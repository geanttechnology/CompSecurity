// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            BugReport

public class 
{

    public static void inject(com.f2prateek.dart.r r, BugReport bugreport, Object obj)
    {
        Object obj1 = r.r(obj, "activity_name");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'activity_name' for field 'activityName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        bugreport.activityName = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "bitmap")));
        if (r != null)
        {
            bugreport.screenshotFilename = (String)r;
        }
    }

    public ()
    {
    }
}
