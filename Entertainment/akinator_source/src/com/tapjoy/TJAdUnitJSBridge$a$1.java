// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.graphics.drawable.Drawable;
import android.webkit.WebView;
import android.widget.RelativeLayout;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge

final class b
    implements Runnable
{

    final boolean a;
    final boolean b;
    final tBackgroundColor c;

    public final void run()
    {
        if (!a) goto _L2; else goto _L1
_L1:
        c.c.setVisibility(0);
        if (!b) goto _L4; else goto _L3
_L3:
        if (c.c.getParent() instanceof RelativeLayout)
        {
            ((RelativeLayout)c.c.getParent()).getBackground().setAlpha(0);
            ((RelativeLayout)c.c.getParent()).setBackgroundColor(0);
        }
        if (android.os. >= 11)
        {
            c.c.setLayerType(1, null);
        }
_L6:
        return;
_L4:
        if (c.c.getParent() instanceof RelativeLayout)
        {
            ((RelativeLayout)c.c.getParent()).getBackground().setAlpha(255);
            ((RelativeLayout)c.c.getParent()).setBackgroundColor(-1);
        }
        if (android.os. >= 11)
        {
            c.c.setLayerType(0, null);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        c.c.setVisibility(4);
        if (c.c.getParent() instanceof RelativeLayout)
        {
            ((RelativeLayout)c.c.getParent()).getBackground().setAlpha(0);
            ((RelativeLayout)c.c.getParent()).setBackgroundColor(0);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    le(le le, boolean flag, boolean flag1)
    {
        c = le;
        a = flag;
        b = flag1;
        super();
    }
}
