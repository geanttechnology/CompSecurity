// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


public interface PowerManagerWrapper
{
    public static interface WakeLock
    {

        public abstract void acquire();

        public abstract boolean isHeld();

        public abstract void release();

        public abstract void setReferenceCounted(boolean flag);
    }


    public static final int FULL_WAKE_LOCK = 26;
    public static final int PARTIAL_WAKE_LOCK = 1;
    public static final int SCREEN_BRIGHT_WAKE_LOCK = 10;
    public static final int SCREEN_DIM_WAKE_LOCK = 6;

    public abstract WakeLock newWakeLock(int i, String s);
}
