// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.Toast;
import com.groupon.adapter.ABTestListAdapter;
import com.groupon.models.status.Experiment;
import com.groupon.models.status.Status;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.StatusService;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.type.TypeReference;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class PreconfiguredAbTests extends GrouponActivity
{

    public static final String DISABLE = "Disable";
    public static final String NO_OVERRIDE = "No Override";
    public static final int REQUEST_CODE = 10148;
    public static final String SET_VALUE = "Set Value";
    public static final String UNSAVED_CHANGES = "unsaved_changes";
    ListView aBTestList;
    private Map abTestMap;
    private AbTestService abTestService;
    private ABTestListAdapter adapter;
    private AlertDialog alertDialog;
    private List experiments;
    private ObjectMapperWrapper om;
    private android.widget.AdapterView.OnItemClickListener onItemClickListener;
    EditText search;
    private StatusService statusService;
    private TextWatcher textWatcher;

    public PreconfiguredAbTests()
    {
        abTestMap = new HashMap();
        experiments = new ArrayList();
    }

    private void showCancelDialog()
    {
        int i = adapter.getNumberOfUnsavedChanges();
        if (i == 0)
        {
            finish();
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Are you sure?");
            builder.setMessage(String.format("You have %d unsaved change(s). To save changes, press \"stay here\" and then tap \"save\" in the top right corner. Otherwise, press \"I'm sure\" to discard changes.", new Object[] {
                Integer.valueOf(i)
            }));
            builder.setPositiveButton("I'm sure", new android.content.DialogInterface.OnClickListener() {

                final PreconfiguredAbTests this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    finish();
                }

            
            {
                this$0 = PreconfiguredAbTests.this;
                super();
            }
            });
            builder.setNegativeButton("Stay here", null);
            builder.show();
            return;
        }
    }

    private void showSelectDialog(final String key)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Set Value");
        if (!abTestMap.containsKey(key))
        {
            abTestService.clearAllOverrides();
            abTestService.refresh(experiments);
            setResult(-1);
            finish();
            Toast.makeText(this, "Overrides cleared", 1).show();
            return;
        }
        final ArrayList values = new ArrayList();
        values.addAll((Collection)abTestMap.get(key));
        values.add(0, "No Override");
        int i = values.indexOf(adapter.getOverrideValue(key));
        CharSequence acharsequence[] = (CharSequence[])values.toArray(new String[values.size()]);
        if (i < 0)
        {
            i = 0;
        }
        builder.setSingleChoiceItems(acharsequence, i, new android.content.DialogInterface.OnClickListener() {

            final PreconfiguredAbTests this$0;
            final String val$key;
            final List val$values;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                if (j != 0)
                {
                    adapter.addOverride(key, (String)values.get(j));
                } else
                {
                    adapter.addOverride(key, null);
                }
                if (alertDialog != null)
                {
                    alertDialog.dismiss();
                }
            }

            
            {
                this$0 = PreconfiguredAbTests.this;
                key = s;
                values = list;
                super();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void onBackPressed()
    {
        showCancelDialog();
    }

    public void onCreate(Bundle bundle)
    {
        ArrayList arraylist1;
        super.onCreate(bundle);
        setContentView(0x7f030194);
        arraylist1 = new ArrayList();
        Iterator iterator1 = ((Map)om.readValue(getAssets().open("experiments.json"), new TypeReference() {

            final PreconfiguredAbTests this$0;

            
            {
                this$0 = PreconfiguredAbTests.this;
                super();
            }
        })).entrySet().iterator();
_L1:
        List list;
        String as[];
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_212;
            }
            as = ((String)((java.util.Map.Entry)iterator1.next()).getValue()).split("=");
        } while (as.length != 2);
        list = (List)abTestMap.get(as[0]);
        Object obj;
        obj = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        obj = new ArrayList();
        abTestMap.put(as[0], obj);
        arraylist1.add(as[0]);
        ((List) (obj)).add(as[1]);
          goto _L1
        bundle;
        Toast.makeText(getApplicationContext(), "Uh oh! Could not load the experiments.", 0).show();
        Ln.e("AB Test Loading Failure", new Object[] {
            bundle
        });
        setResult(0);
        finish();
        return;
        experiments = statusService.getStatus().experiments;
        HashMap hashmap = new HashMap();
        Experiment experiment;
        for (Iterator iterator = experiments.iterator(); iterator.hasNext(); hashmap.put(experiment.id, experiment.variant))
        {
            experiment = (Experiment)iterator.next();
        }

        Collections.sort(arraylist1, String.CASE_INSENSITIVE_ORDER);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        Map map = abTestService.mapExperimentsOverrides();
        for (Iterator iterator2 = arraylist1.iterator(); iterator2.hasNext();)
        {
            String s = (String)iterator2.next();
            if (map.containsKey(s))
            {
                arraylist.add(s);
            } else
            {
                arraylist2.add(s);
            }
        }

        arraylist1.clear();
        arraylist1.add(0, "Disable");
        arraylist1.addAll(arraylist);
        arraylist1.addAll(arraylist2);
        adapter = new ABTestListAdapter(this, 0x7f030018, arraylist1, map, hashmap);
        if (bundle != null)
        {
            onRestoreInstanceState(bundle);
        }
        aBTestList.setAdapter(adapter);
        textWatcher = new TextWatcher() {

            final PreconfiguredAbTests this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                adapter.getFilter().filter(charsequence);
            }

            
            {
                this$0 = PreconfiguredAbTests.this;
                super();
            }
        };
        search.addTextChangedListener(textWatcher);
        onItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final PreconfiguredAbTests this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (String)adapterview.getItemAtPosition(i);
                showSelectDialog(adapterview);
            }

            
            {
                this$0 = PreconfiguredAbTests.this;
                super();
            }
        };
        aBTestList.setOnItemClickListener(onItemClickListener);
        return;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10000b, 0, 0x7f08033e).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        search.removeTextChangedListener(textWatcher);
        aBTestList.setOnItemClickListener(null);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755019: 
            abTestService.setOverrideByMap(adapter.getUnsavedOverrides());
            break;
        }
        abTestService.refresh(experiments);
        setResult(-1);
        finish();
        return true;
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        adapter.restoreOverrides((HashMap)bundle.getSerializable("unsaved_changes"));
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("unsaved_changes", (Serializable)adapter.getUnsavedOverrides());
    }



}
