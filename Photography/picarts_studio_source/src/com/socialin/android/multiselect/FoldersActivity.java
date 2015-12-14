// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.multiselect:
//            a, b, ItemsActivity

public class FoldersActivity extends BaseActivity
{

    private ListView a;
    private com.socialin.android.multiselect.b b;
    private int c;
    private Map d;
    private List e;
    private HorizontalScrollView f;
    private LinearLayout g;
    private int h;
    private e i;
    private j j;
    private Comparator k;

    public FoldersActivity()
    {
        a = null;
        b = null;
        c = 20;
        d = new HashMap();
        e = new ArrayList();
        f = null;
        g = null;
        h = 0;
        k = new Comparator() {

            public final int compare(Object obj, Object obj1)
            {
                obj = (a)obj;
                obj1 = (a)obj1;
                return ((a) (obj)).c.compareTo(((a) (obj1)).c);
            }

        };
    }

    static CursorLoader a(FoldersActivity foldersactivity, int i1)
    {
        if (i1 == 0)
        {
            return new CursorLoader(foldersactivity.getApplicationContext(), android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
                "_data", "_id", "_data", "orientation"
            }, null, null, "date_modified");
        } else
        {
            return null;
        }
    }

    static com.socialin.android.multiselect.b a(FoldersActivity foldersactivity)
    {
        return foldersactivity.b;
    }

    private void a(int i1, String as[])
    {
        Intent intent = new Intent();
        int ai[] = new int[i1];
        int j1 = 0;
        while (j1 < i1) 
        {
            if (d.containsKey(as[j1]))
            {
                ai[j1] = ((Integer)d.get(as[j1])).intValue();
            } else
            {
                ai[j1] = m.d(as[j1]);
            }
            j1++;
        }
        intent.putExtra("selectedItems", as);
        intent.putExtra("itemsCount", i1);
        intent.putExtra("selectedItemsDegrees", ai);
        setResult(-1, intent);
        finish();
    }

    private void a(Intent intent)
    {
        e.clear();
        g.removeAllViews();
        String as[] = intent.getStringArrayExtra("selectedItems");
        h = intent.getIntExtra("itemsCount", 0);
        if (h > 0)
        {
            findViewById(0x7f100722).setVisibility(0);
            findViewById(0x7f100731).setEnabled(true);
        } else
        {
            findViewById(0x7f100722).setVisibility(8);
            findViewById(0x7f100731).setEnabled(false);
        }
        if (as != null && h != 0)
        {
            for (int i1 = 0; i1 < h; i1++)
            {
                intent = as[i1];
                View view = getLayoutInflater().inflate(0x7f03016f, null);
                ImageView imageview = (ImageView)view.findViewById(0x7f10072b);
                j.a((new StringBuilder("file://")).append(intent).toString()).a(imageview);
                view.setOnClickListener(new android.view.View.OnClickListener(intent) {

                    private String a;
                    private FoldersActivity b;

                    public final void onClick(View view1)
                    {
                        FoldersActivity.g(b).removeView(view1);
                        com.socialin.android.multiselect.FoldersActivity.b(b).remove(a);
                        if (com.socialin.android.multiselect.FoldersActivity.b(b).isEmpty())
                        {
                            b.findViewById(0x7f100722).setVisibility(8);
                        }
                        ((TextView)b.findViewById(0x7f10072e)).setText((new StringBuilder()).append(com.socialin.android.multiselect.FoldersActivity.b(b).size()).toString());
                    }

            
            {
                b = FoldersActivity.this;
                a = s;
                super();
            }
                });
                g.addView(view);
                e.add(intent);
                ((TextView)findViewById(0x7f10072e)).setText((new StringBuilder()).append(e.size()).toString());
            }

        }
        (new Handler()).postDelayed(new Runnable() {

            private FoldersActivity a;

            public final void run()
            {
                FoldersActivity.f(a).fullScroll(66);
                FoldersActivity.f(a).invalidate();
            }

            
            {
                a = FoldersActivity.this;
                super();
            }
        }, 100L);
    }

    static void a(FoldersActivity foldersactivity, int i1, String as[])
    {
        foldersactivity.a(i1, as);
    }

    static void a(FoldersActivity foldersactivity, Cursor cursor)
    {
        if (cursor != null)
        {
            int j1 = cursor.getCount();
            HashMap hashmap = new HashMap();
            int i1 = 0;
            while (i1 < j1) 
            {
                cursor.moveToPosition(i1);
                String s2 = cursor.getString(cursor.getColumnIndex("_data"));
                if (s2 != null && s2.contains("/"))
                {
                    String s = s2.substring(0, s2.lastIndexOf("/"));
                    File file = new File(s);
                    int k1 = cursor.getColumnIndex("orientation");
                    foldersactivity.d.put(s2, Integer.valueOf(cursor.getInt(k1)));
                    if (!hashmap.containsKey(s))
                    {
                        a a2 = new a(foldersactivity);
                        a2.d = s;
                        a2.c = a2.d.substring(a2.d.lastIndexOf("/") + 1);
                        a2.b = file.lastModified();
                        a2.e = cursor.getString(cursor.getColumnIndex("_data"));
                        hashmap.put(s, a2);
                    } else
                    {
                        a a1 = (a)hashmap.get(s);
                        a1.a = a1.a + 1;
                        a1.e = cursor.getString(cursor.getColumnIndex("_data"));
                        hashmap.put(s, a1);
                    }
                }
                i1++;
            }
            cursor = hashmap.keySet();
            foldersactivity.b.clear();
            String s1;
            for (cursor = cursor.iterator(); cursor.hasNext(); foldersactivity.b.add(hashmap.get(s1)))
            {
                s1 = (String)cursor.next();
            }

            foldersactivity.b.sort(foldersactivity.k);
            foldersactivity.a.setAdapter(foldersactivity.b);
        }
    }

    static List b(FoldersActivity foldersactivity)
    {
        return foldersactivity.e;
    }

    static int c(FoldersActivity foldersactivity)
    {
        return foldersactivity.h;
    }

    static int d(FoldersActivity foldersactivity)
    {
        return foldersactivity.c;
    }

    static int e(FoldersActivity foldersactivity)
    {
        foldersactivity.h = 0;
        return 0;
    }

    static HorizontalScrollView f(FoldersActivity foldersactivity)
    {
        return foldersactivity.f;
    }

    static LinearLayout g(FoldersActivity foldersactivity)
    {
        return foldersactivity.g;
    }

    static j h(FoldersActivity foldersactivity)
    {
        return foldersactivity.j;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == -1 && i1 == 1000)
        {
            if (intent.getBooleanExtra("done", false))
            {
                j1 = intent.getIntExtra("itemsCount", 0);
                String as[] = intent.getStringArrayExtra("selectedItems");
                ArrayList arraylist = new ArrayList();
                int k1 = as.length;
                for (i1 = 0; i1 < k1; i1++)
                {
                    String s = as[i1];
                    if (s != null)
                    {
                        arraylist.add(s);
                    }
                }

                as = new String[arraylist.size()];
                arraylist.toArray(as);
                a(j1, as);
            }
            if (intent.getBooleanExtra("close", false))
            {
                setResult(0);
                finish();
            }
            a(intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        supportRequestWindowFeature(5);
        setContentView(0x7f03016b);
        f = (HorizontalScrollView)findViewById(0x7f100732);
        g = (LinearLayout)findViewById(0x7f100733);
        a = (ListView)findViewById(0x7f100721);
        Utils.a(50F, this);
        i = (e)com.bumptech.glide.request.e.b(l.a).b(getApplicationContext());
        j = com.bumptech.glide.b.b(getApplicationContext()).i().a(0.6F).a(i);
        b = new com.socialin.android.multiselect.b(this, getApplicationContext());
        bundle = getSupportActionBar();
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f08048f);
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle = getIntent();
        if (bundle.hasExtra("itemsCount"))
        {
            c = bundle.getIntExtra("itemsCount", -1);
            if (c != -1)
            {
                ((TextView)findViewById(0x7f10072f)).setText((new StringBuilder("/ ")).append(c).toString());
            }
        }
        getLoaderManager().initLoader(0, null, new android.app.LoaderManager.LoaderCallbacks() {

            private FoldersActivity a;

            public final Loader onCreateLoader(int i1, Bundle bundle1)
            {
                return FoldersActivity.a(a, i1);
            }

            public final void onLoadFinished(Loader loader, Object obj)
            {
                loader = (Cursor)obj;
                FoldersActivity.a(a, loader);
            }

            public final void onLoaderReset(Loader loader)
            {
            }

            
            {
                a = FoldersActivity.this;
                super();
            }
        });
        a.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private FoldersActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = new Intent(a.getApplicationContext(), com/socialin/android/multiselect/ItemsActivity);
                adapterview.putExtra("folder", ((a)FoldersActivity.a(a).getItem(i1)).d);
                int j1 = com.socialin.android.multiselect.FoldersActivity.b(a).size();
                view = new String[FoldersActivity.c(a)];
                for (i1 = 0; i1 < j1; i1++)
                {
                    view[i1] = (String)com.socialin.android.multiselect.FoldersActivity.b(a).get(i1);
                }

                adapterview.putExtra("selectedItemsArray", view);
                adapterview.putExtra("selectedItemsCount", j1);
                adapterview.putExtra("itemsCount", FoldersActivity.d(a));
                a.startActivityForResult(adapterview, 1000);
            }

            
            {
                a = FoldersActivity.this;
                super();
            }
        });
        findViewById(0x7f100731).setOnClickListener(new android.view.View.OnClickListener() {

            private FoldersActivity a;

            public final void onClick(View view)
            {
                int j1 = com.socialin.android.multiselect.FoldersActivity.b(a).size();
                view = new ArrayList();
                for (int i1 = 0; i1 < j1; i1++)
                {
                    if (com.socialin.android.multiselect.FoldersActivity.b(a).get(i1) != null)
                    {
                        view.add(com.socialin.android.multiselect.FoldersActivity.b(a).get(i1));
                    }
                }

                String as[] = new String[view.size()];
                view.toArray(as);
                FoldersActivity.a(a, j1, as);
            }

            
            {
                a = FoldersActivity.this;
                super();
            }
        });
        findViewById(0x7f100730).setOnClickListener(new android.view.View.OnClickListener() {

            private FoldersActivity a;

            public final void onClick(View view)
            {
                com.socialin.android.multiselect.FoldersActivity.b(a).clear();
                com.socialin.android.multiselect.FoldersActivity.e(a);
                ((LinearLayout)a.findViewById(0x7f100733)).removeAllViews();
                a.findViewById(0x7f100722).setVisibility(8);
            }

            
            {
                a = FoldersActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110010, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            setResult(0);
            finish();
        }
        if (menuitem.getItemId() == 0x7f100af2)
        {
            b.sort(k);
            menuitem.setChecked(true);
        }
        if (menuitem.getItemId() == 0x7f100af3)
        {
            b.sort(new Comparator() {

                public final int compare(Object obj, Object obj1)
                {
                    obj = (a)obj;
                    obj1 = (a)obj1;
                    return Integer.valueOf(((a) (obj)).a).compareTo(Integer.valueOf(((a) (obj1)).a));
                }

            });
            menuitem.setChecked(true);
        }
        if (menuitem.getItemId() == 0x7f100af4)
        {
            b.sort(new Comparator() {

                public final int compare(Object obj, Object obj1)
                {
                    obj = (a)obj;
                    return Long.valueOf(((a)obj1).b).compareTo(Long.valueOf(((a) (obj)).b));
                }

            });
            menuitem.setChecked(true);
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
