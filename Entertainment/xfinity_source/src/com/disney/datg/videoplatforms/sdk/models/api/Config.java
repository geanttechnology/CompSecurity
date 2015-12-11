// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import android.util.Log;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import com.disney.datg.videoplatforms.sdk.utils.StringUtils;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            Features, Feature, Param, WebService, 
//            NonSecure, Url, Secure, WebServices, 
//            Application

public class Config
    implements Serializable, Comparable
{

    private Application application;
    private Features features;
    private WebServices webservices;

    public Config()
    {
    }

    public int compareTo(Config config)
    {
        Persister persister = new Persister();
        StringWriter stringwriter = new StringWriter();
        StringWriter stringwriter1 = new StringWriter();
        int i;
        try
        {
            persister.write(getApplication(), stringwriter);
            persister.write(getFeatures(), stringwriter);
            persister.write(getWebservices(), stringwriter);
            persister.write(config.getApplication(), stringwriter1);
            persister.write(config.getFeatures(), stringwriter1);
            persister.write(config.getWebservices(), stringwriter1);
            i = stringwriter.toString().compareTo(stringwriter1.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Config config)
        {
            LogUtils.logException(config);
            Log.e(getClass().getName(), (new StringBuilder()).append("serializer.write exception ").append(config.getMessage()).toString());
            return -1;
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Config)obj);
    }

    public Application getApplication()
    {
        return application;
    }

    public Feature getFeatureById(String s)
    {
        if (StringUtils.isNotNull(s) && features != null && features.getFeatures() != null)
        {
            ArrayList arraylist = features.getFeatures();
            if (arraylist.size() > 0)
            {
                for (int i = 0; i < arraylist.size(); i++)
                {
                    Feature feature = (Feature)arraylist.get(i);
                    if (feature != null && StringUtils.isNotNull(feature.getId()) && (feature.getId().equals(s) || feature.getId().contains(s)))
                    {
                        return feature;
                    }
                }

            }
        }
        return null;
    }

    public Features getFeatures()
    {
        return features;
    }

    public String getParamInFeatureId(String s, String s1)
    {
        if (StringUtils.isNotNull(s) && StringUtils.isNotNull(s1))
        {
            s1 = getFeatureById(s1);
            if (s1 != null)
            {
                s1 = s1.getParam();
                if (s1 != null && s1.size() > 0)
                {
                    for (int i = 0; i < s1.size(); i++)
                    {
                        Param param = (Param)s1.get(i);
                        if (StringUtils.isNotNull(param.getValue()) && (param.getValue().equals(s) || param.getValue().contains(s)))
                        {
                            return param.getAttrValue();
                        }
                    }

                }
            }
        }
        return null;
    }

    public String getURLFromWebServiceName(String s)
    {
        if (StringUtils.isNotNull(s))
        {
            s = getWebServiceByName(s);
            if (s != null)
            {
                if (s.getNonsecure() != null && s.getNonsecure().getUrl() != null)
                {
                    s = s.getNonsecure().getUrl();
                    if (StringUtils.isNotNull(s.getValue()))
                    {
                        return s.getValue();
                    }
                } else
                if (s.getSecure() != null && s.getSecure().getUrl() != null)
                {
                    s = s.getSecure().getUrl();
                    if (StringUtils.isNotNull(s.getValue()))
                    {
                        return s.getValue();
                    }
                }
            }
        }
        return null;
    }

    public WebService getWebServiceByName(String s)
    {
        if (StringUtils.isNotNull(s) && webservices != null && webservices.getWebServices() != null)
        {
            ArrayList arraylist = webservices.getWebServices();
            if (arraylist.size() > 0)
            {
                for (int i = 0; i < arraylist.size(); i++)
                {
                    WebService webservice = (WebService)arraylist.get(i);
                    if (webservice != null && StringUtils.isNotNull(webservice.getName()) && s.equals(webservice.getName()))
                    {
                        return webservice;
                    }
                }

            }
        }
        return null;
    }

    public WebServices getWebservices()
    {
        return webservices;
    }
}
