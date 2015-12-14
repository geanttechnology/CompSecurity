// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.mp4encoder;

import com.socialin.android.NoProGuard;

public interface MP4WriterFactory
    extends NoProGuard
{

    public abstract void createGifMovie();

    public abstract String getOutputAbsolutePath();
}
