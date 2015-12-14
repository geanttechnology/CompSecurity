// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;


// Referenced classes of package com.socialin.android.views:
//            HorizontalListView

final class a
    implements Runnable
{

    private HorizontalListView a;

    public final void run()
    {
        a.requestLayout();
    }

    (HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }
}
