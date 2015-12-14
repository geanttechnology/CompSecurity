// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;

public class avc
    implements Runnable
{

    final TTieZhiActivity a;

    public avc(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void run()
    {
        if (a.n.getVisibility() != 0)
        {
            TTieZhiActivity.b(a);
        }
    }
}
