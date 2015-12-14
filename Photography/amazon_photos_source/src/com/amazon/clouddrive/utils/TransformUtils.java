// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.utils;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.clouddrive.utils:
//            Optional

public final class TransformUtils
{

    private static final Map TRANSFORM_TO_OPERATION_MAP = new HashMap() {

            
            {
                put("DOCUMENT_CONVERSION", "/alt/pdf");
                put("PDF", "/alt/pdf");
                put("IMAGE_THUMBNAIL", "/alt/thumb");
                put("VIDEO_TRANSCODE", "/alt/video_transcode");
            }
    };

    public static Optional getTransformPathSuffix(String s)
    {
        return Optional.fromNullable((String)TRANSFORM_TO_OPERATION_MAP.get(s));
    }

}
