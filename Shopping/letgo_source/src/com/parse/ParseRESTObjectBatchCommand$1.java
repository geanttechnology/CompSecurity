// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTObjectBatchCommand, ParseException

static final class val.tcss
    implements ct
{

    final int val$batchSize;
    final List val$tcss;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public Void then(cu cu1)
        throws Exception
    {
        boolean flag = false;
        if (cu1.d() || cu1.c())
        {
            int i = 0;
            while (i < val$batchSize) 
            {
                android.support.v7.Size size = (android.support.v7.Size)val$tcss.get(i);
                if (cu1.d())
                {
                    size.Size(cu1.f());
                } else
                {
                    size.Size();
                }
                i++;
            }
        }
        cu1 = ((JSONObject)cu1.e()).getJSONArray("results");
        int l = cu1.length();
        int k = ((flag) ? 1 : 0);
        if (l != val$batchSize)
        {
            int j = 0;
            do
            {
                k = ((flag) ? 1 : 0);
                if (j >= val$batchSize)
                {
                    break;
                }
                ((android.support.v7.Size)val$tcss.get(j)).Size(new IllegalStateException((new StringBuilder()).append("Batch command result count expected: ").append(val$batchSize).append(" but was: ").append(l).toString()));
                j++;
            } while (true);
        }
        while (k < val$batchSize) 
        {
            JSONObject jsonobject = cu1.getJSONObject(k);
            android.support.v7.Size size1 = (android.support.v7.Size)val$tcss.get(k);
            if (jsonobject.has("success"))
            {
                size1.Size(jsonobject.getJSONObject("success"));
            } else
            if (jsonobject.has("error"))
            {
                jsonobject = jsonobject.getJSONObject("error");
                size1.Size(new ParseException(jsonobject.getInt("code"), jsonobject.getString("error")));
            }
            k++;
        }
        return null;
    }

    (int i, List list)
    {
        val$batchSize = i;
        val$tcss = list;
        super();
    }
}
