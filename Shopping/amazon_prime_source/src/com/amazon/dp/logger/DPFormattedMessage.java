// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dp.logger;


public class DPFormattedMessage
{

    private final String mFormattedString;
    private Throwable mThrowable;

    public transient DPFormattedMessage(String s, String s1, Object aobj[])
    {
        mFormattedString = toDPFormat(s, s1, aobj);
        if (aobj.length > 0 && (aobj[aobj.length - 1] instanceof Throwable))
        {
            mThrowable = (Throwable)aobj[aobj.length - 1];
        }
    }

    public static transient String toDPFormat(String s, String s1, Object aobj[])
    {
        int j = aobj.length;
        if (s == null)
        {
            s = "<null>";
        }
        if (s1 == null)
        {
            s1 = "<null>";
        }
        StringBuilder stringbuilder = new StringBuilder(s.length() + s1.length() + j * 40);
        stringbuilder.append(s).append(" - ").append(s1).append(";");
        int i = j;
        if (j > 0)
        {
            i = j;
            if (aobj[j - 1] instanceof Throwable)
            {
                i = j - 1;
            }
        }
        for (int k = 0; k < i; k++)
        {
            if (k > 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(" ").append(aobj[k]);
            k++;
            if (k < i)
            {
                stringbuilder.append(": ").append(aobj[k]);
            }
        }

        return stringbuilder.toString();
    }

    public Throwable getThrowable()
    {
        return mThrowable;
    }

    public void setThrowable(Throwable throwable)
    {
        mThrowable = throwable;
    }

    public String toString()
    {
        return mFormattedString;
    }
}
