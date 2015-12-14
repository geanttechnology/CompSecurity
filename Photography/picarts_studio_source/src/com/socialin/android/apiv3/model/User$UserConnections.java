// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.text.TextUtils;

// Referenced classes of package com.socialin.android.apiv3.model:
//            FbConnection, TwitterConnection, InstagramConnection

public class 
{

    private static final FbConnection emptyFbConnection = new FbConnection();
    private static final InstagramConnection emptyInstagramConnection = new InstagramConnection();
    private static final TwitterConnection emptyTwitterConnection = new TwitterConnection();
    private FbConnection fbConnection;
    private InstagramConnection instagramConnection;
    private TwitterConnection twitterConnection;

    public void connectToFb(FbConnection fbconnection)
    {
        if (fbconnection == null)
        {
            fbConnection = emptyFbConnection;
            return;
        } else
        {
            fbConnection = fbconnection;
            return;
        }
    }

    public void connectToInstagram(InstagramConnection instagramconnection)
    {
        if (instagramconnection == null)
        {
            instagramConnection = emptyInstagramConnection;
            return;
        } else
        {
            instagramConnection = instagramconnection;
            return;
        }
    }

    public void connectToTwitter(TwitterConnection twitterconnection)
    {
        if (twitterconnection == null)
        {
            twitterConnection = emptyTwitterConnection;
            return;
        } else
        {
            twitterConnection = twitterconnection;
            return;
        }
    }

    public void disconnectFb()
    {
        fbConnection = emptyFbConnection;
    }

    public void disconnectInstagram()
    {
        instagramConnection = emptyInstagramConnection;
    }

    public void disconnectTwitter()
    {
        twitterConnection = emptyTwitterConnection;
    }

    public FbConnection getFbConnection()
    {
        return fbConnection;
    }

    public InstagramConnection getInstagramConnection()
    {
        if (instagramConnection == null)
        {
            return emptyInstagramConnection;
        } else
        {
            return instagramConnection;
        }
    }

    public TwitterConnection getTwitterConnection()
    {
        if (twitterConnection == null)
        {
            return emptyTwitterConnection;
        } else
        {
            return twitterConnection;
        }
    }

    public boolean isEmptyFb()
    {
        return fbConnection == null || fbConnection == emptyFbConnection || TextUtils.isEmpty(fbConnection.token);
    }

    public boolean isEmptyInstagram()
    {
        return instagramConnection == null || instagramConnection == emptyInstagramConnection || TextUtils.isEmpty(instagramConnection.token);
    }

    public boolean isEmptyTwitter()
    {
        return twitterConnection == null || twitterConnection == emptyTwitterConnection;
    }


    public ()
    {
    }
}
