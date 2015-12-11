// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command.data:
//            IsIntentSupportedResponseData

public static class 
    implements k
{

    public  deserialize(l l1, Type type, j j)
    {
        l1 = l1.h().b();
        type = ();
        int i1 = type.length;
        for (int i = 0; i < i1; i++)
        {
            j = type[i];
            if ((j).equals(l1))
            {
                return j;
            }
        }

        return ;
    }

    public volatile Object deserialize(l l1, Type type, j j)
    {
        return deserialize(l1, type, j);
    }

    public ()
    {
    }
}
