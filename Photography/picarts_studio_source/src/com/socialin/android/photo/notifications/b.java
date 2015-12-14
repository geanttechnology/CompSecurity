// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.notifications;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.socialin.android.picsart.profile.invite.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.notifications:
//            a, d

public final class b extends CountDownTimer
{

    private List a;
    private View b;
    private a c;

    public b(a a1, long l, List list, View view)
    {
        c = a1;
        super(l, 1000L);
        b = view;
        a = null;
        a = new ArrayList();
        a.addAll(list);
    }

    public final void onFinish()
    {
        if (b != null)
        {
            b.setVisibility(8);
        }
    }

    public final void onTick(long l)
    {
        String s1;
        Iterator iterator;
        s1 = i.a(com.socialin.android.photo.notifications.a.d(c), l);
        iterator = a.iterator();
_L3:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        d d1 = (d)iterator.next();
        if (d1.a != null)
        {
            String s;
            if (d1.b != null && d1.b.contains("KEY_TIME"))
            {
                s = d1.b.replace("KEY_TIME", s1);
            } else
            {
                s = s1;
            }
            d1.a.setText(s);
            d1.a.setVisibility(0);
        }
        if (true) goto _L3; else goto _L2
_L2:
    }
}
