// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.animated.factory:
//            AnimatedImageFactory

class val.bitmaps
    implements com.facebook.imagepipeline.animated.impl..Callback
{

    final AnimatedImageFactory this$0;
    final List val$bitmaps;

    public CloseableReference getCachedBitmap(int i)
    {
        return CloseableReference.cloneOrNull((CloseableReference)val$bitmaps.get(i));
    }

    public void onIntermediateResult(int i, Bitmap bitmap)
    {
    }

    llback()
    {
        this$0 = final_animatedimagefactory;
        val$bitmaps = List.this;
        super();
    }
}
