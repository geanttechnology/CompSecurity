// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.sql.Timestamp;
import java.util.Date;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            x

final class y extends TypeAdapter
{

    final TypeAdapter a;
    final x b;

    y(x x, TypeAdapter typeadapter)
    {
        b = x;
        a = typeadapter;
        super();
    }

    public final Object read(JsonReader jsonreader)
    {
        jsonreader = (Date)a.read(jsonreader);
        if (jsonreader != null)
        {
            return new Timestamp(jsonreader.getTime());
        } else
        {
            return null;
        }
    }

    public final volatile void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (Timestamp)obj;
        a.write(jsonwriter, obj);
    }
}
