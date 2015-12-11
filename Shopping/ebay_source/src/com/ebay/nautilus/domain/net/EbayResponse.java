// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.ApiMetaData;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.LogTrackConfiguration;
import com.ebay.nautilus.kernel.net.LogTrackManager;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayErrorUtil, EbayResponseError, ResponseWrapper

public abstract class EbayResponse extends Response
    implements ApiMetaData, IResponseDataHandler
{

    public static final int ACK_CUSTOM_CODE = 0;
    public static final int ACK_FAILURE = -1;
    public static final int ACK_PARTIAL_FAILURE = -2;
    public static final int ACK_SUCCESS = 1;
    public static final int ACK_WARNING = 2;
    private static volatile long hostTimeDelta = 0L;
    public int ackCode;
    public String build;
    public String version;

    public EbayResponse()
    {
        ackCode = -1;
    }

    public static long currentHostTime()
    {
        return getHostTime(System.currentTimeMillis());
    }

    public static long getClientTime(long l)
    {
        return hostTimeDelta + l;
    }

    public static long getHostTime(long l)
    {
        return l - hostTimeDelta;
    }

    public IResponseDataHandler getDataHandler()
    {
        if (hasSuccessResponseCode())
        {
            return this;
        } else
        {
            return null;
        }
    }

    public boolean hasFailureValidation()
    {
        return EbayErrorUtil.invalidIafToken(getResultStatus());
    }

    public boolean hasReportableResultStatusError()
    {
label0:
        {
            if (ackCode != -1)
            {
                return false;
            }
            if (LogTrackManager.getConfig().isRequestErrorReportingEnabled())
            {
                break label0;
            }
            Object obj = getResultStatus();
            if (obj == null || !((ResultStatus) (obj)).hasMessage())
            {
                break label0;
            }
            obj = ((ResultStatus) (obj)).getMessages().iterator();
            com.ebay.nautilus.kernel.content.ResultStatus.Message message;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)((Iterator) (obj)).next();
            } while (!(message instanceof EbayResponseError) || ((EbayResponseError)message).category != 2);
            return false;
        }
        return getResultStatus().hasError();
    }

    public final boolean isSuccessful()
    {
        return ackCode > 0;
    }

    protected Object readJsonStream(Gson gson, InputStream inputstream, Class class1)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        return readStream(gson, inputstream, class1);
    }

    protected Object readJsonStream(InputStream inputstream, Class class1)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        return readStream(DataMapperFactory.getDefaultMapper(), inputstream, class1);
    }

    protected Object readStream(Gson gson, InputStream inputstream, Class class1)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        InputStream inputstream1;
        InputStream inputstream2;
        inputstream2 = null;
        inputstream1 = null;
        inputstream = StreamUtil.streamToReader(inputstream, "UTF-8");
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        Object obj = gson.fromJson(inputstream, class1);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException("Response readStream returned with a null object.");
        gson;
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        try
        {
            throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException("Response parsing failed with an exception!", gson);
        }
        // Misplaced declaration of an exception variable
        catch (Gson gson)
        {
            inputstream2 = inputstream1;
        }
        finally
        {
            StreamUtil.closeQuietly(inputstream2);
        }
        throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(gson);
        throw gson;
        gson = null;
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        if (!(obj instanceof ResponseWrapper))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        gson = ((ResponseWrapper)obj).getResponse();
        class1 = gson;
        if (gson != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        class1 = gson;
        if (!(obj instanceof BaseApiResponse))
        {
            break MISSING_BLOCK_LABEL_151;
        }
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        class1 = (BaseApiResponse)obj;
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        setAckCode(class1.getAck());
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        setBuild(class1.getBuild());
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        setErrors(class1.getErrors());
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        setHostTime(class1.getHostTime());
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        setVersion(class1.getVersion());
        StreamUtil.closeQuietly(inputstream);
        return obj;
    }

    public void setAckCode(int i)
    {
        ackCode = i;
    }

    public void setBuild(String s)
    {
        build = s;
    }

    public void setErrors(List list)
    {
        setResultStatus(ResultStatus.create(list));
    }

    public final void setHostTime(long l)
    {
label0:
        {
            if (l > 0L)
            {
                if (requestTime > 0L)
                {
                    break label0;
                }
                hostTimeDelta = 0L;
            }
            return;
        }
        hostTimeDelta = requestTime - l;
    }

    public void setVersion(String s)
    {
        version = s;
    }

}
