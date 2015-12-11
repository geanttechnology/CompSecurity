// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.UUID;

// Referenced classes of package android.support.v7:
//            ahk

class ahl
{
    public static class a extends Exception
    {

        public a()
        {
        }
    }


    public static String a(Context context)
    {
        try
        {
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ahk.a().b("Unable to resolve android ID", context);
            return null;
        }
        return context;
    }

    public static String b(Context context)
    {
label0:
        {
            try
            {
                if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0)
                {
                    break label0;
                }
                context = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ahk.a().b("Unable to resolve device ID", context);
                return null;
            }
            return context;
        }
        return null;
    }

    public static String c(Context context)
        throws a
    {
        context = AdvertisingIdClient.getAdvertisingIdInfo(context);
        if (context.isLimitAdTrackingEnabled())
        {
            throw new a();
        }
          goto _L1
        context;
        ahk.a().b("Error extracting advertising ID (note that event will still be sent), you likely need to include the google play lib in your project (http://developer.android.com/google/play-services/setup.html)", context);
_L3:
        return null;
_L1:
        context = context.getId();
        return context;
        context;
        ahk.a().b("Error extracting advertising ID, note that event will still be sent", context);
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static String d(Context context)
    {
        context = context.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[] {
            "aid"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        ahk.a().b("TRACK EVENT ERROR: attribution id could not be found?!", null);
        break MISSING_BLOCK_LABEL_102;
        String s = context.getString(context.getColumnIndex("aid"));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        context = s;
        if (s.trim().length() != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        ahk.a().b("TRACK EVENT : attribution is null/empty?!", null);
        return s;
        context;
        ahk.a().b("Error getting FB attribution id, perhaps its missing?", context);
        context = null;
        return context;
    }

    public static String e(Context context)
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences("nanTrackingPrefs", 0);
        String s = sharedpreferences.getString("nan_hash", null);
        context = s;
        if (s == null)
        {
            context = UUID.randomUUID().toString().replaceAll("-", "");
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("nan_hash", context);
            editor.commit();
        }
        return context;
    }
}
