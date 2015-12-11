// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.os.Message;
import io.presage.services.e;

// Referenced classes of package io.presage.services.for:
//            b

final class c
    implements android.os.Handler.Callback
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public final boolean handleMessage(Message message)
    {
        a.f().g();
        return false;
    }
}
