// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseInstallation, ParseCurrentInstallationController

class this._cls0
    implements i
{

    final ParseInstallation this$0;

    public j then(j j)
        throws Exception
    {
        return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    tionController()
    {
        this$0 = ParseInstallation.this;
        super();
    }
}
