// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            TransactionStateUtil, TransactionState

public class HttpsURLConnectionExtension extends HttpsURLConnection
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private HttpsURLConnection impl;
    private TransactionState transactionState;

    public HttpsURLConnectionExtension(HttpsURLConnection httpsurlconnection)
    {
        super(httpsurlconnection.getURL());
        impl = httpsurlconnection;
        TransactionStateUtil.setCrossProcessHeader(httpsurlconnection);
    }

    private void addTransactionAndErrorData(TransactionState transactionstate)
    {
        TransactionData transactiondata = transactionstate.end();
        Agent.addTransactionData(transactiondata);
        if ((long)transactionstate.getStatusCode() >= 400L)
        {
            StringBuilder stringbuilder = new StringBuilder();
            TreeMap treemap;
            String s;
            try
            {
                InputStream inputstream = getErrorStream();
                if (inputstream instanceof CountingInputStream)
                {
                    stringbuilder.append(((CountingInputStream)inputstream).getBufferAsString());
                }
            }
            catch (Exception exception)
            {
                log.error(exception.toString());
            }
            treemap = new TreeMap();
            s = impl.getContentType();
            if (s != null && !"".equals(s))
            {
                treemap.put("content_type", s);
            }
            treemap.put("content_length", Long.valueOf(transactionstate.getBytesReceived()));
            Agent.addErrorData(new ErrorData(transactiondata.getUrl(), transactiondata.getStatusCode(), stringbuilder.toString(), treemap));
        }
    }

    private void checkResponse()
    {
        if (!getTransactionState().isComplete())
        {
            TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), impl);
        }
    }

    private void error(Exception exception)
    {
        TransactionState transactionstate = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(transactionstate, exception);
        if (!transactionstate.isComplete())
        {
            TransactionStateUtil.inspectAndInstrumentResponse(transactionstate, impl);
            Agent.addTransactionData(transactionstate.end());
        }
    }

    private TransactionState getTransactionState()
    {
        if (transactionState == null)
        {
            transactionState = new TransactionState();
            TransactionStateUtil.inspectAndInstrument(transactionState, impl);
        }
        return transactionState;
    }

    public void addRequestProperty(String s, String s1)
    {
        impl.addRequestProperty(s, s1);
    }

    public void connect()
        throws IOException
    {
        getTransactionState();
        try
        {
            impl.connect();
            return;
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
    }

    public void disconnect()
    {
        if (transactionState != null && !transactionState.isComplete())
        {
            addTransactionAndErrorData(transactionState);
        }
        impl.disconnect();
    }

    public boolean getAllowUserInteraction()
    {
        return impl.getAllowUserInteraction();
    }

    public String getCipherSuite()
    {
        return impl.getCipherSuite();
    }

    public int getConnectTimeout()
    {
        return impl.getConnectTimeout();
    }

    public Object getContent()
        throws IOException
    {
        getTransactionState();
        Object obj;
        int i;
        try
        {
            obj = impl.getContent();
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        i = impl.getContentLength();
        if (i >= 0)
        {
            TransactionState transactionstate = getTransactionState();
            if (!transactionstate.isComplete())
            {
                transactionstate.setBytesReceived(i);
                addTransactionAndErrorData(transactionstate);
            }
        }
        return obj;
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        getTransactionState();
        try
        {
            aclass = ((Class []) (impl.getContent(aclass)));
        }
        // Misplaced declaration of an exception variable
        catch (Class aclass[])
        {
            error(aclass);
            throw aclass;
        }
        checkResponse();
        return aclass;
    }

    public String getContentEncoding()
    {
        getTransactionState();
        String s = impl.getContentEncoding();
        checkResponse();
        return s;
    }

    public int getContentLength()
    {
        getTransactionState();
        int i = impl.getContentLength();
        checkResponse();
        return i;
    }

    public String getContentType()
    {
        getTransactionState();
        String s = impl.getContentType();
        checkResponse();
        return s;
    }

    public long getDate()
    {
        getTransactionState();
        long l = impl.getDate();
        checkResponse();
        return l;
    }

    public boolean getDefaultUseCaches()
    {
        return impl.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return impl.getDoInput();
    }

    public boolean getDoOutput()
    {
        return impl.getDoOutput();
    }

    public InputStream getErrorStream()
    {
        getTransactionState();
        CountingInputStream countinginputstream;
        try
        {
            countinginputstream = new CountingInputStream(impl.getErrorStream(), true);
        }
        catch (Exception exception)
        {
            log.error(exception.toString());
            return impl.getErrorStream();
        }
        return countinginputstream;
    }

    public long getExpiration()
    {
        getTransactionState();
        long l = impl.getExpiration();
        checkResponse();
        return l;
    }

    public String getHeaderField(int i)
    {
        getTransactionState();
        String s = impl.getHeaderField(i);
        checkResponse();
        return s;
    }

    public String getHeaderField(String s)
    {
        getTransactionState();
        s = impl.getHeaderField(s);
        checkResponse();
        return s;
    }

    public long getHeaderFieldDate(String s, long l)
    {
        getTransactionState();
        l = impl.getHeaderFieldDate(s, l);
        checkResponse();
        return l;
    }

    public int getHeaderFieldInt(String s, int i)
    {
        getTransactionState();
        i = impl.getHeaderFieldInt(s, i);
        checkResponse();
        return i;
    }

    public String getHeaderFieldKey(int i)
    {
        getTransactionState();
        String s = impl.getHeaderFieldKey(i);
        checkResponse();
        return s;
    }

    public Map getHeaderFields()
    {
        getTransactionState();
        Map map = impl.getHeaderFields();
        checkResponse();
        return map;
    }

    public long getIfModifiedSince()
    {
        getTransactionState();
        long l = impl.getIfModifiedSince();
        checkResponse();
        return l;
    }

    public InputStream getInputStream()
        throws IOException
    {
        final TransactionState transactionState = getTransactionState();
        CountingInputStream countinginputstream;
        try
        {
            countinginputstream = new CountingInputStream(impl.getInputStream());
            TransactionStateUtil.inspectAndInstrumentResponse(transactionState, impl);
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        countinginputstream.addStreamCompleteListener(new StreamCompleteListener() {

            final HttpsURLConnectionExtension this$0;
            final TransactionState val$transactionState;

            public void streamComplete(StreamCompleteEvent streamcompleteevent)
            {
                if (!transactionState.isComplete())
                {
                    long l1 = impl.getContentLength();
                    long l = streamcompleteevent.getBytes();
                    if (l1 >= 0L)
                    {
                        l = l1;
                    }
                    transactionState.setBytesReceived(l);
                    addTransactionAndErrorData(transactionState);
                }
            }

            public void streamError(StreamCompleteEvent streamcompleteevent)
            {
                if (!transactionState.isComplete())
                {
                    transactionState.setBytesReceived(streamcompleteevent.getBytes());
                }
                error(streamcompleteevent.getException());
            }

            
            {
                this$0 = HttpsURLConnectionExtension.this;
                transactionState = transactionstate;
                super();
            }
        });
        return countinginputstream;
    }

    public boolean getInstanceFollowRedirects()
    {
        return impl.getInstanceFollowRedirects();
    }

    public long getLastModified()
    {
        getTransactionState();
        long l = impl.getLastModified();
        checkResponse();
        return l;
    }

    public Certificate[] getLocalCertificates()
    {
        return impl.getLocalCertificates();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        final TransactionState transactionState = getTransactionState();
        CountingOutputStream countingoutputstream;
        try
        {
            countingoutputstream = new CountingOutputStream(impl.getOutputStream());
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        countingoutputstream.addStreamCompleteListener(new StreamCompleteListener() {

            final HttpsURLConnectionExtension this$0;
            final TransactionState val$transactionState;

            public void streamComplete(StreamCompleteEvent streamcompleteevent)
            {
                if (!transactionState.isComplete())
                {
                    String s = impl.getRequestProperty("content-length");
                    long l1 = streamcompleteevent.getBytes();
                    long l = l1;
                    if (s != null)
                    {
                        try
                        {
                            l = Long.parseLong(s);
                        }
                        // Misplaced declaration of an exception variable
                        catch (StreamCompleteEvent streamcompleteevent)
                        {
                            l = l1;
                        }
                    }
                    transactionState.setBytesSent(l);
                    addTransactionAndErrorData(transactionState);
                }
            }

            public void streamError(StreamCompleteEvent streamcompleteevent)
            {
                if (!transactionState.isComplete())
                {
                    transactionState.setBytesSent(streamcompleteevent.getBytes());
                }
                error(streamcompleteevent.getException());
            }

            
            {
                this$0 = HttpsURLConnectionExtension.this;
                transactionState = transactionstate;
                super();
            }
        });
        return countingoutputstream;
    }

    public Permission getPermission()
        throws IOException
    {
        return impl.getPermission();
    }

    public int getReadTimeout()
    {
        return impl.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return impl.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return impl.getRequestProperties();
    }

    public String getRequestProperty(String s)
    {
        return impl.getRequestProperty(s);
    }

    public int getResponseCode()
        throws IOException
    {
        getTransactionState();
        int i;
        try
        {
            i = impl.getResponseCode();
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        checkResponse();
        return i;
    }

    public String getResponseMessage()
        throws IOException
    {
        getTransactionState();
        String s;
        try
        {
            s = impl.getResponseMessage();
        }
        catch (IOException ioexception)
        {
            error(ioexception);
            throw ioexception;
        }
        checkResponse();
        return s;
    }

    public Certificate[] getServerCertificates()
        throws SSLPeerUnverifiedException
    {
        Certificate acertificate[];
        try
        {
            acertificate = impl.getServerCertificates();
        }
        catch (SSLPeerUnverifiedException sslpeerunverifiedexception)
        {
            error(sslpeerunverifiedexception);
            throw sslpeerunverifiedexception;
        }
        return acertificate;
    }

    public URL getURL()
    {
        return impl.getURL();
    }

    public boolean getUseCaches()
    {
        return impl.getUseCaches();
    }

    public void setAllowUserInteraction(boolean flag)
    {
        impl.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        impl.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i)
    {
        impl.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        impl.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        impl.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
    {
        impl.setDoOutput(flag);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        impl.setFixedLengthStreamingMode(i);
    }

    public void setIfModifiedSince(long l)
    {
        impl.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        impl.setInstanceFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        impl.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        try
        {
            impl.setRequestMethod(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            error(s);
        }
        throw s;
    }

    public void setRequestProperty(String s, String s1)
    {
        impl.setRequestProperty(s, s1);
    }

    public void setUseCaches(boolean flag)
    {
        impl.setUseCaches(flag);
    }

    public String toString()
    {
        return impl.toString();
    }

    public boolean usingProxy()
    {
        return impl.usingProxy();
    }




}
