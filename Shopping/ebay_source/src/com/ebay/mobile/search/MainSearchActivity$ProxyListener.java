// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.mobile.search:
//            MainSearchActivity

private class <init>
    implements android.widget.istener
{

    final MainSearchActivity this$0;

    public boolean onQueryTextChange(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            MyApp.getPrefs().removeUserPref("searchLastKeywords");
        } else
        {
            MyApp.getPrefs().setUserPref("searchLastKeywords", s);
        }
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        return false;
    }

    private ()
    {
        this$0 = MainSearchActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
