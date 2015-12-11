// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductVariation;
import com.target.mothership.model.product.interfaces.ProductVariationDimensions;
import com.target.mothership.model.product.interfaces.ProductVariationSummary;
import com.target.mothership.model.product.interfaces.ProductVariationValues;
import com.target.mothership.util.k;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductAttributes, TGTProductVariation, TGTProductCollection

public class TGTProductDetails extends TGTProductAttributes
    implements ProductDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductDetails a(Parcel parcel)
        {
            return new TGTProductDetails(parcel);
        }

        public TGTProductDetails[] a(int l)
        {
            return new TGTProductDetails[l];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int l)
        {
            return a(l);
        }

    };
    private List mCollection;
    private boolean mIsCollectionParent;
    private boolean mIsVariationParent;
    private ProductVariationSummary mProductVariationSummary;
    private List mVariation;
    private ProductVariationDimensions mVariationType;

    public TGTProductDetails()
    {
    }

    public TGTProductDetails(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        mVariationType = (ProductVariationDimensions)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductVariationDimensions.getClassLoader());
        mVariation = new ArrayList();
        parcel.readList(mVariation, com/target/mothership/model/product/handler/TGTProductVariation.getClassLoader());
        mCollection = new ArrayList();
        parcel.readList(mCollection, com/target/mothership/model/product/handler/TGTProductCollection.getClassLoader());
        mProductVariationSummary = (ProductVariationSummary)parcel.readParcelable(com/target/mothership/model/product/interfaces/ProductVariationSummary.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsCollectionParent = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsVariationParent = flag;
    }

    private List a(String s, String s1, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = E().iterator();
label0:
        do
        {
            ProductVariation productvariation;
            String s2;
            String s3;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    productvariation = (ProductVariation)iterator.next();
                } while (!productvariation.v().b());
                s2 = ((ProductVariationValues)productvariation.v().c()).a();
                s3 = ((ProductVariationValues)productvariation.v().c()).b();
            } while (!o.g(s2) || !o.g(s3) || !s2.equalsIgnoreCase(s) || !s3.equalsIgnoreCase(s1));
            arraylist.add(productvariation);
        } while (flag);
        return arraylist;
    }

    private List a(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = E().iterator();
label0:
        do
        {
            ProductVariation productvariation;
            String s1;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    productvariation = (ProductVariation)iterator.next();
                } while (!productvariation.v().b());
                s1 = ((ProductVariationValues)productvariation.v().c()).a();
            } while (!o.g(s1) || !s1.equalsIgnoreCase(s));
            arraylist.add(productvariation);
        } while (flag);
        return arraylist;
    }

    private List b(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = E().iterator();
label0:
        do
        {
            ProductVariation productvariation;
            String s1;
            do
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    productvariation = (ProductVariation)iterator.next();
                } while (!productvariation.v().b());
                s1 = ((ProductVariationValues)productvariation.v().c()).b();
            } while (!o.g(s1) || !s1.equalsIgnoreCase(s));
            arraylist.add(productvariation);
        } while (flag);
        return arraylist;
    }

    private List c(String s, String s1)
    {
        Object obj = null;
        List list;
        if (s != null && s1 == null)
        {
            list = a(s, true);
        } else
        {
            if (s == null && s1 != null)
            {
                return b(s1, true);
            }
            list = obj;
            if (s != null)
            {
                list = obj;
                if (s1 != null)
                {
                    return a(s, s1, true);
                }
            }
        }
        return list;
    }

    private ProductVariation d(String s, String s1)
    {
        if (s != null && s1 == null)
        {
            s = a(s, false);
        } else
        if (s == null && s1 != null)
        {
            s = b(s1, false);
        } else
        if (s != null && s1 != null)
        {
            s = a(s, s1, false);
        } else
        {
            s = null;
        }
        if (s.size() > 0)
        {
            return (ProductVariation)s.get(0);
        } else
        {
            return null;
        }
    }

    public e D()
    {
        return k.a(mVariationType);
    }

    public List E()
    {
        return k.a(mVariation);
    }

    public List F()
    {
        return k.a(mCollection);
    }

    public boolean G()
    {
        return H() || I();
    }

    public boolean H()
    {
        return mIsVariationParent;
    }

    public boolean I()
    {
        return mIsCollectionParent;
    }

    public e J()
    {
        return k.a(mProductVariationSummary);
    }

    public e a(String s, String s1)
    {
        return k.a(d(s, s1));
    }

    public void a(ProductVariationDimensions productvariationdimensions)
    {
        mVariationType = productvariationdimensions;
    }

    public void a(ProductVariationSummary productvariationsummary)
    {
        mProductVariationSummary = productvariationsummary;
    }

    public List b(String s, String s1)
    {
        return k.a(c(s, s1));
    }

    public int describeContents()
    {
        return 0;
    }

    public void g(List list)
    {
        mVariation = list;
    }

    public void h(List list)
    {
        mCollection = list;
    }

    public void i(boolean flag)
    {
        mIsCollectionParent = flag;
    }

    public void j(boolean flag)
    {
        mIsVariationParent = flag;
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        boolean flag = true;
        super.writeToParcel(parcel, l);
        parcel.writeParcelable(mVariationType, 0);
        parcel.writeList(mVariation);
        parcel.writeList(mCollection);
        parcel.writeParcelable(mProductVariationSummary, 0);
        byte byte0;
        if (mIsCollectionParent)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsVariationParent)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
