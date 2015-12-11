// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.groupon.db.dao.DaoDeal;
import com.groupon.db.dao.DaoStockCategory;
import com.groupon.db.events.StockCategoriesUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.db.models.StockCategory;
import com.groupon.db.models.StockValue;
import com.groupon.manager.StockCategoriesSyncManager;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class StockCategories extends GrouponActivity
    implements commonlib.manager.SyncManager.SyncUiCallbacks
{
    private static class StockCategoriesLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
    {

        private DaoDeal dealDao;
        private String dealId;
        private String optionId;
        private DaoStockCategory stockCategoryDao;

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            ArrayList arraylist;
            Object obj;
            Object obj1;
            Iterator iterator;
            try
            {
                obj = (Deal)dealDao.queryForFirstEq("remoteId", dealId);
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            obj1 = null;
            arraylist = obj1;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            arraylist = null;
            iterator = ((Deal) (obj)).getOptions().iterator();
_L2:
            obj = arraylist;
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (Option)iterator.next();
            if (!((Option) (obj)).remoteId.equals(optionId)) goto _L2; else goto _L1
_L1:
            arraylist = obj1;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            arraylist = obj1;
            if (((Option) (obj)).stockCategories != null)
            {
                arraylist = new ArrayList(((Option) (obj)).stockCategories);
            }
            if (arraylist == null)
            {
                break MISSING_BLOCK_LABEL_115;
            }
            obj = arraylist;
            if (!arraylist.isEmpty())
            {
                break MISSING_BLOCK_LABEL_131;
            }
            obj = stockCategoryDao.getListByDealIdAndOptionId(dealId, optionId);
            return ((List) (obj));
        }

        protected boolean shouldReload(StockCategoriesUpdateEvent stockcategoriesupdateevent)
        {
            return stockcategoriesupdateevent.getDealId().equals(dealId) && stockcategoriesupdateevent.getOptionId().equals(optionId);
        }

        protected volatile boolean shouldReload(UpdateEvent updateevent)
        {
            return shouldReload((StockCategoriesUpdateEvent)updateevent);
        }

        private StockCategoriesLoader(Context context, String s, String s1)
        {
            super(com/groupon/db/models/StockCategory, com/groupon/db/events/StockCategoriesUpdateEvent, context);
            RoboGuice.getInjector(context).injectMembers(this);
            dealId = s;
            optionId = s1;
        }

    }


    public static final int REQUEST_CODE = 10121;
    String dealId;
    String dealOptionId;
    private DialogManager dialogManager;
    private LayoutInflater layoutInflater;
    Spinner stockCategoriesSpinner;
    private StockCategoriesSyncManager stockCategoriesSyncManager;
    TextView stockCategoriesTitle;
    View stockProgressView;
    StockValue stockValue;
    ViewGroup stockValuesContainer;
    TextView stockValuesTitle;
    ViewGroup valuesContainer;

    public StockCategories()
    {
    }

    private void addDetailsSeparator()
    {
        if (valuesContainer.getChildCount() > 0)
        {
            layoutInflater.inflate(0x7f0301ae, valuesContainer);
        }
    }

    private boolean containsStockValue(Collection collection)
    {
label0:
        {
            if (collection == null)
            {
                break label0;
            }
            String s = stockValue.id;
            collection = collection.iterator();
            do
            {
                if (!collection.hasNext())
                {
                    break label0;
                }
            } while (!Strings.equals(((StockValue)collection.next()).id, s));
            return true;
        }
        return false;
    }

    private View getBasicListItem(ViewGroup viewgroup, int i, String s, android.view.View.OnClickListener onclicklistener, boolean flag)
    {
        boolean flag2 = true;
        if (i > 0 && Strings.notEmpty(s))
        {
            View view = layoutInflater.inflate(i, viewgroup, false);
            TextView textview = (TextView)view.findViewById(0x7f100249);
            textview.setText(s);
            s = (TextView)view.findViewById(0x7f100540);
            boolean flag1;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            s.setVisibility(i);
            if (flag)
            {
                i = getResources().getColor(0x7f0e013e);
            } else
            {
                i = textview.getCurrentTextColor();
            }
            textview.setTextColor(i);
            if (!flag && onclicklistener != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            view.setClickable(flag1);
            view.setFocusable(flag1);
            view.setFocusableInTouchMode(false);
            view.setOnClickListener(onclicklistener);
            if (!flag)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            view.setEnabled(flag);
            viewgroup.addView(view);
            return view;
        } else
        {
            return null;
        }
    }

    private void setupAdapter(List list)
    {
        stockCategoriesSpinner.setAdapter(new ArrayAdapter(this, 0x7f03020a, list) {

            final StockCategories this$0;

            public View getDropDownView(int i, View view, ViewGroup viewgroup)
            {
                StockCategory stockcategory = (StockCategory)getItem(i);
                viewgroup = view;
                if (view == null)
                {
                    viewgroup = layoutInflater.inflate(0x7f030207, null, false);
                }
                view = (TextView)viewgroup;
                view.setText(stockcategory.name);
                return view;
            }

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                StockCategory stockcategory = (StockCategory)getItem(i);
                viewgroup = view;
                if (view == null)
                {
                    viewgroup = layoutInflater.inflate(0x7f03020a, null, false);
                }
                view = (TextView)viewgroup;
                view.setText(stockcategory.name);
                return view;
            }

            
            {
                this$0 = StockCategories.this;
                super(context, i, list);
            }
        });
        stockCategoriesSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final StockCategories this$0;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (StockCategory)stockCategoriesSpinner.getAdapter().getItem(i);
                if (adapterview != null)
                {
                    view = ((StockCategory) (adapterview)).stockValues;
                    ViewGroup viewgroup = stockValuesContainer;
                    if (view.size() > 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    viewgroup.setVisibility(i);
                    stockValuesTitle.setText(String.format(getString(0x7f0800b4), new Object[] {
                        ((StockCategory) (adapterview)).name
                    }).toUpperCase());
                    valuesContainer.removeAllViews();
                    adapterview = view.iterator();
                    while (adapterview.hasNext()) 
                    {
                        view = (StockValue)adapterview.next();
                        boolean flag;
                        if (((StockValue) (view)).maxStock - ((StockValue) (view)).soldQuantity <= 0)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        getBasicListItem(valuesContainer, 0x7f03020e, ((StockValue) (view)).name, view. new android.view.View.OnClickListener() {

                            final _cls3 this$1;
                            final StockValue val$stockValue;

                            public void onClick(View view)
                            {
                                view = new Intent();
                                view.putExtra("stockValue", stockValue);
                                setResult(-1, view);
                                finish();
                            }

            
            {
                this$1 = final__pcls3;
                stockValue = StockValue.this;
                super();
            }
                        }, flag);
                        addDetailsSeparator();
                    }
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = StockCategories.this;
                super();
            }
        });
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        stockProgressView.setVisibility(8);
        runnable = dialogManager.getDialogFragment(Integer.valueOf(0x7f080165));
        runnable.setCancelable(false);
        GrouponDialogFragment.show(getFragmentManager(), runnable, "http_error_dialog");
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080363));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03020d);
        stockCategoriesTitle.setText(Strings.toString(stockCategoriesTitle.getText()).toUpperCase());
        stockCategoriesSyncManager.setDealId(dealId);
        stockCategoriesSyncManager.setOptionId(dealOptionId);
        getLoaderManager().initLoader(0, null, new android.app.LoaderManager.LoaderCallbacks() {

            final StockCategories this$0;

            public Loader onCreateLoader(int i, Bundle bundle1)
            {
                return new StockCategoriesLoader(StockCategories.this, dealId, dealOptionId);
            }

            public volatile void onLoadFinished(Loader loader, Object obj)
            {
                onLoadFinished(loader, (List)obj);
            }

            public void onLoadFinished(Loader loader, List list)
            {
                if (list != null && !list.isEmpty())
                {
                    setupAdapter(list);
                    if (stockValue != null)
                    {
                        setSpinnerSelection(list);
                    }
                    stockProgressView.setVisibility(8);
                    return;
                } else
                {
                    stockCategoriesSyncManager.requestSync(StockCategories.this, null);
                    return;
                }
            }

            public void onLoaderReset(Loader loader)
            {
            }

            
            {
                this$0 = StockCategories.this;
                super();
            }
        });
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle.containsKey("selectionIndex"))
        {
            stockCategoriesSpinner.setSelection(bundle.getInt("selectionIndex"));
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        int i = stockCategoriesSpinner.getSelectedItemPosition();
        if (i >= 0)
        {
            bundle.putInt("selectionIndex", i);
        }
    }

    protected void setSpinnerSelection(Collection collection)
    {
        int i = 0;
        collection = collection.iterator();
        do
        {
label0:
            {
                if (collection.hasNext())
                {
                    StockCategory stockcategory = (StockCategory)collection.next();
                    if (stockcategory == null || !containsStockValue(stockcategory.stockValues))
                    {
                        break label0;
                    }
                    stockCategoriesSpinner.setSelection(i);
                }
                return;
            }
            i++;
        } while (true);
    }





}
