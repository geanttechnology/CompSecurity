// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.app.Activity;
import com.tremorvideo.sdk.android.videoad.h;
import com.tremorvideo.sdk.android.videoad.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            e, h

public class f
    implements e
{

    private h a;
    private Activity b;
    private ArrayList c;

    public f(Activity activity, h h1)
    {
        c = new ArrayList();
        a = h1;
        b = activity;
    }

    public void a()
    {
        a.a(c);
    }

    public void a(float f1, int i)
    {
        com.tremorvideo.sdk.android.richmedia.a.h h1 = b(i);
        if (h1 != null)
        {
            h1.a(f1);
        }
    }

    public void a(int i)
    {
        a.a(b(i));
    }

    public void a(android.widget.RelativeLayout.LayoutParams layoutparams, int i)
    {
        com.tremorvideo.sdk.android.richmedia.a.h h1 = b(i);
        a.a(layoutparams, h1);
    }

    public void a(com.tremorvideo.sdk.android.richmedia.a.h h1)
    {
        a.c(h1);
    }

    public void a(String s1, String s2, int i)
    {
        try
        {
            s2 = new JSONObject(s2);
            JSONObject jsonobject = a.r().r().f;
            s1 = new com.tremorvideo.sdk.android.richmedia.a.h(b, i, s1, s2, jsonobject);
            s1.a(this);
            c.add(s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
    }

    public void a(String s1, List list)
    {
        a.b(s1, list);
    }

    public com.tremorvideo.sdk.android.richmedia.a.h b(int i)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            com.tremorvideo.sdk.android.richmedia.a.h h1 = (com.tremorvideo.sdk.android.richmedia.a.h)iterator.next();
            if (i == h1.a())
            {
                return h1;
            }
        }

        return null;
    }

    public void b()
    {
        if (c != null)
        {
            c.clear();
            c = null;
            System.gc();
        }
    }
}
