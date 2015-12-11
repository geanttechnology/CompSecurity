// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.debug;

import android.net.Uri;
import android.view.View;
import com.amazon.mShop.util.WebUtils;

// Referenced classes of package com.amazon.mShop.debug:
//            DebugSettingsView

class val.tokenText
    implements android.view.
{

    final DebugSettingsView this$0;
    final String val$tokenText;

    public void onClick(View view)
    {
        view = Uri.encode(val$tokenText);
        view = (new StringBuilder()).append("mailto:yourmail@amazon.com?body=").append(view).append("&subject=NotificationToken").toString();
        WebUtils.handleMailtoLink(getContext(), view);
    }

    ()
    {
        this$0 = final_debugsettingsview;
        val$tokenText = String.this;
        super();
    }
}
