// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.AmazonImageView;
import com.amazon.mShop.control.VariationsSelectionAdapter;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.item.Variations;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Dimension;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            VariationsController, ItemViewUtils

public class VariationFilters extends LinearLayout
{
    private class OptionsAdapter extends BaseAdapter
        implements android.widget.AdapterView.OnItemClickListener
    {

        private final List mAvailabilities;
        private final Context mContext;
        private final Dimension mDimension;
        private final List mValues;
        final VariationFilters this$0;

        private void setPriceAndAvailableMessage(int i, View view)
        {
            Resources resources;
            Object obj;
            resources = view.getResources();
            obj = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_price);
            view = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_availability);
            if (((Boolean)mAvailabilities.get(i)).booleanValue())
            {
                String s = mVariationsController.getPrice(mCurrentDimension, i);
                if (!Util.isEmpty(s))
                {
                    ((TextView) (obj)).setText(s);
                    ((TextView) (obj)).setVisibility(0);
                } else
                {
                    ((TextView) (obj)).setVisibility(8);
                }
                obj = mVariationsController.getAvailabeMessage(mCurrentDimension, i);
                if (!Util.isEmpty(((String) (obj))))
                {
                    view.setText(((CharSequence) (obj)));
                    view.setTextColor(resources.getColor(com.amazon.mShop.android.lib.R.color.subtitle_text_color));
                    view.setVisibility(0);
                    return;
                } else
                {
                    view.setVisibility(8);
                    return;
                }
            }
            if (mVariations.getDimensions().length != 2) goto _L2; else goto _L1
_L1:
            i = 0;
            if (mCurrentDimension == 0)
            {
                i = 1;
            }
            String s1 = mVariations.getDimensionLabels()[i];
            int j = ((Integer)mCurrentSelections.get(i)).intValue();
            if (j >= 0)
            {
                String s2 = (String)mVariations.getDimensions()[i].getValues().get(j);
                view.setText(resources.getString(com.amazon.mShop.android.lib.R.string.variations_not_available_in_dimen_x_selection_y, new Object[] {
                    s1, s2
                }));
            }
_L4:
            view.setTextColor(resources.getColor(com.amazon.mShop.android.lib.R.color.gray_text));
            view.setVisibility(0);
            ((TextView) (obj)).setVisibility(8);
            return;
_L2:
            if (mVariations.getDimensions().length > 2)
            {
                view.setText(resources.getString(com.amazon.mShop.android.lib.R.string.variations_not_available_with_selected_options));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public boolean areAllItemsEnabled()
        {
            return true;
        }

        public int getCount()
        {
            return mValues.size();
        }

        public Object getItem(int i)
        {
            return mValues.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(com.amazon.mShop.android.lib.R.layout.variation_item, null);
            }
            view = (AmazonImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.item_row_image);
            if (mDimension.getSwatchUrls() != null && !mDimension.getSwatchUrls().isEmpty())
            {
                view.fetchImage((String)mDimension.getSwatchUrls().get(i), getContext().getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.variation_item_image_dimension));
            } else
            {
                view.setVisibility(8);
            }
            view = (String)mValues.get(i);
            ((TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.item_title)).setText(view);
            view = (ImageView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.item_checkmark);
            if (mCurrentSelections != null && ((Integer)mCurrentSelections.get(mCurrentDimension)).intValue() == i)
            {
                view.setVisibility(0);
            } else
            {
                view.setVisibility(4);
            }
            setPriceAndAvailableMessage(i, viewgroup);
            return viewgroup;
        }

        public int getViewTypeCount()
        {
            return 1;
        }

        public boolean hasStableIds()
        {
            return false;
        }

        public boolean isEmpty()
        {
            return false;
        }

        public boolean isEnabled(int i)
        {
            return true;
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            selectOption(mCurrentDimension, i);
            if (isAllSelected())
            {
                adapterview = mVariationsController.getSelectedChild(mCurrentSelections);
                view = mSelectionAdapter.getSelectedVariationChild();
                loadSelectedChild();
                if (adapterview != view)
                {
                    notifySelectionComplete();
                }
            } else
            {
                mSelectionAdapter.clearSelectedChild();
                updateUnselectedLabel();
                updatePriceRow();
                notifySelectionIncomplete();
            }
            if (mDialog != null)
            {
                mDialog.dismiss();
                mDialog = null;
            }
        }

        public OptionsAdapter(Context context, List list)
        {
            this$0 = VariationFilters.this;
            super();
            mContext = context;
            mDimension = mVariations.getDimensions()[mCurrentDimension];
            mValues = mDimension.getValues();
            mAvailabilities = list;
        }
    }

    public static interface VariationFiltersSubscriber
    {

        public abstract void onSelectionComplete();

        public abstract void onSelectionIncomplete();
    }


    private AmazonActivity mActivity;
    private int mCurrentDimension;
    private List mCurrentSelections;
    private AmazonAlertDialog mDialog;
    private boolean mFetched;
    private Button mFilterButtons[];
    private OptionsAdapter mOptionsAdapter;
    private LinearLayout mPriceRow;
    private VariationsSelectionAdapter mSelectionAdapter;
    private VariationFiltersSubscriber mSubscriber;
    private Variations mVariations;
    private VariationsController mVariationsController;
    private android.view.View.OnClickListener onDimensionButtonClicked;

    public VariationFilters(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFetched = false;
        onDimensionButtonClicked = new android.view.View.OnClickListener() {

            final VariationFilters this$0;

            public void onClick(View view)
            {
                showDimensionList((Integer)view.getTag());
            }

            
            {
                this$0 = VariationFilters.this;
                super();
            }
        };
        mActivity = (AmazonActivity)context;
    }

    private boolean isAllSelected()
    {
        if (mCurrentSelections == null)
        {
            return false;
        }
        for (int i = 0; i < mCurrentSelections.size(); i++)
        {
            if (((Integer)mCurrentSelections.get(i)).intValue() == -1)
            {
                return false;
            }
        }

        return true;
    }

    private void loadSelectedChild()
    {
        com.amazon.mShop.control.item.Variations.Child child = mVariationsController.getSelectedChild(mCurrentSelections);
        mSelectionAdapter.setSelectedVariationChild(child);
    }

    private void notifySelectionComplete()
    {
        if (mSubscriber != null)
        {
            mSubscriber.onSelectionComplete();
        }
    }

    private void notifySelectionIncomplete()
    {
        if (mSubscriber != null)
        {
            mSubscriber.onSelectionIncomplete();
        }
    }

    private void selectOption(int i, int j)
    {
        Dimension dimension;
        if (i < mVariations.getDimensions().length)
        {
            if (j < (dimension = mVariations.getDimensions()[i]).getValues().size())
            {
                SpannableString spannablestring = new SpannableString((new StringBuilder()).append(dimension.getDisplayLabel()).append(": ").append((String)dimension.getValues().get(j)).toString());
                spannablestring.setSpan(new StyleSpan(1), 0, dimension.getDisplayLabel().length(), 0);
                mFilterButtons[i].setTypeface(Typeface.DEFAULT);
                mFilterButtons[i].setText(spannablestring);
                mCurrentSelections = mVariationsController.selectAndUpdate(i, j);
                return;
            }
        }
    }

    private void setFetched(boolean flag)
    {
        mFetched = flag;
    }

    private void updateUnselectedLabel()
    {
        for (int i = 0; i < mCurrentSelections.size(); i++)
        {
            if (((Integer)mCurrentSelections.get(i)).intValue() == -1)
            {
                mFilterButtons[i].setTypeface(Typeface.DEFAULT_BOLD);
                String s = (new StringBuilder()).append(mVariations.getDimensions()[i].getDisplayLabel()).append(": ").append(getResources().getString(com.amazon.mShop.android.lib.R.string.please_select)).toString();
                mFilterButtons[i].setText(s);
            }
        }

    }

    public int getDimensionCount()
    {
        if (mVariations != null)
        {
            return mVariations.getDimensions().length;
        } else
        {
            return 0;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mVariationsController != null)
        {
            mVariationsController.cancelFetchInfos();
        }
        if (mDialog != null)
        {
            mDialog.dismiss();
        }
    }

    public void setSubscriber(VariationFiltersSubscriber variationfilterssubscriber)
    {
        mSubscriber = variationfilterssubscriber;
    }

    public void showDimensionList(Integer integer)
    {
        mCurrentDimension = integer.intValue();
        integer = mVariationsController.checkAvailabilitiesForDimension(mCurrentDimension);
        mOptionsAdapter = new OptionsAdapter(getContext(), integer);
        mDialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).create();
        AmazonAlertDialog.customizeAlertDialog(mActivity, mDialog, mVariations.getDimensions()[mCurrentDimension].getDisplayLabel(), mOptionsAdapter, mOptionsAdapter, ((Integer)mCurrentSelections.get(mCurrentDimension)).intValue());
        mDialog.show();
    }

    public void updatePriceRow()
    {
label0:
        {
            if (mSelectionAdapter instanceof ProductController)
            {
                if (mPriceRow == null)
                {
                    mPriceRow = (LinearLayout)((ViewStub)findViewById(com.amazon.mShop.android.lib.R.id.product_price_row_stub)).inflate();
                }
                if (!isAllSelected())
                {
                    break label0;
                }
                ItemViewUtils.updateActualPriceRow((ProductController)mSelectionAdapter, mPriceRow);
            }
            return;
        }
        mPriceRow.setVisibility(8);
    }






/*
    static AmazonAlertDialog access$1102(VariationFilters variationfilters, AmazonAlertDialog amazonalertdialog)
    {
        variationfilters.mDialog = amazonalertdialog;
        return amazonalertdialog;
    }

*/








}
