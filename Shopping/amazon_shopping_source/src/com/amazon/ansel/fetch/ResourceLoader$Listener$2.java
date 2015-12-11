// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.tools.ref.ObjectReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, ResourceListener, LoaderListener

class val.error
    implements Runnable
{

    final val.error this$1;
    final Throwable val$error;

    public void run()
    {
        Object obj = getResourceListener();
        if (obj != null)
        {
            ((ResourceListener) (obj)).error(val$error);
        }
        obj = ResourceLoader.access$300(_fld0).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            LoaderListener loaderlistener = (LoaderListener)((ObjectReference)((Iterator) (obj)).next()).get();
            if (loaderlistener != null)
            {
                loaderlistener.error(val$error);
            }
        } while (true);
    }

    ()
    {
        this$1 = final_;
        val$error = Throwable.this;
        super();
    }
}
