// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.idresolver;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.Preferences;
import com.amazon.insights.core.system.System;

// Referenced classes of package com.amazon.insights.core.idresolver:
//            UniqueIdService, Id, RandomUUIDGenerator, UniqueIdGenerator

public class SharedPrefsUniqueIdService
    implements UniqueIdService
{

    protected static final String PREFS_NAME = com/amazon/insights/core/idresolver/SharedPrefsUniqueIdService.getName();
    private static Logger logger = Logger.getLogger(com/amazon/insights/core/idresolver/SharedPrefsUniqueIdService);
    private final UniqueIdGenerator generator;

    public SharedPrefsUniqueIdService(UniqueIdGenerator uniqueidgenerator)
    {
        generator = uniqueidgenerator;
    }

    private Id getIdFromPreferences(Preferences preferences)
    {
        Id id = Id.getEmptyId();
        String s = preferences.getString("UniqueId", null);
        preferences = id;
        if (s != null)
        {
            preferences = new Id(s);
        }
        return preferences;
    }

    public static UniqueIdService newInstance()
    {
        return new SharedPrefsUniqueIdService(new RandomUUIDGenerator());
    }

    private void storeUniqueId(Preferences preferences, Id id)
    {
        try
        {
            preferences.putString("UniqueId", id.getValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Preferences preferences)
        {
            logger.e("There was an exception when trying to store the unique id into the Preferences", preferences);
        }
    }

    public Id getUniqueId(InsightsContext insightscontext)
    {
        Id id;
        if (insightscontext == null || insightscontext.getSystem() == null || insightscontext.getSystem().getPreferences() == null)
        {
            id = Id.getEmptyId();
        } else
        {
            Id id2 = getIdFromPreferences(insightscontext.getSystem().getPreferences());
            id = id2;
            if (id2 == Id.getEmptyId())
            {
                Id id1 = new Id(generator.generateUniqueIdString());
                storeUniqueId(insightscontext.getSystem().getPreferences(), id1);
                return id1;
            }
        }
        return id;
    }

}
