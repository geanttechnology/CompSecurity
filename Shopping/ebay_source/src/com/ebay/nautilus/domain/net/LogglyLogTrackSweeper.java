// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.content.Context;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackPerf;
import com.ebay.nautilus.kernel.net.LogTrackSweeper;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.DefaultHelper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LogglyLogTrackSweeper extends LogTrackSweeper
{
    public static final class PerformanceRequest extends Request
    {

        private static URL LOGGLY_URL;
        private static final int TIMEOUT = 10000;
        private final LogTrackPerf _tracker;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            byte abyte0[];
            try
            {
                abyte0 = LogglyLogTrackSweeper.buildData(getContext(), _tracker).toString().getBytes();
            }
            catch (JSONException jsonexception)
            {
                throw com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException.create(jsonexception);
            }
            return abyte0;
        }

        public URL getRequestUrl()
        {
            return LOGGLY_URL;
        }

        public PerformanceResponse getResponse()
        {
            return new PerformanceResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public String getUserAgent()
        {
            return null;
        }

        public boolean isErrorReportable()
        {
            return false;
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            iheaders.setHeader("Content-Type", "application/json");
        }

        static 
        {
            try
            {
                LOGGLY_URL = new URL("https://logs.loggly.com/inputs/402b7be9-7480-4a8b-9103-1fe77ef48703");
            }
            catch (MalformedURLException malformedurlexception)
            {
                LogglyLogTrackSweeper.logger.logAsError("Unable to initialize LOGGLY_URL");
            }
        }

        public PerformanceRequest(LogTrackPerf logtrackperf)
        {
            _tracker = logtrackperf;
            setTimeout(10000);
            setServiceName("Logging");
            setOperationName("loggly");
        }
    }

    public static final class PerformanceResponse extends Response
    {

        public PerformanceResponse()
        {
        }
    }


    private static final int MAX_ERR_ITEMS = 20;
    private static final int MAX_PERF_ITEMS = 500;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("LogglyPerf", 3, "Log LogglyPerformanceSweeper events");
    private final Thread _thread;
    private final Runnable _worker = new Runnable() {

        final LogglyLogTrackSweeper this$0;

        public void run()
        {
            do
            {
                sendReport();
                try
                {
                    Thread.sleep(15000L);
                }
                catch (InterruptedException interruptedexception) { }
            } while (true);
        }

            
            {
                this$0 = LogglyLogTrackSweeper.this;
                super();
            }
    };

    public LogglyLogTrackSweeper(EbayContext ebaycontext)
    {
        super(ebaycontext, 500, 20);
        _thread = new Thread(_worker);
        _thread.start();
    }

    protected static JSONObject buildData(Context context, LogTrackPerf logtrackperf)
        throws JSONException
    {
        context = new JSONObject();
        context.put("serviceName", DefaultHelper.forString(logtrackperf.getServiceName(), "Unknown"));
        context.put("operationName", DefaultHelper.forString(logtrackperf.getOperationName(), "Unknown"));
        context.put("operationStartTime", (new Date(logtrackperf.getOperationStartTime())).toString());
        context.put("requestDuration", logtrackperf.getRequestDuration());
        context.put("responseDuration", logtrackperf.getResponseDuration());
        return context;
    }

    public void sendReport()
    {
        Iterator iterator = takePerfList().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (LogTrackPerf)iterator.next();
            try
            {
                obj = new PerformanceRequest(((LogTrackPerf) (obj)));
                com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebayContext, ((Request) (obj)));
            }
            catch (IOException ioexception)
            {
                if (logger.isLoggable)
                {
                    logger.log(ioexception.getLocalizedMessage());
                }
            }
            catch (InterruptedException interruptedexception)
            {
                if (logger.isLoggable)
                {
                    logger.log(interruptedexception.getLocalizedMessage());
                }
            }
        } while (true);
    }


}
