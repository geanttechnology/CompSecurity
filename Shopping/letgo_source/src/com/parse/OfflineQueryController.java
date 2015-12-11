// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            AbstractQueryController, OfflineStore, ParseQueryController, ParseUser

class OfflineQueryController extends AbstractQueryController
{

    private final ParseQueryController networkController;
    private final OfflineStore offlineStore;

    public OfflineQueryController(OfflineStore offlinestore, ParseQueryController parsequerycontroller)
    {
        offlineStore = offlinestore;
        networkController = parsequerycontroller;
    }

    public cu countAsync(ParseQuery.State state, ParseUser parseuser, cu cu)
    {
        if (state.isFromLocalDatastore())
        {
            return offlineStore.countFromPinAsync(state.pinName(), state, parseuser);
        } else
        {
            return networkController.countAsync(state, parseuser, cu);
        }
    }

    public cu findAsync(ParseQuery.State state, ParseUser parseuser, cu cu)
    {
        if (state.isFromLocalDatastore())
        {
            return offlineStore.findFromPinAsync(state.pinName(), state, parseuser);
        } else
        {
            return networkController.findAsync(state, parseuser, cu);
        }
    }
}
