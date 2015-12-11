// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Collection;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            BrowserCompatSpec

public class BrowserCompatSpecFactory
    implements CookieSpecFactory, CookieSpecProvider
{
    public static final class SecurityLevel extends Enum
    {

        private static final SecurityLevel $VALUES[];
        public static final SecurityLevel SECURITYLEVEL_DEFAULT;
        public static final SecurityLevel SECURITYLEVEL_IE_MEDIUM;

        public static SecurityLevel valueOf(String s)
        {
            return (SecurityLevel)Enum.valueOf(cz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel, s);
        }

        public static SecurityLevel[] values()
        {
            return (SecurityLevel[])$VALUES.clone();
        }

        static 
        {
            SECURITYLEVEL_DEFAULT = new SecurityLevel("SECURITYLEVEL_DEFAULT", 0);
            SECURITYLEVEL_IE_MEDIUM = new SecurityLevel("SECURITYLEVEL_IE_MEDIUM", 1);
            $VALUES = (new SecurityLevel[] {
                SECURITYLEVEL_DEFAULT, SECURITYLEVEL_IE_MEDIUM
            });
        }

        private SecurityLevel(String s, int i)
        {
            super(s, i);
        }
    }


    private final String datepatterns[];
    private final SecurityLevel securityLevel;

    public BrowserCompatSpecFactory()
    {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactory(String as[])
    {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactory(String as[], SecurityLevel securitylevel)
    {
        datepatterns = as;
        securityLevel = securitylevel;
    }

    public CookieSpec create(HttpContext httpcontext)
    {
        return new BrowserCompatSpec(datepatterns);
    }

    public CookieSpec newInstance(HttpParams httpparams)
    {
        if (httpparams != null)
        {
            Object obj = null;
            Collection collection = (Collection)httpparams.getParameter("http.protocol.cookie-datepatterns");
            httpparams = obj;
            if (collection != null)
            {
                httpparams = (String[])collection.toArray(new String[collection.size()]);
            }
            return new BrowserCompatSpec(httpparams, securityLevel);
        } else
        {
            return new BrowserCompatSpec(null, securityLevel);
        }
    }
}
