// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;

public class vh
    implements vd
{

    static final Map a;

    public vh()
    {
    }

    public void a(gu gu, Map map)
    {
        String s = (String)map.get("a");
        switch (((Integer)a.get(s)).intValue())
        {
        case 2: // '\002'
        default:
            acb.c("Unknown MRAID command called.");
            return;

        case 1: // '\001'
            (new wv(gu, map)).b();
            return;

        case 4: // '\004'
            (new wu(gu, map)).a();
            return;

        case 3: // '\003'
            (new ww(gu, map)).a();
            return;
        }
    }

    static 
    {
        a = new HashMap();
        a.put("resize", Integer.valueOf(1));
        a.put("playVideo", Integer.valueOf(2));
        a.put("storePicture", Integer.valueOf(3));
        a.put("createCalendarEvent", Integer.valueOf(4));
    }
}
