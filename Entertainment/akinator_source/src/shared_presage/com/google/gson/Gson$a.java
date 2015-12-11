// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson:
//            TypeAdapter, Gson

static final class JsonWriter extends TypeAdapter
{

    private TypeAdapter a;

    public final void a(TypeAdapter typeadapter)
    {
        if (a != null)
        {
            throw new AssertionError();
        } else
        {
            a = typeadapter;
            return;
        }
    }

    public final Object read(JsonReader jsonreader)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            return a.read(jsonreader);
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            a.write(jsonwriter, obj);
            return;
        }
    }

    JsonWriter()
    {
    }
}
