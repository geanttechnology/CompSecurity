// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

public interface ProgressiveJpegConfig
{

    public abstract int getNextScanNumberToDecode(int i);

    public abstract QualityInfo getQualityInfo(int i);
}
