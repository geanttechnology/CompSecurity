// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.config;

import android.content.Context;
import com.supersonic.mediationsdk.logger.SupersonicError;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.ConfigValidator;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk.config:
//            ConfigFile, ConfigValidationResult

public abstract class AbstractAdapterConfig
    implements ConfigValidator
{

    protected JSONObject mJsonSettings;
    protected ArrayList mMandatoryKeys;
    protected ArrayList mOptionalKeys;

    public AbstractAdapterConfig(Context context)
    {
        mJsonSettings = ConfigFile.getConfigFile(context).getProviderJsonSettings(getProviderName());
        mMandatoryKeys = initializeMandatoryFields();
        if (mMandatoryKeys == null)
        {
            mMandatoryKeys = new ArrayList();
        }
        mOptionalKeys = initializeOptionalFields();
        if (mOptionalKeys == null)
        {
            mOptionalKeys = new ArrayList();
        }
    }

    private void checkForAllMandatoryFields(JSONObject jsonobject, ArrayList arraylist, ConfigValidationResult configvalidationresult)
    {
        if (arraylist != null && jsonobject != null) goto _L2; else goto _L1
_L1:
        configvalidationresult.setInvalid(ErrorBuilder.buildGenericError((new StringBuilder()).append(getProviderName()).append(" - Wrong configuration").toString()));
_L6:
        return;
_L2:
        Iterator iterator = arraylist.iterator();
_L4:
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist = (String)iterator.next();
        if (!jsonobject.has(arraylist))
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildKeyNotSetForProviderError(arraylist, getProviderName()));
            return;
        }
        if (!isEmpty(jsonobject.getString(arraylist))) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(arraylist, getProviderName(), null));
        return;
        jsonobject;
        jsonobject.printStackTrace();
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(arraylist, getProviderName(), null));
        return;
    }

    private boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    private boolean isMandatoryField(String s)
    {
        return mMandatoryKeys.contains(s);
    }

    private boolean isOptionalField(String s)
    {
        return mOptionalKeys.contains(s);
    }

    private void validateAllFields(JSONObject jsonobject, ConfigValidationResult configvalidationresult)
    {
        Iterator iterator = jsonobject.keys();
_L5:
        if (!configvalidationresult.isValid() || !iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (!isMandatoryField(s)) goto _L4; else goto _L3
_L3:
        validateMandatoryField(jsonobject, s, configvalidationresult);
          goto _L5
        jsonobject;
        configvalidationresult.setInvalid(ErrorBuilder.buildGenericError((new StringBuilder()).append(getProviderName()).append(" - Invalid configuration").toString()));
_L2:
        return;
_L4:
label0:
        {
            if (!isOptionalField(s))
            {
                break label0;
            }
            validateOptionalField(jsonobject, s, configvalidationresult);
            if (!configvalidationresult.isValid())
            {
                logConfigWarningMessage(configvalidationresult.getSupersonicError());
                iterator.remove();
                configvalidationresult.setValid();
            }
        }
          goto _L5
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":Unknown key in configuration - ").append(s).toString(), 2);
          goto _L5
    }

    protected abstract void adapterPostValidation(JSONObject jsonobject, ConfigValidationResult configvalidationresult);

    protected abstract String getProviderName();

    protected abstract ArrayList initializeMandatoryFields();

    protected abstract ArrayList initializeOptionalFields();

    public ConfigValidationResult isConfigValid()
    {
        ConfigValidationResult configvalidationresult = new ConfigValidationResult();
        checkForAllMandatoryFields(mJsonSettings, mMandatoryKeys, configvalidationresult);
        if (configvalidationresult.isValid())
        {
            validateAllFields(mJsonSettings, configvalidationresult);
        }
        if (configvalidationresult.isValid())
        {
            adapterPostValidation(mJsonSettings, configvalidationresult);
            if (!configvalidationresult.isValid())
            {
                logConfigWarningMessage(configvalidationresult.getSupersonicError());
                configvalidationresult.setValid();
            }
        }
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(getProviderName()).append(":isConfigValid(config: ").append(mJsonSettings.toString()).append("):result(valid:").append(configvalidationresult.isValid()).append(")").toString(), 0);
        return configvalidationresult;
    }

    protected void logConfigWarningMessage(SupersonicError supersonicerror)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, supersonicerror.toString(), 2);
    }

    protected void validateBoolean(String s, String s1, ConfigValidationResult configvalidationresult)
    {
        s1 = s1.trim();
        if (!s1.equalsIgnoreCase("true") && !s1.equalsIgnoreCase("false"))
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(s, getProviderName(), "value should be 'true'/'false'"));
        }
    }

    protected abstract void validateMandatoryField(JSONObject jsonobject, String s, ConfigValidationResult configvalidationresult);

    protected void validateMaxVideos(String s, ConfigValidationResult configvalidationresult)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("maxVideos", getProviderName(), "Please insert a number between 0-10"));
            return;
        }
        if (i >= 0 && i <= 10)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("maxVideos", getProviderName(), (new StringBuilder()).append("maxVideos value should be between 0-10, your value is:").append(i).toString()));
    }

    protected void validateNonEmptyString(String s, String s1, ConfigValidationResult configvalidationresult)
    {
        if (isEmpty(s1))
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(s, getProviderName(), "value is empty"));
        }
    }

    protected abstract void validateOptionalField(JSONObject jsonobject, String s, ConfigValidationResult configvalidationresult);

    public void validateOptionalKeys(ArrayList arraylist)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(getProviderName()).append(":validateOptionalKeys(config: ").append(mJsonSettings).append(")").toString(), 1);
        arraylist.iterator();
        ConfigValidationResult configvalidationresult = new ConfigValidationResult();
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            String s = (String)arraylist.next();
            if (isOptionalField(s))
            {
                validateOptionalField(mJsonSettings, s, configvalidationresult);
                if (!configvalidationresult.isValid())
                {
                    logConfigWarningMessage(configvalidationresult.getSupersonicError());
                    configvalidationresult.setValid();
                }
            } else
            {
                SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append(getProviderName()).append(":validateOptionalKeys(").append(s).append(")").toString(), 0);
            }
        } while (true);
    }

    protected void validateRewards(String s, ConfigValidationResult configvalidationresult)
    {
        try
        {
            if (Integer.parseInt(s) <= 0)
            {
                configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("rewards", getProviderName(), "rewards value should be any positive value."));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            configvalidationresult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("rewards", getProviderName(), "rewards value should be any positive value."));
        }
    }
}
