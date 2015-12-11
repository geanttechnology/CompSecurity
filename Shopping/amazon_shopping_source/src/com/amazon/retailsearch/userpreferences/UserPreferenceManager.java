// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.userpreferences;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.ViewType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.userpreferences:
//            UserPreferenceChangeListener

public class UserPreferenceManager
{

    private RetailSearchLogger retailSearchLogger;
    private Set userPreferenceChangeListeners;
    private ViewType viewType;

    public UserPreferenceManager(Context context)
    {
        userPreferenceChangeListeners = new HashSet();
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        viewType = getDefaultViewType(context);
    }

    private ViewType getDefaultViewType(Context context)
    {
        Object obj = null;
        try
        {
            context = ViewType.findByNameIgnoreCase(context.getResources().getString(com.amazon.retailsearch.R.string.config_rs_default_viewtype));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            retailSearchLogger.error("Failed to set defaultViewType from config_rs_default_viewtype", context);
            context = obj;
        }
        if (context != null)
        {
            return context;
        } else
        {
            return ViewType.ListView;
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

    public ViewType getViewType()
    {
        return viewType;
    }

    public void removeUserPreferenceChangeListener(UserPreferenceChangeListener userpreferencechangelistener)
    {
        userPreferenceChangeListeners.remove(userpreferencechangelistener);
    }

    public void setViewType(ViewType viewtype)
    {
        if (viewType != viewtype)
        {
            viewType = viewtype;
            Iterator iterator = userPreferenceChangeListeners.iterator();
            while (iterator.hasNext()) 
            {
                ((UserPreferenceChangeListener)iterator.next()).onViewTypeUpdated(viewtype);
            }
        }
    }
}
