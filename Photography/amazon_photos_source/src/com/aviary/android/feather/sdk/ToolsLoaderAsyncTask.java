// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.util.Pair;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.sdk.panels.AbstractPanelLoaderService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity

public class ToolsLoaderAsyncTask extends AviaryAsyncTask
{
    public static interface OnToolsLoadListener
    {

        public abstract void onToolsLoaded(List list, List list1, boolean flag);
    }

    static class ToolLoadResult
    {

        public List entries;
        public List tools;
        public boolean whiteLabel;

        ToolLoadResult()
        {
        }
    }


    private final OnToolsLoadListener mListener;
    private final AbstractPanelLoaderService mPanelLoaderService;
    private final List mToolList;

    ToolsLoaderAsyncTask(OnToolsLoadListener ontoolsloadlistener, List list, AbstractPanelLoaderService abstractpanelloaderservice)
    {
        mListener = ontoolsloadlistener;
        mToolList = list;
        mPanelLoaderService = abstractpanelloaderservice;
    }

    protected transient ToolLoadResult doInBackground(FeatherActivity afeatheractivity[])
    {
        Object obj = afeatheractivity[0];
        if (obj == null)
        {
            return null;
        }
        afeatheractivity = loadTools(((FeatherActivity) (obj)), mToolList);
        obj = CdsUtils.getPermissions(((android.content.Context) (obj)));
        ToolLoadResult toolloadresult = new ToolLoadResult();
        toolloadresult.tools = (List)((Pair) (afeatheractivity)).first;
        toolloadresult.entries = (List)((Pair) (afeatheractivity)).second;
        boolean flag;
        if (obj != null && ((List) (obj)).contains(com.aviary.android.feather.cds.AviaryCds.Permission.whitelabel.name()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        toolloadresult.whiteLabel = flag;
        return toolloadresult;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((FeatherActivity[])aobj);
    }

    protected void doPostExecute(ToolLoadResult toolloadresult)
    {
        if (mListener != null && toolloadresult != null)
        {
            mListener.onToolsLoaded(toolloadresult.tools, toolloadresult.entries, toolloadresult.whiteLabel);
        }
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((ToolLoadResult)obj);
    }

    protected void doPreExecute()
    {
    }

    Pair loadTools(FeatherActivity featheractivity, List list)
    {
        Object obj = list;
        if (list == null)
        {
            featheractivity = featheractivity.loadStandaloneTools();
            obj = featheractivity;
            if (featheractivity == null)
            {
                obj = Arrays.asList(ToolLoaderFactory.getAllTools());
            }
        }
        featheractivity = new ArrayList();
        list = new HashMap();
        ToolEntry atoolentry[] = mPanelLoaderService.getToolsEntries();
        int i = 0;
        while (i < atoolentry.length) 
        {
            com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools = atoolentry[i].name;
            if (obj == null || ((List) (obj)).contains(tools.name()))
            {
                list.put(tools.name(), atoolentry[i]);
            }
            i++;
        }
        if (obj != null)
        {
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (list.containsKey(s))
                {
                    featheractivity.add(list.get(s));
                }
            } while (true);
        }
        return new Pair(obj, featheractivity);
    }
}
