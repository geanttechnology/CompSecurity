// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            l

private class <init>
    implements android.view..OnClickListener
{

    final l a;

    public void onClick(View view)
    {
        ((<init>)view).b().d();
        int j = l.a(a).getChildCount();
        int i = 0;
        while (i < j) 
        {
            View view1 = l.a(a).getChildAt(i);
            boolean flag;
            if (view1 == view)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view1.setSelected(flag);
            i++;
        }
    }

    private ompat(l l1)
    {
        a = l1;
        super();
    }

    a(l l1, a a1)
    {
        this(l1);
    }
}
