// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.views.ImojiWithBadgeView;
import com.crashlytics.android.Crashlytics;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.LinkedList;
import javax.inject.Provider;

public abstract class PolyAdapter extends android.support.v7.widget.RecyclerView.Adapter
{
    public static class HeaderPackViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
        implements ViewHolderSetup
    {

        ImageView mHeaderBottomImage;
        ImageView mHeaderTopImage;
        PolyImojiItem mItem;
        TextView mTitleView;
        View mTopShadowLine;

        private void onErrorLogo(String s)
        {
            mHeaderTopImage.setVisibility(8);
            mTitleView.setVisibility(0);
            StringBuilder stringbuilder = (new StringBuilder()).append("Failed to load Bitshop pack header logo image: ");
            if (s == null)
            {
                s = "null";
            }
            s = stringbuilder.append(s).toString();
            Log.e("error", s);
            Crashlytics.log(s);
        }

        public void setBackground(String s)
        {
            Picasso.with(mHeaderTopImage.getContext()).load(s).placeholder(new ColorDrawable(mItem.getPack().getBgColor())).fit().centerInside().into(mHeaderBottomImage);
        }

        public void setImage(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                onErrorLogo(s);
            }
            mHeaderTopImage.setVisibility(0);
            Picasso.with(mHeaderTopImage.getContext()).load(s).fit().centerInside().into(mHeaderTopImage, s. new Callback() {

                final HeaderPackViewHolder this$0;
                final String val$topImageUrl;

                public void onError()
                {
                    onErrorLogo(topImageUrl);
                }

                public void onSuccess()
                {
                    mTitleView.setVisibility(8);
                }

            
            {
                this$0 = final_headerpackviewholder;
                topImageUrl = String.this;
                super();
            }
            });
        }

        public void setItem(PolyImojiItem polyimojiitem)
        {
            mItem = polyimojiitem;
        }

        public void setTitle(String s)
        {
            mTitleView.setTextColor(mItem.getPack().getFgColor());
            mTitleView.setText(s);
        }


        public HeaderPackViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class HeaderTitleViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
        implements ViewHolderSetup
    {

        TextView mHeaderTitle;
        PolyImojiItem mItem;

        public void setBackground(String s)
        {
        }

        public void setImage(String s)
        {
        }

        public void setItem(PolyImojiItem polyimojiitem)
        {
            mItem = polyimojiitem;
        }

        public void setTitle(String s)
        {
            byte byte0;
            mHeaderTitle.setText(s);
            s = s.toLowerCase();
            byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 3: default 52
        //                       -1960890269: 109
        //                       -934918565: 81
        //                       -393940263: 95;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_109;
_L5:
            switch (byte0)
            {
            default:
                return;

            case 0: // '\0'
                mHeaderTitle.setBackgroundColor(mHeaderTitle.getContext().getResources().getColor(0x7f090075));
                return;

            case 1: // '\001'
                mHeaderTitle.setBackgroundColor(mHeaderTitle.getContext().getResources().getColor(0x7f09006a));
                return;

            case 2: // '\002'
                mHeaderTitle.setBackgroundColor(mHeaderTitle.getContext().getResources().getColor(0x7f090074));
                break;
            }
            break MISSING_BLOCK_LABEL_191;
_L3:
            if (s.equals("recent"))
            {
                byte0 = 0;
            }
              goto _L5
_L4:
            if (s.equals("popular"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s.equals("theme packs"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        public HeaderTitleViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class ImojiViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
        implements ViewHolderSetup
    {

        ImojiWithBadgeView mImojiWithBadgeView;
        PolyImojiItem mItem;

        public void setBackground(String s)
        {
        }

        public void setImage(String s)
        {
            mImojiWithBadgeView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
            Picasso.with(mImojiWithBadgeView.getContext()).load(s).placeholder(0x7f0200a9).fit().centerInside().into(mImojiWithBadgeView);
        }

        public void setItem(PolyImojiItem polyimojiitem)
        {
            mItem = polyimojiitem;
        }

        public void setTitle(String s)
        {
        }

        public ImojiViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class PolyCellType
    {

        public static final int CELLTYPE_HEADER_PACK = 1;
        public static final int CELLTYPE_HEADER_SECTION = 0;
        public static final int CELLTYPE_IMOJI = 2;
        public static final int CELLTYPE_PACKS_EMPTY = 4;
        public static final int CELLTYPE_RECENT_EMPTY = 3;
        public static final int CELLTYPE_ROUND_FOOTER = 5;

        public PolyCellType()
        {
        }
    }

    public static class PolyImojiItem
    {

        private Imoji imoji;
        private BitshopPack pack;
        private String superTag;
        private String title;
        private int type;

        public String getBackgroundImageUrl()
        {
            if (pack != null)
            {
                return pack.getHeaderBackgroundUrl();
            } else
            {
                return null;
            }
        }

        public String getImageUrl(String s)
        {
            Object obj = null;
            String s1 = obj;
            switch (type)
            {
            case 2: // '\002'
            default:
                s1 = obj;
                if (imoji != null)
                {
                    s1 = imoji.getUrl(s, true);
                }
                // fall through

            case 0: // '\0'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                return s1;

            case 1: // '\001'
                return pack.getHeaderLogoUrl();
            }
        }

        public Imoji getImoji()
        {
            return imoji;
        }

        public int getNumColumns()
        {
            switch (type)
            {
            case 2: // '\002'
            default:
                return 1;

            case 0: // '\0'
            case 1: // '\001'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                return 3;
            }
        }

        public BitshopPack getPack()
        {
            return pack;
        }

        public String getSuperTag()
        {
            return superTag;
        }

        public String getTitle()
        {
            return title;
        }

        public int getType()
        {
            return type;
        }

        public void setPack(BitshopPack bitshoppack)
        {
            pack = bitshoppack;
        }

        public PolyImojiItem(String s, int i)
        {
            type = i;
            title = s;
        }

        public PolyImojiItem(String s, BitshopPack bitshoppack, int i)
        {
            pack = bitshoppack;
            title = s;
            type = i;
        }

        public PolyImojiItem(String s, Imoji imoji1, int i, String s1)
        {
            title = s;
            imoji = imoji1;
            type = i;
            superTag = s1;
        }
    }

    static interface ViewHolderSetup
    {

        public abstract void setBackground(String s);

        public abstract void setImage(String s);

        public abstract void setItem(PolyImojiItem polyimojiitem);

        public abstract void setTitle(String s);
    }


    Provider mAvatarIdProvider;
    protected LinkedList mImojiList;

    public PolyAdapter(Context context, LinkedList linkedlist)
    {
        ((InjectorApplication)context.getApplicationContext()).inject(this);
        mImojiList = linkedlist;
    }

    protected HeaderPackViewHolder getHeaderPackViewHolder(ViewGroup viewgroup)
    {
        return new HeaderPackViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03003a, viewgroup, false));
    }

    protected ImojiViewHolder getImojiImageViewHolder(ViewGroup viewgroup)
    {
        return new ImojiViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03003e, viewgroup, false));
    }

    public int getItemCount()
    {
        return mImojiList.size();
    }

    public int getItemViewType(int i)
    {
        return ((PolyImojiItem)mImojiList.get(i)).getType();
    }

    public int getSpanSizeForItem(int i)
    {
        return ((PolyImojiItem)mImojiList.get(i)).getNumColumns();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        if (!(viewholder instanceof ViewHolderSetup))
        {
            return;
        } else
        {
            ViewHolderSetup viewholdersetup = (ViewHolderSetup)viewholder;
            viewholdersetup.setItem((PolyImojiItem)mImojiList.get(i));
            viewholdersetup.setImage(((PolyImojiItem)mImojiList.get(i)).getImageUrl((String)mAvatarIdProvider.get()));
            viewholdersetup.setBackground(((PolyImojiItem)mImojiList.get(i)).getBackgroundImageUrl());
            viewholdersetup.setTitle(((PolyImojiItem)mImojiList.get(i)).getTitle());
            viewholdersetup.setItem((PolyImojiItem)mImojiList.get(i));
            setOnItemClick(viewholder, i);
            return;
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        default:
            return null;

        case 2: // '\002'
            return getImojiImageViewHolder(viewgroup);

        case 1: // '\001'
            return getHeaderPackViewHolder(viewgroup);

        case 0: // '\0'
            return new HeaderTitleViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03003b, viewgroup, false));

        case 3: // '\003'
            return new android.support.v7.widget.RecyclerView.ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030025, viewgroup, false)) {

                final PolyAdapter this$0;

            
            {
                this$0 = PolyAdapter.this;
                super(view);
            }
            };

        case 5: // '\005'
            return new android.support.v7.widget.RecyclerView.ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030037, viewgroup, false)) {

                final PolyAdapter this$0;

            
            {
                this$0 = PolyAdapter.this;
                super(view);
            }
            };

        case 4: // '\004'
            return new android.support.v7.widget.RecyclerView.ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030024, viewgroup, false)) {

                final PolyAdapter this$0;

            
            {
                this$0 = PolyAdapter.this;
                super(view);
            }
            };
        }
    }

    public abstract void setOnItemClick(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i);
}
