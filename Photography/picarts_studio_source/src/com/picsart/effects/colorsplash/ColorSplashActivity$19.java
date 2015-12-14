// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, ColorSplashForegroundView

final class a
    implements android.view.rSplashActivity._cls19
{

    private ColorSplashActivity a;

    public final void onClick(View view)
    {
        if (!ColorSplashActivity.d(a)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        view = (ColorSplashForegroundView)a.findViewById(0x7f1002bc);
        if (((ColorSplashForegroundView) (view)).e.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ColorSplashForegroundView) (view)).e.remove(((ColorSplashForegroundView) (view)).e.size() - 1);
        ((ColorSplashForegroundView) (view)).f.remove(((ColorSplashForegroundView) (view)).f.size() - 1);
        ((ColorSplashForegroundView) (view)).g.remove(((ColorSplashForegroundView) (view)).g.size() - 1);
        if (((ColorSplashForegroundView) (view)).d != null && ((ColorSplashForegroundView) (view)).c != null && !((ColorSplashForegroundView) (view)).c.isRecycled())
        {
            ((ColorSplashForegroundView) (view)).d.drawRect(new Rect(0, 0, ((ColorSplashForegroundView) (view)).c.getWidth(), ((ColorSplashForegroundView) (view)).c.getHeight()), ((ColorSplashForegroundView) (view)).i);
            for (int i = 0; i < ((ColorSplashForegroundView) (view)).e.size(); i++)
            {
                Path path = (Path)((ColorSplashForegroundView) (view)).e.get(i);
                Paint paint = (Paint)((ColorSplashForegroundView) (view)).f.get(i);
                ((ColorSplashForegroundView) (view)).d.drawPath(path, paint);
            }

        }
        view.invalidate();
        if (((ColorSplashForegroundView) (view)).e.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
_L4:
        if (!flag)
        {
            a.b(false);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag = false;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    ew(ColorSplashActivity colorsplashactivity)
    {
        a = colorsplashactivity;
        super();
    }
}
