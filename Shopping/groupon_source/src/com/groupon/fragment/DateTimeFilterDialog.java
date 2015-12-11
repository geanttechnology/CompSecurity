// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.adapter.DateTimePickerAdapter;
import com.groupon.foundations.dialog.BaseDialogFragment;
import com.groupon.view.FixedPositionListView;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragmentPresenter

public class DateTimeFilterDialog extends BaseDialogFragment
{

    public static final int LIST_OFFSET = 1;
    private static final int SKIP_RESET_COUNTER = 3;
    private static final int UPDATE_DELAY = 300;
    protected View background;
    protected ImageButton closeButton;
    private DateTimePickerAdapter dateTimePickerAdapter1;
    private DateTimePickerAdapter dateTimePickerAdapter2;
    private DateTimePickerAdapter dateTimePickerAdapter3;
    int default_reset_text_color;
    private Handler handler;
    private long lastUpdatedTime;
    protected FixedPositionListView list1;
    protected FixedPositionListView list2;
    protected FixedPositionListView list3;
    int modified_reset_text_color;
    private RapiSearchResultFragmentPresenter rapiSearchResultFragmentPresenter;
    protected TextView resetButton;
    private int skipCounter;

    public DateTimeFilterDialog()
    {
        skipCounter = 0;
        lastUpdatedTime = 0L;
    }

    private boolean isFiltersInDefaultPosition()
    {
        return dateTimePickerAdapter1.getSelectedPosition() == rapiSearchResultFragmentPresenter.getDefaultPositionForList1(true) && dateTimePickerAdapter2.getSelectedPosition() == rapiSearchResultFragmentPresenter.getDefaultPositionForList2(true) && dateTimePickerAdapter3.getSelectedPosition() == rapiSearchResultFragmentPresenter.getDefaultPositionForList3(true);
    }

    private void searchWithDelay(final DateTimePickerAdapter adapter, final int position)
    {
        if (skipCounter >= 1)
        {
            skipCounter = skipCounter - 1;
            final int localCounter = skipCounter;
            final long currentTime = System.currentTimeMillis();
            lastUpdatedTime = currentTime;
            handler.postDelayed(new Runnable() {

                final DateTimeFilterDialog this$0;
                final DateTimePickerAdapter val$adapter;
                final long val$currentTime;
                final int val$localCounter;
                final int val$position;

                public void run()
                {
                    adapter.setSelectedPosition(position, true);
                    if (localCounter == 0)
                    {
                        updateModel(Long.valueOf(currentTime));
                    }
                }

            
            {
                this$0 = DateTimeFilterDialog.this;
                adapter = datetimepickeradapter;
                position = i;
                localCounter = j;
                currentTime = l;
                super();
            }
            }, 300L);
        } else
        if (adapter.getSelectedPosition() != position)
        {
            final long currentTime = System.currentTimeMillis();
            final int oldPos = adapter.getSelectedPosition();
            lastUpdatedTime = currentTime;
            adapter.setSelectedPosition(position, true);
            handler.postDelayed(new Runnable() {

                final DateTimeFilterDialog this$0;
                final DateTimePickerAdapter val$adapter;
                final long val$currentTime;
                final int val$oldPos;
                final int val$position;

                public void run()
                {
                    if (adapter == dateTimePickerAdapter2)
                    {
                        int i = rapiSearchResultFragmentPresenter.getDefaultPositionForList2(true);
                        if (oldPos == i && position != i || i == position)
                        {
                            dateTimePickerAdapter3.setDataList(rapiSearchResultFragmentPresenter.getListValuePair3());
                            list3.invalidate();
                            if (rapiSearchResultFragmentPresenter.isToday())
                            {
                                int j = rapiSearchResultFragmentPresenter.findMappingIndexInListValuePair3ForToday();
                                if (j == -1)
                                {
                                    updateModel(Long.valueOf(currentTime));
                                    return;
                                } else
                                {
                                    skipCounter = 1;
                                    dateTimePickerAdapter3.setSelectedPosition(j, false);
                                    list3.setSelection(j);
                                    return;
                                }
                            } else
                            {
                                skipCounter = 1;
                                int k = rapiSearchResultFragmentPresenter.findMappingIndexInListValuePair3FromToday();
                                dateTimePickerAdapter3.setSelectedPosition(k, false);
                                list3.setSelection(k);
                                return;
                            }
                        } else
                        {
                            updateModel(Long.valueOf(currentTime));
                            return;
                        }
                    } else
                    {
                        updateModel(Long.valueOf(currentTime));
                        return;
                    }
                }

            
            {
                this$0 = DateTimeFilterDialog.this;
                adapter = datetimepickeradapter;
                oldPos = i;
                position = j;
                currentTime = l;
                super();
            }
            }, 300L);
            return;
        }
    }

    private void setInitialState(boolean flag)
    {
        list1.setSelection(rapiSearchResultFragmentPresenter.getDefaultPositionForList1(flag));
        list2.setSelection(rapiSearchResultFragmentPresenter.getDefaultPositionForList2(flag));
        list3.setSelection(rapiSearchResultFragmentPresenter.getDefaultPositionForList3(flag));
    }

    private void updateModel(Long long1)
    {
        if (long1 == null || long1.longValue() == lastUpdatedTime)
        {
            int i = dateTimePickerAdapter1.getSelectedPosition();
            int j = dateTimePickerAdapter2.getSelectedPosition();
            int k = dateTimePickerAdapter3.getSelectedPosition();
            if (rapiSearchResultFragmentPresenter != null && i >= 1 && i < dateTimePickerAdapter1.getCount() - 1 && j >= 1 && j < dateTimePickerAdapter2.getCount() - 1 && k >= 1 && k < dateTimePickerAdapter3.getCount() - 1)
            {
                if (rapiSearchResultFragmentPresenter.isFoodAndDrinkIntent())
                {
                    rapiSearchResultFragmentPresenter.setPartySize(i);
                } else
                {
                    rapiSearchResultFragmentPresenter.setServiceCategory(i);
                }
                rapiSearchResultFragmentPresenter.setReservationDate(j);
                rapiSearchResultFragmentPresenter.setReservationTime(k);
                rapiSearchResultFragmentPresenter.refreshView();
                rapiSearchResultFragmentPresenter.reloadDeals();
                return;
            }
        }
    }

    private void updateResetButtonState(boolean flag)
    {
        TextView textview = resetButton;
        int i;
        if (flag)
        {
            i = default_reset_text_color;
        } else
        {
            i = modified_reset_text_color;
        }
        textview.setTextColor(i);
        textview = resetButton;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        textview.setClickable(flag);
    }

    protected void dismissCurrentDialog()
    {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        setStyle(1, 0x7f0a010e);
        handler = new Handler(Looper.getMainLooper());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(getResources().getLayout(0x7f0300ba), viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        if (getDialog() != null)
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        Dart.inject(this);
        setupAdapters();
        resetButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DateTimeFilterDialog this$0;

            public void onClick(View view1)
            {
                skipCounter = 3;
                setInitialState(true);
                updateResetButtonState(true);
            }

            
            {
                this$0 = DateTimeFilterDialog.this;
                super();
            }
        });
        updateResetButtonState(true);
        closeButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DateTimeFilterDialog this$0;

            public void onClick(View view1)
            {
                dismissCurrentDialog();
            }

            
            {
                this$0 = DateTimeFilterDialog.this;
                super();
            }
        });
        background.setOnClickListener(new android.view.View.OnClickListener() {

            final DateTimeFilterDialog this$0;

            public void onClick(View view1)
            {
                dismissCurrentDialog();
            }

            
            {
                this$0 = DateTimeFilterDialog.this;
                super();
            }
        });
    }

    public void setRapiSearchResultFragmentPresenter(RapiSearchResultFragmentPresenter rapisearchresultfragmentpresenter)
    {
        rapiSearchResultFragmentPresenter = rapisearchresultfragmentpresenter;
    }

    protected void setupAdapters()
    {
        list1.setListOffset(1);
        list2.setListOffset(1);
        list3.setListOffset(1);
        dateTimePickerAdapter1 = new DateTimePickerAdapter(1, getActivity().getApplicationContext(), rapiSearchResultFragmentPresenter.getListValuePair1(), rapiSearchResultFragmentPresenter);
        dateTimePickerAdapter2 = new DateTimePickerAdapter(2, getActivity().getApplicationContext(), rapiSearchResultFragmentPresenter.getListValuePair2(), rapiSearchResultFragmentPresenter);
        dateTimePickerAdapter3 = new DateTimePickerAdapter(3, getActivity().getApplicationContext(), rapiSearchResultFragmentPresenter.getListValuePair3(), rapiSearchResultFragmentPresenter);
        list1.setAdapter(dateTimePickerAdapter1);
        list2.setAdapter(dateTimePickerAdapter2);
        list3.setAdapter(dateTimePickerAdapter3);
        setInitialState(false);
        dateTimePickerAdapter1.setSelectedPosition(rapiSearchResultFragmentPresenter.getDefaultPositionForList1(false), true);
        dateTimePickerAdapter2.setSelectedPosition(rapiSearchResultFragmentPresenter.getDefaultPositionForList2(false), true);
        dateTimePickerAdapter3.setSelectedPosition(rapiSearchResultFragmentPresenter.getDefaultPositionForList3(false), true);
        updateModel(null);
        list1.setOnPositionChangedListener(new com.groupon.view.FixedPositionListView.OnPositionChangedListener() {

            final DateTimeFilterDialog this$0;

            public void onStartScroll()
            {
            }

            public void onStopScroll(int i)
            {
                searchWithDelay(dateTimePickerAdapter1, i);
                updateResetButtonState(isFiltersInDefaultPosition());
            }

            
            {
                this$0 = DateTimeFilterDialog.this;
                super();
            }
        });
        list2.setOnPositionChangedListener(new com.groupon.view.FixedPositionListView.OnPositionChangedListener() {

            final DateTimeFilterDialog this$0;

            public void onStartScroll()
            {
            }

            public void onStopScroll(int i)
            {
                searchWithDelay(dateTimePickerAdapter2, i);
                updateResetButtonState(isFiltersInDefaultPosition());
            }

            
            {
                this$0 = DateTimeFilterDialog.this;
                super();
            }
        });
        list3.setOnPositionChangedListener(new com.groupon.view.FixedPositionListView.OnPositionChangedListener() {

            final DateTimeFilterDialog this$0;

            public void onStartScroll()
            {
            }

            public void onStopScroll(int i)
            {
                searchWithDelay(dateTimePickerAdapter3, i);
                updateResetButtonState(isFiltersInDefaultPosition());
            }

            
            {
                this$0 = DateTimeFilterDialog.this;
                super();
            }
        });
    }








/*
    static int access$602(DateTimeFilterDialog datetimefilterdialog, int i)
    {
        datetimefilterdialog.skipCounter = i;
        return i;
    }

*/



}
