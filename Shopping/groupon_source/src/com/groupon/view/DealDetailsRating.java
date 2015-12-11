// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.db.models.Rating;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class DealDetailsRating extends RelativeLayout
{

    protected TextView reviewCount;
    protected View separator;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

    public DealDetailsRating(Context context)
    {
        this(context, null);
    }

    public DealDetailsRating(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        inflate(getContext(), 0x7f0300c3, this);
        onFinishInflate();
    }

    public void hideRatingSeparator()
    {
        separator.setVisibility(8);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        star1 = (ImageView)findViewById(0x7f10025e);
        star2 = (ImageView)findViewById(0x7f10025f);
        star3 = (ImageView)findViewById(0x7f100260);
        star4 = (ImageView)findViewById(0x7f100261);
        star5 = (ImageView)findViewById(0x7f100262);
        reviewCount = (TextView)findViewById(0x7f100252);
        separator = findViewById(0x7f100253);
    }

    public void setRating(Rating rating)
    {
        int j = rating.getReviewsCount().intValue();
        Object obj = getContext().getString(0x7f0802ba);
        String s = rating.getLinkText();
        int i = -1;
        obj = String.format(((String) (obj)), new Object[] {
            Integer.valueOf(j), "__S__"
        });
        String s1;
        if (Strings.notEmpty(s))
        {
            s = (new StringBuilder()).append(" ").append(getContext().getString(0x7f0802be, new Object[] {
                s
            })).toString();
            j = ((String) (obj)).indexOf("__S__");
            i = s.length();
            Ln.d("DETAILS: index = %s, onSiteString = '%s', onSiteString len = %s, fullText = '%s', raw = %s", new Object[] {
                Integer.valueOf(j), s, Integer.valueOf(s.length()), null, rating
            });
        } else
        {
            s = "";
            j = 0;
        }
        s = ((String) (obj)).replace("__S__", s);
        obj = new SpannableString(s);
        s1 = rating.getUrl();
        if (Strings.notEmpty(s1))
        {
            int k = i;
            if (i < 0)
            {
                k = s.length();
            }
            ((SpannableString) (obj)).setSpan(new URLSpan(s1), j, j + k, 33);
            reviewCount.setMovementMethod(LinkMovementMethod.getInstance());
        }
        reviewCount.setText(((CharSequence) (obj)));
        setStars(rating.getRating().doubleValue());
    }

    protected void setStar(ImageView imageview, double d)
    {
        int i;
        if (d >= 1.0D)
        {
            i = 0x7f020202;
        } else
        if (d >= 0.5D)
        {
            i = 0x7f020200;
        } else
        {
            i = 0x7f020201;
        }
        imageview.setImageResource(i);
    }

    protected void setStars(double d)
    {
        setStar(star1, d);
        setStar(star2, d - 1.0D);
        setStar(star3, d - 2D);
        setStar(star4, d - 3D);
        setStar(star5, d - 4D);
    }
}
