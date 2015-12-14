// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import android.net.Uri;
import java.net.URI;
import org.apache.http.HttpHost;

public class Endpoint
{
    public static final class Marketplace extends Enum
    {

        private static final Marketplace $VALUES[];
        public static final Marketplace AUSTRALIA;
        public static final Marketplace CANADA;
        public static final Marketplace CHINA;
        public static final Marketplace EUROPE;
        public static final Marketplace FRANCE;
        public static final Marketplace GERMANY;
        public static final Marketplace INDIA;
        public static final Marketplace ITALY;
        public static final Marketplace JAPAN;
        public static final Marketplace SPAIN;
        public static final Marketplace UK;
        public static final Marketplace UNKNOWN;
        public static final Marketplace US;

        public static Marketplace valueOf(String s)
        {
            return (Marketplace)Enum.valueOf(com/amazon/gallery/framework/network/http/rest/account/Endpoint$Marketplace, s);
        }

        public static Marketplace[] values()
        {
            return (Marketplace[])$VALUES.clone();
        }

        static 
        {
            CHINA = new Marketplace("CHINA", 0);
            JAPAN = new Marketplace("JAPAN", 1);
            US = new Marketplace("US", 2);
            EUROPE = new Marketplace("EUROPE", 3);
            CANADA = new Marketplace("CANADA", 4);
            INDIA = new Marketplace("INDIA", 5);
            SPAIN = new Marketplace("SPAIN", 6);
            ITALY = new Marketplace("ITALY", 7);
            FRANCE = new Marketplace("FRANCE", 8);
            GERMANY = new Marketplace("GERMANY", 9);
            UK = new Marketplace("UK", 10);
            AUSTRALIA = new Marketplace("AUSTRALIA", 11);
            UNKNOWN = new Marketplace("UNKNOWN", 12);
            $VALUES = (new Marketplace[] {
                CHINA, JAPAN, US, EUROPE, CANADA, INDIA, SPAIN, ITALY, FRANCE, GERMANY, 
                UK, AUSTRALIA, UNKNOWN
            });
        }

        private Marketplace(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/http/rest/account/Endpoint.getName();
    private final boolean customerExists;
    private final String endpoint;
    private final String host;
    private final String path;

    private Endpoint()
    {
        endpoint = "http://www.amazon.com/photos/api/";
        customerExists = false;
        host = URI.create(endpoint).getHost();
        path = URI.create(endpoint).getPath();
    }

    public Endpoint(Uri uri)
    {
        endpoint = uri.toString();
        customerExists = false;
        host = uri.getHost();
        path = uri.getPath();
    }

    public Endpoint(String s, boolean flag)
    {
        endpoint = s;
        customerExists = flag;
        host = URI.create(s).getHost();
        path = URI.create(s).getPath();
    }

    public String getEndpoint()
    {
        return endpoint;
    }

    public Marketplace getExactMarketplace()
    {
        if (host != null)
        {
            if (host.contains("amazon.com"))
            {
                return Marketplace.US;
            }
            if (host.contains("amazon.co.uk"))
            {
                return Marketplace.UK;
            }
            if (host.contains("www.amazon.de"))
            {
                return Marketplace.GERMANY;
            }
            if (host.contains("www.amazon.fr"))
            {
                return Marketplace.FRANCE;
            }
            if (host.contains("www.amazon.es"))
            {
                return Marketplace.SPAIN;
            }
            if (host.contains("www.amazon.it"))
            {
                return Marketplace.ITALY;
            }
            if (host.contains("amazon.ca"))
            {
                return Marketplace.CANADA;
            }
            if (host.contains("amazon.cn"))
            {
                return Marketplace.CHINA;
            }
            if (host.contains("amazon.co.jp"))
            {
                return Marketplace.JAPAN;
            }
            if (host.contains("amazon.in"))
            {
                return Marketplace.INDIA;
            }
            if (host.contains("amazon.com.au"))
            {
                return Marketplace.AUSTRALIA;
            }
        }
        return Marketplace.UNKNOWN;
    }

    public HttpHost getHttpHost()
    {
        return new HttpHost(host, -1, "https");
    }

    public String getHttpHostString()
    {
        return host;
    }

    public String getHttpPath()
    {
        return (new StringBuilder()).append(getHttpHost()).append(path).toString();
    }

    public String getManageStorageUrl()
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("https").authority(getHttpHostString()).appendEncodedPath("gp/photos/storage").appendQueryParameter("hide_nav", "1");
        return builder.build().toString();
    }

    public Marketplace getMarketplace()
    {
        if (host != null)
        {
            if (host.contains("amazon.com"))
            {
                return Marketplace.US;
            }
            if (host.contains("amazon.co.uk") || host.contains("www.amazon.de") || host.contains("www.amazon.fr") || host.contains("amazon.es") || host.contains("www.amazon.it"))
            {
                return Marketplace.EUROPE;
            }
            if (host.contains("amazon.ca"))
            {
                return Marketplace.CANADA;
            }
            if (host.contains("amazon.cn"))
            {
                return Marketplace.CHINA;
            }
            if (host.contains("amazon.co.jp"))
            {
                return Marketplace.JAPAN;
            }
            if (host.contains("amazon.in"))
            {
                return Marketplace.INDIA;
            }
            if (host.contains("amazon.com.au"))
            {
                return Marketplace.AUSTRALIA;
            }
        }
        return Marketplace.UNKNOWN;
    }

}
