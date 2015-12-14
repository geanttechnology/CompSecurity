// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v4.app.LoaderManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            AdapterFragment

class this._cls0
    implements Runnable
{

    final AdapterFragment this$0;

    public void run()
    {
        android.os.Bundle bundle = null;
        if (contentConfiguration.toViewDescriptor().hasCollectionTypeChanged())
        {
            bundle = getPreloadArgs();
        }
        getLoaderManager().restartLoader(0x7f0c0007, bundle, AdapterFragment.this);
    }

    uration()
    {
        this$0 = AdapterFragment.this;
        super();
    }
}
