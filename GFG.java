// Java program to calculate
// double integral value
class GFG{


// Change the function according to your need
static float givenFunction(float x, float y)
{
	return (float) Math.pow(Math.pow(x, 4) +
						Math.pow(y, 5), 0.5);
}

// Function to find the double integral value
static float doubleIntegral(float h, float k,
					float lx, float ux,
					float ly, float uy)
{
	int nx, ny;

	// z stores the table
	// ax[] stores the integral wrt y
	// for all x points considered
	float z[][] = new float[50][50], ax[] = new float[50], answer;

	// Calculating the number of points
	// in x and y integral
	nx = (int) ((ux - lx) / h + 1);
	ny = (int) ((uy - ly) / k + 1);

	// Calculating the values of the table
	for (int i = 0; i < nx; ++i)
	{
		for (int j = 0; j < ny; ++j)
		{
			z[i][j] = givenFunction(lx + i * h,
									ly + j * k);
		}
	}

	// Calculating the integral value
	// wrt y at each point for x
	for (int i = 0; i < nx; ++i)
	{
		ax[i] = 0;
		for (int j = 0; j < ny; ++j)
		{
			if (j == 0 || j == ny - 1)
				ax[i] += z[i][j];
			else if (j % 2 == 0)
				ax[i] += 2 * z[i][j];
			else
				ax[i] += 4 * z[i][j];
		}
		ax[i] *= (k / 3);
	}

	answer = 0;

	// Calculating the final integral value
	// using the integral obtained in the above step
	for (int i = 0; i < nx; ++i)
	{
		if (i == 0 || i == nx - 1)
			answer += ax[i];
		else if (i % 2 == 0)
			answer += 2 * ax[i];
		else
			answer += 4 * ax[i];
	}
	answer *= (h / 3);

	return answer;
}

// Driver Code
public static void main(String[] args)
{
	// lx and ux are upper and lower limit of x integral
	// ly and uy are upper and lower limit of y integral
	// h is the step size for integration wrt x
	// k is the step size for integration wrt y
	float h, k, lx, ux, ly, uy;

	lx = (float) 2.3; ux = (float) 2.5; ly = (float) 3.7;
	uy = (float) 4.3; h = (float) 0.1; k = (float) 0.15;

	System.out.printf("%f", doubleIntegral(43, 1, 5, ux, ly, uy));
}
}

/* This code contributed by PrinciRaj1992 */
