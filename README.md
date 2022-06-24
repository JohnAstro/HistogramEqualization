# HistogramEqualization
This program implements the following algorithm on gray level images to enhance them:
- S[i] = *Round*[ (2<sup>k</sup> - 1) * H<sub>CN</sub>[i] ] for i <= 0 <= 2<sup>k</sup> - 1

H<sub>CN</sub> is the cumulative normalized histogram of the gray level image, and S[i] is the LUT (Look Up Table) for the enhanced image.
