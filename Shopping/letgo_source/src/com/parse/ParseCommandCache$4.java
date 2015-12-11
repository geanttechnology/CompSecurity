// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseCommandCache, ParseRESTCommand, ParseException, LocalIdManager

class val.tcs
    implements ct
{

    final ParseCommandCache this$0;
    final ParseRESTCommand val$command;
    final android.support.v7.ance val$tcs;

    public cu then(cu cu1)
        throws Exception
    {
_L2:
        do
        {
            return cu1;
        } while ((obj instanceof ParseException) && ((ParseException)obj).getCode() == 100 || val$tcs == null);
        val$tcs.nd(((Exception) (obj)));
        return cu1;
        String s = val$command.getLocalId();
        Object obj = cu1.f();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        obj = (JSONObject)cu1.e();
        if (val$tcs != null)
        {
            val$tcs.nd(obj);
            return cu1;
        }
        if (s != null)
        {
            obj = ((JSONObject) (obj)).optString("objectId", null);
            if (obj != null)
            {
                LocalIdManager.getDefaultInstance().setObjectId(s, ((String) (obj)));
                return cu1;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = final_parsecommandcache;
        val$command = parserestcommand;
        val$tcs = android.support.v7.nd.this;
        super();
    }
}
