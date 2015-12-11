// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemChooseVariationsFragment

private class urlRewriterType extends ArrayAdapter
{

    private final boolean itemsHaveImages;
    final ViewItemChooseVariationsFragment this$0;
    private final com.ebay.nautilus.domain.content.dm.etConsolidatedView urlRewriterType;

    private View getConsolidatedView(int i, View view, ViewGroup viewgroup, boolean flag)
    {
        urlRewriterType urlrewritertype = (urlRewriterType)getItem(i);
        View view1 = view;
        byte byte0;
        if (view != null)
        {
            view = (getItem)view.getTag();
        } else
        {
            view1 = ViewItemChooseVariationsFragment.access$000(ViewItemChooseVariationsFragment.this).inflate(0x7f03028b, viewgroup, false);
            view = new (ViewItemChooseVariationsFragment.this, null);
            view._fld0 = (RemoteImageView)view1.findViewById(0x7f10005b);
            ((this._cls0) (view))._fld0.setUrlRewriter(urlRewriterType);
            view.urlRewriterType = (TextView)view1.findViewById(0x7f100618);
            view.ctionText = (TextView)view1.findViewById(0x7f1008ab);
            view.ctionLayout = view1.findViewById(0x7f1008aa);
            view1.setTag(view);
        }
        byte0 = 8;
        i = byte0;
        if (itemsHaveImages)
        {
            if (flag && !TextUtils.isEmpty(urlrewritertype.itemsHaveImages))
            {
                ((itemsHaveImages) (view)).itemsHaveImages.setRemoteImageUrl(urlrewritertype.itemsHaveImages);
                i = 0;
            } else
            {
                i = byte0;
                if (flag)
                {
                    i = byte0;
                    if (urlrewritertype.t)
                    {
                        i = 4;
                    }
                }
            }
        }
        ((t) (view)).t.setVisibility(i);
        if (i == 0)
        {
            ((t) (view)).t.setRemoteImageUrl(urlrewritertype.t);
        } else
        {
            ((t) (view)).t.setRemoteImageUrl(null);
        }
        if (urlrewritertype.t && !flag)
        {
            ((t) (view)).t.setText(ViewItemChooseVariationsFragment.access$200(ViewItemChooseVariationsFragment.this));
        } else
        if (urlrewritertype.t)
        {
            ((t) (view)).ctionText.setText(urlrewritertype.ctionText);
            ((ctionText) (view)).ctionLayout.setVisibility(0);
            ((ctionLayout) (view)).ctionLayout.setVisibility(8);
        } else
        {
            ((ctionLayout) (view)).ctionLayout.setText(urlrewritertype.ctionLayout);
            ((ctionLayout) (view)).ctionLayout.setVisibility(8);
            ((ctionLayout) (view)).ctionLayout.setVisibility(0);
        }
        if (flag)
        {
            view1.setMinimumHeight(ViewItemChooseVariationsFragment.access$300(ViewItemChooseVariationsFragment.this));
        }
        return view1;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return getConsolidatedView(i, view, viewgroup, true);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return getConsolidatedView(i, view, viewgroup, false);
    }

    public (Context context, int i, int j, List list, boolean flag, com.ebay.nautilus.domain.content.dm. )
    {
        this$0 = ViewItemChooseVariationsFragment.this;
        super(context, i, j, list);
        itemsHaveImages = flag;
        urlRewriterType = ;
    }
}
