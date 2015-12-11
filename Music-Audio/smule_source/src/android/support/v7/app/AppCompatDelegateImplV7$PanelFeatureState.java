// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.g;
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
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    g listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;

    void applyFrozenState()
    {
        if (menu != null && frozenMenuState != null)
        {
            menu.b(frozenMenuState);
            frozenMenuState = null;
        }
    }

    public void clearMenuPresenters()
    {
        if (menu != null)
        {
            menu.b(listMenuPresenter);
        }
        listMenuPresenter = null;
    }

    MenuView getListMenuView(android.support.v7.internal.view.menu.er er)
    {
        if (menu == null)
        {
            return null;
        }
        if (listMenuPresenter == null)
        {
            listMenuPresenter = new g(listPresenterContext, android.support.v7.appcompat.esenterContext);
            listMenuPresenter.setCallback(er);
            menu.a(listMenuPresenter);
        }
        return listMenuPresenter.getMenuView(decorView);
    }

    public boolean hasPanelItems()
    {
        boolean flag1 = true;
        boolean flag;
        if (shownPanelView == null)
        {
            flag = false;
        } else
        {
            flag = flag1;
            if (createdPanelView == null)
            {
                flag = flag1;
                if (listMenuPresenter.a().getCount() <= 0)
                {
                    return false;
                }
            }
        }
        return flag;
    }

    void onRestoreInstanceState(Parcelable parcelable)
    {
        class SavedState
            implements Parcelable
        {

            public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

                public SavedState createFromParcel(Parcel parcel)
                {
                    return SavedState.readFromParcel(parcel);
                }

                public volatile Object createFromParcel(Parcel parcel)
                {
                    return createFromParcel(parcel);
                }

                public SavedState[] newArray(int i)
                {
                    return new SavedState[i];
                }

                public volatile Object[] newArray(int i)
                {
                    return newArray(i);
                }

            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            private static SavedState readFromParcel(Parcel parcel)
            {
                boolean flag = true;
                SavedState savedstate = new SavedState();
                savedstate.featureId = parcel.readInt();
                if (parcel.readInt() != 1)
                {
                    flag = false;
                }
                savedstate.isOpen = flag;
                if (savedstate.isOpen)
                {
                    savedstate.menuState = parcel.readBundle();
                }
                return savedstate;
            }

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
                parcel.writeInt(featureId);
                if (isOpen)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                parcel.writeInt(i);
                if (isOpen)
                {
                    parcel.writeBundle(menuState);
                }
            }



            private SavedState()
            {
            }

            SavedState(AppCompatDelegateImplV7._cls1 _pcls1)
            {
                this();
            }
        }

        parcelable = (SavedState)parcelable;
        featureId = ((SavedState) (parcelable)).featureId;
        wasLastOpen = ((SavedState) (parcelable)).isOpen;
        frozenMenuState = ((SavedState) (parcelable)).menuState;
        shownPanelView = null;
        decorView = null;
    }

    Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(null);
        savedstate.featureId = featureId;
        savedstate.isOpen = isOpen;
        if (menu != null)
        {
            savedstate.menuState = new Bundle();
            menu.a(savedstate.menuState);
        }
        return savedstate;
    }

    void setMenu(MenuBuilder menubuilder)
    {
        if (menubuilder != menu)
        {
            if (menu != null)
            {
                menu.b(listMenuPresenter);
            }
            menu = menubuilder;
            if (menubuilder != null && listMenuPresenter != null)
            {
                menubuilder.a(listMenuPresenter);
                return;
            }
        }
    }

    void setStyle(Context context)
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

    SavedState(int i)
    {
        featureId = i;
        refreshDecorView = false;
    }
}
