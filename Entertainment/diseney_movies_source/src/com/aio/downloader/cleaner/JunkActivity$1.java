// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.wjj.adapter.base.ApkSoftAdapter;
import com.wjj.adapter.base.JunkCacheAdapter;
import com.wjj.adapter.base.JunkCanliuAdapter;
import com.wjj.eneity.Canliu;
import com.wjj.eneity.RuningApp;
import com.wjj.manager.SoftApkManager;
import com.wjj.utils.CommonUtil;
import com.xiaos.adapter.PinnedHeaderExpandableAdapter;
import com.xiaos.view.PinnedHeaderExpandableListView;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0 extends Handler
{

    final JunkActivity this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            JunkActivity.access$0(JunkActivity.this, (List)message.obj);
            JunkActivity.access$1(JunkActivity.this).setVisibility(8);
            JunkActivity.access$2(JunkActivity.this).setVisibility(0);
            message = JunkActivity.this;
            JunkActivity.access$4(message, JunkActivity.access$3(message) + 1);
            JunkActivity.access$5(JunkActivity.this, 1);
        } else
        if (message.what == 2)
        {
            JunkActivity junkactivity = JunkActivity.this;
            JunkActivity.access$7(junkactivity, JunkActivity.access$6(junkactivity) + ((Long)message.obj).longValue());
            JunkActivity.access$8(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this)));
            JunkActivity.access$9(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this) + JunkActivity.access$10(JunkActivity.this) + JunkActivity.access$11(JunkActivity.this) + JunkActivity.access$12(JunkActivity.this)));
        } else
        if (message.what == 22)
        {
            message = (RuningApp)message.obj;
            JunkActivity.access$13(JunkActivity.this).setText((new StringBuilder("Scanning:")).append(((RuningApp) (message)).runingsoftname).toString());
        } else
        if (message.what == 3)
        {
            JunkActivity.access$14(JunkActivity.this, (List)message.obj);
            JunkActivity.access$15(JunkActivity.this).addData(JunkActivity.access$16(JunkActivity.this), true);
            JunkActivity.access$15(JunkActivity.this).notifyDataSetChanged();
            JunkActivity.access$17(JunkActivity.this).setVisibility(8);
            JunkActivity.access$18(JunkActivity.this).setVisibility(0);
            message = JunkActivity.this;
            JunkActivity.access$4(message, JunkActivity.access$3(message) + 1);
            JunkActivity.access$19(JunkActivity.this, 1);
        } else
        {
label0:
            {
                if (message.what != 4)
                {
                    break label0;
                }
                JunkActivity junkactivity1 = JunkActivity.this;
                JunkActivity.access$20(junkactivity1, JunkActivity.access$10(junkactivity1) + ((Long)message.obj).longValue());
                JunkActivity.access$21(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$10(JunkActivity.this)));
                JunkActivity.access$9(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this) + JunkActivity.access$10(JunkActivity.this) + JunkActivity.access$11(JunkActivity.this) + JunkActivity.access$12(JunkActivity.this)));
            }
        }
_L1:
        if (JunkActivity.access$3(JunkActivity.this) == 4)
        {
            JunkActivity.access$42(JunkActivity.this).setVisibility(8);
            JunkActivity.access$43(JunkActivity.this).setVisibility(0);
            JunkActivity.access$13(JunkActivity.this).setVisibility(8);
            JunkActivity.access$44(JunkActivity.this).setText((new StringBuilder("Selected junk:")).append(CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this) + JunkActivity.access$10(JunkActivity.this) + JunkActivity.access$11(JunkActivity.this) + JunkActivity.access$12(JunkActivity.this))).toString());
            JunkActivity.access$45(JunkActivity.this)[0] = CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this));
            JunkActivity.access$45(JunkActivity.this)[1] = CommonUtil.formatSize(JunkActivity.access$10(JunkActivity.this));
            JunkActivity.access$45(JunkActivity.this)[2] = CommonUtil.formatSize(JunkActivity.access$11(JunkActivity.this));
            JunkActivity.access$45(JunkActivity.this)[3] = CommonUtil.formatSize(JunkActivity.access$12(JunkActivity.this));
            sticky_content.setVisibility(8);
            JunkActivity.access$46(JunkActivity.this).setVisibility(0);
            JunkActivity.access$51(JunkActivity.this, new PinnedHeaderExpandableAdapter(JunkActivity.access$47(JunkActivity.this), JunkActivity.access$16(JunkActivity.this), JunkActivity.access$33(JunkActivity.this), JunkActivity.access$26(JunkActivity.this), JunkActivity.access$48(JunkActivity.this), getApplicationContext(), JunkActivity.access$49(JunkActivity.this), JunkActivity.access$45(JunkActivity.this), JunkActivity.access$50(JunkActivity.this)));
            JunkActivity.access$49(JunkActivity.this).setAdapter(JunkActivity.access$52(JunkActivity.this));
        }
        return;
        int i;
        if (message.what != 5)
        {
            break MISSING_BLOCK_LABEL_1030;
        }
        JunkActivity.access$22(JunkActivity.this, (List)message.obj);
        i = 0;
_L2:
label1:
        {
            if (i < JunkActivity.access$23(JunkActivity.this).size())
            {
                break label1;
            }
            JunkActivity.access$27(JunkActivity.this).addData(JunkActivity.access$26(JunkActivity.this), true);
            JunkActivity.access$27(JunkActivity.this).notifyDataSetChanged();
            JunkActivity.access$28(JunkActivity.this).setVisibility(8);
            JunkActivity.access$29(JunkActivity.this).setVisibility(0);
            JunkActivity.access$9(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this) + JunkActivity.access$10(JunkActivity.this) + JunkActivity.access$11(JunkActivity.this) + JunkActivity.access$12(JunkActivity.this)));
            message = JunkActivity.this;
            JunkActivity.access$4(message, JunkActivity.access$3(message) + 1);
            JunkActivity.access$30(JunkActivity.this, 1);
        }
          goto _L1
        message = JunkActivity.this;
        JunkActivity.access$24(message, JunkActivity.access$11(message) + ((File)JunkActivity.access$23(JunkActivity.this).get(i)).length());
        JunkActivity.access$25(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$11(JunkActivity.this)));
        message = new Canliu();
        message.runingsoftname = ((File)JunkActivity.access$23(JunkActivity.this).get(i)).getName();
        message.memory = ((File)JunkActivity.access$23(JunkActivity.this).get(i)).length();
        message.ischecked = true;
        message.path = ((File)JunkActivity.access$23(JunkActivity.this).get(i)).getAbsolutePath();
        JunkActivity.access$26(JunkActivity.this).add(message);
        i++;
          goto _L2
        if (message.what != 954) goto _L4; else goto _L3
_L3:
        i = 0;
_L9:
        int j = JunkActivity.access$31(JunkActivity.this).size();
        if (i < j) goto _L6; else goto _L5
_L5:
        i = 0;
_L10:
        if (i < JunkActivity.access$32(JunkActivity.this).size()) goto _L8; else goto _L7
_L7:
        JunkActivity.access$36(JunkActivity.this).addData(JunkActivity.access$33(JunkActivity.this), true);
        JunkActivity.access$36(JunkActivity.this).notifyDataSetChanged();
        JunkActivity.access$37(JunkActivity.this).setVisibility(8);
        JunkActivity.access$38(JunkActivity.this).setVisibility(0);
        message = JunkActivity.this;
        JunkActivity.access$4(message, JunkActivity.access$3(message) + 1);
        JunkActivity.access$39(JunkActivity.this, 1);
          goto _L1
_L6:
        if (getApplicationContext().getPackageManager().getPackageArchiveInfo((String)JunkActivity.access$31(JunkActivity.this).get(i), 1) != null)
        {
            JunkActivity.access$32(JunkActivity.this).add((String)JunkActivity.access$31(JunkActivity.this).get(i));
        }
        i++;
          goto _L9
_L8:
        JunkActivity.access$33(JunkActivity.this).add(JunkActivity.access$34(JunkActivity.this).GetAllApk2(JunkActivity.access$35(JunkActivity.this), (String)JunkActivity.access$32(JunkActivity.this).get(i)));
        i++;
          goto _L10
_L4:
        if (message.what == 7)
        {
            JunkActivity junkactivity2 = JunkActivity.this;
            JunkActivity.access$40(junkactivity2, JunkActivity.access$12(junkactivity2) + ((Long)message.obj).longValue());
            JunkActivity.access$41(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$12(JunkActivity.this)));
            JunkActivity.access$9(JunkActivity.this).setText(CommonUtil.formatSize(JunkActivity.access$6(JunkActivity.this) + JunkActivity.access$10(JunkActivity.this) + JunkActivity.access$11(JunkActivity.this) + JunkActivity.access$12(JunkActivity.this)));
        }
          goto _L1
        message;
          goto _L5
    }

    iew()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
