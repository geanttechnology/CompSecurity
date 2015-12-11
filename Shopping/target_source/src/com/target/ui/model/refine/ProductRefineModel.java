// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductFacet;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.model.refine:
//            ProductSortModel

public class ProductRefineModel
    implements Parcelable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a CATEGORY;
        public static final a COLOR;
        public static final a OTHERS;
        public static final a PRICE;
        private String mLabel;

        public static a a(String s)
        {
            if (s != null) goto _L2; else goto _L1
_L1:
            a a1 = OTHERS;
_L4:
            return a1;
_L2:
            a aa[];
            int i;
            int j;
            aa = values();
            j = aa.length;
            i = 0;
_L6:
            a a2;
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            a2 = aa[i];
            a1 = a2;
            if (s.equalsIgnoreCase(a2.a())) goto _L4; else goto _L3
_L3:
            a1 = a2;
            if (s.equalsIgnoreCase(a2.name())) goto _L4; else goto _L5
_L5:
            i++;
              goto _L6
            return OTHERS;
        }

        private String a()
        {
            return mLabel;
        }

        static String a(a a1)
        {
            return a1.a();
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/model/refine/ProductRefineModel$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            CATEGORY = new a("CATEGORY", 0, "category");
            PRICE = new a("PRICE", 1, "price");
            COLOR = new a("COLOR", 2, "color");
            OTHERS = new a("OTHERS", 3, "");
            $VALUES = (new a[] {
                CATEGORY, PRICE, COLOR, OTHERS
            });
        }

        private a(String s, int i, String s1)
        {
            super(s, i);
            mLabel = s1;
        }
    }

    public class b
    {

        private final String mLabel;
        final ProductRefineModel this$0;

        public a a()
        {
            return a.a(mLabel);
        }

        public String b()
        {
            return mLabel;
        }

        b(String s)
        {
            this$0 = ProductRefineModel.this;
            super();
            mLabel = s;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductRefineModel a(Parcel parcel)
        {
            return new ProductRefineModel(parcel);
        }

        public ProductRefineModel[] a(int i)
        {
            return new ProductRefineModel[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private Comparator CATEGORY_COMPARATOR = new Comparator() {

        final ProductRefineModel this$0;

        public int a(ProductEntry productentry, ProductEntry productentry1)
        {
            if (productentry == null && productentry1 == null)
            {
                return 0;
            }
            if (productentry == null)
            {
                return -1;
            }
            if (productentry1 == null)
            {
                return 1;
            } else
            {
                return productentry.d().compareTo(productentry1.d());
            }
        }

        public int compare(Object obj, Object obj1)
        {
            return a((ProductEntry)obj, (ProductEntry)obj1);
        }

            
            {
                this$0 = ProductRefineModel.this;
                super();
            }
    };
    private List mAppliedCategories;
    private List mAppliedFacets;
    private List mOriginalCategories;
    private List mOriginalFacets;
    private List mSelectedFacets;
    private ProductSortModel mSortModel;

    private ProductRefineModel(Parcel parcel)
    {
        mSortModel = (ProductSortModel)parcel.readParcelable(com/target/ui/model/refine/ProductSortModel.getClassLoader());
        mOriginalFacets = new ArrayList();
        parcel.readList(mOriginalFacets, com/target/mothership/model/product/interfaces/ProductFacet.getClassLoader());
        mOriginalCategories = new ArrayList();
        parcel.readList(mOriginalCategories, com/target/mothership/model/product/interfaces/ProductFacet.getClassLoader());
        mAppliedFacets = new ArrayList();
        parcel.readList(mAppliedFacets, com/target/mothership/model/product/interfaces/ProductFacet.getClassLoader());
        mAppliedCategories = new ArrayList();
        parcel.readList(mAppliedCategories, com/target/mothership/model/product/interfaces/ProductFacet.getClassLoader());
        mSelectedFacets = new ArrayList();
        parcel.readList(mSelectedFacets, com/target/mothership/model/product/interfaces/ProductEntry.getClassLoader());
    }


    public ProductRefineModel(List list, List list1)
    {
        mOriginalFacets = list1;
        mOriginalCategories = list;
        mSelectedFacets = Collections.emptyList();
        mSortModel = new ProductSortModel();
    }

    public List a(b b1)
    {
        if (b1 == null)
        {
            return Collections.emptyList();
        }
        Object obj = a.a(a.CATEGORY);
        if (b1.b().equalsIgnoreCase(((String) (obj))))
        {
            return d();
        }
        obj = new ArrayList();
        for (Iterator iterator = mAppliedFacets.iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((ProductFacet)iterator.next()).a().iterator();
            while (iterator2.hasNext()) 
            {
                ProductEntry productentry1 = (ProductEntry)iterator2.next();
                if (productentry1.d().equalsIgnoreCase(b1.b()) && productentry1.c().b())
                {
                    ((List) (obj)).add(productentry1);
                }
            }
        }

        Iterator iterator1 = mSelectedFacets.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ProductEntry productentry = (ProductEntry)iterator1.next();
            if (productentry.d().equalsIgnoreCase(b1.b()) && productentry.c().b() && !((List) (obj)).contains(productentry))
            {
                ((List) (obj)).add(productentry);
            }
        } while (true);
        return ((List) (obj));
    }

    public void a()
    {
        mAppliedFacets = mOriginalFacets;
        mAppliedCategories = mOriginalCategories;
        mSelectedFacets = Collections.emptyList();
        mSortModel.b();
    }

    public void a(List list)
    {
        mAppliedFacets = list;
    }

    public ProductSortModel b()
    {
        return mSortModel;
    }

    public List b(b b1)
    {
        if (b1 == null)
        {
            return Collections.emptyList();
        }
        Object obj = a.a(a.CATEGORY);
        if (b1.b().equalsIgnoreCase(((String) (obj))))
        {
            return e();
        }
        obj = new ArrayList();
        Iterator iterator = mSelectedFacets.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ProductEntry productentry = (ProductEntry)iterator.next();
            if (productentry.d().equalsIgnoreCase(b1.b()))
            {
                ((List) (obj)).add(productentry);
            }
        } while (true);
        return ((List) (obj));
    }

    public void b(List list)
    {
        mAppliedCategories = list;
    }

    public List c()
    {
        ArrayList arraylist = new ArrayList();
        if (!mAppliedCategories.isEmpty())
        {
            arraylist.add(new b(a.a(a.CATEGORY)));
        }
        Object obj = new ArrayList();
        for (Iterator iterator = mAppliedFacets.iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((ProductFacet)iterator.next()).a().iterator();
            while (iterator2.hasNext()) 
            {
                ProductEntry productentry1 = (ProductEntry)iterator2.next();
                if (o.g(productentry1.d()))
                {
                    ((List) (obj)).add(productentry1.d());
                }
            }
        }

        Iterator iterator1 = mSelectedFacets.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ProductEntry productentry = (ProductEntry)iterator1.next();
            String s = productentry.d();
            if (o.g(s) && !productentry.f() && !((List) (obj)).contains(s))
            {
                ((List) (obj)).add(s);
            }
        } while (true);
        obj = new ArrayList(new HashSet(((java.util.Collection) (obj))));
        Collections.sort(((List) (obj)));
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new b((String)((Iterator) (obj)).next()))) { }
        return arraylist;
    }

    public void c(List list)
    {
        mSelectedFacets = list;
    }

    public List d()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mAppliedCategories.iterator(); iterator.hasNext(); arraylist.addAll(((ProductFacet)iterator.next()).a())) { }
        Iterator iterator1 = mSelectedFacets.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ProductEntry productentry = (ProductEntry)iterator1.next();
            if (productentry.f() && !arraylist.contains(productentry))
            {
                arraylist.add(productentry);
            }
        } while (true);
        Collections.sort(arraylist, CATEGORY_COMPARATOR);
        return arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public List e()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mSelectedFacets.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ProductEntry productentry = (ProductEntry)iterator.next();
            if (productentry.f())
            {
                arraylist.add(productentry);
            }
        } while (true);
        return arraylist;
    }

    public List f()
    {
        return mSelectedFacets;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mSortModel, i);
        parcel.writeList(mOriginalFacets);
        parcel.writeList(mOriginalCategories);
        parcel.writeList(mAppliedFacets);
        parcel.writeList(mAppliedCategories);
        parcel.writeList(mSelectedFacets);
    }

}
