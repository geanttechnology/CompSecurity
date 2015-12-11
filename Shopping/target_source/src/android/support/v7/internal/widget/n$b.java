// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v7.widget.u;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            n

private class <init>
    implements android.view..OnClickListener
{

    final n a;

    public void onClick(View view)
    {
        ((<init>)view).b().d();
        int j = n.a(a).getChildCount();
        int i = 0;
        while (i < j) 
        {
            View view1 = n.a(a).getChildAt(i);
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

    private (n n1)
    {
        a = n1;
        super();
    }

    a(n n1, a a1)
    {
        this(n1);
    }
}
