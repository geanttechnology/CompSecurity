// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import android.app.Activity;
import java.util.Map;

public interface AutoSaveManager
{

    public abstract Map getMediaItems();

    public abstract void registerObserver();

    public abstract void setContext(Activity activity);

    public abstract void showNewDialogForCurrentTags();
}
