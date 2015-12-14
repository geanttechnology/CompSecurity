// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.photo.adjust.TwoDirectionSeekbar;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            b

final class a
    implements android.view.TreeObserver.OnGlobalLayoutListener
{

    private View a;
    private b b;

    public final void onGlobalLayout()
    {
        int i = a.getWidth();
        int j = a.getHeight();
        if (i > 0 && j > 0)
        {
            Utils.a(a, this);
            android.widget.tiveLayout.LayoutParams layoutparams = (android.widget.tiveLayout.LayoutParams)com.picsart.studio.editor.fragment.b.l(b).getLayoutParams();
            layoutparams.width = j;
            com.picsart.studio.editor.fragment.b.l(b).setLayoutParams(layoutparams);
            com.picsart.studio.editor.fragment.b.l(b).setTranslationX((float)(i - com.picsart.studio.editor.fragment.b.l(b).getHeight()) / 2.0F);
            com.picsart.studio.editor.fragment.b.l(b).setPivotX(j);
            com.picsart.studio.editor.fragment.b.l(b).setPivotY(0.0F);
            com.picsart.studio.editor.fragment.b.l(b).setRotation(270F);
        }
    }

    ams(b b1, View view)
    {
        b = b1;
        a = view;
        super();
    }
}
