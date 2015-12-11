// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.PagedItemAdapter;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.history.HistoryBrowser;
import com.amazon.mShop.control.home.BasicProductsSubscriber;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.ui.BottomToolBar;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.history:
//            ObjectDeletingObserver, HistoryContentProvider, HistoryEntity, HistoryItemView

public class HistoryView extends RelativeLayout
    implements android.content.DialogInterface.OnClickListener, TitleProvider, BasicProductsSubscriber, ObjectDeletingObserver, UserListener, com.amazon.mShop.ui.BottomToolBar.ToolBarParent
{
    private class HistoryPagedItemAdapter extends PagedItemAdapter
    {

        final HistoryView this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            browser.setCurrentIndex(i);
            byte abyte0[];
            int j;
            int k;
            if (view == null)
            {
                view = (HistoryItemView)layoutInflater.inflate(rowResId, null);
                view.setObserver(HistoryView.this);
            } else
            {
                view = (HistoryItemView)view;
            }
            viewgroup = ((ViewGroup) (browser.getObjectAtIndex(i)));
            j = i;
            k = j;
            if (mIndexToDelete != -1)
            {
                k = j;
                if (i > mIndexToDelete)
                {
                    k = j - 1;
                }
            }
            abyte0 = browser.getImageAtIndex(i);
            view.setObjectIndex(i);
            view.setTag(mVisitDateList.get(i));
            view.update(this, viewgroup, abyte0, k);
            if (i == mIndexToDelete)
            {
                view.showUndoGroup();
                return view;
            } else
            {
                view.showItemGroup();
                return view;
            }
        }

        public boolean isEnabled(int i)
        {
            return i != mIndexToDelete;
        }

        protected Object makeObjectForForward()
        {
            ProductController productcontroller = (ProductController)super.makeObjectForForward();
            productcontroller.setClickStreamTag(ClickStreamTag.ORIGIN_RVI);
            return productcontroller;
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            RefMarkerObserver.logRefMarker("dp_rvi");
            super.onItemClick(adapterview, view, i, l);
            if (deleteAsinsFromDB())
            {
                refresh();
            }
        }

        public void onPageComplete()
        {
            super.onPageComplete();
            mBottomToolBar.setToolBarEnabled(true);
            if (mBrowser.getAvailableItemCount() > mBrowser.getReceivedCount())
            {
                showLoadingStatus();
                return;
            } else
            {
                hideStatus();
                return;
            }
        }

        public HistoryPagedItemAdapter(AmazonActivity amazonactivity, int i)
        {
            this$0 = HistoryView.this;
            super(amazonactivity, i);
        }
    }


    private static final String TAG = com/amazon/mShop/history/HistoryView.getSimpleName();
    private HistoryPagedItemAdapter mAdapter;
    private String mAsinToDelete;
    private List mAsinsDeleted;
    private BottomToolBar mBottomToolBar;
    private HistoryBrowser mBrowser;
    private View mEmptyGroup;
    private View mFooter;
    private int mIndexToDelete;
    private View mListGroup;
    private ListView mListView;
    private ProgressBar mProgress;
    private TextView mStatus;
    private List mVisitDateList;

    public HistoryView(Context context)
    {
        super(context);
        mVisitDateList = new ArrayList();
        mAsinsDeleted = new ArrayList();
        mIndexToDelete = -1;
        View.inflate(context, com.amazon.mShop.android.lib.R.layout.history_list_view, this);
        mListView = (ListView)findViewById(com.amazon.mShop.android.lib.R.id.items_list);
        mListView.setDividerHeight(0);
        mListView.setItemsCanFocus(true);
        mListView.setOnItemClickListener(mAdapter);
        mListGroup = findViewById(com.amazon.mShop.android.lib.R.id.history_list_group);
        mEmptyGroup = findViewById(com.amazon.mShop.android.lib.R.id.history_empty_group);
        mEmptyGroup.findViewById(com.amazon.mShop.android.lib.R.id.history_search_link).setOnClickListener(new android.view.View.OnClickListener() {

            final HistoryView this$0;

            public void onClick(View view)
            {
                view = (AmazonActivity)getContext();
                ActivityUtils.startSearchActivity(view, (new SearchIntentBuilder(view)).showSearchEntryView(true).selectInitialQuery(true).clickStreamOrigin(ClickStreamTag.ORIGIN_RVI.getTag()).build());
            }

            
            {
                this$0 = HistoryView.this;
                super();
            }
        });
        mEmptyGroup.findViewById(com.amazon.mShop.android.lib.R.id.shop_by_department_link).setOnClickListener(new android.view.View.OnClickListener() {

            final HistoryView this$0;

            public void onClick(View view)
            {
                ActivityUtils.startCategoryBrowseActivity(getContext());
            }

            
            {
                this$0 = HistoryView.this;
                super();
            }
        });
        mFooter = inflate(context, com.amazon.mShop.android.lib.R.layout.search_results_footer, null);
        mProgress = (ProgressBar)mFooter.findViewById(com.amazon.mShop.android.lib.R.id.search_results_progress);
        mStatus = (TextView)mFooter.findViewById(com.amazon.mShop.android.lib.R.id.search_results_status);
        mListView.addFooterView(mFooter, null, false);
        mBottomToolBar = (BottomToolBar)findViewById(com.amazon.mShop.android.lib.R.id.bottom_tool_bar);
        mBottomToolBar.setToolBarParent(this);
        initToolBar();
        getDatas();
    }

    private List getAllViewedItems()
    {
        Cursor cursor;
        Cursor cursor1;
        ArrayList arraylist;
        arraylist = new ArrayList();
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = (new CursorLoader(getContext(), HistoryContentProvider.PRODUCT_URI, HistoryEntity.HISTORY_PROJECTION, null, null, "visit_date DESC")).loadInBackground();
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        cursor1 = cursor2;
        if (cursor2.getCount() <= 0) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor2;
        mVisitDateList.clear();
        cursor = cursor2;
        cursor1 = cursor2;
        cursor2.moveToFirst();
_L4:
        cursor = cursor2;
        cursor1 = cursor2;
        arraylist.add(cursor2.getString(cursor2.getColumnIndex("asin")));
        cursor = cursor2;
        cursor1 = cursor2;
        long l = cursor2.getLong(cursor2.getColumnIndex("visit_date"));
        cursor = cursor2;
        cursor1 = cursor2;
        Date date = Calendar.getInstance().getTime();
        cursor = cursor2;
        cursor1 = cursor2;
        date.setTime(l);
        cursor = cursor2;
        cursor1 = cursor2;
        mVisitDateList.add(date);
        cursor = cursor2;
        cursor1 = cursor2;
        boolean flag = cursor2.move(1);
        if (flag) goto _L4; else goto _L2
_L2:
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L6:
        return arraylist;
        DBException dbexception;
        dbexception;
        cursor1 = cursor;
        Log.i(TAG, dbexception.getMessage());
        if (cursor == null) goto _L6; else goto _L5
_L5:
        cursor.close();
        return arraylist;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    private void getDatas()
    {
        List list = getAllViewedItems();
        if (list.size() == 0)
        {
            hideStatus();
            mEmptyGroup.setVisibility(0);
            mListGroup.setVisibility(8);
            return;
        } else
        {
            mBrowser = new HistoryBrowser(8, 3, list, this);
            mBrowser.startFirstPageRequest(list.size(), null);
            mAdapter = new HistoryPagedItemAdapter((AmazonActivity)getContext(), com.amazon.mShop.android.lib.R.layout.history_item_row);
            mAdapter.setBrowser(mBrowser);
            mAdapter.setListView(mListView);
            return;
        }
    }

    private void hideStatus()
    {
        mProgress.setVisibility(8);
        mStatus.setVisibility(8);
    }

    private void initToolBar()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new com.amazon.mShop.ui.BottomToolBar.ToolBarItem(com.amazon.mShop.android.lib.R.id.history_clear_all, com.amazon.mShop.android.lib.R.string.history_clear_all, true));
        mBottomToolBar.init(arraylist);
        mBottomToolBar.setToolBarEnabled(false);
    }

    private void showLoadingStatus()
    {
        mProgress.setVisibility(0);
        mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
        mStatus.setVisibility(0);
    }

    protected boolean deleteAsinsFromDB()
    {
        if (!Util.isEmpty(mAsinToDelete))
        {
            mAsinsDeleted.add(mAsinToDelete);
            mAsinToDelete = null;
            mIndexToDelete = -1;
        }
        if (!mAsinsDeleted.isEmpty())
        {
            StringBuilder stringbuilder = new StringBuilder("asin in (");
            String s;
            for (Iterator iterator = mAsinsDeleted.iterator(); iterator.hasNext(); stringbuilder.append("\"").append(s).append("\"").append(","))
            {
                s = (String)iterator.next();
            }

            stringbuilder.deleteCharAt(stringbuilder.length() - 1);
            stringbuilder.append(")");
            try
            {
                getContext().getContentResolver().delete(HistoryContentProvider.PRODUCT_URI, stringbuilder.toString(), null);
            }
            catch (DBException dbexception)
            {
                Log.i(TAG, dbexception.getMessage());
            }
            mAsinsDeleted.clear();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean deleteObjectInIndex(int i)
    {
        Object obj = mBrowser.getObjectAtIndex(i);
        if (obj != null)
        {
            int j = i;
            if (!Util.isEmpty(mAsinToDelete))
            {
                mAsinsDeleted.add(mAsinToDelete);
                mBrowser.deleteObject(mIndexToDelete);
                mVisitDateList.remove(mIndexToDelete);
                j = i;
                if (mIndexToDelete <= i)
                {
                    j = i - 1;
                }
                mAdapter.notifyDataSetChanged();
            }
            mAsinToDelete = ((SearchResult)obj).getBasicProduct().getAsin();
            mIndexToDelete = j;
            return true;
        } else
        {
            return false;
        }
    }

    public CharSequence getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.history_title);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        User.addUserListener(this);
    }

    public void onBasicProductsReceived(BasicProductsResponse basicproductsresponse)
    {
        mAdapter.notifyDataSetChanged();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch -1 -1: default 20
    //                   -1 27;
           goto _L1 _L2
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        try
        {
            getContext().getContentResolver().delete(HistoryContentProvider.PRODUCT_URI, null, null);
            refresh();
        }
        catch (DBException dbexception)
        {
            Log.i(TAG, dbexception.getMessage());
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        User.removeUserListener(this);
        deleteAsinsFromDB();
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        hideStatus();
        servicecall = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final HistoryView this$0;

            public void onActionButtonClick(int i)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        showLoadingStatus();
                        mBrowser.replayPageRequest();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = HistoryView.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError((AmazonActivity)getContext(), servicecall, this, exception);
    }

    public void onToolBarItemSelected(com.amazon.mShop.ui.BottomToolBar.ToolBarItem toolbaritem)
    {
        toolbaritem = new com.amazon.mShop.AmazonAlertDialog.Builder(getContext());
        toolbaritem.setMessage(com.amazon.mShop.android.lib.R.string.history_confirm_clear_all);
        toolbaritem.setPositiveButton(com.amazon.mShop.android.lib.R.string.yes, this);
        toolbaritem.setNegativeButton(com.amazon.mShop.android.lib.R.string.no, this);
        toolbaritem.create().show();
    }

    protected void refresh()
    {
        List list = getAllViewedItems();
        if (list.size() == 0)
        {
            mEmptyGroup.setVisibility(0);
            mListGroup.setVisibility(8);
            return;
        } else
        {
            mEmptyGroup.setVisibility(8);
            mListGroup.setVisibility(0);
            mBrowser.startFirstPageRequest(list, null);
            mAdapter.notifyDataSetChanged();
            showLoadingStatus();
            return;
        }
    }

    public void undoDelete(int i)
    {
        mIndexToDelete = -1;
        mAsinToDelete = null;
        mAdapter.notifyDataSetChanged();
    }

    public void userSignedIn(User user)
    {
        ((AmazonActivity)getContext()).finish();
    }

    public void userSignedOut()
    {
    }

    public void userUpdated(User user)
    {
    }







}
