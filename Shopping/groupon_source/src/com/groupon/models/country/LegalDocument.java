// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country;

import java.io.Serializable;

public class LegalDocument
    implements Serializable
{

    public int version;

    public LegalDocument()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LegalDocument))
            {
                return false;
            }
            obj = (LegalDocument)obj;
            if (version != ((LegalDocument) (obj)).version)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return version;
    }
}
