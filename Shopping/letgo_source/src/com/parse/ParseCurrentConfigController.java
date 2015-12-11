// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseExecutors, ParseFileUtils, ParseConfig, ParseDecoder, 
//            NoObjectsEncoder

class ParseCurrentConfigController
{

    ParseConfig currentConfig;
    private File currentConfigFile;
    private final Object currentConfigMutex = new Object();

    public ParseCurrentConfigController(File file)
    {
        currentConfigFile = file;
    }

    void clearCurrentConfigForTesting()
    {
        synchronized (currentConfigMutex)
        {
            currentConfig = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu getCurrentConfigAsync()
    {
        return cu.a(new Callable() {

            final ParseCurrentConfigController this$0;

            public ParseConfig call()
                throws Exception
            {
                Object obj = currentConfigMutex;
                obj;
                JVM INSTR monitorenter ;
                if (currentConfig != null) goto _L2; else goto _L1
_L1:
                ParseConfig parseconfig;
                ParseCurrentConfigController parsecurrentconfigcontroller;
                parseconfig = getFromDisk();
                parsecurrentconfigcontroller = ParseCurrentConfigController.this;
                if (parseconfig == null) goto _L4; else goto _L3
_L3:
                parsecurrentconfigcontroller.currentConfig = parseconfig;
_L2:
                obj;
                JVM INSTR monitorexit ;
                return currentConfig;
_L4:
                parseconfig = new ParseConfig();
                if (true) goto _L3; else goto _L5
_L5:
                Exception exception;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = ParseCurrentConfigController.this;
                super();
            }
        }, ParseExecutors.io());
    }

    ParseConfig getFromDisk()
    {
        JSONObject jsonobject = ParseFileUtils.readFileToJSONObject(currentConfigFile);
        return new ParseConfig(jsonobject, ParseDecoder.get());
        Object obj;
        obj;
_L2:
        return null;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void saveToDisk(ParseConfig parseconfig)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("params", (JSONObject)NoObjectsEncoder.get().encode(parseconfig.getParams()));
        }
        // Misplaced declaration of an exception variable
        catch (ParseConfig parseconfig)
        {
            throw new RuntimeException("could not serialize config to JSON");
        }
        try
        {
            ParseFileUtils.writeJSONObjectToFile(currentConfigFile, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParseConfig parseconfig)
        {
            return;
        }
    }

    public cu setCurrentConfigAsync(final ParseConfig config)
    {
        return cu.a(new Callable() {

            final ParseCurrentConfigController this$0;
            final ParseConfig val$config;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                synchronized (currentConfigMutex)
                {
                    currentConfig = config;
                    saveToDisk(config);
                }
                return null;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = ParseCurrentConfigController.this;
                config = parseconfig;
                super();
            }
        }, ParseExecutors.io());
    }

}
