// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;

public class NanoHTTPD
{
    private class HTTPSession
        implements Runnable
    {

        private Socket mySocket;
        final NanoHTTPD this$0;

        private void decodeHeader(BufferedReader bufferedreader, Properties properties, Properties properties1, Properties properties2)
            throws InterruptedException
        {
            Object obj = bufferedreader.readLine();
            if (obj == null)
            {
                return;
            }
            String s;
            int i;
            obj = new StringTokenizer(((String) (obj)));
            if (!((StringTokenizer) (obj)).hasMoreTokens())
            {
                sendError("400 Bad Request", "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            properties.put("method", ((StringTokenizer) (obj)).nextToken());
            if (!((StringTokenizer) (obj)).hasMoreTokens())
            {
                sendError("400 Bad Request", "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            s = ((StringTokenizer) (obj)).nextToken();
            i = s.indexOf('?');
            if (i < 0) goto _L2; else goto _L1
_L1:
            decodeParms(s.substring(i + 1), properties1);
            properties1 = decodePercent(s.substring(0, i));
_L6:
            if (!((StringTokenizer) (obj)).hasMoreTokens()) goto _L4; else goto _L3
_L3:
            obj = bufferedreader.readLine();
_L5:
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (((String) (obj)).trim().length() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            i = ((String) (obj)).indexOf(':');
            if (i < 0)
            {
                break MISSING_BLOCK_LABEL_191;
            }
            properties2.put(((String) (obj)).substring(0, i).trim().toLowerCase(), ((String) (obj)).substring(i + 1).trim());
            obj = bufferedreader.readLine();
            if (true) goto _L5; else goto _L4
_L2:
            properties1 = decodePercent(s);
              goto _L6
_L4:
            try
            {
                properties.put("uri", properties1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                sendError("500 Internal Server Error", (new StringBuilder()).append("SERVER INTERNAL ERROR: IOException: ").append(bufferedreader.getMessage()).toString());
            }
            return;
        }

        private void decodeMultipartData(String s, byte abyte0[], BufferedReader bufferedreader, Properties properties, Properties properties1)
            throws InterruptedException
        {
            int ai[] = getBoundaryPositions(abyte0, s.getBytes());
            int i = 1;
            Object obj2 = bufferedreader.readLine();
_L12:
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_287;
            }
            if (((String) (obj2)).indexOf(s) == -1)
            {
                sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
            }
            int j = i + 1;
            Object obj;
            Object obj3;
            obj3 = new Properties();
            obj = bufferedreader.readLine();
_L2:
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (((String) (obj)).trim().length() <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            i = ((String) (obj)).indexOf(':');
            if (i == -1)
            {
                break MISSING_BLOCK_LABEL_127;
            }
            ((Properties) (obj3)).put(((String) (obj)).substring(0, i).trim().toLowerCase(), ((String) (obj)).substring(i + 1).trim());
            obj = bufferedreader.readLine();
            if (true) goto _L2; else goto _L1
_L1:
            i = j;
            obj2 = obj;
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            Object obj1 = ((Properties) (obj3)).getProperty("content-disposition");
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_171;
            }
            sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
            obj1 = new StringTokenizer(((String) (obj1)), "; ");
            obj2 = new Properties();
_L4:
            String s1;
            do
            {
                if (!((StringTokenizer) (obj1)).hasMoreTokens())
                {
                    break MISSING_BLOCK_LABEL_288;
                }
                s1 = ((StringTokenizer) (obj1)).nextToken();
                i = s1.indexOf('=');
            } while (i == -1);
            ((Properties) (obj2)).put(s1.substring(0, i).trim().toLowerCase(), s1.substring(i + 1).trim());
            if (true) goto _L4; else goto _L3
_L3:
            s;
            sendError("500 Internal Server Error", (new StringBuilder()).append("SERVER INTERNAL ERROR: IOException: ").append(s.getMessage()).toString());
            return;
            obj1 = ((Properties) (obj2)).getProperty("name");
            s1 = ((String) (obj1)).substring(1, ((String) (obj1)).length() - 1);
            obj1 = "";
            if (((Properties) (obj3)).getProperty("content-type") != null) goto _L6; else goto _L5
_L5:
            obj2 = obj;
            obj3 = obj1;
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj2 = obj;
            obj3 = obj1;
            if (((String) (obj)).indexOf(s) != -1)
            {
                break; /* Loop/switch isn't completed */
            }
            obj2 = bufferedreader.readLine();
            obj = obj2;
            if (obj2 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = ((String) (obj2)).indexOf(s);
            if (i != -1)
            {
                break MISSING_BLOCK_LABEL_415;
            }
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj2))).toString();
            obj = obj2;
            continue; /* Loop/switch isn't completed */
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj2)).substring(0, i - 2)).toString();
            obj = obj2;
            if (true) goto _L5; else goto _L7
_L6:
            if (j > ai.length)
            {
                sendError("500 Internal Server Error", "Error processing request");
            }
            i = stripMultipartHeaders(abyte0, ai[j - 2]);
            properties1.put(s1, saveTmpFile(abyte0, i, ai[j - 1] - i - 4));
            obj = ((Properties) (obj2)).getProperty("filename");
            obj = ((String) (obj)).substring(1, ((String) (obj)).length() - 1);
_L10:
            obj1 = bufferedreader.readLine();
            obj2 = obj1;
            obj3 = obj;
            if (obj1 == null) goto _L7; else goto _L8
_L8:
            if (((String) (obj1)).indexOf(s) == -1) goto _L10; else goto _L9
_L9:
            obj3 = obj;
            obj2 = obj1;
_L7:
            properties.put(s1, obj3);
            i = j;
            if (true) goto _L12; else goto _L11
_L11:
        }

        private void decodeParms(String s, Properties properties)
            throws InterruptedException
        {
            if (s != null)
            {
                s = new StringTokenizer(s, "&");
                while (s.hasMoreTokens()) 
                {
                    String s1 = s.nextToken();
                    int i = s1.indexOf('=');
                    if (i >= 0)
                    {
                        properties.put(decodePercent(s1.substring(0, i)).trim(), decodePercent(s1.substring(i + 1)));
                    }
                }
            }
        }

        private String decodePercent(String s)
            throws InterruptedException
        {
            StringBuffer stringbuffer;
            int i;
            char c;
            try
            {
                stringbuffer = new StringBuffer();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                sendError("400 Bad Request", "BAD REQUEST: Bad percent-encoding.");
                return null;
            }
            i = 0;
_L7:
            if (i >= s.length()) goto _L2; else goto _L1
_L1:
            c = s.charAt(i);
            c;
            JVM INSTR lookupswitch 2: default 125
        //                       37: 86
        //                       43: 65;
               goto _L3 _L4 _L5
_L3:
            stringbuffer.append(c);
            break MISSING_BLOCK_LABEL_128;
_L5:
            stringbuffer.append(' ');
            break MISSING_BLOCK_LABEL_128;
_L4:
            stringbuffer.append((char)Integer.parseInt(s.substring(i + 1, i + 3), 16));
            i += 2;
            break MISSING_BLOCK_LABEL_128;
_L2:
            s = stringbuffer.toString();
            return s;
            i++;
            if (true) goto _L7; else goto _L6
_L6:
        }

        private int findHeaderEnd(byte abyte0[], int i)
        {
            for (int j = 0; j + 3 < i; j++)
            {
                if (abyte0[j] == 13 && abyte0[j + 1] == 10 && abyte0[j + 2] == 13 && abyte0[j + 3] == 10)
                {
                    return j + 4;
                }
            }

            return 0;
        }

        private String saveTmpFile(byte abyte0[], int i, int j)
        {
            Object obj = "";
            if (j > 0)
            {
                obj = System.getProperty("java.io.tmpdir");
                try
                {
                    obj = File.createTempFile("NanoHTTPD", "", new File(((String) (obj))));
                    FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj)));
                    fileoutputstream.write(abyte0, i, j);
                    fileoutputstream.close();
                    obj = ((File) (obj)).getAbsolutePath();
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    NanoHTTPD.myErr.println((new StringBuilder()).append("Error: ").append(abyte0.getMessage()).toString());
                    return "";
                }
            }
            return ((String) (obj));
        }

        private void sendError(String s, String s1)
            throws InterruptedException
        {
            sendResponse(s, "text/plain", null, new ByteArrayInputStream(s1.getBytes()));
            throw new InterruptedException();
        }

        private void sendResponse(String s, String s1, Properties properties, InputStream inputstream)
        {
            if (s != null) goto _L2; else goto _L1
_L1:
            try
            {
                throw new Error("sendResponse(): Status can't be null.");
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            mySocket.close();
_L8:
            return;
_L2:
            OutputStream outputstream;
            PrintWriter printwriter;
            outputstream = mySocket.getOutputStream();
            printwriter = new PrintWriter(outputstream);
            printwriter.print((new StringBuilder()).append("HTTP/1.0 ").append(s).append(" \r\n").toString());
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            printwriter.print((new StringBuilder()).append("Content-Type: ").append(s1).append("\r\n").toString());
            if (properties == null)
            {
                break MISSING_BLOCK_LABEL_124;
            }
            if (properties.getProperty("Date") != null)
            {
                break MISSING_BLOCK_LABEL_167;
            }
            printwriter.print((new StringBuilder()).append("Date: ").append(NanoHTTPD.gmtFrmt.format(new Date())).append("\r\n").toString());
            if (properties == null)
            {
                break MISSING_BLOCK_LABEL_241;
            }
            String s2;
            for (s = properties.keys(); s.hasMoreElements(); printwriter.print((new StringBuilder()).append(s1).append(": ").append(s2).append("\r\n").toString()))
            {
                s1 = (String)s.nextElement();
                s2 = properties.getProperty(s1);
            }

            printwriter.print("\r\n");
            printwriter.flush();
            if (inputstream == null) goto _L4; else goto _L3
_L3:
            int i;
            i = inputstream.available();
            s = new byte[NanoHTTPD.theBufferSize];
_L9:
            if (i <= 0) goto _L4; else goto _L5
_L5:
            int j;
            if (i <= NanoHTTPD.theBufferSize)
            {
                break MISSING_BLOCK_LABEL_348;
            }
            j = NanoHTTPD.theBufferSize;
_L10:
            j = inputstream.read(s, 0, j);
            if (j > 0) goto _L6; else goto _L4
_L4:
            outputstream.flush();
            outputstream.close();
            if (inputstream == null) goto _L8; else goto _L7
_L7:
            inputstream.close();
            return;
_L6:
            outputstream.write(s, 0, j);
            i -= j;
              goto _L9
            s;
            return;
            j = i;
              goto _L10
        }

        private int stripMultipartHeaders(byte abyte0[], int i)
        {
            int j = i;
            do
            {
label0:
                {
                    i = j;
                    if (j < abyte0.length)
                    {
                        i = j;
                        if (abyte0[j] != 13)
                        {
                            break label0;
                        }
                        j++;
                        i = j;
                        if (abyte0[j] != 10)
                        {
                            break label0;
                        }
                        j++;
                        i = j;
                        if (abyte0[j] != 13)
                        {
                            break label0;
                        }
                        j++;
                        i = j;
                        if (abyte0[j] != 10)
                        {
                            break label0;
                        }
                        i = j;
                    }
                    return i + 1;
                }
                j = i + 1;
            } while (true);
        }

        public int[] getBoundaryPositions(byte abyte0[], byte abyte1[])
        {
            int k = 0;
            int l = -1;
            Vector vector = new Vector();
            int i = 0;
            while (i < abyte0.length) 
            {
                int j1;
                if (abyte0[i] == abyte1[k])
                {
                    int i1 = l;
                    if (k == 0)
                    {
                        i1 = i;
                    }
                    int k1 = k + 1;
                    j1 = i;
                    l = i1;
                    k = k1;
                    if (k1 == abyte1.length)
                    {
                        vector.addElement(new Integer(i1));
                        k = 0;
                        l = -1;
                        j1 = i;
                    }
                } else
                {
                    j1 = i - k;
                    k = 0;
                    l = -1;
                }
                i = j1 + 1;
            }
            abyte0 = new int[vector.size()];
            for (int j = 0; j < abyte0.length; j++)
            {
                abyte0[j] = ((Integer)vector.elementAt(j)).intValue();
            }

            return abyte0;
        }

        public void run()
        {
            Object obj;
            InputStream inputstream;
            Properties properties;
            Properties properties1;
            Properties properties2;
            Object obj1;
            Object obj2;
            Object obj3;
            NumberFormatException numberformatexception;
            BufferedReader bufferedreader;
            byte abyte0[];
            StringTokenizer stringtokenizer;
            char ac[];
            int i;
            int j;
            int k;
            int l;
            long l1;
            long l2;
            try
            {
                inputstream = mySocket.getInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                try
                {
                    sendError("500 Internal Server Error", (new StringBuilder()).append("SERVER INTERNAL ERROR: IOException: ").append(((IOException) (obj)).getMessage()).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return;
                }
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
            if (inputstream == null)
            {
                return;
            }
            obj = new byte[8192];
            j = 0;
            i = 0;
            l = inputstream.read(((byte []) (obj)), 0, 8192);
_L9:
            k = i;
            if (l <= 0) goto _L2; else goto _L1
_L1:
            i += l;
            j = findHeaderEnd(((byte []) (obj)), i);
            if (j <= 0) goto _L4; else goto _L3
_L3:
            k = i;
_L2:
            obj1 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(((byte []) (obj)), 0, k)));
            obj2 = new Properties();
            properties = new Properties();
            properties1 = new Properties();
            properties2 = new Properties();
            decodeHeader(((BufferedReader) (obj1)), ((Properties) (obj2)), properties, properties1);
            obj1 = ((Properties) (obj2)).getProperty("method");
            obj2 = ((Properties) (obj2)).getProperty("uri");
            l1 = 0x7fffffffffffffffL;
            obj3 = properties1.getProperty("content-length");
            l2 = l1;
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_197;
            }
            i = Integer.parseInt(((String) (obj3)));
            l2 = i;
_L16:
            obj3 = new ByteArrayOutputStream();
            if (j >= k) goto _L6; else goto _L5
_L5:
            ((ByteArrayOutputStream) (obj3)).write(((byte []) (obj)), j, k - j);
              goto _L6
_L17:
            obj = new byte[512];
_L8:
            if (k < 0 || l1 <= 0L)
            {
                break; /* Loop/switch isn't completed */
            }
            i = inputstream.read(((byte []) (obj)), 0, 512);
            l2 = l1 - (long)i;
            k = i;
            l1 = l2;
            if (i <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((ByteArrayOutputStream) (obj3)).write(((byte []) (obj)), 0, i);
            k = i;
            l1 = l2;
            if (true) goto _L8; else goto _L7
_L4:
            l = inputstream.read(((byte []) (obj)), i, 8192 - i);
              goto _L9
_L7:
            abyte0 = ((ByteArrayOutputStream) (obj3)).toByteArray();
            bufferedreader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(abyte0)));
            if (!((String) (obj1)).equalsIgnoreCase("POST")) goto _L11; else goto _L10
_L10:
            obj = "";
            stringtokenizer = new StringTokenizer(properties1.getProperty("content-type"), "; ");
            if (stringtokenizer.hasMoreTokens())
            {
                obj = stringtokenizer.nextToken();
            }
            if (!((String) (obj)).equalsIgnoreCase("multipart/form-data")) goto _L13; else goto _L12
_L12:
            if (!stringtokenizer.hasMoreTokens())
            {
                sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
            }
            obj = new StringTokenizer(stringtokenizer.nextToken(), "=");
            if (((StringTokenizer) (obj)).countTokens() != 2)
            {
                sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary syntax error. Usage: GET /example/file.html");
            }
            ((StringTokenizer) (obj)).nextToken();
            decodeMultipartData(((StringTokenizer) (obj)).nextToken(), abyte0, bufferedreader, properties, properties2);
_L11:
            if (((String) (obj1)).equalsIgnoreCase("PUT"))
            {
                properties2.put("content", saveTmpFile(abyte0, 0, ((ByteArrayOutputStream) (obj3)).size()));
            }
            obj = serve(((String) (obj2)), ((String) (obj1)), properties1, properties, properties2);
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_663;
            }
            sendError("500 Internal Server Error", "SERVER INTERNAL ERROR: Serve() returned a null response.");
_L15:
            bufferedreader.close();
            inputstream.close();
            return;
_L13:
            obj = "";
            ac = new char[512];
            i = bufferedreader.read(ac);
_L14:
            if (i < 0)
            {
                break MISSING_BLOCK_LABEL_651;
            }
            if (((String) (obj)).endsWith("\r\n"))
            {
                break MISSING_BLOCK_LABEL_651;
            }
            obj = (new StringBuilder()).append(((String) (obj))).append(String.valueOf(ac, 0, i)).toString();
            i = bufferedreader.read(ac);
              goto _L14
            decodeParms(((String) (obj)).trim(), properties);
              goto _L11
            sendResponse(((Response) (obj)).status, ((Response) (obj)).mimeType, ((Response) (obj)).header, ((Response) (obj)).data);
              goto _L15
            numberformatexception;
            l2 = l1;
              goto _L16
_L6:
label0:
            {
                if (j >= k)
                {
                    break label0;
                }
                l1 = l2 - (long)((k - j) + 1);
            }
              goto _L17
            if (j == 0) goto _L19; else goto _L18
_L18:
            l1 = l2;
            if (l2 != 0x7fffffffffffffffL) goto _L17; else goto _L19
_L19:
            l1 = 0L;
              goto _L17
        }

        public HTTPSession(Socket socket)
        {
            this$0 = NanoHTTPD.this;
            super();
            mySocket = socket;
            nanohttpd = new Thread(this);
            setDaemon(true);
            start();
        }
    }

    public class Response
    {

        public InputStream data;
        public Properties header;
        public String mimeType;
        public String status;
        final NanoHTTPD this$0;

        public void addHeader(String s, String s1)
        {
            header.put(s, s1);
        }

        public Response(String s, String s1, InputStream inputstream)
        {
            this$0 = NanoHTTPD.this;
            super();
            header = new Properties();
            status = s;
            mimeType = s1;
            data = inputstream;
        }

        public Response(String s, String s1, String s2)
        {
            this$0 = NanoHTTPD.this;
            super();
            header = new Properties();
            status = s;
            mimeType = s1;
            try
            {
                data = new ByteArrayInputStream(s2.getBytes("UTF-8"));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (NanoHTTPD nanohttpd)
            {
                printStackTrace();
            }
        }
    }


    private static SimpleDateFormat gmtFrmt;
    protected static PrintStream myErr;
    protected static PrintStream myOut;
    private static int theBufferSize = 16384;
    private static Hashtable theMimeTypes;
    private File myRootDir;
    private final ServerSocket myServerSocket;
    private int myTcpPort;
    private Thread myThread;

    public NanoHTTPD(int i, File file)
        throws IOException
    {
        myTcpPort = i;
        myRootDir = file;
        myServerSocket = new ServerSocket(myTcpPort);
        myThread = new Thread(new Runnable() {

            final NanoHTTPD this$0;

            public void run()
            {
                do
                {
                    try
                    {
                        new HTTPSession(myServerSocket.accept());
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                } while (true);
            }

            
            {
                this$0 = NanoHTTPD.this;
                super();
            }
        });
        myThread.setDaemon(true);
        myThread.start();
    }

    private String encodeUri(String s)
    {
        String s1 = "";
        StringTokenizer stringtokenizer = new StringTokenizer(s, "/ ", true);
        s = s1;
        while (stringtokenizer.hasMoreTokens()) 
        {
            String s2 = stringtokenizer.nextToken();
            if (s2.equals("/"))
            {
                s = (new StringBuilder()).append(s).append("/").toString();
            } else
            if (s2.equals(" "))
            {
                s = (new StringBuilder()).append(s).append("%20").toString();
            } else
            {
                s = (new StringBuilder()).append(s).append(URLEncoder.encode(s2)).toString();
            }
        }
        return s;
    }

    public Response serve(String s, String s1, Properties properties, Properties properties1, Properties properties2)
    {
        myOut.println((new StringBuilder()).append(s1).append(" '").append(s).append("' ").toString());
        String s2;
        for (s1 = properties.propertyNames(); s1.hasMoreElements(); myOut.println((new StringBuilder()).append("  HDR: '").append(s2).append("' = '").append(properties.getProperty(s2)).append("'").toString()))
        {
            s2 = (String)s1.nextElement();
        }

        String s3;
        for (s1 = properties1.propertyNames(); s1.hasMoreElements(); myOut.println((new StringBuilder()).append("  PRM: '").append(s3).append("' = '").append(properties1.getProperty(s3)).append("'").toString()))
        {
            s3 = (String)s1.nextElement();
        }

        for (s1 = properties2.propertyNames(); s1.hasMoreElements(); myOut.println((new StringBuilder()).append("  UPLOADED: '").append(properties1).append("' = '").append(properties2.getProperty(properties1)).append("'").toString()))
        {
            properties1 = (String)s1.nextElement();
        }

        return serveFile(s, properties, myRootDir, true);
    }

    public Response serveFile(String s, Properties properties, final File final_file, boolean flag)
    {
        String s1;
        Object obj;
        File file;
        Response response1;
label0:
        {
            Response response = null;
            if (!final_file.isDirectory())
            {
                response = new Response("500 Internal Server Error", "text/plain", "INTERNAL ERRROR: serveFile(): given homeDir is not a directory.");
            }
            response1 = response;
            s1 = s;
            if (response != null)
            {
                break label0;
            }
            s1 = s.trim().replace(File.separatorChar, '/');
            s = s1;
            if (s1.indexOf('?') >= 0)
            {
                s = s1.substring(0, s1.indexOf('?'));
            }
            if (!s.startsWith("src/main") && !s.endsWith("src/main"))
            {
                response1 = response;
                s1 = s;
                if (s.indexOf("../") < 0)
                {
                    break label0;
                }
            }
            response1 = new Response("403 Forbidden", "text/plain", "FORBIDDEN: Won't serve ../ for security reasons.");
            s1 = s;
        }
        file = new File(final_file, s1);
        s = response1;
        if (response1 == null)
        {
            s = response1;
            if (!file.exists())
            {
                s = new Response("404 Not Found", "text/plain", "Error 404, file not found.");
            }
        }
        obj = s;
        if (s != null) goto _L2; else goto _L1
_L1:
        obj = s;
        if (!file.isDirectory()) goto _L2; else goto _L3
_L3:
        String s2;
        s2 = s1;
        if (!s1.endsWith("/"))
        {
            s2 = (new StringBuilder()).append(s1).append("/").toString();
            s = new Response("301 Moved Permanently", "text/html", (new StringBuilder()).append("<html><body>Redirected: <a href=\"").append(s2).append("\">").append(s2).append("</a></body></html>").toString());
            s.addHeader("Location", s2);
        }
        obj = s;
        if (s != null) goto _L2; else goto _L4
_L4:
        int i;
        long l1;
        long l3;
        if ((new File(file, "index.html")).exists())
        {
            final_file = new File(final_file, (new StringBuilder()).append(s2).append("/index.html").toString());
        } else
        if ((new File(file, "index.htm")).exists())
        {
            final_file = new File(final_file, (new StringBuilder()).append(s2).append("/index.htm").toString());
        } else
        if (flag && file.canRead())
        {
            String as[] = file.list();
            final_file = (new StringBuilder()).append("<html><body><h1>Directory ").append(s2).append("</h1><br/>").toString();
            s = final_file;
            if (s2.length() > 1)
            {
                obj = s2.substring(0, s2.length() - 1);
                int j = ((String) (obj)).lastIndexOf('/');
                s = final_file;
                if (j >= 0)
                {
                    s = final_file;
                    if (j < ((String) (obj)).length())
                    {
                        s = (new StringBuilder()).append(final_file).append("<b><a href=\"").append(s2.substring(0, j + 1)).append("\">..</a></b><br/>").toString();
                    }
                }
            }
            final_file = s;
            if (as != null)
            {
                int k = 0;
                do
                {
                    final_file = s;
                    if (k >= as.length)
                    {
                        break;
                    }
                    obj = new File(file, as[k]);
                    flag = ((File) (obj)).isDirectory();
                    final_file = s;
                    if (flag)
                    {
                        final_file = (new StringBuilder()).append(s).append("<b>").toString();
                        as[k] = (new StringBuilder()).append(as[k]).append("/").toString();
                    }
                    final_file = (new StringBuilder()).append(final_file).append("<a href=\"").append(encodeUri((new StringBuilder()).append(s2).append(as[k]).toString())).append("\">").append(as[k]).append("</a>").toString();
                    s = final_file;
                    if (((File) (obj)).isFile())
                    {
                        l = ((File) (obj)).length();
                        s = (new StringBuilder()).append(final_file).append(" &nbsp;<font size=2>(").toString();
                        if (l < 1024L)
                        {
                            s = (new StringBuilder()).append(s).append(l).append(" bytes").toString();
                        } else
                        if (l < 0x100000L)
                        {
                            s = (new StringBuilder()).append(s).append(l / 1024L).append(".").append(((l % 1024L) / 10L) % 100L).append(" KB").toString();
                        } else
                        {
                            s = (new StringBuilder()).append(s).append(l / 0x100000L).append(".").append(((l % 0x100000L) / 10L) % 100L).append(" MB").toString();
                        }
                        s = (new StringBuilder()).append(s).append(")</font>").toString();
                    }
                    final_file = (new StringBuilder()).append(s).append("<br/>").toString();
                    s = final_file;
                    if (flag)
                    {
                        s = (new StringBuilder()).append(final_file).append("</b>").toString();
                    }
                    k++;
                } while (true);
            }
            s = new Response("200 OK", "text/html", (new StringBuilder()).append(final_file).append("</body></html>").toString());
            final_file = file;
        } else
        {
            s = new Response("403 Forbidden", "text/plain", "FORBIDDEN: No directory listing.");
            final_file = file;
        }
_L14:
        if (s != null) goto _L6; else goto _L5
_L5:
        s = null;
        i = final_file.getCanonicalPath().lastIndexOf('.');
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_1681;
        }
        long l;
        long l2;
        long l4;
        try
        {
            s = (String)theMimeTypes.get(final_file.getCanonicalPath().substring(i + 1).toLowerCase());
            break MISSING_BLOCK_LABEL_1681;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
          goto _L7
_L15:
        s2 = Integer.toHexString((new StringBuilder()).append(final_file.getAbsolutePath()).append(final_file.lastModified()).append("").append(final_file.length()).toString().hashCode());
        l2 = 0L;
        l3 = -1L;
        obj = properties.getProperty("range");
        l1 = l3;
        s = ((String) (obj));
        l = l2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_586;
        }
        l1 = l3;
        s = ((String) (obj));
        l = l2;
        if (!((String) (obj)).startsWith("bytes="))
        {
            break MISSING_BLOCK_LABEL_586;
        }
        obj = ((String) (obj)).substring("bytes=".length());
        i = ((String) (obj)).indexOf('-');
        l1 = l3;
        s = ((String) (obj));
        l = l2;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_586;
        }
        l = l2;
        l1 = Long.parseLong(((String) (obj)).substring(0, i));
        l = l1;
        l2 = Long.parseLong(((String) (obj)).substring(i + 1));
        l = l1;
        s = ((String) (obj));
        l1 = l2;
_L13:
        l4 = final_file.length();
        if (s == null || l < 0L) goto _L9; else goto _L8
_L8:
        if (l < l4) goto _L11; else goto _L10
_L10:
        s = new Response("416 Requested Range Not Satisfiable", "text/plain", "");
        s.addHeader("Content-Range", (new StringBuilder()).append("bytes 0-0/").append(l4).toString());
        s.addHeader("ETag", s2);
_L6:
        s.addHeader("Accept-Ranges", "bytes");
        return s;
_L11:
        l2 = l1;
        if (l1 < 0L)
        {
            l2 = l4 - 1L;
        }
        l3 = (l2 - l) + 1L;
        l1 = l3;
        if (l3 < 0L)
        {
            l1 = 0L;
        }
        s = new FileInputStream(l1) {

            final NanoHTTPD this$0;
            final long val$dataLen;

            public int available()
                throws IOException
            {
                return (int)dataLen;
            }

            
            {
                this$0 = NanoHTTPD.this;
                dataLen = l;
                super(final_file);
            }
        };
        s.skip(l);
        s = new Response("206 Partial Content", as, s);
        try
        {
            s.addHeader("Content-Length", (new StringBuilder()).append("").append(l1).toString());
            s.addHeader("Content-Range", (new StringBuilder()).append("bytes ").append(l).append("-").append(l2).append("/").append(l4).toString());
            s.addHeader("ETag", s2);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
_L7:
        s = new Response("403 Forbidden", "text/plain", "FORBIDDEN: Reading file failed.");
        continue; /* Loop/switch isn't completed */
_L9:
        if (s2.equals(properties.getProperty("if-none-match")))
        {
            s = new Response("304 Not Modified", as, "");
            continue; /* Loop/switch isn't completed */
        }
        s = new Response("200 OK", as, new FileInputStream(final_file));
        s.addHeader("Content-Length", (new StringBuilder()).append("").append(l4).toString());
        s.addHeader("ETag", s2);
        if (true) goto _L6; else goto _L12
_L12:
        s;
        l1 = l3;
        s = ((String) (obj));
        if (true) goto _L13; else goto _L2
_L2:
        s = ((String) (obj));
        final_file = file;
          goto _L14
        as = s;
        if (s == null)
        {
            as = "application/octet-stream";
        }
          goto _L15
    }

    public void stop()
    {
        try
        {
            myServerSocket.close();
            myThread.join();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    static 
    {
        theMimeTypes = new Hashtable();
        for (StringTokenizer stringtokenizer = new StringTokenizer("css\t\ttext/css htm\t\ttext/html html\t\ttext/html xml\t\ttext/xml txt\t\ttext/plain asc\t\ttext/plain gif\t\timage/gif jpg\t\timage/jpeg jpeg\t\timage/jpeg png\t\timage/png mp3\t\taudio/mpeg m3u\t\taudio/mpeg-url mp4\t\tvideo/mp4 ogv\t\tvideo/ogg flv\t\tvideo/x-flv mov\t\tvideo/quicktime swf\t\tapplication/x-shockwave-flash js\t\t\tapplication/javascript pdf\t\tapplication/pdf doc\t\tapplication/msword ogg\t\tapplication/x-ogg zip\t\tapplication/octet-stream exe\t\tapplication/octet-stream class\t\tapplication/octet-stream "); stringtokenizer.hasMoreTokens(); theMimeTypes.put(stringtokenizer.nextToken(), stringtokenizer.nextToken())) { }
        myOut = System.out;
        myErr = System.err;
        gmtFrmt = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        gmtFrmt.setTimeZone(TimeZone.getTimeZone("GMT"));
    }



}
