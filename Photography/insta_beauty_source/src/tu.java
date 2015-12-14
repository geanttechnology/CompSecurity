// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.newui.MNewFindFaceFragment;

public class tu
    implements android.view.View.OnClickListener
{

    final MNewFindFaceFragment a;

    public tu(MNewFindFaceFragment mnewfindfacefragment)
    {
        a = mnewfindfacefragment;
        super();
    }

    public void onClick(View view)
    {
        if (MNewFindFaceFragment.c(a) != null)
        {
            MNewFindFaceFragment.c(a).a();
            FlurryAgent.logEvent("selectfacePoint_cancelbutton_clicked");
        }
    }
}
