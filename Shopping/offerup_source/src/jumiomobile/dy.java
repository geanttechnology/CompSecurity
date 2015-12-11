// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.TextureView;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            ew, dz

public interface dy
{

    public abstract boolean doAdditionalStep(InternalCardInformation internalcardinformation);

    public abstract ew getScanOverlayView();

    public abstract TextureView getTextureView();

    public abstract void performAdditionalStep(InternalCardInformation internalcardinformation);

    public abstract void prepareBlurView(boolean flag);

    public abstract void presentError(dz dz, InternalCardInformation internalcardinformation, ArrayList arraylist);

    public abstract void restoreScanView();

    public abstract void setDebugText(String s);

    public abstract void showBlurView();

    public abstract void showBranding(boolean flag);
}
