// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.internal.view.menu.g;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.y;
import android.support.v7.internal.view.menu.z;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

final class refreshDecorView
{

    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    g listMenuPresenter;
    Context listPresenterContext;
    i menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    int windowAnimations;
    int x;
    int y;

    final z getListMenuView(y y1)
    {
        if (menu == null)
        {
            return null;
        }
        if (listMenuPresenter == null)
        {
            listMenuPresenter = new g(listPresenterContext, android.support.v7.appcompat.esenterContext);
            listMenuPresenter.a(y1);
            menu.a(listMenuPresenter);
        }
        return listMenuPresenter.a(decorView);
    }

    public final boolean hasPanelItems()
    {
        if (shownPanelView != null)
        {
            if (createdPanelView != null)
            {
                return true;
            }
            if (listMenuPresenter.a().getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

    final void setMenu(i j)
    {
        if (j != menu)
        {
            if (menu != null)
            {
                menu.b(listMenuPresenter);
            }
            menu = j;
            if (j != null && listMenuPresenter != null)
            {
                j.a(listMenuPresenter);
                return;
            }
        }
    }

    final void setStyle(Context context)
    {
        TypedValue typedvalue = new TypedValue();
        android.content.res.te te = context.getResources().newTheme();
        te.te(context.getTheme());
        te.te(android.support.v7.appcompat.nuPresenter, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        }
        te.te(android.support.v7.appcompat.nuPresenter, typedvalue, true);
        if (typedvalue.resourceId != 0)
        {
            te.te(typedvalue.resourceId, true);
        } else
        {
            te.te(android.support.v7.appcompat.nuPresenter, true);
        }
        context = new ContextThemeWrapper(context, 0);
        context.getTheme().nu(te);
        listPresenterContext = context;
        context = context.obtainStyledAttributes(android.support.v7.appcompat.esenterContext);
        background = context.getResourceId(android.support.v7.appcompat.ound, 0);
        windowAnimations = context.getResourceId(android.support.v7.appcompat.tyle, 0);
        context.recycle();
    }

    (int j)
    {
        featureId = j;
        refreshDecorView = false;
    }
}
