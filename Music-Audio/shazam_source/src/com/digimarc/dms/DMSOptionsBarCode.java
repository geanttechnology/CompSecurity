// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms:
//            DMSIOptions

public class DMSOptionsBarCode
    implements DMSIOptions
{

    private static final int Default_Inverted_Interval = 0;
    public String codeType;
    private int invertedInterval;
    private boolean read1DBarcodes;
    private boolean readQRcodes;

    public DMSOptionsBarCode()
    {
        read1DBarcodes = false;
        readQRcodes = false;
        invertedInterval = 0;
    }

    public int getInvertedReadInterval()
    {
        return invertedInterval;
    }

    public void initWithJSONDictionary(JSONObject jsonobject)
    {
        boolean flag1 = true;
        boolean flag;
        if (jsonobject.getInt("read1DBarcodes") == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        read1DBarcodes = flag;
        if (jsonobject.getInt("readQRcodes") == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        try
        {
            readQRcodes = flag;
            invertedInterval = jsonobject.getInt("invertedReadInterval");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
        if (invertedInterval < 0)
        {
            invertedInterval = 0;
        }
        return;
    }

    public boolean isRead1DBarcodes()
    {
        return read1DBarcodes;
    }

    public boolean isReadQRCodes()
    {
        return readQRcodes;
    }
}
