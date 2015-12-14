// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary;

import ako;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import awg;
import bft;
import bgd;
import ceo;
import ceq;
import cer;
import com.crashlytics.android.Crashlytics;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.wantu.ResourceOnlineLibrary:
//            EOnlineResType

public class FileManager
{

    private static bgd _frameFileCache;
    private static bgd _freeRectStyleFileCache;
    private static bgd _freeStyleFileCache;
    private static bgd _instaMagFileCache;
    private static FileManager _instance;
    private static bgd _lightFileCache;
    private static bgd _onlineConfigFileCache;
    private static bgd _pipFileCache;
    private static bgd _textFileCache;
    private static bgd _tiezhiFileCache;

    private FileManager()
    {
        if (_lightFileCache == null)
        {
            _lightFileCache = new bgd(InstaBeautyApplication.a().b(), "light");
        }
        if (_pipFileCache == null)
        {
            _pipFileCache = new bgd(InstaBeautyApplication.a().b(), "pip");
        }
        if (_frameFileCache == null)
        {
            _frameFileCache = new bgd(InstaBeautyApplication.a().b(), "frame");
        }
        if (_onlineConfigFileCache == null)
        {
            _onlineConfigFileCache = new bgd(InstaBeautyApplication.a().b(), "config");
        }
        if (_freeStyleFileCache == null)
        {
            _freeStyleFileCache = new bgd(InstaBeautyApplication.a().b(), "freestyle");
        }
        if (_instaMagFileCache == null)
        {
            _instaMagFileCache = new bgd(InstaBeautyApplication.a().b(), "instamag");
        }
        if (_freeRectStyleFileCache == null)
        {
            _freeRectStyleFileCache = new bgd(InstaBeautyApplication.a().b(), "freerectStyle");
        }
        if (_tiezhiFileCache == null)
        {
            _tiezhiFileCache = awg.a().c();
        }
        if (_textFileCache == null)
        {
            _textFileCache = ako.a().d();
        }
    }

    public static FileManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new FileManager();
        }
        return _instance;
    }

    private Bitmap getOnlineFrameBitmapRes(String s)
    {
        if (_frameFileCache != null)
        {
            return (Bitmap)_frameFileCache.a(s, new ceo());
        } else
        {
            return null;
        }
    }

    private Bitmap getOnlineFreeRectStyleBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getFreeRectStyleFileCache().a(s, new ceo());
        } else
        {
            return (Bitmap)getFreeRectStyleFileCache().a(s, new ceq());
        }
    }

    private Bitmap getOnlineFreeStyleBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getFreeStyleFileCache().a(s, new ceo());
        } else
        {
            return (Bitmap)getFreeStyleFileCache().a(s, new ceq());
        }
    }

    private Bitmap getOnlineInstaMagBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getInstaMagFileCache().a(s, new ceo());
        } else
        {
            return (Bitmap)getInstaMagFileCache().a(s, new ceq());
        }
    }

    private Bitmap getOnlineLightBitmapRes(String s)
    {
        if (_lightFileCache != null)
        {
            return (Bitmap)_lightFileCache.a(s, new ceq());
        } else
        {
            return null;
        }
    }

    private Bitmap getOnlinePipBitmapRes(String s)
    {
        if (_pipFileCache != null)
        {
            return (Bitmap)_pipFileCache.a(s, new ceo());
        } else
        {
            return null;
        }
    }

    private Bitmap getOnlineTextBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getTextFileCache().a(s, new ceo());
        } else
        {
            return (Bitmap)getTextFileCache().a(s, new ceq());
        }
    }

    private Bitmap getOnlineTieZhiBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getTieZhiFileCache().a(s, new ceo());
        } else
        {
            return (Bitmap)getTieZhiFileCache().a(s, new ceq());
        }
    }

    private void saveOnlineFrameBitmapRes(String s, Bitmap bitmap)
    {
        if (_frameFileCache != null)
        {
            _frameFileCache.a(s, bitmap, new ceo());
        }
    }

    private void saveOnlineFreeRectStyleBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getFreeRectStyleFileCache().a(s, bitmap, new ceo());
            return;
        } else
        {
            getFreeRectStyleFileCache().a(s, bitmap, new ceq());
            return;
        }
    }

    private void saveOnlineFreeStyleBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getFreeStyleFileCache().a(s, bitmap, new ceo());
            return;
        } else
        {
            getFreeStyleFileCache().a(s, bitmap, new ceq());
            return;
        }
    }

    private void saveOnlineInstaMagBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getInstaMagFileCache().a(s, bitmap, new ceo());
            return;
        } else
        {
            getInstaMagFileCache().a(s, bitmap, new ceq());
            return;
        }
    }

    private void saveOnlineLightBitmapRes(String s, Bitmap bitmap)
    {
        if (_lightFileCache != null)
        {
            _lightFileCache.a(s, bitmap, new ceq());
        }
    }

    private void saveOnlinePipBitmapRes(String s, Bitmap bitmap)
    {
        if (_pipFileCache != null)
        {
            _pipFileCache.a(s, bitmap, new ceo());
        }
    }

    private void saveOnlineTextBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getTextFileCache().a(s, bitmap, new ceo());
            return;
        } else
        {
            getTextFileCache().a(s, bitmap, new ceq());
            return;
        }
    }

    private void saveOnlineTieZhiBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getTieZhiFileCache().a(s, bitmap, new ceo());
            return;
        } else
        {
            getTieZhiFileCache().a(s, bitmap, new ceq());
            return;
        }
    }

    public void archiveAddtionInstaMagStyles(String s)
    {
        getInstaMagFileCache().a("instamag_archive_addtion", s, new cer());
    }

    public void archiveFilterManger(EOnlineResType eonlinerestype, String s)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            getLightFileCache().a("light_archive", s, new cer());
            return;

        case 2: // '\002'
            getPipFileCache().a("pip_archive", s, new cer());
            return;

        case 9: // '\t'
            getPipFileCache().a("pip2_archive", s, new cer());
            return;

        case 3: // '\003'
            getFrameFileCache().a("frame_archive", s, new cer());
            return;

        case 4: // '\004'
            getFreeStyleFileCache().a("freestyle_archive", s, new cer());
            return;

        case 5: // '\005'
            getInstaMagFileCache().a("instamag_archive", s, new cer());
            return;

        case 6: // '\006'
            getFreeRectStyleFileCache().a("freerectstyle_archive", s, new cer());
            return;

        case 7: // '\007'
            getTieZhiFileCache().a("tiezhi_archive", s, new cer());
            return;

        case 8: // '\b'
            getTextFileCache().a("text_archive", s, new cer());
            return;
        }
    }

    public void archiveKeyFilterManger(EOnlineResType eonlinerestype, String s)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            return;

        case 1: // '\001'
            getLightFileCache().a("key_light_archive", s, new cer());
            break;
        }
    }

    public void deleteArchiveFilterManger(EOnlineResType eonlinerestype)
    {
        bft.a[eonlinerestype.ordinal()];
        JVM INSTR tableswitch 1 9: default 60
    //                   1 70
    //                   2 80
    //                   3 100
    //                   4 110
    //                   5 120
    //                   6 130
    //                   7 140
    //                   8 60
    //                   9 90;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L1 _L9
_L1:
        getTextFileCache().a("text_archive");
        return;
_L2:
        getLightFileCache().a("light_archive");
        return;
_L3:
        getPipFileCache().a("pip_archive");
        return;
_L9:
        getPipFileCache().a("pip2_archive");
        return;
_L4:
        getFrameFileCache().a("frame_archive");
        return;
_L5:
        getFreeStyleFileCache().a("freestyle_archive");
        return;
_L6:
        getInstaMagFileCache().a("instamag_archive");
        return;
_L7:
        getFreeRectStyleFileCache().a("freerectstyle_archive");
        return;
_L8:
        getTieZhiFileCache().a("tiezhi_archive");
        if (true) goto _L1; else goto _L10
_L10:
    }

    public void deleteArchiveKeyFilterManger(EOnlineResType eonlinerestype)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            return;

        case 1: // '\001'
            getLightFileCache().a("key_light_archive");
            break;
        }
    }

    public void deleteOnlineBitmapRes(EOnlineResType eonlinerestype, String s)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            _lightFileCache = getLightFileCache();
            _lightFileCache.a(s);
            return;

        case 2: // '\002'
            _pipFileCache = getPipFileCache();
            _pipFileCache.a(s);
            return;

        case 9: // '\t'
            _pipFileCache = getPipFileCache();
            _pipFileCache.a(s);
            return;

        case 3: // '\003'
            _frameFileCache = getFrameFileCache();
            _frameFileCache.a(s);
            return;

        case 4: // '\004'
            _freeStyleFileCache = getFreeStyleFileCache();
            _freeStyleFileCache.a(s);
            return;

        case 5: // '\005'
            _instaMagFileCache = getInstaMagFileCache();
            _instaMagFileCache.a(s);
            return;

        case 6: // '\006'
            _freeRectStyleFileCache = getFreeRectStyleFileCache();
            _freeRectStyleFileCache.a(s);
            return;

        case 7: // '\007'
            _tiezhiFileCache = getTieZhiFileCache();
            _tiezhiFileCache.a(s);
            return;

        case 8: // '\b'
            _textFileCache = getTextFileCache();
            _textFileCache.a(s);
            return;
        }
    }

    public Bitmap getBitmapByFilePath(String s)
    {
        Object obj;
        Object obj4;
        obj4 = null;
        obj = null;
        s = new File(s);
        if (!s.exists()) goto _L2; else goto _L1
_L1:
        obj = new BufferedInputStream(new FileInputStream(s));
        s = ((String) (obj));
        Object obj1 = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        s = ((String) (obj1));
_L11:
        obj1 = s;
        if (obj != null)
        {
            Object obj2;
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return s;
            }
            obj1 = s;
        }
_L4:
        return ((Bitmap) (obj1));
        obj2;
        obj = null;
_L9:
        s = ((String) (obj));
        ((FileNotFoundException) (obj2)).printStackTrace();
        obj2 = obj4;
        if (obj == null) goto _L4; else goto _L3
_L3:
        try
        {
            ((BufferedInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return null;
        obj2;
        obj = null;
_L8:
        s = ((String) (obj));
        ((Exception) (obj2)).printStackTrace();
        obj2 = obj4;
        if (obj == null) goto _L4; else goto _L5
_L5:
        try
        {
            ((BufferedInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return null;
        obj;
        s = null;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw obj;
        obj;
        if (true) goto _L7; else goto _L6
_L6:
        obj2;
          goto _L8
        obj2;
          goto _L9
_L2:
        Object obj3 = null;
        s = ((String) (obj));
        obj = obj3;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public String getExtension(String s)
    {
        String s2 = "jpg";
        String s1 = s2;
        if (s != null)
        {
            s1 = s2;
            if (s.length() > 0)
            {
                int i = s.lastIndexOf('.');
                s1 = s2;
                if (i > -1)
                {
                    s1 = s2;
                    if (i < s.length() - 1)
                    {
                        s1 = s.substring(i + 1);
                    }
                }
            }
        }
        return s1;
    }

    public bgd getFrameFileCache()
    {
        if (_frameFileCache == null)
        {
            _frameFileCache = new bgd(InstaBeautyApplication.a().b(), "frame");
        }
        return _frameFileCache;
    }

    public bgd getFreeRectStyleFileCache()
    {
        if (_freeRectStyleFileCache == null)
        {
            _freeRectStyleFileCache = new bgd(InstaBeautyApplication.a().b(), "freerectstyle");
        }
        return _freeRectStyleFileCache;
    }

    public bgd getFreeStyleFileCache()
    {
        if (_freeStyleFileCache == null)
        {
            _freeStyleFileCache = new bgd(InstaBeautyApplication.a().b(), "freestyle");
        }
        return _freeStyleFileCache;
    }

    public bgd getInstaMagFileCache()
    {
        if (_instaMagFileCache == null)
        {
            _instaMagFileCache = new bgd(InstaBeautyApplication.a, "instamag");
        }
        return _instaMagFileCache;
    }

    public bgd getLightFileCache()
    {
        if (_lightFileCache == null)
        {
            _lightFileCache = new bgd(InstaBeautyApplication.a().b(), "light");
        }
        return _lightFileCache;
    }

    public Bitmap getOnlineBitmapRes(EOnlineResType eonlinerestype, String s)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getOnlineLightBitmapRes(s);

        case 2: // '\002'
            return getOnlinePipBitmapRes(s);

        case 3: // '\003'
            return getOnlineFrameBitmapRes(s);

        case 4: // '\004'
            return getOnlineFreeStyleBitmapRes(s);

        case 5: // '\005'
            return getOnlineInstaMagBitmapRes(s);

        case 6: // '\006'
            return getOnlineFreeRectStyleBitmapRes(s);

        case 7: // '\007'
            return getOnlineTieZhiBitmapRes(s);

        case 8: // '\b'
            return getOnlineTextBitmapRes(s);
        }
    }

    public bgd getOnlineConfigFileCache()
    {
        if (_onlineConfigFileCache == null)
        {
            _onlineConfigFileCache = new bgd(InstaBeautyApplication.a().b(), "config");
        }
        return _onlineConfigFileCache;
    }

    public Object getOnlineConfigUpdateTimes()
    {
        return getOnlineConfigFileCache().a("config_archiveUpdateTimes", new cer());
    }

    public bgd getPipFileCache()
    {
        if (_pipFileCache == null)
        {
            _pipFileCache = new bgd(InstaBeautyApplication.a().b(), "pip");
        }
        return _pipFileCache;
    }

    public bgd getTextFileCache()
    {
        if (_textFileCache == null)
        {
            _textFileCache = new bgd(InstaBeautyApplication.a().b(), "text");
        }
        return _textFileCache;
    }

    public bgd getTieZhiFileCache()
    {
        if (_tiezhiFileCache == null)
        {
            _tiezhiFileCache = new bgd(InstaBeautyApplication.a().b(), "tiezhi");
        }
        return _tiezhiFileCache;
    }

    public void saveOnlineBitmapRes(EOnlineResType eonlinerestype, String s, Bitmap bitmap)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            saveOnlineLightBitmapRes(s, bitmap);
            return;

        case 2: // '\002'
            saveOnlinePipBitmapRes(s, bitmap);
            return;

        case 3: // '\003'
            saveOnlineFrameBitmapRes(s, bitmap);
            return;

        case 4: // '\004'
            saveOnlineFreeStyleBitmapRes(s, bitmap);
            return;

        case 5: // '\005'
            saveOnlineInstaMagBitmapRes(s, bitmap);
            return;

        case 6: // '\006'
            saveOnlineFreeRectStyleBitmapRes(s, bitmap);
            return;

        case 7: // '\007'
            saveOnlineTieZhiBitmapRes(s, bitmap);
            return;

        case 8: // '\b'
            saveOnlineTextBitmapRes(s, bitmap);
            break;
        }
    }

    public void saveOnlineConfigUpdateTimes(String s)
    {
        getOnlineConfigFileCache().a("config_archiveUpdateTimes", s, new cer());
    }

    public Object unarachiveAssetAddtionInstaMagStyles()
    {
        Object obj = new cer();
        Exception exception;
        java.io.InputStream inputstream;
        try
        {
            inputstream = InstaBeautyApplication.a.getResources().getAssets().open("instamag_archive_minimal");
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
            Crashlytics.logException(exception1);
            return null;
        }
        obj = ((cer) (obj)).a(new BufferedInputStream(inputstream));
        return obj;
        exception;
        exception.printStackTrace();
        return null;
    }

    public Object unarchiveFilterManger(EOnlineResType eonlinerestype)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getLightFileCache().a("light_archive", new cer());

        case 2: // '\002'
            return getPipFileCache().a("pip_archive", new cer());

        case 9: // '\t'
            return getPipFileCache().a("pip2_archive", new cer());

        case 3: // '\003'
            return getFrameFileCache().a("frame_archive", new cer());

        case 4: // '\004'
            return getFreeStyleFileCache().a("freestyle_archive", new cer());

        case 5: // '\005'
            return getInstaMagFileCache().a("instamag_archive", new cer());

        case 6: // '\006'
            return getFreeRectStyleFileCache().a("freerectstyle_archive", new cer());

        case 7: // '\007'
            return getTieZhiFileCache().a("tiezhi_archive", new cer());

        case 8: // '\b'
            return getTextFileCache().a("text_archive", new cer());
        }
    }

    public Object unarchiveKeyFilterManger(EOnlineResType eonlinerestype)
    {
        switch (bft.a[eonlinerestype.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            return null;

        case 1: // '\001'
            return getLightFileCache().a("key_light_archive", new cer());
        }
    }
}
