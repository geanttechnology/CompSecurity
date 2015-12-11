// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.pianoandroid.search.c;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

final class 
    implements Observer
{

    public void update(Observable observable, Object obj)
    {
        if ("SONGBOOK_SYNCED_ACTION".equals((String)((Map)obj).get("ACTION")))
        {
            c.a();
        }
    }

    ()
    {
    }
}
