// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.demo;

import android.app.Activity;

public interface PhotosDemoManager
{

    public abstract boolean isInDemoMode();

    public abstract void setForceDemoMode(boolean flag);

    public abstract void showWarningForUnavailableAction(Activity activity);
}
