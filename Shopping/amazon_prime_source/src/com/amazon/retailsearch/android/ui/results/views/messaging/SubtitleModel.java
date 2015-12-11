// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            EditionLineModel

public class SubtitleModel
{
    public static class Builder
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
                editionlinemodel.text = s;
                return editionlinemodel;
            }
        }

        public Builder()
        {
        }
    }


    private String text;

    public SubtitleModel()
    {
    }

    public String getText()
    {
        return text;
    }


/*
    static String access$002(SubtitleModel subtitlemodel, String s)
    {
        subtitlemodel.text = s;
        return s;
    }

*/
}
