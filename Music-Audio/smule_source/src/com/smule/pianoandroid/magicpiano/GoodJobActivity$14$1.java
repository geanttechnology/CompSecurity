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
    implements Runnable
{

    final Object a;
    final ring b;

    public void run()
    {
        Object obj = (com.smule.android.network.models.te)a;
        if (obj == com.smule.android.network.models.te.SUBMIT_SUCCESS)
        {
            aa.b("$$$", "good job: got submit result, setting rank on UI");
            obj = e.a().a(e.a().f());
            GoodJobActivity.b(b.b).setText((new Long(((com.smule.android.network.models.erState) (obj)).rank.longValue() + 1L)).toString());
        } else
        {
            if (obj == com.smule.android.network.models.te.SUBMIT_ERROR)
            {
                aa.b("$$$", "good job: got submit result, error, showing toast");
                Toast.makeText(b.b, b.b.getString(0x7f0c027a), 1).show();
                return;
            }
            if (obj == com.smule.android.network.models.te.SUBMIT_EXPIRED)
            {
                aa.b("$$$", "good job: got submit result, expired, showing toast");
                Toast.makeText(b.b, b.b.getString(0x7f0c027b), 1).show();
                return;
            }
        }
    }

    rState(rState rstate, Object obj)
    {
        b = rstate;
        a = obj;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/GoodJobActivity$14

/* anonymous class */
    class GoodJobActivity._cls14
        implements Observer
    {

        final GoodJobActivity a;

        public void update(Observable observable, Object obj)
        {
            a.runOnUiThread(new GoodJobActivity._cls14._cls1(this, obj));
        }

            
            {
                a = goodjobactivity;
                super();
            }
    }

}
