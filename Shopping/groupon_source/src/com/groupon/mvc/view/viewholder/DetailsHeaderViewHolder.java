// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.callbacks.OnDealImageEventListener;
import com.groupon.mvc.model.DetailsHeader;
import com.groupon.view.DealDetailsTemporaryImage;
import com.groupon.view.DealImageView;
import com.groupon.view.PaymentMethodsView;
import com.squareup.picasso.Callback;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class DetailsHeaderViewHolder extends RecyclerItemViewHolder
{

    private static final float VALUE_CONTAINER_WIDTH_SIZE_PERCENTAGE_LARGE = 0.7F;
    private static final float VALUE_CONTAINER_WIDTH_SIZE_PERCENTAGE_MEDIUM = 0.5F;
    private static final float VALUE_CONTAINER_WIDTH_SIZE_PERCENTAGE_SMALL = 0.25F;
    private View boughtContainer;
    private TextView boughtCountView;
    private TextView boughtLabelView;
    public View dealImageContainer;
    DealImageView dealImageView;
    TextView dealLocationView;
    TextView dealTitleView;
    private View discountBoughtContainer;
    ViewGroup discountBoughtHorizontalContainer;
    ViewGroup discountBoughtInlineContainer;
    RelativeLayout discountBoughtPriceContainer;
    private View discountContainer;
    private TextView discountView;
    public View imageGradientOverlay;
    private TextView limitedAvailabilityView;
    View loadingView;
    private View mobileOnly;
    private ViewStub mobileOnlyStub;
    PaymentMethodsView paymentMethodsView;
    TextView priceView;
    TextView reservationMessage;
    private TextView saleNowPriceView;
    private LinearLayout salePriceContainer;
    private TextView saleValueView;
    private TextView saleWasPriceLabelView;
    private TextView saleWasPriceView;
    public DealDetailsTemporaryImage temporaryDealImageView;
    public View titleValuePriceSection;
    LinearLayout valueContainer;
    TextView valueView;

    public DetailsHeaderViewHolder(View view)
    {
        super(view);
    }

    private int generateDiscountBoughtLimitedAvailabilityWidgetsCount()
    {
        int j = 0;
        if (((DetailsHeader)model).displayDiscount)
        {
            j = 0 + 1;
        }
        int i = j;
        if (((DetailsHeader)model).displayBought)
        {
            i = j + 1;
        }
        j = i;
        if (((DetailsHeader)model).displayLimitedAvailability)
        {
            j = i + 1;
        }
        i = j;
        if (((DetailsHeader)model).displayMobileOnly)
        {
            i = j + 1;
        }
        return i;
    }

    private void initUrgencyPricingViews()
    {
        valueContainer.removeAllViews();
        salePriceContainer = (LinearLayout)View.inflate(itemView.getContext(), 0x7f0300c5, valueContainer);
        saleValueView = (TextView)salePriceContainer.findViewById(0x7f10025b);
        saleWasPriceLabelView = (TextView)salePriceContainer.findViewById(0x7f100259);
        saleWasPriceView = (TextView)salePriceContainer.findViewById(0x7f10025c);
        saleNowPriceView = (TextView)salePriceContainer.findViewById(0x7f10025d);
    }

    private void initViewsAfterMeasure()
    {
        byte byte0 = 8;
        int k = valueContainer.getMeasuredWidth();
        int l = itemView.getMeasuredWidth();
        int i1 = generateDiscountBoughtLimitedAvailabilityWidgetsCount();
        if ((float)k > (float)l * 0.25F);
        int j = 1;
        int i = j;
        Object obj;
        if ((float)k > (float)l * 0.25F)
        {
            i = j;
            String s;
            View view;
            if ((float)k <= (float)l * 0.5F)
            {
                if (i1 <= 2)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            }
        }
        j = i;
        if ((float)k > (float)l * 0.5F)
        {
            j = i;
            if ((float)k < (float)l * 0.7F)
            {
                if (i1 <= 1)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            }
        }
        if ((float)k > (float)l * 0.7F)
        {
            j = 0;
        }
        i = j;
        if (((DetailsHeader)model).urgencyPricingAvailable)
        {
            i = j;
            if (((DetailsHeader)model).displayMobileOnly)
            {
                i = 0;
            }
        }
        if (i != 0)
        {
            j = 0x7f0300d1;
            obj = discountBoughtInlineContainer;
        } else
        {
            j = 0x7f0300d0;
            obj = discountBoughtHorizontalContainer;
        }
        discountBoughtHorizontalContainer.removeAllViews();
        discountBoughtInlineContainer.removeAllViews();
        discountBoughtContainer = View.inflate(itemView.getContext(), j, ((ViewGroup) (obj)));
        discountContainer = discountBoughtContainer.findViewById(0x7f100270);
        discountView = (TextView)discountBoughtContainer.findViewById(0x7f100272);
        boughtContainer = discountBoughtContainer.findViewById(0x7f100273);
        boughtLabelView = (TextView)discountBoughtContainer.findViewById(0x7f100274);
        boughtCountView = (TextView)discountBoughtContainer.findViewById(0x7f100275);
        limitedAvailabilityView = (TextView)discountBoughtContainer.findViewById(0x7f100276);
        mobileOnlyStub = (ViewStub)discountBoughtContainer.findViewById(0x7f10026f);
        obj = discountBoughtPriceContainer;
        if (i != 0)
        {
            i = 5;
        } else
        {
            i = 3;
        }
        ((RelativeLayout) (obj)).setGravity(i);
        obj = discountContainer;
        if (((DetailsHeader)model).displayDiscount && Strings.notEmpty(((DetailsHeader)model).discount))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        discountView.setText(((DetailsHeader)model).discount);
        obj = ((DetailsHeader)model).boughtLabel;
        s = ((DetailsHeader)model).boughtCountMessage;
        view = boughtContainer;
        if (((DetailsHeader)model).displayBought && Strings.notEmpty(obj) && Strings.notEmpty(s))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        boughtLabelView.setText(((CharSequence) (obj)));
        boughtCountView.setText(s);
        obj = limitedAvailabilityView;
        i = byte0;
        if (((DetailsHeader)model).displayLimitedAvailability)
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        if (((DetailsHeader)model).displayMobileOnly && mobileOnly == null)
        {
            mobileOnly = mobileOnlyStub.inflate();
            mobileOnlyStub = null;
        }
        if (((DetailsHeader)model).acceptedPaymentMethods != null)
        {
            paymentMethodsView.setVisibility(0);
            paymentMethodsView.setIconsForAvailablePaymentMethods(((DetailsHeader)model).acceptedPaymentMethods);
        }
    }

    public void populateViews()
    {
        boolean flag = false;
        boolean flag1 = ((DetailsHeader)model).hideDiscountValueContainer;
        float f = ((DetailsHeader)model).dealImageHeight;
        Object obj3 = ((DetailsHeader)model).dealTitle;
        Object obj2 = ((DetailsHeader)model).dealLocation;
        Object obj = ((DetailsHeader)model).value;
        Object obj1 = ((DetailsHeader)model).price;
        List list;
        int i;
        boolean flag2;
        if (((DetailsHeader)model).largeImageUrl != null)
        {
            temporaryDealImageView.setImageHeight(f);
            temporaryDealImageView.loadImageFromUrl(((DetailsHeader)model).largeImageUrl, null);
        } else
        {
            temporaryDealImageView.setVisibility(8);
        }
        flag2 = ((DetailsHeader)model).imageRotationState;
        list = ((DetailsHeader)model).dealImageList;
        if (list != null && list.size() > 0)
        {
            dealImageView.setOnDealImageEventListener((OnDealImageEventListener)callback);
            dealImageView.setDealImageHeight(f);
            dealImageView.setCurrentItem(((DetailsHeader)model).imageCarouselPosition);
            dealImageView.setImageUrls(list).setDealId(((DetailsHeader)model).dealId).setChannel(((DetailsHeader)model).channel).setDealTitle(((String) (obj3))).setupImagePager(new Callback() {

                final DetailsHeaderViewHolder this$0;

                public void onError(ImageView imageview)
                {
                }

                public void onSuccess(ImageView imageview)
                {
                    temporaryDealImageView.animate().alpha(0.0F).setDuration(200L).setStartDelay(400L);
                }

            
            {
                this$0 = DetailsHeaderViewHolder.this;
                super();
            }
            });
            if (flag2)
            {
                dealImageView.doStartImageRotation();
            } else
            {
                dealImageView.doStopImageRotation();
            }
        }
        dealTitleView.setText(((CharSequence) (obj3)));
        flag2 = Strings.notEmpty(obj2);
        obj3 = dealLocationView;
        if (flag2)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj3)).setVisibility(i);
        if (flag2)
        {
            dealLocationView.setText(((CharSequence) (obj2)));
        }
        obj2 = reservationMessage;
        if (((DetailsHeader)model).displayReservationMessage)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj2)).setVisibility(i);
        if (!flag1)
        {
            discountBoughtPriceContainer.setVisibility(0);
            if (((DetailsHeader)model).urgencyPricingAvailable)
            {
                initUrgencyPricingViews();
                saleValueView.setText(((CharSequence) (obj)));
                saleWasPriceLabelView.setText(((DetailsHeader)model).wasPriceLabel);
                saleWasPriceView.setText(((DetailsHeader)model).regularPrice);
                saleNowPriceView.setText(Html.fromHtml(((DetailsHeader)model).nowPriceHtml));
            }
            priceView.setText(((CharSequence) (obj1)));
            obj1 = priceView;
            obj2 = itemView.getResources();
            if (((DetailsHeader)model).displayConnectedMarketplace)
            {
                i = 0x7f0e00ee;
            } else
            {
                i = 0x7f0e0004;
            }
            ((TextView) (obj1)).setTextColor(((Resources) (obj2)).getColor(i));
            if (((DetailsHeader)model).displayDiscount && Strings.notEmpty(((DetailsHeader)model).value))
            {
                valueView.setText(((CharSequence) (obj)));
                valueView.setPaintFlags(valueView.getPaintFlags() | 0x10);
            } else
            {
                valueView.setVisibility(8);
            }
            itemView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final DetailsHeaderViewHolder this$0;

                public void onGlobalLayout()
                {
                    initViewsAfterMeasure();
                    ViewTreeObserver viewtreeobserver = itemView.getViewTreeObserver();
                    if (viewtreeobserver.isAlive())
                    {
                        viewtreeobserver.removeOnGlobalLayoutListener(this);
                    }
                }

            
            {
                this$0 = DetailsHeaderViewHolder.this;
                super();
            }
            });
        } else
        {
            discountBoughtPriceContainer.setVisibility(8);
            mobileOnlyStub = (ViewStub)titleValuePriceSection.findViewById(0x7f100266);
            if (((DetailsHeader)model).displayMobileOnly && mobileOnly == null)
            {
                mobileOnly = mobileOnlyStub.inflate();
                mobileOnlyStub = null;
            }
        }
        obj = loadingView;
        if (((DetailsHeader)model).displayLoadingView)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

}
