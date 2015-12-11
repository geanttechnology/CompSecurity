// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import co.vine.android.util.FlurryUtils;

// Referenced classes of package co.vine.android:
//            StartActivity

public class CameraWidgetConfigureActivity extends Activity
{

    public CameraWidgetConfigureActivity()
    {
    }

    public static void setupShortcut(Context context)
    {
        Intent intent = new Intent(context.getApplicationContext(), co/vine/android/StartActivity);
        intent.setAction("co.vine.android.RECORD");
        intent.setFlags(0x20000);
        Intent intent1 = new Intent();
        intent1.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent1.putExtra("android.intent.extra.shortcut.NAME", context.getText(0x7f0e0056));
        intent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", android.content.Intent.ShortcutIconResource.fromContext(context.getApplicationContext(), 0x7f020199));
        intent1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.getApplicationContext().sendBroadcast(intent1);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setupShortcut(this);
        Toast.makeText(this, 0x7f0e0287, 0).show();
        FlurryUtils.trackCameraWidgetAdded();
        setResult(0);
        finish();
    }
}
