// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            Toolbar

class a
    implements android.view.ckListener
{

    final Toolbar a;

    public void onClick(View view)
    {
        a.collapseActionView();
    }

    (Toolbar toolbar)
    {
        a = toolbar;
        super();
    }
}
