// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Handler;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeFragement;
import com.instamag.activity.view.TMaskScrollImageView;
import java.util.ArrayList;
import java.util.List;

class bah
    implements Runnable
{

    final bag a;

    bah(bag bag1)
    {
        a = bag1;
        super();
    }

    public void run()
    {
        int i;
        if (MagComposeFragement.access$100(a.a) != null && MagComposeFragement.access$200(a.a) != null && a.a.mActivity != null)
        {
            i = ((Integer)MagComposeFragement.access$100(a.a).getTag()).intValue();
            break MISSING_BLOCK_LABEL_59;
        }
        do
        {
            return;
        } while (i >= a.a.mActivity.f().size() || i >= a.a.mActivity.e().size());
        String s = (String)a.a.mActivity.e().get(i);
        if (s == null)
        {
            FlurryAgent.onError((new StringBuilder()).append(MagComposeFragement.access$300(a.a)).append("004").toString(), "unexpected", "004");
            return;
        } else
        {
            Intent intent = new Intent(a.a.getActivity(), com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
            intent.putExtra("FotoBeautyActivity_SelectedImageUri", s);
            intent.putExtra("FotoBeautyActivity_NeedReturnUri", "need return");
            a.a.startActivityForResult(intent, 0);
            MagComposeFragement.access$400(a.a).sendEmptyMessage(0);
            return;
        }
    }
}
