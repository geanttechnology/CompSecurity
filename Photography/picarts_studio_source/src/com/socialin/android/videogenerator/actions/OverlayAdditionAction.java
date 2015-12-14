// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import com.socialin.android.brushlib.overlay.Overlay;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action

public class OverlayAdditionAction extends Action
{

    private static final long serialVersionUID = 0x39689a728c841dc0L;
    private UUID layerId;
    private Overlay overlay;

    public OverlayAdditionAction(Overlay overlay1, UUID uuid, String s)
    {
        super(s);
        overlay = overlay1;
        layerId = uuid;
    }

    public void apply(a a1)
    {
        a1 = a1.a(layerId);
        overlay.draw(a1.b());
    }

    public String getActionDescription()
    {
        return "Adding Overlay";
    }

    public Overlay getOverlay()
    {
        return overlay;
    }

    public String toString()
    {
        return (new StringBuilder("Adding Overlay overlay:")).append(overlay).toString();
    }
}
