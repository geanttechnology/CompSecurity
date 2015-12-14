// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.activity:
//            BaseActivity

public class InfoDialogActivity extends BaseActivity
{

    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_ICON_RES_ID = "iconResourceId";
    public static final String EXTRA_ICON_URL = "iconUrl";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TITLE = "title";

    public InfoDialogActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030135);
        Object obj = getIntent().getExtras();
        bundle = ((Bundle) (obj)).getString("title");
        String s = ((Bundle) (obj)).getString("desc");
        obj = (new StringBuilder()).append(((Bundle) (obj)).getString("message")).append(s).toString();
        if (!TextUtils.isEmpty(bundle))
        {
            ((TextView)findViewById(0x7f100399)).setText(bundle);
        }
        bundle = (TextView)findViewById(0x7f10067e);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            bundle.setVisibility(8);
        } else
        {
            bundle.setText(((CharSequence) (obj)));
            bundle.setVisibility(0);
        }
        findViewById(0x7f10067f).setOnClickListener(new android.view.View.OnClickListener() {

            private InfoDialogActivity a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = InfoDialogActivity.this;
                super();
            }
        });
        bundle.setMovementMethod(new ScrollingMovementMethod());
    }
}
