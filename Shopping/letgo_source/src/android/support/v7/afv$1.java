// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            afl, afv, aeu, agq

class nit> extends afl
{

    final boolean a;
    final boolean b;
    final aeu c;
    final agq d;
    final afv e;
    private afl f;

    private afl a()
    {
        afl afl1 = f;
        if (afl1 != null)
        {
            return afl1;
        } else
        {
            afl afl2 = c.a(e, d);
            f = afl2;
            return afl2;
        }
    }

    public void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        if (b)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            a().a(jsonwriter, obj);
            return;
        }
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        if (a)
        {
            jsonreader.skipValue();
            return null;
        } else
        {
            return a().b(jsonreader);
        }
    }

    onReader(afv afv1, boolean flag, boolean flag1, aeu aeu1, agq agq)
    {
        e = afv1;
        a = flag;
        b = flag1;
        c = aeu1;
        d = agq;
        super();
    }
}
