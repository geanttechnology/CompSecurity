// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            agi, afb, afa

public abstract class afl
{

    public afl()
    {
    }

    public final afa a(Object obj)
    {
        try
        {
            agi agi1 = new agi();
            a(((JsonWriter) (agi1)), obj);
            obj = agi1.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new afb(((Throwable) (obj)));
        }
        return ((afa) (obj));
    }

    public abstract void a(JsonWriter jsonwriter, Object obj)
        throws IOException;

    public abstract Object b(JsonReader jsonreader)
        throws IOException;
}
