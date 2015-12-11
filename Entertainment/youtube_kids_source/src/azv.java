// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.util.Log;

public final class azv
{

    private static boolean c = false;
    final String a;
    String b;
    private boolean d;
    private boolean e;

    public azv(String s)
    {
        this(s, false);
    }

    private azv(String s, boolean flag)
    {
        a = s;
        d = flag;
        e = false;
    }

    public final transient void a(String s, Object aobj[])
    {
        if (d)
        {
            String s1 = a;
            c(s, aobj);
        }
    }

    public final transient void a(Throwable throwable, String s, Object aobj[])
    {
        if (d)
        {
            throwable = a;
            c(s, aobj);
        }
    }

    public final transient void b(String s, Object aobj[])
    {
        Log.w(a, c(s, aobj));
    }

    transient String c(String s, Object aobj[])
    {
        if (aobj.length != 0)
        {
            s = String.format(s, aobj);
        }
        aobj = s;
        if (!TextUtils.isEmpty(b))
        {
            aobj = (new StringBuilder()).append(b).append(s).toString();
        }
        return ((String) (aobj));
    }

}
