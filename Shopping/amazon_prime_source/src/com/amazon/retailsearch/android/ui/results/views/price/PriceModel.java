// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ProductUtil;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Savings;
import com.amazon.searchapp.retailsearch.model.Shipping;
import com.amazon.searchapp.retailsearch.model.ShippingStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PriceModel
{
    public static class Builder
    {

        private PriceInfo mainPrice;
        private Shipping shippingInfo;

        private String buildSponsoredPriceMsg()
        {
            String s = "";
            boolean flag;
            if (mainPrice.getLink() != null && !TextUtils.isEmpty(mainPrice.getLink().getText()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!TextUtils.isEmpty(mainPrice.getPreLinkText()))
            {
                String s1;
                int i;
                if (flag)
                {
                    i = mainPrice.getPreLinkText().length();
                } else
                {
                    i = mainPrice.getPreLinkText().lastIndexOf(':');
                }
                s = (new StringBuilder()).append("").append(mainPrice.getPreLinkText().substring(0, i)).toString();
            }
            s1 = s;
            if (flag)
            {
                s1 = s;
                if (!TextUtils.isEmpty(s))
                {
                    s1 = (new StringBuilder()).append(s).append(" ").toString();
                }
                s1 = (new StringBuilder()).append(s1).append(mainPrice.getLink().getText()).toString();
            }
            return s1;
        }

        private String getAddonBadgeAssetId()
        {
            if (shippingInfo != null && shippingInfo.getAddOn() != null)
            {
                return shippingInfo.getAddOn().getBadgeAssetId();
            }
            if (mainPrice != null && mainPrice.getShipping() != null && mainPrice.getShipping().getAddOn() != null)
            {
                return mainPrice.getShipping().getAddOn().getBadgeAssetId();
            } else
            {
                return null;
            }
        }

        private String getCodBadgeAssetId()
        {
            if (shippingInfo != null && shippingInfo.getCod() != null)
            {
                return shippingInfo.getCod().getBadgeAssetId();
            }
            if (mainPrice != null && mainPrice.getShipping() != null && mainPrice.getShipping().getCod() != null)
            {
                return mainPrice.getShipping().getCod().getBadgeAssetId();
            } else
            {
                return null;
            }
        }

        public PriceModel build(PriceInfo priceinfo, Shipping shipping, boolean flag, boolean flag1)
        {
            return build(null, priceinfo, shipping, false, false, flag, flag1);
        }

        public PriceModel build(Prices prices, PriceInfo priceinfo, Shipping shipping, boolean flag, boolean flag1, boolean flag2, boolean flag3)
        {
            Object obj;
            PriceModel pricemodel;
            mainPrice = priceinfo;
            shippingInfo = shipping;
            if (priceinfo == null)
            {
                return null;
            }
            pricemodel = new PriceModel();
            if (flag2)
            {
                pricemodel.setListPrice(priceinfo.getListPrice());
            }
            Object obj2;
            UIPriceInfo uipriceinfo;
            if (flag1)
            {
                obj = priceinfo.getPostLinkText();
            } else
            {
                obj = priceinfo.getPrice();
            }
            pricemodel.setPrice(((String) (obj)));
            if (priceinfo.getMap() != null)
            {
                pricemodel.setMapTextId(Integer.valueOf(com.amazon.retailsearch.R.string.item_map_instructions));
            }
            if (!TextUtils.isEmpty(priceinfo.getUnitPrice()))
            {
                pricemodel.setUnitOrIssuePrice(priceinfo.getUnitPrice());
                break MISSING_BLOCK_LABEL_104;
            } else
            {
                if (!TextUtils.isEmpty(priceinfo.getIssuePrice()))
                {
                    pricemodel.setUnitOrIssuePrice(priceinfo.getIssuePrice());
                }
                continue;
            }
            do
            {
                obj = ProductUtil.getShipping(prices, shipping);
                Object obj1 = ProductUtil.getPrimeProgramBadgeId(((Shipping) (obj)));
                obj2 = getAddonBadgeAssetId();
                if (obj2 != null)
                {
                    pricemodel.setBadgeId(((String) (obj2)));
                } else
                if (obj1 != null)
                {
                    pricemodel.setBadgeId(((String) (obj1)));
                }
                obj1 = getCodBadgeAssetId();
                if (obj1 != null)
                {
                    pricemodel.setCodBadgeId(((String) (obj1)));
                }
                pricemodel.setHasAutoRip(ProductUtil.hasAutoRipBadge(((Shipping) (obj))));
                pricemodel.setUseEditions(flag);
                if (prices != null && prices.getEditions() != null)
                {
                    obj1 = prices.getEditions();
                    obj = new ArrayList(((List) (obj1)).size());
                    obj1 = ((List) (obj1)).iterator();
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break;
                        }
                        obj2 = (EditionsPriceInfo)((Iterator) (obj1)).next();
                        if (!TextUtils.isEmpty(((EditionsPriceInfo) (obj2)).getPrice()))
                        {
                            uipriceinfo = new UIPriceInfo();
                            uipriceinfo.setPrice(((EditionsPriceInfo) (obj2)).getPrice());
                            uipriceinfo.setLabel(((EditionsPriceInfo) (obj2)).getLink().getText());
                            ((List) (obj)).add(uipriceinfo);
                        }
                    } while (true);
                    pricemodel.setEditions(((List) (obj)));
                    if (prices.getRental() != null && !prices.getEditions().isEmpty())
                    {
                        prices = (EditionsPriceInfo)prices.getEditions().get(0);
                        pricemodel.setStyledPrice(prices.getStyledPrice());
                        pricemodel.setStyledRentalPrice(prices.getStyledRentalPrice());
                    }
                }
                if (flag3 && shipping != null && shipping.getPrime() != null)
                {
                    pricemodel.setSomePrimeMsg(shipping.getPrime().getMessage());
                }
                pricemodel.setSavings(priceinfo.getSavings());
                if (flag1)
                {
                    pricemodel.setSponsoredPriceMsg(buildSponsoredPriceMsg());
                }
                pricemodel.setInAppPurchaseMsg(priceinfo.getInAppPurchaseLabel());
                return pricemodel;
            } while (true);
        }

        public Builder()
        {
        }
    }

    static class UIPriceInfo
    {

        String label;
        String price;

        public String getLabel()
        {
            return label;
        }

        public String getPrice()
        {
            return price;
        }

        public void setLabel(String s)
        {
            label = s;
        }

        public void setPrice(String s)
        {
            price = s;
        }

        public UIPriceInfo()
        {
        }

        public UIPriceInfo(String s, String s1)
        {
            price = s;
            label = s1;
        }
    }


    private String badgeId;
    private String codBadgeId;
    private List editions;
    private boolean hasAutoRip;
    private List inAppPurchaseMsg;
    private String listPrice;
    private Integer mapTextId;
    private String price;
    private Savings savings;
    private String somePrimeMsg;
    private String sponsoredPriceMsg;
    private List styledPrice;
    private List styledRentalPrice;
    private String unitOrIssuePrice;
    private boolean useEditions;

    public PriceModel()
    {
    }

    public String getBadgeId()
    {
        return badgeId;
    }

    public String getCodBadgeId()
    {
        return codBadgeId;
    }

    public List getEditions()
    {
        return editions;
    }

    public List getInAppPurchaseMsg()
    {
        return inAppPurchaseMsg;
    }

    public String getListPrice()
    {
        return listPrice;
    }

    public Integer getMapTextId()
    {
        return mapTextId;
    }

    public String getPrice()
    {
        return price;
    }

    public Savings getSavings()
    {
        return savings;
    }

    public String getSomePrimeMsg()
    {
        return somePrimeMsg;
    }

    public String getSponsoredPriceMsg()
    {
        return sponsoredPriceMsg;
    }

    public List getStyledPrice()
    {
        return styledPrice;
    }

    public List getStyledRentalPrice()
    {
        return styledRentalPrice;
    }

    public String getUnitOrIssuePrice()
    {
        return unitOrIssuePrice;
    }

    public boolean getUseEditions()
    {
        return useEditions;
    }

    public boolean hasAutoRip()
    {
        return hasAutoRip;
    }

    protected void setBadgeId(String s)
    {
        badgeId = s;
    }

    public void setCodBadgeId(String s)
    {
        codBadgeId = s;
    }

    protected void setEditions(List list)
    {
        editions = list;
    }

    protected void setHasAutoRip(boolean flag)
    {
        hasAutoRip = flag;
    }

    protected void setInAppPurchaseMsg(List list)
    {
        inAppPurchaseMsg = list;
    }

    protected void setListPrice(String s)
    {
        listPrice = s;
    }

    protected void setMapTextId(Integer integer)
    {
        mapTextId = integer;
    }

    protected void setPrice(String s)
    {
        price = s;
    }

    protected void setSavings(Savings savings1)
    {
        savings = savings1;
    }

    protected void setSomePrimeMsg(String s)
    {
        somePrimeMsg = s;
    }

    protected void setSponsoredPriceMsg(String s)
    {
        sponsoredPriceMsg = s;
    }

    public void setStyledPrice(List list)
    {
        styledPrice = list;
    }

    public void setStyledRentalPrice(List list)
    {
        styledRentalPrice = list;
    }

    protected void setUnitOrIssuePrice(String s)
    {
        unitOrIssuePrice = s;
    }

    protected void setUseEditions(boolean flag)
    {
        useEditions = flag;
    }
}
