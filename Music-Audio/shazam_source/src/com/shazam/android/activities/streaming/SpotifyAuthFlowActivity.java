// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shazam.android.an.b.e;
import com.shazam.i.b.ai.b;
import com.shazam.i.b.ai.b.a;
import com.shazam.i.b.ai.b.f;

// Referenced classes of package com.shazam.android.activities.streaming:
//            c

public class SpotifyAuthFlowActivity extends c
    implements android.view.View.OnClickListener
{

    private final e c = com.shazam.i.b.ai.b.a.a();

    public SpotifyAuthFlowActivity()
    {
        super(f.a(), com.shazam.i.b.ai.b.b());
    }

    protected final void a()
    {
        c.a();
        super.a();
    }

    public final void b()
    {
        throw new UnsupportedOperationException("Not implemented for Spotify.");
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1024)
        {
            c.a(j, intent);
            a.b();
        }
    }

    public void onClick(View view)
    {
        i();
        c.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c.a(this);
        a(this);
    }
}
