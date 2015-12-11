// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Referenced classes of package android.support.v4.preference:
//            PreferenceFragment

public class PreferenceManagerCompat
{
    static interface OnPreferenceTreeClickListener
    {

        public abstract boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference);
    }


    private static final String TAG = android/support/v4/preference/PreferenceManagerCompat.getSimpleName();

    public PreferenceManagerCompat()
    {
    }

    static void dispatchActivityDestroy(PreferenceManager preferencemanager)
    {
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("dispatchActivityDestroy", new Class[0]);
            method.setAccessible(true);
            method.invoke(preferencemanager, new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityDestroy by reflection", preferencemanager);
        }
    }

    static void dispatchActivityResult(PreferenceManager preferencemanager, int i, int j, Intent intent)
    {
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("dispatchActivityResult", new Class[] {
                Integer.TYPE, Integer.TYPE, android/content/Intent
            });
            method.setAccessible(true);
            method.invoke(preferencemanager, new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), intent
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityResult by reflection", preferencemanager);
        }
    }

    static void dispatchActivityStop(PreferenceManager preferencemanager)
    {
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("dispatchActivityStop", new Class[0]);
            method.setAccessible(true);
            method.invoke(preferencemanager, new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.dispatchActivityStop by reflection", preferencemanager);
        }
    }

    static PreferenceScreen getPreferenceScreen(PreferenceManager preferencemanager)
    {
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("getPreferenceScreen", new Class[0]);
            method.setAccessible(true);
            preferencemanager = (PreferenceScreen)method.invoke(preferencemanager, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.getPreferenceScreen by reflection", preferencemanager);
            return null;
        }
        return preferencemanager;
    }

    static PreferenceScreen inflateFromIntent(PreferenceManager preferencemanager, Intent intent, PreferenceScreen preferencescreen)
    {
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("inflateFromIntent", new Class[] {
                android/content/Intent, android/preference/PreferenceScreen
            });
            method.setAccessible(true);
            preferencemanager = (PreferenceScreen)method.invoke(preferencemanager, new Object[] {
                intent, preferencescreen
            });
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.inflateFromIntent by reflection", preferencemanager);
            return null;
        }
        return preferencemanager;
    }

    static PreferenceScreen inflateFromResource(PreferenceManager preferencemanager, Activity activity, int i, PreferenceScreen preferencescreen)
    {
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("inflateFromResource", new Class[] {
                android/content/Context, Integer.TYPE, android/preference/PreferenceScreen
            });
            method.setAccessible(true);
            preferencemanager = (PreferenceScreen)method.invoke(preferencemanager, new Object[] {
                activity, Integer.valueOf(i), preferencescreen
            });
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.inflateFromResource by reflection", preferencemanager);
            return null;
        }
        return preferencemanager;
    }

    static PreferenceManager newInstance(Activity activity, int i)
    {
        try
        {
            Constructor constructor = android/preference/PreferenceManager.getDeclaredConstructor(new Class[] {
                android/app/Activity, Integer.TYPE
            });
            constructor.setAccessible(true);
            activity = (PreferenceManager)constructor.newInstance(new Object[] {
                activity, Integer.valueOf(i)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.w(TAG, "Couldn't call constructor PreferenceManager by reflection", activity);
            return null;
        }
        return activity;
    }

    static void setFragment(PreferenceManager preferencemanager, PreferenceFragment preferencefragment)
    {
    }

    static void setOnPreferenceTreeClickListener(PreferenceManager preferencemanager, OnPreferenceTreeClickListener onpreferencetreeclicklistener)
    {
        Field field;
        field = android/preference/PreferenceManager.getDeclaredField("mOnPreferenceTreeClickListener");
        field.setAccessible(true);
        if (onpreferencetreeclicklistener != null)
        {
            try
            {
                ClassLoader classloader = field.getType().getClassLoader();
                Class class1 = field.getType();
                onpreferencetreeclicklistener = new InvocationHandler(onpreferencetreeclicklistener) {

                    final OnPreferenceTreeClickListener val$listener;

                    public Object invoke(Object obj, Method method, Object aobj[])
                    {
                        if (method.getName().equals("onPreferenceTreeClick"))
                        {
                            return Boolean.valueOf(listener.onPreferenceTreeClick((PreferenceScreen)aobj[0], (Preference)aobj[1]));
                        } else
                        {
                            return null;
                        }
                    }

            
            {
                listener = onpreferencetreeclicklistener;
                super();
            }
                };
                field.set(preferencemanager, Proxy.newProxyInstance(classloader, new Class[] {
                    class1
                }, onpreferencetreeclicklistener));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (PreferenceManager preferencemanager)
            {
                Log.w(TAG, "Couldn't set PreferenceManager.mOnPreferenceTreeClickListener by reflection", preferencemanager);
            }
            break MISSING_BLOCK_LABEL_78;
        }
        field.set(preferencemanager, null);
        return;
    }

    static boolean setPreferences(PreferenceManager preferencemanager, PreferenceScreen preferencescreen)
    {
        boolean flag;
        try
        {
            Method method = android/preference/PreferenceManager.getDeclaredMethod("setPreferences", new Class[] {
                android/preference/PreferenceScreen
            });
            method.setAccessible(true);
            flag = ((Boolean)method.invoke(preferencemanager, new Object[] {
                preferencescreen
            })).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (PreferenceManager preferencemanager)
        {
            Log.w(TAG, "Couldn't call PreferenceManager.setPreferences by reflection", preferencemanager);
            return false;
        }
        return flag;
    }

}
