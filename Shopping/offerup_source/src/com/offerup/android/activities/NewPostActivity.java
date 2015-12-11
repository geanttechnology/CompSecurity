// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.b.a;
import android.widget.Toast;
import com.b.a.a.g;
import com.b.a.a.i;
import com.b.a.a.j;
import com.google.gson.Gson;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.IndexedItemPostPhoto;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.dto.Photo;
import com.offerup.android.g.c.c;
import com.offerup.android.g.c.h;
import com.offerup.android.g.c.l;
import com.offerup.android.g.c.t;
import com.offerup.android.g.c.z;
import com.offerup.android.h.b;
import com.offerup.android.network.ItemService;
import com.offerup.android.network.f;
import com.offerup.android.network.o;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.al;
import com.offerup.android.utils.an;
import com.offerup.android.utils.ap;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.d;
import com.offerup.android.utils.n;
import com.offerup.android.utils.u;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;

// Referenced classes of package com.offerup.android.activities:
//            k, el, ek, em, 
//            ej, ei, PrePostingHelpActivity

public class NewPostActivity extends k
    implements b
{

    private int a;
    private i b;
    private com.b.a.a.a c;
    private ItemPost d;
    private al j;
    private Object k;
    private boolean l;

    public NewPostActivity()
    {
    }

    static ItemPost a(NewPostActivity newpostactivity)
    {
        return newpostactivity.d;
    }

    private void a(Bundle bundle)
    {
        if (bundle != null)
        {
            boolean flag;
            if (bundle.containsKey("post_step"))
            {
                a = bundle.getInt("post_step");
            } else
            {
                a = 1;
            }
            if (bundle.containsKey("item_post"))
            {
                d = (ItemPost)bundle.getParcelable("item_post");
            } else
            if (bundle.containsKey("item"))
            {
                d = new ItemPost((Item)bundle.getParcelable("item"));
            } else
            {
                d = b.a();
            }
            if (bundle.containsKey("is_posted") && bundle.getBoolean("is_posted"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l = flag;
        } else
        {
            d = b.a();
            a = 1;
            bundle = d;
            OfferUpLocation offeruplocation = an.a(ap.b);
            if (offeruplocation.d() != 0.0D)
            {
                bundle.setLatitude(Double.valueOf(offeruplocation.d()));
            } else
            {
                bundle.setLatitude(null);
            }
            if (offeruplocation.c() != 0.0D)
            {
                bundle.setLongitude(Double.valueOf(offeruplocation.c()));
            } else
            {
                bundle.setLongitude(null);
            }
            if (StringUtils.isNotEmpty(offeruplocation.a()))
            {
                bundle.setZipcode(offeruplocation.a());
            } else
            {
                bundle.setZipcode(null);
            }
            if (StringUtils.isNotEmpty(offeruplocation.f()) && StringUtils.isNotEmpty(offeruplocation.h()))
            {
                bundle.setLocationName((new StringBuilder()).append(offeruplocation.f()).append(", ").append(offeruplocation.h()).toString());
            } else
            {
                bundle.setLocationName(null);
            }
        }
        j = new al(d);
    }

    private void a(Fragment fragment)
    {
        android.support.v4.app.an an1 = getSupportFragmentManager().a();
        an1.b(0x7f10011a, fragment);
        an1.a(null);
        an1.b();
    }

    static void a(NewPostActivity newpostactivity, IndexedItemPostPhoto indexeditempostphoto)
    {
        if (newpostactivity.d.getItemPostPhotos() != null && newpostactivity.d.getItemPostPhotos().size() > indexeditempostphoto.getIndex())
        {
            newpostactivity.d.getItemPostPhotos().set(indexeditempostphoto.getIndex(), indexeditempostphoto.getItemPostPhoto());
        }
    }

    static void a(NewPostActivity newpostactivity, Item item)
    {
        boolean flag2 = false;
        newpostactivity.i();
        newpostactivity.l = true;
        boolean flag3 = newpostactivity.e.Q();
        Uri uri;
        String s1;
        String s3;
        boolean flag;
        if (newpostactivity.d.getId() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = item.getGetFullUrl();
        if (item.getPhotos() != null && item.getPhotos().length > 0)
        {
            uri = item.getPhotos()[0].getDetailUri();
        } else
        {
            uri = null;
        }
        s3 = item.getTitle();
        newpostactivity.e.r(true);
        newpostactivity.g = ProgressDialog.show(newpostactivity, "", "");
        newpostactivity.g.setProgressStyle(0);
        newpostactivity.g.setIndeterminateDrawable(android.support.v4.b.a.a(newpostactivity, 0x7f0201e1));
        newpostactivity.g.setMessage(newpostactivity.getResources().getString(0x7f0901b5));
        newpostactivity.g.show();
        (new Handler()).postDelayed(new el(newpostactivity, s1, uri, s3, flag3, flag), 3000L);
        if (newpostactivity.d.getShareToFacebook().intValue() == 1)
        {
            com.offerup.android.tracker.a.a(newpostactivity.getApplicationContext(), "ou_item_post_share", item);
        }
        if (flag)
        {
            com.offerup.android.tracker.a.e(newpostactivity.getApplicationContext(), item);
        } else
        {
            String s = item.getPrice();
            String s2 = item.getCategory().getName();
            boolean flag1 = flag2;
            if (item.getState() == 1)
            {
                flag1 = true;
            }
            com.offerup.android.tracker.a.a(newpostactivity, newpostactivity, s, s2, flag1);
            newpostactivity.e.w(true);
            newpostactivity.b.b();
            newpostactivity.c.a(newpostactivity.d.getId()).a();
            newpostactivity.c.a();
        }
        android.support.v4.e.a.i();
    }

    static void a(NewPostActivity newpostactivity, String s, Uri uri, String s1, boolean flag, boolean flag1)
    {
        newpostactivity.a = 5;
        newpostactivity.a(((Fragment) (h.a(s, s1, uri, flag, flag1))));
    }

    static void a(NewPostActivity newpostactivity, Throwable throwable)
    {
        com.b.a.a.g.a(newpostactivity, throwable);
        newpostactivity.i();
        n.a(newpostactivity, 0x7f090132, newpostactivity.f());
    }

    static void a(NewPostActivity newpostactivity, RetrofitError retrofiterror)
    {
        newpostactivity.i();
        if (retrofiterror.getKind() == retrofit.RetrofitError.Kind.NETWORK)
        {
            n.a(newpostactivity, 0x7f090134, 0x7f090133);
            return;
        } else
        {
            n.a(newpostactivity, 0x7f090132, u.a(retrofiterror, newpostactivity.f()));
            return;
        }
    }

    static boolean b(NewPostActivity newpostactivity)
    {
        return newpostactivity.g();
    }

    static boolean c(NewPostActivity newpostactivity)
    {
        return newpostactivity.l;
    }

    static i d(NewPostActivity newpostactivity)
    {
        return newpostactivity.b;
    }

    static String e(NewPostActivity newpostactivity)
    {
        return newpostactivity.f();
    }

    private String f()
    {
        if (g())
        {
            return getResources().getString(0x7f090131);
        } else
        {
            return getResources().getString(0x7f090130);
        }
    }

    static void f(NewPostActivity newpostactivity)
    {
        Object obj = newpostactivity.getApplicationContext();
        ItemPost itempost = newpostactivity.d;
        ek ek1 = new ek(newpostactivity);
        Object obj1 = new al(itempost);
        if (StringUtils.isEmpty(itempost.getUploadedImageUuids()) && itempost.getId() == null)
        {
            ek1.failure(RetrofitError.unexpectedError(String.format("%s%s", new Object[] {
                o.a(), "/items/"
            }), new Exception("Unable to create item without primary image.")));
            return;
        }
        newpostactivity = null;
        int i1 = itempost.getShareToFacebook().intValue();
        if (i1 != 0)
        {
            newpostactivity = ba.b();
        }
        obj = ((al) (obj1)).a(((android.content.Context) (obj)));
        if (((List) (obj)).size() > 0)
        {
            ek1.failure(RetrofitError.unexpectedError(String.format("%s%s", new Object[] {
                o.a(), "/items/"
            }), new Exception((String)((List) (obj)).get(0))));
            return;
        }
        if (itempost.getCategory() == null)
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(itempost.getCategory().getId());
        }
        obj1 = o.l(o.a(Executors.newSingleThreadExecutor()));
        if (itempost.getId() == null)
        {
            ((ItemService) (obj1)).createItem(itempost.getTitle(), itempost.getCondition(), ((Integer) (obj)), itempost.getDescription(), itempost.getPrice(), itempost.getListingType(), itempost.getUploadedImageUuids(), itempost.getListingState(), itempost.getZipcode(), itempost.getLatitude(), itempost.getLongitude(), i1, newpostactivity, ek1);
            return;
        } else
        {
            ((ItemService) (obj1)).updateItem(itempost.getId().longValue(), itempost.getTitle(), itempost.getCondition(), ((Integer) (obj)), itempost.getDescription(), itempost.getPrice(), itempost.getListingType(), itempost.getUploadedImageUuids(), itempost.getListingState(), itempost.getZipcode(), itempost.getLatitude(), itempost.getLongitude(), ek1);
            return;
        }
    }

    private boolean g()
    {
        return d.getId() == null;
    }

    public final void a()
    {
        a;
        JVM INSTR tableswitch 1 5: default 40
    //                   1 41
    //                   2 68
    //                   3 102
    //                   4 191
    //                   5 323;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        a(((Fragment) (com.offerup.android.g.c.c.a(d.getCategory(), d.getDescription()))));
        a = 2;
        return;
_L3:
        a(((Fragment) (t.a(d.getPrice(), d.getListingType(), d.getCondition()))));
        a = 3;
        return;
_L4:
        int k1 = d.getShareToFacebook().intValue();
        int i1 = k1;
        if (g())
        {
            i1 = k1;
            if (StringUtils.isNotEmpty(ba.b()))
            {
                i1 = k1;
                if (!com.b.a.a.j.a().X())
                {
                    i1 = 1;
                }
            }
        }
        a(((Fragment) (z.a(Integer.valueOf(i1), d.getZipcode(), d.getLatitude(), d.getLongitude(), d.getLocationName()))));
        a = 4;
        return;
_L5:
        if (android.support.v4.e.a.b(getApplicationContext()))
        {
            List list = j.a(getApplicationContext());
            if (list.size() <= 0)
            {
                a(0x7f0901bb);
                (new f(getApplicationContext())).a(d.getItemPostPhotos()).a(e.a.b.a.a()).b(new em(this, (byte)0));
                return;
            }
            int j1 = 0;
            while (j1 < list.size()) 
            {
                Toast.makeText(this, (CharSequence)list.get(j1), 0).show();
                j1++;
            }
        } else
        {
            Toast.makeText(this, getString(0x7f090176), 0).show();
            return;
        }
          goto _L1
_L6:
        finish();
        return;
    }

    public final void a(com.offerup.android.h.c c1)
    {
        Category acategory[] = (Category[])(new Gson()).fromJson(e.C(), [Lcom/offerup/android/dto/Category;);
        if (acategory != null && acategory.length > 0)
        {
            c1.a(acategory);
            return;
        }
        if (android.support.v4.e.a.b(getApplicationContext()))
        {
            android.support.v4.e.a.b(new ej(this, c1));
            return;
        } else
        {
            c1.a();
            return;
        }
    }

    final String b()
    {
        return "";
    }

    public final int e()
    {
        return 0x7f110004;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
    }

    public void onBackPressed()
    {
        if (a == 5)
        {
            finish();
            return;
        } else
        {
            super.onBackPressed();
            a = a - 1;
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040033);
        b = i.a(getApplicationContext());
        c = com.b.a.a.a.a(getApplicationContext());
        k = new ei(this);
        com.offerup.android.b.a.getInstance().register(k);
        if (bundle != null)
        {
            a(bundle);
        } else
        {
            a(getIntent().getExtras());
            bundle = com.offerup.android.g.c.l.a(d.getTitle(), d.getItemPostPhotos(), d.getId());
            getSupportFragmentManager().a().a(0x7f10011a, bundle).b();
            if (!e.Q())
            {
                startActivity(new Intent(this, com/offerup/android/activities/PrePostingHelpActivity));
                return;
            }
        }
    }

    public void onDestroy()
    {
        com.offerup.android.b.a.getInstance().unregister(k);
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        a(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("post_step", a);
        bundle.putParcelable("item_post", d);
        bundle.putBoolean("is_posted", l);
        super.onSaveInstanceState(bundle);
    }
}
