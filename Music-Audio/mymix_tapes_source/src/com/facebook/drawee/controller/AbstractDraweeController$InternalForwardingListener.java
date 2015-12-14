// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;


// Referenced classes of package com.facebook.drawee.controller:
//            ForwardingControllerListener, AbstractDraweeController, ControllerListener

private static class  extends ForwardingControllerListener
{

    public static  createInternal(ControllerListener controllerlistener, ControllerListener controllerlistener1)
    {
          = new <init>();
        .addListener(controllerlistener);
        .addListener(controllerlistener1);
        return ;
    }

    private ()
    {
    }
}
