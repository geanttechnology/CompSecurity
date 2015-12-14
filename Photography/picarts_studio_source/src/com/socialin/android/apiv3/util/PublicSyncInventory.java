// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.util;

import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicSyncInventory
{

    public static final String KEY_PUBLIC_USER = "public";
    private static long fileChangeDate = 0L;
    private static final long invFileLastModifiedTimeout = 20000L;
    private static String shopFileName;
    private static String shopFilePath;
    private static String shopFileRootPath;
    private static ArrayList userLocalShopItems = null;

    public PublicSyncInventory()
    {
    }

    public static void createEmptyInventoryFile()
    {
        File file;
        file = new File(shopFileRootPath);
        file.mkdirs();
        file = new File(file, (new StringBuilder()).append(shopFileName).append("public").toString());
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_58;
        }
        file.createNewFile();
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return;
    }

    public static String getShopFilePath()
    {
        return (new StringBuilder()).append(shopFilePath).append("public").toString();
    }

    public static boolean hasData()
    {
        return (new File((new StringBuilder()).append(shopFilePath).append("public").toString())).exists();
    }

    public static boolean isAdsRemoved()
    {
        return (new File((new StringBuilder()).append(shopFileRootPath).append("state").toString())).exists();
    }

    public static boolean publicInventoryFileExists()
    {
        File file = new File(shopFileRootPath);
        file.mkdirs();
        return (new File(file, (new StringBuilder()).append(shopFileName).append("public").toString())).exists();
    }

    public static ArrayList readUserLocalShopItems()
    {
        d.b("PublicSyncInventory", new Object[] {
            "getUserShopItems:  userId= public"
        });
        return updateLocalShopItems(false);
    }

    private static JSONArray readUserShopItems()
    {
        Object obj2 = null;
        Object obj;
        d.b("PublicSyncInventory", new Object[] {
            (new StringBuilder(" readUserShopItems ")).append(shopFilePath).append("public").toString()
        });
        obj = new File((new StringBuilder()).append(shopFilePath).append("public").toString());
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        abyte0 = new byte[(int)((File) (obj)).length()];
        obj = new RandomAccessFile(((File) (obj)), "r");
        Object obj1;
        ((RandomAccessFile) (obj)).read(abyte0);
        obj1 = new JSONArray(new String(abyte0));
        obj = obj1;
_L7:
        obj1 = obj;
_L4:
        return ((JSONArray) (obj1));
        Exception exception;
        exception;
        obj = null;
_L5:
        exception.printStackTrace();
        exception = obj2;
        if (obj == null) goto _L4; else goto _L3
_L3:
        try
        {
            ((RandomAccessFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            return null;
        }
        return null;
        exception;
          goto _L5
_L2:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void removeInventoryData()
    {
        userLocalShopItems = null;
        File file = new File((new StringBuilder()).append(shopFilePath).append("public").toString());
        if (file.exists())
        {
            file.delete();
        }
    }

    public static boolean removeShopItem(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        JSONArray jsonarray;
        JSONArray jsonarray2;
        int i;
        int j;
        if (shopitem == null)
        {
            return false;
        }
        JSONArray jsonarray1 = readUserShopItems();
        jsonarray2 = new JSONArray();
        jsonarray = jsonarray1;
        if (jsonarray1 == null)
        {
            jsonarray = new JSONArray();
        }
        j = jsonarray.length();
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        if (!jsonobject.getString("id").equals(shopitem.id))
        {
            jsonarray2.put(jsonobject);
            break MISSING_BLOCK_LABEL_132;
        }
        try
        {
            d.b("PublicSyncInventory", new Object[] {
                (new StringBuilder("Remove: ")).append(shopitem.data.shopItemUid).toString()
            });
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_132;
        return writeUserShopItems(jsonarray2, true);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void reset()
    {
        if (userLocalShopItems != null)
        {
            userLocalShopItems.clear();
        }
        userLocalShopItems = null;
    }

    public static void setAdsState(boolean flag)
    {
        File file;
        file = new File((new StringBuilder()).append(shopFileRootPath).append("state").toString());
        if (file.exists())
        {
            file.delete();
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        file.createNewFile();
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        return;
    }

    private static ArrayList updateLocalShopItems()
    {
        int i;
        i = 0;
        d.b("PublicSyncInventory", new Object[] {
            "updateLocalShopItems:  userId= public"
        });
        if (userLocalShopItems == null)
        {
            userLocalShopItems = new ArrayList();
        }
        if (!(new File((new StringBuilder()).append(shopFilePath).append("public").toString())).exists()) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        jsonarray = readUserShopItems();
        userLocalShopItems.clear();
        if (jsonarray == null) goto _L2; else goto _L3
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        userLocalShopItems.add(new com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem(jsonobject));
        i++;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
        exception.printStackTrace();
_L2:
        return userLocalShopItems;
    }

    public static ArrayList updateLocalShopItems(boolean flag)
    {
        if (flag)
        {
            return updateLocalShopItems();
        }
        long l = (new File((new StringBuilder()).append(shopFilePath).append("public").toString())).lastModified();
        if (l != fileChangeDate || userLocalShopItems == null)
        {
            fileChangeDate = l;
            return updateLocalShopItems();
        } else
        {
            return userLocalShopItems;
        }
    }

    private static void updateLocalShopItemsFromJson(JSONArray jsonarray)
    {
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            userLocalShopItems.add(new com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem(jsonobject));
        }

    }

    public static boolean writeShopItem(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        boolean flag1 = false;
        if (shopitem == null)
        {
            return false;
        }
        ArrayList arraylist = updateLocalShopItems(true);
        if (arraylist == null)
        {
            arraylist = new ArrayList();
        }
        Iterator iterator = arraylist.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next()).id.equals(shopitem.id))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        if (!flag)
        {
            arraylist.add(shopitem);
        }
        return writeUserShopItems(arraylist, true);
    }

    public static boolean writeUserShopItems(ArrayList arraylist, boolean flag)
    {
        if (arraylist == null)
        {
            return false;
        }
        JSONArray jsonarray = new JSONArray();
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next();
            try
            {
                jsonarray.put(shopitem.toSimpleJson());
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }

        return writeUserShopItems(jsonarray, flag);
    }

    public static boolean writeUserShopItems(JSONArray jsonarray, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        File file;
        boolean flag1;
        flag1 = true;
        d.b("PublicSyncInventory", new Object[] {
            (new StringBuilder(" writeUserShopItems ")).append(shopFilePath).append("public").toString()
        });
        obj3 = null;
        obj4 = null;
        file = null;
        obj1 = file;
        obj2 = obj3;
        obj = obj4;
        if (!FileUtils.a())
        {
            break MISSING_BLOCK_LABEL_287;
        }
        obj1 = file;
        obj2 = obj3;
        obj = obj4;
        if (TextUtils.isEmpty("public"))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        obj1 = file;
        obj2 = obj3;
        obj = obj4;
        if (TextUtils.isEmpty("public"))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        obj2 = obj3;
        obj = obj4;
        obj1 = new File(shopFileRootPath);
        obj2 = obj3;
        obj = obj4;
        ((File) (obj1)).mkdirs();
        obj2 = obj3;
        obj = obj4;
        file = new File(((File) (obj1)), (new StringBuilder()).append(shopFileName).append("public").toString());
        obj2 = obj3;
        obj = obj4;
        if (!file.exists() || flag)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        obj2 = obj3;
        obj = obj4;
        if (System.currentTimeMillis() - file.lastModified() < 20000L)
        {
            return false;
        }
        obj2 = obj3;
        obj = obj4;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_240;
        }
        obj2 = obj3;
        obj = obj4;
        file.createNewFile();
        obj2 = obj3;
        obj = obj4;
        obj1 = new FileOutputStream(file);
        ((FileOutputStream) (obj1)).write(jsonarray.toString().getBytes(e.a));
        ((FileOutputStream) (obj1)).flush();
        ((FileOutputStream) (obj1)).close();
        fileChangeDate = file.lastModified();
        obj2 = obj1;
        obj = obj1;
        if (userLocalShopItems != null) goto _L2; else goto _L1
_L1:
        obj2 = obj1;
        obj = obj1;
        userLocalShopItems = new ArrayList();
_L3:
        obj2 = obj1;
        obj = obj1;
        updateLocalShopItemsFromJson(jsonarray);
        flag = flag1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_336;
        }
        ((FileOutputStream) (obj1)).close();
        flag = flag1;
_L4:
        return flag;
_L2:
        obj2 = obj1;
        obj = obj1;
        userLocalShopItems.clear();
          goto _L3
        jsonarray;
_L7:
        obj = obj2;
        jsonarray.printStackTrace();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        ((FileOutputStream) (obj2)).close();
        flag = false;
          goto _L4
        jsonarray;
        jsonarray.printStackTrace();
        flag = flag1;
          goto _L4
        jsonarray;
        jsonarray.printStackTrace();
        flag = false;
          goto _L4
        jsonarray;
_L6:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw jsonarray;
        jsonarray;
        obj = obj1;
        if (true) goto _L6; else goto _L5
_L5:
        jsonarray;
        obj2 = obj1;
          goto _L7
        flag = false;
          goto _L4
    }

    static 
    {
        fileChangeDate = -1L;
        shopFileName = "user_shop_items_";
        shopFileRootPath = (new StringBuilder()).append(SocialinV3.getInstance().getFilesDirPath()).append("/").toString();
        shopFilePath = (new StringBuilder()).append(shopFileRootPath).append(shopFileName).toString();
    }
}
