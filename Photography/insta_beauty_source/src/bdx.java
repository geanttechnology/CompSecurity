// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.CompoundButton;
import com.instamag.activity.library.view.MaglibItemView;

public class bdx
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final MaglibItemView a;

    public bdx(MaglibItemView maglibitemview)
    {
        a = maglibitemview;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            aqx.b(a.getContext(), "MaglibItemView", "deleteInfoTagTip", true);
            return;
        } else
        {
            aqx.b(a.getContext(), "MaglibItemView", "deleteInfoTagTip", false);
            return;
        }
    }
}
