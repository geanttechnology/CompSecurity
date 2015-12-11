// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mopub.common.b;

abstract class g extends Activity
{
    static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a d[];
        String c;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/mopub/mobileads/g$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        protected final String a()
        {
            return (new StringBuilder("javascript:")).append(c).toString();
        }

        static 
        {
            a = new a("WEB_VIEW_DID_APPEAR", 0, "webviewDidAppear();");
            b = new a("WEB_VIEW_DID_CLOSE", 1, "webviewDidClose();");
            d = (new a[] {
                a, b
            });
        }

        private a(String s, int i, String s1)
        {
            super(s, i);
            c = s1;
        }
    }


    protected b a;
    com.mopub.common.g b;
    Long c;

    g()
    {
    }

    private static b a(Intent intent)
    {
        try
        {
            intent = (b)intent.getSerializableExtra("mopub-intent-ad-report");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public abstract View a();

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.hasExtra("broadcastIdentifier"))
        {
            bundle = Long.valueOf(intent.getLongExtra("broadcastIdentifier", -1L));
        } else
        {
            bundle = null;
        }
        c = bundle;
        a = a(intent);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        bundle = a();
        b = new com.mopub.common.g(this);
        b.setOnCloseListener(new com.mopub.common.b() {

            final g a;

            public final void a()
            {
                a.finish();
            }

            
            {
                a = g.this;
                super();
            }
        });
        b.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        setContentView(b);
    }

    protected void onDestroy()
    {
        b.removeAllViews();
        super.onDestroy();
    }
}
