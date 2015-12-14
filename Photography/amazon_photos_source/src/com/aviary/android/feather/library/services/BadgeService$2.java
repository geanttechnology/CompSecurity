// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BadgeService, PreferenceService, IAviaryController

class this._cls0
    implements com.aviary.android.feather.common.threading.this._cls0
{

    final BadgeService this$0;

    public volatile Object run(com.aviary.android.feather.common.threading.er er, Object aobj[])
        throws Exception
    {
        return run(er, (Integer[])aobj);
    }

    public transient Set run(com.aviary.android.feather.common.threading.er er, Integer ainteger[])
        throws Exception
    {
        IAviaryController iaviarycontroller = getContext();
        if (iaviarycontroller == null)
        {
            er = null;
        } else
        {
            ainteger = new HashSet();
            PreferenceService preferenceservice = (PreferenceService)iaviarycontroller.getService(com/aviary/android/feather/library/services/PreferenceService);
            if (preferenceservice == null)
            {
                return null;
            }
            if (BadgeService.access$100(BadgeService.this, iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ry.Tools.EFFECTS, "effect"))
            {
                ainteger.add(com.aviary.android.feather.library.filters.ry.Tools.EFFECTS);
            }
            if (BadgeService.access$100(BadgeService.this, iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ry.Tools.FRAMES, "frame"))
            {
                ainteger.add(com.aviary.android.feather.library.filters.ry.Tools.FRAMES);
            }
            if (BadgeService.access$100(BadgeService.this, iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ry.Tools.STICKERS, "sticker"))
            {
                ainteger.add(com.aviary.android.feather.library.filters.ry.Tools.STICKERS);
            }
            er = ainteger;
            if (BadgeService.access$100(BadgeService.this, iaviarycontroller, preferenceservice, com.aviary.android.feather.library.filters.ry.Tools.OVERLAYS, "overlay"))
            {
                ainteger.add(com.aviary.android.feather.library.filters.ry.Tools.OVERLAYS);
                return ainteger;
            }
        }
        return er;
    }

    er()
    {
        this$0 = BadgeService.this;
        super();
    }
}
