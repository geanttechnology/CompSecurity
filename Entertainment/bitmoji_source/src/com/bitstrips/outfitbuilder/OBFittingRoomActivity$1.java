// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;

// Referenced classes of package com.bitstrips.outfitbuilder:
//            OBFittingRoomActivity

class this._cls0 extends BroadcastReceiver
{

    final OBFittingRoomActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        OBFittingRoomActivity.access$000(OBFittingRoomActivity.this).setVisibility(8);
        int i = intent.getIntExtra("com.bitstrips.outfitbuilder.saveOutfitResponseCode", -1);
        if (i == 0)
        {
            OBFittingRoomActivity.access$100(OBFittingRoomActivity.this);
        } else
        if (i == 1)
        {
            OBFittingRoomActivity.access$200(OBFittingRoomActivity.this);
            return;
        }
    }

    _cls9()
    {
        this$0 = OBFittingRoomActivity.this;
        super();
    }
}
