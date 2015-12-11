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
import java.util.List;
import java.util.Locale;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretAbTestFragment

private class <init> extends GrouponSafeAsyncTask
{

    private List missingExperimentsList;
    final SecretAbTestFragment this$0;
    private List unusedExperimentsList;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        missingExperimentsList = ((AbTestService)SecretAbTestFragment.access$300(SecretAbTestFragment.this).get()).getExperimentsMissingFromStatusCall();
        unusedExperimentsList = ((AbTestService)SecretAbTestFragment.access$300(SecretAbTestFragment.this).get()).getUnusedExperimentsFromStatusCall();
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

            final SecretAbTestFragment.MissingOrUnusedExperimentsTask this$1;

            protected View onCreateDialogView()
            {
                ListView listview = new ListView(getActivity());
                listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, missingExperimentsList));
                return listview;
            }

            protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
            {
                builder.setPositiveButton("", null);
                builder.setNegativeButton("Close", new SecretAbTestFragment.CloseDialogClickListener(null));
                super.onPrepareDialogBuilder(builder);
            }

            
            {
                this$1 = SecretAbTestFragment.MissingOrUnusedExperimentsTask.this;
                super(context, attributeset);
            }
        };
        void1.setTitle(String.format(Locale.US, "%d experiments missing in status call", new Object[] {
            Integer.valueOf(missingExperimentsList.size())
        }));
        void1.setSummary("Check logcat for full details");
        getPreferenceScreen().addPreference(void1);
        void1 = new DialogPreference(getActivity(), null) {

            final SecretAbTestFragment.MissingOrUnusedExperimentsTask this$1;

            protected View onCreateDialogView()
            {
                ListView listview = new ListView(getActivity());
                listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, unusedExperimentsList));
                return listview;
            }

            protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
            {
                builder.setPositiveButton("", null);
                builder.setNegativeButton("Close", new SecretAbTestFragment.CloseDialogClickListener(null));
                super.onPrepareDialogBuilder(builder);
            }

            
            {
                this$1 = SecretAbTestFragment.MissingOrUnusedExperimentsTask.this;
                super(context, attributeset);
            }
        };
        void1.setTitle(String.format(Locale.US, "%d experiments in status call not used", new Object[] {
            Integer.valueOf(unusedExperimentsList.size())
        }));
        void1.setSummary("Check logcat for full details");
        getPreferenceScreen().addPreference(void1);
    }



    private _cls2.this._cls1()
    {
        this$0 = SecretAbTestFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
