// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import android.content.Context;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.ads:
//            i, h

public interface c
{

    public abstract i fetchAd(Context context, String s, String s1, HashMap hashmap);

    public abstract h fetchInterstitialAd(Context context, String s, String s1, HashMap hashmap);
}
