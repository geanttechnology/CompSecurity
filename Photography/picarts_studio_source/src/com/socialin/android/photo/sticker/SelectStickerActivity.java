// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.sticker;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.j;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ak;
import com.socialin.android.util.s;
import java.io.File;

// Referenced classes of package com.socialin.android.photo.sticker:
//            b, a

public class SelectStickerActivity extends AdBaseActivity
    implements android.widget.AdapterView.OnItemClickListener, j
{

    private String a;

    public SelectStickerActivity()
    {
    }

    static void a(SelectStickerActivity selectstickeractivity, int i)
    {
        selectstickeractivity.b(i);
    }

    private void b(int i)
    {
        Intent intent = new Intent();
        intent.putExtra("stickerIndex", i);
        intent.putExtra("stickerFilePath", ak.a(this, a).b(i));
        setResult(-1, intent);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("sticker:done");
    }

    public final void a(int i)
    {
        String s = ak.a(this, a).b(i);
        String s1 = (new StringBuilder()).append(b.b).append(ak.a(this, a).a(i)).toString();
        if ((new File(s)).exists())
        {
            b(i);
            return;
        } else
        {
            (new ModernAsyncTask(s1, s, i) {

                private String a;
                private String b;
                private int c;
                private SelectStickerActivity d;

                protected final Object doInBackground(Object aobj[])
                {
                    return Boolean.valueOf(com.socialin.android.util.s.a(a, b));
                }

                protected final void onPostExecute(Object obj)
                {
                    obj = (Boolean)obj;
                    super.onPostExecute(obj);
                    if (((Boolean) (obj)).booleanValue())
                    {
                        SelectStickerActivity.a(d, c);
                    }
                }

            
            {
                d = SelectStickerActivity.this;
                a = s1;
                b = s2;
                c = i;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void finish()
    {
        super.finish();
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301bb);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
            bundle.setTitle(0x7f08060c);
        }
        AnalyticUtils.getInstance(this).trackLocalAction("sticker:onCreate");
        a = getIntent().getStringExtra("stickerCategory");
        if (a == null)
        {
            a = "default";
        }
        bundle = (GridView)findViewById(0x7f100818);
        bundle.setAdapter(new a(this, a));
        bundle.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private SelectStickerActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                a.a(i);
            }

            
            {
                a = SelectStickerActivity.this;
                super();
            }
        });
        Utils.b(hashCode());
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        AnalyticUtils.getInstance(this).trackLocalAction("sticker:download");
        a(i);
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
        setResult(0);
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("sticker:back");
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Utils.b(hashCode());
        initAd();
    }

    public void onStart()
    {
        super.onStart();
    }
}
