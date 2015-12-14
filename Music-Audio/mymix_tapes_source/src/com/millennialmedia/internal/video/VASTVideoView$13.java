// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import java.util.Comparator;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class this._cls0
    implements Comparator
{

    final VASTVideoView this$0;

    public int compare( ,  1)
    {
        return .position - 1.position;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare(()obj, ()obj1);
    }

    ()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
