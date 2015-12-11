// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.mrz.impl.smartEngines.swig;


public final class c
{

    public static final InvertedPortrait InvertedLandscape;
    public static final InvertedPortrait InvertedPortrait;
    public static final InvertedPortrait Landscape;
    public static final InvertedPortrait Portrait;
    private static InvertedPortrait a[];
    private static int b = 0;
    private final int c;
    private final String d;

    public static c swigToEnum(int i)
    {
        if (i < a.length && i >= 0 && a[i].c == i)
        {
            return a[i];
        }
        for (int j = 0; j < a.length; j++)
        {
            if (a[j].c == i)
            {
                return a[j];
            }
        }

        throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/mrz/impl/smartEngines/swig/MrzEngine$ImageOrientation).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public final String toString()
    {
        return d;
    }

    static 
    {
        Landscape = new <init>("Landscape");
        Portrait = new <init>("Portrait");
        InvertedLandscape = new <init>("InvertedLandscape");
        InvertedPortrait = new <init>("InvertedPortrait");
        a = (new a[] {
            Landscape, Portrait, InvertedLandscape, InvertedPortrait
        });
    }

    private (String s)
    {
        d = s;
        int i = b;
        b = i + 1;
        c = i;
    }
}
