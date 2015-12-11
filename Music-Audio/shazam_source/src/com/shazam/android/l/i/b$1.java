// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.i;

import com.shazam.model.share.ShareDataItem;
import java.util.Comparator;

// Referenced classes of package com.shazam.android.l.i:
//            b

final class a
    implements Comparator
{

    final b a;

    public final int compare(Object obj, Object obj1)
    {
        obj = (ShareDataItem)obj;
        obj1 = (ShareDataItem)obj1;
        return b.a(a, ((ShareDataItem) (obj)).intentPackageName) - b.a(a, ((ShareDataItem) (obj1)).intentPackageName);
    }

    eDataItem(b b1)
    {
        a = b1;
        super();
    }
}
