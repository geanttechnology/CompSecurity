// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            CookieSpecBase, BasicPathHandler, NetscapeDomainHandler, BasicSecureHandler, 
//            BasicCommentHandler, BasicExpiresHandler, NetscapeDraftHeaderParser

public class NetscapeDraftSpec extends CookieSpecBase
{

    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yy HH:mm:ss z";
    private final String datepatterns[];

    public NetscapeDraftSpec()
    {
        this(null);
    }

    public NetscapeDraftSpec(String as[])
    {
        if (as != null)
        {
            datepatterns = (String[])as.clone();
        } else
        {
            datepatterns = (new String[] {
                "EEE, dd-MMM-yy HH:mm:ss z"
            });
        }
        registerAttribHandler("path", new BasicPathHandler());
        registerAttribHandler("domain", new NetscapeDomainHandler());
        registerAttribHandler("secure", new BasicSecureHandler());
        registerAttribHandler("comment", new BasicCommentHandler());
        registerAttribHandler("expires", new BasicExpiresHandler(datepatterns));
    }

    public List formatCookies(List list)
    {
        Args.notEmpty(list, "List of cookies");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(list.size() * 20);
        chararraybuffer.append("Cookie");
        chararraybuffer.append(": ");
        for (int i = 0; i < list.size(); i++)
        {
            Object obj = (Cookie)list.get(i);
            if (i > 0)
            {
                chararraybuffer.append("; ");
            }
            chararraybuffer.append(((Cookie) (obj)).getName());
            obj = ((Cookie) (obj)).getValue();
            if (obj != null)
            {
                chararraybuffer.append("=");
                chararraybuffer.append(((String) (obj)));
            }
        }

        list = new ArrayList(1);
        list.add(new BufferedHeader(chararraybuffer));
        return list;
    }

    public int getVersion()
    {
        return 0;
    }

    public Header getVersionHeader()
    {
        return null;
    }

    public List parse(Header header, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        Args.notNull(header, "Header");
        Args.notNull(cookieorigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie"))
        {
            throw new MalformedCookieException((new StringBuilder()).append("Unrecognized cookie header '").append(header.toString()).append("'").toString());
        }
        NetscapeDraftHeaderParser netscapedraftheaderparser = NetscapeDraftHeaderParser.DEFAULT;
        Object obj;
        if (header instanceof FormattedHeader)
        {
            CharArrayBuffer chararraybuffer = ((FormattedHeader)header).getBuffer();
            obj = new ParserCursor(((FormattedHeader)header).getValuePos(), chararraybuffer.length());
            header = chararraybuffer;
        } else
        {
            obj = header.getValue();
            if (obj == null)
            {
                throw new MalformedCookieException("Header value is null");
            }
            header = new CharArrayBuffer(((String) (obj)).length());
            header.append(((String) (obj)));
            obj = new ParserCursor(0, header.length());
        }
        return parse(new HeaderElement[] {
            netscapedraftheaderparser.parseHeader(header, ((ParserCursor) (obj)))
        }, cookieorigin);
    }

    public String toString()
    {
        return "netscape";
    }
}
