// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.view.mraid;

import android.content.Context;
import com.openx.view.WebViewBase;

// Referenced classes of package com.openx.view.mraid:
//            BaseJSInterface

public class InterstitialJSInterface extends BaseJSInterface
{

    Context context;

    public InterstitialJSInterface(Context context1, WebViewBase webviewbase)
    {
        super(context1, webviewbase);
        context = context1;
    }

    public void expand()
    {
    }

    public String getPlacementType()
    {
        return "interstitial";
    }
}
