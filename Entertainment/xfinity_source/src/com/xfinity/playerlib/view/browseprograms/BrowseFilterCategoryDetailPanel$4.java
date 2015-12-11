// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import com.comcast.cim.cmasl.utils.CommonUtils;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoryDetailPanel, FilterEventListener

class val.category
    implements android.widget.ilterCategoryDetailPanel._cls4
{

    final BrowseFilterCategoryDetailPanel this$0;
    final eak val$category;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = (CheckedTextView)view.findViewById(com.xfinity.playerlib.lter.FilterCategory);
        adapterview = (Pair)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
        view.toggle();
        if (view.isChecked())
        {
            filterEventListener.onFilterItemSelected((String)((Pair) (adapterview)).first, (String)((Pair) (adapterview)).second, val$category);
            speak(com.xfinity.playerlib.ed_to_checked);
            return;
        } else
        {
            filterEventListener.onFilterItemDeselected((String)((Pair) (adapterview)).first, val$category);
            speak(com.xfinity.playerlib.ed_to_unchecked);
            return;
        }
    }

    Q()
    {
        this$0 = final_browsefiltercategorydetailpanel;
        val$category = val.category.this;
        super();
    }
}
