// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.socialin.android.d;
import org.json.JSONArray;

// Referenced classes of package com.socialin.android.activity:
//            FragmentActionsListener

public abstract class FragmentActionsListenerActivity extends AppCompatActivity
    implements FragmentActionsListener
{

    private final String LOG_TAG = (new StringBuilder()).append(com/socialin/android/activity/FragmentActionsListener.getSimpleName()).append(" - ").toString();

    public FragmentActionsListenerActivity()
    {
    }

    public void dismissFragmentProgressDialog()
    {
        d.b(LOG_TAG, new Object[] {
            "dismissFragmentProgressDialog"
        });
    }

    public void onFragmentBack(int i, Bundle bundle)
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentBack"
        });
    }

    public void onFragmentFinishWithResultCancel(int i)
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentFinishWithResultCancel"
        });
    }

    public void onFragmentFinishWithResultError(int i)
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentFinishWithResultError"
        });
    }

    public void onFragmentFinishWithResultOK(int i)
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentFinishWithResultOK"
        });
    }

    public void onFragmentImageSelected(String s, boolean flag, String as[], String as1[], int i, JSONArray jsonarray)
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentImageSelected"
        });
    }

    public void onFragmentLoaded()
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentLoaded"
        });
    }

    public void onFragmentResult(int i, Intent intent)
    {
        d.b(LOG_TAG, new Object[] {
            "onFragmentResult"
        });
    }

    public void onPicsinGalleryOpen()
    {
        d.b(LOG_TAG, new Object[] {
            "onPicsinGalleryOpen"
        });
    }

    public void onPicsinLogout()
    {
        d.b(LOG_TAG, new Object[] {
            "onPicsinLogout"
        });
    }

    public void onPicsinUserGalleryOpen()
    {
        d.b(LOG_TAG, new Object[] {
            "onPicsinUserGalleryOpen"
        });
    }

    public void onSocialLogout(int i)
    {
        d.b(LOG_TAG, new Object[] {
            "onSocialLogout"
        });
    }

    public void removeFacebookFragments()
    {
        d.b(LOG_TAG, new Object[] {
            "removeFacebookFragments"
        });
    }

    public void removeFlickrFragment()
    {
        d.b(LOG_TAG, new Object[] {
            "removeFlickrFragment"
        });
    }

    public void showFragmentNoNetworkDialog()
    {
        d.b(LOG_TAG, new Object[] {
            "showFragmentNoNetworkDialog"
        });
    }

    public void showFragmentProgressDialog(String s, String s1, boolean flag)
    {
        d.b(LOG_TAG, new Object[] {
            "showFragmentProgressDialog"
        });
    }
}
