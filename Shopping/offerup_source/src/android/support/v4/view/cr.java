// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            cl

final class cr
    implements Comparator
{

    cr()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (View)obj;
        obj1 = (View)obj1;
        obj = (cl)((View) (obj)).getLayoutParams();
        obj1 = (cl)((View) (obj1)).getLayoutParams();
        if (((cl) (obj)).a != ((cl) (obj1)).a)
        {
            return !((cl) (obj)).a ? -1 : 1;
        } else
        {
            return ((cl) (obj)).e - ((cl) (obj1)).e;
        }
    }
}
