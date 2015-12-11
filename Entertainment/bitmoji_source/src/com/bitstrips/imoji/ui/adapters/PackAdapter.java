// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.util.PicassoBorderTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public class PackAdapter extends PolyAdapter
{
    public static class BitShopHeaderPackViewHolder extends PolyAdapter.HeaderPackViewHolder
    {

        private static final int HEADER_RADIUS = 40;
        FrameLayout headerLayout;
        TextView headerPrice;
        int horizontalPadding;
        int imojiPrimaryColor;
        ImageView packHanger;
        int priceColor;
        int verticalPadding;

        private void markAsPurchased()
        {
            headerPrice.setEnabled(false);
            headerPrice.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
            headerPrice.setText(0x7f060034);
            headerPrice.setTextColor(imojiPrimaryColor);
        }

        private void markAsUnpurchasedWithPrice(String s)
        {
            headerPrice.setEnabled(true);
            headerPrice.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
            if (s == null)
            {
                headerPrice.setText(0x7f060032);
            } else
            {
                headerPrice.setText(s);
            }
            headerPrice.setTextColor(priceColor);
        }

        public void setBackground(String s)
        {
            Picasso.with(mHeaderTopImage.getContext()).load(s).placeholder(new ColorDrawable(mItem.getPack().getBgColor())).transform(new PicassoBorderTransformation(40)).into(mHeaderBottomImage);
        }



        public BitShopHeaderPackViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
            headerLayout.setBackground(null);
        }
    }

    public static class BitShopImojiImageViewHolder extends PolyAdapter.ImojiViewHolder
    {

        View mLeftBorder;
        View mRightBorder;

        public BitShopImojiImageViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static interface PackClickListener
    {

        public abstract void onPackClick(BitshopPack bitshoppack);
    }


    private PackClickListener mPackClickListener;

    public PackAdapter(Context context, LinkedList linkedlist)
    {
        super(context, linkedlist);
    }

    protected PolyAdapter.HeaderPackViewHolder getHeaderPackViewHolder(ViewGroup viewgroup)
    {
        viewgroup = new BitShopHeaderPackViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030039, viewgroup, false));
        ((PolyAdapter.HeaderPackViewHolder) (viewgroup)).mTopShadowLine.setVisibility(4);
        return viewgroup;
    }

    protected PolyAdapter.ImojiViewHolder getImojiImageViewHolder(ViewGroup viewgroup)
    {
        return new BitShopImojiImageViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030023, viewgroup, false));
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        Object obj;
        super.onBindViewHolder(viewholder, i);
        obj = ((PolyAdapter.PolyImojiItem)mImojiList.get(i)).getPack();
        if (obj == null || !(viewholder instanceof BitShopHeaderPackViewHolder)) goto _L2; else goto _L1
_L1:
        if (!((BitshopPack) (obj)).isPurchased()) goto _L4; else goto _L3
_L3:
        ((BitShopHeaderPackViewHolder)viewholder).markAsPurchased();
_L6:
        return;
_L4:
        if (((BitshopPack) (obj)).isFree())
        {
            obj = null;
        } else
        {
            obj = ((BitshopPack) (obj)).getPrice();
        }
        ((BitShopHeaderPackViewHolder)viewholder).markAsUnpurchasedWithPrice(((String) (obj)));
        return;
_L2:
        if (obj != null && (viewholder instanceof BitShopImojiImageViewHolder))
        {
            viewholder = (BitShopImojiImageViewHolder)viewholder;
            i = ((BitshopPack) (obj)).getTemplates().indexOf(((PolyAdapter.PolyImojiItem)mImojiList.get(i)).getImoji());
            if (i % 3 == 0 || i == 0)
            {
                ((BitShopImojiImageViewHolder) (viewholder)).mLeftBorder.setVisibility(0);
                ((BitShopImojiImageViewHolder) (viewholder)).mRightBorder.setVisibility(8);
                return;
            }
            if ((i + 1) % 3 == 0)
            {
                ((BitShopImojiImageViewHolder) (viewholder)).mRightBorder.setVisibility(0);
                ((BitShopImojiImageViewHolder) (viewholder)).mLeftBorder.setVisibility(8);
                return;
            } else
            {
                ((BitShopImojiImageViewHolder) (viewholder)).mLeftBorder.setVisibility(8);
                ((BitShopImojiImageViewHolder) (viewholder)).mRightBorder.setVisibility(8);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setDataList(LinkedList linkedlist)
    {
        mImojiList = linkedlist;
    }

    public void setOnItemClick(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        final BitshopPack pack = ((PolyAdapter.PolyImojiItem)mImojiList.get(i)).getPack();
        if (mPackClickListener != null && pack != null)
        {
            viewholder.itemView.setOnClickListener(new android.view.View.OnClickListener() {

                final PackAdapter this$0;
                final BitshopPack val$pack;

                public void onClick(View view)
                {
                    mPackClickListener.onPackClick(pack);
                }

            
            {
                this$0 = PackAdapter.this;
                pack = bitshoppack;
                super();
            }
            });
        }
    }

    public void setPackClickListener(PackClickListener packclicklistener)
    {
        mPackClickListener = packclicklistener;
    }

}
