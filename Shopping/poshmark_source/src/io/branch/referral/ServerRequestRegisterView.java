// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import io.branch.indexing.BranchUniversalObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, PrefHelper, SystemObserver, BranchError, 
//            ServerResponse, Branch

class ServerRequestRegisterView extends ServerRequest
{

    io.branch.indexing.BranchUniversalObject.RegisterViewStatusListener callback_;

    public ServerRequestRegisterView(Context context, BranchUniversalObject branchuniversalobject, SystemObserver systemobserver, io.branch.indexing.BranchUniversalObject.RegisterViewStatusListener registerviewstatuslistener)
    {
        super(context, Defines.RequestPath.RegisterView.getPath());
        callback_ = registerviewstatuslistener;
        try
        {
            setPost(createContentViewJson(branchuniversalobject, systemobserver));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        constructError_ = true;
    }

    private JSONObject createContentViewJson(BranchUniversalObject branchuniversalobject, SystemObserver systemobserver)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        Object obj = (new StringBuilder()).append("Android ").append(android.os.Build.VERSION.SDK_INT).toString();
        String s = prefHelper_.getSessionID();
        jsonobject.put(Defines.Jsonkey.OS.getKey(), obj);
        jsonobject.put(Defines.Jsonkey.SessionID.getKey(), s);
        jsonobject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
        obj = systemobserver.getUniqueID(prefHelper_.getExternDebug());
        if (!((String) (obj)).equals("bnc_no_value") && systemobserver.hasRealHardwareId())
        {
            jsonobject.put(Defines.Jsonkey.HardwareID.getKey(), obj);
        }
        systemobserver = systemobserver.getAppVersion();
        if (!systemobserver.equals("bnc_no_value"))
        {
            jsonobject.put(Defines.Jsonkey.AppVersion.getKey(), systemobserver);
        }
        systemobserver = new JSONObject();
        systemobserver.put(Defines.Jsonkey.ContentKeyWords.getKey(), branchuniversalobject.getKeywordsJsonArray());
        systemobserver.put(Defines.Jsonkey.PublicallyIndexable.getKey(), branchuniversalobject.isPublicallyIndexable());
        obj = branchuniversalobject.getCanonicalIdentifier();
        if (obj != null && ((String) (obj)).trim().length() > 0)
        {
            systemobserver.put(Defines.Jsonkey.CanonicalIdentifier.getKey(), obj);
        }
        obj = branchuniversalobject.getTitle();
        if (obj != null && ((String) (obj)).trim().length() > 0)
        {
            systemobserver.put(Defines.Jsonkey.ContentTitle.getKey(), branchuniversalobject.getTitle());
        }
        obj = branchuniversalobject.getDescription();
        if (obj != null && ((String) (obj)).trim().length() > 0)
        {
            systemobserver.put(Defines.Jsonkey.ContentDesc.getKey(), obj);
        }
        obj = branchuniversalobject.getImageUrl();
        if (obj != null && ((String) (obj)).trim().length() > 0)
        {
            systemobserver.put(Defines.Jsonkey.ContentImgUrl.getKey(), obj);
        }
        obj = branchuniversalobject.getType();
        if (obj != null && ((String) (obj)).trim().length() > 0)
        {
            systemobserver.put(Defines.Jsonkey.ContentType.getKey(), obj);
        }
        if (branchuniversalobject.getExpirationTime() > 0L)
        {
            systemobserver.put(Defines.Jsonkey.ContentExpiryTime.getKey(), branchuniversalobject.getExpirationTime());
        }
        jsonobject.put(Defines.Jsonkey.Params.getKey(), systemobserver);
        branchuniversalobject = branchuniversalobject.getMetadata();
        obj = branchuniversalobject.keySet();
        systemobserver = new JSONObject();
        Object obj1;
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); systemobserver.put((String)obj1, branchuniversalobject.get(obj1)))
        {
            obj1 = ((Iterator) (obj)).next();
        }

        jsonobject.put(Defines.Jsonkey.Metadata.getKey(), systemobserver);
        return jsonobject;
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public boolean handleErrors(Context context)
    {
        boolean flag = false;
        if (!super.doesAppHasInternetPermission(context))
        {
            if (callback_ != null)
            {
                callback_.onRegisterViewFinished(false, new BranchError("Unable to register content view", -102));
            }
            flag = true;
        }
        return flag;
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            callback_.onRegisterViewFinished(false, new BranchError((new StringBuilder()).append("Unable to register content view. ").append(s).toString(), i));
        }
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        if (callback_ != null)
        {
            callback_.onRegisterViewFinished(true, null);
        }
    }
}
