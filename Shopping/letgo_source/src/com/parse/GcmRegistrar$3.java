// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            GcmRegistrar, ManifestInfo

class this._cls0
    implements ct
{

    final GcmRegistrar this$0;

    public cu then(cu cu1)
        throws Exception
    {
        boolean flag;
        if (((Long)cu1.e()).longValue() != ManifestInfo.getLastModified())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return cu.a(Boolean.valueOf(flag));
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = GcmRegistrar.this;
        super();
    }
}
