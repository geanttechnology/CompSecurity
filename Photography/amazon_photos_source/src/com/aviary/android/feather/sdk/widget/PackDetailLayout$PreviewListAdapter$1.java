// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.ImageView;
import it.sephiroth.android.library.picasso.Callback;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            PackDetailLayout

class val.imageTag
    implements Callback
{

    final val.imageTag this$0;
    final int val$imageTag;
    final ImageView val$imageView;

    public void onError()
    {
    }

    public void onSuccess()
    {
        val$imageView.setTag(Integer.valueOf(val$imageTag));
    }

    Q()
    {
        this$0 = final_q;
        val$imageView = imageview;
        val$imageTag = I.this;
        super();
    }
}
