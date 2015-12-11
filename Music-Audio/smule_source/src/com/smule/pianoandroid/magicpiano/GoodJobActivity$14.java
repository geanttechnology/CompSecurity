// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.TextView;
import android.widget.Toast;
import com.smule.android.c.aa;
import com.smule.android.network.managers.e;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements Observer
{

    final GoodJobActivity a;

    public void update(Observable observable, Object obj)
    {
        a.runOnUiThread(new Runnable(obj) {

            final Object a;
            final GoodJobActivity._cls14 b;

            public void run()
            {
                Object obj1 = (com.smule.android.network.models.ContestData.SubmitState)a;
                if (obj1 == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_SUCCESS)
                {
                    aa.b("$$$", "good job: got submit result, setting rank on UI");
                    obj1 = e.a().a(e.a().f());
                    GoodJobActivity.b(b.a).setText((new Long(((com.smule.android.network.models.ContestData.ContestUserState) (obj1)).rank.longValue() + 1L)).toString());
                } else
                {
                    if (obj1 == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_ERROR)
                    {
                        aa.b("$$$", "good job: got submit result, error, showing toast");
                        Toast.makeText(b.a, b.a.getString(0x7f0c027a), 1).show();
                        return;
                    }
                    if (obj1 == com.smule.android.network.models.ContestData.SubmitState.SUBMIT_EXPIRED)
                    {
                        aa.b("$$$", "good job: got submit result, expired, showing toast");
                        Toast.makeText(b.a, b.a.getString(0x7f0c027b), 1).show();
                        return;
                    }
                }
            }

            
            {
                b = GoodJobActivity._cls14.this;
                a = obj;
                super();
            }
        });
    }

    _cls1.a(GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
