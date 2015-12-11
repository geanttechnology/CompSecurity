// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.animation.Animation;
import com.ebay.android.widget.OnSizeRelativeLayout;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesMasterFragment

class val.show
    implements android.view.animation.er
{

    final MessagesMasterFragment this$0;
    final boolean val$show;

    public void onAnimationEnd(Animation animation)
    {
        animation = MessagesMasterFragment.access$300(MessagesMasterFragment.this);
        int i;
        if (val$show)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        animation.setVisibility(i);
        MessagesMasterFragment.access$402(MessagesMasterFragment.this, false);
        if (MessagesMasterFragment.access$500(MessagesMasterFragment.this) != null && MessagesMasterFragment.access$500(MessagesMasterFragment.this).booleanValue() != val$show)
        {
            MessagesMasterFragment.access$600(MessagesMasterFragment.this, MessagesMasterFragment.access$500(MessagesMasterFragment.this).booleanValue());
        }
        MessagesMasterFragment.access$502(MessagesMasterFragment.this, null);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        MessagesMasterFragment.access$202(MessagesMasterFragment.this, val$show);
    }

    er()
    {
        this$0 = final_messagesmasterfragment;
        val$show = Z.this;
        super();
    }
}
