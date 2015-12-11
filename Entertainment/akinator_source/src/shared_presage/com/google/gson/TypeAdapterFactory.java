// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import shared_presage.com.google.gson.reflect.TypeToken;

// Referenced classes of package shared_presage.com.google.gson:
//            Gson, TypeAdapter

public interface TypeAdapterFactory
{

    public abstract TypeAdapter create(Gson gson, TypeToken typetoken);
}
