// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.os.Bundle;
import android.support.v4.app.q;
import android.view.MenuItem;
import com.rdio.android.sdk.activity.OAuth2WebViewActivity;
import com.shazam.android.p.k;
import com.shazam.android.p.l;
import com.shazam.i.b.r.e;

// Referenced classes of package com.shazam.android.activities:
//            c

public class RdioSignInActivity extends OAuth2WebViewActivity
    implements c
{

    private final k a;
    private final l b;

    public RdioSignInActivity()
    {
        this(((k) (e.a())), new l());
    }

    public RdioSignInActivity(k k1, l l1)
    {
        a = k1;
        b = l1;
    }

    public void onBackPressed()
    {
        setResult(-2);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            q.a(this);
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (!a.a())
        {
            l.a(this);
        }
    }
}
