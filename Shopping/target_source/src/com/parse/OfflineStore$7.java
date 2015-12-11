// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;
import android.database.Cursor;

// Referenced classes of package com.parse:
//            OfflineStore

class val.uuid
    implements i
{

    final OfflineStore this$0;
    final h val$uuid;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public String then(j j1)
        throws Exception
    {
        j1 = (Cursor)j1.e();
        j1.moveToFirst();
        if (j1.isAfterLast())
        {
            j1.close();
            throw new IllegalStateException((new StringBuilder()).append("Attempted to find non-existent uuid ").append((String)val$uuid.a()).toString());
        } else
        {
            String s = j1.getString(0);
            j1.close();
            return s;
        }
    }

    eption()
    {
        this$0 = final_offlinestore;
        val$uuid = h.this;
        super();
    }
}
