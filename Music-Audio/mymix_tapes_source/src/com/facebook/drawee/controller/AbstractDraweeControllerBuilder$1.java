// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;

// Referenced classes of package com.facebook.drawee.controller:
//            BaseControllerListener, AbstractDraweeControllerBuilder

static final class  extends BaseControllerListener
{

    public void onFinalImageSet(String s, Object obj, Animatable animatable)
    {
        if (animatable != null)
        {
            animatable.start();
        }
    }

    ()
    {
    }
}
