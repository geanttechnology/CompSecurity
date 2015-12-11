// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserListFragment

class this._cls1
    implements PMApiResponseHandler
{

    final is._cls0 this$1;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        UserListFragment.access$000(_fld0, pmapiresponse, true);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/UserListFragment$7

/* anonymous class */
    class UserListFragment._cls7
        implements com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener
    {

        final UserListFragment this$0;

        public void loadItems(boolean flag)
        {
            if (flag)
            {
                PMApi.getDiscoveredClosets(UserListFragment.access$100(UserListFragment.this), model.getNextPageMaxValue(), new UserListFragment._cls7._cls1());
            }
        }

            
            {
                this$0 = UserListFragment.this;
                super();
            }
    }

}
