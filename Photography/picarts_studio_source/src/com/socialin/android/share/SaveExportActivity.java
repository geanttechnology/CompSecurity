// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Window;
import com.socialin.android.activity.BaseActivity;

// Referenced classes of package com.socialin.android.share:
//            a

public class SaveExportActivity extends BaseActivity
{

    private float a;

    public SaveExportActivity()
    {
        a = 0.0F;
    }

    public void finish()
    {
        super.finish();
        overridePendingTransition(0, 0x7f040048);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle != null && bundle.hasExtra("fixOrientation") && getIntent().getBooleanExtra("fixOrientation", false))
        {
            setRequestedOrientation(4);
        }
        bundle = getWindow().getAttributes();
        bundle.width = Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        bundle.gravity = 81;
        setContentView(0x7f030198);
        bundle = getFragmentManager().beginTransaction();
        Object obj = getFragmentManager().findFragmentByTag("export_fragment_tag");
        if (obj == null)
        {
            obj = new a();
            if (getIntent() != null && getIntent().getExtras() != null)
            {
                ((Fragment) (obj)).setArguments(getIntent().getExtras());
            }
            bundle.add(0x7f1007b8, ((Fragment) (obj)), "export_fragment_tag");
        } else
        {
            bundle.show(((Fragment) (obj)));
        }
        bundle.commit();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 32
    //                   2 49;
           goto _L1 _L2 _L1 _L3
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        a = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        if (motionevent.getY() - a > 20F)
        {
            finish();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
