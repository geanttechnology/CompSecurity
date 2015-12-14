// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PhoneVerificationHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.identity.auth.device:
//            MAPSmsReceiver

class val.intent
    implements Runnable
{

    final MAPSmsReceiver this$0;
    final Intent val$intent;

    public void run()
    {
        if (val$intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
        {
            Object obj = val$intent.getExtras();
            if (obj != null)
            {
                Object aobj[] = (Object[])((Bundle) (obj)).get("pdus");
                SmsMessage asmsmessage[] = new SmsMessage[aobj.length];
                obj = null;
                StringBuilder stringbuilder = new StringBuilder();
                for (int i = 0; i < asmsmessage.length; i++)
                {
                    asmsmessage[i] = SmsMessage.createFromPdu((byte[])aobj[i]);
                    obj = asmsmessage[i].getOriginatingAddress();
                    stringbuilder.append(asmsmessage[i].getMessageBody());
                }

                String s = stringbuilder.toString();
                MAPSmsReceiver.access$000();
                (new StringBuilder("Receiving message from: ")).append(((String) (obj))).append(". Message body:").append(s).toString();
                obj = PhoneVerificationHelper.parsePVTinyURLFromSMS(s);
                if (obj != null)
                {
                    MAPSmsReceiver.access$100(MAPSmsReceiver.this).incrementCounter("MOA:GetValidUrlFromSMS");
                    try
                    {
                        obj = (HttpURLConnection)((URL) (obj)).openConnection();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        MAPLog.logAndReportError(MAPSmsReceiver.access$000(), MAPSmsReceiver.access$100(MAPSmsReceiver.this), "IOException happens when trying to open Connection", "OpenTinyURLConnectionIOException");
                        return;
                    }
                    obj = PhoneVerificationHelper.resolveTinyURLRedirect(((HttpURLConnection) (obj)), MAPSmsReceiver.access$100(MAPSmsReceiver.this));
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        MAPSmsReceiver.access$100(MAPSmsReceiver.this).incrementCounter("MOA:CannotResolveTinyUrl");
                        return;
                    }
                    obj = PhoneVerificationHelper.getPhoneVerificationUrlFromDeepLinkUrl(((String) (obj)), MAPSmsReceiver.access$100(MAPSmsReceiver.this));
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        MAPLog.i(MAPSmsReceiver.access$000(), "Finished parsing the url from SMS");
                        MAPSmsReceiver.access$200(MAPSmsReceiver.this, ((String) (obj)));
                        return;
                    }
                }
            }
        }
    }

    cationHelper()
    {
        this$0 = final_mapsmsreceiver;
        val$intent = Intent.this;
        super();
    }
}
