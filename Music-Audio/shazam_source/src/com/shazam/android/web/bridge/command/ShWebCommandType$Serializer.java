// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command;

import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command:
//            ShWebCommandType

public static class 
    implements t
{

    public l serialize(ShWebCommandType shwebcommandtype, Type type, s s)
    {
        return new r(ShWebCommandType.access$000(shwebcommandtype));
    }

    public volatile l serialize(Object obj, Type type, s s)
    {
        return serialize((ShWebCommandType)obj, type, s);
    }

    public ()
    {
    }
}
