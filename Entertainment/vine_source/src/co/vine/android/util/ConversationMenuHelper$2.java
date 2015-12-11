// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package co.vine.android.util:
//            ConversationMenuHelper

class this._cls0
    implements android.view.animation.er
{

    final ConversationMenuHelper this$0;

    public void onAnimationEnd(Animation animation)
    {
        ConversationMenuHelper.access$000(ConversationMenuHelper.this).setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ener()
    {
        this$0 = ConversationMenuHelper.this;
        super();
    }
}
