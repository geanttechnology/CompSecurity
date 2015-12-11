// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

public final class f
{

    public static void a(Context context, ComponentName componentname)
    {
        ((AudioManager)context.getSystemService("audio")).unregisterMediaButtonEventReceiver(componentname);
    }
}
