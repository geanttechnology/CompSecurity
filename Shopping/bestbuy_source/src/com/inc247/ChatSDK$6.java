// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.view.animation.Animation;
import android.widget.LinearLayout;

// Referenced classes of package com.inc247:
//            ChatSDK

class t>
    implements android.view.animation.AnimationListener
{

    final ChatSDK this$0;

    public void onAnimationEnd(Animation animation)
    {
        ChatSDK.access$5(ChatSDK.this).setVisibility(8);
        ChatSDK.access$4(ChatSDK.this).setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation)
    {
        ChatSDK.access$4(ChatSDK.this).setVisibility(8);
    }

    public void onAnimationStart(Animation animation)
    {
        ChatSDK.access$4(ChatSDK.this).setVisibility(8);
    }

    n.Animation()
    {
        this$0 = ChatSDK.this;
        super();
    }
}
