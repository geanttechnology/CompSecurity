// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseInstallation, ParseObject

static final class 
    implements ct
{

    public cu then(cu cu1)
        throws Exception
    {
        if ((ParseInstallation)cu1.e() != null)
        {
            return cu1;
        } else
        {
            return ParseObject.migrateFromDiskToLDS("currentInstallation", "_currentInstallation").i();
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
    }
}
