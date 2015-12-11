// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.libraries.youtube.media.m2ts;

import b;
import cik;
import cim;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;

public class NativeM2TSPlayer
    implements cik
{

    public final Queue a;
    public boolean b;
    public boolean c;
    public boolean d;

    public NativeM2TSPlayer()
    {
        if (!createPlayer())
        {
            throw new cim();
        } else
        {
            c = false;
            a = new LinkedList();
            return;
        }
    }

    public static void a(float f)
    {
        setVolumeLevel(f);
    }

    public static long c()
    {
        return (long)getPositionMillis() * 1000L;
    }

    private static native boolean createPlayer();

    public static native void enqueueBuffer(ByteBuffer bytebuffer, int i);

    public static native void enqueueEos();

    private static native int getPositionMillis();

    public static native ByteBuffer getUnusedBuffer();

    public static native void setPlaybackState(boolean flag);

    private static native void setVolumeLevel(float f);

    private static native void shutdown();

    public final void a()
    {
        boolean flag;
        if (!c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        setPlaybackState(true);
    }

    public final void a(byte abyte0[])
    {
        a.add(abyte0);
    }

    public final void b()
    {
        if (!c)
        {
            c = true;
            setPlaybackState(false);
            shutdown();
        }
    }

    static 
    {
        System.loadLibrary("m2ts_player");
    }
}
