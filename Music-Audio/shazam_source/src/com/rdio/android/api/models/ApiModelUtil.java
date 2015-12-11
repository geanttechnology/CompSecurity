// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models;

import java.lang.reflect.Field;
import java.util.List;

// Referenced classes of package com.rdio.android.api.models:
//            ApiModel

public class ApiModelUtil
{

    public ApiModelUtil()
    {
    }

    public static List getTrackKeys(ApiModel apimodel)
    {
        try
        {
            apimodel = (List)apimodel.getClass().getField("trackKeys").get(apimodel);
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            apimodel.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            apimodel.printStackTrace();
            return null;
        }
        return apimodel;
    }

    public static List getTracks(ApiModel apimodel)
    {
        try
        {
            apimodel = (List)apimodel.getClass().getField("tracks").get(apimodel);
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            apimodel.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            apimodel.printStackTrace();
            return null;
        }
        return apimodel;
    }

    public static void setTrackKeys(ApiModel apimodel, List list)
    {
        try
        {
            apimodel.getClass().getField("trackKeys").set(apimodel, list);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            apimodel.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ApiModel apimodel)
        {
            apimodel.printStackTrace();
        }
    }
}
