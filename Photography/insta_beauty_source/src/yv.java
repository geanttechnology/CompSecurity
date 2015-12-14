// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.comlib.ui.HorizontalListView;

public class yv
    implements Runnable
{

    final HorizontalListView a;

    public yv(HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }

    public void run()
    {
        a.requestLayout();
    }
}
