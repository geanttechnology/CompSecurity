// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest.cache;

import com.amazon.insights.abtest.DefaultVariation;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.FileManager;
import com.amazon.insights.core.system.System;
import com.amazon.insights.core.util.Preconditions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.abtest.cache:
//            VariationCache

public class FileVariationCache
    implements VariationCache
{

    private static Logger logger = Logger.getLogger(com/amazon/insights/abtest/cache/FileVariationCache);
    private final FileManager fileManager;
    private final Map variationFiles = new ConcurrentHashMap();
    private final File variationsDirectory;

    public FileVariationCache(InsightsContext insightscontext)
    {
        fileManager = insightscontext.getSystem().getFileManager();
        variationsDirectory = fileManager.createDirectory("variations");
        loadVariationFileInfo();
    }

    private void loadVariationFileInfo()
    {
        if (variationsDirectory != null && variationsDirectory.exists())
        {
            Iterator iterator = fileManager.listFilesInDirectory(variationsDirectory).iterator();
            while (iterator.hasNext()) 
            {
                File file = (File)iterator.next();
                variationFiles.put(file.getName(), file);
            }
        }
    }

    private DefaultVariation loadVariationFromFile(File file)
    {
        if (file == null)
        {
            return null;
        }
        file = new BufferedReader(new InputStreamReader(new GZIPInputStream(fileManager.newInputStream(file))));
        Object obj = new StringBuilder();
_L1:
        String s = file.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        ((StringBuilder) (obj)).append(s);
          goto _L1
        obj;
        int i;
        HashMap hashmap;
        JSONObject jsonobject;
        try
        {
            file.close();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            logger.e("The file does not exist to read the variation from", file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            logger.e("An error occurred while trying to read the variation from the file", file);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            logger.e("Failed to parse from json the variation read from the file", file);
        }
        return null;
        obj = new JSONObject(((StringBuilder) (obj)).toString());
        file.close();
        file = new com.amazon.insights.abtest.DefaultVariation.Builder();
        file.setApplicationKey(((JSONObject) (obj)).getString("applicationKey"));
        file.setUniqueId(Id.valueOf(((JSONObject) (obj)).getString("uniqueId")));
        file.setAllocationSource(com.amazon.insights.abtest.DefaultVariation.AllocationSource.CACHE);
        file.setExpirationDate(new Date(((JSONObject) (obj)).getLong("expirationDate")));
        file.setProjectName(((JSONObject) (obj)).getString("projectName"));
        file.setVariationName(((JSONObject) (obj)).getString("variationName"));
        file.setVariationId(((JSONObject) (obj)).getLong("variationId"));
        file.setExperimentId(((JSONObject) (obj)).getLong("experimentId"));
        obj = ((JSONObject) (obj)).getJSONArray("variables");
        if (obj == null) goto _L3; else goto _L2
_L2:
        hashmap = new HashMap();
        i = 0;
_L9:
        if (i >= ((JSONArray) (obj)).length()) goto _L5; else goto _L4
_L4:
        jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        if (jsonobject == null) goto _L7; else goto _L6
_L6:
        hashmap.put(jsonobject.getString("name"), jsonobject.getString("value"));
          goto _L7
_L5:
        file.setVariables(hashmap);
_L3:
        file = file.build();
        return file;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private boolean writeVariationToFile(DefaultVariation defaultvariation, Writer writer)
    {
        try
        {
            defaultvariation = defaultvariation.toJSONObject().toString(4);
        }
        // Misplaced declaration of an exception variable
        catch (DefaultVariation defaultvariation)
        {
            return false;
        }
        if (defaultvariation != null)
        {
            try
            {
                writer.write(defaultvariation);
                writer.flush();
            }
            // Misplaced declaration of an exception variable
            catch (DefaultVariation defaultvariation)
            {
                return false;
            }
        }
        return true;
    }

    public Map get(Set set)
    {
        this;
        JVM INSTR monitorenter ;
        ConcurrentHashMap concurrenthashmap;
        concurrenthashmap = new ConcurrentHashMap();
        set = set.iterator();
_L3:
        String s;
        Object obj;
        do
        {
            if (!set.hasNext())
            {
                break MISSING_BLOCK_LABEL_117;
            }
            s = (String)set.next();
        } while (!variationFiles.containsKey(s));
        obj = (File)variationFiles.get(s);
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        variationFiles.remove(s);
          goto _L3
        set;
        throw set;
_L2:
        obj = loadVariationFromFile(((File) (obj)));
        if (obj == null) goto _L3; else goto _L4
_L4:
        concurrenthashmap.put(s, obj);
          goto _L3
        this;
        JVM INSTR monitorexit ;
        return concurrenthashmap;
    }

    public Map getAll()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ConcurrentHashMap();
        iterator = variationFiles.entrySet().iterator();
_L3:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_121;
        }
        entry = (java.util.Map.Entry)iterator.next();
        if (((File)entry.getValue()).exists()) goto _L2; else goto _L1
_L1:
        variationFiles.remove(entry.getKey());
          goto _L3
        obj;
        throw obj;
_L2:
        DefaultVariation defaultvariation = loadVariationFromFile((File)entry.getValue());
        if (defaultvariation == null) goto _L3; else goto _L4
_L4:
        ((Map) (obj)).put(entry.getKey(), defaultvariation);
          goto _L3
        this;
        JVM INSTR monitorexit ;
        return ((Map) (obj));
    }

    public boolean put(DefaultVariation defaultvariation)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(defaultvariation);
        Object obj;
        File file;
        Object obj1;
        Object obj2;
        boolean flag;
        if (!defaultvariation.isDefault())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (!variationFiles.containsKey(defaultvariation.getProjectName())) goto _L2; else goto _L1
_L1:
        file = (File)variationFiles.get(defaultvariation.getProjectName());
_L7:
        obj1 = null;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj1 = fileManager.newOutputStream(file, false);
        flag = flag1;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj = null;
        obj2 = null;
        obj1 = new OutputStreamWriter(new GZIPOutputStream(((java.io.OutputStream) (obj1))));
        if (!writeVariationToFile(defaultvariation, ((Writer) (obj1)))) goto _L6; else goto _L5
_L5:
        variationFiles.put(defaultvariation.getProjectName(), file);
        IOException ioexception;
        if (obj1 != null)
        {
            try
            {
                ((OutputStreamWriter) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (DefaultVariation defaultvariation) { }
            finally
            {
                this;
            }
        }
        flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj = defaultvariation.getProjectName();
        obj = new File(variationsDirectory, ((String) (obj)));
        file = fileManager.createFile(((File) (obj)));
          goto _L7
        defaultvariation;
_L14:
        logger.deve("Unable to cache the variation");
        logger.e("An error occurred while attempting to create a new file to persist a variation", defaultvariation);
        flag = flag1;
        if (true) goto _L4; else goto _L8
_L8:
        JVM INSTR monitorexit ;
        throw defaultvariation;
        defaultvariation;
        logger.e("The file does not exist to write the variation to", defaultvariation);
        flag = flag1;
          goto _L4
_L6:
        flag = flag1;
        if (obj1 == null) goto _L4; else goto _L9
_L9:
        ((OutputStreamWriter) (obj1)).close();
        flag = flag1;
          goto _L4
        defaultvariation;
        flag = flag1;
          goto _L4
        ioexception;
        defaultvariation = obj2;
_L13:
        obj = defaultvariation;
        logger.e("Could not write the variation to file", ioexception);
        flag = flag1;
        if (defaultvariation == null) goto _L4; else goto _L10
_L10:
        defaultvariation.close();
        flag = flag1;
          goto _L4
        defaultvariation;
        flag = flag1;
          goto _L4
        defaultvariation;
_L12:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        try
        {
            ((OutputStreamWriter) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        throw defaultvariation;
        defaultvariation;
        obj = obj1;
        if (true) goto _L12; else goto _L11
_L11:
        ioexception;
        defaultvariation = ((DefaultVariation) (obj1));
          goto _L13
        defaultvariation;
          goto _L14
    }

}
