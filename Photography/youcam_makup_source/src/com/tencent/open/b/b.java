// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class b
    implements Serializable
{

    public final HashMap a = new HashMap();

    public b(Bundle bundle)
    {
        if (bundle != null)
        {
            String s;
            for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); a.put(s, bundle.getString(s)))
            {
                s = (String)iterator.next();
            }

        }
    }
}
