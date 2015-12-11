// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.DialogInterface;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarkUtils, BookmarkEventListener

class tener
    implements android.content.OnClickListener
{

    final BookmarkUtils this$0;
    final AuthenticatingFragment val$accessibilityFragment;
    final BookmarkEventListener val$bookmarkEventListener;
    final boolean val$isAdded;
    final HalLiveStream val$liveStream;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        executeAddRemove(val$liveStream, val$isAdded, val$accessibilityFragment, val$bookmarkEventListener);
    }

    tener()
    {
        this$0 = final_bookmarkutils;
        val$liveStream = hallivestream;
        val$isAdded = flag;
        val$accessibilityFragment = authenticatingfragment;
        val$bookmarkEventListener = BookmarkEventListener.this;
        super();
    }
}
