// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.widget.UserThumbnail;
import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionViewModel

public class CollectionViewHolder extends ViewHolder
{

    private final String STRING_CREATED_BY;
    private final View collectionOwnerIcon;
    private final View collectionTitleSubtitle;
    private final List images;
    private final View selectableView;
    private final TextView subtitle;
    private final TextView title;
    private final TextView userCollectionTitle;
    private final View userIconName;
    private final UserThumbnail userImage;
    private final TextView userNameSubtitle;

    public CollectionViewHolder(View view)
    {
        super(view);
        selectableView = itemView;
        STRING_CREATED_BY = view.getContext().getString(0x7f070221);
        if (selectableView != null)
        {
            selectableView.setOnClickListener(this);
        }
        title = (TextView)itemView.findViewById(0x7f10005f);
        subtitle = (TextView)itemView.findViewById(0x7f1000fb);
        images = findViewsByIds(itemView, new int[] {
            0x7f1000f3, 0x7f1000f4, 0x7f1000f5, 0x7f10010b
        });
        userImage = (UserThumbnail)itemView.findViewById(0x7f1000fa);
        userIconName = itemView.findViewById(0x7f1000f7);
        if (userIconName != null)
        {
            userIconName.setClickable(true);
            userIconName.setOnClickListener(this);
        }
        userCollectionTitle = (TextView)itemView.findViewById(0x7f100115);
        userNameSubtitle = (TextView)itemView.findViewById(0x7f100116);
        collectionTitleSubtitle = itemView.findViewById(0x7f1000f6);
        collectionOwnerIcon = itemView.findViewById(0x7f1000f7);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (!(viewmodel instanceof CollectionViewModel))
        {
            return false;
        }
        viewmodel = (CollectionViewModel)viewmodel;
        byte byte0;
        if (flag || flag1)
        {
            byte0 = 4;
        } else
        {
            byte0 = 3;
        }
        if (isNotEmpty(new CharSequence[] {
    ((CollectionViewModel) (viewmodel)).title, ((CollectionViewModel) (viewmodel)).username, ((CollectionViewModel) (viewmodel)).collectionId
}) && ((CollectionViewModel) (viewmodel)).images.size() >= byte0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof CollectionViewModel)) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        viewmodel = (CollectionViewModel)viewmodel;
        title.setText(((CollectionViewModel) (viewmodel)).title);
        bindImageViews(((CollectionViewModel) (viewmodel)).images, images);
        Resources resources = itemView.getResources();
        int i;
        if (((CollectionViewModel) (viewmodel)).lowestAmount != null && ((CollectionViewModel) (viewmodel)).lowestAmount.currency != null)
        {
            subtitle.setText(resources.getQuantityString(0x7f08000d, ((CollectionViewModel) (viewmodel)).entryCount, new Object[] {
                Integer.valueOf(((CollectionViewModel) (viewmodel)).entryCount), EbayCurrencyUtil.formatDisplay(((CollectionViewModel) (viewmodel)).lowestAmount.getAmount(), 2)
            }));
        } else
        {
            subtitle.setText(resources.getQuantityString(0x7f080014, ((CollectionViewModel) (viewmodel)).entryCount, new Object[] {
                Integer.valueOf(((CollectionViewModel) (viewmodel)).entryCount)
            }));
        }
        if (((CollectionViewModel) (viewmodel)).isCollectionOwnerShown)
        {
            collectionTitleSubtitle.setVisibility(8);
            collectionOwnerIcon.setVisibility(0);
        } else
        {
            collectionTitleSubtitle.setVisibility(0);
            collectionOwnerIcon.setVisibility(8);
        }
        if (userCollectionTitle != null)
        {
            userCollectionTitle.setText(((CollectionViewModel) (viewmodel)).title);
        }
        if (userNameSubtitle != null)
        {
            userNameSubtitle.setText(String.format(STRING_CREATED_BY, new Object[] {
                ((CollectionViewModel) (viewmodel)).username
            }));
        }
        if (userImage != null)
        {
            if (!TextUtils.isEmpty(((CollectionViewModel) (viewmodel)).userImage))
            {
                userImage.setRemoteImageUrl(((CollectionViewModel) (viewmodel)).userImage);
            } else
            {
                userImage.setUserId(((CollectionViewModel) (viewmodel)).username);
            }
        }
        i = getItemViewType();
        j = resources.getDimensionPixelSize(0x7f090142);
        k = resources.getDimensionPixelSize(0x7f090144);
        i;
        JVM INSTR tableswitch 0 2: default 260
    //                   0 359
    //                   1 329
    //                   2 344;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L4:
        itemView.setPadding(k, k, j, 0);
        return;
_L5:
        itemView.setPadding(j, k, k, 0);
        return;
_L3:
        itemView.setPadding(k, k, k, 0);
        return;
    }
}
