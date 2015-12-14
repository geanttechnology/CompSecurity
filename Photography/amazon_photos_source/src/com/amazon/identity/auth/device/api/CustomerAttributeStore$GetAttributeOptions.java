// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            CustomerAttributeStore

public static final class mUniqueValue extends Enum
{

    private static final ForceRefresh $VALUES[];
    public static final ForceRefresh ForceRefresh;
    private final String mUniqueValue;

    public static EnumSet deserializeList(JSONArray jsonarray)
    {
        EnumSet enumset = EnumSet.noneOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions);
        int i = 0;
        while (i < jsonarray.length()) 
        {
            try
            {
                enumset.add(getOptionFromValue(jsonarray.getString(i)));
            }
            catch (JSONException jsonexception)
            {
                MAPLog.e(CustomerAttributeStore.access$000(), "Could not deseralize part of getAttribute options", jsonexception);
            }
            i++;
        }
        return enumset;
    }

    public static getOptionFromValue getOptionFromValue(String s)
    {
        getOptionFromValue agetoptionfromvalue[] = values();
        int j = agetoptionfromvalue.length;
        for (int i = 0; i < j; i++)
        {
            getOptionFromValue getoptionfromvalue = agetoptionfromvalue[i];
            if (getoptionfromvalue.getValue().equals(s))
            {
                return getoptionfromvalue;
            }
        }

        return null;
    }

    public static JSONArray serializeList(EnumSet enumset)
    {
        JSONArray jsonarray = new JSONArray();
        for (enumset = enumset.iterator(); enumset.hasNext(); jsonarray.put(((getValue)enumset.next()).getValue())) { }
        return jsonarray;
    }

    public static getValue valueOf(String s)
    {
        return (getValue)Enum.valueOf(com/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions, s);
    }

    public static getValue[] values()
    {
        return (getValue[])$VALUES.clone();
    }

    public String getValue()
    {
        return mUniqueValue;
    }

    static 
    {
        ForceRefresh = new <init>("ForceRefresh", 0, "forceRefresh");
        $VALUES = (new .VALUES[] {
            ForceRefresh
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mUniqueValue = s1;
    }
}
