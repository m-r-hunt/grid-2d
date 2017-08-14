(ns grid-2d.core-test
  (:require [clojure.test :refer :all]
            [grid-2d.core :refer :all]))

(def test-grid [[0 1 2] [1 2 3] [2 3 4]])

(deftest make-grid-tests
  (testing "make-grid"
    (is (= (make-grid 3 3 \a)
           [[\a \a \a] [\a \a \a] [\a \a \a]])))
  (testing "make-grid-fn"
    (is (= (make-grid-fn 3 3 +)
           test-grid))
    (is (= (make-grid-fn 3 3 #(vector %1 %2))
           [[[0 0] [0 1] [0 2]]
            [[1 0] [1 1] [1 2]]
            [[2 0] [2 1] [2 2]]]))
    (is (= (make-grid-fn 3 3 (fn [_ _ x] x) \a)
           [[\a \a \a] [\a \a \a] [\a \a \a]]))))

(deftest grid-map-tests
  (testing "grid-map"
    (is (= (grid-map inc test-grid)
           [[1 2 3] [2 3 4] [3 4 5]]))))

(deftest grid-map-range-tests
  (testing "grid-map-range"
    (is (= (grid-map-range inc test-grid 1 1 3 3)
           [[0 1 2] [1 3 4] [2 4 5]]))
    (is (= (grid-map-range inc test-grid 1 1 2 2)
           [[0 1 2] [1 3 3] [2 3 4]]))
    (is (= (grid-map-range inc test-grid 1 1 1 1)
           test-grid))))

(deftest grid-reduce-tests
  (testing "grid-reduce"
    (is (= (grid-reduce + 0 test-grid)
           18))
    (is (= (grid-reduce + 5 test-grid)
           23))))
