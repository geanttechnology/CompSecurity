// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.tapjoy.internal:
//            ch, bu, br, ci

public abstract class cg extends ch
{

    public cg()
    {
    }

    protected abstract Object a(bu bu1);

    public final Object a(URI uri, InputStream inputstream)
    {
        String s;
        bu bu1;
        s = null;
        bu1 = bu.a(inputstream);
        bu1.a("BASE_URI", uri);
        bu1.i();
        int i;
        i = 0;
        uri = null;
        inputstream = s;
_L1:
        do
        {
label0:
            {
                if (!bu1.k())
                {
                    break MISSING_BLOCK_LABEL_116;
                }
                s = bu1.m();
                if (!"status".equals(s))
                {
                    break label0;
                }
                i = bu1.s();
            }
        } while (true);
label1:
        {
            if (!"message".equals(s))
            {
                break label1;
            }
            uri = bu1.n();
        }
          goto _L1
label2:
        {
            if (!"data".equals(s))
            {
                break label2;
            }
            inputstream = ((InputStream) (a(bu1)));
        }
          goto _L1
        bu1.t();
          goto _L1
        uri;
        bu1.close();
        throw uri;
        bu1.j();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        throw new ci(i, uri);
        bu1.close();
        return inputstream;
    }

    public final List a()
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new BasicHeader("Accept", "application/json"));
        return linkedlist;
    }
}
