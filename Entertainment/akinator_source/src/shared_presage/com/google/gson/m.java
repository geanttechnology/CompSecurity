// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;


// Referenced classes of package shared_presage.com.google.gson:
//            LongSerializationPolicy, JsonPrimitive, JsonElement

final class m extends LongSerializationPolicy
{

    m(String s)
    {
        super(s, 1, null);
    }

    public final JsonElement serialize(Long long1)
    {
        return new JsonPrimitive(String.valueOf(long1));
    }
}
