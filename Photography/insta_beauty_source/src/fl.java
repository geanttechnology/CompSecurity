// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.SearchView;

public class fl
    implements Runnable
{

    final SearchView a;

    public fl(SearchView searchview)
    {
        a = searchview;
        super();
    }

    public void run()
    {
        SearchView.access$000(a);
    }
}
