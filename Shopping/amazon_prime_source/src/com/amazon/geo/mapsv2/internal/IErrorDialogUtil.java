// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;

public interface IErrorDialogUtil
{

    public abstract Dialog getErrorDialog(int i, Activity activity, int j);

    public abstract Dialog getErrorDialog(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener);

    public abstract PendingIntent getErrorPendingIntent(int i, Context context, int j);

    public abstract String getErrorString(int i);

    public abstract String getOpenSourceSoftwareLicenseInfo(Context context);

    public abstract boolean isUserRecoverableError(int i);

    public abstract boolean showErrorDialogFragment(int i, Activity activity, int j);

    public abstract boolean showErrorDialogFragment(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener);

    public abstract void showErrorNotification(int i, Context context);
}
