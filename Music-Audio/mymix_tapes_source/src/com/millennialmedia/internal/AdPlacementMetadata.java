// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal:
//            AdPlacement

public abstract class AdPlacementMetadata
{

    public static final String METADATA_KEY_HEIGHT = "height";
    public static final String METADATA_KEY_KEYWORDS = "keywords";
    public static final String METADATA_KEY_NATIVE_TYPES = "nativeTypes";
    public static final String METADATA_KEY_PLACEMENT_ID = "placementId";
    public static final String METADATA_KEY_PLACEMENT_TYPE = "placementType";
    public static final String METADATA_KEY_SUPPORTED_ORIENTATIONS = "supportedOrientations";
    public static final String METADATA_KEY_WIDTH = "width";
    private static final String TAG = com/millennialmedia/internal/AdPlacementMetadata.getName();
    private static final List validOrientations = Arrays.asList(new String[] {
        "portrait", "landscape"
    });
    private String keywords;
    private final String placementType;
    private List supportedOrientations;

    protected AdPlacementMetadata(String s)
    {
        placementType = s;
    }

    protected List buildValidatedList(String s, String s1, List list)
    {
        if (s1 != null)
        {
            ArrayList arraylist = new ArrayList();
            s1 = s1.split(",");
            int j = s1.length;
            int i = 0;
            while (i < j) 
            {
                String s2 = s1[i].trim();
                if (!list.contains(s2))
                {
                    MMLog.e(TAG, (new StringBuilder()).append("Value <").append(s2).append("> is not a valid ").append(s).toString());
                } else
                if (!arraylist.contains(s2))
                {
                    arraylist.add(s2);
                }
                i++;
            }
            s = arraylist;
            if (arraylist.size() == 0)
            {
                s = null;
            }
            return s;
        } else
        {
            return null;
        }
    }

    public String getKeywords()
    {
        return keywords;
    }

    public List getSupportedOrientations()
    {
        return supportedOrientations;
    }

    public Object setKeywords(String s)
    {
        keywords = s;
        return this;
    }

    public Object setSupportedOrientations(String s)
    {
        supportedOrientations = buildValidatedList("orientation", s, validOrientations);
        return this;
    }

    public Map toMap(AdPlacement adplacement)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("placementId", adplacement.placementId);
        hashmap.put("placementType", placementType);
        Utils.injectIfNotNull(hashmap, "keywords", keywords);
        Utils.injectIfNotNull(hashmap, "supportedOrientations", supportedOrientations);
        return hashmap;
    }

}
