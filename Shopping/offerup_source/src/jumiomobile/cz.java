// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.widget.LinearLayout;
import com.jumio.netswipe.sdk.activity.ScanCardActivity;

// Referenced classes of package jumiomobile:
//            ew

public class cz
    implements android.view.View.OnLayoutChangeListener
{

    final int a;
    final ScanCardActivity b;

    public cz(ScanCardActivity scancardactivity, int i)
    {
        b = scancardactivity;
        a = i;
        super();
    }

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        i = ScanCardActivity.b(b).getBottomPositionOfRoi();
        ScanCardActivity.c(b).setY(i + a);
    }
}
