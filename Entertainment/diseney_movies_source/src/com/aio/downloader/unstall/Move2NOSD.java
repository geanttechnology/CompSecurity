// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.aio.downloader.utils.MemoryManager;
import com.aio.downloader.views.LImageButton;

public class Move2NOSD extends Activity
{

    private long firstsd;
    private LImageButton header_left_move2nosd;
    private MemoryManager memoryManager;
    private long sencondsd;
    private TextView tv_nosd;

    public Move2NOSD()
    {
        sencondsd = 0L;
        firstsd = 0L;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03007a);
        memoryManager = new MemoryManager(getApplicationContext());
        sencondsd = memoryManager.getSecondSDTotalSize();
        firstsd = memoryManager.getSDTotalSize();
        header_left_move2nosd = (LImageButton)findViewById(0x7f0702e6);
        tv_nosd = (TextView)findViewById(0x7f0702e7);
        if (sencondsd == 0L && firstsd != 0L)
        {
            tv_nosd.setText("Your device storage and internal SD card are the same, so moving is unnecessary.");
        } else
        {
            tv_nosd.setText("Unfortunately, your device doesn't support moving apps.");
        }
        header_left_move2nosd.setOnClickListener(new android.view.View.OnClickListener() {

            final Move2NOSD this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = Move2NOSD.this;
                super();
            }
        });
    }
}
