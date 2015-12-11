// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils.notification;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.arellomobile.android.push.preference.SoundType;
import com.arellomobile.android.push.preference.VibrateType;

public abstract class BaseNotificationFactory
{

    private Context mContext;
    private Bundle mData;
    private String mHeader;
    private String mMessage;
    private Notification mNotification;
    private SoundType mSoundType;
    private VibrateType mVibrateType;

    public BaseNotificationFactory(Context context, Bundle bundle, String s, String s1, SoundType soundtype, VibrateType vibratetype)
    {
        mContext = context;
        mData = bundle;
        mHeader = s;
        mMessage = s1;
        mSoundType = soundtype;
        mVibrateType = vibratetype;
    }

    private static void addPushNotificationSound(Context context, Notification notification, String s)
    {
        if (s != null && s.length() != 0)
        {
            int i = context.getResources().getIdentifier(s, "raw", context.getPackageName());
            if (i != 0)
            {
                notification.sound = Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(i).toString());
                return;
            }
        }
        notification.defaults = notification.defaults | 1;
    }

    private static boolean phoneHaveVibratePermission(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i = packagemanager.checkPermission("android.permission.VIBRATE", context.getPackageName());
        if (i == 0)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_32;
        context;
        Log.e("PushWoosh", "error in checking vibrate permission", context);
        return false;
    }

    public void addCancel()
    {
        Notification notification = mNotification;
        notification.flags = notification.flags | 0x10;
    }

    public void addLED(boolean flag)
    {
        if (!flag)
        {
            return;
        } else
        {
            mNotification.ledARGB = -1;
            Notification notification = mNotification;
            notification.flags = notification.flags | 1;
            mNotification.ledOnMS = 100;
            mNotification.ledOffMS = 1000;
            return;
        }
    }

    public void addSoundAndVibrate()
    {
        String s = (String)mData.get("s");
        AudioManager audiomanager = (AudioManager)mContext.getSystemService("audio");
        if (mSoundType == SoundType.ALWAYS || audiomanager.getRingerMode() == 2 && mSoundType == SoundType.DEFAULT_MODE)
        {
            addPushNotificationSound(mContext, mNotification, s);
        }
        if ((mVibrateType == VibrateType.ALWAYS || audiomanager.getRingerMode() == 1 && mVibrateType == VibrateType.DEFAULT_MODE) && phoneHaveVibratePermission(mContext))
        {
            Notification notification = mNotification;
            notification.defaults = notification.defaults | 2;
        }
    }

    public void generateNotification()
    {
        int i = getContext().getResources().getIdentifier("new_push_message", "string", getContext().getPackageName());
        if (i != 0)
        {
            String s = getContext().getString(i);
            mNotification = generateNotificationInner(getContext(), getData(), mHeader, mMessage, s);
            return;
        } else
        {
            mNotification = generateNotificationInner(getContext(), getData(), mHeader, mMessage, mMessage);
            return;
        }
    }

    abstract Notification generateNotificationInner(Context context, Bundle bundle, String s, String s1, String s2);

    protected Context getContext()
    {
        return mContext;
    }

    protected Bundle getData()
    {
        return mData;
    }

    public Notification getNotification()
    {
        return mNotification;
    }

    protected SoundType getSoundType()
    {
        return mSoundType;
    }

    protected VibrateType getVibrateType()
    {
        return mVibrateType;
    }
}
