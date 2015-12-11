// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.view.View;
import java.util.Comparator;

final class x
    implements Comparator
{

    x()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (View)obj;
        obj1 = (View)obj1;
        float f = bi.C(((View) (obj)));
        float f1 = bi.C(((View) (obj1)));
        if (f > f1)
        {
            return -1;
        }
        return f >= f1 ? 0 : 1;
    }
}
