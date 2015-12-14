// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class val.deleteCloud
    implements Runnable
{

    final DeleteFragment this$0;
    final Activity val$activity;
    final boolean val$deleteCloud;
    final List val$mediaItemList;
    final String val$parentObjectId;

    public void run()
    {
        deleteMediaItemsFromAlbum(val$activity, val$mediaItemList, val$parentObjectId, val$deleteCloud);
    }

    ()
    {
        this$0 = final_deletefragment;
        val$activity = activity1;
        val$mediaItemList = list;
        val$parentObjectId = s;
        val$deleteCloud = Z.this;
        super();
    }
}
