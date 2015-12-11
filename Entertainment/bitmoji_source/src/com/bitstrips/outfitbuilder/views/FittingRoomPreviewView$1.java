// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.squareup.picasso.Callback;
import java.lang.ref.WeakReference;

// Referenced classes of package com.bitstrips.outfitbuilder.views:
//            FittingRoomPreviewView

class fit
    implements Callback
{

    final FittingRoomPreviewView this$0;
    final OBOutfit val$outfit;
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
        FittingRoomPreviewView.access$000(FittingRoomPreviewView.this, avatarPreviewImageView);
        stener stener = (stener)val$weakActivity.get();
        if (stener != null)
        {
            stener.onOutfitLoaded(val$outfit);
        }
    }

    stener()
    {
        this$0 = final_fittingroompreviewview;
        val$weakActivity = weakreference;
        val$outfit = OBOutfit.this;
        super();
    }
}
