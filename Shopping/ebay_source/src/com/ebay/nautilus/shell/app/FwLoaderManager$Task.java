// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwLoaderManager

private final class isCancelable
    implements com.ebay.nautilus.shell.content.ncelable
{

    public final int id;
    public final boolean isCancelable;
    public final FwLoader loader;
    final FwLoaderManager this$0;

    public final boolean cancel(boolean flag)
    {
        return loader.cancel(flag);
    }

    public void onCanceled(FwLoader fwloader)
    {
        removeLoader(this);
        ack ack = handler;
        if (ack != null)
        {
            if (FwLoaderManager.access$000().ble)
            {
                FwLoaderManager.access$100(FwLoaderManager.this, FwLoaderManager.access$000(), ack.getContext().getClass().getName(), "onCanceled", null, new Object[] {
                    Integer.valueOf(id), fwloader
                });
            }
            ack.onCanceled(id, fwloader);
        }
    }

    public void onTaskComplete(FwLoader fwloader)
    {
        removeLoader(this);
        ack ack = handler;
        if (ack != null)
        {
            if (FwLoaderManager.access$000().ble)
            {
                FwLoaderManager.access$100(FwLoaderManager.this, FwLoaderManager.access$000(), ack.getContext().getClass().getName(), "onTaskComplete", null, new Object[] {
                    Integer.valueOf(id), fwloader
                });
            }
            ack.onTaskComplete(id, fwloader);
        }
    }

    public ack(int i, FwLoader fwloader, boolean flag)
    {
        this$0 = FwLoaderManager.this;
        super();
        id = i;
        loader = fwloader;
        isCancelable = flag;
    }
}
