// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.webkit.URLUtil;
import android.widget.ImageButton;
import com.sessionm.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.sessionm.core:
//            Drawables, Config

public class i
{

    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";
    private static final String TAG = "SessionM.Util";
    public static final int dV = 0x10000;

    public i()
    {
    }

    public static int a(float f, Context context)
    {
        return (int)(b(f, context) + 0.5F);
    }

    public static int a(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[0x10000];
        int j = 0;
        do
        {
            int i1 = inputstream.read(abyte0);
            if (i1 != -1)
            {
                outputstream.write(abyte0, 0, i1);
                j += i1;
            } else
            {
                return j;
            }
        } while (true);
    }

    public static transient String a(com.sessionm.api.SessionM.ActivityType activitytype, String s, String s1, boolean flag, Object aobj[])
    {
        if (activitytype == com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT)
        {
            throw new InvalidParameterException((new StringBuilder()).append("Invalid activityType : ").append(activitytype).append(" for portal url").toString());
        }
        if (activitytype != com.sessionm.api.SessionM.ActivityType.INTERSTITIAL) goto _L2; else goto _L1
_L1:
        aobj = String.format("%s/%s", new Object[] {
            s, String.format(Locale.US, "apps/%s/welcome?z=%d", new Object[] {
                s1, Long.valueOf(System.currentTimeMillis())
            })
        });
_L4:
        return ((String) (aobj));
_L2:
        if (flag)
        {
            return String.format("%s/%s", new Object[] {
                s, String.format(Locale.US, "optin?z=%d&platform=android", new Object[] {
                    Long.valueOf(System.currentTimeMillis())
                })
            });
        }
        Object obj = null;
        activitytype = obj;
        if (aobj != null)
        {
            activitytype = obj;
            if (aobj.length > 0)
            {
                if (aobj[0] instanceof String)
                {
                    activitytype = (String)aobj[0];
                } else
                {
                    activitytype = obj;
                    if (aobj.length > 1)
                    {
                        activitytype = obj;
                        if (aobj[1] instanceof String)
                        {
                            activitytype = (String)aobj[1];
                        }
                    }
                }
            }
        }
        if (activitytype == null)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj = activitytype;
        if (URLUtil.isValidUrl(activitytype)) goto _L4; else goto _L3
_L3:
label0:
        {
            aobj = String.format(Locale.US, "apps/%s/portal?z=%d", new Object[] {
                s1, Long.valueOf(System.currentTimeMillis())
            });
            if (activitytype != null)
            {
                s1 = activitytype;
                if (activitytype.length() != 0)
                {
                    break label0;
                }
            }
            s1 = ((String) (aobj));
        }
        return String.format("%s/%s", new Object[] {
            s, s1
        });
    }

    public static String a(File file, String s)
    {
        file = b(file, s);
        if (file == null)
        {
            return null;
        } else
        {
            return com.sessionm.a.a.a(file.digest());
        }
    }

    public static String a(String s, byte abyte0[])
        throws NoSuchAlgorithmException, InvalidKeyException
    {
        if (s == null)
        {
            return null;
        } else
        {
            abyte0 = new SecretKeySpec(abyte0, "HmacSHA256");
            s = s.getBytes();
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(abyte0);
            return Base64.encodeToString(mac.doFinal(s), 10);
        }
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    public static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile != null)
        {
            int i1 = afile.length;
            int j = 0;
            while (j < i1) 
            {
                File file1 = afile[j];
                if (file1.isDirectory())
                {
                    a(file1);
                } else
                {
                    file1.delete();
                }
                j++;
            }
        }
        file.delete();
    }

    public static boolean a(Context context, Intent intent)
    {
        while (context == null || context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) 
        {
            return false;
        }
        return true;
    }

    public static String aD()
    {
        return Build.BRAND;
    }

    public static float b(float f, Context context)
    {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static MessageDigest b(File file, String s)
    {
        Object obj;
        Object obj2 = null;
        byte abyte0[] = null;
        if (s == null)
        {
            return null;
        }
        int j;
        try
        {
            s = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return null;
        }
        file = new DigestInputStream(new FileInputStream(file), s);
        abyte0 = new byte[0x10000];
        do
        {
            j = file.read(abyte0);
        } while (j != -1);
        a(file);
_L1:
        return s;
        file;
        file = abyte0;
_L5:
        a(file);
          goto _L1
        file;
        file = obj2;
_L4:
        a(file);
          goto _L1
        file;
        obj = null;
        s = file;
_L3:
        a(((Closeable) (obj)));
        throw s;
        s;
        obj = file;
        if (true) goto _L3; else goto _L2
_L2:
        Object obj1;
        obj1;
          goto _L4
        obj1;
          goto _L5
    }

    public static ImageButton d(Activity activity)
    {
        ImageButton imagebutton = new ImageButton(activity);
        imagebutton.setBackgroundColor(0x106000d);
        BitmapDrawable bitmapdrawable = Drawables.aw.e(activity);
        if (m(16))
        {
            imagebutton.setBackground(bitmapdrawable);
        } else
        {
            imagebutton.setBackgroundDrawable(bitmapdrawable);
        }
        activity = new android.widget.RelativeLayout.LayoutParams(a(50F, activity), a(50F, activity));
        activity.addRule(11);
        activity.rightMargin = 0;
        activity.topMargin = 0;
        imagebutton.setLayoutParams(activity);
        return imagebutton;
    }

    public static String getModel()
    {
        return Build.MODEL;
    }

    public static int getPid()
    {
        return Process.myPid();
    }

    public static boolean isSupportedPlatform()
    {
        return android.os.Build.VERSION.SDK_INT >= Config.h().l();
    }

    public static String k(Context context)
    {
        if (context == null)
        {
            return "unknown";
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context != null && context.isConnectedOrConnecting())
        {
            if (context.getType() == 1)
            {
                return "wifi";
            }
            if (context.getType() == 0)
            {
                return context.getSubtypeName();
            } else
            {
                return (new StringBuilder()).append("connection_type_").append(context.getType()).toString();
            }
        } else
        {
            return "unknown";
        }
    }

    public static boolean l(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public static boolean m(int j)
    {
        return android.os.Build.VERSION.SDK_INT >= j;
    }

    public static boolean m(Context context)
    {
        return "mounted".equals(Environment.getExternalStorageState()) && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean n(Context context)
    {
        Intent intent = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
        return m(14) && a(context, intent);
    }

    public static BitmapDrawable o(String s)
    {
        s = Base64.decode(s, 0);
        return new BitmapDrawable(null, BitmapFactory.decodeByteArray(s, 0, s.length));
    }

    public static boolean o(Context context)
    {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return a(context, intent);
    }

    public static Bitmap p(String s)
    {
        Object obj = q(s);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((Bitmap) (obj));
_L2:
        Bitmap bitmap = BitmapFactory.decodeStream(((InputStream) (obj)));
        ((InputStream) (obj)).close();
        return bitmap;
        IOException ioexception;
        ioexception;
        obj = bitmap;
        if (Log.isLoggable("SessionM.Util", 6))
        {
            Log.e("SessionM.Util", String.format(Locale.US, "Error closing stream while reading drawable at path: %s", new Object[] {
                s
            }), ioexception);
            return bitmap;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean p(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(context, intent);
    }

    public static InputStream q(String s)
    {
        return com/sessionm/core/i.getClassLoader().getResourceAsStream(s);
    }

    public static String r(String s)
    {
        s = s.split("&");
        Arrays.sort(s, new Comparator() {

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((String)obj, (String)obj1);
            }

            public int compare(String s1, String s2)
            {
                byte byte0 = 2;
                String as[] = s1.split("=");
                String s4 = as[0];
                s1 = "";
                if (as.length > 1)
                {
                    s1 = as[1];
                }
                int j = 2;
                String s3 = s1;
                for (; j < as.length; j++)
                {
                    s3 = (new StringBuilder()).append(s3).append("=").append(as[j]).toString();
                }

                s2 = s2.split("=");
                String s5 = s2[0];
                s1 = "";
                j = byte0;
                if (s2.length > 1)
                {
                    s1 = s2[1];
                    j = byte0;
                }
                for (; j < s2.length; j++)
                {
                    s1 = (new StringBuilder()).append(s1).append("=").append(s2[j]).toString();
                }

                if (s4.equals(s5))
                {
                    return s3.compareTo(s1);
                } else
                {
                    return s4.compareTo(s5);
                }
            }

        });
        return TextUtils.join("&", s);
    }
}
