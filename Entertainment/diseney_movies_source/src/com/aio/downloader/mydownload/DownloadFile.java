// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import java.io.Serializable;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.HttpHandler;

public class DownloadFile
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean isStop;
    private HttpHandler mHttpHandler;

    public DownloadFile()
    {
    }

    public HttpHandler getmHttpHandler()
    {
        return mHttpHandler;
    }

    public boolean isStop()
    {
        isStop = getmHttpHandler().isStop();
        return isStop;
    }

    public void setStop(boolean flag)
    {
        isStop = flag;
    }

    public void setmHttpHandler(HttpHandler httphandler)
    {
        mHttpHandler = httphandler;
    }

    public DownloadFile startDownloadFileByUrl(String s, String s1, AjaxCallBack ajaxcallback)
    {
        if (ajaxcallback == null)
        {
            throw new RuntimeException("AjaxCallBack\u5BF9\u8C61\u4E0D\u80FD\u4E3Anull");
        } else
        {
            setmHttpHandler((new FinalHttp()).download(s, s1, true, ajaxcallback));
            return this;
        }
    }

    public DownloadFile startDownloadFileByUrlNoCatch(String s, String s1, AjaxCallBack ajaxcallback)
    {
        if (ajaxcallback == null)
        {
            throw new RuntimeException("AjaxCallBack\u5BF9\u8C61\u4E0D\u80FD\u4E3Anull");
        } else
        {
            setmHttpHandler((new FinalHttp()).download(s, s1, true, ajaxcallback));
            return this;
        }
    }

    public void stopDownload()
    {
        if (getmHttpHandler() != null)
        {
            getmHttpHandler().stop();
            getmHttpHandler().cancel(true);
            if (!getmHttpHandler().isStop())
            {
                getmHttpHandler().stop();
                getmHttpHandler().cancel(true);
            }
        }
    }
}
