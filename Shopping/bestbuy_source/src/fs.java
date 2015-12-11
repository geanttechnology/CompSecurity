// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import com.bestbuy.android.api.lib.models.blueshirt.FeatureFlagResponse;
import com.bestbuy.android.api.lib.models.browse.UberCategoryList;
import com.bestbuy.android.api.lib.models.capi.lookup.GiftCard;
import com.bestbuy.android.api.lib.models.cart.CartResponse;
import com.bestbuy.android.api.lib.models.deals.StoreDeals;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewedResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.pdp.castandcrew.CastAndCrewParent;
import com.bestbuy.android.api.lib.models.pdp.episodes.PDPEpisodesParent;
import com.bestbuy.android.api.lib.models.pdpaccessories.AccessoriesResponse;
import com.bestbuy.android.api.lib.models.pdpbuyingoptions.BuyingOptionsResponse;
import com.bestbuy.android.api.lib.models.pdpfeaturereviews.FeatureReviewsResponse;
import com.bestbuy.android.api.lib.models.pdpmovies.MoviesResponse;
import com.bestbuy.android.api.lib.models.pdpmusic.MusicResponse;
import com.bestbuy.android.api.lib.models.pdpreviews.ReviewsResponse;
import com.bestbuy.android.api.lib.models.registry.Entity;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.api.lib.models.registry.Recommendations;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.RegistryWishListCompleteData;
import com.bestbuy.android.api.lib.models.registry.ShareURL;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.api.lib.models.releasemgt.SupportedVersionsResponse;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class fs
{

    public static String a = "";

    public static Address a(Context context, double d1, double d2)
    {
        return gi.a(context, d1, d2);
    }

    public static FeatureFlagResponse a(Activity activity, String s, String s1, String s2)
    {
        String s4 = s;
        String s3 = s1;
        if (s2 != null)
        {
            s2 = gi.a(activity, s2);
            s4 = s;
            s3 = s1;
            if (s2 != null)
            {
                s4 = (new StringBuilder()).append("").append(s2.getLatitude()).toString();
                s3 = (new StringBuilder()).append("").append(s2.getLongitude()).toString();
            }
        }
        return gq.a(activity, s4, s3);
    }

    public static GiftCard a(ft ft1, String s, String s1)
    {
        return fy.a(ft1, s, s1);
    }

    public static DNMResponse a(double d1, double d2, int i1, int j1, int k1, String s, 
            String s1, String s2, ArrayList arraylist, String s3, String s4)
    {
        return gc.a(d1, d2, i1, j1, k1, s, s1, s2, arraylist, s3, s4);
    }

    public static DNMResponse a(String s, double d1, double d2, int i1, int j1, int k1, 
            String s1, ArrayList arraylist, String s2, String s3)
    {
        return gc.a(s, d1, d2, i1, j1, k1, s1, arraylist, s2, s3);
    }

    public static RecentlyViewedAlsoViewedResponse a(Context context, Recommendation recommendation)
    {
        if (!gf.a(context))
        {
            gf.a(context, gg.b());
        }
        return gq.a(gf.b(context), recommendation);
    }

    public static FeatureReviewsResponse a(String s, String s1, int i1, String s2)
    {
        return gq.a(s, s1, i1, s2);
    }

    public static ReviewsResponse a(String s, int i1, int j1, String s1)
    {
        return gq.a(s, i1, j1, s1);
    }

    public static LoggedInUserProfile a(String s, String s1)
    {
        s = gj.e(s, s1);
        if (s.isHasError()) goto _L2; else goto _L1
_L1:
        boolean flag;
        s.setRefreshToken(s.getAccess_token());
        try
        {
            s1 = gj.d(((Entity)s.getEntities().get(0)).getUuid(), s.getAccess_token());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return s;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        flag = true;
        s.setRegistry(s1);
_L3:
        s.setHasWeddingRegistry(flag);
_L2:
        return s;
        flag = false;
          goto _L3
    }

    public static Recommendations a(String s, int i1)
    {
        return gj.a(s, i1);
    }

    public static RegistryWishList a(String s, String s1, String s2, WeddingRegistryData weddingregistrydata)
    {
        return gj.a(s, s1, s2, weddingregistrydata);
    }

    public static RegistryWishListCompleteData a(String s, String s1, boolean flag, int i1, String s2)
    {
        return gj.a(s, s1, flag, i1, s2);
    }

    public static SupportedVersionsResponse a(ft ft1, Context context)
    {
        return gq.a(ft1, context);
    }

    public static StoreList a(Activity activity, double d1, double d2, String s, int i1, int j1)
    {
        Address address1 = gi.a(activity, d1, d2);
        Address address = address1;
        if (address1 != null)
        {
            address = address1;
            if (address1.getPostalCode() == null)
            {
                address = gi.a(activity, d1, d2);
            }
        }
        if (address != null && address.getPostalCode() != null)
        {
            return a(address.getPostalCode(), s, i1, j1);
        } else
        {
            return null;
        }
    }

    public static StoreList a(Activity activity, String s, String s1, int i1, int j1)
    {
        Address address1 = gi.b(activity, s);
        Address address = address1;
        if (address1 != null)
        {
            address = address1;
            if (address1.getPostalCode() == null)
            {
                address = gi.b(activity, s);
            }
        }
        if (address != null && address.getPostalCode() != null)
        {
            return a(address.getPostalCode(), s1, i1, j1);
        } else
        {
            return null;
        }
    }

    public static StoreList a(String s, String s1, int i1, int j1)
    {
        return gq.a(s, s1, i1, j1);
    }

    public static SearchApi a(String s, String s1, String s2, Map map, String s3, boolean flag, boolean flag1, int i1, 
            int j1)
    {
        return gq.a(s, s1, s2, map, s3, flag, flag1, i1, j1);
    }

    public static SolrResponse a(String s, Context context, String s1, String s2, String s3, int i1, int j1, boolean flag)
    {
        return gg.a(s, context, s1, s2, s3, i1, j1, flag);
    }

    public static SolrResponse a(String s, Context context, ArrayList arraylist, String s1, String s2, String s3, int i1, int j1, 
            boolean flag)
    {
        return gg.a(s, context, arraylist, s1, s2, s3, i1, j1, flag);
    }

    public static ft a(String s)
    {
        if (s.equals("PROD"))
        {
            return ft.a;
        }
        if (s.equalsIgnoreCase("QA"))
        {
            return ft.e;
        }
        if (s.equalsIgnoreCase("PROD_LIKE"))
        {
            return ft.b;
        }
        if (s.equalsIgnoreCase("CLOUD_TEST"))
        {
            return ft.c;
        }
        if (s.equalsIgnoreCase("STAGE"))
        {
            return ft.d;
        }
        if (s.equalsIgnoreCase("QA1"))
        {
            return ft.f;
        }
        if (s.equalsIgnoreCase("QA2"))
        {
            return ft.g;
        }
        if (s.equalsIgnoreCase("QA3"))
        {
            return ft.h;
        }
        if (s.equalsIgnoreCase("CDC"))
        {
            return ft.i;
        }
        if (s.equalsIgnoreCase("DEV"))
        {
            return ft.j;
        }
        if (s.equalsIgnoreCase("LOCAL"))
        {
            return ft.k;
        }
        if (s.equalsIgnoreCase("CUSTOM"))
        {
            return ft.l;
        } else
        {
            return ft.a;
        }
    }

    public static String a(Context context, String s)
    {
        if (!gf.a(context))
        {
            gf.a(context, gg.b());
        }
        return gg.a(gf.b(context), s);
    }

    public static String a(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        return gq.a(s, s1, s2, s3, s4, s5, s6);
    }

    public static ArrayList a()
    {
        return gm.b();
    }

    public static ArrayList a(Context context)
    {
        if (!gf.a(context))
        {
            gf.a(context, gg.b());
        }
        return gq.c(gf.b(context));
    }

    public static ArrayList a(Recommendation recommendation)
    {
        return gq.a(recommendation);
    }

    public static ArrayList a(ft ft1, String s)
    {
        return gq.a(ft1, s);
    }

    public static ArrayList a(String s, int i1, int j1, boolean flag)
    {
        return gq.a(s, i1, j1, flag);
    }

    public static ArrayList a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {
        return gj.a(s, s1, s2, s3, s4, s5, s6, s7);
    }

    public static ArrayList a(ArrayList arraylist)
    {
        fs;
        JVM INSTR monitorenter ;
        arraylist = gq.a(arraylist);
        fs;
        JVM INSTR monitorexit ;
        return arraylist;
        arraylist;
        throw arraylist;
    }

    public static void a(String s, String s1, int i1)
    {
        switch (i1)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return;

        case 0: // '\0'
            gm.a(s, s1);
            return;

        case 1: // '\001'
            gd.a(s, s1);
            return;

        case 2: // '\002'
            gg.a(s, s1, Boolean.valueOf(true));
            return;

        case 8: // '\b'
            fu.a(s, s1);
            return;

        case 9: // '\t'
            fw.a(s);
            // fall through

        case 10: // '\n'
            ga.a(s);
            return;

        case 11: // '\013'
            gq.a(s);
            break;
        }
    }

    public static void a(String s, String s1, String s2)
    {
        gq.a(s, s1, s2);
    }

    public static void a(List list)
    {
        gg.a(list);
    }

    public static boolean a(String s, String s1, String s2, WishListReqData wishlistreqdata)
    {
        return gj.a(s, s1, s2, wishlistreqdata);
    }

    public static boolean a(String s, String s1, String s2, String s3)
    {
        return gj.c(s, s1, s2, s3);
    }

    public static boolean a(String s, String s1, String s2, String s3, int i1, String s4)
    {
        return gj.a(s, s1, s2, s3, i1, s4);
    }

    public static boolean a(String s, String s1, String s2, String s3, String s4)
    {
        return gj.a(s, s1, s2, s3, s4);
    }

    public static boolean a(String s, String s1, String s2, String s3, String s4, boolean flag)
    {
        return gj.a(s, s1, s2, s3, s4, flag);
    }

    public static Address b(Context context, String s)
    {
        return gi.a(context, s);
    }

    public static CartResponse b(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {
        return ga.a(s, s1, s2, s3, s4, s5, s6, s7);
    }

    public static RegistryWishList b(String s, String s1, String s2, String s3)
    {
        return gj.a(s, s1, s2, s3);
    }

    public static SearchApi b(String s, String s1, int i1)
    {
        return gq.a(s, s1, i1);
    }

    public static SolrResponse b(String s, Context context, String s1, String s2, String s3, int i1, int j1, boolean flag)
    {
        return gq.a(s, context, s1, s2, s3, i1, j1, flag);
    }

    public static SolrResponse b(String s, Context context, ArrayList arraylist, String s1, String s2, String s3, int i1, int j1, 
            boolean flag)
    {
        return gq.a(s, context, arraylist, s1, s2, s3, i1, j1, flag);
    }

    public static ArrayList b()
    {
        return gm.c();
    }

    public static ArrayList b(String s, String s1)
    {
        return gj.b(s, s1);
    }

    public static ArrayList b(String s, String s1, String s2)
    {
        return gq.b(s, s1, s2);
    }

    public static void b(String s)
    {
        a = s;
    }

    public static void b(String s, String s1, String s2, String s3, String s4)
    {
        gq.a(s, s1, s2, s3, s4);
    }

    public static boolean b(String s, String s1, String s2, WeddingRegistryData weddingregistrydata)
    {
        return gj.b(s, s1, s2, weddingregistrydata);
    }

    public static UberCategoryList c()
    {
        return gq.b();
    }

    public static RegistryWishList c(String s, String s1)
    {
        return gj.c(s, s1);
    }

    public static Store c(String s)
    {
        return fu.b(s);
    }

    public static ArrayList c(String s, String s1, String s2, String s3)
    {
        return gj.b(s, s1, s2, s3);
    }

    public static StoreDeals d(String s)
    {
        return gd.a(s);
    }

    public static RegistryWishList d(String s, String s1)
    {
        return gj.d(s, s1);
    }

    public static ArrayList d()
    {
        return gj.a();
    }

    public static void d(String s, String s1, String s2, String s3)
    {
        gq.a(s, s1, s2, s3);
    }

    public static ArrayList e()
    {
        return gj.b();
    }

    public static ArrayList e(String s)
    {
        return gq.d(s);
    }

    public static ArrayList e(String s, String s1)
    {
        return gj.a(s, s1);
    }

    public static PDPOverviewResponseRoot f(String s, String s1)
    {
        return gq.a(s, s1);
    }

    public static ArrayList f(String s)
    {
        return gq.e(s);
    }

    public static ArrayList g(String s)
    {
        return gq.g(s);
    }

    public static BuyingOptionsResponse h(String s)
    {
        return gq.j(s);
    }

    public static CastAndCrewParent i(String s)
    {
        return gq.k(s);
    }

    public static PDPEpisodesParent j(String s)
    {
        return gq.l(s);
    }

    public static MoviesResponse k(String s)
    {
        return gq.m(s);
    }

    public static MusicResponse l(String s)
    {
        return gq.n(s);
    }

    public static AccessoriesResponse m(String s)
    {
        return gq.o(s);
    }

    public static ShareURL n(String s)
    {
        return gj.d(s);
    }

}
