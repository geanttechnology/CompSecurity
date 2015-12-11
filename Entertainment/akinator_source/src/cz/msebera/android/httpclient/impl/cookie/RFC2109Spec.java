// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookiePathComparator;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            CookieSpecBase, RFC2109VersionHandler, BasicPathHandler, RFC2109DomainHandler, 
//            BasicMaxAgeHandler, BasicSecureHandler, BasicCommentHandler, BasicExpiresHandler

public class RFC2109Spec extends CookieSpecBase
{

    private static final String DATE_PATTERNS[] = {
        "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"
    };
    private static final CookiePathComparator PATH_COMPARATOR = new CookiePathComparator();
    private final String datepatterns[];
    private final boolean oneHeader;

    public RFC2109Spec()
    {
        this(null, false);
    }

    public RFC2109Spec(String as[], boolean flag)
    {
        if (as != null)
        {
            datepatterns = (String[])as.clone();
        } else
        {
            datepatterns = DATE_PATTERNS;
        }
        oneHeader = flag;
        registerAttribHandler("version", new RFC2109VersionHandler());
        registerAttribHandler("path", new BasicPathHandler());
        registerAttribHandler("domain", new RFC2109DomainHandler());
        registerAttribHandler("max-age", new BasicMaxAgeHandler());
        registerAttribHandler("secure", new BasicSecureHandler());
        registerAttribHandler("comment", new BasicCommentHandler());
        registerAttribHandler("expires", new BasicExpiresHandler(datepatterns));
    }

    private List doFormatManyHeaders(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        CharArrayBuffer chararraybuffer;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new BufferedHeader(chararraybuffer)))
        {
            Cookie cookie = (Cookie)list.next();
            int i = cookie.getVersion();
            chararraybuffer = new CharArrayBuffer(40);
            chararraybuffer.append("Cookie: ");
            chararraybuffer.append("$Version=");
            chararraybuffer.append(Integer.toString(i));
            chararraybuffer.append("; ");
            formatCookieAsVer(chararraybuffer, cookie, i);
        }

        return arraylist;
    }

    private List doFormatOneHeader(List list)
    {
        int i = 0x7fffffff;
        Object obj = list.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Cookie cookie = (Cookie)((Iterator) (obj)).next();
            if (cookie.getVersion() < i)
            {
                i = cookie.getVersion();
            }
        } while (true);
        obj = new CharArrayBuffer(list.size() * 40);
        ((CharArrayBuffer) (obj)).append("Cookie");
        ((CharArrayBuffer) (obj)).append(": ");
        ((CharArrayBuffer) (obj)).append("$Version=");
        ((CharArrayBuffer) (obj)).append(Integer.toString(i));
        Cookie cookie1;
        for (list = list.iterator(); list.hasNext(); formatCookieAsVer(((CharArrayBuffer) (obj)), cookie1, i))
        {
            cookie1 = (Cookie)list.next();
            ((CharArrayBuffer) (obj)).append("; ");
        }

        list = new ArrayList(1);
        list.add(new BufferedHeader(((CharArrayBuffer) (obj))));
        return list;
    }

    protected void formatCookieAsVer(CharArrayBuffer chararraybuffer, Cookie cookie, int i)
    {
        formatParamAsVer(chararraybuffer, cookie.getName(), cookie.getValue(), i);
        if (cookie.getPath() != null && (cookie instanceof ClientCookie) && ((ClientCookie)cookie).containsAttribute("path"))
        {
            chararraybuffer.append("; ");
            formatParamAsVer(chararraybuffer, "$Path", cookie.getPath(), i);
        }
        if (cookie.getDomain() != null && (cookie instanceof ClientCookie) && ((ClientCookie)cookie).containsAttribute("domain"))
        {
            chararraybuffer.append("; ");
            formatParamAsVer(chararraybuffer, "$Domain", cookie.getDomain(), i);
        }
    }

    public List formatCookies(List list)
    {
        Args.notEmpty(list, "List of cookies");
        if (list.size() > 1)
        {
            list = new ArrayList(list);
            Collections.sort(list, PATH_COMPARATOR);
        }
        if (oneHeader)
        {
            return doFormatOneHeader(list);
        } else
        {
            return doFormatManyHeaders(list);
        }
    }

    protected void formatParamAsVer(CharArrayBuffer chararraybuffer, String s, String s1, int i)
    {
label0:
        {
            chararraybuffer.append(s);
            chararraybuffer.append("=");
            if (s1 != null)
            {
                if (i <= 0)
                {
                    break label0;
                }
                chararraybuffer.append('"');
                chararraybuffer.append(s1);
                chararraybuffer.append('"');
            }
            return;
        }
        chararraybuffer.append(s1);
    }

    public int getVersion()
    {
        return 1;
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
        } else
        {
            return parse(header.getElements(), cookieorigin);
        }
    }

    public String toString()
    {
        return "rfc2109";
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        Args.notNull(cookie, "Cookie");
        String s = cookie.getName();
        if (s.indexOf(' ') != -1)
        {
            throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
        }
        if (s.startsWith("$"))
        {
            throw new CookieRestrictionViolationException("Cookie name may not start with $");
        } else
        {
            super.validate(cookie, cookieorigin);
            return;
        }
    }

}
