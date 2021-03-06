// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;


public class Matrix2f
{

    final float mMat[];

    public Matrix2f()
    {
        mMat = new float[4];
        loadIdentity();
    }

    public Matrix2f(float af[])
    {
        mMat = new float[4];
        System.arraycopy(af, 0, mMat, 0, mMat.length);
    }

    public float get(int i, int j)
    {
        return mMat[i * 2 + j];
    }

    public float[] getArray()
    {
        return mMat;
    }

    public void load(Matrix2f matrix2f)
    {
        System.arraycopy(matrix2f.getArray(), 0, mMat, 0, mMat.length);
    }

    public void loadIdentity()
    {
        mMat[0] = 1.0F;
        mMat[1] = 0.0F;
        mMat[2] = 0.0F;
        mMat[3] = 1.0F;
    }

    public void loadMultiply(Matrix2f matrix2f, Matrix2f matrix2f1)
    {
        for (int i = 0; i < 2; i++)
        {
            int j = 0;
            float f = 0.0F;
            float f1 = 0.0F;
            for (; j < 2; j++)
            {
                float f2 = matrix2f1.get(i, j);
                f1 += matrix2f.get(j, 0) * f2;
                f += f2 * matrix2f.get(j, 1);
            }

            set(i, 0, f1);
            set(i, 1, f);
        }

    }

    public void loadRotate(float f)
    {
        float f1 = 0.01745329F * f;
        f = (float)Math.cos(f1);
        f1 = (float)Math.sin(f1);
        mMat[0] = f;
        mMat[1] = -f1;
        mMat[2] = f1;
        mMat[3] = f;
    }

    public void loadScale(float f, float f1)
    {
        loadIdentity();
        mMat[0] = f;
        mMat[3] = f1;
    }

    public void multiply(Matrix2f matrix2f)
    {
        Matrix2f matrix2f1 = new Matrix2f();
        matrix2f1.loadMultiply(this, matrix2f);
        load(matrix2f1);
    }

    public void rotate(float f)
    {
        Matrix2f matrix2f = new Matrix2f();
        matrix2f.loadRotate(f);
        multiply(matrix2f);
    }

    public void scale(float f, float f1)
    {
        Matrix2f matrix2f = new Matrix2f();
        matrix2f.loadScale(f, f1);
        multiply(matrix2f);
    }

    public void set(int i, int j, float f)
    {
        mMat[i * 2 + j] = f;
    }

    public void transpose()
    {
        float f = mMat[1];
        mMat[1] = mMat[2];
        mMat[2] = f;
    }
}
