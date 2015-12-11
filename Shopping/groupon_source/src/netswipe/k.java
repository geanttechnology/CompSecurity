// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            au

public class k extends AnimatorListenerAdapter
{

    final ScanCardActivity a;

    public k(ScanCardActivity scancardactivity)
    {
        a = scancardactivity;
        super();
    }

    public void onAnimationStart(Animator animator)
    {
        a.bottomButtonBar.setVisibility(0);
    }
}
