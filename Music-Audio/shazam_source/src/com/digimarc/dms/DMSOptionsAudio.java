// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms:
//            DMSIOptions

public class DMSOptionsAudio
    implements DMSIOptions
{

    private int bufferSeconds;
    private String decoderFactoryName;

    public DMSOptionsAudio()
    {
    }

    public int getBufferSeconds()
    {
        return bufferSeconds;
    }

    public String getDecoderFactoryName()
    {
        return decoderFactoryName;
    }

    public void initWithJSONDictionary(JSONObject jsonobject)
    {
        try
        {
            decoderFactoryName = jsonobject.getString("decoderFactoryName");
            bufferSeconds = jsonobject.getInt("bufferSeconds");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }
}
