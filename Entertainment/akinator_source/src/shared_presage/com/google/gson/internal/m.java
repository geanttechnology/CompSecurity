// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.reflect.TypeToken;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            Excluder

final class m extends TypeAdapter
{

    final boolean a;
    final boolean b;
    final Gson c;
    final TypeToken d;
    final Excluder e;
    private TypeAdapter f;

    m(Excluder excluder, boolean flag, boolean flag1, Gson gson, TypeToken typetoken)
    {
        e = excluder;
        a = flag;
        b = flag1;
        c = gson;
        d = typetoken;
        super();
    }

    private TypeAdapter a()
    {
        TypeAdapter typeadapter = f;
        if (typeadapter != null)
        {
            return typeadapter;
        } else
        {
            TypeAdapter typeadapter1 = c.getDelegateAdapter(e, d);
            f = typeadapter1;
            return typeadapter1;
        }
    }

    public final Object read(JsonReader jsonreader)
    {
        if (a)
        {
            jsonreader.skipValue();
            return null;
        } else
        {
            return a().read(jsonreader);
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        if (b)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            a().write(jsonwriter, obj);
            return;
        }
    }
}
