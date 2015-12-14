// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import bxi;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore, DialogStringResolver

class val.promptData
    implements Runnable
{

    final CrashlyticsCore this$0;
    final Activity val$activity;
    final tInLatch val$latch;
    final bxi val$promptData;
    final DialogStringResolver val$stringResolver;

    public void run()
    {
        android.app.r r = new android.app.r(val$activity);
        class _cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final CrashlyticsCore._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                latch.setOptIn(true);
                dialoginterface.dismiss();
            }

            _cls1()
            {
                this$1 = CrashlyticsCore._cls7.this;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        float f = val$activity.getResources().getDisplayMetrics().density;
        int i = CrashlyticsCore.access$300(CrashlyticsCore.this, f, 5);
        TextView textview = new TextView(val$activity);
        textview.setAutoLinkMask(15);
        textview.setText(val$stringResolver.getMessage());
        textview.setTextAppearance(val$activity, 0x1030044);
        textview.setPadding(i, i, i, i);
        textview.setFocusable(false);
        ScrollView scrollview = new ScrollView(val$activity);
        scrollview.setPadding(CrashlyticsCore.access$300(CrashlyticsCore.this, f, 14), CrashlyticsCore.access$300(CrashlyticsCore.this, f, 2), CrashlyticsCore.access$300(CrashlyticsCore.this, f, 10), CrashlyticsCore.access$300(CrashlyticsCore.this, f, 12));
        scrollview.addView(textview);
        r.setView(scrollview).setTitle(val$stringResolver.getTitle()).setCancelable(false).setNeutralButton(val$stringResolver.getSendButtonTitle(), _lcls1);
        if (val$promptData.d)
        {
            class _cls2
                implements android.content.DialogInterface.OnClickListener
            {

                final CrashlyticsCore._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    latch.setOptIn(false);
                    dialoginterface.dismiss();
                }

            _cls2()
            {
                this$1 = CrashlyticsCore._cls7.this;
                super();
            }
            }

            _cls2 _lcls2 = new _cls2();
            r.setNegativeButton(val$stringResolver.getCancelButtonTitle(), _lcls2);
        }
        if (val$promptData.f)
        {
            class _cls3
                implements android.content.DialogInterface.OnClickListener
            {

                final CrashlyticsCore._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    setShouldSendUserReportsWithoutPrompting(true);
                    latch.setOptIn(true);
                    dialoginterface.dismiss();
                }

            _cls3()
            {
                this$1 = CrashlyticsCore._cls7.this;
                super();
            }
            }

            _cls3 _lcls3 = new _cls3();
            r.setPositiveButton(val$stringResolver.getAlwaysSendButtonTitle(), _lcls3);
        }
        r.show();
    }

    er()
    {
        this$0 = final_crashlyticscore;
        val$activity = activity1;
        val$latch = tinlatch;
        val$stringResolver = dialogstringresolver;
        val$promptData = bxi.this;
        super();
    }
}
