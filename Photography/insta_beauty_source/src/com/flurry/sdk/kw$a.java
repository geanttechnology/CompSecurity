// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            lb, kw

public class 
    implements lb
{

    public kw a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            class _cls2 extends DataInputStream
            {

                final kw.a a;

                public void close()
                {
                }

            _cls2(InputStream inputstream)
            {
                a = kw.a.this;
                super(inputstream);
            }
            }

            inputstream = new _cls2(inputstream);
            kw kw1 = new kw(null);
            kw.a(kw1, inputstream.readUTF());
            return kw1;
        }
    }

    public void a(OutputStream outputstream, kw kw1)
    {
        if (outputstream == null || kw1 == null)
        {
            return;
        } else
        {
            class _cls1 extends DataOutputStream
            {

                final kw.a a;

                public void close()
                {
                }

            _cls1(OutputStream outputstream)
            {
                a = kw.a.this;
                super(outputstream);
            }
            }

            outputstream = new _cls1(outputstream);
            outputstream.writeUTF(kw.a(kw1));
            outputstream.flush();
            return;
        }
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (kw)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

    public ()
    {
    }
}
