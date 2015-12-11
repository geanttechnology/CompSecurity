// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.FileManager;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.events:
//            UniqueIdResolverChain, UniqueIdResolver

public class ExternalStorageUniqueIdResolver extends UniqueIdResolverChain
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/ExternalStorageUniqueIdResolver);
    private final FileManager fileManager;
    private final File uniqueIdFile;

    public ExternalStorageUniqueIdResolver(FileManager filemanager, UniqueIdResolver uniqueidresolver)
    {
        super(uniqueidresolver);
        fileManager = filemanager;
        uniqueIdFile = filemanager.createFile("Android/data/amazon", "amzn-unique.txt");
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject = super.toJSONObject();
        if (uniqueIdFile != null)
        {
            try
            {
                jsonobject.put("uniqueIdFile", uniqueIdFile.getPath());
            }
            catch (JSONException jsonexception)
            {
                return jsonobject;
            }
        }
        return jsonobject;
    }

    public String toString()
    {
        JSONObject jsonobject = toJSONObject();
        String s;
        try
        {
            s = jsonobject.toString(4);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject.toString();
        }
        return s;
    }

    public String tryResolve()
    {
        if (!fileManager.isExternalStoragePresent())
        {
            return null;
        }
        String s;
        try
        {
            s = fileManager.readFileContents(uniqueIdFile);
        }
        catch (Exception exception)
        {
            logger.e(exception.getLocalizedMessage());
            return null;
        }
        return s;
    }

    public boolean tryStore(String s)
    {
        if (!fileManager.isExternalStorageWritable())
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = fileManager.writeFileContents(uniqueIdFile, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

}
