// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.SeekBar;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            k

final class a
    implements android.view.TreeObserver.OnGlobalLayoutListener
{

    private View a;
    private k b;

    public final void onGlobalLayout()
    {
        int i = a.getWidth();
        int j = a.getHeight();
        if (i > 0 && j > 0)
        {
            Utils.a(a, this);
            android.widget.tiveLayout.LayoutParams layoutparams = (android.widget.tiveLayout.LayoutParams)k.h(b).getLayoutParams();
            layoutparams.width = j;
            k.h(b).setLayoutParams(layoutparams);
            k.h(b).setTranslationX((float)(i - k.h(b).getHeight()) / 2.0F);
            k.h(b).setPivotX(j);
            k.h(b).setPivotY(0.0F);
            k.h(b).setRotation(270F);
        }
    }

    ams(k k1, View view)
    {
        b = k1;
        a = view;
        super();
    }
}
