// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import android.content.Context;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.FileManager;
import java.io.File;
import java.io.FileOutputStream;

// Referenced classes of package com.amazon.device.analytics.events:
//            UniqueIdResolverChain, UniqueIdResolver

public class MASUniqueIdResolver extends UniqueIdResolverChain
{

    private static final Logger logging = Logging.getLogger(com/amazon/device/analytics/events/MASUniqueIdResolver);
    private final Context appContext;
    private final FileManager fileManager;

    public MASUniqueIdResolver(FileManager filemanager, Context context, UniqueIdResolver uniqueidresolver)
    {
        super(uniqueidresolver);
        appContext = context.getApplicationContext();
        fileManager = filemanager;
    }

    public String tryResolve()
    {
        Object obj;
        try
        {
            obj = new File(new File((new StringBuilder()).append("/data/data/com.amazon.venezia").append(File.separator).append("files").toString()), "amzn-unique.txt");
            obj = fileManager.readFileContents(((File) (obj)));
        }
        catch (Exception exception)
        {
            logging.e("Error reading file contents", exception);
            return null;
        }
        return ((String) (obj));
    }

    public boolean tryStore(String s)
    {
        if ("com.amazon.venezia".equals(appContext.getPackageName()))
        {
            try
            {
                FileOutputStream fileoutputstream = appContext.openFileOutput("amzn-unique.txt", 1);
                fileoutputstream.write(s.getBytes());
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                logging.e("Error writing file contents", s);
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

}
