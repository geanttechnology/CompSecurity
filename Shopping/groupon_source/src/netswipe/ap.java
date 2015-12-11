// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;

// Referenced classes of package netswipe:
//            aq

public class ap
{

    public static StateListDrawable a(Resources resources)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        android.graphics.drawable.NinePatchDrawable ninepatchdrawable = aq.b(resources, aq.p);
        statelistdrawable.addState(new int[] {
            0x10100a7
        }, ninepatchdrawable);
        ninepatchdrawable = aq.b(resources, aq.p);
        statelistdrawable.addState(new int[] {
            0x101009c
        }, ninepatchdrawable);
        ninepatchdrawable = aq.b(resources, aq.r);
        statelistdrawable.addState(new int[] {
            0xfefeff62
        }, ninepatchdrawable);
        resources = aq.b(resources, aq.q);
        statelistdrawable.addState(new int[0], resources);
        return statelistdrawable;
    }
}
