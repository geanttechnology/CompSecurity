// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.tasks;

import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.core.events.LoadModelFromJsonEvent;
import com.rdio.android.core.events.LoadModelsEvent;
import com.rdio.android.core.events.ModelLoaderErrorEvent;
import com.rdio.android.core.events.ModelsLoadedEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.tasks:
//            PresenterTask

public class LoadModelsTask extends PresenterTask
{
    public static class Response
    {

        public boolean isPartial;
        public List models;

        public Response()
        {
        }
    }


    private static final String TAG = "LoadModelsTask";
    private List extras;
    private List keys;
    private boolean loadWithDefaults;
    private List loadedModels;
    private JSONObject modelToLoadJson;
    private JSONArray options;

    public LoadModelsTask(e e1, String s, boolean flag, List list)
    {
        this(e1, s, flag, list, null);
    }

    public LoadModelsTask(e e1, String s, boolean flag, List list, JSONArray jsonarray)
    {
        super(e1);
        e1 = new ArrayList(1);
        e1.add(s);
        initialize(e1, flag, list, jsonarray);
    }

    public LoadModelsTask(e e1, List list, boolean flag, List list1)
    {
        super(e1);
        initialize(list, flag, list1, null);
    }

    public LoadModelsTask(e e1, JSONObject jsonobject, boolean flag, List list)
    {
        super(e1);
        modelToLoadJson = jsonobject;
        initialize(null, flag, list, null);
    }

    private void initialize(List list, boolean flag, List list1, JSONArray jsonarray)
    {
        keys = list;
        extras = list1;
        loadWithDefaults = flag;
        options = jsonarray;
    }

    private void pruneUnavailableModels(List list)
    {
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (list.get(i) == null)
            {
                list.remove(i);
            }
        }

    }

    private void updateLoadedModels(List list)
    {
        if (keys != null)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                ApiModel apimodel = (ApiModel)list.next();
                int i = 0;
                while (i < keys.size()) 
                {
                    if (apimodel.key.equals(keys.get(i)))
                    {
                        loadedModels.set(i, apimodel);
                    }
                    i++;
                }
            }

        } else
        {
            loadedModels = new ArrayList(list);
        }
    }

    public void onModelLoaderError(ModelLoaderErrorEvent modelloadererrorevent)
    {
        if (modelloadererrorevent.getRequester().equals(getEventRequesterId()))
        {
            onTaskError(modelloadererrorevent.getMessage());
        }
    }

    public void onModelsLoaded(ModelsLoadedEvent modelsloadedevent)
    {
label0:
        {
            if (checkRequesterId(modelsloadedevent.getRequester()))
            {
                if (modelsloadedevent.getLoadedCount() != modelsloadedevent.getRequestedCount() && !modelsloadedevent.isFromStorage())
                {
                    break label0;
                }
                updateLoadedModels(modelsloadedevent.getModels());
                if (modelsloadedevent.isFromStorage() && modelsloadedevent.getLoadedCount() != modelsloadedevent.getRequestedCount())
                {
                    pruneUnavailableModels(loadedModels);
                }
                Response response;
                boolean flag;
                if (!modelsloadedevent.isIncomplete())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                response = new Response();
                response.isPartial = modelsloadedevent.isIncomplete();
                response.models = loadedModels;
                onTaskCompleted(response, flag);
            }
            return;
        }
        updateLoadedModels(modelsloadedevent.getModels());
    }

    protected void onPerformTask()
    {
        if (modelToLoadJson == null)
        {
            loadedModels = new ArrayList(Collections.nCopies(keys.size(), null));
            LoadModelsEvent loadmodelsevent = new LoadModelsEvent(keys, extras, loadWithDefaults, getEventRequesterId(), getEventId());
            loadmodelsevent.options = options;
            getEventBus().post(loadmodelsevent);
            return;
        } else
        {
            LoadModelFromJsonEvent loadmodelfromjsonevent = new LoadModelFromJsonEvent(modelToLoadJson, loadWithDefaults, getEventRequesterId(), getEventId());
            getEventBus().post(loadmodelfromjsonevent);
            return;
        }
    }
}
