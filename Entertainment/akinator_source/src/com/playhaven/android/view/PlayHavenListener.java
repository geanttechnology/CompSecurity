// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.view;

import android.os.Bundle;
import com.playhaven.android.PlayHavenException;

// Referenced classes of package com.playhaven.android.view:
//            PlayHavenView

public interface PlayHavenListener
{

    public abstract void viewDismissed(PlayHavenView playhavenview, PlayHavenView.DismissType dismisstype, Bundle bundle);

    public abstract void viewFailed(PlayHavenView playhavenview, PlayHavenException playhavenexception);
}
