// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.text.Html;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.cart.interfaces.CartRegistryDetails;
import com.target.mothership.model.cart.interfaces.CartUsableShippingInfo;
import com.target.mothership.model.cart.interfaces.GiftCardDeliveryProfile;
import com.target.mothership.model.cart.interfaces.a;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.model.common.TGTPickUpPersonDetails;
import com.target.mothership.model.common.TGTPickUpStoreAddress;
import com.target.mothership.model.common.TGTStorePickUpDetails;
import com.target.mothership.model.common.b;
import com.target.mothership.model.common.c;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.ac;
import com.target.mothership.services.apigee.c.b.ak;
import com.target.mothership.services.apigee.c.b.al;
import com.target.mothership.services.apigee.c.b.t;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTGiftCardDeliveryProfile, TGTCartProduct, n, al, 
//            TGTCartPhoneNumber, c, TGTCartRegistryDetails, TGTCartUsableShippingInfo

class at
    implements aa
{

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    at()
    {
    }

    private GiftCardDeliveryProfile a(ak ak1)
    {
        if (ak1.s() == null)
        {
            return null;
        } else
        {
            TGTGiftCardDeliveryProfile tgtgiftcarddeliveryprofile = new TGTGiftCardDeliveryProfile();
            tgtgiftcarddeliveryprofile.a(ak1.s());
            tgtgiftcarddeliveryprofile.b(ak1.t());
            tgtgiftcarddeliveryprofile.c(ak1.u());
            tgtgiftcarddeliveryprofile.d(ak1.v());
            tgtgiftcarddeliveryprofile.e(ak1.w());
            return tgtgiftcarddeliveryprofile;
        }
    }

    private List a(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        TGTCartProduct tgtcartproduct;
        for (list = list.iterator(); list.hasNext(); arraylist.add(tgtcartproduct))
        {
            Object obj = (ak)list.next();
            tgtcartproduct = new TGTCartProduct();
            Object obj1 = ((ak) (obj)).c().iterator();
            if (((Iterator) (obj1)).hasNext())
            {
                obj1 = (t)((Iterator) (obj1)).next();
                TGTOrderProductImage tgtorderproductimage = new TGTOrderProductImage();
                tgtorderproductimage.a(((t) (obj1)).a());
                tgtorderproductimage.b(((t) (obj1)).b());
                tgtcartproduct.a(tgtorderproductimage);
            }
            tgtcartproduct.l(Html.fromHtml(((ak) (obj)).i()).toString());
            tgtcartproduct.a(((ak) (obj)).j());
            tgtcartproduct.c(((ak) (obj)).i());
            tgtcartproduct.a(((ak) (obj)).b());
            tgtcartproduct.b(((ak) (obj)).d());
            tgtcartproduct.a((new n()).a(((ak) (obj)).f()));
            tgtcartproduct.a(((ak) (obj)).a());
            tgtcartproduct.a(((ak) (obj)).g());
            tgtcartproduct.d(((ak) (obj)).k());
            tgtcartproduct.a(new Tcin(((ak) (obj)).l()));
            tgtcartproduct.g(((ak) (obj)).l());
            tgtcartproduct.h(((ak) (obj)).m());
            tgtcartproduct.a(com.target.mothership.model.cart.interfaces.a.a(((ak) (obj)).h()));
            tgtcartproduct.a((new b()).a(((ak) (obj)).e()));
            tgtcartproduct.a(((ak) (obj)).A());
            tgtcartproduct.b(((ak) (obj)).B());
            if (o.g(((ak) (obj)).C()))
            {
                tgtcartproduct.d(true);
            }
            tgtcartproduct.a(a(((ak) (obj))));
            tgtcartproduct.a(b(((ak) (obj))));
            tgtcartproduct.a(c(((ak) (obj))));
            obj1 = new ArrayList();
            if (((ak) (obj)).D() != null)
            {
                com.target.mothership.model.cart.handler.al al1 = new com.target.mothership.model.cart.handler.al();
                for (obj = ((ak) (obj)).D().iterator(); ((Iterator) (obj)).hasNext(); ((List) (obj1)).add(al1.a((ac)((Iterator) (obj)).next()))) { }
            }
            tgtcartproduct.b(((List) (obj1)));
        }

        return arraylist;
    }

    private StorePickUpDetails b(ak ak1)
    {
        if (!o.g(ak1.p()))
        {
            return null;
        } else
        {
            TGTStorePickUpDetails tgtstorepickupdetails = new TGTStorePickUpDetails();
            tgtstorepickupdetails.a(new StoreIdentifier(ak1.p()));
            Object obj = new TGTPickUpPersonDetails();
            ((TGTPickUpPersonDetails) (obj)).b(ak1.r());
            ((TGTPickUpPersonDetails) (obj)).a(ak1.o());
            TGTCartPhoneNumber tgtcartphonenumber = new TGTCartPhoneNumber();
            tgtcartphonenumber.a(ak1.q());
            tgtcartphonenumber.a(c.Other);
            ((TGTPickUpPersonDetails) (obj)).a(tgtcartphonenumber);
            tgtstorepickupdetails.a(((com.target.mothership.model.common.PickUpPersonDetails) (obj)));
            obj = new TGTPickUpStoreAddress();
            ak1 = ak1.n();
            ((TGTPickUpStoreAddress) (obj)).a(ak1.f());
            ((TGTPickUpStoreAddress) (obj)).a(ak1.g());
            ((TGTPickUpStoreAddress) (obj)).b(ak1.h());
            ((TGTPickUpStoreAddress) (obj)).d(ak1.i());
            ((TGTPickUpStoreAddress) (obj)).c(ak1.j());
            tgtcartphonenumber = new TGTCartPhoneNumber();
            tgtcartphonenumber.a(ak1.k());
            tgtcartphonenumber.a(c.Other);
            ((TGTPickUpStoreAddress) (obj)).a(tgtcartphonenumber);
            tgtstorepickupdetails.a(ak1.a());
            tgtstorepickupdetails.a(((com.target.mothership.model.common.PickUpStoreAddress) (obj)));
            return tgtstorepickupdetails;
        }
    }

    private List b(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        com.target.mothership.model.cart.handler.c c1 = new com.target.mothership.model.cart.handler.c();
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(c1.a((com.target.mothership.services.apigee.c.b.b)list.next()))) { }
        return arraylist;
    }

    private CartRegistryDetails c(ak ak1)
    {
        if (ak1.x() == null)
        {
            return null;
        } else
        {
            TGTCartRegistryDetails tgtcartregistrydetails = new TGTCartRegistryDetails();
            tgtcartregistrydetails.a(new RegistryId(ak1.x()));
            tgtcartregistrydetails.a(ak1.y());
            tgtcartregistrydetails.a(ak1.z());
            return tgtcartregistrydetails;
        }
    }

    public CartUsableShippingInfo a(al al1)
    {
        TGTCartUsableShippingInfo tgtcartusableshippinginfo = new TGTCartUsableShippingInfo();
        tgtcartusableshippinginfo.a(al1.a());
        tgtcartusableshippinginfo.b(al1.b());
        tgtcartusableshippinginfo.a(al1.e());
        tgtcartusableshippinginfo.a(a(al1.c()));
        tgtcartusableshippinginfo.b(b(al1.d()));
        return tgtcartusableshippinginfo;
    }

    public volatile Object a(Object obj)
    {
        return a((al)obj);
    }
}
