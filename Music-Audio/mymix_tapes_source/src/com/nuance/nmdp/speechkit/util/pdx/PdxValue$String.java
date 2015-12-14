// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.pdx;


// Referenced classes of package com.nuance.nmdp.speechkit.util.pdx:
//            PdxValue

public static final class a extends PdxValue
{

    private final String a;

    public final String get()
    {
        return a;
    }

    public final String toString(String s)
    {
        return a.replace("\n", (new StringBuilder()).append("\n").append(s).toString());
    }

    public (String s)
    {
        super(0);
        a = s;
    }
}
