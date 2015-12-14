// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.location.Location;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseGeoPoint

static final class 
    implements Continuation
{

    public ParseGeoPoint then(Task task)
        throws Exception
    {
        task = (Location)task.getResult();
        return new ParseGeoPoint(task.getLatitude(), task.getLongitude());
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
    }
}
