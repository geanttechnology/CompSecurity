// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;


// Referenced classes of package com.millennialmedia.google.gson:
//            e, h

public abstract class LongSerializationPolicy extends Enum
{

    private static final LongSerializationPolicy $VALUES[];
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    private LongSerializationPolicy(String s, int i)
    {
        super(s, i);
    }


    public static LongSerializationPolicy valueOf(String s)
    {
        return (LongSerializationPolicy)Enum.valueOf(com/millennialmedia/google/gson/LongSerializationPolicy, s);
    }

    public static LongSerializationPolicy[] values()
    {
        return (LongSerializationPolicy[])$VALUES.clone();
    }

    public abstract e serialize(Long long1);

    static 
    {
        DEFAULT = new LongSerializationPolicy("DEFAULT", 0) {

            public final e serialize(Long long1)
            {
                return new h(long1);
            }

        };
        STRING = new LongSerializationPolicy("STRING", 1) {

            public final e serialize(Long long1)
            {
                return new h(String.valueOf(long1));
            }

        };
        $VALUES = (new LongSerializationPolicy[] {
            DEFAULT, STRING
        });
    }
}
