// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeLinkFragement;

public class bav
    implements android.view.View.OnClickListener
{

    final MagComposeLinkFragement a;

    public bav(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public void onClick(View view)
    {
        if (MagComposeLinkFragement.c(a) != null && (MagComposeLinkFragement.c(a) instanceof TextView))
        {
            ((TextView)MagComposeLinkFragement.c(a)).setText(MagComposeLinkFragement.d(a).getText().toString());
        }
        if (a.a != null)
        {
            a.a.a(true);
        }
        a.b(MagComposeLinkFragement.d(a));
        if (MagComposeLinkFragement.e(a))
        {
            a.d.setVisibility(0);
        }
        MagComposeLinkFragement.d(a).clearFocus();
        MagComposeLinkFragement.f(a).setVisibility(4);
    }
}
