// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.ui.customviews.ColorSelectionView;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.ui.customviews.PMButton;
import java.util.ArrayList;
import java.util.List;

public class ListingEditorViewHolder
{

    public LabelledEditText availabilityEditText;
    public LinearLayout availabilitySectionLayout;
    public LabelledEditText brandEditText;
    public LabelledEditText categoryEditText;
    public LabelledEditText colorDummyEditText;
    public ColorSelectionView colorsContainer;
    public PMButton deleteButton;
    public LinearLayout deleteButtonSectionLayout;
    public EditText descriptionEditText;
    public TextView earningsTextView;
    public List imageList;
    public LabelledEditText listingPriceEditText;
    public LabelledEditText nwtEditText;
    public LabelledEditText originalPriceEditText;
    public LinearLayout picturesSelectorLayout;
    public LabelledEditText sizeEditText;
    public EditText titleEditText;

    public ListingEditorViewHolder()
    {
        imageList = new ArrayList();
    }
}
