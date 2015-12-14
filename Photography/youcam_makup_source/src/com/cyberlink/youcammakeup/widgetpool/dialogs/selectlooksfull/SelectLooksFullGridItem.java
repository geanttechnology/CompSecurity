// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs.selectlooksfull;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.ak;

public class SelectLooksFullGridItem extends FrameLayout
{

    private ImageView a;
    private TextView b;
    private Context c;
    private View d;
    private android.view.View.OnClickListener e;
    private float f;
    private View g;

    public SelectLooksFullGridItem(Context context, AttributeSet attributeset, int i)
    {
        this(context, null);
    }

    public SelectLooksFullGridItem(Context context, android.view.View.OnClickListener onclicklistener)
    {
        super(context);
        c = context;
        e = onclicklistener;
        a(((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030202, this));
    }

    private void a(View view)
    {
        a = (ImageView)view.findViewById(0x7f0c08a1);
        a.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        b = (TextView)view.findViewById(0x7f0c08a4);
        d = view.findViewById(0x7f0c08a0);
        g = view.findViewById(0x7f0c08da);
        f = aj.a(((Activity)c).getWindowManager().getDefaultDisplay(), new ak(360F, 9F, new String[] {
            ""
        })).floatValue();
    }

    public void setImageChecked(boolean flag)
    {
        if (g != null)
        {
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            g.setVisibility(i);
        }
    }

    public void setName(String s)
    {
        if (b != null)
        {
            b.setText(s);
        }
    }
}
