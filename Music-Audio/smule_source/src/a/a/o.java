// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.apache.http.ParseException;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package a.a:
//            g, m, n, t

public final class o extends g
{

    public o(m m1)
    {
        super(m1);
    }

    public final boolean a(CharArrayBuffer chararraybuffer)
    {
        ParserCursor parsercursor = new ParserCursor(0, chararraybuffer.length());
        try
        {
            chararraybuffer = BasicLineParser.DEFAULT.parseRequestLine(chararraybuffer, parsercursor);
            super.a.a(chararraybuffer.getMethod(), chararraybuffer.getUri());
        }
        // Misplaced declaration of an exception variable
        catch (CharArrayBuffer chararraybuffer)
        {
            return false;
        }
        return true;
    }

    public final g b()
    {
        return new n(this);
    }

    public final g c()
    {
        return t.d;
    }

    protected final int d()
    {
        return 64;
    }

    protected final int e()
    {
        return 2048;
    }
}
