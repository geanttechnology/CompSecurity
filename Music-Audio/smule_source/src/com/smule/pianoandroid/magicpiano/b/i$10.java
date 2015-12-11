// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.content.res.Resources;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

final class plication
    implements Observer
{

    public void update(Observable observable, Object obj)
    {
        MagicApplication.getInstance().showToast(MagicApplication.getInstance().getResources().getString(0x7f0c0230), 1);
    }

    plication()
    {
    }
}
