// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;


final class p extends LinkedTreeMap.c
{

    final LinkedTreeMap.b a;

    p(LinkedTreeMap.b b)
    {
        a = b;
        super(b.a, (byte)0);
    }

    public final Object next()
    {
        return a().f;
    }
}
