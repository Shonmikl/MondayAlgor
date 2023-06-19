function searchMatrix(matrix, k) {
  if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
    return false;
  }

 //правый верхний угол
  const m = matrix.length;
  const stroka = matrix[0].length;

 //границы массива
  let i = 0;
  let j = stroka - 1;

  while (i < m && j >= 0) {
    if (matrix[i][j] === k) {
      return true;
    }
    if (matrix[i][j] > k) {
      j--;
    } else {
      i++;
    }
  }
  return false;
}