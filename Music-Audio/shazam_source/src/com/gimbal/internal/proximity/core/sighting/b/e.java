// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.b;

import com.gimbal.a.b;
import com.gimbal.internal.b.a.a;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.f.g;
import com.gimbal.internal.proximity.core.g.d;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersRequest;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersResponse;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.impl.TransmitterInternal;
import java.util.List;
import org.springframework.util.CollectionUtils;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting.b:
//            d

public class e
    implements com.gimbal.internal.proximity.core.sighting.b.d
{

    private static final com.gimbal.a.a a = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/sighting/b/e.getName());
    private com.gimbal.internal.proximity.core.sighting.g b;
    private d c;
    private com.gimbal.internal.proximity.core.g.a d;
    private com.gimbal.internal.proximity.core.service.a.a e;
    private a f;

    public e(com.gimbal.internal.proximity.core.sighting.g g1, com.gimbal.internal.proximity.core.g.a a1, d d1, com.gimbal.internal.proximity.core.service.a.a a2, a a3)
    {
        c = d1;
        d = a1;
        b = g1;
        e = a2;
        f = a3;
    }

    static com.gimbal.internal.proximity.core.service.a.a a(e e1)
    {
        return e1.e;
    }

    private void a(int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = f;
        if (((a) (s)).b && ((a) (s)).c)
        {
            a.a.b("Sighted unknown Gimbal beacon", new Object[0]);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void a(ResolveTransmittersResponse resolvetransmittersresponse)
    {
        this;
        JVM INSTR monitorenter ;
        TransmitterInternal transmitterinternal;
        Sighting sighting;
        transmitterinternal = new TransmitterInternal();
        transmitterinternal.setIdentifier(resolvetransmittersresponse.getUuid());
        transmitterinternal.setUuid(resolvetransmittersresponse.getExternalUuid());
        transmitterinternal.setName(resolvetransmittersresponse.getName());
        transmitterinternal.setOwnerId(resolvetransmittersresponse.getOwnerId());
        resolvetransmittersresponse.getSighting().getPayload();
        transmitterinternal.getIdentifier();
        transmitterinternal.getName();
        sighting = resolvetransmittersresponse.getSighting();
        if (CollectionUtils.isEmpty(resolvetransmittersresponse.getLookupKeys())) goto _L2; else goto _L1
_L1:
        String s;
        int j;
        int k;
        s = com.gimbal.internal.c.c.a((String)resolvetransmittersresponse.getLookupKeys().get(0));
        d.a(transmitterinternal, s);
        if (resolvetransmittersresponse.getDataMasks() != null && resolvetransmittersresponse.getDataMasks().size() > 0)
        {
            String s1 = (String)resolvetransmittersresponse.getDataMasks().get(0);
            com.gimbal.internal.proximity.core.g.c.a().a(s1, s);
        }
        j = resolvetransmittersresponse.getLookupKeys().size();
        k = resolvetransmittersresponse.getDataMasks().size();
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        String s2 = (String)resolvetransmittersresponse.getLookupKeys().get(i);
        if (k <= i)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        String s3 = (String)resolvetransmittersresponse.getDataMasks().get(i);
        com.gimbal.internal.proximity.core.g.c.a().a(s3, s2);
        d.a(transmitterinternal, s2);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        resolvetransmittersresponse = (Sighting)c.a.a(s, com/gimbal/internal/proximity/core/sighting/Sighting);
        if (resolvetransmittersresponse == null) goto _L6; else goto _L5
_L5:
        sighting.getPayload();
        c.a.a(s);
        b.a(resolvetransmittersresponse, transmitterinternal);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        sighting.getPayload();
        if (true) goto _L2; else goto _L7
_L7:
        resolvetransmittersresponse;
        throw resolvetransmittersresponse;
    }

    static void a(e e1, int i, String s)
    {
        e1.a(i, s);
    }

    static void a(e e1, ResolveTransmittersResponse resolvetransmittersresponse)
    {
        e1.a(resolvetransmittersresponse);
    }

    public final boolean a(Sighting sighting)
    {
        boolean flag;
        if (!c.a(com.gimbal.internal.c.c.d(sighting.getPayload())).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            sighting.getPayload();
            c.a(sighting);
            ResolveTransmittersRequest resolvetransmittersrequest = new ResolveTransmittersRequest();
            resolvetransmittersrequest.setPayload(sighting.getPayload());
            resolvetransmittersrequest.setSighting(sighting);
            sighting = e;
            com.gimbal.internal.proximity.c c1 = new com.gimbal.internal.proximity.c(resolvetransmittersrequest) {

                private ResolveTransmittersRequest a;
                private e b;

                public final void a(int i, String s)
                {
                    com.gimbal.internal.proximity.core.sighting.b.e.a(b, i, s);
                }

                public final void a(Object obj)
                {
                    obj = (ResolveTransmittersResponse)obj;
                    com.gimbal.internal.proximity.core.sighting.b.e.a(b, ((ResolveTransmittersResponse) (obj)));
                    obj = com.gimbal.internal.proximity.core.sighting.b.e.a(b);
                    ResolveTransmittersRequest resolvetransmittersrequest1 = a;
                    com.gimbal.internal.proximity.c c2 = b. new com.gimbal.internal.proximity.c() {

                        private e a;

                        public final void a(int i, String s)
                        {
                            com.gimbal.internal.proximity.core.sighting.b.e.a(a, i, s);
                        }

                        public final volatile void a(Object obj)
                        {
                            obj = (ResolveTransmittersResponse)obj;
                            com.gimbal.internal.proximity.core.sighting.b.e.a(a, ((ResolveTransmittersResponse) (obj)));
                        }

            
            {
                a = e.this;
                super();
            }
                    };
                    (new com.gimbal.internal.proximity.core.service.b.b(((com.gimbal.internal.proximity.core.service.a.a) (obj)).b)).b(resolvetransmittersrequest1, c2, ((com.gimbal.internal.proximity.core.service.a.a) (obj)).a);
                }

            
            {
                b = e.this;
                a = resolvetransmittersrequest;
                super();
            }
            };
            (new com.gimbal.internal.proximity.core.service.b.a(((com.gimbal.internal.proximity.core.service.a.a) (sighting)).b)).b(resolvetransmittersrequest, c1, ((com.gimbal.internal.proximity.core.service.a.a) (sighting)).a);
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/core/sighting/b/e.getName());
    }
}
