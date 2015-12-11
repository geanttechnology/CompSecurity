// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.groupon.activity.IntentFactory;
import com.groupon.models.status.Status;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.StatusService;
import com.groupon.util.GrouponSafeAsyncTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretAbTestFragment extends BaseSecretSettingsFragment
{
    private static class CloseDialogClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.dismiss();
        }

        private CloseDialogClickListener()
        {
        }

    }

    private class CustomAbTestPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference pref;
        final SecretAbTestFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            obj = (String)obj;
            String as[] = ((String) (obj)).split("=");
            if (Strings.notEmpty(as[0]) && as.length == 2 && !Strings.equals("experiment_id", as[0]))
            {
                ((AbTestService)abTestService.get()).setOverride(as[0], as[1]);
                if (Strings.notEmpty(as[1]))
                {
                    pref.setText(((String) (obj)));
                    pref.setSummary(((CharSequence) (obj)));
                } else
                {
                    pref.setText("experiment_id=variant");
                    pref.setSummary("Click to add a experiment_id=variant pair");
                }
                refreshAbTestAndRecreate();
                return false;
            }
            if (Strings.notEmpty(as[0]) && as.length == 1 && Strings.equals(preference.getTitle(), as[0]))
            {
                ((AbTestService)abTestService.get()).removeOverride(as[0]);
                getPreferenceScreen().removePreference(preference);
                refreshAbTestAndRecreate();
                return false;
            } else
            {
                Toast.makeText(getActivity(), "A/B Test Overrides must be specified as experiment_id=variant", 1).show();
                return false;
            }
        }

        public CustomAbTestPreferenceChangeListener(EditTextPreference edittextpreference)
        {
            this$0 = SecretAbTestFragment.this;
            super();
            pref = edittextpreference;
        }
    }

    private class MissingOrUnusedExperimentsTask extends GrouponSafeAsyncTask
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
            missingExperimentsList = ((AbTestService)abTestService.get()).getExperimentsMissingFromStatusCall();
            unusedExperimentsList = ((AbTestService)abTestService.get()).getUnusedExperimentsFromStatusCall();
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

                final MissingOrUnusedExperimentsTask this$1;

                protected View onCreateDialogView()
                {
                    ListView listview = new ListView(getActivity());
                    listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, missingExperimentsList));
                    return listview;
                }

                protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
                {
                    builder.setPositiveButton("", null);
                    builder.setNegativeButton("Close", new CloseDialogClickListener());
                    super.onPrepareDialogBuilder(builder);
                }

            
            {
                this$1 = MissingOrUnusedExperimentsTask.this;
                super(context, attributeset);
            }
            };
            void1.setTitle(String.format(Locale.US, "%d experiments missing in status call", new Object[] {
                Integer.valueOf(missingExperimentsList.size())
            }));
            void1.setSummary("Check logcat for full details");
            getPreferenceScreen().addPreference(void1);
            void1 = new DialogPreference(getActivity(), null) {

                final MissingOrUnusedExperimentsTask this$1;

                protected View onCreateDialogView()
                {
                    ListView listview = new ListView(getActivity());
                    listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, unusedExperimentsList));
                    return listview;
                }

                protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
                {
                    builder.setPositiveButton("", null);
                    builder.setNegativeButton("Close", new CloseDialogClickListener());
                    super.onPrepareDialogBuilder(builder);
                }

            
            {
                this$1 = MissingOrUnusedExperimentsTask.this;
                super(context, attributeset);
            }
            };
            void1.setTitle(String.format(Locale.US, "%d experiments in status call not used", new Object[] {
                Integer.valueOf(unusedExperimentsList.size())
            }));
            void1.setSummary("Check logcat for full details");
            getPreferenceScreen().addPreference(void1);
        }



        private MissingOrUnusedExperimentsTask()
        {
            this$0 = SecretAbTestFragment.this;
            super();
        }

    }

    private class PreconfiguredAbTestPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final SecretAbTestFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            startActivityForResult(((IntentFactory)intentFactory.get()).newPreconfigedABTestsIntent(), 10148);
            return true;
        }

        private PreconfiguredAbTestPreferenceClickListener()
        {
            this$0 = SecretAbTestFragment.this;
            super();
        }

    }

    private class SelectedVariantsTask extends GrouponSafeAsyncTask
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
            Object obj = ((AbTestService)abTestService.get()).listExperiments();
            selectedVariantsList = new ArrayList();
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                String s1 = ((AbTestService)abTestService.get()).getVariantWithoutLogging(s);
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

                final SelectedVariantsTask this$1;

                protected View onCreateDialogView()
                {
                    ListView listview = new ListView(getActivity());
                    listview.setAdapter(new ArrayAdapter(getActivity(), 0x7f030200, 0x7f100524, selectedVariantsList));
                    return listview;
                }

                protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder)
                {
                    builder.setPositiveButton("", null);
                    builder.setNegativeButton("Close", new CloseDialogClickListener());
                    super.onPrepareDialogBuilder(builder);
                }

            
            {
                this$1 = SelectedVariantsTask.this;
                super(context, attributeset);
            }
            };
            void1.setTitle("Click to see the selected variants");
            getPreferenceScreen().addPreference(void1);
        }


        private SelectedVariantsTask()
        {
            this$0 = SecretAbTestFragment.this;
            super();
        }

    }


    public static final String TAG = com/groupon/fragment/SecretAbTestFragment.getName();
    private Lazy abTestService;
    private Lazy intentFactory;
    private Lazy statusService;

    public SecretAbTestFragment()
    {
    }

    private void refreshAbTestAndRecreate()
    {
        ((AbTestService)abTestService.get()).refresh(((StatusService)statusService.get()).getStatus().experiments);
        getActivity().recreate();
    }

    public void init()
    {
        abTestService = new Lazy(getActivity()) {

            final SecretAbTestFragment this$0;

            
            {
                this$0 = SecretAbTestFragment.this;
                super(context);
            }
        };
        intentFactory = new Lazy(getActivity()) {

            final SecretAbTestFragment this$0;

            
            {
                this$0 = SecretAbTestFragment.this;
                super(context);
            }
        };
        statusService = new Lazy(getActivity()) {

            final SecretAbTestFragment this$0;

            
            {
                this$0 = SecretAbTestFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ArrayList arraylist = new ArrayList(((AbTestService)abTestService.get()).listExperimentsOverrides());
        int i = 0;
        do
        {
            EditTextPreference edittextpreference = new EditTextPreference(getActivity());
            Object obj;
            String s;
            if (i < arraylist.size())
            {
                bundle = (String)arraylist.get(i);
            } else
            {
                bundle = null;
            }
            if (Strings.notEmpty(bundle))
            {
                obj = bundle;
            } else
            {
                obj = "Add Override";
            }
            edittextpreference.setTitle(((CharSequence) (obj)));
            s = ((AbTestService)abTestService.get()).getOverride(bundle);
            if (Strings.notEmpty(bundle))
            {
                obj = String.format("%s=%s", new Object[] {
                    bundle, s
                });
            } else
            {
                obj = "experiment_id=variant";
            }
            edittextpreference.setText(((String) (obj)));
            if (Strings.notEmpty(bundle))
            {
                bundle = String.format("%s=%s", new Object[] {
                    bundle, s
                });
            } else
            {
                bundle = "Click to add an experiment_id=variant pair";
            }
            edittextpreference.setSummary(bundle);
            edittextpreference.setOnPreferenceChangeListener(new CustomAbTestPreferenceChangeListener(edittextpreference));
            getPreferenceScreen().addPreference(edittextpreference);
            if (i >= arraylist.size())
            {
                bundle = new Preference(getActivity());
                bundle.setKey("addPreconfiguredVariant");
                bundle.setTitle("Click to add a preconfigured variant");
                bundle.setOnPreferenceClickListener(new PreconfiguredAbTestPreferenceClickListener());
                getPreferenceScreen().addPreference(bundle);
                (new SelectedVariantsTask()).execute();
                (new MissingOrUnusedExperimentsTask()).execute();
                return;
            }
            i++;
        } while (true);
    }




}
