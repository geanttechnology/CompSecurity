// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.util.Log;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

public final class TemporaryFileManager
{

    public static TemporaryFileManager instance = new TemporaryFileManager();
    private final String TAG = getClass().getSimpleName();
    private final ArrayList files = new ArrayList();

    private TemporaryFileManager()
    {
    }

    private void deleteAllFiles()
    {
        Iterator iterator;
        Log.d(TAG, "purging temporary files");
        iterator = files.iterator();
_L2:
        File file;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        file = (File)iterator.next();
        Log.d(TAG, (new StringBuilder()).append("removing temporary file ").append(file.getAbsolutePath()).toString());
        boolean flag = file.delete();
        if (!flag)
        {
            Log.w(TAG, (new StringBuilder()).append("unable to remove file, ").append(file.getAbsolutePath()).toString());
        }
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        Log.w(TAG, (new StringBuilder()).append("failed to remove file, ").append(file.getAbsolutePath()).toString(), exception1);
        if (true)
        {
            Log.w(TAG, (new StringBuilder()).append("unable to remove file, ").append(file.getAbsolutePath()).toString());
        }
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        if (true)
        {
            Log.w(TAG, (new StringBuilder()).append("unable to remove file, ").append(file.getAbsolutePath()).toString());
        }
        throw exception;
_L1:
        files.clear();
        return;
    }

    public void add(File file)
    {
        files.add(file);
    }

    public ArrayList clear()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = files.iterator(); iterator.hasNext(); arraylist.add(((File)iterator.next()).toURI().toString())) { }
        files.clear();
        return arraylist;
    }

    public void init(ArrayList arraylist)
    {
        files.clear();
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            String s = (String)arraylist.next();
            try
            {
                files.add(new File(new URI(s)));
            }
            catch (URISyntaxException urisyntaxexception)
            {
                Log.w(TAG, "failed to import uri", urisyntaxexception);
            }
        }

    }

    public void purge()
    {
        (new Thread(new Runnable() {

            final TemporaryFileManager this$0;

            public void run()
            {
                deleteAllFiles();
            }

            
            {
                this$0 = TemporaryFileManager.this;
                super();
            }
        })).start();
    }


}
