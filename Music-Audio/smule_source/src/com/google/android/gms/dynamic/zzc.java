// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;

// Referenced classes of package com.google.android.gms.dynamic:
//            zzd

public interface zzc
    extends IInterface
{

    public abstract Bundle getArguments();

    public abstract int getId();

    public abstract boolean getRetainInstance();

    public abstract String getTag();

    public abstract int getTargetRequestCode();

    public abstract boolean getUserVisibleHint();

    public abstract zzd getView();

    public abstract boolean isAdded();

    public abstract boolean isDetached();

    public abstract boolean isHidden();

    public abstract boolean isInLayout();

    public abstract boolean isRemoving();

    public abstract boolean isResumed();

    public abstract boolean isVisible();

    public abstract void setHasOptionsMenu(boolean flag);

    public abstract void setMenuVisibility(boolean flag);

    public abstract void setRetainInstance(boolean flag);

    public abstract void setUserVisibleHint(boolean flag);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    public abstract void zze(zzd zzd);

    public abstract void zzf(zzd zzd);

    public abstract zzd zzov();

    public abstract zzc zzow();

    public abstract zzd zzox();

    public abstract zzc zzoy();
}
