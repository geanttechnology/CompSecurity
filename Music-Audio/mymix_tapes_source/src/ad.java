// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class ad extends ag
{

    public ad(af af1)
    {
        super(af1);
    }

    public final void a()
    {
    }

    public final void c()
    {
        b.a(this, "Starting recognize transaction");
        af af1 = a;
        Object obj;
        if (a.m())
        {
            obj = new ah(a);
        } else
        {
            obj = new ak(a);
        }
        af1.a(((i) (obj)));
    }
}
