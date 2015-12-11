// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Bundle;
import android.view.View;
import com.smule.pianoandroid.utils.n;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, MagicApplication

public class WhatsNewActivity extends ag
{

    public WhatsNewActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        MagicApplication.sShowWhatsNew = false;
        super.onCreate(bundle);
        try
        {
            setContentView(0x7f030078);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            if (n.a(bundle))
            {
                setContentView(0x7f030079);
            } else
            {
                throw bundle;
            }
        }
        findViewById(0x7f0a0247).setOnClickListener(new android.view.View.OnClickListener() {

            final WhatsNewActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = WhatsNewActivity.this;
                super();
            }
        });
    }
}
