// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.ContentResolver;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;

// Referenced classes of package org.acra.collector:
//            Compatibility

final class SettingsCollector
{

    SettingsCollector()
    {
    }

    public static String collectGlobalSettings(Context context)
    {
        StringBuilder stringbuilder;
        if (Compatibility.getAPILevel() < 17)
        {
            return "";
        }
        stringbuilder = new StringBuilder();
        Field afield[];
        Object obj;
        int j;
        obj = Class.forName("android.provider.Settings$Global");
        afield = ((Class) (obj)).getFields();
        obj = ((Class) (obj)).getMethod("getString", new Class[] {
            android/content/ContentResolver, java/lang/String
        });
        j = afield.length;
        int i = 0;
_L2:
        Field field;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        field = afield[i];
        Object obj1;
        if (field.isAnnotationPresent(java/lang/Deprecated) || field.getType() != java/lang/String || !isAuthorized(field))
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj1 = ((Method) (obj)).invoke(null, new Object[] {
            context.getContentResolver(), (String)field.get(null)
        });
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        stringbuilder.append(field.getName()).append("=").append(obj1).append("\n");
        i++;
        if (true) goto _L2; else goto _L1
        context;
        Log.w(ACRA.LOG_TAG, "Error : ", context);
_L1:
        return stringbuilder.toString();
        context;
        Log.w(ACRA.LOG_TAG, "Error : ", context);
        continue; /* Loop/switch isn't completed */
        context;
        Log.w(ACRA.LOG_TAG, "Error : ", context);
        continue; /* Loop/switch isn't completed */
        context;
        Log.w(ACRA.LOG_TAG, "Error : ", context);
        continue; /* Loop/switch isn't completed */
        context;
        Log.w(ACRA.LOG_TAG, "Error : ", context);
        continue; /* Loop/switch isn't completed */
        context;
        Log.w(ACRA.LOG_TAG, "Error : ", context);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static String collectSecureSettings(Context context)
    {
        StringBuilder stringbuilder;
        Field afield[];
        int i;
        int j;
        stringbuilder = new StringBuilder();
        afield = android/provider/Settings$Secure.getFields();
        j = afield.length;
        i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Field field;
        field = afield[i];
        if (field.isAnnotationPresent(java/lang/Deprecated) || field.getType() != java/lang/String || !isAuthorized(field))
        {
            continue; /* Loop/switch isn't completed */
        }
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), (String)field.get(null));
        if (s != null)
        {
            try
            {
                stringbuilder.append(field.getName()).append("=").append(s).append("\n");
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.w(ACRA.LOG_TAG, "Error : ", illegalargumentexception);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.w(ACRA.LOG_TAG, "Error : ", illegalaccessexception);
            }
        }
        i++;
          goto _L3
_L2:
        return stringbuilder.toString();
    }

    public static String collectSystemSettings(Context context)
    {
        StringBuilder stringbuilder;
        Field afield[];
        int i;
        int j;
        stringbuilder = new StringBuilder();
        afield = android/provider/Settings$System.getFields();
        j = afield.length;
        i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Field field;
        field = afield[i];
        if (field.isAnnotationPresent(java/lang/Deprecated) || field.getType() != java/lang/String)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s = android.provider.Settings.System.getString(context.getContentResolver(), (String)field.get(null));
        if (s != null)
        {
            try
            {
                stringbuilder.append(field.getName()).append("=").append(s).append("\n");
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.w(ACRA.LOG_TAG, "Error : ", illegalargumentexception);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.w(ACRA.LOG_TAG, "Error : ", illegalaccessexception);
            }
        }
        i++;
          goto _L3
_L2:
        return stringbuilder.toString();
    }

    private static boolean isAuthorized(Field field)
    {
        if (field != null && !field.getName().startsWith("WIFI_AP")) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String as[] = ACRA.getConfig().excludeMatchingSettingsKeys();
        int j = as.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                String s = as[i];
                if (field.getName().matches(s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }
}
