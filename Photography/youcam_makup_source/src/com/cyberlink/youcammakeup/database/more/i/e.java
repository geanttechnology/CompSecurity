// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.i;

import java.net.URI;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.i:
//            d

public class e
{

    final d a;
    private String b;
    private URI c;
    private URI d;
    private URI e;
    private boolean f;
    private URI g;
    private String h;

    public e(d d1, JSONObject jsonobject)
    {
        a = d1;
        super();
        b = jsonobject.getString("itemGUID");
        try
        {
            c = URI.create(jsonobject.getString("freeSampleURL"));
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            c = URI.create("");
        }
        try
        {
            d = URI.create(jsonobject.getString("shoppingURL"));
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            d = URI.create("");
        }
        try
        {
            e = URI.create(jsonobject.getString("moreInfoURL"));
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            e = URI.create("");
        }
        f = jsonobject.getBoolean("hot");
        if (jsonobject.has("itemThumbnailURL") && jsonobject.has("itemDescription"))
        {
            try
            {
                g = URI.create(jsonobject.getString("itemThumbnailURL"));
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                g = URI.create("");
            }
            h = jsonobject.getString("itemDescription");
        }
    }

    public String a()
    {
        return b;
    }

    public void a(URI uri)
    {
        d = uri;
    }

    public URI b()
    {
        return c;
    }

    public URI c()
    {
        return d;
    }

    public URI d()
    {
        return e;
    }

    public boolean e()
    {
        return f;
    }
}
