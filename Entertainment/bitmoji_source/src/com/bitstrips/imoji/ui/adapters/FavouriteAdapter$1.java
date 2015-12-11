// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.view.View;
import com.bitstrips.imoji.models.Imoji;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            FavouriteAdapter

class val.position
    implements android.view.r
{

    final FavouriteAdapter this$0;
    final Imoji val$imoji;
    final int val$position;

    public void onClick(View view)
    {
        if (val$imoji.getSupertags() == null || val$imoji.getSupertags().isEmpty())
        {
            val$imoji.setSupertags(Collections.singletonList(((jiItem)mImojiList.get(val$position)).getSuperTag()));
        }
        FavouriteAdapter.access$000(FavouriteAdapter.this).onClick(((jiItem)mImojiList.get(val$position)).getImoji());
    }

    vouriteClickListener()
    {
        this$0 = final_favouriteadapter;
        val$imoji = imoji1;
        val$position = I.this;
        super();
    }
}
