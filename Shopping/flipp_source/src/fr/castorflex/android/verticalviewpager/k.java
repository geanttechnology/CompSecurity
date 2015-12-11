// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import android.view.View;
import java.util.Comparator;

// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            f

final class k
    implements Comparator
{

    k()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (View)obj;
        obj1 = (View)obj1;
        obj = (f)((View) (obj)).getLayoutParams();
        obj1 = (f)((View) (obj1)).getLayoutParams();
        if (((f) (obj)).a != ((f) (obj1)).a)
        {
            return !((f) (obj)).a ? -1 : 1;
        } else
        {
            return ((f) (obj)).e - ((f) (obj1)).e;
        }
    }
}
