// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bhx
    implements bhv
{

    public volatile boolean a;
    private final bhv b;

    private bhx(bhv bhv1)
    {
        b = bhv1;
    }

    public static bhx a(bhv bhv1)
    {
        return new bhx(bhv1);
    }

    public final void a(Object obj, Exception exception)
    {
        if (!a)
        {
            b.a(obj, exception);
        }
    }

    public final void a(Object obj, Object obj1)
    {
        if (!a)
        {
            b.a(obj, obj1);
        }
    }
}
