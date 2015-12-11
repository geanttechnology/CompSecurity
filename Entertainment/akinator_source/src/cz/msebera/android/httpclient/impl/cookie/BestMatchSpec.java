// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            BrowserCompatSpec, RFC2109Spec, RFC2965Spec, NetscapeDraftHeaderParser

public class BestMatchSpec
    implements CookieSpec
{

    private BrowserCompatSpec compat;
    private final String datepatterns[];
    private RFC2109Spec obsoleteStrict;
    private final boolean oneHeader;
    private RFC2965Spec strict;

    public BestMatchSpec()
    {
        this(null, false);
    }

    public BestMatchSpec(String as[], boolean flag)
    {
        if (as == null)
        {
            as = null;
        } else
        {
            as = (String[])as.clone();
        }
        datepatterns = as;
        oneHeader = flag;
    }

    private BrowserCompatSpec getCompat()
    {
        if (compat == null)
        {
            compat = new BrowserCompatSpec(datepatterns);
        }
        return compat;
    }

    private RFC2109Spec getObsoleteStrict()
    {
        if (obsoleteStrict == null)
        {
            obsoleteStrict = new RFC2109Spec(datepatterns, oneHeader);
        }
        return obsoleteStrict;
    }

    private RFC2965Spec getStrict()
    {
        if (strict == null)
        {
            strict = new RFC2965Spec(datepatterns, oneHeader);
        }
        return strict;
    }

    public List formatCookies(List list)
    {
        Args.notNull(list, "List of cookies");
        int i = 0x7fffffff;
        boolean flag = true;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Cookie cookie = (Cookie)iterator.next();
            boolean flag1 = flag;
            if (!(cookie instanceof SetCookie2))
            {
                flag1 = false;
            }
            flag = flag1;
            if (cookie.getVersion() < i)
            {
                i = cookie.getVersion();
                flag = flag1;
            }
        } while (true);
        if (i > 0)
        {
            if (flag)
            {
                return getStrict().formatCookies(list);
            } else
            {
                return getObsoleteStrict().formatCookies(list);
            }
        } else
        {
            return getCompat().formatCookies(list);
        }
    }

    public int getVersion()
    {
        return getStrict().getVersion();
    }

    public Header getVersionHeader()
    {
        return getStrict().getVersionHeader();
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieorigin, "Cookie origin");
        if (cookie.getVersion() > 0)
        {
            if (cookie instanceof SetCookie2)
            {
                return getStrict().match(cookie, cookieorigin);
            } else
            {
                return getObsoleteStrict().match(cookie, cookieorigin);
            }
        } else
        {
            return getCompat().match(cookie, cookieorigin);
        }
    }

    public List parse(Header header, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        Args.notNull(header, "Header");
        Args.notNull(cookieorigin, "Cookie origin");
        HeaderElement aheaderelement[] = header.getElements();
        boolean flag1 = false;
        boolean flag = false;
        int j = aheaderelement.length;
        for (int i = 0; i < j; i++)
        {
            HeaderElement headerelement = aheaderelement[i];
            if (headerelement.getParameterByName("version") != null)
            {
                flag1 = true;
            }
            if (headerelement.getParameterByName("expires") != null)
            {
                flag = true;
            }
        }

        if (flag || !flag1)
        {
            NetscapeDraftHeaderParser netscapedraftheaderparser = NetscapeDraftHeaderParser.DEFAULT;
            if (header instanceof FormattedHeader)
            {
                CharArrayBuffer chararraybuffer = ((FormattedHeader)header).getBuffer();
                aheaderelement = new ParserCursor(((FormattedHeader)header).getValuePos(), chararraybuffer.length());
                header = chararraybuffer;
            } else
            {
                aheaderelement = header.getValue();
                if (aheaderelement == null)
                {
                    throw new MalformedCookieException("Header value is null");
                }
                header = new CharArrayBuffer(aheaderelement.length());
                header.append(aheaderelement);
                aheaderelement = new ParserCursor(0, header.length());
            }
            header = netscapedraftheaderparser.parseHeader(header, aheaderelement);
            return getCompat().parse(new HeaderElement[] {
                header
            }, cookieorigin);
        }
        if ("Set-Cookie2".equals(header.getName()))
        {
            return getStrict().parse(aheaderelement, cookieorigin);
        } else
        {
            return getObsoleteStrict().parse(aheaderelement, cookieorigin);
        }
    }

    public String toString()
    {
        return "best-match";
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieorigin, "Cookie origin");
        if (cookie.getVersion() > 0)
        {
            if (cookie instanceof SetCookie2)
            {
                getStrict().validate(cookie, cookieorigin);
                return;
            } else
            {
                getObsoleteStrict().validate(cookie, cookieorigin);
                return;
            }
        } else
        {
            getCompat().validate(cookie, cookieorigin);
            return;
        }
    }
}
