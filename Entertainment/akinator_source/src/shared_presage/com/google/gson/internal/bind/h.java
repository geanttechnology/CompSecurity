// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.sql.Time;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.reflect.TypeToken;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            TimeTypeAdapter

final class h
    implements TypeAdapterFactory
{

    h()
    {
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        if (typetoken.getRawType() == java/sql/Time)
        {
            return new TimeTypeAdapter();
        } else
        {
            return null;
        }
    }
}
