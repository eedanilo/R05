package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return bsFloor(array, x, 0, array.length - 1);
	}
	public Integer bsFloor(Integer[] array, int x, int l, int r) {
		if (l > r){
			return null;
		}
		int m = (l + r) / 2;

		if (array[m] == x) {
			return array[m];
		}
		if (array[m] < x) {
			if (m + 1 > r || array[m + 1] > x) {
				return array[m];
			}
			return bsFloor(array, x, m + 1, r);
		}
		return bsFloor(array, x, l, m - 1);
		}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return bsCeil(array, x, 0, array.length - 1);
	}

	public Integer bsCeil(Integer[] array, int x, int l, int r) {
		if (l > r) {
			return null;
		}
		int m = (l + r) / 2;
		if (array[m] == x) {
			return array[m];
		}
		if (array[m] > x) {
			if (m == l || array[m - 1] < x) {
				return array[m];
			}
			return bsCeil(array, x, l, m - 1);
		}
		return bsCeil(array, x, m + 1, r);
}