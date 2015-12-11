// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.shazam.android.activities.b;
import com.shazam.android.activities.sheet.ShareDataBottomSheetActivity;
import com.shazam.android.widget.c.f;
import com.shazam.i.b.ay.a.a;
import com.shazam.model.configuration.ShareTagConfiguration;
import com.shazam.model.share.ShareData;

public class ShareTagDialogActivity extends com.shazam.android.activities.b
    implements com.shazam.p.q.b
{
    private final class a
        implements android.view.View.OnClickListener
    {

        final ShareTagDialogActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.share.ShareTagDialogActivity.a(a).b.b();
        }

        private a()
        {
            a = ShareTagDialogActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.view.View.OnClickListener
    {

        final ShareTagDialogActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.share.ShareTagDialogActivity.a(a).a.a();
        }

        private b()
        {
            a = ShareTagDialogActivity.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }


    private final ShareTagConfiguration g = com.shazam.i.b.n.b.S();
    private final f h = com.shazam.i.b.ay.a.a.b();
    private com.shazam.l.p.b i;

    public ShareTagDialogActivity()
    {
    }

    public static Bundle a(ShareData sharedata)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("share_data", sharedata);
        return bundle;
    }

    static com.shazam.l.p.b a(ShareTagDialogActivity sharetagdialogactivity)
    {
        return sharetagdialogactivity.i;
    }

    public final void a()
    {
        ShareData sharedata = (ShareData)getIntent().getSerializableExtra("share_data");
        h.a(this, com.shazam.android.k.f.a.a(com.shazam.android.k.f.a.r, new Object[0]), ShareDataBottomSheetActivity.a(sharedata));
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(0x7f09010f);
        b(0x7f03002d);
        d(0x7f090145);
        c(0x7f0900bb);
        super.c.setVisibility(0);
        super.c.setText(0x7f09006d);
        a(new b((byte)0));
        c(new a((byte)0));
        i = new com.shazam.l.p.b(this, g);
    }
}
