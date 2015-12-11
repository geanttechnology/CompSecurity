// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            CouponTopItem

public class CouponTopItemCard extends CardView
{

    protected UrlImageView image;
    protected TextView title;

    public CouponTopItemCard(Context context)
    {
        this(context, null, 0);
    }

    public CouponTopItemCard(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CouponTopItemCard(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03007a, this);
        onFinishInflate();
    }

    public void bind(CouponTopItem coupontopitem)
    {
        title.setText(coupontopitem.getTitle());
        image.setImageUrl((new StringBuilder()).append("https://").append(coupontopitem.getImageUrl()).append("/v1/t300x300.png").toString());
        setTag(0x7f100001, coupontopitem);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        image = (UrlImageView)findViewById(0x7f1001dc);
        title = (TextView)findViewById(0x7f1001dd);
    }
}
