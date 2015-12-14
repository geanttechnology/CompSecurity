// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.database.a.a;
import com.cyberlink.beautycircle.model.database.b;
import com.cyberlink.beautycircle.model.network.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Post

public class s
{

    private JSONArray a;
    private Integer b;
    private final String c;
    private final String d;

    public s(Class class1)
    {
        a = new JSONArray();
        c = (new StringBuilder()).append(getClass().getName()).append("_").append(class1.getName()).toString();
        d = (new StringBuilder()).append(c).append("_totalSize").toString();
        a();
    }

    public d a(int i, int j)
    {
        if (i >= 0 && i < a.length()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((d) (obj));
_L2:
        d d1 = new d();
        d1.a = b;
        d1.b = new ArrayList();
        int k = Math.min(j, a.length() - i);
        j = i;
        do
        {
            obj = d1;
            if (j >= k + i)
            {
                continue;
            }
            obj = a.optJSONObject(j);
            if (obj != null)
            {
                long l = ((JSONObject) (obj)).optLong("postId", -1L);
                obj = com.cyberlink.beautycircle.model.database.b.c().a(l);
                if (obj != null)
                {
                    d1.b.add(obj);
                }
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected JSONObject a(Post post)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("postId", post.postId);
            jsonobject.put("lastModified", post.lastModified.getTime());
        }
        // Misplaced declaration of an exception variable
        catch (Post post)
        {
            post.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public void a()
    {
        Integer integer = null;
        SharedPreferences sharedpreferences = Globals.D();
        String s1 = sharedpreferences.getString(c, null);
        int i = sharedpreferences.getInt(d, -1);
        if (i != -1)
        {
            integer = Integer.valueOf(i);
        }
        b = integer;
        try
        {
            a = new JSONArray(s1);
            return;
        }
        catch (Exception exception)
        {
            a = new JSONArray();
        }
    }

    public void a(d d1)
    {
        if (d1 == null || d1.b == null || d1.b.isEmpty())
        {
            return;
        }
        b = d1.a;
        Post post;
        for (d1 = d1.b.iterator(); d1.hasNext(); a.put(a(post)))
        {
            post = (Post)d1.next();
        }

        b();
    }

    public void b()
    {
        SharedPreferences sharedpreferences = Globals.D();
        String s1 = a.toString();
        int i;
        if (b != null)
        {
            i = b.intValue();
        } else
        {
            i = -1;
        }
        sharedpreferences.edit().putString(c, s1).putInt(d, i).commit();
    }

    public void c()
    {
        a = new JSONArray();
    }
}
