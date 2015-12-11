// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public final class clj
{

    private final cnf a;
    private final mh b;
    private final cqs c[];

    public transient clj(cnf cnf1, mh mh1, cqs acqs[])
    {
        a = (cnf)b.a(cnf1);
        b = (mh)b.a(mh1);
        c = (cqs[])b.a(acqs);
    }

    static byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                bytearrayoutputstream.flush();
                bytearrayoutputstream.close();
                inputstream.close();
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public final cln a(Uri uri, byte abyte0[], String s)
    {
        b.b();
        uri = bnf.a(uri);
        a.a(uri);
        uri.a("cpn", s);
        s = ((bnf) (uri)).a.build();
        uri = crf.a();
        abyte0 = new clm(s.toString(), abyte0, c, uri);
        abyte0.e = false;
        abyte0.h = new clk();
        b.a(abyte0);
        try
        {
            uri = (cln)uri.get();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new clo(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            if (uri.getCause() instanceof clo)
            {
                throw (clo)uri.getCause();
            } else
            {
                throw new clo(uri.getCause());
            }
        }
        return uri;
    }

    public final byte[] a(Uri uri)
    {
        b.b();
        uri = bnf.a(uri);
        a.a(uri);
        uri = ((bnf) (uri)).a.build();
        crf crf1 = crf.a();
        b.a(new cll(uri.toString(), crf1));
        try
        {
            uri = (byte[])crf1.get();
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new clo(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            if (uri.getCause() instanceof clo)
            {
                throw (clo)uri.getCause();
            } else
            {
                throw new clo(uri.getCause());
            }
        }
        return uri;
    }
}
