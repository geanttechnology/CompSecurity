// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.animated.impl:
//            AnimatedImageCompositor

public static interface 
{

    public abstract CloseableReference getCachedBitmap(int i);

    public abstract void onIntermediateResult(int i, Bitmap bitmap);
}
