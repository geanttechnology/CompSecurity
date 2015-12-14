// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeFragement;
import com.instamag.activity.view.TDecorateInfosLayerView;

public class bak
    implements android.view.View.OnClickListener
{

    final MagComposeFragement a;

    public bak(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }

    public void onClick(View view)
    {
        MagComposeFragement.access$700(a).setCurSelectedDecorateText(MagComposeFragement.access$600(a).getText().toString());
        if (MagComposeFragement.access$600(a).getTag() != null && (MagComposeFragement.access$600(a).getTag() instanceof Integer) && (((Integer)MagComposeFragement.access$600(a).getTag()).intValue() == 5 || ((Integer)MagComposeFragement.access$600(a).getTag()).intValue() == 10 || ((Integer)MagComposeFragement.access$600(a).getTag()).intValue() == 9))
        {
            MagComposeFragement.access$800(a, MagComposeFragement.access$600(a).getText().toString(), ((Integer)MagComposeFragement.access$600(a).getTag()).intValue());
        }
        if (a.mActivity != null)
        {
            a.mActivity.a(true);
        }
        a.hideSoftKeyborad(MagComposeFragement.access$600(a));
        MagComposeFragement.access$600(a).clearFocus();
        MagComposeFragement.access$900(a).setVisibility(4);
    }
}
