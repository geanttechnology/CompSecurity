// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.http.api.PMApi;
import com.poshmark.utils.FbDeferredDeepLinkManager;
import java.util.HashMap;

// Referenced classes of package com.poshmark.ui.fragments:
//            SignInSignUpWallFragment

class this._cls0
    implements ImageLoadingListener
{

    final SignInSignUpWallFragment this$0;

    public void onLoadingCancelled(String s, View view)
    {
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        ((ImageView)getView().findViewById(0x7f0c02d7)).setImageBitmap(bitmap);
        replaceTrackingLabel("nus_dl");
        s = new HashMap();
        s.put("ev", "fbdl");
        s.put("s", "dlrc");
        s.put("lrf", FbDeferredDeepLinkManager.INSTANCE.getDeepLinkUrl());
        PMApi.trackDeepLink(s);
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
    }

    public void onLoadingStarted(String s, View view)
    {
    }

    son()
    {
        this$0 = SignInSignUpWallFragment.this;
        super();
    }
}
