// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.message.BasicLineParser;

// Referenced classes of package com.codebutler.android_websockets:
//            HybiParser

public class WebSocketClient
{
    public static interface Listener
    {

        public abstract void onConnect();

        public abstract void onDisconnect(int i, String s);

        public abstract void onError(Exception exception);

        public abstract void onMessage(String s);

        public abstract void onMessage(byte abyte0[]);
    }


    public static final int FLAG_CONNECTED = 2;
    public static final int FLAG_CONNECTING = 1;
    private static final String TAG = "WebSocketClient";
    private static TrustManager sTrustManagers[];
    private volatile int mConnectionFlag;
    private List mExtraHeaders;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private Listener mListener;
    private HybiParser mParser;
    private final Object mSendLock = new Object();
    private Socket mSocket;
    private Thread mThread;
    private URI mURI;

    public WebSocketClient(URI uri, Listener listener, List list)
    {
        mURI = uri;
        mListener = listener;
        mExtraHeaders = list;
        mParser = new HybiParser(this);
        mHandlerThread = new HandlerThread("websocket-thread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
        mConnectionFlag = 0;
    }

    private String createSecret()
    {
        byte abyte0[] = new byte[16];
        for (int i = 0; i < 16; i++)
        {
            abyte0[i] = (byte)(int)(Math.random() * 256D);
        }

        return Base64.encodeToString(abyte0, 0).trim();
    }

    private String createSecretValidation(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update((new StringBuilder()).append(s).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11").toString().getBytes());
            s = Base64.encodeToString(messagedigest.digest(), 0).trim();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    private SSLSocketFactory getSSLSocketFactory()
        throws NoSuchAlgorithmException, KeyManagementException
    {
        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(null, sTrustManagers, null);
        return sslcontext.getSocketFactory();
    }

    private Header parseHeader(String s)
    {
        return BasicLineParser.parseHeader(s, new BasicLineParser());
    }

    private StatusLine parseStatusLine(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return BasicLineParser.parseStatusLine(s, new BasicLineParser());
        }
    }

    private String readLine(HybiParser.HappyDataInputStream happydatainputstream)
        throws IOException
    {
        int i = happydatainputstream.read();
        if (i == -1)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder("");
        while (i != 10) 
        {
            if (i != 13)
            {
                stringbuilder.append((char)i);
            }
            int j = happydatainputstream.read();
            i = j;
            if (j == -1)
            {
                return null;
            }
        }
        return stringbuilder.toString();
    }

    public static void setTrustManagers(TrustManager atrustmanager[])
    {
        sTrustManagers = atrustmanager;
    }

    public void connect()
    {
        if (mThread != null && mThread.isAlive())
        {
            return;
        } else
        {
            mThread = new Thread(new Runnable() {

                final WebSocketClient this$0;

                public void run()
                {
                    String s;
                    mConnectionFlag = 1;
                    s = createSecret();
                    if (!TextUtils.isEmpty(mURI.getPath()))
                    {
                        break MISSING_BLOCK_LABEL_435;
                    }
                    Object obj = "/";
_L1:
                    Object obj1 = obj;
                    if (!TextUtils.isEmpty(mURI.getQuery()))
                    {
                        obj1 = (new StringBuilder()).append(((String) (obj))).append("?").append(mURI.getQuery()).toString();
                    }
                    URI uri = new URI("https", (new StringBuilder()).append("//").append(mURI.getHost()).toString(), null);
                    obj = getSSLSocketFactory();
                    mSocket = ((SocketFactory) (obj)).createSocket(mURI.getHost(), 443);
                    obj = new PrintWriter(mSocket.getOutputStream());
                    ((PrintWriter) (obj)).print((new StringBuilder()).append("GET ").append(((String) (obj1))).append(" HTTP/1.1\r\n").toString());
                    ((PrintWriter) (obj)).print("Upgrade: websocket\r\n");
                    ((PrintWriter) (obj)).print("Connection: Upgrade\r\n");
                    ((PrintWriter) (obj)).print((new StringBuilder()).append("Host: ").append(mURI.getHost()).append("\r\n").toString());
                    ((PrintWriter) (obj)).print((new StringBuilder()).append("Origin: ").append(uri.toString()).append("\r\n").toString());
                    ((PrintWriter) (obj)).print((new StringBuilder()).append("Sec-WebSocket-Key: ").append(s).append("\r\n").toString());
                    ((PrintWriter) (obj)).print("Sec-WebSocket-Version: 13\r\n");
                    if (mExtraHeaders != null)
                    {
                        NameValuePair namevaluepair;
                        for (obj1 = mExtraHeaders.iterator(); ((Iterator) (obj1)).hasNext(); ((PrintWriter) (obj)).print(String.format("%s: %s\r\n", new Object[] {
                namevaluepair.getName(), namevaluepair.getValue()
            })))
                        {
                            namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
                        }

                    }
                    break MISSING_BLOCK_LABEL_449;
                    obj = mURI.getPath();
                      goto _L1
                    ((PrintWriter) (obj)).print("\r\n");
                    ((PrintWriter) (obj)).flush();
                    obj = new HybiParser.HappyDataInputStream(mSocket.getInputStream());
                    obj1 = parseStatusLine(readLine(((HybiParser.HappyDataInputStream) (obj))));
                    if (obj1 == null)
                    {
                        try
                        {
                            throw new HttpException("Received no reply from server.");
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            Log.d("WebSocketClient", "WebSocket EOF!", ((Throwable) (obj)));
                            mListener.onDisconnect(0, "EOF");
                            mConnectionFlag = 0;
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            Log.d("WebSocketClient", "Websocket SSL error!", ((Throwable) (obj)));
                            mListener.onDisconnect(0, "SSL");
                            mConnectionFlag = 0;
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            mListener.onError(((Exception) (obj)));
                        }
                        break MISSING_BLOCK_LABEL_587;
                    }
                    if (((StatusLine) (obj1)).getStatusCode() != 101)
                    {
                        throw new HttpResponseException(((StatusLine) (obj1)).getStatusCode(), ((StatusLine) (obj1)).getReasonPhrase());
                    }
                    break MISSING_BLOCK_LABEL_597;
                    mConnectionFlag = 0;
                    return;
                    boolean flag = false;
_L3:
                    Object obj2 = readLine(((HybiParser.HappyDataInputStream) (obj)));
                    if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                    {
                        obj2 = parseHeader(((String) (obj2)));
                        if (!((Header) (obj2)).getName().equals("Sec-WebSocket-Accept"))
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                        if (!createSecretValidation(s).equals(((Header) (obj2)).getValue().trim()))
                        {
                            throw new HttpException("Bad Sec-WebSocket-Accept header value.");
                        }
                        break MISSING_BLOCK_LABEL_722;
                    }
                    if (flag)
                    {
                        break MISSING_BLOCK_LABEL_689;
                    }
                    throw new HttpException("No Sec-WebSocket-Accept header.");
                    mConnectionFlag = 2;
                    mListener.onConnect();
                    mParser.start(((HybiParser.HappyDataInputStream) (obj)));
                    return;
                    flag = true;
                    if (true) goto _L3; else goto _L2
_L2:
                }

            
            {
                this$0 = WebSocketClient.this;
                super();
            }
            });
            mThread.start();
            return;
        }
    }

    public void disconnect()
    {
        mConnectionFlag = 0;
        if (mSocket != null)
        {
            mHandler.post(new Runnable() {

                final WebSocketClient this$0;

                public void run()
                {
                    try
                    {
                        mSocket.close();
                        Log.d("RTC", "WebSocket disconnected");
                        mSocket = null;
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        Log.d("WebSocketClient", "Error while disconnecting", ioexception);
                        mListener.onError(ioexception);
                        return;
                    }
                }

            
            {
                this$0 = WebSocketClient.this;
                super();
            }
            });
        }
    }

    public Listener getListener()
    {
        return mListener;
    }

    public boolean isConnected()
    {
        return mSocket != null && (mConnectionFlag & 2) != 0;
    }

    public boolean isConnecting()
    {
        return mSocket != null && (mConnectionFlag & 1) != 0;
    }

    public void send(String s)
    {
        sendFrame(mParser.frame(s));
    }

    public void send(byte abyte0[])
    {
        sendFrame(mParser.frame(abyte0));
    }

    void sendFrame(final byte frame[])
    {
        mHandler.post(new Runnable() {

            final WebSocketClient this$0;
            final byte val$frame[];

            public void run()
            {
                Object obj = mSendLock;
                obj;
                JVM INSTR monitorenter ;
                if (mSocket == null)
                {
                    throw new IOException((new StringBuilder()).append("Socket not connected while trying to write: ").append(Arrays.toString(frame)).toString());
                }
                break MISSING_BLOCK_LABEL_73;
                Exception exception;
                exception;
                obj;
                JVM INSTR monitorexit ;
                try
                {
                    throw exception;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    mListener.onError(((Exception) (obj)));
                }
                return;
                OutputStream outputstream = mSocket.getOutputStream();
                outputstream.write(frame);
                outputstream.flush();
                obj;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = WebSocketClient.this;
                frame = abyte0;
                super();
            }
        });
    }


/*
    static int access$002(WebSocketClient websocketclient, int i)
    {
        websocketclient.mConnectionFlag = i;
        return i;
    }

*/









/*
    static Socket access$402(WebSocketClient websocketclient, Socket socket)
    {
        websocketclient.mSocket = socket;
        return socket;
    }

*/





}
