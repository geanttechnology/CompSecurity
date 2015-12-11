// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.content.Content;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

class this._cls0
{

    public Content result;
    final FollowedEntityDataManager this$0;
    public final CountDownLatch wait = new CountDownLatch(1);

    ()
    {
        this$0 = FollowedEntityDataManager.this;
        super();
    }
}
