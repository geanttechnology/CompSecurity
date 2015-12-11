// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.ah;
import android.view.View;
import java.util.Comparator;

// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout

static class 
    implements Comparator
{

    public int a(View view, View view1)
    {
        float f = ah.A(view);
        float f1 = ah.A(view1);
        if (f > f1)
        {
            return -1;
        }
        return f >= f1 ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((View)obj, (View)obj1);
    }

    ()
    {
    }
}
