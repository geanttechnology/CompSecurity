// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.eBayRating;
import com.ebay.mobile.itemview.ProductReviewsDataManager;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.net.api.guidesandreviews.Reviews;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemViewData, ItemViewCommonProgressAndError, ViewItemDataManager

public class ProductReviewsActivity extends ItemViewBaseActivity
    implements android.widget.AdapterView.OnItemClickListener, com.ebay.mobile.itemview.ProductReviewsDataManager.Observer
{
    private class ListAdapter extends ArrayAdapter
    {

        private int ELLIPSIS_LENGTH_THRESHOLD;
        private final Context context;
        private final DateFormat dateFormatter = DateFormat.getDateInstance(2, Locale.getDefault());
        private final String ellipsis;
        private final View headerView;
        private final LayoutInflater inflater;
        private final TextView reviewsCount;
        private final eBayRating reviewsRating;
        final ProductReviewsActivity this$0;

        public void addItems(List list)
        {
            addAll(list);
            notifyDataSetChanged();
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (i == 0)
            {
                viewgroup = headerView;
            } else
            {
                com.ebay.nautilus.domain.net.api.guidesandreviews.Reviews.Review review = (com.ebay.nautilus.domain.net.api.guidesandreviews.Reviews.Review)getItem(i);
                String s;
                int j;
                boolean flag;
                if (view != null && (view.getTag() instanceof ViewHolder))
                {
                    viewgroup = (ViewHolder)view.getTag();
                } else
                {
                    view = inflater.inflate(0x7f030291, viewgroup, false);
                    viewgroup = new ViewHolder();
                    viewgroup.titleTextView = (TextView)view.findViewById(0x7f1008bc);
                    viewgroup.textTextView = (TextView)view.findViewById(0x7f1008c0);
                    viewgroup.textFullTextView = (TextView)view.findViewById(0x7f1008c2);
                    viewgroup.dateTextView = (TextView)view.findViewById(0x7f1008bf);
                    viewgroup.reviewByTextView = (TextView)view.findViewById(0x7f1008be);
                    viewgroup.reviewRating = (eBayRating)view.findViewById(0x7f1008bd);
                    ((ViewHolder) (viewgroup)).reviewRating.setFeedbackStarResources(0x7f02022b, 0x7f02022d, 0, 0x7f02022c);
                    ((ViewHolder) (viewgroup)).reviewRating.setOnTouchListener(null);
                    viewgroup.expandImage = (ImageView)view.findViewById(0x7f1008c1);
                    view.setTag(viewgroup);
                }
                ((ViewHolder) (viewgroup)).titleTextView.setText(review.title.getSourceContent());
                s = "";
                if (review.description != null)
                {
                    s = review.description.getSourceContent();
                    ((ViewHolder) (viewgroup)).textFullTextView.setText(s);
                }
                ((ViewHolder) (viewgroup)).reviewByTextView.setText(context.getString(0x7f070934, new Object[] {
                    review.author.username
                }));
                ((ViewHolder) (viewgroup)).reviewRating.setValue(review.rating.floatValue());
                if (review.lastModifiedDate != null)
                {
                    ((ViewHolder) (viewgroup)).dateTextView.setText(context.getString(0x7f070276, new Object[] {
                        dateFormatter.format(review.lastModifiedDate.value)
                    }));
                    ((ViewHolder) (viewgroup)).dateTextView.setVisibility(0);
                } else
                {
                    ((ViewHolder) (viewgroup)).dateTextView.setVisibility(8);
                }
                flag = expanded.get(i);
                if (s.length() > ELLIPSIS_LENGTH_THRESHOLD)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (j != 0)
                {
                    ((ViewHolder) (viewgroup)).textTextView.setText((new StringBuilder()).append(s.substring(0, ELLIPSIS_LENGTH_THRESHOLD - 1)).append(ellipsis).toString());
                    if (flag)
                    {
                        ((ViewHolder) (viewgroup)).textFullTextView.setVisibility(0);
                        ((ViewHolder) (viewgroup)).textTextView.setVisibility(8);
                        ((ViewHolder) (viewgroup)).expandImage.setImageResource(0x7f020256);
                    } else
                    {
                        ((ViewHolder) (viewgroup)).textFullTextView.setVisibility(8);
                        ((ViewHolder) (viewgroup)).textTextView.setVisibility(0);
                        ((ViewHolder) (viewgroup)).expandImage.setImageResource(0x7f020252);
                    }
                } else
                {
                    ((ViewHolder) (viewgroup)).textTextView.setText(s);
                }
                viewgroup = ((ViewHolder) (viewgroup)).expandImage;
                if (j != 0)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                viewgroup.setVisibility(j);
                j = getCount() - 1;
                if (ProductReviewsActivity.logTag.isLoggable)
                {
                    ProductReviewsActivity.logTag.log((new StringBuilder()).append("count=").append(j).append(";position=").append(i).append(";reviewCount=").append(reviewData.count).append(";pageNumber=").append(pageNumber).toString());
                }
                viewgroup = view;
                if (i == j - 1)
                {
                    viewgroup = view;
                    if (j < reviewData.count)
                    {
                        viewgroup = view;
                        if (j <= pageNumber * 10)
                        {
                            getMore();
                            return view;
                        }
                    }
                }
            }
            return viewgroup;
        }

        public ListAdapter(Context context1, int i, int j, List list)
        {
            this$0 = ProductReviewsActivity.this;
            super(context1, i, j, list);
            ELLIPSIS_LENGTH_THRESHOLD = 250;
            inflater = (LayoutInflater)context1.getSystemService("layout_inflater");
            context = context1;
            headerView = inflater.inflate(0x7f0301aa, null);
            headerView.setTag(Boolean.valueOf(false));
            reviewsCount = (TextView)headerView.findViewById(0x7f1004f7);
            reviewsRating = (eBayRating)headerView.findViewById(0x7f1004f6);
            reviewsRating.setFeedbackStarResources(0x7f02022b, 0x7f02022d, 0x7f02022b, 0x7f02022c);
            reviewsRating.setOnTouchListener(null);
            reviewsRating.setValue(item.productReviewAverageRating);
            reviewsRating.invalidate();
            reviewsCount.setText(getString(0x7f0708d2, new Object[] {
                Long.valueOf(item.productReviewCount)
            }));
            ellipsis = context1.getString(0x7f0703a7);
            if (context1.getResources().getBoolean(0x7f0b0006))
            {
                ELLIPSIS_LENGTH_THRESHOLD = 800;
            }
            headerStart(0x7f03012c, (ViewGroup)headerView);
        }
    }

    private static class ViewHolder
    {

        TextView dateTextView;
        ImageView expandImage;
        TextView reviewByTextView;
        eBayRating reviewRating;
        TextView textFullTextView;
        TextView textTextView;
        TextView titleTextView;

        private ViewHolder()
        {
        }

    }


    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ProductReviews", 3, "ProductReviews");
    private SparseBooleanArray expanded;
    private ListView listView;
    private int pageNumber;
    private ProductReviewsDataManager productReviewsDataManager;
    private Reviews reviewData;

    public ProductReviewsActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ProductReviewsActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        activity.startActivity(intent);
    }

    private void createUI()
    {
        listView = (ListView)findViewById(0x7f1004f8);
        listView.setOnItemClickListener(this);
    }

    private void setProductReviewsDataManager(DataManagerContainer datamanagercontainer)
    {
        if (datamanagercontainer != null)
        {
            productReviewsDataManager = (ProductReviewsDataManager)datamanagercontainer.initialize(new com.ebay.mobile.itemview.ProductReviewsDataManager.KeyParams(MyApp.getPrefs().getCurrentSite()), this);
            return;
        } else
        {
            productReviewsDataManager = (ProductReviewsDataManager)DataManager.get(getEbayContext(), new com.ebay.mobile.itemview.ProductReviewsDataManager.KeyParams(MyApp.getPrefs().getCurrentSite()));
            return;
        }
    }

    public void getMore()
    {
        if (logTag.isLoggable)
        {
            logTag.log("getMore() fetching..");
        }
        ProductReviewsDataManager productreviewsdatamanager = productReviewsDataManager;
        String s = item.productReviewSubjectReferenceId;
        int i = pageNumber + 1;
        pageNumber = i;
        productreviewsdatamanager.getReviews(s, i);
    }

    public String getTrackingEventName()
    {
        return "ProductReviews";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301ab);
        setTitle(getString(0x7f070938));
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        pageNumber = 1;
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        createUI();
        initDataManagers();
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                actionhandled, Boolean.valueOf(flag)
            });
        }
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (!content.getStatus().hasError())
        {
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                break;
            }
            if (productReviewsDataManager == null)
            {
                setProductReviewsDataManager(null);
            }
            productReviewsDataManager.getReviews(item.productReviewSubjectReferenceId, pageNumber);
            return;
        } else
        {
            showMessage(0, content.getStatus());
            return;
        }
    }

    public void onDismissMessage(int i, boolean flag)
    {
        finish();
    }

    public void onGetReviewDetails(Content content)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        if (content.getStatus().hasError())
        {
            showMessage(0, content.getStatus());
        } else
        {
            content = (Reviews)content.getData();
            if (content != null && ((Reviews) (content)).members != null && ((Reviews) (content)).members.size() > 0)
            {
                if (reviewData != null)
                {
                    ((ListAdapter)listView.getAdapter()).addItems(((Reviews) (content)).members);
                    return;
                } else
                {
                    reviewData = content;
                    expanded = new SparseBooleanArray();
                    content = new com.ebay.nautilus.domain.net.api.guidesandreviews.Reviews.Review();
                    reviewData.members.add(0, content);
                    content = new ListAdapter(this, 0, 0, reviewData.members);
                    listView.setAdapter(content);
                    return;
                }
            }
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        setProductReviewsDataManager(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        boolean flag = expanded.get(i);
        adapterview = expanded;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        adapterview.put(i, flag);
        ((ListAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        while (isFinishing() || content == null || content.getData() == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }




}
