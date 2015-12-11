// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.content.res.Resources;
import com.amazon.now.ChromeStyle;
import com.amazon.now.media.FullScreenGalleryActivity;
import com.amazon.now.restaurants.RestaurantsActivity;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHImageGalleryPlugin

class val.startIndex
    implements Runnable
{

    final MASHImageGalleryPlugin this$0;
    final String val$imageArray[];
    final int val$startIndex;

    public void run()
    {
        ChromeStyle chromestyle = null;
        if (cordova.getActivity() instanceof RestaurantsActivity)
        {
            int i = cordova.getActivity().getResources().getColor(0x7f0d0025);
            chromestyle = new ChromeStyle(com.amazon.now.NORMAL, i, true);
        }
        FullScreenGalleryActivity.startFullScreenGalleryActivity(cordova.getActivity(), val$imageArray, val$startIndex, chromestyle);
    }

    ()
    {
        this$0 = final_mashimagegalleryplugin;
        val$imageArray = as;
        val$startIndex = I.this;
        super();
    }
}
