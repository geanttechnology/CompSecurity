// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.ComponentName;
import android.media.AudioManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MediaButtonHelper
{

    private static final String TAG = "MediaButtonHelper";
    static Method sMethodRegisterMediaButtonEventReceiver;
    static Method sMethodUnregisterMediaButtonEventReceiver;

    public MediaButtonHelper()
    {
    }

    static void initializeStaticCompatMethods()
    {
        try
        {
            sMethodRegisterMediaButtonEventReceiver = android/media/AudioManager.getMethod("registerMediaButtonEventReceiver", new Class[] {
                android/content/ComponentName
            });
            sMethodUnregisterMediaButtonEventReceiver = android/media/AudioManager.getMethod("unregisterMediaButtonEventReceiver", new Class[] {
                android/content/ComponentName
            });
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return;
        }
    }

    public static void registerMediaButtonEventReceiverCompat(AudioManager audiomanager, ComponentName componentname)
    {
        if (sMethodRegisterMediaButtonEventReceiver == null)
        {
            return;
        }
        try
        {
            sMethodRegisterMediaButtonEventReceiver.invoke(audiomanager, new Object[] {
                componentname
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AudioManager audiomanager)
        {
            componentname = audiomanager.getCause();
            if (componentname instanceof RuntimeException)
            {
                throw (RuntimeException)componentname;
            }
            if (componentname instanceof Error)
            {
                throw (Error)componentname;
            } else
            {
                throw new RuntimeException(audiomanager);
            }
        }
        // Misplaced declaration of an exception variable
        catch (AudioManager audiomanager)
        {
            Log.e("MediaButtonHelper", "IllegalAccessException invoking registerMediaButtonEventReceiver.");
        }
        audiomanager.printStackTrace();
    }

    public static void unregisterMediaButtonEventReceiverCompat(AudioManager audiomanager, ComponentName componentname)
    {
        if (sMethodUnregisterMediaButtonEventReceiver == null)
        {
            return;
        }
        try
        {
            sMethodUnregisterMediaButtonEventReceiver.invoke(audiomanager, new Object[] {
                componentname
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AudioManager audiomanager)
        {
            componentname = audiomanager.getCause();
            if (componentname instanceof RuntimeException)
            {
                throw (RuntimeException)componentname;
            }
            if (componentname instanceof Error)
            {
                throw (Error)componentname;
            } else
            {
                throw new RuntimeException(audiomanager);
            }
        }
        // Misplaced declaration of an exception variable
        catch (AudioManager audiomanager)
        {
            Log.e("MediaButtonHelper", "IllegalAccessException invoking unregisterMediaButtonEventReceiver.");
        }
        audiomanager.printStackTrace();
    }

    static 
    {
        initializeStaticCompatMethods();
    }
}
