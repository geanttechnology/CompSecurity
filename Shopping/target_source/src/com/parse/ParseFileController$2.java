// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFileController, ParseFileUtils

class val.file
    implements i
{

    final ParseFileController this$0;
    final File val$file;
    final then val$state;

    public val.file then(j j1)
        throws Exception
    {
        j1 = (JSONObject)j1.e();
        j1 = (new r(val$state)).name(j1.getString("name")).url(j1.getString("url")).build();
        try
        {
            ParseFileUtils.copyFile(val$file, getCacheFile(j1));
        }
        catch (IOException ioexception)
        {
            return j1;
        }
        return j1;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    r()
    {
        this$0 = final_parsefilecontroller;
        val$state = r;
        val$file = File.this;
        super();
    }
}
