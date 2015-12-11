// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.util.concurrent.Executor;

public class ml
{

    final Executor a;

    public ml(Handler handler)
    {
        a = new lw(this, handler);
    }

    public ml(Executor executor)
    {
        a = executor;
    }

    public void a(me me1, mi mi1)
    {
        a(me1, mi1, null);
    }

    public void a(me me1, mi mi1, Runnable runnable)
    {
        me1.g = true;
        me1.a("post-response");
        a.execute(new lx(this, me1, mi1, runnable));
    }

    public void a(me me1, mp mp)
    {
        me1.a("post-error");
        mp = mi.a(mp);
        a.execute(new lx(this, me1, mp, null));
    }
}
