// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class clm extends cre
{

    private final Map j = new HashMap();
    private final byte k[];
    private final mj l;

    public clm(String s, byte abyte0[], cqs acqs[], mj mj1)
    {
        super(1, s, mj1);
        k = abyte0;
        l = mj1;
        int j1 = acqs.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            acqs[i1].a(j, this);
        }

    }

    protected final mi a(mb mb1)
    {
        String s;
        int i1;
        i1 = 1;
        try
        {
            s = a.a(mb1.c);
            mb1 = clj.a(new ByteArrayInputStream(mb1.b));
            s = new String(mb1, s);
            if (!s.startsWith("GLS/1."))
            {
                throw new IOException("Invalid response from server. Expected GLS/1.x");
            }
        }
        // Misplaced declaration of an exception variable
        catch (mb mb1)
        {
            return mi.a(new md(mb1));
        }
        int j1 = s.indexOf("\r\n\r\n");
        if (j1 != -1)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        throw new IOException("Invalid response from server. Could not locate DRM message");
        String as[] = s.substring(0, j1).split("\r\n");
        Object obj = as[0];
        HashMap hashmap;
        int k1;
        obj = Pattern.compile("GLS/[0-9]+\\.[0-9]+ ([0-9]+) (.*)").matcher(((CharSequence) (obj)));
        ((Matcher) (obj)).find();
        k1 = Integer.parseInt(((Matcher) (obj)).group(1));
        obj = ((Matcher) (obj)).group(2);
        hashmap = new HashMap();
_L1:
        if (i1 >= as.length)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        String as1[] = as[i1].split(": ");
        hashmap.put(as1[0], as1[1]);
        i1++;
          goto _L1
        mb1 = new cln(k1, ((String) (obj)), Arrays.copyOfRange(mb1, "\r\n\r\n".length() + j1, mb1.length), hashmap);
        if (((cln) (mb1)).a == 0)
        {
            return mi.a(mb1, null);
        }
        mb1 = mi.a(new clo(mb1));
        return mb1;
    }

    protected final void a(Object obj)
    {
        obj = (cln)obj;
        l.a(obj);
    }

    public final Map c()
    {
        return j;
    }

    public final byte[] h()
    {
        return k;
    }

    public final mg i()
    {
        return mg.b;
    }
}
