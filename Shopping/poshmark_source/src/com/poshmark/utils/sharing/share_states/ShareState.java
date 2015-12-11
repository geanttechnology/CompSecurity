// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing.share_states;

import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.StateCompletionListener;
import java.util.UUID;

public abstract class ShareState
{

    StateCompletionListener listener;
    ShareManager shareManager;

    public ShareState(StateCompletionListener statecompletionlistener, ShareManager sharemanager)
    {
        listener = statecompletionlistener;
        shareManager = sharemanager;
    }

    public void executeState()
    {
    }

    public abstract UUID getId();
}
