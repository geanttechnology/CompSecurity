// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;


// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

private static class pos
{

    public final int pos;
    public final Symbol symbols[];

    public (Symbol asymbol[], int i)
    {
        symbols = asymbol;
        pos = i;
    }
}
