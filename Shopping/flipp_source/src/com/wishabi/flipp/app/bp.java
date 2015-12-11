// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.graphics.RectF;
import com.wishabi.flipp.widget.bi;
import java.util.Comparator;

// Referenced classes of package com.wishabi.flipp.app:
//            bo

final class bp
    implements Comparator
{

    final bo a;

    bp(bo bo)
    {
        a = bo;
        super();
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (bi)obj;
        obj1 = (bi)obj1;
        return Float.compare(((bi) (obj)).a.left, ((bi) (obj1)).a.left);
    }
}
