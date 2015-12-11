// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import com.comcast.cim.model.user.UserManager;
import com.penthera.virtuososdk.client.IServiceConnectedCallback;
import com.penthera.virtuososdk.client.ServiceException;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceManager

class this._cls0
    implements IServiceConnectedCallback
{

    final DownloadServiceManager this$0;

    public void connected()
    {
        DownloadServiceManager.access$000().debug("Initial connection to virtuoso service established");
        Object obj;
        try
        {
            DownloadServiceManager.access$100(DownloadServiceManager.this);
            DownloadServiceManager.access$200(DownloadServiceManager.this);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            DownloadServiceManager.access$000().error("ServiceException while setting up in connected() callback", ((Throwable) (obj)));
            return;
        }
        DownloadServiceManager.access$000().debug("Service settings setup & fetchFileList called");
        onDownloadServiceConnected();
        DownloadServiceManager.access$300(DownloadServiceManager.this).addUserManagerListener(DownloadServiceManager.this);
        obj = DownloadServiceManager.access$300(DownloadServiceManager.this).getUser();
        if (obj == null)
        {
            onUserLoggedOut();
        } else
        {
            onUserLoggedIn(((com.comcast.cim.model.user.User) (obj)), DownloadServiceManager.access$300(DownloadServiceManager.this).getUserSettings());
        }
        DownloadServiceManager.access$400(DownloadServiceManager.this);
    }

    llback()
    {
        this$0 = DownloadServiceManager.this;
        super();
    }
}
