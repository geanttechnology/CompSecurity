// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements FacebookCallback
{

    final HomeActivity this$0;

    public void onCancel()
    {
        Log.i("HomeActivity", "InviteCallback - CANCEL!");
    }

    public void onError(FacebookException facebookexception)
    {
        Log.e("HomeActivity", (new StringBuilder()).append("InviteCallback - ERROR! ").append(facebookexception.getMessage()).toString());
    }

    public void onSuccess(com.facebook.share.widget.Result result)
    {
        Log.d("HomeActivity", (new StringBuilder()).append("InviteCallback onSuccess result = ").append(result.getData().toString()).toString());
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((com.facebook.share.widget.Result)obj);
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
