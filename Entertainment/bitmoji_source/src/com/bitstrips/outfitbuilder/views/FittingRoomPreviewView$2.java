// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.widget.ImageView;
import com.squareup.picasso.Callback;
import java.lang.ref.WeakReference;

// Referenced classes of package com.bitstrips.outfitbuilder.views:
//            FittingRoomPreviewView

class val.weakActivity
    implements Callback
{

    final FittingRoomPreviewView this$0;
    final ImageView val$imageView;
    final WeakReference val$weakActivity;

    public void onError()
    {
        stener stener = (stener)val$weakActivity.get();
        if (stener != null)
        {
            stener.onAssetLoadingError();
        }
    }

    public void onSuccess()
    {
        FittingRoomPreviewView.access$000(FittingRoomPreviewView.this, val$imageView);
    }

    stener()
    {
        this$0 = final_fittingroompreviewview;
        val$imageView = imageview;
        val$weakActivity = WeakReference.this;
        super();
    }
}
