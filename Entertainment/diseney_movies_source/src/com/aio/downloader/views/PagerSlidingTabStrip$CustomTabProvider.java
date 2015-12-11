// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.aio.downloader.views:
//            PagerSlidingTabStrip

public static interface 
{

    public abstract View getCustomTabView(ViewGroup viewgroup, int i);

    public abstract void tabSelected(View view);

    public abstract void tabUnselected(View view);
}
