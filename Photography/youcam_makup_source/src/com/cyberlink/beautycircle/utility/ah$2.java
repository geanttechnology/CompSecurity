// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.j;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ah

class a extends j
{

    final Bundle a;
    final ah b;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        Iterator iterator;
        void1 = new JSONObject();
        iterator = a.keySet().iterator();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (android.os..VERSION.SDK_INT >= 19) goto _L4; else goto _L3
_L3:
        void1.put(s, ah.a(b, a.get(s)));
          goto _L5
_L4:
        try
        {
            void1.put(s, JSONObject.wrap(a.get(s)));
        }
        catch (Exception exception) { }
_L5:
        if (true) goto _L6; else goto _L2
_L2:
        void1 = void1.toString();
        Globals.D().edit().putString("KEY_WEIBO_TOKEN", void1).commit();
        return null;
    }

    (ah ah1, Bundle bundle)
    {
        b = ah1;
        a = bundle;
        super();
    }
}
