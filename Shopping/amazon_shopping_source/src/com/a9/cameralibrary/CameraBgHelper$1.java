// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;

// Referenced classes of package com.a9.cameralibrary:
//            OnSurfaceCreatedListener, CameraBgHelper

class this._cls0
    implements OnSurfaceCreatedListener
{

    final CameraBgHelper this$0;

    public Point adjustSurfaceSize(double d, int i)
    {
        double d1;
        double d2;
        int j;
        boolean flag;
        int k;
        int l;
        int i1;
        boolean flag1;
label0:
        {
            Object obj;
            if (i % 180 == 90)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = CameraBgHelper.access$000(CameraBgHelper.this).getWindowManager().getDefaultDisplay();
            if (android.os._INT >= 13)
            {
                Point point = new Point();
                ((Display) (obj)).getSize(point);
                j = point.x;
                i = point.y;
            } else
            {
                j = ((Display) (obj)).getWidth();
                i = ((Display) (obj)).getHeight();
            }
            flag1 = false;
            d2 = (double)j / (double)i;
            if (d2 >= 1.0D || d <= 1.0D)
            {
                d1 = d;
                if (d2 <= 1.0D)
                {
                    break label0;
                }
                d1 = d;
                if (d >= 1.0D)
                {
                    break label0;
                }
            }
            d1 = 1.0D / d;
        }
        if (d2 > d1)
        {
            i1 = (int)((double)j / d1);
            k = j;
            l = ((flag1) ? 1 : 0);
        } else
        if (d2 < d1)
        {
            int j1 = (int)((double)i * d1);
            l = ((flag1) ? 1 : 0);
            i1 = i;
            k = j1;
            if (flag)
            {
                l = j - j1;
                i1 = i;
                k = j1;
            }
        } else
        {
            l = ((flag1) ? 1 : 0);
            i1 = i;
            k = j;
            if (d2 == d1)
            {
                l = ((flag1) ? 1 : 0);
                i1 = i;
                k = j;
            }
        }
        obj = (android.widget.tParams)CameraBgHelper.access$100(CameraBgHelper.this).getLayoutParams();
        obj.width = k;
        obj.height = i1;
        obj.topMargin = 0;
        obj.leftMargin = l;
        CameraBgHelper.access$100(CameraBgHelper.this).setLayoutParams(((android.view.arams) (obj)));
        if (flag)
        {
            return new Point(i1, k);
        } else
        {
            return new Point(k, i1);
        }
    }

    s()
    {
        this$0 = CameraBgHelper.this;
        super();
    }
}
