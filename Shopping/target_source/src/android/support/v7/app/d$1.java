// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            d

class a
    implements android.view..OnClickListener
{

    final d a;

    public void onClick(View view)
    {
        if (view == d.a(a) && d.b(a) != null)
        {
            view = Message.obtain(d.b(a));
        } else
        if (view == d.c(a) && d.d(a) != null)
        {
            view = Message.obtain(d.d(a));
        } else
        if (view == d.e(a) && d.f(a) != null)
        {
            view = Message.obtain(d.f(a));
        } else
        {
            view = null;
        }
        if (view != null)
        {
            view.sendToTarget();
        }
        d.h(a).obtainMessage(1, d.g(a)).sendToTarget();
    }

    stener(d d1)
    {
        a = d1;
        super();
    }
}
