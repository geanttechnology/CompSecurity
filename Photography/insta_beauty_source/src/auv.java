// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class auv
    implements android.view.View.OnClickListener
{

    final TTieZhiActivity a;

    public auv(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void onClick(View view)
    {
        TTieZhiActivity.a(a, TTieZhiActivity.a(a).isSelected());
    }
}
