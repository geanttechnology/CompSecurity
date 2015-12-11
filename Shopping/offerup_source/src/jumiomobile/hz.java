// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import java.util.List;

// Referenced classes of package jumiomobile:
//            ij, ia, ba, hh, 
//            ii, q, ib, bg, 
//            ao, mt, g, hp

public class hz extends ij
{

    private int l;
    private byte m[];
    private BroadcastReceiver n;

    public hz(Context context, ModelTemplate modeltemplate, ao ao, ii ii1, mt mt, g g, hp hp)
    {
        super(context, modeltemplate, ao, ii1, mt, g, hp);
        l = 0;
        m = null;
        n = new ia(this);
        l = (int)System.currentTimeMillis();
        modeltemplate = new IntentFilter();
        modeltemplate.addAction("com.jumio.netverify.sdk.ACTION_EXTRACTION_FINISHED");
        ba.a(context).a(n, modeltemplate);
    }

    static int a(hz hz1)
    {
        return hz1.l;
    }

    static byte[] a(hz hz1, byte abyte0[])
    {
        hz1.m = abyte0;
        return abyte0;
    }

    public void a()
    {
        e.b.a((Country)e.d().get(e.w), e.v.getId(), m, l);
    }

    public void a(byte abyte0[], int i, int j, byte abyte1[], int k, int i1, float f)
    {
        d.a(f);
        d.c(true);
        abyte1 = q.a(abyte1, k, i1);
        abyte0 = new ib(this, abyte1);
        ii ii1 = d;
        f = bg.a(a, 15);
        if (e.F)
        {
            abyte0 = null;
        }
        ii1.a(abyte1, f, abyte0);
    }

    public void b()
    {
        m = null;
        ba.a(a).a(n);
    }
}
