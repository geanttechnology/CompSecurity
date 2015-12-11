// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import android.content.Intent;
import com.shazam.android.k.h;
import com.shazam.i.b.ab.a;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StartIntentsData
{

    private final List intents = new ArrayList();

    public StartIntentsData()
    {
    }

    public Intent getFirstValidIntent()
    {
        return h.a(intents, a.a());
    }

    public List getIntents()
    {
        return intents;
    }

    public void setIntents(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (String)list.next();
            try
            {
                obj = Intent.parseUri(((String) (obj)), 1);
                intents.add(obj);
            }
            catch (URISyntaxException urisyntaxexception) { }
        }

    }
}
