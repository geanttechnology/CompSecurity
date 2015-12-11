// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.sell.util.DescriptionConverter;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;
import java.util.Iterator;

public class HubDisplayState
{

    public boolean additionalShippingMethods;
    public String categoryValue;
    public String conditionValue;
    public boolean conditionVisible;
    public String currencyValue;
    public String descriptionValue;
    public String formatValue;
    public String guaranteeSalePrice;
    public boolean hasPaypal;
    public boolean isGuaranteeSelected;
    public String itemSpecificsValue;
    public String paymentValue;
    public String paypalEmail;
    public int photoCountValue;
    public String photoUrlValue;
    public String priceValue;
    public String returnsSummary;
    public String shippingCostValue;
    public String shippingType;
    public String shippingValue;
    public String startPriceValue;
    public String subtitleValue;
    public String titleValue;
    public String whoPaysForShipping;

    public HubDisplayState()
    {
    }

    private static String getShippingCostDisplay(ListingDraft listingdraft, ArrayList arraylist)
    {
        if (listingdraft != null && listingdraft.shippingType != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        obj = listingdraft.shippingType.getStringValue();
        if (!((String) (obj)).equals("FLAT_RATE"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (listingdraft.shippingService1fee == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist = listingdraft.shippingService1fee.getStringValue();
        if (arraylist != null && listingdraft.shippingService1fee.getDoubleValue() != 0.0D)
        {
            return EbayCurrencyUtil.formatDisplay(new CurrencyAmount(arraylist, listingdraft.getCurrencyCode()), 0);
        }
        continue; /* Loop/switch isn't completed */
        if (!((String) (obj)).equals("ACTUAL_RATE") || arraylist == null) goto _L1; else goto _L3
_L3:
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (ShippingEstimate)arraylist.next();
        } while (!((ShippingEstimate) (obj)).shippingService.serviceId.equals(listingdraft.shippingService1.getStringValue()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L4
_L4:
        return ((ShippingEstimate) (obj)).getValueDisplay(listingdraft.getCurrencyCode());
    }

    private static String getWhoPaysString(boolean flag, EbayContext ebaycontext)
    {
        if (flag)
        {
            return ebaycontext.getString(0x7f0705ae);
        } else
        {
            return ebaycontext.getString(0x7f07052c);
        }
    }

    private static String specificsValuesForDisplay(ListingDraft listingdraft)
    {
        StringBuilder stringbuilder = new StringBuilder();
        listingdraft = listingdraft.selectedItemSpecifics.iterator();
        do
        {
            if (!listingdraft.hasNext())
            {
                break;
            }
            Iterator iterator = ((LdsField)listingdraft.next()).getSelectedValues().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                stringbuilder.append((String)iterator.next());
                if (iterator.hasNext())
                {
                    stringbuilder.append(", ");
                }
            } while (true);
            if (listingdraft.hasNext())
            {
                stringbuilder.append(", ");
            }
        } while (true);
        return stringbuilder.toString();
    }

    public void update(ListingDraftContent listingdraftcontent, EbayContext ebaycontext)
    {
        boolean flag1 = true;
        ListingDraft listingdraft = (ListingDraft)listingdraftcontent.getData();
        photoUrlValue = listingdraft.getPrimaryPhotoUrl();
        if (listingdraft.pictureUrls != null)
        {
            photoCountValue = listingdraft.pictureUrls.size();
        }
        Object obj;
        boolean flag;
        if (listingdraft.title != null && listingdraft.title.getStringValue() != null && listingdraft.title.getStringValue().length() > 0)
        {
            titleValue = listingdraft.title.getStringValue();
        } else
        {
            titleValue = null;
        }
        if (listingdraft.subtitle != null && listingdraft.subtitle.getStringValue() != null && listingdraft.subtitle.getStringValue().length() > 0)
        {
            subtitleValue = listingdraft.subtitle.getStringValue();
        } else
        {
            subtitleValue = null;
        }
        if (listingdraft.categoryNamePath != null && listingdraft.category != null && !"0".equals(listingdraft.category.getStringValue()))
        {
            categoryValue = listingdraft.categoryNamePath.getStringValue();
        } else
        {
            categoryValue = null;
        }
        conditionValue = null;
        if (listingdraft.condition != null)
        {
            int i = listingdraft.condition.getIntValue();
            obj = listingdraft.condition.options.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                LdsOption ldsoption = (LdsOption)((Iterator) (obj)).next();
                if (ldsoption.getIntValue() != i)
                {
                    continue;
                }
                conditionValue = ldsoption.caption;
                break;
            } while (true);
            if (!listingdraft.condition.getBmode().equals("DISABLE"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            conditionVisible = flag;
        }
        itemSpecificsValue = specificsValuesForDisplay(listingdraft);
        if (listingdraft.description != null && listingdraft.description.getStringValue() != null)
        {
            obj = DescriptionConverter.toPlainText(listingdraft.description.getStringValue());
            if (((String) (obj)).length() > 250)
            {
                descriptionValue = ((String) (obj)).substring(0, 250);
            } else
            {
                descriptionValue = ((String) (obj));
            }
        } else
        {
            descriptionValue = null;
        }
        if (listingdraft.price != null)
        {
            priceValue = listingdraft.price.getStringValue();
        }
        if (listingdraft.startPrice != null)
        {
            startPriceValue = listingdraft.startPrice.getStringValue();
        }
        if (listingdraft.format != null)
        {
            formatValue = listingdraft.format.getStringValue();
        }
        currencyValue = listingdraft.getCurrencyCode();
        shippingValue = null;
        shippingCostValue = null;
        whoPaysForShipping = null;
        if (listingdraft.shippingType != null && listingdraft.shippingType.getStringValue().equals("NOT_SPECIFIED"))
        {
            shippingValue = ebaycontext.getString(0x7f0700b7);
        } else
        if (listingdraft.shippingService1 != null)
        {
            shippingValue = listingdraft.shippingService1.getSelectedCaption();
            shippingCostValue = getShippingCostDisplay(listingdraft, listingdraftcontent.shippingEstimates);
            whoPaysForShipping = getWhoPaysString(listingdraft.isFreeShipping(), ebaycontext);
        }
        if (listingdraft.getDomesticShippingCount() > 1 || listingdraft.getIntlShippingCount() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        additionalShippingMethods = flag;
        hasPaypal = false;
        paymentValue = "";
        if (listingdraft.paypalEmailAddress == null)
        {
            ebaycontext = null;
        } else
        {
            ebaycontext = listingdraft.paypalEmailAddress.getStringValue();
        }
        paypalEmail = ebaycontext;
        if (listingdraft.refundReturnsAccepted != null)
        {
            returnsSummary = listingdraft.refundReturnsAccepted.getSelectedCaption();
        }
        for (ebaycontext = listingdraft.paymentMethods.iterator(); ebaycontext.hasNext();)
        {
            obj = (LdsField)ebaycontext.next();
            if (!"DISABLE".equals(((LdsField) (obj)).getBmode()) && ((LdsField) (obj)).getBooleanValue())
            {
                if (paymentValue.length() > 0)
                {
                    paymentValue = (new StringBuilder()).append(paymentValue).append(", ").toString();
                }
                if ("PayPal".equals(((LdsField) (obj)).getIdIndex()))
                {
                    hasPaypal = true;
                } else
                {
                    paymentValue = (new StringBuilder()).append(paymentValue).append(((LdsField) (obj)).caption).toString();
                }
            }
        }

        if (listingdraft.isGuaranteeAvailable() && listingdraftcontent.isGuaranteeSelectedThisSession)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isGuaranteeSelected = flag;
        if (isGuaranteeSelected)
        {
            guaranteeSalePrice = EbayCurrencyUtil.formatDisplay(currencyValue, listingdraft.guaranteeSalePrice.getDoubleValue(), 2);
            return;
        } else
        {
            guaranteeSalePrice = null;
            return;
        }
    }
}
