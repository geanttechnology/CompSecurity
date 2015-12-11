// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzdd, zzdc, zzbg, DataLayer, 
//            zzdf

public class zzdg extends zzdd
{

    private static final String ID;
    private static final String zzaZS;
    private static final String zzaZT;
    private static final String zzaZU;
    private static final String zzaZV;
    private static final String zzaZW;
    private static final String zzaZX;
    private static final String zzaZY;
    private static final String zzaZZ;
    private static final String zzbaa;
    private static final List zzbab = Arrays.asList(new String[] {
        "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"
    });
    private static final Pattern zzbac = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzbad = Pattern.compile("metric(\\d+)");
    private static Map zzbae;
    private static Map zzbaf;
    private final DataLayer zzaVR;
    private final Set zzbag;
    private final zzdc zzbah;

    public zzdg(Context context, DataLayer datalayer)
    {
        this(context, datalayer, new zzdc(context));
    }

    zzdg(Context context, DataLayer datalayer, zzdc zzdc1)
    {
        super(ID, new String[0]);
        zzaVR = datalayer;
        zzbah = zzdc1;
        zzbag = new HashSet();
        zzbag.add("");
        zzbag.add("0");
        zzbag.add("false");
    }

    private Promotion zzS(Map map)
    {
        Promotion promotion = new Promotion();
        String s = (String)map.get("id");
        if (s != null)
        {
            promotion.setId(String.valueOf(s));
        }
        s = (String)map.get("name");
        if (s != null)
        {
            promotion.setName(String.valueOf(s));
        }
        s = (String)map.get("creative");
        if (s != null)
        {
            promotion.setCreative(String.valueOf(s));
        }
        map = (String)map.get("position");
        if (map != null)
        {
            promotion.setPosition(String.valueOf(map));
        }
        return promotion;
    }

    private Product zzT(Map map)
    {
        Product product;
        Object obj;
        product = new Product();
        obj = map.get("id");
        if (obj != null)
        {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null)
        {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null)
        {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null)
        {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null)
        {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null)
        {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null)
        {
            product.setPosition(zzV(obj).intValue());
        }
        obj = map.get("price");
        if (obj != null)
        {
            product.setPrice(zzU(obj).doubleValue());
        }
        obj = map.get("quantity");
        if (obj != null)
        {
            product.setQuantity(zzV(obj).intValue());
        }
        obj = map.keySet().iterator();
_L2:
        String s;
        Matcher matcher;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)((Iterator) (obj)).next();
        matcher = zzbac.matcher(s);
        if (matcher.matches())
        {
            int i;
            try
            {
                i = Integer.parseInt(matcher.group(1));
            }
            catch (NumberFormatException numberformatexception)
            {
                zzbg.zzaH((new StringBuilder("illegal number in custom dimension value: ")).append(s).toString());
                continue; /* Loop/switch isn't completed */
            }
            product.setCustomDimension(i, String.valueOf(map.get(s)));
            continue; /* Loop/switch isn't completed */
        }
        numberformatexception = zzbad.matcher(s);
        if (!numberformatexception.matches())
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = Integer.parseInt(numberformatexception.group(1));
        product.setCustomMetric(j, zzV(map.get(s)).intValue());
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception1;
        numberformatexception1;
        zzbg.zzaH((new StringBuilder("illegal number in custom metric value: ")).append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
        return product;
    }

    private Double zzU(Object obj)
    {
        if (obj instanceof String)
        {
            try
            {
                obj = Double.valueOf((String)obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException((new StringBuilder("Cannot convert the object to Double: ")).append(((NumberFormatException) (obj)).getMessage()).toString());
            }
            return ((Double) (obj));
        }
        if (obj instanceof Integer)
        {
            return Double.valueOf(((Integer)obj).doubleValue());
        }
        if (obj instanceof Double)
        {
            return (Double)obj;
        } else
        {
            throw new RuntimeException((new StringBuilder("Cannot convert the object to Double: ")).append(obj.toString()).toString());
        }
    }

    private Map zzU(Map map)
    {
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaZZ);
        if (map != null)
        {
            return zzc(map);
        }
        if (zzbae == null)
        {
            map = new HashMap();
            map.put("transactionId", "&ti");
            map.put("transactionAffiliation", "&ta");
            map.put("transactionTax", "&tt");
            map.put("transactionShipping", "&ts");
            map.put("transactionTotal", "&tr");
            map.put("transactionCurrency", "&cu");
            zzbae = map;
        }
        return zzbae;
    }

    private Integer zzV(Object obj)
    {
        if (obj instanceof String)
        {
            try
            {
                obj = Integer.valueOf((String)obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException((new StringBuilder("Cannot convert the object to Integer: ")).append(((NumberFormatException) (obj)).getMessage()).toString());
            }
            return ((Integer) (obj));
        }
        if (obj instanceof Double)
        {
            return Integer.valueOf(((Double)obj).intValue());
        }
        if (obj instanceof Integer)
        {
            return (Integer)obj;
        } else
        {
            throw new RuntimeException((new StringBuilder("Cannot convert the object to Integer: ")).append(obj.toString()).toString());
        }
    }

    private Map zzV(Map map)
    {
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzbaa);
        if (map != null)
        {
            return zzc(map);
        }
        if (zzbaf == null)
        {
            map = new HashMap();
            map.put("name", "&in");
            map.put("sku", "&ic");
            map.put("category", "&iv");
            map.put("price", "&ip");
            map.put("quantity", "&iq");
            map.put("currency", "&cu");
            zzbaf = map;
        }
        return zzbaf;
    }

    private void zza(Tracker tracker, Map map)
    {
        String s = zzfj("transactionId");
        if (s != null) goto _L2; else goto _L1
_L1:
        zzbg.e("Cannot find transactionId in data layer.");
_L4:
        return;
_L2:
        LinkedList linkedlist;
        Object obj;
        linkedlist = new LinkedList();
        try
        {
            obj = zzm((com.google.android.gms.internal.zzag.zza)map.get(zzaZX));
            ((Map) (obj)).put("&t", "transaction");
            java.util.Map.Entry entry;
            for (Iterator iterator = zzU(map).entrySet().iterator(); iterator.hasNext(); zze(((Map) (obj)), (String)entry.getValue(), zzfj((String)entry.getKey())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Tracker tracker)
        {
            zzbg.zzb("Unable to send transaction", tracker);
            return;
        }
        linkedlist.add(obj);
        obj = zzfk("transactionProducts");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_347;
        }
        obj = ((List) (obj)).iterator();
_L3:
        Map map1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_347;
        }
        map1 = (Map)((Iterator) (obj)).next();
        if (map1.get("name") == null)
        {
            zzbg.e("Unable to send transaction item hit due to missing 'name' field.");
            return;
        }
        Map map2;
        map2 = zzm((com.google.android.gms.internal.zzag.zza)map.get(zzaZX));
        map2.put("&t", "item");
        map2.put("&ti", s);
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = zzV(map).entrySet().iterator(); iterator1.hasNext(); zze(map2, (String)entry1.getValue(), (String)map1.get(entry1.getKey())))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        linkedlist.add(map2);
          goto _L3
        map = linkedlist.iterator();
        while (map.hasNext()) 
        {
            tracker.send((Map)map.next());
        }
          goto _L4
    }

    private void zzb(Tracker tracker, Map map)
    {
        com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder screenviewbuilder = new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder();
        Object obj = zzm((com.google.android.gms.internal.zzag.zza)map.get(zzaZX));
        screenviewbuilder.setAll(((Map) (obj)));
        if (zzj(map, zzaZV))
        {
            map = ((Map) (zzaVR.get("ecommerce")));
            Object obj1;
            RuntimeException runtimeexception;
            Map map1;
            RuntimeException runtimeexception1;
            boolean flag;
            if (map instanceof Map)
            {
                map = (Map)map;
            } else
            {
                map = null;
            }
        } else
        {
            map = ((Map) (zzdf.zzl((com.google.android.gms.internal.zzag.zza)map.get(zzaZW))));
            if (map instanceof Map)
            {
                map = (Map)map;
            } else
            {
                map = null;
            }
        }
        if (map == null) goto _L2; else goto _L1
_L1:
        obj1 = (String)((Map) (obj)).get("&cu");
        obj = obj1;
        if (obj1 == null)
        {
            obj = (String)map.get("currencyCode");
        }
        if (obj != null)
        {
            screenviewbuilder.set("&cu", ((String) (obj)));
        }
        obj = map.get("impressions");
        if (obj instanceof List)
        {
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext();)
            {
                obj1 = (Map)((Iterator) (obj)).next();
                try
                {
                    screenviewbuilder.addImpression(zzT(((Map) (obj1))), (String)((Map) (obj1)).get("list"));
                }
                // Misplaced declaration of an exception variable
                catch (RuntimeException runtimeexception)
                {
                    zzbg.e((new StringBuilder("Failed to extract a product from DataLayer. ")).append(runtimeexception.getMessage()).toString());
                }
            }

        }
        if (map.containsKey("promoClick"))
        {
            obj = (List)((Map)map.get("promoClick")).get("promotions");
        } else
        if (map.containsKey("promoView"))
        {
            obj = (List)((Map)map.get("promoView")).get("promotions");
        } else
        {
            obj = null;
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            runtimeexception = (Map)((Iterator) (obj)).next();
            try
            {
                screenviewbuilder.addPromotion(zzS(runtimeexception));
            }
            // Misplaced declaration of an exception variable
            catch (RuntimeException runtimeexception)
            {
                zzbg.e((new StringBuilder("Failed to extract a promotion from DataLayer. ")).append(runtimeexception.getMessage()).toString());
            }
        }

        if (!map.containsKey("promoClick")) goto _L6; else goto _L5
_L5:
        screenviewbuilder.set("&promoa", "click");
        flag = false;
_L12:
        if (!flag) goto _L2; else goto _L7
_L7:
        runtimeexception = zzbab.iterator();
_L10:
        if (!runtimeexception.hasNext()) goto _L2; else goto _L8
_L8:
        obj = (String)runtimeexception.next();
        if (!map.containsKey(obj)) goto _L10; else goto _L9
_L9:
        map = (Map)map.get(obj);
        runtimeexception = (List)map.get("products");
        if (runtimeexception != null)
        {
            for (runtimeexception = runtimeexception.iterator(); runtimeexception.hasNext();)
            {
                map1 = (Map)runtimeexception.next();
                try
                {
                    screenviewbuilder.addProduct(zzT(map1));
                }
                // Misplaced declaration of an exception variable
                catch (RuntimeException runtimeexception1)
                {
                    zzbg.e((new StringBuilder("Failed to extract a product from DataLayer. ")).append(runtimeexception1.getMessage()).toString());
                }
            }

        }
          goto _L11
_L6:
        screenviewbuilder.set("&promoa", "view");
_L4:
        flag = true;
          goto _L12
_L11:
        if (!map.containsKey("actionField")) goto _L14; else goto _L13
_L13:
        map = zzd(((String) (obj)), (Map)map.get("actionField"));
_L15:
        screenviewbuilder.setProductAction(map);
_L2:
        tracker.send(screenviewbuilder.build());
        return;
_L14:
        map = new ProductAction(((String) (obj)));
          goto _L15
        map;
        zzbg.e((new StringBuilder("Failed to extract a product action from DataLayer. ")).append(map.getMessage()).toString());
          goto _L2
    }

    private Map zzc(com.google.android.gms.internal.zzag.zza zza1)
    {
        zza1 = ((com.google.android.gms.internal.zzag.zza) (zzdf.zzl(zza1)));
        if (!(zza1 instanceof Map))
        {
            return null;
        }
        Object obj = (Map)zza1;
        zza1 = new LinkedHashMap();
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); zza1.put(entry.getKey().toString(), entry.getValue().toString()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        return zza1;
    }

    private ProductAction zzd(String s, Map map)
    {
        s = new ProductAction(s);
        Object obj = map.get("id");
        if (obj != null)
        {
            s.setTransactionId(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null)
        {
            s.setTransactionAffiliation(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null)
        {
            s.setTransactionCouponCode(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null)
        {
            s.setProductActionList(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null)
        {
            s.setCheckoutOptions(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null)
        {
            s.setTransactionRevenue(zzU(obj).doubleValue());
        }
        obj = map.get("tax");
        if (obj != null)
        {
            s.setTransactionTax(zzU(obj).doubleValue());
        }
        obj = map.get("shipping");
        if (obj != null)
        {
            s.setTransactionShipping(zzU(obj).doubleValue());
        }
        map = ((Map) (map.get("step")));
        if (map != null)
        {
            s.setCheckoutStep(zzV(map).intValue());
        }
        return s;
    }

    private void zze(Map map, String s, String s1)
    {
        if (s1 != null)
        {
            map.put(s, s1);
        }
    }

    private String zzfj(String s)
    {
        s = ((String) (zzaVR.get(s)));
        if (s == null)
        {
            return null;
        } else
        {
            return s.toString();
        }
    }

    private List zzfk(String s)
    {
        s = ((String) (zzaVR.get(s)));
        if (s == null)
        {
            return null;
        }
        if (!(s instanceof List))
        {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Iterator iterator = ((List)s).iterator(); iterator.hasNext();)
        {
            if (!(iterator.next() instanceof Map))
            {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }

        return (List)s;
    }

    private boolean zzj(Map map, String s)
    {
        map = (com.google.android.gms.internal.zzag.zza)map.get(s);
        if (map == null)
        {
            return false;
        } else
        {
            return zzdf.zzk(map).booleanValue();
        }
    }

    private Map zzm(com.google.android.gms.internal.zzag.zza zza1)
    {
        if (zza1 == null)
        {
            return new HashMap();
        }
        zza1 = zzc(zza1);
        if (zza1 == null)
        {
            return new HashMap();
        }
        String s = (String)zza1.get("&aip");
        if (s != null && zzbag.contains(s.toLowerCase()))
        {
            zza1.remove("&aip");
        }
        return zza1;
    }

    public volatile String zzCT()
    {
        return super.zzCT();
    }

    public volatile Set zzCU()
    {
        return super.zzCU();
    }

    public volatile boolean zzCo()
    {
        return super.zzCo();
    }

    public volatile com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        return super.zzI(map);
    }

    public void zzK(Map map)
    {
        Tracker tracker = zzbah.zzfb("_GTM_DEFAULT_TRACKER_");
        tracker.enableAdvertisingIdCollection(zzj(map, "collect_adid"));
        if (zzj(map, zzaZU))
        {
            zzb(tracker, map);
            return;
        }
        if (zzj(map, zzaZT))
        {
            tracker.send(zzm((com.google.android.gms.internal.zzag.zza)map.get(zzaZX)));
            return;
        }
        if (zzj(map, zzaZY))
        {
            zza(tracker, map);
            return;
        } else
        {
            zzbg.zzaH("Ignoring unknown tag.");
            return;
        }
    }

    static 
    {
        ID = zzad.zzcE.toString();
        zzaZS = zzae.zzdl.toString();
        zzaZT = zzae.zzdv.toString();
        zzaZU = zzae.zzeQ.toString();
        zzaZV = zzae.zzeK.toString();
        zzaZW = zzae.zzeJ.toString();
        zzaZX = zzae.zzdu.toString();
        zzaZY = zzae.zzhn.toString();
        zzaZZ = zzae.zzhq.toString();
        zzbaa = zzae.zzhs.toString();
    }
}
