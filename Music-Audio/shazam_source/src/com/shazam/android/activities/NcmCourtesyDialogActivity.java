// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.View;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.aq.a;
import com.shazam.android.aspects.c.a.b;
import com.shazam.android.fragment.c;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import java.util.List;

// Referenced classes of package com.shazam.android.activities:
//            c

public class NcmCourtesyDialogActivity extends b
    implements android.view.View.OnClickListener, com.shazam.android.activities.c, a
{

    private final EventAnalytics a = com.shazam.i.b.g.b.a.a();
    private long b;
    private UrlCachingImageView c;

    public NcmCourtesyDialogActivity()
    {
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroid";
    }

    public void onClick(View view)
    {
        a.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "ncmcourtesymessage").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, "close").build()).build());
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030028);
        c = (UrlCachingImageView)findViewById(0x7f1100f4);
        findViewById(0x7f1100f5).setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        CharSequence charsequence = menuitem.getTitle();
        if (charsequence != null)
        {
            menuitem.setTitleCondensed(charsequence.toString());
        }
        return super.onOptionsItemSelected(menuitem);
    }

    public void onStart()
    {
        super.onStart();
        b = System.currentTimeMillis();
        String s = getIntent().getStringExtra("extraImageUrl");
        c.a(s).c();
    }

    public void onStop()
    {
        super.onStop();
        long l = System.currentTimeMillis();
        long l1 = b;
        a.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.IMPRESSION).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, "ncmcourtesymessage").putNotEmptyOrNullParameter(DefinedEventParameterKey.TIME_SPENT, String.valueOf(l - l1)).build()).build());
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        List list = getSupportFragmentManager().f();
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                Fragment fragment = (Fragment)list.get(i);
                if (fragment instanceof c)
                {
                    ((c)fragment).onWindowFocusChanged(flag);
                }
            }

        }
    }
}
