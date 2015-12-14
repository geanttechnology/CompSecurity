// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.internal.utils.Utils;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.mmWebView
    implements com.millennialmedia.internal.utils.tener
{

    final val.mmWebView this$1;
    final MMWebView val$mmWebView;

    public void onError(String s)
    {
        throwMraidError(s, "storePicture");
    }

    public void onPictureSaved(File file)
    {
        Utils.showToast(val$mmWebView.getContext(), (new StringBuilder()).append(file.getName()).append(" stored in gallery").toString());
    }

    ureListener()
    {
        this$1 = final_urelistener;
        val$mmWebView = MMWebView.this;
        super();
    }
}
