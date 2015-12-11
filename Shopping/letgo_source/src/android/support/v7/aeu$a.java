// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            afl, aeu

static class onReader extends afl
{

    private afl a;

    public void a(afl afl1)
    {
        if (a != null)
        {
            throw new AssertionError();
        } else
        {
            a = afl1;
            return;
        }
    }

    public void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            a.a(jsonwriter, obj);
            return;
        }
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            return a.b(jsonreader);
        }
    }

    onReader()
    {
    }
}
