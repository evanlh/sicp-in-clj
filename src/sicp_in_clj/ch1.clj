(ns sicp-in-clj.ch1)
;;;; SECTION 1.1.4
(defn square [x] (* x x))
;: (square 5)
;: (square (+ 2 5))
;: (square (square 3))

(defn sum-of-squares [x y]
  (+ (square x) (square y)))

;: (sum-of-squares 3 4)

(defn f [a]
  (sum-of-squares (+ a 1) (* a 2)))

;: (f 5)

;;;; SECTION 1.1.5

;;;; SECTION 1.1.6

(defn abs [x]
  (cond (> x 0) x
    (= x 0) 0
    (< x 0) (- x)))

(defn abs [x]
  (cond (< x 0) (- x)
        true x))

(defn abs [x]
  (if (< x 0)
    (- x) x))

(abs -3)

(defn >= [x y]
  (or (> x y) (= x y)))

(defn >= [x y]
  (not (< x y)))

;;EXERCISE 1.1

10

(+ 5 3 4)

(- 9 1)

(/ 6 2)

(+ (* 2 4) (- 4 6))

(def a 3)

(def b (+ a 1))

(+ a b (* a b))

(= a b)

(if (and (> b a) (< b (* a b)))
  b
  a)

(cond (= a 4) 6
      (= b 4) (+ 6 7 a)
      true 25)

(+ 2 (if (> b a) b a))

(* (cond (> a b) a
         (< a b) b
         true -1)
   (+ a 1))

;; EXERCISE 1.3

;; ugly version that works
(defn mid-of-three [x y z]
  (if (> x y)
    (if (> x z)
      (if (> y z)
        y
        z)
      z)
    (if (> y z)
      (if (> x z)
        x
        z))))

;; prettier. probably slower.
(defn mid-of-three [x y z]
  (second (sort [x y z])))

(defn sum-of-max-squares [x y z]
  (sum-of-squares
   (max x y z) (mid-of-three x y z)))

;; EXERCISE 1.4
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

;; Evaluation of the if expression yields the + or - operator that is then
;; applied to a and b. The if expression determines the function to
;; apply without knowing anything about the parameters which are then
;; applied to it.

;; EXERCISE 1.5
(defn p []  (p))

(defn test [x y]
  (if (= x 0)
      0
      y))

(test 0 p)

;; Under normal order evaluation the above command evaluates to 0,
;; whereas (I think) under applicative order it would go into an
;; infinite recursion until it blew the stack trying to resolve p to a
;; simple value

;;;;SECTION 1.1.7

(defn square [x]
  (* x x))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x)
                 x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

;; (sqrt 9)
;; (sqrt (+ 100 37))
;; (sqrt (+ (sqrt 2) (sqrt 3)))
;; (square (sqrt 1000))

