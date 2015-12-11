// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.playbackmanager.EPPlaybackManagerListener;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPStream, FeedsCommListener, FeedsManagerAPI

class MaintainSession
{
    private class MaintainSessionTask extends TimerTask
    {

        final MaintainSession this$0;

        public void run()
        {
            String s1;
            try
            {
                String s = (new StringBuilder(String.valueOf(stream.getMaintainUrl()))).append("?token=").append(URLEncoder.encode(stream.getToken(), "UTF-8")).append("&v=2.0.0").toString();
                (new FeedsManagerAPI(listener)).getMaintianSessionResponse(s);
                return;
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                if ((new StringBuilder("MaintainSessionTask error: ")).append(unsupportedencodingexception.getMessage()).toString() != null)
                {
                    s1 = unsupportedencodingexception.getMessage();
                } else
                {
                    s1 = "";
                }
            }
            Utils.sdkLog(s1, 5, unsupportedencodingexception);
        }

        private MaintainSessionTask()
        {
            this$0 = MaintainSession.this;
            super();
        }

        MaintainSessionTask(MaintainSessionTask maintainsessiontask)
        {
            this();
        }
    }


    FeedsCommListener listener;
    EPPlaybackManagerListener playbackInterface;
    EPStream stream;
    Timer timer;
    int ttlMargin;

    protected MaintainSession(EPStream epstream, EPPlaybackManagerListener epplaybackmanagerlistener, FeedsCommListener feedscommlistener)
    {
        ttlMargin = 0x15f90;
        stream = epstream;
        playbackInterface = epplaybackmanagerlistener;
        listener = feedscommlistener;
        timer = new Timer();
    }

    protected void cancel()
    {
        String s;
        try
        {
            if (timer != null)
            {
                timer.cancel();
                timer.purge();
            }
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("MaintainSession error: ")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, exception);
    }

    protected void maintain()
    {
        String s;
        try
        {
            int i = Integer.parseInt(stream.getTtl());
            timer.schedule(new MaintainSessionTask(null), i - ttlMargin);
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("MaintainSession error: ")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, exception);
    }

    protected void update(EPStream epstream)
    {
        try
        {
            cancel();
            stream = epstream;
            int i = Integer.parseInt(epstream.getTtl());
            timer = new Timer();
            timer.schedule(new MaintainSessionTask(null), i - ttlMargin);
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("MaintainSession error: ")).append(exception.getMessage()).toString() != null)
            {
                epstream = exception.getMessage();
            } else
            {
                epstream = "";
            }
        }
        Utils.sdkLog(epstream, 5, exception);
    }
}
