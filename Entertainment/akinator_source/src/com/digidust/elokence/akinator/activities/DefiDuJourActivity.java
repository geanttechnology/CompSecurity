// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.billing.Base64;
import com.digidust.elokence.akinator.billing.Base64DecoderException;
import com.digidust.elokence.akinator.db.DefiSetAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.TraductionFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, PartageAppsFragment, PostHomeActivity, PostProposeActivity

public class DefiDuJourActivity extends AkActivity
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
{

    private static final int GAIN_TOTAL = 1000;
    public static final String KEY_MODE = "keyMode";
    public static final String KEY_PERSO_TROUVE = "keyPersoTrouve";
    public static final int MODE_DEFI_DU_JOUR = 0;
    public static final int MODE_DEFI_PRECEDANT = 1;
    private static final String NB_GENIZ = "[NB_GENIZ]";
    private static final int PROCHAIN_GAIN[] = {
        100, 200, 300, 400, 500
    };
    private static final String TAG = "DefiDuJourActivity";
    private final int LAST_ANIMATION_DURATION = 1000;
    private int MaxPersosToFind;
    AlphaAnimation alpha;
    private TextView felicitation;
    private PartageAppsFragment fragmentPartage;
    private ImageView imageCharacterFound;
    private ImageView imageCharacterFoundIcon;
    private ImageView imageFlecheDroite;
    RelativeLayout layoutFireworks;
    private RelativeLayout layoutOneCharacterFound;
    private LinearLayout listViewDefi;
    private int mMode;
    private RelativeLayout mainLayout;
    private int nbCharactersFound;
    private Button partageButton;
    private String photoBase64PersoTrouve;
    private TextView prochainGain;
    ScaleAnimation s1;
    ScaleAnimation s2;
    ScaleAnimation s3;
    private TextView textPourcent;
    private TextView titreDefi;
    TranslateAnimation translateToIcon;

    public DefiDuJourActivity()
    {
        MaxPersosToFind = 0;
        nbCharactersFound = 0;
        fragmentPartage = null;
    }

    private void doShare()
    {
        try
        {
            Object obj = AkGameFactory.sharedInstance().getCharacterScreenshotDefi();
            Object obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/temp").toString());
            if (!((File) (obj1)).exists())
            {
                ((File) (obj1)).mkdirs();
            }
            obj1 = new File(((File) (obj1)), "tempDefi.jpg");
            FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj1)));
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, fileoutputstream);
            fileoutputstream.flush();
            fileoutputstream.close();
            obj1 = Uri.fromFile(((File) (obj1)));
            obj = new Intent();
            ((Intent) (obj)).setAction("android.intent.action.SEND");
            ((Intent) (obj)).setType("image/jpeg");
            ((Intent) (obj)).putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) (obj1)));
            obj1 = getPackageManager().queryIntentActivities(((Intent) (obj)), 0);
            fragmentPartage = new PartageAppsFragment();
            fragmentPartage.build(((Intent) (obj)), ((List) (obj1)));
            obj = getFragmentManager().beginTransaction();
            ((FragmentTransaction) (obj)).add(0x7f0d00e0, fragmentPartage);
            ((FragmentTransaction) (obj)).commit();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void onAnimationEnd(Animation animation)
    {
        if (animation == alpha)
        {
            s1 = new ScaleAnimation(1.0F, -1F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            s1.setStartOffset(500L);
            s1.setDuration(400L);
            s1.setFillBefore(true);
            s1.setFillAfter(true);
            s1.setAnimationListener(this);
            imageCharacterFound.startAnimation(s1);
        }
        if (animation == s1)
        {
            s2 = new ScaleAnimation(-1F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
            s2.setDuration(400L);
            s2.setFillAfter(true);
            s2.setAnimationListener(this);
            imageCharacterFound.startAnimation(s2);
        } else
        {
            if (animation == s2)
            {
                s3 = new ScaleAnimation(1.0F, -1F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
                s3.setDuration(400L);
                s3.setFillAfter(true);
                s3.setAnimationListener(this);
                imageCharacterFound.startAnimation(s3);
                return;
            }
            if (animation == s3)
            {
                animation = new AnimationSet(true);
                animation.setFillAfter(true);
                ScaleAnimation scaleanimation = new ScaleAnimation(-1F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
                scaleanimation.setDuration(1000L);
                int i = imageCharacterFound.getLayoutParams().width;
                int j = imageCharacterFound.getLayoutParams().height;
                int k = imageCharacterFoundIcon.getLayoutParams().width;
                int l = imageCharacterFoundIcon.getLayoutParams().height;
                ScaleAnimation scaleanimation1 = new ScaleAnimation(1.0F, (float)k / (float)i, 1.0F, (float)l / (float)j);
                scaleanimation1.setDuration(1000L);
                int ai[] = new int[2];
                int ai1[] = new int[2];
                imageCharacterFound.getLocationInWindow(ai);
                imageCharacterFoundIcon.getLocationInWindow(ai1);
                translateToIcon = new TranslateAnimation(0, 0.0F, 0, ai1[0] - ai[0], 0, 0.0F, 0, ai1[1] - ai[1]);
                translateToIcon.setDuration(1000L);
                translateToIcon.setAnimationListener(this);
                animation.addAnimation(scaleanimation);
                animation.addAnimation(scaleanimation1);
                animation.addAnimation(translateToIcon);
                imageCharacterFound.startAnimation(animation);
                animation = new AlphaAnimation(1.0F, 0.0F);
                animation.setDuration(1000L);
                animation.setFillAfter(true);
                layoutOneCharacterFound.startAnimation(animation);
                return;
            }
            if (animation == translateToIcon)
            {
                MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_playing", PROCHAIN_GAIN[nbCharactersFound - 1]);
                AkPlayerBelongingsFactory.sharedInstance().depositGenizWithoutNotif(PROCHAIN_GAIN[nbCharactersFound - 1]);
                layoutOneCharacterFound.setVisibility(8);
                imageFlecheDroite.setEnabled(true);
                if (nbCharactersFound == MaxPersosToFind)
                {
                    imageFlecheDroite.setEnabled(false);
                    layoutFireworks = (RelativeLayout)findViewById(0x7f0d00d8);
                    layoutFireworks.setVisibility(0);
                    animation = (TextView)findViewById(0x7f0d00dd);
                    animation.setTypeface(tf);
                    animation.setText(TraductionFactory.sharedInstance().getTraductionFromToken("FELICITATIONS"));
                    TextView textview = (TextView)findViewById(0x7f0d00de);
                    textview.setTypeface(tf);
                    textview.setText(TraductionFactory.sharedInstance().getTraductionFromToken("TU_REMPORTES"));
                    TextView textview1 = (TextView)findViewById(0x7f0d00df);
                    textview1.setTypeface(tf);
                    textview1.setText("+1000GZ");
                    addTextView(animation);
                    addTextView(textview);
                    addTextView(textview1);
                    updateTextViewsSize();
                    animation = new AlphaAnimation(0.0F, 1.0F);
                    animation.setDuration(500L);
                    animation.setFillAfter(true);
                    animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                        final DefiDuJourActivity this$0;

                        public void onAnimationEnd(Animation animation1)
                        {
                            layoutFireworks.setOnClickListener(DefiDuJourActivity.this);
                        }

                        public void onAnimationRepeat(Animation animation1)
                        {
                        }

                        public void onAnimationStart(Animation animation1)
                        {
                        }

            
            {
                this$0 = DefiDuJourActivity.this;
                super();
            }
                    });
                    layoutFireworks.startAnimation(animation);
                    return;
                }
            }
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (mMode == 0)
        {
            if (fragmentPartage != null && fragmentPartage.isVisible())
            {
                fragmentPartage.hide();
                return;
            } else
            {
                goToHome();
                return;
            }
        } else
        {
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/PostHomeActivity));
            finish();
            return;
        }
    }

    public void onClick(View view)
    {
        if (view != partageButton) goto _L2; else goto _L1
_L1:
        BackgroundSoundsBinder.sharedInstance().playBip();
        if (android.os.Build.VERSION.SDK_INT < 23) goto _L4; else goto _L3
_L3:
        if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto _L6; else goto _L5
_L5:
        AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
        requestPermissions(new String[] {
            "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"
        }, 666);
_L8:
        return;
_L6:
        doShare();
        return;
_L4:
        doShare();
        return;
_L2:
        if (view == imageFlecheDroite)
        {
            if (mMode == 0)
            {
                startActivity(new Intent(this, com/digidust/elokence/akinator/activities/PostProposeActivity));
                finish();
                return;
            } else
            {
                startActivity(new Intent(this, com/digidust/elokence/akinator/activities/PostHomeActivity));
                finish();
                return;
            }
        }
        if (view == layoutFireworks)
        {
            layoutFireworks.setClickable(false);
            view = new AlphaAnimation(1.0F, 0.0F);
            view.setDuration(500L);
            view.setFillAfter(false);
            view.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final DefiDuJourActivity this$0;

                public void onAnimationEnd(Animation animation)
                {
                    layoutFireworks.setVisibility(8);
                    layoutFireworks.setClickable(false);
                    MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_playing", 1000);
                    AkPlayerBelongingsFactory.sharedInstance().depositGenizWithoutNotif(1000);
                    AkGameFactory.sharedInstance().setCharacterScreenshotDefi(screenShot(findViewById(0x7f0d0085)));
                    imageFlecheDroite.setEnabled(true);
                /* block-local class not found */
                class _cls1 {}

                    (new _cls1()).start();
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                this$0 = DefiDuJourActivity.this;
                super();
            }
            });
            layoutFireworks.startAnimation(view);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030020);
        ((TextView)findViewById(0x7f0d0289)).setTextColor(0xff000000);
        mainLayout = (RelativeLayout)findViewById(0x7f0d0085);
        layoutOneCharacterFound = (RelativeLayout)findViewById(0x7f0d00d6);
        imageCharacterFound = (ImageView)findViewById(0x7f0d00d7);
        mMode = getIntent().getIntExtra("keyMode", 0);
        felicitation = (TextView)findViewById(0x7f0d00d0);
        felicitation.setTypeface(tf);
        titreDefi = (TextView)findViewById(0x7f0d00cf);
        titreDefi.setTypeface(tf);
        prochainGain = (TextView)findViewById(0x7f0d00d3);
        prochainGain.setTypeface(tf);
        imageFlecheDroite = (ImageView)findViewById(0x7f0d00d2);
        imageFlecheDroite.setOnClickListener(this);
        listViewDefi = (LinearLayout)findViewById(0x7f0d00d1);
        bundle = LayoutInflater.from(this);
        partageButton = (Button)findViewById(0x7f0d00d4);
        textPourcent = (TextView)findViewById(0x7f0d00d5);
        textPourcent.setTypeface(tf);
        textPourcent.setText(TraductionFactory.sharedInstance().getTraductionFromToken("POURCENTAGE_PERSOS_DEFI"));
        addTextView(textPourcent);
        if (mMode == 0)
        {
            imageFlecheDroite.setEnabled(false);
            MetricsSetAdapter.sharedInstance().incMetricCompteur("enigmes_hits");
            felicitation.setText(TraductionFactory.sharedInstance().getTraductionFromToken("FELICITATION_PERSO_TROUVE"));
            int k = getIntent().getIntExtra("keyPersoTrouve", 0);
            DefiSetAdapter.sharedInstance().setPersoAlreadyFound(k);
            com.digidust.elokence.akinator.db.DefiSetAdapter.DefiInfos defiinfos = DefiSetAdapter.sharedInstance().getDefiInfos(true);
            titreDefi.setText(defiinfos.getTitle());
            partageButton.setOnClickListener(this);
            Bitmap bitmap = AkSessionFactory.sharedInstance().getImageDefi();
            imageCharacterFound.setImageBitmap(bitmap);
            MaxPersosToFind = defiinfos.getListPerso().size();
            int i = 0;
            while (i < MaxPersosToFind) 
            {
                com.digidust.elokence.akinator.db.DefiSetAdapter.Perso perso = (com.digidust.elokence.akinator.db.DefiSetAdapter.Perso)defiinfos.getListPerso().get(i);
                View view = bundle.inflate(0x7f030059, null);
                ImageView imageview = (ImageView)view.findViewById(0x7f0d0260);
                TextView textview1 = (TextView)view.findViewById(0x7f0d0261);
                ((ImageView)view.findViewById(0x7f0d0262)).setVisibility(8);
                if (perso.isFound())
                {
                    nbCharactersFound = nbCharactersFound + 1;
                    if (perso.getBaseId() != k)
                    {
                        try
                        {
                            byte abyte0[] = Base64.decode(perso.getPhotoBase64());
                            imageview.setImageBitmap(BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length));
                            AkLog.d("DefiDuJourActivity", (new StringBuilder()).append("ajout image ").append(perso.getBaseId()).toString());
                        }
                        catch (Base64DecoderException base64decoderexception)
                        {
                            base64decoderexception.printStackTrace();
                        }
                    } else
                    {
                        imageview.setImageBitmap(null);
                    }
                    textview1.setText((new StringBuilder()).append(perso.getName()).append(" (").append(perso.getPourcentage()).append("%)").toString());
                    textview1.setTypeface(tf);
                    addTextView(textview1);
                }
                addTextView(textview1);
                listViewDefi.addView(view);
                if (perso.getBaseId() == k)
                {
                    imageCharacterFoundIcon = imageview;
                }
                i++;
            }
            if (nbCharactersFound == MaxPersosToFind)
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("enigmes_completes");
                partageButton.setVisibility(0);
                prochainGain.setText(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TROUVE"));
                textPourcent.setVisibility(8);
            } else
            {
                partageButton.setVisibility(4);
                bundle = TraductionFactory.sharedInstance().getTraductionFromToken("PROCHAIN_GAIN");
                prochainGain.setText(bundle.replace("[NB_GENIZ]", String.valueOf(PROCHAIN_GAIN[nbCharactersFound])));
            }
            layoutOneCharacterFound.setVisibility(0);
            imageCharacterFound.setVisibility(0);
            alpha = new AlphaAnimation(0.0F, 1.0F);
            alpha.setDuration(1000L);
            alpha.setFillAfter(true);
            alpha.setAnimationListener(this);
            imageCharacterFound.startAnimation(alpha);
        } else
        {
            prochainGain.setVisibility(4);
            partageButton.setVisibility(4);
            felicitation.setVisibility(8);
            com.digidust.elokence.akinator.db.DefiSetAdapter.DefiInfos defiinfos1 = DefiSetAdapter.sharedInstance().getDefiInfos(false);
            titreDefi.setText(defiinfos1.getTitle());
            int j = 0;
            while (j < defiinfos1.getListPerso().size()) 
            {
                com.digidust.elokence.akinator.db.DefiSetAdapter.Perso perso1 = (com.digidust.elokence.akinator.db.DefiSetAdapter.Perso)defiinfos1.getListPerso().get(j);
                View view1 = bundle.inflate(0x7f030059, null);
                ImageView imageview2 = (ImageView)view1.findViewById(0x7f0d0260);
                TextView textview = (TextView)view1.findViewById(0x7f0d0261);
                ImageView imageview1 = (ImageView)view1.findViewById(0x7f0d0262);
                try
                {
                    byte abyte1[] = Base64.decode(perso1.getPhotoBase64());
                    imageview2.setImageBitmap(BitmapFactory.decodeByteArray(abyte1, 0, abyte1.length));
                }
                catch (Base64DecoderException base64decoderexception1)
                {
                    base64decoderexception1.printStackTrace();
                }
                textview.setText((new StringBuilder()).append(perso1.getName()).append(" (").append(perso1.getPourcentage()).append("%)").toString());
                textview.setTypeface(tf);
                addTextView(textview);
                if (perso1.isFound())
                {
                    imageview1.setImageResource(0x7f02016f);
                } else
                {
                    imageview1.setImageResource(0x7f02016b);
                }
                listViewDefi.addView(view1);
                j++;
            }
        }
        addTextView(felicitation);
        addTextView(titreDefi);
        addTextView(prochainGain);
        updateTextViewsSize();
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


}
