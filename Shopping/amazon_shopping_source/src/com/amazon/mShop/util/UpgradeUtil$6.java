// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.view.View;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.util:
//            UpgradeUtil

static final class val.store
    implements android.view.stener
{

    final AmazonAlertDialog val$dialog;
    final DataStore val$store;

    public void onClick(View view)
    {
        val$dialog.dismiss();
        RefMarkerObserver.logRefMarker("up_remind");
        val$store.putBoolean("upgradeShouldShowDialog", true);
    }

    ce.DataStore(AmazonAlertDialog amazonalertdialog, DataStore datastore)
    {
        val$dialog = amazonalertdialog;
        val$store = datastore;
        super();
    }
}
