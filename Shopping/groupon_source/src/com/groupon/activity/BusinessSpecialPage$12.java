// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.ImageView;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class val.imageResId
    implements Runnable
{

    final BusinessSpecialPage this$0;
    final int val$imageResId;
    final ImageView val$imageView;

    public void run()
    {
        val$imageView.setImageResource(val$imageResId);
    }

    ()
    {
        this$0 = final_businessspecialpage;
        val$imageView = imageview;
        val$imageResId = I.this;
        super();
    }
}
