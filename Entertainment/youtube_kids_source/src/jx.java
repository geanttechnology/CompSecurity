// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;

final class jx
    implements je
{

    private final WeakReference a;

    public jx(jw jw1)
    {
        a = new WeakReference(jw1);
    }

    public final void a(Object obj, int i)
    {
        obj = (jw)a.get();
        if (obj != null && ((jw) (obj)).b != null)
        {
            ((jw) (obj)).b.a(i);
        }
    }

    public final void b(Object obj, int i)
    {
        obj = (jw)a.get();
        if (obj != null && ((jw) (obj)).b != null)
        {
            ((jw) (obj)).b.b(i);
        }
    }
}
