// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.widget.LinearLayout;

// Referenced classes of package com.inc247:
//            ChatSDK, ChatSDKBadgeView

class t>
    implements Runnable
{

    final ChatSDK this$0;

    public void run()
    {
        ChatSDK.access$4(ChatSDK.this).setVisibility(0);
        int i = Integer.parseInt((new StringBuilder()).append(ChatSDK.access$6(ChatSDK.this).getText().toString().charAt(0)).toString());
        String s;
        if (i == 9)
        {
            s = (new StringBuilder(String.valueOf(i))).append("+").toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(i + 1))).toString();
        }
        ChatSDK.access$6(ChatSDK.this).setText(s);
    }

    e()
    {
        this$0 = ChatSDK.this;
        super();
    }
}
