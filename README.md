# Lab 10 — Matrix Operations

| | |
|---|---|
| **Week** | 11 |
| **Textbook** | Liang — **Chapter 8** (Multidimensional Arrays) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Distinguish the row count `m.length` from the column count `m[r].length`.
2. Write a column-major traversal, in which the outer loop runs over columns.
3. Allocate a result array whose dimensions differ from the input's.
4. Implement matrix multiplication with three nested loops and validate conformability.
5. Return `null` deliberately to signal an operation that is not defined.

---

## Background

**Shape.** A 2-D array is an array of row arrays:

```java
int[][] a = {{1, 2, 3},
             {4, 5, 6}};    // 2 rows, 3 columns

a.length      // 2  -> number of ROWS
a[0].length   // 3  -> number of COLUMNS in row 0
a[1][2]       // 6  -> row 1, column 2 (both zero-based)
```

**Row sums versus column sums.** For row sums the outer loop runs over rows. For column sums the
loops **swap roles**: the outer loop runs over columns and the inner loop gathers down the rows.
Writing the same loop nest twice and expecting different answers is the standard error here.

**Transpose changes the shape.** An *m* × *n* matrix transposes to *n* × *m*, so the result array
must be allocated as `new int[m[0].length][m.length]` — not as a copy of the original shape.

**Matrix multiplication.** For `a` (*m* × *n*) and `b` (*p* × *q*), the product exists **only when
n equals p**, and the result is *m* × *q*:

```
result[i][j] = sum over k of a[i][k] * b[k][j]
```

Three nested loops: `i` over the rows of `a`, `j` over the columns of `b`, `k` over the shared
dimension. Note that `result[i][j]` accumulates, so it must start at 0 — which Java guarantees for
a freshly allocated `int` array.

Worked example, verifying one element of the required answer:

```
row 0 of a = [1, 2, 3];  column 0 of b = [7, 9, 11]
result[0][0] = 1*7 + 2*9 + 3*11 = 7 + 18 + 33 = 58
```

**Symmetry** requires a square matrix: check the row count against every row's length first, then
compare `m[r][c]` with `m[c][r]`.

---

## Instructions

| Step | Method | Requirement |
|---|---|---|
| 1 | `rowSums(int[][])` | Length equals the row count |
| 2 | `columnSums(int[][])` | Length equals the column count; outer loop over columns |
| 3 | `transpose(int[][])` | `result[r][c] == m[c][r]`; shape is inverted |
| 4 | `multiply(int[][], int[][])` | Three nested loops; return `null` when shapes do not conform |
| 5 | `isSymmetric(int[][])` | `false` for any non-square matrix |
| 6 | `largest(int[][])` | `Integer.MIN_VALUE` for an empty or `null` matrix |
| 7 | `main` | Print each result for a sample matrix |

---

## Commenting Standard (20 points)

```java
// WEAK
for (int c = 0; c < m[0].length; c++) { // loop columns

// STRONG
// The OUTER loop walks the columns because one column sum is produced per column;
// the inner loop then gathers that column's value from every row.
for (int c = 0; c < m[0].length; c++) {
```

---

## Compile, Run, and Test

```bash
bash tools/run_lab.sh lab10          # 19 official checks
python3 tools/comment_check.py labs/lab10
```

---

## Test Data

| Matrix | Value | Notes |
|---|---|---|
| `a` | `{{1,2,3},{4,5,6}}` | 2 × 3; row sums `{6,15}`, column sums `{5,7,9}` |
| `b` | `{{7,8},{9,10},{11,12}}` | 3 × 2 |
| `a × b` | `{{58,64},{139,154}}` | 2 × 2 |
| `b × a` | `{{39,54,69},{49,68,87},{59,82,105}}` | 3 × 3 — multiplication is not commutative |
| `a × a` | `null` | 3 columns cannot meet 2 rows |

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 19 checks pass | 60 |
| Line comments explain every loop bound and index expression | 20 |
| Correct traversal order; conformability validated | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab10` reports 19 of 19.
- [ ] `multiply(a, a)` returns `null` rather than throwing.
- [ ] Transposing twice reproduces the original matrix.

```bash
git add . && git commit -m "Lab 10 complete - all 19 checks passing" && git push
```

---

## Stretch Goal

Add `public static boolean isMagicSquare(int[][] m)`: true when every row, every column, and both
diagonals share the same sum. Reuse `rowSums` and `columnSums` rather than writing new loops.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| `columnSums` returns the row sums | Loops not swapped | Outer loop over columns |
| `ArrayIndexOutOfBoundsException` in `transpose` | Result allocated with the original shape | Allocate `new int[cols][rows]` |
| Products are far too large | `result[i][j]` reused across `i` or `j` | Accumulate into the correct cell only |
| `multiply` throws instead of returning `null` | Conformability not checked | Compare `a[0].length` with `b.length` first |
| Non-square matrix reported symmetric | Row lengths never validated | Verify `m[r].length == m.length` for every row |

