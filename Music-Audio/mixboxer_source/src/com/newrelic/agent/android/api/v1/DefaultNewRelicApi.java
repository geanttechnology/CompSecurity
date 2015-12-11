// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.v1;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.api.common.ConnectionState;
import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.MachineMeasurements;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.Location;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.transport.DisableAgentException;
import com.newrelic.agent.android.transport.DisconnectAgentException;
import com.newrelic.agent.android.transport.FlushTransactionDataException;
import com.newrelic.agent.android.transport.Transport;
import com.newrelic.agent.android.transport.TransportException;
import com.newrelic.agent.android.transport.TransportFactory;
import com.newrelic.agent.android.transport.http.HttpJsonTransportFactory;
import java.io.InterruptedIOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.newrelic.agent.android.api.v1:
//            NewRelicApi, Configuration, DeviceForm, SimpleDeviceInfo, 
//            ConnectionEvent, ConnectionListener, DeviceInfo

public class DefaultNewRelicApi
    implements NewRelicApi
{

    private static final String AGENT_NAME = "AndroidAgent";
    private static final String CPU_SYSTEM_UTILIZATION_METRIC = "CPU/System/Utilization";
    private static final String CPU_TOTAL_UTILIZATION_METRIC = "CPU/Total/Utilization";
    private static final String CPU_USER_UTILIZATION_METRIC = "CPU/User/Utilization";
    private static final String MEMORY_USED_METRIC = "Memory/Used";
    private static final String OS_NAME = "Android";
    private static final String SESSION_DURATION_METRIC = "Session/Duration";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final String appName;
    private final String appVersion;
    private ArrayList connectionListeners;
    private ConnectionState connectionState;
    private SimpleDeviceInfo deviceInfo;
    private Location location;
    private final String packageId;
    private final TransportFactory transportFactory;

    public DefaultNewRelicApi(Configuration configuration)
    {
        this(configuration.getAppName(), configuration.getAppVersion(), configuration.getPackageId(), ((TransportFactory) (new HttpJsonTransportFactory(getCollectorUrl(configuration), configuration.getLicenseKey()))), configuration.getDeviceId(), configuration.getDeviceForm(), configuration.getDeviceManufacturer(), configuration.getDeviceModel(), configuration.getAndroidRelease());
    }

    public DefaultNewRelicApi(String s, String s1, String s2, TransportFactory transportfactory, String s3, DeviceForm deviceform, String s4, 
            String s5, String s6)
    {
        connectionState = ConnectionState.NULL;
        connectionListeners = new ArrayList();
        appName = s;
        appVersion = s1;
        packageId = s2;
        transportFactory = transportfactory;
        s = new HashMap();
        if (deviceform != null)
        {
            s.put("size", deviceform.name().toLowerCase());
        }
        deviceInfo = new SimpleDeviceInfo("Android", s6, s4, s5, "AndroidAgent", Agent.getVersion(), s3, s);
    }

    private JSONArray buildAppInfoJson()
    {
        return new JSONArray(Arrays.asList(new String[] {
            appName, appVersion, packageId
        }));
    }

    private void connect(Transport transport)
        throws InterruptedIOException, TransportException
    {
        Object obj;
        String s;
        int i;
        int j;
        int k;
        long l1;
        long l2;
        long l3;
        long l4;
        boolean flag;
        log.info("Connect in progress");
        obj = new TicToc();
        try
        {
            JSONArray jsonarray = new JSONArray(Arrays.asList(new JSONArray[] {
                buildAppInfoJson(), deviceInfoWithLocation().toJSONArray()
            }));
            ((TicToc) (obj)).tic();
            transport = transport.send(com.newrelic.agent.android.transport.Transport.MessageType.CONNECT, jsonarray.toString(), 0L);
            StatsEngine.get().recordTimeMs("Supportability/MobileAgent/Collector/Connect", ((TicToc) (obj)).toc());
        }
        // Misplaced declaration of an exception variable
        catch (Transport transport)
        {
            throw new TransportException(transport);
        }
        this;
        JVM INSTR monitorenter ;
        transport = new JSONObject(transport);
        obj = transport.get("data_token");
        s = transport.getString("cross_process_id");
        l3 = transport.getLong("server_timestamp");
        l2 = transport.getLong("data_report_period");
        l4 = transport.getLong("report_max_transaction_count");
        l1 = transport.getLong("report_max_transaction_age");
        flag = transport.getBoolean("collect_network_errors");
        i = transport.getInt("error_limit");
        j = transport.getInt("response_body_limit");
        k = transport.getInt("stack_trace_limit");
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        reset();
        throw new TransportException("Missing or invalid data token");
        transport;
        this;
        JVM INSTR monitorexit ;
        throw transport;
        transport;
        reset();
        log.error("Error while unpacking JSON response during connect");
        throw new TransportException(transport);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        reset();
        throw new TransportException("Missing cross process ID");
        if (l4 >= 0L) goto _L2; else goto _L1
_L1:
        throw new TransportException((new StringBuilder()).append("Invalid max transaction count of ").append(l4).toString());
_L7:
        if (l3 > 0L) goto _L4; else goto _L3
_L3:
        reset();
        throw new TransportException("Invalid server timestamp");
_L10:
        long l;
        setConnectionState(new ConnectionState(obj, s, l3, l1, TimeUnit.SECONDS, l, TimeUnit.SECONDS, l4, k, j, flag, i));
        log.verbose((new StringBuilder()).append("Connected, notifying listeners. Got data token: ").append(obj).toString());
        notifyConnected(getConnectionState());
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (l1 <= 0L) goto _L6; else goto _L5
_L5:
        l = l1;
        if (l1 <= 600L) goto _L7; else goto _L6
_L6:
        l = 600L;
          goto _L7
_L4:
        if (l2 <= 0L) goto _L9; else goto _L8
_L8:
        l1 = l2;
        if (l2 <= 60L) goto _L10; else goto _L9
_L9:
        l1 = 60L;
          goto _L10
    }

    private void data(Transport transport, Collection collection, Collection collection1, MachineMeasurements machinemeasurements, double d, boolean flag)
        throws InterruptedIOException, TransportException
    {
        ConnectionState connectionstate;
        JSONObject jsonobject;
        connectionstate = getConnectionState();
        if (connectionstate == null)
        {
            log.error("Connection state is unexpectedly null! Aborting.");
            return;
        }
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("Memory/Used", machinemeasurements.getMemoryUsage());
            jsonobject.put("CPU/User/Utilization", 0);
            jsonobject.put("CPU/System/Utilization", 0);
            jsonobject.put("CPU/Total/Utilization", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Transport transport)
        {
            throw new TransportException(transport);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        jsonobject.put("Session/Duration", d);
        machinemeasurements = deviceInfoWithLocation().toJSONArray();
        JSONArray jsonarray = new JSONArray();
        int j = 0;
        int i = 0;
        collection = collection.iterator();
        while (collection.hasNext()) 
        {
            TransactionData transactiondata = (TransactionData)collection.next();
            int k;
            int l;
            if (transactiondata.getErrorCode() != 0)
            {
                k = j + 1;
                l = i;
            } else
            {
                k = j;
                l = i;
                if (transactiondata.getStatusCode() >= 400)
                {
                    l = i + 1;
                    k = j;
                }
            }
            jsonarray.put(new JSONArray(transactiondata.asList()));
            j = k;
            i = l;
        }
        collection = new JSONArray();
        for (collection1 = collection1.iterator(); collection1.hasNext(); collection.put(new JSONArray(((ErrorData)collection1.next()).asList()))) { }
        StatsEngine.populateMetrics(jsonobject);
        log.verbose(MessageFormat.format("Sending {0} transactions ({1} errors, {2} failed calls)", new Object[] {
            Integer.valueOf(jsonarray.length()), Integer.valueOf(j), Integer.valueOf(i)
        }));
        log.verbose(MessageFormat.format("Sending {0} error traces", new Object[] {
            Integer.valueOf(collection.length())
        }));
        collection = new JSONArray(Arrays.asList(new Object[] {
            connectionstate.getDataToken(), machinemeasurements, Double.valueOf(connectionstate.getHarvestIntervalInSeconds()), jsonarray, jsonobject, collection
        }));
        transport.send(com.newrelic.agent.android.transport.Transport.MessageType.DATA, collection.toString(), connectionstate.getServerTimestamp());
        return;
    }

    private SimpleDeviceInfo deviceInfoWithLocation()
        throws JSONException
    {
        this;
        JVM INSTR monitorenter ;
        SimpleDeviceInfo simpledeviceinfo;
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        simpledeviceinfo = deviceInfo.withLocation(location.getCountryCode(), location.getRegion());
        this;
        JVM INSTR monitorexit ;
        return simpledeviceinfo;
        simpledeviceinfo = deviceInfo;
        this;
        JVM INSTR monitorexit ;
        return simpledeviceinfo;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void disconnect(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = isConnected();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        notifyDisconnected();
        reset();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        Agent.disable();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        reset();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Agent.disable();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String getCollectorUrl(Configuration configuration)
    {
        String s;
        if (configuration.isSslEnabled())
        {
            s = "https";
        } else
        {
            s = "http";
        }
        return MessageFormat.format("{0}://{1}/mobile/v1", new Object[] {
            s, configuration.getCollectorHost()
        });
    }

    private List getConnectionListeners()
    {
        ArrayList arraylist1;
        synchronized (connectionListeners)
        {
            arraylist1 = new ArrayList(connectionListeners);
        }
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ConnectionState getConnectionState()
    {
        this;
        JVM INSTR monitorenter ;
        ConnectionState connectionstate = connectionState;
        this;
        JVM INSTR monitorexit ;
        return connectionstate;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void notifyConnected(ConnectionState connectionstate)
    {
        connectionstate = new ConnectionEvent(this, connectionstate);
        for (Iterator iterator = getConnectionListeners().iterator(); iterator.hasNext(); ((ConnectionListener)iterator.next()).connected(connectionstate)) { }
    }

    private void notifyDisconnected()
    {
        ConnectionEvent connectionevent = new ConnectionEvent(this);
        for (Iterator iterator = getConnectionListeners().iterator(); iterator.hasNext(); ((ConnectionListener)iterator.next()).disconnected(connectionevent)) { }
    }

    private void sendDataInternal(double d, Collection collection, Collection collection1, MachineMeasurements machinemeasurements, double d1, 
            boolean flag)
        throws InterruptedIOException, TransportException
    {
        Transport transport = transportFactory.newTransport();
        try
        {
            if (!isConnected())
            {
                connect(transport);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            log.warning("The collector has asked the agent to disconnect");
            disconnect(false);
            return;
        }
        try
        {
            data(transport, collection, collection1, machinemeasurements, d1, flag);
            return;
        }
        catch (DisconnectAgentException disconnectagentexception) { }
        log.info("The collector has asked the agent to disconnect while sending metric data");
        disconnect(false);
        connect(transport);
        data(transport, collection, collection1, machinemeasurements, d1, flag);
        return;
        collection;
        log.warning("The collector has asked the agent to disable itself");
        disconnect(true);
        return;
        collection;
        log.warning((new StringBuilder()).append("Flushing transaction data (transaction too big?): ").append(collection.toString()).toString());
        return;
    }

    public void addConnectionListener(ConnectionListener connectionlistener)
    {
        synchronized (connectionListeners)
        {
            connectionListeners.add(connectionlistener);
        }
        return;
        connectionlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectionlistener;
    }

    Object getDataToken()
    {
        return connectionState.getDataToken();
    }

    public DeviceInfo getDeviceInfo()
    {
        return deviceInfo;
    }

    public boolean isConnected()
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (connectionState != ConnectionState.NULL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeConnectionListener(ConnectionListener connectionlistener)
    {
        synchronized (connectionListeners)
        {
            connectionListeners.remove(connectionlistener);
        }
        return;
        connectionlistener;
        arraylist;
        JVM INSTR monitorexit ;
        throw connectionlistener;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        connectionState = ConnectionState.NULL;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void sendConnect()
        throws InterruptedIOException, TransportException
    {
        connect(transportFactory.newTransport());
    }

    public void sendData(double d, Collection collection, Collection collection1, MachineMeasurements machinemeasurements)
        throws InterruptedIOException, TransportException
    {
        sendDataInternal(d, collection, collection1, machinemeasurements, 0.0D, false);
    }

    public void sendData(double d, Collection collection, Collection collection1, MachineMeasurements machinemeasurements, double d1)
        throws InterruptedIOException, TransportException
    {
        sendDataInternal(d, collection, collection1, machinemeasurements, d1, true);
    }

    public void setConnectionState(ConnectionState connectionstate)
    {
        this;
        JVM INSTR monitorenter ;
        connectionState = connectionstate;
        this;
        JVM INSTR monitorexit ;
        return;
        connectionstate;
        this;
        JVM INSTR monitorexit ;
        throw connectionstate;
    }

    public void setLocation(Location location1)
    {
        this;
        JVM INSTR monitorenter ;
        location = location1;
        this;
        JVM INSTR monitorexit ;
        return;
        location1;
        this;
        JVM INSTR monitorexit ;
        throw location1;
    }

}
