// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.DRMMetadataInfo;
import com.adobe.mediacore.MediaPlayer;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer

class this._cls0
    implements com.adobe.mediacore.ntListener
{

    final PrimeTimePlayer this$0;

    public void onDRMMetadata(DRMMetadataInfo drmmetadatainfo)
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).drmMetaDataAvailable(PrimeTimePlayer.access$000(PrimeTimePlayer.this).getDRMManager(), drmmetadatainfo.getDRMMetadata());
        }
        switch (.SwitchMap.com.comcast.playerplatform.primetime.android.enums.DrmWorkflow[PrimeTimePlayer.access$2100(PrimeTimePlayer.this).getDrmWorkflow().ordinal()])
        {
        default:
            PrimeTimePlayer.access$2500(PrimeTimePlayer.this);
            return;

        case 1: // '\001'
            PrimeTimePlayer.access$2200(PrimeTimePlayer.this, drmmetadatainfo);
            return;

        case 2: // '\002'
            PrimeTimePlayer.access$2300(PrimeTimePlayer.this);
            return;

        case 3: // '\003'
            PrimeTimePlayer.access$2400(PrimeTimePlayer.this, drmmetadatainfo);
            break;
        }
    }

    ()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}
