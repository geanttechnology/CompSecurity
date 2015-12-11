// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.android.widget.ExpandingImageView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.net.GetImageNetLoader;
import com.ebay.common.net.api.shopping.GetMultipleItemsNetLoader;
import com.ebay.common.view.DefaultItemAdapter;
import com.ebay.common.view.ItemAdapter;
import com.ebay.common.view.ViewCache;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.shopping.GetMultipleItemsResponse;
import com.ebay.nautilus.domain.net.image.ConstructDipUrl;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseListActivity

public class RtmItemListActivity extends BaseListActivity
{
    private class RtmItemListArrayAdapter extends ArrayAdapter
    {

        private static final int layout = 0x7f030074;
        private final Bitmap bannerImage;
        private final LayoutInflater inflater;
        private final ItemAdapter itemAdapter;
        final RtmItemListActivity this$0;

        private View getBannerView(Context context)
        {
            context = new ExpandingImageView(context);
            context.setImageBitmap(bannerImage);
            return context;
        }

        public boolean areAllItemsEnabled()
        {
            return false;
        }

        public int getCount()
        {
            return super.getCount() + 1;
        }

        public EbayItem getItem(int i)
        {
            return (EbayItem)super.getItem(i - 1);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            long l1 = -1L;
            long l = l1;
            if (i != 0)
            {
                EbayItem ebayitem = getItem(i);
                l = l1;
                if (ebayitem != null)
                {
                    l = ebayitem.id;
                }
            }
            return l;
        }

        public int getItemViewType(int i)
        {
            if (i == 0)
            {
                return -1;
            } else
            {
                return super.getItemViewType(i - 1);
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (i == 0)
            {
                return getBannerView(super.getContext());
            }
            EbayItem ebayitem;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f030074, viewgroup, false);
                view = new ViewCache(viewgroup);
                viewgroup.setTag(view);
                itemAdapter.init(view);
            } else
            {
                viewgroup = view;
                view = (ViewCache)viewgroup.getTag();
            }
            ebayitem = getItem(i);
            view.object = ebayitem;
            if (ebayitem != null)
            {
                itemAdapter.setItem(view, ebayitem, i);
                return viewgroup;
            } else
            {
                ((ViewCache) (view)).image.setImageResource(0x7f0201f5);
                ((ViewCache) (view)).image.setTag(null);
                ((ViewCache) (view)).text.setText(null);
                ((ViewCache) (view)).rightColumnText1.setText(null);
                ((ViewCache) (view)).rightColumnText2.setText(null);
                ((ViewCache) (view)).rightColumnText3.setText(null);
                ((ViewCache) (view)).rightColumnText4.setText(null);
                ((ViewCache) (view)).rightColumnText5.setVisibility(8);
                ((ViewCache) (view)).imageLeaveFeedback.setVisibility(8);
                ((ViewCache) (view)).imageItemShipped.setVisibility(8);
                ((ViewCache) (view)).imageStampEnding.setVisibility(8);
                ((ViewCache) (view)).imageStampOutbid.setVisibility(8);
                ((ViewCache) (view)).imageStampPaid.setVisibility(8);
                return viewgroup;
            }
        }

        public boolean isEnabled(int i)
        {
            return i > 0;
        }

        public RtmItemListArrayAdapter(Activity activity, List list, Bitmap bitmap)
        {
            this$0 = RtmItemListActivity.this;
            super(activity, 0x7f030074, list);
            bannerImage = bitmap;
            inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
            itemAdapter = new RtmItemListItemAdapter(activity, true, true, true);
        }
    }

    private class RtmItemListItemAdapter extends DefaultItemAdapter
    {

        final RtmItemListActivity this$0;

        public void setItem(ViewCache viewcache, EbayItem ebayitem, int i)
        {
            super.setItem(viewcache, ebayitem, i);
            String s1 = ebayitem.galleryUrl;
            String s = s1;
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
            s1 = s;
            if (TextUtils.isEmpty(s))
            {
                s1 = s;
                if (!TextUtils.isEmpty(ebayitem.masterImageUrl))
                {
                    s1 = ConstructDipUrl.constructDynamicUrl(ebayitem.masterImageUrl, "_26");
                }
            }
            viewcache.image.setRemoteImageUrl(s1);
        }

        public volatile void setItem(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem, int i)
        {
            setItem(viewcache, (EbayItem)ebaysearchlistitem, i);
        }

        public volatile void setItem(ViewCache viewcache, Object obj, int i)
        {
            setItem(viewcache, (EbayItem)obj, i);
        }

        public RtmItemListItemAdapter(Activity activity, boolean flag, boolean flag1, boolean flag2)
        {
            this$0 = RtmItemListActivity.this;
            super(activity, flag, flag1, flag2);
        }
    }


    private static final String BANNER_IMAGE = "banner_image";
    private static final String BANNER_LOADING_IS_PENDING = "banner_loading_is_pending";
    public static final String BANNER_URL = "banner_url";
    private static final String EBAY_ITEMS = "ebay_items";
    private static final String EBAY_ITEMS_LOADING_IS_PENDING = "ebay_items_loading_is_pending";
    private static final int GET_IMAGE_LOADER = 1;
    private static final int GET_MULTIPLE_ITEMS_LOADER = 2;
    private static final int GET_MULTIPLE_ITEMS_LOADER_MAX_ITEMS = 20;
    public static final String ITEM_IDS = "item_ids";
    private static final String NEXT_ITEM_IDS_END_INDEX = "next_item_ids_end_index";
    private static final String NEXT_ITEM_IDS_START_INDEX = "next_item_ids_start_index";
    public static final String TITLE = "title";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private Bitmap bannerImage;
    private boolean bannerLoadingIsPending;
    private String bannerUrl;
    private ArrayList ebayItems;
    private boolean ebayItemsLoadingIsPending;
    private ArrayList itemIds;
    private int nextItemIdsEndIndex;
    private int nextItemIdsStartIndex;
    private String title;

    public RtmItemListActivity()
    {
        title = null;
        bannerUrl = null;
        itemIds = null;
        ebayItems = null;
        bannerImage = null;
        bannerLoadingIsPending = false;
        ebayItemsLoadingIsPending = false;
        nextItemIdsStartIndex = 0;
        nextItemIdsEndIndex = 0;
    }

    private void fetchEbayItemsForItemIds(ArrayList arraylist)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                Integer.valueOf(nextItemIdsStartIndex), Integer.valueOf(nextItemIdsEndIndex)
            });
        }
        ebayItemsLoadingIsPending = true;
        Object obj = arraylist.subList(nextItemIdsStartIndex, nextItemIdsEndIndex);
        obj = new GetMultipleItemsNetLoader(getEbayContext(), EbayApiUtil.getShoppingApi(this), (String[])((List) (obj)).toArray(new String[((List) (obj)).size()]), "Details,ShippingCosts");
        getFwLoaderManager().start(2, ((FwLoader) (obj)), true);
        nextItemIdsStartIndex = nextItemIdsEndIndex;
        nextItemIdsEndIndex = Math.min(nextItemIdsStartIndex + 20, arraylist.size());
    }

    private void onGetImage(GetImageNetLoader getimagenetloader)
    {
        this;
        JVM INSTR monitorenter ;
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                getimagenetloader
            });
        }
        if (getimagenetloader.isError()) goto _L2; else goto _L1
_L1:
        bannerImage = getimagenetloader.getBitmap();
        if (bannerImage == null) goto _L4; else goto _L3
_L3:
        if (!debugLogger.isLoggable) goto _L6; else goto _L5
_L5:
        debugLogger.log("Retrieved bannerImage from network");
_L4:
        bannerLoadingIsPending = false;
        updateUI();
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (!debugLogger.isLoggable) goto _L4; else goto _L7
_L7:
        debugLogger.log("Failed to retrieve bannerImage from network. Probably doesn't exist");
          goto _L4
        getimagenetloader;
        throw getimagenetloader;
_L2:
        if (!debugLogger.isLoggable) goto _L4; else goto _L8
_L8:
        debugLogger.log((new StringBuilder()).append("Error while retrieving bannerImage: ").append(getimagenetloader.getException()).toString());
          goto _L4
    }

    private void onGetMultipleItems(GetMultipleItemsNetLoader getmultipleitemsnetloader)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                getmultipleitemsnetloader
            });
        }
        obj = (GetMultipleItemsResponse)getmultipleitemsnetloader.getResponse();
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (getmultipleitemsnetloader.isError())
        {
            if (((GetMultipleItemsResponse) (obj)).ackCode == -2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = true;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Retrieved ebayItems from network");
        }
        if (((GetMultipleItemsResponse) (obj)).items == null) goto _L6; else goto _L5
_L5:
        ebayItems.addAll(((GetMultipleItemsResponse) (obj)).items);
_L8:
        if (nextItemIdsEndIndex <= nextItemIdsStartIndex)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        fetchEbayItemsForItemIds(itemIds);
_L16:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (!debugLogger.isLoggable) goto _L8; else goto _L7
_L7:
        debugLogger.log("GetMultipleItems didn't return any items");
          goto _L8
        getmultipleitemsnetloader;
        throw getmultipleitemsnetloader;
_L4:
        if (!debugLogger.isLoggable) goto _L8; else goto _L9
_L9:
        obj = "Unknown";
        Object obj1 = getmultipleitemsnetloader.getException();
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        getmultipleitemsnetloader = ((IOException) (obj1)).toString();
_L13:
        debugLogger.log((new StringBuilder()).append("Error while retrieving ebayItems: ").append(getmultipleitemsnetloader).toString());
          goto _L8
_L11:
        obj1 = getmultipleitemsnetloader.getServiceErrorsAndWarnings();
        getmultipleitemsnetloader = ((GetMultipleItemsNetLoader) (obj));
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        getmultipleitemsnetloader = ((GetMultipleItemsNetLoader) (obj));
        if (((List) (obj1)).isEmpty()) goto _L13; else goto _L14
_L14:
        getmultipleitemsnetloader = ((EbayResponseError)((List) (obj1)).get(0)).toString();
          goto _L13
_L2:
        if (!debugLogger.isLoggable) goto _L8; else goto _L15
_L15:
        debugLogger.log("GetMultipleItems didn't return a response");
          goto _L8
        ebayItemsLoadingIsPending = false;
        updateUI();
          goto _L16
    }

    private void updateUI()
    {
        this;
        JVM INSTR monitorenter ;
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        if (bannerLoadingIsPending || ebayItemsLoadingIsPending) goto _L2; else goto _L1
_L1:
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Both loaders are done.");
        }
        setTitle(title);
        if (ebayItems == null) goto _L4; else goto _L3
_L3:
        if (getListAdapter() == null)
        {
            setListAdapter(new RtmItemListArrayAdapter(this, ebayItems, bannerImage));
        }
_L6:
        findViewById(0x7f1001dc).setVisibility(0);
        findViewById(0x7f100120).setVisibility(8);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!debugLogger.isLoggable) goto _L6; else goto _L5
_L5:
        debugLogger.log("ebayItems is null");
          goto _L6
        Exception exception;
        exception;
        throw exception;
    }

    public String getTrackingEventName()
    {
        return "RTMItemList";
    }

    protected void onCreate(Bundle bundle)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                bundle
            });
        }
        super.onCreate(bundle);
        setContentView(0x7f0301c3);
        if (bundle != null)
        {
            title = bundle.getString("title");
            bannerUrl = bundle.getString("banner_url");
            bannerImage = (Bitmap)bundle.getParcelable("banner_image");
            itemIds = bundle.getStringArrayList("item_ids");
            ebayItems = bundle.getParcelableArrayList("ebay_items");
            bannerLoadingIsPending = bundle.getBoolean("banner_loading_is_pending");
            ebayItemsLoadingIsPending = bundle.getBoolean("ebay_items_loading_is_pending");
            nextItemIdsStartIndex = bundle.getInt("next_item_ids_start_index");
            nextItemIdsEndIndex = bundle.getInt("next_item_ids_end_index");
        } else
        {
            bundle = getIntent();
            title = bundle.getStringExtra("title");
            bannerUrl = bundle.getStringExtra("banner_url");
            itemIds = bundle.getStringArrayListExtra("item_ids");
        }
        bundle = findViewById(0x7f1003ab);
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final RtmItemListActivity this$0;

                public void onClick(View view)
                {
                    finish();
                }

            
            {
                this$0 = RtmItemListActivity.this;
                super();
            }
            });
        }
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                listview, view, Integer.valueOf(i), Long.valueOf(l)
            });
        }
        super.onListItemClick(listview, view, i, l);
        ItemViewActivity.StartActivity(this, ((EbaySearchListItem)listview.getItemAtPosition(i)).id, com.ebay.common.ConstantsCommon.ItemKind.Found);
    }

    protected void onResume()
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        super.onResume();
        if (bannerImage == null || ebayItems == null || ebayItemsLoadingIsPending) goto _L2; else goto _L1
_L1:
        updateUI();
_L10:
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        return;
_L2:
        setTitle(0x7f070264);
        findViewById(0x7f1001dc).setVisibility(8);
        findViewById(0x7f100120).setVisibility(0);
        if (bannerImage != null) goto _L4; else goto _L3
_L3:
        if (bannerUrl == null) goto _L6; else goto _L5
_L5:
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("Fetching banner image at: ").append(bannerUrl).toString());
        }
        try
        {
            bannerLoadingIsPending = true;
            GetImageNetLoader getimagenetloader = new GetImageNetLoader(getEbayContext(), new URL(bannerUrl));
            getFwLoaderManager().start(1, getimagenetloader, true);
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
        }
_L8:
        if (ebayItems != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (itemIds != null && !itemIds.isEmpty())
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log((new StringBuilder()).append("Fetching ebay items for: ").append(itemIds).toString());
            }
            ebayItems = new ArrayList();
            nextItemIdsEndIndex = Math.min(20, itemIds.size());
            fetchEbayItemsForItemIds(itemIds);
        } else
        if (debugLogger.isLoggable)
        {
            debugLogger.log("itemIds is null");
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (debugLogger.isLoggable)
        {
            debugLogger.log("bannerUrl is null");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Already have bannerImage");
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Already have ebayItems");
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                bundle
            });
        }
        super.onSaveInstanceState(bundle);
        bundle.putString("banner_url", bannerUrl);
        bundle.putParcelable("banner_image", bannerImage);
        bundle.putStringArrayList("item_ids", itemIds);
        bundle.putParcelableArrayList("ebay_items", ebayItems);
        bundle.putBoolean("banner_loading_is_pending", bannerLoadingIsPending);
        bundle.putBoolean("ebay_items_loading_is_pending", ebayItemsLoadingIsPending);
        bundle.putInt("next_item_ids_start_index", nextItemIdsStartIndex);
        bundle.putInt("next_item_ids_end_index", nextItemIdsEndIndex);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                Integer.valueOf(i), fwloader
            });
        }
        if (fwloader == null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 2: default 56
    //                   1 57
    //                   2 66;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        onGetImage((GetImageNetLoader)fwloader);
        return;
_L4:
        onGetMultipleItems((GetMultipleItemsNetLoader)fwloader);
        return;
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("RtmItemList", 3, "Log RTM ItemList events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended RTM ItemList events");
    }
}
