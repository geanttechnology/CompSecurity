// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.PagedListingAdapter;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.barcodeSearch.BarcodeSearchController;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

public class BarcodeSearchResultsAdapter extends PagedListingAdapter
    implements android.widget.AdapterView.OnItemClickListener
{

    private final Activity mActivity;
    private final BarcodeSearchController mBarcodeSearchController;
    private final ClickStreamTag mClickStreamOrigin;
    private final LayoutInflater mLayoutInflater;
    private ListView mListView;
    protected final int mSearchResultItemResId;

    public BarcodeSearchResultsAdapter(AmazonActivity amazonactivity, int i, BarcodeSearchController barcodesearchcontroller, String s)
    {
        super(amazonactivity);
        mSearchResultItemResId = i;
        mBarcodeSearchController = barcodesearchcontroller;
        mActivity = amazonactivity;
        mLayoutInflater = LayoutInflater.from(mActivity);
        mClickStreamOrigin = new ClickStreamTag(s);
    }

    private View getAndUpdateItemView(int i, View view, SearchResult searchresult)
    {
        Object obj;
        Bitmap bitmap;
        String s;
        if (view == null)
        {
            view = (ItemView)mLayoutInflater.inflate(mSearchResultItemResId, null);
            view.setIsGetImageFromURL(true);
        } else
        {
            view = (ItemView)view;
        }
        s = ImageUtil.getImageUrl(searchresult.getBasicProduct().getImageUrl(), mActivity.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.item_row_height));
        bitmap = (Bitmap)LRUCache.getValue(s, android/graphics/Bitmap);
        obj = null;
        if (bitmap != null)
        {
            obj = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(s, null);
            obj = DrawableFactory.getInstance().createDrawable(mActivity.getResources(), bitmap, ((com.amazon.mShop.net.HttpFetcher.Params) (obj)));
        }
        view.update(this, searchresult, ((android.graphics.drawable.Drawable) (obj)), i);
        return view;
    }

    public int getCount()
    {
        int i = 0;
        boolean flag = false;
        int k = mBarcodeSearchController.getBarcodeSearchResultType();
        if (k == 1)
        {
            i = ((flag) ? 1 : 0);
            if (super.getCount() > 0)
            {
                i = super.getCount() + 1;
            }
            return i + 2;
        }
        if (k == 2)
        {
            int j = super.getCount();
            if (mBarcodeSearchController.getBarcodeSearchStatus() == 2)
            {
                i = 1;
            }
            return j + i;
        } else
        {
            return super.getCount();
        }
    }

    public int getItemViewType(int i)
    {
        int j = mBarcodeSearchController.getBarcodeSearchResultType();
        if (j != 1) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        return 0;
_L4:
        if (i == 1)
        {
            return 1;
        }
        if (super.getCount() > 0 && i == 2)
        {
            return 2;
        }
        if (super.getCount() > 0 && i >= 3)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        return -1;
_L2:
        if (j != 2) goto _L6; else goto _L5
_L5:
        if (i >= browser.getReceivedCount())
        {
            return 1;
        }
        if (true) goto _L3; else goto _L7
_L7:
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        int j;
        obj = null;
        j = mBarcodeSearchController.getBarcodeSearchResultType();
        if (j != 1) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        viewgroup = getAndUpdateItemView(i, view, mBarcodeSearchController.getMatchItemSearchResult());
_L6:
        return viewgroup;
_L4:
        if (i == 1)
        {
            view = (ViewGroup)mLayoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.barcode_search_results_view_no_match_row, null);
            viewgroup = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.barcode_search_results_view_not_match_hint);
            viewgroup.setText((new StringBuilder()).append(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match_prompt)).append(" ").append(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match)).toString());
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final BarcodeSearchResultsAdapter this$0;

                public void onClick(View view1)
                {
                    mBarcodeSearchController.reportMismatch();
                    view1 = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).setMessage(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match_acknowledgement));
                    android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    };
                    view1.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
                    view1.create().show();
                }

            
            {
                this$0 = BarcodeSearchResultsAdapter.this;
                super();
            }
            });
            return view;
        }
        if (super.getCount() > 0 && i == 2)
        {
            view = (LinearLayout)mLayoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.search_results_view_title_row, null, false);
            view.setBackgroundResource(com.amazon.mShop.android.lib.R.color.blue_dark);
            ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.search_results_view_group_title)).setText(mBarcodeSearchController.getResultsTitle());
            return view;
        }
        viewgroup = obj;
        if (super.getCount() > 0)
        {
            viewgroup = obj;
            if (i >= 3)
            {
                i -= 3;
                browser.setCurrentIndex(i);
                return getAndUpdateItemView(i, view, (SearchResult)browser.getObjectAtIndex(i));
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        viewgroup = obj;
        if (j == 2)
        {
            if (i < browser.getReceivedCount())
            {
                browser.setCurrentIndex(i);
                return getAndUpdateItemView(i, view, (SearchResult)browser.getObjectAtIndex(i));
            } else
            {
                view = (ViewGroup)mLayoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.barcode_search_results_view_no_match_row, null);
                viewgroup = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.barcode_search_results_view_not_match_hint);
                viewgroup.setText((new StringBuilder()).append(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match_prompt)).append(" ").append(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match)).toString());
                viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                    final BarcodeSearchResultsAdapter this$0;

                    public void onClick(View view1)
                    {
                        mBarcodeSearchController.reportMismatch();
                        view1 = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).setMessage(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_bad_match_acknowledgement));
                        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        };
                        view1.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
                        view1.create().show();
                    }

            
            {
                this$0 = BarcodeSearchResultsAdapter.this;
                super();
            }
                });
                return view;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    public boolean isEnabled(int i)
    {
        if (mBarcodeSearchController.getBarcodeSearchResultType() == 1 && super.getCount() > 0 && i == 2)
        {
            return false;
        } else
        {
            return super.isEnabled(i);
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j = mBarcodeSearchController.getBarcodeSearchResultType();
        if (j != 1) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        getAmazonActivity().forward(new ProductController(mBarcodeSearchController.getMatchItemSearchResult(), mClickStreamOrigin));
        RefMarkerObserver.logRefMarker("sr_scan_pd");
        RefMarkerObserver.logRefMarker("scan_first_dp");
_L6:
        return;
_L4:
        if (super.getCount() > 0 && i >= 3)
        {
            browser.setCurrentIndex(i - 3);
            getAmazonActivity().forward(new ProductController(browser.getCurrentObject(), mClickStreamOrigin));
            RefMarkerObserver.logRefMarker("sr_scan_pd");
            RefMarkerObserver.logRefMarker("scan_other_dp");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == 2 && i < browser.getReceivedCount())
        {
            browser.setCurrentIndex(i);
            getAmazonActivity().forward(new ProductController(browser.getCurrentObject(), mClickStreamOrigin));
            RefMarkerObserver.logRefMarker("sr_scan_pd");
            if (i == 0)
            {
                adapterview = "scan_first_dp";
            } else
            {
                adapterview = "scan_other_dp";
            }
            RefMarkerObserver.logRefMarker(adapterview);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setListView(ListView listview)
    {
        mListView = listview;
        listview.setAdapter(this);
        listview.setOnItemClickListener(this);
    }


}
