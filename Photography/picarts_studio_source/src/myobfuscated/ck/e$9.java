// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.graphics.Point;
import java.util.Observable;
import java.util.Observer;
import myobfuscated.cm.n;
import myobfuscated.cv.c;

// Referenced classes of package myobfuscated.ck:
//            e, c

final class it>
    implements Observer
{

    private e a;

    public final void update(Observable observable, Object obj)
    {
        observable = ((n)obj).c;
        obj = e.d(a);
        break MISSING_BLOCK_LABEL_16;
        if (obj != null && !((Activity) (obj)).isFinishing() && observable != null)
        {
            Point point = e.a(a).a;
            if (point != null)
            {
                c.a(((Activity) (obj)), observable, point.x, point.y);
                return;
            }
        }
        return;
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
