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

class exerAdapter extends exerAdapter
{

    final GlobalSearchFragment this$0;
    final List val$textSuggestionsListClone;

    public View getView(final int position, View view, final ViewGroup suggestion)
    {
        if (view == null)
        {
            view = GlobalSearchFragment.access$2700(GlobalSearchFragment.this).inflate(0x7f030111, null);
        }
        view = (TextView)view.findViewById(0x7f100204);
        suggestion = (SearchSuggestion)val$textSuggestionsListClone.get(position);
        view.setText(Html.fromHtml(((SearchSuggestion) (suggestion)).label));
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobalSearchFragment._cls19 this$1;
            final int val$position;
            final SearchSuggestion val$suggestion;

            public void onClick(View view1)
            {
                GlobalSearchFragment.access$2400(this$0, suggestion.value, "", true);
                GlobalSearchFragment.access$300(this$0).clearFocus();
                if (GlobalSearchFragment.access$2000(this$0).isUniversalSearchChannelSelectorEnabled())
                {
                    view1 = new GlobalSearchAutoCompleteClickMetadata(GlobalSearchFragment.access$2100(this$0).loggingNameForChannelString(GlobalSearchFragment.access$1200(this$0).toString()), Strings.join(",", Arrays.asList(new Serializable[] {
                        suggestion.value, Integer.valueOf(position + 1)
                    })));
                    GlobalSearchFragment.access$2200(this$0).logClick("", "autocomplete_selection_click", "global_search", view1);
                    return;
                } else
                {
                    GlobalSearchFragment.access$000(this$0).logClick("", "autocomplete_selection_click", "global_search", Strings.join(",", Arrays.asList(new Serializable[] {
                        suggestion.value, Integer.valueOf(position + 1)
                    })));
                    return;
                }
            }

            
            {
                this$1 = GlobalSearchFragment._cls19.this;
                suggestion = searchsuggestion;
                position = i;
                super();
            }
        });
        return view;
    }

    _cls1.val.position(int i, List list, List list1)
    {
        this$0 = final_globalsearchfragment;
        val$textSuggestionsListClone = list1;
        super(Context.this, i, list);
    }
}
