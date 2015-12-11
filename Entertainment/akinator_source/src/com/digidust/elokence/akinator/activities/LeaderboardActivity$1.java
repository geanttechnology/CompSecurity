// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkLog;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            LeaderboardActivity

class this._cls0
    implements FacebookCallback
{

    final LeaderboardActivity this$0;

    public void onCancel()
    {
        AkLog.d("LeaderboardActivity", "cancel");
    }

    public void onError(FacebookException facebookexception)
    {
        AkLog.e("LeaderboardActivity", facebookexception.toString());
    }

    public void onSuccess(com.facebook.share.widget.lt lt)
    {
        AkLog.d("LeaderboardActivity", "ok");
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((com.facebook.share.widget.lt)obj);
    }

    ()
    {
        this$0 = LeaderboardActivity.this;
        super();
    }
}
