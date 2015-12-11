// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.Serializable;

public class n
    implements Serializable
{

    public int a;
    public int b;

    public n(int i, int j)
    {
        a = i;
        b = j;
    }

    public n a()
    {
        return new n(a, b);
    }
}
