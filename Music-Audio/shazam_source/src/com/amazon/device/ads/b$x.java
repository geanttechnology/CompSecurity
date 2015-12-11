// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;
import org.json.JSONArray;

// Referenced classes of package com.amazon.device.ads:
//            b, af

static final class <init> extends <init>
{

    protected final Object b(<init> <init>1)
    {
        JSONArray jsonarray = new JSONArray();
        boolean flag = <init>1.c.b.f;
        if (<init>1.b.containsKey("enableDisplayAds"))
        {
            flag = Boolean.parseBoolean((String)<init>1.b.remove("enableDisplayAds"));
        }
        if (flag)
        {
            jsonarray.put("DISPLAY");
        }
        if ((new (<init>1)).a())
        {
            jsonarray.put("VIDEO");
        }
        return jsonarray;
    }

    public ()
    {
        super("supportedMediaTypes", "debug.supportedMediaTypes");
    }
}
