// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import org.json.JSONObject;

public class d
{

    public Integer a;
    public ArrayList b;

    public d()
    {
        a = null;
        b = null;
    }

    public d(Class class1, String s)
    {
        a = null;
        b = null;
        try
        {
            s = new JSONObject(s);
            a = Integer.valueOf(s.optInt("totalSize", 0));
            s = s.getJSONArray("results");
            e.a(new Object[] {
                "Success on getting result; totalSize: ", a
            });
            b = Model.a(class1, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            e.e(new Object[] {
                class1
            });
        }
        a = Integer.valueOf(0);
        b = new ArrayList();
    }
}
