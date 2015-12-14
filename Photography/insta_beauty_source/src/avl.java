// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class avl
    implements android.view.View.OnClickListener
{

    final TTieZhiActivity a;

    public avl(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void onClick(View view)
    {
        TTieZhiActivity.b(a);
    }
}
