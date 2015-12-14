// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bp;

import android.app.Activity;
import android.widget.TextView;
import com.picsart.shop.m;

public class a
{

    public m a;

    public a(m m1)
    {
        a = m1;
        super();
    }

    public void a(String s)
    {
        Activity activity = a.getActivity();
        if (activity != null && !activity.isFinishing())
        {
            m.b();
            if (s != null && !"".equals(s))
            {
                m.q(a).setText(s);
                return;
            }
        }
    }
}
