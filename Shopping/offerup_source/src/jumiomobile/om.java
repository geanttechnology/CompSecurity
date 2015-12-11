// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.util.SparseArray;
import com.jumio.commons.camera.ImageData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Referenced classes of package jumiomobile:
//            ai, ob, oa, hu, 
//            ol, hq, av, ab

class om extends ai
{

    final oa e;

    private om(oa oa1)
    {
        e = oa1;
        super();
    }

    om(oa oa1, ob ob1)
    {
        this(oa1);
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.TRUE;
    }

    protected void a(Boolean boolean1)
    {
        ob.a[oa.a(e).c.ordinal()];
        JVM INSTR tableswitch 1 13: default 551
    //                   1 154
    //                   2 161
    //                   3 154
    //                   4 154
    //                   5 161
    //                   6 222
    //                   7 222
    //                   8 371
    //                   9 451
    //                   10 451
    //                   11 451
    //                   12 451
    //                   13 533;
           goto _L1 _L2 _L3 _L2 _L2 _L3 _L4 _L4 _L5 _L6 _L6 _L6 _L6 _L7
_L1:
        oa.a(e, new ol(e, null), false);
_L13:
        if (!oa.i(e).isEmpty())
        {
            oa.e(e, (ai)oa.j(e).remove(0));
            oa.f(e, oa.k(e));
        }
        return;
_L2:
        e.f();
_L3:
        oa.a(e, (Country)oa.a(e).d().get(oa.a(e).w), oa.a(e).v.getId(), oa.a(e).v.getDocumentVariant());
_L4:
        if (oa.a(e).J != hq.h && oa.a(e).J != hq.m) goto _L5; else goto _L8
_L8:
        int j = NVScanSide.FRONT.getPartNumber();
        int i = j;
        if (!"DEU".equals(oa.a(e).f().b())) goto _L10; else goto _L9
_L9:
        i = j;
        if (oa.a(e).v.getId() == NVDocumentType.IDENTITY_CARD)
        {
            i = NVScanSide.BACK.getPartNumber();
        }
_L10:
        boolean1 = (ImageData)oa.a(e).u.get(i);
        e.a(oa.a(e).f(), oa.a(e).v.getId(), av.a(boolean1.h()), 0);
_L5:
        if (oa.a(e).J != hq.i && oa.a(e).J != hq.j && oa.a(e).J != hq.k)
        {
            boolean1 = new ArrayList();
            boolean1.add(oa.a(e).J);
            oa.a(e, boolean1, 0);
        }
_L6:
        boolean1 = oa.a(e).v.getUploadParts(oa.a(e).s);
        j = boolean1.length;
        i = 0;
_L14:
        if (i >= j) goto _L7; else goto _L11
_L11:
        NVScanSide nvscanside = boolean1[i];
        if (!"SKIPPED".equals(((ImageData)oa.a(e).u.get(nvscanside.getPartNumber())).f()))
        {
            oa.a(e, nvscanside);
        }
          goto _L12
_L7:
        oa.h(e);
          goto _L1
        boolean1;
        ab.a(boolean1);
          goto _L13
_L12:
        i++;
          goto _L14
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
