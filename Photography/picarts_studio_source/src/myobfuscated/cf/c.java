// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cf;

import android.view.View;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.draw.dialog.SelectBrushDialog;

// Referenced classes of package myobfuscated.cf:
//            b, a

final class c
    implements android.view.View.OnClickListener
{

    private final b a;
    private final FloatSeekBar b;
    private a c;

    public c(a a1, FloatSeekBar floatseekbar, b b1)
    {
        c = a1;
        super();
        b = floatseekbar;
        a = b1;
    }

    public final void onClick(View view)
    {
        float f1;
        f1 = b.a();
        float f;
        if (view.getId() == 0x7f1001d4)
        {
            f = f1 - a.e;
        } else
        {
            f = f1;
            if (view.getId() == 0x7f1001d6)
            {
                f = f1 + a.e;
            }
        }
        if (f < b.a)
        {
            f1 = b.a;
        } else
        {
            f1 = f;
            if (f > b.b)
            {
                f1 = b.b;
            }
        }
        b.setValue(f1);
        a.a;
        JVM INSTR tableswitch 2131755013 2131755022: default 116
    //                   2131755013 307
    //                   2131755014 322
    //                   2131755015 337
    //                   2131755016 352
    //                   2131755017 253
    //                   2131755018 292
    //                   2131755019 367
    //                   2131755020 382
    //                   2131755021 397
    //                   2131755022 277;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        AnalyticUtils.getInstance(c.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(c.E, c.D, c.C, c.a(c.z), c.B, c.A, false));
        c.F.a(c.y);
        return;
_L6:
        c.y.setAlpha(Math.round((f1 / 100F) * 255F));
        continue; /* Loop/switch isn't completed */
_L11:
        c.y.setThickness(f1);
        continue; /* Loop/switch isn't completed */
_L7:
        c.y.setScattering(f1);
        continue; /* Loop/switch isn't completed */
_L2:
        c.y.setAngle(f1);
        continue; /* Loop/switch isn't completed */
_L3:
        c.y.setAngleJitter(f1);
        continue; /* Loop/switch isn't completed */
_L4:
        c.y.setHardness(f1);
        continue; /* Loop/switch isn't completed */
_L5:
        c.y.setHueJitter(f1);
        continue; /* Loop/switch isn't completed */
_L8:
        c.y.setSizeJitter(f1);
        continue; /* Loop/switch isn't completed */
_L9:
        c.y.setSpacing(f1);
        continue; /* Loop/switch isn't completed */
_L10:
        c.y.setSquish(f1);
        if (true) goto _L1; else goto _L12
_L12:
    }
}
