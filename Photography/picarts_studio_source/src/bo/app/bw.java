// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.appboy.Constants;
import myobfuscated.d.b;
import myobfuscated.i.a;
import myobfuscated.i.d;

// Referenced classes of package bo.app:
//            cc

public class bw
{

    public static final String a;
    public final Context b;
    public final cc c;

    public bw(Context context, cc cc)
    {
        b = context;
        c = cc;
    }

    private static boolean a(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            myobfuscated.i.a.c(a, "GCM requires devices running Android 2.2 or higher.");
            return false;
        }
        try
        {
            context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            myobfuscated.i.a.c(a, "GCM requires the Google Play store installed.");
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            myobfuscated.i.a.c(a, String.format("Unexpected exception while checking for %s.", new Object[] {
                "com.google.android.gsf"
            }));
            return false;
        }
        return true;
    }

    public static boolean a(Context context, b b1)
    {
        return a(context) && b(context, b1);
    }

    private static boolean b(Context context, b b1)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        Object obj = context.getPackageManager();
        String s = context.getPackageName();
        s = (new StringBuilder()).append(s).append(".permission.C2D_MESSAGE").toString();
        try
        {
            ((PackageManager) (obj)).getPermissionInfo(s, 4096);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            stringbuilder.append(String.format("The manifest does not define the %s permission.", new Object[] {
                s
            }));
        }
        if (!d.a(context, "android.permission.INTERNET"))
        {
            stringbuilder.append(String.format("Missing permission. The %s permission must be set so that the Android application can send the registration ID to the 3rd party server.", new Object[] {
                "android.permission.INTERNET"
            }));
        } else
        if (!d.a(context, "com.google.android.c2dm.permission.RECEIVE"))
        {
            stringbuilder.append(String.format("Missing permission. The %s permission must be set so that the Android application can register and receive messages.", new Object[] {
                "com.google.android.c2dm.permission.RECEIVE"
            }));
        } else
        if (!d.a(context, s))
        {
            stringbuilder.append(String.format("Missing permission. The %s permission must be set so that ONLY this Android application can register and receive GCM messages.", new Object[] {
                s
            }));
        }
        if (!d.a(context, "android.permission.GET_ACCOUNTS"))
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                myobfuscated.i.a.a(a, String.format("Missing permission. The %s permission is recommended to be set so that pre-Jelly Bean Android devices can register with the GCM server.", new Object[] {
                    "android.permission.GET_ACCOUNTS"
                }));
            } else
            {
                stringbuilder.append(String.format("Missing permission. The %s permission must be set so that this pre-Jelly Bean Android device can register with the GCM server.", new Object[] {
                    "android.permission.GET_ACCOUNTS"
                }));
            }
        }
        if (!d.a(context, "android.permission.WAKE_LOCK"))
        {
            myobfuscated.i.a.a(a, String.format("Missing permission. The %s permission is recommended be set so that the GCM receiver can notify users by waking the phone when a message is received.", new Object[] {
                "android.permission.WAKE_LOCK"
            }));
        }
        context = new ComponentName(context, "com.appboy.AppboyGcmReceiver");
        obj = ((PackageManager) (obj)).getReceiverInfo(context, 2);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (((ActivityInfo) (obj)).enabled)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        stringbuilder.append(String.format("The %s broadcast receiver is either not found or is disabled", new Object[] {
            context.getClassName()
        }));
_L1:
        if (b1.l() == null)
        {
            stringbuilder.append(String.format("Cannot find the Google Cloud Messaging sender ID attribute %s in res/values/appboy.xml.", new Object[] {
                "com.appboy.GCM_SENDER_ID"
            }));
        }
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (stringbuilder.length() == 0)
        {
            return true;
        } else
        {
            myobfuscated.i.a.c(a, stringbuilder.toString());
            return false;
        }
        namenotfoundexception;
        stringbuilder.append(String.format("No %s broadcast receiver is registered in the manifest.", new Object[] {
            context.getClassName()
        }));
          goto _L1
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, bo/app/bw.getName()
        });
    }
}
