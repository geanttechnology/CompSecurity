// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.b;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.b:
//            c, a

class b extends View
{

    protected Handler a;
    protected int b;
    final a c;

    public b(a a1, Context context)
    {
        c = a1;
        super(context);
        b = -1;
        a = new Handler(a());
    }

    protected android.os.Handler.Callback a()
    {
        return new c(this);
    }

    protected void b()
    {
        Object obj = v.a();
        obj = Message.obtain(a, 1, obj);
        a.sendMessage(((Message) (obj)));
    }

    protected void onDraw(Canvas canvas)
    {
        m.b("RENDER", (new StringBuilder()).append("renderMethod#CV: ").append(b).toString());
        switch (b)
        {
        default:
            return;

        case 1: // '\001'
            com.cyberlink.youcammakeup.widgetpool.b.a.a(c, canvas);
            break;
        }
    }
}
