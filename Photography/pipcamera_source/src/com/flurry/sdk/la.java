// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            lb

public class la
    implements lb
{

    lb a;

    public la(lb lb1)
    {
        if (lb1 == null)
        {
            throw new IllegalArgumentException("recordSerializer cannot be null");
        } else
        {
            a = lb1;
            return;
        }
    }

    public List a(InputStream inputstream)
    {
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((List) (obj));
_L2:
        int j = (new DataInputStream(inputstream) {

            final la a;

            public void close()
            {
            }

            
            {
                a = la.this;
                super(inputstream);
            }
        }).readInt();
        ArrayList arraylist = new ArrayList(j);
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= j)
            {
                continue;
            }
            obj = a.b(inputstream);
            if (obj == null)
            {
                throw new IOException("Missing record.");
            }
            arraylist.add(obj);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (List)obj);
    }

    public void a(OutputStream outputstream, List list)
    {
        int j = 0;
        if (outputstream == null)
        {
            return;
        }
        DataOutputStream dataoutputstream = new DataOutputStream(outputstream) {

            final la a;

            public void close()
            {
            }

            
            {
                a = la.this;
                super(outputstream);
            }
        };
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        dataoutputstream.writeInt(i);
        for (; j < i; j++)
        {
            a.a(outputstream, list.get(j));
        }

        dataoutputstream.flush();
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }
}
