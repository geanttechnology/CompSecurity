// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingPromotion;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import java.util.Iterator;
import java.util.List;

public class WeeklyAdListingPromotionView extends LinearLayout
{
    public static interface a
    {

        public abstract void a(WeeklyAdListingPromotion weeklyadlistingpromotion);
    }


    private a mListener;

    public WeeklyAdListingPromotionView(Context context)
    {
        super(context);
        a();
    }

    public WeeklyAdListingPromotionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public WeeklyAdListingPromotionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(WeeklyAdListingPromotionView weeklyadlistingpromotionview)
    {
        return weeklyadlistingpromotionview.mListener;
    }

    private void a()
    {
        setOrientation(1);
    }

    public void setOnPromotionClickedListener(a a1)
    {
        mListener = a1;
    }

    public void setPromotion(List list)
    {
        if (list != null)
        {
            removeAllViews();
            list = list.iterator();
            while (list.hasNext()) 
            {
                final WeeklyAdListingPromotion promo = (WeeklyAdListingPromotion)list.next();
                View view = LayoutInflater.from(getContext()).inflate(0x7f030192, this, false);
                TextView textview = (TextView)view.findViewById(0x7f1004d4);
                if (o.g(promo.a()))
                {
                    textview.setText(Html.fromHtml(promo.a()));
                    al.b(textview);
                } else
                {
                    al.c(textview);
                }
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final WeeklyAdListingPromotionView this$0;
                    final WeeklyAdListingPromotion val$promo;

                    public void onClick(View view1)
                    {
                        if (WeeklyAdListingPromotionView.a(WeeklyAdListingPromotionView.this) != null)
                        {
                            WeeklyAdListingPromotionView.a(WeeklyAdListingPromotionView.this).a(promo);
                        }
                    }

            
            {
                this$0 = WeeklyAdListingPromotionView.this;
                promo = weeklyadlistingpromotion;
                super();
            }
                });
                addView(view);
            }
        }
    }
}
