// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.fotoable.sketch.view.TTieZhiViewCell;

public class oz
    implements android.view.View.OnClickListener
{

    final TTieZhiViewCell a;

    private oz(TTieZhiViewCell ttiezhiviewcell)
    {
        a = ttiezhiviewcell;
        super();
    }

    public oz(TTieZhiViewCell ttiezhiviewcell, com.fotoable.sketch.view.TTieZhiViewCell._cls1 _pcls1)
    {
        this(ttiezhiviewcell);
    }

    public void onClick(View view)
    {
        if (TTieZhiViewCell.access$100(a) != null)
        {
            if (!TTieZhiViewCell.access$100(a).isGroupEnable)
            {
                if (oo.a().b(TTieZhiViewCell.access$100(a).resId))
                {
                    TTieZhiViewCell.access$200(a, TTieZhiViewCell.access$100(a));
                    return;
                }
                if (TTieZhiViewCell.access$300(a) == null || !(new ub(TTieZhiViewCell.access$300(a), TTieZhiViewCell.access$100(a))).a())
                {
                    TTieZhiViewCell.access$400(a, TTieZhiViewCell.access$100(a));
                    return;
                }
            } else
            {
                TTieZhiViewCell.access$500(a);
                return;
            }
        }
    }
}
