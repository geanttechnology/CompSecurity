// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            HotTopicActivity

class a
    implements b
{

    final HotTopicActivity a;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        Globals.b("Get AccountToken Success");
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    (HotTopicActivity hottopicactivity)
    {
        a = hottopicactivity;
        super();
    }
}
