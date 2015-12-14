// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

// Referenced classes of package com.cyberlink.uma:
//            k, g

class h
    implements k
{

    h()
    {
    }

    public String a()
    {
        if (g.b().exists() && g.b().length() == (long)g.c())
        {
            Object obj;
            try
            {
                obj = new InputStreamReader(new FileInputStream(g.b()), "US-ASCII");
                char ac[] = new char[g.c()];
                ((Reader) (obj)).read(ac);
                ((Reader) (obj)).close();
                obj = new String(ac);
            }
            catch (Throwable throwable)
            {
                g.b().delete();
                return "";
            }
            return ((String) (obj));
        } else
        {
            return "";
        }
    }

    public void a(String s)
    {
        if (s.equals(a()))
        {
            return;
        } else
        {
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(new FileOutputStream(g.b()), "US-ASCII");
            outputstreamwriter.write(s);
            outputstreamwriter.close();
            return;
        }
    }
}
