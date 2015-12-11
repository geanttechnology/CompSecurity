// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicStatusLine;

public class HttpResponseValidator
{

    private static final DPLogger log = new DPLogger("TComm.HttpResponseValidator");

    private HttpResponseValidator()
    {
    }

    private static void changeStatusLine(HttpResponse httpresponse, int i, String s)
    {
        StatusLine statusline = httpresponse.getStatusLine();
        s = new BasicStatusLine(statusline.getProtocolVersion(), i, s);
        log.debug("changeStatusCode", "changing code and phrase", new Object[] {
            "statusLine", s, "newStatusLine", statusline
        });
        httpresponse.setStatusLine(s);
    }

    public static boolean validateContentLength(HttpResponse httpresponse)
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i / 100 != 2)
        {
            log.debug("validateContentLength", "Ignoring non-2xx status code", new Object[] {
                "statusCode", Integer.valueOf(i)
            });
            return true;
        }
        Object obj = httpresponse.getFirstHeader("Content-Length");
        if (obj == null)
        {
            log.debug("validateContentLength", "No Content-Length header", new Object[0]);
            return true;
        }
        long l = Long.parseLong(((Header) (obj)).getValue());
        log.debug("validateContentLength", "Got header content-length", new Object[] {
            "headerContentLength", Long.valueOf(l)
        });
        if (l < 0L)
        {
            return true;
        }
        obj = httpresponse.getEntity();
        if (obj == null)
        {
            if (l != 0L)
            {
                log.error("validateContentLength", "Unexpected null content", new Object[] {
                    "headerContentLength", Long.valueOf(l)
                });
                httpresponse.setHeader("Content-Length", "0");
                changeStatusLine(httpresponse, 500, "Unexpected Null Content");
                return false;
            }
        } else
        {
            long l1 = ((HttpEntity) (obj)).getContentLength();
            log.debug("validateContentLength", "got entity content-length", new Object[] {
                "entityContentLength", Long.valueOf(l1)
            });
            if (l != l1)
            {
                log.error("validateContentLength", "Length mismatch", new Object[0]);
                httpresponse.setHeader("Content-Length", String.valueOf(l1));
                String s;
                if (l1 < l)
                {
                    s = "Response Truncated";
                } else
                {
                    s = "Content Length Mismatch";
                }
                changeStatusLine(httpresponse, 500, s);
                return false;
            }
        }
        return true;
    }

}
