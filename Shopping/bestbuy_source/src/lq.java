// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.exacttarget.etpushsdk.ETException;
import com.exacttarget.etpushsdk.ETPush;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class lq
{

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            if (i > 0)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append((String)list.get(i));
        }

        return stringbuilder.toString();
    }

    public static ArrayList a(Context context)
    {
        ArrayList arraylist = new ArrayList();
        context = b(context);
        if (context.isEmpty())
        {
            return new ArrayList();
        } else
        {
            arraylist.addAll(Arrays.asList(context.split(" ")));
            return arraylist;
        }
    }

    public static void a(Application application, String s)
    {
        String s2 = application.getString(0x7f080192);
        String s1 = application.getString(0x7f080191);
        if (na.b)
        {
            s2 = application.getString(0x7f08016b);
            s1 = application.getString(0x7f08016a);
        }
        ETPush.readyAimFire((new com.exacttarget.etpushsdk.ETPushConfig.Builder(application)).setEtAppId(s2).setAccessToken(s1).setGcmSenderId(application.getString(0x7f0801b7)).setAnalyticsEnabled(true).setPiAnalyticsEnabled(true).setLocationEnabled(false).setCloudPagesEnabled(false).setLogLevel(3).build());
_L1:
        return;
        application;
        if (ETPush.getLogLevel() <= 6)
        {
            kf.a(s, application);
            return;
        }
          goto _L1
    }

    public static void a(Context context, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(a(context));
        if (!arraylist.contains(s))
        {
            arraylist.add(0, s);
            context.getSharedPreferences("sharedPrefs", 0).edit().putString("pushnotificationsSelectedCatIds", a(((List) (arraylist)))).commit();
        }
    }

    public static void a(Context context, ArrayList arraylist)
    {
        Boolean boolean1;
        Object obj;
        obj = nb.a().c();
        arraylist = Boolean.valueOf(((SharedPreferences) (obj)).getBoolean(context.getResources().getString(0x7f08004b), false));
        boolean1 = Boolean.valueOf(((SharedPreferences) (obj)).getBoolean(context.getResources().getString(0x7f08003e), false));
        obj = Boolean.valueOf(((SharedPreferences) (obj)).getBoolean(context.getResources().getString(0x7f08008a), false));
        if (!arraylist.booleanValue() && !boolean1.booleanValue() && !((Boolean) (obj)).booleanValue())
        {
            ETPush.pushManager().disablePush();
            context = ETPush.pushManager().getTags().iterator();
            do
            {
                ETPush.pushManager().removeTag((String)context.next());
            } while (context.hasNext());
            return;
        }
        try
        {
            ETPush.pushManager().enablePush();
            if (arraylist.booleanValue())
            {
                ETPush.pushManager().addTag(context.getString(0x7f0802c1));
            }
            if (boolean1.booleanValue())
            {
                ETPush.pushManager().addTag(context.getString(0x7f08016f));
            }
            if (((Boolean) (obj)).booleanValue())
            {
                ETPush.pushManager().addTag(context.getString(0x7f080388));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
    }

    public static String b(Context context)
    {
        return context.getSharedPreferences("sharedPrefs", 0).getString("pushnotificationsSelectedCatIds", "");
    }

    public static void b(Context context, String s)
    {
        ArrayList arraylist = a(context);
        arraylist.remove(s);
        context.getSharedPreferences("sharedPrefs", 0).edit().putString("pushnotificationsSelectedCatIds", a(arraylist)).commit();
    }

    public static void c(Context context)
    {
        context.getSharedPreferences("sharedPrefs", 0).edit().putString("pushnotificationsSelectedCatIds", "").commit();
    }
}
