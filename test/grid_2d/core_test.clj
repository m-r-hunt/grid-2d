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
            [[2 0] [2 1] [2 2]]]))))

(deftest grid-map-tests
  (testing "grid-map"
    (is (= (grid-map inc test-grid)
           [[1 2 3] [2 3 4] [3 4 5]]))))
