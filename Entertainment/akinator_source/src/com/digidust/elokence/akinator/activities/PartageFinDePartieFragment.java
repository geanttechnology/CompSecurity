// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.io.File;
import java.io.FileOutputStream;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity, PartageAppsFragment

public class PartageFinDePartieFragment extends Fragment
    implements android.view.View.OnClickListener
{

    public static final int SHARING_AWARD = 2;
    public static final int SHARING_BD = 0;
    public static final int SHARING_PROPOSE = 1;
    private GameOverActivity activityMaster;
    private PartageAppsFragment fragmentPartage;
    private int mIndex;

    public PartageFinDePartieFragment()
    {
        fragmentPartage = null;
    }

    private void doShare()
    {
        Object obj;
        Intent intent;
        activityMaster.layoutPartage.setVisibility(8);
        intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        obj = null;
        if (mIndex != 0) goto _L2; else goto _L1
_L1:
        obj = AkGameFactory.sharedInstance().getBd();
_L16:
        if (obj == null) goto _L4; else goto _L3
_L3:
        Bitmap bitmap;
        Object obj1;
        bitmap = Bitmap.createBitmap(((Bitmap) (obj)));
        obj = new Canvas(bitmap);
        obj1 = new Paint();
        ((Paint) (obj1)).setColor(0xff00ffff);
        ((Canvas) (obj)).drawRect(0.0F, 0.0F, 10F, 10F, ((Paint) (obj1)));
        obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/temp").toString());
        if (!((File) (obj1)).exists())
        {
            ((File) (obj1)).mkdirs();
        }
        obj = null;
        if (mIndex != 0) goto _L6; else goto _L5
_L5:
        obj = new File(((File) (obj1)), "bd.jpg");
_L12:
        if (obj == null) goto _L4; else goto _L7
_L7:
        obj1 = new FileOutputStream(((File) (obj)));
        if (mIndex == 0) goto _L9; else goto _L8
_L8:
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, ((java.io.OutputStream) (obj1)));
_L14:
        ((FileOutputStream) (obj1)).flush();
        ((FileOutputStream) (obj1)).close();
        obj = Uri.fromFile(((File) (obj)));
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(TraductionFactory.sharedInstance().getTraductionFromToken("AKINATOR_VIENS_DE_DEVINER_QUE_JE_PENSAIS_A")).append(" ").append(SessionFactory.sharedInstance().getSession().getCurrentProposedObject().getName()).append(" ").append(getResources().getString(0x7f07005f)).toString());
        intent.setType("image/jpeg");
        intent.putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) (obj)));
        obj = activityMaster.getPackageManager().queryIntentActivities(intent, 0);
        fragmentPartage = new PartageAppsFragment();
        fragmentPartage.setPartageIndex(mIndex);
        fragmentPartage.build(intent, ((java.util.List) (obj)));
        obj = activityMaster.getFragmentManager().beginTransaction();
        ((FragmentTransaction) (obj)).add(0x7f0d00e0, fragmentPartage);
        ((FragmentTransaction) (obj)).commit();
        return;
_L2:
        if (mIndex == 1)
        {
            obj = AkGameFactory.sharedInstance().getCharacterScreenshot();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (mIndex == 2)
            {
                obj = AkGameFactory.sharedInstance().getCharacterScreenshotWithAward();
            }
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
          goto _L4
_L6:
        if (mIndex != 1) goto _L11; else goto _L10
_L10:
        obj = new File(((File) (obj1)), "temp.jpg");
          goto _L12
_L11:
        if (mIndex != 2) goto _L12; else goto _L13
_L13:
        obj = new File(((File) (obj1)), "tempAward.jpg");
          goto _L12
_L9:
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((java.io.OutputStream) (obj1)));
          goto _L14
_L4:
        return;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public boolean checkPartageHasClosed()
    {
        if (fragmentPartage != null && fragmentPartage.isVisible())
        {
            fragmentPartage.hide();
            return true;
        } else
        {
            return false;
        }
    }

    public void onClick(View view)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            if (activityMaster.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 || activityMaster.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
            {
                AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
                requestPermissions(new String[] {
                    "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"
                }, 666);
                return;
            } else
            {
                doShare();
                return;
            }
        } else
        {
            doShare();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030051, viewgroup, false);
        viewgroup = (ImageView)layoutinflater.findViewById(0x7f0d0221);
        viewgroup.setOnClickListener(this);
        activityMaster = (GameOverActivity)getActivity();
        if (mIndex == 0)
        {
            viewgroup.setImageBitmap(AkGameFactory.sharedInstance().getBd());
        } else
        {
            if (mIndex == 1)
            {
                viewgroup.setImageBitmap(AkGameFactory.sharedInstance().getCharacterScreenshot());
                return layoutinflater;
            }
            if (mIndex == 2)
            {
                viewgroup.setImageBitmap(AkGameFactory.sharedInstance().getCharacterScreenshotWithAward());
                return layoutinflater;
            }
        }
        return layoutinflater;
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
        if (i != 666) goto _L2; else goto _L1
_L1:
        int j;
        j = ai.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ai[i] == 0) goto _L3; else goto _L2
_L2:
        return;
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        doShare();
        return;
    }

    public void setIndex(int i)
    {
        mIndex = i;
    }
}
