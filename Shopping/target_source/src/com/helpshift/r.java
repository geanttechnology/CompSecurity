// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.k;
import java.util.ArrayList;

// Referenced classes of package com.helpshift:
//            l, ab, x, HSSectionFragment, 
//            s

public final class r extends k
{

    private static ArrayList a = new ArrayList();
    private l b;
    private s c;
    private int d;

    public r(h h, Context context, String s)
    {
        super(h);
        b = new l(context);
        c = b.a;
        a.clear();
        d = -1;
        int i;
        try
        {
            a = b.b();
        }
        // Misplaced declaration of an exception variable
        catch (h h)
        {
            x.b("HelpShiftDebug", h.toString(), h);
            return;
        }
        i = 0;
label0:
        {
            if (i < a.size())
            {
                if (!((ab)a.get(i)).a().equals(s))
                {
                    break label0;
                }
                d = i;
            }
            c();
            return;
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_52;
        }
    }

    public Fragment a(int i)
    {
        Object obj = (ab)a.get(i);
        HSSectionFragment hssectionfragment = new HSSectionFragment();
        obj = ((ab) (obj)).a();
        Bundle bundle = new Bundle();
        bundle.putString("sectionPublishId", ((String) (obj)));
        hssectionfragment.setArguments(bundle);
        return hssectionfragment;
    }

    public int b()
    {
        return a.size();
    }

    public void b(int i)
    {
        d = i;
    }

    public CharSequence c(int i)
    {
        return ((ab)a.get(i)).b();
    }

    public int d()
    {
        return d;
    }

}
