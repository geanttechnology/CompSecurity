// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.TextView;
import com.fotoable.photocollage.activity.compose2.CollageHandleView;
import com.fotoable.photocollage.view.compose2.Compose2ModuleBgView;
import com.fotoable.photocollage.view.compose2.Compose2ModuleCornorView;
import com.fotoable.photocollage.view.compose2.Compose2ModuleFramesView;

public class le
    implements android.view.View.OnClickListener
{

    final CollageHandleView a;

    public le(CollageHandleView collagehandleview)
    {
        a = collagehandleview;
        super();
    }

    public void onClick(View view)
    {
        a.setCornorInfo();
        CollageHandleView.access$000(a).setTextColor(-1);
        CollageHandleView.access$100(a).setTextColor(0xff007aff);
        CollageHandleView.access$200(a).setTextColor(-1);
        CollageHandleView.access$300(a).setVisibility(0);
        CollageHandleView.access$400(a).setVisibility(4);
        CollageHandleView.access$500(a).setVisibility(4);
    }
}
