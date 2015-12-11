// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;

public class MetaItem
{

    private String display;
    private String id;

    public MetaItem()
    {
        display = "";
        id = "";
    }

    public MetaItem(String s, String s1)
    {
        id = s;
        display = s1;
    }

    public static MetaItem clone(MetaItem metaitem)
    {
        if (metaitem != null)
        {
            return new MetaItem(metaitem.getId(), metaitem.getDisplay());
        } else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MetaItem)obj;
            if (!display.equals(((MetaItem) (obj)).display))
            {
                return false;
            }
            if (!id.equals(((MetaItem) (obj)).id))
            {
                return false;
            }
        }
        return true;
    }

    public String getDisplay()
    {
        return display;
    }

    public SpannableStringBuilder getFormattedDisplayStringBuilder()
    {
        String s = display.replace('/', '\n');
        int i = s.indexOf('\n');
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        if (i >= 0)
        {
            spannablestringbuilder.setSpan(new RelativeSizeSpan(0.9F), i, s.length(), 33);
        }
        return spannablestringbuilder;
    }

    public String getId()
    {
        return id;
    }

    public int hashCode()
    {
        return display.hashCode() * 31 + id.hashCode();
    }

    public void setDisplay(String s)
    {
        display = s;
    }

    public void setId(String s)
    {
        id = s;
    }
}
