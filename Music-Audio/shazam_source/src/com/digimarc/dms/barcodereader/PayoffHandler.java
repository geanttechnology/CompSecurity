// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.barcodereader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.util.Log;

public class PayoffHandler
{
    public static final class PayoffType extends Enum
    {

        private static final PayoffType $VALUES[];
        public static final PayoffType BRIGHTCOVE;
        public static final PayoffType DIAL;
        public static final PayoffType EMAIL;
        public static final PayoffType SMS;
        public static final PayoffType VIDEO;
        public static final PayoffType WEB;
        public static final PayoffType WIFI;
        public static final PayoffType YOUTUBE;

        public static PayoffType valueOf(String s)
        {
            return (PayoffType)Enum.valueOf(com/digimarc/dms/barcodereader/PayoffHandler$PayoffType, s);
        }

        public static PayoffType[] values()
        {
            return (PayoffType[])$VALUES.clone();
        }

        static 
        {
            WEB = new PayoffType("WEB", 0);
            VIDEO = new PayoffType("VIDEO", 1);
            YOUTUBE = new PayoffType("YOUTUBE", 2);
            SMS = new PayoffType("SMS", 3);
            DIAL = new PayoffType("DIAL", 4);
            WIFI = new PayoffType("WIFI", 5);
            BRIGHTCOVE = new PayoffType("BRIGHTCOVE", 6);
            EMAIL = new PayoffType("EMAIL", 7);
            $VALUES = (new PayoffType[] {
                WEB, VIDEO, YOUTUBE, SMS, DIAL, WIFI, BRIGHTCOVE, EMAIL
            });
        }

        private PayoffType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = "PayoffHandler";
    private static boolean mHasRequestedYoutube;

    public PayoffHandler()
    {
    }

    private static String[] commaSeperatedStringToArray(String s)
    {
        int i = 0;
        if (s != null && s.length() > 0)
        {
            String as2[] = s.split(", ");
            int j = as2.length;
            if (j > 0)
            {
                String as[] = new String[j];
                do
                {
                    s = as;
                    if (i >= j)
                    {
                        break;
                    }
                    as[i] = as2[i];
                    i++;
                } while (true);
            } else
            {
                String as1[] = new String[1];
                as1[0] = s;
                s = as1;
            }
            return s;
        } else
        {
            return null;
        }
    }

    public static PayoffType getPayoffType(String s)
    {
        String as[] = s.split("\\.");
        if (as.length > 0)
        {
            String s1 = as[as.length - 1];
            if (s1.length() >= 3 && (s1.toUpperCase().contains("MP4") || s1.toUpperCase().contains("MPG") || s1.toUpperCase().contains("3GP") || s1.toUpperCase().contains("WEBM")))
            {
                return PayoffType.VIDEO;
            }
        }
        if (s.toLowerCase().startsWith("tel:"))
        {
            return PayoffType.DIAL;
        }
        if (s.toLowerCase().startsWith("sms:") || s.toLowerCase().startsWith("smsto:"))
        {
            return PayoffType.SMS;
        }
        if (s.toLowerCase().startsWith("wifi:"))
        {
            return PayoffType.WIFI;
        }
        if (s.toLowerCase().contains("youtube.com"))
        {
            return PayoffType.YOUTUBE;
        }
        if (s.toLowerCase().contains("bcove.me") || s.toLowerCase().contains("brightcove.com"))
        {
            return PayoffType.BRIGHTCOVE;
        }
        if (s.toLowerCase().startsWith("mailto:"))
        {
            return PayoffType.EMAIL;
        } else
        {
            return PayoffType.WEB;
        }
    }

    public static void launchGoogleProductSearch(Context context, String s, Activity activity)
    {
        activity = new Intent(context, activity.getClass());
        activity.putExtra("url", Uri.parse((new StringBuilder("http://www.google.com/search?q=")).append(s).append("&tbs=shop:1").toString()).toString());
        try
        {
            context.startActivity(activity);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("PayoffHandler", "Failed to launch google product search");
        }
    }

    public static boolean launchPayoff(Context context, String s, Activity activity)
    {
        return launchPayoffAsType(context, s, null, activity);
    }

    public static boolean launchPayoffAsType(Context context, String s, PayoffType payofftype, Activity activity)
    {
        PayoffType payofftype1;
        String s1;
        s1 = sanitizeScheme(s);
        payofftype1 = payofftype;
        if (payofftype == null)
        {
            payofftype1 = getPayoffType(s1);
        }
        static class _cls1
        {

            static final int $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[];

            static 
            {
                $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType = new int[PayoffType.values().length];
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.WEB.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.DIAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.SMS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.VIDEO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.WIFI.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.YOUTUBE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.BRIGHTCOVE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$digimarc$dms$barcodereader$PayoffHandler$PayoffType[PayoffType.EMAIL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.digimarc.dms.barcodereader.PayoffHandler.PayoffType[payofftype1.ordinal()];
        JVM INSTR tableswitch 1 8: default 76
    //                   1 78
    //                   2 176
    //                   3 205
    //                   4 271
    //                   5 76
    //                   6 299
    //                   7 325
    //                   8 360;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7 _L8
_L1:
        return false;
_L2:
        if (s1.startsWith("http://") || s1.startsWith("https://"))
        {
            payofftype = new Intent(context, activity.getClass());
            payofftype.putExtra("url", Uri.parse(s1).toString());
            payofftype.addFlags(0x10000000);
            s = payofftype;
            if (getPayoffType(s1) == PayoffType.YOUTUBE)
            {
                mHasRequestedYoutube = true;
                s = payofftype;
            }
        } else
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        }
        return startActivity(context, s);
_L3:
        s = new Intent("android.intent.action.DIAL");
        s.setData(Uri.parse(s1.toLowerCase()));
        return startActivity(context, s);
_L4:
        s = new Intent("android.intent.action.SENDTO");
        payofftype = s1.split(":");
        s.setData(Uri.parse((new StringBuilder("smsto:")).append(payofftype[1]).toString()));
        if (payofftype.length > 2)
        {
            s.putExtra("sms_body", payofftype[2]);
        }
        return startActivity(context, s);
_L5:
        s = new Intent("android.intent.action.VIEW");
        s.setDataAndType(Uri.parse(s1), "video/*");
        return startActivity(context, s);
_L6:
        if (!mHasRequestedYoutube)
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s1)));
            return true;
        }
          goto _L1
_L7:
        s = new Intent("android.intent.action.VIEW");
        s.setDataAndType(Uri.parse(s1), "text/html");
        s.addFlags(0x40080000);
        return startActivity(context, s);
_L8:
        s = MailTo.parse(s);
        payofftype = commaSeperatedStringToArray(s.getTo());
        activity = commaSeperatedStringToArray(s.getCc());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        if (payofftype != null)
        {
            intent.putExtra("android.intent.extra.EMAIL", payofftype);
        }
        if (activity != null)
        {
            intent.putExtra("android.intent.extra.CC", activity);
        }
        intent.putExtra("android.intent.extra.SUBJECT", s.getSubject());
        intent.putExtra("android.intent.extra.TEXT", s.getBody());
        return startActivity(context, intent);
    }

    public static String sanitizeScheme(String s)
    {
        String as[] = s.split(":");
        if (as.length == 2)
        {
            s = (new StringBuilder()).append(as[0].toLowerCase()).append(":").append(as[1]).toString();
        }
        return s;
    }

    private static boolean startActivity(Context context, Intent intent)
    {
        try
        {
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean urlIsValid(String s)
    {
        return s.split("://").length == 2;
    }
}
