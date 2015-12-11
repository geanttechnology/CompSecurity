// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.widget.ImageView;
import com.groupon.util.Function0;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view:
//            DealDetailsTemporaryImage

class val.callback
    implements Callback
{

    final DealDetailsTemporaryImage this$0;
    final Function0 val$callback;

    public void onError(ImageView imageview)
    {
        if (val$callback != null)
        {
            val$callback.execute();
        }
    }

    public void onSuccess(ImageView imageview)
    {
        if (val$callback != null)
        {
            val$callback.execute();
        }
    }

    ()
    {
        this$0 = final_dealdetailstemporaryimage;
        val$callback = Function0.this;
        super();
    }
}
