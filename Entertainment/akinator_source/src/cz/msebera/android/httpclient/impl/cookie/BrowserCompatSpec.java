// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BasicHeaderElement;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            CookieSpecBase, BasicPathHandler, BasicDomainHandler, BasicMaxAgeHandler, 
//            BasicSecureHandler, BasicCommentHandler, BasicExpiresHandler, BrowserCompatVersionAttributeHandler, 
//            NetscapeDraftHeaderParser, BasicClientCookie

public class BrowserCompatSpec extends CookieSpecBase
{

    private static final String DEFAULT_DATE_PATTERNS[] = {
        "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", 
        "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"
    };
    private final String datepatterns[];

    public BrowserCompatSpec()
    {
        this(null, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec(String as[])
    {
        this(as, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec(String as[], BrowserCompatSpecFactory.SecurityLevel securitylevel)
    {
        static class _cls2
        {

            static final int $SwitchMap$cz$msebera$android$httpclient$impl$cookie$BrowserCompatSpecFactory$SecurityLevel[];

            static 
            {
                $SwitchMap$cz$msebera$android$httpclient$impl$cookie$BrowserCompatSpecFactory$SecurityLevel = new int[BrowserCompatSpecFactory.SecurityLevel.values().length];
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$impl$cookie$BrowserCompatSpecFactory$SecurityLevel[BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$cz$msebera$android$httpclient$impl$cookie$BrowserCompatSpecFactory$SecurityLevel[BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_IE_MEDIUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (as != null)
        {
            datepatterns = (String[])as.clone();
        } else
        {
            datepatterns = DEFAULT_DATE_PATTERNS;
        }
        _cls2..SwitchMap.cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory.SecurityLevel[securitylevel.ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 68
    //                   2 164;
           goto _L1 _L2 _L3
_L1:
        throw new RuntimeException("Unknown security level");
_L2:
        registerAttribHandler("path", new BasicPathHandler());
_L5:
        registerAttribHandler("domain", new BasicDomainHandler());
        registerAttribHandler("max-age", new BasicMaxAgeHandler());
        registerAttribHandler("secure", new BasicSecureHandler());
        registerAttribHandler("comment", new BasicCommentHandler());
        registerAttribHandler("expires", new BasicExpiresHandler(datepatterns));
        registerAttribHandler("version", new BrowserCompatVersionAttributeHandler());
        return;
_L3:
        registerAttribHandler("path", new BasicPathHandler() {

            final BrowserCompatSpec this$0;

            public void validate(Cookie cookie, CookieOrigin cookieorigin)
                throws MalformedCookieException
            {
            }

            
            {
                this$0 = BrowserCompatSpec.this;
                super();
            }
        });
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static boolean isQuoteEnclosed(String s)
    {
        return s != null && s.startsWith("\"") && s.endsWith("\"");
    }

    public List formatCookies(List list)
    {
        Args.notEmpty(list, "List of cookies");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(list.size() * 20);
        chararraybuffer.append("Cookie");
        chararraybuffer.append(": ");
        int i = 0;
        while (i < list.size()) 
        {
            Cookie cookie = (Cookie)list.get(i);
            if (i > 0)
            {
                chararraybuffer.append("; ");
            }
            String s = cookie.getName();
            String s1 = cookie.getValue();
            if (cookie.getVersion() > 0 && !isQuoteEnclosed(s1))
            {
                BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(chararraybuffer, new BasicHeaderElement(s, s1), false);
            } else
            {
                chararraybuffer.append(s);
                chararraybuffer.append("=");
                if (s1 != null)
                {
                    chararraybuffer.append(s1);
                }
            }
            i++;
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
        HeaderElement aheaderelement[] = header.getElements();
        boolean flag1 = false;
        boolean flag = false;
        int k = aheaderelement.length;
        for (int i = 0; i < k; i++)
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
            String s;
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
            aheaderelement = netscapedraftheaderparser.parseHeader(header, aheaderelement);
            header = aheaderelement.getName();
            s = aheaderelement.getValue();
            if (header == null || TextUtils.isBlank(header))
            {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            header = new BasicClientCookie(header, s);
            header.setPath(getDefaultPath(cookieorigin));
            header.setDomain(getDefaultDomain(cookieorigin));
            cookieorigin = aheaderelement.getParameters();
            for (int j = cookieorigin.length - 1; j >= 0; j--)
            {
                aheaderelement = cookieorigin[j];
                Object obj = aheaderelement.getName().toLowerCase(Locale.ENGLISH);
                header.setAttribute(((String) (obj)), aheaderelement.getValue());
                obj = findAttribHandler(((String) (obj)));
                if (obj != null)
                {
                    ((CookieAttributeHandler) (obj)).parse(header, aheaderelement.getValue());
                }
            }

            if (flag)
            {
                header.setVersion(0);
            }
            return Collections.singletonList(header);
        } else
        {
            return parse(aheaderelement, cookieorigin);
        }
    }

    public String toString()
    {
        return "compatibility";
    }

}
