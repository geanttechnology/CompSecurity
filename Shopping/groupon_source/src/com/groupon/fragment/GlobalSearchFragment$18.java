// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.models.SearchTermAndCategory;
import com.groupon.util.SearchInterfaceProvider;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class rchTermIndexerAdapter extends rchTermIndexerAdapter
{

    final GlobalSearchFragment this$0;
    final List val$recentlySearchedTermsListClone;

    public View getView(int i, View view, final ViewGroup suggestion)
    {
        if (view == null)
        {
            view = GlobalSearchFragment.access$2700(GlobalSearchFragment.this).inflate(0x7f030111, null);
        }
        view = (TextView)view.findViewById(0x7f100204);
        suggestion = ((SearchTermAndCategory)val$recentlySearchedTermsListClone.get(i)).getSearchTerm();
        view.setText(suggestion);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobalSearchFragment._cls18 this$1;
            final String val$suggestion;

            public void onClick(View view1)
            {
                GlobalSearchFragment.access$2300(this$0, suggestion, "");
                GlobalSearchFragment.access$2400(this$0, suggestion, "", true);
                GlobalSearchFragment.access$300(this$0).clearFocus();
            }

            
            {
                this$1 = GlobalSearchFragment._cls18.this;
                suggestion = s;
                super();
            }
        });
        return view;
    }

    _cls1.val.suggestion(int i, List list, List list1)
    {
        this$0 = final_globalsearchfragment;
        val$recentlySearchedTermsListClone = list1;
        super(Context.this, i, list);
    }
}
