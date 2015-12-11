// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.a.a.b;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.util.k;
import com.target.mothership.util.p;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TGTProductImage
    implements ProductImage
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductImage a(Parcel parcel)
        {
            return new TGTProductImage(parcel);
        }

        public TGTProductImage[] a(int i)
        {
            return new TGTProductImage[i];
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
    private static String TAG = com/target/mothership/model/product/handler/TGTProductImage.getSimpleName();
    private List mAlternateImage;
    private URL mDisplayImage;
    private URL mProductHeroImage;
    private URL mProductImage;

    TGTProductImage()
    {
    }

    private TGTProductImage(Parcel parcel)
    {
        mProductImage = (URL)parcel.readSerializable();
        mDisplayImage = (URL)parcel.readSerializable();
        mAlternateImage = new ArrayList();
        parcel.readList(mAlternateImage, java/net/URL.getClassLoader());
    }


    private URL a(String s, int i)
    {
        if (s == null)
        {
            return null;
        }
        s = p.a(s, i);
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.target.a.a.b.a(TAG, "Unable to get create the url");
            s = null;
        }
        return s;
    }

    public e a(int i)
    {
        if (mDisplayImage == null)
        {
            return e.e();
        } else
        {
            return k.a(a(mDisplayImage.toString(), i));
        }
    }

    public URL a()
    {
        return mProductImage;
    }

    public void a(URL url)
    {
        mProductImage = url;
    }

    public void a(List list)
    {
        mAlternateImage = list;
    }

    public e b()
    {
        return k.a(mDisplayImage);
    }

    public URL b(int i)
    {
        if (mProductImage == null)
        {
            return null;
        } else
        {
            return a(mProductImage.toString(), i);
        }
    }

    public void b(URL url)
    {
        mProductHeroImage = url;
    }

    public List c(int i)
    {
        if (mAlternateImage == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mAlternateImage.iterator(); iterator.hasNext(); arraylist.add(a(((URL)iterator.next()).toString(), i))) { }
        return arraylist;
    }

    public void c(URL url)
    {
        mDisplayImage = url;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mProductImage);
        parcel.writeSerializable(mDisplayImage);
        parcel.writeList(mAlternateImage);
    }

}
