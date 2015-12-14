// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.view.View;
import android.widget.EditText;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.c:
//            c

class a
    implements android.view..OnClickListener
{

    final c a;

    public void onClick(View view)
    {
        if (c.b(a) == null)
        {
            return;
        } else
        {
            view = c.b(a).getText().toString();
            HashMap hashmap = new HashMap();
            hashmap.put("text", view);
            a.a("sendText", hashmap);
            return;
        }
    }

    kListener(c c1)
    {
        a = c1;
        super();
    }
}
