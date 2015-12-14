// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.database.Group;
import com.cyberlink.you.friends.e;
import com.cyberlink.you.friends.i;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class m
    implements e, i
{

    final MessageSettingActivity a;
    private int b;
    private Group c;

    public m(MessageSettingActivity messagesettingactivity, Group group)
    {
        a = messagesettingactivity;
        super();
        b = 1;
        c = group;
    }

    private void a()
    {
        b = b + 1;
        MessageSettingActivity.a(a, c, b);
    }

    public void a(Object obj)
    {
        if (obj != null)
        {
            obj = (List)obj;
            MessageSettingActivity.a(a, ((List) (obj)));
            if (((List) (obj)).size() == 20)
            {
                a();
            }
        }
    }

    public void a(String s)
    {
    }
}
