// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeauty.WantuActivity;
import com.instamag.activity.library.model.TResTypeManager;

public class acu
    implements Runnable
{

    final WantuActivity a;

    public acu(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void run()
    {
        TResTypeManager.instance().checkOnlineTypeInfo();
    }
}
