// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

// Referenced classes of package com.amazon.mShop:
//            TitleProvider, AmazonActivity

public class InfoView extends ScrollView
    implements TitleProvider
{

    int titleId;

    public InfoView(Context context, AttributeSet attributeset)
    {
        super(context);
        titleId = 0;
        titleId = attributeset.getAttributeResourceValue(null, "amazon_titleResourceId", 0);
        setText(context, attributeset.getAttributeResourceValue(null, "amazon_htmlContentId", 0));
    }

    public InfoView(AmazonActivity amazonactivity, int i, int j)
    {
        super(amazonactivity);
        titleId = 0;
        titleId = i;
        setText(amazonactivity, j);
    }

    private void setText(Context context, int i)
    {
        ViewGroup viewgroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(com.amazon.mShop.android.lib.R.layout.info, null);
        ((TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.info_text_view_id)).setText(Html.fromHtml(context.getString(i)));
        addView(viewgroup);
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return getResources().getString(titleId);
    }
}
