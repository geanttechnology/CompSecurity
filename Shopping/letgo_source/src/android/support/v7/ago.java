// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package android.support.v7:
//            afl, agq, aeu

final class ago extends afl
{

    private final aeu a;
    private final afl b;
    private final Type c;

    ago(aeu aeu1, afl afl1, Type type)
    {
        a = aeu1;
        b = afl1;
        c = type;
    }

    private Type a(Type type, Object obj)
    {
        Object obj1;
label0:
        {
            obj1 = type;
            if (obj == null)
            {
                break label0;
            }
            if (type != java/lang/Object && !(type instanceof TypeVariable))
            {
                obj1 = type;
                if (!(type instanceof Class))
                {
                    break label0;
                }
            }
            obj1 = obj.getClass();
        }
        return ((Type) (obj1));
    }

    public void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        afl afl1;
        afl1 = b;
        Type type = a(c, obj);
        if (type != c)
        {
            afl1 = a.a(agq.a(type));
            break MISSING_BLOCK_LABEL_38;
        }
_L1:
        afl1.a(jsonwriter, obj);
        return;
        if ((afl1 instanceof agl.a) && !(b instanceof agl.a))
        {
            afl1 = b;
        }
          goto _L1
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return b.b(jsonreader);
    }
}
