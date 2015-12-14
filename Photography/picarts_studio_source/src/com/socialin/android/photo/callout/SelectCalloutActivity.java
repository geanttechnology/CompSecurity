// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.app.DialogFragment;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.activity.LocationListActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.c;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.database.a;
import com.socialin.android.photo.main.CommonPhraseListActivity;
import com.socialin.android.photo.main.DateAndTimeListActivity;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.callout:
//            CalloutItemView, b, c, d, 
//            Callout, a

public class SelectCalloutActivity extends AdBaseActivity
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static final String a = com/socialin/android/photo/callout/SelectCalloutActivity.getSimpleName();
    private g b;
    private int c;
    private AutoCompleteTextView d;
    private LinearLayout e;
    private HashMap f;
    private String g;
    private String h;
    private String i[];
    private boolean j;
    private int k;

    public SelectCalloutActivity()
    {
        new Handler();
        c = 22;
        d = null;
        e = null;
        f = null;
        g = "";
        i = null;
        j = false;
        k = 0;
    }

    static int a(SelectCalloutActivity selectcalloutactivity, int l)
    {
        selectcalloutactivity.c = l;
        return l;
    }

    static String a()
    {
        return a;
    }

    static String a(SelectCalloutActivity selectcalloutactivity, String s)
    {
        selectcalloutactivity.g = s;
        return s;
    }

    static HashMap a(SelectCalloutActivity selectcalloutactivity)
    {
        return selectcalloutactivity.f;
    }

    static HashMap a(SelectCalloutActivity selectcalloutactivity, HashMap hashmap)
    {
        selectcalloutactivity.f = hashmap;
        return hashmap;
    }

    static void a(SelectCalloutActivity selectcalloutactivity, String s, int l, String as[])
    {
        selectcalloutactivity.a(s, l, as);
    }

    private void a(String s, int l, String as[])
    {
        e.removeAllViews();
        CalloutItemView calloutitemview = new CalloutItemView(this);
        int i1 = (int)TypedValue.applyDimension(1, 200F, getResources().getDisplayMetrics());
        int j1 = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        int k1 = (int)TypedValue.applyDimension(1, 10F, getResources().getDisplayMetrics());
        calloutitemview.a((HashMap)b.E.get(l), as, s, i1, j1, k1, k1, l);
        e.addView(calloutitemview);
    }

    static boolean a(SelectCalloutActivity selectcalloutactivity, boolean flag)
    {
        selectcalloutactivity.j = flag;
        return flag;
    }

    static String[] a(SelectCalloutActivity selectcalloutactivity, String as[])
    {
        selectcalloutactivity.i = as;
        return as;
    }

    static int b(SelectCalloutActivity selectcalloutactivity, int l)
    {
        selectcalloutactivity.k = l;
        return l;
    }

    private void b()
    {
        e = (LinearLayout)findViewById(0x7f1007da);
        d = (AutoCompleteTextView)findViewById(0x7f1007dd);
        if (!g.equals(getString(0x7f080604)))
        {
            d.setText(g);
        }
        getWindow().setSoftInputMode(3);
        d.addTextChangedListener(new TextWatcher() {

            private SelectCalloutActivity a;

            public final void afterTextChanged(Editable editable)
            {
                editable = com.socialin.android.photo.callout.SelectCalloutActivity.d(a).getText().toString();
                com.socialin.android.photo.callout.SelectCalloutActivity.a(a, editable, SelectCalloutActivity.e(a), SelectCalloutActivity.f(a));
                com.socialin.android.photo.callout.SelectCalloutActivity.a(a, editable);
            }

            public final void beforeTextChanged(CharSequence charsequence, int l, int i1, int j1)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int l, int i1, int j1)
            {
            }

            
            {
                a = SelectCalloutActivity.this;
                super();
            }
        });
        d.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            private SelectCalloutActivity a;

            public final boolean onEditorAction(TextView textview, int l, KeyEvent keyevent)
            {
                if (l == 6 || l == 5 || keyevent.getAction() == 0 && keyevent.getKeyCode() == 66)
                {
                    if (a.getCurrentFocus() != null)
                    {
                        ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 2);
                    } else
                    {
                        com.socialin.android.photo.callout.SelectCalloutActivity.g(a);
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = SelectCalloutActivity.this;
                super();
            }
        });
        findViewById(0x7f1007de).setOnClickListener(new android.view.View.OnClickListener() {

            final SelectCalloutActivity a;

            public final void onClick(View view)
            {
                view = (new b()).a(1, 0x7f0c0181);
                view.f = 0x7f0301be;
                view.i = true;
                view.j = true;
                view.p = new c(this) {

                    final _cls6 a;

                    public final void onViewCreated(View view, DialogFragment dialogfragment)
                    {
                        dialogfragment.setStyle(1, 0x7f0c0181);
                        view.findViewById(0x7f100831).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                            private DialogFragment a;
                            private _cls2 b;

                            public final void onClick(View view)
                            {
                                view = new Intent(b.a.a, com/socialin/android/photo/main/CommonPhraseListActivity);
                                b.a.a.startActivityForResult(view, 3);
                                AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_common_phrase");
                                a.dismiss();
                            }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                        });
                        view.findViewById(0x7f100832).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                            private DialogFragment a;
                            private _cls2 b;

                            public final void onClick(View view)
                            {
                                view = new Intent(b.a.a, com/socialin/android/activity/LocationListActivity);
                                b.a.a.startActivityForResult(view, 1);
                                AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_loc_based");
                                a.dismiss();
                            }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                        });
                        view.findViewById(0x7f100833).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                            private DialogFragment a;
                            private _cls2 b;

                            public final void onClick(View view)
                            {
                                view = new Intent(b.a.a, com/socialin/android/photo/main/DateAndTimeListActivity);
                                b.a.a.startActivityForResult(view, 2);
                                AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_date");
                                a.dismiss();
                            }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                        });
                    }

            
            {
                a = _pcls6;
                super();
            }
                };
                view.m = new android.content.DialogInterface.OnCancelListener() {

                    public final void onCancel(DialogInterface dialoginterface)
                    {
                        dialoginterface.dismiss();
                    }

                };
                view.h = false;
                view.g = false;
                view.a().show(a.getFragmentManager(), null);
            }

            
            {
                a = SelectCalloutActivity.this;
                super();
            }
        });
        c();
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(0x7f080607);
        actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        initAd();
    }

    static void b(SelectCalloutActivity selectcalloutactivity)
    {
        if (!selectcalloutactivity.isFinishing())
        {
            m.b(selectcalloutactivity, selectcalloutactivity.b);
            GridView gridview = (GridView)selectcalloutactivity.findViewById(0x7f1007e0);
            gridview.setAdapter(new com.socialin.android.photo.callout.c(selectcalloutactivity));
            gridview.setOnItemClickListener(selectcalloutactivity. new android.widget.AdapterView.OnItemClickListener() {

                private SelectCalloutActivity a;

                public final void onItemClick(AdapterView adapterview, View view, int l, long l1)
                {
                    view = com.socialin.android.photo.callout.SelectCalloutActivity.d(a).getText().toString();
                    adapterview = view;
                    if (view.equals(""))
                    {
                        adapterview = a.getString(0x7f080604);
                    }
                    com.socialin.android.photo.callout.SelectCalloutActivity.a(a, adapterview, l, SelectCalloutActivity.f(a));
                    com.socialin.android.photo.callout.SelectCalloutActivity.a(a, l);
                    com.socialin.android.photo.callout.SelectCalloutActivity.a(a, adapterview);
                    AnalyticUtils.getInstance(a).trackLocalAction("callout:apply");
                }

            
            {
                a = SelectCalloutActivity.this;
                super();
            }
            });
            gridview = (GridView)selectcalloutactivity.findViewById(0x7f1007db);
            gridview.setAdapter(new com.socialin.android.photo.callout.d(selectcalloutactivity));
            gridview.setSelection(selectcalloutactivity.k);
            gridview.setOnItemClickListener(selectcalloutactivity. new android.widget.AdapterView.OnItemClickListener() {

                private SelectCalloutActivity a;

                public final void onItemClick(AdapterView adapterview, View view, int l, long l1)
                {
                    com.socialin.android.photo.callout.SelectCalloutActivity.a(a, com.socialin.android.photo.callout.a.b[l]);
                    com.socialin.android.photo.callout.SelectCalloutActivity.b(a, l);
                    SelectCalloutActivity.h(a);
                    AnalyticUtils.getInstance(a).trackLocalAction("callout:change");
                }

            
            {
                a = SelectCalloutActivity.this;
                super();
            }
            });
        }
    }

    static String c(SelectCalloutActivity selectcalloutactivity)
    {
        return selectcalloutactivity.h;
    }

    private void c()
    {
        a(g, c, i);
        String as[] = i;
        m.a(this, b);
        (new Thread(as, (int)TypedValue.applyDimension(1, 70F, getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(1, 17F, getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(1, 5F, getResources().getDisplayMetrics())) {

            final SelectCalloutActivity a;
            private String b[];
            private int c;
            private int d;
            private int e;

            public final void run()
            {
                com.socialin.android.photo.callout.SelectCalloutActivity.a(a, true);
                com.socialin.android.photo.callout.SelectCalloutActivity.a(a, new HashMap());
                for (int l = 0; l < b.E.size(); l++)
                {
                    Callout callout = new Callout(a, b, (HashMap)b.E.get(l), "ABC", c, d, e, e, false, 1);
                    com.socialin.android.photo.callout.SelectCalloutActivity.a(a).put(Integer.valueOf(l), callout);
                }

                a.runOnUiThread(new Runnable(this) {

                    private _cls2 a;

                    public final void run()
                    {
                        com.socialin.android.photo.callout.SelectCalloutActivity.a(a.a, false);
                        com.socialin.android.photo.callout.SelectCalloutActivity.b(a.a);
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            
            {
                a = SelectCalloutActivity.this;
                b = as;
                c = l;
                d = i1;
                e = j1;
                super();
            }
        }).start();
    }

    static AutoCompleteTextView d(SelectCalloutActivity selectcalloutactivity)
    {
        return selectcalloutactivity.d;
    }

    private void d()
    {
        String s = d.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("text", s);
        intent.putExtra("callout", i);
        intent.putExtra("styleIndex", c);
        setResult(-1, intent);
        (new ModernAsyncTask(s) {

            private String a;
            private SelectCalloutActivity b;

            private transient Void a()
            {
                Object obj;
                if (a.equals(com.socialin.android.photo.callout.SelectCalloutActivity.c(b)))
                {
                    break MISSING_BLOCK_LABEL_252;
                }
                obj = b.getContentResolver();
                android.net.Uri uri = a.a;
                String s1 = a;
                obj = ((ContentResolver) (obj)).query(uri, new String[] {
                    "addtext_usage"
                }, "addtext_addedtext=?", new String[] {
                    s1
                }, null);
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_73;
                }
                if (((Cursor) (obj)).getCount() != 0)
                {
                    break MISSING_BLOCK_LABEL_128;
                }
                obj = new ContentValues(2);
                ((ContentValues) (obj)).put("addtext_addedtext", a);
                ((ContentValues) (obj)).put("addtext_created_at", Long.valueOf((new Date()).getTime()));
                b.getContentResolver().insert(a.a, ((ContentValues) (obj)));
                return null;
                ((Cursor) (obj)).moveToFirst();
                ContentValues contentvalues = new ContentValues(2);
                contentvalues.put("addtext_usage", Integer.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("addtext_usage")) + 1));
                contentvalues.put("addtext_created_at", Long.valueOf((new Date()).getTime()));
                b.getContentResolver().update(a.a, contentvalues, "addtext_addedtext=?", new String[] {
                    a
                });
                return null;
                Exception exception;
                exception;
                com.socialin.android.d.b(com.socialin.android.photo.callout.SelectCalloutActivity.a(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            
            {
                b = SelectCalloutActivity.this;
                a = s;
                super();
            }
        }).execute(new Void[0]);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("callout:done");
    }

    static int e(SelectCalloutActivity selectcalloutactivity)
    {
        return selectcalloutactivity.c;
    }

    static String[] f(SelectCalloutActivity selectcalloutactivity)
    {
        return selectcalloutactivity.i;
    }

    static void g(SelectCalloutActivity selectcalloutactivity)
    {
        selectcalloutactivity.d();
    }

    static void h(SelectCalloutActivity selectcalloutactivity)
    {
        selectcalloutactivity.c();
    }

    static boolean i(SelectCalloutActivity selectcalloutactivity)
    {
        return selectcalloutactivity.j;
    }

    public void finish()
    {
        super.finish();
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onActivityResult(int l, int i1, Intent intent)
    {
        super.onActivityResult(l, i1, intent);
        if (i1 == -1 && (l == 1 || l == 3 || l == 2))
        {
            intent = intent.getExtras().getString("text");
            d.append(intent);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        setContentView(0x7f0301a7);
        b();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0301a7);
        AnalyticUtils.getInstance(this).trackLocalAction("callout:onCreate");
        bundle = getIntent().getExtras();
        i = bundle.getStringArray("callout");
        g = getString(0x7f080604);
        if (bundle.containsKey("currentText"))
        {
            String s = bundle.getString("currentText");
            h = s;
            g = s;
            c = bundle.getInt("currentCalloutStyleIndex");
            ((EditText)findViewById(0x7f1007dd)).setText(g);
        }
        b = new g(this);
        b.setMessage("Working...");
        b.setCancelable(true);
        b.setCanceledOnTouchOutside(false);
        b.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private SelectCalloutActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.finish();
            }

            
            {
                a = SelectCalloutActivity.this;
                super();
            }
        });
        getLoaderManager().initLoader(1, null, this);
        b();
        Utils.b(hashCode());
    }

    public Loader onCreateLoader(int l, Bundle bundle)
    {
        try
        {
            bundle = new CursorLoader(this, a.a, new String[] {
                "addtext_addedtext"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
            });
            return null;
        }
        return bundle;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuItemCompat.setShowAsAction(menu.add(0, 1, 0, "Done").setIcon(0x7f020046), 2);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        System.gc();
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        if (1 != loader.getId() || obj == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        int i1;
        if (((Cursor) (obj)).getCount() <= 0 || !((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        i1 = ((Cursor) (obj)).getCount();
        loader = new String[i1];
        int l = 0;
        do
        {
            if (l >= i1)
            {
                break;
            }
            try
            {
                loader[l] = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("addtext_addedtext"));
                ((Cursor) (obj)).moveToNext();
            }
            // Misplaced declaration of an exception variable
            catch (Loader loader)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(loader.getMessage()).toString()
                });
                return;
            }
            l++;
        } while (true);
        d.setAdapter(new ArrayAdapter(this, 0x7f03024f, loader));
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   1: 56
    //                   16908332: 34;
           goto _L1 _L2 _L3
_L1:
        return true;
_L3:
        setResult(0);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("callout:exit");
        continue; /* Loop/switch isn't completed */
_L2:
        d();
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Utils.b(hashCode());
    }

}
