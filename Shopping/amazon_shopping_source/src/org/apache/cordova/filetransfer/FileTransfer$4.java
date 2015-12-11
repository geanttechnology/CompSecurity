// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.cordova.filetransfer;

import android.net.Uri;
import android.util.Log;
import android.webkit.CookieManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.apache.cordova.file.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package org.apache.cordova.filetransfer:
//            FileTransfer, FileProgressResult

class val.objectId
    implements Runnable
{

    final FileTransfer this$0;
    final questContext val$context;
    final JSONObject val$headers;
    final boolean val$isLocalTransfer;
    final String val$objectId;
    final CordovaResourceApi val$resourceApi;
    final String val$source;
    final Uri val$sourceUri;
    final String val$target;
    final Uri val$targetUri;
    final boolean val$trustEveryone;
    final boolean val$useHttps;

    public void run()
    {
        Object obj3;
        Object obj4;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Object obj22;
        Object obj23;
        Object obj24;
        Object obj25;
        Object obj26;
        Object obj27;
        Object obj29;
        Object obj30;
        Object obj31;
        Object obj32;
        Object obj33;
        Object obj34;
        Object obj35;
        Object obj36;
        Object obj37;
        Object obj38;
        Object obj39;
        Object obj40;
        Object obj41;
        Object obj42;
        Object obj43;
        Object obj44;
        int i;
        int j;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        if (val$context.aborted)
        {
            return;
        }
        obj1 = null;
        obj41 = null;
        obj42 = null;
        obj43 = null;
        obj44 = null;
        obj4 = null;
        obj39 = null;
        obj29 = null;
        obj30 = null;
        obj31 = null;
        obj32 = null;
        obj33 = null;
        obj27 = null;
        obj40 = null;
        obj34 = null;
        obj35 = null;
        obj36 = null;
        obj37 = null;
        obj38 = null;
        obj2 = null;
        obj18 = null;
        obj20 = null;
        obj21 = null;
        obj22 = null;
        obj17 = null;
        obj25 = null;
        obj26 = null;
        flag4 = false;
        flag5 = false;
        flag6 = false;
        flag7 = false;
        flag8 = false;
        flag3 = false;
        obj24 = null;
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj12 = obj33;
        obj9 = obj38;
        obj = val$resourceApi.mapUriToFile(val$targetUri);
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        val$context.targetFile = ((File) (obj));
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        Log.d("FileTransfer", (new StringBuilder()).append("Download file:").append(val$sourceUri).toString());
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        FileProgressResult fileprogressresult = new FileProgressResult();
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        if (!val$isLocalTransfer) goto _L2; else goto _L1
_L1:
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        obj26 = val$resourceApi.openForRead(val$sourceUri);
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        if (((org.apache.cordova.Api.OpenForReadResult) (obj26)).length == -1L)
        {
            break MISSING_BLOCK_LABEL_1047;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        fileprogressresult.setLengthComputable(true);
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        fileprogressresult.setTotal(((org.apache.cordova.Api.OpenForReadResult) (obj26)).length);
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        obj1 = new mpleTrackingInputStream(((org.apache.cordova.Api.OpenForReadResult) (obj26)).inputStream);
        obj14 = obj1;
        obj1 = null;
        obj3 = obj27;
        i = ((flag3) ? 1 : 0);
_L4:
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_6715;
        }
        obj15 = obj24;
        obj5 = val$context;
        obj15 = obj24;
        obj5;
        JVM INSTR monitorenter ;
        if (!val$context.aborted)
        {
            break; /* Loop/switch isn't completed */
        }
        obj5;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj15 = val$context;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj15;
        JVM INSTR monitorenter ;
        val$context.connection = null;
        obj15;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        FileTransfer.access$300(((java.io.Closeable) (obj14)));
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        FileTransfer.access$300(null);
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj4 != null && val$trustEveryone && val$useHttps)
        {
            obj5 = (HttpsURLConnection)obj4;
            ((HttpsURLConnection) (obj5)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj3)));
            ((HttpsURLConnection) (obj5)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj2)));
        }
        Object obj28;
        if (obj1 == null)
        {
            obj2 = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null));
        } else
        {
            obj2 = obj1;
        }
        if (i == 0 && ((PluginResult) (obj2)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj != null)
        {
            ((File) (obj)).delete();
        }
        obj1 = val$context;
        obj = obj2;
        ((questContext) (obj1)).sendPluginResult(((PluginResult) (obj)));
        return;
_L2:
        i = ((flag4) ? 1 : 0);
        obj14 = obj1;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj41;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj42;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj43;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj44;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        obj4 = val$resourceApi.createHttpConnection(val$sourceUri);
        obj2 = obj39;
        obj1 = obj40;
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        if (!val$useHttps)
        {
            break MISSING_BLOCK_LABEL_2211;
        }
        obj2 = obj39;
        obj1 = obj40;
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        if (!val$trustEveryone)
        {
            break MISSING_BLOCK_LABEL_2211;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        obj28 = (HttpsURLConnection)obj4;
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj34;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj35;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj36;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj37;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj38;
        obj1 = FileTransfer.access$000(((HttpsURLConnection) (obj28)));
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj29;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj30;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj31;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj32;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj33;
        obj9 = obj1;
        obj2 = ((HttpsURLConnection) (obj28)).getHostnameVerifier();
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        ((HttpsURLConnection) (obj28)).setHostnameVerifier(FileTransfer.access$100());
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        ((HttpURLConnection) (obj4)).setRequestMethod("GET");
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        obj28 = CookieManager.getInstance().getCookie(val$sourceUri.toString());
        if (obj28 == null)
        {
            break MISSING_BLOCK_LABEL_2502;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        ((HttpURLConnection) (obj4)).setRequestProperty("cookie", ((String) (obj28)));
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        ((HttpURLConnection) (obj4)).setRequestProperty("Accept-Encoding", "gzip");
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        if (val$headers == null)
        {
            break MISSING_BLOCK_LABEL_2784;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        FileTransfer.access$200(((java.net.URLConnection) (obj4)), val$headers);
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        ((HttpURLConnection) (obj4)).connect();
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        if (((HttpURLConnection) (obj4)).getResponseCode() != 304)
        {
            break MISSING_BLOCK_LABEL_3414;
        }
        flag4 = true;
        flag5 = true;
        flag6 = true;
        flag7 = true;
        flag8 = true;
        flag3 = true;
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        ((HttpURLConnection) (obj4)).disconnect();
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        Log.d("FileTransfer", (new StringBuilder()).append("Resource not modified: ").append(val$source).toString());
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        obj28 = FileTransfer.access$500(FileTransfer.NOT_MODIFIED_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null);
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        obj28 = new PluginResult(org.apache.cordova.atus.ERROR, ((JSONObject) (obj28)));
        i = ((flag3) ? 1 : 0);
        obj14 = obj26;
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj28;
        continue; /* Loop/switch isn't completed */
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        if (((HttpURLConnection) (obj4)).getContentEncoding() == null)
        {
            break MISSING_BLOCK_LABEL_3606;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        if (!((HttpURLConnection) (obj4)).getContentEncoding().equalsIgnoreCase("gzip"))
        {
            break MISSING_BLOCK_LABEL_3887;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        if (((HttpURLConnection) (obj4)).getContentLength() == -1)
        {
            break MISSING_BLOCK_LABEL_3887;
        }
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        fileprogressresult.setLengthComputable(true);
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        fileprogressresult.setTotal(((HttpURLConnection) (obj4)).getContentLength());
        i = ((flag4) ? 1 : 0);
        obj14 = obj4;
        obj17 = obj;
        obj3 = obj2;
        obj5 = obj1;
        j = ((flag5) ? 1 : 0);
        obj15 = obj4;
        obj18 = obj;
        obj6 = obj2;
        obj7 = obj1;
        flag = flag6;
        obj16 = obj4;
        obj20 = obj;
        obj8 = obj2;
        obj10 = obj1;
        flag1 = flag7;
        obj19 = obj4;
        obj21 = obj;
        obj11 = obj2;
        obj13 = obj1;
        flag2 = flag8;
        obj23 = obj4;
        obj22 = obj;
        obj12 = obj2;
        obj9 = obj1;
        obj26 = FileTransfer.access$400(((java.net.URLConnection) (obj4)));
        obj14 = obj26;
        obj5 = null;
        i = ((flag3) ? 1 : 0);
        obj3 = obj2;
        obj2 = obj1;
        obj1 = obj5;
        if (true) goto _L4; else goto _L3
_L3:
        val$context.connection = ((HttpURLConnection) (obj4));
        obj5;
        JVM INSTR monitorexit ;
        obj15 = obj24;
        obj5 = new byte[16384];
        obj15 = obj24;
        obj16 = val$resourceApi.openOutputStream(val$targetUri);
_L6:
        obj15 = obj16;
        j = ((ackingInputStream) (obj14)).read(((byte []) (obj5)));
        if (j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj15 = obj16;
        ((OutputStream) (obj16)).write(((byte []) (obj5)), 0, j);
        obj15 = obj16;
        fileprogressresult.setLoaded(((ackingInputStream) (obj14)).getTotalRawBytesRead());
        obj15 = obj16;
        obj6 = new PluginResult(org.apache.cordova.atus.OK, fileprogressresult.toJSONObject());
        obj15 = obj16;
        ((PluginResult) (obj6)).setKeepCallback(true);
        obj15 = obj16;
        val$context.sendPluginResult(((PluginResult) (obj6)));
        if (true) goto _L6; else goto _L5
        obj17;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj16 = val$context;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj16;
        JVM INSTR monitorenter ;
        val$context.connection = null;
        obj16;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        FileTransfer.access$300(((java.io.Closeable) (obj14)));
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        FileTransfer.access$300(((java.io.Closeable) (obj15)));
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        throw obj17;
        obj;
_L16:
        j = i;
        obj8 = obj4;
        obj5 = obj10;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj11 = FileTransfer.access$500(FileTransfer.FILE_NOT_FOUND_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj10;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.e("FileTransfer", ((JSONObject) (obj11)).toString(), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj10;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj1 = new PluginResult(org.apache.cordova.atus.IO_EXCEPTION, ((JSONObject) (obj11)));
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj4 != null && val$trustEveryone && val$useHttps)
        {
            obj = (HttpsURLConnection)obj4;
            ((HttpsURLConnection) (obj)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj3)));
            ((HttpsURLConnection) (obj)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj2)));
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null));
        }
        if (i == 0 && ((PluginResult) (obj)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj10 != null)
        {
            ((File) (obj10)).delete();
        }
        obj1 = val$context;
        break MISSING_BLOCK_LABEL_1490;
        obj6;
        obj5;
        JVM INSTR monitorexit ;
        obj15 = obj24;
        throw obj6;
_L5:
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj15 = val$context;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj15;
        JVM INSTR monitorenter ;
        val$context.connection = null;
        obj15;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        FileTransfer.access$300(((java.io.Closeable) (obj14)));
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        FileTransfer.access$300(((java.io.Closeable) (obj16)));
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.d("FileTransfer", (new StringBuilder()).append("Saved file: ").append(val$target).toString());
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj16 = webView.getClass();
        obj14 = null;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj15 = (PluginManager)((Class) (obj16)).getMethod("getPluginManager", new Class[0]).invoke(webView, new Object[0]);
        obj14 = obj15;
_L18:
        obj15 = obj14;
        if (obj14 != null)
        {
            break MISSING_BLOCK_LABEL_4988;
        }
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj15 = (PluginManager)((Class) (obj16)).getField("pluginManager").get(webView);
_L17:
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj = val$resourceApi.mapUriToFile(val$targetUri);
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        val$context.targetFile = ((File) (obj));
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj14 = (FileUtils)((PluginManager) (obj15)).getPlugin("File");
        if (obj14 == null) goto _L8; else goto _L7
_L7:
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj14 = ((FileUtils) (obj14)).getEntryForFile(((File) (obj)));
        if (obj14 == null) goto _L10; else goto _L9
_L9:
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj14 = new PluginResult(org.apache.cordova.atus.OK, ((JSONObject) (obj14)));
        obj1 = obj14;
        obj5 = obj;
_L11:
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj4 != null && val$trustEveryone && val$useHttps)
        {
            obj = (HttpsURLConnection)obj4;
            ((HttpsURLConnection) (obj)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj3)));
            ((HttpsURLConnection) (obj)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj2)));
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null));
        }
        if (i == 0 && ((PluginResult) (obj)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj5 != null)
        {
            ((File) (obj5)).delete();
        }
        obj1 = val$context;
        break MISSING_BLOCK_LABEL_1490;
_L10:
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj14 = FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null);
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.e("FileTransfer", "File plugin cannot represent download path");
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj14 = new PluginResult(org.apache.cordova.atus.IO_EXCEPTION, ((JSONObject) (obj14)));
        obj5 = obj;
        obj1 = obj14;
          goto _L11
_L8:
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.e("FileTransfer", "File plugin not found; cannot save downloaded file");
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj14 = new PluginResult(org.apache.cordova.atus.ERROR, "File plugin not found; cannot save downloaded file");
        obj5 = obj;
        obj1 = obj14;
          goto _L11
        obj;
        obj1 = null;
        obj2 = obj5;
        obj11 = obj17;
        obj4 = obj14;
_L12:
        j = i;
        obj8 = obj4;
        obj5 = obj11;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj10 = FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj11;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.e("FileTransfer", ((JSONObject) (obj10)).toString(), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj11;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj1 = new PluginResult(org.apache.cordova.atus.IO_EXCEPTION, ((JSONObject) (obj10)));
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj4 != null && val$trustEveryone && val$useHttps)
        {
            obj = (HttpsURLConnection)obj4;
            ((HttpsURLConnection) (obj)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj3)));
            ((HttpsURLConnection) (obj)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj2)));
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null));
        }
        if (i == 0 && ((PluginResult) (obj)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj11 != null)
        {
            ((File) (obj11)).delete();
        }
        obj1 = val$context;
        break MISSING_BLOCK_LABEL_1490;
        obj;
        obj1 = null;
        obj2 = obj7;
        obj3 = obj6;
        obj12 = obj18;
        obj4 = obj15;
        i = j;
_L13:
        j = i;
        obj8 = obj4;
        obj5 = obj12;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.e("FileTransfer", ((JSONException) (obj)).getMessage(), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj12;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj1 = new PluginResult(org.apache.cordova.atus.JSON_EXCEPTION);
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj4 != null && val$trustEveryone && val$useHttps)
        {
            obj = (HttpsURLConnection)obj4;
            ((HttpsURLConnection) (obj)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj3)));
            ((HttpsURLConnection) (obj)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj2)));
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null));
        }
        if (i == 0 && ((PluginResult) (obj)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj12 != null)
        {
            ((File) (obj12)).delete();
        }
        obj1 = val$context;
        break MISSING_BLOCK_LABEL_1490;
        obj;
        obj1 = null;
        obj2 = obj10;
        obj3 = obj8;
        obj13 = obj20;
        obj4 = obj16;
        i = ((flag) ? 1 : 0);
_L14:
        j = i;
        obj8 = obj4;
        obj5 = obj13;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj10 = FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj13;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        Log.e("FileTransfer", ((JSONObject) (obj10)).toString(), ((Throwable) (obj)));
        j = i;
        obj8 = obj4;
        obj5 = obj13;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        obj1 = new PluginResult(org.apache.cordova.atus.IO_EXCEPTION, ((JSONObject) (obj10)));
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj4 != null && val$trustEveryone && val$useHttps)
        {
            obj = (HttpsURLConnection)obj4;
            ((HttpsURLConnection) (obj)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj3)));
            ((HttpsURLConnection) (obj)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj2)));
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj4)), null));
        }
        if (i == 0 && ((PluginResult) (obj)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj13 != null)
        {
            ((File) (obj13)).delete();
        }
        obj1 = val$context;
        break MISSING_BLOCK_LABEL_1490;
        obj1;
        obj = obj25;
        obj6 = obj13;
        obj7 = obj11;
        obj5 = obj21;
        obj8 = obj19;
        j = ((flag1) ? 1 : 0);
_L15:
        synchronized (FileTransfer.access$600())
        {
            FileTransfer.access$600().remove(val$objectId);
        }
        if (obj8 != null && val$trustEveryone && val$useHttps)
        {
            obj2 = (HttpsURLConnection)obj8;
            ((HttpsURLConnection) (obj2)).setHostnameVerifier(((javax.net.ssl.HostnameVerifier) (obj7)));
            ((HttpsURLConnection) (obj2)).setSSLSocketFactory(((javax.net.ssl.SSLSocketFactory) (obj6)));
        }
        obj2 = obj;
        if (obj == null)
        {
            obj2 = new PluginResult(org.apache.cordova.atus.ERROR, FileTransfer.access$500(FileTransfer.CONNECTION_ERR, val$source, val$target, ((java.net.URLConnection) (obj8)), null));
        }
        if (j == 0 && ((PluginResult) (obj2)).getStatus() != org.apache.cordova.atus.OK.ordinal() && obj5 != null)
        {
            ((File) (obj5)).delete();
        }
        val$context.sendPluginResult(((PluginResult) (obj2)));
        throw obj1;
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj14;
        obj16;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        throw obj14;
        obj;
          goto _L12
        obj14;
        obj15;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        throw obj14;
        obj;
          goto _L13
        obj;
        obj5;
        JVM INSTR monitorexit ;
        throw obj;
        obj14;
        obj15;
        JVM INSTR monitorexit ;
        obj10 = obj;
        obj11 = obj;
        obj12 = obj;
        obj13 = obj;
        j = i;
        obj8 = obj4;
        obj5 = obj;
        obj7 = obj3;
        obj6 = obj2;
        obj9 = obj1;
        throw obj14;
        obj;
          goto _L14
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj = obj9;
          goto _L15
        obj;
        obj1 = null;
        i = ((flag2) ? 1 : 0);
        obj4 = obj23;
        obj10 = obj22;
        obj3 = obj12;
        obj2 = obj9;
          goto _L16
        obj5;
        obj15 = obj14;
          goto _L17
        obj5;
        obj15 = obj14;
          goto _L17
        obj5;
          goto _L18
        obj5;
          goto _L18
        obj5;
          goto _L18
        obj5 = obj;
          goto _L11
    }

    questContext()
    {
        this$0 = final_filetransfer;
        val$context = questcontext;
        val$resourceApi = cordovaresourceapi;
        val$targetUri = uri;
        val$sourceUri = uri1;
        val$isLocalTransfer = flag;
        val$useHttps = flag1;
        val$trustEveryone = flag2;
        val$headers = jsonobject;
        val$source = s;
        val$target = s1;
        val$objectId = String.this;
        super();
    }
}
