// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;


// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            LocalCache

final class  extends 
{

    final LocalCache this$0;

    public Object next()
    {
        return nextEntry().getKey();
    }

    Entry()
    {
        this$0 = LocalCache.this;
        super(LocalCache.this);
    }
}
