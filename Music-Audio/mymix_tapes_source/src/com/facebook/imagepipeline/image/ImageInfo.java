// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;


// Referenced classes of package com.facebook.imagepipeline.image:
//            QualityInfo

public interface ImageInfo
{

    public abstract int getHeight();

    public abstract QualityInfo getQualityInfo();

    public abstract int getWidth();
}
