// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.math.BigDecimal;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            CartAdapter

private static final class onversionDisplay
    implements onversionDisplay
{

    public TextView bopisSubtotal;
    public TextView bopisSubtotalLabel;
    public TextView cartSubtotal;
    private final String discountFormat;
    public TextView discountSubtotal;
    public TextView discountSubtotalLabel;
    private final boolean invertedCurrencyConversionDisplay;
    public TextView itemSubtotal;
    public TextView itemSubtotalLabel;
    private final String localCurrencyCode = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
    public TextView sellerDiscountSubtotalAmount;
    public TextView sellerDiscountSubtotalLabel;
    public TextView shippingImportSubtotalAmount;
    public TextView shippingImportSubtotalLabel;
    public TextView shippingSubtotal;
    public TextView shippingSubtotalLabel;
    public TextView taxAmount;
    public TextView taxLabel;

    public void update(Object obj, boolean flag)
    {
label0:
        {
            com.ebay.nautilus.domain.data.nversionDisplay nversiondisplay = (com.ebay.nautilus.domain.data.nversionDisplay)obj;
            if (nversiondisplay != null)
            {
                cartSubtotal.setText(EbayCurrencyUtil.formatDisplay(nversiondisplay.artSubtotal, 2));
                itemSubtotal.setText(EbayCurrencyUtil.formatDisplay(nversiondisplay.otal, 2));
                itemSubtotalLabel.setText(itemSubtotalLabel.getContext().getString(0x7f070a8f, new Object[] {
                    Integer.valueOf(nversiondisplay.ableItems)
                }));
                PostalCodeSpecification postalcodespecification;
                if (nversiondisplay.SubTotal.isZero())
                {
                    shippingSubtotal.setText(0x7f070421);
                } else
                {
                    shippingSubtotal.setText(EbayCurrencyUtil.formatDisplay(nversiondisplay.SubTotal, 2));
                }
                postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
                obj = "";
                if (postalcodespecification != null)
                {
                    obj = postalcodespecification.postalCode;
                }
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    shippingSubtotalLabel.setText(0x7f070aab);
                } else
                {
                    shippingSubtotalLabel.setText(shippingSubtotalLabel.getContext().getString(0x7f070aac, new Object[] {
                        obj
                    }));
                }
                if (nversiondisplay.Item)
                {
                    bopisSubtotal.setText(0x7f070421);
                    bopisSubtotal.setVisibility(0);
                    bopisSubtotalLabel.setVisibility(0);
                    bopisSubtotalLabel.setText(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
                } else
                {
                    bopisSubtotal.setVisibility(8);
                    bopisSubtotalLabel.setVisibility(8);
                }
                if (!nversiondisplay.arges.isZero())
                {
                    shippingImportSubtotalAmount.setText(EbayCurrencyUtil.formatDisplay(nversiondisplay.arges, 2));
                    shippingImportSubtotalAmount.setVisibility(0);
                    shippingImportSubtotalLabel.setVisibility(0);
                } else
                {
                    shippingImportSubtotalAmount.setVisibility(8);
                    shippingImportSubtotalLabel.setVisibility(8);
                }
                if (!nversiondisplay.tal.isZero())
                {
                    taxAmount.setText(EbayCurrencyUtil.formatDisplay(nversiondisplay.tal, 2));
                    taxAmount.setVisibility(0);
                    taxLabel.setVisibility(0);
                } else
                {
                    taxLabel.setVisibility(8);
                    taxAmount.setVisibility(8);
                }
                if (!nversiondisplay..isZero())
                {
                    discountSubtotal.setText(String.format(discountFormat, new Object[] {
                        EbayCurrencyUtil.formatDisplay(nversiondisplay., 2)
                    }));
                    discountSubtotal.setVisibility(0);
                    discountSubtotalLabel.setVisibility(0);
                } else
                {
                    discountSubtotal.setVisibility(8);
                    discountSubtotalLabel.setVisibility(8);
                }
                if (!nversiondisplay.ntsSubTotal.isZero())
                {
                    flag = nversiondisplay.ntsSubTotal.isGreaterThanZero();
                    obj = MyApp.getApp();
                    CurrencyAmount currencyamount;
                    StringBuilder stringbuilder;
                    int i;
                    if (flag)
                    {
                        i = 0x7f070c66;
                    } else
                    {
                        i = 0x7f070c67;
                    }
                    obj = ((MyApp) (obj)).getString(i);
                    currencyamount = new CurrencyAmount(nversiondisplay.ntsSubTotal.getValueAsBigDecimal().abs(), nversiondisplay.ntsSubTotal.getCurrencyCode());
                    stringbuilder = new StringBuilder();
                    if (!flag)
                    {
                        stringbuilder.append("- ");
                    }
                    stringbuilder.append(EbayCurrencyUtil.formatDisplay(currencyamount, 2));
                    sellerDiscountSubtotalAmount.setText(stringbuilder);
                    sellerDiscountSubtotalLabel.setText(((CharSequence) (obj)));
                    sellerDiscountSubtotalAmount.setVisibility(0);
                    sellerDiscountSubtotalLabel.setVisibility(0);
                } else
                {
                    sellerDiscountSubtotalAmount.setVisibility(8);
                    sellerDiscountSubtotalLabel.setVisibility(8);
                }
                if (invertedCurrencyConversionDisplay)
                {
                    if (!nversiondisplay.urrencyCart(localCurrencyCode))
                    {
                        break label0;
                    }
                    cartSubtotal.setTypeface(null, 0);
                    itemSubtotal.setTypeface(null, 0);
                    shippingImportSubtotalAmount.setTypeface(null, 0);
                    shippingSubtotal.setTypeface(null, 0);
                    bopisSubtotal.setTypeface(null, 0);
                    taxAmount.setTypeface(null, 0);
                    discountSubtotal.setTypeface(null, 0);
                }
            }
            return;
        }
        cartSubtotal.setTypeface(null, 2);
        itemSubtotal.setTypeface(null, 2);
        shippingImportSubtotalAmount.setTypeface(null, 2);
        shippingSubtotal.setTypeface(null, 2);
        bopisSubtotal.setTypeface(null, 2);
        taxAmount.setTypeface(null, 2);
        discountSubtotal.setTypeface(null, 2);
    }

    public (View view)
    {
        cartSubtotal = (TextView)view.findViewById(0x7f1007e6);
        itemSubtotalLabel = (TextView)view.findViewById(0x7f1007d7);
        itemSubtotal = (TextView)view.findViewById(0x7f1007d8);
        shippingSubtotalLabel = (TextView)view.findViewById(0x7f1007d9);
        shippingImportSubtotalAmount = (TextView)view.findViewById(0x7f1007dc);
        shippingImportSubtotalLabel = (TextView)view.findViewById(0x7f1007db);
        shippingSubtotal = (TextView)view.findViewById(0x7f1007da);
        bopisSubtotal = (TextView)view.findViewById(0x7f1007de);
        bopisSubtotalLabel = (TextView)view.findViewById(0x7f1007dd);
        discountSubtotal = (TextView)view.findViewById(0x7f1007e2);
        discountSubtotalLabel = (TextView)view.findViewById(0x7f1007e1);
        sellerDiscountSubtotalAmount = (TextView)view.findViewById(0x7f1007e4);
        sellerDiscountSubtotalLabel = (TextView)view.findViewById(0x7f1007e3);
        taxAmount = (TextView)view.findViewById(0x7f1007e0);
        taxLabel = (TextView)view.findViewById(0x7f1007df);
        discountFormat = view.getResources().getString(0x7f070a80);
        invertedCurrencyConversionDisplay = MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.ShoppingCartInvertCurrencyConversionDisplay);
    }
}
