// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command:
//            ShWebCommandType, ShWebCommand

public class ShWebCommandDeserializer
    implements k
{

    public ShWebCommandDeserializer()
    {
    }

    public ShWebCommand deserialize(l l1, Type type, j j1)
    {
        return ShWebCommand.fromTypeAndData((ShWebCommandType)j1.a(l1.g().a("type"), com/shazam/android/web/bridge/command/ShWebCommandType), l1.g().a("data").toString());
    }

    public volatile Object deserialize(l l1, Type type, j j1)
    {
        return deserialize(l1, type, j1);
    }
}
