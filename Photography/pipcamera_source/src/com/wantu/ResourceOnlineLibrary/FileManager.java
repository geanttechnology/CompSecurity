// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary;

import ahn;
import ahp;
import ahq;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import tm;

// Referenced classes of package com.wantu.ResourceOnlineLibrary:
//            EOnlineResType

public class FileManager
{

    private static tm _instaMagFileCache;
    private static FileManager _instance;
    private static tm _onlineConfigFileCache;
    private static tm _pipFileCache;
    private static tm _tiezhiFileCache;

    private FileManager()
    {
        if (_pipFileCache == null)
        {
            _pipFileCache = new tm(PIPCameraApplication.a, "pip");
        }
        if (_onlineConfigFileCache == null)
        {
            _onlineConfigFileCache = new tm(PIPCameraApplication.a, "config");
        }
        if (_instaMagFileCache == null)
        {
            _instaMagFileCache = new tm(PIPCameraApplication.a, "instamag");
        }
        if (_tiezhiFileCache == null)
        {
            _tiezhiFileCache = new tm(PIPCameraApplication.a, "tiezhi");
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

    private Bitmap getOnlineInstaMagBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getInstaMagFileCache().a(s, new ahn());
        } else
        {
            return (Bitmap)getInstaMagFileCache().a(s, new ahp());
        }
    }

    private Bitmap getOnlinePipBitmapRes(String s)
    {
        if (_pipFileCache != null)
        {
            return (Bitmap)_pipFileCache.a(s, new ahn());
        } else
        {
            return null;
        }
    }

    private Bitmap getOnlineTieZhiBitmapRes(String s)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            return (Bitmap)getTieZhiFileCache().a(s, new ahn());
        } else
        {
            return (Bitmap)getTieZhiFileCache().a(s, new ahp());
        }
    }

    private void saveOnlineInstaMagBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getInstaMagFileCache().a(s, bitmap, new ahn());
            return;
        } else
        {
            getInstaMagFileCache().a(s, bitmap, new ahp());
            return;
        }
    }

    private void saveOnlinePipBitmapRes(String s, Bitmap bitmap)
    {
        if (_pipFileCache != null)
        {
            _pipFileCache.a(s, bitmap, new ahn());
        }
    }

    private void saveOnlineTieZhiBitmapRes(String s, Bitmap bitmap)
    {
        if (getExtension(s).equalsIgnoreCase("png") || getExtension(s).equalsIgnoreCase("PNG"))
        {
            getTieZhiFileCache().a(s, bitmap, new ahn());
            return;
        } else
        {
            getTieZhiFileCache().a(s, bitmap, new ahp());
            return;
        }
    }

    public void archiveAddtionInstaMagStyles(String s)
    {
        getInstaMagFileCache().a("instamag_archive_pip", s, new ahq());
    }

    public void archiveFilterManger(EOnlineResType eonlinerestype, String s)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[EOnlineResType.values().length];
                try
                {
                    a[EOnlineResType.PIP_SCENE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[EOnlineResType.MAG_MASK_INFO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[EOnlineResType.TIEZHI.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[EOnlineResType.PIP_SCENE2.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            getPipFileCache().a("pip_archive", s, new ahq());
            return;

        case 4: // '\004'
            getPipFileCache().a("pip2_archive", s, new ahq());
            return;

        case 2: // '\002'
            getInstaMagFileCache().a("instamag_archive", s, new ahq());
            return;

        case 3: // '\003'
            getTieZhiFileCache().a("tiezhi_archive", s, new ahq());
            return;
        }
    }

    public void archiveKeyFilterManger(EOnlineResType eonlinerestype, String s)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            getPipFileCache().a("pip_key_archive", s, new ahq());
            return;

        case 4: // '\004'
            getPipFileCache().a("pip2_key_archive", s, new ahq());
            return;

        case 2: // '\002'
            getInstaMagFileCache().a("instamag_key_archive", s, new ahq());
            return;

        case 3: // '\003'
            getTieZhiFileCache().a("tiezhi_key_archive", s, new ahq());
            return;
        }
    }

    public void deleteArchiveFilterManger(EOnlineResType eonlinerestype)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            getInstaMagFileCache().a("instamag_archive");
            return;

        case 1: // '\001'
            getPipFileCache().a("pip_archive");
            return;

        case 4: // '\004'
            getPipFileCache().a("pip2_archive");
            return;

        case 3: // '\003'
            getTieZhiFileCache().a("tiezhi_archive");
            return;
        }
    }

    public void deleteOnlineBitmapRes(EOnlineResType eonlinerestype, String s)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        case 2: // '\002'
        default:
            return;

        case 1: // '\001'
            _pipFileCache = getPipFileCache();
            _pipFileCache.a(s);
            return;

        case 4: // '\004'
            _pipFileCache = getPipFileCache();
            _pipFileCache.a(s);
            return;

        case 3: // '\003'
            _tiezhiFileCache = getTieZhiFileCache();
            _tiezhiFileCache.a(s);
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

    public tm getInstaMagFileCache()
    {
        if (_instaMagFileCache == null)
        {
            _instaMagFileCache = new tm(PIPCameraApplication.a, "instamag");
        }
        return _instaMagFileCache;
    }

    public Bitmap getOnlineBitmapRes(EOnlineResType eonlinerestype, String s)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getOnlinePipBitmapRes(s);

        case 2: // '\002'
            return getOnlineInstaMagBitmapRes(s);

        case 3: // '\003'
            return getOnlineTieZhiBitmapRes(s);
        }
    }

    public tm getOnlineConfigFileCache()
    {
        if (_onlineConfigFileCache == null)
        {
            _onlineConfigFileCache = new tm(PIPCameraApplication.a, "config");
        }
        return _onlineConfigFileCache;
    }

    public Object getOnlineConfigUpdateTimes()
    {
        return getOnlineConfigFileCache().a("config_archiveUpdateTimes", new ahq());
    }

    public tm getPipFileCache()
    {
        if (_pipFileCache == null)
        {
            _pipFileCache = new tm(PIPCameraApplication.a, "pip");
        }
        return _pipFileCache;
    }

    public tm getTieZhiFileCache()
    {
        if (_tiezhiFileCache == null)
        {
            _tiezhiFileCache = new tm(PIPCameraApplication.a, "tiezhi");
        }
        return _tiezhiFileCache;
    }

    public void saveOnlineBitmapRes(EOnlineResType eonlinerestype, String s, Bitmap bitmap)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            saveOnlinePipBitmapRes(s, bitmap);
            return;

        case 2: // '\002'
            saveOnlineInstaMagBitmapRes(s, bitmap);
            return;

        case 3: // '\003'
            saveOnlineTieZhiBitmapRes(s, bitmap);
            break;
        }
    }

    public void saveOnlineConfigUpdateTimes(String s)
    {
        getOnlineConfigFileCache().a("config_archiveUpdateTimes", s, new ahq());
    }

    public Object unarachiveAssetAddtionInstaMagStyles()
    {
        Object obj = new ahq();
        Exception exception;
        java.io.InputStream inputstream;
        try
        {
            inputstream = PIPCameraApplication.a.getResources().getAssets().open("instamag_archive_addtion");
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
            Crashlytics.logException(exception1);
            return null;
        }
        obj = ((ahq) (obj)).a(new BufferedInputStream(inputstream));
        return obj;
        exception;
        exception.printStackTrace();
        Crashlytics.logException(exception);
        return null;
    }

    public Object unarchiveAddtionInstaMagStyles()
    {
        return getInstaMagFileCache().a("instamag_archive_pip", new ahq());
    }

    public Object unarchiveFilterManger(EOnlineResType eonlinerestype)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getPipFileCache().a("pip_archive", new ahq());

        case 4: // '\004'
            return getPipFileCache().a("pip2_archive", new ahq());

        case 2: // '\002'
            return getInstaMagFileCache().a("instamag_archive", new ahq());

        case 3: // '\003'
            return getTieZhiFileCache().a("tiezhi_archive", new ahq());
        }
    }

    public Object unarchiveKeyFilterManger(EOnlineResType eonlinerestype)
    {
        switch (_cls1.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getPipFileCache().a("pip_key_archive", new ahq());

        case 4: // '\004'
            return getPipFileCache().a("pip2_key_archive", new ahq());

        case 2: // '\002'
            return getInstaMagFileCache().a("instamag_key_archive", new ahq());

        case 3: // '\003'
            return getTieZhiFileCache().a("tiezhi_key_archive", new ahq());
        }
    }
}
