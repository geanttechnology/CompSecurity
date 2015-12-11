// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.hs;
import android.view.Menu;
import android.widget.Toast;
import com.abtnprojects.ambatana.ui.widgets.LetgoPageIndicator;
import java.util.ArrayList;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

public class ImageGalleryActivity extends b
{

    private ArrayList A;
    private hs B;
    private int C;
    private ViewPager n;

    public ImageGalleryActivity()
    {
        A = new ArrayList();
        C = 0;
    }

    private void l()
    {
        B = new hs(f(), A);
        n = (ViewPager)findViewById(0x7f100086);
        n.setAdapter(B);
        n.setCurrentItem(C);
        LetgoPageIndicator letgopageindicator = (LetgoPageIndicator)findViewById(0x7f100087);
        int i = A.size();
        if (i <= 1)
        {
            letgopageindicator.setVisibility(4);
            return;
        } else
        {
            letgopageindicator.setIndicatorsSize(i);
            letgopageindicator.b(C);
            n.a(letgopageindicator);
            return;
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            bundle = getIntent().getExtras();
            if (bundle != null)
            {
                A = bundle.getStringArrayList("ProductObjectId");
                C = bundle.getInt("ImagePosition");
                l();
            } else
            {
                Toast.makeText(this, getString(0x7f0900b5), 1).show();
                t();
            }
            a(0x7f0200d1);
        }
    }

    protected void k()
    {
        setContentView(0x7f04001e);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }
}
