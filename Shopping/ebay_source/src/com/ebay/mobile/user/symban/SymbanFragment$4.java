// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.view.animation.Animation;
import com.ebay.nautilus.domain.data.SymbanNotification;
import java.util.List;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanFragment, SymbanAdapter

class ion
    implements android.view.animation.onListener
{

    final SymbanFragment this$0;
    final SymbanAdapter val$adapter;
    final SymbanNotification val$notif;

    public void onAnimationEnd(Animation animation)
    {
        val$adapter.remove(val$notif);
        dismissingItems.remove(val$notif);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ion()
    {
        this$0 = final_symbanfragment;
        val$adapter = symbanadapter;
        val$notif = SymbanNotification.this;
        super();
    }
}
