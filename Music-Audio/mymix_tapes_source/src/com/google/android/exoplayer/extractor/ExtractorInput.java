// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;

import java.io.IOException;

public interface ExtractorInput
{

    public abstract void advancePeekPosition(int i)
        throws IOException, InterruptedException;

    public abstract long getLength();

    public abstract long getPosition();

    public abstract void peekFully(byte abyte0[], int i, int j)
        throws IOException, InterruptedException;

    public abstract int read(byte abyte0[], int i, int j)
        throws IOException, InterruptedException;

    public abstract void readFully(byte abyte0[], int i, int j)
        throws IOException, InterruptedException;

    public abstract boolean readFully(byte abyte0[], int i, int j, boolean flag)
        throws IOException, InterruptedException;

    public abstract void resetPeekPosition();

    public abstract void skipFully(int i)
        throws IOException, InterruptedException;
}
