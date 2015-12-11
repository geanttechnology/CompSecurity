// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.content.res.Resources;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchConfigurationManager;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.Locale;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView

private class <init>
    implements android.widget.bugOnCheckedChangeListener
{

    final SearchDebugView this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (i != com.amazon.retailsearch.kedChangeListener) goto _L2; else goto _L1
_L1:
        SearchConfigurationManager.getInstance().setConfigurationId("amazon");
        SearchDebugView.access$100(SearchDebugView.this).setText("");
_L4:
        radiogroup = SearchConfiguration.getConfiguration();
        radiogroup.setRealm(radiogroup.getRealmForLocale(Locale.getDefault()));
        AndroidRetailSearchClient.resetClient();
        SearchDebugView.access$200(SearchDebugView.this).setText(SearchConfiguration.getConfiguration().getRealm().getSecureSearchServiceUrl());
        return;
_L2:
        if (i == com.amazon.retailsearch.Url)
        {
            SearchConfigurationManager.getInstance().setConfigurationId("test1");
            SearchDebugView.access$100(SearchDebugView.this).setText(getResources().getString(com.amazon.retailsearch.kedChangeListener.this._fld0));
        } else
        if (i == com.amazon.retailsearch.kedChangeListener.this._fld0)
        {
            SearchConfigurationManager.getInstance().setConfigurationId("test2");
            SearchDebugView.access$100(SearchDebugView.this).setText(getResources().getString(com.amazon.retailsearch.kedChangeListener.this._fld0));
        } else
        if (i == com.amazon.retailsearch.kedChangeListener.this._fld0)
        {
            SearchConfigurationManager.getInstance().setConfigurationId("test3");
            SearchDebugView.access$100(SearchDebugView.this).setText(getResources().getString(com.amazon.retailsearch.kedChangeListener.this._fld0));
        } else
        if (i == com.amazon.retailsearch.kedChangeListener.this._fld0)
        {
            SearchConfigurationManager.getInstance().setConfigurationId("test4");
            SearchDebugView.access$100(SearchDebugView.this).setText(getResources().getString(com.amazon.retailsearch.kedChangeListener.this._fld0));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ()
    {
        this$0 = SearchDebugView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
