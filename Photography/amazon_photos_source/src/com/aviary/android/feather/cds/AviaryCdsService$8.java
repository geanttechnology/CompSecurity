// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.Context;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

class val.context
    implements com.aviary.android.feather.common.threading.
{

    WeakReference mContext;
    final AviaryCdsService this$0;
    final Context val$context;

    public transient InputStream run(com.aviary.android.feather.common.threading. , String as[])
        throws Exception
    {
        if (!AviaryCdsService.isConnected((Context)mContext.get()))
        {
            throw new IOException("Could not run the Job without wifi connection");
        } else
        {
            return IOUtils.download(as[0], null);
        }
    }

    public volatile Object run(com.aviary.android.feather.common.threading. , Object aobj[])
        throws Exception
    {
        return run(, (String[])aobj);
    }

    Pool.Worker()
    {
        this$0 = final_aviarycdsservice;
        val$context = Context.this;
        super();
        mContext = new WeakReference(val$context);
    }
}
