// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.boldchat.sdk.utils.DrawableReadyListener;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatListViewHistory

class val.h2
    implements DrawableReadyListener
{

    final val.h2 this$1;
    final val.h2 val$h2;
    final Object val$tag;

    public void onDrawableLoadFailed(String s)
    {
        val$h2.h2.setVisibility(8);
    }

    public void onDrawableReady(String s, Drawable drawable)
    {
        if (val$tag == val$h2.h2.getTag())
        {
            val$h2.h2.setVisibility(0);
            val$h2.h2.setImageDrawable(drawable);
        }
    }

    ()
    {
        this$1 = final_;
        val$tag = obj;
        val$h2 = val.h2.this;
        super();
    }
}
