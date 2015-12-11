// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


final class bm
{

    String dC;
    String dD;
    String dE;
    String dF;
    String dG;

    bm(String s, String s1, String s2, String s3, String s4)
    {
        dG = null;
        dC = s;
        dD = s1;
        dE = s2;
        dF = s3;
        dG = s4;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (bm)obj;
            if (!((bm) (obj)).dC.equals(dC) || !((bm) (obj)).dE.equals(dE))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return (dC.hashCode() + 1296) * 36 + dE.hashCode();
    }
}
