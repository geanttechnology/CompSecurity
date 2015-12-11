// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            a, al

final class aq
{

    static WeakReference a;

    static String a(Context context)
    {
        return Uri.fromFile(c(context)).toString();
    }

    static boolean a(Context context, InputStream inputstream)
    {
        File file;
        boolean flag;
        flag = true;
        file = new File(com.millennialmedia.android.a.f(context), "mraid.js");
        String.format("Saving mraid js to %s", new Object[] {
            file
        });
        al.a();
        Object obj = new FileOutputStream(file);
        context = ((Context) (obj));
        byte abyte0[] = new byte[1024];
_L4:
        context = ((Context) (obj));
        int i = inputstream.read(abyte0);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        context = ((Context) (obj));
        ((FileOutputStream) (obj)).write(abyte0, 0, i);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        inputstream = ((InputStream) (obj));
        obj = context;
_L9:
        context = inputstream;
        file.delete();
        context = inputstream;
        al.a("MRaid", "Exception downloading component mraid.js: ", ((Throwable) (obj)));
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                al.a("MRaid", "Exception closing file: ", context);
            }
        }
        flag = false;
_L6:
        return flag;
        inputstream;
        context = null;
_L7:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                al.a("MRaid", "Exception closing file: ", context);
            }
        }
        throw inputstream;
_L2:
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            ((FileOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            al.a("MRaid", "Exception closing file: ", context);
            return true;
        }
        return true;
        inputstream;
          goto _L7
        obj;
        inputstream = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static boolean a(Context context, String s)
    {
        boolean flag = false;
        if (!TextUtils.isEmpty(s))
        {
            context = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            context.putString("KEY_MMJS_URL", s);
            context.commit();
            flag = true;
        }
        return flag;
    }

    static boolean b(Context context)
    {
        context = c(context);
        (new StringBuilder("@@-MMJS File location: ")).append(context.getAbsolutePath());
        al.b();
        return context.exists();
    }

    private static File c(Context context)
    {
        return new File(com.millennialmedia.android.a.f(context), "mraid.js");
    }

    // Unreferenced inner class com/millennialmedia/android/aq$1

/* anonymous class */
    static final class _cls1
        implements Runnable
    {

        final String a;
        final Context b;

        public final void run()
        {
            (new StringBuilder("MMJS -  download start (")).append(a).append(")");
            al.d();
            Object obj = new HttpGet(a);
            obj = (new DefaultHttpClient()).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
            (new StringBuilder("MMJS -  download finish (")).append(a).append(")");
            al.d();
            if (aq.a(b, ((HttpResponse) (obj)).getEntity().getContent()) && aq.a(b, a))
            {
                (new StringBuilder("MMJS -  download saved (")).append(a).append(")");
                al.d();
            }
            if (aq.a == null) goto _L2; else goto _L1
_L1:
            WeakReference weakreference = aq.a;
_L7:
            weakreference.get();
_L2:
            return;
            Object obj1;
            obj1;
            al.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
            if (aq.a == null) goto _L2; else goto _L3
_L3:
            obj1 = aq.a;
            continue; /* Loop/switch isn't completed */
            obj1;
            al.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
            if (aq.a == null) goto _L2; else goto _L4
_L4:
            obj1 = aq.a;
            continue; /* Loop/switch isn't completed */
            obj1;
            al.a("MRaid", "Mraid download exception: ", ((Throwable) (obj1)));
            if (aq.a == null) goto _L2; else goto _L5
_L5:
            obj1 = aq.a;
            if (true) goto _L7; else goto _L6
_L6:
            obj1;
            if (aq.a != null)
            {
                aq.a.get();
            }
            throw obj1;
        }

            
            {
                a = s;
                b = context;
                super();
            }
    }

}
