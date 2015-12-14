// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.Button;
import com.flurry.android.FlurryAgent;
import com.fotoable.savepagescrollview.FotoBigPicAdViewItem;
import java.util.HashMap;
import java.util.Map;

public class atd
    implements android.view.View.OnClickListener
{

    final FotoBigPicAdViewItem a;

    public atd(FotoBigPicAdViewItem fotobigpicadviewitem)
    {
        a = fotobigpicadviewitem;
        super();
    }

    public void onClick(View view)
    {
        if (FotoBigPicAdViewItem.access$000(a) == null)
        {
            FotoBigPicAdViewItem.access$002(a, new HashMap());
        }
        view = (ate)view.getTag();
        if (FotoBigPicAdViewItem.access$100(a).getText().equals("Open"))
        {
            FotoBigPicAdViewItem.access$200(a, ((ate) (view)).e);
            FotoBigPicAdViewItem.access$000(a).put(a.SavePageScrollOpened, ((ate) (view)).a);
        } else
        {
            FotoBigPicAdViewItem.access$300(a, ((ate) (view)).f);
            FotoBigPicAdViewItem.access$000(a).put(a.SavePageScrollClicked, ((ate) (view)).a);
        }
        FlurryAgent.logEvent(a.SavePageScrollClicked, FotoBigPicAdViewItem.access$000(a));
    }
}
