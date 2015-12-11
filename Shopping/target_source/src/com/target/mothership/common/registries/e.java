// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class e extends Enum
{

    private static final e $VALUES[];
    public static final e CITY;
    public static final e CREATED_BY;
    public static final e EVENT_DATE;
    public static final e EVENT_TYPE;
    public static final e FIRST_NAME;
    public static final e LAST_NAME;
    public static final e REGISTRY_TITLE;
    public static final e STATE;
    public static final e UNKNOWN;
    private String mValue;

    private e(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static e a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        e e1 = UNKNOWN;
_L4:
        return e1;
_L2:
        e ae[];
        int i;
        int j;
        ae = values();
        j = ae.length;
        i = 0;
_L6:
        e e2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        e2 = ae[i];
        e1 = e2;
        if (s.equalsIgnoreCase(e2.toString())) goto _L4; else goto _L3
_L3:
        e1 = e2;
        if (s.equalsIgnoreCase(e2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/target/mothership/common/registries/e, s);
    }

    public static e[] values()
    {
        return (e[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        EVENT_DATE = new e("EVENT_DATE", 0, "event_date");
        FIRST_NAME = new e("FIRST_NAME", 1, "first_name");
        LAST_NAME = new e("LAST_NAME", 2, "last_name");
        STATE = new e("STATE", 3, "state");
        CITY = new e("CITY", 4, "city");
        EVENT_TYPE = new e("EVENT_TYPE", 5, "event_type");
        CREATED_BY = new e("CREATED_BY", 6, "created_by");
        REGISTRY_TITLE = new e("REGISTRY_TITLE", 7, "registry_title");
        UNKNOWN = new e("UNKNOWN", 8, "");
        $VALUES = (new e[] {
            EVENT_DATE, FIRST_NAME, LAST_NAME, STATE, CITY, EVENT_TYPE, CREATED_BY, REGISTRY_TITLE, UNKNOWN
        });
    }
}
