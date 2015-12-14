// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.view;

import android.view.MenuItem;

public interface PhotosNavigationPane
{
    public static interface EnabledChangedListener
    {

        public abstract void OnEnabledChanged(boolean flag);
    }

    public static interface SidePanelListener
    {

        public abstract void onClosed();

        public abstract void onDragged();

        public abstract void onNavigate(MenuItem menuitem);

        public abstract void onOpened();
    }


    public abstract void addSidePanelListener(SidePanelListener sidepanellistener);

    public abstract boolean getSideBarEnabled();

    public abstract void open();

    public abstract void removeSidePanelListener(SidePanelListener sidepanellistener);

    public abstract void select(int i);

    public abstract void setEnabledChangedListener(EnabledChangedListener enabledchangedlistener);

    public abstract void setItemInvisible(int i);

    public abstract void setItemVisible(int i);

    public abstract void setSideBarEnabled(boolean flag);
}
