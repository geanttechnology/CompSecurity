// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, Messages

public class MessageNotificationHandler extends BroadcastReceiver
{

    public MessageNotificationHandler()
    {
    }

    private String getAppName()
    {
        Object obj;
        android.content.pm.ApplicationInfo applicationinfo;
        try
        {
            obj = StaticMethods.getSharedContext().getPackageManager();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            StaticMethods.logDebugFormat("Messages - unable to retrieve app name for local notification (%s)", new Object[] {
                ((android.content.pm.PackageManager.NameNotFoundException) (obj)).getMessage()
            });
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            StaticMethods.logDebugFormat("Messages - unable to get app name (%s)", new Object[] {
                ((StaticMethods.NullContextException) (obj)).getMessage()
            });
            return "";
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        applicationinfo = ((PackageManager) (obj)).getApplicationInfo(StaticMethods.getSharedContext().getPackageName(), 0);
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (((PackageManager) (obj)).getApplicationLabel(applicationinfo) != null)
        {
            obj = (String)((PackageManager) (obj)).getApplicationLabel(applicationinfo);
            break MISSING_BLOCK_LABEL_96;
        }
        obj = "";
        break MISSING_BLOCK_LABEL_96;
        obj = "";
        return ((String) (obj));
    }

    private Bitmap getLargeIcon()
    {
        int i = Messages.getLargeIconResourceId();
        if (i == -1) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = StaticMethods.getSharedContext();
        if (android.os.Build.VERSION.SDK_INT > 20)
        {
            obj = (Drawable)android/content/res/Resources.getDeclaredMethod("getDrawable", new Class[] {
                Integer.TYPE, android/content/res/Resources$Theme
            }).invoke(((Context) (obj)).getResources(), new Object[] {
                Integer.valueOf(i), ((Context) (obj)).getTheme()
            });
        } else
        {
            obj = (Drawable)android/content/res/Resources.getDeclaredMethod("getDrawable", new Class[] {
                Integer.TYPE
            }).invoke(((Context) (obj)).getResources(), new Object[] {
                Integer.valueOf(i)
            });
        }
_L4:
        if (obj != null)
        {
            return ((BitmapDrawable)obj).getBitmap();
        } else
        {
            return null;
        }
_L2:
        obj = StaticMethods.getSharedContext().getApplicationInfo();
        if (obj != null)
        {
            PackageManager packagemanager = StaticMethods.getSharedContext().getPackageManager();
            if (packagemanager != null)
            {
                obj = packagemanager.getApplicationIcon(((android.content.pm.ApplicationInfo) (obj)));
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int getSmallIcon()
    {
        if (Messages.getSmallIconResourceId() != -1)
        {
            return Messages.getSmallIconResourceId();
        } else
        {
            return 0x1080093;
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getExtras();
        if (context != null) goto _L2; else goto _L1
_L1:
        StaticMethods.logDebugFormat("Messages - unable to load extras from local notification intent", new Object[0]);
_L4:
        return;
_L2:
        String s;
        int i;
        int j;
        try
        {
            s = context.getString("alarm_message");
            j = context.getInt("adbMessageCode");
            i = context.getInt("requestCode");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logDebugFormat("Messages - unable to load message from local notification (%s)", new Object[] {
                context.getMessage()
            });
            return;
        }
        if (j != Messages.MESSAGE_LOCAL_IDENTIFIER.intValue()) goto _L4; else goto _L3
_L3:
        Activity activity1;
        Context context1;
        if (s == null)
        {
            StaticMethods.logDebugFormat("Messages - local notification message was empty ", new Object[0]);
            return;
        }
        Activity activity;
        try
        {
            activity1 = StaticMethods.getCurrentActivity();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logErrorFormat(context.getMessage(), new Object[0]);
            return;
        }
        try
        {
            context1 = StaticMethods.getSharedContext();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logErrorFormat(context.getMessage(), new Object[0]);
            return;
        }
        context = null;
        activity = StaticMethods.getCurrentActivity();
        context = activity;
_L7:
        if (context != null)
        {
            intent = context.getIntent();
        }
        intent.setFlags(0x24000000);
        j = android.os.Build.VERSION.SDK_INT;
        intent = PendingIntent.getActivity(context1, i, intent, 0x8000000);
        if (intent != null)
        {
            break; /* Loop/switch isn't completed */
        }
        StaticMethods.NullActivityException nullactivityexception;
        Object obj;
        try
        {
            StaticMethods.logDebugFormat("Messages - could not retrieve sender from broadcast, unable to post notification", new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logErrorFormat("Messages - error posting notification, class not found (%s)", new Object[] {
                context.getMessage()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logErrorFormat("Messages - error posting notification, method not found (%s)", new Object[] {
                context.getMessage()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logErrorFormat("Messages - error posting notification (%s)", new Object[] {
                context.getMessage()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            StaticMethods.logErrorFormat("Messages - unexpected error posting notification (%s)", new Object[] {
                context.getMessage()
            });
        }
          goto _L5
        nullactivityexception;
        StaticMethods.logErrorFormat("Messages - unable to find activity for your notification, using default", new Object[0]);
        if (true) goto _L7; else goto _L6
_L6:
        if (j < 11) goto _L9; else goto _L8
_L8:
        context = android/content/BroadcastReceiver.getClassLoader().loadClass("android.app.Notification$Builder");
        obj = context.getConstructor(new Class[] {
            android/content/Context
        });
        ((Constructor) (obj)).setAccessible(true);
        obj = ((Constructor) (obj)).newInstance(new Object[] {
            StaticMethods.getSharedContext()
        });
        context.getDeclaredMethod("setSmallIcon", new Class[] {
            Integer.TYPE
        }).invoke(obj, new Object[] {
            Integer.valueOf(getSmallIcon())
        });
        context.getDeclaredMethod("setLargeIcon", new Class[] {
            android/graphics/Bitmap
        }).invoke(obj, new Object[] {
            getLargeIcon()
        });
        context.getDeclaredMethod("setContentTitle", new Class[] {
            java/lang/CharSequence
        }).invoke(obj, new Object[] {
            getAppName()
        });
        context.getDeclaredMethod("setContentText", new Class[] {
            java/lang/CharSequence
        }).invoke(obj, new Object[] {
            s
        });
        context.getDeclaredMethod("setContentIntent", new Class[] {
            android/app/PendingIntent
        }).invoke(obj, new Object[] {
            intent
        });
        context.getDeclaredMethod("setAutoCancel", new Class[] {
            Boolean.TYPE
        }).invoke(obj, new Object[] {
            Boolean.valueOf(true)
        });
        if (j < 16) goto _L11; else goto _L10
_L10:
        context = ((Context) (context.getDeclaredMethod("build", new Class[0]).invoke(obj, new Object[0])));
          goto _L12
_L13:
        ((NotificationManager)activity1.getSystemService("notification")).notify((new SecureRandom()).nextInt(), (Notification)context);
        return;
_L11:
        context = ((Context) (context.getDeclaredMethod("getNotification", new Class[0]).invoke(obj, new Object[0])));
        continue; /* Loop/switch isn't completed */
_L9:
        context = new Notification();
        android/app/Notification.getDeclaredMethod("setLatestEventInfo", new Class[] {
            android/content/Context, java/lang/String, java/lang/String, android/app/PendingIntent
        }).invoke(context, new Object[] {
            context1, getAppName(), s, intent
        });
        android/app/Notification.getField("icon").set(context, Integer.valueOf(getSmallIcon()));
        context.flags = 16;
        if (true) goto _L13; else goto _L5
_L5:
        return;
_L12:
        if (context == null) goto _L4; else goto _L13
    }
}
