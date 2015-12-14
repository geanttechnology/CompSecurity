// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import com.aviary.android.feather.common.utils.IOUtils;
import java.io.InputStream;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

class this._cls0
    implements com.aviary.android.feather.common.threading.
{

    final AviaryCdsService this$0;

    public transient InputStream run(com.aviary.android.feather.common.threading. , String as[])
        throws Exception
    {
        return IOUtils.download(as[0], null);
    }

    public volatile Object run(com.aviary.android.feather.common.threading. , Object aobj[])
        throws Exception
    {
        return run(, (String[])aobj);
    }

    Pool.Worker()
    {
        this$0 = AviaryCdsService.this;
        super();
    }
}
