// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.os.Handler;
import android.os.Message;
import android.view.View;

// Referenced classes of package android.support.v7.a:
//            d

final class a
    implements android.view..OnClickListener
{

    final d a;

    public final void onClick(View view)
    {
        if (view == a.n && a.p != null)
        {
            view = Message.obtain(a.p);
        } else
        if (view == a.q && a.s != null)
        {
            view = Message.obtain(a.s);
        } else
        if (view == a.t && a.v != null)
        {
            view = Message.obtain(a.v);
        } else
        {
            view = null;
        }
        if (view != null)
        {
            view.sendToTarget();
        }
        a.M.obtainMessage(1, a.b).sendToTarget();
    }

    Listener(d d1)
    {
        a = d1;
        super();
    }
}
