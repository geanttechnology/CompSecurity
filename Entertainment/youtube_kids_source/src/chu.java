// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

public final class chu
    implements chq
{

    public chu()
    {
    }

    public final void a(String s)
    {
    }

    public final void a(String s, Exception exception)
    {
        Log.e("YouTube MDX", s, exception);
    }

    public final transient void a(String s, Object aobj[])
    {
        String.format(s, aobj);
    }

    public final void b(String s)
    {
        Log.e("YouTube MDX", s);
    }

    public final transient void b(String s, Object aobj[])
    {
        String.format(s, aobj);
    }

    public final transient void c(String s, Object aobj[])
    {
        Log.e("YouTube MDX", String.format(s, aobj));
    }
}
