// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.sheet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shazam.a.g;
import com.shazam.android.j.w.c;
import com.shazam.android.k.b.i;
import com.shazam.android.k.e.o;
import com.shazam.i.c.b;
import com.shazam.i.d.d;
import com.shazam.model.share.ShareData;
import com.shazam.p.q.a;

// Referenced classes of package com.shazam.android.activities.sheet:
//            a

public class ShareTagBottomSheetActivity extends com.shazam.android.activities.sheet.a
    implements a
{

    private final g a = com.shazam.i.c.b.a();
    private final c b = com.shazam.i.b.n.b.E();
    private final com.shazam.b.a.a c = com.shazam.i.d.d.F();
    private ShareData d;

    public ShareTagBottomSheetActivity()
    {
    }

    public static Bundle a(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("post_id", s);
        return bundle;
    }

    public final void a()
    {
        finish();
    }

    public final void a(View view, int j)
    {
        (new com.shazam.android.widget.share.b()).a(d, j, view, null);
    }

    public final void a(ShareData sharedata)
    {
        d = sharedata;
        a(sharedata.a());
    }

    public final void b()
    {
        com.shazam.android.activities.b.b.b(this);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getStringExtra("post_id");
        bundle = new com.shazam.l.p.a(this, new com.shazam.android.k.b.a(getSupportLoaderManager(), 10033, this, new o(b, a, c, bundle), i.a));
        ((com.shazam.l.p.a) (bundle)).b.a(new com.shazam.l.p.a.a(bundle, (byte)0));
        ((com.shazam.l.p.a) (bundle)).b.a();
    }
}
