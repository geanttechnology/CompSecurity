// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.nautilus.domain.app.Authentication;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchListActivity

class this._cls1
    implements android.view.Adapter._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        while (SavedSearchListActivity.access$000(_fld0) == null || cess._mth100(this._cls1.this)) 
        {
            return;
        }
        int i = ((Integer)view.getTag()).intValue();
        SavedSearch savedsearch = tItem(i);
        view = (ImageView)view;
        boolean flag;
        if (!SavedSearchListActivity.access$200(_fld0).isNotifyEnabledForSavedSearch(SavedSearchListActivity.access$000(_fld0).user, savedsearch.id))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            SavedSearchListActivity.access$200(_fld0).addNotifyEnabledSavedSearchId(SavedSearchListActivity.access$000(_fld0).user, savedsearch.id);
        } else
        {
            SavedSearchListActivity.access$200(_fld0).removeNotifyEnabledSavedSearchId(SavedSearchListActivity.access$000(_fld0).user, savedsearch.id);
        }
        if (flag)
        {
            view.setImageResource(0x7f020288);
            Toast.makeText(_fld0, cess._mth300(this._cls1.this), 0).show();
        } else
        {
            view.setImageResource(0x7f020287);
            Toast.makeText(_fld0, cess._mth400(this._cls1.this), 0).show();
        }
        if (SavedSearchListActivity.access$500(_fld0))
        {
            (new cTask(_fld0, null)).execute(SavedSearchListActivity.access$200(_fld0).getNotifyEnabledSavedSearchIdList(SavedSearchListActivity.access$000(_fld0).user).toArray(new String[0]));
            return;
        } else
        {
            SavedSearchListActivity.access$602(_fld0, true);
            return;
        }
    }

    cTask()
    {
        this$1 = this._cls1.this;
        super();
    }
}
