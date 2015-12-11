// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ActivityManager;
import android.app.RemoteInput;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.MediaRouter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.transition.Transition;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.Attributes;

public class a
    implements ai
{

    public static Boolean b;
    public static Exception c;
    public static int d;
    public static String e;
    public static int f;
    public static volatile String g;
    public static volatile Boolean h;
    public static volatile Boolean i;
    public static volatile String j;
    public static HttpClient k;
    public static HttpClient l;
    public static HttpClient m;
    public static HttpClient n;
    public static String o;
    public static bml p;
    public static boolean q;
    public static boolean r;
    final j a;

    a(c c1, j j1)
    {
        a = j1;
        super();
    }

    public static HttpClient A()
    {
        a;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (m == null)
        {
            b.a(o);
            m = b(1800, 1800);
        }
        httpclient = m;
        a;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    public static HttpClient B()
    {
        a;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (n == null)
        {
            b.a(o);
            n = b(2000, 60000);
        }
        httpclient = n;
        a;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    public static bnq C()
    {
        bnr bnr1 = new bnr();
        bnr1.a("/transcript", new cxq()).a("/transcript/text", new cxp());
        bnr1.a("/timedtext", new cxt()).a("/timedtext/window", new cxs()).a("/timedtext/text", new cxr());
        return bnr1.a();
    }

    public static exe D()
    {
        return E().c(true);
    }

    public static exe E()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = ActivityManager.isRunningInTestHarness();
        } else
        {
            flag = false;
        }
        if (ActivityManager.isUserAMonkey() || flag)
        {
            return (new exe()).a(false);
        } else
        {
            return (new exe()).a(true);
        }
    }

    public static exf F()
    {
        return (new exf()).a(1);
    }

    public static void G()
    {
        boolean flag;
        if (Looper.getMainLooper().getThread() != Thread.currentThread())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag);
    }

    public static dat H()
    {
        return new dat();
    }

    public static dat I()
    {
        return new dat();
    }

    public static Throwable J()
    {
        return null;
    }

    public static ArrayList K()
    {
        return new ArrayList();
    }

    public static float a(String s1, float f1)
    {
        float f2 = f1;
        if (s1 != null)
        {
            try
            {
                f2 = Float.valueOf(s1).floatValue();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return f1;
            }
        }
        return f2;
    }

    public static int a(byte byte0)
    {
        return byte0 & 0xff;
    }

    public static int a(float f1)
    {
        return (int)(1000F * f1);
    }

    public static int a(ContentResolver contentresolver)
    {
        return bcf.a(contentresolver, "youtube:device_lowend", 2);
    }

    public static int a(Context context, int i1)
    {
        TypedValue typedvalue = new TypedValue();
        if (context.getTheme().resolveAttribute(i1, typedvalue, true))
        {
            return typedvalue.resourceId;
        } else
        {
            return 0;
        }
    }

    public static int a(Parcel parcel)
    {
        int j1 = parcel.readInt();
        int k1 = a(parcel, j1);
        int i1 = parcel.dataPosition();
        if ((0xffff & j1) != 20293)
        {
            throw new l((new StringBuilder("Expected object header. Got 0x")).append(Integer.toHexString(j1)).toString(), parcel);
        }
        j1 = i1 + k1;
        if (j1 < i1 || j1 > parcel.dataSize())
        {
            throw new l((new StringBuilder("Size read is invalid start=")).append(i1).append(" end=").append(j1).toString(), parcel);
        } else
        {
            return j1;
        }
    }

    public static int a(Parcel parcel, int i1)
    {
        if ((i1 & 0xffff0000) != 0xffff0000)
        {
            return i1 >> 16 & 0xffff;
        } else
        {
            return parcel.readInt();
        }
    }

    public static int a(ObjectInputStream objectinputstream)
    {
        return objectinputstream.readInt();
    }

    public static int a(CharSequence charsequence, int i1, int j1)
    {
        for (; i1 < j1; i1++)
        {
            if (Character.isWhitespace(charsequence.charAt(i1)))
            {
                return i1;
            }
        }

        return -1;
    }

    public static int a(List list, Object obj, Comparator comparator, elf elf1, elb elb1)
    {
        f.b(comparator);
        f.b(list);
        f.b(elf1);
        f.b(elb1);
        Object obj1 = list;
        if (!(list instanceof RandomAccess))
        {
            obj1 = c(list);
        }
        int i1 = 0;
        for (int j1 = ((List) (obj1)).size() - 1; i1 <= j1;)
        {
            int k1 = i1 + j1 >>> 1;
            int l1 = comparator.compare(obj, ((List) (obj1)).get(k1));
            if (l1 < 0)
            {
                j1 = k1 - 1;
            } else
            if (l1 > 0)
            {
                i1 = k1 + 1;
            } else
            {
                return elf1.a(comparator, obj, ((List) (obj1)).subList(i1, j1 + 1), k1 - i1) + i1;
            }
        }

        return elb1.a(i1);
    }

    public static transient int a(int ai1[])
    {
        f.a(true);
        int j1 = ai1[0];
        for (int i1 = 1; i1 < 2;)
        {
            int k1 = j1;
            if (ai1[1] < j1)
            {
                k1 = ai1[1];
            }
            i1++;
            j1 = k1;
        }

        return j1;
    }

    public static long a(InputStream inputstream, OutputStream outputstream)
    {
        b.a(inputstream);
        b.a(outputstream);
        byte abyte0[] = new byte[4096];
        long l1 = 0L;
        do
        {
            int i1 = inputstream.read(abyte0);
            if (i1 != -1)
            {
                outputstream.write(abyte0, 0, i1);
                l1 += i1;
            } else
            {
                return l1;
            }
        } while (true);
    }

    public static long a(String s1)
    {
        long l1;
        try
        {
            l1 = DateUtils.parseDate(s1).getTime();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return 0L;
        }
        return l1;
    }

    public static long a(String s1, long l1)
    {
        l1 = 0L;
        if (s1 != null)
        {
            try
            {
                l1 = Long.valueOf(s1).longValue();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return 0L;
            }
        }
        return l1;
    }

    public static Context a(Context context, boolean flag)
    {
        int i1 = 1;
        boolean flag1 = false;
        TypedValue typedvalue = new TypedValue();
        if (!context.getTheme().resolveAttribute(0x7f010081, typedvalue, true) || typedvalue.data == 0)
        {
            i1 = 0;
        }
        if (i1 != 0 && flag)
        {
            context = new ContextThemeWrapper(context, 0x7f0c00ee);
            i1 = ((flag1) ? 1 : 0);
        }
        if (i1 != 0)
        {
            i1 = 0x7f0c0033;
        } else
        {
            i1 = 0x7f0c0032;
        }
        return new ContextThemeWrapper(context, i1);
    }

    public static Bitmap a(Activity activity, int i1)
    {
        Bitmap bitmap;
        View view;
        boolean flag;
        view = activity.getWindow().getDecorView().getRootView();
        flag = view.isDrawingCacheEnabled();
        view.setDrawingCacheEnabled(true);
        bitmap = view.getDrawingCache();
        activity = bitmap;
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        if (bitmap != null) goto _L4; else goto _L3
_L3:
        activity = null;
_L2:
        if (!flag)
        {
            view.setDrawingCacheEnabled(false);
            view.destroyDrawingCache();
        }
        return activity;
_L4:
        bitmap = bitmap.copy(android.graphics.Bitmap.Config.RGB_565, false);
        int j1 = bitmap.getWidth();
        for (i1 = bitmap.getHeight(); j1 * i1 << 1 > 0x100000; i1 /= 2)
        {
            j1 /= 2;
        }

        activity = bitmap;
        if (j1 != bitmap.getWidth())
        {
            activity = Bitmap.createScaledBitmap(bitmap, j1, i1, true);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    static Rect a(View view)
    {
        Rect rect = new Rect();
        int ai1[] = new int[2];
        view.getLocationOnScreen(ai1);
        rect.set(ai1[0], ai1[1], ai1[0] + view.getWidth(), ai1[1] + view.getHeight());
        return rect;
    }

    public static Uri a(Uri uri, Map map)
    {
        Object obj = uri.getQueryParameterNames();
        android.net.Uri.Builder builder = uri.buildUpon();
        builder.query("");
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s2 = (String)((Iterator) (obj)).next();
            if (!map.containsKey(s2))
            {
                builder.appendQueryParameter(s2, uri.getQueryParameter(s2));
            }
        } while (true);
        String s1;
        for (uri = map.keySet().iterator(); uri.hasNext(); builder.appendQueryParameter(s1, (String)map.get(s1)))
        {
            s1 = (String)uri.next();
        }

        return builder.build();
    }

    public static Parcelable a(Parcel parcel, int i1, android.os.Parcelable.Creator creator)
    {
        i1 = a(parcel, i1);
        int j1 = parcel.dataPosition();
        if (i1 == 0)
        {
            return null;
        } else
        {
            creator = (Parcelable)creator.createFromParcel(parcel);
            parcel.setDataPosition(i1 + j1);
            return creator;
        }
    }

    public static Pair a(Context context, HttpResponseException httpresponseexception)
    {
        int i1 = httpresponseexception.getStatusCode();
        String s1 = (new StringBuilder(21)).append("httpError ").append(i1).toString();
        if (httpresponseexception.getStatusCode() == 403)
        {
            return Pair.create(context.getString(0x7f0b00e8), s1);
        } else
        {
            return Pair.create(context.getString(0x7f0b00e9, new Object[] {
                Integer.valueOf(httpresponseexception.getStatusCode())
            }), s1);
        }
    }

    public static AccessibilityManager a(Context context)
    {
        return (AccessibilityManager)context.getSystemService("accessibility");
    }

    public static anl a(int i1, int j1, int k1)
    {
        return new anl(i1, j1, k1);
    }

    public static bvd a(ear ear1)
    {
        bvd bvd1;
        boolean flag;
        flag = false;
        bvd1 = new bvd(b(ear1.a, 3));
        if (ear1.b != null && ear1.b.length != 0) goto _L2; else goto _L1
_L1:
        bmo.c("Invalid Vast Ad proto with no Ads.");
_L41:
        return bvd1;
_L2:
        Object aobj[];
        int i1;
        int j1;
        aobj = ear1.b;
        j1 = aobj.length;
        i1 = 0;
_L8:
        if (i1 >= j1) goto _L4; else goto _L3
_L3:
        ear1 = aobj[i1];
        if (((dce) (ear1)).b != 1) goto _L6; else goto _L5
_L5:
        dmd dmd1;
        if (ear1 == null)
        {
            bmo.c("Invalid Vast Ad proto with no inLine Ad.");
            return bvd1;
        }
        bvd1.n = ((dce) (ear1)).d;
        dmd1 = ((dce) (ear1)).c;
        bvd1.k = dmd1.b;
        if (dmd1.a != null)
        {
            bvd1.o = dmd1.a.a;
        }
        if (dmd1.d != null)
        {
            ear1 = dmd1.d;
            j1 = ear1.length;
            i1 = 0;
            while (i1 < j1) 
            {
                Object obj1 = ear1[i1];
                try
                {
                    bvd1.a(q(((eam) (obj1)).b));
                }
                catch (MalformedURLException malformedurlexception)
                {
                    bmo.c("Badly formed impression uri - ignoring");
                }
                i1++;
            }
        }
        if (dmd1.c != null)
        {
            ear1 = dmd1.c;
            j1 = ear1.length;
            i1 = 0;
            while (i1 < j1) 
            {
                String s1 = ear1[i1];
                try
                {
                    bvd1.n(q(s1));
                }
                catch (MalformedURLException malformedurlexception1)
                {
                    bmo.c("Badly formed error uri - ignoring");
                }
                i1++;
            }
        }
          goto _L7
_L6:
        i1++;
          goto _L8
_L7:
        if (dmd1.e == null) goto _L10; else goto _L9
_L9:
        ear1 = dmd1.e;
        j1 = ear1.length;
        i1 = 0;
_L39:
        Object aobj1[];
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj1 = ear1[i1];
        if (((dmg) (aobj1)).b != 1) goto _L12; else goto _L11
_L11:
        aobj1 = ((dmg) (aobj1)).c.a;
        j1 = aobj1.length;
        i1 = 0;
_L14:
        Object obj2;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = aobj1[i1];
        if (obj2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        bmo.c("Badly formed tracking event - ignoring");
_L28:
        i1++;
        if (true) goto _L14; else goto _L13
_L13:
        ear1 = q(((dzv) (obj2)).c);
        ((dzv) (obj2)).b;
        JVM INSTR tableswitch 1 19: default 971
    //                   1 467
    //                   2 467
    //                   3 476
    //                   4 485
    //                   5 494
    //                   6 503
    //                   7 530
    //                   8 448
    //                   9 512
    //                   10 448
    //                   11 521
    //                   12 539
    //                   13 448
    //                   14 448
    //                   15 448
    //                   16 448
    //                   17 548
    //                   18 557
    //                   19 574;
           goto _L15 _L16 _L16 _L17 _L18 _L19 _L20 _L21 _L15 _L22 _L15 _L23 _L24 _L15 _L15 _L15 _L15 _L25 _L26 _L27
_L15:
        bmo.c("Badly formed tracking uri - ignoring");
          goto _L28
_L16:
        try
        {
            bvd1.b(ear1);
        }
        // Misplaced declaration of an exception variable
        catch (ear ear1)
        {
            bmo.c("Badly formed tracking uri - ignoring");
        }
          goto _L28
_L17:
        bvd1.c(ear1);
          goto _L28
_L18:
        bvd1.d(ear1);
          goto _L28
_L19:
        bvd1.e(ear1);
          goto _L28
_L20:
        bvd1.h(ear1);
          goto _L28
_L22:
        bvd1.j(ear1);
          goto _L28
_L23:
        bvd1.k(ear1);
          goto _L28
_L21:
        bvd1.l(ear1);
          goto _L28
_L24:
        bvd1.m(ear1);
          goto _L28
_L25:
        bvd1.i(ear1);
          goto _L28
_L26:
        if (bvd1.a < 3) goto _L28; else goto _L29
_L29:
        bvd1.f(ear1);
          goto _L28
_L27:
        if (bvd1.a < 3) goto _L28; else goto _L30
_L30:
        obj2 = ((dzv) (obj2)).d;
        if (((dsi) (obj2)).a != 1) goto _L32; else goto _L31
_L31:
        if (((dsi) (obj2)).b < 0.0F || ((dsi) (obj2)).b > 100F) goto _L34; else goto _L33
_L33:
        ear1 = new bvg((int)((dsi) (obj2)).b, true, ear1);
_L38:
        if (ear1 == null) goto _L28; else goto _L35
_L35:
        bvd1.a(ear1);
          goto _L28
_L32:
        if (((dsi) (obj2)).a != 2) goto _L37; else goto _L36
_L36:
        ear1 = new bvg(((dsi) (obj2)).c, false, ear1);
          goto _L38
_L37:
        bmo.c("Badly formed progress tracking uri - ignoring");
_L34:
        ear1 = null;
          goto _L38
_L12:
        i1++;
        if (true) goto _L39; else goto _L10
_L10:
        if (dmd1.g != null)
        {
            ear1 = new bqa();
            aobj1 = dmd1.g;
            j1 = aobj1.length;
            for (i1 = 0; i1 < j1; i1++)
            {
                obj2 = bpm.a(aobj1[i1]);
                if (obj2 != null)
                {
                    ear1.a(((bvj) (obj2)));
                }
            }

            bvd1.ah = ear1.a();
        }
        dmd1 = dmd1.f;
        if (dmd1 == null) goto _L41; else goto _L40
_L40:
        int k1;
        k1 = dmd1.length;
        i1 = 0;
_L51:
        if (i1 >= k1) goto _L43; else goto _L42
_L42:
        int l1;
        ear1 = dmd1[i1];
        aobj1 = ((dkn) (ear1)).b;
        l1 = aobj1.length;
        j1 = 0;
_L50:
        if (j1 >= l1) goto _L45; else goto _L44
_L44:
        obj2 = aobj1[j1];
        if (((dex) (obj2)).b == null || !"type".equalsIgnoreCase(((dex) (obj2)).b.a) || !"adsense".equalsIgnoreCase(((dex) (obj2)).c)) goto _L47; else goto _L46
_L46:
        if (ear1 == null) goto _L41; else goto _L48
_L48:
        ear1 = ((dkn) (ear1)).c;
        j1 = ear1.length;
        i1 = ((flag) ? 1 : 0);
_L52:
        if (i1 >= j1) goto _L41; else goto _L49
_L47:
        j1++;
          goto _L50
_L45:
        i1++;
          goto _L51
_L43:
        ear1 = null;
          goto _L46
_L49:
        Object obj = ear1[i1];
        if (((drk) (obj)).b != null && "ConversionUrl".equalsIgnoreCase(((drk) (obj)).b.a))
        {
            try
            {
                bvd1.R = q(((drk) (obj)).c);
            }
            // Misplaced declaration of an exception variable
            catch (ear ear1)
            {
                bmo.c("Badly formed ConversionUrl uri - ignoring");
                return bvd1;
            }
            return bvd1;
        }
        i1++;
          goto _L52
_L4:
        ear1 = null;
          goto _L5
    }

    public static dar a(String s1, boolean flag)
    {
        return new dar(s1, 1, (new emx()).a((new StringBuilder()).append(s1).append("-%d").toString()).a(), false, true);
    }

    public static dfh a(cdu cdu1, List list, int i1, int j1, boolean flag)
    {
        dre dre1;
        boolean flag1;
        if (i1 < list.size() && i1 >= 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        b.a(flag1);
        if (i1 < list.size() - 1)
        {
            int k1 = i1 + 1;
            dre1 = a(((ced)list.get(k1)).b, cdu1.a, k1, flag);
        } else
        if (i1 == list.size() - 1 && j1 == 3)
        {
            dre1 = a(((ced)list.get(0)).b, cdu1.a, 0, flag);
        } else
        {
            dre1 = null;
        }
        if (i1 > 0)
        {
            i1--;
            cdu1 = a(((ced)list.get(i1)).b, cdu1.a, i1, flag);
        } else
        {
            cdu1 = null;
        }
        list = new dfh();
        list.b = j1;
        if (dre1 != null)
        {
            list.d = dre1;
            list.c = dre1;
        }
        if (cdu1 != null)
        {
            list.e = cdu1;
        }
        return list;
    }

    public static doy a(dpb dpb1, boolean flag)
    {
        doy doy1 = new doy();
        doy1.a = new dox();
        doy1.a.a = dpb1;
        doy1.a.g = new byte[0];
        doy1.a.h = flag;
        doy1.a.b = 2;
        return doy1;
    }

    public static dre a(String s1, String s2, int i1)
    {
        dsd dsd1 = new dsd();
        if (!TextUtils.isEmpty(s1))
        {
            dsd1.a = s1;
        }
        if (!TextUtils.isEmpty(s2))
        {
            dsd1.b = s2;
        }
        if (i1 != -1)
        {
            dsd1.c = i1;
        }
        s1 = new dre();
        s1.i = dsd1;
        return s1;
    }

    public static dre a(String s1, String s2, int i1, boolean flag)
    {
        if (flag)
        {
            return a(s1, s2, i1);
        }
        eda eda1 = new eda();
        if (!TextUtils.isEmpty(s1))
        {
            eda1.a = s1;
        }
        if (!TextUtils.isEmpty(s2))
        {
            eda1.b = s2;
        }
        if (i1 != -1)
        {
            eda1.c = i1;
        }
        s1 = new dre();
        s1.e = eda1;
        return s1;
    }

    public static ede a(Context context, dre dre1, ced ced1)
    {
        ede ede1 = new ede();
        ede1.c = dre1;
        ede1.a = new edf();
        ede1.a.a = new dyl();
        ede1.a.a.a = new dyp();
        ede1.a.a.a.a = new dwq();
        ede1.a.a.a.a.a = (new dwt[] {
            new dwt()
        });
        dwt dwt1 = ede1.a.a.a.a.a[0];
        dom dom1 = new dom();
        dlb dlb1 = u(ced1.k);
        dre1 = null;
        if (ced1.p != null)
        {
            dre1 = ced1.p;
        }
        Object obj = new ebp();
        obj.b = dlb1;
        obj.a = new dzp();
        ((ebp) (obj)).a.b = (new dzq[] {
            new dzq()
        });
        ((ebp) (obj)).a.b[0].b = dre1;
        dre1 = new doo();
        dre1.g = ((ebp) (obj));
        Object obj1 = u(ced1.f);
        Object obj2 = u(context.getString(0x7f0b0055, new Object[] {
            Long.valueOf(ced1.h)
        }));
        dlb1 = byf.a(ced1.i);
        obj = byf.a(ced1.i + 1L);
        dlb dlb2 = byf.a(ced1.j);
        dlb dlb3 = byf.a(ced1.j + 1L);
        dlb dlb4 = u(ced1.m);
        dlb dlb5 = new dlb();
        if (ced1.l != null)
        {
            dza dza1 = byf.a();
            dza1.b = DateFormat.getLongDateFormat(context).format(ced1.l);
            dlb5.b = (new dza[] {
                dza1
            });
        }
        context = new doo();
        context.h = new ebn();
        ((doo) (context)).h.e = ced1.a();
        ((doo) (context)).h.d = ced1.a();
        ((doo) (context)).h.c = dlb4;
        ((doo) (context)).h.f = dlb5;
        ((doo) (context)).h.b = ((dlb) (obj2));
        ((doo) (context)).h.a = ((dlb) (obj1));
        obj1 = ((doo) (context)).h;
        obj2 = new dpb();
        obj2.a = ced1.b;
        obj1.g = a(((dpb) (obj2)), true);
        ((doo) (context)).h.g.a.e = dlb2;
        ((doo) (context)).h.g.a.f = dlb3;
        ((doo) (context)).h.g.a.c = dlb1;
        ((doo) (context)).h.g.a.d = ((dlb) (obj));
        dom1.a = (new doo[] {
            dre1, context
        });
        dwt1.b = dom1;
        return ede1;
    }

    public static ede a(Context context, ede ede1, cdu cdu1, List list, int i1, boolean flag)
    {
        b.a(context);
        b.a(cdu1);
        b.a(list);
        dyl dyl1 = ede1.a.a;
        int j1 = list.size();
        duq duq1 = new duq();
        duq1.d = cdu1.a;
        duq1.a = cdu1.b;
        duq1.c = i1;
        duq1.e = j1;
        duq1.h = u(context.getResources().getQuantityString(0x7f0d0000, j1, new Object[] {
            Integer.valueOf(j1)
        }));
        duq1.b = new dus[list.size()];
        context = new dpb();
        context.b = cdu1.a;
        boolean flag1;
        if (!cdu1.d)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        duq1.g = a(((dpb) (context)), flag1);
        j1 = 0;
        while (j1 < list.size()) 
        {
            duu duu1;
            if (j1 == i1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            context = (ced)list.get(j1);
            duu1 = new duu();
            duu1.e = flag1;
            duu1.g = ((ced) (context)).b;
            duu1.a = u(((ced) (context)).f);
            duu1.h = u(((ced) (context)).k);
            duu1.d = byf.a(j1 + 1);
            duu1.c = u(a(((ced) (context)).g, 3));
            duu1.f = a(((ced) (context)).b, cdu1.a, j1, flag);
            if (((ced) (context)).c != null)
            {
                duu1.b = new dzp();
                duu1.b.b = (new dzq[] {
                    new dzq()
                });
                duu1.b.b[0].b = ((ced) (context)).c.toString();
            }
            duq1.b[j1] = new dus();
            duq1.b[j1].b = duu1;
            j1++;
        }
        context = new dyn();
        context.a = duq1;
        dyl1.b = context;
        context = new dym();
        context.a = new dfg();
        ((dym) (context)).a.a = (new dfh[] {
            a(cdu1, list, i1, 1, flag), a(cdu1, list, i1, 3, flag), a(cdu1, list, i1, 2, flag), a(cdu1, list, i1, 4, flag)
        });
        dyl1.c = context;
        return ede1;
    }

    public static egf a(egf egf1)
    {
        if (egf1 instanceof egg)
        {
            return egf1;
        } else
        {
            return new egg((egf)f.b(egf1));
        }
    }

    public static els a(long l1)
    {
        return new elv(l1);
    }

    public static els a(byte abyte0[])
    {
        return new elt(abyte0);
    }

    public static exf a(etg etg)
    {
        return (new exf()).a(0).a((new exj()).a(etg));
    }

    public static exf a(ewk ewk)
    {
        return (new exf()).a(0).a((new exl()).a(ewk));
    }

    public static Class a(dxa dxa1)
    {
        if (dxa1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Field afield[];
        int i1;
        int j1;
        afield = dxa.getDeclaredFields();
        j1 = afield.length;
        i1 = 0;
_L4:
        Object obj;
        if (i1 >= j1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = afield[i1];
        ((Field) (obj)).setAccessible(true);
        Object obj2 = ((Field) (obj)).get(dxa1);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (Modifier.isStatic(((Field) (obj)).getModifiers()) || !(obj2 instanceof eul))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj = obj2.getClass();
        return ((Class) (obj));
        Object obj1;
        obj1;
        break MISSING_BLOCK_LABEL_79;
        obj1;
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static Iterable a(Iterable iterable, efx efx)
    {
        f.b(iterable);
        f.b(efx);
        return new eji(iterable, efx);
    }

    public static Object a(Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = ((Transition)obj).clone();
        }
        return obj1;
    }

    public static Object a(Object obj, int i1)
    {
        return ((MediaRouter)obj).getSelectedRoute(0x800003);
    }

    public static Object a(Object obj, String s1, boolean flag)
    {
        return ((MediaRouter)obj).createRouteCategory(s1, false);
    }

    public static Object a(Field field, eun eun1)
    {
        field = ((Field) (field.get(eun1)));
        int j1 = Array.getLength(field);
        if (j1 == 0)
        {
            return null;
        }
        eun1 = new JSONArray();
        int i1 = 0;
        while (i1 < j1) 
        {
            Object obj = Array.get(field, i1);
            if (obj instanceof eun)
            {
                eun1.put(a((eun)obj));
            } else
            if (obj instanceof byte[])
            {
                eun1.put(new String(Base64.encode((byte[])obj, 0)));
            } else
            {
                eun1.put(obj);
            }
            i1++;
        }
        return eun1;
    }

    public static Object a(Executor executor, Class class1, Object obj)
    {
        f.b(executor);
        f.b(class1);
        f.b(obj);
        executor = new dbc(obj, executor);
        return Proxy.newProxyInstance(class1.getClassLoader(), new Class[] {
            class1
        }, executor);
    }

    public static Object a(Executor executor, Object obj)
    {
        boolean flag = true;
        Class aclass[] = obj.getClass().getInterfaces();
        if (aclass.length != 1)
        {
            flag = false;
        }
        f.a(flag, "Delegate must implement a single interface");
        return a(executor, aclass[0], obj);
    }

    public static Object a(je je)
    {
        return new jf(je);
    }

    public static String a(int i1, int j1)
    {
        int i2 = i1 / 60;
        int j2 = i2 / 60;
        int l1 = i2;
        int k1 = j1;
        if (j2 > 0)
        {
            l1 = i2 % 60;
            k1 = Math.max(j1, 5);
        }
        String s2 = Integer.toString(i1 % 60);
        String s1 = s2;
        if (s2.length() == 1)
        {
            s1 = String.valueOf(s2);
            String s3;
            if (s1.length() != 0)
            {
                s1 = "0".concat(s1);
            } else
            {
                s1 = new String("0");
            }
        }
        s3 = Integer.toString(l1);
        s2 = s3;
        if (s3.length() == 1)
        {
            s2 = s3;
            if (k1 > 3)
            {
                s2 = String.valueOf(s3);
                if (s2.length() != 0)
                {
                    s2 = "0".concat(s2);
                } else
                {
                    s2 = new String("0");
                }
            }
        }
        if (k1 > 4)
        {
            return (new StringBuilder(String.valueOf(s2).length() + 13 + String.valueOf(s1).length())).append(j2).append(":").append(s2).append(":").append(s1).toString();
        } else
        {
            return (new StringBuilder(String.valueOf(s2).length() + 1 + String.valueOf(s1).length())).append(s2).append(":").append(s1).toString();
        }
    }

    public static String a(ContentResolver contentresolver, bmw bmw1)
    {
        String s1 = android.provider.Settings.Secure.getString(contentresolver, "android_id");
        contentresolver = s1;
        if (TextUtils.isEmpty(s1))
        {
            contentresolver = String.format("%x", new Object[] {
                Long.valueOf(bmw1.a().nextLong())
            });
        }
        return contentresolver;
    }

    public static String a(Context context, PackageManager packagemanager)
    {
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
            packagemanager = context.split("\\.");
            if (packagemanager.length == 3)
            {
                context = TextUtils.join(".", new String[] {
                    packagemanager[0], packagemanager[1]
                });
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException("PackageManager did not find our package name!", context);
        }
        return context;
    }

    public static String a(Location location, int i1, int j1)
    {
        if (location == null)
        {
            return null;
        }
        ezj ezj1 = new ezj();
        ezg ezg1 = new ezg();
        ezj1.a(i1);
        ezj1.b(j1);
        ezg1.a((int)Math.round(location.getLatitude() * 10000000D));
        ezg1.b((int)Math.round(location.getLongitude() * 10000000D));
        ezj1.a(ezg1);
        long l1 = location.getTime();
        ezj1.a(TimeUnit.MILLISECONDS.toMicros(l1));
        if (location.hasAccuracy())
        {
            ezj1.a((float)((double)location.getAccuracy() * 1000D));
        }
        return (new StringBuilder("w ")).append(Base64.encodeToString(ezj1.c(), 10)).toString();
    }

    public static String a(Location location, Location location1)
    {
        if (location == null)
        {
            return null;
        } else
        {
            location1 = a(location, 1, 12);
            String s1 = a(((Location) (null)), 4, 1);
            location = efy.a(" ").a();
            Object aobj[] = new Object[0];
            f.b(((Object) (aobj)));
            location1 = (new egb(aobj, location1, s1)).iterator();
            return location.a(new StringBuilder(), location1).toString();
        }
    }

    public static String a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        } else
        {
            return uri.toString();
        }
    }

    public static String a(Iterable iterable)
    {
        return ejj.b(iterable.iterator());
    }

    public static String a(Map map)
    {
        map = (String)map.get("Content-Type");
        if (map != null)
        {
            map = map.split(";");
            for (int i1 = 1; i1 < map.length; i1++)
            {
                String as[] = map[i1].trim().split("=");
                if (as.length == 2 && as[0].equals("charset"))
                {
                    return as[1];
                }
            }

        }
        return "ISO-8859-1";
    }

    public static String a(HttpUriRequest httpurirequest)
    {
        stringbuilder.append(" -d '");
        if (k1 != 0)
        {
            stringbuilder.append("$(printf '");
            stringbuilder.append(httpurirequest.toString());
            stringbuilder.append("')");
        } else
        {
            stringbuilder.append(httpurirequest.toString());
        }
        stringbuilder.append("'");
_L2:
        return stringbuilder.toString();
label0:
        {
            int k1 = 0;
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("curl");
            Header aheader[] = httpurirequest.getAllHeaders();
            int l1 = aheader.length;
            for (int i1 = 0; i1 < l1; i1++)
            {
                Header header = aheader[i1];
                stringbuilder.append(" -H '");
                stringbuilder.append(header.getName().replace("'", "\\'"));
                stringbuilder.append(": ");
                stringbuilder.append(header.getValue().replace("'", "\\'"));
                stringbuilder.append("'");
            }

            stringbuilder.append(" '");
            stringbuilder.append(httpurirequest.getURI());
            stringbuilder.append("'");
            if (httpurirequest instanceof HttpEntityEnclosingRequest)
            {
label1:
                {
                    Object obj = new ByteArrayOutputStream();
                    httpurirequest = ((HttpEntityEnclosingRequest)httpurirequest).getEntity();
                    if (httpurirequest == null)
                    {
                        break label1;
                    }
                    int j1;
                    int i2;
                    byte byte0;
                    try
                    {
                        httpurirequest.writeTo(((OutputStream) (obj)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (HttpUriRequest httpurirequest)
                    {
                        try
                        {
                            ((ByteArrayOutputStream) (obj)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (HttpUriRequest httpurirequest) { }
                        break label1;
                    }
                    finally
                    {
                        try
                        {
                            ((ByteArrayOutputStream) (obj)).close();
                        }
                        catch (IOException ioexception) { }
                        throw httpurirequest;
                    }
                    try
                    {
                        ((ByteArrayOutputStream) (obj)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (HttpUriRequest httpurirequest) { }
                }
                httpurirequest = new StringBuilder();
                obj = ((ByteArrayOutputStream) (obj)).toByteArray();
                i2 = obj.length;
                j1 = 0;
                while (j1 < i2) 
                {
                    byte0 = obj[j1];
                    if (byte0 >= 32 && (char)byte0 != '\'')
                    {
                        httpurirequest.append((char)byte0);
                    } else
                    {
                        k1 = (byte0 + 256) % 256;
                        httpurirequest.append("\\x");
                        if (k1 < 16)
                        {
                            httpurirequest.append('0');
                        }
                        httpurirequest.append(Integer.toString(k1, 16));
                        k1 = 1;
                    }
                    j1++;
                }
                break label0;
            }
        }
        if (!httpurirequest.getMethod().equals("GET"))
        {
            stringbuilder.append(" -X ");
            stringbuilder.append(httpurirequest.getMethod());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String a(Attributes attributes, String as[])
    {
        for (int i1 = 0; i1 < as.length; i1++)
        {
            String s1 = attributes.getValue(as[i1]);
            if (s1 != null)
            {
                return s1;
            }
        }

        return null;
    }

    public static Throwable a(Throwable throwable, Throwable throwable1)
    {
        if (throwable1 == null)
        {
            return throwable;
        }
        Throwable throwable2;
        for (throwable2 = throwable; throwable2.getCause() != null; throwable2 = throwable2.getCause()) { }
        StackTraceElement astacktraceelement[] = throwable2.getStackTrace();
        throwable1 = throwable1.getStackTrace();
        StackTraceElement astacktraceelement1[] = new StackTraceElement[astacktraceelement.length + throwable1.length];
        System.arraycopy(astacktraceelement, 0, astacktraceelement1, 0, astacktraceelement.length);
        System.arraycopy(throwable1, 0, astacktraceelement1, astacktraceelement.length, throwable1.length);
        throwable2.setStackTrace(astacktraceelement1);
        return throwable;
    }

    public static Key a(SharedPreferences sharedpreferences, bmw bmw1)
    {
        if (!sharedpreferences.contains("downloads_encryption_key"))
        {
            sharedpreferences.edit().putString("downloads_encryption_key", Base64.encodeToString(a(bmw1).getEncoded(), 0)).apply();
        }
        return new SecretKeySpec(Base64.decode(sharedpreferences.getString("downloads_encryption_key", null), 0), "AES");
    }

    public static Key a(bmw bmw1)
    {
        try
        {
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            keygenerator.init(128, bmw1.a());
            bmw1 = keygenerator.generateKey();
        }
        // Misplaced declaration of an exception variable
        catch (bmw bmw1)
        {
            bmo.a("AES not recognized as a supported algorithm", bmw1);
            return null;
        }
        return bmw1;
    }

    public static ArrayList a(Iterator iterator)
    {
        f.b(iterator);
        ArrayList arraylist = new ArrayList();
        for (; iterator.hasNext(); arraylist.add(iterator.next())) { }
        return arraylist;
    }

    public static transient ArrayList a(Object aobj[])
    {
        b.a(((Object) (aobj)));
        ArrayList arraylist = new ArrayList(1);
        Collections.addAll(arraylist, aobj);
        return arraylist;
    }

    public static List a(String s1, int i1)
    {
        ArrayList arraylist = new ArrayList();
        int l1 = s1.length() / 2048;
        for (i1 = 0; i1 < l1 + 1; i1++)
        {
            int k1 = i1 + 1 << 11;
            int j1 = k1;
            if (k1 >= s1.length())
            {
                j1 = s1.length();
            }
            arraylist.add(s1.substring(i1 << 11, j1));
        }

        return arraylist;
    }

    public static List a(List list)
    {
        if (list == null || list == Collections.EMPTY_LIST)
        {
            return Collections.emptyList();
        } else
        {
            return Collections.unmodifiableList(list);
        }
    }

    public static Locale a(String s1, Locale locale)
    {
        if (s1 == null || TextUtils.isEmpty(s1))
        {
            return locale;
        }
        int i1 = s1.indexOf('_');
        if (i1 == -1)
        {
            return new Locale(s1);
        }
        locale = s1.substring(0, i1);
        i1++;
        int j1 = s1.indexOf('_', i1);
        if (j1 == -1)
        {
            return new Locale(locale, s1.substring(i1));
        }
        String s2 = s1.substring(i1, j1);
        i1 = j1 + 1;
        j1 = s1.indexOf('_', i1);
        if (j1 == -1)
        {
            s1 = s1.substring(i1);
        } else
        {
            s1 = s1.substring(i1, j1);
        }
        return new Locale(locale, s2, s1);
    }

    public static Set a(Map map, Object obj)
    {
        if (!map.containsKey(obj))
        {
            return new HashSet();
        } else
        {
            return (Set)map.get(obj);
        }
    }

    public static Set a(Set set)
    {
        if (set == null || set == Collections.EMPTY_SET)
        {
            return Collections.emptySet();
        } else
        {
            return Collections.unmodifiableSet(set);
        }
    }

    public static ls a(mb mb1)
    {
        int i1 = 0;
        long l4 = 0L;
        long l5 = System.currentTimeMillis();
        Map map = mb1.c;
        String s1 = (String)map.get("Date");
        String as[];
        Object obj;
        Exception exception;
        long l1;
        long l2;
        long l3;
        if (s1 != null)
        {
            l2 = a(s1);
        } else
        {
            l2 = 0L;
        }
        s1 = (String)map.get("Cache-Control");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        as = s1.split(",");
        i1 = 0;
        l1 = 0L;
        if (i1 >= as.length) goto _L2; else goto _L1
_L1:
        obj = as[i1].trim();
        if (((String) (obj)).equals("no-cache") || ((String) (obj)).equals("no-store"))
        {
            return null;
        }
        if (!((String) (obj)).startsWith("max-age=")) goto _L4; else goto _L3
_L3:
        l3 = Long.parseLong(((String) (obj)).substring(8));
        l1 = l3;
_L5:
        i1++;
        break MISSING_BLOCK_LABEL_70;
_L4:
        if (((String) (obj)).equals("must-revalidate") || ((String) (obj)).equals("proxy-revalidate"))
        {
            l1 = 0L;
        }
          goto _L5
_L2:
        i1 = 1;
_L10:
        as = (String)map.get("Expires");
        if (as != null)
        {
            l3 = a(((String) (as)));
        } else
        {
            l3 = 0L;
        }
        as = (String)map.get("ETag");
        if (i1 == 0) goto _L7; else goto _L6
_L6:
        l1 = 1000L * l1 + l5;
_L9:
        obj = new ls();
        obj.a = mb1.b;
        obj.b = as;
        obj.e = l1;
        obj.d = ((ls) (obj)).e;
        obj.c = l2;
        obj.f = map;
        return ((ls) (obj));
_L7:
        l1 = l4;
        if (l2 > 0L)
        {
            l1 = l4;
            if (l3 >= l2)
            {
                l1 = (l3 - l2) + l5;
            }
        }
        if (true) goto _L9; else goto _L8
_L8:
        exception;
          goto _L5
        l1 = 0L;
          goto _L10
    }

    public static HttpClient a(String s1, bml bml1, bkd bkd1)
    {
        b.a(bkd1);
        try
        {
            bml1.a();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bmo.b("googlePlayProviderInstaller failed to install.", s1);
            return new bko();
        }
        bml1 = String.valueOf(s1);
        if (bml1.length() != 0)
        {
            bml1 = "HttpClient.UserAgent: ".concat(bml1);
        } else
        {
            bml1 = new String("HttpClient.UserAgent: ");
        }
        bmo.e(bml1);
        bml1 = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(bml1, false);
        HttpConnectionParams.setConnectionTimeout(bml1, bkd1.b);
        HttpConnectionParams.setSoTimeout(bml1, bkd1.c);
        HttpConnectionParams.setSocketBufferSize(bml1, 8192);
        HttpClientParams.setRedirecting(bml1, true);
        HttpProtocolParams.setUserAgent(bml1, String.valueOf(s1).concat(" gzip"));
        s1 = new SchemeRegistry();
        s1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try
        {
            s1.register(new Scheme("https", new SSLSocketFactory(null, null), 443));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bmo.b("Failed to create SSLSocketFactory.", s1);
            throw new IllegalStateException();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bmo.b("Failed to create SSLSocketFactory.", s1);
            throw new IllegalStateException();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bmo.b("Failed to create SSLSocketFactory.", s1);
            throw new IllegalStateException();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            bmo.b("Failed to create SSLSocketFactory.", s1);
            throw new IllegalStateException();
        }
        ConnManagerParams.setMaxConnectionsPerRoute(bml1, new ConnPerRouteBean(16));
        s1 = new DefaultHttpClient(new ThreadSafeClientConnManager(bml1, s1), bml1);
        s1.addRequestInterceptor(new bkw(bkd1));
        if (bkd1.a)
        {
            s1.addRequestInterceptor(new bka());
        }
        s1.addResponseInterceptor(new bkb());
        s1.setCookieStore(new bjz());
        return s1;
    }

    public static JSONObject a(eun eun1)
    {
        Object obj;
        JSONObject jsonobject;
        obj = eun1.getClass();
        jsonobject = new JSONObject();
        Field afield[];
        int j1;
        afield = ((Class) (obj)).getDeclaredFields();
        j1 = afield.length;
        int i1 = 0;
_L30:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        Object obj1 = afield[i1];
        ((Field) (obj1)).setAccessible(true);
        obj = ((Field) (obj1)).getName();
        if ("EMPTY_ARRAY".equals(obj)) goto _L4; else goto _L3
_L3:
        if (!((Field) (obj1)).getType().isArray()) goto _L6; else goto _L5
_L5:
        obj1 = a(((Field) (obj1)), eun1);
        if (obj1 == null) goto _L4; else goto _L7
_L7:
        jsonobject.put(((String) (obj)), obj1);
          goto _L4
_L6:
        if (!(eun1 instanceof dhf) || !((String) (obj)).equals("clientName")) goto _L9; else goto _L8
_L8:
        int k1 = ((Field) (obj1)).getInt(eun1);
        k1;
        JVM INSTR lookupswitch 7: default 505
    //                   3: 277
    //                   14: 508
    //                   18: 522
    //                   20: 515
    //                   21: 536
    //                   23: 529
    //                   24: 543;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L17:
        break MISSING_BLOCK_LABEL_543;
_L10:
        obj = (new StringBuilder(69)).append("UNKNOWN_PLEASE_EDIT_ProtoToJsonConverterForDebugOnly_java_").append(k1).toString();
_L20:
        jsonobject.put("clientName", obj);
          goto _L4
_L26:
        eun1 = String.valueOf(eun1.getClass().getSimpleName());
        if (eun1.length() == 0) goto _L19; else goto _L18
_L18:
        eun1 = "Exception while trying to convert protoMessage: ".concat(eun1);
_L29:
        bmo.a(eun1, ((Throwable) (obj)));
        eun1 = new JSONObject();
        eun1.put("PROTO CONVERSION FAILED", "See error logs and file bug.");
        return eun1;
_L11:
        obj = "ANDROID";
          goto _L20
_L9:
        if (!((Field) (obj1)).getType().equals(java/lang/String)) goto _L22; else goto _L21
_L21:
        boolean flag;
        if (!TextUtils.isEmpty((String)((Field) (obj1)).get(eun1)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L23
_L23:
        obj1 = ((Field) (obj1)).get(eun1);
        if (!(obj1 instanceof eun)) goto _L25; else goto _L24
_L24:
        jsonobject.put(((String) (obj)), a((eun)obj1));
          goto _L4
_L22:
        if (!((Field) (obj1)).getType().equals(Integer.TYPE))
        {
            break MISSING_BLOCK_LABEL_383;
        }
        if (((Field) (obj1)).getInt(eun1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        break MISSING_BLOCK_LABEL_316;
        try
        {
label0:
            {
                if (!((Field) (obj1)).getType().equals(Boolean.TYPE))
                {
                    break label0;
                }
                flag = ((Field) (obj1)).getBoolean(eun1);
            }
            break MISSING_BLOCK_LABEL_316;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L26
        if (((Field) (obj1)).get(eun1) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        break MISSING_BLOCK_LABEL_316;
_L25:
        if (!(obj1 instanceof byte[])) goto _L28; else goto _L27
_L27:
        jsonobject.put(((String) (obj)), new String(Base64.encode((byte[])obj1, 0)));
          goto _L4
_L28:
        jsonobject.put(((String) (obj)), obj1);
          goto _L4
_L19:
        try
        {
            eun1 = new String("Exception while trying to convert protoMessage: ");
        }
        // Misplaced declaration of an exception variable
        catch (eun eun1)
        {
            throw new RuntimeException("This should never happen.", eun1);
        }
          goto _L29
_L2:
        return jsonobject;
_L4:
        i1++;
          goto _L30
_L12:
        obj = "ANDROID_CREATOR";
          goto _L20
_L14:
        obj = "ANDROID_INSTANT";
          goto _L20
_L13:
        obj = "ANDROID_KIDS";
          goto _L20
_L16:
        obj = "ANDROID_TV";
          goto _L20
_L15:
        obj = "ANDROID_MUSIC";
          goto _L20
        obj = "ANDROID_GAMING";
          goto _L20
    }

    public static void a(android.app.Notification.Builder builder, bh bh1)
    {
        android.app.Notification.Action.Builder builder1 = new android.app.Notification.Action.Builder(bh1.a(), bh1.b(), bh1.c());
        if (bh1.e() != null)
        {
            RemoteInput aremoteinput[] = a(bh1.e());
            int j1 = aremoteinput.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                builder1.addRemoteInput(aremoteinput[i1]);
            }

        }
        if (bh1.d() != null)
        {
            builder1.addExtras(bh1.d());
        }
        builder.addAction(builder1.build());
    }

    public static void a(Parcel parcel, int i1, int j1)
    {
        i1 = a(parcel, i1);
        if (i1 != j1)
        {
            throw new l((new StringBuilder("Expected size ")).append(j1).append(" got ").append(i1).append(" (0x").append(Integer.toHexString(i1)).append(")").toString(), parcel);
        } else
        {
            return;
        }
    }

    public static void a(Parcel parcel, int i1, Parcelable parcelable, int j1, boolean flag)
    {
        if (parcelable == null)
        {
            return;
        } else
        {
            i1 = g(parcel, i1);
            parcelable.writeToParcel(parcel, j1);
            h(parcel, i1);
            return;
        }
    }

    public static void a(Parcel parcel, int i1, String s1, boolean flag)
    {
        if (s1 == null)
        {
            return;
        } else
        {
            i1 = g(parcel, i1);
            parcel.writeString(s1);
            h(parcel, i1);
            return;
        }
    }

    public static void a(Parcel parcel, int i1, List list, boolean flag)
    {
        if (list == null)
        {
            return;
        } else
        {
            i1 = g(parcel, i1);
            parcel.writeStringList(list);
            h(parcel, i1);
            return;
        }
    }

    public static void a(Parcel parcel, int i1, boolean flag)
    {
        b(parcel, i1, 4);
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
    }

    public static void a(Parcel parcel, eug eug1)
    {
        if (eug1 == null)
        {
            eug1 = null;
        } else
        {
            eug1 = eug1.c();
        }
        parcel.writeByteArray(eug1);
    }

    public static void a(Parcel parcel, eun eun1)
    {
        if (eun1 == null)
        {
            eun1 = null;
        } else
        {
            eun1 = eun.a(eun1);
        }
        parcel.writeByteArray(eun1);
    }

    public static void a(awn awn)
    {
        if (!(awn instanceof awm));
    }

    public static void a(bnr bnr1, String s1)
    {
        cce.d(bnr1, String.valueOf(s1).concat("/entry/content/entry"));
        bnr1.a(String.valueOf(s1).concat("/entry/content/entry"), new cad()).a(String.valueOf(s1).concat("/entry/yt:when"), new cac()).a(String.valueOf(s1).concat("/entry/yt:status"), new cab()).a(String.valueOf(s1).concat("/entry/link"), new caa());
    }

    public static void a(ejx ejx1, ObjectInputStream objectinputstream, int i1)
    {
        for (int j1 = 0; j1 < i1; j1++)
        {
            Collection collection = ejx1.b(objectinputstream.readObject());
            int l1 = objectinputstream.readInt();
            for (int k1 = 0; k1 < l1; k1++)
            {
                collection.add(objectinputstream.readObject());
            }

        }

    }

    public static void a(ejx ejx1, ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeInt(ejx1.f().size());
        for (ejx1 = ejx1.f().entrySet().iterator(); ejx1.hasNext();)
        {
            Object obj = (java.util.Map.Entry)ejx1.next();
            objectoutputstream.writeObject(((java.util.Map.Entry) (obj)).getKey());
            objectoutputstream.writeInt(((Collection)((java.util.Map.Entry) (obj)).getValue()).size());
            obj = ((Collection)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                objectoutputstream.writeObject(((Iterator) (obj)).next());
            }
        }

    }

    public static void a(CharSequence charsequence, File file, Charset charset)
    {
        charset = new emk(new emv(file, new emu[0]), charset);
        f.b(charsequence);
        file = emq.a();
        ((Writer)file.a(charset.a())).append(charsequence);
        file.close();
        return;
        charsequence;
        throw file.a(charsequence);
        charsequence;
        file.close();
        throw charsequence;
    }

    public static void a(Object obj, View view)
    {
        ((Transition)obj).setEpicenterCallback(new ad(a(view)));
    }

    public static void a(Object obj, View view, boolean flag)
    {
        ((Transition)obj).excludeTarget(view, flag);
    }

    public static void a(Object obj, Object obj1)
    {
        ((MediaRouter)obj).removeCallback((android.media.MediaRouter.Callback)obj1);
    }

    public static void a(Object obj, Object obj1, View view, ai ai1, View view1, ah ah, Map map, ArrayList arraylist, 
            Map map1, ArrayList arraylist1)
    {
        if (obj != null || obj1 != null)
        {
            obj = (Transition)obj;
            if (obj != null)
            {
                ((Transition) (obj)).addTarget(view1);
            }
            if (obj1 != null)
            {
                b((Transition)obj1, arraylist1);
            }
            view.getViewTreeObserver().addOnPreDrawListener(new ae(view, ai1, map, map1, ((Transition) (obj)), arraylist));
            if (obj != null)
            {
                ((Transition) (obj)).setEpicenterCallback(new af(ah));
            }
        }
    }

    public static void a(Object obj, StringBuilder stringbuilder)
    {
        String s1;
label0:
        {
            if (obj == null)
            {
                stringbuilder.append("null");
                return;
            }
            String s2 = obj.getClass().getSimpleName();
            if (s2 != null)
            {
                s1 = s2;
                if (s2.length() > 0)
                {
                    break label0;
                }
            }
            s2 = obj.getClass().getName();
            int i1 = s2.lastIndexOf('.');
            s1 = s2;
            if (i1 > 0)
            {
                s1 = s2.substring(i1 + 1);
            }
        }
        stringbuilder.append(s1);
        stringbuilder.append('{');
        stringbuilder.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void a(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        int j1 = arraylist.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((Transition) (obj)).removeTarget((View)arraylist.get(i1));
        }

    }

    public static void a(String s1, bgc bgc1)
    {
        if ("linear".equalsIgnoreCase(s1))
        {
            bgc1.c = true;
        } else
        {
            if ("nonlinear".equalsIgnoreCase(s1))
            {
                bgc1.d = true;
                return;
            }
            if ("display".equalsIgnoreCase(s1))
            {
                bgc1.e = true;
                return;
            }
        }
    }

    public static void a(String s1, Object obj, StringBuffer stringbuffer, StringBuffer stringbuffer1)
    {
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof eun)) goto _L4; else goto _L3
_L3:
        Class class1;
        Method amethod[];
        int i1;
        int l1;
        int j2;
        j2 = stringbuffer.length();
        if (s1 != null)
        {
            stringbuffer1.append(stringbuffer).append(v(s1)).append(" <\n");
            stringbuffer.append("  ");
        }
        class1 = obj.getClass();
        Field afield[] = class1.getFields();
        int k2 = afield.length;
        i1 = 0;
        while (i1 < k2) 
        {
            Object obj2 = afield[i1];
            int j1 = ((Field) (obj2)).getModifiers();
            String s2 = ((Field) (obj2)).getName();
            if ((j1 & 1) == 1 && (j1 & 8) != 8 && !s2.startsWith("_") && !s2.endsWith("_"))
            {
                Class class2 = ((Field) (obj2)).getType();
                obj2 = ((Field) (obj2)).get(obj);
                if (class2.isArray())
                {
                    if (class2.getComponentType() == Byte.TYPE)
                    {
                        a(s2, obj2, stringbuffer, stringbuffer1);
                    } else
                    {
                        int k1;
                        int i2;
                        if (obj2 == null)
                        {
                            k1 = 0;
                        } else
                        {
                            k1 = Array.getLength(obj2);
                        }
                        i2 = 0;
                        while (i2 < k1) 
                        {
                            a(s2, Array.get(obj2, i2), stringbuffer, stringbuffer1);
                            i2++;
                        }
                    }
                } else
                {
                    a(s2, obj2, stringbuffer, stringbuffer1);
                }
            }
            i1++;
        }
        amethod = class1.getMethods();
        l1 = amethod.length;
        i1 = 0;
_L15:
        Object obj1;
        if (i1 >= l1)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        obj1 = amethod[i1].getName();
        if (!((String) (obj1)).startsWith("set")) goto _L6; else goto _L5
_L5:
        String s3 = ((String) (obj1)).substring(3);
        obj1 = String.valueOf(s3);
        if (((String) (obj1)).length() == 0) goto _L8; else goto _L7
_L7:
        obj1 = "has".concat(((String) (obj1)));
_L12:
        obj1 = class1.getMethod(((String) (obj1)), new Class[0]);
        if (!((Boolean)((Method) (obj1)).invoke(obj, new Object[0])).booleanValue()) goto _L6; else goto _L9
_L9:
        obj1 = String.valueOf(s3);
        if (((String) (obj1)).length() == 0) goto _L11; else goto _L10
_L10:
        obj1 = "get".concat(((String) (obj1)));
_L13:
        obj1 = class1.getMethod(((String) (obj1)), new Class[0]);
        a(s3, ((Method) (obj1)).invoke(obj, new Object[0]), stringbuffer, stringbuffer1);
_L6:
        i1++;
        continue; /* Loop/switch isn't completed */
_L8:
        obj1 = new String("has");
          goto _L12
        obj1;
          goto _L6
_L11:
        obj1 = new String("get");
          goto _L13
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
          goto _L6
        if (s1 != null)
        {
            stringbuffer.setLength(j2);
            stringbuffer1.append(stringbuffer).append(">\n");
        }
_L2:
        return;
_L4:
        s1 = v(s1);
        stringbuffer1.append(stringbuffer).append(s1).append(": ");
        if (obj instanceof String)
        {
            obj = (String)obj;
            s1 = ((String) (obj));
            if (!((String) (obj)).startsWith("http"))
            {
                s1 = ((String) (obj));
                if (((String) (obj)).length() > 200)
                {
                    s1 = String.valueOf(((String) (obj)).substring(0, 200)).concat("[...]");
                }
            }
            s1 = w(s1);
            stringbuffer1.append("\"").append(s1).append("\"");
        } else
        if (obj instanceof byte[])
        {
            a((byte[])obj, stringbuffer1);
        } else
        {
            stringbuffer1.append(obj);
        }
        stringbuffer1.append("\n");
        return;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public static void a(Throwable throwable)
    {
        a(throwable, java/lang/Error);
        a(throwable, java/lang/RuntimeException);
    }

    public static void a(Throwable throwable, Class class1)
    {
        if (throwable != null && class1.isInstance(throwable))
        {
            throw (Throwable)class1.cast(throwable);
        } else
        {
            return;
        }
    }

    public static void a(HttpURLConnection httpurlconnection)
    {
        try
        {
            httpurlconnection.connect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            throw new IOException(httpurlconnection);
        }
    }

    static void a(ArrayList arraylist, View view)
    {
label0:
        {
            if (view.getVisibility() == 0)
            {
                if (!(view instanceof ViewGroup))
                {
                    break label0;
                }
                view = (ViewGroup)view;
                if (view.isTransitionGroup())
                {
                    arraylist.add(view);
                } else
                {
                    int j1 = view.getChildCount();
                    int i1 = 0;
                    while (i1 < j1) 
                    {
                        a(arraylist, view.getChildAt(i1));
                        i1++;
                    }
                }
            }
            return;
        }
        arraylist.add(view);
    }

    public static void a(Map map, View view)
    {
        if (view.getVisibility() == 0)
        {
            String s1 = view.getTransitionName();
            if (s1 != null)
            {
                map.put(s1, view);
            }
            if (view instanceof ViewGroup)
            {
                view = (ViewGroup)view;
                int j1 = view.getChildCount();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    a(map, view.getChildAt(i1));
                }

            }
        }
    }

    public static void a(Map map, Object obj, Object obj1)
    {
        Set set = (Set)map.get(obj);
        Object obj2 = set;
        if (set == null)
        {
            obj2 = new HashSet();
            map.put(obj, obj2);
        }
        ((Set) (obj2)).add(obj1);
    }

    public static void a(HttpResponse httpresponse)
    {
        if (httpresponse == null || httpresponse.getEntity() == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        httpresponse.getEntity().consumeContent();
        return;
        Exception exception;
        exception;
        try
        {
            httpresponse.getEntity().getContent().close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            return;
        }
    }

    public static void a(boolean flag)
    {
        if (!flag)
        {
            throw new IllegalArgumentException();
        } else
        {
            return;
        }
    }

    public static void a(boolean flag, Object obj)
    {
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf(obj));
        } else
        {
            return;
        }
    }

    public static void a(byte abyte0[], int i1, int j1, Key key, IvParameterSpec ivparameterspec, long l1)
    {
        long l2 = l1 / 16L;
        int j2 = (int)(l1 % 16L);
        byte abyte1[] = new byte[j2 + j1];
        for (int k1 = 0; k1 < j1; k1++)
        {
            abyte1[j2 + k1] = abyte0[i1 + k1];
        }

        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        ivparameterspec = ByteBuffer.wrap(ivparameterspec.getIV());
        ivparameterspec.order(ByteOrder.BIG_ENDIAN);
        ivparameterspec.putLong(8, l2 + ivparameterspec.getLong(8));
        cipher.init(2, key, new IvParameterSpec(ivparameterspec.array()));
        key = cipher.doFinal(abyte1);
        for (int i2 = 0; i2 < j1; i2++)
        {
            abyte0[i1 + i2] = key[j2 + i2];
        }

    }

    public static void a(byte abyte0[], StringBuffer stringbuffer)
    {
        if (abyte0 == null)
        {
            stringbuffer.append("\"\"");
            return;
        }
        stringbuffer.append('"');
        int i1 = 0;
        while (i1 < abyte0.length) 
        {
            int j1 = abyte0[i1] & 0xff;
            if (j1 == 92 || j1 == 34)
            {
                stringbuffer.append('\\').append((char)j1);
            } else
            if (j1 >= 32 && j1 < 127)
            {
                stringbuffer.append((char)j1);
            } else
            {
                stringbuffer.append(String.format("\\%03o", new Object[] {
                    Integer.valueOf(j1)
                }));
            }
            i1++;
        }
        stringbuffer.append('"');
    }

    public static boolean a(int i1)
    {
        return android.os.Build.VERSION.SDK_INT >= i1;
    }

    public static boolean a(Context context, bmj bmj1)
    {
        return (c(context, 720) || c(context)) && bmj1.f();
    }

    public static boolean a(Context context, String s1)
    {
        return f(context).equals(s1);
    }

    public static boolean a(Comparator comparator, Iterable iterable)
    {
        f.b(comparator);
        f.b(iterable);
        if (iterable instanceof SortedSet)
        {
            Comparator comparator1 = ((SortedSet)iterable).comparator();
            iterable = comparator1;
            if (comparator1 == null)
            {
                iterable = ekb.a();
            }
        } else
        if (iterable instanceof ela)
        {
            iterable = ((ela)iterable).comparator();
        } else
        {
            return false;
        }
        return comparator.equals(iterable);
    }

    public static boolean a(List list, Object obj)
    {
        if (obj != f.b(list))
        {
            if (!(obj instanceof List))
            {
                return false;
            }
            obj = (List)obj;
            if (list.size() != ((List) (obj)).size() || !ejj.a(list.iterator(), ((List) (obj)).iterator()))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Set set, Object obj)
    {
        if (set != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof Set))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj = (Set)obj;
        boolean flag;
        try
        {
            if (set.size() != ((Set) (obj)).size())
            {
                break; /* Loop/switch isn't completed */
            }
            flag = set.containsAll(((Collection) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Set set)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Set set)
        {
            return false;
        }
        if (flag) goto _L1; else goto _L3
_L3:
        return false;
        return false;
    }

    public static boolean a(Set set, Collection collection)
    {
        boolean flag2 = false;
        boolean flag = false;
        f.b(collection);
        Object obj = collection;
        if (collection instanceof ejy)
        {
            obj = ((ejy)collection).a();
        }
        if ((obj instanceof Set) && ((Collection) (obj)).size() > set.size())
        {
            set = set.iterator();
            do
            {
                flag2 = flag;
                if (!set.hasNext())
                {
                    break;
                }
                if (((Collection) (obj)).contains(set.next()))
                {
                    flag = true;
                    set.remove();
                }
            } while (true);
        } else
        {
            collection = ((Collection) (obj)).iterator();
            boolean flag1 = flag2;
            do
            {
                flag2 = flag1;
                if (!collection.hasNext())
                {
                    break;
                }
                flag1 |= set.remove(collection.next());
            } while (true);
        }
        return flag2;
    }

    public static byte[] a(File file)
    {
        return (new emw(file)).b();
    }

    public static byte[] a(byte abyte0[], int i1)
    {
        boolean flag1 = true;
        int j1;
        boolean flag;
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (i1 > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.a(flag);
        j1 = abyte0.length % i1;
        if (j1 == 0)
        {
            return (byte[])abyte0.clone();
        } else
        {
            return b(abyte0, (i1 - j1) + abyte0.length);
        }
    }

    public static byte[] a(byte abyte0[], int i1, byte byte0)
    {
        byte abyte1[] = a(abyte0, 188);
        for (i1 = abyte0.length; i1 < abyte1.length; i1++)
        {
            abyte1[i1] = -1;
        }

        return abyte1;
    }

    public static byte[] a(byte abyte0[], int i1, int j1)
    {
        boolean flag1 = true;
        byte abyte1[];
        boolean flag;
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (i1 >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (j1 >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.a(flag);
        abyte1 = new byte[j1];
        System.arraycopy(abyte0, i1, abyte1, 0, j1);
        return abyte1;
    }

    public static transient byte[] a(byte abyte0[][])
    {
        boolean flag = false;
        int l1 = abyte0.length;
        int i1 = 0;
        int k1 = 0;
        for (; i1 < l1; i1++)
        {
            k1 += abyte0[i1].length;
        }

        ByteBuffer bytebuffer = ByteBuffer.allocate(k1);
        k1 = abyte0.length;
        for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
        {
            bytebuffer.put(abyte0[j1]);
        }

        return bytebuffer.array();
    }

    public static transient int[] a(int ai1[], int ai2[])
    {
        int ai3[] = Arrays.copyOf(ai1, ai1.length + ai2.length);
        System.arraycopy(ai2, 0, ai3, ai1.length, ai2.length);
        return ai3;
    }

    static RemoteInput[] a(br abr[])
    {
        if (abr == null)
        {
            return null;
        }
        RemoteInput aremoteinput[] = new RemoteInput[abr.length];
        for (int i1 = 0; i1 < abr.length; i1++)
        {
            br br1 = abr[i1];
            aremoteinput[i1] = (new android.app.RemoteInput.Builder(br1.a())).setLabel(br1.b()).setChoices(br1.c()).setAllowFreeFormInput(br1.d()).addExtras(br1.e()).build();
        }

        return aremoteinput;
    }

    public static Object[] a(Iterable iterable, Class class1)
    {
        if (iterable instanceof Collection)
        {
            iterable = (Collection)iterable;
        } else
        {
            iterable = a(iterable.iterator());
        }
        return iterable.toArray(eka.a(class1, iterable.size()));
    }

    public static Object[] a(Object aobj[], int i1)
    {
        return (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i1);
    }

    public static transient Object[] a(Object aobj[], Object aobj1[])
    {
        Object aobj2[] = Arrays.copyOf(aobj, aobj.length + aobj1.length);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), aobj.length, aobj1.length);
        return aobj2;
    }

    public static int b(CharSequence charsequence, int i1, int j1)
    {
        for (; i1 < j1; i1++)
        {
            if (!Character.isWhitespace(charsequence.charAt(i1)))
            {
                return i1;
            }
        }

        return -1;
    }

    public static int b(String s1, int i1)
    {
        int j1 = i1;
        if (s1 != null)
        {
            try
            {
                j1 = Integer.valueOf(s1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return i1;
            }
        }
        return j1;
    }

    public static int b(List list, Object obj)
    {
        for (list = list.listIterator(); list.hasNext();)
        {
            if (f.a(obj, list.next()))
            {
                return list.previousIndex();
            }
        }

        return -1;
    }

    public static long b(String s1)
    {
        long l1 = 0L;
        if (s1 != null) goto _L2; else goto _L1
_L1:
        long l2 = l1;
_L4:
        return l2;
_L2:
        int i1 = 0;
        do
        {
            l2 = l1;
            if (i1 >= s1.length())
            {
                continue;
            }
            l1 ^= s1.charAt(i1);
            l1 += (l1 << 1) + (l1 << 4) + (l1 << 5) + (l1 << 7) + (l1 << 8) + (l1 << 40);
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Drawable b(Context context, int i1)
    {
        i1 = a(context, i1);
        if (i1 != 0)
        {
            return context.getResources().getDrawable(i1);
        } else
        {
            return null;
        }
    }

    public static dar b(String s1, boolean flag)
    {
        emx emx1 = (new emx()).a((new StringBuilder()).append(s1).append("-%d").toString());
        f.a(true, "Thread priority (%s) must be >= %s", new Object[] {
            Integer.valueOf(10), Integer.valueOf(1)
        });
        f.a(true, "Thread priority (%s) must be <= %s", new Object[] {
            Integer.valueOf(10), Integer.valueOf(10)
        });
        emx1.a = Integer.valueOf(10);
        return new dar(s1, 1, emx1.a(), false, false);
    }

    public static eug b(Parcel parcel, eug eug1)
    {
        parcel = parcel.createByteArray();
        if (parcel == null)
        {
            return null;
        } else
        {
            eug1.a(parcel);
            return eug1;
        }
    }

    public static eun b(Parcel parcel, eun eun1)
    {
        parcel = parcel.createByteArray();
        if (parcel == null)
        {
            return null;
        } else
        {
            return eun.a(eun1, parcel);
        }
    }

    public static exf b(ewk ewk)
    {
        return (new exf()).a(0).a((new exl()).a(ewk));
    }

    public static Object b(Iterable iterable)
    {
        return ejj.c(iterable.iterator());
    }

    public static Object b(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        } else
        {
            return obj;
        }
    }

    public static Object b(Object obj, Object obj1)
    {
        return ((MediaRouter)obj).createUserRoute((android.media.MediaRouter.RouteCategory)obj1);
    }

    public static RuntimeException b(Throwable throwable)
    {
        a((Throwable)f.b(throwable));
        throw new RuntimeException(throwable);
    }

    public static String b(Context context)
    {
        if (e == null)
        {
            e = String.valueOf(bcf.a(context.getContentResolver(), "android_id", 0L));
        }
        return e;
    }

    public static String b(eun eun1)
    {
        if (eun1 == null)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer();
        try
        {
            a(((String) (null)), eun1, new StringBuffer(), stringbuffer);
        }
        // Misplaced declaration of an exception variable
        catch (eun eun1)
        {
            eun1 = String.valueOf(eun1.getMessage());
            if (eun1.length() != 0)
            {
                return "Error printing proto: ".concat(eun1);
            } else
            {
                return new String("Error printing proto: ");
            }
        }
        // Misplaced declaration of an exception variable
        catch (eun eun1)
        {
            eun1 = String.valueOf(eun1.getMessage());
            if (eun1.length() != 0)
            {
                return "Error printing proto: ".concat(eun1);
            } else
            {
                return new String("Error printing proto: ");
            }
        }
        return stringbuffer.toString();
    }

    public static ArrayList b(Parcel parcel, int i1, android.os.Parcelable.Creator creator)
    {
        i1 = a(parcel, i1);
        int j1 = parcel.dataPosition();
        if (i1 == 0)
        {
            return null;
        } else
        {
            creator = parcel.createTypedArrayList(creator);
            parcel.setDataPosition(i1 + j1);
            return creator;
        }
    }

    public static Set b(Set set)
    {
        HashSet hashset = new HashSet(set.size());
        for (set = set.iterator(); set.hasNext(); hashset.add(((String)set.next()).toLowerCase(Locale.US))) { }
        return hashset;
    }

    public static transient Set b(Object aobj[])
    {
        HashSet hashset = new HashSet(aobj.length);
        Collections.addAll(hashset, aobj);
        return a(hashset);
    }

    public static HttpClient b(int i1, int j1)
    {
        Object obj = new bke();
        obj.b = i1;
        obj.c = j1;
        obj.a = false;
        obj.d = r;
        obj.e = q;
        obj = ((bke) (obj)).a();
        return a(o, p, ((bkd) (obj)));
    }

    public static void b(Parcel parcel, int i1)
    {
        parcel.setDataPosition(a(parcel, i1) + parcel.dataPosition());
    }

    public static void b(Parcel parcel, int i1, int j1)
    {
        if (j1 >= 65535)
        {
            parcel.writeInt(0xffff0000 | i1);
            parcel.writeInt(j1);
            return;
        } else
        {
            parcel.writeInt(j1 << 16 | i1);
            return;
        }
    }

    public static void b(Parcel parcel, int i1, List list, boolean flag)
    {
        if (list == null)
        {
            return;
        }
        int j1 = g(parcel, i1);
        int k1 = list.size();
        parcel.writeInt(k1);
        i1 = 0;
        while (i1 < k1) 
        {
            Parcelable parcelable = (Parcelable)list.get(i1);
            if (parcelable == null)
            {
                parcel.writeInt(0);
            } else
            {
                int l1 = parcel.dataPosition();
                parcel.writeInt(1);
                int i2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int j2 = parcel.dataPosition();
                parcel.setDataPosition(l1);
                parcel.writeInt(j2 - i2);
                parcel.setDataPosition(j2);
            }
            i1++;
        }
        h(parcel, j1);
    }

    public static void b(bnr bnr1, String s1)
    {
        bnr1.a(String.valueOf(s1).concat("/summary"), new cas()).a(String.valueOf(s1).concat("/content"), new car()).a(String.valueOf(s1).concat("/link"), new caq()).a(String.valueOf(s1).concat("/yt:countHint"), new cap());
        c(bnr1, s1);
    }

    public static void b(Object obj, int i1)
    {
        ((android.media.MediaRouter.UserRouteInfo)obj).setPlaybackType(i1);
    }

    public static void b(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        int j1 = arraylist.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((Transition) (obj)).addTarget((View)arraylist.get(i1));
        }

    }

    public static void b(Throwable throwable, Class class1)
    {
        a(throwable, class1);
        a(throwable);
    }

    public static void b(boolean flag)
    {
        if (!flag)
        {
            throw new IllegalStateException();
        } else
        {
            return;
        }
    }

    public static void b(boolean flag, Object obj)
    {
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf(obj));
        } else
        {
            return;
        }
    }

    public static boolean b()
    {
        boolean flag1;
        flag1 = true;
        if (b != null)
        {
            return b.booleanValue();
        }
        if (c != null)
        {
            throw c;
        }
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 8)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        boolean flag = flag1;
        if (!"sdk".equals(Build.PRODUCT))
        {
            if ("google_sdk".equals(Build.PRODUCT))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        Class class1;
        Field field;
        try
        {
            b = Boolean.valueOf(flag);
        }
        catch (Exception exception)
        {
            c = exception;
            throw exception;
        }
        return b.booleanValue();
        class1 = Class.forName("android.os.Build");
        field = class1.getField("HARDWARE");
        field.setAccessible(true);
        b = Boolean.valueOf("goldfish".equals((String)field.get(class1)));
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_71;
        }
    }

    public static boolean b(int i1)
    {
        return x() >= i1;
    }

    public static boolean b(Map map, Object obj, Object obj1)
    {
        if (!map.containsKey(obj) || !((Set)map.get(obj)).contains(obj1))
        {
            return false;
        } else
        {
            ((Set)map.get(obj)).remove(obj1);
            return true;
        }
    }

    public static byte[] b(byte abyte0[], int i1)
    {
        boolean flag1 = true;
        byte abyte1[];
        boolean flag;
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        if (i1 >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b.a(flag);
        abyte1 = new byte[i1];
        System.arraycopy(abyte0, 0, abyte1, 0, Math.min(i1, abyte0.length));
        return abyte1;
    }

    public static int[] b(List list)
    {
        int ai1[] = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            ai1[i1] = ((Integer)list.get(i1)).intValue();
        }

        return ai1;
    }

    static Bundle[] b(br abr[])
    {
        if (abr == null)
        {
            return null;
        }
        Bundle abundle[] = new Bundle[abr.length];
        for (int i1 = 0; i1 < abr.length; i1++)
        {
            br br1 = abr[i1];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", br1.a());
            bundle.putCharSequence("label", br1.b());
            bundle.putCharSequenceArray("choices", br1.c());
            bundle.putBoolean("allowFreeFormInput", br1.d());
            bundle.putBundle("extras", br1.e());
            abundle[i1] = bundle;
        }

        return abundle;
    }

    public static int c(CharSequence charsequence, int i1, int j1)
    {
        for (j1--; j1 >= i1; j1--)
        {
            if (!Character.isWhitespace(charsequence.charAt(j1)))
            {
                return j1;
            }
        }

        return -1;
    }

    public static int c(List list)
    {
        int i1 = 1;
        list = list.iterator();
        while (list.hasNext()) 
        {
            Object obj = list.next();
            int j1;
            if (obj == null)
            {
                j1 = 0;
            } else
            {
                j1 = obj.hashCode();
            }
            i1 = ~~(j1 + i1 * 31);
        }
        return i1;
    }

    public static int c(List list, Object obj)
    {
        for (list = list.listIterator(list.size()); list.hasPrevious();)
        {
            if (f.a(obj, list.previous()))
            {
                return list.nextIndex();
            }
        }

        return -1;
    }

    public static int c(Set set)
    {
        set = set.iterator();
        int i1 = 0;
        while (set.hasNext()) 
        {
            Object obj = set.next();
            int j1;
            if (obj != null)
            {
                j1 = obj.hashCode();
            } else
            {
                j1 = 0;
            }
            i1 = ~~(i1 + j1);
        }
        return i1;
    }

    public static ayd c(Object obj)
    {
        return new ayd(obj);
    }

    public static exe c(byte abyte0[], int i1)
    {
        return E().a((new ewp()).a(euc.a(abyte0, 0, i1)));
    }

    public static String c(int i1)
    {
        switch (i1)
        {
        case 103: // 'g'
        case 109: // 'm'
        case 110: // 'n'
        case 111: // 'o'
        case 112: // 'p'
        case 113: // 'q'
        case 114: // 'r'
        case 115: // 's'
        case 116: // 't'
        case 117: // 'u'
        case 118: // 'v'
        case 119: // 'w'
        case 120: // 'x'
        case 124: // '|'
        case 125: // '}'
        case 126: // '~'
        case 127: // '\177'
        case 128: 
        case 129: 
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 139: 
        case 140: 
        default:
            return (new StringBuilder("ClientEvent(")).append(i1).append(")").toString();

        case 1: // '\001'
            return "APP_EVENT_MAIN_ACTIVITY_RESUME";

        case 2: // '\002'
            return "APP_EVENT_MAIN_ACTIVITY_PAUSE";

        case 43: // '+'
            return "APP_EVENT_MAIN_ACTIVITY_CREATE";

        case 77: // 'M'
            return "APP_EVENT_HANDSFREE_ACTIVITY_RESUME";

        case 78: // 'N'
            return "APP_EVENT_HANDSFREE_ACTIVITY_PAUSE";

        case 79: // 'O'
            return "APP_EVENT_HANDSFREE_ACTIVITY_CREATE";

        case 3: // '\003'
            return "APP_EVENT_WAIT_FOR_CONFIGURATION";

        case 4: // '\004'
            return "APP_EVENT_SHOW_CARD";

        case 5: // '\005'
            return "APP_EVENT_START_RECORDING_USER_SPEECH";

        case 6: // '\006'
            return "APP_EVENT_STOP_RECORDING_END_POINTER_TRIGGERED";

        case 90: // 'Z'
            return "APP_EVENT_STOP_RECORDING_NO_SPEECH_DETECTED";

        case 21: // '\025'
            return "APP_EVENT_TRIGGER_SPEECH_RECOGNITION";

        case 53: // '5'
            return "DEPRECATED_APP_EVENT_EMBEDDED_RECOGNIZER_RESULT_USED";

        case 54: // '6'
            return "DEPRECATED_APP_EVENT_S3_RECOGNIZER_RESULT_USED";

        case 74: // 'J'
            return "APP_EVENT_IME_PARTIAL_RESULT_OVERRIDDEN";

        case 35: // '#'
            return "APP_EVENT_IME_START_INPUT_VIEW";

        case 36: // '$'
            return "APP_EVENT_IME_JUMP_TO_OTHER_FIELD";

        case 38: // '&'
            return "APP_EVENT_IME_DISPLAY_ERROR";

        case 39: // '\''
            return "APP_EVENT_IME_RESULT_DISPLAYED";

        case 70: // 'F'
            return "APP_EVENT_RESULTS_FROM_EMBEDDED_RECOGNIZER";

        case 71: // 'G'
            return "APP_EVENT_RESULTS_FROM_NETWORK_RECOGNIZER";

        case 93: // ']'
            return "APP_EVENT_ACTION_FROM_EMBEDDED_PARSER";

        case 94: // '^'
            return "APP_EVENT_ACTION_FROM_NETWORK_PARSER";

        case 108: // 'l'
            return "APP_EVENT_UNUSED_ACTION_FROM_NETWORK_PARSER";

        case 123: // '{'
            return "APP_EVENT_UNUSED_ACTION_FROM_EMBEDDED_PARSER";

        case 87: // 'W'
            return "APP_EVENT_EMBEDDED_RESULTS_MERGED_WITH_NETWORK_RESULTS";

        case 92: // '\\'
            return "APP_EVENT_NETWORK_RESULTS_MERGED_WITH_EMBEDDED_RESULTS";

        case 131: 
            return "EVENT_TYPE_APP_EVENT_ICING_QUERY_GLOBAL_SEARCH_LATENCY";

        case 121: // 'y'
            return "EVENT_TYPE_APP_EVENT_ICING_CORPORA_DIAGNOSED";

        case 40: // '('
            return "APP_EVENT_IME_CLOSE";

        case 41: // ')'
            return "APP_EVENT_IME_FINISH_INPUT_VIEW";

        case 42: // '*'
            return "APP_EVENT_IME_INTERRUPTED";

        case 55: // '7'
            return "APP_EVENT_SERVICE_API_START_LISTENING";

        case 56: // '8'
            return "APP_EVENT_SERVICE_API_ENDED";

        case 57: // '9'
            return "APP_EVENT_SERVICE_API_CANCEL";

        case 58: // ':'
            return "APP_EVENT_SERVICE_API_STOP_LISTENING";

        case 59: // ';'
            return "APP_EVENT_SERVICE_API_ERROR";

        case 60: // '<'
            return "APP_EVENT_SERVICE_API_RESULTS";

        case 61: // '='
            return "APP_EVENT_INTENT_ACTIVITY_RESUME";

        case 62: // '>'
            return "APP_EVENT_INTENT_ACTIVITY_PAUSE";

        case 69: // 'E'
            return "APP_EVENT_APPLICATION_STATE_NOT_RESTORED";

        case 75: // 'K'
            return "APP_EVENT_IME_ROTATE_WHILE_RECORDING";

        case 76: // 'L'
            return "APP_EVENT_ESTABLISH_AUDIO_PATH";

        case 82: // 'R'
            return "APP_EVENT_CONTACT_GRAMMAR_LOADING_LATENCY";

        case 83: // 'S'
            return "DEPRECATED_APP_EVENT_CREATE_LATENCY";

        case 84: // 'T'
            return "DEPRECATED_APP_EVENT_RESUME_LATENCY";

        case 99: // 'c'
            return "APP_EVENT_APPLICATION_CREATE_LATENCY";

        case 100: // 'd'
            return "APP_EVENT_ACTIVITY_CREATE_LATENCY";

        case 101: // 'e'
            return "APP_EVENT_ACTIVITY_RESTART_LATENCY";

        case 102: // 'f'
            return "APP_EVENT_ACTIVITY_RESUME_LATENCY";

        case 85: // 'U'
            return "APP_EVENT_WEBSEARCH_LATENCY_VOICE";

        case 86: // 'V'
            return "APP_EVENT_WEBSEARCH_LATENCY_TEXT";

        case 104: // 'h'
            return "APP_EVENT_WEBSEARCH_LATENCY_SOUNDSEARCH";

        case 95: // '_'
            return "DEPRECATED_APP_EVENT_PUMPKIN_RESULT_RECEIVED";

        case 98: // 'b'
            return "APP_EVENT_PUMPKIN_NO_MATCH_RECEIVED";

        case 97: // 'a'
            return "APP_EVENT_PUMPKIN_LATENCY_INITIALIZATION";

        case 96: // '`'
            return "APP_EVENT_PUMPKIN_LATENCY";

        case 106: // 'j'
            return "APP_EVENT_ESTABLISH_BT_SCO_CONNECTION_LATENCY";

        case 107: // 'k'
            return "APP_EVENT_FAIL_IN_ESTABLISH_BT_SCO_CONNECTION_LATENCY";

        case 130: 
            return "APP_EVENT_OPEN_MICROPHONE_LATENCY";

        case 7: // '\007'
            return "PROTOCOL_EVENT_S3_CONNECTION_OPEN";

        case 8: // '\b'
            return "PROTOCOL_EVENT_S3_CONNECTION_OPEN_LATENCY";

        case 9: // '\t'
            return "PROTOCOL_EVENT_S3_CONNECTION_ERROR";

        case 10: // '\n'
            return "PROTOCOL_EVENT_S3_CONNECTION_DONE";

        case 11: // '\013'
            return "PROTOCOL_EVENT_S3_RECOGNITION_COMPLETED";

        case 12: // '\f'
            return "PROTOCOL_EVENT_S3_MAJEL_RESULT_RECEIVED";

        case 22: // '\026'
            return "PROTOCOL_EVENT_S3_SEND_RECOGNIZE_REQUEST";

        case 23: // '\027'
            return "PROTOCOL_EVENT_S3_SEND_END_OF_DATA";

        case 24: // '\030'
            return "PROTOCOL_EVENT_S3_SEND_TEXT_RECOGNITION_REQUEST";

        case 25: // '\031'
            return "PROTOCOL_EVENT_S3_RETRY";

        case 26: // '\032'
            return "PROTOCOL_EVENT_S3_RETRY_AUTH_FAILURE";

        case 27: // '\033'
            return "PROTOCOL_EVENT_S3_NO_RETRY_MAX_COUNT_REACHED";

        case 28: // '\034'
            return "PROTOCOL_EVENT_S3_NO_RETRY_TIMEOUT_EXCEEDED";

        case 30: // '\036'
            return "PROTOCOL_EVENT_S3_TTS_RECEIVED";

        case 31: // '\037'
            return "PROTOCOL_EVENT_S3_PERCEIVED_LATENCY_RECOGNITION_COMPLETE";

        case 32: // ' '
            return "PROTOCOL_EVENT_S3_PERCEIVED_LATENCY_MAJEL_RESULT";

        case 73: // 'I'
            return "PROTOCOL_EVENT_S3_PERCEIVED_LATENCY_TEXT_MAJEL_RESULT";

        case 33: // '!'
            return "PROTOCOL_EVENT_S3_PERCEIVED_LATENCY_TTS_RESULT";

        case 13: // '\r'
            return "USER_EVENT_ACTION_COMPLETE";

        case 50: // '2'
            return "USER_EVENT_CARD_VIEW_IN_EXTERNAL_APP";

        case 14: // '\016'
            return "USER_EVENT_ACTION_CANCEL";

        case 72: // 'H'
            return "USER_EVENT_ACTION_CANCEL_COUNTDOWN";

        case 81: // 'Q'
            return "DEPRECATED_USER_EVENT_ACTION_CANCEL_AND_RETRY";

        case 80: // 'P'
            return "DEPRECATED_USER_EVENT_ACTION_EXPIRED_COUNTDOWN";

        case 15: // '\017'
            return "USER_EVENT_ALTERNATE_SELECTED";

        case 16: // '\020'
            return "USER_EVENT_EDIT_RECOGNIZED_TEXT";

        case 34: // '"'
            return "USER_EVENT_DELETE_RECOGNIZED_TEXT";

        case 17: // '\021'
            return "USER_EVENT_STOP_RECORDING";

        case 18: // '\022'
            return "USER_EVENT_CANCEL_WHILE_RECOGNITION_WORKING";

        case 19: // '\023'
            return "USER_EVENT_TRIGGER_TEXT_RECOGNITION";

        case 20: // '\024'
            return "USER_EVENT_TRIGGER_SPEECH_RECOGNITION";

        case 65: // 'A'
            return "USER_EVENT_TRIGGER_SPEECH_RECOGNITION_BY_HOTWORD";

        case 37: // '%'
            return "USER_EVENT_IME_CLICK_DONE";

        case 44: // ','
            return "USER_EVENT_CONTACT_SELECT_PICK";

        case 45: // '-'
            return "USER_EVENT_CONTACT_SELECT_DISMISS";

        case 46: // '.'
            return "USER_EVENT_PERSONALIZATION_CLICK_MORE_INFO";

        case 47: // '/'
            return "USER_EVENT_PERSONALIZATION_CLICK_DASHBOARD";

        case 48: // '0'
            return "USER_EVENT_PERSONALIZATION_ENABLED_FROM_SETTING";

        case 49: // '1'
            return "USER_EVENT_PERSONALIZATION_DISABLED_FROM_SETTING";

        case 63: // '?'
            return "USER_EVENT_IME_PAUSE_RECORDING";

        case 64: // '@'
            return "USER_EVENT_IME_RESTART_RECORDING";

        case 66: // 'B'
            return "USER_EVENT_CHANGE_VOICE_LANGUAGE_SETTINGS";

        case 67: // 'C'
            return "USER_EVENT_CHANGE_IME_LANGUAGE_SETTINGS_FROM_IME";

        case 68: // 'D'
            return "USER_EVENT_CHANGE_IME_LANGUAGE_SETTINGS";

        case 91: // '['
            return "USER_EVENT_CLICK_PLAY_STORE_LINK";

        case 105: // 'i'
            return "USER_EVENT_CLICK_ON_DEVICE_RESULT";

        case 51: // '3'
            return "EMBEDDED_RECOGNIZER_EVENT_RECOGNITION_STARTED";

        case 52: // '4'
            return "EMBEDDED_RECOGNIZER_EVENT_RECOGNITION_COMPLETED";

        case 88: // 'X'
            return "EMBEDDED_RECOGNIZER_EVENT_HOTWORD_RECOGNITION_STARTED";

        case 89: // 'Y'
            return "EMBEDDED_RECOGNIZER_EVENT_HOTWORD_RECOGNITION_COMPLETED";

        case 29: // '\035'
            return "UNEXPECTED_CLIENT_ERROR";

        case 122: // 'z'
            return "TOKEN_FETCHED";

        case 138: 
            return "USER_EVENT_GWS_CORRECTION_SELECTED";

        case 143: 
            return "EVENT_TYPE_APP_EVENT_PROMPT_FOR_CONFIRMATION";

        case 142: 
            return "EVENT_TYPE_APP_EVENT_PROMPT_FOR_NEW_MESSAGE";

        case 141: 
            return "EVENT_TYPE_APP_EVENT_PROMPT_FOR_NEW_RECIPIENT";
        }
    }

    public static String c(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException();
        } else
        {
            return s1;
        }
    }

    public static ArrayList c(Iterable iterable)
    {
        f.b(iterable);
        if (iterable instanceof Collection)
        {
            return new ArrayList(ehc.a(iterable));
        } else
        {
            return a(iterable.iterator());
        }
    }

    public static void c()
    {
        if (atp.a >= 18)
        {
            Trace.endSection();
        }
    }

    public static void c(Parcel parcel, int i1, int j1)
    {
        b(parcel, i1, 4);
        parcel.writeInt(j1);
    }

    public static void c(bnr bnr1, String s1)
    {
        bnr1.a(String.valueOf(s1).concat("/yt:playlistId"), new can()).a(String.valueOf(s1).concat("/yt:private"), new cam()).a(String.valueOf(s1).concat("/author/name"), new cal()).a(String.valueOf(s1).concat("/title"), new cak()).a(String.valueOf(s1).concat("/updated"), new caj()).a(String.valueOf(s1).concat("/media:group/media:thumbnail"), new cai());
    }

    public static void c(Object obj, int i1)
    {
        ((android.media.MediaRouter.UserRouteInfo)obj).setPlaybackStream(i1);
    }

    public static void c(Object obj, Object obj1)
    {
        ((android.media.MediaRouter.RouteInfo)obj).setTag(obj1);
    }

    public static void c(boolean flag)
    {
        if (!flag)
        {
            throw new IllegalStateException();
        } else
        {
            return;
        }
    }

    public static boolean c(Context context)
    {
        b.a(context);
        return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }

    public static boolean c(Context context, int i1)
    {
        if (f == 0)
        {
            b.a(context);
            context = context.getResources().getDisplayMetrics();
            f = Math.min(((DisplayMetrics) (context)).widthPixels, ((DisplayMetrics) (context)).heightPixels);
        }
        return f >= i1;
    }

    public static boolean c(Parcel parcel, int i1)
    {
        a(parcel, i1, 4);
        return parcel.readInt() != 0;
    }

    public static Object[] c(Object aobj[])
    {
        return (Object[])((Object []) (aobj)).clone();
    }

    public static int d(Parcel parcel, int i1)
    {
        a(parcel, i1, 4);
        return parcel.readInt();
    }

    public static Object d(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            return obj;
        }
    }

    public static String d()
    {
        return "0ZnY30Jj0poskMNptPzOAUAoLJ3M+w62lTbrjj2yJsw=";
    }

    public static String d(int i1)
    {
        switch (i1)
        {
        case 12: // '\f'
        case 13: // '\r'
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        default:
            return (new StringBuilder("LatencyBreakDown(")).append(i1).append(")").toString();

        case 0: // '\0'
            return "WEBSEARCH_QUERYSTATE_RECOGNIZE ";

        case 1: // '\001'
            return "WEBSEARCH_QUERYSTATE_COMMIT_WEB ";

        case 2: // '\002'
            return "WEBSEARCH_QUERYSTATE_RECEIVED_ANSWER_RESPONSE ";

        case 3: // '\003'
            return "WEBSEARCH_QUERYSTATE_CORPORA_LOAD ";

        case 4: // '\004'
            return "WEBSEARCH_JESRCTRL_COMMIT ";

        case 5: // '\005'
            return "WEBSEARCH_JESRCTRL_LOGIN_COMPLETE ";

        case 6: // '\006'
            return "WEBSEARCH_JESRCTRL_REQUEST_JESR ";

        case 7: // '\007'
            return "WEBSEARCH_JESRCTRL_REQUEST_NONJESR ";

        case 8: // '\b'
            return "WEBSEARCH_JESRCTRL_START_JESR ";

        case 9: // '\t'
            return "WEBSEARCH_JESRCTRL_START_NONJESR ";

        case 10: // '\n'
            return "WEBSEARCH_JESRCTRL_END_JESR ";

        case 11: // '\013'
            return "WEBSEARCH_JESRCTRL_END_NONJESR ";

        case 14: // '\016'
            return "WEBSEARCH_FRAGMENT_SHOW_WEBVIEW ";

        case 15: // '\017'
            return "WEBSEARCH_FRAGMENT_SHOW_WEBVIEW_COMPLETE ";

        case 16: // '\020'
            return "APPLICATION_ON_CREATE_START";

        case 17: // '\021'
            return "APPLICATION_ON_CREATE_END";

        case 18: // '\022'
            return "ACTIVITY_ON_CREATE_START";

        case 19: // '\023'
            return "ACTIVITY_ON_CREATE_END";

        case 20: // '\024'
            return "SEARCH_PLATE_ON_DRAW_START";

        case 21: // '\025'
            return "ACTIVITY_ON_START_START";

        case 22: // '\026'
            return "ACTIVITY_ON_START_END";

        case 23: // '\027'
            return "ACTIVITY_ON_RESUME_START";

        case 24: // '\030'
            return "ACTIVITY_ON_RESUME_END";

        case 25: // '\031'
            return "VELVET_PRESENTER_UPDATE_MODE_START";

        case 26: // '\032'
            return "VELVET_PRESENTER_UPDATE_MODE_END";

        case 27: // '\033'
            return "ACTIVITY_ON_RESTART_START";

        case 40: // '('
            return "VELVET_PRESENTER_INITIALIZE_DELAYED_START";

        case 28: // '\034'
            return "VELVET_PRESENTER_INITIALIZE_DELAYED_END";

        case 32: // ' '
            return "STARTUP_UI_THREAD_IDLE";

        case 29: // '\035'
            return "WEBSEARCH_PREFETCH_START";

        case 30: // '\036'
            return "WEBSEARCH_PREFETCH_END";

        case 31: // '\037'
            return "WEBSEARCH_PREFETCH_CANCEL";

        case 33: // '!'
            return "WEBSEARCH_QUERYSTATE_PUMPKIN_PARSE_START";

        case 34: // '"'
            return "WEBSEARCH_QUERYSTATE_PUMPKIN_PARSE_END";

        case 35: // '#'
            return "WEBSEARCH_QUERYSTATE_COMMIT_WEB_SINGLE_REQUEST";

        case 36: // '$'
            return "WEBSEARCH_QUERYSTATE_SWITCH_QUERY";

        case 37: // '%'
            return "WEBSEARCH_QUERYSTATE_SELECT_ACTION";

        case 38: // '&'
            return "WEBSEARCH_QUERYSTATE_HANDLE_ACTION";

        case 39: // '\''
            return "WEBSEARCH_FRAGMENT_SHOW_CARD";

        case 50: // '2'
            return "OPEN_MICROPHONE_AUDIO_RECORD_CREATED";

        case 49: // '1'
            return "OPEN_MICROPHONE_AUDIO_ROUTED";

        case 54: // '6'
            return "OPEN_MICROPHONE_DONE";

        case 51: // '3'
            return "OPEN_MICROPHONE_NOISE_SUPPRESSOR_CREATED";

        case 53: // '5'
            return "OPEN_MICROPHONE_RECORDING_STARTED";

        case 52: // '4'
            return "OPEN_MICROPHONE_RECORDING_STARTED_SYNCED";
        }
    }

    public static String d(String s1)
    {
        int i1 = s1.indexOf('/');
        if (i1 == -1)
        {
            s1 = String.valueOf(s1);
            if (s1.length() != 0)
            {
                s1 = "Invalid mime type: ".concat(s1);
            } else
            {
                s1 = new String("Invalid mime type: ");
            }
            throw new IllegalArgumentException(s1);
        } else
        {
            return s1.substring(0, i1);
        }
    }

    public static void d(bnr bnr1, String s1)
    {
        bnr1.a(String.valueOf(s1).concat("/entry/summary"), new cbk()).a(String.valueOf(s1).concat("/entry/link"), new cbj()).a(String.valueOf(s1).concat("/entry/author/name"), new cbi()).a(String.valueOf(s1).concat("/entry/author/uri"), new cbh());
    }

    public static void d(Object obj, int i1)
    {
        ((android.media.MediaRouter.UserRouteInfo)obj).setVolume(i1);
    }

    public static void d(Object obj, Object obj1)
    {
        ((android.media.MediaRouter.UserRouteInfo)obj).setVolumeCallback((android.media.MediaRouter.VolumeCallback)obj1);
    }

    public static boolean d(Context context)
    {
        return a(context, "DOGFOOD") || a(context, "DEV") || a(context, "TEST");
    }

    public static String e()
    {
        return "njAQBT4Y/YqRKbRatytX8xL8HhDUWVPVKorn9eIpx4Ybs+ItVmvp3oygk4Ov92fXCE4xuXDEpWxiA2OBtkT68/cBUziU9c4Kvc/xGGI5JU+7CE5eZHShEMv3fy8HPY9M+L+5s/vV3S84LqIHBv0To1WI7K7ksqCNdPuWIxU4bgeu4m0Egzysv2H0K7B26isXszu61imuYglIQ89K0hOEDdYv4267/oqV/nIdevY3hb61ASah18XV4bpX8k45QydKEcni/4RrB+z/mGe2iFBJ2dXzCglT9WWElhbmbajAVSGICStrvBWC3USgQv4Qm58JnsQWlxdxUNPttI4AbSkYGnDcf30FxAWeqS2Xl8mAXRZfJDAxCNpbpN4qeZLYshAokEBGM44NmNz0ttOSZs7y5/QI4dsWCBfG9W7Wvyl2QwEeMfoi++4b5dTx+ktSXwu0XAkp6Dnrn5ImGBPfhDE6WPf5LD93DiPwuskXy0NzJHgyu+oQyOX/1Mf8Z4tq6IvgRf3WrTPOjZlUmQUPeuDIb6jgyI5BbAgexEjSbc0U6S1t3MFH1pN/deUKyunxmXQCgWT01CRqhlNcDMxkQo1dMAhG/OdVtKYm3aZeUb2y0g6PSryC470Ru2H3JfOx3ducY/3bqTJbI4s0qaTAo+uqkqAm5TO76JW+XOwq+eaFjNsyTQt/fJKtwrdFfvMEnPdRYsb41+txvOST7NcxdAMGjMSCnoUQfBfktC06+DJqdZZ2D2zGqt97LXJ5Z5YpQFWkj9zz8BVB+bteFplUNGj4fCMxKIuMnSQgQEX8RrirXOHYf870uAJ2BlyJhe/cVqh3nVlrz982U4aYIdXBaWNjPTEl4Iwrx3GTyIkstojIeaPyLSwG3IPBfa9p2LiPE8+8fwDXkLcogkJFHoKy8Ka8FfCLuXH5vv/e6/wYcJ+T/ZFF60RQDwcIIeZONaLAKA9/gIWRVuv1MPP9KXSfLraP9HAKPnRYlXW3wZ3N01vKyKrA69KfKJpvBxzTbHK4UUVx5opFvn/VYrYt9S2rcXN9ky5h0Y5U+PQTUrXOorC7Z2yiJ290JiiTMRNXftPr74weT8CLrABFnk/sFGMrm6CZ8wB0pGUREFSRYvOzJ+HdRRJifPNdExWqD+uGmkGgCPYQZsbZaQfZIsR7kDumSj9URJO13er/cx0hY9A7tVSvbEY+3Jaoe9Wm6LjmBKpCfzb5e/8agTZpZ7kPbyPxlQTuIeyW/gZVZnNgFaKu8JGo7xcSwup0VgDYcys8MgcRGlQoJTGoGB+mB0ZKQxG7MwzFz5GXY6BiD7hY5zi7EQO6XakbsYfmVmfCh0m/FgIt+6ZkFrYm5qfvAifde8TeXzHMYFquXK/MB7LCmif8LX7Tc9NR145uHYGzoyugVi0zVrml3crCNddADKZdx2TAQbszfzadUEX5OYlMug5QgXRKk9I10RTLCx8pfkN33KJnDSQzoZb4QmvtDQxJhEfUDmteHXme3e5CyfeSTUNOEXT6tQj+7NEdSVZAM2ipF3wj0iHEZtv+ANDGbolSczgI2rF7GTCdAWacUqulUzBOTIc8ROrgViyDphcu/wnxG9+vv4wrWHKjlyviRuRVayUL4cETeRVAGm4jcSfWVeiGklkm0Llr9ZvhLO3I0DOEh5qgyP0FgHeeV8kDlVNT7PxP1yrVZc0QLupG9sn5zyL5Ojt+KEnDwmoRO68S1j6cPaRG/NuT4r1pOjyNmd3QoTNux7Mf9V3ANzZY6vYPRYPZHjpwNjfiuF87ml6f9AnjvPn+s57S4TJO/QF2QFW2iPGOfWHl9qNjRru/VXq5ru9+wkyOJEd2nU9/TFDSwO2G5MPhrdB/pkgEB18EUTC2rpNCx/IVuoObIpt8nQ+hWjklsOnAN/tVkHGDfmUbso4j2MNcZIC7KMnFoeGOg1+OiVCAzQlEwbKnI134swMju7oqyZdk34XyqxTo2MU+0U+tdQB7oIsLsmpfP9APFTjOrqRB9/MBj2H0CxHpUA4ZCLxcgAqu5zulwNR3xsvUHPVrEOg6ANgYhMZEpmuWGJDruLBlkjK7SAjThqRnBIaj+Rp1sZlhN3iLvr+8tJ4ffShpylDUR+HlzobRJ8NsVIXuaAXWEGt7rajHbBOs2XV+cBpofgM2pvqLxYbI6jOJldp7dhRoBW0WK0he7qGwdDpZAX7QjW8PZN5V6xf4WwOr2CFYgunYtDb+orwDwcOlboHpf4xgRz2FwlHuvriz8BlRG+9i3TTzNbQuVtC3v3DvnRBphvkKgP/fO5GwOaaHDe7gUjFxlME/BulcC2gvs4Vnl+ZE4YwbNbNXXmZB7MIcZsP5F9H+hCNEd238CiFv4fBvg/Lt30f/jOBC6mN7SQoBbMbiagU/zAPGD6G8zv9HgItehkWcmGrBw5Gijk2zvFzU9y++TcbJJw+sqPmSILnOO2KKekvXAFHf/cQaSvUEXbE61tSw6sgiml5QEwBi84n2GCDuN+h3rRMQgFQ+2IZsCgT49lBouo9NrQjbGgpmWIu2X0Sux5hOpIBe+C7uG2ol0jwKdfh1NFFg4B8CJAc6JqHGFceDxX5KC/Gh386CgPnde35gWtLwM6FTDlxFuOeOrY6v2rSBw1N4WcVdaJNOUD5MBaw4az6h8AoIAyQOCY5EPT3YyUFTJr6C8uP7/6dqKkOATiuGf6SzKz2JtBn1WVYOvSfl58yEn4s2wTxMyd0kprC/o4sLdmRa4ylWLxVytYhz/AEZCFktUkLTX2prbPvaSTgDYK0Dav9p/cNg8Yy8iI73elp/JA7vDdl+6GWp4U/Ij0Gd+5+hpgZZosSAFozdjeMZYm/TKtuHaJ44ofLgSAmkoUnZHUbi+EnEq8Qmo9v1brNwqzvBE6UJgO2huMf+NoHhljRyIzcvpqqPXp5HC/Crd36nPqhNP1PjQlPfWT1h3wbQYQnnvm9r4L/78lfZhoePA/dWbR7p+c3XlQrqoS+QFPfX8goAweFjuAUdtxhUCN1FdQlQj+7021yhSnpyIdTPuezr1PYb9lYsovAr4h5lGjhqlmMz+k7obZInwBFJrXwKKmipd5hykjAQ8JmrVmxQqwYTA7w5ASDy0k6gkgl3HiDEgx2GLFxTPO7+WOpZXVDanNZHSqVoXP0l0rEwd5fjCS17w+eQuidEKYI828DtZdib2uLUSBmPaG42BsdgAP9sCM2WYu4p8Sd0mCnp8b0Ii1wJQ7/Kqd/dd65Kbluqy7vpoLN9m2eB015I2Wcr2NNGddo7mCQKhZ8JWcXiH7w+0x1J20JNhSZUIIp8/OPvNyZOE4rrKJy4/l5FDV8XopenUzrN3d11CGfLmTuRf1zbDTWh2zKYsW7lFvZ6WKQ0hanTELD1Qd6yt7v6/nwS6YCIOCmMHOImUUCdAsUcAhNvt19qQTe4ulMIQY2MIgC7ZNXgAXLYEw8kmfLoy6OfRrUPHNfkrPUL4iN6dvctelFj7hvKBRiUB5Nut/CjzSRIFhdPNC2GSg/u9VbNS5KR0cTy8hyavxEbuu4J5WapnTGm6L6r2kgVvtoVcrjo+RNeemiTT++pxsZ66ij0jqVk2/0zCtMos/eTJWxW77keEohIjj4OUO3CWwaHcO0cE+6JNVTYQiVg0K364T6LeEV1W7D40R77P84YFZqE4fZzKNYTyNUakJsTfj/IToy0uMRkZaFm9PRb8wCnGCVkF18eufe5AtjfJqCzliTJsp8XMMQnQd2amc0wXo/LFEsBSvWA4z4HKzqEQ9n+7G7LUek7s0ljObeH8xFBhJvB21uBlM1Uvc+qppbGwtVvsgHBh/J/AphnZqZTtweG37n0hEsP2e7LkL12WYqWanqbX5kMfwc0PosDHcBXpj0GJ92utKSutniaWOYCQ0vSxorkPZRgMbnxz7Gz2GPurk6wAzRBhW2sbOlIvf4Qml9wOiGJe8kUy6v5rF6n6TCPMSDGLklS9biGFAUBplsVN8rMN8ru71RJ2WMXqb16NVGxUJOxOFGj6dReHQSvtJ12QYJ9naTOsaykuERNDGyeY0WVVj9qLGo6ZbAhLZGYGpK5BucoHwtrMYoaUsIGPbQyMRZJO/CotgiM8u7kwS371UAcnzMWxejctCLI7XTxA+/33SfyT2BESEDxjejzUFMrv062yHwKWTqB25UpoebKzrsIAiuarWFjwm65QPn7VqehuT9du0OS/2fXYVJ2vExLQq31CBiRR9jxlMYHSY6vW2uEdqu2RHFIhSwX9Hbi7+tDijCTRJOdjSYEcrZ6kmpoewe+UXFSiEgQaFHWU6fEd731VWEAj0zpfEzaDgzrLPU8Gq4FVCRiwLbJuL6qZYjTWoFB3HqtXYGMRZaezLXooYM/1T/AwJwvb/IXpQTCVrnW4w4w54XXj/7DoVBW196xqMMDF9+eAxrvKXOUtCiNwZoosC2bf1sod0KOvSQd/C4lRMSkBdS6AxKkNL+F3EinQQSp4m35Xm/j8ixpagYgZS0SfknBrntOgf7AEPmdkJ5LFg1CumhnO1kskRslb7p2Yr2C4lU4+8jX5CgjkidkVkkmP0aif8HqrgTVTjCzUx6c+vD2CIgVDMN+4vucAdWciWseg/HNu7WI2lwyqdA2yfFYF2ZSto1YeBQ5sh+iBvs1H9lX+NXEz1Sqyr6tnhO4GHEJ1KDbI9g98yuJs91xvp5asyBYhN39k7MXtEKLuQx0NVfLjh8KYWV3DuRJ8+LBpLFioU9wuBSN4jrWVKxKaBF+AZbRQcgKyihCCi1GJZz1F4+D0SbL4cPrbnX/JARHzUWfiRbkDUOX/Qw0OuyS6y7AtbwcDc+4CJWwCqG2IBvdlCYRRnU//AJq77qwTgc5kTCyhSRWuHuwdS+CnAp4ERDECtwirLrcC2yrT8GvzaS4/gWy91g2lCge9xA+rQLHY2+KBQHbu7ZM1oDVm5/6QpQbqKElR99gJIAOdQvwIDO1c+pZV/eBe3xC8W/yvDSIXX4OHvuHzoJ4Wbt/JLVbwjjtjlGOBa7CJ/rkhYURnQ0XqnHshc39T7q5G9Jx7R84DUcIEEoHTjP0yEW3RRkLGni227F1bwCTUsizSd7uPfke1Hq4musYDBpWqsjq7FbDmZo6nRhRNF+LQI7O5Pg3ApZHwcXJ0zTKpZaF6pPOiLb7PFX4YlVTbiy12dJVKIej7wzGrKUzecgQycahmthQGKOsbAAammPdpZMgfVJ2JzJBALmKo/Y70rfwj3Qg6UKfeyW+tMfodNNfjQvpSpPZCmubIthG4259x8+W1nOFR/HtPzQuiycX5khhmUI0KCieFnQjd6FSCrRkY9/8WRr6RMkApwL3oFOfR8dh0i8CFP16HvwQ7Ytx4R7KCBQ8UJ7nuLfORDBPHMOCCA99jpZ6jQjZtiVIdhBc1bIvSESjfXmp7qJo0F3jGEs=";
    }

    public static String e(Parcel parcel, int i1)
    {
        i1 = a(parcel, i1);
        int j1 = parcel.dataPosition();
        if (i1 == 0)
        {
            return null;
        } else
        {
            String s1 = parcel.readString();
            parcel.setDataPosition(i1 + j1);
            return s1;
        }
    }

    public static ArrayList e(int i1)
    {
        boolean flag;
        if (i1 >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        return new ArrayList(i1);
    }

    public static void e(Object obj, int i1)
    {
        ((android.media.MediaRouter.UserRouteInfo)obj).setVolumeMax(i1);
    }

    public static boolean e(Context context)
    {
        return a(context, "DEV") || a(context, "TEST");
    }

    public static boolean e(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static boolean e(String s1)
    {
        return d(s1).equals("audio");
    }

    public static Object f(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException(String.valueOf(obj1));
        } else
        {
            return obj;
        }
    }

    public static String f()
    {
        return "YrbyZSSP4U9hc8jE2WPmFNgTN1z05H0vH9oE1FybYkm+ba2d6Fvv2ns+bDgjjsxY";
    }

    public static String f(Context context)
    {
        b.a(context);
        if (g != null) goto _L2; else goto _L1
_L1:
        context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (context == null) goto _L4; else goto _L3
_L3:
        if (((ApplicationInfo) (context)).metaData != null) goto _L5; else goto _L4
_L4:
        g = "RELEASE";
_L2:
        return g;
_L5:
        String s1 = ((ApplicationInfo) (context)).metaData.getString("com.google.android.apps.youtube.config.BuildType");
        context = s1;
        if (s1 == null)
        {
            context = "RELEASE";
        }
        try
        {
            g = context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            bmo.a("Could not get metadata from application info for build type.", context);
            g = "RELEASE";
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static ArrayList f(int i1)
    {
        long l1;
        boolean flag;
        if (i1 >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        l1 = 5L + (long)i1 + (long)(i1 / 10);
        if (l1 > 0x7fffffffL)
        {
            i1 = 0x7fffffff;
        } else
        if (l1 < 0xffffffff80000000L)
        {
            i1 = 0x80000000;
        } else
        {
            i1 = (int)l1;
        }
        return new ArrayList(i1);
    }

    public static ArrayList f(Parcel parcel, int i1)
    {
        i1 = a(parcel, i1);
        int j1 = parcel.dataPosition();
        if (i1 == 0)
        {
            return null;
        } else
        {
            ArrayList arraylist = parcel.createStringArrayList();
            parcel.setDataPosition(i1 + j1);
            return arraylist;
        }
    }

    public static void f(Object obj, int i1)
    {
        ((android.media.MediaRouter.UserRouteInfo)obj).setVolumeHandling(i1);
    }

    public static boolean f(String s1)
    {
        return d(s1).equals("video");
    }

    public static int g(Parcel parcel, int i1)
    {
        parcel.writeInt(0xffff0000 | i1);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static String g()
    {
        return "kRR7rs7/67KmJnHc39cGYo9VSbtX8D+K9iBRzr+ZWHw=";
    }

    public static String g(Context context)
    {
        b.a(context);
        if (j == null)
        {
            try
            {
                j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                bmo.b("could not retrieve application version name", context);
                return "Unknown";
            }
        }
        return j;
    }

    public static ArrayBlockingQueue g(int i1)
    {
        return new ArrayBlockingQueue(40);
    }

    public static void g(String s1)
    {
        if (atp.a >= 18)
        {
            Trace.beginSection(s1);
        }
    }

    public static boolean g(Object obj, Object obj1)
    {
        return obj == null && obj1 == null || obj != null && obj1 != null && obj.equals(obj1);
    }

    public static String h()
    {
        return "GNSTGQkASBJjdoPM3qUZH+W2cvDZ7y4NSc+DyQCptSITAZDDS+1XDHr50mVb5dta";
    }

    public static String h(String s1)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        StringBuffer stringbuffer = new StringBuffer("com.google.android.gms.cast.CATEGORY_CAST");
        if (s1 != null)
        {
            String s2 = s1.toUpperCase();
            if (!s2.matches("[A-F0-9]+"))
            {
                throw new IllegalArgumentException((new StringBuilder("Invalid application ID: ")).append(s1).toString());
            }
            stringbuffer.append("/").append(s2);
        }
        return stringbuffer.toString();
    }

    public static HashSet h(int i1)
    {
        return new HashSet(ejr.b(i1));
    }

    public static void h(Parcel parcel, int i1)
    {
        int j1 = parcel.dataPosition();
        parcel.setDataPosition(i1 - 4);
        parcel.writeInt(j1 - i1);
        parcel.setDataPosition(j1);
    }

    public static els i(int i1)
    {
        return new elu(i1);
    }

    public static String i()
    {
        return "pOBJLvaCxA4swTauHiPD1b5OmPvpwKqFh4DwgWd/rOU=";
    }

    public static void i(String s1)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException(s1);
        } else
        {
            return;
        }
    }

    public static String j()
    {
        return "2OzZqyjDGGeVPCdRn0SZjweOlEmTVEH/2I6FOErTAoqB/rBHpia1X11yzALkJV9Q";
    }

    public static void j(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (s1.length() > 128)
        {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!s1.startsWith("urn:x-cast:"))
        {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (s1.length() == 11)
        {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        } else
        {
            return;
        }
    }

    public static String k()
    {
        return "0iKk4oNP7JyNIYKEnVUDJ0DrlhQRJqtEhvwQRx6qZQc=";
    }

    public static String k(String s1)
    {
        return s1.replaceAll("\\/", "/vmap:");
    }

    public static bfp l(String s1)
    {
        int i1;
        int j1;
        boolean flag;
        flag = true;
        j1 = 1;
        i1 = 0;
        if (TextUtils.isEmpty(s1))
        {
            bmo.b("in Vmap AdBreak: timeOffset is null or empty");
            return new bfp(bft.f, 0L);
        }
        if ("start".equals(s1))
        {
            return new bfp(bft.c, 0L);
        }
        if ("end".equals(s1))
        {
            return new bfp(bft.d, 0L);
        }
        if ('#' != s1.charAt(0)) goto _L2; else goto _L1
_L1:
        i1 = Integer.parseInt(s1.substring(1).trim());
        if (i1 > 0)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        bmo.b("in Vmap AdBreak(positional): timeOffset must be >= 1");
        i1 = j1;
_L3:
        return new bfp(bft.e, i1);
        s1;
        i1 = ((flag) ? 1 : 0);
_L10:
        bmo.a("in Vmap AdBreak(positional): integer parse error", s1);
        if (true) goto _L3; else goto _L2
_L2:
        j1 = s1.length();
        if ('%' != s1.charAt(j1 - 1)) goto _L5; else goto _L4
_L4:
        j1 = Integer.parseInt(s1.substring(0, j1 - 1).trim());
        if (j1 >= 0) goto _L7; else goto _L6
_L6:
        bmo.b("in Vmap AdBreak(percentage): value must not be <0");
        i1 = 0;
_L8:
        return new bfp(bft.b, i1);
_L7:
        i1 = j1;
        if (j1 <= 100)
        {
            continue; /* Loop/switch isn't completed */
        }
        bmo.b("in Vmap AdBreak(percentage): value must not be >100");
        i1 = 100;
        continue; /* Loop/switch isn't completed */
        s1;
        i1 = 0;
_L9:
        bmo.a("in Vmap AdBreak(percentage): integer parse error", s1);
        if (true) goto _L8; else goto _L5
_L5:
        j1 = o(s1);
        if (j1 < 0)
        {
            bmo.b("in Vmap AdBreak(time): value must not be <00:00:00.000");
        } else
        {
            i1 = j1;
        }
        return new bfp(bft.a, i1);
        s1;
        i1 = j1;
          goto _L9
        s1;
          goto _L10
    }

    public static String l()
    {
        return "VcUUwPGeTemkhZBWfA0dzhopeQMk8UmWNJUp1plwq5TYklBYIH8FmibbEPRb2/t8";
    }

    public static String m()
    {
        return "IFcgchRiblF6SvZ04Mf3r4gD0jW7v92DEzsK/lIIQ6w=";
    }

    public static IvParameterSpec m(String s1)
    {
        MessageDigest messagedigest = null;
        MessageDigest messagedigest1 = MessageDigest.getInstance("MD5");
        messagedigest = messagedigest1;
_L2:
        return new IvParameterSpec(messagedigest.digest(s1.getBytes()));
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        bmo.a("MD5 not recognized as a supported algorithm", nosuchalgorithmexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String n()
    {
        return "IpYbUFX/1Lq2SdNyrjP+SHtn/rxlRtA0Jr4BRMouE4VUk9kzzTKYpG0eF3RKbNRf";
    }

    public static byte[] n(String s1)
    {
        try
        {
            s1 = s1.getBytes("utf8");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new RuntimeException(s1);
        }
        return s1;
    }

    public static int o(String s1)
    {
        int l1 = 0;
        String as1[] = s1.split(":");
        int i1 = as1.length;
        Object obj;
        String as[];
        int j1;
        int k1;
        int i2;
        if (i1 == 0)
        {
            obj = s1;
        } else
        {
            obj = as1[i1 - 1];
        }
        if (i1 >= 2)
        {
            try
            {
                j1 = Integer.parseInt(as1[i1 - 2]);
            }
            catch (NumberFormatException numberformatexception)
            {
                String s2 = String.valueOf(s1);
                if (s2.length() != 0)
                {
                    s2 = "error parsing minutes: ".concat(s2);
                } else
                {
                    s2 = new String("error parsing minutes: ");
                }
                bmo.b(s2);
                j1 = 0;
            }
        } else
        {
            j1 = 0;
        }
        if (i1 >= 3)
        {
            try
            {
                k1 = Integer.parseInt(as1[i1 - 3]);
            }
            catch (NumberFormatException numberformatexception1)
            {
                String s3 = String.valueOf(s1);
                if (s3.length() != 0)
                {
                    s3 = "error parsing hours: ".concat(s3);
                } else
                {
                    s3 = new String("error parsing hours: ");
                }
                bmo.b(s3);
                k1 = 0;
            }
        } else
        {
            k1 = 0;
        }
        as = ((String) (obj)).split("\\.");
        if (as.length <= 1) goto _L2; else goto _L1
_L1:
        try
        {
            i1 = Integer.parseInt(as[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = String.valueOf(s1);
            if (((String) (obj)).length() != 0)
            {
                obj = "error parsing seconds: ".concat(((String) (obj)));
            } else
            {
                obj = new String("error parsing seconds: ");
            }
            bmo.b(((String) (obj)));
            i1 = 0;
        }
        try
        {
            i2 = Integer.parseInt(as[1]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s1 = String.valueOf(s1);
            if (s1.length() != 0)
            {
                s1 = "error parsing milliseconds: ".concat(s1);
            } else
            {
                s1 = new String("error parsing milliseconds: ");
            }
            bmo.b(s1);
            continue; /* Loop/switch isn't completed */
        }
        l1 = i2;
_L4:
        return k1 * 0x36ee80 + 60000 * j1 + i1 * 1000 + l1;
_L2:
        try
        {
            i1 = Integer.parseInt(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1 = String.valueOf(obj);
            if (s1.length() != 0)
            {
                s1 = "error parsing seconds: ".concat(s1);
            } else
            {
                s1 = new String("error parsing seconds: ");
            }
            bmo.b(s1);
            i1 = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String o()
    {
        return "1lvTXic8n3R7JEjgipB5q7vdz0HYYFQ3eI4rvSKT9fQ=";
    }

    public static Uri p(String s1)
    {
        if (s1 == null)
        {
            return null;
        } else
        {
            return Uri.parse(s1);
        }
    }

    public static String p()
    {
        return "jlEcTd2rIYHNtjOJXeVHSY0waWduxdbpsAmB61jhLKM3J/X8S64pKP93o8lehC2U";
    }

    public static Uri q(String s1)
    {
        return s(r(s1));
    }

    public static String q()
    {
        return "lpxMXoKWdChv8Zrq7NbZEHaw06Cqv88mVVhozulIi9E=";
    }

    public static String r()
    {
        return "ubB2mzU1bFqDkuDzq0sZsy5gTUocAqqB2dNG1iii3lWzkYnY52nQ5klBR3XLwNL8";
    }

    public static String r(String s1)
    {
        Object obj = Uri.parse(s1);
        try
        {
            new URI(s1);
        }
        catch (URISyntaxException urisyntaxexception1)
        {
            String s2;
            try
            {
                s2 = Uri.encode(((Uri) (obj)).getEncodedAuthority(), "%,;:$&+=@[]");
                String s4 = Uri.encode(((Uri) (obj)).getEncodedPath(), "%,;:$&+=/@");
                String s6 = Uri.encode(((Uri) (obj)).getEncodedQuery(), "%,;:$&+=/[]@?");
                s2 = ((Uri) (obj)).buildUpon().encodedAuthority(s2).encodedPath(s4).encodedQuery(s6).build().toString();
                new URI(s2);
            }
            catch (URISyntaxException urisyntaxexception2)
            {
                try
                {
                    String s3 = Uri.encode(((Uri) (obj)).getEncodedAuthority(), ",;:$&+=@[]");
                    String s5 = Uri.encode(((Uri) (obj)).getEncodedPath(), ",;:$&+=/@");
                    String s7 = Uri.encode(((Uri) (obj)).getEncodedQuery(), ",;:$&+=/@[]?");
                    obj = ((Uri) (obj)).buildUpon().encodedAuthority(s3).encodedPath(s5).encodedQuery(s7).build().toString();
                    new URI(((String) (obj)));
                }
                catch (URISyntaxException urisyntaxexception)
                {
                    return Uri.encode(s1, ":/");
                }
                return ((String) (obj));
            }
            return s2;
        }
        return s1;
    }

    public static Uri s(String s1)
    {
        s1 = Uri.parse(s1);
        if (!s1.isAbsolute())
        {
            throw new MalformedURLException("Uri must have an absolute scheme");
        } else
        {
            return s1;
        }
    }

    public static String s()
    {
        return "SyRjv4WYiA6ZWBzCfu5oNPjxfQ3TS9ELKWyLIoXKw88=";
    }

    public static String t()
    {
        return "x/c7MN7jOYlvQanQaA5kQ24VOO0cWRdM+3FsUpc5WCSkluZU++04QU+SPpASlM4c";
    }

    public static boolean t(String s1)
    {
        return "https".equalsIgnoreCase(Uri.parse(s1).getScheme());
    }

    public static dlb u(String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return byf.a(new String[0]);
        } else
        {
            return byf.a(new String[] {
                s1
            });
        }
    }

    public static String u()
    {
        return "vvMYIcVorTU4oAddtqAIlXJgjNIJa8QVKq9612ASc1o=";
    }

    public static String v()
    {
        return "6IoSJDu5YS+GiM9TLtm7+1wlH+WgGGjJALXDzx/p53YFoQ2QIFAw2DuEpBbGX4YM";
    }

    public static String v(String s1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i1 = 0;
        while (i1 < s1.length()) 
        {
            char c1 = s1.charAt(i1);
            if (i1 == 0)
            {
                stringbuffer.append(Character.toLowerCase(c1));
            } else
            if (Character.isUpperCase(c1))
            {
                stringbuffer.append('_').append(Character.toLowerCase(c1));
            } else
            {
                stringbuffer.append(c1);
            }
            i1++;
        }
        return stringbuffer.toString();
    }

    public static String w()
    {
        return "AwYgqnENj21N72E08XR4MNWn/iMPoCZb222U80unU2g=";
    }

    public static String w(String s1)
    {
        int j1 = s1.length();
        StringBuilder stringbuilder = new StringBuilder(j1);
        int i1 = 0;
        while (i1 < j1) 
        {
            char c1 = s1.charAt(i1);
            if (c1 >= ' ' && c1 <= '~' && c1 != '"' && c1 != '\'')
            {
                stringbuilder.append(c1);
            } else
            {
                stringbuilder.append(String.format("\\u%04x", new Object[] {
                    Integer.valueOf(c1)
                }));
            }
            i1++;
        }
        return stringbuilder.toString();
    }

    public static int x()
    {
        String s1;
        int i1;
        int j1;
        int k1;
        k1 = 0;
        j1 = 0;
        s1 = bna.a("sys.display-size");
        i1 = k1;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        String as[];
        as = s1.split("x");
        i1 = k1;
        if (as == null) goto _L2; else goto _L3
_L3:
        i1 = k1;
        if (as.length <= 1) goto _L2; else goto _L4
_L4:
        k1 = Integer.parseInt(as[0]);
        i1 = Integer.parseInt(as[1]);
        j1 = k1;
_L6:
        i1 = Math.min(j1, i1);
_L2:
        return i1;
        NumberFormatException numberformatexception;
        numberformatexception;
        boolean flag = false;
        i1 = j1;
        j1 = ((flag) ? 1 : 0);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static HttpClient y()
    {
        a;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (k == null)
        {
            b.a(o);
            k = b(3000, 5000);
        }
        httpclient = k;
        a;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    public static HttpClient z()
    {
        a;
        JVM INSTR monitorenter ;
        HttpClient httpclient;
        if (l == null)
        {
            b.a(o);
            l = b(15000, 20000);
        }
        httpclient = l;
        a;
        JVM INSTR monitorexit ;
        return httpclient;
        Exception exception;
        exception;
        throw exception;
    }

    public View a()
    {
        return a.K;
    }
}
