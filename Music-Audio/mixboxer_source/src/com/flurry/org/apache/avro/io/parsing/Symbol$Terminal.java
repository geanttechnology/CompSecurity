// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;


// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

private static class printName extends Symbol
{

    private final String printName;

    public String toString()
    {
        return printName;
    }

    public (String s)
    {
        super(INAL);
        printName = s;
    }
}
