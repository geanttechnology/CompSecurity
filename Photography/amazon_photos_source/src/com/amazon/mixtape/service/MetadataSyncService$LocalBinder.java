// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.os.Binder;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataSyncService

public class this._cls0 extends Binder
{

    private final Set mProgressObservers = new CopyOnWriteArraySet();
    private final Set mStateObservers = new CopyOnWriteArraySet();
    final MetadataSyncService this$0;

    public ()
    {
        this$0 = MetadataSyncService.this;
        super();
    }
}
