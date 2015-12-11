// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            RetailSearchResultView, MultiStoreModel, MultiStoreOfferView

public class MultiStoreView extends LinearLayout
    implements RetailSearchResultView
{

    private Context context;

    public MultiStoreView(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    private void buildSeeMoreButton(final List additionalViews, final MultiStoreModel model)
    {
        if (Utils.isEmpty(additionalViews))
        {
            return;
        } else
        {
            View view = View.inflate(context, com.amazon.retailsearch.R.layout.rs_multi_store_see_more, null);
            view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, (int)context.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_multi_store_item_height)));
            UIUtils.setBackground(view, context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_bottom));
            addView(view);
            final TextView text = (TextView)view.findViewById(com.amazon.retailsearch.R.id.rs_multi_store_see_more_text);
            final ImageView indicator = (ImageView)view.findViewById(com.amazon.retailsearch.R.id.rs_multi_store_indicator);
            updateSeeMoreButtonState(text, indicator, model.getProductViewModel().isMultiStoreExpanded());
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final MultiStoreView this$0;
                final List val$additionalViews;
                final ImageView val$indicator;
                final MultiStoreModel val$model;
                final TextView val$text;

                public void onClick(View view1)
                {
                    boolean flag = false;
                    for (view1 = additionalViews.iterator(); view1.hasNext();)
                    {
                        View view2 = (View)view1.next();
                        if (view2.getVisibility() == 8)
                        {
                            view2.setVisibility(0);
                            flag = true;
                        } else
                        {
                            view2.setVisibility(8);
                            flag = false;
                        }
                    }

                    updateSeeMoreButtonState(text, indicator, flag);
                    model.getProductViewModel().setMultiStoreExpanded(flag);
                }

            
            {
                this$0 = MultiStoreView.this;
                additionalViews = list;
                text = textview;
                indicator = imageview;
                model = multistoremodel;
                super();
            }
            });
            return;
        }
    }

    private void updateSeeMoreButtonState(TextView textview, ImageView imageview, boolean flag)
    {
        if (flag)
        {
            textview.setText(context.getText(com.amazon.retailsearch.R.string.rs_see_less_offers));
            imageview.setImageDrawable(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_up_arrow));
            return;
        } else
        {
            textview.setText(context.getText(com.amazon.retailsearch.R.string.rs_see_more_offers));
            imageview.setImageDrawable(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_down_arrow));
            return;
        }
    }

    public void buildView(MultiStoreModel multistoremodel, ResultLayoutType resultlayouttype)
    {
        if (multistoremodel == null)
        {
            setVisibility(8);
            return;
        }
        removeAllViews();
        int i = 0;
        ArrayList arraylist = new ArrayList();
        Iterator iterator;
        boolean flag;
        if (multistoremodel.getOfferList().size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iterator = multistoremodel.getOfferList().iterator();
        do
        {
            if (iterator.hasNext())
            {
                EditionsPriceInfo editionspriceinfo = (EditionsPriceInfo)iterator.next();
                if (editionspriceinfo != null)
                {
                    MultiStoreOfferView multistoreofferview = (MultiStoreOfferView)View.inflate(context, com.amazon.retailsearch.R.layout.rs_multi_store_item, null);
                    MultiStoreOfferModel.OfferPosition offerposition;
                    int j;
                    if (getChildCount() == 0)
                    {
                        offerposition = MultiStoreOfferModel.OfferPosition.TOP;
                    } else
                    if (getChildCount() == multistoremodel.getOfferList().size() - 1 && multistoremodel.getOfferList().size() <= multistoremodel.getNumVisibleOffers())
                    {
                        offerposition = MultiStoreOfferModel.OfferPosition.BOTTOM;
                    } else
                    {
                        offerposition = MultiStoreOfferModel.OfferPosition.MIDDLE;
                    }
                    multistoreofferview.buildView((new MultiStoreOfferModel.Builder()).setListener(multistoremodel.getListener()).setShowBorder(flag).setOfferPosition(offerposition).build(multistoremodel.getStoreManager(), getResources(), multistoremodel.getResourceProvider(), editionspriceinfo, multistoremodel.getProductViewModel(), multistoremodel.getProductView(), multistoremodel.getOfferList().size()), resultlayouttype);
                    addView(multistoreofferview);
                    multistoremodel.getGestureListener().addTapTarget(multistoreofferview);
                    j = i + 1;
                    i = j;
                    if (j > multistoremodel.getNumVisibleOffers())
                    {
                        if (!multistoremodel.getProductViewModel().isMultiStoreExpanded())
                        {
                            multistoreofferview.setVisibility(8);
                        }
                        arraylist.add(multistoreofferview);
                        i = j;
                    }
                }
            } else
            {
                buildSeeMoreButton(arraylist, multistoremodel);
                setVisibility(0);
                return;
            }
        } while (true);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((MultiStoreModel)obj, resultlayouttype);
    }

}
