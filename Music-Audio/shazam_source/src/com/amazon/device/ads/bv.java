// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageButton;
import android.widget.ImageView;

// Referenced classes of package com.amazon.device.ads:
//            bx, at

final class bv
    implements bx
{

    bv()
    {
    }

    public final BitmapDrawable a(Resources resources, String s)
    {
        return at.a(resources, s);
    }

    public final ImageView a(Context context, String s)
    {
        context = new ImageButton(context);
        context.setContentDescription(s);
        return context;
    }
}
