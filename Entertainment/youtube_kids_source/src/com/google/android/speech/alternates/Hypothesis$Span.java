// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.alternates;

import egd;
import eic;
import f;

public class mAlternates
{

    public final eic mAlternates;
    public final int mUtf16End;
    public final int mUtf16Start;
    public final int mUtf8Length;
    public final int mUtf8Start;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof mAlternates)
        {
            obj = (mAlternates)obj;
            flag = flag1;
            if (mUtf16Start == ((mUtf16Start) (obj)).mUtf16Start)
            {
                flag = flag1;
                if (mUtf16End == ((mUtf16End) (obj)).mUtf16End)
                {
                    flag = flag1;
                    if (mUtf8Start == ((mUtf8Start) (obj)).mUtf8Start)
                    {
                        flag = flag1;
                        if (mUtf8Length == ((mUtf8Length) (obj)).mUtf8Length)
                        {
                            flag = flag1;
                            if (f.a(mAlternates, ((mAlternates) (obj)).mAlternates))
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return f.a(new Object[] {
            Integer.valueOf(mUtf16Start), Integer.valueOf(mUtf16End), Integer.valueOf(mUtf8Start), Integer.valueOf(mUtf8Length), mAlternates
        });
    }

    public String toString()
    {
        return f.a(this).a("mUtf16Start", mUtf16Start).a("mUtf16End", mUtf16End).a("mUtf8Start", mUtf8Start).a("mUtf8Length", mUtf8Length).a("mAlternates", mAlternates).toString();
    }

    public mAlternates withAlternates(eic eic)
    {
        return new <init>(mUtf16Start, mUtf16End, mUtf8Start, mUtf8Length, eic);
    }

    public (int i, int j, int k, int l, eic eic)
    {
        mUtf16Start = i;
        mUtf16End = j;
        mUtf8Start = k;
        mUtf8Length = l;
        mAlternates = eic;
    }
}
