// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.CompactListing;
import com.ebay.nautilus.domain.data.Merchandise;
import com.ebay.nautilus.domain.data.Placement;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.CommonLangUtils;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseDataManager

public class MerchandiseFragment extends BaseFragment
    implements MerchandiseDataManager.Observer
{

    public static final String EXTRA_FRAGMENT_TAG = "com.ebay.mobile.merch.MerchandiseFragment.fragmentTag";
    public static final String EXTRA_INITIAL_ITEMS_SHOWN = "com.ebay.mobile.merch.MerchandiseFragment.initialItemsShown";
    public static final String EXTRA_IS_EXPANDED = "com.ebay.mobile.merch.MerchandiseFragment.isExpanded";
    public static final String EXTRA_IS_TRANSACTED = "com.ebay.mobile.merch.MerchandiseFragment.isTransacted";
    public static final String EXTRA_ITEM_IDS = "com.ebay.mobile.merch.MerchandiseFragment.itemIds";
    public static final String EXTRA_PLACEMENT_ID = "com.ebay.mobile.merch.MerchandiseFragment.placementId";
    public static final String EXTRA_TRANSIENT_CACHE = "com.ebay.mobile.merch.MerchandiseFragment.transientCache";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo LOG_TAG = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("merchandiseFragment", 3, "MerchandiseFragment lifeCycle");
    private String fragmentTag;
    private int initialItemsShown;
    private boolean isExpanded;
    private boolean isTransacted;
    private long itemIds[];
    private MerchandiseDataManager merchandiseDataManager;
    private long placementId;
    private Merchandise transientCache;
    private com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlRewriterType;

    public MerchandiseFragment()
    {
    }

    public static MerchandiseFragment attach(Activity activity, String s, int i, long l, long al[], boolean flag)
    {
        Object obj = activity.getFragmentManager();
        MerchandiseFragment merchandisefragment = (MerchandiseFragment)((FragmentManager) (obj)).findFragmentByTag(s);
        activity = merchandisefragment;
        if (merchandisefragment == null)
        {
            FragmentTransaction fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
            activity = new MerchandiseFragment();
            obj = new Bundle();
            ((Bundle) (obj)).putLong("com.ebay.mobile.merch.MerchandiseFragment.placementId", l);
            ((Bundle) (obj)).putInt("com.ebay.mobile.merch.MerchandiseFragment.initialItemsShown", 6);
            ((Bundle) (obj)).putString("com.ebay.mobile.merch.MerchandiseFragment.fragmentTag", s);
            if (al != null)
            {
                ((Bundle) (obj)).putLongArray("com.ebay.mobile.merch.MerchandiseFragment.itemIds", al);
            }
            ((Bundle) (obj)).putBoolean("com.ebay.mobile.merch.MerchandiseFragment.isTransacted", flag);
            activity.setArguments(((Bundle) (obj)));
            fragmenttransaction.add(i, activity, s);
            fragmenttransaction.commit();
        }
        return activity;
    }

    private android.widget.GridLayout.LayoutParams getLayoutParams(int i, int j, int k, int l)
    {
        int i1 = l % j;
        j = l / j;
        android.widget.GridLayout.LayoutParams layoutparams = new android.widget.GridLayout.LayoutParams();
        if (i1 > 0)
        {
            layoutparams.leftMargin = i;
        }
        layoutparams.bottomMargin = i;
        layoutparams.width = k;
        layoutparams.height = -2;
        layoutparams.columnSpec = GridLayout.spec(i1);
        layoutparams.rowSpec = GridLayout.spec(j);
        return layoutparams;
    }

    private View inflateMerchandiseItem(LayoutInflater layoutinflater, final CompactListing item)
    {
        int i = 0;
        layoutinflater = layoutinflater.inflate(0x7f030159, null);
        RemoteImageView remoteimageview = (RemoteImageView)layoutinflater.findViewById(0x7f10005b);
        Object obj = (TextView)layoutinflater.findViewById(0x7f10005f);
        TextView textview = (TextView)layoutinflater.findViewById(0x7f1001b8);
        TextView textview1 = (TextView)layoutinflater.findViewById(0x7f100374);
        TextView textview2 = (TextView)layoutinflater.findViewById(0x7f100373);
        ((TextView) (obj)).setText(item.title.getSourceContent());
        obj = item.getPrimaryImageUrl();
        remoteimageview.setUrlRewriter(urlRewriterType);
        if (obj != null && !((String) (obj)).isEmpty())
        {
            remoteimageview.setRemoteImageUrl(((String) (obj)));
        } else
        {
            remoteimageview.setImageResource(0x7f0201f5);
        }
        if (item.lowestFixedPrice != null)
        {
            textview.setText(EbayCurrencyUtil.formatDisplay(item.lowestFixedPrice.getAmount(), 2));
        } else
        if (item.currentBidPrice != null)
        {
            textview.setText(EbayCurrencyUtil.formatDisplay(item.currentBidPrice.getAmount(), 2));
        }
        if (textview1 != null && com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(item.format))
        {
            textview1.setText(getResources().getQuantityString(0x7f08001b, item.bidCount, new Object[] {
                Integer.valueOf(item.bidCount)
            }));
        }
        if (textview2 != null)
        {
            if (!item.freeShippingAvailable)
            {
                i = 4;
            }
            textview2.setVisibility(i);
        }
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final MerchandiseFragment this$0;
            final CompactListing val$item;

            public void onClick(View view)
            {
                view = new TrackingData("MerchItemSelected", TrackingType.EVENT);
                view.addKeyValuePair("svcdata", item.serverSideTrackingInfo);
                view.send(getActivity());
                long l = NumberUtil.safeParseLong(item.listingId, -1L);
                if (l != -1L)
                {
                    view = new SourceIdentification("MerchItemSelected");
                    Intent intent = new Intent();
                    intent.putExtra("com.ebay.mobile.analytics.sid", view);
                    ItemViewActivity.StartActivity(getActivity(), l, com.ebay.common.ConstantsCommon.ItemKind.Deals, intent);
                }
            }

            
            {
                this$0 = MerchandiseFragment.this;
                item = compactlisting;
                super();
            }
        });
        return layoutinflater;
    }

    private boolean isValidInput()
    {
        return placementId > 0L && itemIds != null;
    }

    private final void render(Merchandise merchandise, View view)
    {
        final GridLayout gridLayout = (GridLayout)view.findViewById(0x7f100372);
        TextView textview = (TextView)view.findViewById(0x7f100371);
        merchandise = merchandise.itemsByPlacement.entrySet().iterator();
        do
        {
            if (!merchandise.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)merchandise.next();
            if (((Placement)entry.getKey()).placementId == placementId && !((List)entry.getValue()).isEmpty())
            {
                final List items = (List)entry.getValue();
                final int itemsInCollection = items.size();
                final int itemsShown;
                if (isExpanded || initialItemsShown < 0)
                {
                    itemsShown = itemsInCollection;
                } else
                {
                    itemsShown = Math.min(initialItemsShown, itemsInCollection);
                }
                if (gridLayout != null)
                {
                    final LayoutInflater inflater = LayoutInflater.from(getActivity());
                    final int margin = getActivity().getResources().getDimensionPixelSize(0x7f090072);
                    int i = gridLayout.getWidth();
                    final int itemsPerRow = Math.max(1, gridLayout.getColumnCount());
                    final int itemWidth = i / itemsPerRow - (margin / itemsPerRow) * (itemsPerRow - 1);
                    gridLayout.removeAllViews();
                    for (i = 0; i < itemsShown; i++)
                    {
                        gridLayout.addView(inflateMerchandiseItem(inflater, (CompactListing)items.get(i)), getLayoutParams(margin, itemsPerRow, itemWidth, i));
                    }

                    final Button showMoreButton = (Button)view.findViewById(0x7f10029c);
                    if (showMoreButton != null)
                    {
                        if (itemsShown < itemsInCollection)
                        {
                            i = 0;
                        } else
                        {
                            i = 8;
                        }
                        showMoreButton.setVisibility(i);
                        showMoreButton.setOnClickListener(new android.view.View.OnClickListener() {

                            final MerchandiseFragment this$0;
                            final GridLayout val$gridLayout;
                            final LayoutInflater val$inflater;
                            final int val$itemWidth;
                            final List val$items;
                            final int val$itemsInCollection;
                            final int val$itemsPerRow;
                            final int val$itemsShown;
                            final int val$margin;
                            final Button val$showMoreButton;

                            public void onClick(View view1)
                            {
                                for (int j = itemsShown; j < itemsInCollection; j++)
                                {
                                    gridLayout.addView(inflateMerchandiseItem(inflater, (CompactListing)items.get(j)), getLayoutParams(margin, itemsPerRow, itemWidth, j));
                                }

                                isExpanded = true;
                                showMoreButton.setVisibility(8);
                            }

            
            {
                this$0 = MerchandiseFragment.this;
                itemsShown = i;
                itemsInCollection = j;
                gridLayout = gridlayout;
                inflater = layoutinflater;
                items = list;
                margin = k;
                itemsPerRow = l;
                itemWidth = i1;
                showMoreButton = button;
                super();
            }
                        });
                    }
                    if (itemsShown > 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 4;
                    }
                    gridLayout.setVisibility(i);
                }
                if (textview != null)
                {
                    textview.setText(((Placement)entry.getKey()).caption);
                    if (itemsShown > 0)
                    {
                        itemsShown = 0;
                    } else
                    {
                        itemsShown = 8;
                    }
                    textview.setVisibility(itemsShown);
                }
            }
        } while (true);
        view.setVisibility(gridLayout.getVisibility());
        merchandise = (ViewGroup)view.getParent();
        if (merchandise != null)
        {
            merchandise.setVisibility(gridLayout.getVisibility());
        }
    }

    public transient void loadMerchandise(boolean flag, long al[])
    {
        itemIds = al;
        isTransacted = flag;
        if (isResumed() && isValidInput())
        {
            merchandiseDataManager.getMerchandise(Arrays.asList(new Long[] {
                Long.valueOf(placementId)
            }), CommonLangUtils.arrayToList(itemIds), flag, this);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        urlRewriterType = com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType.from(DeviceConfiguration.getAsync().get(DcsNautilusString.MerchandiseImageRewriterType));
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (bundle != null)
        {
            placementId = bundle.getLong("com.ebay.mobile.merch.MerchandiseFragment.placementId", -1L);
            initialItemsShown = bundle.getInt("com.ebay.mobile.merch.MerchandiseFragment.initialItemsShown", -1);
            transientCache = (Merchandise)bundle.getParcelable("com.ebay.mobile.merch.MerchandiseFragment.transientCache");
            itemIds = bundle.getLongArray("com.ebay.mobile.merch.MerchandiseFragment.itemIds");
            fragmentTag = bundle.getString("com.ebay.mobile.merch.MerchandiseFragment.fragmentTag");
            isExpanded = bundle.getBoolean("com.ebay.mobile.merch.MerchandiseFragment.isExpanded", false);
            isTransacted = bundle.getBoolean("com.ebay.mobile.merch.MerchandiseFragment.isTransacted", false);
        } else
        {
            bundle = getArguments();
            placementId = bundle.getLong("com.ebay.mobile.merch.MerchandiseFragment.placementId", -1L);
            initialItemsShown = bundle.getInt("com.ebay.mobile.merch.MerchandiseFragment.initialItemsShown", -1);
            itemIds = bundle.getLongArray("com.ebay.mobile.merch.MerchandiseFragment.itemIds");
            fragmentTag = bundle.getString("com.ebay.mobile.merch.MerchandiseFragment.fragmentTag");
            isExpanded = bundle.getBoolean("com.ebay.mobile.merch.MerchandiseFragment.isExpanded", false);
            isTransacted = bundle.getBoolean("com.ebay.mobile.merch.MerchandiseFragment.isTransacted", false);
        }
        return layoutinflater.inflate(0x7f030158, viewgroup, false);
    }

    public void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        merchandiseDataManager = (MerchandiseDataManager)datamanagercontainer.initialize(MerchandiseDataManager.KEY, null);
    }

    public void onMerchandiseLoaded(MerchandiseDataManager merchandisedatamanager, Content content)
    {
        if (!content.getStatus().hasError() && content.getData() != null)
        {
            transientCache = (Merchandise)content.getData();
            render(transientCache, getView());
            return;
        } else
        {
            getView().setVisibility(8);
            return;
        }
    }

    public void onMerchandiseLoading(MerchandiseDataManager merchandisedatamanager)
    {
    }

    public void onPause()
    {
        if (merchandiseDataManager != null)
        {
            merchandiseDataManager.unregisterObserver(this);
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (merchandiseDataManager != null)
        {
            merchandiseDataManager.registerObserver(this);
            if (transientCache != null)
            {
                getView().getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final MerchandiseFragment this$0;

                    public void onGlobalLayout()
                    {
                        ViewTreeObserver viewtreeobserver = getView().getViewTreeObserver();
                        if (viewtreeobserver.isAlive())
                        {
                            viewtreeobserver.removeOnGlobalLayoutListener(this);
                            render(transientCache, getView());
                        }
                    }

            
            {
                this$0 = MerchandiseFragment.this;
                super();
            }
                });
            } else
            if (isValidInput())
            {
                merchandiseDataManager.getMerchandise(Arrays.asList(new Long[] {
                    Long.valueOf(placementId)
                }), CommonLangUtils.arrayToList(itemIds), isTransacted, this);
                return;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putLong("com.ebay.mobile.merch.MerchandiseFragment.placementId", placementId);
        bundle.putInt("com.ebay.mobile.merch.MerchandiseFragment.initialItemsShown", initialItemsShown);
        bundle.putParcelable("com.ebay.mobile.merch.MerchandiseFragment.transientCache", transientCache);
        bundle.putLongArray("com.ebay.mobile.merch.MerchandiseFragment.itemIds", itemIds);
        bundle.putString("com.ebay.mobile.merch.MerchandiseFragment.fragmentTag", fragmentTag);
        bundle.putBoolean("com.ebay.mobile.merch.MerchandiseFragment.isExpanded", isExpanded);
        bundle.putBoolean("com.ebay.mobile.merch.MerchandiseFragment.isTransacted", isTransacted);
        super.onSaveInstanceState(bundle);
    }

    public void onStop()
    {
        Object obj = getView();
        if (obj != null)
        {
            obj = (GridLayout)((View) (obj)).findViewById(0x7f100372);
            if (obj != null)
            {
                ((GridLayout) (obj)).removeAllViews();
            }
        }
        super.onStop();
    }

    public void updatePlacementId(long l)
    {
        placementId = l;
    }







/*
    static boolean access$402(MerchandiseFragment merchandisefragment, boolean flag)
    {
        merchandisefragment.isExpanded = flag;
        return flag;
    }

*/
}
