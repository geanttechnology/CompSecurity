// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioTrack;
import android.os.ConditionVariable;

final class aow extends Thread
{

    private AudioTrack a;
    private aov b;

    aow(aov aov1, AudioTrack audiotrack)
    {
        b = aov1;
        a = audiotrack;
        super();
    }

    public final void run()
    {
        a.release();
        b.a.open();
        return;
        Exception exception;
        exception;
        b.a.open();
        throw exception;
    }
}
