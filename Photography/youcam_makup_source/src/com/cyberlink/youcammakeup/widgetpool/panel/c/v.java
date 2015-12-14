// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.utility.bo;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            t

class v extends t
{

    v()
    {
        super(bo.z("default_original_looks"));
    }

    public MakeupItemMetadata b()
    {
        throw new UnsupportedOperationException("OriginalLook has no metadata");
    }
}
