// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shazam.android.util.s;
import com.shazam.i.b.ai.a.a;
import com.shazam.i.b.ai.b;
import com.shazam.i.b.ai.b.f;
import com.shazam.i.b.au.d;

// Referenced classes of package com.shazam.android.activities.streaming:
//            c

public class RdioAuthFlowActivity extends c
    implements android.view.View.OnClickListener
{

    private final com.shazam.android.an.a.f c = com.shazam.i.b.ai.a.a.a();
    private final s d = com.shazam.i.b.au.d.a();

    public RdioAuthFlowActivity()
    {
        super(f.b(), b.a());
    }

    protected final void a()
    {
        c.a();
        super.a();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (c.a(i, j, intent))
        {
            super.onActivityResult(i, j, intent);
        }
    }

    public void onClick(View view)
    {
        i();
        try
        {
            c.a(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view = d;
        }
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.b = getString(0x7f0900a1);
        view.a(a1.a());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c.a(this);
        c.a(true);
        a(this);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        c.b();
    }
}
