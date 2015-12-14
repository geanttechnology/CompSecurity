// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.messaging.ChooserResultEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorChooserActivity

public class ChooserStubActivity extends Activity
{

    private boolean inFirstOnResume;
    private ChooserResultEvent result;

    public ChooserStubActivity()
    {
        result = null;
        inFirstOnResume = true;
    }

    public void onChooserResult(ChooserResultEvent chooserresultevent)
    {
        result = chooserresultevent;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void onResume()
    {
        super.onResume();
        if (result != null)
        {
            Intent intent = new Intent();
            intent.setDataAndType(result.data, result.type);
            setResult(-1, intent);
            finish();
            return;
        }
        if (inFirstOnResume)
        {
            inFirstOnResume = false;
            GlobalMessagingBus.register(this);
            Intent intent1 = new Intent(this, com/amazon/gallery/thor/app/activity/ThorChooserActivity);
            intent1.setAction(getIntent().getAction());
            intent1.setType(getIntent().getType());
            startActivity(intent1);
            return;
        } else
        {
            finish();
            return;
        }
    }
}
