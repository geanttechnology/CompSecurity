// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;

import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawableBackend

public interface AnimatedDrawableCachingBackend
    extends AnimatedDrawableBackend
{

    public abstract void appendDebugOptionString(StringBuilder stringbuilder);

    public abstract AnimatedDrawableCachingBackend forNewBounds(Rect rect);

    public abstract CloseableReference getBitmapForFrame(int i);

    public abstract CloseableReference getPreviewBitmap();
}
