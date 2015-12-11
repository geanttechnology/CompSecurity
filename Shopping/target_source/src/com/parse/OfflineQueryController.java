// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

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

    public j countAsync(ParseQuery.State state, ParseUser parseuser, j j)
    {
        if (state.isFromLocalDatastore())
        {
            return offlineStore.countFromPinAsync(state.pinName(), state, parseuser);
        } else
        {
            return networkController.countAsync(state, parseuser, j);
        }
    }

    public j findAsync(ParseQuery.State state, ParseUser parseuser, j j)
    {
        if (state.isFromLocalDatastore())
        {
            return offlineStore.findFromPinAsync(state.pinName(), state, parseuser);
        } else
        {
            return networkController.findAsync(state, parseuser, j);
        }
    }
}
