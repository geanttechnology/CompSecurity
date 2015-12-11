// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;
import com.groupon.db.models.CouponSummary;
import com.groupon.view.UrlImageView;
import roboguice.util.Strings;

public class CouponCard extends CardView
{

    protected TextView exclusiveTextView;
    protected UrlImageView imageView;
    protected TextView subtitleLabel;
    protected TextView titleLabel;

    public CouponCard(Context context)
    {
        super(context);
    }

    public CouponCard(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CouponCard(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        exclusiveTextView = (TextView)findViewById(0x7f1001b9);
        imageView = (UrlImageView)findViewById(0x7f1001b5);
        titleLabel = (TextView)findViewById(0x7f1001b7);
        subtitleLabel = (TextView)findViewById(0x7f1001b8);
    }

    public void setCoupon(CouponSummary couponsummary, boolean flag)
    {
        int i;
        boolean flag1;
        flag1 = false;
        Object obj = exclusiveTextView;
        String s;
        if (couponsummary.isExclusive)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ((TextView) (obj)).setVisibility(i);
        titleLabel.setText(couponsummary.title);
        imageView.setImageUrl("");
        if (flag)
        {
            obj = couponsummary.productImageUrl;
        } else
        {
            obj = couponsummary.getImageUrl();
        }
        s = ((String) (obj));
        if (flag)
        {
            s = ((String) (obj));
            if (Strings.isEmpty(obj))
            {
                s = couponsummary.getImageUrl();
            }
        }
        if (Strings.notEmpty(s))
        {
            imageView.setImageUrl((new StringBuilder()).append("https://").append(s).append("/v1/t300x300.png").toString());
        }
        obj = couponsummary.displayType;
        couponsummary = ((CouponSummary) (obj));
        if (obj == null)
        {
            couponsummary = "";
        }
        couponsummary.hashCode();
        JVM INSTR lookupswitch 8: default 208
    //                   -1835309887: 360
    //                   -997631434: 391
    //                   -27932576: 315
    //                   464109235: 300
    //                   814094796: 375
    //                   1494517706: 330
    //                   1617612823: 345
    //                   1932946569: 284;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        i = -1;
          goto _L10
_L9:
        if (!couponsummary.equals("online_promo_code")) goto _L1; else goto _L11
_L11:
        i = ((flag1) ? 1 : 0);
          goto _L10
_L5:
        if (!couponsummary.equals("online_sale")) goto _L1; else goto _L12
_L12:
        i = 1;
          goto _L10
_L4:
        if (!couponsummary.equals("instore_promo_code")) goto _L1; else goto _L13
_L13:
        i = 2;
          goto _L10
_L7:
        if (!couponsummary.equals("instore_sale")) goto _L1; else goto _L14
_L14:
        i = 3;
          goto _L10
_L8:
        if (!couponsummary.equals("mobile_download_promo_code")) goto _L1; else goto _L15
_L15:
        i = 4;
          goto _L10
_L2:
        if (!couponsummary.equals("mobile_download_sale")) goto _L1; else goto _L16
_L16:
        i = 5;
          goto _L10
_L6:
        if (!couponsummary.equals("online_instore_promo_code")) goto _L1; else goto _L17
_L17:
        i = 6;
          goto _L10
_L3:
        if (!couponsummary.equals("online_instore_sale")) goto _L1; else goto _L18
_L18:
        i = 7;
_L10:
        switch (i)
        {
        default:
            subtitleLabel.setText("");
            return;

        case 0: // '\0'
        case 1: // '\001'
            subtitleLabel.setText(0x7f080467);
            return;

        case 2: // '\002'
        case 3: // '\003'
            subtitleLabel.setText(0x7f080109);
            return;

        case 4: // '\004'
        case 5: // '\005'
            subtitleLabel.setText(0x7f08010a);
            return;

        case 6: // '\006'
        case 7: // '\007'
            subtitleLabel.setText(0x7f08010b);
            break;
        }
        return;
    }
}
