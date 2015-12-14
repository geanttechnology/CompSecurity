// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;


public interface SeekMap
{

    public static final SeekMap UNSEEKABLE = new SeekMap() {

        public long getPosition(long l)
        {
            return 0L;
        }

        public boolean isSeekable()
        {
            return false;
        }

    };

    public abstract long getPosition(long l);

    public abstract boolean isSeekable();

}
