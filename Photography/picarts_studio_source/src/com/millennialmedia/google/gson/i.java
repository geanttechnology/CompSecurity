// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
import java.io.IOException;
import java.util.List;
import myobfuscated.ao.f;

// Referenced classes of package com.millennialmedia.google.gson:
//            JsonIOException, e

public abstract class i
{

    public i()
    {
    }

    public final e a(Object obj)
    {
        f f1;
        try
        {
            f1 = new f();
            a(((b) (f1)), obj);
            if (!f1.a.isEmpty())
            {
                throw new IllegalStateException((new StringBuilder("Expected one JSON element but was ")).append(f1.a).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new JsonIOException(((Throwable) (obj)));
        }
        obj = f1.b;
        return ((e) (obj));
    }

    public abstract Object a(a a1);

    public abstract void a(b b, Object obj);
}
