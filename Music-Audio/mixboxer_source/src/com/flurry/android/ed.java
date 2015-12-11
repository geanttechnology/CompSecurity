// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudLoginResponseHandler;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            AppCloudUser, AppCloudResponse, AppCloudResponseHandler, FlurryAppCloudRequestManager, 
//            ef, gq, ap, bt, 
//            fw, fb

final class ed
    implements AppCloudLoginResponseHandler
{

    private HashMap ga;
    private gq gb;
    private AppCloudResponseHandler gc;

    ed(HashMap hashmap, gq gq1, AppCloudResponseHandler appcloudresponsehandler)
    {
        ga = hashmap;
        gb = gq1;
        gc = appcloudresponsehandler;
        super();
    }

    public final void onError(AppCloudError appclouderror)
    {
        Log.w("FlurryAppCloudRequestManager", (new StringBuilder()).append("RELOGIN FAILED DUE TO : ").append(appclouderror.getErrorCode()).append(" : ").append(appclouderror.getErrorMessage()).toString());
        AppCloudUser.setCurrentUser(null);
        try
        {
            appclouderror = new AppCloudResponse(new JSONObject("{code:\"400\",note:\"invalid user session\"}"));
            gc.handleResponse(appclouderror);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudError appclouderror)
        {
            appclouderror.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudError appclouderror)
        {
            appclouderror.printStackTrace();
        }
    }

    public final void onOperationSucceed(AppCloudUser appclouduser)
    {
        Log.w("FlurryAppCloudRequestManager", (new StringBuilder()).append("RELOGIN SUCCEED, new APPCLOUD_USER_SESSION = ").append(FlurryAppCloudRequestManager.UserSession).toString());
        ga.remove(FlurryAppCloudRequestManager.ap());
        FlurryAppCloudRequestManager.b(ga);
        ef.gd[gb.ordinal()];
        JVM INSTR tableswitch 1 4: default 186
    //                   1 88
    //                   2 117
    //                   3 140
    //                   4 163;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        (new ap()).execute(new HashMap[] {
            ga
        });
        return;
_L3:
        try
        {
            (new bt()).execute(new HashMap[] {
                ga
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AppCloudUser appclouduser)
        {
            appclouduser.printStackTrace();
            return;
        }
_L4:
        (new fw()).execute(new HashMap[] {
            ga
        });
        return;
_L5:
        (new fb()).execute(new HashMap[] {
            ga
        });
        return;
_L1:
    }
}
