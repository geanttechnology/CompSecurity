// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

class this._cls0
    implements android.content.Activity._cls5
{

    final SavedSearchResultListActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SavedSearchResultListActivity.access$700(SavedSearchResultListActivity.this);
        dialoginterface = MyApp.getPrefs().getAuthentication();
        SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).retry(getEbayContext(), SavedSearchResultListActivity.this, dialoginterface);
    }

    archResults()
    {
        this$0 = SavedSearchResultListActivity.this;
        super();
    }
}
