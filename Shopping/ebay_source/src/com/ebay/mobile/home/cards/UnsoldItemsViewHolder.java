// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.home.cards:
//            PaddingSpan, SellingUtilityViewModel

public class UnsoldItemsViewHolder extends ViewHolder
{

    public final TextView allRelisted;
    public final TextView noOfUnSoldItems;
    public final TextView notYetRelistedText;
    private final TextView oopsUnSoldText;
    private final Resources resources;
    public final View unSoldBoard;

    public UnsoldItemsViewHolder(View view)
    {
        super(view);
        resources = view.getResources();
        String s = resources.getString(0x7f07046d);
        int i = s.length();
        s = (new StringBuilder()).append(s).append("\n").append(resources.getString(0x7f070470)).toString();
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        int j = s.length();
        spannablestringbuilder.setSpan(new TextAppearanceSpan(view.getContext(), 0x7f0a0152), i, j, 33);
        spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d00df)), i, j, 33);
        unSoldBoard = view.findViewById(0x7f1002cf);
        noOfUnSoldItems = (TextView)view.findViewById(0x7f1002d1);
        notYetRelistedText = (TextView)view.findViewById(0x7f1002d2);
        allRelisted = (TextView)view.findViewById(0x7f1002d3);
        oopsUnSoldText = (TextView)view.findViewById(0x7f10021a);
        oopsUnSoldText.setText(spannablestringbuilder);
        unSoldBoard.setOnClickListener(this);
    }

    private Spannable getRelistedText(int i)
    {
        int j = String.valueOf(i).length();
        Object obj = resources.getQuantityString(0x7f080003, i, new Object[] {
            Integer.valueOf(i)
        });
        i = ((String) (obj)).length();
        obj = new SpannableString(((CharSequence) (obj)));
        ((Spannable) (obj)).setSpan(new TextAppearanceSpan(notYetRelistedText.getContext(), 0x7f0a014b), 0, j, 33);
        ((Spannable) (obj)).setSpan(new PaddingSpan(resources.getDimensionPixelSize(0x7f090051), resources.getDimensionPixelSize(0x7f09007a)), 0, j, 33);
        ((Spannable) (obj)).setSpan(new TextAppearanceSpan(notYetRelistedText.getContext(), 0x7f0a013d), j, i, 33);
        ((Spannable) (obj)).setSpan(new PaddingSpan(0.0F, 0.0F), j, i, 33);
        return ((Spannable) (obj));
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        return viewmodel != null && (viewmodel instanceof SellingUtilityViewModel);
    }

    public void bind(ViewModel viewmodel)
    {
label0:
        {
            super.bind(viewmodel);
            if (viewmodel instanceof SellingUtilityViewModel)
            {
                viewmodel = (SellingUtilityViewModel)viewmodel;
                if (!((SellingUtilityViewModel) (viewmodel)).isUnSoldFailure)
                {
                    break label0;
                }
                oopsUnSoldText.setVisibility(0);
                noOfUnSoldItems.setVisibility(8);
                notYetRelistedText.setVisibility(8);
                allRelisted.setVisibility(8);
            }
            return;
        }
        oopsUnSoldText.setVisibility(8);
        noOfUnSoldItems.setVisibility(0);
        noOfUnSoldItems.setText(String.valueOf(((SellingUtilityViewModel) (viewmodel)).noOfUnSoldItems));
        if (((SellingUtilityViewModel) (viewmodel)).notRelisted > 0)
        {
            notYetRelistedText.setVisibility(0);
            allRelisted.setVisibility(8);
            notYetRelistedText.setText(getRelistedText(((SellingUtilityViewModel) (viewmodel)).notRelisted), android.widget.TextView.BufferType.SPANNABLE);
            return;
        } else
        {
            notYetRelistedText.setVisibility(8);
            allRelisted.setVisibility(0);
            return;
        }
    }
}
