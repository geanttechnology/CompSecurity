// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.helpshift.app.a;
import com.helpshift.i.b;

// Referenced classes of package com.helpshift:
//            j

public class ScreenshotPreviewActivity extends a
    implements com.helpshift.j.b.a
{

    private boolean a;
    private com.helpshift.j.b b;
    private Bundle c;

    public ScreenshotPreviewActivity()
    {
    }

    public void b(String s)
    {
        Intent intent = new Intent();
        intent.putExtra("SCREENSHOT", s);
        intent.putExtra("screenshot_position", c.getInt("screenshot_position"));
        setResult(-1, intent);
        finish();
    }

    public void g()
    {
        a = true;
        startActivityForResult(new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 32700);
    }

    protected void onActivityResult(int i, int k, Intent intent)
    {
        super.onActivityResult(i, k, intent);
        if (-1 == k && i == 32700 && com.helpshift.i.b.b(this, intent))
        {
            intent = com.helpshift.i.b.a(this, intent);
            if (!TextUtils.isEmpty(intent))
            {
                b.setScreenshotPreview(intent);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (Boolean.valueOf(getIntent().getExtras().getBoolean("showInFullScreen")).booleanValue())
        {
            getWindow().setFlags(1024, 1024);
        }
        b = new com.helpshift.j.b(this);
        setContentView(b);
        c = getIntent().getExtras();
        b.setScreenshotPreviewInterface(this);
        b.setScreenshotPreview(c.getString("SCREENSHOT"));
        b.setSendButtonText(c.getInt("screenshot_text_type"));
    }

    public void onResume()
    {
        super.onResume();
        a = false;
    }

    public void onStart()
    {
        super.onStart();
        if (!a)
        {
            com.helpshift.j.a(this);
        }
        a = false;
    }

    public void onStop()
    {
        super.onStop();
        if (!a)
        {
            com.helpshift.j.b(this);
        }
    }
}
