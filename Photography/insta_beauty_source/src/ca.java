// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.ActionBarContextView;
import android.view.View;

public class ca
    implements android.view.View.OnClickListener
{

    final ee a;
    final ActionBarContextView b;

    public ca(ActionBarContextView actionbarcontextview, ee ee1)
    {
        b = actionbarcontextview;
        a = ee1;
        super();
    }

    public void onClick(View view)
    {
        a.c();
    }
}
