// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;

// Referenced classes of package jumiomobile:
//            id, mk, iv, iw, 
//            ao, ii, mt, g

public class iu extends id
{

    private iw h;
    private iv i;
    private boolean j;
    private boolean k;
    private boolean l;

    public iu(Context context, ModelTemplate modeltemplate, ao ao, ii ii, mt mt, g g1)
    {
        super(context, modeltemplate, ao, ii);
        j = false;
        k = false;
        l = false;
    }

    static boolean a(iu iu1, boolean flag)
    {
        iu1.j = flag;
        return flag;
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        return mk.a(a, "infobar_camera_view_manual");
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        k = false;
        l = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void b(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (!j)
        {
            j = true;
            i = new iv(this, abyte0);
            i.start();
        }
        if (k && !l)
        {
            l = true;
            h = new iw(this, abyte0);
            h.start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public void e()
    {
        a();
    }

    public boolean g()
    {
        return true;
    }

    public void h()
    {
        this;
        JVM INSTR monitorenter ;
        k = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String j()
    {
        return mk.a(a, "actionbar_title_scan");
    }
}
