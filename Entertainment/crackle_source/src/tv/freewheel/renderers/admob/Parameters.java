// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.admob;

import com.google.ads.AdSize;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONObject;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.ParamParser;

public class Parameters
{

    public static final String NAMESPACE = "renderer.admob";
    public static final String PARAM_BACKGROUND_COLOR = "backgroundColor";
    public static final String PARAM_BANNER = "BANNER";
    public static final String PARAM_BANNER_SIZE = "bannerSize";
    public static final String PARAM_DESCRIPTION_TEXT_COLOR = "descriptionTextColor";
    public static final String PARAM_GENDER_FEMALE = "female";
    public static final String PARAM_GENDER_MALE = "male";
    public static final String PARAM_HEADER_TEXT_COLOR = "headerTextColor";
    public static final String PARAM_IAB_BANNER = "IAB_BANNER";
    public static final String PARAM_IAB_LEADERBOARD = "IAB_LEADERBOARD";
    public static final String PARAM_IAB_MRECT = "IAB_MRECT";
    public static final String PARAM_MARGIN_HEIGHT = "marginHeight";
    public static final String PARAM_MARGIN_WIDTH = "marginWidth";
    public static final String PARAM_PRIMARY_ANCHOR = "primaryAnchor";
    public static final String PARAM_PUBLISHER_ID = "publisherId";
    public static final String PARAM_SHORT_TIMEOUT = "shortTimeout";
    public static final String PARAM_TEST_DEVICE_IDS = "testDeviceIds";
    public static final AdSize adSizes[];
    public int backgroundColor;
    public AdSize bannerSize;
    private IConstants constants;
    public GregorianCalendar dateOfBirth;
    public int descriptionTextColor;
    public String errorCode;
    public String errorString;
    public com.google.ads.AdRequest.Gender gender;
    public int headerTextColor;
    public String keywords;
    public int marginHeight;
    public int marginWidth;
    public String primaryAnchor;
    public String publisherId;
    public String searchString;
    public boolean shortTimeout;
    public List testDeviceIds;

    public Parameters()
    {
        publisherId = null;
        dateOfBirth = null;
        gender = null;
        keywords = null;
        searchString = null;
        backgroundColor = 0;
        headerTextColor = 0;
        descriptionTextColor = 0;
        shortTimeout = false;
        testDeviceIds = null;
        primaryAnchor = "bc";
        marginWidth = 0;
        marginHeight = 0;
        bannerSize = null;
        errorCode = null;
        errorString = null;
    }

    public static Parameters parseParameters(IRendererContext irenderercontext)
    {
        Parameters parameters = new Parameters();
        ParamParser paramparser = new ParamParser(irenderercontext, "renderer.admob");
        parameters.constants = irenderercontext.getConstants();
        parameters.publisherId = paramparser.parseString("publisherId", parameters.publisherId);
        parameters.keywords = paramparser.parseString(parameters.constants.PARAMETER_KEYWORDS(), parameters.keywords);
        parameters.searchString = paramparser.parseString(parameters.constants.PARAMETER_SEARCH_STRING(), parameters.searchString);
        parameters.dateOfBirth = paramparser.parseDate(parameters.constants.PARAMETER_DATE_OF_BIRTH(), parameters.dateOfBirth);
        irenderercontext = paramparser.parseEnum(parameters.constants.PARAMETER_GENDER(), null, new String[] {
            "male", "female"
        });
        if (irenderercontext != null)
        {
            if (irenderercontext == "male")
            {
                irenderercontext = com.google.ads.AdRequest.Gender.MALE;
            } else
            {
                irenderercontext = com.google.ads.AdRequest.Gender.FEMALE;
            }
            parameters.gender = irenderercontext;
        }
        parameters.headerTextColor = paramparser.parseColor("headerTextColor", parameters.headerTextColor);
        parameters.descriptionTextColor = paramparser.parseColor("descriptionTextColor", parameters.descriptionTextColor);
        parameters.backgroundColor = paramparser.parseColor("backgroundColor", parameters.backgroundColor);
        parameters.shortTimeout = paramparser.parseBoolean("shortTimeout", Boolean.valueOf(parameters.shortTimeout)).booleanValue();
        parameters.testDeviceIds = paramparser.parseList("testDeviceIds");
        parameters.primaryAnchor = paramparser.parseString("primaryAnchor", parameters.primaryAnchor);
        parameters.marginWidth = paramparser.parseInt("marginWidth", parameters.marginWidth);
        parameters.marginHeight = paramparser.parseInt("marginHeight", parameters.marginHeight);
        irenderercontext = paramparser.parseEnum("bannerSize", null, new String[] {
            "BANNER", "IAB_MRECT", "IAB_BANNER", "IAB_LEADERBOARD"
        });
        if (irenderercontext != null)
        {
            if (irenderercontext == "IAB_LEADERBOARD")
            {
                parameters.bannerSize = AdSize.IAB_LEADERBOARD;
            } else
            if (irenderercontext == "IAB_BANNER")
            {
                parameters.bannerSize = AdSize.IAB_BANNER;
            } else
            if (irenderercontext == "IAB_MRECT")
            {
                parameters.bannerSize = AdSize.IAB_MRECT;
            } else
            {
                parameters.bannerSize = AdSize.BANNER;
            }
        }
        Logger.getLogger("Parameters").debug(parameters.toString());
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
        if (i >= tv/freewheel/renderers/admob/Parameters.getDeclaredFields().length)
        {
            break; /* Loop/switch isn't completed */
        }
        field = tv/freewheel/renderers/admob/Parameters.getDeclaredFields()[i];
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
        errorString = null;
        if (publisherId == null)
        {
            errorString = "publisherId is not set";
            errorCode = constants.ERROR_MISSING_PARAMETER();
        } else
        if (publisherId.length() == 0)
        {
            errorString = "publisherId is empty";
            errorCode = constants.ERROR_INVALID_VALUE();
        }
        return errorString == null;
    }

    static 
    {
        adSizes = (new AdSize[] {
            AdSize.IAB_LEADERBOARD, AdSize.IAB_BANNER, AdSize.IAB_MRECT, AdSize.BANNER
        });
    }
}
