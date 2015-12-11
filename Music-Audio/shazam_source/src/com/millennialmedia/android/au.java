// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            al, h, MMActivity

final class au
{
    static final class a
    {
    }

    static final class b
    {

        static void a(Context context, Intent intent)
        {
            intent.setClass(context, com/millennialmedia/android/MMActivity);
            intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            b(context, intent);
        }

        static void a(Context context, Uri uri)
        {
            Intent intent = new Intent(context, com/millennialmedia/android/MMActivity);
            intent.setData(uri);
            intent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
            b(context, intent);
        }

        static void b(Context context, Intent intent)
        {
            if (!(context instanceof Activity))
            {
                intent.addFlags(0x10000000);
            }
            Object obj = intent.getData();
            if (obj != null)
            {
                obj = ((Uri) (obj)).getLastPathSegment();
                if (TextUtils.isEmpty(intent.getStringExtra("class")) && !TextUtils.isEmpty(((CharSequence) (obj))) && (((String) (obj)).endsWith(".mp4") || ((String) (obj)).endsWith(".3gp") || ((String) (obj)).endsWith(".mkv") || ((String) (obj)).endsWith("content.once")))
                {
                    intent.setDataAndType(intent.getData(), "video/*");
                }
            }
            context.startActivity(intent);
        }
    }

    static final class c
    {

        private static final ExecutorService a = Executors.newCachedThreadPool();

        static void a(Runnable runnable)
        {
            a.execute(runnable);
        }

    }


    static int a(JSONObject jsonobject, String s)
    {
        int i;
        try
        {
            i = jsonobject.getInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            al.a("Utils", (new StringBuilder("Unable to get int value from JSON object for key <")).append(s).append(">").toString(), jsonobject);
            return 0;
        }
        return i;
    }

    static BitmapDrawable a(Context context, String s)
    {
        s = BitmapFactory.decodeStream(new ByteArrayInputStream(h.a(s)));
        if (s == null)
        {
            throw new IOException("Unable to create bitmap from input stream");
        } else
        {
            return new BitmapDrawable(context.getResources(), s);
        }
    }

    static String a(JSONObject jsonobject, String s, String s1)
    {
        try
        {
            jsonobject = jsonobject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            al.a("Utils", (new StringBuilder("Unable to get string value from JSON object for key <")).append(s).append(">").toString(), jsonobject);
            return s1;
        }
        return jsonobject;
    }

    static JSONObject a(View view)
    {
        JSONObject jsonobject = new JSONObject();
        if (view == null)
        {
            al.a("Utils", "Unable to calculate view dimensions for null view");
        } else
        {
            DisplayMetrics displaymetrics = view.getContext().getResources().getDisplayMetrics();
            if (displaymetrics != null)
            {
                int ai[] = new int[2];
                view.getLocationInWindow(ai);
                try
                {
                    jsonobject.put("x", (int)((float)ai[0] / displaymetrics.density));
                    jsonobject.put("y", (int)((float)ai[1] / displaymetrics.density));
                    jsonobject.put("width", (int)((float)view.getWidth() / displaymetrics.density));
                    jsonobject.put("height", (int)((float)view.getHeight() / displaymetrics.density));
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    al.a("Utils", "Unable to build view dimensions", view);
                    return jsonobject;
                }
                return jsonobject;
            }
        }
        return jsonobject;
    }

    static double b(JSONObject jsonobject, String s)
    {
        double d;
        try
        {
            d = jsonobject.getDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            al.a("Utils", (new StringBuilder("Unable to get int value from JSON object for key <")).append(s).append(">").toString(), jsonobject);
            return 0.0D;
        }
        return d;
    }

    static boolean c(JSONObject jsonobject, String s)
    {
        boolean flag;
        try
        {
            flag = jsonobject.getBoolean(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            al.a("Utils", (new StringBuilder("Unable to get boolean value from JSON object for key <")).append(s).append(">").toString(), jsonobject);
            return false;
        }
        return flag;
    }

    // Unreferenced inner class com/millennialmedia/android/au$a$1

/* anonymous class */
    static final class a._cls1
        implements Runnable
    {

        final String a;

        public final void run()
        {
            try
            {
                (new DefaultHttpClient()).execute(new HttpGet(a));
                (new StringBuilder("Executed Url :\"")).append(a).append("\"");
                al.b();
                return;
            }
            catch (IOException ioexception)
            {
                al.a("Utils", "Exception with HttpUtils: ", ioexception);
            }
        }

            
            {
                a = s;
                super();
            }
    }

}
