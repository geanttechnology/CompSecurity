// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wjj.adapter.base.BoostPhoneAdapter;
import com.wjj.eneity.RuningApp;
import com.wjj.manager.CommonUtil;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            PhoneBoostActivity

class this._cls0 extends Handler
{

    final PhoneBoostActivity this$0;

    public void handleMessage(Message message)
    {
        if (message.what != 6)
        {
            if (message.what == 2)
            {
                PhoneBoostActivity.access$0(PhoneBoostActivity.this, (List)message.obj);
                Log.e("toggletag", (new StringBuilder("listdata=")).append(PhoneBoostActivity.access$1(PhoneBoostActivity.this).size()).toString());
                PhoneBoostActivity.access$2(PhoneBoostActivity.this).addData(PhoneBoostActivity.access$1(PhoneBoostActivity.this), true);
                PhoneBoostActivity.access$2(PhoneBoostActivity.this).notifyDataSetChanged();
            } else
            if (message.what == 1)
            {
                PhoneBoostActivity phoneboostactivity = PhoneBoostActivity.this;
                PhoneBoostActivity.access$4(phoneboostactivity, PhoneBoostActivity.access$3(phoneboostactivity) + ((Long)message.obj).longValue());
                PhoneBoostActivity.access$5(PhoneBoostActivity.this).setText(CommonUtil.formatSize(PhoneBoostActivity.access$3(PhoneBoostActivity.this)));
                PhoneBoostActivity.access$6(PhoneBoostActivity.this).setText(CommonUtil.formatSizeDanweiTwo(PhoneBoostActivity.access$3(PhoneBoostActivity.this)));
            } else
            if (message.what == 3)
            {
                PhoneBoostActivity phoneboostactivity1 = PhoneBoostActivity.this;
                PhoneBoostActivity.access$8(phoneboostactivity1, PhoneBoostActivity.access$7(phoneboostactivity1) + 1);
                PhoneBoostActivity.access$9(PhoneBoostActivity.this).setProgress(PhoneBoostActivity.access$7(PhoneBoostActivity.this));
                PhoneBoostActivity.access$10(PhoneBoostActivity.this, (RuningApp)message.obj);
                PhoneBoostActivity.access$11(PhoneBoostActivity.this).setText((new StringBuilder("Scan:")).append(PhoneBoostActivity.access$12(PhoneBoostActivity.this).runingsoftname).toString());
            } else
            if (message.what == 0 && PhoneBoostActivity.access$13(PhoneBoostActivity.this) == 1)
            {
                PhoneBoostActivity.access$14(PhoneBoostActivity.this).setVisibility(8);
                PhoneBoostActivity.access$15(PhoneBoostActivity.this).setVisibility(0);
                PhoneBoostActivity.access$11(PhoneBoostActivity.this).setVisibility(4);
                PhoneBoostActivity.access$16(PhoneBoostActivity.this).setText((new StringBuilder("Selected memory:")).append(CommonUtil.formatSize(PhoneBoostActivity.access$3(PhoneBoostActivity.this))).append(CommonUtil.formatSizeDanweiTwo(PhoneBoostActivity.access$3(PhoneBoostActivity.this))).toString());
            }
        }
        switch (message.what)
        {
        default:
            return;

        case 10: // '\n'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#3E56B1"));
            return;

        case 20: // '\024'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#3B62A8"));
            return;

        case 30: // '\036'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#3967A4"));
            return;

        case 40: // '('
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#386BA1"));
            return;

        case 50: // '2'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#376F9E"));
            return;

        case 60: // '<'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#36739B"));
            return;

        case 70: // 'F'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#357699"));
            return;

        case 80: // 'P'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#347A96"));
            return;

        case 90: // 'Z'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#337C94"));
            return;

        case 100: // 'd'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#337F92"));
            return;

        case 110: // 'n'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#31848E"));
            return;

        case 120: // 'x'
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#30878C"));
            return;

        case 130: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2F8B89"));
            return;

        case 140: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2E9085"));
            return;

        case 150: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2D9482"));
            return;

        case 160: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2C997E"));
            return;

        case 170: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2C9E7A"));
            return;

        case 180: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2CA277"));
            return;

        case 190: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2CA574"));
            return;

        case 200: 
            PhoneBoostActivity.access$17(PhoneBoostActivity.this).setBackgroundColor(Color.parseColor("#2CA971"));
            break;
        }
    }

    ()
    {
        this$0 = PhoneBoostActivity.this;
        super();
    }
}
