// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.Bundle;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.InvalidShareCallerException;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            TumblrHelper, FbHelper, PinterestHelper, ExtServiceConnectInterface, 
//            ExtServiceUserInfoInterface, FBConnectCallback

public class ExtServiceConnectManager
{

    static ExtServiceConnectManager gShareManager = null;
    ExtServiceConnectInterface callback;
    TumblrHelper tumblrHelper;

    ExtServiceConnectManager()
    {
        tumblrHelper = new TumblrHelper();
    }

    public static ExtServiceConnectManager getGlobalConnectManager()
    {
        if (gShareManager == null)
        {
            gShareManager = new ExtServiceConnectManager();
        }
        return gShareManager;
    }

    public void fbGetUserInfo(ExtServiceUserInfoInterface extserviceuserinfointerface)
    {
        FbHelper.getInstance().getMe(extserviceuserinfointerface);
    }

    public void fbLink(PMFragment pmfragment, int i, int j, final ExtServiceConnectInterface callback)
    {
        FbHelper.getInstance().link(pmfragment, i, j, new FBConnectCallback() {

            final ExtServiceConnectManager this$0;
            final ExtServiceConnectInterface val$callback;

            public void error(PMApiError pmapierror)
            {
                callback.error(pmapierror);
            }

            public void success(int k, String s, String s1)
            {
                Bundle bundle = new Bundle();
                bundle.putString("TOKEN", s);
                bundle.putString("EXPIRY_DATE", s1);
                callback.success(k, bundle);
            }

            
            {
                this$0 = ExtServiceConnectManager.this;
                callback = extserviceconnectinterface;
                super();
            }
        });
    }

    public void fbUnlink()
    {
        FbHelper.getInstance().logout();
        PMApplicationSession.GetPMSession().clearFacebookInfo();
    }

    public void logout()
    {
        fbUnlink();
        tmUnlink();
        twUnlink();
    }

    public void pinterestLink(PMFragment pmfragment)
    {
        pmfragment.getActivity();
        PinterestHelper.getInstance().connect(pmfragment);
    }

    public void pinterestLink(PMFragment pmfragment, ExtServiceConnectInterface extserviceconnectinterface)
    {
        callback = extserviceconnectinterface;
        pmfragment = pmfragment.getActivity();
        PinterestHelper.getInstance().connect(pmfragment, extserviceconnectinterface);
    }

    public void pinterestUnlink()
    {
        PMApplicationSession.GetPMSession().clearPinterestInfo();
    }

    public void tmUnlink()
    {
        PMApplicationSession.GetPMSession().clearTumblrInfo();
    }

    public void tumblrLink(Object obj, ExtServiceConnectInterface extserviceconnectinterface)
    {
        try
        {
            callback = extserviceconnectinterface;
            tumblrHelper.link(TumblrHelper.EXTERNAL_SERVICE_TYPE.TUMBLR, obj, callback);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((InvalidShareCallerException) (obj)).printStackTrace();
        }
    }

    public void twUnlink()
    {
        PMApplicationSession.GetPMSession().clearTwitterInfo();
    }

    public void twitterLink(Object obj, ExtServiceConnectInterface extserviceconnectinterface)
    {
        try
        {
            callback = extserviceconnectinterface;
            tumblrHelper.link(TumblrHelper.EXTERNAL_SERVICE_TYPE.TWITTER, obj, callback);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((InvalidShareCallerException) (obj)).printStackTrace();
        }
    }

}
