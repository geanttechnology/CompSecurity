// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.AudioManager;

public class bnm
{

    final Context a;

    public bnm(Context context)
    {
        a = context;
    }

    public float a()
    {
        AudioManager audiomanager = (AudioManager)a.getSystemService("audio");
        float f = audiomanager.getStreamMaxVolume(3);
        return (float)audiomanager.getStreamVolume(3) / f;
    }
}
