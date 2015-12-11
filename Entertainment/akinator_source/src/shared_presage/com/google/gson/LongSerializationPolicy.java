// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;


// Referenced classes of package shared_presage.com.google.gson:
//            l, m, JsonElement

public abstract class LongSerializationPolicy extends Enum
{

    private static final LongSerializationPolicy $VALUES[];
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    private LongSerializationPolicy(String s, int i)
    {
        super(s, i);
    }

    LongSerializationPolicy(String s, int i, l l1)
    {
        this(s, i);
    }

    public static LongSerializationPolicy valueOf(String s)
    {
        return (LongSerializationPolicy)Enum.valueOf(shared_presage/com/google/gson/LongSerializationPolicy, s);
    }

    public static LongSerializationPolicy[] values()
    {
        return (LongSerializationPolicy[])$VALUES.clone();
    }

    public abstract JsonElement serialize(Long long1);

    static 
    {
        DEFAULT = new l("DEFAULT");
        STRING = new m("STRING");
        $VALUES = (new LongSerializationPolicy[] {
            DEFAULT, STRING
        });
    }
}
