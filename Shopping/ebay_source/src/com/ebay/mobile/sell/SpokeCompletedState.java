// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.text.TextUtils;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SpokeCompletedState
{

    public boolean categorySpokeCompleted;
    public boolean conditionSpokeCompleted;
    public boolean descriptionSpokeCompleted;
    public boolean formatPriceSpokeCompleted;
    public boolean itemSpecificsSpokeCompleted;
    public boolean photoSpokeCompleted;
    public boolean preferencesSpokeCompleted;
    public boolean shippingSpokeCompleted;
    public boolean titleSpokeCompleted;

    public SpokeCompletedState()
    {
    }

    private static boolean getFormatPriceSpokeCompleted(ListingDraft listingdraft)
    {
        Object obj;
        String s;
        boolean flag;
        s = null;
        if (listingdraft.format != null)
        {
            s = listingdraft.format.getStringValue();
        }
        obj = null;
        if (listingdraft.price != null)
        {
            obj = listingdraft.price.getStringValue();
        }
        flag = false;
        if (!"ChineseAuction".equals(s)) goto _L2; else goto _L1
_L1:
        s = null;
        if (listingdraft.startPrice != null)
        {
            s = listingdraft.startPrice.getStringValue();
        }
        listingdraft = EbayCurrencyUtil.parseApiValue(s);
        if (listingdraft == null) goto _L4; else goto _L3
_L3:
        if (listingdraft.doubleValue() > 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = EbayCurrencyUtil.parseApiValue(((String) (obj)));
        if (obj == null) goto _L4; else goto _L5
_L5:
        if (listingdraft.doubleValue() >= ((Double) (obj)).doubleValue() && ((Double) (obj)).doubleValue() != 0.0D || listingdraft.doubleValue() == 0.0D) goto _L7; else goto _L6
_L6:
        flag = true;
_L4:
        return flag;
_L7:
        return false;
_L2:
        if ("FixedPrice".equals(s) || "StoresFixedPrice".equals(s))
        {
            listingdraft = EbayCurrencyUtil.parseApiValue(((String) (obj)));
            return listingdraft != null && listingdraft.doubleValue() > 0.0D;
        }
        if (true) goto _L4; else goto _L8
_L8:
    }

    public Set getCheckedSpokesForTracking()
    {
        HashSet hashset = new HashSet();
        if (photoSpokeCompleted)
        {
            hashset.add("SellingItemPhoto");
        }
        if (titleSpokeCompleted)
        {
            hashset.add("SellingItemTitleAndSubtitle");
        }
        if (categorySpokeCompleted)
        {
            hashset.add("SellingCategory");
        }
        if (conditionSpokeCompleted)
        {
            hashset.add("RefineItemCondition");
        }
        if (descriptionSpokeCompleted)
        {
            hashset.add("SellingItemDetails");
        }
        if (itemSpecificsSpokeCompleted)
        {
            hashset.add("SellingItemSpecifics");
        }
        if (formatPriceSpokeCompleted)
        {
            hashset.add("SellingItemFormatAndPrice");
        }
        if (shippingSpokeCompleted)
        {
            hashset.add("SellingShippingService");
        }
        if (preferencesSpokeCompleted)
        {
            hashset.add("SellingUserPrefs");
        }
        return hashset;
    }

    public void update(ListingDraftContent listingdraftcontent)
    {
        ListingDraft listingdraft;
        boolean flag;
        boolean flag2;
label0:
        {
            listingdraft = (ListingDraft)listingdraftcontent.getData();
            int i = 0;
            if (listingdraft.pictureUrls != null)
            {
                i = listingdraft.pictureUrls.size();
            }
            Object obj;
            Iterator iterator;
            Iterator iterator1;
            if (i > 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            photoSpokeCompleted = flag2;
            iterator = null;
            obj = iterator;
            if (listingdraft.title != null)
            {
                obj = iterator;
                if (listingdraft.title.getStringValue() != null)
                {
                    obj = iterator;
                    if (listingdraft.title.getStringValue().length() > 0)
                    {
                        obj = listingdraft.title.getStringValue();
                    }
                }
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            titleSpokeCompleted = flag2;
            iterator = null;
            obj = iterator;
            if (listingdraft.categoryNamePath != null)
            {
                obj = iterator;
                if (listingdraft.category != null)
                {
                    obj = iterator;
                    if (!"0".equals(listingdraft.category.getStringValue()))
                    {
                        obj = listingdraft.categoryNamePath.getStringValue();
                    }
                }
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            categorySpokeCompleted = flag2;
            iterator = null;
            obj = iterator;
            if (listingdraft.condition == null)
            {
                break label0;
            }
            i = listingdraft.condition.getIntValue();
            iterator1 = listingdraft.condition.options.iterator();
            do
            {
                obj = iterator;
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                obj = (LdsOption)iterator1.next();
            } while (((LdsOption) (obj)).getIntValue() != i);
            obj = ((LdsOption) (obj)).caption;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        conditionSpokeCompleted = flag2;
        iterator = null;
        obj = iterator;
        if (listingdraft.description != null)
        {
            obj = iterator;
            if (listingdraft.description.getStringValue() != null)
            {
                obj = listingdraft.description.getStringValue();
            }
        }
        if (listingdraft.productId != null && listingdraft.productId.getStringValue() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))) || flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        descriptionSpokeCompleted = flag2;
        itemSpecificsSpokeCompleted = listingdraftcontent.haveRequiredSpecifics();
        formatPriceSpokeCompleted = getFormatPriceSpokeCompleted(listingdraft);
        listingdraftcontent = null;
        if (listingdraft.shippingType != null)
        {
            listingdraftcontent = listingdraft.shippingType.getStringValue();
        }
        obj = null;
        if (listingdraft.shippingService1 != null)
        {
            obj = listingdraft.shippingService1.getSelectedCaption();
        }
        if ("NOT_SPECIFIED".equals(listingdraftcontent) || !TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        shippingSpokeCompleted = flag2;
        flag = false;
        listingdraftcontent = "";
        iterator = listingdraft.paymentMethods.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsField ldsfield = (LdsField)iterator.next();
            if (!"DISABLE".equals(ldsfield.getBmode()) && ldsfield.getBooleanValue())
            {
                Object obj1 = listingdraftcontent;
                if (listingdraftcontent.length() > 0)
                {
                    obj1 = (new StringBuilder()).append(listingdraftcontent).append(", ").toString();
                }
                if ("PayPal".equals(ldsfield.getIdIndex()))
                {
                    flag = true;
                    listingdraftcontent = ((ListingDraftContent) (obj1));
                } else
                {
                    listingdraftcontent = (new StringBuilder()).append(((String) (obj1))).append(ldsfield.caption).toString();
                }
            }
        } while (true);
        Object obj2;
        boolean flag1;
        if (listingdraft.paypalEmailAddress == null)
        {
            obj2 = null;
        } else
        {
            obj2 = listingdraft.paypalEmailAddress.getStringValue();
        }
        if (flag)
        {
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (!TextUtils.isEmpty(listingdraftcontent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (listingdraft.locationPostalCode != null && (!TextUtils.isEmpty(listingdraft.locationPostalCode.getStringValue()) || !TextUtils.isEmpty(listingdraft.locationCityState.getStringValue())))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag && flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        preferencesSpokeCompleted = flag2;
    }
}
