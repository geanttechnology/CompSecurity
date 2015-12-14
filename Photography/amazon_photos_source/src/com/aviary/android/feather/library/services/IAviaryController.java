// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.drag.DragLayer;

public interface IAviaryController
{

    public abstract void cancel();

    public abstract ToolEntry getActiveTool();

    public abstract Activity getBaseActivity();

    public abstract Context getBaseContext();

    public abstract Matrix getCurrentImageViewMatrix();

    public abstract DragLayer getDragLayer();

    public abstract Object getService(Class class1);

    public abstract AviaryTracker getTracker();

    public abstract void restoreToolbarTitle();

    public abstract void runOnUiThread(Runnable runnable);

    public abstract void setPanelApplyStatusEnabled(boolean flag);

    public abstract void setToolbarTitle(int i);

    public abstract void setToolbarTitle(CharSequence charsequence);
}
