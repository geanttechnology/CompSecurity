// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.TextView;
import com.b.a.a.j;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            k, hx

public class TruYouConfActivity extends k
{

    public TruYouConfActivity()
    {
    }

    final String b()
    {
        return "truyou_confirmation";
    }

    public void finish()
    {
        setResult(-1, new Intent());
        super.finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003e);
        ((TextView)findViewById(0x7f100145)).setTypeface(Typeface.createFromAsset(getAssets(), "segoesc.ttf"));
        TextView textview = (TextView)findViewById(0x7f100146);
        bundle = j.a().k();
        if (StringUtils.isNotEmpty(bundle))
        {
            bundle = String.format(getString(0x7f09020a), new Object[] {
                bundle
            });
        } else
        {
            bundle = String.format(getString(0x7f09020b), new Object[] {
                bundle
            });
        }
        textview.setText(bundle);
        ((Button)findViewById(0x7f100148)).setOnClickListener(new hx(this));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110011, menu);
        return true;
    }
}
