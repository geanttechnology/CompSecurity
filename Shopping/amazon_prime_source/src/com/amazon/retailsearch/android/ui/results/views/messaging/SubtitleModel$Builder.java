// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            SubtitleModel, EditionLineModel

public static class 
{

    public SubtitleModel build(String s, EditionLineModel editionlinemodel)
    {
        String s1 = "";
        if (!TextUtils.isEmpty(s))
        {
            if (editionlinemodel != null && !TextUtils.isEmpty(editionlinemodel.getEditionText()))
            {
                s = (new StringBuilder()).append(s).append(" \267 ").append(editionlinemodel.getEditionText()).toString();
            }
        } else
        {
            s = s1;
            if (editionlinemodel != null)
            {
                s = s1;
                if (!TextUtils.isEmpty(editionlinemodel.getEditionText()))
                {
                    s = editionlinemodel.getEditionText();
                }
            }
        }
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            editionlinemodel = new SubtitleModel();
            SubtitleModel.access$002(editionlinemodel, s);
            return editionlinemodel;
        }
    }

    public ()
    {
    }
}
