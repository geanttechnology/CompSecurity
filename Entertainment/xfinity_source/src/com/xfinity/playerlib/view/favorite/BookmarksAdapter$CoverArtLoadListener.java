// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarksAdapter

class holder
    implements com.comcast.cim.android.image.tener
{

    holder holder;
    final BookmarksAdapter this$0;

    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
    {
        if (BookmarksAdapter.access$000(BookmarksAdapter.this))
        {
            holder.holder.setVisibility(8);
        }
    }

    public void onLoadError(ImageView imageview, String s)
    {
    }

    public ( )
    {
        this$0 = BookmarksAdapter.this;
        super();
        holder = ;
    }
}
