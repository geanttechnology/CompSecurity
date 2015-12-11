// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls1 extends TimerTask
{

    final adcast this$1;

    public void run()
    {
        Intent intent = new Intent("meiri");
        intent.putExtra("icon_pick1", cess._mth2(this._cls1.this));
        intent.putExtra("title_pick1", cess._mth3(this._cls1.this));
        intent.putExtra("short_desc1", cess._mth4(this._cls1.this));
        intent.putExtra("id_meiri", ServiceUpdate.access$13(cess._mth6(this._cls1.this)));
        cess._mth6(this._cls1.this).sendBroadcast(intent);
        intent = new Intent("meiribig");
        intent.putExtra("icon_pick", ServiceUpdate.access$14(cess._mth6(this._cls1.this)));
        intent.putExtra("title_pick", ServiceUpdate.access$15(cess._mth6(this._cls1.this)));
        intent.putExtra("short_desc", ServiceUpdate.access$16(cess._mth6(this._cls1.this)));
        intent.putExtra("img_pick", cess._mth5(this._cls1.this));
        intent.putExtra("id_meiribig", ServiceUpdate.access$18(cess._mth6(this._cls1.this)));
        cess._mth6(this._cls1.this).sendBroadcast(intent);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
