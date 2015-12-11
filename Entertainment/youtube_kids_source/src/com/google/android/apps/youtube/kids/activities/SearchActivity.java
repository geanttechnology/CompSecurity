// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import aaa;
import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import bmr;
import bpd;
import bpf;
import bvy;
import com.google.android.apps.youtube.kids.ui.HeaderTileGridLayout;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;
import dre;
import dwl;
import vq;
import yn;
import yo;
import yp;
import yq;
import yr;
import ys;
import zj;

// Referenced classes of package com.google.android.apps.youtube.kids.activities:
//            VoiceSearchActivity

public class SearchActivity extends zj
{

    private String k;
    private boolean l;
    private HeaderTileGridLayout m;
    private bpd n;
    private SearchManager o;
    private SearchView p;
    private View q;
    private View r;
    private bvy s;
    private Intent t;

    public SearchActivity()
    {
    }

    public static bvy a(SearchActivity searchactivity, bvy bvy)
    {
        searchactivity.s = bvy;
        return bvy;
    }

    public static void a(SearchActivity searchactivity)
    {
        searchactivity.startActivityForResult(new Intent(searchactivity, com/google/android/apps/youtube/kids/activities/VoiceSearchActivity), 0);
    }

    public static void b(SearchActivity searchactivity)
    {
        searchactivity.o();
    }

    public static bpd c(SearchActivity searchactivity)
    {
        return searchactivity.n;
    }

    public static bvy d(SearchActivity searchactivity)
    {
        return searchactivity.s;
    }

    private static boolean n()
    {
        try
        {
            System.loadLibrary("google_recognizer_jni_l");
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            try
            {
                System.loadLibrary("google_recognizer_jni");
            }
            catch (UnsatisfiedLinkError unsatisfiedlinkerror1)
            {
                return false;
            }
            return true;
        }
        return true;
    }

    private void o()
    {
        super.j.a();
        l();
        bpf bpf1 = n.a();
        bpf1.a(k);
        bpf1.a(new byte[0]);
        n.a(bpf1, new ys(this, super.f));
    }

    private void p()
    {
        dwl dwl1 = new dwl();
        dwl1.a = k;
        dre dre1 = new dre();
        dre1.d = dwl1;
        super.f = dre1;
    }

    public final bvy h()
    {
        return s;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 0 && j == -1 && intent != null)
        {
            intent = intent.getStringExtra("RecognizedText");
            if (!TextUtils.isEmpty(intent))
            {
                k = intent;
                l = true;
            }
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        setContentView(0x7f04005c);
        super.onCreate(bundle);
        m = (HeaderTileGridLayout)findViewById(0x7f1000b7);
        n = (bpd)c().p.b_();
        a(new yq(this));
        super.j = m.a;
        r = findViewById(0x7f100198);
        q = findViewById(0x7f1000c0);
        q.setOnClickListener(new yn(this));
        if (!n())
        {
            r.setVisibility(4);
        }
        r.setOnClickListener(new yo(this));
        LinearLayout linearlayout;
        int i;
        if (!PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("LimitSearchResults", false))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            bundle = new yr(this);
        } else
        {
            bundle = null;
        }
        a(bundle);
        o = (SearchManager)getSystemService("search");
        p = (SearchView)findViewById(0x7f100199);
        p.setIconifiedByDefault(false);
        try
        {
            p.setSearchableInfo(o.getSearchableInfo(getComponentName()));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        t = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        t.addFlags(0x10000000);
        try
        {
            i = getResources().getIdentifier("android:id/search_mag_icon", null, null);
            p.findViewById(i).setLayoutParams(new android.widget.LinearLayout.LayoutParams(0, 0));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            i = getResources().getDimensionPixelSize(0x7f0a00ff);
            int j = getResources().getIdentifier("android:id/search_src_text", null, null);
            bundle = (AutoCompleteTextView)p.findViewById(j);
            android.view.ViewGroup.LayoutParams layoutparams = bundle.getLayoutParams();
            bundle.setPrivateImeOptions("nm");
            layoutparams.height = i;
            bundle.setLayoutParams(layoutparams);
            j = getResources().getIdentifier("android:id/search_close_btn", null, null);
            bundle = (ImageView)p.findViewById(j);
            bundle.setScaleType(android.widget.ImageView.ScaleType.CENTER);
            bundle.setLayoutParams(new android.widget.LinearLayout.LayoutParams(i, i));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            bundle = getResources().getDrawable(0x7f02026b);
            linearlayout = (LinearLayout)findViewById(0x7f100096);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
        if (linearlayout == null)
        {
            break MISSING_BLOCK_LABEL_414;
        }
        linearlayout.setBackground(bundle);
    }

    protected void onNewIntent(Intent intent)
    {
        setIntent(intent);
        if ("android.intent.action.SEARCH".equals(intent.getAction()))
        {
            k = intent.getStringExtra("query");
            if (k == null)
            {
                k = "";
            } else
            {
                p.setQuery(k, false);
                p.clearFocus();
            }
            k = k;
            if (k != null)
            {
                o();
            }
        }
        p();
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        l = true;
        k = bundle.getString("query");
    }

    public void onResume()
    {
label0:
        {
            {
                super.onResume();
                if (f())
                {
                    finish();
                }
                if (l && k != null)
                {
                    p();
                    o();
                    p.setQuery(k, false);
                }
                l = false;
                if (p.getQuery().length() <= 0)
                {
                    break label0;
                }
                try
                {
                    int i = getResources().getIdentifier("android:id/search_src_text", null, null);
                    AutoCompleteTextView autocompletetextview = (AutoCompleteTextView)p.findViewById(i);
                    autocompletetextview.setThreshold(99);
                    autocompletetextview.postDelayed(new yp(this, autocompletetextview), 50L);
                }
                catch (android.content.res.Resources.NotFoundException notfoundexception) { }
                p.clearFocus();
                getWindow().setSoftInputMode(3);
                m.requestFocus();
            }
            p();
            p.setFocusable(false);
            return;
        }
        if (p.requestFocus())
        {
            getWindow().setSoftInputMode(4);
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_140;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("query", k);
    }
}
