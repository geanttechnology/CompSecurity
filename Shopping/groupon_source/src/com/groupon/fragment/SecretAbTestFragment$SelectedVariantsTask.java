// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.preference.DialogPreference;
import android.preference.PreferenceScreen;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.groupon.service.core.AbTestService;
import com.groupon.util.GrouponSafeAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretAbTestFragment

private class <init> extends GrouponSafeAsyncTask
{

    private List selectedVariantsList;
    final SecretAbTestFragment this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Object obj = ((AbTestService)SecretAbTestFragment.access$300(SecretAbTestFragment.this).get()).listExperiments();
        selectedVariantsList = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            String s1 = ((AbTestService)SecretAbTestFragment.access$300(SecretAbTestFragment.this).get()).getVariantWithoutLogging(s);
            if (!Strings.equalsIgnoreCase(s1, "original"))
            {
                selectedVariantsList.add((new StringBuilder()).append(s).append("=").append(s1).toString());
            }
        } while (true);
        return null;
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
        throws Exception
    {
        super.onSuccess(void1);
        void1 = new DialogPreference(getActivity(), null) {

            final SecretAbTestFragment.SelectedVariantsTask this$1;

            protected View onCreateDialogView()
            {
                ListView listview = new ListView(getActivity());
                listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, selectedVariantsList));
                return listview;
            }

            protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
            {
                builder.setPositiveButton("", null);
                builder.setNegativeButton("Close", new SecretAbTestFragment.CloseDialogClickListener(null));
                super.onPrepareDialogBuilder(builder);
            }

            
            {
                this$1 = SecretAbTestFragment.SelectedVariantsTask.this;
                super(context, attributeset);
            }
        };
        void1.setTitle("Click to see the selected variants");
        getPreferenceScreen().addPreference(void1);
    }


    private _cls1.this._cls1()
    {
        this$0 = SecretAbTestFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
