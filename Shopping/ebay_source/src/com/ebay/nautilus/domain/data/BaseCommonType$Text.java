// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.Html;
import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class content
{

    public String content;
    public String language;
    public String translatedFromContent;
    public String translatedFromLanguage;

    public String decode()
    {
        String s = null;
        String s1 = getSourceContent();
        if (!TextUtils.isEmpty(s1))
        {
            s = Html.fromHtml(s1).toString();
        }
        return s;
    }

    public String getContent(boolean flag)
    {
        if (flag && !TextUtils.isEmpty(content))
        {
            return content;
        }
        if (!flag && !TextUtils.isEmpty(translatedFromContent))
        {
            return translatedFromContent;
        } else
        {
            return content;
        }
    }

    public String getSourceContent()
    {
        String s1 = translatedFromContent;
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = content;
        }
        return s;
    }

    public (String s)
    {
        content = s;
    }
}
