// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


public class Rational
{

    private final long mDenominator;
    private final long mNumerator;

    public Rational(long l, long l1)
    {
        mNumerator = l;
        mDenominator = l1;
    }

    public Rational(Rational rational)
    {
        mNumerator = rational.mNumerator;
        mDenominator = rational.mDenominator;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof Rational)
            {
                obj = (Rational)obj;
                if (mNumerator != ((Rational) (obj)).mNumerator || mDenominator != ((Rational) (obj)).mDenominator)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public long getDenominator()
    {
        return mDenominator;
    }

    public long getNumerator()
    {
        return mNumerator;
    }

    public double toDouble()
    {
        return (double)mNumerator / (double)mDenominator;
    }

    public String toString()
    {
        return (new StringBuilder()).append(mNumerator).append("/").append(mDenominator).toString();
    }
}
