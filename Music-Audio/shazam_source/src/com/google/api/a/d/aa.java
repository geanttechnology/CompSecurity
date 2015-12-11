// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.y;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// Referenced classes of package com.google.api.a.d:
//            a, o, m, i, 
//            j, k

public final class aa extends com.google.api.a.d.a
{
    public static final class a
    {

        i a;
        m b;
        j c;

        public a()
        {
            this(null);
        }

        public a(i l)
        {
            this(l, (byte)0);
        }

        private a(i l, byte byte0)
        {
            b = null;
            a = l;
        }
    }


    public ArrayList b;

    public aa()
    {
        super((new o("multipart/related")).a("boundary", "__END_OF_PART__"));
        b = new ArrayList();
    }

    public final void a(OutputStream outputstream)
    {
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream, b());
        String s = super.a.a("boundary");
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (a)iterator.next();
            m m1 = new m();
            m1.acceptEncoding = m.a(null);
            if (((a) (obj1)).b != null)
            {
                m1.a(((a) (obj1)).b);
            }
            m1.b(null).e(null).d(null).a(null).a("Content-Transfer-Encoding", null);
            Object obj = ((a) (obj1)).a;
            if (obj != null)
            {
                m1.a("Content-Transfer-Encoding", Arrays.asList(new String[] {
                    "binary"
                }));
                m1.d(((i) (obj)).c());
                obj1 = ((a) (obj1)).c;
                long l;
                if (obj1 == null)
                {
                    l = ((i) (obj)).a();
                } else
                {
                    m1.b(((j) (obj1)).a());
                    obj1 = new k(((y) (obj)), ((j) (obj1)));
                    l = com.google.api.a.d.a.a(((i) (obj)));
                    obj = obj1;
                }
                obj1 = obj;
                if (l != -1L)
                {
                    m1.a(Long.valueOf(l));
                    obj1 = obj;
                }
            } else
            {
                obj1 = null;
            }
            outputstreamwriter.write("--");
            outputstreamwriter.write(s);
            outputstreamwriter.write("\r\n");
            m.a(m1, outputstreamwriter);
            if (obj1 != null)
            {
                outputstreamwriter.write("\r\n");
                outputstreamwriter.flush();
                ((y) (obj1)).a(outputstream);
                outputstreamwriter.write("\r\n");
            }
        } while (true);
        outputstreamwriter.write("--");
        outputstreamwriter.write(s);
        outputstreamwriter.write("--");
        outputstreamwriter.write("\r\n");
        outputstreamwriter.flush();
    }

    public final boolean d()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            if (!((a)iterator.next()).a.d())
            {
                return false;
            }
        }

        return true;
    }
}
