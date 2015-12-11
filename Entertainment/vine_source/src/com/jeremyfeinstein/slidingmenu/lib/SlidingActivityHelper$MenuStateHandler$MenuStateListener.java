// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;

import android.view.DragEvent;
import android.view.View;

// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            SlidingActivityHelper

public static interface 
{

    public abstract void onMenuClick(View view);

    public abstract void onMenuClose();

    public abstract void onMenuClosed();

    public abstract boolean onMenuDrag(View view, DragEvent dragevent);

    public abstract void onMenuOpen();

    public abstract void onMenuOpened();
}
