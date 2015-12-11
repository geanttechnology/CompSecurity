// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

public class SearchItemView extends ItemView
{

    public SearchItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ((TextView)findViewById(com.amazon.mShop.android.lib.R.id.search_results_sub_header)).setOnClickListener(new android.view.View.OnClickListener() {

            final SearchItemView this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = SearchItemView.this;
                super();
            }
        });
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, Drawable drawable, int i)
    {
        super.update(objectsubscriberadapter, obj, drawable, i);
        objectsubscriberadapter = (SearchResult)obj;
        showBadgeImageTogetherWithPrice(objectsubscriberadapter.getBasicOffer(), objectsubscriberadapter.getBasicProduct());
    }
}
