// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;

// Referenced classes of package com.parse:
//            ParseObject, Parse, ParseFileUtils

static final class val.disk
    implements ct
{

    final ParseObject val$disk;
    final String val$filename;

    public ParseObject then(cu cu1)
        throws Exception
    {
        if (!cu1.d())
        {
            ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), val$filename));
        }
        return val$disk;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    (String s, ParseObject parseobject)
    {
        val$filename = s;
        val$disk = parseobject;
        super();
    }
}
