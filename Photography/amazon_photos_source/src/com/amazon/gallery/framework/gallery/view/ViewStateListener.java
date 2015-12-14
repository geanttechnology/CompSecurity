// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;


// Referenced classes of package com.amazon.gallery.framework.gallery.view:
//            ViewDescriptor

public interface ViewStateListener
{

    public abstract void onEnterFullScreen();

    public abstract void onExitFullScreen();

    public abstract void onFocusedGained(ViewDescriptor viewdescriptor);

    public abstract void onRotation();

    public abstract void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag);
}
