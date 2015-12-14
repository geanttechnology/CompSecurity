// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.encoder.factory;

import android.graphics.Bitmap;
import java.io.File;

public interface VideoEncoderFactory
{

    public abstract boolean addFrame(Bitmap bitmap, long l);

    public abstract boolean cancelVideoGeneration();

    public abstract boolean endVideoGeneration();

    public abstract void init(int i, int j, int k, File file);

    public abstract boolean startVideoGeneration(File file);
}
