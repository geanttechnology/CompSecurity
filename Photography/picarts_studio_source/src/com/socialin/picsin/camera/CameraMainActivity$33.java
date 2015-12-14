// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.graphics.Point;
import android.view.View;
import android.widget.ViewFlipper;
import java.util.ArrayList;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class c
    implements android.view.balLayoutListener
{

    private View a;
    private int b;
    private ViewFlipper c;
    private CameraMainActivity d;

    public final void onGlobalLayout()
    {
        int i = a.getWidth();
        int j = a.getHeight();
        if (i > 0 && j > 0)
        {
            m.a(a, this);
            ((Point)CameraMainActivity.e(d).get(b)).set(i, j);
            if (c.getVisibility() == 0 && c.getDisplayedChild() == b)
            {
                CameraMainActivity.a(d, b, CameraMainActivity.a(d));
            }
        }
    }

    ner(CameraMainActivity cameramainactivity, View view, int i, ViewFlipper viewflipper)
    {
        d = cameramainactivity;
        a = view;
        b = i;
        c = viewflipper;
        super();
    }
}
