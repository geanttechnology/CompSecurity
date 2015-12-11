// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.HttpError;
import com.ebay.nautilus.kernel.net.InvalidDeviceClockError;
import com.ebay.nautilus.kernel.net.IoError;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.ExceptionUtil;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.IOException;

// Referenced classes of package com.ebay.nautilus.shell.content:
//            FwLoader

public abstract class FwNetLoader extends FwLoader
{

    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logInfo = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/nautilus/shell/content/FwNetLoader.getSimpleName(), 3, "Log network errors from tasks");
    private final EbayContext ebayContext;
    private volatile IOException exception;
    private volatile boolean interrupted;
    private volatile ResultStatus resultStatus;

    protected FwNetLoader(EbayContext ebaycontext)
    {
        super((Context)ebaycontext.getExtension(android/content/Context));
        resultStatus = ResultStatus.SUCCESS;
        exception = null;
        ebayContext = ebaycontext;
    }

    static void log(Exception exception1)
    {
        if (logInfo.isLoggable)
        {
            String s1 = exception1.getMessage();
            String s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = exception1.getClass().getName();
            }
            FwLog.println(logInfo, s, exception1);
        }
    }

    protected final void doInBackground()
    {
        try
        {
            doInBackgroundInternal();
            return;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.HostErrorException hosterrorexception)
        {
            exception = hosterrorexception;
            log(hosterrorexception);
            EbayContext ebaycontext = ebayContext;
            ResultStatus resultstatus = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                new HttpError(hosterrorexception.getResponseCode(), hosterrorexception.getMessage())
            });
            resultStatus = resultstatus;
            NautilusDomain.rewriteServiceErrors(ebaycontext, resultstatus);
            return;
        }
        catch (com.ebay.nautilus.kernel.net.Connector.InvalidDeviceClockException invaliddeviceclockexception)
        {
            exception = invaliddeviceclockexception;
            log(invaliddeviceclockexception);
            EbayContext ebaycontext1 = ebayContext;
            ResultStatus resultstatus1 = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                new InvalidDeviceClockError()
            });
            resultStatus = resultstatus1;
            NautilusDomain.rewriteServiceErrors(ebaycontext1, resultstatus1);
            return;
        }
        catch (IOException ioexception)
        {
            log(ioexception);
            if (ExceptionUtil.isInterruptedException(ioexception))
            {
                interrupted = true;
                return;
            } else
            {
                exception = ioexception;
                EbayContext ebaycontext2 = ebayContext;
                ResultStatus resultstatus2 = ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    new IoError(ioexception)
                });
                resultStatus = resultstatus2;
                NautilusDomain.rewriteServiceErrors(ebaycontext2, resultstatus2);
                return;
            }
        }
        catch (InterruptedException interruptedexception)
        {
            log(interruptedexception);
        }
        interrupted = true;
    }

    protected abstract void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException;

    public EbayContext getEbayContext()
    {
        return ebayContext;
    }

    public final IOException getException()
    {
        return exception;
    }

    public final ResultStatus getResultStatus()
    {
        return resultStatus;
    }

    public final boolean isClientError()
    {
        return exception != null && (exception instanceof com.ebay.nautilus.kernel.net.Connector.ClientErrorException);
    }

    public final boolean isConnectionError()
    {
        return exception != null && !isClientError();
    }

    public final boolean isError()
    {
        return exception != null || isServiceError();
    }

    public boolean isInterrupted()
    {
        return interrupted;
    }

    public boolean isServiceError()
    {
        return false;
    }

    protected final Response sendRequest(Request request)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        return com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebayContext, request);
    }

    protected final void setResultStatus(ResultStatus resultstatus)
    {
        if (resultstatus == null)
        {
            throw new IllegalArgumentException("status");
        } else
        {
            resultStatus = resultstatus;
            return;
        }
    }

}
