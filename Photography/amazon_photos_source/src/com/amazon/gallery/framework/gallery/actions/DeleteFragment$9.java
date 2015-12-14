// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class val.mediaItemList
    implements Runnable
{

    final DeleteFragment this$0;
    final List val$mediaItemList;

    public void run()
    {
        deleteMediaItems(val$mediaItemList);
    }

    ()
    {
        this$0 = final_deletefragment;
        val$mediaItemList = List.this;
        super();
    }
}
