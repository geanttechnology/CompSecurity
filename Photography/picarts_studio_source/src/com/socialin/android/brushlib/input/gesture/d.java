// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.socialin.android.brushlib.input.gesture:
//            c, GestureResponse

public final class d
{

    private List a;
    private List b;
    private List c;

    public d()
    {
        a = new LinkedList();
        b = new ArrayList();
        c = new ArrayList();
    }

    public final void a(c c1)
    {
        a.add(c1);
    }

    public final boolean a(MotionEvent motionevent)
    {
        switch (motionevent.getActionMasked())
        {
        default:
            b.clear();
            Iterator iterator = a.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                c c2 = (c)iterator.next();
                if (c2.a(motionevent) == GestureResponse.ACCEPT)
                {
                    b.add(c2);
                }
            } while (true);
            break;

        case 2: // '\002'
            if (b.size() > 0)
            {
                c.clear();
                Iterator iterator1 = b.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    c c3 = (c)iterator1.next();
                    if (c3.a(motionevent) == GestureResponse.REJECT)
                    {
                        c.add(c3);
                    }
                } while (true);
                c c1;
                for (motionevent = c.iterator(); motionevent.hasNext(); b.remove(c1))
                {
                    c1 = (c)motionevent.next();
                }

            }
            break;
        }
        return b.size() != 0;
    }
}
