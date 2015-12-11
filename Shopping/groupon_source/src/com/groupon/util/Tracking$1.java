// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.http.Http;

// Referenced classes of package com.groupon.util:
//            Tracking

class  extends Http
{

    final Tracking this$0;

    protected void onException(Exception exception)
    {
    }

    transient (Context context, Class class1, String s, Object aobj[])
    {
        this$0 = Tracking.this;
        super(context, class1, s, aobj);
    }
}
