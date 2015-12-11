// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aho, ahn, ahk, ahq, 
//            ahm, ahr

class a
    implements Runnable
{

    final aho a;

    public void run()
    {
        Object obj13;
        android.content.Context context;
        int i;
        obj13 = null;
        i = 0;
        context = a.d();
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = null;
_L9:
        Object obj1;
        Exception exception;
        ahm ahm1;
        try
        {
            ahm1 = ahn.a(context);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ahk.a().a("Error processing events from DB", ((Throwable) (obj)));
            return;
        }
        if (ahm1 == null) goto _L1; else goto _L3
_L3:
        if (aho.a(a) == null || aho.a(a).intValue() != 1)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        ahk.a().b("Not actually sending events from sample appId: 1", null);
        obj = aho.b(a).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj1 = (ahq)((Iterator) (obj)).next();
        ((ahq) (obj1)).a(ahm1.a());
          goto _L4
        exception;
        Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on success", exception);
          goto _L4
        ahn.a(context, Arrays.asList(new ahm[] {
            ahm1
        }));
        return;
        if (!a.f()) goto _L6; else goto _L5
_L5:
        boolean flag = ahr.a().a(ahm1);
        if (!flag) goto _L7; else goto _L6
_L6:
        ahn.a(context, Arrays.asList(new ahm[] {
            ahm1
        }));
_L16:
        exception = aho.b(a).iterator();
_L10:
        if (!exception.hasNext()) goto _L9; else goto _L8
_L8:
        Object obj2 = (ahq)exception.next();
        ((ahq) (obj2)).b(ahm1.a());
          goto _L10
        Exception exception1;
        exception1;
        Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on success", exception1);
          goto _L10
        exception;
        ahk.a().a("Error determining is tracking is disabled", exception);
_L7:
        exception = (HttpURLConnection)(new URL(ahm1.a())).openConnection();
        int j;
        int k;
        int l;
        j = i;
        k = i;
        l = i;
        exception.setUseCaches(false);
        j = i;
        k = i;
        l = i;
        exception.setConnectTimeout(30000);
        j = i;
        k = i;
        l = i;
        exception.setReadTimeout(30000);
        j = i;
        k = i;
        l = i;
        exception.setRequestProperty("Connection", "Keep-Alive");
        j = i;
        k = i;
        l = i;
        exception.connect();
        j = i;
        k = i;
        l = i;
        i = exception.getResponseCode();
        j = i;
        k = i;
        l = i;
        exception1 = exception.getInputStream();
        Object obj3 = new ByteArrayOutputStream();
        Object obj4;
        Object obj5;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        byte abyte0[] = new byte[1024];
_L12:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        if (exception1.read(abyte0) == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        ((ByteArrayOutputStream) (obj3)).write(abyte0);
        if (true) goto _L12; else goto _L11
        obj5;
        obj4 = obj11;
        obj = obj3;
        obj3 = exception1;
        exception1 = ((Exception) (obj5));
_L43:
        ahk.a().b((new StringBuilder()).append("UnknownHostException sending: ").append(ahm1.a()).toString(), exception1);
        exception1 = aho.b(a).iterator();
_L15:
        if (!exception1.hasNext()) goto _L14; else goto _L13
_L13:
        obj5 = (ahq)exception1.next();
        ((ahq) (obj5)).a(ahm1.a(), i, ((String) (obj4)));
          goto _L15
        obj5;
        Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on error", ((Throwable) (obj5)));
          goto _L15
        obj4;
        exception1 = ((Exception) (obj3));
        obj3 = exception;
        exception = ((Exception) (obj));
        obj = obj4;
_L22:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_649;
        }
        ((HttpURLConnection) (obj3)).disconnect();
        if (exception1 == null)
        {
            break MISSING_BLOCK_LABEL_657;
        }
        exception1.close();
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_665;
        }
        exception.close();
        throw obj;
        exception;
        ahk.a().a((new StringBuilder()).append("Error deleting: ").append(ahm1.a()).toString(), exception);
          goto _L16
_L11:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        obj = ((ByteArrayOutputStream) (obj3)).toString("UTF-8");
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        if (!ahk.a().a) goto _L18; else goto _L17
_L17:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        Log.i(android/support/v7/aho.getSimpleName(), (new StringBuilder()).append("TRACK EVENT REQUEST ").append(ahm1.a()).append(",RESPONSE: ").append(((String) (obj))).toString());
          goto _L18
_L47:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        throw new RuntimeException((new StringBuilder()).append("Non-200 response: ").append(i).toString());
        obj4;
        obj = obj3;
        obj3 = obj4;
_L42:
        obj9 = exception;
        obj5 = obj;
        obj4 = exception1;
        ahk.a().b((new StringBuilder()).append("Socket/Connect timeout sending: ").append(ahm1.a()).toString(), ((Throwable) (obj3)));
        obj9 = exception;
        obj5 = obj;
        obj4 = exception1;
        obj3 = aho.b(a).iterator();
_L21:
        obj9 = exception;
        obj5 = obj;
        obj4 = exception1;
        if (!((Iterator) (obj3)).hasNext()) goto _L20; else goto _L19
_L19:
        obj9 = exception;
        obj5 = obj;
        obj4 = exception1;
        obj11 = (ahq)((Iterator) (obj3)).next();
        obj9 = exception;
        obj5 = obj;
        obj4 = exception1;
        ((ahq) (obj11)).a(ahm1.a(), i, ((String) (obj10)));
          goto _L21
        obj11;
        obj9 = exception;
        obj5 = obj;
        obj4 = exception1;
        Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on error", ((Throwable) (obj11)));
          goto _L21
        obj;
        obj3 = obj9;
        exception = ((Exception) (obj5));
        exception1 = ((Exception) (obj4));
          goto _L22
_L45:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        ahn.a(context, Arrays.asList(new ahm[] {
            ahm1
        }));
_L31:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        Iterator iterator = aho.b(a).iterator();
_L25:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        if (!iterator.hasNext()) goto _L24; else goto _L23
_L23:
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        ahq ahq1 = (ahq)iterator.next();
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        ahq1.a(ahm1.a());
          goto _L25
        Exception exception3;
        exception3;
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj5 = obj3;
        obj4 = exception1;
        obj12 = obj;
        Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on success", exception3);
          goto _L25
        Object obj6;
        obj6;
        obj = obj12;
        obj4 = exception;
        exception = ((Exception) (obj3));
        obj3 = obj4;
        obj4 = obj6;
_L41:
        ahk.a().b((new StringBuilder()).append("Error sending: ").append(ahm1.a()).append(" ").append(obj4.getClass()).append(",").append(((Throwable) (obj4)).getMessage()).toString(), ((Throwable) (obj4)));
        j = ahm1.b;
        if (j < 3) goto _L27; else goto _L26
_L26:
        ahk.a().b((new StringBuilder()).append(ahm1).append(" failed after 3 attempts so deleting").toString(), null);
        ahn.a(context, Arrays.asList(new ahm[] {
            ahm1
        }));
_L37:
        obj4 = aho.b(a).iterator();
_L30:
        if (!((Iterator) (obj4)).hasNext()) goto _L29; else goto _L28
_L28:
        obj6 = (ahq)((Iterator) (obj4)).next();
        ((ahq) (obj6)).a(ahm1.a(), i, ((String) (obj)));
          goto _L30
        obj6;
        Log.e(android/support/v7/aho.getSimpleName(), "Error in request sent listener on error", ((Throwable) (obj6)));
          goto _L30
        obj;
          goto _L22
        Exception exception2;
        exception2;
        obj11 = obj;
        obj10 = obj;
        obj9 = exception;
        obj6 = obj3;
        obj4 = exception1;
        obj12 = obj;
        ahk.a().a((new StringBuilder()).append("Error deleting: ").append(ahm1.a()).toString(), exception2);
          goto _L31
_L24:
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_1519;
        }
        exception.disconnect();
        if (exception1 == null) goto _L33; else goto _L32
_L32:
        exception1.close();
_L33:
        if (obj3 == null) goto _L9; else goto _L34
_L34:
        ((ByteArrayOutputStream) (obj3)).close();
          goto _L9
_L14:
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_1548;
        }
        exception.disconnect();
        if (obj3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((InputStream) (obj3)).close();
        if (obj == null) goto _L1; else goto _L35
_L35:
        ((ByteArrayOutputStream) (obj)).close();
        return;
_L20:
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_1575;
        }
        exception.disconnect();
        if (exception1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        exception1.close();
        if (obj == null) goto _L1; else goto _L36
_L36:
        ((ByteArrayOutputStream) (obj)).close();
        return;
        obj4;
        ahk.a().a((new StringBuilder()).append("Error deleting: ").append(ahm1.a()).toString(), ((Throwable) (obj4)));
          goto _L37
_L27:
        ahn.b(context, Arrays.asList(new ahm[] {
            ahm1
        }));
          goto _L37
        obj4;
        ahk.a().b("Error incrementing attempt count", ((Throwable) (obj4)));
          goto _L37
_L29:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_1675;
        }
        ((HttpURLConnection) (obj3)).disconnect();
        if (exception1 == null) goto _L39; else goto _L38
_L38:
        exception1.close();
_L39:
        if (exception == null) goto _L9; else goto _L40
_L40:
        exception.close();
          goto _L9
        obj;
        exception = null;
        exception1 = null;
        obj3 = null;
          goto _L22
        obj;
        obj4 = null;
        exception1 = null;
        obj3 = exception;
        exception = ((Exception) (obj4));
          goto _L22
        obj;
        obj4 = null;
        obj3 = exception;
        exception = ((Exception) (obj4));
          goto _L22
        obj4;
        exception = null;
        exception1 = null;
        obj3 = null;
          goto _L41
        obj4;
        Object obj7 = null;
        exception1 = null;
        i = j;
        obj3 = exception;
        exception = obj7;
          goto _L41
        obj4;
        Object obj8 = null;
        obj3 = exception;
        exception = obj8;
          goto _L41
        obj3;
        obj4 = null;
        exception1 = null;
        exception = null;
        obj10 = obj;
        obj = obj4;
          goto _L42
        obj3;
        obj4 = null;
        exception1 = null;
        obj10 = obj;
        i = k;
        obj = obj4;
          goto _L42
        obj3;
        obj4 = null;
        obj10 = obj;
        obj = obj4;
          goto _L42
        exception1;
        exception = null;
        obj4 = obj;
        obj3 = null;
        obj = exception;
        exception = ((Exception) (obj3));
        obj3 = obj13;
          goto _L43
        exception1;
        i = l;
        obj4 = obj;
        obj = null;
        obj3 = obj13;
          goto _L43
        obj8;
        obj4 = obj;
        obj = null;
        obj3 = exception1;
        exception1 = obj8;
          goto _L43
_L18:
        i;
        JVM INSTR tableswitch 200 200: default 1912
    //                   200 1047;
           goto _L44 _L45
_L44:
        if (true) goto _L47; else goto _L46
_L46:
          goto _L9
    }

    eption(aho aho1)
    {
        a = aho1;
        super();
    }
}
