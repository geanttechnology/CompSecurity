// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common.view;

import android.text.TextUtils;
import android.view.View;
import com.ebay.android.widget.RemoteImageView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.common.view:
//            ViewModel

public abstract class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    implements android.view.View.OnClickListener
{

    protected ViewModel model;

    public ViewHolder(View view)
    {
        super(view);
    }

    protected static void bindImageViews(List list, List list1)
    {
        int j = Math.min(list.size(), list1.size());
        for (int i = 0; i < j; i++)
        {
            ((RemoteImageView)list1.get(i)).setRemoteImageUrl((String)list.get(i));
        }

    }

    protected static transient List findViewsByIds(View view, int ai[])
    {
        ArrayList arraylist = new ArrayList();
        int j = ai.length;
        int i = 0;
        do
        {
            View view1;
label0:
            {
                if (i < j)
                {
                    view1 = view.findViewById(ai[i]);
                    if (view1 != null)
                    {
                        break label0;
                    }
                }
                return arraylist;
            }
            arraylist.add(view1);
            i++;
        } while (true);
    }

    protected static transient boolean isNotEmpty(CharSequence acharsequence[])
    {
        if (acharsequence != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = acharsequence.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (TextUtils.isEmpty(acharsequence[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public void bind(ViewModel viewmodel)
    {
        model = viewmodel;
    }

    public void onClick(View view)
    {
        ViewModel.OnClickListener onclicklistener = model.listener;
        if (onclicklistener != null)
        {
            onclicklistener.onClick(view, model);
        }
    }

    public void setFullSpan(boolean flag)
    {
        Object obj = itemView.getLayoutParams();
        if (obj instanceof android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)
        {
            obj = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)obj;
            ((android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) (obj)).setFullSpan(flag);
            itemView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
    }
}
