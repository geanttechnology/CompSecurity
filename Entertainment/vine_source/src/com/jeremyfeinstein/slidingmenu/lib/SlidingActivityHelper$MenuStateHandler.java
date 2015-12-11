// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.view.DragEvent;
import android.view.View;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            SlidingActivityHelper

public static class mListener
    implements android.view.elper.MenuStateHandler, mListener, mListener, mListener, mListener, android.view.enListener
{
    public static interface MenuStateListener
    {

        public abstract void onMenuClick(View view);

        public abstract void onMenuClose();

        public abstract void onMenuClosed();

        public abstract boolean onMenuDrag(View view, DragEvent dragevent);

        public abstract void onMenuOpen();

        public abstract void onMenuOpened();
    }


    private final MenuStateListener mListener;

    public void onClick(View view)
    {
        mListener.onMenuClick(view);
    }

    public void onClose()
    {
        mListener.onMenuClose();
    }

    public void onClosed()
    {
        mListener.onMenuClosed();
    }

    public boolean onDrag(View view, DragEvent dragevent)
    {
        return mListener.onMenuDrag(view, dragevent);
    }

    public void onOpen()
    {
        mListener.onMenuOpen();
    }

    public void onOpened()
    {
        mListener.onMenuOpened();
    }

    public MenuStateListener(MenuStateListener menustatelistener)
    {
        mListener = menustatelistener;
    }
}
