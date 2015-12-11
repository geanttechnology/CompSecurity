// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm;

import com.rhythmnewmedia.sdk.AdParameters;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.ParamParser;

public class Parameters extends AdParameters
{

    public static final String FW_PARAMETER_AREA_CODE = "areaCode";
    public static final String FW_PARAMETER_DATE_OF_BIRTH = "dateOfBirth";
    public static final String FW_PARAMETER_GENDER = "gender";
    public static final String FW_PARAMETER_GENDER_FEMALE = "female";
    public static final String FW_PARAMETER_GENDER_MALE = "male";
    public static final String FW_PARAMETER_POSTAL_CODE = "postalCode";
    public static final String FW_PARAMETER_RNM_APPID = "applicationID";
    public static final String FW_PARAMETER_RNM_FULLSCREEN = "fullScreen";
    public static final String FW_PARAMETER_RNM_NAMESPACE_PREFIX = "renderer.rhythm";
    public static final String FW_PARAMETER_RNM_TARGETING = "targeting";
    public static final String FW_PARAMETER_RNM_TEST_MODE = "testMode";
    private static boolean fullScreen;
    private static Logger logger = Logger.getLogger("AdParameters");
    private static String targeting;

    public Parameters()
    {
    }

    public static void extractParam(IRendererContext irenderercontext)
    {
        ParamParser paramparser = new ParamParser(irenderercontext, "renderer.rhythm");
        AdParameters.setAppId(paramparser.parseString("applicationID", null));
        AdParameters.setTestMode(paramparser.parseBoolean("testMode", Boolean.valueOf(false)).booleanValue());
        setTargeting(paramparser.parseString("targeting", null));
        setFullScreen(paramparser.parseBoolean("fullScreen", Boolean.valueOf(false)).booleanValue());
        irenderercontext = paramparser.parseString("postalCode", null);
        if (irenderercontext != null)
        {
            AdParameters.setPostalCode(irenderercontext);
        }
        irenderercontext = paramparser.parseString("areaCode", null);
        if (irenderercontext != null)
        {
            AdParameters.setAreaCode(irenderercontext);
        }
        irenderercontext = paramparser.parseEnum("gender", null, new String[] {
            "male", "female"
        });
        if (irenderercontext != null)
        {
            if (irenderercontext.equals("male"))
            {
                irenderercontext = com.rhythmnewmedia.sdk.AdParameters.Gender.male;
            } else
            {
                irenderercontext = com.rhythmnewmedia.sdk.AdParameters.Gender.female;
            }
            AdParameters.setGender(irenderercontext);
        }
        irenderercontext = paramparser.parseDate("dateOfBirth", null);
        if (irenderercontext != null)
        {
            AdParameters.setBirthday(irenderercontext);
        }
        logger.debug(toJSONString());
    }

    public static String getTargeting()
    {
        return targeting;
    }

    public static boolean isFullScreen()
    {
        return fullScreen;
    }

    public static void setFullScreen(boolean flag)
    {
        fullScreen = flag;
    }

    public static void setTargeting(String s)
    {
        targeting = s;
    }

    public static String toJSONString()
    {
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject();
        i = 0;
_L3:
        if (i >= tv/freewheel/renderers/rhythm/Parameters.getDeclaredFields().length) goto _L2; else goto _L1
_L1:
        Field field;
        field = tv/freewheel/renderers/rhythm/Parameters.getDeclaredFields()[i];
        if (!Modifier.isStatic(field.getModifiers()))
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj1 = field.get(null);
        Object obj = obj1;
        if (obj1 instanceof Calendar)
        {
            obj = ((Calendar)obj1).getTime().toString();
        }
        Object obj2 = obj;
        try
        {
            if (obj instanceof Boolean)
            {
                obj2 = obj.toString();
            }
            jsonobject.put(field.getName(), obj2);
        }
        catch (Exception exception)
        {
            logger.error(exception.getLocalizedMessage());
        }
        i++;
          goto _L3
_L2:
        return jsonobject.toString();
    }

}
