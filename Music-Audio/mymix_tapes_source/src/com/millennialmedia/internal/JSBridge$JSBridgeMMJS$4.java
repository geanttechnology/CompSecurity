// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.MediaUtils;
import com.millennialmedia.internal.utils.Utils;
import java.io.File;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.callbackId
    implements com.millennialmedia.internal.utils.stener
{

    final val.callbackId this$1;
    final String val$callbackId;
    final String val$description;
    final MMWebView val$mmWebView;

    public void onError(String s)
    {
        MMLog.e(JSBridge.access$000(), s);
        invokeCallback(val$callbackId, new Object[] {
            Boolean.valueOf(false)
        });
    }

    public void onPictureSaved(File file)
    {
        if (val$description != null)
        {
            MediaUtils.setFileDescription(file, val$description);
        }
        Utils.showToast(val$mmWebView.getContext(), (new StringBuilder()).append(file.getName()).append(" stored in gallery").toString());
        invokeCallback(val$callbackId, new Object[] {
            Boolean.valueOf(true)
        });
    }

    tureListener()
    {
        this$1 = final_turelistener;
        val$description = s;
        val$mmWebView = mmwebview;
        val$callbackId = String.this;
        super();
    }
}
