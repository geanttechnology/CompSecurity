// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            NetworkCallback, PrefHelper, ServerResponse

public static class 
    implements NetworkCallback
{

    private int connectionStatus;

    public void finished(ServerResponse serverresponse)
    {
        if (serverresponse == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        String s;
        connectionStatus = serverresponse.getStatusCode();
        s = serverresponse.getTag();
        if (connectionStatus != 465) goto _L2; else goto _L1
_L1:
        PrefHelper.access$202(false);
        Log.i("Branch Debug", "======= Server is not listening =======");
_L3:
        PrefHelper.access$302(false);
        return;
_L2:
label0:
        {
            if (connectionStatus < 400 || connectionStatus >= 500)
            {
                break label0;
            }
            if (serverresponse.getObject() != null && serverresponse.getObject().has("error") && serverresponse.getObject().getJSONObject("error").has("message"))
            {
                Log.i("BranchSDK", (new StringBuilder()).append("Branch API Error: ").append(serverresponse.getObject().getJSONObject("error").getString("message")).toString());
            }
        }
          goto _L3
        if (connectionStatus == 200) goto _L5; else goto _L4
_L4:
        if (connectionStatus != -1009)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        Log.i("BranchSDK", "Branch API Error: poor network connectivity. Please try again later.");
          goto _L3
        try
        {
            Log.i("BranchSDK", "Trouble reaching server. Please try again in a few minutes.");
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponse serverresponse)
        {
            serverresponse.printStackTrace();
            return;
        }
          goto _L3
_L5:
        if (!s.equals("t_debug_connect")) goto _L3; else goto _L6
_L6:
        PrefHelper.access$202(true);
        Log.i("Branch Debug", "======= Connected to Branch Remote Debugger =======");
          goto _L3
    }

    public int getConnectionStatus()
    {
        return connectionStatus;
    }

    public ()
    {
    }
}
