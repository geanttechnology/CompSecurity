// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.cart.CartStateListener;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            InlineActionsButtonModel, InlineActionsButtonType, AddToCartState, InlineActionsButtonStyle, 
//            InlineActionsListener, QuantitySwitcherDialog

public class InlineActionsButton extends LinearLayout
    implements CartStateListener, RetailSearchResultView
{
    private class AddToCartClickListener
        implements android.view.View.OnClickListener
    {

        private final String asin;
        private final AddToCartState cartState;
        private final ContentSwitcherModel contentSwitcherModel;
        private final String merchantId;
        private final String offerId;
        private final ProductView productView;
        private final String qid;
        private final String sr;
        final InlineActionsButton this$0;

        public void onClick(View view)
        {
            cartState.setState(2);
            userInteractionListener.addToCart(asin, offerId, merchantId, qid, sr, 1, new com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback() {

                final AddToCartClickListener this$1;

                public void error()
                {
                    cartState.reset();
                }

                public void error(int i, String s, int j)
                {
                    cartState.update(i, s, j);
                }

                public void success()
                {
                    cartState.reset(1);
                }

                public void success(int i, String s, int j)
                {
                    cartState.update(i, s, j);
                }

            
            {
                this$1 = AddToCartClickListener.this;
                super();
            }
            });
            if (productView != null)
            {
                if (model.getOffer() == null)
                {
                    productView.switchViewTypes(contentSwitcherModel);
                } else
                {
                    productView.switchViewTypes(model.getOffer(), contentSwitcherModel);
                }
                productView.scrollIntoView();
            }
        }


        public AddToCartClickListener(AddToCartState addtocartstate, String s, String s1, String s2, String s3, String s4, 
                ContentSwitcherModel contentswitchermodel, ProductView productview)
        {
            this$0 = InlineActionsButton.this;
            super();
            cartState = addtocartstate;
            asin = s;
            offerId = s1;
            merchantId = s2;
            qid = s3;
            sr = s4;
            contentSwitcherModel = contentswitchermodel;
            productView = productview;
        }
    }

    private class QuantitySwitcherClickListener
        implements android.view.View.OnClickListener
    {

        private final AddToCartState cartState;
        private final String offerId;
        private final String qid;
        private final String sr;
        final InlineActionsButton this$0;

        public void onClick(View view)
        {
            (new QuantitySwitcherDialog(view.getContext(), cartState, offerId, qid, sr)).show();
        }

        public QuantitySwitcherClickListener(AddToCartState addtocartstate, String s, String s1, String s2)
        {
            this$0 = InlineActionsButton.this;
            super();
            cartState = addtocartstate;
            offerId = s;
            qid = s1;
            sr = s2;
        }
    }

    private class ViewOptionsClickListener
        implements android.view.View.OnClickListener
    {

        private final String asin;
        private final String detailPageUrl;
        private final String group;
        final InlineActionsButton this$0;

        public void onClick(View view)
        {
            view = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(asin, detailPageUrl, group);
            userInteractionListener.resultItemSelected(view, DetailPageType.VIEW_OPTIONS);
        }

        public ViewOptionsClickListener(String s, String s1, String s2)
        {
            this$0 = InlineActionsButton.this;
            super();
            asin = s;
            detailPageUrl = s1;
            group = s2;
        }
    }


    private Button actionButton;
    private AddToCartState cartState;
    private InlineActionsButtonModel model;
    private ResultLayoutType resultLayoutType;
    private ProgressBar spinner;
    private InlineActionsButtonStyle style;
    private TextView successMessage;
    UserInteractionListener userInteractionListener;

    public InlineActionsButton(Context context)
    {
        super(context);
        init();
    }

    public InlineActionsButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public InlineActionsButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private InlineActionsButtonType getButtonType()
    {
        if (model.isViewOptionsEnabled())
        {
            if (cartState == null || !model.hasMultipleOffers() && model.isTwisted())
            {
                return InlineActionsButtonType.VIEW_OPTIONS;
            }
        } else
        if (cartState == null)
        {
            return null;
        }
        if (cartState.getState() == 1 && model.isQuantitySwitcherEnabled())
        {
            return InlineActionsButtonType.QUANTITY_SWITCHER;
        } else
        {
            return InlineActionsButtonType.ADD_TO_CART;
        }
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        setOrientation(0);
    }

    private void renderButton()
    {
        InlineActionsButtonType inlineactionsbuttontype = getButtonType();
        if (inlineactionsbuttontype == null)
        {
            setVisibility(8);
            return;
        }
        actionButton.setBackgroundResource(style.getBackgroundResource(getContext(), inlineactionsbuttontype, resultLayoutType));
        if (inlineactionsbuttontype != InlineActionsButtonType.QUANTITY_SWITCHER)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[];

                static 
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType = new int[InlineActionsButtonType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[InlineActionsButtonType.ADD_TO_CART.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[InlineActionsButtonType.VIEW_OPTIONS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[InlineActionsButtonType.QUANTITY_SWITCHER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            String s;
            if (model.useLongText())
            {
                s = style.getText(getContext(), inlineactionsbuttontype, resultLayoutType);
            } else
            {
                s = style.getShortText(getContext(), inlineactionsbuttontype, resultLayoutType);
            }
            actionButton.setText(s);
            actionButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else
        {
            actionButton.setText(Integer.toString(cartState.getQuantity()));
            actionButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.amazon.retailsearch.R.drawable.quantity_switcher_arrows, 0);
        }
        _cls1..SwitchMap.com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonType[inlineactionsbuttontype.ordinal()];
        JVM INSTR tableswitch 1 3: default 128
    //                   1 199
    //                   2 270
    //                   3 309;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_309;
_L5:
        setVisibility(0);
        if (inlineactionsbuttontype == InlineActionsButtonType.VIEW_OPTIONS)
        {
            setStateVisibility(0);
            return;
        } else
        {
            setStateVisibility(cartState.getState());
            return;
        }
_L2:
        actionButton.setOnClickListener(new AddToCartClickListener(cartState, model.getAsin(), model.getOfferId(), model.getMerchantId(), model.getQid(), model.getSr(), model.getContentSwitcherModel(), model.getProductView()));
          goto _L5
_L3:
        actionButton.setOnClickListener(new ViewOptionsClickListener(model.getAsin(), model.getDetailPageUrl(), model.getGroup()));
          goto _L5
        actionButton.setOnClickListener(new QuantitySwitcherClickListener(cartState, model.getOfferId(), model.getQid(), model.getSr()));
          goto _L5
    }

    private void setStateVisibility(int i)
    {
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
            UIUtils.setVisibility(actionButton, 8);
            UIUtils.setVisibility(spinner, 0);
            UIUtils.setVisibility(successMessage, 8);
            return;

        case 1: // '\001'
            UIUtils.setVisibility(actionButton, 0);
            UIUtils.setVisibility(spinner, 8);
            UIUtils.setVisibility(successMessage, 0);
            return;

        case 0: // '\0'
            UIUtils.setVisibility(actionButton, 0);
            UIUtils.setVisibility(spinner, 8);
            UIUtils.setVisibility(successMessage, 8);
            return;
        }
    }

    public void buildView(InlineActionsButtonModel inlineactionsbuttonmodel, ResultLayoutType resultlayouttype)
    {
        if (cartState != null)
        {
            cartState.removeListener(this);
        }
        if (inlineactionsbuttonmodel == null || actionButton == null || spinner == null)
        {
            setVisibility(8);
            return;
        }
        model = inlineactionsbuttonmodel;
        resultLayoutType = resultlayouttype;
        style = inlineactionsbuttonmodel.getStyle();
        cartState = inlineactionsbuttonmodel.getCartState();
        if (cartState != null)
        {
            cartState.addListener(this);
        }
        renderButton();
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((InlineActionsButtonModel)obj, resultlayouttype);
    }

    public void onFinishInflate()
    {
        actionButton = (Button)findViewById(com.amazon.retailsearch.R.id.rs_inline_actions_button);
        successMessage = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_inline_success);
        spinner = (ProgressBar)findViewById(com.amazon.retailsearch.R.id.rs_inline_progress_spinner);
    }

    public void onQuantityUpdated(int i)
    {
    }

    public void onStateChange(int i)
    {
        if (cartState != null)
        {
            if (cartState.getState() != 2)
            {
                renderButton();
            } else
            {
                setStateVisibility(cartState.getState());
            }
            if (cartState.getState() == 1 && i == 2 && model.getInlineActionsListener() != null)
            {
                model.getInlineActionsListener().onAddToCartSuccess();
                return;
            }
        }
    }

}
