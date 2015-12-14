// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.gpuimage.sample.activity.CameraFilterItemView;
import com.fotoable.beautyui.gpuimage.sample.activity.CameraFilterScrollView;

public class py
    implements android.view.View.OnClickListener
{

    final CameraFilterScrollView a;

    public py(CameraFilterScrollView camerafilterscrollview)
    {
        a = camerafilterscrollview;
        super();
    }

    public void onClick(View view)
    {
        if (CameraFilterScrollView.access$000(a) != view)
        {
            if (CameraFilterScrollView.access$000(a) != null)
            {
                CameraFilterScrollView.access$000(a).setSelected(false);
            }
            CameraFilterScrollView.access$100(a, view);
            CameraFilterScrollView.access$002(a, (CameraFilterItemView)view);
            view.setSelected(true);
            CameraFilterScrollView.access$202(a, ((Integer)view.getTag()).intValue());
            if (CameraFilterScrollView.access$300(a) != null)
            {
                CameraFilterScrollView.access$300(a).a(CameraFilterScrollView.access$000(a).getFilterPath(), CameraFilterScrollView.access$000(a).getTextRes(), CameraFilterScrollView.access$000(a).getText());
                return;
            }
        }
    }
}
