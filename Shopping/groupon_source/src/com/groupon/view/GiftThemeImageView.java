// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.groupon.db.models.DerivedGiftTheme;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class GiftThemeImageView extends LinearLayout
{

    private String imageUrl;
    private View indicator;
    private DerivedGiftTheme theme;
    private UrlImageView urlImageView;

    public GiftThemeImageView(Context context, AttributeSet attributeset, String s, DerivedGiftTheme derivedgifttheme)
    {
        super(context, attributeset);
        imageUrl = s;
        theme = derivedgifttheme;
        View.inflate(context, 0x7f030101, this);
        onFinishInflate();
    }

    public DerivedGiftTheme getTheme()
    {
        return theme;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        indicator = findViewById(0x7f1000ac);
        View view = indicator;
        int i;
        if (theme.selected)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        view.setVisibility(i);
        urlImageView = (UrlImageView)findViewById(0x7f100076);
        urlImageView.setImageUrl(imageUrl);
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }
}
