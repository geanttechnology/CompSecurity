// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity

public class ViewOverlayActivity extends BaseControllerActionBarActivity
    implements android.view.View.OnClickListener
{

    private static final String EXTRA_CALL_TO_ACTION_ID = "call_to_action_id";
    private static final String EXTRA_LAYOUT = "layout";
    private static final String EXTRA_SKIP_ID = "skip_id";

    public ViewOverlayActivity()
    {
    }

    public static Intent getIntent(Context context, int i, int j, int k)
    {
        context = new Intent(context, co/vine/android/ViewOverlayActivity);
        context.putExtra("layout", i);
        context.putExtra("call_to_action_id", j);
        context.putExtra("skip_id", k);
        return context;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131362079: 
            Util.getDefaultSharedPrefs(this).edit().putBoolean("pref_gb_notif_dismissed", true).apply();
            setResult(-1);
            finish();
            return;

        case 2131362358: 
            setResult(-1);
            finish();
            return;

        case 2131361930: 
            setResult(0);
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        Intent intent = getIntent();
        if (intent.getExtras() == null)
        {
            throw new IllegalStateException("Extras bundle must not be null; use this class's getIntent() helper.");
        }
        int i = intent.getIntExtra("layout", 0);
        if (i < 1)
        {
            throw new IllegalStateException("You must provide a layout id when starting this Activity");
        }
        super.onCreate(bundle, i, true);
        if (android.os.Build.VERSION.SDK_INT <= 14)
        {
            bundle = getSupportActionBar();
            if (bundle != null)
            {
                bundle.hide();
            }
        }
        bundle = findViewById(intent.getIntExtra("call_to_action_id", 0));
        if (bundle != null)
        {
            bundle.setOnClickListener(this);
        }
        bundle = findViewById(intent.getIntExtra("skip_id", 0));
        if (bundle != null)
        {
            bundle.setOnClickListener(this);
        }
    }
}
