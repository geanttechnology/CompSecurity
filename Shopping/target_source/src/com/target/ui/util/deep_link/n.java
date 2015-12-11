// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.model.store.interfaces.Store;
import java.util.List;

// Referenced classes of package com.target.ui.util.deep_link:
//            o, f, r

public class n
{

    public static f a(Uri uri, Store store)
    {
        Object obj;
        obj = uri.getPathSegments();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return o.a(uri, store);
        }
        obj = (String)((List) (obj)).get(0);
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 80
    //                   47: 121
    //                   99: 149
    //                   112: 163
    //                   115: 135;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte byte0 = -1;
_L7:
        switch (byte0)
        {
        default:
            return new f(uri);

        case 0: // '\0'
            return o.a(uri, store);

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return r.a(uri, store);
        }
_L2:
        if (!((String) (obj)).equals("/")) goto _L1; else goto _L6
_L6:
        byte0 = 0;
          goto _L7
_L5:
        if (!((String) (obj)).equals("s")) goto _L1; else goto _L8
_L8:
        byte0 = 1;
          goto _L7
_L3:
        if (!((String) (obj)).equals("c")) goto _L1; else goto _L9
_L9:
        byte0 = 2;
          goto _L7
_L4:
        if (!((String) (obj)).equals("p")) goto _L1; else goto _L10
_L10:
        byte0 = 3;
          goto _L7
    }
}
