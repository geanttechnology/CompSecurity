// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

class ask
{

    final String a;
    final byte b[];

    ask(String s, byte abyte0[])
    {
        a = s;
        b = abyte0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("KeyAndSerialized: key = ").append(a).append(" serialized hash = ").append(Arrays.hashCode(b)).toString();
    }
}
