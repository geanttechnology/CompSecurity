// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;

import com.groupon.deeplink.imp.AppLaunchDeepLink;
import com.groupon.deeplink.imp.BusinessDeepLink;
import com.groupon.deeplink.imp.CardSearchDeepLink;
import com.groupon.deeplink.imp.ChannelDeepLink;
import com.groupon.deeplink.imp.DealDeepLink;
import com.groupon.deeplink.imp.FreebieCategoryDeepLink;
import com.groupon.deeplink.imp.FreebieDeepLink;
import com.groupon.deeplink.imp.FreebieMerchantDeepLink;
import com.groupon.deeplink.imp.LiveChatDeepLink;
import com.groupon.deeplink.imp.ProfileDeepLink;
import com.groupon.deeplink.imp.PurchaseDeepLink;
import com.groupon.deeplink.imp.SearchDeepLink;
import com.groupon.deeplink.imp.SearchResultsDeepLink;
import com.groupon.deeplink.imp.SearchResultsWithUIDeepLink;
import com.groupon.deeplink.imp.SecretAdminDeepLink;
import com.groupon.deeplink.imp.ShoppingCartDeepLink;
import com.groupon.deeplink.imp.SurveyDeepLink;
import com.groupon.deeplink.imp.WebviewDeepLink;
import com.groupon.deeplink.imp.WidgetsDeepLink;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.groupon.deeplink:
//            InvalidDeepLinkException, Endpoint, DeepLinkData

public class DeepLinkUtil
{
    public static class CountriesCodes
    {

        public static final String RU = "ru";

        public CountriesCodes()
        {
        }
    }


    public static final String DEFAULT_HTTP_PREFIX = "http://www.groupon.com/dispatch";
    public static final String DEFAULT_PREFIX = "groupon:///dispatch";
    public static final String FORWARD_SLASH = "/";
    private static final Pattern HOST_PATTERN = Pattern.compile("http[s]?://(www|staging|uat)\\.(groupon.*)/dispatch.*");
    public static final String NULL_STRING = "";
    public static final String PREFIX = "/dispatch";
    public static final Pattern PREFIX_PATTERN = Pattern.compile("^/dispatch(/(.*))?$");
    public static final String STAGING = "staging";
    public static final String UAT = "uat";
    public static final String US_PROD_HOST = "www.groupon.com";
    public static final String WILD_CARD_COUNTRY_CODE = "*";
    public static final Set domainSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] {
        "groupon.com", "groupon.ae", "groupon.com.ar", "groupon.com.au", "groupon.at", "groupon.be", "groupon.com.br", "groupon.ch", "groupon.de", "groupon.dk", 
        "groupon.es", "groupon.fi", "groupon.fr", "groupon.co.uk", "groupon.ie", "groupon.co.il", "groupon.it", "groupon.nl", "groupon.no", "grouponnz.co.nz", 
        "groupon.pl", "groupon.pt", "groupon.se", "groupon.co.za", "groupon.cl", "groupon.com.co", "groupon.com.mx"
    })));

    public DeepLinkUtil()
    {
    }

    private Endpoint getEndpointFromUriString(String s)
        throws InvalidDeepLinkException
    {
label0:
        {
            Endpoint endpoint;
            try
            {
                s = new URI(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new InvalidDeepLinkException(s);
            }
            s = normalizePath(s.getPath()).split("/");
            if (s.length > 2)
            {
                s = s[2];
            } else
            {
                s = "";
            }
            try
            {
                if (s.isEmpty())
                {
                    break label0;
                }
                endpoint = Endpoint.valueOf(s.toUpperCase());
            }
            catch (Exception exception)
            {
                throw new InvalidDeepLinkException((new StringBuilder()).append("Endpoint ").append(s).append(" is not supported").toString());
            }
            return endpoint;
        }
        return null;
    }

    private void handleContentId(DeepLinkData deeplinkdata)
    {
        String as[] = deeplinkdata.getFields();
        String s;
        if (as.length > 4)
        {
            s = as[4];
        } else
        {
            s = "";
        }
        deeplinkdata.setContentId(s);
    }

    private void handleCountryCode(DeepLinkData deeplinkdata)
    {
        String as[] = deeplinkdata.getFields();
        String s;
        if (as.length > 1)
        {
            s = as[1];
        } else
        {
            s = "";
        }
        deeplinkdata.setCountryCode(s);
    }

    private void handleParams(DeepLinkData deeplinkdata)
    {
        String s = deeplinkdata.getUri().getRawQuery();
        if (s == null)
        {
            return;
        }
        String as[] = s.split("&");
        HashMap hashmap = new HashMap();
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s2 = as[i];
            int k = s2.indexOf('=');
            if (k != -1)
            {
                String s1 = s2.substring(0, k);
                s2 = s2.substring(k + 1);
                if (!s1.isEmpty())
                {
                    try
                    {
                        hashmap.put(s1, URLDecoder.decode(s2, "UTF-8"));
                    }
                    catch (UnsupportedEncodingException unsupportedencodingexception)
                    {
                        hashmap.put(s1, s2);
                    }
                }
            }
            i++;
        }
        deeplinkdata.setParams(hashmap);
    }

    private void handleSpecialId(DeepLinkData deeplinkdata)
    {
        String as[] = deeplinkdata.getFields();
        String s;
        if (as.length > 5)
        {
            s = as[5];
        } else
        {
            s = "";
        }
        deeplinkdata.setSpecialId(s);
    }

    private void handleSpecifier(DeepLinkData deeplinkdata)
        throws InvalidDeepLinkException
    {
        Object obj = deeplinkdata.getFields();
        if (shouldHandleRuSpecificDealId(deeplinkdata))
        {
            if (obj.length > 4)
            {
                obj = (new StringBuilder()).append(obj[3]).append("/").append(obj[4]).toString();
            } else
            {
                obj = "";
            }
        } else
        if (obj.length > 3)
        {
            obj = obj[3];
        } else
        {
            obj = "";
        }
        deeplinkdata.setSpecifier(((String) (obj)));
    }

    private String normalizePath(String s)
    {
        Object obj = PREFIX_PATTERN.matcher(s);
        if (((Matcher) (obj)).matches())
        {
            s = ((Matcher) (obj)).group(1);
        }
        obj = s;
        if (s == null)
        {
            obj = "";
        }
        return ((String) (obj));
    }

    private DeepLinkData selectDeepLink(Endpoint endpoint)
        throws InvalidDeepLinkException
    {
        if (endpoint == null)
        {
            return new AppLaunchDeepLink();
        }
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$deeplink$Endpoint[];

            static 
            {
                $SwitchMap$com$groupon$deeplink$Endpoint = new int[Endpoint.values().length];
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.BUSINESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.DEAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.CHANNEL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.FREEBIE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.FREEBIE_CATEGORY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.FREEBIE_MERCHANT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.LIVECHAT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.PROFILE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.PURCHASE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SEARCH.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SEARCH_RESULTS.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SEARCH_RESULTS_WITH_UI.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SHOPPING_CART.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.WEBVIEW.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.WIDGETS.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SURVEY.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.SIKR3TADMIN.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$deeplink$Endpoint[Endpoint.CARDSEARCH.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.groupon.deeplink.Endpoint[endpoint.ordinal()])
        {
        default:
            throw new InvalidDeepLinkException("Unknown endpoint");

        case 1: // '\001'
            return new BusinessDeepLink();

        case 2: // '\002'
            return new DealDeepLink();

        case 3: // '\003'
            return new ChannelDeepLink();

        case 4: // '\004'
            return new FreebieDeepLink();

        case 5: // '\005'
            return new FreebieCategoryDeepLink();

        case 6: // '\006'
            return new FreebieMerchantDeepLink();

        case 7: // '\007'
            return new LiveChatDeepLink();

        case 8: // '\b'
            return new ProfileDeepLink();

        case 9: // '\t'
            return new PurchaseDeepLink();

        case 10: // '\n'
            return new SearchDeepLink();

        case 11: // '\013'
            return new SearchResultsDeepLink();

        case 12: // '\f'
            return new SearchResultsWithUIDeepLink();

        case 13: // '\r'
            return new ShoppingCartDeepLink();

        case 14: // '\016'
            return new WebviewDeepLink();

        case 15: // '\017'
            return new WidgetsDeepLink();

        case 16: // '\020'
            return new SurveyDeepLink();

        case 17: // '\021'
            return new SecretAdminDeepLink();

        case 18: // '\022'
            return new CardSearchDeepLink();
        }
    }

    private boolean shouldHandleRuSpecificDealId(DeepLinkData deeplinkdata)
    {
        return deeplinkdata.getCountryCode().equalsIgnoreCase("ru") && (deeplinkdata.getEndpoint().equals(Endpoint.DEAL) || deeplinkdata.getEndpoint().equals(Endpoint.PURCHASE));
    }

    public String defaultLocalDeeplink(String s)
    {
        return (new StringBuilder()).append("groupon:///dispatch/").append(s).append("/").toString();
    }

    public DeepLinkData getDeepLink(String s)
        throws InvalidDeepLinkException
    {
        URI uri;
        URI uri1;
        DeepLinkData deeplinkdata;
        try
        {
            Endpoint endpoint = getEndpointFromUriString(s);
            deeplinkdata = selectDeepLink(endpoint);
            if (!(deeplinkdata instanceof AppLaunchDeepLink))
            {
                deeplinkdata.setEndpoint(endpoint);
            }
            uri1 = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidDeepLinkException(s);
        }
        uri = uri1;
        if (uri1.getHost() == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (uri1.getHost().startsWith("uat"))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        uri = uri1;
        if (!uri1.getHost().startsWith("staging"))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        uri = new URI(s.replaceFirst(uri1.getHost(), "www.groupon.com"));
        deeplinkdata.setUri(uri);
        s = normalizePath(uri.getPath());
        deeplinkdata.setNormalizedPath(s);
        deeplinkdata.setFields(s.split("/"));
        handleCountryCode(deeplinkdata);
        handleSpecifier(deeplinkdata);
        handleContentId(deeplinkdata);
        handleSpecialId(deeplinkdata);
        handleParams(deeplinkdata);
        deeplinkdata.validate();
        return deeplinkdata;
    }

    public boolean hasWildCardCountryCode(DeepLinkData deeplinkdata)
    {
        return deeplinkdata.getCountryCode().equals("*");
    }

    public boolean isBaseUrl(DeepLinkData deeplinkdata)
    {
        return deeplinkdata.getNormalizedPath().equals("") || deeplinkdata.getNormalizedPath().equals("/");
    }

    public boolean isDeepLink(String s)
    {
        if (!s.isEmpty())
        {
            if (s.startsWith("groupon:///dispatch"))
            {
                return true;
            }
            s = HOST_PATTERN.matcher(s);
            if (s.matches())
            {
                s = s.group(2);
                return domainSet.contains(s);
            }
        }
        return false;
    }

    public boolean isValidURL(DeepLinkData deeplinkdata)
    {
        try
        {
            if (!deeplinkdata.getUri().toString().startsWith("groupon:///dispatch"))
            {
                new URI((new StringBuilder()).append("http://").append(deeplinkdata.getUri().getHost()).append(deeplinkdata.getNormalizedPath()).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (DeepLinkData deeplinkdata)
        {
            return false;
        }
        return true;
    }

    public String normalizeUrl(String s, boolean flag)
    {
        String s1;
        String s2;
        if (flag)
        {
            s1 = "groupon:///dispatch";
        } else
        {
            s1 = "http://www.groupon.com/dispatch";
        }
        if (s == null)
        {
            s2 = null;
        } else
        {
            s2 = s;
            if (!s.startsWith("http://"))
            {
                if (s.startsWith("/"))
                {
                    return (new StringBuilder()).append(s1).append(s).toString();
                } else
                {
                    return (new StringBuilder()).append(s1).append("/").append(s).toString();
                }
            }
        }
        return s2;
    }

}
