// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.xfinity.playerlib.model.VideoFavorite;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarkMenuItemDelegate, BookmarkUtils

class val.authenticatingFragment
    implements android.view.markMenuItemDelegate._cls1
{

    final BookmarkMenuItemDelegate this$0;
    final AuthenticatingFragment val$authenticatingFragment;
    final VideoFavorite val$favorite;
    final CheckBox val$favoriteIndicator;

    public void onClick(View view)
    {
        view = BookmarkMenuItemDelegate.access$000(BookmarkMenuItemDelegate.this);
        Object obj = val$favorite;
        boolean flag;
        if (!val$favoriteIndicator.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.executeAddRemove(((VideoFavorite) (obj)), flag, val$authenticatingFragment);
        obj = val$favoriteIndicator;
        if (val$favoriteIndicator.isChecked())
        {
            view = val$favoriteIndicator.getContext().getString(com.xfinity.playerlib.n_bookmarked_checkbox_selected);
        } else
        {
            view = val$favoriteIndicator.getContext().getString(com.xfinity.playerlib.n_bookmarked_checkbox_not_selected);
        }
        ((CheckBox) (obj)).setContentDescription(view);
    }

    ()
    {
        this$0 = final_bookmarkmenuitemdelegate;
        val$favorite = videofavorite;
        val$favoriteIndicator = checkbox;
        val$authenticatingFragment = AuthenticatingFragment.this;
        super();
    }
}
