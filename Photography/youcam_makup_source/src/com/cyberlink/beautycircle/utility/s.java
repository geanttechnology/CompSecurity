// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.tencent.tauth.b;
import org.json.JSONObject;

public abstract class s
    implements b
{

    Class d;

    public s(Class class1)
    {
        d = class1;
    }

    public abstract void a(Model model);

    public void a(Object obj)
    {
        if (obj instanceof JSONObject)
        {
            a(Model.a(d, (JSONObject)obj));
            return;
        } else
        {
            e.e(new Object[] {
                "Login fail: Response is not a valid JSONObject."
            });
            a(((com.tencent.tauth.d) (null)));
            return;
        }
    }
}
