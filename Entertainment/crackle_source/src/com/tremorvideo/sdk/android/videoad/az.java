// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw

public class az
{

    File a;
    private int b;
    private String c;
    private String d;
    private List e;

    public az(JSONObject jsonobject)
        throws Exception
    {
        a = null;
        b = jsonobject.getInt("survey-skip-seconds") * 1000;
        c = jsonobject.getString("survey-link");
        d = jsonobject.getString("survey-image");
        if (!jsonobject.has("events"))
        {
            e = new ArrayList();
        } else
        {
            jsonobject = jsonobject.getJSONArray("events");
            e = new ArrayList(jsonobject.length());
            int i = 0;
            while (i < jsonobject.length()) 
            {
                e.add(new aw(jsonobject.getJSONObject(i)));
                i++;
            }
        }
    }

    public int a()
    {
        return b;
    }

    public aw a(aw.b b1)
    {
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == b1)
            {
                return aw1;
            }
        }

        return null;
    }

    public void a(File file)
    {
        a = file;
    }

    public String b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public File d()
    {
        return a;
    }
}
