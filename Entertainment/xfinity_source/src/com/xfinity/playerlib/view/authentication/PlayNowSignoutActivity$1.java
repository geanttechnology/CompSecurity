// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.authentication;

import android.content.DialogInterface;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.model.user.UserManager;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;

// Referenced classes of package com.xfinity.playerlib.view.authentication:
//            PlayNowSignoutActivity

class this._cls0
    implements android.content.stener
{

    final PlayNowSignoutActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        try
        {
            if (PlayNowSignoutActivity.access$000(PlayNowSignoutActivity.this) != null)
            {
                PlayNowSignoutActivity.access$000(PlayNowSignoutActivity.this).deleteAllContent();
            }
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface) { }
        PlayNowSignoutActivity.access$100(PlayNowSignoutActivity.this).signOutUser();
        PlayNowSignoutActivity.access$200(PlayNowSignoutActivity.this).restartAppFlow(PlayNowSignoutActivity.this);
        finish();
    }

    ()
    {
        this$0 = PlayNowSignoutActivity.this;
        super();
    }
}
