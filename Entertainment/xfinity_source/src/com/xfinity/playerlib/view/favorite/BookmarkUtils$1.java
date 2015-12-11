// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.DialogInterface;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.xfinity.playerlib.model.VideoFavorite;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarkUtils

class agment
    implements android.content.OnClickListener
{

    final BookmarkUtils this$0;
    final AuthenticatingFragment val$accessibilityFragment;
    final VideoFavorite val$favorite;
    final boolean val$isAdded;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        executeAddRemove(val$favorite, val$isAdded, val$accessibilityFragment);
    }

    agment()
    {
        this$0 = final_bookmarkutils;
        val$favorite = videofavorite;
        val$isAdded = flag;
        val$accessibilityFragment = AuthenticatingFragment.this;
        super();
    }
}
