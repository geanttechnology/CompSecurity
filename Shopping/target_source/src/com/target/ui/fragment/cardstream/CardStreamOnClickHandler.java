// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.a.b.k;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.fragment.cardstream.f.a;
import com.target.ui.util.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            e, SingleShoppingListData

public class CardStreamOnClickHandler
    implements com.target.ui.fragment.cardstream.f.a
{
    public static class OnClickArgs
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public OnClickArgs a(Parcel parcel)
            {
                return new OnClickArgs(parcel);
            }

            public OnClickArgs[] a(int i)
            {
                return new OnClickArgs[i];
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
        private static com.target.ui.util.u.a sBundleEqualityTester = new com.target.ui.util.u.a() {

            public boolean a(Bundle bundle, Bundle bundle1)
            {
                return com.target.ui.fragment.cardstream.OnClickArgs.a(bundle, bundle1);
            }

            public volatile boolean a(Object obj, Object obj1)
            {
                return a((Bundle)obj, (Bundle)obj1);
            }

        };
        private final int mOnClickAction;
        private final Bundle mOptions;

        private static int a(Bundle bundle)
        {
            Object obj = k.a(bundle.keySet());
            Collections.sort(((List) (obj)));
            obj = ((List) (obj)).iterator();
            int i = 0;
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = (String)((Iterator) (obj)).next();
                Object obj1 = bundle.get(s);
                int j;
                int l;
                if (s == null)
                {
                    j = 0;
                } else
                {
                    j = s.hashCode();
                }
                if (obj1 == null)
                {
                    l = 0;
                } else
                {
                    l = obj1.hashCode();
                }
                i = l + (j + i * 31) * 31;
            }
            return i;
        }

        static int a(OnClickArgs onclickargs)
        {
            return onclickargs.mOnClickAction;
        }

        static boolean a(Bundle bundle, Bundle bundle1)
        {
            return b(bundle, bundle1);
        }

        static Bundle b(OnClickArgs onclickargs)
        {
            return onclickargs.mOptions;
        }

        private static boolean b(Bundle bundle, Bundle bundle1)
        {
label0:
            {
                if (bundle.size() != bundle1.size())
                {
                    return false;
                }
                Iterator iterator = bundle.keySet().iterator();
                Object obj;
                Object obj1;
label1:
                do
                {
                    String s;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        s = (String)iterator.next();
                        obj = bundle.get(s);
                        obj1 = bundle1.get(s);
                        if ((obj instanceof Bundle) && (obj1 instanceof Bundle) && !b((Bundle)obj, (Bundle)obj1))
                        {
                            return false;
                        }
                        if (obj != null)
                        {
                            continue label1;
                        }
                    } while (obj1 == null && bundle1.containsKey(s));
                    return false;
                } while (obj.equals(obj1));
                return false;
            }
            return true;
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (this == obj)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if (getClass() == obj.getClass())
                    {
                        obj = (OnClickArgs)obj;
                        flag = flag1;
                        if (mOnClickAction == ((OnClickArgs) (obj)).mOnClickAction)
                        {
                            return u.a(mOptions, ((OnClickArgs) (obj)).mOptions, sBundleEqualityTester);
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            int j = mOnClickAction;
            int i;
            if (mOptions != null)
            {
                i = a(mOptions);
            } else
            {
                i = 0;
            }
            return i + j * 31;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(mOnClickAction);
            parcel.writeBundle(mOptions);
        }


        private OnClickArgs(int i)
        {
            this(i, new Bundle());
        }

        private OnClickArgs(int i, Bundle bundle)
        {
            mOnClickAction = i;
            mOptions = bundle;
        }



        private OnClickArgs(Parcel parcel)
        {
            this(parcel.readInt(), parcel.readBundle());
        }

    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(Uri uri, String s);

        public abstract void a(Store store, SingleShoppingListData singleshoppinglistdata);

        public abstract void a(StoreSummary storesummary);

        public abstract void a(e e1);

        public abstract void a(String s);

        public abstract void b();
    }


    private final a mActions;

    public CardStreamOnClickHandler(a a1)
    {
        mActions = a1;
    }

    public static com.target.ui.fragment.cardstream.f.b.e a()
    {
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(3));
    }

    public static com.target.ui.fragment.cardstream.f.b.e a(Uri uri, String s)
    {
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(7, com.c.a.a.a().a("uri", uri).a("title", s).b()));
    }

    public static com.target.ui.fragment.cardstream.f.b.e a(Store store, SingleShoppingListData singleshoppinglistdata)
    {
        store = com.c.a.a.a().a("store", store).b();
        if (singleshoppinglistdata != null)
        {
            store.putParcelable("list_data", singleshoppinglistdata);
        }
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(4, store));
    }

    public static com.target.ui.fragment.cardstream.f.b.e a(StoreSummary storesummary)
    {
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(5, com.c.a.a.a().a("store", storesummary).b()));
    }

    public static com.target.ui.fragment.cardstream.f.b.e a(e e1)
    {
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(2, com.c.a.a.a().a("card_name", e1).b()));
    }

    public static com.target.ui.fragment.cardstream.f.b.e a(String s)
    {
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(1, com.c.a.a.a().a("toast_msg", s).b()));
    }

    public static com.target.ui.fragment.cardstream.f.b.e b()
    {
        return new com.target.ui.fragment.cardstream.f.b.e(new OnClickArgs(6));
    }

    public void a(View view, com.target.ui.fragment.cardstream.f.b.e e1)
    {
        view = (OnClickArgs)e1.param;
        int i = com.target.ui.fragment.cardstream.OnClickArgs.a(view);
        view = OnClickArgs.b(view);
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown action value: ").append(i).toString());

        case 1: // '\001'
            view = view.getString("toast_msg");
            mActions.a(view);
            return;

        case 2: // '\002'
            view = (e)view.getSerializable("card_name");
            mActions.a(view);
            return;

        case 3: // '\003'
            mActions.a();
            return;

        case 4: // '\004'
            e1 = (Store)view.getParcelable("store");
            view = (SingleShoppingListData)view.getParcelable("list_data");
            mActions.a(e1, view);
            return;

        case 5: // '\005'
            view = (StoreSummary)view.getParcelable("store");
            mActions.a(view);
            return;

        case 6: // '\006'
            mActions.b();
            return;

        case 7: // '\007'
            e1 = (Uri)view.getParcelable("uri");
            break;
        }
        view = view.getString("title", "");
        mActions.a(e1, view);
    }
}
