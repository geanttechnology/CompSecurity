// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.widgets;

import android.content.Context;
import android.widget.RemoteViews;
import com.target.ui.analytics.a.ao;
import com.target.ui.util.i.a;
import com.target.ui.util.i.b;

// Referenced classes of package com.target.ui.widgets:
//            BaseWidgetProvider

public class TargetWidget extends BaseWidgetProvider
{

    public TargetWidget()
    {
    }

    private void a(Context context, RemoteViews remoteviews)
    {
        if (context == null || remoteviews == null)
        {
            return;
        } else
        {
            remoteviews.setOnClickPendingIntent(0x7f1005f7, com.target.ui.util.i.a.d(context));
            remoteviews.setOnClickPendingIntent(0x7f1005f9, com.target.ui.util.i.a.b(context));
            remoteviews.setOnClickPendingIntent(0x7f1005fa, com.target.ui.util.i.a.c(context));
            remoteviews.setOnClickPendingIntent(0x7f1005f8, com.target.ui.util.i.a.a(context));
            remoteviews.setOnClickPendingIntent(0x7f1005fb, com.target.ui.util.i.a.e(context));
            return;
        }
    }

    private static void a(RemoteViews remoteviews, int i, boolean flag)
    {
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        remoteviews.setViewVisibility(i, j);
    }

    private void a(RemoteViews remoteviews, b b1)
    {
        boolean flag;
        flag = false;
        if (remoteviews == null)
        {
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$util$widget$WidgetSize[];

            static 
            {
                $SwitchMap$com$target$ui$util$widget$WidgetSize = new int[com.target.ui.util.i.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$util$widget$WidgetSize[b.ONE_X_ONE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$util$widget$WidgetSize[b.ONE_X_TWO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$util$widget$WidgetSize[b.ONE_X_THREE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$util$widget$WidgetSize[b.ONE_X_FOUR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$util$widget$WidgetSize[b.ONE_X_FIVE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.util.widget.WidgetSize[b1.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 90
    //                   2 102
    //                   3 116;
           goto _L1 _L2 _L3 _L4
_L1:
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag = true;
        flag1 = true;
        flag2 = true;
        flag3 = true;
_L6:
        a(remoteviews, 0x7f1005f7, true);
        a(remoteviews, 0x7f1005f9, flag2);
        a(remoteviews, 0x7f1005fa, flag1);
        a(remoteviews, 0x7f1005f8, flag3);
        a(remoteviews, 0x7f1005fb, flag);
        return;
_L2:
        flag1 = false;
        flag2 = false;
        flag3 = false;
        continue; /* Loop/switch isn't completed */
_L3:
        flag1 = false;
        flag2 = false;
        flag3 = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        flag1 = false;
        flag2 = true;
        flag3 = true;
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected RemoteViews a(Context context, b b1)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030210);
        a(remoteviews, b1);
        a(context, remoteviews);
        return remoteviews;
    }

    protected b a()
    {
        return b.ONE_X_FIVE;
    }

    protected void a(int ai[])
    {
        ao.a(com.target.ui.analytics.a.ao.a.WidgetRemoved).e();
    }

    protected void b()
    {
        ao.a(com.target.ui.analytics.a.ao.a.WidgetInstantiated).e();
    }

    protected void c()
    {
    }
}
