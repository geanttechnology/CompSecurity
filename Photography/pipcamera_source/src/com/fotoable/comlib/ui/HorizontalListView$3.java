// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.ui;


// Referenced classes of package com.fotoable.comlib.ui:
//            HorizontalListView

class a
    implements Runnable
{

    final HorizontalListView a;

    public void run()
    {
        a.requestLayout();
    }

    (HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }
}
