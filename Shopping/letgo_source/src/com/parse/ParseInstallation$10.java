// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseInstallation

static final class val.installation
    implements ct
{

    final ParseInstallation val$installation;

    public cu then(cu cu)
        throws Exception
    {
        return val$installation.pinInBackground("_currentInstallation", false);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    (ParseInstallation parseinstallation)
    {
        val$installation = parseinstallation;
        super();
    }
}
