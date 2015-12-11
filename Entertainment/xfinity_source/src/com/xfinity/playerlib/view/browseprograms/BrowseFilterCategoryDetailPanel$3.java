// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoryDetailPanel, DibicProgramFilter

class val.category extends ArrayAdapter
{

    final BrowseFilterCategoryDetailPanel this$0;
    final val.category val$category;
    final DibicProgramFilter val$filter;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Pair pair = (Pair)getItem(i);
        View view1 = view;
        if (view == null)
        {
            view1 = BrowseFilterCategoryDetailPanel.access$000(BrowseFilterCategoryDetailPanel.this).inflate(com.xfinity.playerlib.tegoryDetailPanel, viewgroup, false);
        }
        view = (CheckedTextView)view1.findViewById(com.xfinity.playerlib.tegoryDetailPanel);
        view.setText((CharSequence)pair.second);
        view.setChecked(val$filter.getFiltersForCategory(val$category).containsKey(pair.first));
        return view1;
    }

    Q(Pair apair[], DibicProgramFilter dibicprogramfilter, Q q)
    {
        this$0 = final_browsefiltercategorydetailpanel;
        val$filter = dibicprogramfilter;
        val$category = q;
        super(final_context, I.this, apair);
    }
}
