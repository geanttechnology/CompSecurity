// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.widget.ListView;

// Referenced classes of package com.ebay.mobile.widget:
//            SwipeDismissListViewTouchListener

public static interface 
{

    public abstract boolean canDismiss(int i);

    public abstract void onDismiss(ListView listview, int i);

    public abstract void onUndismiss(ListView listview, int i);
}
