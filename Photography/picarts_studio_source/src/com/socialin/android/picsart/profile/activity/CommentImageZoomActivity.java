// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.socialin.android.activity.BaseActivity;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            c

public class CommentImageZoomActivity extends BaseActivity
{

    private ImageView a;
    private com.bumptech.glide.request.d b;

    public CommentImageZoomActivity()
    {
        b = new c(this, (byte)0);
    }

    static ImageView a(CommentImageZoomActivity commentimagezoomactivity)
    {
        return commentimagezoomactivity.a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03008f);
        a = (ImageView)findViewById(0x7f100335);
        bundle = getIntent().getStringExtra("url");
        if (bundle != null)
        {
            (new d(getApplicationContext())).a(bundle, a, b, e.b(l.e));
        }
        findViewById(0x7f100333).setOnClickListener(new android.view.View.OnClickListener() {

            private CommentImageZoomActivity a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = CommentImageZoomActivity.this;
                super();
            }
        });
    }
}
