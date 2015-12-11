// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

// Referenced classes of package cn.jpush.android.ui:
//            d

final class e extends Handler
{

    final d a;

    e(d d1)
    {
        a = d1;
        super();
    }

    public final void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (d.a(a) != null)
        {
            d.a(a).setProgress(0);
            d.a(a).setVisibility(8);
        }
    }
}
