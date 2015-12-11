// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.jumio.netswipe.sdk.NetswipeCustomScanInterface;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            dy, bg, ew, ch, 
//            eb, bp, dz, ec

public class dk
    implements dy
{

    private TextureView a;
    private ew b;
    private ImageView c;
    private NetswipeCustomScanInterface d;
    private Context e;

    public dk(RelativeLayout relativelayout, NetswipeCustomScanInterface netswipecustomscaninterface)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        e = relativelayout.getContext();
        d = netswipecustomscaninterface;
        int i = (int)bg.a(e, 10F);
        int j = (int)bg.a(e, 20F);
        int k = (int)bg.a(e, 17F);
        relativelayout.removeAllViews();
        a = new TextureView(e);
        a.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        relativelayout.addView(a);
        b = new ew(e);
        b.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        relativelayout.addView(b);
        c = new ImageView(e);
        netswipecustomscaninterface = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        netswipecustomscaninterface.addRule(12);
        netswipecustomscaninterface.addRule(14);
        c.setLayoutParams(netswipecustomscaninterface);
        c.setAdjustViewBounds(true);
        c.setPadding(j, i, j, k);
        c.setImageBitmap(eb.a(e.getResources(), ch.b));
        bp.a(c, 0);
        relativelayout.addView(c);
    }

    public boolean doAdditionalStep(InternalCardInformation internalcardinformation)
    {
        return false;
    }

    public ew getScanOverlayView()
    {
        return b;
    }

    public TextureView getTextureView()
    {
        return a;
    }

    public void performAdditionalStep(InternalCardInformation internalcardinformation)
    {
    }

    public void prepareBlurView(boolean flag)
    {
    }

    public void presentError(dz dz1, InternalCardInformation internalcardinformation, ArrayList arraylist)
    {
        b.setVisibility(4);
        d.onNetswipeError(dz1.a(), ec.a(e, dz1.b()), dz1.d(), arraylist);
    }

    public void restoreScanView()
    {
    }

    public void setDebugText(String s)
    {
    }

    public void showBlurView()
    {
    }

    public void showBranding(boolean flag)
    {
        if (flag)
        {
            if (bp.a(c) == 0.0F)
            {
                ObjectAnimator objectanimator = ObjectAnimator.ofInt(c, "alpha", new int[] {
                    0, 255
                });
                objectanimator.setDuration(200L);
                objectanimator.start();
            }
            return;
        } else
        {
            bp.a(c, 0);
            return;
        }
    }
}
