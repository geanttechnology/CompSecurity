// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
    implements com.shazam.android.widget.slidingtabs.a
{

    public final Map a = com.shazam.i.e.a.a(0);

    public a()
    {
    }

    public final void a(int i)
    {
        Object obj = (List)a.get(Integer.valueOf(i));
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                ((com.shazam.android.widget.slidingtabs.a)((Iterator) (obj)).next()).a(i);
            }
        }
    }
}
