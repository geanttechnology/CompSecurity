// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.ContentValues;
import android.os.Bundle;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.Collection;
import java.util.Date;
import java.util.IllegalFormatException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInformationProvider

private static class ngs
{

    private static final <init> EMPTY_SELECTION_INFO = new <init>(null, null, null, null, null, null, null, null);
    public final Collection bulkData;
    public final String directedId;
    public final String displayName;
    public final String key;
    public final String namespace;
    public final Date timestamp;
    public final Bundle userdata;
    public final String value;

    public static ngs parseSelection(ContentValues contentvalues)
    {
        String s = contentvalues.getAsString("directedId");
        String s1 = contentvalues.getAsString("key");
        String s2 = contentvalues.getAsString("value");
        String s3 = contentvalues.getAsString("namespace");
        String s4 = contentvalues.getAsString("display_name");
        String s5 = contentvalues.getAsString("userdata_bundle_key");
        Object obj = contentvalues.getAsLong("timestamp_key");
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new Date(((Long) (obj)).longValue());
        }
        return new <init>(s, s1, s2, s3, s4, s5, ((Date) (obj)), contentvalues.getAsString("bulk_data"));
    }

    public static <init> parseSelection(String s, String as[])
    {
        if (s == null)
        {
            String as1[];
            String as2[];
            int i;
            try
            {
                return EMPTY_SELECTION_INFO;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPLog.e(MAPInformationProvider.access$000(), (new StringBuilder("Format not valid. Error: ")).append(s.getMessage()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MAPLog.e(MAPInformationProvider.access$000(), "Format was not valid JSON");
            }
            return null;
        }
        if (as != null) goto _L2; else goto _L1
_L1:
        as1 = new String[0];
_L4:
        s = new JSONObject(String.format(s.replace("\"?\"", "%s"), (Object[])as1));
        s = new <init>(JSONHelpers.getStringOrDefault(s, "directedId", null), JSONHelpers.getStringOrDefault(s, "key", null), JSONHelpers.getStringOrDefault(s, "value", null), JSONHelpers.getStringOrDefault(s, "namespace", null), JSONHelpers.getStringOrDefault(s, "display_name", null), JSONHelpers.getStringOrDefault(s, "userdata_bundle_key", null), TimeUtil.deserialize(JSONHelpers.getStringOrDefault(s, "timestamp_key", null)), JSONHelpers.getStringOrDefault(s, "bulk_data", null));
        return s;
_L2:
        as2 = new String[as.length];
        i = 0;
_L5:
        as1 = as2;
        if (i >= as.length) goto _L4; else goto _L3
_L3:
        as2[i] = JSONObject.quote(as[i]);
        i++;
          goto _L5
    }


    public (String s, String s1, String s2, String s3, String s4, String s5, Date date, 
            String s6)
    {
        directedId = s;
        key = s1;
        value = s2;
        namespace = s3;
        displayName = s4;
        userdata = ParcelUtils.stringToBundle(s5);
        timestamp = date;
        bulkData = ParcelUtils.stringToListOfMapOfStrings(s6);
    }
}
