// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.IdleConnectionHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpConnectionManager, HostConfiguration, HttpConnection, ConnectionPoolTimeoutException, 
//            HttpException, SimpleHttpConnectionManager

public class MultiThreadedHttpConnectionManager
    implements HttpConnectionManager
{
    private class ConnectionPool
    {

        private LinkedList freeConnections;
        private IdleConnectionHandler idleConnectionHandler;
        private final Map mapHosts;
        private int numConnections;
        private final MultiThreadedHttpConnectionManager this$0;
        private LinkedList waitingThreads;

        private void deleteConnection(HttpConnection httpconnection)
        {
            this;
            JVM INSTR monitorenter ;
            HostConfiguration hostconfiguration = configurationForConnection(httpconnection);
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.LOG.debug("Reclaiming connection, hostConfig=" + hostconfiguration);
            }
            httpconnection.close();
            HostConnectionPool hostconnectionpool = getHostPool(hostconfiguration, true);
            hostconnectionpool.freeConnections.remove(httpconnection);
            hostconnectionpool.numConnections = hostconnectionpool.numConnections - 1;
            numConnections = numConnections - 1;
            if (hostconnectionpool.numConnections == 0 && hostconnectionpool.waitingThreads.isEmpty())
            {
                mapHosts.remove(hostconfiguration);
            }
            idleConnectionHandler.remove(httpconnection);
            this;
            JVM INSTR monitorexit ;
            return;
            httpconnection;
            throw httpconnection;
        }

        public void closeIdleConnections(long l)
        {
            this;
            JVM INSTR monitorenter ;
            idleConnectionHandler.closeIdleConnections(l);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public HttpConnection createConnection(HostConfiguration hostconfiguration)
        {
            this;
            JVM INSTR monitorenter ;
            HttpConnectionWithReference httpconnectionwithreference;
            HostConnectionPool hostconnectionpool = getHostPool(hostconfiguration, true);
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.LOG.debug("Allocating new connection, hostConfig=" + hostconfiguration);
            }
            httpconnectionwithreference = new HttpConnectionWithReference(hostconfiguration);
            httpconnectionwithreference.getParams().setDefaults(params);
            httpconnectionwithreference.setHttpConnectionManager(MultiThreadedHttpConnectionManager.this);
            numConnections = numConnections + 1;
            hostconnectionpool.numConnections = hostconnectionpool.numConnections + 1;
            MultiThreadedHttpConnectionManager.storeReferenceToConnection(httpconnectionwithreference, hostconfiguration, this);
            this;
            JVM INSTR monitorexit ;
            return httpconnectionwithreference;
            hostconfiguration;
            throw hostconfiguration;
        }

        public void deleteClosedConnections()
        {
            this;
            JVM INSTR monitorenter ;
            Iterator iterator = freeConnections.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                HttpConnection httpconnection = (HttpConnection)iterator.next();
                if (!httpconnection.isOpen())
                {
                    iterator.remove();
                    deleteConnection(httpconnection);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_55;
            Exception exception;
            exception;
            throw exception;
            this;
            JVM INSTR monitorexit ;
        }

        public void deleteLeastUsedConnection()
        {
            this;
            JVM INSTR monitorenter ;
            HttpConnection httpconnection = (HttpConnection)freeConnections.removeFirst();
            if (httpconnection == null) goto _L2; else goto _L1
_L1:
            deleteConnection(httpconnection);
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.LOG.debug("Attempted to reclaim an unused connection but there were none.");
            }
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public void freeConnection(HttpConnection httpconnection)
        {
            HostConfiguration hostconfiguration;
            hostconfiguration = configurationForConnection(httpconnection);
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.LOG.debug("Freeing connection, hostConfig=" + hostconfiguration);
            }
            this;
            JVM INSTR monitorenter ;
            if (!MultiThreadedHttpConnectionManager.this.shutdown)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            httpconnection.close();
            this;
            JVM INSTR monitorexit ;
            return;
            HostConnectionPool hostconnectionpool = getHostPool(hostconfiguration, true);
            hostconnectionpool.freeConnections.add(httpconnection);
            if (hostconnectionpool.numConnections == 0)
            {
                MultiThreadedHttpConnectionManager.LOG.error("Host connection pool not found, hostConfig=" + hostconfiguration);
                hostconnectionpool.numConnections = 1;
            }
            freeConnections.add(httpconnection);
            MultiThreadedHttpConnectionManager.removeReferenceToConnection((HttpConnectionWithReference)httpconnection);
            if (numConnections == 0)
            {
                MultiThreadedHttpConnectionManager.LOG.error("Host connection pool not found, hostConfig=" + hostconfiguration);
                numConnections = 1;
            }
            idleConnectionHandler.add(httpconnection);
            notifyWaitingThread(hostconnectionpool);
            this;
            JVM INSTR monitorexit ;
            return;
            httpconnection;
            this;
            JVM INSTR monitorexit ;
            throw httpconnection;
        }

        public HttpConnection getFreeConnection(HostConfiguration hostconfiguration)
        {
            this;
            JVM INSTR monitorenter ;
            Object obj1 = null;
            Object obj = getHostPool(hostconfiguration, false);
            if (obj == null) goto _L2; else goto _L1
_L1:
            if (((HostConnectionPool) (obj)).freeConnections.size() <= 0) goto _L2; else goto _L3
_L3:
            obj = (HttpConnectionWithReference)((HostConnectionPool) (obj)).freeConnections.removeLast();
            freeConnections.remove(obj);
            MultiThreadedHttpConnectionManager.storeReferenceToConnection(((HttpConnectionWithReference) (obj)), hostconfiguration, this);
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.LOG.debug("Getting free connection, hostConfig=" + hostconfiguration);
            }
            idleConnectionHandler.remove(((HttpConnection) (obj)));
_L5:
            this;
            JVM INSTR monitorexit ;
            return ((HttpConnection) (obj));
_L2:
            obj = obj1;
            if (!MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                continue; /* Loop/switch isn't completed */
            }
            MultiThreadedHttpConnectionManager.LOG.debug("There were no free connections to get, hostConfig=" + hostconfiguration);
            obj = obj1;
            if (true) goto _L5; else goto _L4
_L4:
            hostconfiguration;
            throw hostconfiguration;
        }

        public HostConnectionPool getHostPool(HostConfiguration hostconfiguration, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            HostConnectionPool hostconnectionpool1;
            MultiThreadedHttpConnectionManager.LOG.trace("enter HttpConnectionManager.ConnectionPool.getHostPool(HostConfiguration)");
            hostconnectionpool1 = (HostConnectionPool)mapHosts.get(hostconfiguration);
            HostConnectionPool hostconnectionpool;
            hostconnectionpool = hostconnectionpool1;
            if (hostconnectionpool1 != null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            hostconnectionpool = hostconnectionpool1;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            hostconnectionpool = new HostConnectionPool();
            hostconnectionpool.hostConfiguration = hostconfiguration;
            mapHosts.put(hostconfiguration, hostconnectionpool);
            this;
            JVM INSTR monitorexit ;
            return hostconnectionpool;
            hostconfiguration;
            throw hostconfiguration;
        }

        public void handleLostConnection(HostConfiguration hostconfiguration)
        {
            this;
            JVM INSTR monitorenter ;
            HostConnectionPool hostconnectionpool = getHostPool(hostconfiguration, true);
            hostconnectionpool.numConnections = hostconnectionpool.numConnections - 1;
            if (hostconnectionpool.numConnections == 0 && hostconnectionpool.waitingThreads.isEmpty())
            {
                mapHosts.remove(hostconfiguration);
            }
            numConnections = numConnections - 1;
            notifyWaitingThread(hostconfiguration);
            this;
            JVM INSTR monitorexit ;
            return;
            hostconfiguration;
            throw hostconfiguration;
        }

        public void notifyWaitingThread(HostConfiguration hostconfiguration)
        {
            this;
            JVM INSTR monitorenter ;
            notifyWaitingThread(getHostPool(hostconfiguration, true));
            this;
            JVM INSTR monitorexit ;
            return;
            hostconfiguration;
            throw hostconfiguration;
        }

        public void notifyWaitingThread(HostConnectionPool hostconnectionpool)
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = null;
            if (hostconnectionpool.waitingThreads.size() <= 0) goto _L2; else goto _L1
_L1:
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                MultiThreadedHttpConnectionManager.LOG.debug("Notifying thread waiting on host pool, hostConfig=" + hostconnectionpool.hostConfiguration);
            }
            hostconnectionpool = (WaitingThread)hostconnectionpool.waitingThreads.removeFirst();
            waitingThreads.remove(hostconnectionpool);
_L4:
            if (hostconnectionpool == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            hostconnectionpool.interruptedByConnectionPool = true;
            ((WaitingThread) (hostconnectionpool)).thread.interrupt();
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            if (waitingThreads.size() > 0)
            {
                if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
                {
                    MultiThreadedHttpConnectionManager.LOG.debug("No-one waiting on host pool, notifying next waiting thread.");
                }
                hostconnectionpool = (WaitingThread)waitingThreads.removeFirst();
                ((WaitingThread) (hostconnectionpool)).hostConnectionPool.waitingThreads.remove(hostconnectionpool);
                continue; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_157;
            hostconnectionpool;
            throw hostconnectionpool;
            hostconnectionpool = obj;
            if (!MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
            {
                continue; /* Loop/switch isn't completed */
            }
            MultiThreadedHttpConnectionManager.LOG.debug("Notifying no-one, there are no waiting threads");
            hostconnectionpool = obj;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void shutdown()
        {
            this;
            JVM INSTR monitorenter ;
            HttpConnection httpconnection;
            for (Iterator iterator = freeConnections.iterator(); iterator.hasNext(); httpconnection.close())
            {
                httpconnection = (HttpConnection)iterator.next();
                iterator.remove();
            }

            break MISSING_BLOCK_LABEL_47;
            Exception exception;
            exception;
            throw exception;
            MultiThreadedHttpConnectionManager.shutdownCheckedOutConnections(this);
            WaitingThread waitingthread;
            for (Iterator iterator1 = waitingThreads.iterator(); iterator1.hasNext(); waitingthread.thread.interrupt())
            {
                waitingthread = (WaitingThread)iterator1.next();
                iterator1.remove();
                waitingthread.interruptedByConnectionPool = true;
            }

            mapHosts.clear();
            idleConnectionHandler.removeAll();
            this;
            JVM INSTR monitorexit ;
        }




        private ConnectionPool()
        {
            this$0 = MultiThreadedHttpConnectionManager.this;
            freeConnections = new LinkedList();
            waitingThreads = new LinkedList();
            mapHosts = new HashMap();
            idleConnectionHandler = new IdleConnectionHandler();
            numConnections = 0;
        }

    }

    private static class ConnectionSource
    {

        public ConnectionPool connectionPool;
        public HostConfiguration hostConfiguration;

        private ConnectionSource()
        {
        }

    }

    private static class HostConnectionPool
    {

        public LinkedList freeConnections;
        public HostConfiguration hostConfiguration;
        public int numConnections;
        public LinkedList waitingThreads;

        private HostConnectionPool()
        {
            freeConnections = new LinkedList();
            waitingThreads = new LinkedList();
            numConnections = 0;
        }

    }

    private static class HttpConnectionAdapter extends HttpConnection
    {

        private HttpConnection wrappedConnection;

        public void close()
        {
            if (hasConnection())
            {
                wrappedConnection.close();
            }
        }

        public boolean closeIfStale()
            throws IOException
        {
            if (hasConnection())
            {
                return wrappedConnection.closeIfStale();
            } else
            {
                return false;
            }
        }

        public void flushRequestOutputStream()
            throws IOException
        {
            if (hasConnection())
            {
                wrappedConnection.flushRequestOutputStream();
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public String getHost()
        {
            if (hasConnection())
            {
                return wrappedConnection.getHost();
            } else
            {
                return null;
            }
        }

        public HttpConnectionManager getHttpConnectionManager()
        {
            if (hasConnection())
            {
                return wrappedConnection.getHttpConnectionManager();
            } else
            {
                return null;
            }
        }

        public InputStream getLastResponseInputStream()
        {
            if (hasConnection())
            {
                return wrappedConnection.getLastResponseInputStream();
            } else
            {
                return null;
            }
        }

        public InetAddress getLocalAddress()
        {
            if (hasConnection())
            {
                return wrappedConnection.getLocalAddress();
            } else
            {
                return null;
            }
        }

        public HttpConnectionParams getParams()
        {
            if (hasConnection())
            {
                return wrappedConnection.getParams();
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public int getPort()
        {
            if (hasConnection())
            {
                return wrappedConnection.getPort();
            } else
            {
                return -1;
            }
        }

        public Protocol getProtocol()
        {
            if (hasConnection())
            {
                return wrappedConnection.getProtocol();
            } else
            {
                return null;
            }
        }

        public String getProxyHost()
        {
            if (hasConnection())
            {
                return wrappedConnection.getProxyHost();
            } else
            {
                return null;
            }
        }

        public int getProxyPort()
        {
            if (hasConnection())
            {
                return wrappedConnection.getProxyPort();
            } else
            {
                return -1;
            }
        }

        public OutputStream getRequestOutputStream()
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                return wrappedConnection.getRequestOutputStream();
            } else
            {
                return null;
            }
        }

        public InputStream getResponseInputStream()
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                return wrappedConnection.getResponseInputStream();
            } else
            {
                return null;
            }
        }

        public int getSendBufferSize()
            throws SocketException
        {
            if (hasConnection())
            {
                return wrappedConnection.getSendBufferSize();
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public int getSoTimeout()
            throws SocketException
        {
            if (hasConnection())
            {
                return wrappedConnection.getSoTimeout();
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public String getVirtualHost()
        {
            if (hasConnection())
            {
                return wrappedConnection.getVirtualHost();
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        HttpConnection getWrappedConnection()
        {
            return wrappedConnection;
        }

        protected boolean hasConnection()
        {
            return wrappedConnection != null;
        }

        public boolean isOpen()
        {
            if (hasConnection())
            {
                return wrappedConnection.isOpen();
            } else
            {
                return false;
            }
        }

        public boolean isProxied()
        {
            if (hasConnection())
            {
                return wrappedConnection.isProxied();
            } else
            {
                return false;
            }
        }

        public boolean isResponseAvailable()
            throws IOException
        {
            if (hasConnection())
            {
                return wrappedConnection.isResponseAvailable();
            } else
            {
                return false;
            }
        }

        public boolean isResponseAvailable(int i)
            throws IOException
        {
            if (hasConnection())
            {
                return wrappedConnection.isResponseAvailable(i);
            } else
            {
                return false;
            }
        }

        public boolean isSecure()
        {
            if (hasConnection())
            {
                return wrappedConnection.isSecure();
            } else
            {
                return false;
            }
        }

        public boolean isStaleCheckingEnabled()
        {
            if (hasConnection())
            {
                return wrappedConnection.isStaleCheckingEnabled();
            } else
            {
                return false;
            }
        }

        public boolean isTransparent()
        {
            if (hasConnection())
            {
                return wrappedConnection.isTransparent();
            } else
            {
                return false;
            }
        }

        public void open()
            throws IOException
        {
            if (hasConnection())
            {
                wrappedConnection.open();
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void print(String s)
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.print(s);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void print(String s, String s1)
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.print(s, s1);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void printLine()
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.printLine();
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void printLine(String s)
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.printLine(s);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void printLine(String s, String s1)
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.printLine(s, s1);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public String readLine()
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                return wrappedConnection.readLine();
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public String readLine(String s)
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                return wrappedConnection.readLine(s);
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void releaseConnection()
        {
            if (!isLocked() && hasConnection())
            {
                HttpConnection httpconnection = wrappedConnection;
                wrappedConnection = null;
                httpconnection.releaseConnection();
            }
        }

        public void setConnectionTimeout(int i)
        {
            if (hasConnection())
            {
                wrappedConnection.setConnectionTimeout(i);
            }
        }

        public void setHost(String s)
            throws IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setHost(s);
            }
        }

        public void setHttpConnectionManager(HttpConnectionManager httpconnectionmanager)
        {
            if (hasConnection())
            {
                wrappedConnection.setHttpConnectionManager(httpconnectionmanager);
            }
        }

        public void setLastResponseInputStream(InputStream inputstream)
        {
            if (hasConnection())
            {
                wrappedConnection.setLastResponseInputStream(inputstream);
            }
        }

        public void setLocalAddress(InetAddress inetaddress)
        {
            if (hasConnection())
            {
                wrappedConnection.setLocalAddress(inetaddress);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void setParams(HttpConnectionParams httpconnectionparams)
        {
            if (hasConnection())
            {
                wrappedConnection.setParams(httpconnectionparams);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void setPort(int i)
            throws IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setPort(i);
            }
        }

        public void setProtocol(Protocol protocol)
        {
            if (hasConnection())
            {
                wrappedConnection.setProtocol(protocol);
            }
        }

        public void setProxyHost(String s)
            throws IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setProxyHost(s);
            }
        }

        public void setProxyPort(int i)
            throws IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setProxyPort(i);
            }
        }

        public void setSendBufferSize(int i)
            throws SocketException
        {
            if (hasConnection())
            {
                wrappedConnection.setSendBufferSize(i);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void setSoTimeout(int i)
            throws SocketException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setSoTimeout(i);
            }
        }

        public void setSocketTimeout(int i)
            throws SocketException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setSocketTimeout(i);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void setStaleCheckingEnabled(boolean flag)
        {
            if (hasConnection())
            {
                wrappedConnection.setStaleCheckingEnabled(flag);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void setVirtualHost(String s)
            throws IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.setVirtualHost(s);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void shutdownOutput()
        {
            if (hasConnection())
            {
                wrappedConnection.shutdownOutput();
            }
        }

        public void tunnelCreated()
            throws IllegalStateException, IOException
        {
            if (hasConnection())
            {
                wrappedConnection.tunnelCreated();
            }
        }

        public void write(byte abyte0[])
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.write(abyte0);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.write(abyte0, i, j);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void writeLine()
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.writeLine();
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public void writeLine(byte abyte0[])
            throws IOException, IllegalStateException
        {
            if (hasConnection())
            {
                wrappedConnection.writeLine(abyte0);
                return;
            } else
            {
                throw new IllegalStateException("Connection has been released");
            }
        }

        public HttpConnectionAdapter(HttpConnection httpconnection)
        {
            super(httpconnection.getHost(), httpconnection.getPort(), httpconnection.getProtocol());
            wrappedConnection = httpconnection;
        }
    }

    private static class HttpConnectionWithReference extends HttpConnection
    {

        public WeakReference reference;

        public HttpConnectionWithReference(HostConfiguration hostconfiguration)
        {
            super(hostconfiguration);
            reference = new WeakReference(this, MultiThreadedHttpConnectionManager.REFERENCE_QUEUE);
        }
    }

    private static class ReferenceQueueThread extends Thread
    {

        private volatile boolean shutdown;

        private void handleReference(Reference reference)
        {
            synchronized (MultiThreadedHttpConnectionManager.REFERENCE_TO_CONNECTION_SOURCE)
            {
                reference = (ConnectionSource)MultiThreadedHttpConnectionManager.REFERENCE_TO_CONNECTION_SOURCE.remove(reference);
            }
            if (reference != null)
            {
                if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled())
                {
                    MultiThreadedHttpConnectionManager.LOG.debug("Connection reclaimed by garbage collector, hostConfig=" + ((ConnectionSource) (reference)).hostConfiguration);
                }
                ((ConnectionSource) (reference)).connectionPool.handleLostConnection(((ConnectionSource) (reference)).hostConfiguration);
            }
            return;
            reference;
            map;
            JVM INSTR monitorexit ;
            throw reference;
        }

        public void run()
        {
_L2:
            if (shutdown)
            {
                break; /* Loop/switch isn't completed */
            }
            Reference reference = MultiThreadedHttpConnectionManager.REFERENCE_QUEUE.remove();
            if (reference != null)
            {
                try
                {
                    handleReference(reference);
                }
                catch (InterruptedException interruptedexception)
                {
                    MultiThreadedHttpConnectionManager.LOG.debug("ReferenceQueueThread interrupted", interruptedexception);
                }
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void shutdown()
        {
            shutdown = true;
            interrupt();
        }

        public ReferenceQueueThread()
        {
            shutdown = false;
            setDaemon(true);
            setName("MultiThreadedHttpConnectionManager cleanup");
        }
    }

    private static class WaitingThread
    {

        public HostConnectionPool hostConnectionPool;
        public boolean interruptedByConnectionPool;
        public Thread thread;

        private WaitingThread()
        {
            interruptedByConnectionPool = false;
        }

    }


    private static WeakHashMap ALL_CONNECTION_MANAGERS = new WeakHashMap();
    public static final int DEFAULT_MAX_HOST_CONNECTIONS = 2;
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;
    private static final Log LOG;
    private static final ReferenceQueue REFERENCE_QUEUE = new ReferenceQueue();
    private static ReferenceQueueThread REFERENCE_QUEUE_THREAD;
    private static final Map REFERENCE_TO_CONNECTION_SOURCE = new HashMap();
    static Class class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager;
    private ConnectionPool connectionPool;
    private HttpConnectionManagerParams params;
    private volatile boolean shutdown;

    public MultiThreadedHttpConnectionManager()
    {
        params = new HttpConnectionManagerParams();
        shutdown = false;
        connectionPool = new ConnectionPool();
        synchronized (ALL_CONNECTION_MANAGERS)
        {
            ALL_CONNECTION_MANAGERS.put(this, null);
        }
        return;
        exception;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private HostConfiguration configurationForConnection(HttpConnection httpconnection)
    {
        HostConfiguration hostconfiguration = new HostConfiguration();
        hostconfiguration.setHost(httpconnection.getHost(), httpconnection.getPort(), httpconnection.getProtocol());
        if (httpconnection.getLocalAddress() != null)
        {
            hostconfiguration.setLocalAddress(httpconnection.getLocalAddress());
        }
        if (httpconnection.getProxyHost() != null)
        {
            hostconfiguration.setProxy(httpconnection.getProxyHost(), httpconnection.getProxyPort());
        }
        return hostconfiguration;
    }

    private HttpConnection doGetConnection(HostConfiguration hostconfiguration, long l)
        throws ConnectionPoolTimeoutException
    {
        HttpConnection httpconnection;
        int i;
        int j;
        httpconnection = null;
        i = params.getMaxConnectionsPerHost(hostconfiguration);
        j = params.getMaxTotalConnections();
        ConnectionPool connectionpool = connectionPool;
        connectionpool;
        JVM INSTR monitorenter ;
        HostConfiguration hostconfiguration1 = new HostConfiguration(hostconfiguration);
        HostConnectionPool hostconnectionpool = connectionPool.getHostPool(hostconfiguration1, true);
        Exception exception;
        Object obj;
        Object obj1;
        InterruptedException interruptedexception;
        WaitingThread waitingthread;
        boolean flag;
        long l1;
        long l2;
        long l3;
        long l4;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l4 = l;
        l = 0L;
        hostconfiguration = null;
          goto _L1
_L18:
        if (httpconnection != null) goto _L3; else goto _L2
_L2:
        if (shutdown)
        {
            throw new IllegalStateException("Connection factory has been shutdown.");
        }
          goto _L4
        hostconfiguration;
_L14:
        connectionpool;
        JVM INSTR monitorexit ;
        throw hostconfiguration;
_L4:
        if (hostconnectionpool.freeConnections.size() > 0)
        {
            httpconnection = connectionPool.getFreeConnection(hostconfiguration1);
            continue; /* Loop/switch isn't completed */
        }
        if (hostconnectionpool.numConnections < i && connectionPool.numConnections < j)
        {
            httpconnection = connectionPool.createConnection(hostconfiguration1);
            continue; /* Loop/switch isn't completed */
        }
        if (hostconnectionpool.numConnections < i && connectionPool.freeConnections.size() > 0)
        {
            connectionPool.deleteLeastUsedConnection();
            httpconnection = connectionPool.createConnection(hostconfiguration1);
            continue; /* Loop/switch isn't completed */
        }
        if (!flag || l4 > 0L) goto _L6; else goto _L5
_L5:
        throw new ConnectionPoolTimeoutException("Timeout waiting for connection");
        interruptedexception;
_L16:
        l2 = l;
        obj = hostconfiguration;
        if (((WaitingThread) (hostconfiguration)).interruptedByConnectionPool) goto _L8; else goto _L7
_L7:
        l2 = l;
        obj = hostconfiguration;
        LOG.debug("Interrupted while waiting for connection", interruptedexception);
        l2 = l;
        obj = hostconfiguration;
        throw new IllegalThreadStateException("Interrupted while waiting in MultiThreadedHttpConnectionManager");
        hostconfiguration;
        l = l2;
_L15:
        if (!((WaitingThread) (obj)).interruptedByConnectionPool)
        {
            hostconnectionpool.waitingThreads.remove(obj);
            connectionPool.waitingThreads.remove(obj);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        System.currentTimeMillis();
        throw hostconfiguration;
_L6:
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Unable to get a connection, waiting..., hostConfig=" + hostconfiguration1);
        }
        if (hostconfiguration != null) goto _L10; else goto _L9
_L9:
        waitingthread = new WaitingThread();
        l2 = l;
        obj = waitingthread;
        l3 = l;
        obj1 = waitingthread;
        waitingthread.hostConnectionPool = hostconnectionpool;
        l2 = l;
        obj = waitingthread;
        l3 = l;
        obj1 = waitingthread;
        waitingthread.thread = Thread.currentThread();
        hostconfiguration = waitingthread;
_L11:
        l1 = l;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        l2 = l;
        obj = hostconfiguration;
        l3 = l;
        obj1 = hostconfiguration;
        l1 = System.currentTimeMillis();
        l2 = l1;
        obj = hostconfiguration;
        l3 = l1;
        obj1 = hostconfiguration;
        hostconnectionpool.waitingThreads.addLast(hostconfiguration);
        l2 = l1;
        obj = hostconfiguration;
        l3 = l1;
        obj1 = hostconfiguration;
        connectionPool.waitingThreads.addLast(hostconfiguration);
        l2 = l1;
        obj = hostconfiguration;
        l3 = l1;
        obj1 = hostconfiguration;
        connectionPool.wait(l4);
        if (!((WaitingThread) (hostconfiguration)).interruptedByConnectionPool)
        {
            hostconnectionpool.waitingThreads.remove(hostconfiguration);
            connectionPool.waitingThreads.remove(hostconfiguration);
        }
        l2 = l1;
        l3 = l4;
        obj = hostconfiguration;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_584;
        }
        l = System.currentTimeMillis();
        l3 = l4 - (l - l1);
        obj = hostconfiguration;
        l2 = l1;
_L13:
        hostconfiguration = ((HostConfiguration) (obj));
        l = l2;
        l4 = l3;
        continue; /* Loop/switch isn't completed */
_L10:
        hostconfiguration.interruptedByConnectionPool = false;
          goto _L11
_L8:
        if (!((WaitingThread) (hostconfiguration)).interruptedByConnectionPool)
        {
            hostconnectionpool.waitingThreads.remove(hostconfiguration);
            connectionPool.waitingThreads.remove(hostconfiguration);
        }
        l2 = l;
        l3 = l4;
        obj = hostconfiguration;
        if (!flag) goto _L13; else goto _L12
_L12:
        l3 = l4 - (System.currentTimeMillis() - l);
        l2 = l;
        obj = hostconfiguration;
          goto _L13
_L3:
        connectionpool;
        JVM INSTR monitorexit ;
        return httpconnection;
        hostconfiguration;
          goto _L14
        exception;
        obj = hostconfiguration;
        hostconfiguration = exception;
          goto _L15
        waitingthread;
        l = l3;
        hostconfiguration = ((HostConfiguration) (obj1));
          goto _L16
_L1:
        if (true) goto _L18; else goto _L17
_L17:
    }

    private static void removeReferenceToConnection(HttpConnectionWithReference httpconnectionwithreference)
    {
        synchronized (REFERENCE_TO_CONNECTION_SOURCE)
        {
            REFERENCE_TO_CONNECTION_SOURCE.remove(httpconnectionwithreference.reference);
        }
        return;
        httpconnectionwithreference;
        map;
        JVM INSTR monitorexit ;
        throw httpconnectionwithreference;
    }

    public static void shutdownAll()
    {
        Map map = REFERENCE_TO_CONNECTION_SOURCE;
        map;
        JVM INSTR monitorenter ;
        WeakHashMap weakhashmap = ALL_CONNECTION_MANAGERS;
        weakhashmap;
        JVM INSTR monitorenter ;
        MultiThreadedHttpConnectionManager amultithreadedhttpconnectionmanager[] = (MultiThreadedHttpConnectionManager[])(MultiThreadedHttpConnectionManager[])ALL_CONNECTION_MANAGERS.keySet().toArray(new MultiThreadedHttpConnectionManager[ALL_CONNECTION_MANAGERS.size()]);
        int i = 0;
_L2:
        if (i >= amultithreadedhttpconnectionmanager.length)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (amultithreadedhttpconnectionmanager[i] == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        amultithreadedhttpconnectionmanager[i].shutdown();
        break MISSING_BLOCK_LABEL_101;
        weakhashmap;
        JVM INSTR monitorexit ;
        if (REFERENCE_QUEUE_THREAD != null)
        {
            REFERENCE_QUEUE_THREAD.shutdown();
            REFERENCE_QUEUE_THREAD = null;
        }
        REFERENCE_TO_CONNECTION_SOURCE.clear();
        map;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void shutdownCheckedOutConnections(ConnectionPool connectionpool)
    {
        ArrayList arraylist = new ArrayList();
        Map map = REFERENCE_TO_CONNECTION_SOURCE;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = REFERENCE_TO_CONNECTION_SOURCE.keySet().iterator();
_L2:
        Object obj;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_104;
                }
                obj = (Reference)iterator.next();
            } while (((ConnectionSource)REFERENCE_TO_CONNECTION_SOURCE.get(obj)).connectionPool != connectionpool);
            iterator.remove();
            obj = (HttpConnection)((Reference) (obj)).get();
        } while (obj == null);
        arraylist.add(obj);
        if (true) goto _L2; else goto _L1
_L1:
        connectionpool;
        map;
        JVM INSTR monitorexit ;
        throw connectionpool;
        map;
        JVM INSTR monitorexit ;
        HttpConnection httpconnection;
        for (connectionpool = arraylist.iterator(); connectionpool.hasNext(); httpconnection.releaseConnection())
        {
            httpconnection = (HttpConnection)connectionpool.next();
            httpconnection.close();
            httpconnection.setHttpConnectionManager(null);
        }

        return;
    }

    private static void storeReferenceToConnection(HttpConnectionWithReference httpconnectionwithreference, HostConfiguration hostconfiguration, ConnectionPool connectionpool)
    {
        ConnectionSource connectionsource = new ConnectionSource();
        connectionsource.connectionPool = connectionpool;
        connectionsource.hostConfiguration = hostconfiguration;
        synchronized (REFERENCE_TO_CONNECTION_SOURCE)
        {
            if (REFERENCE_QUEUE_THREAD == null)
            {
                REFERENCE_QUEUE_THREAD = new ReferenceQueueThread();
                REFERENCE_QUEUE_THREAD.start();
            }
            REFERENCE_TO_CONNECTION_SOURCE.put(httpconnectionwithreference.reference, connectionsource);
        }
        return;
        httpconnectionwithreference;
        hostconfiguration;
        JVM INSTR monitorexit ;
        throw httpconnectionwithreference;
    }

    public void closeIdleConnections(long l)
    {
        connectionPool.closeIdleConnections(l);
        deleteClosedConnections();
    }

    public void deleteClosedConnections()
    {
        connectionPool.deleteClosedConnections();
    }

    public HttpConnection getConnection(HostConfiguration hostconfiguration)
    {
_L2:
        HttpConnection httpconnection = getConnectionWithTimeout(hostconfiguration, 0L);
        return httpconnection;
        ConnectionPoolTimeoutException connectionpooltimeoutexception;
        connectionpooltimeoutexception;
        LOG.debug("Unexpected exception while waiting for connection", connectionpooltimeoutexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public HttpConnection getConnection(HostConfiguration hostconfiguration, long l)
        throws HttpException
    {
        LOG.trace("enter HttpConnectionManager.getConnection(HostConfiguration, long)");
        try
        {
            hostconfiguration = getConnectionWithTimeout(hostconfiguration, l);
        }
        // Misplaced declaration of an exception variable
        catch (HostConfiguration hostconfiguration)
        {
            throw new HttpException(hostconfiguration.getMessage());
        }
        return hostconfiguration;
    }

    public HttpConnection getConnectionWithTimeout(HostConfiguration hostconfiguration, long l)
        throws ConnectionPoolTimeoutException
    {
        LOG.trace("enter HttpConnectionManager.getConnectionWithTimeout(HostConfiguration, long)");
        if (hostconfiguration == null)
        {
            throw new IllegalArgumentException("hostConfiguration is null");
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("HttpConnectionManager.getConnection:  config = " + hostconfiguration + ", timeout = " + l);
        }
        return new HttpConnectionAdapter(doGetConnection(hostconfiguration, l));
    }

    public int getConnectionsInPool()
    {
        int i;
        synchronized (connectionPool)
        {
            i = connectionPool.numConnections;
        }
        return i;
        exception;
        connectionpool;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getConnectionsInPool(HostConfiguration hostconfiguration)
    {
        int i = 0;
        ConnectionPool connectionpool = connectionPool;
        connectionpool;
        JVM INSTR monitorenter ;
        hostconfiguration = connectionPool.getHostPool(hostconfiguration, false);
        if (hostconfiguration == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        i = ((HostConnectionPool) (hostconfiguration)).numConnections;
        connectionpool;
        JVM INSTR monitorexit ;
        return i;
        hostconfiguration;
        connectionpool;
        JVM INSTR monitorexit ;
        throw hostconfiguration;
    }

    public int getConnectionsInUse()
    {
        return getConnectionsInPool();
    }

    public int getConnectionsInUse(HostConfiguration hostconfiguration)
    {
        return getConnectionsInPool(hostconfiguration);
    }

    public int getMaxConnectionsPerHost()
    {
        return params.getDefaultMaxConnectionsPerHost();
    }

    public int getMaxTotalConnections()
    {
        return params.getMaxTotalConnections();
    }

    public HttpConnectionManagerParams getParams()
    {
        return params;
    }

    public boolean isConnectionStaleCheckingEnabled()
    {
        return params.isStaleCheckingEnabled();
    }

    public void releaseConnection(HttpConnection httpconnection)
    {
        LOG.trace("enter HttpConnectionManager.releaseConnection(HttpConnection)");
        HttpConnection httpconnection1 = httpconnection;
        if (httpconnection instanceof HttpConnectionAdapter)
        {
            httpconnection1 = ((HttpConnectionAdapter)httpconnection).getWrappedConnection();
        }
        SimpleHttpConnectionManager.finishLastResponse(httpconnection1);
        connectionPool.freeConnection(httpconnection1);
    }

    public void setConnectionStaleCheckingEnabled(boolean flag)
    {
        params.setStaleCheckingEnabled(flag);
    }

    public void setMaxConnectionsPerHost(int i)
    {
        params.setDefaultMaxConnectionsPerHost(i);
    }

    public void setMaxTotalConnections(int i)
    {
        params.setMaxTotalConnections(i);
    }

    public void setParams(HttpConnectionManagerParams httpconnectionmanagerparams)
    {
        if (httpconnectionmanagerparams == null)
        {
            throw new IllegalArgumentException("Parameters may not be null");
        } else
        {
            params = httpconnectionmanagerparams;
            return;
        }
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        synchronized (connectionPool)
        {
            if (!shutdown)
            {
                shutdown = true;
                connectionPool.shutdown();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        exception1;
        connectionpool;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.MultiThreadedHttpConnectionManager");
            class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager;
        }
        LOG = LogFactory.getLog(class1);
    }









}
