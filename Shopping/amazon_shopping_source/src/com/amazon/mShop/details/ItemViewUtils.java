// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.BitmapFetcher;
import com.amazon.mShop.util.BadgeUtils;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.MShopUiOOMHandler;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.ExtraOfferListing;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.OffersSummary;
import com.amazon.rio.j2me.client.services.mShop.PricePerUnit;
import com.amazon.rio.j2me.client.services.mShop.RichMessage;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            PriceBlock

public class ItemViewUtils
{

    public ItemViewUtils()
    {
    }

    private static void getBadgeFromBackground(BasicOfferListing basicofferlisting, TextView textview, SpannableStringBuilder spannablestringbuilder, String s, int i, int j)
    {
        basicofferlisting = ((HyperText)basicofferlisting.getBadgeInfo().getBadge().getMeta().getMessages().get(0)).getText();
        if (textview.getTag() == null)
        {
            basicofferlisting = new com.amazon.mShop.net.HttpFetcher.Subscriber(spannablestringbuilder, basicofferlisting, j, textview, i) {

                final int val$badgeDefaultHyperTextStart;
                final String val$fallbackText;
                final int val$imageSpanVerticalAlignment;
                final TextView val$price;
                final SpannableStringBuilder val$spanned;

                public void onHttpRequestFailed(com.amazon.mShop.net.HttpFetcher.Params params)
                {
                    price.setTag(null);
                }

                public void onHttpResponseReceived(Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
                {
                    if (bitmap != null)
                    {
                        BadgeUtils.addBadgeBitampToCache(((com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams)params).getBaseUrl(), bitmap);
                        int k = spanned.length();
                        int l;
                        if (!Util.isEmpty(fallbackText))
                        {
                            k = badgeDefaultHyperTextStart + 1;
                        } else
                        {
                            spanned.append(" ");
                        }
                        l = spanned.length();
                        bitmap = new ImageSpan(price.getContext(), bitmap, imageSpanVerticalAlignment);
                        spanned.setSpan(bitmap, k, l, 33);
                        price.setText(spanned);
                        price.setTag(null);
                    }
                }

                public volatile void onHttpResponseReceived(Object obj, com.amazon.mShop.net.HttpFetcher.Params params)
                {
                    onHttpResponseReceived((Bitmap)obj, params);
                }

            
            {
                spanned = spannablestringbuilder;
                fallbackText = s;
                badgeDefaultHyperTextStart = i;
                price = textview;
                imageSpanVerticalAlignment = j;
                super();
            }
            };
            i = UIUtils.convertDipToPixel(2);
            basicofferlisting = new BitmapFetcher(ImageUtil.getImageUrlWithMaxHeight(s, (int)textview.getTextSize() + i), s, basicofferlisting);
            textview.setTag(basicofferlisting);
            basicofferlisting.fetch();
        }
    }

    public static String getDisplayByLineAndBinding(BasicProductInfo basicproductinfo, Context context)
    {
        if (basicproductinfo == null)
        {
            basicproductinfo = null;
        } else
        {
            String s1 = basicproductinfo.getByLine();
            String s = basicproductinfo.getShortDescription();
            basicproductinfo = s;
            if (!Util.isEmpty(s1))
            {
                basicproductinfo = context.getResources();
                if (Util.isEmpty(s))
                {
                    return basicproductinfo.getString(com.amazon.mShop.android.lib.R.string.item_row_byline_format, new Object[] {
                        s1
                    });
                } else
                {
                    return basicproductinfo.getString(com.amazon.mShop.android.lib.R.string.item_row_byline_and_binding_format, new Object[] {
                        s1, s
                    });
                }
            }
        }
        return basicproductinfo;
    }

    public static String getNewAndUsed(BasicProductInfo basicproductinfo, BasicOfferListing basicofferlisting, Context context)
    {
        if (ProductController.hasMarketPlaceOffers(basicproductinfo, basicofferlisting))
        {
            basicproductinfo = basicproductinfo.getUsedAndNewSummary();
            if (basicproductinfo != null)
            {
                basicofferlisting = context.getResources();
                int i = basicproductinfo.getCount();
                if (i > 0)
                {
                    return basicofferlisting.getString(com.amazon.mShop.android.lib.R.string.item_row_x_new_and_used_from_y_format, new Object[] {
                        Integer.valueOf(i), basicproductinfo.getLowestPrice()
                    });
                } else
                {
                    return basicofferlisting.getString(com.amazon.mShop.android.lib.R.string.item_row_new_and_used_from_y_format, new Object[] {
                        basicproductinfo.getLowestPrice()
                    });
                }
            }
        }
        return null;
    }

    public static void setBadgeImage(AmazonActivity amazonactivity, BasicOfferListing basicofferlisting, TextView textview, SpannableStringBuilder spannablestringbuilder, int i)
    {
        if (!BadgeUtils.isContainedBadge(basicofferlisting)) goto _L2; else goto _L1
_L1:
        Badge badge = basicofferlisting.getBadgeInfo().getBadge();
        if (!BadgeUtils.hasBadgeUrl(badge)) goto _L4; else goto _L3
_L3:
        Bitmap bitmap = BadgeUtils.getCachedBadge(BadgeUtils.getBadgeImageUrl(badge));
        if (bitmap == null) goto _L6; else goto _L5
_L5:
        UIUtils.setImageSpan(amazonactivity, bitmap, spannablestringbuilder, i);
_L2:
        return;
_L6:
        int j;
        if (spannablestringbuilder != null)
        {
            j = spannablestringbuilder.length();
        } else
        {
            j = 0;
        }
        if (BadgeUtils.hasBadgeDefaultHyperText(badge))
        {
            BadgeUtils.setBadgeItemSpan(spannablestringbuilder, badge.getMeta(), amazonactivity);
        }
        getBadgeFromBackground(basicofferlisting, textview, spannablestringbuilder, BadgeUtils.getBadgeImageUrl(badge), i, j);
        return;
_L4:
        if (BadgeUtils.hasBadgeDefaultHyperText(badge))
        {
            BadgeUtils.setBadgeItemSpan(spannablestringbuilder, badge.getMeta(), amazonactivity);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public static void updateActualPrice(ProductController productcontroller, LinearLayout linearlayout)
    {
        TextView textview = (TextView)linearlayout.findViewById(com.amazon.mShop.android.lib.R.id.item_price);
        if (!productcontroller.isPriceHidden())
        {
            String s2 = productcontroller.getDisplayPrice();
            if (s2 != null)
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                spannablestringbuilder.append(s2);
                spannablestringbuilder.setSpan(new StyleSpan(1), 0, s2.length(), 33);
                spannablestringbuilder.setSpan(new ForegroundColorSpan(linearlayout.getContext().getResources().getColor(com.amazon.mShop.android.lib.R.color.price)), 0, s2.length(), 33);
                BasicOfferListing basicofferlisting = productcontroller.getBasicOffer();
                if (basicofferlisting != null)
                {
                    PricePerUnit priceperunit = productcontroller.getBasicOffer().getPricePerUnit();
                    if (priceperunit != null)
                    {
                        String s3 = priceperunit.getPrice();
                        String s1 = priceperunit.getCount();
                        String s4 = priceperunit.getUnits();
                        if (!Util.isEmpty(s3) && !Util.isEmpty(s1) && !Util.isEmpty(s4))
                        {
                            String s = s1;
                            if ("1".equals(s1))
                            {
                                s = "";
                            }
                            s = linearlayout.getContext().getResources().getString(com.amazon.mShop.android.lib.R.string.dp_ppu_format_string, new Object[] {
                                s3, s, s4
                            });
                            spannablestringbuilder.append(" ");
                            spannablestringbuilder.append(s);
                            spannablestringbuilder.setSpan(new ForegroundColorSpan(linearlayout.getContext().getResources().getColor(com.amazon.mShop.android.lib.R.color.price)), s2.length(), spannablestringbuilder.length(), 33);
                        }
                    }
                }
                productcontroller = PriceBlock.getShippingPrice(linearlayout, productcontroller.getBasicOffer(), null);
                if (!Util.isEmpty(productcontroller))
                {
                    spannablestringbuilder.append((new StringBuilder()).append(" ").append(productcontroller).toString());
                }
                setBadgeImage((AmazonActivity)linearlayout.getContext(), basicofferlisting, textview, spannablestringbuilder, 1);
                textview.setText(spannablestringbuilder);
                linearlayout.setVisibility(0);
                return;
            } else
            {
                linearlayout.setVisibility(8);
                return;
            }
        } else
        {
            linearlayout.setVisibility(8);
            return;
        }
    }

    public static void updateActualPriceRow(ProductController productcontroller, LinearLayout linearlayout)
    {
        PriceBlock.updateActualPriceLabel(linearlayout, productcontroller);
        updateActualPrice(productcontroller, linearlayout);
    }

    public static void updateImage(byte abyte0[], ImageView imageview)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            imageview.setImageResource(com.amazon.mShop.android.lib.R.drawable.noimage);
            return;
        } else
        {
            imageview.setImageBitmap(BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length));
            return;
        }
    }

    public static void updateImageWithDrawable(Drawable drawable, ImageView imageview)
    {
        (new MShopUiOOMHandler((Activity)imageview.getContext(), new com.amazon.mShop.util.MShopUiOOMHandler.UiRunnable(new Runnable(drawable, imageview) {

            final Drawable val$drawable;
            final ImageView val$imageView;

            public void run()
            {
                if (drawable == null)
                {
                    imageView.setImageResource(com.amazon.mShop.android.lib.R.drawable.noimage);
                    return;
                } else
                {
                    imageView.setImageDrawable(drawable);
                    return;
                }
            }

            
            {
                drawable = drawable1;
                imageView = imageview;
                super();
            }
        }, true))).execute();
    }

    public static void updatePrice(TextView textview, BasicProductInfo basicproductinfo, BasicOfferListing basicofferlisting)
    {
label0:
        {
            if (textview != null)
            {
                basicproductinfo = ProductController.getPriceToDisplay(basicproductinfo, basicofferlisting);
                if (Util.isEmpty(basicproductinfo))
                {
                    break label0;
                }
                textview.setText(UIUtils.convertUnsupportedCharacter(textview.getContext(), basicproductinfo, com.amazon.mShop.util.UIUtils.CharacterColor.RED));
                textview.setVisibility(0);
            }
            return;
        }
        textview.setText(null);
        textview.setVisibility(8);
    }

    public static void updatePriceForMarketplace(TextView textview, BasicOfferListing basicofferlisting)
    {
label0:
        {
            if (textview != null)
            {
                if (basicofferlisting != null && !Util.isEmpty(basicofferlisting.getPrice()))
                {
                    break label0;
                }
                textview.setVisibility(8);
            }
            return;
        }
        if (basicofferlisting.getPriceViolatesMap())
        {
            basicofferlisting = textview.getContext().getString(com.amazon.mShop.android.lib.R.string.dp_add_to_cart_to_see_price);
            if (!Util.isEmpty(basicofferlisting))
            {
                textview.setText(basicofferlisting);
                textview.setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
                textview.setVisibility(0);
                return;
            } else
            {
                textview.setVisibility(8);
                return;
            }
        } else
        {
            textview.setText(UIUtils.convertUnsupportedCharacter(textview.getContext(), basicofferlisting.getPrice(), com.amazon.mShop.util.UIUtils.CharacterColor.RED));
            textview.setEllipsize(null);
            textview.setVisibility(0);
            return;
        }
    }

    public static void updateShippingPrice(AmazonActivity amazonactivity, TextView textview, BasicOfferListing basicofferlisting, ExtraOfferListing extraofferlisting, boolean flag)
    {
        if (textview == null) goto _L2; else goto _L1
_L1:
        SpannableStringBuilder spannablestringbuilder;
        spannablestringbuilder = new SpannableStringBuilder();
        extraofferlisting = ProductController.getOfferShippingPrice(basicofferlisting, extraofferlisting);
        if (Util.isEmpty(extraofferlisting)) goto _L4; else goto _L3
_L3:
        spannablestringbuilder.append(UIUtils.convertUnsupportedCharacter(amazonactivity, textview.getResources().getString(com.amazon.mShop.android.lib.R.string.dp_plus_shipping, new Object[] {
            extraofferlisting
        }), com.amazon.mShop.util.UIUtils.CharacterColor.DARK_GRAY));
_L6:
        if (flag)
        {
            setBadgeImage(amazonactivity, basicofferlisting, textview, spannablestringbuilder, 0);
        }
        if (spannablestringbuilder.length() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        textview.setText(spannablestringbuilder);
        textview.setVisibility(0);
_L2:
        return;
_L4:
        if (ProductController.isEligibleForSuperSaverShipping(basicofferlisting))
        {
            spannablestringbuilder.append(textview.getResources().getString(com.amazon.mShop.android.lib.R.string.dp_free_super_saver_shipping));
        }
        if (true) goto _L6; else goto _L5
_L5:
        textview.setText(null);
        textview.setVisibility(8);
        return;
    }

    public static void updateTitleBlock(View view, ProductController productcontroller)
    {
        TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_title);
        if (textview != null)
        {
            textview.setText(productcontroller.getTitle());
        }
        textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_byline_binding);
        if (textview != null)
        {
            textview.setText(getDisplayByLineAndBinding(productcontroller.getBasicProduct(), view.getContext()));
        }
    }
}
