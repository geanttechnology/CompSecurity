// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, BranchLinkData, PrefHelper, Base64, 
//            BranchError, ServerResponse, Branch

class ServerRequestCreateUrl extends ServerRequest
{

    private static final String DEF_BASE_URL = "https://bnc.lt/a/";
    private Branch.BranchLinkCreateListener callback_;
    private boolean isAsync_;
    private BranchLinkData linkPost_;

    public ServerRequestCreateUrl(Context context, String s, int i, int j, Collection collection, String s1, String s2, 
            String s3, String s4, Branch.BranchLinkCreateListener branchlinkcreatelistener, boolean flag)
    {
        super(context, Defines.RequestPath.GetURL.getPath());
        isAsync_ = true;
        callback_ = branchlinkcreatelistener;
        isAsync_ = flag;
        linkPost_ = new BranchLinkData();
        try
        {
            linkPost_.put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
            linkPost_.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
            linkPost_.put(Defines.Jsonkey.SessionID.getKey(), prefHelper_.getSessionID());
            if (!prefHelper_.getLinkClickID().equals("bnc_no_value"))
            {
                linkPost_.put(Defines.Jsonkey.LinkClickID.getKey(), prefHelper_.getLinkClickID());
            }
            linkPost_.putType(i);
            linkPost_.putDuration(j);
            linkPost_.putTags(collection);
            linkPost_.putAlias(s);
            linkPost_.putChannel(s1);
            linkPost_.putFeature(s2);
            linkPost_.putStage(s3);
            linkPost_.putParams(s4);
            setPost(linkPost_);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        constructError_ = true;
    }

    public ServerRequestCreateUrl(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
        isAsync_ = true;
    }

    private String generateLongUrlWithParams(String s)
    {
        String s1 = (new StringBuilder()).append(s).append("?").toString();
        Object obj = linkPost_.getTags();
        s = s1;
        if (obj != null)
        {
            obj = ((Collection) (obj)).iterator();
            do
            {
                s = s1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                s = (String)((Iterator) (obj)).next();
                if (s != null && s.length() > 0)
                {
                    s1 = (new StringBuilder()).append(s1).append(Defines.LinkParam.Tags).append("=").append(s).append("&").toString();
                }
            } while (true);
        }
        obj = linkPost_.getAlias();
        s1 = s;
        if (obj != null)
        {
            s1 = s;
            if (((String) (obj)).length() > 0)
            {
                s1 = (new StringBuilder()).append(s).append(Defines.LinkParam.Alias).append("=").append(((String) (obj))).append("&").toString();
            }
        }
        obj = linkPost_.getChannel();
        s = s1;
        if (obj != null)
        {
            s = s1;
            if (((String) (obj)).length() > 0)
            {
                s = (new StringBuilder()).append(s1).append(Defines.LinkParam.Channel).append("=").append(((String) (obj))).append("&").toString();
            }
        }
        obj = linkPost_.getFeature();
        s1 = s;
        if (obj != null)
        {
            s1 = s;
            if (((String) (obj)).length() > 0)
            {
                s1 = (new StringBuilder()).append(s).append(Defines.LinkParam.Feature).append("=").append(((String) (obj))).append("&").toString();
            }
        }
        obj = linkPost_.getStage();
        s = s1;
        if (obj != null)
        {
            s = s1;
            if (((String) (obj)).length() > 0)
            {
                s = (new StringBuilder()).append(s1).append(Defines.LinkParam.Stage).append("=").append(((String) (obj))).append("&").toString();
            }
        }
        long l = linkPost_.getType();
        s = (new StringBuilder()).append(s).append(Defines.LinkParam.Type).append("=").append(l).append("&").toString();
        l = linkPost_.getDuration();
        s1 = (new StringBuilder()).append(s).append(Defines.LinkParam.Duration).append("=").append(l).append("&").toString();
        obj = linkPost_.getParams();
        s = s1;
        if (obj != null)
        {
            s = s1;
            if (((String) (obj)).length() > 0)
            {
                s = Base64.encodeToString(((String) (obj)).getBytes(), 2);
                s = (new StringBuilder()).append(s1).append("source=android&data=").append(s).toString();
            }
        }
        return s;
    }

    private boolean hasUser()
    {
        return !prefHelper_.getIdentityID().equals("bnc_no_value");
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public BranchLinkData getLinkPost()
    {
        return linkPost_;
    }

    public String getLongUrl()
    {
        if (!prefHelper_.getUserURL().equals("bnc_no_value"))
        {
            return generateLongUrlWithParams(prefHelper_.getUserURL());
        } else
        {
            return generateLongUrlWithParams((new StringBuilder()).append("https://bnc.lt/a/").append(prefHelper_.getBranchKey()).toString());
        }
    }

    public void handleDuplicateURLError()
    {
        if (callback_ != null)
        {
            callback_.onLinkCreate(null, new BranchError("Trouble creating a URL.", -105));
        }
    }

    public boolean handleErrors(Context context)
    {
        if (!super.doesAppHasInternetPermission(context))
        {
            if (callback_ != null)
            {
                callback_.onLinkCreate(null, new BranchError("Trouble creating a URL.", -102));
            }
        } else
        if (isAsync_ || hasUser())
        {
            return false;
        }
        return true;
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            String s1 = getLongUrl();
            callback_.onLinkCreate(s1, new BranchError((new StringBuilder()).append("Trouble creating a URL. ").append(s).toString(), i));
        }
    }

    public boolean isAsync()
    {
        return isAsync_;
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        try
        {
            serverresponse = serverresponse.getObject().getString("url");
            if (callback_ != null)
            {
                callback_.onLinkCreate(serverresponse, null);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponse serverresponse)
        {
            serverresponse.printStackTrace();
        }
    }

    public void onUrlAvailable(String s)
    {
        if (callback_ != null)
        {
            callback_.onLinkCreate(s, null);
        }
    }
}
