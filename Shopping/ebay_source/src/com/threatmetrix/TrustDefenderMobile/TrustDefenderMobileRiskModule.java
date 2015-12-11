// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.threatmetrix.TrustDefenderMobile.riskmodule.RiskModule;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            TrustDefenderMobileCore, StringUtils, HttpParameterMap, TDConfiguration

public class TrustDefenderMobileRiskModule
    implements RiskModule
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/TrustDefenderMobileRiskModule.getSimpleName();
    final TrustDefenderMobileCore m_td = new TrustDefenderMobileCore();

    public TrustDefenderMobileRiskModule()
    {
    }

    public byte[] getConfigurationBody()
    {
        return null;
    }

    public Header[] getConfigurationHTTPHeaders(String s)
    {
        m_td.setBrowserStringFromJS(s);
        return StringUtils.mapToHeader(m_td.getConfigurationHeaders());
    }

    public String getConfigurationHttpMethod()
    {
        return "GET";
    }

    public URL getConfigurationURL()
        throws MalformedURLException
    {
        String s = m_td.getConfigurationPath();
        HttpParameterMap httpparametermap = m_td.getConfigurationParams();
        return new URL((new StringBuilder()).append(s).append("?").append(httpparametermap.getUrlEncodedParamString()).toString());
    }

    public byte[] getRiskDataBody(Hashtable hashtable)
    {
        if (!m_td.getConfig().isUsable())
        {
            return null;
        }
        try
        {
            hashtable = EntityUtils.toByteArray(m_td.getRiskBodyParameterMap().getEntity());
        }
        // Misplaced declaration of an exception variable
        catch (Hashtable hashtable)
        {
            Log.e(TAG, "Interrupted", hashtable);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Hashtable hashtable)
        {
            Log.e(TAG, "IO", hashtable);
            return null;
        }
        return hashtable;
    }

    public Header[] getRiskDataHTTPHeaders()
    {
        return StringUtils.mapToHeader(m_td.getRiskDataHeaders());
    }

    public String getRiskDataHttpMethod()
    {
        return "POST";
    }

    public URL getRiskDataURL()
        throws MalformedURLException
    {
        return new URL((new StringBuilder()).append("https://").append(m_td.getFPServer()).append("/fp/clear.png").toString());
    }

    public String getSessionID()
    {
        return m_td.getSessionID();
    }

    public boolean initWithoutTransport(String s, String s1)
    {
        return initWithoutTransport(s, s1, "h.online-metrix.net");
    }

    public boolean initWithoutTransport(String s, String s1, String s2)
    {
        if (s1 != null && !s1.isEmpty())
        {
            m_td.setSessionID(s1);
        } else
        {
            m_td.setSessionID(StringUtils.new_session_id());
        }
        return m_td.setFPServer(s2) && m_td.setOrgID(s) && m_td.setProfileOptions(1241);
    }

    public void prepareRiskTransaction(Context context)
    {
        try
        {
            m_td.setContext(context);
            m_td.setURLS(null, context.getPackageName());
            m_td.gatherInfo();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, "Interrupted", context);
        }
    }

    public Object setConfigurationData(byte abyte0[])
    {
        TDConfiguration tdconfiguration = new TDConfiguration();
        if (abyte0 != null)
        {
            tdconfiguration.parseConfigFromStream(new ByteArrayInputStream(abyte0));
            m_td.setConfig(tdconfiguration);
            if (tdconfiguration.isUsable())
            {
                return new String("SUCCESS");
            }
        }
        return null;
    }

    public void setLocation(Location location)
    {
        m_td.setLocation(location);
    }

    public void setRiskDataResponse(byte abyte0[])
        throws Exception
    {
    }

}
