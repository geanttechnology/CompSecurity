// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;

import android.content.Intent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.ui.fragments.MappPageFragment;
import com.poshmark.utils.PMSerializer;
import java.util.Map;
import java.util.Random;

// Referenced classes of package com.poshmark.webcommands:
//            CommandCompletionHandler

public class WebCommand
    implements PMSerializer
{

    int commandHashCode;
    String commandName;
    transient CommandCompletionHandler completionHandler;
    Map dictionary;
    CommandCompletionHandler.HandlerType handlerType;
    String js_callback;
    Map parameters;

    public WebCommand()
    {
        commandHashCode = (new Random()).nextInt(65535);
    }

    public int commandHashCode()
    {
        return commandHashCode;
    }

    public void handleCommandResults(MappPageFragment mapppagefragment, Intent intent)
    {
        if (completionHandler != null)
        {
            completionHandler.handleCommandResults(mapppagefragment, this, intent);
        }
    }

    public String serialize()
    {
        Gson gson = (new GsonBuilder()).create();
        if (!(gson instanceof Gson))
        {
            return gson.toJson(this, com/poshmark/webcommands/WebCommand);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, this, com/poshmark/webcommands/WebCommand);
        }
    }

    public void setCommandCompletionHandler(CommandCompletionHandler commandcompletionhandler)
    {
        completionHandler = commandcompletionhandler;
        handlerType = commandcompletionhandler.type;
    }
}
