// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.xfinity.playerlib.alt.speechrecognizers.KidsSpeechRecognizer;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            KidsFilterDialogFragment

public class KidsActivity extends PlayNowFlyinMenuActivity
    implements FilterRequestObserver
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/KidsActivity);

    public KidsActivity()
    {
    }

    private void addExtras()
    {
        ActivityInfo activityinfo;
        Intent intent;
        intent = getIntent();
        activityinfo = null;
        ActivityInfo activityinfo1 = getPackageManager().getActivityInfo(getComponentName(), 129);
        activityinfo = activityinfo1;
_L2:
        if (activityinfo != null)
        {
            intent.putExtra("label", getResources().getString(activityinfo.labelRes));
        }
        setIntent(intent);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        LOG.error("Caught name not found exception", namenotfoundexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_kids_programs;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_kids;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;
    }

    public void onCreate(Bundle bundle)
    {
        addExtras();
        super.onCreate(bundle);
    }

    public void showFilter(Bundle bundle)
    {
        (new KidsFilterDialogFragment()).show(getFragmentManager(), "kidsfilterdialogfragment");
    }

}
