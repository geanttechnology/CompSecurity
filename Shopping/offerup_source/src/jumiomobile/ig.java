// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;

// Referenced classes of package jumiomobile:
//            id, mk, ih, ao, 
//            ii, mt, g

public class ig extends id
{

    private ih h;
    private boolean i;
    private boolean j;

    public ig(Context context, ModelTemplate modeltemplate, ao ao, ii ii, mt mt, g g1)
    {
        super(context, modeltemplate, ao, ii);
        i = false;
        j = false;
    }

    public String a(NVDocumentType nvdocumenttype, NVScanSide nvscanside)
    {
        return mk.a(a, "infobar_camera_view_face");
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        i = false;
        j = false;
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
        if (i && !j)
        {
            j = true;
            h = new ih(this, abyte0);
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
        i = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String j()
    {
        return mk.a(a, "actionbar_title_scan_face");
    }
}
