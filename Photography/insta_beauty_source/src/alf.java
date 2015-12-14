// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.mosaic.MosaicIconScrollView;
import com.fotoable.fotoproedit.activity.mosaic.MosaicInfo;

public class alf
    implements android.view.View.OnClickListener
{

    final MosaicIconScrollView a;

    public alf(MosaicIconScrollView mosaiciconscrollview)
    {
        a = mosaiciconscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (!view.isSelected())
        {
            if (MosaicIconScrollView.access$000(a) != null)
            {
                MosaicIconScrollView.access$000(a).setSelected(false);
            }
            MosaicIconScrollView.access$002(a, view);
            MosaicIconScrollView.access$100(a, view);
            MosaicIconScrollView.access$000(a).setSelected(true);
            if (MosaicIconScrollView.access$200(a) != null)
            {
                MosaicIconScrollView.access$200(a).a((MosaicInfo)view.getTag());
                return;
            }
        }
    }
}
