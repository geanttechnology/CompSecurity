// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package co.vine.android:
//            SonyRecordingActivity

public class SonyLaunchActivity extends Activity
{

    public SonyLaunchActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new Intent(this, co/vine/android/SonyRecordingActivity);
        bundle.setFlags(0x10008000);
        startActivity(bundle);
        finish();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
    }
}
