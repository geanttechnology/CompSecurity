// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;

// Referenced classes of package com.facebook.drawee.controller:
//            ControllerListener

public class BaseControllerListener
    implements ControllerListener
{

    private static final ControllerListener NO_OP_LISTENER = new BaseControllerListener();

    public BaseControllerListener()
    {
    }

    public static ControllerListener getNoOpListener()
    {
        return NO_OP_LISTENER;
    }

    public void onFailure(String s, Throwable throwable)
    {
    }

    public void onFinalImageSet(String s, Object obj, Animatable animatable)
    {
    }

    public void onIntermediateImageFailed(String s, Throwable throwable)
    {
    }

    public void onIntermediateImageSet(String s, Object obj)
    {
    }

    public void onRelease(String s)
    {
    }

    public void onSubmit(String s, Object obj)
    {
    }

}
