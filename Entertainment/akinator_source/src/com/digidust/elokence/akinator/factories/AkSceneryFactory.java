// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkLog, AkApplication

public class AkSceneryFactory
{
    public static class BackgroundSet
    {

        public ArrayList background1;
        public ArrayList background2;
        public ArrayList background3;
        public Bitmap star;

        public BackgroundSet()
        {
            background1 = new ArrayList();
            background2 = new ArrayList();
            background3 = new ArrayList();
            star = null;
        }
    }


    private static final String AKIFOLDER = "apoils";
    public static final String AKINATOR_CONCENTRATION_INTENSE = "akinator_concentration_intense";
    public static final String AKINATOR_CONFIANT = "akinator_confiant";
    public static final String AKINATOR_DECEPTION = "akinator_deception";
    public static final String AKINATOR_DEFI = "akinator_defi";
    public static final String AKINATOR_ETONNEMENT = "akinator_etonnement";
    public static final String AKINATOR_INSPIRATION_FORTE = "akinator_inspiration_forte";
    public static final String AKINATOR_INSPIRATION_LEGERE = "akinator_inspiration_legere";
    public static final String AKINATOR_LEGER_DECOURAGEMENT = "akinator_leger_decouragement";
    public static final String AKINATOR_MOBILE = "akinator_mobile";
    public static final String AKINATOR_SEREIN = "akinator_serein";
    public static final String AKINATOR_SURPRISE = "akinator_surprise";
    public static final String AKINATOR_TENSION = "akinator_tension";
    public static final String AKINATOR_TRIOMPHE = "akinator_triomphe";
    public static final String AKINATOR_VRAI_DECOURAGEMENT = "akinator_vrai_decouragement";
    private static final String BACKGROUNDSFOLDER = "backgrounds";
    private static final String BASEURL = "http://assets-mobile.akinator.com/";
    private static final String BASEURL2 = "http://assets-mobile2.akinator.com/";
    private static final String CLOTHESFOLDER = "tenues";
    private static final String HATSFOLDER = "chapeaux";
    public static final int LOAD_ERROR_NOT_FOUND = 404;
    public static final int LOAD_ERROR_NO_NETWORK = 1;
    public static final int LOAD_ERROR_OTHER = 2;
    public static final int LOAD_OK = 0;
    private static AkSceneryFactory _instance = null;
    private static final String akitudes[] = {
        "akinator_concentration_intense", "akinator_confiant", "akinator_deception", "akinator_defi", "akinator_etonnement", "akinator_inspiration_forte", "akinator_inspiration_legere", "akinator_leger_decouragement", "akinator_mobile", "akinator_serein", 
        "akinator_surprise", "akinator_tension", "akinator_triomphe", "akinator_vrai_decouragement"
    };
    private int maxMemory;
    private int screenWidth;

    private AkSceneryFactory()
    {
        screenWidth = 512;
        maxMemory = 48;
    }

    private int downloadFile(String s, File file, String s1)
    {
        int i;
        long l;
        try
        {
            s = new URL(s);
            URLConnection urlconnection = s.openConnection();
            urlconnection.setConnectTimeout(5000);
            urlconnection.connect();
            urlconnection.getContentLength();
            s = new BufferedInputStream(s.openStream(), 8192);
            file = new FileOutputStream(new File(file, s1));
            s1 = new byte[1024];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 2;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 404;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 2;
        }
        l = 0L;
        i = s.read(s1);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        l += i;
        file.write(s1, 0, i);
        break MISSING_BLOCK_LABEL_75;
        file.flush();
        file.close();
        s.close();
        return 0;
    }

    private int downloadFileWithFallback(String s, File file, String s1)
    {
        AkLog.d("AkSceneryFactory", (new StringBuilder()).append("Download http://assets-mobile.akinator.com/").append(s).toString());
        int i = downloadFile((new StringBuilder()).append("http://assets-mobile.akinator.com/").append(s).toString(), file, s1);
        if (i != 0)
        {
            AkLog.d("AkSceneryFactory", (new StringBuilder()).append("Download http://assets-mobile2.akinator.com/").append(s).toString());
            int j = downloadFile((new StringBuilder()).append("http://assets-mobile2.akinator.com/").append(s).toString(), file, s1);
            if (j != 0)
            {
                while (i == 1 || i == 404 && j == 404) 
                {
                    return i;
                }
                return 2;
            } else
            {
                return 0;
            }
        } else
        {
            return 0;
        }
    }

    private String getDimsClass()
    {
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            return "512/";
        }
        if (screenWidth > 1081 && maxMemory > 144)
        {
            return "1200/";
        }
        if (screenWidth > 600 && maxMemory > 96)
        {
            return "800/";
        } else
        {
            return "512/";
        }
    }

    public static AkSceneryFactory sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new AkSceneryFactory();
        }
        return _instance;
    }

    public Bitmap getAkiBitmap(String s)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        return BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("apoils", 0)).append("/").append(s).append(".png").toString(), options);
    }

    public BackgroundSet getBackgroundSet(String s)
    {
        BackgroundSet backgroundset = new BackgroundSet();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        for (int i = 1; i <= 6; i++)
        {
            Bitmap bitmap2 = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_").append(s).append("_plan1").append(i).append(".png").toString(), options);
            Bitmap bitmap = bitmap2;
            if (bitmap2 == null)
            {
                bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_orient_plan1").append(i).append(".png").toString(), options);
            }
            backgroundset.background1.add(bitmap);
        }

        Bitmap bitmap3 = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_").append(s).append("_plan2.png").toString(), options);
        Bitmap bitmap1 = bitmap3;
        if (bitmap3 == null)
        {
            bitmap1 = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_orient_plan2.png").toString(), options);
        }
        backgroundset.background2.add(bitmap1);
        bitmap3 = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_").append(s).append("_plan3.png").toString(), options);
        bitmap1 = bitmap3;
        if (bitmap3 == null)
        {
            bitmap1 = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_orient_plan3.png").toString(), options);
        }
        backgroundset.background3.add(bitmap1);
        bitmap1 = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_").append(s).append("_star.png").toString(), options);
        s = bitmap1;
        if (bitmap1 == null)
        {
            s = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0)).append("/ak_decor_orient_star.png").toString(), options);
        }
        backgroundset.star = s;
        return backgroundset;
    }

    public Bitmap getClothBitmap(String s, String s1)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        Bitmap bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("tenues", 0)).append("/").append(s1).append("_").append(s).append(".png").toString(), options);
        s = bitmap;
        if (bitmap == null)
        {
            s = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("tenues", 0)).append("/").append(s1).append("_orient.png").toString(), options);
        }
        return s;
    }

    public ArrayList getGraduationsBitmaps()
    {
        ArrayList arraylist;
        android.graphics.BitmapFactory.Options options;
        Context context;
        int i;
        options = new android.graphics.BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        context = AkApplication.getAppContext();
        arraylist = new ArrayList();
        i = 1;
_L2:
        Object obj;
        obj = arraylist;
        if (i > 6)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (new StringBuilder()).append("drawable/").append(getDimsClass()).append("graduations").append(i).append(".png").toString();
        arraylist.add(BitmapFactory.decodeStream(new BufferedInputStream(context.getAssets().open(((String) (obj))), 32768), null, options));
        i++;
        if (true) goto _L2; else goto _L1
        obj;
        obj = null;
_L1:
        return ((ArrayList) (obj));
    }

    public Bitmap getHatBitmap(String s, String s1)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        Bitmap bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("chapeaux", 0)).append("/").append(s1).append("_chapeau_").append(s).append(".png").toString(), options);
        s = bitmap;
        if (bitmap == null)
        {
            s = BitmapFactory.decodeFile((new StringBuilder()).append(AkApplication.getAppContext().getDir("chapeaux", 0)).append("/").append(s1).append("_chapeau_turban.png").toString(), options);
        }
        return s;
    }

    public boolean initDefault(int i)
    {
        updateScreenWidth(i);
        Context context = AkApplication.getAppContext();
        String as[];
        Object obj;
        byte abyte0[];
        Object obj1;
        Object obj2;
        byte abyte1[];
        Object obj3;
        int j;
        int k;
        long l;
        try
        {
            as = akitudes;
            j = as.length;
        }
        catch (Exception exception)
        {
            return false;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = as[i];
        obj = (new StringBuilder()).append(((String) (obj1))).append("_orient.png").toString();
        obj2 = new BufferedInputStream(context.getAssets().open((new StringBuilder()).append("drawable/").append(getDimsClass()).append("tenues/").append(((String) (obj))).toString()), 32768);
        obj3 = new FileOutputStream(new File(AkApplication.getAppContext().getDir("tenues", 0), ((String) (obj))));
        abyte0 = new byte[1024];
        l = 0L;
_L1:
        k = ((InputStream) (obj2)).read(abyte0);
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        l += k;
        ((OutputStream) (obj3)).write(abyte0, 0, k);
          goto _L1
        ((OutputStream) (obj3)).flush();
        ((OutputStream) (obj3)).close();
        ((InputStream) (obj2)).close();
        obj3 = (new StringBuilder()).append(((String) (obj1))).append("_chapeau_turban.png").toString();
        obj2 = new BufferedInputStream(context.getAssets().open((new StringBuilder()).append("drawable/").append(getDimsClass()).append("chapeaux/").append(((String) (obj3))).toString()), 32768);
        obj3 = new FileOutputStream(new File(AkApplication.getAppContext().getDir("chapeaux", 0), ((String) (obj3))));
        l = 0L;
_L2:
        k = ((InputStream) (obj2)).read(abyte0);
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        l += k;
        ((OutputStream) (obj3)).write(abyte0, 0, k);
          goto _L2
        ((OutputStream) (obj3)).flush();
        ((OutputStream) (obj3)).close();
        ((InputStream) (obj2)).close();
        obj2 = (new StringBuilder()).append(((String) (obj1))).append(".png").toString();
        obj1 = new BufferedInputStream(context.getAssets().open((new StringBuilder()).append("drawable/").append(getDimsClass()).append(((String) (obj2))).toString()), 32768);
        obj2 = new FileOutputStream(new File(AkApplication.getAppContext().getDir("apoils", 0), ((String) (obj2))));
        l = 0L;
_L3:
        k = ((InputStream) (obj1)).read(abyte0);
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_486;
        }
        l += k;
        ((OutputStream) (obj2)).write(abyte0, 0, k);
          goto _L3
        ((OutputStream) (obj2)).flush();
        ((OutputStream) (obj2)).close();
        ((InputStream) (obj1)).close();
        i++;
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_19;
_L4:
        as = new String[9];
        as[0] = "ak_decor_orient_plan11.png";
        as[1] = "ak_decor_orient_plan12.png";
        as[2] = "ak_decor_orient_plan13.png";
        as[3] = "ak_decor_orient_plan14.png";
        as[4] = "ak_decor_orient_plan15.png";
        as[5] = "ak_decor_orient_plan16.png";
        as[6] = "ak_decor_orient_plan2.png";
        as[7] = "ak_decor_orient_plan3.png";
        as[8] = "ak_decor_orient_star.png";
        j = as.length;
        i = 0;
_L8:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = as[i];
        abyte0 = new BufferedInputStream(context.getAssets().open((new StringBuilder()).append("drawable/").append(getDimsClass()).append(((String) (obj1))).toString()), 32768);
        obj1 = new FileOutputStream(new File(AkApplication.getAppContext().getDir("backgrounds", 0), ((String) (obj1))));
        abyte1 = new byte[1024];
        l = 0L;
_L6:
        k = abyte0.read(abyte1);
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_708;
        }
        l += k;
        ((OutputStream) (obj1)).write(abyte1, 0, k);
          goto _L6
        ((OutputStream) (obj1)).flush();
        ((OutputStream) (obj1)).close();
        abyte0.close();
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        return true;
    }

    public boolean isBackgroundLoaded(String s)
    {
        return (new File((new StringBuilder()).append(AkApplication.getAppContext().getDir("backgrounds", 0).toString()).append("/ak_decor_").append(s).append("_star.png").toString())).exists();
    }

    public boolean isHatLoaded(String s)
    {
        return (new File((new StringBuilder()).append(AkApplication.getAppContext().getDir("chapeaux", 0).toString()).append("/akinator_vrai_decouragement_chapeau_").append(s).append(".png").toString())).exists();
    }

    public boolean isTenueLoaded(String s)
    {
        return (new File((new StringBuilder()).append(AkApplication.getAppContext().getDir("tenues", 0).toString()).append("/akinator_vrai_decouragement_").append(s).append(".png").toString())).exists();
    }

    public int loadBackgroundSet(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = loadBackgroundSet(s, null);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public int loadBackgroundSet(String s, LoadListener loadlistener)
    {
        this;
        JVM INSTR monitorenter ;
        int i = 1;
_L10:
        if (i > 6) goto _L2; else goto _L1
_L1:
        int j;
        String s1 = (new StringBuilder()).append("ak_decor_").append(s).append("_plan1").append(i).append(".png").toString();
        j = downloadFileWithFallback((new StringBuilder()).append(getDimsClass()).append("backgrounds").append("/").append(s1).toString(), AkApplication.getAppContext().getDir("backgrounds", 0), s1);
        if (j == 0) goto _L4; else goto _L3
_L3:
        i = j;
_L6:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        if (loadlistener == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
    /* block-local class not found */
    class LoadListener {}

        loadlistener.onLoadingProgress(i, 9);
        break MISSING_BLOCK_LABEL_429;
_L2:
        String s2 = (new StringBuilder()).append("ak_decor_").append(s).append("_plan2.png").toString();
        j = downloadFileWithFallback((new StringBuilder()).append(getDimsClass()).append("backgrounds").append("/").append(s2).toString(), AkApplication.getAppContext().getDir("backgrounds", 0), s2);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        if (loadlistener == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        loadlistener.onLoadingProgress(7, 9);
        String s3 = (new StringBuilder()).append("ak_decor_").append(s).append("_plan3.png").toString();
        j = downloadFileWithFallback((new StringBuilder()).append(getDimsClass()).append("backgrounds").append("/").append(s3).toString(), AkApplication.getAppContext().getDir("backgrounds", 0), s3);
        i = j;
        if (j != 0) goto _L6; else goto _L7
_L7:
        if (loadlistener == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        loadlistener.onLoadingProgress(8, 9);
        s = (new StringBuilder()).append("ak_decor_").append(s).append("_star.png").toString();
        j = downloadFileWithFallback((new StringBuilder()).append(getDimsClass()).append("backgrounds").append("/").append(s).toString(), AkApplication.getAppContext().getDir("backgrounds", 0), s);
        i = j;
        if (j != 0) goto _L6; else goto _L8
_L8:
        if (loadlistener == null)
        {
            break MISSING_BLOCK_LABEL_418;
        }
        loadlistener.onLoadingProgress(9, 9);
        i = 0;
          goto _L6
        s;
        throw s;
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public int loadClothes(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = loadClothes(s, null);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public int loadClothes(String s, LoadListener loadlistener)
    {
        this;
        JVM INSTR monitorenter ;
        int j = 0;
        String as[];
        int l;
        as = akitudes;
        l = as.length;
        int i = 0;
_L5:
        if (i >= l) goto _L2; else goto _L1
_L1:
        String s1 = as[i];
        int k;
        s1 = (new StringBuilder()).append(s1).append("_").append(s).append(".png").toString();
        k = downloadFileWithFallback((new StringBuilder()).append(getDimsClass()).append("tenues").append("/").append(s1).toString(), AkApplication.getAppContext().getDir("tenues", 0), s1);
        if (k == 0) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return k;
_L4:
        k = j;
        if (loadlistener == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        k = j + 1;
        loadlistener.onLoadingProgress(k, akitudes.length);
        i++;
        j = k;
          goto _L5
_L2:
        k = 0;
          goto _L3
        s;
        throw s;
    }

    public int loadHat(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = loadHat(s, null);
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public int loadHat(String s, LoadListener loadlistener)
    {
        this;
        JVM INSTR monitorenter ;
        int j = 0;
        String as[];
        int l;
        as = akitudes;
        l = as.length;
        int i = 0;
_L5:
        if (i >= l) goto _L2; else goto _L1
_L1:
        String s1 = as[i];
        int k;
        s1 = (new StringBuilder()).append(s1).append("_chapeau_").append(s).append(".png").toString();
        k = downloadFileWithFallback((new StringBuilder()).append(getDimsClass()).append("chapeaux").append("/").append(s1).toString(), AkApplication.getAppContext().getDir("chapeaux", 0), s1);
        if (k == 0) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return k;
_L4:
        k = j;
        if (loadlistener == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        k = j + 1;
        loadlistener.onLoadingProgress(k, akitudes.length);
        i++;
        j = k;
          goto _L5
_L2:
        k = 0;
          goto _L3
        s;
        throw s;
    }

    public void updateMaxMemory(int i)
    {
        maxMemory = i;
    }

    public void updateScreenWidth(int i)
    {
        screenWidth = i;
    }

}
