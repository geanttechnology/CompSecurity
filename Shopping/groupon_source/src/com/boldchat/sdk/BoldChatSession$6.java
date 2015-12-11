// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

class val.typingView
    implements Runnable
{

    final BoldChatSession this$0;
    final Spanned val$text;
    final TextView val$typingView;

    public void run()
    {
        if (!TextUtils.isEmpty(val$text))
        {
            val$typingView.setText(val$text);
            val$typingView.setVisibility(0);
            return;
        } else
        {
            val$typingView.setText("");
            val$typingView.setVisibility(4);
            return;
        }
    }

    ()
    {
        this$0 = final_boldchatsession;
        val$text = spanned;
        val$typingView = TextView.this;
        super();
    }
}
