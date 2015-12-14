// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.nearby.messages:
//            MessageFilter

public static final class 
{

    private final List zzaJI = new ArrayList();

    private  zzE(String s, String s1)
    {
        zzaJI.add(new MessageType(s, s1));
        return this;
    }

    public MessageFilter build()
    {
        boolean flag;
        if (!zzaJI.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "At least one of the include methods must be called.");
        return new MessageFilter(zzaJI, null);
    }

    public zzaJI includeAllMyTypes()
    {
        return zzE("", "");
    }

    public zzE includeFilter(MessageFilter messagefilter)
    {
        zzaJI.addAll(messagefilter.zzyo());
        return this;
    }

    public zzaJI includeNamespacedType(String s, String s1)
    {
        return zzE(s, s1);
    }

    public ()
    {
    }
}
