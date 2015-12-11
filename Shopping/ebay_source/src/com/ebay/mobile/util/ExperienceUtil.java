// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import com.ebay.nautilus.domain.data.experience.type.base.StyleEnum;
import com.ebay.nautilus.domain.data.experience.type.base.TextSpan;
import java.util.Iterator;
import java.util.List;

public class ExperienceUtil
{

    public ExperienceUtil()
    {
    }

    public static Spannable getSpannableFromTextSpans(List list, Resources resources)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        list = null;
_L8:
        return list;
_L2:
        SpannableStringBuilder spannablestringbuilder;
        spannablestringbuilder = new SpannableStringBuilder();
        list = list.iterator();
_L4:
        Object obj;
        int i;
        int j;
        do
        {
label0:
            {
                if (list.hasNext())
                {
                    obj = (TextSpan)list.next();
                    if (obj != null && !TextUtils.isEmpty(((TextSpan) (obj)).text))
                    {
                        break label0;
                    }
                }
                list = spannablestringbuilder;
                if (spannablestringbuilder.length() <= 0)
                {
                    return null;
                }
                continue; /* Loop/switch isn't completed */
            }
            i = spannablestringbuilder.length();
            spannablestringbuilder.append(((TextSpan) (obj)).text);
            j = spannablestringbuilder.length();
        } while (((TextSpan) (obj)).styles == null);
        obj = ((TextSpan) (obj)).styles.iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        StyleEnum styleenum = (StyleEnum)((Iterator) (obj)).next();
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum = new int[StyleEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.BOLD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.ITALIC.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.EMPHASIS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.POSITIVE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.NEGATIVE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.STRIKETHROUGH.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.SUPERSCRIPT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$experience$type$base$StyleEnum[StyleEnum.SUBSCRIPT.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.data.experience.type.base.StyleEnum[styleenum.ordinal()])
        {
        case 1: // '\001'
            spannablestringbuilder.setSpan(new StyleSpan(1), i, j, 0);
            break;

        case 2: // '\002'
            spannablestringbuilder.setSpan(new StyleSpan(2), i, j, 0);
            break;

        case 3: // '\003'
            if (resources != null)
            {
                spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d0097)), i, j, 0);
            }
            break;

        case 4: // '\004'
            if (resources != null)
            {
                spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d0099)), i, j, 0);
            }
            break;

        case 5: // '\005'
            if (resources != null)
            {
                spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d0098)), i, j, 0);
            }
            break;

        case 6: // '\006'
            spannablestringbuilder.setSpan(new StrikethroughSpan(), i, j, 0);
            break;

        case 7: // '\007'
            spannablestringbuilder.setSpan(new SuperscriptSpan(), i, j, 0);
            break;

        case 8: // '\b'
            spannablestringbuilder.setSpan(new SubscriptSpan(), i, j, 0);
            break;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
    }
}
