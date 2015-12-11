// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFileController, ParseFileUtils

class val.data
    implements ct
{

    final ParseFileController this$0;
    final byte val$data[];
    final then val$state;

    public val.data then(cu cu1)
        throws Exception
    {
        cu1 = (JSONObject)cu1.e();
        cu1 = (new r(val$state)).name(cu1.getString("name")).url(cu1.getString("url")).build();
        try
        {
            ParseFileUtils.writeByteArrayToFile(getCacheFile(cu1), val$data);
        }
        catch (IOException ioexception)
        {
            return cu1;
        }
        return cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    r()
    {
        this$0 = final_parsefilecontroller;
        val$state = r;
        val$data = _5B_B.this;
        super();
    }
}
