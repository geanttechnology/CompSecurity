// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.view.ImageCollageView;

public class bpm
    implements android.view.View.OnClickListener
{

    int a;
    final ImageCollageView b;

    public bpm(ImageCollageView imagecollageview, int i)
    {
        b = imagecollageview;
        super();
        a = i;
    }

    public void onClick(View view)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        if (layoutparams != null && b.listener != null)
        {
            int i = layoutparams.height;
            int j = layoutparams.width;
            int k = layoutparams.leftMargin;
            int l = layoutparams.topMargin;
            b.listener.a(view, a, k, l, j, i);
        }
    }
}
