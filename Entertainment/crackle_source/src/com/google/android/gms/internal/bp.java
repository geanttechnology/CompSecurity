// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

// Referenced classes of package com.google.android.gms.internal:
//            cs

public final class bp extends FrameLayout
    implements android.view.View.OnClickListener
{

    private final ImageButton gZ;
    private final Activity gs;

    public bp(Activity activity, int i)
    {
        super(activity);
        gs = activity;
        setOnClickListener(this);
        gZ = new ImageButton(activity);
        gZ.setImageResource(0x1080017);
        gZ.setBackgroundColor(0);
        gZ.setOnClickListener(this);
        gZ.setPadding(0, 0, 0, 0);
        i = cs.a(activity, i);
        addView(gZ, new android.widget.FrameLayout.LayoutParams(i, i, 17));
    }

    public void g(boolean flag)
    {
        ImageButton imagebutton = gZ;
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        imagebutton.setVisibility(byte0);
    }

    public void onClick(View view)
    {
        gs.finish();
    }
}
