Final Programming Project: Atomic Nature of Matter

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours: 7


/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. Completing the following   *
 *  will help you estimate the running time (in seconds) of BeadTracker   *
 *  as a function of n?          *
 * 
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/

What is the number of pixels per frame?  640 * 480 = 307200

 
Experiment | # of frames |  # of pixels |  running time in seconds
-------------------------------------------------------------------
  1        |     10      |   3072000    |        0.001            |
-------------------------------------------------------------------
  2        |     20      |   6144000    |        7.062            |
-------------------------------------------------------------------
  3        |     40      |   12288000   |        17.987           |
-------------------------------------------------------------------
  4        |     80      |   24576000   |        27.449           |
-------------------------------------------------------------------

Formulate a hypothesis for the running time (in seconds) of BeadTracker
as a function of the input size (total number of pixels read in across
all frames being processed):
    T(N) = aN^b
read as a times N raised to the power of b

The value for b: ~1.0267

The value for a: ~8.0431e-7

T(N) = (8.0431e-7)N^(1.0267)

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no? No



/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/
Thanks for a great semester! Had lots of fun in the class and was glad to 
have a physics-related final project.