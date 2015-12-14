// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import acl;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import bog;
import com.wantu.setting.BackPathActionBarView;
import java.util.Locale;
import sm;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity

public class StorePathActivity extends FullscreenActivity
    implements bog
{

    TextView a;
    TextView b;
    FrameLayout c;
    TextView d;
    TextView e;
    BackPathActionBarView f;

    public StorePathActivity()
    {
    }

    public void a()
    {
        a = (TextView)findViewById(0x7f0d0339);
        b = (TextView)findViewById(0x7f0d033a);
        c = (FrameLayout)findViewById(0x7f0d033b);
        d = (TextView)findViewById(0x7f0d033c);
        e = (TextView)findViewById(0x7f0d033d);
        f = (BackPathActionBarView)findViewById(0x7f0d00b3);
        f.saveButtomIsShow(false);
        f.setBackTopLayerListener(this);
        b.setText(sm.a());
        if (Locale.getDefault().getLanguage().compareTo("zh") != 0)
        {
            a.setTextSize(18F);
            d.setTextSize(22F);
            e.setTextSize(18F);
            b.setTextSize(20F);
        }
        c.setOnClickListener(new acl(this));
    }

    public void c()
    {
    }

    public void e()
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0300c8);
        a();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            finish();
            return false;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onResume()
    {
        super.onResume();
        b.setText(sm.a());
    }
}
