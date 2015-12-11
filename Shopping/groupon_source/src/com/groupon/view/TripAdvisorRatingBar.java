// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.groupon.view:
//            CircleRatingBar

public class TripAdvisorRatingBar extends CircleRatingBar
{

    public TripAdvisorRatingBar(Context context)
    {
        super(context);
    }

    public TripAdvisorRatingBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void inflateView()
    {
        inflate(getContext(), 0x7f03021a, this);
    }

    protected void setCircle(ImageView imageview, double d)
    {
        int i;
        if (d >= 1.0D)
        {
            i = 0x7f020323;
        } else
        if (d >= 0.5D)
        {
            i = 0x7f020321;
        } else
        {
            i = 0x7f020322;
        }
        imageview.setImageResource(i);
    }
}
