// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.widget.Toolbar;
import android.view.View;

public class gd
    implements android.view.View.OnClickListener
{

    final Toolbar a;

    public gd(Toolbar toolbar)
    {
        a = toolbar;
        super();
    }

    public void onClick(View view)
    {
        a.collapseActionView();
    }
}
