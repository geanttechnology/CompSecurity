// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Clock, ContainerOpener

class this._cls0
    implements Clock
{

    final ContainerOpener this$0;

    public long currentTimeMillis()
    {
        return System.currentTimeMillis();
    }

    ()
    {
        this$0 = ContainerOpener.this;
        super();
    }
}
