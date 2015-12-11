// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.tools.ref.ObjectReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, ResourceListener, LoaderListener

class this._cls0
    implements Runnable
{

    final ResourceLoader this$0;

    public void run()
    {
        Object obj = getResourceListener();
        if (obj != null)
        {
            ((ResourceListener) (obj)).done();
        }
        obj = ResourceLoader.access$300(ResourceLoader.this).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            LoaderListener loaderlistener = (LoaderListener)((ObjectReference)((Iterator) (obj)).next()).get();
            if (loaderlistener != null)
            {
                loaderlistener.done();
            }
        } while (true);
    }

    eference()
    {
        this$0 = ResourceLoader.this;
        super();
    }
}
