// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.widgets;

import android.net.Uri;

public interface IMiniController
{

    public abstract boolean isVisible();

    public abstract void setIcon(Uri uri);

    public abstract void setOnMiniControllerChangedListener(MiniController.OnMiniControllerChangedListener onminicontrollerchangedlistener);

    public abstract void setPlaybackStatus(int i);

    public abstract void setSubTitle(String s);

    public abstract void setTitle(String s);

    public abstract void setVisibility(int i);
}
