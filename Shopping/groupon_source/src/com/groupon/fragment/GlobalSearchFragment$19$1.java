// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.models.SearchSuggestion;
import com.groupon.models.nst.GlobalSearchAutoCompleteClickMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GlobalSearchUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.SearchInterfaceProvider;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.position
    implements android.view.nt._cls19._cls1
{

    final val.position this$1;
    final int val$position;
    final SearchSuggestion val$suggestion;

    public void onClick(View view)
    {
        GlobalSearchFragment.access$2400(_fld0, val$suggestion.value, "", true);
        GlobalSearchFragment.access$300(_fld0).clearFocus();
        if (GlobalSearchFragment.access$2000(_fld0).isUniversalSearchChannelSelectorEnabled())
        {
            view = new GlobalSearchAutoCompleteClickMetadata(GlobalSearchFragment.access$2100(_fld0).loggingNameForChannelString(GlobalSearchFragment.access$1200(_fld0).toString()), Strings.join(",", Arrays.asList(new Serializable[] {
                val$suggestion.value, Integer.valueOf(val$position + 1)
            })));
            GlobalSearchFragment.access$2200(_fld0).logClick("", "autocomplete_selection_click", "global_search", view);
            return;
        } else
        {
            GlobalSearchFragment.access$000(_fld0).logClick("", "autocomplete_selection_click", "global_search", Strings.join(",", Arrays.asList(new Serializable[] {
                val$suggestion.value, Integer.valueOf(val$position + 1)
            })));
            return;
        }
    }

    erAdapter()
    {
        this$1 = final_eradapter;
        val$suggestion = searchsuggestion;
        val$position = I.this;
        super();
    }

    // Unreferenced inner class com/groupon/fragment/GlobalSearchFragment$19

/* anonymous class */
    class GlobalSearchFragment._cls19 extends GlobalSearchFragment.IndexerAdapter
    {

        final GlobalSearchFragment this$0;
        final List val$textSuggestionsListClone;

        public View getView(int i, View view, final ViewGroup suggestion)
        {
            if (view == null)
            {
                view = GlobalSearchFragment.access$2700(GlobalSearchFragment.this).inflate(0x7f030111, null);
            }
            view = (TextView)view.findViewById(0x7f100204);
            suggestion = (SearchSuggestion)textSuggestionsListClone.get(i);
            view.setText(Html.fromHtml(((SearchSuggestion) (suggestion)).label));
            view.setOnClickListener(i. new GlobalSearchFragment._cls19._cls1());
            return view;
        }

            
            {
                this$0 = final_globalsearchfragment;
                textSuggestionsListClone = list1;
                super(Context.this, i, list);
            }
    }

}
