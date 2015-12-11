// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.shopping.GetMultipleItemsNetLoader;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.ViewCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsResponse;
import com.ebay.nautilus.domain.net.image.ConstructDipUrl;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseListActivity

public class RecentlyViewedItemsActivity extends BaseListActivity
    implements android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.UssContentsDataManager.Observer
{
    private static class MyViewCache extends ViewCache
    {

        public long itemId;

        public MyViewCache(View view, long l)
        {
            super(view);
            itemId = l;
        }
    }

    private final class RecentlyViewedDataObserver extends com.ebay.mobile.recents.RecentsDataManager.SimpleLookUpObserver
    {

        final RecentlyViewedItemsActivity this$0;

        public void onAllViewedItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content)
        {
            findViewById(0x7f100120).setVisibility(8);
            if (content != null && content.getStatus().hasError())
            {
                Toast.makeText(RecentlyViewedItemsActivity.this, getString(0x7f0703d1), 1).show();
                return;
            } else
            {
                recentsdatamanager = new Intent();
                recentsdatamanager.putExtra("cleared", true);
                setResult(-1, recentsdatamanager);
                finish();
                return;
            }
        }

        private RecentlyViewedDataObserver()
        {
            this$0 = RecentlyViewedItemsActivity.this;
            super();
        }

    }

    private class RecentlyViewedItemsAdapter extends ArrayAdapter
    {

        protected static final long HOUR = 0x36ee80L;
        protected static final long SECOND = 1000L;
        protected static final long YEAR = 0x757b12c00L;
        private final Spannable binOrBestOffer = getBinOrBestOfferText();
        protected final int buyingFormat = 7;
        protected final int colorEekInfo;
        protected final int colorPriceSold;
        protected final int colorPriceUnsold;
        protected final int colorShippingFree;
        protected final int colorTextDefault;
        protected final int colorTimeWarning;
        private final Map eekInfoMap;
        private final LayoutInflater inflater;
        private final Resources resources;
        protected final boolean showFreeShipping = true;
        protected final boolean showShipping = true;
        protected final String strDays;
        protected final String strHours;
        protected final String strMinutes;
        protected final String strSeconds;
        private android.content.res.Resources.Theme theme;
        final RecentlyViewedItemsActivity this$0;

        private int convertListingType(EbayItem ebayitem)
        {
            if (ebayitem.isBidWithBinAvailable())
            {
                return 3;
            }
            if (ebayitem.isBinOnly())
            {
                return 5;
            }
            return !ebayitem.isListingTypeBid() ? 0 : 2;
        }

        private Spannable getBinOrBestOfferText()
        {
            int i = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010036);
            Object obj = resources.getString(0x7f0701b7);
            String s = resources.getString(0x7f070742);
            int j = ((String) (obj)).length() + 1;
            int k = j + s.length();
            obj = new SpannableString((new StringBuilder(((String) (obj)))).append('\n').append(s));
            ((Spannable) (obj)).setSpan(new ForegroundColorSpan(i), j, k, 33);
            ((Spannable) (obj)).setSpan(new StyleSpan(1), j, k, 33);
            ((Spannable) (obj)).setSpan(new AbsoluteSizeSpan(10, true), j, k, 33);
            return ((Spannable) (obj));
        }

        private Spannable getOrBuyItNowText(String s)
        {
            int i = colorTextDefault;
            String s1 = resources.getString(0x7f070743);
            int j = s.length() + 1;
            int k = j + s1.length();
            s = new SpannableString((new StringBuilder(s)).append('\n').append(s1));
            s.setSpan(new ForegroundColorSpan(i), j, k, 33);
            s.setSpan(new StyleSpan(1), j, k, 33);
            s.setSpan(new AbsoluteSizeSpan(10, true), j, k, 33);
            return s;
        }

        private Spannable getPriceSpannable(String s, String s1, EbayItem ebayitem, boolean flag)
        {
            int j = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010036);
            double d;
            int i;
            int k;
            try
            {
                d = Double.parseDouble(ebayitem.currentPrice.value) / Double.parseDouble(ebayitem.unitPriceQuantity);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("SearchResultListAdapter", "getPriceSpannable exception", s);
                return null;
            }
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            s = EbayCurrencyUtil.formatDisplay(s, d, i);
            ebayitem = (new StringBuilder()).append("(").append(s).append(" / ").append(ebayitem.unitPriceType).append(")").toString();
            i = s1.length() + 1;
            k = i + ebayitem.length();
            s = new StyleSpan(1);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            s = new StyleSpan(3);
            s1 = new SpannableString((new StringBuilder(s1)).append('\n').append(ebayitem));
            s1.setSpan(new ForegroundColorSpan(j), i, k, 33);
            s1.setSpan(s, i, k, 33);
            s1.setSpan(new AbsoluteSizeSpan(10, true), i, k, 33);
            return s1;
        }

        private Spannable getPriceSpannableAuctionWithBin(String s, String s1, EbayItem ebayitem, boolean flag)
        {
            int j;
            j = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010036);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_228;
            }
            ItemCurrency itemcurrency;
            if (ebayitem.convertedBuyItNowPrice == null)
            {
                break MISSING_BLOCK_LABEL_228;
            }
            itemcurrency = ebayitem.convertedBuyItNowPrice;
_L1:
            double d = Double.parseDouble(itemcurrency.value) / Double.parseDouble(ebayitem.unitPriceQuantity);
            int i;
            int k;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            try
            {
                s = EbayCurrencyUtil.formatDisplay(s, d, i);
                ebayitem = (new StringBuilder()).append("(").append(s).append(" / ").append(ebayitem.unitPriceType).append(")").toString();
                i = s1.length() + 1;
                k = i + ebayitem.length();
                s = new StyleSpan(1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("SearchResultListAdapter", "getPriceSpannable exception", s);
                return null;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_145;
            }
            s = new StyleSpan(3);
            s1 = new SpannableString((new StringBuilder(s1)).append('\n').append(ebayitem));
            s1.setSpan(new ForegroundColorSpan(j), i, k, 33);
            s1.setSpan(s, i, k, 33);
            s1.setSpan(new AbsoluteSizeSpan(10, true), i, k, 33);
            return s1;
            itemcurrency = ebayitem.buyItNowPrice;
              goto _L1
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            EbayItem ebayitem = (EbayItem)items.get(i);
            MyViewCache myviewcache;
            String s;
            String s1;
            if (eekInfoMap != null)
            {
                viewgroup = (String)eekInfoMap.get(Long.valueOf(ebayitem.id));
            } else
            {
                viewgroup = null;
            }
            if (view == null)
            {
                view = inflater.inflate(0x7f030074, null);
                myviewcache = new MyViewCache(view, ebayitem.id);
                view.setTag(myviewcache);
            } else
            {
                myviewcache = (MyViewCache)view.getTag();
                myviewcache.itemId = ebayitem.id;
            }
            setItem(myviewcache, ebayitem);
            s1 = ebayitem.galleryUrl;
            s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = s1;
                if (ebayitem.pictureUrls != null)
                {
                    s = s1;
                    if (ebayitem.pictureUrls.size() > 0)
                    {
                        s = (String)ebayitem.pictureUrls.get(0);
                    }
                }
            }
            myviewcache.image.setRemoteImageUrl(s);
            myviewcache.text.setText(ebayitem.title);
            if (!TextUtils.isEmpty(viewgroup))
            {
                myviewcache.specialText.setText(viewgroup);
                myviewcache.specialText.setTextColor(colorEekInfo);
                myviewcache.specialText.setVisibility(0);
            } else
            {
                myviewcache.specialText.setVisibility(8);
            }
            myviewcache.object = ebayitem;
            view.setOnClickListener(RecentlyViewedItemsActivity.this);
            i = 0x1080062;
            viewgroup = new TypedValue();
            if (getContext().getTheme().resolveAttribute(0x10102f0, viewgroup, true))
            {
                i = ((TypedValue) (viewgroup)).resourceId;
            }
            view.setBackgroundResource(i);
            return view;
        }

        public void refresh(ListView listview)
        {
            long l = EbayResponse.currentHostTime();
            int j = listview.getChildCount();
            int i = 0;
            while (i < j) 
            {
                Object obj = listview.getChildAt(i);
                if (obj != null)
                {
                    obj = (ViewCache)((View) (obj)).getTag();
                    if (obj != null)
                    {
                        EbayItem ebayitem = (EbayItem)((ViewCache) (obj)).object;
                        if (ebayitem != null)
                        {
                            setTimeLeft(((ViewCache) (obj)).rightColumnText4, ebayitem.endDate, l);
                        }
                    }
                }
                i++;
            }
        }

        protected boolean setCurrency(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
        {
            return setCurrency(textview, itemcurrency, itemcurrency1, false, null);
        }

        protected boolean setCurrency(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, boolean flag, EbayItem ebayitem)
        {
            boolean flag2;
            if (itemcurrency1 != null && itemcurrency1.code != null && itemcurrency1.value != null && !itemcurrency1.equals(itemcurrency))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                itemcurrency = itemcurrency1;
            } else
            if (itemcurrency == null || itemcurrency.code == null || itemcurrency.value == null)
            {
                itemcurrency = null;
            }
            if (itemcurrency != null)
            {
                Object obj = formatCurrency(itemcurrency.value, itemcurrency.code);
                boolean flag1 = true;
                byte byte0 = flag1;
                itemcurrency1 = ((ItemCurrency) (obj));
                if (flag2)
                {
                    byte0 = flag1;
                    itemcurrency1 = ((ItemCurrency) (obj));
                    if (obj != null)
                    {
                        byte0 = 2;
                        itemcurrency1 = (new StringBuilder()).append(((String) (obj))).append(" ").toString();
                    }
                }
                Object obj1 = null;
                obj = obj1;
                if (DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE))
                {
                    obj = obj1;
                    if (flag)
                    {
                        obj = obj1;
                        if (ebayitem != null)
                        {
                            obj = getPriceSpannable(itemcurrency.code, itemcurrency1, ebayitem, flag2);
                        }
                    }
                }
                if (obj == null)
                {
                    textview.setTypeface(Typeface.DEFAULT, byte0);
                    textview.setText(itemcurrency1);
                    return flag2;
                } else
                {
                    textview.setText(((CharSequence) (obj)));
                    return flag2;
                }
            } else
            {
                textview.setText(null);
                return flag2;
            }
        }

        protected boolean setCurrencyWithBaseUnitPriceAuctionWithBin(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, ItemCurrency itemcurrency2, ItemCurrency itemcurrency3, boolean flag, EbayItem ebayitem)
        {
            boolean flag2;
            Object obj;
            byte byte0;
            boolean flag1;
            if (itemcurrency1 != null && itemcurrency1.code != null && itemcurrency1.value != null && !itemcurrency1.equals(itemcurrency))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                itemcurrency = itemcurrency1;
                break MISSING_BLOCK_LABEL_36;
            } else
            {
                if (itemcurrency == null || itemcurrency.code == null || itemcurrency.value == null)
                {
                    itemcurrency = null;
                }
                continue;
            }
            do
            {
                if (itemcurrency != null)
                {
                    itemcurrency = formatCurrency(itemcurrency.value, itemcurrency.code);
                    flag1 = true;
                    byte0 = flag1;
                    itemcurrency1 = itemcurrency;
                    if (flag2)
                    {
                        byte0 = flag1;
                        itemcurrency1 = itemcurrency;
                        if (itemcurrency != null)
                        {
                            byte0 = 2;
                            itemcurrency1 = (new StringBuilder()).append(itemcurrency).append(" ").toString();
                        }
                    }
                    obj = null;
                    Spannable spannable = obj;
                    if (DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE))
                    {
                        spannable = obj;
                        if (flag)
                        {
                            spannable = obj;
                            if (ebayitem != null)
                            {
                                if (itemcurrency3 != null && itemcurrency3.code != null && itemcurrency3.value != null && !itemcurrency3.equals(itemcurrency2))
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (flag)
                                {
                                    itemcurrency = itemcurrency3;
                                } else
                                if (itemcurrency2 != null && itemcurrency2.code != null && itemcurrency2.value != null)
                                {
                                    itemcurrency = itemcurrency2;
                                } else
                                {
                                    itemcurrency = null;
                                }
                                spannable = obj;
                                if (itemcurrency != null)
                                {
                                    spannable = getPriceSpannableAuctionWithBin(itemcurrency.code, itemcurrency1, ebayitem, flag);
                                }
                            }
                        }
                    }
                    if (spannable == null)
                    {
                        textview.setTypeface(Typeface.DEFAULT, byte0);
                        textview.setText(itemcurrency1);
                        return flag2;
                    } else
                    {
                        textview.setText(spannable);
                        return flag2;
                    }
                }
                textview.setText(null);
                return flag2;
            } while (true);
        }

        public void setItem(ViewCache viewcache, EbayItem ebayitem)
        {
            String s2 = ebayitem.imageUrl;
            String s = s2;
            if (TextUtils.isEmpty(s2))
            {
                s = s2;
                if (!TextUtils.isEmpty(ebayitem.masterImageUrl))
                {
                    s = ConstructDipUrl.constructDynamicUrl(ebayitem.masterImageUrl, "_26");
                }
            }
            viewcache.image.setRemoteImageUrl(s);
            viewcache.text.setText(ebayitem.title);
            setTimeLeft(viewcache.rightColumnText4, ebayitem.endDate, EbayResponse.currentHostTime());
            ebayitem.sellingState;
            JVM INSTR tableswitch 4 5: default 104
        //                       4 371
        //                       5 385;
               goto _L1 _L2 _L3
_L1:
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            int i = convertListingType(ebayitem);
            flag4 = false;
            flag2 = false;
            double d;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE) && (i == 3 || i == 5 || i == 6) && !TextUtils.isEmpty(ebayitem.unitPriceQuantity) && !TextUtils.isEmpty(ebayitem.unitPriceType))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag3 = flag1;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_201;
            }
            d = Double.parseDouble(ebayitem.unitPriceQuantity);
            flag3 = flag1;
            if (d <= 0.0D)
            {
                flag3 = false;
            }
_L15:
            i;
            JVM INSTR tableswitch 2 6: default 236
        //                       2 469
        //                       3 405
        //                       4 236
        //                       5 634
        //                       6 634;
               goto _L4 _L5 _L6 _L4 _L7 _L7
_L4:
            flag1 = setCurrency(viewcache.rightColumnText1, ebayitem.currentPrice, ebayitem.convertedCurrentPrice, flag3, ebayitem);
            viewcache.rightColumnText3.setText("");
            break; /* Loop/switch isn't completed */
_L2:
            viewcache.rightColumnText1.setTextColor(colorPriceSold);
              goto _L1
_L3:
            viewcache.rightColumnText1.setTextColor(colorPriceUnsold);
              goto _L1
_L6:
            if (!ebayitem.buyItNowAvailable || ebayitem.buyItNowPrice == null && ebayitem.convertedBuyItNowPrice == null || (buyingFormat & 1) != 0) goto _L5; else goto _L8
_L8:
            flag1 = setCurrency(viewcache.rightColumnText1, ebayitem.buyItNowPrice, ebayitem.convertedBuyItNowPrice, flag3, ebayitem);
            viewcache.rightColumnText3.setText(0x7f070529);
              goto _L9
_L5:
            if (flag3 && ebayitem.buyItNowAvailable && (ebayitem.buyItNowPrice != null || ebayitem.convertedBuyItNowPrice != null))
            {
                flag1 = setCurrencyWithBaseUnitPriceAuctionWithBin(viewcache.rightColumnText1, ebayitem.currentPrice, ebayitem.convertedCurrentPrice, ebayitem.buyItNowPrice, ebayitem.convertedBuyItNowPrice, flag3, ebayitem);
            } else
            {
                flag1 = setCurrency(viewcache.rightColumnText1, ebayitem.currentPrice, ebayitem.convertedCurrentPrice, false, null);
            }
            if (ebayitem.buyItNowAvailable)
            {
                viewcache.rightColumnText3.setText(getOrBuyItNowText(resources.getQuantityString(0x7f080013, ebayitem.bidCount, new Object[] {
                    Integer.valueOf(ebayitem.bidCount)
                })));
            } else
            {
                viewcache.rightColumnText3.setText(resources.getQuantityString(0x7f080013, ebayitem.bidCount, new Object[] {
                    Integer.valueOf(ebayitem.bidCount)
                }));
            }
              goto _L9
_L7:
            flag2 = flag4;
            if (ebayitem.originalRetailPrice != null)
            {
                flag2 = flag4;
                if (ebayitem.originalRetailPrice.code != null)
                {
                    flag2 = flag4;
                    if (ebayitem.originalRetailPrice.value != null)
                    {
                        flag2 = "MAP".equals(ebayitem.pricingTreatment);
                    }
                }
            }
            flag1 = setCurrency(viewcache.rightColumnText1, ebayitem.currentPrice, ebayitem.convertedCurrentPrice, flag3, ebayitem);
            viewcache.rightColumnText3.setText(0x7f070529);
_L9:
            double d1;
            int j;
            boolean flag;
            if (flag2)
            {
                viewcache.rightColumnText1.setText(0x7f0705ab);
            }
            viewcache.rightColumnText5.setVisibility(8);
            if (ebayitem.bestOfferEnabled)
            {
                viewcache.rightColumnText3.setText(binOrBestOffer);
            }
            if (ebayitem.shippingType != null && ebayitem.shippingType.equals("FreePickup") && ebayitem.shipToLocation != null && ebayitem.shipToLocation.equals("None"))
            {
                viewcache.rightColumnText2.setText(0x7f0700b7);
                viewcache.rightColumnText2.setTextColor(colorTextDefault);
                return;
            }
            if (!showShipping || ebayitem.shippingCost == null || ebayitem.shippingCost.code == null || ebayitem.shippingCost.value == null)
            {
                break MISSING_BLOCK_LABEL_919;
            }
            int k;
            try
            {
                k = colorTextDefault;
            }
            // Misplaced declaration of an exception variable
            catch (EbayItem ebayitem)
            {
                viewcache.rightColumnText2.setText("");
                return;
            }
            flag = false;
            j = 0;
            d1 = Double.parseDouble(ebayitem.shippingCost.value);
            if (d1 >= 0.01D) goto _L11; else goto _L10
_L10:
            if (!showFreeShipping) goto _L13; else goto _L12
_L12:
            k = colorShippingFree;
            viewcache.rightColumnText2.setText(0x7f070422);
_L14:
            viewcache.rightColumnText2.setTypeface(Typeface.DEFAULT, j);
            viewcache.rightColumnText2.setTextColor(k);
            return;
_L13:
            viewcache.rightColumnText2.setText("");
              goto _L14
_L11:
            String s1 = formatCurrency(d1, ebayitem.shippingCost.code);
            j = ((flag) ? 1 : 0);
            ebayitem = s1;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_908;
            }
            j = 2;
            ebayitem = (new StringBuilder()).append(s1).append(" ").toString();
            viewcache.rightColumnText2.setText(ebayitem);
              goto _L14
            viewcache.rightColumnText2.setText("");
            return;
            NumberFormatException numberformatexception;
            numberformatexception;
            flag3 = flag1;
              goto _L15
        }

        public void setTimeLeft(TextView textview, Date date, long l)
        {
            int i;
            if (date != null)
            {
                l = date.getTime() - l;
            } else
            {
                l = 0L;
            }
            if (l > 0L && l < 0x36ee80L)
            {
                i = colorTimeWarning;
            } else
            {
                i = colorTextDefault;
            }
            textview.setTextColor(i);
            if (l >= 0x757b12c00L)
            {
                textview.setText(null);
                return;
            }
            if (l > 0L)
            {
                l /= 1000L;
                int j = (int)(l % 60L);
                l /= 60L;
                int k = (int)(l % 60L);
                l /= 60L;
                int i1 = (int)(l % 24L);
                int j1 = (int)(l / 24L);
                date = new StringBuilder();
                if (j1 > 0)
                {
                    date.append(j1).append(strDays).append(' ').append(i1).append(strHours);
                } else
                if (i1 > 0)
                {
                    date.append(i1).append(strHours).append(' ').append(k).append(strMinutes);
                } else
                if (k > 0)
                {
                    date.append(k).append(strMinutes).append(' ').append(j).append(strSeconds);
                } else
                {
                    date.append(j).append(strSeconds);
                }
                textview.setText(date.toString());
                return;
            } else
            {
                textview.setText(0x7f0703c3);
                return;
            }
        }

        RecentlyViewedItemsAdapter(Activity activity, List list, Map map)
        {
            this$0 = RecentlyViewedItemsActivity.this;
            super(activity, 0x7f030074, list);
            theme = null;
            inflater = activity.getLayoutInflater();
            resources = activity.getResources();
            theme = activity.getTheme();
            eekInfoMap = map;
            colorTextDefault = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010036);
            colorShippingFree = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010036);
            colorPriceSold = resources.getColor(0x7f0d00df);
            colorPriceUnsold = resources.getColor(0x7f0d00f0);
            colorTimeWarning = resources.getColor(0x7f0d00f0);
            colorEekInfo = resources.getColor(0x7f0d00e7);
            strDays = resources.getString(0x7f070049);
            strHours = resources.getString(0x7f07004c);
            strMinutes = resources.getString(0x7f07004f);
            strSeconds = resources.getString(0x7f070052);
        }
    }


    public static final int LOADER_GET_MULTIPLE_ITEMS = 3;
    private int currentPositionY;
    private Map eekInfoMap;
    private List itemIds;
    private List items;
    private RecentlyViewedDataObserver recentlyViewedDataObserver;
    private RecentsDataManager recentsDataManager;
    private final EbayTimer timer = new EbayTimer(1000L);

    public RecentlyViewedItemsActivity()
    {
        currentPositionY = -1;
    }

    private void clearAll()
    {
        if (recentsDataManager != null)
        {
            recentsDataManager.clearRecentlyViewedItems();
        }
        findViewById(0x7f100120).setVisibility(0);
    }

    private String getEEkInfo(com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord)
    {
label0:
        {
            if (contentrecord.listings == null || contentrecord.listings.size() <= 0)
            {
                break label0;
            }
            contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)contentrecord.listings.get(0);
            if (contentrecord == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (contentrecord)).aspectValuesList == null)
            {
                break label0;
            }
            Object obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing) (contentrecord)).aspectValuesList.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                contentrecord = (com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair)((Iterator) (obj)).next();
            } while (!"EnergyEfficiencyRating".equals(((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (contentrecord)).globalIdentifier) || ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (contentrecord)).values == null || ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (contentrecord)).values.size() <= 0 || ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (contentrecord)).name == null);
            obj = ((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (contentrecord)).name.content;
            contentrecord = ((com.ebay.nautilus.domain.data.BaseCommonType.Text)((com.ebay.nautilus.domain.data.BaseCommonType.NameValuesPair) (contentrecord)).values.get(0)).content;
            return String.format(getString(0x7f07046a), new Object[] {
                obj, contentrecord
            });
        }
        return null;
    }

    private boolean isProgressOn()
    {
        View view = findViewById(0x7f100120);
        return view != null && view.getVisibility() == 0;
    }

    private void onGetMultipleItems(GetMultipleItemsNetLoader getmultipleitemsnetloader)
    {
        if (!getmultipleitemsnetloader.isError() && ((GetMultipleItemsResponse)getmultipleitemsnetloader.getResponse()).items != null)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = itemIds.iterator();
label0:
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                long l = Long.parseLong((String)iterator.next());
                Iterator iterator1 = ((GetMultipleItemsResponse)getmultipleitemsnetloader.getResponse()).items.iterator();
                EbayItem ebayitem;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    ebayitem = (EbayItem)iterator1.next();
                } while (ebayitem.id != l);
                arraylist.add(ebayitem);
            } while (true);
            items = arraylist;
            getListView().setAdapter(new RecentlyViewedItemsAdapter(this, items, eekInfoMap));
        }
        findViewById(0x7f100120).setVisibility(8);
    }

    private void refreshPds(boolean flag)
    {
label0:
        {
            if (recentsDataManager != null)
            {
                if (!flag)
                {
                    break label0;
                }
                recentsDataManager.forceRefresh();
            }
            return;
        }
        recentsDataManager.loadData(recentlyViewedDataObserver);
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final RecentlyViewedItemsActivity this$0;

            public void OnTimer()
            {
                ((RecentlyViewedItemsAdapter)getListView().getAdapter()).refresh(getListView());
            }

            
            {
                this$0 = RecentlyViewedItemsActivity.this;
                super();
            }
        });
    }

    protected final String formatCurrency(double d, String s)
    {
        return EbayCurrencyUtil.formatDisplay(s, d, 0);
    }

    protected final String formatCurrency(String s, String s1)
    {
        try
        {
            s = formatCurrency(Double.parseDouble(s), s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public String getTrackingEventName()
    {
        return "RecentItemsList";
    }

    public void onClick(View view)
    {
        if (!isProgressOn()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!Util.hasNetwork())
        {
            showNetworkErrorToast();
            return;
        }
        switch (view.getId())
        {
        default:
            view = (MyViewCache)view.getTag();
            if (view != null)
            {
                currentPositionY = getListView().getFirstVisiblePosition();
                Intent intent = new Intent();
                intent.putExtra("recently_viewed", true);
                ItemViewActivity.StartActivity(this, ((MyViewCache) (view)).itemId, com.ebay.common.ConstantsCommon.ItemKind.RecentlyViewed, intent);
                return;
            }
            break;

        case 2131756275: 
            showDialog(0x7f1004f3);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301b9);
        setTitle(getString(0x7f0708dd));
        bundle = getIntent();
        items = bundle.getParcelableArrayListExtra("my_ebay_items");
        if (items == null || items.size() == 0)
        {
            items = new ArrayList();
            findViewById(0x7f100120).setVisibility(0);
        }
        getListView().setAdapter(new RecentlyViewedItemsAdapter(this, items, eekInfoMap));
        findViewById(0x7f1004f3).setOnClickListener(this);
        if (items != null && items.size() != bundle.getIntExtra("recently_viewed_pds_count", 0))
        {
            refreshPds(false);
        }
    }

    protected Dialog onCreateDialog(final int id)
    {
        switch (id)
        {
        default:
            return null;

        case 2131756275: 
            return (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(0x7f07023a).setMessage(0x7f07025f).setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

                final RecentlyViewedItemsActivity this$0;
                final int val$id;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dismissDialog(id);
                }

            
            {
                this$0 = RecentlyViewedItemsActivity.this;
                id = i;
                super();
            }
            }).setPositiveButton(0x7f070cc7, new android.content.DialogInterface.OnClickListener() {

                final RecentlyViewedItemsActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    clearAll();
                }

            
            {
                this$0 = RecentlyViewedItemsActivity.this;
                super();
            }
            }).create();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer.initialize(UssContentsDataManager.getContentSourceKeyParams(ContentSourceEnum.RECENTLY_VIEWED_ITEMS), this);
        recentlyViewedDataObserver = new RecentlyViewedDataObserver();
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            recentsDataManager = (RecentsDataManager)datamanagercontainer.initialize(new com.ebay.mobile.recents.RecentsDataManager.KeyParams(authentication.iafToken, true), recentlyViewedDataObserver);
        }
    }

    public void onPause()
    {
        timer.stop();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        resumeUi();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }

    public void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1)
    {
        usscontentsdatamanager = content.getStatus();
        if (usscontentsdatamanager.hasError())
        {
            findViewById(0x7f100120).setVisibility(8);
            EbayErrorHandler.handleResultStatus(this, 0, usscontentsdatamanager);
            return;
        }
        if (itemIds == null)
        {
            itemIds = new ArrayList();
        } else
        {
            itemIds.clear();
        }
        if (eekInfoMap == null)
        {
            eekInfoMap = new HashMap();
        } else
        {
            eekInfoMap.clear();
        }
        usscontentsdatamanager = (Contents)content.getData();
        if (usscontentsdatamanager != null)
        {
            usscontentsdatamanager = usscontentsdatamanager.getContentGroup(ContentSourceEnum.RECENTLY_VIEWED_ITEMS);
        } else
        {
            usscontentsdatamanager = null;
        }
        if (usscontentsdatamanager != null)
        {
            usscontentsdatamanager = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (usscontentsdatamanager)).contents;
        } else
        {
            usscontentsdatamanager = null;
        }
        if (usscontentsdatamanager != null)
        {
            usscontentsdatamanager = usscontentsdatamanager.iterator();
            do
            {
                if (!usscontentsdatamanager.hasNext())
                {
                    break;
                }
                content = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)usscontentsdatamanager.next();
                itemIds.add(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (content)).id);
                String s = getEEkInfo(content);
                if (!TextUtils.isEmpty(s))
                {
                    eekInfoMap.put(Long.valueOf(Long.parseLong(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (content)).id)), s);
                }
            } while (itemIds.size() != 20);
        }
        getFwLoaderManager().start(3, new GetMultipleItemsNetLoader(getEbayContext(), EbayApiUtil.getShoppingApi(this), (String[])itemIds.toArray(new String[0]), "Details"), true);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (fwloader == null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 3 3: default 24
    //                   3 25;
           goto _L2 _L3
_L2:
        return;
_L3:
        onGetMultipleItems((GetMultipleItemsNetLoader)fwloader);
        return;
    }

    public void resumeUi()
    {
        if (currentPositionY != -1)
        {
            getListView().setSelectionFromTop(currentPositionY, 0);
        }
        setupTimer();
        timer.start();
    }


}
