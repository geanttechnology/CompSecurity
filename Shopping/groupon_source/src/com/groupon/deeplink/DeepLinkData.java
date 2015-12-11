// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;

import com.groupon.deeplink.annotation.DeepLinkField;
import com.groupon.deeplink.annotation.Required;
import com.groupon.deeplink.annotation.Values;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.HashMap;

// Referenced classes of package com.groupon.deeplink:
//            InvalidDeepLinkException, Endpoint

public abstract class DeepLinkData
{

    public static final String PARAM_ATTR_CID = "cid";
    public static final String PARAM_ATTR_LINK_ID = "grpn_l";
    public static final String UTM_MEDIUM = "utm_medium";
    private String attributionId;
    private String attributionType;
    private String contentId;
    private String countryCode;
    private Endpoint endpoint;
    private String fields[];
    private String normalizedPath;
    private HashMap params;
    private String specialId;
    private String specifier;
    private URI uri;

    public DeepLinkData()
    {
    }

    public String getAttributionCid()
    {
        return getParam("cid");
    }

    public String getAttributionLinkId()
    {
        if (attributionId != null)
        {
            return attributionId;
        } else
        {
            return getParam("grpn_l");
        }
    }

    public String getContentId()
    {
        return contentId;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public Endpoint getEndpoint()
    {
        return endpoint;
    }

    public String[] getFields()
    {
        return fields;
    }

    public String getNormalizedPath()
    {
        return normalizedPath;
    }

    public String getParam(String s)
    {
        if (params == null)
        {
            s = "";
        } else
        {
            String s1 = (String)params.get(s);
            s = s1;
            if (s1 == null)
            {
                return "";
            }
        }
        return s;
    }

    public HashMap getParams()
    {
        return params;
    }

    public String getSpecialId()
    {
        return specialId;
    }

    public String getSpecifier()
    {
        return specifier;
    }

    public URI getUri()
    {
        return uri;
    }

    public String getUtmMediumAttribution()
    {
        if (attributionType != null)
        {
            return attributionType;
        } else
        {
            return getParam("utm_medium");
        }
    }

    public void setAttributionId(String s)
    {
        attributionId = s;
    }

    public void setAttributionType(String s)
    {
        attributionType = s;
    }

    public void setContentId(String s)
    {
        contentId = s;
    }

    public void setCountryCode(String s)
    {
        countryCode = s;
    }

    public void setEndpoint(Endpoint endpoint1)
    {
        endpoint = endpoint1;
    }

    public void setFields(String as[])
    {
        fields = as;
    }

    public void setNormalizedPath(String s)
    {
        normalizedPath = s;
    }

    public void setParams(HashMap hashmap)
    {
        params = new HashMap(hashmap);
    }

    public void setSpecialId(String s)
    {
        specialId = s;
    }

    public void setSpecifier(String s)
    {
        specifier = s;
    }

    public void setUri(URI uri1)
    {
        uri = uri1;
    }

    public String toString()
    {
        return uri.toString();
    }

    public void validate()
        throws InvalidDeepLinkException
    {
        Annotation aannotation[] = getClass().getAnnotations();
        int i1 = aannotation.length;
label0:
        for (int i = 0; i < i1; i++)
        {
            Object obj = aannotation[i];
            if (((Annotation) (obj)).annotationType().equals(com/groupon/deeplink/annotation/Required))
            {
                obj = ((Required)obj).values();
                int l = obj.length;
                int j = 0;
                do
                {
                    if (j >= l)
                    {
                        continue label0;
                    }
                    if (obj[j].equals(DeepLinkField.SPECIFIER) && specifier.isEmpty())
                    {
                        throw new InvalidDeepLinkException("Specifier is required");
                    }
                    j++;
                } while (true);
            }
            if (!((Annotation) (obj)).annotationType().equals(com/groupon/deeplink/annotation/Values))
            {
                continue;
            }
            obj = (Values)obj;
            DeepLinkField deeplinkfield = ((Values) (obj)).field();
            String as[] = ((Values) (obj)).values();
            obj = "";
            if (deeplinkfield.equals(DeepLinkField.SPECIFIER))
            {
                obj = specifier;
            }
            if (((String) (obj)).isEmpty())
            {
                continue;
            }
            boolean flag1 = false;
            int j1 = as.length;
            int k = 0;
            do
            {
label1:
                {
                    boolean flag = flag1;
                    if (k < j1)
                    {
                        if (!as[k].equals(obj))
                        {
                            break label1;
                        }
                        flag = true;
                    }
                    if (!flag)
                    {
                        throw new InvalidDeepLinkException((new StringBuilder()).append("Unknown value ").append(((String) (obj))).append(" for field ").append(deeplinkfield.name()).toString());
                    }
                    continue label0;
                }
                k++;
            } while (true);
        }

    }
}
