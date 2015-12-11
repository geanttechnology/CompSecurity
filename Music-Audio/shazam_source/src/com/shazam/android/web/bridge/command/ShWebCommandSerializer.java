// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command:
//            ShWebCommand

public class ShWebCommandSerializer
    implements t
{

    public ShWebCommandSerializer()
    {
    }

    public l serialize(ShWebCommand shwebcommand, Type type, s s1)
    {
        type = new o();
        type.a("type", s1.a(shwebcommand.getType()));
        if (shwebcommand.hasData())
        {
            type.a("data", (l)shwebcommand.getData(com/google/b/o));
        }
        return type;
    }

    public volatile l serialize(Object obj, Type type, s s1)
    {
        return serialize((ShWebCommand)obj, type, s1);
    }
}
