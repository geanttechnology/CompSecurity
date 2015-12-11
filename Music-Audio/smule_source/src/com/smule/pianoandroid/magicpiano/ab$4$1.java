// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.smule.android.console.DebugConsoleActivity;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ab, SettingsActivity, DailyChallengeActivity, ProductListActivity, 
//            GameStatsActivity, SoloActivity, GlobeActivity, PianoWebActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        o.e(ab.a(a.a));
    }

    ivity(ivity ivity)
    {
        a = ivity;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/ab$4

/* anonymous class */
    class ab._cls4
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ab a;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (i != 0) goto _L2; else goto _L1
_L1:
            if (!ab.b(a).booleanValue()) goto _L4; else goto _L3
_L3:
            o.a(ab.a(a), new ab._cls4._cls1(this));
_L6:
            a.b.setItemChecked(i, true);
            a.c.closeDrawer(0x800003);
            return;
_L4:
            if (!(ab.a(a) instanceof SettingsActivity))
            {
                adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/SettingsActivity);
                adapterview.putExtra("settings.show_handle", Boolean.TRUE);
                ab.a(a).startActivity(adapterview);
                ab.a(a).finish();
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (i == 1)
            {
                if (!(ab.a(a) instanceof DailyChallengeActivity))
                {
                    adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/DailyChallengeActivity);
                    ab.a(a).startActivity(adapterview);
                    ab.a(a).finish();
                }
            } else
            if (i == 2)
            {
                if (!(ab.a(a) instanceof ProductListActivity))
                {
                    adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/ProductListActivity);
                    ab.a(a).startActivity(adapterview);
                    ab.a(a).finish();
                }
            } else
            if (i == 3)
            {
                if (!(ab.a(a) instanceof GameStatsActivity))
                {
                    adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/GameStatsActivity);
                    ab.a(a).startActivity(adapterview);
                    ab.a(a).finish();
                }
            } else
            if (i == 4)
            {
                if (!(ab.a(a) instanceof SoloActivity))
                {
                    adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/SoloActivity);
                    ab.a(a).startActivity(adapterview);
                    ab.a(a).finish();
                }
            } else
            if (i == 5)
            {
                if (!(ab.a(a) instanceof GlobeActivity))
                {
                    o.d(ab.a(a));
                }
            } else
            if (i == 6)
            {
                if (!(ab.a(a) instanceof SettingsActivity))
                {
                    adapterview = new Intent(ab.a(a), com/smule/pianoandroid/magicpiano/SettingsActivity);
                    ab.a(a).startActivity(adapterview);
                    ab.a(a).finish();
                }
            } else
            if (i == 7)
            {
                if ((ab.a(a) instanceof PianoWebActivity) && ((PianoWebActivity)ab.a(a)).f().booleanValue())
                {
                    adapterview = Boolean.valueOf(false);
                } else
                {
                    adapterview = Boolean.valueOf(true);
                }
                if (adapterview.booleanValue())
                {
                    PianoWebActivity.a(ab.a(a), PianoWebActivity.h);
                    ab.a(a).finish();
                }
            } else
            if (i == 8)
            {
                if ((ab.a(a) instanceof PianoWebActivity) && ((PianoWebActivity)ab.a(a)).e().booleanValue())
                {
                    adapterview = Boolean.valueOf(false);
                } else
                {
                    adapterview = Boolean.valueOf(true);
                }
                if (adapterview.booleanValue())
                {
                    PianoWebActivity.a(ab.a(a), PianoWebActivity.e);
                    ab.a(a).finish();
                }
            } else
            if (i == 9)
            {
                adapterview = new Intent(ab.a(a), com/smule/android/console/DebugConsoleActivity);
                ab.a(a).startActivity(adapterview);
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                a = ab1;
                super();
            }
    }

}
