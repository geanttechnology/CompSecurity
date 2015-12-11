// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.vast.model;

import tv.freewheel.hybrid.utils.Logger;

public class FWVastContentTypeTransform
{

    static String equivalence[][] = {
        {
            "text/html_doc_lit_mobile", "image/gif", "image/jpeg", "image/png", "text/html", "text/javascript", "text/js_ref"
        }, {
            "video/3gpp", "video/3gp"
        }
    };
    private static Logger logger = Logger.getLogger("FWVastContentTypeTransform");

    public static String transform(String s)
    {
        String s1;
        Object obj;
        s1 = null;
        obj = s;
        if (s == null) goto _L2; else goto _L1
_L1:
        String s2;
        int i;
        s2 = s;
        s = s.trim();
        i = 0;
_L6:
        s1 = s2;
        obj = s;
        if (i >= equivalence.length) goto _L2; else goto _L3
_L3:
        obj = equivalence[i];
        if (obj.length >= 1) goto _L5; else goto _L4
_L4:
        i++;
          goto _L6
_L5:
        int j;
        s1 = obj[0];
        j = 0;
_L10:
        if (j >= obj.length) goto _L4; else goto _L7
_L7:
        if (!s.equalsIgnoreCase(obj[j])) goto _L9; else goto _L8
_L8:
        obj = s;
_L2:
        logger.debug((new StringBuilder()).append("The content type ").append(((String) (obj))).append(" transformed to FW content type ").append(s1).toString());
        return s1;
_L9:
        j++;
          goto _L10
    }

}
