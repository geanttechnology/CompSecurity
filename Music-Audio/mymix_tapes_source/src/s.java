// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class s extends i
{

    private final p a;

    public s(p p1)
    {
        super(p1);
        a = p1;
    }

    public final void a()
    {
    }

    public final void c()
    {
        b.a(this, (new StringBuilder()).append("Starting ").append(a.j()).append(" transaction").toString());
        a.a(new t(a));
    }
}
