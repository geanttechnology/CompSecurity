// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            cv, cu, bb, bi, 
//            bh, bj, bl, bu, 
//            bv, bp, bn, cf, 
//            bg, bq, bx, bs, 
//            by, cc, cd, au, 
//            ay, dg

public final class cp
    implements cv
{

    private JSONObject a;
    private JSONObject b;
    private JSONArray c;
    private JSONArray d;
    private File e;
    private String f;

    public cp(File file, ay ay1, ay ay2, ay ay3, ay ay4)
    {
        file.exists();
        f = cu.a.a();
        e = file;
        a = (new bb()).a(new bi()).a(new bh()).a(new bj()).a(new bl()).a(new bu()).a(new bv()).a(new bp()).a(new bn()).a(new cf()).a(new bg()).a(new bq()).a(new bx()).a(new bs()).a(new by()).a(new cc()).a(new cd()).a();
        file = new HashMap();
        file.put("crashed_session", (new au(ay1)).a);
        if (ay2.b() > 0)
        {
            file.put("previous_session", (new au(ay2)).a);
        }
        b = new JSONObject(file);
        c = (new au(ay3)).a;
        d = (new au(ay4)).a;
    }

    public final void a(OutputStream outputstream)
    {
        HashMap hashmap1 = new HashMap();
        hashmap1.put("app_state", a);
        hashmap1.put("breadcrumbs", b);
        hashmap1.put("endpoints", c);
        hashmap1.put("systemBreadcrumbs", d);
        byte abyte0[] = new byte[0];
        byte abyte2[] = new byte[8192];
        FileInputStream fileinputstream = new FileInputStream(e);
        do
        {
            int i = fileinputstream.read(abyte2);
            if (i != -1)
            {
                byte abyte1[] = new byte[abyte0.length + i];
                System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
                System.arraycopy(abyte2, 0, abyte1, abyte0.length, i);
                abyte0 = abyte1;
            } else
            {
                fileinputstream.close();
                HashMap hashmap = new HashMap();
                hashmap.put("dmp_name", e.getName());
                hashmap.put("dmp_file", dg.a(abyte0));
                hashmap1.put("ndk_dmp_info", new JSONObject(hashmap));
                outputstream.write((new JSONObject(hashmap1)).toString().getBytes());
                return;
            }
        } while (true);
    }

    public final String f()
    {
        return f;
    }
}
