// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.nodes;

import java.util.Map;

// Referenced classes of package org.jsoup.nodes:
//            Entities

public static final class map extends Enum
{

    private static final extended $VALUES[];
    public static final extended base;
    public static final extended extended;
    public static final extended xhtml;
    private Map map;

    public static map valueOf(String s)
    {
        return (map)Enum.valueOf(org/jsoup/nodes/Entities$EscapeMode, s);
    }

    public static map[] values()
    {
        return (map[])$VALUES.clone();
    }

    public Map getMap()
    {
        return map;
    }

    static 
    {
        xhtml = new <init>("xhtml", 0, Entities.access$000());
        base = new <init>("base", 1, Entities.access$100());
        extended = new <init>("extended", 2, Entities.access$200());
        $VALUES = (new .VALUES[] {
            xhtml, base, extended
        });
    }

    private (String s, int i, Map map1)
    {
        super(s, i);
        map = map1;
    }
}
