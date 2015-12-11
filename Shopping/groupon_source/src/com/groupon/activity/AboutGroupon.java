// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.groupon.service.AttributionService;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class AboutGroupon extends GrouponActivity
{
    protected class PrivacyOnClickListener
        implements android.view.View.OnClickListener
    {

        final AboutGroupon this$0;

        public void onClick(View view)
        {
            startActivity(intentFactory.newSimpleMarkUpActivity("internal:///privacypolicy"));
        }

        protected PrivacyOnClickListener()
        {
            this$0 = AboutGroupon.this;
            super();
        }
    }

    protected class TOSOnClickListener
        implements android.view.View.OnClickListener
    {

        final AboutGroupon this$0;

        public void onClick(View view)
        {
            startActivity(intentFactory.newSimpleMarkUpActivity("internal:///tos"));
        }

        protected TOSOnClickListener()
        {
            this$0 = AboutGroupon.this;
            super();
        }
    }


    private AttributionService attributionService;
    private final Handler handler = new Handler();
    private PackageInfo info;
    private IntentFactory intentFactory;
    TextView privacyStatement;
    TextView termsOfUse;
    private Runnable threeFingerLongPressed;
    TextView versionNumber;

    public AboutGroupon()
    {
        threeFingerLongPressed = new Runnable() {

            final AboutGroupon this$0;

            public void run()
            {
                ((Vibrator)getSystemService("vibrator")).vibrate(100L);
                startActivity(intentFactory.newSecretAdminSettingsWithOktaAuthenticationIntent());
            }

            
            {
                this$0 = AboutGroupon.this;
                super();
            }
        };
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080040));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030017);
        privacyStatement.setOnClickListener(new PrivacyOnClickListener());
        termsOfUse.setOnClickListener(new TOSOnClickListener());
        bundle = attributionService.getAttributionDownloadId();
        versionNumber.setText(String.format(getString(0x7f080220), new Object[] {
            (new StringBuilder()).append(info.packageName.replaceAll("com.groupon\\.?", "")).append(" ").append(info.versionName).append(" ").append(bundle).toString()
        }));
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 1 6: default 48
    //                   1 80
    //                   2 48
    //                   3 48
    //                   4 48
    //                   5 54
    //                   6 80;
           goto _L1 _L2 _L1 _L1 _L1 _L3 _L2
_L1:
        return super.onTouchEvent(motionevent);
_L3:
        if (motionevent.getPointerCount() == 3)
        {
            handler.postDelayed(threeFingerLongPressed, 3000L);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        handler.removeCallbacks(threeFingerLongPressed);
        if (true) goto _L1; else goto _L4
_L4:
    }

}
