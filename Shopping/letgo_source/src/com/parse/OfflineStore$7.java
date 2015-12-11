// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore

class val.uuid
    implements ct
{

    final OfflineStore this$0;
    final cs val$uuid;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public String then(cu cu1)
        throws Exception
    {
        cu1 = (Cursor)cu1.e();
        cu1.moveToFirst();
        if (cu1.isAfterLast())
        {
            cu1.close();
            throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append((String)val$uuid.a()).toString());
        } else
        {
            String s = cu1.getString(0);
            cu1.close();
            return s;
        }
    }

    eption()
    {
        this$0 = final_offlinestore;
        val$uuid = cs.this;
        super();
    }
}
