// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.emailsubscription;

import com.groupon.models.division.Division;

public class EmailSubscription
{

    public Division division;
    public String emailAddress;
    public String id;

    public EmailSubscription()
    {
    }

    public boolean equals(Object obj)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!(obj instanceof EmailSubscription))
            {
                break label0;
            }
            obj = (EmailSubscription)obj;
            if (division != ((EmailSubscription) (obj)).division)
            {
                flag = flag1;
                if (division == null)
                {
                    break label0;
                }
                flag = flag1;
                if (((EmailSubscription) (obj)).division == null)
                {
                    break label0;
                }
                flag = flag1;
                if (!division.id.equals(((EmailSubscription) (obj)).division.id))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public String getDisplayString()
    {
        return division.name;
    }

    public int hashCode()
    {
        if (division == null)
        {
            return 0;
        } else
        {
            return division.id.hashCode();
        }
    }
}
