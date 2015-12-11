// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            cd

final class bi
{

    int a;
    int b;
    Boolean c;
    private Boolean d;

    bi()
    {
        c = Boolean.FALSE;
        d = Boolean.TRUE;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        cd.b(jsonobject, "width", a);
        cd.b(jsonobject, "height", b);
        cd.b(jsonobject, "useCustomClose", c.booleanValue());
        cd.b(jsonobject, "isModal", d.booleanValue());
        return jsonobject;
    }
}
