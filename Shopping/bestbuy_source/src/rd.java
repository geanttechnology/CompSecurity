// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;

public class rd extends Loader
    implements qo, qp
{

    public final qm a;
    private boolean b;
    private pp c;

    public rd(Context context, qm qm1)
    {
        super(context);
        a = qm1;
    }

    private void a(pp pp1)
    {
        c = pp1;
        if (isStarted() && !isAbandoned())
        {
            deliverResult(pp1);
        }
    }

    public void a()
    {
        if (b)
        {
            b = false;
            if (isStarted() && !isAbandoned())
            {
                a.b();
            }
        }
    }

    public void onConnected(Bundle bundle)
    {
        b = false;
        a(pp.a);
    }

    public void onConnectionFailed(pp pp1)
    {
        b = true;
        a(pp1);
    }

    public void onConnectionSuspended(int i)
    {
    }

    protected void onReset()
    {
        c = null;
        b = false;
        a.b(this);
        a.b(this);
        a.c();
    }

    protected void onStartLoading()
    {
        super.onStartLoading();
        a.a(this);
        a.a(this);
        if (c != null)
        {
            deliverResult(c);
        }
        if (!a.d() && !a.e() && !b)
        {
            a.b();
        }
    }

    protected void onStopLoading()
    {
        a.c();
    }
}
