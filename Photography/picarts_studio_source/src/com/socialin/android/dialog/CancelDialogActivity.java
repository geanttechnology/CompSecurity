// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.List;

public class CancelDialogActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private CheckBox k;
    private String l;

    public CancelDialogActivity()
    {
        a = false;
        b = false;
        c = true;
        d = true;
        e = false;
        f = false;
        g = false;
    }

    public void onClick(View view)
    {
        Intent intent;
        int i1;
        intent = new Intent();
        i1 = view.getId();
        if (i1 != 0x7f100370) goto _L2; else goto _L1
_L1:
        if (!f) goto _L4; else goto _L3
_L3:
        getSharedPreferences("socialin", 0).edit().putBoolean("dontShowDialogAgain", k.isChecked()).commit();
        intent.putExtra("button", "button_picsartEdit");
        setResult(-1, intent);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:editPicsart");
_L6:
        return;
_L4:
        intent.putExtra("button", "button_ok");
        setResult(-1, intent);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:ok");
        return;
_L2:
        if (i1 == 0x7f100367)
        {
            intent.putExtra("button", "button_saveSD");
            setResult(-1, intent);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:saveSD");
            return;
        }
        if (i1 == 0x7f100368)
        {
            intent.putExtra("button", "button_uploadToPicsinId");
            setResult(-1, intent);
            if (!SocialinV3.getInstance().isRegistered() && !TextUtils.isEmpty(l) && !TextUtils.isEmpty(null))
            {
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent(l, null));
            }
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:uploadToPicsart");
            return;
        }
        if (i1 == 0x7f100369)
        {
            intent.putExtra("button", "button_postFB");
            setResult(-1, intent);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:postFB");
            return;
        }
        if (i1 == 0x7f10036a)
        {
            intent.putExtra("button", "button_postInstagram");
            setResult(-1, intent);
            finish();
            return;
        }
        if (i1 == 0x7f10036b)
        {
            intent.putExtra("button", "button_tweet");
            setResult(-1, intent);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:tweet");
            return;
        }
        if (i1 == 0x7f10036c)
        {
            intent.putExtra("button", "button_share");
            setResult(-1, intent);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:share");
            return;
        }
        if (i1 == 0x7f10036d)
        {
            intent.putExtra("button", "button_picsartEdit");
            setResult(-1, intent);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:editPicsart");
            return;
        }
        if (i1 == 0x7f10036f)
        {
            setResult(0);
            finish();
            AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:cancel");
            return;
        }
        if (i1 == 0x7f100363)
        {
            intent.putExtra("button", "button_saveProject");
            setResult(-1, intent);
            finish();
            return;
        }
        if (i1 == 0x7f100364)
        {
            intent.putExtra("button", "button_exportVideo");
            setResult(-1, intent);
            finish();
            return;
        }
        if (i1 == 0x7f100365)
        {
            intent.putExtra("button", "button_exportGif");
            setResult(-1, intent);
            finish();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            setContentView(0x7f03009f);
            bundle = getIntent().getExtras();
            if (bundle != null)
            {
                a = bundle.getBoolean("showExport", false);
                b = bundle.getBoolean("showEdit", false);
                c = bundle.getBoolean("showTitle", true);
                d = bundle.getBoolean("showCloseButton", true);
                h = bundle.getBoolean("showSaveProject", false);
                i = bundle.getBoolean("showExportVideo", false);
                j = bundle.getBoolean("showExportGif", false);
                f = bundle.getBoolean("drawingActivityActionDone", false);
                g = bundle.getBoolean("drawingActivityActionCancel", false);
                e = bundle.getBoolean("showCheckbox", false);
                l = bundle.getString("source");
                l = bundle.getString("action");
            }
            if (c)
            {
                bundle = (TextView)findViewById(0x7f1000f3);
                if (f)
                {
                    bundle.setText(0x7f080123);
                } else
                if (g)
                {
                    bundle.setTextSize(2, 20F);
                    bundle.setText(0x7f080122);
                } else
                {
                    bundle.setText(0x7f080467);
                }
                AnalyticUtils.getInstance(this).trackLocalAction("cancelDialog:onCreate");
            } else
            {
                findViewById(0x7f1000f3).setVisibility(8);
            }
            if (f || g)
            {
                findViewById(0x7f100366).setVisibility(8);
                findViewById(0x7f10036f).setOnClickListener(this);
                findViewById(0x7f100361).getLayoutParams().height = -2;
            } else
            {
                findViewById(0x7f10036f).setOnClickListener(this);
                findViewById(0x7f100367).setOnClickListener(this);
                findViewById(0x7f100368).setOnClickListener(this);
                findViewById(0x7f100369).setOnClickListener(this);
                findViewById(0x7f10036b).setOnClickListener(this);
                findViewById(0x7f10036a).setOnClickListener(this);
            }
            if (getString(0x7f0808c8).equals(getString(0x7f0808cc)))
            {
                findViewById(0x7f100369).setVisibility(8);
                findViewById(0x7f10036b).setVisibility(8);
                findViewById(0x7f10036a).setVisibility(8);
                findViewById(0x7f100361).getLayoutParams().height = -2;
            }
            bundle = findViewById(0x7f100363);
            if (h)
            {
                findViewById(0x7f100363).setVisibility(0);
                bundle.setOnClickListener(this);
            } else
            {
                findViewById(0x7f100363).setVisibility(8);
            }
            bundle = findViewById(0x7f100364);
            if (i)
            {
                findViewById(0x7f100364).setVisibility(0);
                bundle.setOnClickListener(this);
            } else
            {
                findViewById(0x7f100364).setVisibility(8);
            }
            bundle = findViewById(0x7f100365);
            if (j)
            {
                findViewById(0x7f100365).setVisibility(0);
                bundle.setOnClickListener(this);
            } else
            {
                findViewById(0x7f100364).setVisibility(8);
            }
            bundle = (Button)findViewById(0x7f100370);
            if (f || g)
            {
                bundle.setText(getString(0x7f080311));
            }
            if (d)
            {
                bundle.setOnClickListener(this);
                bundle.setVisibility(0);
            } else
            {
                bundle.setVisibility(8);
            }
            bundle = (Button)findViewById(0x7f10036c);
            if (a)
            {
                bundle.setOnClickListener(this);
                bundle.setVisibility(0);
            } else
            {
                bundle.setVisibility(8);
            }
            bundle = (Button)findViewById(0x7f10036d);
            if (b)
            {
                if (f)
                {
                    bundle.setText(getString(0x7f080116));
                }
                bundle.setOnClickListener(this);
                bundle.setVisibility(0);
            } else
            {
                bundle.setVisibility(8);
            }
            k = (CheckBox)findViewById(0x7f10036e);
            if (e)
            {
                k.setVisibility(0);
            } else
            {
                k.setVisibility(8);
            }
            if (!f && !g)
            {
                bundle = new Intent("android.intent.action.SEND", null);
                bundle.setPackage("com.instagram.android");
                bundle.setDataAndType(null, "image/*");
                bundle = getPackageManager().queryIntentActivities(bundle, 0x10000);
                if (bundle != null && bundle.size() != 0 && !getString(0x7f0808c8).equals(getString(0x7f0808cc)))
                {
                    break label0;
                }
                findViewById(0x7f10036a).setVisibility(8);
            }
            return;
        }
        findViewById(0x7f10036a).setVisibility(0);
    }
}
