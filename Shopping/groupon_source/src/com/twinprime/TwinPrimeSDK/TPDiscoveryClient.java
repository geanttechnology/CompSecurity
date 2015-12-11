// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import com.twinprime.msgpack.MessageTypeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLog, XcpMsgDiscReq, TwinPrimeSDKPvt, XcpMsgUtils, 
//            XcpMsgDiscRep

class TPDiscoveryClient
{
    static final class TPDiscState extends Enum
    {

        private static final TPDiscState $VALUES[];
        public static final TPDiscState TPSDK_DISC_COMPLETE_SUCCESS;
        public static final TPDiscState TPSDK_DISC_ERR;
        public static final TPDiscState TPSDK_DISC_FATAL_ERR;
        public static final TPDiscState TPSDK_DISC_INIT;
        public static final TPDiscState TPSDK_DISC_SENT;

        public static TPDiscState valueOf(String s)
        {
            return (TPDiscState)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPDiscoveryClient$TPDiscState, s);
        }

        public static TPDiscState[] values()
        {
            return (TPDiscState[])$VALUES.clone();
        }

        static 
        {
            TPSDK_DISC_INIT = new TPDiscState("TPSDK_DISC_INIT", 0);
            TPSDK_DISC_SENT = new TPDiscState("TPSDK_DISC_SENT", 1);
            TPSDK_DISC_COMPLETE_SUCCESS = new TPDiscState("TPSDK_DISC_COMPLETE_SUCCESS", 2);
            TPSDK_DISC_ERR = new TPDiscState("TPSDK_DISC_ERR", 3);
            TPSDK_DISC_FATAL_ERR = new TPDiscState("TPSDK_DISC_FATAL_ERR", 4);
            $VALUES = (new TPDiscState[] {
                TPSDK_DISC_INIT, TPSDK_DISC_SENT, TPSDK_DISC_COMPLETE_SUCCESS, TPSDK_DISC_ERR, TPSDK_DISC_FATAL_ERR
            });
        }

        private TPDiscState(String s, int i)
        {
            super(s, i);
        }
    }


    private static String API_KEY_EXPUNGED = "API_KEY_EXPUNGED";
    private static int DISCO_LISTEN_PORT = 8124;
    private ArrayList accIPAddrList;
    private String apiKey;
    private Context appContext;
    private String cookie;
    private int custId;
    private int discExpirySec;
    private InetAddress discIPAddr;
    private ArrayList discIPAddrList;
    private String discName;
    private boolean isSecured;
    private int nonce;
    private long sessionId;
    private TPDiscState state;

    TPDiscoveryClient(Context context, String s, String s1, int i)
    {
        discIPAddrList = new ArrayList(10);
        accIPAddrList = null;
        apiKey = s;
        discName = s1;
        custId = i;
        isSecured = true;
        appContext = context;
        discIPAddr = null;
        state = TPDiscState.TPSDK_DISC_INIT;
        accIPAddrList = new ArrayList();
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", "Initializing TPDiscovery");
        }
    }

    public static String bytesToHex(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(String.format("%02x", new Object[] {
                Byte.valueOf(abyte0[i])
            }));
        }

        return stringbuilder.toString();
    }

    private InetAddress getNextDiscoveryIP()
    {
        long l = (new Date()).getTime();
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", "getNextDiscoveryIP() starts");
        }
        InetAddress inetaddress = null;
        if (discIPAddrList.size() > 0)
        {
            inetaddress = (InetAddress)discIPAddrList.get(0);
            discIPAddrList.remove(0);
        }
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", (new StringBuilder()).append("getNextDiscoveryIP() ends [").append((new Date()).getTime() - l).append(" ms]").toString());
        }
        return inetaddress;
    }

    private boolean performRequest()
    {
        Object obj;
        Object obj1;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        String s;
        obj6 = null;
        obj7 = null;
        s = null;
        obj1 = null;
        obj3 = obj1;
        obj4 = obj6;
        obj5 = obj7;
        obj = s;
        long l = (new Date()).getTime();
        obj3 = obj1;
        obj4 = obj6;
        obj5 = obj7;
        obj = s;
        obj1 = AndroidHttpClient.newInstance("TwinPrime - 1.18.0.1");
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        Log.d("TPDiscoveryClient", (new StringBuilder()).append("Connecting to ").append(discIPAddr.getHostAddress()).append(":").append(DISCO_LISTEN_PORT).toString());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = new HttpPost((new StringBuilder()).append("http://").append(discIPAddr.getHostAddress()).append(":").append(DISCO_LISTEN_PORT).toString());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        ((HttpPost) (obj6)).setHeader("Content-Type", "xcp/disc-req");
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        HttpConnectionParams.setConnectionTimeout(((AndroidHttpClient) (obj1)).getParams(), 5000);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        HttpConnectionParams.setConnectionTimeout(((AndroidHttpClient) (obj1)).getParams(), 5000);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        HttpConnectionParams.setTcpNoDelay(((AndroidHttpClient) (obj1)).getParams(), true);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7 = new XcpMsgDiscReq();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.app_id = appContext.getPackageName();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.api_key = apiKey;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.app_guid = TwinPrimeSDKPvt.getInstance().getAppGuid();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        (new Random()).nextInt(0x77359400);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        int i = (int)((new Date()).getTime() / 1000L);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.nonce = i;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        nonce = i;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.ts = i;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!isSecured)
        {
            break MISSING_BLOCK_LABEL_602;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.cust_id = custId;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        s = (new StringBuilder()).append(((XcpMsgDiscReq) (obj7)).api_key).append("-").append(((XcpMsgDiscReq) (obj7)).ts).toString();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        messagedigest.update(s.getBytes("UTF-8"));
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.hashed_key = bytesToHex(messagedigest.digest());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7.api_key = "0";
_L10:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_644;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        Log.d("TPDiscoveryClient", ((XcpMsgDiscReq) (obj7)).toString());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        ((HttpPost) (obj6)).setEntity(new ByteArrayEntity(((XcpMsgDiscReq) (obj7)).getMessage()));
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        state = TPDiscState.TPSDK_DISC_SENT;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = ((AndroidHttpClient) (obj1)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj6)));
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7 = ((HttpResponse) (obj6)).getStatusLine();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (((StatusLine) (obj7)).getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj7 = new ByteArrayOutputStream(50000);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        byte abyte0[] = new byte[5000];
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = ((HttpResponse) (obj6)).getEntity().getContent();
_L4:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        i = ((InputStream) (obj6)).read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        ((ByteArrayOutputStream) (obj7)).write(abyte0, 0, i);
        if (true) goto _L4; else goto _L3
        obj1;
        obj = obj3;
        if (!TPLog.LOG10.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_879;
        }
        obj = obj3;
        ((IOException) (obj1)).printStackTrace();
        if (obj3 != null)
        {
            ((AndroidHttpClient) (obj3)).close();
        }
_L8:
        boolean flag;
        state = TPDiscState.TPSDK_DISC_ERR;
        flag = false;
_L6:
        return flag;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG10.isLoggable("TPDiscoveryClient"))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        Log.d("TPDiscoveryClient", (new StringBuilder()).append("NoSuchAlgorithmException ").append(nosuchalgorithmexception.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        obj1;
        obj = obj4;
        if (!TPLog.LOG10.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_988;
        }
        obj = obj4;
        ((ClassCastException) (obj1)).printStackTrace();
        if (obj4 != null)
        {
            ((AndroidHttpClient) (obj4)).close();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = (XcpMsgDiscRep)XcpMsgUtils.getInstance().getXcpObjForBytes(((ByteArrayOutputStream) (obj7)).toByteArray());
        if (obj6 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_1074;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        Log.d("TPDiscoveryClient", ((XcpMsgDiscRep) (obj6)).toString());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        connectToDisc(((XcpMsgDiscRep) (obj6)));
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_1164;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        Log.d("TPDiscoveryClient", (new StringBuilder()).append("connect ends [").append((new Date()).getTime() - l).append(" ms]").toString());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        state = TPDiscState.TPSDK_DISC_COMPLETE_SUCCESS;
        flag = true;
        if (obj1 != null)
        {
            ((AndroidHttpClient) (obj1)).close();
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG10.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_1284;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        Log.d("TPDiscoveryClient", (new StringBuilder()).append("HTTP request [http://").append(discIPAddr.getHostAddress()).append(":").append(DISCO_LISTEN_PORT).append(" rcvd response code of : ").append(((StatusLine) (obj7)).getStatusCode()).toString());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (((StatusLine) (obj7)).getStatusCode() == 401)
        {
            break MISSING_BLOCK_LABEL_1330;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (((StatusLine) (obj7)).getStatusCode() != 400)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!TPLog.LOG1.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_1372;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        TPLog.LOG1.e("TPDiscoveryClient", "Discovery: Invalid key");
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        state = TPDiscState.TPSDK_DISC_FATAL_ERR;
        flag = false;
        if (obj1 != null)
        {
            ((AndroidHttpClient) (obj1)).close();
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (obj1 != null)
        {
            ((AndroidHttpClient) (obj1)).close();
        }
        continue; /* Loop/switch isn't completed */
        Object obj2;
        obj2;
        obj = obj5;
        if (!TPLog.LOG10.isLoggable("TPDiscoveryClient"))
        {
            break MISSING_BLOCK_LABEL_1435;
        }
        obj = obj5;
        ((MessageTypeException) (obj2)).printStackTrace();
        if (obj5 != null)
        {
            ((AndroidHttpClient) (obj5)).close();
        }
        if (true) goto _L8; else goto _L7
_L7:
        obj2;
        if (obj != null)
        {
            ((AndroidHttpClient) (obj)).close();
        }
        throw obj2;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void resolveWithGetAddrInfo(String s)
    {
        Object obj;
        long l;
        obj = null;
        l = (new Date()).getTime();
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", "resolveWithGetAddrInfo starts");
        }
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        InetAddress ainetaddress[];
        int j;
        ainetaddress = InetAddress.getAllByName(s);
        j = ainetaddress.length;
        int i = 0;
_L7:
        InetAddress inetaddress = obj;
        if (i >= j) goto _L2; else goto _L1
_L1:
        inetaddress = ainetaddress[i];
        boolean flag = InetAddressUtils.isIPv4Address(inetaddress.getHostAddress());
        if (!flag) goto _L3; else goto _L2
_L2:
        if (inetaddress != null)
        {
            discIPAddrList.add(inetaddress);
        }
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", (new StringBuilder()).append("resolveWithGetAddrInfo ends [").append((new Date()).getTime() - l).append(" ms]").toString());
        }
_L5:
        return;
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if (TPLog.LOG10.isLoggable("TPDiscoveryClient"))
        {
            long l1 = (new Date()).getTime();
            Log.d("TPDiscoveryClient", (new StringBuilder()).append("Error geting IP address for ").append(s).append(" (").append(exception.getMessage()).append(") [").append(l1 - l).append(" ms]").toString());
        }
        if (!TPLog.LOG1.isLoggable("TPDiscoveryClient")) goto _L5; else goto _L4
_L4:
        TPLog.LOG1.e("TPDiscoveryClient", (new StringBuilder()).append("Error geting IP address for '").append(s).append("'.\nPlease check whether the key is valid and the network connection is up.").toString());
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void connectToDisc(XcpMsgDiscRep xcpmsgdiscrep)
    {
        long l = (new Date()).getTime();
        sessionId = xcpmsgdiscrep.sessionId;
        accIPAddrList.clear();
        if (xcpmsgdiscrep.ipAddrCt == 0 && xcpmsgdiscrep.ipAddrObs != 0L)
        {
            xcpmsgdiscrep.ipAddrCt = 1;
            xcpmsgdiscrep.accIpAddrs = new long[1];
            xcpmsgdiscrep.accIpAddrs[0] = xcpmsgdiscrep.ipAddrObs;
        }
        int i = 0;
        do
        {
            if (i >= xcpmsgdiscrep.ipAddrCt)
            {
                break;
            }
            byte abyte0[] = ByteBuffer.allocate(8).putLong(Long.reverseBytes(xcpmsgdiscrep.accIpAddrs[i])).array();
            byte abyte1[] = new byte[4];
            for (int j = 0; j < abyte1.length; j++)
            {
                abyte1[j] = abyte0[j];
            }

            try
            {
                InetAddress inetaddress = InetAddress.getByAddress(abyte1);
                if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
                {
                    Log.d("TPDiscoveryClient", inetaddress.getCanonicalHostName());
                }
                accIPAddrList.add(inetaddress);
            }
            catch (UnknownHostException unknownhostexception)
            {
                if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
                {
                    Log.e("TPDiscoveryClient", unknownhostexception.getLocalizedMessage());
                    unknownhostexception.printStackTrace();
                }
            }
            i++;
        } while (true);
        cookie = xcpmsgdiscrep.cookie;
        discExpirySec = xcpmsgdiscrep.expiry;
        if (TPLog.LOG2.isLoggable("TPDiscoveryClient"))
        {
            TPLog.LOG2.i("TPDiscoveryClient", "Discovery: Completed");
        }
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", (new StringBuilder()).append("connectToDisc [").append((new Date()).getTime() - l).append(" ms]").toString());
        }
    }

    void discover()
    {
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", (new StringBuilder()).append("connect [").append(state).append("]").toString());
        }
        if (discIPAddrList.isEmpty())
        {
            resolveWithGetAddrInfo(discName);
        }
        state = TPDiscState.TPSDK_DISC_INIT;
_L4:
        InetAddress inetaddress = getNextDiscoveryIP();
        if (inetaddress == null) goto _L2; else goto _L1
_L1:
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", (new StringBuilder()).append("Trying new discovery host: ").append(inetaddress).toString());
        }
        discIPAddr = inetaddress;
        performRequest();
        if (state != TPDiscState.TPSDK_DISC_COMPLETE_SUCCESS) goto _L4; else goto _L3
_L3:
        apiKey = API_KEY_EXPUNGED;
        return;
_L2:
        if (TPLog.LOG13.isLoggable("TPDiscoveryClient"))
        {
            Log.d("TPDiscoveryClient", "Failed to discover");
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    ArrayList getAccIPAddrList()
    {
        return accIPAddrList;
    }

    public String getCookie()
    {
        return cookie;
    }

    protected TPDiscState getDiscoveryState()
    {
        return state;
    }

    public int getExpiry()
    {
        return discExpirySec;
    }

    int getNonce()
    {
        return nonce;
    }

    long getSessionId()
    {
        return sessionId;
    }

}
