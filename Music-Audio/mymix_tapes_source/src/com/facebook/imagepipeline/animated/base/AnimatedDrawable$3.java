// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;

import com.facebook.common.logging.FLog;

// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawable

class this._cls0
    implements Runnable
{

    final AnimatedDrawable this$0;

    public void run()
    {
        FLog.v(AnimatedDrawable.access$100(), "(%s) Invalidate Task", AnimatedDrawable.access$200(AnimatedDrawable.this));
        AnimatedDrawable.access$402(AnimatedDrawable.this, false);
        AnimatedDrawable.access$500(AnimatedDrawable.this);
    }

    A()
    {
        this$0 = AnimatedDrawable.this;
        super();
    }
}
