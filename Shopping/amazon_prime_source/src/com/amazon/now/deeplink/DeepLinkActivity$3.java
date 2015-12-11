// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.deeplink;

import android.content.DialogInterface;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.deeplink:
//            DeepLinkActivity

class this._cls0
    implements android.content.ancelListener
{

    final DeepLinkActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        AppUtils.resetActivityStack(DeepLinkActivity.this);
    }

    tener()
    {
        this$0 = DeepLinkActivity.this;
        super();
    }
}
