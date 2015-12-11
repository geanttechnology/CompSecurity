// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.client;

import com.comcast.playerplatform.drm.java.request.ClientSessionParser;
import com.comcast.playerplatform.util.android.StringUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.drm.java.client:
//            SecurityTokenType

public class SecurityToken
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/drm/java/client/SecurityToken);
    private String deviceId;
    private boolean isInHome;
    private String notOnOrAfter;
    private Map properties;
    private String token;
    private SecurityTokenType type;

    public SecurityToken()
    {
    }

    public SecurityToken(SecurityTokenType securitytokentype, ClientSessionParser clientsessionparser)
    {
        logger.debug((new StringBuilder()).append("Creating Security Token. Token Type:").append(String.valueOf(securitytokentype.name())).toString());
        type = securitytokentype;
        token = clientsessionparser.getToken();
        notOnOrAfter = clientsessionparser.getNotOnOrAfter();
        isInHome = clientsessionparser.getInHome().booleanValue();
        deviceId = clientsessionparser.getDeviceId();
        properties = clientsessionparser.getProperties();
        logger.debug((new StringBuilder()).append("Security Token Created. Token Type:").append(String.valueOf(securitytokentype.name())).toString());
    }

    public SecurityToken(SecurityTokenType securitytokentype, String s)
    {
        type = securitytokentype;
        token = s;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getNotOnOrAfter()
    {
        return notOnOrAfter;
    }

    public Map getProperties()
    {
        return properties;
    }

    public String getToken()
    {
        return token;
    }

    public SecurityTokenType getType()
    {
        return type;
    }

    public boolean isInHome()
    {
        return isInHome;
    }

    public boolean isValid()
    {
label0:
        {
            boolean flag = false;
            if (StringUtil.isNotNullOrEmpty(token))
            {
                if (notOnOrAfter == null)
                {
                    break label0;
                }
                Object obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                ((DateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("Zulu"));
                try
                {
                    obj = ((DateFormat) (obj)).parse(notOnOrAfter);
                    flag = (new Date()).before(((Date) (obj)));
                }
                catch (ParseException parseexception)
                {
                    return false;
                }
            }
            return flag;
        }
        return true;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setName(SecurityTokenType securitytokentype)
    {
        type = securitytokentype;
    }

    public void setNotOnOrAfter(String s)
    {
        notOnOrAfter = s;
    }

    public void setProperties(Map map)
    {
        properties = map;
    }

    public void setToken(String s)
    {
        token = s;
    }

}
