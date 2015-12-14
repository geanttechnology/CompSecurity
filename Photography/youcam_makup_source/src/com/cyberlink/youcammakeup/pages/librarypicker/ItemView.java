// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker:
//            b

public abstract class ItemView extends FrameLayout
{

    protected static Drawable a;
    protected static Drawable b;
    protected final Context c;
    protected ImageView d;

    public ItemView(Context context)
    {
        super(context);
        c = context;
        a = getResources().getDrawable(0x7f020896);
        b = getResources().getDrawable(0x7f020895);
    }

    public ItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = context;
    }

    public void a()
    {
        d.setImageDrawable(a);
    }

    public ImageView getImageView()
    {
        return d;
    }

    public abstract b getItem();
}
