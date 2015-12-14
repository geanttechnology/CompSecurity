// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class ail
    implements android.view.View.OnTouchListener
{

    final ProEditSlimBodyActivity a;

    public ail(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        Log.e("mCompareBtn", "dianji bijiaoanniu");
        if (ProEditSlimBodyActivity.a(a).b() != 0L)
        {
            if (motionevent.getAction() == 0)
            {
                ProEditSlimBodyActivity.c(a).setImageBitmap(ProEditSlimBodyActivity.b(a));
                return false;
            }
            if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
            {
                ProEditSlimBodyActivity.c(a).setImageBitmap(ProEditSlimBodyActivity.d(a));
                return false;
            }
        }
        return false;
    }
}
