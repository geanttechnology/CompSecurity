// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tu;
import ur;
import us;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose:
//            TPhotoComposeInfo, TDecorateInfo, InstaMagType, TPhotoMaskInfo

public class TPhotoMagComposeManager extends tu
{

    public static int KFBNATIVEID = -2012;
    public static int KMAXADRESID = 10;
    public static String TAG = "TPhotoMagComposeManager";
    public static int UITextAlignmentCenter = 17;
    public static int UITextAlignmentLeft = 3;
    public static int UITextAlignmentRight = 5;
    us _network;
    public List _styleInfoArray;
    private boolean haveArchive;

    public TPhotoMagComposeManager()
    {
        int i = 0;
        super();
        _styleInfoArray = new ArrayList();
        haveArchive = false;
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" before unarchive").toString());
        unarchive();
        if (haveArchive)
        {
            i = 1;
        }
        installNewArchiveInfosByOrder(i);
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" end unarchive").toString());
        _network = new us();
        _network.a(this);
        getAllFontNames();
        insertADResInfos();
    }

    private boolean checkResInfos()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (_styleInfoArray != null)
        {
            flag = flag1;
            if (_styleInfoArray.size() > 0)
            {
                ArrayList arraylist = new ArrayList();
                for (int i = 0; i < _styleInfoArray.size(); i++)
                {
                    TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
                    if (!isAvilable(tphotocomposeinfo))
                    {
                        arraylist.add(tphotocomposeinfo);
                    }
                }

                flag = flag1;
                if (arraylist.size() > 0)
                {
                    _styleInfoArray.removeAll(arraylist);
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void getAllFontNames()
    {
        ArrayList arraylist = new ArrayList();
        if (_styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            for (int i = 0; i < _styleInfoArray.size(); i++)
            {
                List list = ((TPhotoComposeInfo)_styleInfoArray.get(i)).decorateInfoArray;
                if (list == null || list.size() <= 0)
                {
                    continue;
                }
                for (int j = 0; j < list.size(); j++)
                {
                    TDecorateInfo tdecorateinfo = (TDecorateInfo)list.get(j);
                    if (tdecorateinfo.fontFamily != null && tdecorateinfo.fontFamily.length() > 0 && !isExistStringValue(tdecorateinfo.fontFamily, arraylist))
                    {
                        arraylist.add(tdecorateinfo.fontFamily);
                    }
                }

            }

            Log.v(TAG, (new StringBuilder()).append(TAG).append(" all fonts:").append(arraylist).toString());
        }
    }

    private boolean isExistStringValue(String s, List list)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (list == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        flag = flag1;
        if (i >= list.size()) goto _L2; else goto _L3
_L3:
        if (!s.equalsIgnoreCase((String)list.get(i))) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private boolean isResinfoNeedDelete(int i)
    {
        boolean flag1 = false;
        int ai[] = new int[7];
        int[] _tmp = ai;
        ai[0] = 1118;
        ai[1] = 1114;
        ai[2] = 1110;
        ai[3] = 1105;
        ai[4] = 1091;
        ai[5] = 1090;
        ai[6] = 1138;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < ai.length)
                {
                    if (i != ai[j])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j++;
        } while (true);
    }

    private boolean isValidate(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag = true;
        if (tphotocomposeinfo == null)
        {
            return false;
        }
        if (tphotocomposeinfo.icon == null || tphotocomposeinfo.icon.length() == 0 || tphotocomposeinfo.resId == 0 || tphotocomposeinfo.imageCount == 0)
        {
            flag = false;
        }
        return flag;
    }

    private void removeByResId(int i)
    {
        if (_styleInfoArray == null || _styleInfoArray.size() <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L7:
        if (j >= _styleInfoArray.size()) goto _L2; else goto _L3
_L3:
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
        if (tphotocomposeinfo.resId != i) goto _L5; else goto _L4
_L4:
        _styleInfoArray.remove(tphotocomposeinfo);
_L2:
        return;
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public List AllInfos()
    {
        ArrayList arraylist = new ArrayList();
        if (_styleInfoArray.size() != 0);
        for (Iterator iterator = _styleInfoArray.iterator(); iterator.hasNext(); arraylist.add((TPhotoComposeInfo)iterator.next())) { }
        return arraylist;
    }

    public void add(TPhotoComposeInfo tphotocomposeinfo)
    {
        _styleInfoArray.add(tphotocomposeinfo);
    }

    public void addAndReplace(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo == null)
        {
            return;
        }
        if (!isExistedByResId(tphotocomposeinfo.resId))
        {
            _styleInfoArray.add(tphotocomposeinfo);
            return;
        } else
        {
            replace(tphotocomposeinfo);
            return;
        }
    }

    public void addFront(TPhotoComposeInfo tphotocomposeinfo)
    {
        _styleInfoArray.add(0, tphotocomposeinfo);
    }

    public List allItem()
    {
        if (_styleInfoArray.size() != 0);
        return _styleInfoArray;
    }

    public void archive()
    {
        if (_styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            Object obj = new Gson();
            Iterator iterator = _styleInfoArray.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
                if (tphotocomposeinfo.icon == null || tphotocomposeinfo.icon != null && tphotocomposeinfo.icon.length() == 0)
                {
                    iterator.remove();
                }
            } while (true);
            obj = ((Gson) (obj)).toJson(_styleInfoArray);
            FileManager.getInstance().archiveFilterManger(EOnlineResType.MAG_MASK_INFO, ((String) (obj)));
        }
    }

    public void asynArchive()
    {
        (new ur(this)).execute(new Void[0]);
    }

    public void cancelDownloadWork()
    {
        if (_network == null);
    }

    public void clearLandscapeInfo()
    {
        if (_styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < _styleInfoArray.size(); i++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
                if (tphotocomposeinfo.width > tphotocomposeinfo.height)
                {
                    Log.e("landscape info id", (new StringBuilder()).append("id:").append(tphotocomposeinfo.resId).toString());
                    arraylist.add(tphotocomposeinfo);
                }
            }

            if (arraylist.size() > 0)
            {
                _styleInfoArray.removeAll(arraylist);
            }
        }
        archive();
    }

    public void deleteInfo(TResInfo tresinfo)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < _styleInfoArray.size())
                {
                    Object obj = (TPhotoComposeInfo)_styleInfoArray.get(i);
                    if (((TPhotoComposeInfo) (obj)).getResType() != EResType.NETWORK || tresinfo.resId != ((TPhotoComposeInfo) (obj)).resId)
                    {
                        break label0;
                    }
                    _styleInfoArray.remove(obj);
                    obj = (TPhotoComposeInfo)tresinfo;
                    i = ((TPhotoComposeInfo) (obj)).icon.lastIndexOf("/");
                    obj = ((TPhotoComposeInfo) (obj)).icon.substring(i + 1);
                    FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.MAG_MASK_INFO, ((String) (obj)));
                    archive();
                    obj = new Intent("ACTION_MATERIAL_REMOVE");
                    ((Intent) (obj)).putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.MAG_MASK_INFO));
                    ((Intent) (obj)).putExtra("INSTAMAG_RESID", tresinfo.resId);
                    PIPCameraApplication.a.sendBroadcast(((Intent) (obj)));
                }
                return;
            }
            i++;
        } while (true);
    }

    public void downloadRes(TResInfo tresinfo)
    {
        if (_network != null)
        {
            _network.b(tresinfo);
        }
    }

    public void filterDownloadFinished(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)obj;
        tphotocomposeinfo.setResType(EResType.NETWORK);
        if (isExistedByResId(tphotocomposeinfo.resId))
        {
            removeByResId(tphotocomposeinfo.resId);
        }
        if (isValidate(tphotocomposeinfo))
        {
            addFront(tphotocomposeinfo);
            Intent intent = new Intent("ACTION_MATERIAL_ADDED");
            intent.putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.MAG_MASK_INFO));
            intent.putExtra("INSTAMAG_TYPE", TPhotoComposeInfo.getInstaMagType(tphotocomposeinfo).ordinal());
            intent.putExtra("INSTAMAG_RESID", tphotocomposeinfo.resId);
            intent.putExtra("INSTAMAG_IMAGE_COUNT", tphotocomposeinfo.imageCount);
            PIPCameraApplication.a.sendBroadcast(intent);
            super.filterDownloadFinished(obj);
            return;
        } else
        {
            filterDownloadFailed(0, tphotocomposeinfo);
            return;
        }
    }

    public TPhotoComposeInfo getComposeInfoByResId(int i)
    {
        if (_styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            for (int j = 0; j < _styleInfoArray.size(); j++)
            {
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(j);
                if (tphotocomposeinfo.resId == i)
                {
                    return tphotocomposeinfo;
                }
            }

        }
        return null;
    }

    public void insertADResInfos()
    {
        if (_styleInfoArray.size() > 0)
        {
            int i = _styleInfoArray.size() - 1;
            TPhotoComposeInfo tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 1;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad1.jpg";
            tphotocomposeinfo.name = "Mag_9P03";
            tphotocomposeinfo.imageCount = 3;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 480F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add(i - 1, tphotocomposeinfo);
            }
            tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 2;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad2.jpg";
            tphotocomposeinfo.name = "PIP_1P13";
            tphotocomposeinfo.imageCount = 1;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 320F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add(5, tphotocomposeinfo);
            }
            tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 3;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad3.jpg";
            tphotocomposeinfo.name = "PIP_1P36";
            tphotocomposeinfo.imageCount = 1;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 480F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add(6, tphotocomposeinfo);
            }
            tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 4;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad4.jpg";
            tphotocomposeinfo.name = "Mag_4S47";
            tphotocomposeinfo.imageCount = 3;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 320F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add(i - 1, tphotocomposeinfo);
            }
            tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 5;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad5.jpg";
            tphotocomposeinfo.name = "Mag_3P78";
            tphotocomposeinfo.imageCount = 3;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 480F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add((i * 3) / 4, tphotocomposeinfo);
            }
            tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 6;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad6.jpg";
            tphotocomposeinfo.name = "Mag_2S02";
            tphotocomposeinfo.imageCount = 2;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 320F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add((i * 2) / 3, tphotocomposeinfo);
            }
            tphotocomposeinfo = new TPhotoComposeInfo();
            tphotocomposeinfo.resId = 8;
            tphotocomposeinfo.backgroundColor = -1;
            tphotocomposeinfo.icon = "MRes/adRes/ad8.jpg";
            tphotocomposeinfo.name = "Mag_1P163";
            tphotocomposeinfo.imageCount = 1;
            tphotocomposeinfo.price = 0;
            tphotocomposeinfo.previewUrl = "";
            tphotocomposeinfo.width = 320F;
            tphotocomposeinfo.height = 480F;
            if (!isExistedByResId(tphotocomposeinfo.resId))
            {
                _styleInfoArray.add((i * 3) / 5, tphotocomposeinfo);
                return;
            }
        }
    }

    public void installNewArchiveInfosByOrder(int i)
    {
        SharedPreferences sharedpreferences;
        int j;
        boolean flag;
        flag = false;
        j = 0;
        sharedpreferences = PIPCameraApplication.a.getSharedPreferences("config", 0);
        if (sharedpreferences.getBoolean("unArchiveAddtion", false)) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = new ArrayList();
        obj1 = FileManager.getInstance().unarachiveAssetAddtionInstaMagStyles();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj1 = (String)obj1;
        Gson gson = new Gson();
        try
        {
            obj1 = (List)gson.fromJson(((String) (obj1)), (new TypeToken() {

                final TPhotoMagComposeManager a;

            
            {
                a = TPhotoMagComposeManager.this;
                super();
            }
            }).getType());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            Log.v("TphotoMagComposeManager", (new StringBuilder()).append("TphotoMagComposeManagerunarchive error:").append(((JsonSyntaxException) (obj2)).toString()).toString());
            Crashlytics.logException(((Throwable) (obj2)));
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
_L8:
        if (((List) (obj)).size() > 0)
        {
            while (j < ((List) (obj)).size()) 
            {
                Object obj2 = (TPhotoComposeInfo)((List) (obj)).get(j);
                if (obj2 != null && ((TPhotoComposeInfo) (obj2)).resId != 1138)
                {
                    if (isExistedByResId(((TPhotoComposeInfo) (obj2)).resId))
                    {
                        replace(((TPhotoComposeInfo) (obj2)));
                    } else
                    if (i == 0)
                    {
                        addFront(((TPhotoComposeInfo) (obj2)));
                    } else
                    {
                        add(((TPhotoComposeInfo) (obj2)));
                    }
                }
                j++;
            }
            archive();
            obj = sharedpreferences.edit();
            ((android.content.SharedPreferences.Editor) (obj)).putBoolean("unArchiveAddtion", true);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
_L4:
        return;
_L2:
        if (_styleInfoArray == null || _styleInfoArray.size() <= 0) goto _L4; else goto _L5
_L5:
        obj = new ArrayList();
        for (i = ((flag) ? 1 : 0); i < _styleInfoArray.size(); i++)
        {
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)_styleInfoArray.get(i);
            if (isResinfoNeedDelete(tphotocomposeinfo.resId))
            {
                ((List) (obj)).add(tphotocomposeinfo);
            }
        }

        if (((List) (obj)).size() <= 0) goto _L4; else goto _L6
_L6:
        _styleInfoArray.removeAll(((java.util.Collection) (obj)));
        archive();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean isAvilable(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (tphotocomposeinfo.resId < KMAXADRESID)
        {
            return true;
        }
        if (tphotocomposeinfo.photoMaskInfoArray != null && tphotocomposeinfo.photoMaskInfoArray.size() > 0)
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= tphotocomposeinfo.photoMaskInfoArray.size())
                    {
                        break label1;
                    }
                    TPhotoMaskInfo tphotomaskinfo = (TPhotoMaskInfo)tphotocomposeinfo.photoMaskInfoArray.get(i);
                    if (tphotomaskinfo == null || tphotomaskinfo.backgroundFrame == null)
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public boolean isExistedByResId(int i)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (_styleInfoArray == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (_styleInfoArray.size() <= 0) goto _L2; else goto _L3
_L3:
        int j = 0;
_L8:
        flag = flag1;
        if (j >= _styleInfoArray.size()) goto _L2; else goto _L4
_L4:
        if (((TPhotoComposeInfo)_styleInfoArray.get(j)).resId != i) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public List netMaterials()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = _styleInfoArray.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
            if (tphotocomposeinfo.getResType() == EResType.NETWORK)
            {
                arraylist.add(tphotocomposeinfo);
            }
        } while (true);
        return arraylist;
    }

    public void replace(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null && _styleInfoArray != null && _styleInfoArray.size() > 0)
        {
            int i = 0;
            while (i < _styleInfoArray.size()) 
            {
                if (((TPhotoComposeInfo)_styleInfoArray.get(i)).resId == tphotocomposeinfo.resId)
                {
                    _styleInfoArray.set(i, tphotocomposeinfo);
                    return;
                }
                i++;
            }
        }
    }

    public void unarchive()
    {
        Object obj;
        Gson gson;
        obj = FileManager.getInstance().unarchiveFilterManger(EOnlineResType.MAG_MASK_INFO);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        haveArchive = true;
        obj = (String)obj;
        gson = new Gson();
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" before gson String:").toString());
        _styleInfoArray = (List)gson.fromJson(((String) (obj)), (new TypeToken() {

            final TPhotoMagComposeManager a;

            
            {
                a = TPhotoMagComposeManager.this;
                super();
            }
        }).getType());
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" end gson String:").toString());
        checkResInfos();
        return;
        JsonSyntaxException jsonsyntaxexception;
        jsonsyntaxexception;
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" unarchive gson error").toString());
        installNewArchiveInfosByOrder(0);
        FileManager.getInstance().deleteArchiveFilterManger(EOnlineResType.MAG_MASK_INFO);
        android.content.SharedPreferences.Editor editor = PIPCameraApplication.a.getSharedPreferences("config", 0).edit();
        editor.putBoolean("unArchiveAddtion", false);
        editor.commit();
        Crashlytics.logException(jsonsyntaxexception);
        return;
    }

    public void update()
    {
        if (_styleInfoArray.size() > 0)
        {
            ArrayList arraylist = new ArrayList(_styleInfoArray.size());
            for (Iterator iterator = _styleInfoArray.iterator(); iterator.hasNext(); arraylist.add((TPhotoComposeInfo)iterator.next())) { }
            _network.b(arraylist);
        }
    }

    public void updateUseCountByResId(int i, int j)
    {
        if (_styleInfoArray == null || _styleInfoArray.size() <= 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L7:
        if (k >= _styleInfoArray.size()) goto _L2; else goto _L3
_L3:
        Object obj = (TPhotoComposeInfo)_styleInfoArray.get(k);
        if (((TPhotoComposeInfo) (obj)).resId != i) goto _L5; else goto _L4
_L4:
        obj.useCount = j;
        obj = new Intent("ACTION_MATERIAL_CHANGE");
        ((Intent) (obj)).putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.MAG_MASK_INFO));
        PIPCameraApplication.a.sendBroadcast(((Intent) (obj)));
_L2:
        return;
_L5:
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
