// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;

public final class awh
    implements atr
{

    public awh()
    {
    }

    private qq a(qm qm1, att att, IntentFilter aintentfilter[])
    {
        return qm1.a(new awi(qm1, att, aintentfilter));
    }

    private void a(Asset asset)
    {
        if (asset == null)
        {
            throw new IllegalArgumentException("asset is null");
        }
        if (asset.b() == null)
        {
            throw new IllegalArgumentException("invalid asset");
        }
        if (asset.a() != null)
        {
            throw new IllegalArgumentException("invalid asset");
        } else
        {
            return;
        }
    }

    public qq a(qm qm1, att att)
    {
        return a(qm1, att, null);
    }

    public qq a(qm qm1, Asset asset)
    {
        a(asset);
        return qm1.a(new awf(qm1, asset) {

            final Asset b;
            final awh c;

            protected qt a(Status status)
            {
                return c(status);
            }

            protected void a(awc awc1)
            {
                awc1.a(this, b);
            }

            protected void b(qd qd)
            {
                a((awc)qd);
            }

            protected atu c(Status status)
            {
                return new awk(status, null);
            }

            
            {
                c = awh.this;
                b = asset;
                super(qm1);
            }
        });
    }

    public qq a(qm qm1, PutDataRequest putdatarequest)
    {
        return qm1.a(new awf(qm1, putdatarequest) {

            final PutDataRequest b;
            final awh c;

            public qt a(Status status)
            {
                return c(status);
            }

            protected void a(awc awc1)
            {
                awc1.a(this, b);
            }

            protected void b(qd qd)
            {
                a((awc)qd);
            }

            public ats c(Status status)
            {
                return new awj(status, null);
            }

            
            {
                c = awh.this;
                b = putdatarequest;
                super(qm1);
            }
        });
    }

    public qq b(qm qm1, att att)
    {
        return qm1.a(new awf(qm1, att) {

            final att b;
            final awh c;

            public qt a(Status status)
            {
                return c(status);
            }

            protected void a(awc awc1)
            {
                awc1.a(this, b);
            }

            protected void b(qd qd)
            {
                a((awc)qd);
            }

            public Status c(Status status)
            {
                return status;
            }

            
            {
                c = awh.this;
                b = att;
                super(qm1);
            }
        });
    }
}
