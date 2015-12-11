// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.cache.RemovalCause;
import org.roboguice.shaded.goole.common.cache.RemovalListener;
import org.roboguice.shaded.goole.common.cache.RemovalNotification;

// Referenced classes of package com.google.inject.internal:
//            WeakKeySet

class this._cls0
    implements RemovalListener
{

    final WeakKeySet this$0;

    public void onRemoval(RemovalNotification removalnotification)
    {
        Preconditions.checkState(RemovalCause.COLLECTED.equals(removalnotification.getCause()));
        WeakKeySet.access$000(WeakKeySet.this, (Set)removalnotification.getValue());
    }

    RemovalNotification()
    {
        this$0 = WeakKeySet.this;
        super();
    }
}
