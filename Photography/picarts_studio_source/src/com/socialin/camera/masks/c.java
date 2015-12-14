// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.masks;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.camera.masks:
//            d

public final class c
{

    String a;
    public String b;
    public ArrayList c;

    public c()
    {
    }

    public final String a(Context context)
    {
        String s1 = a;
        String s = s1;
        if (d.b.containsKey(s1))
        {
            s = context.getString(((Integer)d.b.get(s1)).intValue());
        }
        return s;
    }
}
