// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.objectinfo;

import com.a9.vs.mobile.library.impl.jni.ObjectInfo;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flow.android.engine.library.objectinfo:
//            FlowObjectInfo

public class FlowLogoMatchObjectInfo extends FlowObjectInfo
{

    private String mDisplayName;
    private String mImageName;
    private HashMap mMetrics;
    private JSONObject mTagObject;

    public FlowLogoMatchObjectInfo(ObjectInfo objectinfo)
    {
        super(objectinfo);
        mTagObject = new JSONObject(m_objectInfo.getTag());
        if (!mTagObject.has("displayedName")) goto _L2; else goto _L1
_L1:
        objectinfo = mTagObject.getString("displayedName");
_L8:
        mDisplayName = objectinfo;
        if (!mTagObject.has("imageName")) goto _L4; else goto _L3
_L3:
        objectinfo = mTagObject.getString("imageName");
_L6:
        mImageName = objectinfo;
        mMetrics = new HashMap();
        if (mTagObject.has("metrics"))
        {
            objectinfo = mTagObject.getJSONObject("metrics");
            String s;
            for (Iterator iterator = objectinfo.keys(); iterator.hasNext(); mMetrics.put(s, objectinfo.getString(s)))
            {
                s = (String)iterator.next();
            }

        }
          goto _L5
_L2:
        try
        {
            objectinfo = getBrandFilterName();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (ObjectInfo objectinfo) { }
          goto _L5
_L4:
        objectinfo = null;
          goto _L6
_L5:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String getBrandFilterName()
    {
        return m_objectInfo.getContent();
    }
}
