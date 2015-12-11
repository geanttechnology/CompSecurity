// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.userpreferences;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.userpreferences:
//            UserPreferenceChangeListener

public class UserPreferenceManager
{

    private ResultLayoutType resultLayoutType;
    private RetailSearchLogger retailSearchLogger;
    private Set userPreferenceChangeListeners;

    public UserPreferenceManager(Context context)
    {
        userPreferenceChangeListeners = new HashSet();
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        resultLayoutType = getResultLayoutType(context);
    }

    private ResultLayoutType getResultLayoutType(Context context)
    {
        Object obj = null;
        try
        {
            context = ResultLayoutType.findByNameIgnoreCase(context.getResources().getString(com.amazon.retailsearch.R.string.config_rs_default_result_layout_type));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            retailSearchLogger.error("Failed to set defaultResultLayoutType from config_rs_default_result_layout_type", context);
            context = obj;
        }
        if (context != null)
        {
            return context;
        } else
        {
            return ResultLayoutType.ListView;
        }
    }

    public void addUserPreferenceChangeListener(UserPreferenceChangeListener userpreferencechangelistener)
    {
        userPreferenceChangeListeners.add(userpreferencechangelistener);
    }

    public void clear()
    {
        userPreferenceChangeListeners.clear();
    }

    public ResultLayoutType getResultLayoutType()
    {
        return resultLayoutType;
    }

    public void removeUserPreferenceChangeListener(UserPreferenceChangeListener userpreferencechangelistener)
    {
        userPreferenceChangeListeners.remove(userpreferencechangelistener);
    }

    public void setResultLayoutType(ResultLayoutType resultlayouttype)
    {
        if (resultLayoutType != resultlayouttype)
        {
            resultLayoutType = resultlayouttype;
            Iterator iterator = userPreferenceChangeListeners.iterator();
            while (iterator.hasNext()) 
            {
                ((UserPreferenceChangeListener)iterator.next()).onResultLayoutTypeUpdated(resultlayouttype);
            }
        }
    }
}
