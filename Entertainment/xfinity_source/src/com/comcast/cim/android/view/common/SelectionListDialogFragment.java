// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public abstract class SelectionListDialogFragment extends DialogFragment
{
    public static interface OnSelectionChangedListener
    {

        public abstract void onSelectionChanged(int i);
    }

    class SelectionListAdapter extends BaseAdapter
    {

        final SelectionListDialogFragment this$0;

        public int getCount()
        {
            return selectionItems.length;
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = inflater.inflate(com.comcast.cim.android.R.layout.selection_list_item, null);
            ((TextView)view.findViewById(com.comcast.cim.android.R.id.item_text)).setText(getDisplayText(selectionItems[i]));
            viewgroup = (CheckBox)view.findViewById(com.comcast.cim.android.R.id.item_check);
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final SelectionListAdapter this$1;

                public void onClick(View view)
                {
                    boolean flag = false;
                    int j = view.getId();
                    if (selectedItemIndex < 0 || selectedItemIndex != j || isToggleable)
                    {
                        view = _fld0;
                        int i = j;
                        if (selectedItemIndex == j)
                        {
                            i = -1;
                        }
                        view.selectedItemIndex = i;
                        j = selectionList.getFirstVisiblePosition();
                        view = selectionList.getChildAt(0);
                        if (view == null)
                        {
                            i = ((flag) ? 1 : 0);
                        } else
                        {
                            i = view.getTop();
                        }
                        ((SelectionListAdapter)selectionList.getAdapter()).notifyDataSetInvalidated();
                        selectionList.setSelectionFromTop(j, i);
                        if (cancelOnSelectionChanged)
                        {
                            getDialog().cancel();
                            return;
                        }
                    }
                }

            
            {
                this$1 = SelectionListAdapter.this;
                super();
            }
            });
            viewgroup.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final SelectionListAdapter this$1;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    if (flag && compoundbutton.getId() != selectedItemIndex || isToggleable)
                    {
                        onSelectionChangedListener.onSelectionChanged(compoundbutton.getId());
                        return;
                    } else
                    {
                        compoundbutton.setChecked(true);
                        return;
                    }
                }

            
            {
                this$1 = SelectionListAdapter.this;
                super();
            }
            });
            boolean flag;
            if (selectedItemIndex == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            viewgroup.setChecked(flag);
            viewgroup.setId(i);
            return view;
        }

        SelectionListAdapter()
        {
            this$0 = SelectionListDialogFragment.this;
            super();
        }
    }


    private View anchorView;
    protected boolean cancelOnSelectionChanged;
    private int heightAdjustmentInPixels;
    private LayoutInflater inflater;
    protected boolean isToggleable;
    android.content.DialogInterface.OnCancelListener onCancelListener;
    private android.content.DialogInterface.OnKeyListener onKeyListener;
    OnSelectionChangedListener onSelectionChangedListener;
    private int selectedItemIndex;
    protected String selectionItems[];
    private ListView selectionList;

    public SelectionListDialogFragment(int i, View view, OnSelectionChangedListener onselectionchangedlistener, android.content.DialogInterface.OnCancelListener oncancellistener, android.content.DialogInterface.OnKeyListener onkeylistener, int j)
    {
        isToggleable = true;
        cancelOnSelectionChanged = true;
        heightAdjustmentInPixels = 0;
        anchorView = view;
        selectedItemIndex = i;
        onSelectionChangedListener = onselectionchangedlistener;
        onCancelListener = oncancellistener;
        onKeyListener = onkeylistener;
        heightAdjustmentInPixels = j;
    }

    int dpToPx(int i)
    {
        return (int)TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    protected String getDisplayText(String s)
    {
        return s;
    }

    protected abstract int getHeaderSummaryTextId();

    protected abstract int getHeaderTitleTextId();

    public void onCancel(DialogInterface dialoginterface)
    {
        onCancelListener.onCancel(dialoginterface);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, getTheme());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = getDialog();
        bundle.getWindow().clearFlags(2);
        bundle.setCanceledOnTouchOutside(true);
        bundle.setOnKeyListener(onKeyListener);
        bundle = getArguments();
        if (bundle != null)
        {
            selectionItems = bundle.getStringArray("data");
        }
        viewgroup = layoutinflater.inflate(com.comcast.cim.android.R.layout.selection_list_dialog, viewgroup, false);
        selectionList = (ListView)viewgroup.findViewById(com.comcast.cim.android.R.id.selection_list);
        selectionList.setAdapter(new SelectionListAdapter());
        selectionList.setSelection(selectedItemIndex);
        ((TextView)viewgroup.findViewById(com.comcast.cim.android.R.id.title)).setText(getHeaderTitleTextId());
        ((TextView)viewgroup.findViewById(com.comcast.cim.android.R.id.summary)).setText(getHeaderSummaryTextId());
        inflater = layoutinflater;
        setPosition();
        ((LinearLayout)viewgroup.findViewById(com.comcast.cim.android.R.id.inner_layout)).getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final SelectionListDialogFragment this$0;

            public void onGlobalLayout()
            {
                Object obj = getDialog().getWindow().getAttributes();
                int i = getDialog().getWindow().getWindowManager().getDefaultDisplay().getHeight() - ((android.view.WindowManager.LayoutParams) (obj)).y - dpToPx(heightAdjustmentInPixels);
                obj = getView().findViewById(com.comcast.cim.android.R.id.inner_layout);
                if (((View) (obj)).getMeasuredHeight() > i)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = ((View) (obj)).getLayoutParams();
                    layoutparams.height = i;
                    ((View) (obj)).setLayoutParams(layoutparams);
                }
                ((View) (obj)).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }

            
            {
                this$0 = SelectionListDialogFragment.this;
                super();
            }
        });
        return viewgroup;
    }

    protected void setPosition()
    {
        android.view.WindowManager.LayoutParams layoutparams = getDialog().getWindow().getAttributes();
        layoutparams.width = getResources().getDimensionPixelSize(com.comcast.cim.android.R.dimen.selection_list_dialog_width);
        Rect rect = new Rect();
        anchorView.getGlobalVisibleRect(rect);
        int i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        int j = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        if (rect.top > j - rect.bottom)
        {
            getDialog().getWindow().setGravity(85);
            layoutparams.y = j - rect.top;
        } else
        {
            getDialog().getWindow().setGravity(53);
            layoutparams.y = rect.bottom;
        }
        layoutparams.x = i - rect.right;
        getDialog().getWindow().setAttributes(layoutparams);
    }





/*
    static int access$202(SelectionListDialogFragment selectionlistdialogfragment, int i)
    {
        selectionlistdialogfragment.selectedItemIndex = i;
        return i;
    }

*/

}
