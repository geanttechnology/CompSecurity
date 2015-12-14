// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCToastView

class a
    implements android.view.hangeListener
{

    final BCToastView a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        i = ((View)view.getParent()).getHeight();
        BCToastView.a(a, i - j);
    }

    (BCToastView bctoastview)
    {
        a = bctoastview;
        super();
    }
}
