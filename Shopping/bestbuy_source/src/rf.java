// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.api.g;
import java.util.List;

public class rf
    implements Runnable
{

    final g a;
    private final int b;
    private final pp c;

    public rf(g g1, int i, pp pp1)
    {
        a = g1;
        super();
        b = i;
        c = pp1;
    }

    public void run()
    {
        if (c.a())
        {
            try
            {
                int i = a.getActivity().getSupportFragmentManager().getFragments().indexOf(a);
                c.a(a.getActivity(), (i + 1 << 16) + 1);
                return;
            }
            catch (android.content.IntentSender.SendIntentException sendintentexception)
            {
                g.a(a);
            }
            return;
        }
        if (pu.c(c.c()))
        {
            pu.a(c.c(), a.getActivity(), a, 2, a);
            return;
        } else
        {
            g.a(a, b, c);
            return;
        }
    }
}
