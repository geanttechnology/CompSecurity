// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.telephony.SmsManager;

// Referenced classes of package co.vine.android.util:
//            CrashUtil

public class SMSUtil
{

    public SMSUtil()
    {
    }

    public static boolean sendSMS(String s, String s1)
    {
        SmsManager smsmanager = SmsManager.getDefault();
        String s2 = s1;
        if (s1.length() > 140)
        {
            s2 = s1.substring(0, 140);
            CrashUtil.log("Message is truncated.");
        }
        if (smsmanager != null)
        {
            try
            {
                smsmanager.sendTextMessage(s, null, s2, null, null);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                CrashUtil.logException(s, (new StringBuilder()).append("Failed to send: {").append(s2).append("}").toString(), new Object[0]);
            }
            return true;
        } else
        {
            return false;
        }
    }
}
