// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class SuggestedSearchItem
{

    public String kw;
    public String type;

    public SuggestedSearchItem()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (SuggestedSearchItem)obj;
            if (!kw.equals(((SuggestedSearchItem) (obj)).kw))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return kw.hashCode();
    }
}
