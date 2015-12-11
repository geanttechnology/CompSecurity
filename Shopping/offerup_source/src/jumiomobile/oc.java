// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.util.SparseArray;
import com.jumio.commons.camera.ImageData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.SSLException;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            ai, cb, oa, hu, 
//            ob, ag, aa, u, 
//            w, n, av, cs, 
//            hq, oo

class oc extends ai
{

    final oa e;
    private NVScanSide f;

    public oc(oa oa1, NVScanSide nvscanside)
    {
        e = oa1;
        super();
        f = nvscanside;
    }

    protected transient Boolean a(Void avoid[])
    {
        byte abyte0[];
        abyte0 = null;
        cb.a(getClass());
        oa.a(e).c = hu.q;
        ImageData imagedata = (ImageData)oa.a(e).u.get(f.getPartNumber());
        Object obj = "";
        int i = ob.b[f.ordinal()];
        i;
        JVM INSTR tableswitch 1 3: default 92
    //                   1 1019
    //                   2 1238
    //                   3 1026;
           goto _L1 _L2 _L3 _L4
_L1:
        DataOutputStream dataoutputstream;
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            -15, 42, 43, 27, 67, 85
        }, 0xda48f40463225c5L)).append(oa.a(e).j).append(ag.a(new byte[] {
            -40, -15, -72, -59, -38, 20, -54, 48
        }, 0xcf41846d7a16e99cL)).append(((String) (obj))).toString());
        a = e.a("POST", avoid);
        a.setRequestProperty("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(d).toString());
        dataoutputstream = new DataOutputStream(a.getOutputStream());
        aa aa1;
        dataoutputstream.writeBytes((new StringBuilder("--")).append(d).append("\r\n").toString());
        aa1 = new aa();
        long l;
        long l1;
        boolean flag;
        if (imagedata.d() == u.a)
        {
            avoid = "front";
        } else
        {
            avoid = "back";
        }
        aa1.put("cameraPosition", avoid);
        ob.c[imagedata.c().ordinal()];
        JVM INSTR tableswitch 1 4: default 1225
    //                   1 1245
    //                   2 1252
    //                   3 1259
    //                   4 1266;
           goto _L5 _L6 _L7 _L8 _L9
_L21:
        aa1.put("orientationMode", avoid);
        avoid = imagedata.a();
        aa1.put("imageSize", String.format(Locale.GERMAN, "%dx%d", new Object[] {
            Integer.valueOf(((n) (avoid)).a), Integer.valueOf(((n) (avoid)).b)
        }));
        aa1.put("flashMode", Boolean.toString(imagedata.b()));
        aa1.put("focusConfidence", Float.toString(imagedata.e()));
        dataoutputstream.writeBytes("Content-Disposition: form-data; name=\"cameraDeviceDetail\"\r\n");
        dataoutputstream.writeBytes("Content-Type: application/json; charset=UTF-8\r\n");
        dataoutputstream.writeBytes((new StringBuilder("Content-Length: ")).append(aa1.toString().length()).append("\r\n").toString());
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes((new StringBuilder()).append(aa1.toString()).append("\r\n").toString());
        dataoutputstream.writeBytes((new StringBuilder("--")).append(d).append("\r\n").toString());
        abyte0 = av.a(imagedata.f());
        if (!cs.a()) goto _L11; else goto _L10
_L10:
        avoid = "";
        if (oa.a(e).J != hq.a && oa.a(e).J != hq.c && oa.a(e).J != hq.d && oa.a(e).J != hq.e) goto _L13; else goto _L12
_L17:
        oo.a(abyte0, oo.a(oa.a(e).a, (new StringBuilder()).append(avoid).append(oa.a(e).j).toString()), String.format(Locale.getDefault(), "%s_%s.webp", new Object[] {
            obj, oa.a(e).j
        }));
_L11:
        dataoutputstream.writeBytes("Content-Disposition: form-data; name=\"image\"; filename=\"image.webp\"\r\n");
        dataoutputstream.writeBytes("Content-Type: image/webp\r\n");
        dataoutputstream.writeBytes((new StringBuilder("Content-Length: ")).append(abyte0.length).append("\r\n").toString());
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.write(abyte0);
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes((new StringBuilder("--")).append(d).append("--\r\n").toString());
        dataoutputstream.flush();
        l = System.currentTimeMillis();
        b(0x15f90);
        i = a.getResponseCode();
        l1 = System.currentTimeMillis();
        avoid = oa.f(e, a);
        dataoutputstream.close();
        a(i);
        if (oo.a())
        {
            cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
                getClass().getName(), oa.a(e).j, Long.valueOf(l1 - l), Integer.valueOf(i), avoid
            }));
        }
        System.gc();
        avoid = new JSONObject(avoid);
        if (!avoid.optString("httpStatus").isEmpty())
        {
            throw new Exception(avoid.optString("message"));
        }
          goto _L14
        avoid;
        oa.a(e, avoid, getClass());
        flag = false;
_L19:
        return Boolean.valueOf(flag);
_L2:
        obj = "FRONTSIDE";
          goto _L1
_L4:
        obj = "FACE";
          goto _L1
_L13:
        if (oa.a(e).J == hq.i || oa.a(e).J == hq.h)
        {
            break MISSING_BLOCK_LABEL_1273;
        }
        if (oa.a(e).J != hq.f) goto _L16; else goto _L15
_L15:
        avoid = "BC_";
          goto _L17
_L16:
        if (oa.a(e).J != hq.m) goto _L17; else goto _L18
_L18:
        avoid = "TM_";
          goto _L17
        avoid;
        i = 0;
        obj = null;
_L20:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1135;
        }
        ((DataOutputStream) (obj)).close();
        a(i);
        throw avoid;
        avoid;
        if (b())
        {
            oa.a(e, getClass(), false);
            flag = false;
        } else
        if (!isCancelled())
        {
            oa.a(e, avoid, getClass());
            flag = false;
        } else
        {
            a();
            flag = false;
        }
          goto _L19
_L14:
        flag = true;
          goto _L19
        avoid;
        i = 0;
        obj = dataoutputstream;
          goto _L20
        avoid;
        obj = dataoutputstream;
          goto _L20
_L5:
        avoid = abyte0;
          goto _L21
_L12:
        avoid = "MRZ_";
          goto _L17
_L3:
        obj = "BACKSIDE";
          goto _L1
_L6:
        avoid = "portrait";
          goto _L21
_L7:
        avoid = "reversePortrait";
          goto _L21
_L8:
        avoid = "landscape";
          goto _L21
_L9:
        avoid = "reverseLandscape";
          goto _L21
        avoid = "LF_";
          goto _L17
    }

    protected void a(Boolean boolean1)
    {
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.r, hu.s);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
