// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.instagram.h;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.s;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{

    private static String a[];
    private static Map b = new HashMap();
    private static final AtomicBoolean c = new AtomicBoolean();
    private static final AtomicBoolean d = new AtomicBoolean();

    public static SharedPreferences a(Context context)
    {
        return context.getSharedPreferences("contact.analytics.prefs", 0);
    }

    private static String a(String s1)
    {
        String s2;
        String s3;
        if (a == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        s3 = (String)b.get(s1);
        s2 = s3;
        if (s3 != null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        int j;
        as = a;
        j = as.length;
        i = 0;
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = as[i];
        if (!s1.contains(s2)) goto _L4; else goto _L3
_L3:
        b.put(s1, s2);
_L2:
        return s2;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        b.put(s1, "phone");
        return "phone";
        return "phone";
    }

    public static List a(ContentResolver contentresolver, int i)
    {
        ArrayList arraylist = new ArrayList();
        int j = android.os.Build.VERSION.SDK_INT;
        contentresolver = contentresolver.query(android.provider.ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] {
            "data1", "data2"
        }, "contact_id=?", new String[] {
            String.valueOf(i)
        }, null);
        if (contentresolver.moveToFirst())
        {
            i = contentresolver.getColumnIndex("data1");
            for (; !contentresolver.isAfterLast(); contentresolver.moveToNext())
            {
                arraylist.add(contentresolver.getString(i));
            }

        }
        contentresolver.close();
        return arraylist;
    }

    public static List b(ContentResolver contentresolver, int i)
    {
        ArrayList arraylist = new ArrayList();
        contentresolver = contentresolver.query(android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] {
            "data1"
        }, "contact_id = ? AND data2 = 2", new String[] {
            String.valueOf(i)
        }, null);
        if (contentresolver.moveToFirst())
        {
            i = contentresolver.getColumnIndex("data1");
            for (; !contentresolver.isAfterLast(); contentresolver.moveToNext())
            {
                arraylist.add(contentresolver.getString(i).replaceFirst("\\+", "00").replaceAll("\\D", ""));
            }

        }
        contentresolver.close();
        return arraylist;
    }

    public static void b(Context context)
    {
        if (d.compareAndSet(false, true))
        {
            (new Thread(new Runnable(context) {

                private Context a;

                public final void run()
                {
                    try
                    {
                        h.a(a, false);
                        TwitterSessionManager.sendFriendsAnal(a, false);
                        FacebookUtils.sendFriendsAnal(a, false);
                        return;
                    }
                    catch (Exception exception)
                    {
                        ExceptionReportService.report(a, exception, String.valueOf(SocialinV3.getInstance().getUser().id));
                    }
                }

            
            {
                a = context;
                super();
            }
            })).start();
        }
    }

    public static void c(Context context)
    {
        if (SocialinV3.getInstance().getSettings().isContactSyncOnInviteEnabled() && c.compareAndSet(false, true))
        {
            (new Thread(new Runnable(context) {

                private Context a;

                public final void run()
                {
                    AnalyticUtils.getInstance(a).trackDeviceContactInfo("device_contact", a.d(a));
                }

            
            {
                a = context;
                super();
            }
            })).start();
        }
    }

    static JSONArray d(Context context)
    {
        return e(context);
    }

    private static JSONArray e(Context context)
    {
        Object obj1;
        Object obj2;
        obj2 = new JSONArray();
        obj1 = obj2;
        Long long1 = Long.valueOf((new Date()).getTime());
        obj1 = obj2;
        SharedPreferences sharedpreferences = context.getSharedPreferences("contact.analytics.prefs", 0);
        obj1 = obj2;
        Object obj4 = Long.valueOf(sharedpreferences.getLong("last_send_key", 0L));
        obj1 = obj2;
        Object obj3 = SocialinV3.getInstance().getAppProps().getData();
        Object obj;
        obj = obj2;
        obj1 = obj2;
        if (((Long) (obj4)).longValue() == 0L)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj = obj2;
        obj1 = obj2;
        if (long1.longValue() - ((Long) (obj4)).longValue() >= ((com.socialin.android.apiv3.model.AppProps.Data) (obj3)).social.getIntervalInMillis())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        obj1 = obj2;
        (new StringBuilder()).append(obj4).append(" still to interval");
        obj = null;
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj2 = context.getContentResolver();
        int i;
        int j;
        j = 1;
        obj1 = obj;
        i = j;
        if (((Long) (obj4)).longValue() == 0L) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        i = j;
        if (android.os.Build.VERSION.SDK_INT < 18) goto _L4; else goto _L5
_L5:
        obj1 = obj;
        Object obj5 = android.provider.ContactsContract.Data.CONTENT_URI;
        obj1 = obj;
        obj4 = (new StringBuilder("contact_last_updated_timestamp>")).append(String.valueOf(obj4)).toString();
        obj1 = obj;
        obj4 = ((ContentResolver) (obj2)).query(((android.net.Uri) (obj5)), new String[] {
            "contact_last_updated_timestamp", "contact_id"
        }, ((String) (obj4)), null, null);
        obj1 = obj;
        obj5 = new HashSet();
        obj1 = obj;
        if (!((Cursor) (obj4)).moveToFirst()) goto _L7; else goto _L6
_L6:
        obj1 = obj;
        if (((Cursor) (obj4)).isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        ((Set) (obj5)).add(((Cursor) (obj4)).getString(((Cursor) (obj4)).getColumnIndex("contact_id")));
        obj1 = obj;
        ((Cursor) (obj4)).moveToNext();
        if (true) goto _L6; else goto _L8
        obj;
        ExceptionReportService.report(context, ((Throwable) (obj)), String.valueOf(SocialinV3.getInstance().getUser().id));
        obj2 = obj1;
_L12:
        return ((JSONArray) (obj2));
_L8:
        obj1 = obj;
        ((Cursor) (obj4)).close();
_L7:
        obj1 = obj;
        JSONException jsonexception;
        Object obj6;
        int k;
        int l;
        if (((Set) (obj5)).size() >= ((com.socialin.android.apiv3.model.AppProps.Data) (obj3)).social.contactChangeDiff)
        {
            i = 1;
        } else
        {
            i = 0;
        }
_L4:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_788;
        }
        obj1 = obj;
        a = (new String[] {
            "facebook", "viber", "twitter", "whatsapp", "skype", "linkedin", "google"
        });
        obj1 = obj;
        obj3 = ((ContentResolver) (obj2)).query(android.provider.ContactsContract.RawContacts.CONTENT_URI, new String[] {
            "contact_id", "account_type", "sourceid"
        }, null, null, null);
        obj1 = obj;
        i = ((Cursor) (obj3)).getColumnIndex("contact_id");
        obj1 = obj;
        j = ((Cursor) (obj3)).getColumnIndex("account_type");
        obj1 = obj;
        k = ((Cursor) (obj3)).getColumnIndex("sourceid");
        obj1 = obj;
        if (!((Cursor) (obj3)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_730;
        }
_L9:
        obj1 = obj;
        if (((Cursor) (obj3)).isAfterLast())
        {
            break MISSING_BLOCK_LABEL_730;
        }
        obj1 = obj;
        l = ((Cursor) (obj3)).getInt(i);
        obj1 = obj;
        obj6 = ((Cursor) (obj3)).getString(j);
        obj1 = obj;
        obj4 = ((Cursor) (obj3)).getString(k);
        obj1 = obj;
        obj5 = new JSONObject();
        obj1 = obj;
        ((JSONObject) (obj5)).put("contact_sync", a(((String) (obj6))));
        obj1 = obj;
        obj6 = a(((ContentResolver) (obj2)), l);
        obj1 = obj;
        if (((List) (obj6)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_631;
        }
        obj1 = obj;
        ((JSONObject) (obj5)).put("email", new JSONArray(((java.util.Collection) (obj6))));
        obj1 = obj;
        obj6 = b(((ContentResolver) (obj2)), l);
        obj1 = obj;
        if (((List) (obj6)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_672;
        }
        obj1 = obj;
        ((JSONObject) (obj5)).put("phone", new JSONArray(((java.util.Collection) (obj6))));
        obj1 = obj;
        if (((JSONObject) (obj5)).length() == 1)
        {
            break MISSING_BLOCK_LABEL_705;
        }
        obj1 = obj;
        ((JSONObject) (obj5)).put("identifier", obj4);
        obj1 = obj;
        ((JSONArray) (obj)).put(obj5);
_L10:
        obj1 = obj;
        ((Cursor) (obj3)).moveToNext();
          goto _L9
        jsonexception;
        obj1 = obj;
        jsonexception.printStackTrace();
          goto _L10
        obj1 = obj;
        b.toString();
        obj1 = obj;
        ((Cursor) (obj3)).close();
        obj1 = obj;
        obj2 = obj;
        if (!s.a(context)) goto _L12; else goto _L11
_L11:
        obj1 = obj;
        sharedpreferences.edit().putLong("last_send_key", long1.longValue()).commit();
        return ((JSONArray) (obj));
        context = null;
_L14:
        return context;
_L2:
        context = ((Context) (obj));
        if (true) goto _L14; else goto _L13
_L13:
    }

}
