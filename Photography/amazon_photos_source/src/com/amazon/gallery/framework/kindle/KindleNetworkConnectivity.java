// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import com.amazon.gallery.framework.kindle.amazon.NoWifiDialogFactory;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

public class KindleNetworkConnectivity extends NetworkConnectivity
{

    private NoWifiDialogFactory factory;

    public KindleNetworkConnectivity(Context context)
    {
        super(context);
    }

    protected AlertDialog createNoWifiAlertDialog(Context context)
    {
        return factory.createDialog(context);
    }
}
