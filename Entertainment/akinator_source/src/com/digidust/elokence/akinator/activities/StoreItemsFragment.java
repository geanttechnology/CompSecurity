// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import com.elokence.limuleapi.TraductionFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            StoreCommonElementsFragment, StoreActivity

public class StoreItemsFragment extends StoreCommonElementsFragment
{

    public static final String TYPE_BACKGROUND = "bg";
    public static final String TYPE_CLOTH = "cloth";
    public static final String TYPE_HAT = "hat";
    private static final int mBackgroundGz[] = {
        0, 0, 15000, 0x124f8, 0x249f0
    };
    public static final String mBackgroundNames[] = {
        "orient", "japon", "farwest", "marin", "halloween"
    };
    private static final int mClothGz[] = {
        0, 0, 3000, 15000, 25000, 30000, 40000, 50000, 60000, 0x11170, 
        0x13880, 0x17318, 0x1adb0
    };
    public static final String mClothNames[] = {
        "orient", "yukata", "rap", "chevalier", "scuba", "mexicain", "cowboy", "disco", "catcheur", "indien", 
        "dracula", "superheros", "pirate"
    };
    private static final int mHatGz[] = {
        0, 1000, 7000, 15000, 20000, 25000, 30000, 40000, 45000, 50000, 
        55000
    };
    public static final String mHatNames[] = {
        "turban", "rap", "scuba", "chevalier", "elvis", "cowboy", "mexicain", "disco", "indien", "punk", 
        "pirate"
    };
    private StoreActivity activityMaster;
    android.view.View.OnClickListener backgroundIconListener;
    android.view.View.OnClickListener changeClothListener;
    android.view.View.OnClickListener changeHatListener;
    private LinearLayout listImages;
    private ArrayList mBitmapsToRecycle;
    private int mCurrentBackgroundIndex;
    private int mCurrentClothIndex;
    private int mCurrentHatIndex;
    private ProgressDialog mProgBarBackGround;
    private ProgressDialog mProgBarCloth;
    private ProgressDialog mProgBarHat;
    private View rootView;
    private ImageView uiButtonArrowCloth;
    private ImageView uiButtonArrowHat;
    private Button uiButtonClothLeft;
    private Button uiButtonClothRight;
    private Button uiButtonHatLeft;
    private Button uiButtonHatRight;
    private ImageView uiImageBackgroundGz;
    private ImageView uiImageBackgroundIcon[];
    private RelativeLayout uiLayoutBackgroundGz;
    private TextView uiTextArrowCloth;
    private TextView uiTextArrowHat;
    private TextView uiTextBackgroundGz;
    android.view.View.OnClickListener unlockBackGroundListener;
    android.view.View.OnClickListener unlockClothListener;
    android.view.View.OnClickListener unlockHatListener;

    public StoreItemsFragment()
    {
        mCurrentBackgroundIndex = 0;
        uiImageBackgroundIcon = new ImageView[mBackgroundNames.length];
        mCurrentHatIndex = 0;
        mCurrentClothIndex = 0;
        changeHatListener = new _cls1();
        unlockHatListener = new _cls2();
        changeClothListener = new _cls3();
        unlockClothListener = new _cls4();
        backgroundIconListener = new _cls5();
        unlockBackGroundListener = new _cls6();
    }

    private void ChangeMusic()
    {
        int i = AkConfigFactory.sharedInstance().getShortMusic();
        mCurrentBackgroundIndex;
        JVM INSTR tableswitch 0 4: default 44
    //                   0 70
    //                   1 81
    //                   2 92
    //                   3 103
    //                   4 114;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if (i != AkConfigFactory.sharedInstance().getShortMusic())
        {
            BackgroundMusicBinder.sharedInstance().stopMusic();
        }
        BackgroundMusicBinder.sharedInstance().startMusic(com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.SHORT_MUSIC);
        return;
_L2:
        AkConfigFactory.sharedInstance().setShortMusic(0x7f060008);
        continue; /* Loop/switch isn't completed */
_L3:
        AkConfigFactory.sharedInstance().setShortMusic(0x7f060007);
        continue; /* Loop/switch isn't completed */
_L4:
        AkConfigFactory.sharedInstance().setShortMusic(0x7f060008);
        continue; /* Loop/switch isn't completed */
_L5:
        AkConfigFactory.sharedInstance().setShortMusic(0x7f060008);
        continue; /* Loop/switch isn't completed */
_L6:
        AkConfigFactory.sharedInstance().setShortMusic(0x7f060008);
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void DisplayBackgroundIcon()
    {
        for (int i = 0; i < mBackgroundNames.length; i++)
        {
            setImage(uiImageBackgroundIcon[i], (new StringBuilder()).append("ak_").append(mBackgroundNames[i]).append("_nb").toString());
        }

        setImage(uiImageBackgroundIcon[mCurrentBackgroundIndex], (new StringBuilder()).append("ak_").append(mBackgroundNames[mCurrentBackgroundIndex]).append("_couleur").toString());
        LoadBackgroundAsync();
    }

    private void DisplayBackgroundPreview()
    {
        setBackgroundImage((new StringBuilder()).append("ak_decor_").append(mBackgroundNames[mCurrentBackgroundIndex]).append("_preview").toString());
    }

    private void DisplayItem(String s)
    {
        ImageView imageview;
        String as[];
        int ai[];
        TextView textview;
        int i;
        as = null;
        ai = null;
        i = -1;
        imageview = null;
        textview = null;
        if (!s.equals("hat")) goto _L2; else goto _L1
_L1:
        as = mHatNames;
        ai = mHatGz;
        i = mCurrentHatIndex;
        imageview = uiButtonArrowHat;
        textview = uiTextArrowHat;
_L14:
        if (!AkPlayerBelongingsFactory.sharedInstance().isItemBought(s, as[i])) goto _L4; else goto _L3
_L3:
        imageview.setVisibility(4);
        textview.setVisibility(4);
        boolean flag = true;
    /* block-local class not found */
    class AsyncTaskCustom {}

        if (s.equals("hat"))
        {
            flag = AkSceneryFactory.sharedInstance().isHatLoaded(as[i]);
        } else
        if (s.equals("cloth"))
        {
            flag = AkSceneryFactory.sharedInstance().isTenueLoaded(as[i]);
        }
        if (flag) goto _L6; else goto _L5
_L5:
        (new AsyncTaskCustom(s)).execute(new Void[0]);
_L8:
        return;
_L2:
        if (s.equals("cloth"))
        {
            as = mClothNames;
            ai = mClothGz;
            i = mCurrentClothIndex;
            imageview = uiButtonArrowCloth;
            textview = uiTextArrowCloth;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("hat"))
        {
            setImage(0x7f0d00c7, AkSceneryFactory.sharedInstance().getHatBitmap(as[i], "akinator_defi"));
            return;
        }
        if (!s.equals("cloth")) goto _L8; else goto _L7
_L7:
        setImage(0x7f0d00c6, AkSceneryFactory.sharedInstance().getClothBitmap(as[i], "akinator_defi"));
        return;
_L4:
        if (!s.equals("hat")) goto _L10; else goto _L9
_L9:
        setImage(0x7f0d00c7, (new StringBuilder()).append("akinator_defi_chapeau_").append(as[i]).append("_preview").toString());
_L12:
        imageview.setVisibility(0);
        textview.setVisibility(0);
        textview.setText(NumberFormat.getInstance().format(ai[i]));
        return;
_L10:
        if (s.equals("cloth"))
        {
            setImage(0x7f0d00c6, (new StringBuilder()).append("akinator_defi_tenu_").append(as[i]).append("_preview").toString());
        }
        if (true) goto _L12; else goto _L11
_L11:
        if (true) goto _L14; else goto _L13
_L13:
    }

    private void LoadBackgroundAsync()
    {
        if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("bg", mBackgroundNames[mCurrentBackgroundIndex]))
        {
            if (!AkSceneryFactory.sharedInstance().isBackgroundLoaded(mBackgroundNames[mCurrentBackgroundIndex]))
            {
                (new AsyncTaskCustom("bg")).execute(new Void[0]);
            }
            uiLayoutBackgroundGz.setVisibility(4);
            return;
        } else
        {
            Object obj = getResources();
            float f = ((Resources) (obj)).getDimensionPixelSize(0x7f09002b);
            float f4 = ((Resources) (obj)).getDimensionPixelSize(0x7f09003c);
            float f1 = 10;
            float f2 = mCurrentBackgroundIndex;
            float f3 = 20;
            f4 = (f - f4) / 2.0F;
            obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins((int)(f1 + f2 * (f3 + f) + f4), 0, 0, 0);
            uiLayoutBackgroundGz.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            uiTextBackgroundGz.setText(NumberFormat.getInstance().format(mBackgroundGz[mCurrentBackgroundIndex]));
            uiLayoutBackgroundGz.setVisibility(0);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        rootView = layoutinflater.inflate(0x7f030054, viewgroup, false);
        initCommonShopElements(rootView);
        activityMaster = (StoreActivity)getActivity();
        mBitmapsToRecycle = new ArrayList();
        uiButtonHatLeft = (Button)rootView.findViewById(0x7f0d023e);
        uiButtonHatLeft.setOnClickListener(changeHatListener);
        uiButtonHatRight = (Button)rootView.findViewById(0x7f0d0242);
        uiButtonHatRight.setOnClickListener(changeHatListener);
        uiButtonArrowHat = (ImageView)rootView.findViewById(0x7f0d0240);
        uiTextArrowHat = (TextView)rootView.findViewById(0x7f0d0241);
        uiButtonArrowHat.setOnClickListener(unlockHatListener);
        uiButtonClothLeft = (Button)rootView.findViewById(0x7f0d0243);
        uiButtonClothLeft.setOnClickListener(changeClothListener);
        uiButtonClothRight = (Button)rootView.findViewById(0x7f0d0244);
        uiButtonClothRight.setOnClickListener(changeClothListener);
        uiButtonArrowCloth = (ImageView)rootView.findViewById(0x7f0d0246);
        uiTextArrowCloth = (TextView)rootView.findViewById(0x7f0d0247);
        uiButtonArrowCloth.setOnClickListener(unlockClothListener);
        listImages = (LinearLayout)rootView.findViewById(0x7f0d024c);
        for (int i = 0; i < mBackgroundNames.length; i++)
        {
            uiImageBackgroundIcon[i] = new ImageView(rootView.getContext());
            layoutinflater = new android.widget.LinearLayout.LayoutParams(getResources().getDimensionPixelSize(0x7f09002b), getResources().getDimensionPixelSize(0x7f09002a));
            layoutinflater.setMargins(10, 0, 10, 0);
            uiImageBackgroundIcon[i].setLayoutParams(layoutinflater);
            uiImageBackgroundIcon[i].setOnClickListener(backgroundIconListener);
            listImages.addView(uiImageBackgroundIcon[i]);
        }

        uiLayoutBackgroundGz = (RelativeLayout)rootView.findViewById(0x7f0d0248);
        uiTextBackgroundGz = (TextView)rootView.findViewById(0x7f0d024a);
        uiImageBackgroundGz = (ImageView)rootView.findViewById(0x7f0d0249);
        uiLayoutBackgroundGz.setOnClickListener(unlockBackGroundListener);
        uiTextArrowHat.setTypeface(tf);
        uiTextArrowCloth.setTypeface(tf);
        uiTextBackgroundGz.setTypeface(tf);
        mCurrentBackgroundIndex = AkPlayerBelongingsFactory.sharedInstance().getCurrentBackgroundIndex();
        mCurrentHatIndex = AkPlayerBelongingsFactory.sharedInstance().getCurrentHatIndex();
        mCurrentClothIndex = AkPlayerBelongingsFactory.sharedInstance().getCurrentClothIndex();
        setImage(0x7f0d00c5, AkSceneryFactory.sharedInstance().getAkiBitmap("akinator_defi"));
        ChangeMusic();
        return rootView;
    }

    public void onDestroy()
    {
        super.onDestroy();
        recycleBitmaps();
        System.gc();
        if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("hat", mHatNames[mCurrentHatIndex]))
        {
            AkConfigFactory.sharedInstance().setHat(mHatNames[mCurrentHatIndex]);
            AkPlayerBelongingsFactory.sharedInstance().setCurrentHatIndex(mCurrentHatIndex);
        }
        if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("cloth", mClothNames[mCurrentClothIndex]))
        {
            AkConfigFactory.sharedInstance().setCloth(mClothNames[mCurrentClothIndex]);
            AkPlayerBelongingsFactory.sharedInstance().setCurrentClothIndex(mCurrentClothIndex);
        }
        if (AkPlayerBelongingsFactory.sharedInstance().isItemBought("bg", mBackgroundNames[mCurrentBackgroundIndex]))
        {
            AkConfigFactory.sharedInstance().setBackground(mBackgroundNames[mCurrentBackgroundIndex]);
            AkPlayerBelongingsFactory.sharedInstance().setCurrentBackgroundIndex(mCurrentBackgroundIndex);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mProgBarHat == null || mProgBarHat != null && !mProgBarHat.isShowing())
        {
            DisplayItem("hat");
        }
        if (mProgBarCloth == null || mProgBarCloth != null && !mProgBarCloth.isShowing())
        {
            DisplayItem("cloth");
        }
        if (mProgBarBackGround == null || mProgBarBackGround != null && !mProgBarBackGround.isShowing())
        {
            DisplayBackgroundIcon();
            DisplayBackgroundPreview();
        }
    }

    protected void recycleBitmaps()
    {
        for (int i = 0; i < mBitmapsToRecycle.size(); i++)
        {
            Bitmap bitmap = (Bitmap)mBitmapsToRecycle.get(i);
            if (bitmap != null && !bitmap.isRecycled())
            {
                bitmap.recycle();
            }
        }

        mBitmapsToRecycle.clear();
    }

    public void setBackgroundImage(String s)
    {
        ImageView imageview;
        imageview = (ImageView)rootView.findViewById(0x7f0d023b);
        if (imageview == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(new BufferedInputStream(getResources().getAssets().open((new StringBuilder()).append("drawable/").append(s).append(".png").toString()), 32768));
        mBitmapsToRecycle.add(bitmap);
        imageview.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        return;
        s;
        Toast.makeText(activityMaster, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
        return;
        IOException ioexception;
        ioexception;
        AkLog.e("Akinator", (new StringBuilder()).append("Impossible de charger l'image ").append(s).toString());
        return;
    }

    protected boolean setImage(int i, Bitmap bitmap)
    {
        ImageView imageview = (ImageView)rootView.findViewById(i);
        if (imageview != null)
        {
            Object obj = imageview.getDrawable();
            if (obj instanceof BitmapDrawable)
            {
                obj = ((BitmapDrawable)obj).getBitmap();
                mBitmapsToRecycle.remove(obj);
                try
                {
                    ((Bitmap) (obj)).recycle();
                    AkLog.d("Akinator", "Nettoyage d'une bitmap");
                }
                catch (Exception exception) { }
            }
            try
            {
                mBitmapsToRecycle.add(bitmap);
                imageview.setImageBitmap(bitmap);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                Toast.makeText(activityMaster, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean setImage(int i, String s)
    {
        if ((ImageView)rootView.findViewById(i) == null)
        {
            return false;
        }
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(getResources().getAssets().open((new StringBuilder()).append("drawable/").append(s).append(".png").toString()), 32768));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(activityMaster, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
            return false;
        }
        catch (IOException ioexception)
        {
            AkLog.e("Akinator", (new StringBuilder()).append("Impossible de charger l'image ").append(s).toString());
            return false;
        }
        return setImage(i, bitmap);
    }

    protected boolean setImage(ImageView imageview, Bitmap bitmap)
    {
        if (imageview != null)
        {
            Object obj = imageview.getDrawable();
            if (obj instanceof BitmapDrawable)
            {
                obj = ((BitmapDrawable)obj).getBitmap();
                mBitmapsToRecycle.remove(obj);
                try
                {
                    ((Bitmap) (obj)).recycle();
                    AkLog.d("Akinator", "Nettoyage d'une bitmap");
                }
                catch (Exception exception) { }
            }
            try
            {
                mBitmapsToRecycle.add(bitmap);
                imageview.setImageBitmap(bitmap);
            }
            // Misplaced declaration of an exception variable
            catch (ImageView imageview)
            {
                Toast.makeText(activityMaster, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean setImage(ImageView imageview, String s)
    {
        if (imageview == null)
        {
            return false;
        }
        Bitmap bitmap;
        try
        {
            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(getResources().getAssets().open((new StringBuilder()).append("drawable/").append(s).append(".png").toString()), 32768));
        }
        // Misplaced declaration of an exception variable
        catch (ImageView imageview)
        {
            Toast.makeText(activityMaster, TraductionFactory.sharedInstance().getTraductionFromToken("MANQUE_DE_MEMOIRE"), 1).show();
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (ImageView imageview)
        {
            AkLog.e("Akinator", (new StringBuilder()).append("Impossible de charger l'image ").append(s).toString());
            return false;
        }
        return setImage(imageview, bitmap);
    }






/*
    static int access$1002(StoreItemsFragment storeitemsfragment, int i)
    {
        storeitemsfragment.mCurrentBackgroundIndex = i;
        return i;
    }

*/


/*
    static int access$102(StoreItemsFragment storeitemsfragment, int i)
    {
        storeitemsfragment.mCurrentHatIndex = i;
        return i;
    }

*/


/*
    static int access$108(StoreItemsFragment storeitemsfragment)
    {
        int i = storeitemsfragment.mCurrentHatIndex;
        storeitemsfragment.mCurrentHatIndex = i + 1;
        return i;
    }

*/


/*
    static int access$110(StoreItemsFragment storeitemsfragment)
    {
        int i = storeitemsfragment.mCurrentHatIndex;
        storeitemsfragment.mCurrentHatIndex = i - 1;
        return i;
    }

*/















/*
    static int access$602(StoreItemsFragment storeitemsfragment, int i)
    {
        storeitemsfragment.mCurrentClothIndex = i;
        return i;
    }

*/


/*
    static int access$608(StoreItemsFragment storeitemsfragment)
    {
        int i = storeitemsfragment.mCurrentClothIndex;
        storeitemsfragment.mCurrentClothIndex = i + 1;
        return i;
    }

*/


/*
    static int access$610(StoreItemsFragment storeitemsfragment)
    {
        int i = storeitemsfragment.mCurrentClothIndex;
        storeitemsfragment.mCurrentClothIndex = i - 1;
        return i;
    }

*/




    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}

}
