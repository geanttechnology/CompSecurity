// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.view.View;
import android.widget.Button;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.downloads.DownloadServiceException;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsFragment

class this._cls0
    implements android.view.
{

    final DownloadsFragment this$0;

    public void onClick(View view)
    {
        if (pauseResumeButton.getVisibility() != 8) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            view = downloadsManager.getDownloadEngineStatus().status();
            if (view.equals(com.penthera.virtuososdk.loadEngineStatus.kVDE_Downloading))
            {
                downloadsManager.pauseDownloading();
                tempDisablePauseButton();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            LOG.error(view.getMessage(), view);
            loadingViewDelegate.onLoadingFailed();
            return;
        }
        if (!view.equals(com.penthera.virtuososdk.loadEngineStatus.kVDE_Paused)) goto _L1; else goto _L3
_L3:
        downloadsManager.resumeDownloading();
        tempDisablePauseButton();
        return;
    }

    dingViewDelegate()
    {
        this$0 = DownloadsFragment.this;
        super();
    }
}
