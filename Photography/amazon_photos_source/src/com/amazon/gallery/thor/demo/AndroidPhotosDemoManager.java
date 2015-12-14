// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.demo;

import android.app.Activity;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;

public class AndroidPhotosDemoManager
    implements PhotosDemoManager
{

    public AndroidPhotosDemoManager()
    {
    }

    public boolean isInDemoMode()
    {
        return false;
    }

    public void setForceDemoMode(boolean flag)
    {
    }

    public void showWarningForUnavailableAction(Activity activity)
    {
    }
}
