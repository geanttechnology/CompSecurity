// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import java.lang.reflect.Type;

// Referenced classes of package shared_presage.com.google.gson:
//            JsonSerializationContext, JsonElement

public interface JsonSerializer
{

    public abstract JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext);
}
