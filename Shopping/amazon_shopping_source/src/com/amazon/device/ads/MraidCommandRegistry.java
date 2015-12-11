// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidView, MraidCommand, MraidCommandClose, MraidCommandExpand, 
//            MraidCommandUseCustomClose, MraidCommandOpen, MraidCommandPlayVideo, MraidCommandLogCat

class MraidCommandRegistry
{
    private static interface MraidCommandFactory
    {

        public abstract MraidCommand create(Map map, MraidView mraidview);
    }


    private static Map commandMap;

    MraidCommandRegistry()
    {
    }

    static MraidCommand createCommand(String s, Map map, MraidView mraidview)
    {
        s = (MraidCommandFactory)commandMap.get(s);
        if (s != null)
        {
            return s.create(map, mraidview);
        } else
        {
            return null;
        }
    }

    static 
    {
        commandMap = new HashMap();
        commandMap.put("close", new MraidCommandFactory() {

            public MraidCommand create(Map map, MraidView mraidview)
            {
                return new MraidCommandClose(map, mraidview);
            }

        });
        commandMap.put("expand", new MraidCommandFactory() {

            public MraidCommand create(Map map, MraidView mraidview)
            {
                return new MraidCommandExpand(map, mraidview);
            }

        });
        commandMap.put("usecustomclose", new MraidCommandFactory() {

            public MraidCommand create(Map map, MraidView mraidview)
            {
                return new MraidCommandUseCustomClose(map, mraidview);
            }

        });
        commandMap.put("open", new MraidCommandFactory() {

            public MraidCommand create(Map map, MraidView mraidview)
            {
                return new MraidCommandOpen(map, mraidview);
            }

        });
        commandMap.put("playVideo", new MraidCommandFactory() {

            public MraidCommand create(Map map, MraidView mraidview)
            {
                return new MraidCommandPlayVideo(map, mraidview);
            }

        });
        commandMap.put("log", new MraidCommandFactory() {

            public MraidCommand create(Map map, MraidView mraidview)
            {
                return new MraidCommandLogCat(map, mraidview);
            }

        });
    }
}
