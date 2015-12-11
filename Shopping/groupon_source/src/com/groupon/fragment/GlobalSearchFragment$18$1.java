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

class val.suggestion
    implements android.view.nt._cls18._cls1
{

    final ocus this$1;
    final String val$suggestion;

    public void onClick(View view)
    {
        GlobalSearchFragment.access$2300(_fld0, val$suggestion, "");
        GlobalSearchFragment.access$2400(_fld0, val$suggestion, "", true);
        GlobalSearchFragment.access$300(_fld0).clearFocus();
    }

    hTermIndexerAdapter()
    {
        this$1 = final_htermindexeradapter;
        val$suggestion = String.this;
        super();
    }

    // Unreferenced inner class com/groupon/fragment/GlobalSearchFragment$18

/* anonymous class */
    class GlobalSearchFragment._cls18 extends GlobalSearchFragment.SearchTermIndexerAdapter
    {

        final GlobalSearchFragment this$0;
        final List val$recentlySearchedTermsListClone;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = GlobalSearchFragment.access$2700(GlobalSearchFragment.this).inflate(0x7f030111, null);
            }
            view = (TextView)view.findViewById(0x7f100204);
            viewgroup = ((SearchTermAndCategory)recentlySearchedTermsListClone.get(i)).getSearchTerm();
            view.setText(viewgroup);
            view.setOnClickListener(viewgroup. new GlobalSearchFragment._cls18._cls1());
            return view;
        }

            
            {
                this$0 = final_globalsearchfragment;
                recentlySearchedTermsListClone = list1;
                super(Context.this, i, list);
            }
    }

}
