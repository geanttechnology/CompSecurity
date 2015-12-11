// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            b, cd

static final class init> extends init>
{

    private static JSONObject c(init> init>)
    {
        int i = 0;
        if ((new <init>(init>)).a())
        {
            JSONObject jsonobject = new JSONObject();
            if (init>..containsKey("minVideoAdDuration"))
            {
                init> init>1 = new <init>();
                init>1.a = 0;
                init>1 = init>1.a(b.a);
                init>1.b = "The minVideoAdDuration advanced option could not be parsed properly.";
                i = init>1.b((String)init>..remove("minVideoAdDuration"));
            }
            cd.b(jsonobject, "minAdDuration", i);
            if (init>..containsKey("maxVideoAdDuration"))
            {
                init> init>2 = new <init>();
                init>2.a = 30000;
                init>2 = init>2.a(b.a);
                init>2.b = "The maxVideoAdDuration advanced option could not be parsed properly.";
                i = init>2.b((String)init>..remove("maxVideoAdDuration"));
            } else
            {
                i = 30000;
            }
            cd.b(jsonobject, "maxAdDuration", i);
            return jsonobject;
        } else
        {
            return null;
        }
    }

    protected final Object b( )
    {
        return c();
    }

    public ()
    {
        super("video", "debug.videoOptions");
    }
}
