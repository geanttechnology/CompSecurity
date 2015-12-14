// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.mixtape.account.MetadataStore;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataFetcher, MetadataSyncException

private class needsUpgrade
{

    int currentMetadataVersion;
    String currentState;
    final boolean needsUpgrade;
    final MetadataFetcher this$0;

    public void addAccountMetadataState(String s)
        throws MetadataSyncException
    {
        if (!s.equals(currentState) || 5 != currentMetadataVersion)
        {
            MetadataFetcher.access$000(MetadataFetcher.this).addAccountMetadataState(s);
            currentState = s;
            currentMetadataVersion = 5;
        }
    }

    public void resetMetadata()
        throws MetadataSyncException
    {
        MetadataFetcher.access$000(MetadataFetcher.this).resetStore();
        addAccountMetadataState("RESET");
    }

    public State(com.amazon.mixtape.account.State state)
    {
        this$0 = MetadataFetcher.this;
        super();
        currentState = state.getState();
        currentMetadataVersion = state.getMetadataVersion();
        boolean flag;
        if (5 > currentMetadataVersion && currentState != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        needsUpgrade = flag;
    }
}
