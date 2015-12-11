// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.cx;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.view.menu.y;
import android.view.Menu;
import android.view.ViewGroup;

// Referenced classes of package android.support.v7.internal.widget:
//            ScrollingTabContainerView

public interface DecorToolbar
{

    public abstract boolean canShowOverflowMenu();

    public abstract void collapseActionView();

    public abstract void dismissPopupMenus();

    public abstract Context getContext();

    public abstract int getDisplayOptions();

    public abstract Menu getMenu();

    public abstract int getNavigationMode();

    public abstract CharSequence getTitle();

    public abstract ViewGroup getViewGroup();

    public abstract boolean hasExpandedActionView();

    public abstract boolean hideOverflowMenu();

    public abstract void initIndeterminateProgress();

    public abstract void initProgress();

    public abstract boolean isOverflowMenuShowPending();

    public abstract boolean isOverflowMenuShowing();

    public abstract void setCollapsible(boolean flag);

    public abstract void setDisplayOptions(int i);

    public abstract void setEmbeddedTabView(ScrollingTabContainerView scrollingtabcontainerview);

    public abstract void setHomeButtonEnabled(boolean flag);

    public abstract void setIcon(int i);

    public abstract void setIcon(Drawable drawable);

    public abstract void setLogo(int i);

    public abstract void setMenu(Menu menu, y y);

    public abstract void setMenuCallbacks(y y, j j);

    public abstract void setMenuPrepared();

    public abstract void setNavigationContentDescription(int i);

    public abstract void setNavigationIcon(int i);

    public abstract void setTitle(CharSequence charsequence);

    public abstract void setVisibility(int i);

    public abstract void setWindowCallback(android.view.Window.Callback callback);

    public abstract void setWindowTitle(CharSequence charsequence);

    public abstract cx setupAnimatorToVisibility(int i, long l);

    public abstract boolean showOverflowMenu();
}
