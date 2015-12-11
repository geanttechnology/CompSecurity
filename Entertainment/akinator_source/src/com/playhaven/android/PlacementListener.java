// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android;

import android.os.Bundle;

// Referenced classes of package com.playhaven.android:
//            Placement, PlayHavenException

public interface PlacementListener
{

    public abstract void contentDismissed(Placement placement, com.playhaven.android.view.PlayHavenView.DismissType dismisstype, Bundle bundle);

    public abstract void contentFailed(Placement placement, PlayHavenException playhavenexception);

    public abstract void contentLoaded(Placement placement);
}
