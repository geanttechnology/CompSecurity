// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

// Referenced classes of package cn.jpush.android.data:
//            g

final class h extends Handler
{

    final g a;

    h(g g1)
    {
        a = g1;
        super();
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            if (g.a(a) != null && g.b(a) != null)
            {
                g.a(a).setImageBitmap(g.b(a));
            }
        } else
        if (message.what == 1 && g.c(a) != null && g.d(a) != null)
        {
            g.c(a).setImageBitmap(g.d(a));
            return;
        }
    }
}
