// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.remotecontrol;

import android.media.AudioManager;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.lang.reflect.Method;

// Referenced classes of package com.google.sample.castcompanionlibrary.remotecontrol:
//            RemoteControlClientCompat

public class RemoteControlHelper
{

    private static final String TAG = "RemoteControlHelper";
    private static boolean sHasRemoteControlAPIs = false;
    private static Method sRegisterRemoteControlClientMethod;
    private static Method sUnregisterRemoteControlClientMethod;

    public RemoteControlHelper()
    {
    }

    public static void registerRemoteControlClient(AudioManager audiomanager, RemoteControlClientCompat remotecontrolclientcompat)
    {
        if (!sHasRemoteControlAPIs)
        {
            return;
        }
        try
        {
            sRegisterRemoteControlClientMethod.invoke(audiomanager, new Object[] {
                remotecontrolclientcompat.getActualRemoteControlClientObject()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AudioManager audiomanager)
        {
            LogUtils.LOGE("RemoteControlHelper", audiomanager.getMessage(), audiomanager);
        }
    }

    public static void unregisterRemoteControlClient(AudioManager audiomanager, RemoteControlClientCompat remotecontrolclientcompat)
    {
        if (!sHasRemoteControlAPIs)
        {
            return;
        }
        try
        {
            sUnregisterRemoteControlClientMethod.invoke(audiomanager, new Object[] {
                remotecontrolclientcompat.getActualRemoteControlClientObject()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AudioManager audiomanager)
        {
            LogUtils.LOGE("RemoteControlHelper", audiomanager.getMessage(), audiomanager);
        }
    }

    static 
    {
        try
        {
            Class class1 = RemoteControlClientCompat.getActualRemoteControlClientClass(com/google/sample/castcompanionlibrary/remotecontrol/RemoteControlHelper.getClassLoader());
            sRegisterRemoteControlClientMethod = android/media/AudioManager.getMethod("registerRemoteControlClient", new Class[] {
                class1
            });
            sUnregisterRemoteControlClientMethod = android/media/AudioManager.getMethod("unregisterRemoteControlClient", new Class[] {
                class1
            });
            sHasRemoteControlAPIs = true;
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        catch (NoSuchMethodException nosuchmethodexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
        catch (SecurityException securityexception) { }
    }
}
