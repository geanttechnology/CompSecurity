// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity, TaskInfoProvider, TextFormater, TaskInfo

class this._cls0
    implements Runnable
{

    final RubActivity this$0;

    public void run()
    {
        RubActivity.access$48(RubActivity.this, new TaskInfoProvider(RubActivity.this));
        RubActivity.access$51(RubActivity.this, RubActivity.access$49(RubActivity.this).getAllTask(RubActivity.access$50(RubActivity.this)));
        Object obj = RubActivity.access$19(RubActivity.this).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                total_wyc = total_show;
                obj = new android.app.r.MemoryInfo();
                RubActivity.access$52(RubActivity.this).getMemoryInfo(((android.app.r.MemoryInfo) (obj)));
                long l = ((android.app.r.MemoryInfo) (obj)).availMem;
                obj = RubActivity.this;
                obj.total_show = ((RubActivity) (obj)).total_show << 10;
                obj = RubActivity.this;
                obj.total_show = ((RubActivity) (obj)).total_show + l;
                RubActivity.access$53(RubActivity.this, TextFormater.dataSizeFormat(total_show));
                obj = new Message();
                obj.what = 1;
                RubActivity.access$42(RubActivity.this).sendMessage(((Message) (obj)));
                return;
            }
            TaskInfo taskinfo = (TaskInfo)((Iterator) (obj)).next();
            RubActivity rubactivity = RubActivity.this;
            rubactivity.total_show = rubactivity.total_show + (long)taskinfo.getMemory();
        } while (true);
    }

    er()
    {
        this$0 = RubActivity.this;
        super();
    }
}
