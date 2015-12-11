// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, WearableDataConnection, WearableDataRequest, WearableDataResponse, 
//            Config

final class WearableFunction
{

    private static boolean sendHitFlag = false;

    WearableFunction()
    {
    }

    protected static boolean isHandheldAppStarted()
    {
        boolean flag = false;
        long l;
        try
        {
            l = StaticMethods.getSharedPreferences().getLong("ADMS_Handheld_App_InstallDate", 0L);
        }
        catch (StaticMethods.NullContextException nullcontextexception)
        {
            StaticMethods.logWarningFormat("Wearable - Error getting install date of handheld app", new Object[0]);
            return false;
        }
        if (l != 0L)
        {
            flag = true;
        }
        return flag;
    }

    protected static byte[] retrieveData(String s, int i)
    {
        byte abyte0[] = null;
        if (StaticMethods.isWearableApp())
        {
            try
            {
                abyte0 = StaticMethods.getSharedContext().getApplicationContext();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logErrorFormat("Analytics - Error registering network receiver (%s)", new Object[] {
                    s.getMessage()
                });
                return null;
            }
            s = (WearableDataResponse.GetResponse)(new WearableDataConnection(abyte0)).send(WearableDataRequest.createGetRequest(s, i));
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.getResult();
            }
            abyte0 = s;
        }
        return abyte0;
    }

    protected static boolean sendAnalyticsRequest(String s, String s1, int i)
    {
label0:
        {
            if (StaticMethods.isWearableApp())
            {
                Context context;
                try
                {
                    context = StaticMethods.getSharedContext().getApplicationContext();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    StaticMethods.logErrorFormat("Analytics - Error registering network receiver (%s)", new Object[] {
                        s.getMessage()
                    });
                    return false;
                }
                s = (new WearableDataConnection(context)).send(WearableDataRequest.createPostRequest(s, s1, i));
                if (s == null || !s.isSuccess())
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    protected static void sendGenericRequest(String s, int i)
    {
        retrieveData(s, i);
    }

    protected static boolean sendThirdPartyRequest(String s, String s1, int i, String s2)
    {
label0:
        {
            if (StaticMethods.isWearableApp())
            {
                Context context;
                try
                {
                    context = StaticMethods.getSharedContext().getApplicationContext();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    StaticMethods.logErrorFormat("External Callback - Error registering network receiver (%s)", new Object[] {
                        s.getMessage()
                    });
                    return false;
                }
                s = (new WearableDataConnection(context)).send(WearableDataRequest.createThirdPartyRequest(s, s1, i, s2));
                if (s == null || !s.isSuccess())
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    protected static boolean shouldSendHit()
    {
        if (sendHitFlag)
        {
            return true;
        }
        if (Config.getApplicationType() != Config.ApplicationType.APPLICATION_TYPE_WEARABLE)
        {
            sendHitFlag = true;
            return true;
        }
        if (isHandheldAppStarted())
        {
            sendHitFlag = true;
            return true;
        } else
        {
            StaticMethods.logWarningFormat("Analytics - Failed to send the Wearable request, containing app should get launched before Wearable app.", new Object[0]);
            return false;
        }
    }

}
