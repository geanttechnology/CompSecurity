// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.amazon;

import android.content.Context;
import android.support.v7.app.AlertDialog;

public interface NoWifiDialogFactory
{

    public abstract AlertDialog createDialog(Context context);
}
