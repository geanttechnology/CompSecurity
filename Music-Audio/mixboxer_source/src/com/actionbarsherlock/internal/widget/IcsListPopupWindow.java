// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

public class IcsListPopupWindow
{

    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private ListAdapter mAdapter;
    private Context mContext;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private android.widget.AdapterView.OnItemClickListener mItemClickListener;
    private android.widget.AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    public IcsListPopupWindow(Context context)
    {
        this(context, null, com.actionbarsherlock.R.attr.listPopupWindowStyle);
    }

    public IcsListPopupWindow(Context context, AttributeSet attributeset, int i)
    {
        mDropDownHeight = -2;
        mDropDownWidth = -2;
        mListItemExpandMaximum = 0x7fffffff;
        mPromptPosition = 0;
        mResizePopupRunnable = new ResizePopupRunnable(null);
        mTouchInterceptor = new PopupTouchInterceptor(null);
        mScrollListener = new PopupScrollListener(null);
        mHideSelector = new ListSelectorHider(null);
        mHandler = new Handler();
        mTempRect = new Rect();
        mContext = context;
        mPopup = new PopupWindow(context, attributeset, i);
        mPopup.setInputMethodMode(1);
    }

    public IcsListPopupWindow(Context context, AttributeSet attributeset, int i, int j)
    {
        mDropDownHeight = -2;
        mDropDownWidth = -2;
        mListItemExpandMaximum = 0x7fffffff;
        mPromptPosition = 0;
        mResizePopupRunnable = new ResizePopupRunnable(null);
        mTouchInterceptor = new PopupTouchInterceptor(null);
        mScrollListener = new PopupScrollListener(null);
        mHideSelector = new ListSelectorHider(null);
        mHandler = new Handler();
        mTempRect = new Rect();
        mContext = context;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            mPopup = new PopupWindow(new ContextThemeWrapper(context, j), attributeset, i);
        } else
        {
            mPopup = new PopupWindow(context, attributeset, i, j);
        }
        mPopup.setInputMethodMode(1);
    }

    private int buildDropDown()
    {
        boolean flag1 = true;
        if (mDropDownList != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        View view1;
        android.widget.LinearLayout.LayoutParams layoutparams1;
        int i;
        boolean flag;
        obj1 = mContext;
        int j;
        int l;
        if (!mModal)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mDropDownList = new DropDownListView(((Context) (obj1)), flag);
        if (mDropDownListHighlight != null)
        {
            mDropDownList.setSelector(mDropDownListHighlight);
        }
        mDropDownList.setAdapter(mAdapter);
        mDropDownList.setOnItemClickListener(mItemClickListener);
        mDropDownList.setFocusable(true);
        mDropDownList.setFocusableInTouchMode(true);
        mDropDownList.setOnItemSelectedListener(new _cls1());
        mDropDownList.setOnScrollListener(mScrollListener);
        if (mItemSelectedListener != null)
        {
            mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
        }
        obj = mDropDownList;
        view1 = mPromptView;
        if (view1 == null)
        {
            break MISSING_BLOCK_LABEL_513;
        }
        obj1 = new LinearLayout(((Context) (obj1)));
        ((LinearLayout) (obj1)).setOrientation(1);
        layoutparams1 = new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F);
        mPromptPosition;
        JVM INSTR tableswitch 0 1: default 204
    //                   0 391
    //                   1 376;
           goto _L3 _L4 _L5
_L3:
        view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(mDropDownWidth, 0x80000000), 0);
        obj = (android.widget.LinearLayout.LayoutParams)view1.getLayoutParams();
        i = view1.getMeasuredHeight();
        j = ((android.widget.LinearLayout.LayoutParams) (obj)).topMargin;
        i = ((android.widget.LinearLayout.LayoutParams) (obj)).bottomMargin + (i + j);
        obj = obj1;
_L7:
        mPopup.setContentView(((View) (obj)));
          goto _L6
_L5:
        ((LinearLayout) (obj1)).addView(((View) (obj)), layoutparams1);
        ((LinearLayout) (obj1)).addView(view1);
          goto _L3
_L4:
        ((LinearLayout) (obj1)).addView(view1);
        ((LinearLayout) (obj1)).addView(((View) (obj)), layoutparams1);
          goto _L3
_L2:
        mPopup.getContentView();
        View view = mPromptView;
        int j1;
        int k1;
        if (view != null)
        {
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
            i = view.getMeasuredHeight();
            k = layoutparams.topMargin;
            i = layoutparams.bottomMargin + (i + k);
        } else
        {
            i = 0;
        }
_L6:
        obj = mPopup.getBackground();
        int k;
        int i1;
        if (obj != null)
        {
            ((Drawable) (obj)).getPadding(mTempRect);
            j = mTempRect.top;
            l = mTempRect.bottom;
            if (!mDropDownVerticalOffsetSet)
            {
                mDropDownVerticalOffset = -mTempRect.top;
            }
            k += l;
        } else
        {
            k = 0;
        }
        if (mPopup.getInputMethodMode() == 2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        i1 = getMaxAvailableHeight(mDropDownAnchorView, mDropDownVerticalOffset, flag);
        if (mDropDownHeight == -1)
        {
            return i1 + k;
        }
        k1 = measureHeightOfChildren(0, 0, -1, i1 - i, -1);
        j1 = i;
        if (k1 > 0)
        {
            j1 = i + k;
        }
        return k1 + j1;
        i = 0;
          goto _L7
    }

    private int getMaxAvailableHeight(View view, int i, boolean flag)
    {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int j = rect.bottom;
        if (flag)
        {
            j = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        j = Math.max(j - (ai[1] + view.getHeight()) - i, (ai[1] - rect.top) + i);
        i = j;
        if (mPopup.getBackground() != null)
        {
            mPopup.getBackground().getPadding(mTempRect);
            i = j - (mTempRect.top + mTempRect.bottom);
        }
        return i;
    }

    private boolean isInputMethodNotNeeded()
    {
        return mPopup.getInputMethodMode() == 2;
    }

    private int measureHeightOfChildren(int i, int j, int k, int l, int i1)
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = mAdapter;
        if (obj != null) goto _L2; else goto _L1
_L1:
        int j1 = mDropDownList.getListPaddingTop() + mDropDownList.getListPaddingBottom();
_L7:
        return j1;
_L2:
        int k1;
        int j2;
        int k2 = mDropDownList.getListPaddingTop() + mDropDownList.getListPaddingBottom();
        int l1;
        int i2;
        if (mDropDownList.getDividerHeight() > 0 && mDropDownList.getDivider() != null)
        {
            l1 = mDropDownList.getDividerHeight();
        } else
        {
            l1 = 0;
        }
        k1 = k2;
        j1 = ((flag) ? 1 : 0);
        j2 = j;
        i2 = k;
        if (k == -1)
        {
            i2 = ((ListAdapter) (obj)).getCount() - 1;
            j2 = j;
            j1 = ((flag) ? 1 : 0);
            k1 = k2;
        }
_L5:
        if (j2 > i2) goto _L4; else goto _L3
_L3:
        obj = mAdapter.getView(j2, null, mDropDownList);
        if (mDropDownList.getCacheColorHint() != 0)
        {
            ((View) (obj)).setDrawingCacheBackgroundColor(mDropDownList.getCacheColorHint());
        }
        measureScrapChild(((View) (obj)), j2, i);
        j = k1;
        if (j2 > 0)
        {
            j = k1 + l1;
        }
        k = ((View) (obj)).getMeasuredHeight() + j;
        if (k >= l)
        {
            if (i1 < 0 || j2 <= i1 || j1 <= 0 || k == l)
            {
                return l;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (i1 >= 0 && j2 >= i1)
        {
            j = k;
        } else
        {
            j = j1;
        }
        j2++;
        k1 = k;
        j1 = j;
        if (true) goto _L5; else goto _L4
_L4:
        return k1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void measureScrapChild(View view, int i, int j)
    {
        android.widget.AbsListView.LayoutParams layoutparams1 = (android.widget.AbsListView.LayoutParams)view.getLayoutParams();
        android.widget.AbsListView.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new android.widget.AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutparams);
        }
        j = ViewGroup.getChildMeasureSpec(j, mDropDownList.getPaddingLeft() + mDropDownList.getPaddingRight(), layoutparams.width);
        i = layoutparams.height;
        if (i > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(j, i);
    }

    public void clearListSelection()
    {
        DropDownListView dropdownlistview = mDropDownList;
        if (dropdownlistview != null)
        {
            dropdownlistview.mListSelectionHidden = true;
            dropdownlistview.requestLayout();
        }
    }

    public void dismiss()
    {
        mPopup.dismiss();
        if (mPromptView != null)
        {
            android.view.ViewParent viewparent = mPromptView.getParent();
            if (viewparent instanceof ViewGroup)
            {
                ((ViewGroup)viewparent).removeView(mPromptView);
            }
        }
        mPopup.setContentView(null);
        mDropDownList = null;
        mHandler.removeCallbacks(mResizePopupRunnable);
    }

    public ListView getListView()
    {
        return mDropDownList;
    }

    public boolean isShowing()
    {
        return mPopup.isShowing();
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mObserver != null) goto _L2; else goto _L1
_L1:
        mObserver = new PopupDataSetObserver(null);
_L4:
        mAdapter = listadapter;
        if (mAdapter != null)
        {
            listadapter.registerDataSetObserver(mObserver);
        }
        if (mDropDownList != null)
        {
            mDropDownList.setAdapter(mAdapter);
        }
        return;
_L2:
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAnchorView(View view)
    {
        mDropDownAnchorView = view;
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i)
    {
        Drawable drawable = mPopup.getBackground();
        if (drawable != null)
        {
            drawable.getPadding(mTempRect);
            mDropDownWidth = mTempRect.left + mTempRect.right + i;
            return;
        } else
        {
            mDropDownWidth = i;
            return;
        }
    }

    public void setHorizontalOffset(int i)
    {
        mDropDownHorizontalOffset = i;
    }

    public void setInputMethodMode(int i)
    {
        mPopup.setInputMethodMode(i);
    }

    public void setModal(boolean flag)
    {
        mModal = true;
        mPopup.setFocusable(flag);
    }

    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        mPopup.setOnDismissListener(ondismisslistener);
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        mItemClickListener = onitemclicklistener;
    }

    public void setPromptPosition(int i)
    {
        mPromptPosition = i;
    }

    public void setSelection(int i)
    {
        DropDownListView dropdownlistview = mDropDownList;
        if (isShowing() && dropdownlistview != null)
        {
            dropdownlistview.mListSelectionHidden = false;
            dropdownlistview.setSelection(i);
            if (dropdownlistview.getChoiceMode() != 0)
            {
                dropdownlistview.setItemChecked(i, true);
            }
        }
    }

    public void setVerticalOffset(int i)
    {
        mDropDownVerticalOffset = i;
        mDropDownVerticalOffsetSet = true;
    }

    public void show()
    {
        int j;
        byte byte1;
        byte byte2;
        boolean flag;
        boolean flag1;
        flag = false;
        byte1 = 0;
        byte2 = -1;
        j = buildDropDown();
        flag1 = isInputMethodNotNeeded();
        if (!mPopup.isShowing()) goto _L2; else goto _L1
_L1:
        int i;
        if (mDropDownWidth == -1)
        {
            i = -1;
        } else
        if (mDropDownWidth == -2)
        {
            i = mDropDownAnchorView.getWidth();
        } else
        {
            i = mDropDownWidth;
        }
        if (mDropDownHeight != -1) goto _L4; else goto _L3
_L3:
        if (!flag1)
        {
            j = -1;
        }
        if (flag1)
        {
            PopupWindow popupwindow = mPopup;
            if (mDropDownWidth == -1)
            {
                byte1 = byte2;
            } else
            {
                byte1 = 0;
            }
            popupwindow.setWindowLayoutMode(byte1, 0);
        } else
        {
            PopupWindow popupwindow1 = mPopup;
            if (mDropDownWidth == -1)
            {
                byte1 = -1;
            }
            popupwindow1.setWindowLayoutMode(byte1, -1);
        }
_L8:
        mPopup.setOutsideTouchable(true);
        mPopup.update(mDropDownAnchorView, mDropDownHorizontalOffset, mDropDownVerticalOffset, i, j);
_L6:
        return;
_L4:
        if (mDropDownHeight != -2)
        {
            j = mDropDownHeight;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        byte byte0;
        if (mDropDownWidth == -1)
        {
            byte0 = -1;
        } else
        if (mDropDownWidth == -2)
        {
            mPopup.setWidth(mDropDownAnchorView.getWidth());
            byte0 = 0;
        } else
        {
            mPopup.setWidth(mDropDownWidth);
            byte0 = 0;
        }
        if (mDropDownHeight == -1)
        {
            j = -1;
        } else
        if (mDropDownHeight == -2)
        {
            mPopup.setHeight(j);
            j = ((flag) ? 1 : 0);
        } else
        {
            mPopup.setHeight(mDropDownHeight);
            j = ((flag) ? 1 : 0);
        }
        mPopup.setWindowLayoutMode(byte0, j);
        mPopup.setOutsideTouchable(true);
        mPopup.setTouchInterceptor(mTouchInterceptor);
        mPopup.showAsDropDown(mDropDownAnchorView, mDropDownHorizontalOffset, mDropDownVerticalOffset);
        mDropDownList.setSelection(-1);
        if (!mModal || mDropDownList.isInTouchMode())
        {
            clearListSelection();
        }
        if (mModal) goto _L6; else goto _L5
_L5:
        mHandler.post(mHideSelector);
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }







    private class ResizePopupRunnable
        implements Runnable
    {

        final IcsListPopupWindow this$0;

        public void run()
        {
            if (mDropDownList != null && mDropDownList.getCount() > mDropDownList.getChildCount() && mDropDownList.getChildCount() <= mListItemExpandMaximum)
            {
                mPopup.setInputMethodMode(2);
                show();
            }
        }

        private ResizePopupRunnable()
        {
            this$0 = IcsListPopupWindow.this;
            super();
        }

        ResizePopupRunnable(_cls1 _pcls1)
        {
            this();
        }
    }


    private class PopupTouchInterceptor
        implements android.view.View.OnTouchListener
    {

        final IcsListPopupWindow this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            int i;
            int j;
            int k;
            i = motionevent.getAction();
            j = (int)motionevent.getX();
            k = (int)motionevent.getY();
            if (i != 0 || mPopup == null || !mPopup.isShowing() || j < 0 || j >= mPopup.getWidth() || k < 0 || k >= mPopup.getHeight()) goto _L2; else goto _L1
_L1:
            mHandler.postDelayed(mResizePopupRunnable, 250L);
_L4:
            return false;
_L2:
            if (i == 1)
            {
                mHandler.removeCallbacks(mResizePopupRunnable);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private PopupTouchInterceptor()
        {
            this$0 = IcsListPopupWindow.this;
            super();
        }

        PopupTouchInterceptor(_cls1 _pcls1)
        {
            this();
        }
    }


    private class PopupScrollListener
        implements android.widget.AbsListView.OnScrollListener
    {

        final IcsListPopupWindow this$0;

        public void onScroll(AbsListView abslistview, int i, int j, int k)
        {
        }

        public void onScrollStateChanged(AbsListView abslistview, int i)
        {
            if (i == 1 && !isInputMethodNotNeeded() && mPopup.getContentView() != null)
            {
                mHandler.removeCallbacks(mResizePopupRunnable);
                mResizePopupRunnable.run();
            }
        }

        private PopupScrollListener()
        {
            this$0 = IcsListPopupWindow.this;
            super();
        }

        PopupScrollListener(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ListSelectorHider
        implements Runnable
    {

        final IcsListPopupWindow this$0;

        public void run()
        {
            clearListSelection();
        }

        private ListSelectorHider()
        {
            this$0 = IcsListPopupWindow.this;
            super();
        }

        ListSelectorHider(_cls1 _pcls1)
        {
            this();
        }
    }


    private class DropDownListView extends ListView
    {

        private boolean mHijackFocus;
        private boolean mListSelectionHidden;

        public boolean hasFocus()
        {
            return mHijackFocus || super.hasFocus();
        }

        public boolean hasWindowFocus()
        {
            return mHijackFocus || super.hasWindowFocus();
        }

        public boolean isFocused()
        {
            return mHijackFocus || super.isFocused();
        }

        public boolean isInTouchMode()
        {
            return mHijackFocus && mListSelectionHidden || super.isInTouchMode();
        }


/*
        static boolean access$502(DropDownListView dropdownlistview, boolean flag)
        {
            dropdownlistview.mListSelectionHidden = flag;
            return flag;
        }

*/

        public DropDownListView(Context context, boolean flag)
        {
            super(context, null, com.actionbarsherlock.R.attr.dropDownListViewStyle);
            mHijackFocus = flag;
            setCacheColorHint(0);
        }
    }


    private class _cls1
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final IcsListPopupWindow this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            if (i != -1)
            {
                adapterview = mDropDownList;
                if (adapterview != null)
                {
                    adapterview.mListSelectionHidden = false;
                }
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        _cls1()
        {
            this$0 = IcsListPopupWindow.this;
            super();
        }
    }


    private class PopupDataSetObserver extends DataSetObserver
    {

        final IcsListPopupWindow this$0;

        public void onChanged()
        {
            if (isShowing())
            {
                show();
            }
        }

        public void onInvalidated()
        {
            dismiss();
        }

        private PopupDataSetObserver()
        {
            this$0 = IcsListPopupWindow.this;
            super();
        }

        PopupDataSetObserver(_cls1 _pcls1)
        {
            this();
        }
    }

}
