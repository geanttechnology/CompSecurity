// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.util.Log;
import com.gotv.crackle.data.DetailsProvider;

// Referenced classes of package com.gotv.crackle.helpers:
//            ChromeCastHelper

class val.mediaID
    implements com.gotv.crackle.data.uestListener
{

    final ChromeCastHelper this$0;
    final DetailsProvider val$detailsProvider;
    final String val$mediaID;

    public void onDataFailed(String s, String s1)
    {
        Log.w(ChromeCastHelper.access$000(), (new StringBuilder()).append("couldn't load data for media ID: ").append(val$mediaID).toString());
    }

    public void onDataSuccess(String s)
    {
        ChromeCastHelper.access$102(ChromeCastHelper.this, val$detailsProvider.getMediaDetailsItem());
        savePosition();
        ChromeCastHelper.access$900(ChromeCastHelper.this);
    }

    tListener()
    {
        this$0 = final_chromecasthelper;
        val$detailsProvider = detailsprovider;
        val$mediaID = String.this;
        super();
    }
}
