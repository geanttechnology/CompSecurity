// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

public class aj extends e
{

    private static final String PUSH_MESSAGE = "pushMessage";
    private String message;

    private aj(String s1)
    {
        message = s1;
    }

    public static aj a(String s1)
    {
        return new aj(s1);
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "pushMessage", message);
        return map;
    }

    protected s c()
    {
        return s.Notification;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return y.PushMessage;
    }
}
