// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.v4.app.g;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.ui.activities.c;
import com.facebook.login.f;
import com.parse.ParseException;
import com.parse.ParseUser;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package android.support.v7:
//            aqo, dz, ajx

public class iv
{

    public static int a(Context context)
    {
        return c(context) / 2 - (int)TypedValue.applyDimension(1, 20F, context.getResources().getDisplayMetrics());
    }

    public static CountryCurrencyInfo a(g g)
    {
        g = (c)g;
        Object obj;
        if (g == null)
        {
            g = null;
        } else
        {
            g = g.s();
        }
        obj = g;
        if (g == null)
        {
            obj = CountryCurrencyInfo.createDefaultCountryCurrencyInfo();
        }
        return ((CountryCurrencyInfo) (obj));
    }

    public static File a(Context context, String s, String s1)
    {
        context = new File(Environment.getExternalStorageDirectory(), context.getPackageName());
        if (!context.exists())
        {
            context.mkdir();
        }
        long l = (new Date()).getTime();
        return new File(context, (new StringBuilder()).append(s).append(String.valueOf(l)).append(".").append(s1).toString());
    }

    public static String a(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append("http://www.letgo.com/product/").append(s).toString();
        }
    }

    public static ArrayList a(Context context, int i)
    {
        ArrayList arraylist;
        InputStreamReader inputstreamreader;
        BufferedReader bufferedreader;
        arraylist = new ArrayList();
        context = context.getResources().openRawResource(i);
        inputstreamreader = new InputStreamReader(context);
        bufferedreader = new BufferedReader(inputstreamreader, 8192);
_L1:
        String s;
        try
        {
            s = bufferedreader.readLine();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aqo.b(context, "Error reading raw file %d", new Object[] {
                Integer.valueOf(i)
            });
            return arraylist;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        arraylist.add(s);
          goto _L1
        inputstreamreader.close();
        context.close();
        bufferedreader.close();
        return arraylist;
    }

    public static void a()
    {
        f f1 = f.a();
        if (f1 != null)
        {
            f1.b();
        }
    }

    public static void a(Dialog dialog)
    {
        if (dialog != null && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }

    public static void a(Context context, String s, int i)
    {
        InputStream inputstream;
        s = new File(context.getFilesDir(), s);
        if (s.exists())
        {
            s.delete();
        }
        if (s.exists())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        inputstream = context.getResources().openRawResource(i);
        s = new FileOutputStream(s);
        context = s;
        a(inputstream, ((OutputStream) (s)));
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                aqo.b(context, "Unable to close inputStream", new Object[0]);
            }
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s.close();
_L2:
        return;
        context;
        aqo.b(context, "Unable to close outputStream", new Object[0]);
        return;
        Object obj;
        obj;
        s = null;
_L5:
        context = s;
        aqo.b(((Throwable) (obj)), "Unable to copy database from raw", new Object[0]);
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                aqo.b(context, "Unable to close inputStream", new Object[0]);
            }
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            aqo.b(context, "Unable to close outputStream", new Object[0]);
        }
        return;
        s;
        context = null;
_L4:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aqo.b(((Throwable) (obj)), "Unable to close inputStream", new Object[0]);
            }
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                aqo.b(context, "Unable to close outputStream", new Object[0]);
            }
        }
        throw s;
        s;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
          goto _L5
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
_L1:
        int i = inputstream.read(abyte0, 0, 1024);
        if (i == -1)
        {
            return;
        }
        try
        {
            outputstream.write(abyte0, 0, i);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            aqo.b(inputstream, "copyStream", new Object[0]);
            return;
        }
          goto _L1
    }

    public static void a(Object obj)
    {
        try
        {
            dz.a().b(obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    public static boolean a(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static boolean a(Context context, Intent intent)
    {
        return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
    }

    public static String b(String s)
        throws IOException
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection.setInstanceFollowRedirects(false);
        httpurlconnection.connect();
        httpurlconnection.getInputStream();
        if (httpurlconnection.getResponseCode() == 301 || httpurlconnection.getResponseCode() == 302)
        {
            s = b(httpurlconnection.getHeaderField("Location"));
        }
        return s;
    }

    public static void b()
    {
        ParseUser.enableAutomaticUser();
        try
        {
            ParseUser parseuser = ParseUser.getCurrentUser();
            parseuser.put("processed", Boolean.valueOf(false));
            parseuser.save();
            return;
        }
        catch (ParseException parseexception)
        {
            Object obj = ParseUser.getCurrentUser();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((ParseUser) (obj)).getObjectId();
            }
            aqo.b(parseexception, (new StringBuilder()).append("enableAndSaveAutomaticUser : unable to save : ").append(((String) (obj))).toString(), new Object[0]);
            return;
        }
    }

    public static void b(Object obj)
    {
        try
        {
            dz.a().c(obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    public static boolean b(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    private static int c(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (a(13))
        {
            Point point = new Point();
            context.getSize(point);
            return point.x;
        } else
        {
            return context.getWidth();
        }
    }

    public static Bitmap c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        InputStream inputstream;
        BufferedInputStream bufferedinputstream;
        s = (HttpURLConnection)(new URL(b(s))).openConnection();
        s.setInstanceFollowRedirects(true);
        HttpURLConnection.setFollowRedirects(true);
        s.connect();
        inputstream = s.getInputStream();
        bufferedinputstream = new BufferedInputStream(inputstream);
        try
        {
            s = BitmapFactory.decodeStream(bufferedinputstream);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = null;
        }
        try
        {
            bufferedinputstream.close();
            inputstream.close();
        }
        catch (Exception exception)
        {
            return s;
        }
        return s;
        s;
        return null;
    }

    public static String d(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            Locale locale = Locale.getDefault();
            return Currency.getInstance(s).getSymbol(locale);
        }
    }
}
