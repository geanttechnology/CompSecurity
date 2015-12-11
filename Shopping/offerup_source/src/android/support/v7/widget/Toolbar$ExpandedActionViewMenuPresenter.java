// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.x;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.ImageButton;

// Referenced classes of package android.support.v7.widget:
//            Toolbar

class <init>
    implements x
{

    m mCurrentExpandedItem;
    i mMenu;
    final Toolbar this$0;

    public boolean collapseItemActionView(i j, m m1)
    {
        if (mExpandedActionView instanceof CollapsibleActionView)
        {
            ((CollapsibleActionView)mExpandedActionView).onActionViewCollapsed();
        }
        removeView(mExpandedActionView);
        removeView(Toolbar.access$300(Toolbar.this));
        mExpandedActionView = null;
        addChildrenForExpandedActionView();
        mCurrentExpandedItem = null;
        requestLayout();
        m1.e(false);
        return true;
    }

    public boolean expandItemActionView(i j, m m1)
    {
        Toolbar.access$200(Toolbar.this);
        if (Toolbar.access$300(Toolbar.this).getParent() != Toolbar.this)
        {
            addView(Toolbar.access$300(Toolbar.this));
        }
        mExpandedActionView = m1.getActionView();
        mCurrentExpandedItem = m1;
        if (mExpandedActionView.getParent() != Toolbar.this)
        {
            j = generateDefaultLayoutParams();
            j._fld0 = 0x800003 | Toolbar.access$400(Toolbar.this) & 0x70;
            j._fld0 = 2;
            mExpandedActionView.setLayoutParams(j);
            addView(mExpandedActionView);
        }
        removeChildrenForExpandedActionView();
        requestLayout();
        m1.e(true);
        if (mExpandedActionView instanceof CollapsibleActionView)
        {
            ((CollapsibleActionView)mExpandedActionView).onActionViewExpanded();
        }
        return true;
    }

    public boolean flagActionItems()
    {
        return false;
    }

    public int getId()
    {
        return 0;
    }

    public void initForMenu(Context context, i j)
    {
        if (mMenu != null && mCurrentExpandedItem != null)
        {
            mMenu.b(mCurrentExpandedItem);
        }
        mMenu = j;
    }

    public void onCloseMenu(i j, boolean flag)
    {
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
        return null;
    }

    public boolean onSubMenuSelected(ac ac)
    {
        return false;
    }

    public void updateMenuView(boolean flag)
    {
        boolean flag2 = false;
        if (mCurrentExpandedItem == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = flag2;
        if (mMenu == null) goto _L4; else goto _L3
_L3:
        int j;
        int k;
        k = mMenu.size();
        j = 0;
_L9:
        flag1 = flag2;
        if (j >= k) goto _L4; else goto _L5
_L5:
        if (mMenu.getItem(j) != mCurrentExpandedItem) goto _L7; else goto _L6
_L6:
        flag1 = true;
_L4:
        if (!flag1)
        {
            collapseItemActionView(mMenu, mCurrentExpandedItem);
        }
_L2:
        return;
_L7:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private ()
    {
        this$0 = Toolbar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
