// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            lj, lf

static final class 
{

    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map h;

    public static  a(InputStream inputstream)
    {
          = new <init>();
        if (lj.a(inputstream) != 0x20150306)
        {
            throw new IOException();
        }
        .b = lj.c(inputstream);
        .c = lj.c(inputstream);
        if (.c.equals(""))
        {
            .c = null;
        }
        .d = lj.b(inputstream);
        .e = lj.b(inputstream);
        .f = lj.b(inputstream);
        .g = lj.b(inputstream);
        .h = lj.d(inputstream);
        return ;
    }

    public final boolean a(OutputStream outputstream)
    {
        lj.a(outputstream, 0x20150306);
        lj.a(outputstream, b);
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Object obj = "";
_L1:
        java.util.ntry ntry;
        try
        {
            lj.a(outputstream, ((String) (obj)));
            lj.a(outputstream, d);
            lj.a(outputstream, e);
            lj.a(outputstream, f);
            lj.a(outputstream, g);
            obj = h;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            lf.b("%s", new Object[] {
                outputstream.toString()
            });
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        lj.a(outputstream, ((Map) (obj)).size());
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); lj.a(outputstream, (String)ntry.getValue()))
        {
            ntry = (java.util.ntry)((Iterator) (obj)).next();
            lj.a(outputstream, (String)ntry.getKey());
        }

        break MISSING_BLOCK_LABEL_172;
        obj = c;
          goto _L1
        lj.a(outputstream, 0);
        outputstream.flush();
        return true;
    }

    private ()
    {
    }

    public (String s,  )
    {
        b = s;
        a = ..length;
        c = .;
        d = .;
        e = .;
        f = .;
        g = .;
        h = .;
    }
}
