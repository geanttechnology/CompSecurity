// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;

import android.text.TextUtils;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.type.base:
//            Action

public final class TextSpan
{

    public String accessibilityText;
    public Action action;
    public List styles;
    public String template;
    public String text;

    public TextSpan()
    {
    }

    public boolean isValid()
    {
        return !TextUtils.isEmpty(text) || !TextUtils.isEmpty(template);
    }
}
