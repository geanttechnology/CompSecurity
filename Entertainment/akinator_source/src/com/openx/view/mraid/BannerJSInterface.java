// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.view.mraid;

import android.content.Context;
import com.openx.common.utils.helpers.Utils;
import com.openx.view.WebViewBase;

// Referenced classes of package com.openx.view.mraid:
//            BaseJSInterface

public class BannerJSInterface extends BaseJSInterface
{

    Context context;

    public BannerJSInterface(Context context1, WebViewBase webviewbase)
    {
        super(context1, webviewbase);
        context = context1;
    }

    public String getPlacementType()
    {
        Utils.log(this, "[][][][][][] getPlacement inline");
        return "inline";
    }
}
