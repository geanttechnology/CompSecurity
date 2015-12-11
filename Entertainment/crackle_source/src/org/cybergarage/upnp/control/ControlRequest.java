// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.control;

import java.net.MalformedURLException;
import java.net.URL;
import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.soap.SOAPRequest;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.Service;

public class ControlRequest extends SOAPRequest
{

    public ControlRequest()
    {
    }

    public ControlRequest(HTTPRequest httprequest)
    {
        set(httprequest);
    }

    public boolean isActionControl()
    {
        return !isQueryControl();
    }

    public boolean isQueryControl()
    {
        return isSOAPAction("urn:schemas-upnp-org:control-1-0#QueryStateVariable");
    }

    protected void setRequestHost(Service service)
    {
        Object obj;
        String s;
        String s1;
        s = service.getControlURL();
        s1 = service.getRootDevice().getURLBase();
        obj = s;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = s;
        if (s1.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        int i;
        s1 = (new URL(s1)).getPath();
        i = s1.length();
        obj = s;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (1 < i)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj = s;
        if (s1.charAt(0) == '/')
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = (new StringBuilder(String.valueOf(s1))).append(s).toString();
_L2:
label0:
        {
            setURI(((String) (obj)), true);
            s = "";
            if (HTTP.isAbsoluteURL(((String) (obj))))
            {
                s = ((String) (obj));
            }
            if (s != null)
            {
                obj = s;
                if (s.length() > 0)
                {
                    break label0;
                }
            }
            obj = service.getRootDevice().getURLBase();
        }
label1:
        {
            if (obj != null)
            {
                s = ((String) (obj));
                if (((String) (obj)).length() > 0)
                {
                    break label1;
                }
            }
            s = service.getRootDevice().getLocation();
        }
        service = HTTP.getHost(s);
        int j = HTTP.getPort(s);
        setHost(service, j);
        setRequestHost(((String) (service)));
        setRequestPort(j);
        return;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        malformedurlexception = s;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
