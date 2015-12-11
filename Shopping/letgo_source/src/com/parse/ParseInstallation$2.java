// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseInstallation, Parse

static final class 
    implements Callable
{

    public Boolean call()
        throws Exception
    {
        return Boolean.valueOf((new File(Parse.getParseDir(), "currentInstallation")).exists());
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ()
    {
    }
}
