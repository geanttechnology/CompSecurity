// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import java.util.ArrayList;

final class ki extends kb
{

    private static final ArrayList i;
    private final AudioManager j;
    private final kk k = new kk(this);
    private int l;

    public ki(Context context)
    {
        super(context);
        l = -1;
        j = (AudioManager)context.getSystemService("audio");
        context.registerReceiver(k, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        a();
    }

    static AudioManager a(ki ki1)
    {
        return ki1.j;
    }

    private void a()
    {
        Object obj = super.a.getResources();
        int i1 = j.getStreamMaxVolume(3);
        l = j.getStreamVolume(3);
        obj = (new ig("DEFAULT_ROUTE", ((Resources) (obj)).getString(0x7f0b0165))).a(i).b(3).a(0).e(1).d(i1).c(l).a();
        a((new io()).a(((if) (obj))).a());
    }

    static void b(ki ki1)
    {
        ki1.a();
    }

    static int c(ki ki1)
    {
        return ki1.l;
    }

    public final im a(String s)
    {
        if (s.equals("DEFAULT_ROUTE"))
        {
            return new kj(this);
        } else
        {
            return null;
        }
    }

    static 
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addCategory("android.media.intent.category.LIVE_AUDIO");
        intentfilter.addCategory("android.media.intent.category.LIVE_VIDEO");
        ArrayList arraylist = new ArrayList();
        i = arraylist;
        arraylist.add(intentfilter);
    }
}
