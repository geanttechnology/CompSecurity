// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            an, ct, al, cw

public final class ak
    implements an
{

    private final al fm;

    public ak(al al1)
    {
        fm = al1;
    }

    public void a(cw cw, Map map)
    {
        cw = (String)map.get("name");
        if (cw == null)
        {
            ct.v("App event with no name parameter.");
            return;
        } else
        {
            fm.onAppEvent(cw, (String)map.get("info"));
            return;
        }
    }
}
