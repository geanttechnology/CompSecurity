// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.app.Application;
import com.groupon.cookies.CookieFactory;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.jackson.type.TypeReference;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class SharedPreferencesCookieStore extends CookieHandler
{
    private static final class GrouponHttpCookie
    {

        public String comment;
        public String commentURL;
        public boolean discard;
        public String domain;
        public long maxAge;
        public String name;
        public String path;
        public String portList;
        public boolean secure;
        public String value;
        public int version;

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            } else
            {
                obj = (GrouponHttpCookie)obj;
                return name.equals(((GrouponHttpCookie) (obj)).name);
            }
        }

        public boolean hasExpired()
        {
            while (maxAge == -1L || maxAge > 0L) 
            {
                return false;
            }
            return true;
        }

        public int hashCode()
        {
            return name.hashCode();
        }

        public HttpCookie toHttpCookie()
        {
            HttpCookie httpcookie = new HttpCookie(name, value);
            httpcookie.setComment(comment);
            httpcookie.setCommentURL(commentURL);
            httpcookie.setDiscard(discard);
            httpcookie.setDomain(domain);
            httpcookie.setMaxAge(maxAge);
            httpcookie.setPath(path);
            httpcookie.setPortlist(portList);
            httpcookie.setSecure(secure);
            httpcookie.setVersion(version);
            return httpcookie;
        }

        public GrouponHttpCookie()
        {
            maxAge = -1L;
        }

        public GrouponHttpCookie(HttpCookie httpcookie)
        {
            maxAge = -1L;
            comment = httpcookie.getComment();
            commentURL = httpcookie.getCommentURL();
            discard = httpcookie.getDiscard();
            domain = httpcookie.getDomain();
            maxAge = httpcookie.getMaxAge();
            name = httpcookie.getName();
            path = httpcookie.getPath();
            portList = httpcookie.getPortlist();
            secure = httpcookie.getSecure();
            value = httpcookie.getValue();
            version = httpcookie.getVersion();
        }
    }


    private static final String BIG_JP_COOKIE_NAME = "_ses_data_";
    private static Pattern DOMAIN_PATTERN = Pattern.compile("^.*\\.(\\w*(?:groupon)\\.[^/]*).*$");
    private static final String VERSION_ONE_HEADER = "Set-cookie2";
    private static final String VERSION_ZERO_HEADER = "Set-cookie";
    private Application context;
    private CookieFactory cookieFactory;
    private CurrentCountryManager currentCountryManager;
    private ContextScopedProvider currentCountryServiceProvider;
    private LoginService loginService;
    private ObjectMapperWrapper om;
    protected ArraySharedPreferences prefs;

    public SharedPreferencesCookieStore()
    {
    }

    private URI convertToHttp(URI uri)
    {
        if (uri == null)
        {
            return null;
        }
        URI uri1;
        try
        {
            uri1 = new URI("http", uri.getHost(), null, null);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            return uri;
        }
        return uri1;
    }

    private Map cookiesToMultimap(List list)
    {
        if (list.isEmpty())
        {
            return Collections.emptyMap();
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Strings.toString(list.get(0)));
        for (int i = 1; i < list.size(); i++)
        {
            stringbuilder.append("; ").append(Strings.toString(list.get(i)));
        }

        return Collections.singletonMap("Cookie", Collections.singletonList(stringbuilder.toString().replace("\"", "")));
    }

    private URI cookiesUri(String s)
        throws URISyntaxException
    {
        return new URI("http", s, null, null);
    }

    private String getDomain()
    {
        String s = "";
        String s1 = ((CurrentCountryService)currentCountryServiceProvider.get(context)).getBaseUrl(currentCountryManager.getCurrentCountry());
        s = s1;
_L2:
        return getDomain(s);
        CountryNotSupportedException countrynotsupportedexception;
        countrynotsupportedexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String getDomain(String s)
    {
        s = DOMAIN_PATTERN.matcher(s);
        if (s.matches())
        {
            return s.replaceAll(".$1");
        } else
        {
            return "";
        }
    }

    private void insertTrackingCookies(List list)
    {
        HttpCookie httpcookie = new HttpCookie("s", cookieFactory.getSessionCookie());
        HttpCookie httpcookie1 = new HttpCookie("b", cookieFactory.getBrowserCookie());
        if (!list.contains(httpcookie))
        {
            list.add(httpcookie);
        }
        if (!list.contains(httpcookie1))
        {
            list.add(httpcookie1);
        }
        if (loginService.isLoggedIn())
        {
            list.add(new HttpCookie("l", cookieFactory.getUserPermalinkCookie()));
        }
    }

    private List multimapToCookies(Map map)
    {
        Object obj = new ArrayList();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj1 = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj1)).getKey();
            if (s != null && (s.equalsIgnoreCase("Set-cookie") || s.equalsIgnoreCase("Set-cookie2")))
            {
                obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    String s1 = (String)((Iterator) (obj1)).next();
                    try
                    {
                        ((List) (obj)).addAll(HttpCookie.parse(s1));
                    }
                    catch (IllegalArgumentException illegalargumentexception) { }
                }
            }
        } while (true);
        map = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); map.add(new GrouponHttpCookie((HttpCookie)((Iterator) (obj)).next()))) { }
        return map;
    }

    public Map get(URI uri, Map map)
        throws IOException
    {
        if (uri == null || map == null)
        {
            throw new IllegalArgumentException("URI or request headers cannot be null");
        }
        cookieFactory.setUserPermalink(loginService.getUserId());
        map = (List)getFilteredCookiesMap().get(convertToHttp(uri));
        uri = map;
        if (map == null)
        {
            uri = new ArrayList();
        }
        map = getDomain();
        insertTrackingCookies(uri);
        if (!map.endsWith("groupon.com"))
        {
            insertTrackingCookies(uri);
        }
        return cookiesToMultimap(uri);
    }

    public Map getFilteredCookiesMap()
    {
        Object obj;
        HashMap hashmap;
        hashmap = new HashMap();
        obj = prefs.getAll();
        obj = ((Map) (obj)).entrySet().iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry;
        URI uri;
        Object obj2;
        entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        uri = cookiesUri((String)entry.getKey());
        obj2 = (String)entry.getValue();
        obj2 = (List)om.readValue(((String) (obj2)), new TypeReference() {

            final SharedPreferencesCookieStore this$0;

            
            {
                this$0 = SharedPreferencesCookieStore.this;
                super();
            }
        });
        Iterator iterator = ((List) (obj2)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            GrouponHttpCookie grouponhttpcookie = (GrouponHttpCookie)iterator.next();
            if (grouponhttpcookie.hasExpired() || Strings.equals(grouponhttpcookie.name, "_ses_data_"))
            {
                iterator.remove();
            }
        } while (true);
          goto _L3
        Object obj1;
        obj1;
_L5:
        Ln.e(((Throwable) (obj1)));
_L2:
        return hashmap;
_L3:
        ArrayList arraylist;
        arraylist = new ArrayList(((List) (obj2)).size());
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(((GrouponHttpCookie)((Iterator) (obj2)).next()).toHttpCookie())) { }
        hashmap.put(uri, arraylist);
        prefs.edit().putString((String)entry.getKey(), om.writeValueAsString(arraylist)).apply();
          goto _L4
        obj1;
          goto _L5
    }

    public void put(URI uri, Map map)
        throws IOException
    {
        if (uri == null || map == null)
        {
            throw new IllegalArgumentException("URI or request headers cannot be null");
        }
        List list = multimapToCookies(map);
        uri = convertToHttp(uri);
        if (uri == null)
        {
            uri = null;
        } else
        {
            uri = uri.getHost();
        }
        map = prefs.getString(uri, "");
        if (Strings.isEmpty(map))
        {
            map = new ArrayList();
        } else
        {
            map = (List)om.readValue(map, new TypeReference() {

                final SharedPreferencesCookieStore this$0;

            
            {
                this$0 = SharedPreferencesCookieStore.this;
                super();
            }
            });
            map.removeAll(list);
        }
        map.addAll(list);
        prefs.edit().putString(uri, om.writeValueAsString(map)).apply();
    }

}
