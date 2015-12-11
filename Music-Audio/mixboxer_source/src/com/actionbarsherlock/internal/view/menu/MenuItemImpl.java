// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuBuilder, SubMenuBuilder

public final class MenuItemImpl
    implements MenuItem
{

    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private static String sDeleteShortcutLabel;
    private static String sEnterShortcutLabel;
    private static String sPrependShortcutLabel;
    private static String sSpaceShortcutLabel;
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener mClickListener;
    private int mFlags;
    private final int mGroup;
    private Drawable mIconDrawable;
    private int mIconResId;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    private MenuBuilder mMenu;
    private android.view.ContextMenu.ContextMenuInfo mMenuInfo;
    private com.actionbarsherlock.view.MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;

    MenuItemImpl(MenuBuilder menubuilder, int i, int j, int k, int l, CharSequence charsequence, int i1)
    {
        mIconResId = 0;
        mFlags = 16;
        mShowAsAction = 0;
        mIsActionViewExpanded = false;
        mMenu = menubuilder;
        mId = j;
        mGroup = i;
        mCategoryOrder = k;
        mOrdering = l;
        mTitle = charsequence;
        mShowAsAction = i1;
    }

    public final void actionFormatChanged()
    {
        mMenu.onItemActionRequestChanged(this);
    }

    public final boolean collapseActionView()
    {
        if ((mShowAsAction & 8) != 0)
        {
            if (mActionView == null)
            {
                return true;
            }
            if (mOnActionExpandListener == null || mOnActionExpandListener.onMenuItemActionCollapse(this))
            {
                return mMenu.collapseItemActionView(this);
            }
        }
        return false;
    }

    public final boolean expandActionView()
    {
        while ((mShowAsAction & 8) == 0 || mActionView == null || mOnActionExpandListener != null && !mOnActionExpandListener.onMenuItemActionExpand(this)) 
        {
            return false;
        }
        return mMenu.expandItemActionView(this);
    }

    public final ActionProvider getActionProvider()
    {
        return mActionProvider;
    }

    public final View getActionView()
    {
        if (mActionView != null)
        {
            return mActionView;
        }
        if (mActionProvider != null)
        {
            mActionView = mActionProvider.onCreateActionView();
            return mActionView;
        } else
        {
            return null;
        }
    }

    public final char getAlphabeticShortcut()
    {
        return mShortcutAlphabeticChar;
    }

    final Runnable getCallback()
    {
        return mItemCallback;
    }

    public final int getGroupId()
    {
        return mGroup;
    }

    public final Drawable getIcon()
    {
        if (mIconDrawable != null)
        {
            return mIconDrawable;
        }
        if (mIconResId != 0)
        {
            return mMenu.getResources().getDrawable(mIconResId);
        } else
        {
            return null;
        }
    }

    public final Intent getIntent()
    {
        return mIntent;
    }

    public final int getItemId()
    {
        return mId;
    }

    public final android.view.ContextMenu.ContextMenuInfo getMenuInfo()
    {
        return mMenuInfo;
    }

    public final char getNumericShortcut()
    {
        return mShortcutNumericChar;
    }

    public final int getOrder()
    {
        return mCategoryOrder;
    }

    public final int getOrdering()
    {
        return mOrdering;
    }

    final char getShortcut()
    {
        if (mMenu.isQwertyMode())
        {
            return mShortcutAlphabeticChar;
        } else
        {
            return mShortcutNumericChar;
        }
    }

    final String getShortcutLabel()
    {
        char c;
        StringBuilder stringbuilder;
        c = getShortcut();
        if (c == 0)
        {
            return "";
        }
        stringbuilder = new StringBuilder(sPrependShortcutLabel);
        c;
        JVM INSTR lookupswitch 3: default 60
    //                   8: 82
    //                   10: 71
    //                   32: 93;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuilder.append(c);
_L6:
        return stringbuilder.toString();
_L3:
        stringbuilder.append(sEnterShortcutLabel);
        continue; /* Loop/switch isn't completed */
_L2:
        stringbuilder.append(sDeleteShortcutLabel);
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(sSpaceShortcutLabel);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final SubMenu getSubMenu()
    {
        return mSubMenu;
    }

    public final CharSequence getTitle()
    {
        return mTitle;
    }

    public final CharSequence getTitleCondensed()
    {
        if (mTitleCondensed != null)
        {
            return mTitleCondensed;
        } else
        {
            return mTitle;
        }
    }

    final CharSequence getTitleForItemView(MenuView.ItemView itemview)
    {
        if (itemview != null && itemview.prefersCondensedTitle())
        {
            return getTitleCondensed();
        } else
        {
            return getTitle();
        }
    }

    public final boolean hasCollapsibleActionView()
    {
        return (mShowAsAction & 8) != 0 && mActionView != null;
    }

    public final boolean hasSubMenu()
    {
        return mSubMenu != null;
    }

    public final boolean invoke()
    {
_L2:
        return true;
        if (mClickListener != null && mClickListener.onMenuItemClick(this) || mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this)) goto _L2; else goto _L1
_L1:
        if (mItemCallback != null)
        {
            mItemCallback.run();
            return true;
        }
        if (mIntent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mMenu.getContext().startActivity(mIntent);
        return true;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        if (mActionProvider != null && mActionProvider.onPerformDefaultAction()) goto _L2; else goto _L3
_L3:
        return false;
    }

    public final boolean isActionButton()
    {
        return (mFlags & 0x20) == 32;
    }

    public final boolean isActionViewExpanded()
    {
        return mIsActionViewExpanded;
    }

    public final boolean isCheckable()
    {
        return (mFlags & 1) == 1;
    }

    public final boolean isChecked()
    {
        return (mFlags & 2) == 2;
    }

    public final boolean isEnabled()
    {
        return (mFlags & 0x10) != 0;
    }

    public final boolean isExclusiveCheckable()
    {
        return (mFlags & 4) != 0;
    }

    public final boolean isVisible()
    {
        return (mFlags & 8) == 0;
    }

    public final boolean requestsActionButton()
    {
        return (mShowAsAction & 1) == 1;
    }

    public final boolean requiresActionButton()
    {
        return (mShowAsAction & 2) == 2;
    }

    public final MenuItem setActionProvider(ActionProvider actionprovider)
    {
        mActionView = null;
        mActionProvider = actionprovider;
        mMenu.onItemsChanged(true);
        return this;
    }

    public final MenuItem setActionView(int i)
    {
        Context context = mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final MenuItem setActionView(View view)
    {
        mActionView = view;
        mActionProvider = null;
        if (view != null && view.getId() == -1 && mId > 0)
        {
            view.setId(mId);
        }
        mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public final void setActionViewExpanded(boolean flag)
    {
        mIsActionViewExpanded = flag;
        mMenu.onItemsChanged(false);
    }

    public final MenuItem setAlphabeticShortcut(char c)
    {
        if (mShortcutAlphabeticChar == c)
        {
            return this;
        } else
        {
            mShortcutAlphabeticChar = Character.toLowerCase(c);
            mMenu.onItemsChanged(false);
            return this;
        }
    }

    public final MenuItem setCallback(Runnable runnable)
    {
        mItemCallback = runnable;
        return this;
    }

    public final MenuItem setCheckable(boolean flag)
    {
        int i = mFlags;
        int j = mFlags;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mFlags = flag1 | j & -2;
        if (i != mFlags)
        {
            mMenu.onItemsChanged(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean flag)
    {
        if ((mFlags & 4) != 0)
        {
            mMenu.setExclusiveItemChecked(this);
            return this;
        } else
        {
            setCheckedInt(flag);
            return this;
        }
    }

    final void setCheckedInt(boolean flag)
    {
        int i = mFlags;
        int j = mFlags;
        byte byte0;
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        mFlags = byte0 | j & -3;
        if (i != mFlags)
        {
            mMenu.onItemsChanged(false);
        }
    }

    public final MenuItem setEnabled(boolean flag)
    {
        if (flag)
        {
            mFlags = mFlags | 0x10;
        } else
        {
            mFlags = mFlags & 0xffffffef;
        }
        mMenu.onItemsChanged(false);
        return this;
    }

    public final void setExclusiveCheckable(boolean flag)
    {
        int i = mFlags;
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        mFlags = byte0 | i & -5;
    }

    public final MenuItem setIcon(int i)
    {
        mIconDrawable = null;
        mIconResId = i;
        mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable)
    {
        mIconResId = 0;
        mIconDrawable = drawable;
        mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent)
    {
        mIntent = intent;
        return this;
    }

    public final void setIsActionButton(boolean flag)
    {
        if (flag)
        {
            mFlags = mFlags | 0x20;
            return;
        } else
        {
            mFlags = mFlags & 0xffffffdf;
            return;
        }
    }

    final void setMenuInfo(android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        mMenuInfo = contextmenuinfo;
    }

    public final MenuItem setNumericShortcut(char c)
    {
        if (mShortcutNumericChar == c)
        {
            return this;
        } else
        {
            mShortcutNumericChar = c;
            mMenu.onItemsChanged(false);
            return this;
        }
    }

    public final MenuItem setOnActionExpandListener(com.actionbarsherlock.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        mOnActionExpandListener = onactionexpandlistener;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        mClickListener = onmenuitemclicklistener;
        return this;
    }

    public final MenuItem setShortcut(char c, char c1)
    {
        mShortcutNumericChar = c;
        mShortcutAlphabeticChar = Character.toLowerCase(c1);
        mMenu.onItemsChanged(false);
        return this;
    }

    public final void setShowAsAction(int i)
    {
        switch (i & 3)
        {
        default:
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            mShowAsAction = i;
            break;
        }
        mMenu.onItemActionRequestChanged(this);
    }

    public final MenuItem setShowAsActionFlags(int i)
    {
        setShowAsAction(i);
        return this;
    }

    final void setSubMenu(SubMenuBuilder submenubuilder)
    {
        mSubMenu = submenubuilder;
        submenubuilder.setHeaderTitle(getTitle());
    }

    public final MenuItem setTitle(int i)
    {
        return setTitle(((CharSequence) (mMenu.getContext().getString(i))));
    }

    public final MenuItem setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        mMenu.onItemsChanged(false);
        if (mSubMenu != null)
        {
            mSubMenu.setHeaderTitle(charsequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charsequence)
    {
        mTitleCondensed = charsequence;
        mMenu.onItemsChanged(false);
        return this;
    }

    public final MenuItem setVisible(boolean flag)
    {
        if (setVisibleInt(flag))
        {
            mMenu.onItemVisibleChanged(this);
        }
        return this;
    }

    final boolean setVisibleInt(boolean flag)
    {
        boolean flag1 = false;
        int i = mFlags;
        int j = mFlags;
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 8;
        }
        mFlags = byte0 | j & -9;
        flag = flag1;
        if (i != mFlags)
        {
            flag = true;
        }
        return flag;
    }

    public final boolean shouldShowIcon()
    {
        return mMenu.getOptionalIconsVisible();
    }

    final boolean shouldShowShortcut()
    {
        return mMenu.isShortcutsVisible() && getShortcut() != 0;
    }

    public final boolean showsTextAsAction()
    {
        return (mShowAsAction & 4) == 4;
    }

    public final String toString()
    {
        return mTitle.toString();
    }
}
