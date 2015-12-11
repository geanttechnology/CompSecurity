// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

// Referenced classes of package android.support.v7.internal.view.menu:
//            x, w, i, y, 
//            ac, m

public class v
    implements x, android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener
{

    static final int ITEM_LAYOUT;
    private final w mAdapter;
    private View mAnchorView;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    boolean mForceShowIcon;
    private boolean mHasContentWidth;
    private final LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private final i mMenu;
    private final boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private y mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    public v(Context context, i j, View view)
    {
        this(context, j, view, false, android.support.v7.appcompat.R.attr.popupMenuStyle);
    }

    public v(Context context, i j, View view, boolean flag, int k)
    {
        this(context, j, view, flag, k, 0);
    }

    public v(Context context, i j, View view, boolean flag, int k, int l)
    {
        mDropDownGravity = 0;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mMenu = j;
        mAdapter = new w(this, mMenu);
        mOverflowOnly = flag;
        mPopupStyleAttr = k;
        mPopupStyleRes = l;
        Resources resources = context.getResources();
        mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.appcompat.R.dimen.abc_config_prefDialogWidth));
        mAnchorView = view;
        j.a(this, context);
    }

    private int measureContentWidth()
    {
        w w1 = mAdapter;
        int j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int l1 = w1.getCount();
        int k = 0;
        int l = 0;
        View view = null;
        int j = 0;
        do
        {
            int i1;
label0:
            {
                i1 = j;
                if (k < l1)
                {
                    i1 = w1.getItemViewType(k);
                    if (i1 != l)
                    {
                        l = i1;
                        view = null;
                    }
                    if (mMeasureParent == null)
                    {
                        mMeasureParent = new FrameLayout(mContext);
                    }
                    view = w1.getView(k, view, mMeasureParent);
                    view.measure(j1, k1);
                    i1 = view.getMeasuredWidth();
                    if (i1 < mPopupMaxWidth)
                    {
                        break label0;
                    }
                    i1 = mPopupMaxWidth;
                }
                return i1;
            }
            if (i1 > j)
            {
                j = i1;
            }
            k++;
        } while (true);
    }

    public boolean collapseItemActionView(i j, m m)
    {
        return false;
    }

    public void dismiss()
    {
        if (isShowing())
        {
            mPopup.dismiss();
        }
    }

    public boolean expandItemActionView(i j, m m)
    {
        return false;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public int getId()
    {
        return 0;
    }

    public ListPopupWindow getPopup()
    {
        return mPopup;
    }

    public void initForMenu(Context context, i j)
    {
    }

    public boolean isShowing()
    {
        return mPopup != null && mPopup.isShowing();
    }

    public void onCloseMenu(i j, boolean flag)
    {
        if (j == mMenu)
        {
            dismiss();
            if (mPresenterCallback != null)
            {
                mPresenterCallback.onCloseMenu(j, flag);
                return;
            }
        }
    }

    public void onDismiss()
    {
        mPopup = null;
        mMenu.close();
        if (mTreeObserver != null)
        {
            if (!mTreeObserver.isAlive())
            {
                mTreeObserver = mAnchorView.getViewTreeObserver();
            }
            mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        }
    }

    public void onGlobalLayout()
    {
        if (isShowing())
        {
            View view = mAnchorView;
            if (view == null || !view.isShown())
            {
                dismiss();
            } else
            if (isShowing())
            {
                mPopup.show();
                return;
            }
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int j, long l)
    {
        adapterview = mAdapter;
        w.a(adapterview).a(adapterview.a(j), 0);
    }

    public boolean onKey(View view, int j, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 1 && j == 82)
        {
            dismiss();
            return true;
        } else
        {
            return false;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
        return null;
    }

    public boolean onSubMenuSelected(ac ac1)
    {
        if (!ac1.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        v v1;
        int j;
        int k;
        v1 = new v(mContext, ac1, mAnchorView);
        v1.setCallback(mPresenterCallback);
        k = ac1.size();
        j = 0;
_L5:
        MenuItem menuitem;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        menuitem = ac1.getItem(j);
        if (!menuitem.isVisible() || menuitem.getIcon() == null) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        v1.setForceShowIcon(flag);
        if (v1.tryShow())
        {
            if (mPresenterCallback != null)
            {
                mPresenterCallback.onOpenSubMenu(ac1);
            }
            return true;
        }
          goto _L2
_L4:
        j++;
          goto _L5
_L2:
        return false;
        flag = false;
          goto _L6
    }

    public void setAnchorView(View view)
    {
        mAnchorView = view;
    }

    public void setCallback(y y1)
    {
        mPresenterCallback = y1;
    }

    public void setForceShowIcon(boolean flag)
    {
        mForceShowIcon = flag;
    }

    public void setGravity(int j)
    {
        mDropDownGravity = j;
    }

    public void show()
    {
        if (!tryShow())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        } else
        {
            return;
        }
    }

    public boolean tryShow()
    {
        boolean flag = false;
        mPopup = new ListPopupWindow(mContext, null, mPopupStyleAttr, mPopupStyleRes);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(true);
        View view = mAnchorView;
        if (view != null)
        {
            if (mTreeObserver == null)
            {
                flag = true;
            }
            mTreeObserver = view.getViewTreeObserver();
            if (flag)
            {
                mTreeObserver.addOnGlobalLayoutListener(this);
            }
            mPopup.setAnchorView(view);
            mPopup.setDropDownGravity(mDropDownGravity);
            if (!mHasContentWidth)
            {
                mContentWidth = measureContentWidth();
                mHasContentWidth = true;
            }
            mPopup.setContentWidth(mContentWidth);
            mPopup.setInputMethodMode(2);
            mPopup.show();
            mPopup.getListView().setOnKeyListener(this);
            return true;
        } else
        {
            return false;
        }
    }

    public void updateMenuView(boolean flag)
    {
        mHasContentWidth = false;
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    static 
    {
        ITEM_LAYOUT = android.support.v7.appcompat.R.layout.abc_popup_menu_item_layout;
    }



}
