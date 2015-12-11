// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.Intent;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ci, cd, at, cn, 
//            az, dq, f

private static final class b extends b
{

    private final ci b;

    public final JSONObject a()
    {
        ci ci1 = b;
        Object obj = cd.a(null, "description", null);
        Object obj1 = cd.a(null, "location", null);
        String s = cd.a(null, "summary", null);
        String s1 = cd.a(null, "start", null);
        String s2 = cd.a(null, "end", null);
        if (!at.a(14))
        {
            ci1.a.b("API version does not support calendar operations.", null);
            ci1.a("API version does not support calendar operations.", "createCalendarEvent");
            return null;
        }
        try
        {
            obj = new az(((String) (obj)), ((String) (obj1)), s, s1, s2);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            ci1.a.b(illegalargumentexception.getMessage(), null);
            ci1.a(illegalargumentexception.getMessage(), "createCalendarEvent");
            return null;
        }
        obj1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
        ((Intent) (obj1)).putExtra("title", ((az) (obj)).b);
        if (!dq.a(((az) (obj)).c))
        {
            ((Intent) (obj1)).putExtra("eventLocation", ((az) (obj)).c);
        }
        if (!dq.a(((az) (obj)).d))
        {
            ((Intent) (obj1)).putExtra("description", ((az) (obj)).d);
        }
        ((Intent) (obj1)).putExtra("beginTime", ((az) (obj)).e.getTime());
        if (((az) (obj)).f != null)
        {
            ((Intent) (obj1)).putExtra("endTime", ((az) (obj)).f.getTime());
        }
        ci1.g.b().startActivity(((Intent) (obj1)));
        return null;
    }

    public ception(ci ci1)
    {
        super("CreateCalendarEvent");
        b = ci1;
    }
}
