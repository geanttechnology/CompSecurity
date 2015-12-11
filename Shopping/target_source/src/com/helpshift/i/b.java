// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.helpshift.f.c;
import com.helpshift.h.e;
import com.helpshift.k.a;
import com.helpshift.l;
import com.helpshift.s;
import com.helpshift.x;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.i:
//            q, h

public final class b
{

    public static Bitmap a(String s, int i)
    {
        if (TextUtils.isEmpty(s))
        {
            s = null;
        } else
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = 4;
            Bitmap bitmap = BitmapFactoryInstrumentation.decodeFile(s, options);
            s = bitmap;
            if (i > 0)
            {
                return Bitmap.createScaledBitmap(bitmap, i, (int)(((float)options.outHeight / (float)options.outWidth) * (float)i), false);
            }
        }
        return s;
    }

    public static a a(s s, String s1, String s2)
    {
        return a(s, s1, s2, false);
    }

    public static a a(s s, String s1, String s2, boolean flag)
    {
        try
        {
            s = (new StringBuilder()).append("localRscMessage_").append(UUID.randomUUID().toString()).toString();
            String s3 = a(e.a(s1));
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("id", s);
            jsonobject.put("issue_id", s1);
            jsonobject.put("type", "rsc");
            jsonobject.put("origin", "admin");
            jsonobject.put("body", "Attaching Screenshot...");
            jsonobject.put("invisible", false);
            jsonobject.put("screenshot", s2);
            jsonobject.put("state", 0);
            jsonobject.put("inProgress", flag);
            jsonobject.put("created_at", s3);
            jsonobject.put("seen", true);
            jsonobject.put("author", new JSONObject());
            jsonobject.put("meta", new JSONObject());
            s1 = new JSONArray();
            s1.put(jsonobject);
            e.b(com.helpshift.i.q.a(s1));
            s = new a(s, "rsc", "admin", "Attaching Screenshot...", s3, Boolean.valueOf(false), s2, 0, Boolean.valueOf(false), "");
        }
        // Misplaced declaration of an exception variable
        catch (s s)
        {
            x.b("HelpShiftDebug", "addAndGetLocalRscMessage", s);
            return null;
        }
        return s;
    }

    public static String a(Activity activity, Intent intent)
    {
        intent = intent.getData();
        File file;
        try
        {
            intent = a(activity, ((Uri) (intent)));
            file = new File(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            a(activity);
            return null;
        }
        if (!file.exists())
        {
            a(activity);
            return null;
        }
        Long long1 = new Long(0x500000L);
        if (file.length() > long1.longValue())
        {
            intent = String.format(activity.getResources().getString(com.helpshift.g.y), new Object[] {
                Float.valueOf((float)long1.longValue() / 1048576F)
            });
            Toast.makeText(activity.getApplicationContext(), intent, 1).show();
            return null;
        } else
        {
            return intent;
        }
    }

    private static String a(Activity activity, Uri uri)
    {
        activity = activity.managedQuery(uri, new String[] {
            "_data"
        }, null, null, null);
        int i = activity.getColumnIndexOrThrow("_data");
        activity.moveToFirst();
        return activity.getString(i);
    }

    public static String a(Activity activity, l l1, String s, String s1, int i)
        throws IOException
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        String s2;
        s2 = (new StringBuilder()).append(s1).append(i).append("-thumbnail").toString();
        File file = new File(activity.getFilesDir(), s2);
        s1 = file.getAbsolutePath();
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_230;
        }
        l1.c(s2);
        l1 = new FileInputStream(new File(s));
        activity = activity.openFileOutput(s2, 0);
        s = new byte[1024];
_L3:
        i = l1.read(s);
        if (i == -1) goto _L2; else goto _L1
_L1:
        activity.write(s, 0, i);
          goto _L3
        s;
_L6:
        x.b("HelpShiftDebug", "NPE", s);
        if (activity != null)
        {
            activity.close();
        }
        if (l1 != null)
        {
            l1.close();
        }
        return null;
_L2:
        if (activity != null)
        {
            activity.close();
        }
        if (l1 != null)
        {
            l1.close();
        }
        return s1;
        activity;
        l1 = null;
        s = obj;
_L5:
        if (s != null)
        {
            s.close();
        }
        if (l1 != null)
        {
            l1.close();
        }
        throw activity;
        activity;
        s = obj;
        continue; /* Loop/switch isn't completed */
        s1;
        s = activity;
        activity = s1;
        continue; /* Loop/switch isn't completed */
        s1;
        s = activity;
        activity = s1;
        if (true) goto _L5; else goto _L4
_L4:
        s;
        activity = null;
        l1 = null;
          goto _L6
        s;
        activity = null;
          goto _L6
        activity = null;
        l1 = obj1;
          goto _L2
    }

    public static String a(Activity activity, String s, String s1)
    {
        if (s.contains("audio/"))
        {
            return activity.getResources().getString(com.helpshift.g.S);
        }
        if (s.contains("video/"))
        {
            return activity.getResources().getString(com.helpshift.g.T);
        }
        if (s.contains("application/pdf"))
        {
            return activity.getResources().getString(com.helpshift.g.U);
        }
        if (s.contains("vnd.openxmlformats-officedocument"))
        {
            return activity.getResources().getString(com.helpshift.g.V);
        }
        if (s.equals("text/rtf"))
        {
            return activity.getResources().getString(com.helpshift.g.W);
        }
        if (s.equals("text/csv"))
        {
            return activity.getResources().getString(com.helpshift.g.X);
        }
        if (s.equals("text/"))
        {
            return activity.getResources().getString(com.helpshift.g.Y);
        }
        s1 = s1.split("\\.");
        if (s1.length > 0)
        {
            return s1[s1.length - 1];
        }
        s = s.split("/");
        if (s.length > 0)
        {
            return s[s.length - 1];
        } else
        {
            return activity.getResources().getString(com.helpshift.g.Z);
        }
    }

    private static String a(com.helpshift.f.a a1)
    {
        Date date = new Date();
        try
        {
            a1 = a1.i();
            a1 = (c)a1.get(a1.size() - 1);
            a1 = com.helpshift.i.h.a.parse(a1.f());
            if (date.before(a1))
            {
                date.setTime(a1.getTime() + 3000L);
            }
        }
        // Misplaced declaration of an exception variable
        catch (com.helpshift.f.a a1)
        {
            x.b("HelpShiftDebug", "resolveDate", a1);
        }
        return com.helpshift.i.h.a.format(date);
    }

    private static void a(Activity activity)
    {
        Toast.makeText(activity.getApplicationContext(), activity.getResources().getString(com.helpshift.g.z), 1).show();
    }

    private static void b(Activity activity)
    {
        Toast.makeText(activity.getApplicationContext(), activity.getResources().getString(com.helpshift.g.C), 1).show();
    }

    public static boolean b(Activity activity, Intent intent)
    {
        intent = intent.getData();
        intent = activity.getContentResolver().getType(intent);
        if ((new HashSet(Arrays.asList(new String[] {
    "image/jpeg", "image/png", "image/gif", "image/x-png", "image/x-citrix-pjpeg", "image/x-citrix-gif", "image/pjpeg"
}))).contains(intent))
        {
            return true;
        } else
        {
            b(activity);
            return false;
        }
    }
}
