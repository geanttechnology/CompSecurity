// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.util;

import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ah;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import myobfuscated.bn.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.util:
//            PublicSyncInventory

public class Inventory
{

    private static final String INVENTORY_FILE_NAME = "inv_app_user_items_new";
    private static final long invFileLastModifiedTimeout = 20000L;
    private static long inventoryChangeDate = -1L;
    private static String inventoryFilePath = (new StringBuilder()).append(SocialinV3.getInstance().getFilesDirPath()).append("/inv_app_user_items_new").toString();
    private static String oldInventoryFilePath = (new StringBuilder()).append(SocialinV3.getInstance().getFilesDirPath()).append("/inv_app_user_items").toString();
    private static ArrayList userShopItems = null;

    public Inventory()
    {
    }

    public static void addShopItem(JSONObject jsonobject)
    {
        JSONArray jsonarray = getUserShopItemsJSONArray(inventoryFilePath);
        JSONArray jsonarray1 = new JSONArray();
        if (jsonarray == null)
        {
            return;
        }
        int j = jsonarray.length();
        int i = 0;
        while (i < j) 
        {
            try
            {
                JSONObject jsonobject1 = jsonarray.getJSONObject(i);
                if (!jsonobject1.getString("id").equals(jsonobject.getString("id")))
                {
                    jsonarray1.put(jsonobject1);
                }
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            i++;
        }
        jsonarray1.put(jsonobject);
        setUserShopItems(jsonarray1, true);
    }

    private static boolean checkAdsEnabled(ArrayList arraylist)
    {
        if (arraylist.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        arraylist = arraylist.iterator();
        boolean flag = true;
_L2:
        boolean flag1 = flag;
        boolean flag2;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = "ad_remover".equals(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next()).data.shopItemUid);
        if (flag2)
        {
            flag = false;
        }
        if (true) goto _L2; else goto _L1
        arraylist;
        flag = true;
_L3:
        arraylist.printStackTrace();
        flag1 = flag;
_L1:
        return flag1 && !PublicSyncInventory.isAdsRemoved();
        arraylist;
          goto _L3
        flag1 = true;
          goto _L1
    }

    private static String decrypt(byte abyte0[], String s)
    {
        s = new SecretKeySpec(s.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(2, s);
        abyte0 = new String(cipher.doFinal(abyte0));
        return abyte0;
        abyte0;
        abyte0.printStackTrace();
_L2:
        return "";
        abyte0;
        abyte0.printStackTrace();
        continue; /* Loop/switch isn't completed */
        abyte0;
        abyte0.printStackTrace();
        continue; /* Loop/switch isn't completed */
        abyte0;
        abyte0.printStackTrace();
        continue; /* Loop/switch isn't completed */
        abyte0;
        abyte0.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static byte[] encrypt(String s, String s1)
    {
        s1 = new SecretKeySpec(s1.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(1, s1);
        s = cipher.doFinal(s.getBytes());
        return s;
        s;
        s.printStackTrace();
_L2:
        return new byte[0];
        s;
        s.printStackTrace();
        continue; /* Loop/switch isn't completed */
        s;
        s.printStackTrace();
        continue; /* Loop/switch isn't completed */
        s;
        s.printStackTrace();
        continue; /* Loop/switch isn't completed */
        s;
        s.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getExternalCacheDirectory()
    {
        return inventoryFilePath;
    }

    public static ArrayList getUserShopItems()
    {
        return (ArrayList)updateShopItems(false).clone();
    }

    private static JSONArray getUserShopItemsFromOldFile(String s)
    {
        JSONArray jsonarray = null;
        byte abyte0[];
        s = new File(s);
        if (!s.exists())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        abyte0 = new byte[(int)s.length()];
        s = new RandomAccessFile(s, "r");
        String s1;
        int i;
        s.read(abyte0);
        s1 = new String(abyte0);
        i = s1.length();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        JSONArray jsonarray1 = new JSONArray(ah.a(s1, ah.a(SocialinV3.getInstance().getUser().key)));
        jsonarray = jsonarray1;
_L1:
        return jsonarray;
        Exception exception;
        exception;
        exception = new JSONArray(ah.b(s1));
        s = exception;
_L3:
        return s;
        s;
        s = null;
_L2:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            return null;
        }
          goto _L1
        exception;
          goto _L2
        s = null;
          goto _L3
    }

    private static JSONArray getUserShopItemsJSONArray(String s)
    {
        String s1 = null;
        s = new File(s);
        if (!s.exists()) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        abyte0 = new byte[(int)s.length()];
        s = new RandomAccessFile(s, "r");
        s.read(abyte0);
        if (abyte0.length <= 0) goto _L2; else goto _L3
_L3:
        JSONArray jsonarray = new JSONArray(decrypt(abyte0, ah.a(SocialinV3.getInstance().getUser().key)));
        s = jsonarray;
_L8:
        s1 = s;
_L5:
        return s1;
        s;
        s = null;
_L6:
        if (s == null) goto _L5; else goto _L4
_L4:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return null;
        Exception exception;
        exception;
          goto _L6
          goto _L5
_L2:
        s = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static boolean hasData()
    {
        return (new File(inventoryFilePath)).exists();
    }

    public static boolean isAdsEnabled()
    {
        boolean flag;
        try
        {
            flag = checkAdsEnabled(getUserShopItems());
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            flag = true;
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
            flag = true;
        }
        return flag && !a.a();
    }

    public static boolean isEditorAdsEnabled()
    {
        boolean flag;
        boolean flag2;
        flag = SocialinV3.getInstance().getSettings().isEditorAdsEnabled();
        flag2 = flag;
        if (!flag) goto _L2; else goto _L1
_L1:
        boolean flag1 = flag;
        Object obj = SocialinV3.getInstance().getAppProps().getData();
        flag1 = flag;
        if (((com.socialin.android.apiv3.model.AppProps.Data) (obj)).inviteData == null) goto _L4; else goto _L3
_L3:
        flag1 = flag;
        obj = ((com.socialin.android.apiv3.model.AppProps.Data) (obj)).inviteData.rewardPackage;
_L7:
        flag1 = flag;
        flag2 = flag;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        Object obj1 = getUserShopItems();
        flag1 = flag;
        flag2 = flag;
        if (((ArrayList) (obj1)).isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        obj1 = ((ArrayList) (obj1)).iterator();
_L6:
        flag1 = flag;
        flag2 = flag;
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        flag2 = ((String) (obj)).equals(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)((Iterator) (obj1)).next()).data.shopItemUid);
        if (flag2)
        {
            flag = false;
        }
        if (true) goto _L6; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
_L4:
        obj = null;
        if (true) goto _L7; else goto _L2
        Exception exception;
        exception;
        exception.printStackTrace();
        flag2 = flag1;
_L2:
        return flag2;
    }

    public static void removeInventoryData()
    {
        userShopItems = null;
        File file = new File(inventoryFilePath);
        (new StringBuilder("INVENTORY FILE EXISTS = ")).append(file.exists());
        if (file.exists())
        {
            file.delete();
        }
    }

    public static void removeShopItem(String s)
    {
        JSONArray jsonarray = getUserShopItemsJSONArray(inventoryFilePath);
        JSONArray jsonarray1 = new JSONArray();
        if (jsonarray == null)
        {
            return;
        }
        int j = jsonarray.length();
        int i = 0;
        while (i < j) 
        {
            try
            {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                if (!jsonobject.getString("id").equals(s))
                {
                    jsonarray1.put(jsonobject);
                }
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            i++;
        }
        setUserShopItems(jsonarray1, true);
    }

    public static void reset()
    {
        userShopItems = null;
    }

    public static void restoreShopItems()
    {
        File file = new File(oldInventoryFilePath);
        File file1 = new File(inventoryFilePath);
        if (file.exists() && !file1.exists() && setUserShopItems(getUserShopItemsFromOldFile(oldInventoryFilePath), true))
        {
            file.delete();
        }
    }

    public static boolean setUserShopItems(JSONArray jsonarray, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        File file;
        boolean flag1;
        flag1 = false;
        obj3 = null;
        obj4 = null;
        file = null;
        obj1 = file;
        obj2 = obj3;
        obj = obj4;
        if (!FileUtils.a())
        {
            break MISSING_BLOCK_LABEL_224;
        }
        obj1 = file;
        obj2 = obj3;
        obj = obj4;
        if (SocialinV3.getInstance().getUser() == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        obj2 = obj3;
        obj = obj4;
        obj1 = new File(SocialinV3.getInstance().getFilesDirPath());
        obj2 = obj3;
        obj = obj4;
        ((File) (obj1)).mkdirs();
        obj2 = obj3;
        obj = obj4;
        file = new File(((File) (obj1)), "inv_app_user_items_new");
        obj2 = obj3;
        obj = obj4;
        if (!file.exists() || flag)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj2 = obj3;
        obj = obj4;
        if (System.currentTimeMillis() - file.lastModified() < 20000L)
        {
            return false;
        }
        obj2 = obj3;
        obj = obj4;
        obj1 = new FileOutputStream(file);
        obj = ah.a(SocialinV3.getInstance().getUser().key);
        ((FileOutputStream) (obj1)).write(encrypt(jsonarray.toString(), ((String) (obj))));
        ((FileOutputStream) (obj1)).flush();
        ((FileOutputStream) (obj1)).close();
        inventoryChangeDate = file.lastModified();
        obj = new File(oldInventoryFilePath);
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        obj2 = obj1;
        obj = obj1;
        if (userShopItems != null) goto _L2; else goto _L1
_L1:
        obj2 = obj1;
        obj = obj1;
        userShopItems = new ArrayList();
_L4:
        obj2 = obj1;
        obj = obj1;
        updateShopItemsFromJson(jsonarray);
        flag = true;
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                jsonarray.printStackTrace();
                return true;
            }
            return true;
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj2 = obj1;
        obj = obj1;
        userShopItems.clear();
        if (true) goto _L4; else goto _L3
        jsonarray;
_L9:
        obj = obj2;
        jsonarray.printStackTrace();
        obj = obj2;
        ExceptionReportService.report(SocialinV3.getInstance().getContext(), jsonarray, String.valueOf(SocialinV3.getInstance().getUser().id));
_L6:
        flag = flag1;
        if (obj2 != null)
        {
            try
            {
                ((FileOutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray)
            {
                jsonarray.printStackTrace();
                return false;
            }
            return false;
        }
        break; /* Loop/switch isn't completed */
        jsonarray;
        obj = obj2;
        jsonarray.printStackTrace();
        if (true) goto _L6; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
        jsonarray;
_L8:
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
        if (true) goto _L8; else goto _L7
_L7:
        jsonarray;
        obj2 = obj1;
        if (true) goto _L9; else goto _L3
_L3:
        return flag;
    }

    private static ArrayList updateShopItems()
    {
        if (userShopItems == null)
        {
            userShopItems = new ArrayList();
        }
        if (!(new File(inventoryFilePath)).exists()) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        jsonarray = getUserShopItemsJSONArray(inventoryFilePath);
        userShopItems.clear();
        int i = 0;
        do
        {
            try
            {
                if (i >= jsonarray.length())
                {
                    break;
                }
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                userShopItems.add(new com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem(jsonobject));
            }
            catch (Exception exception)
            {
                break;
            }
            i++;
        } while (true);
_L2:
        checkAdsEnabled(userShopItems);
        return userShopItems;
    }

    public static ArrayList updateShopItems(boolean flag)
    {
        if (flag)
        {
            return updateShopItems();
        }
        long l = (new File(inventoryFilePath)).lastModified();
        if (l != inventoryChangeDate || userShopItems == null)
        {
            inventoryChangeDate = l;
            return updateShopItems();
        } else
        {
            return userShopItems;
        }
    }

    private static void updateShopItemsFromJson(JSONArray jsonarray)
    {
        for (int i = 0; i < jsonarray.length(); i++)
        {
            com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = new com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem(jsonarray.getJSONObject(i));
            userShopItems.add(shopitem);
        }

    }

}
