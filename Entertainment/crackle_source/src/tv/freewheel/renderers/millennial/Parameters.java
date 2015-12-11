// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.millennial;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.ParamParser;

public class Parameters
{

    public static final String NAMESPACE = "renderer.millennial";
    public static final String PARAM_AD_REQUEST_TIMEOUT = "adRequestTimeout";
    public static final String PARAM_AD_TYPE = "adType";
    public static final String PARAM_APID = "apId";
    public static final String PARAM_DATE_OF_BIRTH = "dateOfBirth";
    public static final String PARAM_EDUCATION = "education";
    public static final String PARAM_ETHNICITY = "ethnicity";
    public static final String PARAM_GENDER = "gender";
    public static final String PARAM_INCOME = "income";
    public static final String PARAM_MARITAL = "marital";
    public static final String PARAM_ORIENTATION = "orientation";
    public static final String PARAM_POLITICS = "politics";
    public static final String PARAM_POSTAL_CODE = "postalCode";
    public static final String PARAM_SHOULD_COUNT_DURATION = "shouldEndAfterDuration";
    private static Logger logger = Logger.getLogger("Parameters");
    public int adRequestTimeout;
    public String adType;
    public String apId;
    public List errors;
    public Hashtable metaMap;
    public boolean shouldEndAfterDuration;

    public Parameters()
    {
        apId = null;
        adType = null;
        adRequestTimeout = 10;
        shouldEndAfterDuration = false;
        errors = new ArrayList();
    }

    public static Parameters parseParameters(IRendererContext irenderercontext)
    {
        Parameters parameters = new Parameters();
        irenderercontext = new ParamParser(irenderercontext, "renderer.millennial");
        parameters.apId = irenderercontext.parseString("apId", parameters.apId);
        parameters.adType = irenderercontext.parseEnum("adType", parameters.adType, new String[] {
            "MMBannerAdBottom", "MMBannerAdRectangle", "MMBannerAdTop", "MMFullScreenAdLaunch", "MMFullScreenAdTransition"
        });
        parameters.adRequestTimeout = irenderercontext.parseInt("adRequestTimeout", parameters.adRequestTimeout);
        parameters.shouldEndAfterDuration = irenderercontext.parseBoolean("shouldEndAfterDuration", Boolean.valueOf(false)).booleanValue();
        parameters.metaMap = new Hashtable();
        Object obj = irenderercontext.parseDate("dateOfBirth", null);
        if (obj != null)
        {
            Calendar calendar = Calendar.getInstance();
            parameters.metaMap.put("age", String.valueOf(calendar.get(1) - ((GregorianCalendar) (obj)).get(1)));
        }
        obj = irenderercontext.parseEnum("gender", null, new String[] {
            "male", "female", "unknown"
        });
        if (obj != null)
        {
            parameters.metaMap.put("gender", obj);
        }
        obj = irenderercontext.parseString("postalCode", null);
        if (obj != null)
        {
            parameters.metaMap.put("zip", obj);
        }
        obj = irenderercontext.parseEnum("ethnicity", null, new String[] {
            "hispanic", "africanamerican", "asian", "indian", "middleeastern", "nativeamerican", "pacificislander", "white", "other"
        });
        if (obj != null)
        {
            parameters.metaMap.put("ethnicity", obj);
        }
        obj = irenderercontext.parseEnum("orientation", null, new String[] {
            "straight", "gay", "bisexual", "notsure"
        });
        if (obj != null)
        {
            parameters.metaMap.put("orientation", obj);
        }
        obj = irenderercontext.parseEnum("marital", null, new String[] {
            "single", "married", "divorced", "engaged", "relationship", "swinger"
        });
        if (obj != null)
        {
            parameters.metaMap.put("marital", obj);
        }
        obj = irenderercontext.parseString("income", null);
        if (obj != null)
        {
            parameters.metaMap.put("income", obj);
        }
        obj = irenderercontext.parseEnum("education", null, new String[] {
            "highschool", "somecollege", "associate", "bachelor", "masters", "phd", "professional"
        });
        if (obj != null)
        {
            parameters.metaMap.put("education", obj);
        }
        irenderercontext = irenderercontext.parseEnum("politics", null, new String[] {
            "republican", "democrat", "conservative", "moderate", "liberal", "independent", "other"
        });
        if (irenderercontext != null)
        {
            parameters.metaMap.put("politics", irenderercontext);
        }
        logger.debug(parameters.toString());
        return parameters;
    }

    public String toString()
    {
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject();
        i = 0;
_L2:
        Field field;
        if (i >= tv/freewheel/renderers/millennial/Parameters.getDeclaredFields().length)
        {
            break; /* Loop/switch isn't completed */
        }
        field = tv/freewheel/renderers/millennial/Parameters.getDeclaredFields()[i];
        if (Modifier.isStatic(field.getModifiers()))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        Object obj1 = field.get(this);
        Object obj = obj1;
        if (obj1 instanceof Calendar)
        {
            obj = ((Calendar)obj1).getTime().toString();
        }
        obj1 = obj;
        if (!(obj instanceof Integer))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj1 = obj;
        if (field.getName().indexOf("Color") >= 0)
        {
            obj1 = Integer.toHexString(((Integer)obj).intValue());
        }
        jsonobject.put(field.getName(), obj1);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return jsonobject.toString();
        Exception exception;
        exception;
          goto _L3
    }

    public boolean validate()
    {
        errors.clear();
        if (apId == null)
        {
            errors.add("apId is null");
        }
        if (adType == null)
        {
            errors.add("adType is null");
        }
        return errors.isEmpty();
    }

}
