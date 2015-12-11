// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.inject;

import java.util.HashMap;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.inject:
//            ReferrerProvider

class val.attribution extends HashMap
{

    final ReferrerProvider this$0;
    final String val$attribution;
    final String val$cid;

    ()
    {
        this$0 = final_referrerprovider;
        val$cid = s;
        val$attribution = String.this;
        super();
        if (Strings.notEmpty(val$cid))
        {
            put("cid", val$cid);
        }
        if (Strings.notEmpty(val$attribution))
        {
            put("attribution", val$attribution);
        }
    }
}
