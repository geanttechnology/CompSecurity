// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.DialogInterface;
import com.comcast.cim.downloads.DownloadServiceException;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            MobileDataWarningState, VideoStateController

class this._cls0
    implements android.content.stener
{

    final MobileDataWarningState this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            stateController.getPlayerDownloadServiceManager().setCellularDataThreshold(-1D);
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            dialoginterface.dismiss();
            stateController.getPlayerDownloadServiceManager().showCrashDialog(stateController.getActivityContext(), downloadserviceexception);
            return;
        }
        ((PlayerUserSettings)stateController.getUserManager().getUserSettings()).setUseCellularWhenAvailable(true);
        stateController.transitionToState(MobileDataWarningState.access$000(MobileDataWarningState.this));
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = MobileDataWarningState.this;
        super();
    }
}
