// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            d

public class e extends d
{

    public Date c;

    public e()
    {
        c = null;
    }

    public e(Class class1, String s)
    {
        c = null;
        long l;
        try
        {
            s = new JSONObject(s);
            a = Integer.valueOf(s.optInt("totalSize", 0));
            l = s.optLong("currentTime", 0L);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                class1
            });
            a = Integer.valueOf(0);
            b = new ArrayList();
            return;
        }
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        c = new Date(l);
        s = s.getJSONArray("results");
        com.perfectcorp.utility.e.a(new Object[] {
            "Success on getting result; totalSize: ", a
        });
        b = Model.a(class1, s);
        return;
    }
}
