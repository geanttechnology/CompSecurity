// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.component.view:
//            AttentionComponentView

class this._cls0
    implements com.sina.weibo.sdk.component.RequestCallback
{

    final AttentionComponentView this$0;

    public void onWebViewResult(String s)
    {
        s = Utility.parseUri(s).getString("result");
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        long l = Integer.parseInt(s);
        if (l == 1L)
        {
            try
            {
                AttentionComponentView.access$3(AttentionComponentView.this, true);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            break MISSING_BLOCK_LABEL_54;
        }
        if (l != 0L)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        AttentionComponentView.access$3(AttentionComponentView.this, false);
        return;
    }

    stCallback()
    {
        this$0 = AttentionComponentView.this;
        super();
    }
}
