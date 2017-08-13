(ns grid-2d.core)

(defn make-grid
  "Make an x by y grid of copies of val."
  [x y val]
  (into [] (repeat x (into [] (repeat y val)))))

(defn make-grid-fn
  "Make an x by y grid, where the entry at (i, j) is the result of (f i j & args)."
  [x y f & args]
  (mapv (fn [i] (mapv (fn [j] (apply f i j args))
                      (range y)))
        (range x)))

(defn grid-map
  "Map a function over a grid, returning a grid."
  [f g]
  (mapv #(mapv f %) g))

(defn grid-map-range
  "Like map but only applies f to the grid range from (x1, y1)(inclusive) to (x2, y2)(exlusive)."
  [f g x1 y1 x2 y2]
  (reduce #(update-in %1 %2 f) g (for [x (range x1 x2)
                                       y (range y1 y2)] [x y])))
(defn grid-map-indexed
  "Like map indexed over a grid. f should take 3 args (f x y val)"
  [f g]
  (map-indexed (fn [x gr] (map-indexed #(f x %1 %2) gr)) g))

(defn grid-reduce
  "Reduce a function over all entries in the grid."
  [f val g]
  (reduce (fn [v gr] (reduce f v gr)) val g))
