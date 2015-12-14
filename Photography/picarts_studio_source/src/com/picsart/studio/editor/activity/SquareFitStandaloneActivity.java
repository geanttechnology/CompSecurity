// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.fragment.SquareFitFragment;
import com.picsart.studio.editor.fragment.i;
import com.picsart.studio.editor.history.EditorAction;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.io.File;
import java.util.HashMap;
import myobfuscated.f.m;
import org.json.JSONObject;

public class SquareFitStandaloneActivity extends BaseActivity
{

    private String a;
    private int b;
    private HashMap c;
    private String d;
    private String e;
    private Bitmap f;
    private boolean g;
    private String h;

    public SquareFitStandaloneActivity()
    {
        a = null;
        b = 0;
        c = null;
        d = "";
        e = "";
        g = false;
        h = "blur";
    }

    private Bitmap a(Bundle bundle)
    {
        int i;
        if (bundle.containsKey("bufferData"))
        {
            c = (HashMap)bundle.getSerializable("bufferData");
        }
        a = bundle.getString("imagePath");
        b = bundle.getInt("degree");
        i = bundle.getInt("maxPixel", PicsartContext.a());
        d = getResources().getString(0x7f0808c0);
        e = (new StringBuilder("square_fit_tmp_")).append(String.valueOf(System.currentTimeMillis())).toString();
        if (c != null)
        {
            try
            {
                bundle = w.a(c, i, b);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                setResult(0, (new Intent()).putExtra("memoryError", true));
                finish();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Utils.c(this, getResources().getString(0x7f08024e));
                setResult(111);
                finish();
                return null;
            }
            return bundle;
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        bundle = w.b(a, i, b);
        return bundle;
        bundle;
        setResult(0, (new Intent()).putExtra("memoryError", true));
        finish();
        return null;
        bundle;
        Utils.c(this, getResources().getString(0x7f08024e));
        setResult(111);
        finish();
        return null;
    }

    static String a(SquareFitStandaloneActivity squarefitstandaloneactivity)
    {
        return squarefitstandaloneactivity.a;
    }

    static String a(SquareFitStandaloneActivity squarefitstandaloneactivity, String s)
    {
        squarefitstandaloneactivity.a = s;
        return s;
    }

    public final void a(int i)
    {
        Intent intent = new Intent();
        intent.putExtra("path", a);
        intent.putExtra("degree", b);
        intent.putExtra("bufferData", c);
        intent.putExtra("hasChanges", false);
        setResult(i, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002b);
        bundle = getFragmentManager();
        Intent intent = getIntent();
        g = intent.getBooleanExtra("shareToInstagramOnApply", false);
        if (intent.hasExtra("defaultEffect"))
        {
            h = intent.getStringExtra("defaultEffect");
        }
        SquareFitFragment squarefitfragment = (SquareFitFragment)bundle.findFragmentByTag("squareFitFragment");
        bundle = squarefitfragment;
        if (squarefitfragment == null)
        {
            bundle = new SquareFitFragment();
            bundle.setRetainInstance(true);
            bundle.e = h;
            bundle.d = g;
            getFragmentManager().beginTransaction().add(0x7f10013a, bundle, "squareFitFragment").commit();
        }
        bundle.a(new c() {

            final SquareFitStandaloneActivity a;

            public final void a(i i)
            {
                a.a(0);
            }

            public final void a(i i, Bitmap bitmap, EditorAction editoraction)
            {
                (new ModernAsyncTask(this) {

                    private _cls1 a;

                    protected final Object doInBackground(Object aobj[])
                    {
                        aobj = (Bitmap[])aobj;
                        EditingData editingdata = EditingData.a(SquareFitStandaloneActivity.a(a.a));
                        SquareFitStandaloneActivity.a(a.a, w.a(SquareFitStandaloneActivity.a(a.a).substring(0, SquareFitStandaloneActivity.a(a.a).lastIndexOf("/") + 1), SquareFitStandaloneActivity.a(a.a).substring(SquareFitStandaloneActivity.a(a.a).lastIndexOf("/") + 1), ((Bitmap) (aobj[0])), a.a, android.graphics.Bitmap.CompressFormat.JPEG, false).getPath());
                        String s = SquareFitStandaloneActivity.a(a.a);
                        if (SocialinV3.getInstance().isRegistered())
                        {
                            aobj = String.valueOf(SocialinV3.getInstance().getUser().id);
                        } else
                        {
                            aobj = null;
                        }
                        m.a(s, ((String) (aobj)), editingdata.c().toString());
                        return null;
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        super.onPostExecute((Void)obj);
                        a.a.a(-1);
                    }

            
            {
                a = _pcls1;
                super();
            }
                }).execute(new Bitmap[] {
                    bitmap
                });
            }

            
            {
                a = SquareFitStandaloneActivity.this;
                super();
            }
        });
        f = a(intent.getExtras());
        bundle.a(f);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (f != null)
            {
                AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitCloseEvent(SquareFitFragment.c, "back", 0, f.getHeight(), f.getWidth()));
            }
            a(0);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        d = bundle.getString("folder");
        e = bundle.getString("imageName");
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("folder", d);
        bundle.putString("imageName", e);
    }
}
