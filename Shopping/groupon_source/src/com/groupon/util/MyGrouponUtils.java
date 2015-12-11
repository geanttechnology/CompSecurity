// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.db.models.mygroupons.MyGrouponItem;
import roboguice.util.Strings;

public class MyGrouponUtils
{

    public MyGrouponUtils()
    {
    }

    public static String getGrouponDivisionTimezoneIdentifier(MyGrouponItem mygrouponitem)
    {
        if (Strings.isEmpty(mygrouponitem.timezoneIdentifier))
        {
            return mygrouponitem.timezone;
        } else
        {
            return mygrouponitem.timezoneIdentifier;
        }
    }

    public static Integer getGrouponDivisionTimezoneOffsetInSeconds(MyGrouponItem mygrouponitem)
    {
        int i;
        if (mygrouponitem.timezoneOffsetInSeconds == 0)
        {
            i = mygrouponitem.divisionTimezoneOffsetInSeconds;
        } else
        {
            i = mygrouponitem.timezoneOffsetInSeconds;
        }
        return Integer.valueOf(i);
    }
}
