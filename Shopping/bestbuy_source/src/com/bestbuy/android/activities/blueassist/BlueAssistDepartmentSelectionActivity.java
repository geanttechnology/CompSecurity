// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistStoreSelectionActivity

public class BlueAssistDepartmentSelectionActivity extends BBYBaseFragmentActivity
    implements android.view.View.OnClickListener
{

    private nb a;
    private RelativeLayout b;
    private ImageView c;
    private ImageView d;
    private RelativeLayout e;
    private BBYTextView f;

    public BlueAssistDepartmentSelectionActivity()
    {
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    public void onClick(View view)
    {
        if (view == b)
        {
            startActivity(new Intent(this, com/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity));
        } else
        {
            if (view == d)
            {
                finish();
                return;
            }
            if (view == c)
            {
                finish();
                overridePendingTransition(0x7f040005, 0x7f040008);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002d);
        a = nb.a();
        a.i(true);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setTitle("");
        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().hide();
        b = (RelativeLayout)findViewById(0x7f0c00b7);
        c = (ImageView)findViewById(0x7f0c0067);
        d = (ImageView)findViewById(0x7f0c0068);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        b.setOnClickListener(this);
        e = (RelativeLayout)findViewById(0x7f0c0020);
        f = (BBYTextView)e.findViewById(0x7f0c015e);
        bundle = (BBYTextView)e.findViewById(0x7f0c015f);
        f.setText(Html.fromHtml(getString(0x7f08021f)));
        bundle.setText(Html.fromHtml(getString(0x7f0802f9)));
        lu.a(lu.aL);
    }
}
