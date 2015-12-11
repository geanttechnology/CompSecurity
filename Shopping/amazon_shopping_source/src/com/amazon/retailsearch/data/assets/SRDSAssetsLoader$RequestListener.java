// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.assets;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Assets;

// Referenced classes of package com.amazon.retailsearch.data.assets:
//            SRDSAssetsLoader

private class <init> extends AbstractServiceCallListener
{

    private boolean cancelled;
    final SRDSAssetsLoader this$0;

    public void endRequest()
    {
        if (cancelled)
        {
            return;
        }
        if (!SRDSAssetsLoader.access$700(SRDSAssetsLoader.this))
        {
            SRDSAssetsLoader.access$202(SRDSAssetsLoader.this, true);
            return;
        } else
        {
            SRDSAssetsLoader.access$500(SRDSAssetsLoader.this).searchSRDSAssetsCompleted();
            return;
        }
    }

    public void error(Exception exception)
    {
        if (!cancelled)
        {
            SRDSAssetsLoader.access$500(SRDSAssetsLoader.this).searchSRDSAssetsError("Assets request error", exception, SRDSAssetsLoader.access$800(SRDSAssetsLoader.this), SRDSAssetsLoader.access$400(SRDSAssetsLoader.this));
            SRDSAssetsLoader.access$202(SRDSAssetsLoader.this, true);
        }
    }

    public void result(Assets assets)
    {
        if (!cancelled && SRDSAssetsLoader.access$600(SRDSAssetsLoader.this, assets) != null)
        {
            SRDSAssetsLoader.access$702(SRDSAssetsLoader.this, true);
        }
    }

    public volatile void result(Object obj)
    {
        result((Assets)obj);
    }

    public void startRequest()
    {
        if (!cancelled)
        {
            SRDSAssetsLoader.access$500(SRDSAssetsLoader.this).searchSRDSAssetsStarted(SRDSAssetsLoader.access$400(SRDSAssetsLoader.this));
        }
    }


/*
    static boolean access$102(ner ner, boolean flag)
    {
        ner.cancelled = flag;
        return flag;
    }

*/

    private cancelled()
    {
        this$0 = SRDSAssetsLoader.this;
        super();
    }

    ner(ner ner)
    {
        this();
    }
}
