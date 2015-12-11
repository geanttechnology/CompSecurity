// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.content.Context;
import android.view.View;
import com.bitstrips.imoji.models.Imoji;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public class FavouriteAdapter extends PolyAdapter
{
    public static interface FavouriteClickListener
    {

        public abstract void onClick(Imoji imoji);
    }


    private FavouriteClickListener mFavouriteClickListener;

    public FavouriteAdapter(Context context, LinkedList linkedlist)
    {
        super(context, linkedlist);
    }

    public void setFavouriteClickListener(FavouriteClickListener favouriteclicklistener)
    {
        mFavouriteClickListener = favouriteclicklistener;
    }

    public void setOnItemClick(android.support.v7.widget.RecyclerView.ViewHolder viewholder, final int position)
    {
        final Imoji imoji = ((PolyAdapter.PolyImojiItem)mImojiList.get(position)).getImoji();
        if (mFavouriteClickListener != null && imoji != null)
        {
            viewholder.itemView.setOnClickListener(new android.view.View.OnClickListener() {

                final FavouriteAdapter this$0;
                final Imoji val$imoji;
                final int val$position;

                public void onClick(View view)
                {
                    if (imoji.getSupertags() == null || imoji.getSupertags().isEmpty())
                    {
                        imoji.setSupertags(Collections.singletonList(((PolyAdapter.PolyImojiItem)mImojiList.get(position)).getSuperTag()));
                    }
                    mFavouriteClickListener.onClick(((PolyAdapter.PolyImojiItem)mImojiList.get(position)).getImoji());
                }

            
            {
                this$0 = FavouriteAdapter.this;
                imoji = imoji1;
                position = i;
                super();
            }
            });
        }
    }

}
