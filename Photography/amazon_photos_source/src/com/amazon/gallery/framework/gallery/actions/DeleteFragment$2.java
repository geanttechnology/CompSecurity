// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class this._cls0
    implements Runnable
{

    final DeleteFragment this$0;

    public void run()
    {
        if (DeleteFragment.access$000(DeleteFragment.this))
        {
            GLogger.d(DeleteFragment.access$100(), " Delete MediaItem(s) Successful", new Object[0]);
            return;
        } else
        {
            GLogger.d(DeleteFragment.access$100(), " Delete MediaItem(s) Failed", new Object[0]);
            return;
        }
    }

    ()
    {
        this$0 = DeleteFragment.this;
        super();
    }
}
