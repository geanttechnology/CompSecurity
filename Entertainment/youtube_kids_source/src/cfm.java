// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class cfm
    implements cfu
{

    private static final List a;
    private static final String b = cfm.getCanonicalName();
    private static Pattern c = Pattern.compile("^(.+?): (.+)$");
    private static final InetAddress d = d();
    private final ScheduledExecutorService e = Executors.newScheduledThreadPool(3);
    private final cff f;
    private final Set g = new HashSet();
    private final Map h = new ConcurrentHashMap();
    private final Set i = new HashSet();
    private final Map j = new HashMap();
    private final List k = new ArrayList();
    private final boolean l;
    private final boolean m;
    private boolean n;

    public cfm(boolean flag, boolean flag1, boolean flag2)
    {
        f = new cfh(flag2);
        l = flag;
        m = flag1;
    }

    private cgw a(HttpResponse httpresponse, Map map)
    {
        String s;
        int i1;
        i1 = 0;
        Header aheader[] = httpresponse.getHeaders("Application-URL");
        if (aheader.length != 1)
        {
            Log.w(b, "Expected one Application-URL header. Found 0 or more");
            return null;
        }
        s = aheader[0].getValue();
        Object obj;
        byte abyte0[];
        httpresponse = httpresponse.getEntity().getContent();
        obj = new ByteArrayOutputStream();
        abyte0 = new byte[512];
_L1:
        int j1 = httpresponse.read(abyte0);
label0:
        {
            if (j1 == -1)
            {
                break label0;
            }
            try
            {
                ((ByteArrayOutputStream) (obj)).write(abyte0, 0, j1);
            }
            // Misplaced declaration of an exception variable
            catch (HttpResponse httpresponse)
            {
                Log.w(b, "Error parsing device description response: ", httpresponse);
                return null;
            }
        }
          goto _L1
        httpresponse = ((ByteArrayOutputStream) (obj)).toByteArray();
        obj = DocumentBuilderFactory.newInstance();
        ((DocumentBuilderFactory) (obj)).setNamespaceAware(true);
        obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder().parse(new ByteArrayInputStream(httpresponse)).getDocumentElement().getElementsByTagName("device");
        httpresponse = new cgy();
        if (((NodeList) (obj)).getLength() != 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        Log.w(b, "No devices found in device description XML.");
        return null;
        cgt cgt1;
        Element element = (Element)((NodeList) (obj)).item(0);
        obj = a(element, "friendlyName", "urn:schemas-upnp-org:device-1-0");
        httpresponse.c = ((String) (obj));
        cgt1 = new cgt(a(element, "UDN", "urn:schemas-upnp-org:device-1-0"));
        httpresponse.g = cgt1;
        httpresponse.e = a(element, "manufacturer", "urn:schemas-upnp-org:device-1-0");
        httpresponse.f = a(element, "modelName", "urn:schemas-upnp-org:device-1-0");
        if (s == null) goto _L3; else goto _L2
_L2:
        httpresponse.d = true;
        httpresponse.b = Uri.parse(s).buildUpon().appendPath("YouTube").build();
        if (!l) goto _L5; else goto _L4
_L4:
        map = (String)map.get("WAKEUP");
        if (map == null) goto _L5; else goto _L6
_L6:
        map = map.split(";");
        j1 = map.length;
_L13:
        if (i1 >= j1) goto _L5; else goto _L7
_L7:
        s = map[i1];
        if (!s.startsWith("MAC=")) goto _L9; else goto _L8
_L8:
        s = s.substring(4);
        httpresponse.h = s;
        String s1 = b;
        s1 = String.valueOf(cgt1);
        (new StringBuilder(String.valueOf(obj).length() + 41 + String.valueOf(s1).length() + String.valueOf(s).length())).append("Found wake-up MAC address for ").append(((String) (obj))).append(" with id ").append(s1).append(": ").append(s);
          goto _L10
_L9:
        boolean flag = s.startsWith("Timeout=");
        if (!flag) goto _L10; else goto _L11
_L11:
        s = s.substring(8);
        httpresponse.i = Integer.valueOf(Integer.parseInt(s));
        String s2 = b;
        (new StringBuilder(String.valueOf(obj).length() + 28 + String.valueOf(s).length())).append("Found wake-up timeout for ").append(((String) (obj))).append(": ").append(s);
          goto _L10
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.w(b, "Unable to parse wake-up timeout value: ", numberformatexception);
          goto _L10
_L3:
        httpresponse.d = false;
_L5:
        httpresponse = httpresponse.a();
        return httpresponse;
_L10:
        i1++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private static String a(Element element, String s, String s1)
    {
        element = element.getChildNodes();
        for (int i1 = 0; i1 < element.getLength(); i1++)
        {
            Node node = element.item(i1);
            if ((node instanceof Element) && s.equals(node.getLocalName()) && s1.equals(node.getNamespaceURI()))
            {
                return node.getTextContent();
            }
        }

        return null;
    }

    static DatagramPacket a(String s)
    {
        return c(s);
    }

    private static InetAddress a(NetworkInterface networkinterface)
    {
        networkinterface = networkinterface.getInetAddresses();
        if (networkinterface == null)
        {
            return null;
        }
        while (networkinterface.hasMoreElements()) 
        {
            InetAddress inetaddress = (InetAddress)networkinterface.nextElement();
            if (inetaddress instanceof Inet4Address)
            {
                return inetaddress;
            }
        }
        return null;
    }

    protected static List a()
    {
        Object obj;
        NetworkInterface networkinterface;
        boolean flag;
        Object obj1;
        boolean flag1;
        try
        {
            obj1 = Collections.list(NetworkInterface.getNetworkInterfaces());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(b, "Error retrieving local interfaces", ((Throwable) (obj)));
            return Collections.emptyList();
        }
        obj = new ArrayList();
        obj1 = ((List) (obj1)).iterator();
_L4:
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        networkinterface = (NetworkInterface)((Iterator) (obj1)).next();
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        InetAddress inetaddress;
        SocketException socketexception;
        boolean flag2;
        if (!networkinterface.isLoopback() && !networkinterface.isPointToPoint())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = networkinterface.getInetAddresses().hasMoreElements();
        if (flag1 && a(networkinterface) != null)
        {
            ((List) (obj)).add(networkinterface);
        }
        continue; /* Loop/switch isn't completed */
        inetaddress = a(networkinterface);
        if (inetaddress == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        flag2 = inetaddress.equals(d);
        if (flag2)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_161;
_L2:
        break MISSING_BLOCK_LABEL_66;
        socketexception;
        Log.e(b, String.format("Could not read interface type for %s", new Object[] {
            networkinterface.getDisplayName()
        }), socketexception);
        if (true) goto _L4; else goto _L3
_L3:
        return ((List) (obj));
    }

    static List a(cfm cfm1)
    {
        return cfm1.k;
    }

    static void a(cfm cfm1, String s, Map map)
    {
        HttpClient httpclient = a.A();
        HttpGet httpget = new HttpGet(s);
        httpget.setHeader("Origin", "package:com.google.android.youtube");
        try
        {
            map = cfm1.a(httpclient.execute(httpget), map);
        }
        // Misplaced declaration of an exception variable
        catch (cfm cfm1)
        {
            Log.e(b, String.format("Timed out reading device details at %s failed", new Object[] {
                s
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (cfm cfm1)
        {
            Log.e(b, String.format("Reading device details at %s failed: %s", new Object[] {
                s, cfm1.getMessage()
            }));
            return;
        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        cfm1.a(s, ((cgw) (map)));
    }

    static void a(cfm cfm1, DatagramSocket datagramsocket, List list)
    {
        ArrayList arraylist;
        byte abyte0[];
        int i1;
        i1 = 2000;
        abyte0 = new byte[1024];
        arraylist = new ArrayList();
_L2:
        Object obj = new DatagramPacket(abyte0, 1024);
        datagramsocket.setSoTimeout(i1);
        boolean flag;
        long l1;
        l1 = System.currentTimeMillis();
        flag = true;
        datagramsocket.receive(((DatagramPacket) (obj)));
_L5:
        i1 -= (int)(System.currentTimeMillis() - l1);
        int j1 = i1;
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (flag)
        {
            obj = b(new String(((DatagramPacket) (obj)).getData(), 0, ((DatagramPacket) (obj)).getLength()));
            if (list.contains(((Map) (obj)).get("ST")))
            {
                Object obj1 = (String)((Map) (obj)).get("LOCATION");
                long l2;
                long l3;
                if (obj1 != null)
                {
                    if (cfm1.j.containsKey(obj1))
                    {
                        cfm1.a(((String) (obj1)), (cgw)cfm1.j.get(obj1));
                    } else
                    {
                        arraylist.add(cfm1.e.submit(new cfn(cfm1, ((String) (obj1)), ((Map) (obj)))));
                    }
                }
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        cfm1;
        Log.w(b, "Error setting socket timeout", cfm1);
        j1 = i1;
_L4:
        cfm1 = arraylist.iterator();
        l2 = 7300L;
_L3:
        if (!cfm1.hasNext())
        {
            break MISSING_BLOCK_LABEL_340;
        }
        datagramsocket = (Future)cfm1.next();
        l3 = System.currentTimeMillis();
        datagramsocket.get(j1, TimeUnit.MILLISECONDS);
        l3 = Math.max(0L, l2 - (System.currentTimeMillis() - l3));
        l2 = l3;
          goto _L3
        cfm1;
        j1 = i1;
          goto _L4
        obj1;
        Log.w(b, "Error receiving m search response packet", ((Throwable) (obj1)));
        flag = false;
          goto _L5
        cfm1;
        Log.w(b, "Read device response task cancelled while waiting for reading device details task to complete");
        a(((List) (arraylist)));
        return;
        datagramsocket;
        Log.e(b, "Error waiting for reading device details task to complete", datagramsocket);
          goto _L3
        datagramsocket;
        Log.e(b, "Timed out whilst reading device details");
          goto _L3
    }

    private void a(String s, cgw cgw1)
    {
        int i1 = 1;
        this;
        JVM INSTR monitorenter ;
        if (g.contains(cgw1.g)) goto _L2; else goto _L1
_L1:
        g.add(cgw1.g);
        if (cgw1.d) goto _L4; else goto _L3
_L3:
        cgw1 = null;
_L7:
        if (cgw1 == null) goto _L2; else goto _L5
_L5:
        h.put(cgw1, Boolean.TRUE);
        for (Iterator iterator = i.iterator(); iterator.hasNext(); ((cfv)iterator.next()).a(cgw1)) { }
          goto _L6
        s;
        throw s;
_L4:
        cfy cfy1;
        cfy1 = f.a(cgw1.b);
        if (cfy1.c != -2 && cfy1.c != -1)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        String s1 = b;
        cgw1 = String.valueOf(cgw1.c);
        i1 = cfy1.c;
        Log.e(s1, (new StringBuilder(String.valueOf(cgw1).length() + 33)).append("Dropping TV: ").append(cgw1).append(" status: ").append(i1).toString());
        cgw1 = null;
          goto _L7
        if (!m)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        if (!cfy1.f) goto _L9; else goto _L8
_L8:
        String s2 = b;
_L12:
        if (i1 == 0) goto _L11; else goto _L10
_L10:
        String s3 = b;
        cgw1 = String.valueOf(cgw1.c);
        i1 = cfy1.c;
        (new StringBuilder(String.valueOf(cgw1).length() + 33)).append("Ignoring TV: ").append(cgw1).append(" status: ").append(i1);
        cgw1 = null;
          goto _L7
_L9:
        if (cgw1.e == null || !cgw1.e.equals("Google Inc.") || cgw1.f == null || !cgw1.f.equals("Eureka Dongle"))
        {
            break MISSING_BLOCK_LABEL_378;
        }
        String s4 = b;
          goto _L12
_L11:
        cgw1 = new cgy(cgw1);
        cgw1.a = cfy1;
        cgw1 = cgw1.a();
          goto _L7
_L6:
        j.put(s, cgw1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        i1 = 0;
          goto _L12
    }

    private static void a(List list)
    {
        for (list = list.iterator(); list.hasNext(); ((Future)list.next()).cancel(true)) { }
    }

    static boolean a(cfm cfm1, boolean flag)
    {
        cfm1.n = false;
        return false;
    }

    static String b()
    {
        return b;
    }

    private static MulticastSocket b(NetworkInterface networkinterface)
    {
        MulticastSocket multicastsocket;
        try
        {
            multicastsocket = new MulticastSocket();
            multicastsocket.setNetworkInterface(networkinterface);
            multicastsocket.setReceiveBufferSize(0x40000);
            multicastsocket.setBroadcast(true);
        }
        catch (IOException ioexception)
        {
            Log.w(b, String.format("Error creating socket on interface %s", new Object[] {
                networkinterface.getDisplayName()
            }), ioexception);
            return null;
        }
        return multicastsocket;
    }

    static Map b(cfm cfm1)
    {
        return cfm1.j;
    }

    private static Map b(String s)
    {
        HashMap hashmap = new HashMap();
        s = new Scanner(s);
        do
        {
            if (!s.hasNextLine())
            {
                break;
            }
            Object obj = s.nextLine();
            obj = c.matcher(((CharSequence) (obj)));
            if (((Matcher) (obj)).matches())
            {
                hashmap.put(((Matcher) (obj)).group(1).toUpperCase(Locale.US), ((Matcher) (obj)).group(2));
            }
        } while (true);
        s.close();
        return hashmap;
    }

    private static DatagramPacket c(String s)
    {
        InetAddress inetaddress;
        String s1;
        String s2;
        try
        {
            inetaddress = InetAddress.getByName("239.255.255.250");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        s1 = String.valueOf("M-SEARCH * HTTP/1.1\r\nHOST: ");
        s2 = String.valueOf(inetaddress.getHostAddress());
        s = (new StringBuilder(String.valueOf(s1).length() + 61 + String.valueOf(s2).length() + String.valueOf(s).length())).append(s1).append(s2).append(":1900").append("\r\nMAN: \"ssdp:discover\"\r\n").append("MX: 1").append("\r\nST: ").append(s).append("\r\n\r\n").toString().getBytes();
        return new DatagramPacket(s, s.length, inetaddress, 1900);
    }

    static List c()
    {
        return a;
    }

    static Map c(cfm cfm1)
    {
        return cfm1.h;
    }

    private static InetAddress d()
    {
        InetAddress inetaddress;
        try
        {
            inetaddress = InetAddress.getByName("127.0.0.1");
        }
        catch (UnknownHostException unknownhostexception)
        {
            return null;
        }
        return inetaddress;
    }

    static Set d(cfm cfm1)
    {
        return cfm1.g;
    }

    static Set e(cfm cfm1)
    {
        return cfm1.i;
    }

    static void f(cfm cfm1)
    {
label0:
        {
            Object obj = a();
            if (!((List) (obj)).isEmpty())
            {
                cfm1.k.clear();
                cfm1.j.clear();
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    MulticastSocket multicastsocket = b((NetworkInterface)((Iterator) (obj)).next());
                    if (multicastsocket != null)
                    {
                        for (Iterator iterator = a.iterator(); iterator.hasNext();)
                        {
                            String s = (String)iterator.next();
                            int i1 = 0;
                            while (i1 < 3) 
                            {
                                cfm1.e.schedule(new cfo(cfm1, s, multicastsocket), i1 * 300, TimeUnit.MILLISECONDS);
                                i1++;
                            }
                        }

                        cfm1.k.add(cfm1.e.submit(new cfp(cfm1, multicastsocket)));
                    }
                } while (true);
                if (cfm1.k.isEmpty())
                {
                    break label0;
                }
                cfm1.e.schedule(new cfq(cfm1), 2L, TimeUnit.SECONDS);
            }
            return;
        }
        cfm1.n = false;
    }

    public final void a(cfv cfv1)
    {
        if (e.isShutdown())
        {
            Log.e(b, "Can not call find after stopSearch. Bye!");
        } else
        {
            i.add(cfv1);
            if (n)
            {
                Iterator iterator = h.keySet().iterator();
                while (iterator.hasNext()) 
                {
                    cfv1.a((cgw)iterator.next());
                }
            } else
            {
                n = true;
                e.execute(new cfr(this));
                return;
            }
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList(1);
        for (int i1 = 0; i1 <= 0; i1++)
        {
            arraylist.add((new String[] {
                "urn:dial-multiscreen-org:service:dial:1"
            })[0]);
        }

        a = Collections.unmodifiableList(arraylist);
    }
}
