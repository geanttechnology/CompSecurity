// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.d;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.g;
import com.socialin.android.dialog.h;
import com.socialin.android.dialog.i;
import com.socialin.android.photo.exception.InvalidIndexFileException;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio:
//            c, EditingData

public class DrawingGalleryActivity extends BaseActivity
{

    private static final String a = com/picsart/studio/DrawingGalleryActivity.getSimpleName();
    private final com.picsart.studio.c b = new com.picsart.studio.c(this, (byte)0);
    private List c;
    private int d;
    private String e;
    private String f;
    private long g;
    private String h;
    private JSONObject i;
    private JSONObject j;
    private g k;
    private final ModernAsyncTask l = new ModernAsyncTask() {

        private DrawingGalleryActivity a;

        private transient List a()
        {
            List list;
label0:
            {
                publishProgress(new String[] {
                    a.getString(0x7f0803dd)
                });
                if (isCancelled())
                {
                    return null;
                }
                list = com.socialin.android.brushlib.project.a.a();
                Object obj = new HashSet();
                if (isCancelled())
                {
                    return null;
                }
                publishProgress(new String[] {
                    a.getString(0x7f080376)
                });
                Iterator iterator = list.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Project project = (Project)iterator.next();
                    if (isCancelled())
                    {
                        return null;
                    }
                    try
                    {
                        if (!com.socialin.android.brushlib.project.a.d(project.getRootFolder()))
                        {
                            com.socialin.android.brushlib.project.a.a(project.getRootFolder(), com.picsart.studio.DrawingGalleryActivity.a(a));
                        }
                    }
                    catch (InvalidIndexFileException invalidindexfileexception)
                    {
                        com.socialin.android.d.b(com.picsart.studio.DrawingGalleryActivity.a(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(invalidindexfileexception.getMessage()).toString()
                        });
                        ((Set) (obj)).add(project);
                    }
                } while (true);
                if (isCancelled())
                {
                    return null;
                }
                for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); list.remove((Project)((Iterator) (obj)).next())) { }
                if (com.picsart.studio.DrawingGalleryActivity.b(a) == null)
                {
                    break label0;
                }
                obj = list.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                } while (!((Project)((Iterator) (obj)).next()).getRootFolder().getAbsolutePath().equals(com.picsart.studio.DrawingGalleryActivity.b(a)));
                ((Iterator) (obj)).remove();
            }
            return list;
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (List)obj;
            com.picsart.studio.DrawingGalleryActivity.a(a, ((List) (obj)));
            com.picsart.studio.DrawingGalleryActivity.d(a).notifyDataSetChanged();
            DialogUtils.dismissDialog(a, com.picsart.studio.DrawingGalleryActivity.c(a), true);
        }

        protected final void onProgressUpdate(Object aobj[])
        {
            aobj = (String[])aobj;
            com.picsart.studio.DrawingGalleryActivity.c(a).setMessage(((CharSequence) (aobj[0])));
        }

            
            {
                a = DrawingGalleryActivity.this;
                super();
            }
    };
    private GridView m;
    private boolean n;
    private ActionMode o;

    public DrawingGalleryActivity()
    {
    }

    static int a(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.d;
    }

    static Bitmap a(DrawingGalleryActivity drawinggalleryactivity, String s)
    {
        return drawinggalleryactivity.b(s);
    }

    private static Bitmap a(String s)
    {
        s = new File(s);
        try
        {
            s = com.socialin.android.brushlib.project.a.c(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        com.socialin.android.util.c.a(s, a, true);
        return s;
        return null;
    }

    static ActionMode a(DrawingGalleryActivity drawinggalleryactivity, ActionMode actionmode)
    {
        drawinggalleryactivity.o = actionmode;
        return actionmode;
    }

    static String a()
    {
        return a;
    }

    static List a(DrawingGalleryActivity drawinggalleryactivity, List list)
    {
        drawinggalleryactivity.c = list;
        return list;
    }

    static void a(DrawingGalleryActivity drawinggalleryactivity, Project project)
    {
        (new ModernAsyncTask(project) {

            private Project a;

            protected final Object doInBackground(Object aobj[])
            {
                FileUtils.b(a.getRootFolder().getAbsolutePath());
                return null;
            }

            
            {
                a = project;
                super();
            }
        }).execute(new Void[0]);
        drawinggalleryactivity.c.remove(project);
        drawinggalleryactivity.b.notifyDataSetChanged();
    }

    private Bitmap b(String s)
    {
        Bitmap bitmap = a(s);
        if (bitmap != null && bitmap.getWidth() == d && bitmap.getHeight() == d)
        {
            return bitmap;
        }
        if (bitmap != null)
        {
            bitmap.recycle();
        }
        try
        {
            com.socialin.android.brushlib.project.a.a(new File(s), d);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
            });
            return null;
        }
        return a(s);
    }

    static String b(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.e;
    }

    private void b()
    {
        setContentView(0x7f03001e);
        m = (GridView)findViewById(0x7f10013b);
        m.setAdapter(b);
        m.setChoiceMode(3);
        m.setMultiChoiceModeListener(new android.widget.AbsListView.MultiChoiceModeListener() {

            private DrawingGalleryActivity a;

            public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
            {
                switch (menuitem.getItemId())
                {
                default:
                    return false;

                case 2131755681: 
                    DrawingGalleryActivity.f(a);
                    break;
                }
                return true;
            }

            public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
            {
                actionmode.getMenuInflater().inflate(0x7f110001, menu);
                com.picsart.studio.DrawingGalleryActivity.a(a, actionmode);
                return true;
            }

            public final void onDestroyActionMode(ActionMode actionmode)
            {
                com.picsart.studio.DrawingGalleryActivity.a(a, null);
            }

            public final void onItemCheckedStateChanged(ActionMode actionmode, int i1, long l1, boolean flag)
            {
                i1 = com.picsart.studio.DrawingGalleryActivity.g(a).getCheckedItemCount();
                actionmode.setTitle(a.getResources().getQuantityString(0x7f0a0001, i1, new Object[] {
                    Integer.valueOf(i1)
                }));
                com.picsart.studio.DrawingGalleryActivity.g(a).smoothScrollBy(0, 10);
            }

            public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
            {
                return false;
            }

            
            {
                a = DrawingGalleryActivity.this;
                super();
            }
        });
    }

    static void b(DrawingGalleryActivity drawinggalleryactivity, Project project)
    {
        Object obj = drawinggalleryactivity.getFragmentManager();
        android.app.Fragment fragment = ((FragmentManager) (obj)).findFragmentByTag("textPromptDialog");
        if (fragment != null)
        {
            ((FragmentManager) (obj)).beginTransaction().remove(fragment).commit();
        }
        obj = new h();
        obj.b = drawinggalleryactivity.getString(0x7f080100);
        obj.a = drawinggalleryactivity. new i(drawinggalleryactivity, project) {

            final Project a;
            final DrawingGalleryActivity b;

            public final String a()
            {
                if (a.isDraft())
                {
                    return "";
                } else
                {
                    return a.getDisplayName();
                }
            }

            public final void a(String s)
            {
                (new AsyncTask(this, s) {

                    private String a;
                    private _cls5 b;

                    private transient Void a()
                    {
                        try
                        {
                            Project project = com.socialin.android.brushlib.project.a.a(b.a, a);
                            com.picsart.studio.DrawingGalleryActivity.h(b.b).add(com.picsart.studio.DrawingGalleryActivity.h(b.b).indexOf(b.a), project);
                        }
                        catch (Exception exception)
                        {
                            com.socialin.android.d.b(com.picsart.studio.DrawingGalleryActivity.a(), new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                            });
                            cancel(false);
                        }
                        return null;
                    }

                    protected final Object doInBackground(Object aobj[])
                    {
                        return a();
                    }

                    protected final void onCancelled(Object obj)
                    {
                        Toast.makeText(b.b, 0x7f08009a, 0).show();
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        Toast.makeText(b.b, 0x7f080127, 0).show();
                        com.picsart.studio.DrawingGalleryActivity.d(b.b).notifyDataSetChanged();
                    }

            
            {
                b = _pcls5;
                a = s;
                super();
            }
                }).execute(new Void[0]);
            }

            
            {
                b = DrawingGalleryActivity.this;
                a = project;
                super(context);
            }
        };
        ((h) (obj)).show(drawinggalleryactivity.getFragmentManager(), "textPromptDialog");
    }

    static g c(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.k;
    }

    static void c(DrawingGalleryActivity drawinggalleryactivity, Project project)
    {
        Object obj = drawinggalleryactivity.getFragmentManager();
        android.app.Fragment fragment = ((FragmentManager) (obj)).findFragmentByTag("textPromptDialog");
        if (fragment != null)
        {
            ((FragmentManager) (obj)).beginTransaction().remove(fragment).commit();
        }
        obj = new h();
        obj.b = drawinggalleryactivity.getString(0x7f080562);
        obj.a = drawinggalleryactivity. new i(drawinggalleryactivity, project) {

            private Project a;
            private DrawingGalleryActivity b;

            public final String a()
            {
                if (a.isDraft())
                {
                    return "";
                } else
                {
                    return a.getDisplayName();
                }
            }

            public final void a(String s)
            {
                if (a.rename(s))
                {
                    Toast.makeText(b, 0x7f08054b, 0).show();
                    com.picsart.studio.DrawingGalleryActivity.d(b).notifyDataSetChanged();
                    return;
                } else
                {
                    Toast.makeText(b, 0x7f08009d, 0).show();
                    return;
                }
            }

            
            {
                b = DrawingGalleryActivity.this;
                a = project;
                super(context);
            }
        };
        ((h) (obj)).show(drawinggalleryactivity.getFragmentManager(), "textPromptDialog");
    }

    static com.picsart.studio.c d(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.b;
    }

    static void d(DrawingGalleryActivity drawinggalleryactivity, Project project)
    {
        b b1 = new b();
        b1.b = drawinggalleryactivity.getString(0x7f08010c, new Object[] {
            project.getName()
        });
        b1.a(drawinggalleryactivity. new android.view.View.OnClickListener(project) {

            private Project a;
            private DrawingGalleryActivity b;

            public final void onClick(View view)
            {
                com.picsart.studio.DrawingGalleryActivity.a(b, a);
            }

            
            {
                b = DrawingGalleryActivity.this;
                a = project;
                super();
            }
        }).a().show(drawinggalleryactivity.getFragmentManager(), null);
    }

    static ModernAsyncTask e(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.l;
    }

    static void e(DrawingGalleryActivity drawinggalleryactivity, Project project)
    {
        if (drawinggalleryactivity.n || !project.isValid())
        {
            Toast.makeText(drawinggalleryactivity, drawinggalleryactivity.getString(0x7f080145), 0).show();
            return;
        } else
        {
            drawinggalleryactivity.n = true;
            Intent intent = new Intent();
            intent.setAction("finish.old.drawing");
            drawinggalleryactivity.sendBroadcast(intent);
            intent = new Intent(drawinggalleryactivity, myobfuscated.f.m.g());
            intent.putExtra("from", "draft");
            intent.putExtra("start_draw_session", true);
            intent.putExtra("editing_data", com.picsart.studio.EditingData.a(com.picsart.studio.utils.c.a(drawinggalleryactivity, null), "unknown"));
            intent.putExtra("extra.project", project);
            drawinggalleryactivity.startActivity(intent);
            AnalyticUtils.getInstance(drawinggalleryactivity).track(new com.socialin.android.apiv3.events.EventsFactory.DrawDoneEvent(drawinggalleryactivity.h, drawinggalleryactivity.f, drawinggalleryactivity.i, drawinggalleryactivity.j, "open_draft", (System.nanoTime() - drawinggalleryactivity.g) / 0x3b9aca00L));
            drawinggalleryactivity.finish();
            return;
        }
    }

    static void f(DrawingGalleryActivity drawinggalleryactivity)
    {
        Object obj = new b();
        obj.b = drawinggalleryactivity.getResources().getString(0x7f080128);
        obj = ((b) (obj)).a(drawinggalleryactivity. new android.view.View.OnClickListener() {

            private DrawingGalleryActivity a;

            public final void onClick(View view)
            {
                view = com.picsart.studio.DrawingGalleryActivity.g(a).getCheckedItemPositions();
                Object obj1 = new ArrayList();
                int i1 = 0;
                for (int j1 = com.picsart.studio.DrawingGalleryActivity.g(a).getCount(); i1 < j1; i1++)
                {
                    if (view.get(i1))
                    {
                        ((List) (obj1)).add(com.picsart.studio.DrawingGalleryActivity.h(a).get(i1));
                    }
                }

                for (view = ((List) (obj1)).iterator(); view.hasNext(); com.picsart.studio.DrawingGalleryActivity.a(a, ((Project) (obj1))))
                {
                    obj1 = (Project)view.next();
                }

                if (com.picsart.studio.DrawingGalleryActivity.i(a) != null)
                {
                    com.picsart.studio.DrawingGalleryActivity.i(a).finish();
                }
                com.picsart.studio.DrawingGalleryActivity.d(a).notifyDataSetChanged();
            }

            
            {
                a = DrawingGalleryActivity.this;
                super();
            }
        }).a();
        drawinggalleryactivity.getFragmentManager().beginTransaction().add(((android.app.Fragment) (obj)), null).commitAllowingStateLoss();
    }

    static GridView g(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.m;
    }

    static List h(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.c;
    }

    static ActionMode i(DrawingGalleryActivity drawinggalleryactivity)
    {
        return drawinggalleryactivity.o;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        boolean flag = false;
        super.onConfigurationChanged(configuration);
        configuration = m.getCheckedItemPositions();
        SparseBooleanArray sparsebooleanarray = new SparseBooleanArray();
        int k1 = m.getCount();
        for (int i1 = 0; i1 < k1; i1++)
        {
            sparsebooleanarray.put(i1, configuration.get(i1));
        }

        b();
        k1 = m.getCount();
        for (int j1 = ((flag) ? 1 : 0); j1 < k1; j1++)
        {
            m.setItemChecked(j1, sparsebooleanarray.get(j1));
        }

    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d = (int)getResources().getDimension(0x7f0b00d8);
        c = new CopyOnWriteArrayList();
        n = false;
        k = new g(this);
        k.setCancelable(true);
        k.setCanceledOnTouchOutside(false);
        k.setMessage(getString(0x7f0803dd));
        k.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private DrawingGalleryActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                DrawingGalleryActivity.e(a).cancel(true);
                a.finish();
            }

            
            {
                a = DrawingGalleryActivity.this;
                super();
            }
        });
        if (getIntent() != null && getIntent().getExtras() != null)
        {
            e = getIntent().getExtras().getString("currentProjectRoot");
            f = getIntent().getExtras().getString("drawingSessionId");
            g = getIntent().getExtras().getLong("drawingSessionStart");
            h = getIntent().getExtras().getString("uid");
            try
            {
                i = new JSONObject(getIntent().getExtras().getString("brushTime"));
                j = new JSONObject(getIntent().getExtras().getString("eraserTime"));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        b();
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
            bundle.setTitle(0x7f0804c2);
        }
        DialogUtils.showDialog(this, k, false);
        l.execute(new Void[0]);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.socialin.android.util.c.b(a);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        if (true) goto _L1; else goto _L3
_L3:
    }

}
