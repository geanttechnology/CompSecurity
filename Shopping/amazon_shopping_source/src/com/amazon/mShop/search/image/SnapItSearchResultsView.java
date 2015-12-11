// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.image;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.NonPagedItemAdapter;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.search.image.ImageSearchController;
import com.amazon.mShop.control.search.image.ImageSearchSubscriber;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.NoMatchSearchResultsView;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.mShop.ui.WeakReferenceBitmapDrawable;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.EmailComposer;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

// Referenced classes of package com.amazon.mShop.search.image:
//            SnapItActivity

public class SnapItSearchResultsView extends ListView
    implements TitleProvider, ImageSearchSubscriber
{
    protected class SnapItSearchResultAdapter extends NonPagedItemAdapter
    {

        final SnapItSearchResultsView this$0;

        private byte[] convertDrawableIntoByteArray(Drawable drawable)
        {
            Bitmap bitmap = null;
            if (drawable instanceof WeakReferenceBitmapDrawable)
            {
                bitmap = ((WeakReferenceBitmapDrawable)drawable).getBitmap();
            } else
            if (drawable instanceof BitmapDrawable)
            {
                bitmap = ((BitmapDrawable)drawable).getBitmap();
            }
            if (bitmap != null)
            {
                drawable = new ByteArrayOutputStream();
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, drawable);
                return drawable.toByteArray();
            } else
            {
                return null;
            }
        }

        public int getCount()
        {
            return mImageSearchController.count();
        }

        public Object getItem(int i)
        {
            return mImageSearchController.getSearchResult(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            SearchResult searchresult;
            Bitmap bitmap;
            String s;
            if (view == null)
            {
                view = (ItemView)mLayoutInflater.inflate(mRowResId, null);
            } else
            {
                view = (ItemView)view;
            }
            view.setIsGetImageFromURL(true);
            searchresult = (SearchResult)getItem(i);
            s = ImageUtil.getImageUrl(searchresult.getBasicProduct().getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.item_row_height));
            bitmap = (Bitmap)LRUCache.getValue(s, android/graphics/Bitmap);
            viewgroup = null;
            if (bitmap != null)
            {
                viewgroup = new com.amazon.mShop.net.BitmapFetcher.BitmapFetcherParams(s, null);
                viewgroup = DrawableFactory.getInstance().createDrawable(getResources(), bitmap, viewgroup);
            }
            view.update(this, searchresult, viewgroup, i);
            return view;
        }

        protected Object makeObjectForForward(int i, View view)
        {
            ProductController productcontroller = new ProductController((SearchResult)getItem(i));
            productcontroller.setClickStreamTag(ClickStreamTag.ORIGIN_SNAP_TELL);
            view = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.item_row_image);
            if (view != null)
            {
                productcontroller.setThumbnail(convertDrawableIntoByteArray(view.getDrawable()));
            }
            RefMarkerObserver.logRefMarker("sr_snap_pd");
            return productcontroller;
        }

        public void setListView(ListView listview)
        {
            setAdapterView(listview);
        }

        public SnapItSearchResultAdapter(AmazonActivity amazonactivity, int i)
        {
            this$0 = SnapItSearchResultsView.this;
            super(amazonactivity, i);
        }
    }


    private final SnapItSearchResultAdapter mAdapter;
    private final AmazonActivity mAmazonActivity;
    private final View mFooter;
    private final ImageSearchController mImageSearchController = new ImageSearchController(this);
    private byte mResizedImage[];
    private final TextView mStatus;

    public SnapItSearchResultsView(AmazonActivity amazonactivity)
    {
        super(amazonactivity);
        mAmazonActivity = amazonactivity;
        mFooter = inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.search_results_footer, null);
        mStatus = (TextView)mFooter.findViewById(com.amazon.mShop.android.lib.R.id.search_results_status);
        mStatus.setText(getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_searching_for));
        addFooterView(mFooter);
        setItemsCanFocus(true);
        mResizedImage = compressImangeForImageSearch();
        setFooterDividersEnabled(false);
        mAdapter = new SnapItSearchResultAdapter(amazonactivity, com.amazon.mShop.android.lib.R.layout.item_row);
        mAdapter.setListView(this);
    }

    private byte[] compressImangeForImageSearch()
    {
        if (Util.isEmpty(SnapItActivity.getLastPhotoCapturedOriginal()))
        {
            ActivityUtils.startHomeActivity(mAmazonActivity);
            ((Activity)getContext()).finish();
            return null;
        } else
        {
            Bitmap bitmap = BitmapFactory.decodeByteArray(SnapItActivity.getLastPhotoCapturedOriginal(), 0, SnapItActivity.getLastPhotoCapturedOriginal().length);
            Object obj = new Matrix();
            ((Matrix) (obj)).postRotate(SnapItActivity.getLastKnownOrientation() + 90);
            bitmap = Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true), 360, 480, false);
            obj = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj)));
            return ((ByteArrayOutputStream) (obj)).toByteArray();
        }
    }

    protected View getMismatchFooter()
    {
        View view = inflate(getContext(), com.amazon.mShop.android.lib.R.layout.snapit_search_results_view_report_bad_match_row, null);
        TextView textview = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.snapit_search_results_view_not_match_hint);
        textview.setText((new StringBuilder()).append(getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_prompt)).append(" ").append(getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_button)).toString());
        textview.setOnClickListener(new android.view.View.OnClickListener() {

            final SnapItSearchResultsView this$0;

            public void onClick(View view1)
            {
                reportMismatch();
            }

            
            {
                this$0 = SnapItSearchResultsView.this;
                super();
            }
        });
        return view;
    }

    protected View getNoMatchFooter()
    {
        return new NoMatchSearchResultsView((AmazonActivity)getContext(), "snapItSearchResultsType");
    }

    public CharSequence getTitle()
    {
        if (mAmazonActivity.isErrorBoxShowing())
        {
            return getResources().getString(com.amazon.mShop.android.lib.R.string.search_results_title);
        }
        if (mImageSearchController.isCompleted())
        {
            if (mImageSearchController.count() == 0)
            {
                return getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_search_result_title_no_result);
            }
            if (mImageSearchController.count() == 1)
            {
                return getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_search_result_title_result);
            } else
            {
                return getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_search_result_title_result_plural);
            }
        } else
        {
            return getResources().getString(com.amazon.mShop.android.lib.R.string.snapit_search_result_title_searching_for);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!mImageSearchController.hasServiceCallRunning())
        {
            mImageSearchController.doImageSearch(mResizedImage);
        }
    }

    public void onCompleted()
    {
        mAdapter.notifyDataSetChanged();
        if (1 <= mImageSearchController.count())
        {
            removeFooterView(mFooter);
            addFooterView(getMismatchFooter());
        } else
        {
            removeFooterView(mFooter);
            addFooterView(getNoMatchFooter());
        }
        mAmazonActivity.updateTitle(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        SnapItActivity.clearLastPhotoCaptured();
        if (mImageSearchController.hasServiceCallRunning())
        {
            mImageSearchController.cancel();
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        mImageSearchController.setCompleted(true);
        AmazonErrorUtils.reportMShopServerError((AmazonActivity)getContext(), new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final SnapItSearchResultsView this$0;

            public void onActionButtonClick(int i)
            {
                mImageSearchController.doImageSearch(mResizedImage);
                mAmazonActivity.updateTitle(SnapItSearchResultsView.this);
            }

            
            {
                this$0 = SnapItSearchResultsView.this;
                super();
            }
        }, this, exception);
        mAmazonActivity.updateTitle(this);
    }

    protected void reportMismatch()
    {
        Object obj = new StringBuilder();
        Resources resources = getResources();
        if (mImageSearchController.count() > 0)
        {
            BasicProductInfo basicproductinfo = mImageSearchController.getSearchResult(0).getBasicProduct();
            if (basicproductinfo.getByLine() != null && basicproductinfo.getShortDescription() != null)
            {
                ((StringBuilder) (obj)).append(resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_item_description_with_byline_and_shortdesc, new Object[] {
                    basicproductinfo.getTitle(), basicproductinfo.getByLine(), basicproductinfo.getShortDescription(), basicproductinfo.getAsin()
                }));
            } else
            if (basicproductinfo.getByLine() != null)
            {
                ((StringBuilder) (obj)).append(resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_item_description_with_byline, new Object[] {
                    basicproductinfo.getTitle(), basicproductinfo.getByLine(), basicproductinfo.getAsin()
                }));
            } else
            if (basicproductinfo.getShortDescription() != null)
            {
                ((StringBuilder) (obj)).append(resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_item_description_with_shortdesc, new Object[] {
                    basicproductinfo.getTitle(), basicproductinfo.getShortDescription(), basicproductinfo.getAsin()
                }));
            } else
            {
                ((StringBuilder) (obj)).append(resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_item_description, new Object[] {
                    basicproductinfo.getTitle(), basicproductinfo.getAsin()
                }));
            }
        }
        obj = new EmailComposer(getContext(), Arrays.asList(new String[] {
            resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_mail_recipient)
        }), null, resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_mail_subject), ((StringBuilder) (obj)).insert(0, resources.getString(com.amazon.mShop.android.lib.R.string.snapit_search_report_mismatch_mail_body)).toString());
        ((EmailComposer) (obj)).attachFile(mResizedImage, "snapit", "jpg");
        ((EmailComposer) (obj)).composeEmail();
    }



}
