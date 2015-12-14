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
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.fragment.f;
import com.picsart.studio.editor.fragment.i;
import com.picsart.studio.editor.history.EditorAction;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.util.HashMap;

public class StandaloneCropToolActivity extends BaseActivity
{

    String a;
    String b;
    private int c;
    private int d;
    private float e;
    private String f;
    private int g;
    private HashMap h;
    private f i;

    public StandaloneCropToolActivity()
    {
        f = null;
        g = 0;
        h = null;
        a = "";
        b = "";
    }

    private Bitmap a(Bundle bundle)
    {
        int j;
        if (bundle.containsKey("bufferData"))
        {
            h = (HashMap)bundle.getSerializable("bufferData");
        }
        f = bundle.getString("imagePath");
        g = bundle.getInt("degree");
        j = bundle.getInt("maxPixel", PicsartContext.a());
        if (bundle.containsKey("outputFormat"))
        {
            bundle.getSerializable("outputFormat");
        }
        c = bundle.getInt("outputX");
        d = bundle.getInt("outputY");
        if (c <= 0 || d <= 0)
        {
            e = bundle.getFloat("aspectRatio");
        }
        a = getResources().getString(0x7f0808c0);
        b = (new StringBuilder("crop_tmp_")).append(String.valueOf(System.currentTimeMillis())).toString();
        if (h != null)
        {
            try
            {
                bundle = w.a(h, j, g);
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
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        bundle = w.b(f, j, g);
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

    public final void a()
    {
        Intent intent = new Intent();
        intent.putExtra("path", f);
        intent.putExtra("degree", g);
        intent.putExtra("bufferData", h);
        intent.putExtra("hasChanges", false);
        setResult(0, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        Bundle bundle1;
        super.onCreate(bundle);
        setContentView(0x7f03001d);
        bundle = getFragmentManager();
        bundle1 = new Bundle(1);
        bundle1.putString("source", getIntent().getStringExtra("source"));
        i = (f)bundle.findFragmentByTag("cropFragment");
        if (i != null) goto _L2; else goto _L1
_L1:
        i = new f();
        i.a(a(getIntent().getExtras()));
        i.setArguments(bundle1);
        if (c <= 0 || d <= 0) goto _L4; else goto _L3
_L3:
        bundle = i;
        int j = c;
        int k = d;
        bundle.c = j;
        bundle.d = k;
        if (((f) (bundle)).c > 0 && ((f) (bundle)).d > 0)
        {
            bundle.f = true;
        }
_L6:
        getFragmentManager().beginTransaction().add(0x7f10013a, i, "cropFragment").commit();
_L2:
        i.a(new c() {

            private StandaloneCropToolActivity a;

            public final void a(i l)
            {
                a.a();
            }

            public final void a(i l, Bitmap bitmap, EditorAction editoraction)
            {
                l = a;
                if (!FileUtils.a())
                {
                    Utils.c(l, l.getString(0x7f080479));
                    return;
                } else
                {
                    bitmap = w.a(((StandaloneCropToolActivity) (l)).a, ((StandaloneCropToolActivity) (l)).b, bitmap, l);
                    editoraction = new Intent();
                    editoraction.putExtra("hasChanges", true);
                    editoraction.putExtra("bufferData", bitmap);
                    l.setResult(-1, editoraction);
                    l.finish();
                    return;
                }
            }

            
            {
                a = StandaloneCropToolActivity.this;
                super();
            }
        });
        return;
_L4:
        if (e > 0.0F)
        {
            bundle = i;
            float f1 = e;
            bundle.e = f1;
            if (f1 > 0.0F)
            {
                bundle.f = true;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 4)
        {
            a();
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        a = bundle.getString("folder");
        b = bundle.getString("imageName");
        if (i != null)
        {
            i.a(a(getIntent().getExtras()));
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("folder", a);
        bundle.putString("imageName", b);
    }
}
