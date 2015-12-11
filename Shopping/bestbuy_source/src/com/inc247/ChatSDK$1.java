// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.os.Handler;
import android.view.View;

// Referenced classes of package com.inc247:
//            ChatSDK, ChatSDKMaximizeButton

class t>
    implements android.view.ckListener
{

    final ChatSDK this$0;

    public void onClick(View view)
    {
        maximizeChat();
        ChatSDK.access$2(ChatSDK.this).setClickable(false);
        (new Handler()).postDelayed(new Runnable() {

            final ChatSDK._cls1 this$1;

            public void run()
            {
                ChatSDK.access$2(this$0).setClickable(true);
            }

            
            {
                this$1 = ChatSDK._cls1.this;
                super();
            }
        }, 500L);
    }


    t>()
    {
        this$0 = ChatSDK.this;
        super();
    }
}
