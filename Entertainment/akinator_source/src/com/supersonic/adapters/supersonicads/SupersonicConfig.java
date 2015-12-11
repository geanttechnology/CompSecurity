// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.adapters.supersonicads;

import android.content.Context;
import android.text.TextUtils;
import com.supersonic.mediationsdk.config.AbstractAdapterConfig;
import com.supersonic.mediationsdk.config.ConfigValidationResult;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SupersonicConfig extends AbstractAdapterConfig
{

    public static final String AGE = "age";
    public static final String APPLICATION_KEY = "applicationKey";
    public static final String APPLICATION_PRIVATE_KEY = "privateKey";
    public static final String APPLICATION_USER_AGE_GROUP = "applicationUserAgeGroup";
    public static final String APPLICATION_USER_GENDER = "applicationUserGender";
    static String CAMPAIGN_ID = "campaignId";
    public static final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    public static final String GENDER = "gender";
    public static final String ITEM_COUNT = "itemCount";
    public static final String ITEM_NAME = "itemName";
    public static final String LANGUAGE = "language";
    static final String MAX_VIDEOS_TO_PRESENT = "maxVideos";
    public static final String MAX_VIDEO_LENGTH = "maxVideoLength";
    public static final String PROVIDER_NAME = "SupersonicAds";
    public static final String USER_ID = "userId";
    private static SupersonicConfig mInstance;
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String TAG = com/supersonic/adapters/supersonicads/SupersonicConfig.getSimpleName();
    private Map mOfferwallCustomParams;
    private Map mRewardedVideoCustomParams;

    private SupersonicConfig(Context context)
    {
        super(context);
    }

    private Map convertCustomParams(Map map)
    {
        HashMap hashmap;
        hashmap = new HashMap();
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        Object obj = map.keySet();
        if (obj != null)
        {
            try
            {
                obj = ((Set) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    String s = (String)((Iterator) (obj)).next();
                    if (!TextUtils.isEmpty(s))
                    {
                        String s1 = (String)map.get(s);
                        if (!TextUtils.isEmpty(s1))
                        {
                            hashmap.put((new StringBuilder()).append("custom_").append(s).toString(), s1);
                        }
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":convertCustomParams()").toString(), map);
            }
        }
        return hashmap;
    }

    public static SupersonicConfig getConfigObj(Context context)
    {
        com/supersonic/adapters/supersonicads/SupersonicConfig;
        JVM INSTR monitorenter ;
        if (mInstance == null)
        {
            mInstance = new SupersonicConfig(context);
        }
        context = mInstance;
        com/supersonic/adapters/supersonicads/SupersonicConfig;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void logConfigEvent(String s)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(".").append(s).toString(), 0);
    }

    private void validateAgeGroup(String s, ConfigValidationResult configvalidationresult)
    {
        int i;
        try
        {
            i = Integer.parseInt(s.trim());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("applicationUserAgeGroup", getProviderName(), "applicationUserAgeGroup value should be between 0-8"));
            return;
        }
        if (i >= 0 && i <= 8)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("applicationUserAgeGroup", getProviderName(), "applicationUserAgeGroup value should be between 0-8"));
    }

    private void validateApplicationKey(String s, ConfigValidationResult configvalidationresult)
    {
        s = s.trim();
        if (s != null)
        {
            if (s.length() >= 5 && s.length() <= 10)
            {
                if (!s.matches("^[a-zA-Z0-9]*$"))
                {
                    configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("applicationKey", getProviderName(), "applicationKey value should contains only english characters and numbers"));
                }
                return;
            } else
            {
                configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("applicationKey", getProviderName(), "applicationKey length should be between 5-10 characters"));
                return;
            }
        } else
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("applicationKey", getProviderName(), "applicationKey value is missing"));
            return;
        }
    }

    private void validateClientSideCallbacks(String s, ConfigValidationResult configvalidationresult)
    {
        validateBoolean("useClientSideCallbacks", s, configvalidationresult);
    }

    private void validateGender(String s, ConfigValidationResult configvalidationresult)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        s = s.toLowerCase().trim();
        if (!"male".equals(s) && !"female".equals(s) && !"unknown".equals(s))
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("gender", getProviderName(), "gender value should be one of male/female/unknown."));
        }
        return;
        s;
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("gender", getProviderName(), "gender value should be one of male/female/unknown."));
        return;
    }

    private void validateItemCount(String s, ConfigValidationResult configvalidationresult)
    {
        int i;
        try
        {
            i = Integer.parseInt(s.trim());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("itemCount", getProviderName(), "itemCount value should be between 1-100000"));
            return;
        }
        if (i >= 1 && i <= 0x186a0)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("itemCount", getProviderName(), "itemCount value should be between 1-100000"));
    }

    private void validateItemName(String s, ConfigValidationResult configvalidationresult)
    {
        if (s != null)
        {
            if (s.length() < 1 || s.length() > 50)
            {
                configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("itemName", getProviderName(), "itemNamelength should be between 1-50 characters"));
            }
            return;
        } else
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("itemName", getProviderName(), "itemNamelength should be between 1-50 characters"));
            return;
        }
    }

    private void validateLanguage(String s, ConfigValidationResult configvalidationresult)
    {
        if (s != null)
        {
            s = s.trim();
            if (!s.matches("^[a-zA-Z]*$") || s.length() != 2)
            {
                configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("language", getProviderName(), "language value should be two letters format."));
            }
            return;
        } else
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("language", getProviderName(), "language value should be two letters format."));
            return;
        }
    }

    private void validateMaxVideoLength(String s, ConfigValidationResult configvalidationresult)
    {
        int i;
        try
        {
            i = Integer.parseInt(s.trim());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("maxVideoLength", getProviderName(), "maxVideoLength value should be between 1-1000"));
            return;
        }
        if (i >= 1 && i <= 1000)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("maxVideoLength", getProviderName(), "maxVideoLength value should be between 1-1000"));
    }

    private void validatePrivateKey(String s, ConfigValidationResult configvalidationresult)
    {
        if (s != null)
        {
            if (s.length() >= 5 && s.length() <= 30)
            {
                if (!s.matches("^[a-zA-Z0-9]*$"))
                {
                    configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("privateKey", getProviderName(), "privateKey should contains only characters and numbers"));
                }
                return;
            } else
            {
                configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("privateKey", getProviderName(), "privateKey length should be between 5-30 characters"));
                return;
            }
        } else
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("privateKey", getProviderName(), "privateKey length should be between 5-30 characters"));
            return;
        }
    }

    private void validatePrivateKeyItemNameCountCombination(JSONObject jsonobject, ConfigValidationResult configvalidationresult)
    {
        if ((jsonobject.has("privateKey") || jsonobject.has("itemName") || jsonobject.has("itemCount")) && (!jsonobject.has("privateKey") || !jsonobject.has("itemName") || !jsonobject.has("itemCount")))
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("itemName, itemCount or privateKey", getProviderName(), "configure itemName/itemCount requires the following configurations: itemName, itemCount and privateKey"));
        }
    }

    private void validateUserId(String s, ConfigValidationResult configvalidationresult)
    {
        if (s != null)
        {
            if (s.length() < 1 || s.length() > 64)
            {
                configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("userId", getProviderName(), "userId value should be between 1-64 characters"));
            }
            return;
        } else
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("userId", getProviderName(), "userId is missing"));
            return;
        }
    }

    protected void adapterPostValidation(JSONObject jsonobject, ConfigValidationResult configvalidationresult)
    {
        try
        {
            validatePrivateKeyItemNameCountCombination(jsonobject, configvalidationresult);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildGenericError(""));
        }
    }

    public String getApplicationKey()
    {
        return SupersonicUtils.get(mJsonSettings, "applicationKey");
    }

    String getCampaignId()
    {
        return SupersonicUtils.get(mJsonSettings, CAMPAIGN_ID);
    }

    public String getClientSideCallbacks()
    {
        return SupersonicUtils.get(mJsonSettings, "useClientSideCallbacks");
    }

    public int getItemCount()
    {
        int i = -1;
        try
        {
            String s = SupersonicUtils.get(mJsonSettings, "itemCount");
            if (!SupersonicUtils.isEmpty(s))
            {
                i = Integer.valueOf(s).intValue();
            }
        }
        catch (NumberFormatException numberformatexception)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(TAG).append(":getItemCount()").toString(), numberformatexception);
            return -1;
        }
        return i;
    }

    public String getItemName()
    {
        return SupersonicUtils.get(mJsonSettings, "itemName");
    }

    public String getLanguage()
    {
        return SupersonicUtils.get(mJsonSettings, "language");
    }

    public String getMaxVideoLength()
    {
        return SupersonicUtils.get(mJsonSettings, "maxVideoLength");
    }

    int getMaxVideos()
    {
        String s = SupersonicUtils.get(mJsonSettings, "maxVideos");
        if (s.isEmpty())
        {
            return 1000;
        } else
        {
            return Integer.parseInt(s);
        }
    }

    public Map getOfferwallCustomParams()
    {
        return mOfferwallCustomParams;
    }

    public String getPrivateKey()
    {
        return SupersonicUtils.get(mJsonSettings, "privateKey");
    }

    protected String getProviderName()
    {
        return "SupersonicAds";
    }

    public Map getRewardedVideoCustomParams()
    {
        return mRewardedVideoCustomParams;
    }

    String getUserAgeGroup()
    {
        return SupersonicUtils.get(mJsonSettings, "applicationUserAgeGroup");
    }

    String getUserGender()
    {
        return SupersonicUtils.get(mJsonSettings, "applicationUserGender");
    }

    public String getUserId()
    {
        return SupersonicUtils.get(mJsonSettings, "userId");
    }

    protected ArrayList initializeMandatoryFields()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("applicationKey");
        arraylist.add("userId");
        return arraylist;
    }

    protected ArrayList initializeOptionalFields()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("useClientSideCallbacks");
        arraylist.add("applicationUserGender");
        arraylist.add("applicationUserAgeGroup");
        arraylist.add("language");
        arraylist.add("maxVideos");
        arraylist.add("privateKey");
        arraylist.add("maxVideoLength");
        arraylist.add("itemName");
        arraylist.add("itemCount");
        return arraylist;
    }

    public void setApplicationKey(String s)
    {
        SupersonicUtils.put(mJsonSettings, "applicationKey", s);
    }

    public void setClientSideCallbacks(boolean flag)
    {
        SupersonicUtils.put(mJsonSettings, "useClientSideCallbacks", String.valueOf(flag));
    }

    public void setItemCount(int i)
    {
        SupersonicUtils.put(mJsonSettings, "itemCount", String.valueOf(i));
    }

    public void setItemName(String s)
    {
        SupersonicUtils.put(mJsonSettings, "itemName", s);
    }

    public void setLanguage(String s)
    {
        SupersonicUtils.put(mJsonSettings, "language", String.valueOf(s));
    }

    public void setMaxVideoLength(int i)
    {
        SupersonicUtils.put(mJsonSettings, "maxVideoLength", String.valueOf(i));
    }

    public void setOfferwallCustomParams(Map map)
    {
        mOfferwallCustomParams = convertCustomParams(map);
    }

    public void setPrivateKey(String s)
    {
        SupersonicUtils.put(mJsonSettings, "privateKey", s);
    }

    public void setRewardedVideoCustomParams(Map map)
    {
        mRewardedVideoCustomParams = convertCustomParams(map);
    }

    void setUserAgeGroup(int i)
    {
        String s1 = "0";
        if (i < 13 || i > 17) goto _L2; else goto _L1
_L1:
        String s = "1";
_L4:
        SupersonicUtils.put(mJsonSettings, "applicationUserAgeGroup", s);
        return;
_L2:
        if (i >= 18 && i <= 20)
        {
            s = "2";
        } else
        if (i >= 21 && i <= 24)
        {
            s = "3";
        } else
        if (i >= 25 && i <= 34)
        {
            s = "4";
        } else
        if (i >= 35 && i <= 44)
        {
            s = "5";
        } else
        if (i >= 45 && i <= 54)
        {
            s = "6";
        } else
        if (i >= 55 && i <= 64)
        {
            s = "7";
        } else
        {
            s = s1;
            if (i > 65)
            {
                s = s1;
                if (i <= 120)
                {
                    s = "8";
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void setUserGender(String s)
    {
        SupersonicUtils.put(mJsonSettings, "applicationUserGender", s);
    }

    protected void validateMandatoryField(JSONObject jsonobject, String s, ConfigValidationResult configvalidationresult)
    {
        jsonobject = (String)jsonobject.get(s);
        if ("applicationKey".equals(s))
        {
            validateApplicationKey(jsonobject, configvalidationresult);
            return;
        }
        try
        {
            if ("userId".equals(s))
            {
                validateUserId(jsonobject, configvalidationresult);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(s, getProviderName(), null));
            jsonobject.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(s, getProviderName(), null));
        }
        return;
    }

    protected void validateOptionalField(JSONObject jsonobject, String s, ConfigValidationResult configvalidationresult)
    {
        try
        {
            jsonobject = (String)jsonobject.get(s);
            if ("useClientSideCallbacks".equals(s))
            {
                validateClientSideCallbacks(jsonobject, configvalidationresult);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(s, getProviderName(), null));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(s, getProviderName(), null));
            return;
        }
        if ("applicationUserGender".equals(s))
        {
            validateGender(jsonobject, configvalidationresult);
            return;
        }
        if ("applicationUserAgeGroup".equals(s))
        {
            validateAgeGroup(jsonobject, configvalidationresult);
            return;
        }
        if ("language".equals(s))
        {
            validateLanguage(jsonobject, configvalidationresult);
            return;
        }
        if ("maxVideos".equals(s))
        {
            validateMaxVideos(jsonobject, configvalidationresult);
            return;
        }
        if ("maxVideoLength".equals(s))
        {
            validateMaxVideoLength(jsonobject, configvalidationresult);
            return;
        }
        if ("privateKey".equals(s))
        {
            validatePrivateKey(jsonobject, configvalidationresult);
            return;
        }
        if ("itemName".equals(s))
        {
            validateItemName(jsonobject, configvalidationresult);
            return;
        }
        if ("itemCount".equals(s))
        {
            validateItemCount(jsonobject, configvalidationresult);
        }
        return;
    }

}
