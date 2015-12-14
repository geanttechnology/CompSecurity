// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.EResProcessType;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneCatalog;
import com.wantu.piprender.ESceneMode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class yf
{

    protected ESceneMode a;
    private List b;
    private int c[] = {
        811, 808, 809, 796, 274, 795, 797, 810, 812, 813, 
        814, 815, 816, 817, 818, 819, 820, 821, 822
    };

    public yf()
    {
        b = new ArrayList();
        a = ESceneMode.SCENE_MODE1;
        for (int i = 0; i < ESceneMode.SCENE_MODE_COUNT.ordinal(); i++)
        {
            HashMap hashmap = new HashMap();
            b.add(hashmap);
        }

        c(ESceneMode.SCENE_MODE1);
    }

    private boolean a(int i)
    {
        boolean flag1 = false;
        int j = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j < c.length)
                {
                    if (c[j] != i)
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

    private void c(ESceneMode escenemode)
    {
        Object obj;
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        obj = EOnlineResType.PIP_SCENE;
        if (escenemode == ESceneMode.SCENE_MODE2)
        {
            obj = EOnlineResType.PIP_SCENE2;
        }
        obj = FileManager.getInstance().unarchiveFilterManger(((EOnlineResType) (obj)));
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = (String)obj;
        Object obj1 = new Gson();
        new ArrayList();
        obj1 = (List)((Gson) (obj1)).fromJson(((String) (obj)), (new TypeToken() {

            final yf a;

            
            {
                a = yf.this;
                super();
            }
        }).getType());
        obj = new ArrayList();
        ArrayList arraylist = new ArrayList(1);
        if (obj1 != null)
        {
            int i = 0;
            while (i < ((List) (obj1)).size()) 
            {
                TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)((List) (obj1)).get(i);
                if (tdfsceneinfo.isShouldFirst())
                {
                    arraylist.add(tdfsceneinfo);
                } else
                {
                    ((List) (obj)).add(tdfsceneinfo);
                }
                i++;
            }
            if (arraylist.size() > 0)
            {
                for (int j = 0; j < arraylist.size(); j++)
                {
                    ((List) (obj)).add(0, (TDFSceneInfo)arraylist.get(j));
                }

            }
        }
        if (obj != null && ((List) (obj)).size() > 0) goto _L4; else goto _L3
_L3:
        return;
_L4:
        int k;
        if (!la.a(PIPCameraApplication.a, "ResetPipResID1", false))
        {
            la.b(PIPCameraApplication.a, "ResetPipResID1", true);
            HashMap hashmap = new HashMap();
            hashmap.put("bottle", Integer.valueOf(809));
            hashmap.put("return", Integer.valueOf(808));
            hashmap.put("umbrella", Integer.valueOf(274));
            hashmap.put("glass", Integer.valueOf(810));
            hashmap.put("bubble", Integer.valueOf(811));
            hashmap.put("Digital-photo-frame", Integer.valueOf(812));
            hashmap.put("Rearview-mirror", Integer.valueOf(813));
            hashmap.put("lace1", Integer.valueOf(814));
            hashmap.put("leopard2", Integer.valueOf(815));
            hashmap.put("leopard4", Integer.valueOf(816));
            hashmap.put("photo", Integer.valueOf(817));
            hashmap.put("magzine", Integer.valueOf(818));
            hashmap.put("pad", Integer.valueOf(819));
            hashmap.put("phone", Integer.valueOf(820));
            hashmap.put("Self-timer", Integer.valueOf(821));
            hashmap.put("mac", Integer.valueOf(822));
            hashmap.put("camera", Integer.valueOf(797));
            hashmap.put("magnifier", Integer.valueOf(795));
            hashmap.put("film", Integer.valueOf(796));
            ArrayList arraylist1 = new ArrayList();
            int l = 0;
            k = 0;
            for (; l < ((List) (obj)).size(); l++)
            {
                if (!hashmap.containsKey(((TDFSceneInfo)((List) (obj)).get(l)).name))
                {
                    continue;
                }
                ((TDFSceneInfo)((List) (obj)).get(l)).resId = ((Integer)hashmap.get(((TDFSceneInfo)((List) (obj)).get(l)).name)).intValue();
                if (a(((TDFSceneInfo)((List) (obj)).get(l)).resId))
                {
                    arraylist1.add((TDFSceneInfo)((List) (obj)).get(l));
                }
                k = 1;
            }

            ((List) (obj)).removeAll(arraylist1);
        } else
        {
            k = 0;
        }
        a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode, ((List) (obj)));
        if (k != 0)
        {
            a();
            b(ESceneMode.SCENE_MODE1);
        }
        k = ((flag1) ? 1 : 0);
        if (!la.a(PIPCameraApplication.a, "ResetPipResID3", false))
        {
            k = ((flag1) ? 1 : 0);
            if (la.a(PIPCameraApplication.a, "ResetPipResID1", false))
            {
                la.b(PIPCameraApplication.a, "ResetPipResID3", true);
                escenemode = new ArrayList();
                String as[] = new String[12];
                as[0] = "bottle";
                as[1] = "glasses";
                as[2] = "heart663";
                as[3] = "waterdrop601";
                as[4] = "film796";
                as[5] = "return808";
                as[6] = "bubble811";
                as[7] = "hourglass534";
                as[8] = "photoborder692";
                as[9] = "kissphoto679";
                as[10] = "perfumebottle932";
                as[11] = "CD668";
                HashMap hashmap1 = new HashMap();
                for (k = 0; k < as.length; k++)
                {
                    hashmap1.put(as[k], Integer.valueOf(0));
                }

                k = 0;
                for (int i1 = ((flag) ? 1 : 0); i1 < ((List) (obj)).size(); i1++)
                {
                    if (hashmap1.containsKey(((TDFSceneInfo)((List) (obj)).get(i1)).name))
                    {
                        escenemode.add(((List) (obj)).get(i1));
                        k = 1;
                    }
                }

                ((List) (obj)).removeAll(escenemode);
            }
        }
        if (k != 0)
        {
            a();
            b(ESceneMode.SCENE_MODE1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (escenemode == ESceneMode.SCENE_MODE1)
        {
            a();
            b(escenemode);
            la.b(PIPCameraApplication.a, "ResetPipResID3", true);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public TDFSceneInfo a(int i, ESceneCatalog escenecatalog, ESceneMode escenemode)
    {
        escenecatalog = a(escenecatalog, escenemode);
        if (i < 0 || escenecatalog == null || escenecatalog != null && i >= escenecatalog.size())
        {
            return null;
        } else
        {
            return (TDFSceneInfo)escenecatalog.get(i);
        }
    }

    public ESceneMode a(EOnlineResType eonlinerestype)
    {
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[EOnlineResType.values().length];
                try
                {
                    a[EOnlineResType.PIP_SCENE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[EOnlineResType.PIP_SCENE2.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2.a[eonlinerestype.ordinal()])
        {
        default:
            return ESceneMode.SCENE_MODE1;

        case 1: // '\001'
            return ESceneMode.SCENE_MODE1;

        case 2: // '\002'
            return ESceneMode.SCENE_MODE2;
        }
    }

    public List a(ESceneCatalog escenecatalog, ESceneMode escenemode)
    {
        return (List)((Map)b.get(escenemode.ordinal())).get(escenecatalog);
    }

    protected void a()
    {
        la.b(PIPCameraApplication.a, "ResetPipResID1", true);
        ESceneMode escenemode = ESceneMode.SCENE_MODE1;
        a(TDFSceneInfo.sceneByInfo(809, "bottle", "pipFrame/icon-bottle809.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/bottle.png", new Point(612, 612), new Rect(62, 30, 335, 605), "pipFrame/bottle_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(92, "glasses", "pipFrame/icon-glasses_3.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/Glasses_3.png", new Point(612, 612), new Rect(129, 205, 463, 599), "pipFrame/Glasses_3_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(663, "heart663", "pipFrame/icon-heart663.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/heart663.png", new Point(612, 612), new Rect(74, 124, 516, 502), "pipFrame/heart663_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(601, "waterdrop601", "pipFrame/icon-waterdrop601.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/waterdrop.png", new Point(612, 612), new Rect(203, 85, 522, 582), "pipFrame/waterdrop_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(796, "film796", "pipFrame/icon-film796.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/film796.png", new Point(612, 612), new Rect(60, 119, 529, 472), "pipFrame/film796_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(808, "return808", "pipFrame/icon-return808.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/return808.png", new Point(612, 612), new Rect(109, 50, 546, 536), "pipFrame/return808_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(811, "bubble811", "pipFrame/icon-bubble811.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/bubble811.png", new Point(612, 612), new Rect(63, 45, 508, 484), "pipFrame/bubble811_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(534, "hourglass534", "pipFrame/icon-hourglass534.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/hourglass534.png", new Point(612, 612), new Rect(315, 92, 588, 365), "pipFrame/hourglass534_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(692, "photoborder692", "pipFrame/icon-photoborder692.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/photoborder692.png", new Point(612, 612), new Rect(81, 76, 535, 530), "pipFrame/photoborder692_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(679, "kissphoto679", "pipFrame/icon-kissphoto679.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/kissphoto679.png", new Point(612, 612), new Rect(93, 44, 499, 447), "pipFrame/kissphoto679_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(932, "perfumebottle932", "pipFrame/icon-perfumebottle932.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/perfumebottle932.png", new Point(612, 612), new Rect(52, 221, 396, 562), "pipFrame/perfumebottle932_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        a(TDFSceneInfo.sceneByInfo(668, "CD668", "pipFrame/icon-CD668.jpg", EResType.ASSET, EResProcessType.OTHER, "pipFrame/CD668.png", new Point(612, 612), new Rect(52, 52, 561, 561), "pipFrame/CD668_mask.png", ESceneMode.SCENE_MODE1), ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
    }

    public void a(TResInfo tresinfo)
    {
        Object obj = a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, a);
        int i = 0;
        do
        {
label0:
            {
                if (i < ((List) (obj)).size())
                {
                    TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)((List) (obj)).get(i);
                    if (tdfsceneinfo.getResType() != EResType.NETWORK || tresinfo.resId != tdfsceneinfo.resId)
                    {
                        break label0;
                    }
                    ((List) (obj)).remove(tdfsceneinfo);
                    obj = (TDFSceneInfo)tresinfo;
                    if (tresinfo.folderName != null && tresinfo.folderName.length() > 0)
                    {
                        obj = FileManager.getInstance().getPipFileCache().a();
                        tresinfo = new File((new StringBuilder()).append(((String) (obj))).append("/").append(tresinfo.folderName).toString());
                        if (tresinfo.exists())
                        {
                            pb.a(tresinfo);
                        }
                    } else
                    {
                        i = ((TDFSceneInfo) (obj)).icon.lastIndexOf("/");
                        tresinfo = ((TDFSceneInfo) (obj)).icon.substring(i + 1);
                        FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.PIP_SCENE, tresinfo);
                        i = ((TDFSceneInfo) (obj)).framePath.lastIndexOf("/");
                        tresinfo = ((TDFSceneInfo) (obj)).framePath.substring(i + 1);
                        Log.v("PIpStyle NetWork frameFileName:", tresinfo);
                        FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.PIP_SCENE, tresinfo);
                        if (((TDFSceneInfo) (obj)).alphaTexturePath != null)
                        {
                            i = ((TDFSceneInfo) (obj)).alphaTexturePath.lastIndexOf("/");
                            tresinfo = ((TDFSceneInfo) (obj)).alphaTexturePath.substring(i + 1);
                            Log.v("alphaTexture fileName", tresinfo);
                            FileManager.getInstance().deleteOnlineBitmapRes(EOnlineResType.PIP_SCENE, tresinfo);
                        }
                    }
                    b(a);
                    tresinfo = new Intent("ACTION_MATERIAL_REMOVE");
                    if (a == ESceneMode.SCENE_MODE1)
                    {
                        tresinfo.putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.PIP_SCENE));
                    } else
                    if (a == ESceneMode.SCENE_MODE2)
                    {
                        tresinfo.putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.PIP_SCENE2));
                    }
                    PIPCameraApplication.a.sendBroadcast(tresinfo);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void a(TDFSceneInfo tdfsceneinfo)
    {
        if (tdfsceneinfo.getMode() == null)
        {
            tdfsceneinfo.setMode(ESceneMode.SCENE_MODE1);
        }
        List list = a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, tdfsceneinfo.getMode());
        if (list != null)
        {
            list.add(0, tdfsceneinfo);
        }
    }

    protected void a(TDFSceneInfo tdfsceneinfo, ESceneCatalog escenecatalog, ESceneMode escenemode)
    {
        Map map = (Map)b.get(escenemode.ordinal());
        escenemode = a(escenecatalog, escenemode);
        if (escenemode == null)
        {
            escenemode = new ArrayList();
            map.put(escenecatalog, escenemode);
            escenecatalog = escenemode;
        } else
        {
            escenecatalog = escenemode;
        }
        escenecatalog.add(tdfsceneinfo);
    }

    public void a(ESceneCatalog escenecatalog, ESceneMode escenemode, List list)
    {
        if (list != null)
        {
            ((Map)b.get(escenemode.ordinal())).put(escenecatalog, list);
        }
    }

    public void a(ESceneMode escenemode)
    {
        a = escenemode;
    }

    public void a(Object obj)
    {
        Intent intent;
        if (obj == null)
        {
            return;
        }
        obj = (TDFSceneInfo)obj;
        obj.mode = ESceneMode.SCENE_MODE1;
        ((TDFSceneInfo) (obj)).setResType(EResType.NETWORK);
        a(((TDFSceneInfo) (obj)));
        b(((TDFSceneInfo) (obj)).mode);
        intent = new Intent("ACTION_MATERIAL_ADDED");
        if (((TDFSceneInfo) (obj)).getMode() != ESceneMode.SCENE_MODE1) goto _L2; else goto _L1
_L1:
        intent.putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.PIP_SCENE));
        intent.putExtra("RESID_MATERIAL", ((TDFSceneInfo) (obj)).resId);
_L4:
        PIPCameraApplication.a.sendBroadcast(intent);
        return;
_L2:
        if (((TDFSceneInfo) (obj)).getMode() == ESceneMode.SCENE_MODE2)
        {
            intent.putExtra("TYPE_MATERIAL", tu.getStringByResType(EOnlineResType.PIP_SCENE2));
            intent.putExtra("RESID_MATERIAL", ((TDFSceneInfo) (obj)).resId);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean a(int i, int j, ESceneCatalog escenecatalog, ESceneMode escenemode)
    {
        escenecatalog = a(escenecatalog, escenemode);
        if (i < 0 || i >= escenecatalog.size() || j < 0 || j >= escenecatalog.size())
        {
            return false;
        }
        if (i == j)
        {
            return true;
        }
        escenemode = (TDFSceneInfo)escenecatalog.get(i);
        escenecatalog.remove(i);
        if (j >= escenecatalog.size())
        {
            escenecatalog.add(escenemode);
        } else
        {
            escenecatalog.add(j, escenemode);
        }
        return true;
    }

    public boolean a(int i, EOnlineResType eonlinerestype)
    {
        return a(i, a(eonlinerestype));
    }

    public boolean a(int i, ESceneMode escenemode)
    {
        if (i >= TPhotoMagComposeManager.KMAXADRESID) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((escenemode = a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode)) != null && escenemode.size() > 0)
        {
            int j = 0;
            while (j < escenemode.size()) 
            {
                if (((TDFSceneInfo)escenemode.get(j)).resId == i)
                {
                    return true;
                }
                j++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int b(TDFSceneInfo tdfsceneinfo, ESceneCatalog escenecatalog, ESceneMode escenemode)
    {
        escenecatalog = a(escenecatalog, escenemode);
        if (escenecatalog != null) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int i;
        boolean flag;
        escenecatalog.iterator();
        escenecatalog = escenecatalog.iterator();
        i = -1;
        do
        {
            if (!escenecatalog.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            i++;
            escenemode = (TDFSceneInfo)escenecatalog.next();
        } while (tdfsceneinfo.resId != ((TDFSceneInfo) (escenemode)).resId);
        flag = true;
_L4:
        if (flag)
        {
            return i;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag = false;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public TDFSceneInfo b(ESceneCatalog escenecatalog, ESceneMode escenemode)
    {
        for (escenecatalog = a(escenecatalog, escenemode).iterator(); escenecatalog.hasNext();)
        {
            escenemode = (TDFSceneInfo)escenecatalog.next();
            if (escenemode.getResType() == EResType.ASSET || escenemode.getResType() == EResType.NETWORK)
            {
                return escenemode;
            }
        }

        return null;
    }

    public List b()
    {
        Object obj = a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, a);
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)((Iterator) (obj)).next();
            if (tdfsceneinfo.getResType() == EResType.NETWORK && !tdfsceneinfo.isShouldFirst())
            {
                arraylist.add(tdfsceneinfo);
            }
        } while (true);
        return arraylist;
    }

    public void b(ESceneMode escenemode)
    {
        Object obj = a(ESceneCatalog.SCENE_RECTANGLE_SHAPE, escenemode);
        if (obj != null && ((List) (obj)).size() > 0)
        {
            String s = (new Gson()).toJson(obj);
            obj = EOnlineResType.PIP_SCENE;
            if (escenemode == ESceneMode.SCENE_MODE2)
            {
                obj = EOnlineResType.PIP_SCENE2;
            }
            FileManager.getInstance().archiveFilterManger(((EOnlineResType) (obj)), s);
        }
    }
}
