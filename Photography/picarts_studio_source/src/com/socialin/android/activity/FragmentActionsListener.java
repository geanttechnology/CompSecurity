// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.activity:
//            ActivityResultListener

public interface FragmentActionsListener
{

    public abstract void dismissFragmentProgressDialog();

    public abstract void onFragmentBack(int i, Bundle bundle);

    public abstract void onFragmentFinishWithResultCancel(int i);

    public abstract void onFragmentFinishWithResultError(int i);

    public abstract void onFragmentFinishWithResultOK(int i);

    public abstract void onFragmentImageSelected(String s, boolean flag, String as[], String as1[], int i, JSONArray jsonarray);

    public abstract void onFragmentLoaded();

    public abstract void onFragmentResult(int i, Intent intent);

    public abstract void onPicsinGalleryOpen();

    public abstract void onPicsinLogout();

    public abstract void onPicsinUserGalleryOpen();

    public abstract void onSocialLogout(int i);

    public abstract void removeFacebookFragments();

    public abstract void removeFlickrFragment();

    public abstract void setOnResultListener(ActivityResultListener activityresultlistener);

    public abstract void showFragmentNoNetworkDialog();

    public abstract void showFragmentProgressDialog(String s, String s1, boolean flag);
}
