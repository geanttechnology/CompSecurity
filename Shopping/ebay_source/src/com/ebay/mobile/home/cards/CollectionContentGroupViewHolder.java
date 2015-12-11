// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.mobile.collections.CollectionViewHolder;
import com.ebay.mobile.collections.CollectionViewModel;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ListOfCollectionsViewModel

public class CollectionContentGroupViewHolder extends ViewHolder
{

    private static final int SCREEN_WIDTH_WIDE = 768;
    private static final int collectionIds[] = {
        0x7f1000fd, 0x7f1000fe, 0x7f1000ff, 0x7f100238
    };
    protected static boolean isTablet;
    public final List collectionViews = new ArrayList();
    private final int dp;
    private final TextView groupTitleTextView;
    private boolean isButtonWidthSet;
    private final Resources resources;
    private final View separator;
    private final Button showMoreButton;

    public CollectionContentGroupViewHolder(View view)
    {
        super(view);
        resources = view.getResources();
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        dp = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        isTablet = view.getContext().getResources().getBoolean(0x7f0b0006);
        int ai[];
        int j;
        boolean flag;
        if (isTablet)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        isButtonWidthSet = flag;
        ai = collectionIds;
        j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            View view1 = itemView.findViewById(k);
            if (view1 != null)
            {
                collectionViews.add(new CollectionViewHolder(view1));
            }
        }

        separator = view.findViewById(0x7f100237);
        groupTitleTextView = (TextView)view.findViewById(0x7f10005f);
        showMoreButton = (Button)view.findViewById(0x7f10029c);
        showMoreButton.setText(0x7f0701e9);
        showMoreButton.setOnClickListener(this);
        setFullSpan(true);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (viewmodel instanceof ListOfCollectionsViewModel)
        {
            viewmodel = (ListOfCollectionsViewModel)viewmodel;
            ListIterator listiterator = ((ListOfCollectionsViewModel) (viewmodel)).collections.listIterator();
            do
            {
                if (!listiterator.hasNext())
                {
                    break;
                }
                if (TextUtils.isEmpty(((CollectionViewModel)listiterator.next()).title))
                {
                    listiterator.remove();
                }
            } while (true);
            if (((ListOfCollectionsViewModel) (viewmodel)).collections.size() >= 0)
            {
                return true;
            }
        }
        return false;
    }

    public void bind(ViewModel viewmodel)
    {
        byte byte0 = 8;
        int i = 1;
        super.bind(viewmodel);
        if (!isButtonWidthSet && getItemViewType() == 4 && dp < 768)
        {
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)showMoreButton.getLayoutParams();
            layoutparams.width = resources.getDimensionPixelSize(0x7f090139);
            showMoreButton.setLayoutParams(layoutparams);
            isButtonWidthSet = true;
        }
        if (viewmodel instanceof ListOfCollectionsViewModel)
        {
            viewmodel = (ListOfCollectionsViewModel)viewmodel;
            groupTitleTextView.setText(((ListOfCollectionsViewModel) (viewmodel)).title);
            for (Iterator iterator = collectionViews.iterator(); iterator.hasNext(); ((CollectionViewHolder)iterator.next()).itemView.setVisibility(8)) { }
            int j = Math.min(collectionViews.size(), ((ListOfCollectionsViewModel) (viewmodel)).collections.size());
            View view;
            if (j <= collectionViews.size() / 2)
            {
                i = 0;
            }
            view = separator;
            if (i != 0)
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
            for (i = 0; i < j; i++)
            {
                CollectionViewModel collectionviewmodel = (CollectionViewModel)((ListOfCollectionsViewModel) (viewmodel)).collections.get(i);
                CollectionViewHolder collectionviewholder = (CollectionViewHolder)collectionViews.get(i);
                collectionviewholder.itemView.setVisibility(0);
                collectionviewholder.bind(collectionviewmodel);
            }

        }
    }

}
