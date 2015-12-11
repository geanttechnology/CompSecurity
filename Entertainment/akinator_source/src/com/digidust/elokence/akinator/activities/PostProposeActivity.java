// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.digidust.elokence.akinator.db.AkDBAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Set;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, PartageAppsFragment, PopPedagogiqueActivity, GameOverActivity

public class PostProposeActivity extends AkActivity
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
{
    public class ProgressBarAnimation extends Animation
    {

        private float from;
        private ProgressBar progressBar;
        final PostProposeActivity this$0;
        private float to;

        protected void applyTransformation(float f, Transformation transformation)
        {
            super.applyTransformation(f, transformation);
            f = from + (to - from) * f;
            if ((int)f >= progressBar.getMax()) goto _L2; else goto _L1
_L1:
            progressBar.setProgress((int)f);
_L4:
            return;
_L2:
            int i;
            uiImageHat.startAnimation(animationHat1);
            uiPbXp.clearAnimation();
            i = uiPbXp.getMax();
            if (currentSeuil != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            currentSeuil = 3500;
            uiPbXp.setMax(16500);
_L5:
            if (currentSeuil != 0x1e8480)
            {
                transformation = PostProposeActivity.this;
                ProgressBar progressbar = uiPbXp;
                from = 0.0F;
                f = to - (float)i;
                to = f;
                transformation = transformation. new ProgressBarAnimation(progressbar, 0.0F, f);
                transformation.setDuration(1500L);
                uiPbXp.startAnimation(transformation);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (currentSeuil == 3500)
            {
                currentSeuil = 20000;
                uiPbXp.setMax(25000);
            } else
            if (currentSeuil == 20000)
            {
                currentSeuil = 45000;
                uiPbXp.setMax(45000);
            } else
            if (currentSeuil == 45000)
            {
                currentSeuil = 0x15f90;
                uiPbXp.setMax(54000);
            } else
            if (currentSeuil == 0x15f90)
            {
                currentSeuil = 0x23280;
                uiPbXp.setMax(0x4ab50);
            } else
            if (currentSeuil == 0x23280)
            {
                currentSeuil = 0x6ddd0;
                uiPbXp.setMax(0x6ddd0);
            } else
            if (currentSeuil == 0x6ddd0)
            {
                currentSeuil = 0xdbba0;
                uiPbXp.setMax(0x10c8e0);
            } else
            if (currentSeuil == 0xdbba0)
            {
                currentSeuil = 0x1e8480;
                uiPbXp.setMax(1);
                uiPbXp.setProgress(1);
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        public ProgressBarAnimation(ProgressBar progressbar, float f, float f1)
        {
            this$0 = PostProposeActivity.this;
            super();
            progressBar = progressbar;
            from = f;
            to = f1;
        }
    }


    private static final String BADGE = "[BADGE]";
    private static final String DELAY = "[DELAY]";
    private static final String DELAY2 = "[DELAY2]";
    private static final int GzBlack = 5000;
    private static final int GzBronze = 200;
    private static final int GzGold = 800;
    private static final int GzPlatinum = 1500;
    private static final int GzSilver = 400;
    private static final int GzStandard = 100;
    private static final String LEVEL = "[LEVEL]";
    private static final long Ms12Hours = 0x2932e00L;
    private static final long Ms1Day = 0x5265c00L;
    private static final long Ms1Hour = 0x36ee80L;
    private static final long Ms1Month = 0x9a7ec800L;
    private static final long Ms48Hours = 0xa4cb800L;
    private static final long Ms6Months = 0x39ef8b000L;
    private static final long Ms7Days = 0x240c8400L;
    private static final String NAME_CHARACTER = "[name_character]";
    private static final String NB_GENIZ = "[NB_GENIZ]";
    private static final String TAG = "PostProposeActivity";
    private static final int XpBlack = 9100;
    private static final int XpBronze = 728;
    private static final int XpGold = 1456;
    private static final int XpPlatinum = 2730;
    private static final int XpSilver = 1092;
    private static final int XpStandard = 182;
    private int GzToAdd;
    private int XpToAdd;
    private Animation animationHat1;
    private Animation animationHat2;
    private Animation animationImageAlpha;
    private Animation animationImageZoom;
    private Animation animationXpGz;
    private int award;
    private String awardName;
    private int awardResourceId;
    private PartageAppsFragment fragmentPartage;
    android.view.View.OnClickListener mPartageButtonClickListener;
    private ImageView uiImageAward;
    private ImageView uiImageFlecheDroite;
    private LinearLayout uiLayoutGzPlus;
    private LinearLayout uiLayoutShareButtonsGO;
    private LinearLayout uiLayoutWhatIsAkiAward;
    private LinearLayout uiLayoutXpPlus;
    private Button uiPartageButton;
    private TextView uiTextAwardInfo;
    private TextView uiTextAwardPart1;
    private TextView uiTextAwardPart2;
    private TextView uiTextGzWon;
    private TextView uiTextXpWon;

    public PostProposeActivity()
    {
        fragmentPartage = null;
        award = -1;
        mPartageButtonClickListener = new android.view.View.OnClickListener() {

            final PostProposeActivity this$0;

            public void onClick(View view)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                if (android.os.Build.VERSION.SDK_INT >= 23)
                {
                    if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
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

            
            {
                this$0 = PostProposeActivity.this;
                super();
            }
        };
    }

    private void createSharingImage()
    {
        Object obj1;
        Bitmap bitmap;
        Canvas canvas;
        bitmap = Bitmap.createBitmap(AkGameFactory.sharedInstance().getCharacterScreenshot());
        canvas = new Canvas(bitmap);
        obj1 = null;
        if (award != 4) goto _L2; else goto _L1
_L1:
        Object obj;
        Paint paint;
        int i;
        int j;
        int k;
        int l;
        try
        {
            obj = getAssets().open("drawable/tambonGold.png");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            obj = obj1;
        }
_L4:
        obj1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        (new Canvas(((Bitmap) (obj1)))).drawColor(-1);
        paint = new Paint();
        paint.setAlpha(128);
        canvas.drawBitmap(((Bitmap) (obj1)), 0.0F, 0.0F, paint);
        obj = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(((java.io.InputStream) (obj))), (int)getResources().getDimension(0x7f09002f), (int)getResources().getDimension(0x7f09002d), true);
        i = ((Bitmap) (obj)).getWidth();
        j = ((Bitmap) (obj)).getHeight();
        k = i / 2;
        l = j / 2;
        obj1 = new Matrix();
        ((Matrix) (obj1)).setRotate(-30F, k, l);
        obj = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, i, j, ((Matrix) (obj1)), true);
        canvas.drawBitmap(((Bitmap) (obj)), (float)(bitmap.getWidth() - ((Bitmap) (obj)).getWidth()) / 2.0F, (float)(bitmap.getHeight() - ((Bitmap) (obj)).getHeight()) / 2.0F, null);
        AkGameFactory.sharedInstance().canShareAwardImage(true);
        AkGameFactory.sharedInstance().setCharacterScreenshotWithAward(bitmap);
        return;
_L2:
        if (award == 5)
        {
            try
            {
                obj = getAssets().open("drawable/tamponPlatinum.png");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                obj = obj1;
            }
        } else
        {
            obj = obj1;
            if (award == 6)
            {
                try
                {
                    obj = getAssets().open("drawable/tamponBlack.png");
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    exception = ((Exception) (obj1));
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void doShare()
    {
        Object obj;
        Object obj1;
        Object obj2;
        FileOutputStream fileoutputstream;
        try
        {
            disableAdOneTime();
            obj = TraductionFactory.sharedInstance().getTraductionFromToken("TWEET_POSTPROPOSE").replace("[LEVEL]", awardName).replace("[name_character]", SessionFactory.sharedInstance().getSession().getCurrentProposedObject().getName());
            obj = (new StringBuilder()).append(((String) (obj))).append(" ").append(getResources().getString(0x7f07005f)).toString();
            obj1 = AkGameFactory.sharedInstance().getCharacterScreenshotWithAward();
            obj2 = new Canvas(((Bitmap) (obj1)));
            Paint paint = new Paint();
            paint.setColor(0xff00ff00);
            ((Canvas) (obj2)).drawRect(0.0F, 0.0F, 10F, 10F, paint);
            obj2 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/temp").toString());
            if (!((File) (obj2)).exists())
            {
                ((File) (obj2)).mkdirs();
            }
            obj2 = new File(((File) (obj2)), "tempAward.jpg");
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        fileoutputstream = new FileOutputStream(((File) (obj2)));
        ((Bitmap) (obj1)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, fileoutputstream);
        fileoutputstream.flush();
        fileoutputstream.close();
        obj2 = Uri.fromFile(((File) (obj2)));
        obj1 = new Intent();
        ((Intent) (obj1)).setAction("android.intent.action.SEND");
        ((Intent) (obj1)).putExtra("android.intent.extra.TEXT", ((String) (obj)));
        ((Intent) (obj1)).setType("image/jpeg");
        ((Intent) (obj1)).putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) (obj2)));
        obj = getPackageManager().queryIntentActivities(((Intent) (obj1)), 0);
        fragmentPartage = new PartageAppsFragment();
        fragmentPartage.setPartageIndex(2);
        fragmentPartage.build(((Intent) (obj1)), ((java.util.List) (obj)));
        obj = getFragmentManager().beginTransaction();
        ((FragmentTransaction) (obj)).add(0x7f0d00e0, fragmentPartage);
        ((FragmentTransaction) (obj)).commit();
    }

    private String getDaysPlayedFrom(long l)
    {
        String s = TraductionFactory.sharedInstance().getTraductionFromToken("DERNIER_AWARD_REMPORTE_PAR_JOUR");
        double d = (double)l / 86400000D;
        l = (long)((d - (double)(long)d) * 24D);
        return s.replace("[DELAY]", Long.toString((long)d)).replace("[DELAY2]", Long.toString(l));
    }

    private String getHoursPlayedFrom(long l)
    {
        return TraductionFactory.sharedInstance().getTraductionFromToken("DERNIER_AWARD_REMPORTE_PAR_HEURE").replace("[DELAY]", Long.toString(l / 0x36ee80L));
    }

    private String getMinPlayedFrom(long l)
    {
        return TraductionFactory.sharedInstance().getTraductionFromToken("DERNIER_AWARD_REMPORTE_PAR_MINUTE").replace("[DELAY]", Long.toString(l / 60000L));
    }

    private String getMonthsPlayedFrom(long l)
    {
        String s = TraductionFactory.sharedInstance().getTraductionFromToken("DERNIER_AWARD_REMPORTE_PAR_MOIS");
        double d = (double)l / 2592000000D;
        l = (long)((d - (double)(long)d) * 30D);
        return s.replace("[DELAY]", Long.toString((long)d)).replace("[DELAY2]", Long.toString(l));
    }

    public void onAnimationEnd(Animation animation)
    {
        if (animation != animationImageZoom) goto _L2; else goto _L1
_L1:
        uiLayoutGzPlus.startAnimation(animationXpGz);
        uiLayoutXpPlus.startAnimation(animationXpGz);
        if (AkPlayerBelongingsFactory.sharedInstance().getXp() < 0x1e8480)
        {
            animation = new ProgressBarAnimation(uiPbXp, uiPbXp.getProgress(), uiPbXp.getProgress() + XpToAdd);
            animation.setDuration(1500L);
            uiPbXp.startAnimation(animation);
        }
        AkPlayerBelongingsFactory.sharedInstance().depositGenizWithoutNotif(GzToAdd);
        AkPlayerBelongingsFactory.sharedInstance().addXp(XpToAdd);
        BackgroundSoundsBinder.sharedInstance().playGzSound(award);
        if (AccessToken.getCurrentAccessToken() != null && AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions"))
        {
            sendMyScore();
        }
        uiImageFlecheDroite.setEnabled(true);
_L4:
        return;
_L2:
        if (animation == animationXpGz)
        {
            uiLayoutGzPlus.setVisibility(8);
            uiLayoutXpPlus.setVisibility(8);
            return;
        }
        if (animation != animationHat1) goto _L4; else goto _L3
_L3:
        int i = AkPlayerBelongingsFactory.sharedInstance().getXp();
        if (i >= 3500) goto _L6; else goto _L5
_L5:
        uiImageHat.setImageResource(0x7f020284);
_L8:
        uiImageHat.startAnimation(animationHat2);
        return;
_L6:
        if (i >= 3500 && i < 20000)
        {
            uiImageHat.setImageResource(0x7f02028c);
        } else
        if (i >= 20000 && i < 45000)
        {
            uiImageHat.setImageResource(0x7f020298);
        } else
        if (i >= 45000 && i < 0x15f90)
        {
            uiImageHat.setImageResource(0x7f0202a0);
        } else
        if (i >= 0x15f90 && i < 0x23280)
        {
            uiImageHat.setImageResource(0x7f020288);
        } else
        if (i >= 0x23280 && i < 0x6ddd0)
        {
            uiImageHat.setImageResource(0x7f0202a4);
        } else
        if (i >= 0x6ddd0 && i < 0xdbba0)
        {
            uiImageHat.setImageResource(0x7f020290);
        } else
        if (i >= 0xdbba0 && i < 0x1e8480)
        {
            uiImageHat.setImageResource(0x7f020294);
        } else
        if (i >= 0x1e8480)
        {
            uiImageHat.setImageResource(0x7f02029c);
        }
        if (true) goto _L8; else goto _L7
_L7:
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
        if (fragmentPartage != null && fragmentPartage.isVisible())
        {
            fragmentPartage.hide();
            return;
        } else
        {
            goToHome();
            return;
        }
    }

    public void onClick(View view)
    {
        if (view == uiLayoutWhatIsAkiAward)
        {
            disableAdOneTime();
            view = new Intent(this, com/digidust/elokence/akinator/activities/PopPedagogiqueActivity);
            view.putExtra("PostPedagogiqueActivityModeGz", false);
            startActivity(view);
        } else
        if (view == uiImageFlecheDroite)
        {
            view = new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity);
            view.putExtra("ShowAdOnHome", true);
            AkGameFactory.sharedInstance().setGameOverActivityState(1);
            startActivity(view);
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        Object obj3;
        com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase proposedlimuleobjectminibase;
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        }
        setContentView(0x7f03002d);
        obj = null;
        obj3 = null;
        uiLayoutGzPlus = (LinearLayout)findViewById(0x7f0d0174);
        uiTextGzWon = (TextView)findViewById(0x7f0d0175);
        uiLayoutXpPlus = (LinearLayout)findViewById(0x7f0d0176);
        uiTextXpWon = (TextView)findViewById(0x7f0d0177);
        uiImageAward = (ImageView)findViewById(0x7f0d017a);
        uiLayoutWhatIsAkiAward = (LinearLayout)findViewById(0x7f0d017b);
        uiTextAwardPart1 = (TextView)findViewById(0x7f0d017d);
        uiTextAwardPart2 = (TextView)findViewById(0x7f0d017e);
        uiTextAwardInfo = (TextView)findViewById(0x7f0d017f);
        uiImageFlecheDroite = (ImageView)findViewById(0x7f0d00d2);
        uiPartageButton = (Button)findViewById(0x7f0d00d4);
        uiLayoutShareButtonsGO = (LinearLayout)findViewById(0x7f0d0178);
        animationImageZoom = AnimationUtils.loadAnimation(this, 0x7f04000e);
        animationImageZoom.setAnimationListener(this);
        animationImageAlpha = AnimationUtils.loadAnimation(this, 0x7f04000a);
        animationImageAlpha.setAnimationListener(this);
        animationXpGz = AnimationUtils.loadAnimation(this, 0x7f04000d);
        animationXpGz.setAnimationListener(this);
        animationHat1 = AnimationUtils.loadAnimation(this, 0x7f04000b);
        animationHat1.setAnimationListener(this);
        animationHat2 = AnimationUtils.loadAnimation(this, 0x7f04000c);
        animationHat2.setAnimationListener(this);
        proposedlimuleobjectminibase = (com.elokence.limuleapi.Session.ProposedLimuleObjectMinibase)SessionFactory.sharedInstance().getSession().getCurrentProposedObject();
        if (proposedlimuleobjectminibase == null || proposedlimuleobjectminibase.getElementMinibaseId() != -1) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag2;
        flag2 = AkGameFactory.sharedInstance().winFirstTry();
        flag1 = false;
        bundle = new AkDBAdapter(this);
        boolean flag = bundle.isAwardAlreadyWonForCharacter(TraductionFactory.sharedInstance().getApplicationLanguage(), proposedlimuleobjectminibase.getIdBase());
        obj = bundle;
        flag1 = flag;
        if (bundle != null)
        {
            bundle.close();
            flag1 = flag;
            obj = bundle;
        }
_L5:
        if (!flag1) goto _L4; else goto _L3
_L3:
        uiPartageButton.setVisibility(4);
        bundle = uiImageAward;
        awardResourceId = 0x7f02006e;
        bundle.setImageResource(0x7f02006e);
        uiTextAwardPart1.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AWARD_DEJA_OBTENU"));
        uiLayoutGzPlus.setVisibility(8);
        uiLayoutXpPlus.setVisibility(8);
        uiTextAwardPart2.setText(null);
_L2:
        uiTextAwardInfo.setText(TraductionFactory.sharedInstance().getTraductionFromToken("AKI_AWARD_EN_SAVOIR_PLUS"));
        uiTextGzWon.setTypeface(tf);
        uiTextXpWon.setTypeface(tf);
        uiTextAwardPart1.setTypeface(tf);
        uiTextAwardPart2.setTypeface(tf);
        uiTextAwardInfo.setTypeface(tf);
        addTextView(uiTextGzWon);
        addTextView(uiTextXpWon);
        addTextView(uiTextAwardPart1);
        addTextView(uiTextAwardPart2);
        addTextView(uiTextAwardInfo);
        updateTextViewsSize();
        uiLayoutWhatIsAkiAward.setOnClickListener(this);
        uiImageFlecheDroite.setOnClickListener(this);
        return;
        Object obj1;
        obj1;
        bundle = obj3;
_L11:
        obj = bundle;
        ((Exception) (obj1)).printStackTrace();
        Object obj2;
        if (bundle != null)
        {
            bundle.close();
            obj = bundle;
        } else
        {
            obj = bundle;
        }
          goto _L5
        bundle;
_L10:
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
        throw bundle;
_L4:
        long l = (long)SessionFactory.sharedInstance().getSession().getCurrentStats().getDelayAward() * 60000L;
        AkLog.i("PostProposeActivity", (new StringBuilder()).append("Character not played since ").append(l).append(" Ms").toString());
        if (flag2)
        {
            if (proposedlimuleobjectminibase.getIdBase() == AkGameFactory.sharedInstance().getLastIdBasePlayed())
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("badges_quest");
            }
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("FELICITATIONS_AWARD_GAGNE");
            obj2 = String.format("#%06X", new Object[] {
                Integer.valueOf(0xffffff & getResources().getColor(0x7f0c0066))
            });
            obj2 = bundle.replace("[NB_GENIZ]", (new StringBuilder()).append("<font color='").append(((String) (obj2))).append("'>").append("[NB_GENIZ]").append("</font>").toString());
            uiPartageButton.setOnClickListener(mPartageButtonClickListener);
        } else
        {
            obj2 = TraductionFactory.sharedInstance().getTraductionFromToken("AWARD_A_OBTENIR");
            uiPartageButton.setVisibility(4);
        }
        uiTextAwardPart2.setText(null);
        if (l <= 0x2932e00L)
        {
            bundle = uiImageAward;
            awardResourceId = 0x7f020082;
            bundle.setImageResource(0x7f020082);
            award = 1;
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("STANDARD_TITRE");
            awardName = bundle;
            obj2 = ((String) (obj2)).replace("[BADGE]", bundle);
            bundle = ((Bundle) (obj2));
            if (flag2)
            {
                bundle = ((String) (obj2)).replace("[NB_GENIZ]", Integer.toString(100));
                obj2 = uiTextGzWon;
                StringBuilder stringbuilder = (new StringBuilder()).append("+ ");
                NumberFormat numberformat = NumberFormat.getInstance();
                GzToAdd = 100;
                ((TextView) (obj2)).setText(stringbuilder.append(numberformat.format(100)).toString());
                obj2 = uiTextXpWon;
                stringbuilder = (new StringBuilder()).append("+ ");
                numberformat = NumberFormat.getInstance();
                XpToAdd = 182;
                ((TextView) (obj2)).setText(stringbuilder.append(numberformat.format(182)).toString());
                if (l < 0x36ee80L)
                {
                    uiTextAwardPart2.setText(getMinPlayedFrom(l));
                } else
                {
                    uiTextAwardPart2.setText(getHoursPlayedFrom(l));
                }
            }
        } else
        if (l > 0x2932e00L && l <= 0xa4cb800L)
        {
            bundle = uiImageAward;
            awardResourceId = 0x7f02006a;
            bundle.setImageResource(0x7f02006a);
            award = 2;
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("BRONZE_TITRE");
            awardName = bundle;
            obj2 = ((String) (obj2)).replace("[BADGE]", bundle);
            bundle = ((Bundle) (obj2));
            if (flag2)
            {
                bundle = ((String) (obj2)).replace("[NB_GENIZ]", Integer.toString(200));
                obj2 = uiTextGzWon;
                StringBuilder stringbuilder1 = (new StringBuilder()).append("+ ");
                NumberFormat numberformat1 = NumberFormat.getInstance();
                GzToAdd = 200;
                ((TextView) (obj2)).setText(stringbuilder1.append(numberformat1.format(200)).toString());
                obj2 = uiTextXpWon;
                stringbuilder1 = (new StringBuilder()).append("+ ");
                numberformat1 = NumberFormat.getInstance();
                XpToAdd = 728;
                ((TextView) (obj2)).setText(stringbuilder1.append(numberformat1.format(728)).toString());
                uiTextAwardPart2.setText(getHoursPlayedFrom(l));
            }
        } else
        if (l > 0xa4cb800L && l <= 0x240c8400L)
        {
            bundle = uiImageAward;
            awardResourceId = 0x7f02007e;
            bundle.setImageResource(0x7f02007e);
            award = 3;
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("SILVER_TITRE");
            awardName = bundle;
            obj2 = ((String) (obj2)).replace("[BADGE]", bundle);
            bundle = ((Bundle) (obj2));
            if (flag2)
            {
                bundle = ((String) (obj2)).replace("[NB_GENIZ]", Integer.toString(400));
                obj2 = uiTextGzWon;
                StringBuilder stringbuilder2 = (new StringBuilder()).append("+ ");
                NumberFormat numberformat2 = NumberFormat.getInstance();
                GzToAdd = 400;
                ((TextView) (obj2)).setText(stringbuilder2.append(numberformat2.format(400)).toString());
                obj2 = uiTextXpWon;
                stringbuilder2 = (new StringBuilder()).append("+ ");
                numberformat2 = NumberFormat.getInstance();
                XpToAdd = 1092;
                ((TextView) (obj2)).setText(stringbuilder2.append(numberformat2.format(1092)).toString());
                uiTextAwardPart2.setText(getDaysPlayedFrom(l));
            }
        } else
        if (l > 0x240c8400L && l <= 0x9a7ec800L)
        {
            bundle = uiImageAward;
            awardResourceId = 0x7f020072;
            bundle.setImageResource(0x7f020072);
            award = 4;
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("GOLD_TITRE");
            awardName = bundle;
            obj2 = ((String) (obj2)).replace("[BADGE]", bundle);
            bundle = ((Bundle) (obj2));
            if (flag2)
            {
                uiLayoutShareButtonsGO.setVisibility(0);
                bundle = ((String) (obj2)).replace("[NB_GENIZ]", Integer.toString(800));
                obj2 = uiTextGzWon;
                StringBuilder stringbuilder3 = (new StringBuilder()).append("+ ");
                NumberFormat numberformat3 = NumberFormat.getInstance();
                GzToAdd = 800;
                ((TextView) (obj2)).setText(stringbuilder3.append(numberformat3.format(800)).toString());
                obj2 = uiTextXpWon;
                stringbuilder3 = (new StringBuilder()).append("+ ");
                numberformat3 = NumberFormat.getInstance();
                XpToAdd = 1456;
                ((TextView) (obj2)).setText(stringbuilder3.append(numberformat3.format(1456)).toString());
                uiTextAwardPart2.setText(getDaysPlayedFrom(l));
                createSharingImage();
            }
        } else
        if (l > 0x9a7ec800L && l <= 0x39ef8b000L)
        {
            bundle = uiImageAward;
            awardResourceId = 0x7f020076;
            bundle.setImageResource(0x7f020076);
            award = 5;
            bundle = TraductionFactory.sharedInstance().getTraductionFromToken("PLATINUM_TITRE");
            awardName = bundle;
            obj2 = ((String) (obj2)).replace("[BADGE]", bundle);
            bundle = ((Bundle) (obj2));
            if (flag2)
            {
                uiLayoutShareButtonsGO.setVisibility(0);
                bundle = ((String) (obj2)).replace("[NB_GENIZ]", Integer.toString(1500));
                obj2 = uiTextGzWon;
                StringBuilder stringbuilder4 = (new StringBuilder()).append("+ ");
                NumberFormat numberformat4 = NumberFormat.getInstance();
                GzToAdd = 1500;
                ((TextView) (obj2)).setText(stringbuilder4.append(numberformat4.format(1500)).toString());
                obj2 = uiTextXpWon;
                stringbuilder4 = (new StringBuilder()).append("+ ");
                numberformat4 = NumberFormat.getInstance();
                XpToAdd = 2730;
                ((TextView) (obj2)).setText(stringbuilder4.append(numberformat4.format(2730)).toString());
                uiTextAwardPart2.setText(getMonthsPlayedFrom(l));
                createSharingImage();
            }
        } else
        {
            bundle = ((Bundle) (obj2));
            if (l > 0x39ef8b000L)
            {
                bundle = uiImageAward;
                awardResourceId = 0x7f020066;
                bundle.setImageResource(0x7f020066);
                award = 6;
                bundle = TraductionFactory.sharedInstance().getTraductionFromToken("BLACK_TITRE");
                awardName = bundle;
                obj2 = ((String) (obj2)).replace("[BADGE]", bundle);
                bundle = ((Bundle) (obj2));
                if (flag2)
                {
                    uiLayoutShareButtonsGO.setVisibility(0);
                    bundle = ((String) (obj2)).replace("[NB_GENIZ]", Integer.toString(5000));
                    obj2 = uiTextGzWon;
                    StringBuilder stringbuilder5 = (new StringBuilder()).append("+ ");
                    NumberFormat numberformat5 = NumberFormat.getInstance();
                    GzToAdd = 5000;
                    ((TextView) (obj2)).setText(stringbuilder5.append(numberformat5.format(5000)).toString());
                    obj2 = uiTextXpWon;
                    stringbuilder5 = (new StringBuilder()).append("+ ");
                    numberformat5 = NumberFormat.getInstance();
                    XpToAdd = 9100;
                    ((TextView) (obj2)).setText(stringbuilder5.append(numberformat5.format(9100)).toString());
                    uiTextAwardPart2.setText(getMonthsPlayedFrom(l));
                    createSharingImage();
                }
            }
        }
        MetricsSetAdapter.sharedInstance().createOrUpdateMetricCompteur("gz_gain_playing", GzToAdd);
        uiTextAwardPart1.setText(Html.fromHtml(bundle));
        if (!flag2) goto _L7; else goto _L6
_L6:
        uiImageFlecheDroite.setEnabled(false);
        uiImageAward.startAnimation(animationImageZoom);
        obj2 = new AkDBAdapter(this);
        bundle = ((Bundle) (obj2));
        ((AkDBAdapter) (obj2)).addCharacter(TraductionFactory.sharedInstance().getApplicationLanguage(), proposedlimuleobjectminibase.getIdBase(), award, proposedlimuleobjectminibase.getName(), proposedlimuleobjectminibase.getDescription());
        if (obj2 != null)
        {
            ((AkDBAdapter) (obj2)).close();
        }
          goto _L2
        obj2;
_L9:
        bundle = ((Bundle) (obj));
        ((Exception) (obj2)).printStackTrace();
        if (obj != null)
        {
            ((AkDBAdapter) (obj)).close();
        }
          goto _L2
        obj2;
        bundle = ((Bundle) (obj));
_L8:
        if (bundle != null)
        {
            bundle.close();
        }
        throw obj2;
_L7:
        uiImageAward.startAnimation(animationImageAlpha);
        uiLayoutGzPlus.setVisibility(8);
        uiLayoutXpPlus.setVisibility(8);
          goto _L2
        obj2;
          goto _L8
        bundle;
        obj = obj2;
        obj2 = bundle;
          goto _L9
        obj2;
        obj = bundle;
        bundle = ((Bundle) (obj2));
          goto _L10
        obj2;
          goto _L11
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
