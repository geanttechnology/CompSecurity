// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.content.Context;
import android.util.Log;
import com.targetspot.android.sdk.util.HttpUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdBreak, AdSegment, AdData

public class DownloadManager
{

    private Context appContext;
    private File playbackDir;

    public DownloadManager(Context context)
    {
        appContext = context;
        playbackDir = context.getDir("current", 0);
        cleanPlayback();
    }

    boolean checkDate(File file, Date date)
    {
        boolean flag;
        if (file.lastModified() >= date.getTime())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            Log.d("DownloadManager", (new StringBuilder()).append("Content in file is out of date: ").append(file.getName()).toString());
        }
        return flag;
    }

    public void cleanPlayback()
    {
        String as[] = playbackDir.list();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            moveToCache(as[i]);
        }

    }

    boolean fileIsHtml(File file)
        throws IOException
    {
        return URLConnection.guessContentTypeFromStream(new BufferedInputStream(new FileInputStream(file))) == "text/html";
    }

    String getCacheName(String s)
        throws IOException
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IOException("failed to generate cache file name");
        }
        return s;
    }

    public InputStream getContent(String s)
        throws IOException
    {
        s = getCacheName(s);
        return new FileInputStream(new File(playbackDir, s));
    }

    public String getContentURL(String s)
        throws IOException
    {
        Object obj = getCacheName(s);
        obj = new File(playbackDir, ((String) (obj)));
        if (((File) (obj)).exists())
        {
            s = (new StringBuilder()).append("file://").append(((File) (obj)).getAbsolutePath()).toString();
        }
        return s;
    }

    void moveToCache(String s)
    {
        File file = new File(playbackDir, s);
        if (file.exists())
        {
            s = new File(appContext.getCacheDir(), s);
            if (s.exists())
            {
                s.delete();
            }
            file.renameTo(s);
        }
    }

    public void prepareAds(List list)
        throws IOException
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Iterator iterator = ((AdBreak)list.next()).getSegments().iterator();
            while (iterator.hasNext()) 
            {
                AdSegment adsegment = (AdSegment)iterator.next();
                prepareContent(adsegment, adsegment.getAudioFile().getUrl());
                prepareContent(adsegment, adsegment.getVisualFile().getUrl());
            }
        }

    }

    void prepareContent(AdSegment adsegment, String s)
        throws IOException
    {
        Object obj = getCacheName(s);
        boolean flag1 = false;
        File file = new File(playbackDir, ((String) (obj)));
        Log.d("DownloadManager", (new StringBuilder()).append("Preparing ").append(file.getAbsolutePath()).toString());
        boolean flag;
        if (file.exists())
        {
            flag = flag1;
            if (checkDate(file, adsegment.getLastModified()))
            {
                flag = true;
            }
        } else
        {
            obj = new File(appContext.getCacheDir(), ((String) (obj)));
            flag = flag1;
            if (((File) (obj)).exists())
            {
                flag = flag1;
                if (!fileIsHtml(((File) (obj))))
                {
                    if (checkDate(((File) (obj)), adsegment.getLastModified()))
                    {
                        flag = ((File) (obj)).renameTo(file);
                    } else
                    {
                        ((File) (obj)).delete();
                        flag = flag1;
                    }
                }
            }
        }
        if (!flag)
        {
            HttpUtil.downloadFile(s, file, false);
            if (file.length() == 0L)
            {
                throw new FileNotFoundException(adsegment.adId);
            }
            file.setLastModified(adsegment.getLastModified().getTime());
            Log.d("DownloadManager", (new StringBuilder()).append("Downloaded ").append(file.getAbsolutePath()).toString());
        }
    }

    public void releaseAds(List list)
        throws IOException
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Iterator iterator = ((AdBreak)list.next()).getSegments().iterator();
            while (iterator.hasNext()) 
            {
                AdSegment adsegment = (AdSegment)iterator.next();
                releaseContent(adsegment.getAudioFile().getUrl());
                releaseContent(adsegment.getVisualFile().getUrl());
            }
        }

    }

    void releaseContent(String s)
        throws IOException
    {
        s = getCacheName(s);
        Log.d("DownloadManager", (new StringBuilder()).append("Releasing ").append(s).toString());
        moveToCache(s);
    }
}
