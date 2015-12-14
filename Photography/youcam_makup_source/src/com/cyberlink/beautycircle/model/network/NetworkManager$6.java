// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.g;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager

final class 
    implements Runnable
{

    public void run()
    {
        if (Globals.d != null)
        {
            g.a(Globals.d, Globals.n().getPackageName(), "BeautyCircle", "suggest_update_app");
        }
    }

    ()
    {
    }
}
