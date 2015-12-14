// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.socialin.android.multiselect:
//            ItemsActivity

final class d
    implements Comparator
{

    private ItemsActivity a;

    private d(ItemsActivity itemsactivity)
    {
        a = itemsactivity;
        super();
    }

    d(ItemsActivity itemsactivity, byte byte0)
    {
        this(itemsactivity);
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (String)obj;
        obj1 = (String)obj1;
        obj = new File((new StringBuilder()).append(ItemsActivity.j(a)).append("/").append(((String) (obj))).toString());
        obj1 = new File((new StringBuilder()).append(ItemsActivity.j(a)).append("/").append(((String) (obj1))).toString());
        long l = ((File) (obj)).lastModified() - ((File) (obj1)).lastModified();
        if (l < 0L)
        {
            return 1;
        }
        return l != 0L ? -1 : 0;
    }
}
