// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.ebay.common.util.EnvironmentUtils;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class EbayUtil
{

    private static final String LOG_TAG = "Utils";

    public EbayUtil()
    {
    }

    public static List arrayToList(String as[])
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < as.length; i++)
        {
            arraylist.add(as[i]);
        }

        return arraylist;
    }

    public static byte[] decrypt(byte abyte0[], SecretKeySpec secretkeyspec)
    {
        return encryptDecrypt(abyte0, secretkeyspec, 2);
    }

    public static boolean deviceSupportsC2dm()
    {
        boolean flag = isC2dmRegistrarPresent();
        if (EnvironmentUtils.isBlackberry())
        {
            return flag;
        }
        if (flag && DeviceConfiguration.getAsync().get(DcsBoolean.C2DM))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public static byte[] encrypt(byte abyte0[], SecretKeySpec secretkeyspec)
    {
        return encryptDecrypt(abyte0, secretkeyspec, 1);
    }

    private static byte[] encryptDecrypt(byte abyte0[], SecretKeySpec secretkeyspec, int i)
    {
        try
        {
            byte abyte1[] = new byte[abyte0.length + 256];
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(i, secretkeyspec);
            i = cipher.update(abyte0, 0, abyte0.length, abyte1, 0);
            i += cipher.doFinal(abyte1, i);
            abyte0 = new byte[i];
            System.arraycopy(abyte1, 0, abyte0, 0, i);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.e("Utils", (new StringBuilder()).append("Exception encrypting/decrypting data ").append(abyte0.getMessage()).toString());
            return null;
        }
        return abyte0;
    }

    public static String flattenString(List list)
    {
        if (list == null || list.size() == 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            stringbuilder.append((String)list.get(i));
            stringbuilder.append('~');
        }

        return stringbuilder.toString();
    }

    public static String flattenString(List list, String s)
    {
        if (list == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = list.size() - 1;
        for (int i = 0; i <= j; i++)
        {
            stringbuilder.append((String)list.get(i));
            if (i < j)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

    public static boolean isC2DMActive(Context context, String s, String s1)
    {
        boolean flag = false;
        if (EnvironmentUtils.isBlackberry())
        {
            flag = isPushActiveInternal(context, s, NotificationUtil.getClientIdForNotificationType(com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.C2DM, s1));
        }
        boolean flag1 = flag;
        if (!flag)
        {
            flag1 = isPushActiveInternal(context, s, s1);
        }
        return flag1;
    }

    private static boolean isC2dmRegistrarPresent()
    {
        boolean flag1 = false;
        Object obj = new Intent("com.google.android.c2dm.intent.REGISTER");
        obj = MyApp.getApp().getPackageManager().queryIntentServices(((Intent) (obj)), 0);
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (((List) (obj)).size() > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean isGCMActive(Context context, String s, String s1)
    {
        return isPushActiveInternal(context, s, NotificationUtil.getClientIdForNotificationType(com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM, s1));
    }

    public static boolean isPushActive(Context context, String s, String s1)
    {
        return isGCMActive(context, s, s1) || isC2DMActive(context, s, s1);
    }

    private static boolean isPushActiveInternal(Context context, String s, String s1)
    {
        return (new NotificationPreferenceManager(context)).isUserActiveWithMdns(s, s1);
    }

    public static String[] listToArray(List list)
    {
        String as[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            as[i] = (String)list.get(i);
        }

        return as;
    }

    public static String makeSecureHash(String s)
    {
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Utils", (new StringBuilder()).append("Error computing password hash ").append(s.getMessage()).toString());
            return "";
        }
        messagedigest.update(s.getBytes(), 0, s.length());
        return (new BigInteger(1, messagedigest.digest())).toString(16);
    }

    public static Spannable removeUnderlinesFromHtmlLinks(String s)
    {
        UnderlineSpan underlinespan = new UnderlineSpan() {

            public void updateDrawState(TextPaint textpaint)
            {
                textpaint.setUnderlineText(false);
            }

        };
        s = (Spannable)Html.fromHtml(s);
        URLSpan aurlspan[] = (URLSpan[])s.getSpans(0, s.length(), android/text/style/URLSpan);
        int j = aurlspan.length;
        for (int i = 0; i < j; i++)
        {
            URLSpan urlspan = aurlspan[i];
            s.setSpan(underlinespan, s.getSpanStart(urlspan), s.getSpanEnd(urlspan), 0);
        }

        return s;
    }

    public static List unflattenString(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s))
        {
            s = s.split("\\~");
            int i = 0;
            while (i < s.length) 
            {
                if (s[i].length() > 0 && arraylist.indexOf(s[i]) < 0)
                {
                    arraylist.add(s[i]);
                }
                i++;
            }
        }
        return arraylist;
    }
}
