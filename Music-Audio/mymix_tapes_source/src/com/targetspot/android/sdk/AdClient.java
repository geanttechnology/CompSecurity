// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;

import android.app.Activity;
import android.app.Service;
import android.util.SparseIntArray;
import com.targetspot.android.sdk.service.AdBreak;
import com.targetspot.android.sdk.service.AdSegment;

// Referenced classes of package com.targetspot.android.sdk:
//            AdListener

public interface AdClient
{

    public abstract void adClicked(AdSegment adsegment);

    public abstract void adPlayed(AdSegment adsegment);

    public abstract AdBreak beginBreak(boolean flag, int i);

    public abstract boolean breakAvail();

    public abstract boolean breakAvail(int i);

    public abstract void endBreak(boolean flag);

    public abstract void enterActivity(Activity activity, AdListener adlistener);

    public abstract void enterService(Service service, AdListener adlistener);

    public abstract SparseIntArray getAvailBreaks();

    public abstract int[] getAvailableAds();

    public abstract String getCacheURL(String s);

    public abstract void hideInlineAd();

    public abstract void leaveActivity();

    public abstract void leaveService();

    public abstract void refreshBreaks();

    public abstract void showInlineAd(int i);

    public abstract void showPreRollAd(int i);
}
