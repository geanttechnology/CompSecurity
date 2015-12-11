// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            GcmRegistrar, ManifestInfo

class this._cls0
    implements i
{

    final GcmRegistrar this$0;

    public j then(j j1)
        throws Exception
    {
        boolean flag;
        if (((Long)j1.e()).longValue() != ManifestInfo.getLastModified())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return j.a(Boolean.valueOf(flag));
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
