// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzcm

public interface zzcq
    extends IInterface
{

    public abstract String getBody();

    public abstract String getCallToAction();

    public abstract Bundle getExtras();

    public abstract String getHeadline();

    public abstract List getImages();

    public abstract String getPrice();

    public abstract double getStarRating();

    public abstract String getStore();

    public abstract zzcm zzdw();

    public abstract zzd zzdx();
}
