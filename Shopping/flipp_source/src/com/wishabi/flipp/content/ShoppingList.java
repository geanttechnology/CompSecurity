// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.wishabi.flipp.util.b;
import com.wishabi.flipp.util.d;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.m;
import com.wishabi.flipp.util.o;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.wishabi.flipp.content:
//            ap, SimpleSearchResult, az, ar, 
//            i, aq

public class ShoppingList
    implements android.app.LoaderManager.LoaderCallbacks, Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ap();
    l a;
    Cursor b;
    public final int c;
    public Context d;
    public ar e;
    public long f;
    public int g;
    private final HashMap h;
    private HashSet i;

    public ShoppingList(int j)
    {
        f = -1L;
        c = j;
        h = new HashMap();
    }

    public ShoppingList(Parcel parcel)
    {
        f = -1L;
        c = parcel.readInt();
        f = parcel.readLong();
        h = new HashMap();
        int k = parcel.readInt();
        for (int j = 0; j < k; j++)
        {
            h.put(Long.valueOf(parcel.readLong()), (SimpleSearchResult)parcel.readParcelable(com/wishabi/flipp/content/SimpleSearchResult.getClassLoader()));
        }

    }

    private void a(Cursor cursor)
    {
        int j = cursor.getColumnIndexOrThrow("_id");
        i = new HashSet();
        for (boolean flag = cursor.moveToFirst(); flag; flag = cursor.moveToNext())
        {
            i.add(Long.valueOf(cursor.getLong(j)));
        }

        d();
    }

    private void a(az az1, boolean flag)
    {
        Object obj = (SimpleSearchResult)h.get(Long.valueOf(az1.a()));
        if (obj != null && i != null)
        {
            obj = new HashSet(((SimpleSearchResult) (obj)).a);
            ((HashSet) (obj)).retainAll(i);
            az1.b = ((HashSet) (obj)).size();
        } else
        {
            az1.b = -1;
        }
        if (flag && e != null)
        {
            e.a(a.c(az1.a()));
        }
    }

    private void d()
    {
        if (a != null && i != null)
        {
            Iterator iterator = a.iterator();
            while (iterator.hasNext()) 
            {
                o o1 = (o)iterator.next();
                int j = 0;
                while (j < o1.b()) 
                {
                    a((az)o1.a(j).e, true);
                    j++;
                }
            }
        }
    }

    public final int a()
    {
        if (a == null || b == null || b.isClosed())
        {
            return 0;
        } else
        {
            return a.c();
        }
    }

    public final int a(int j)
    {
        if (a == null || a.d(j) == null)
        {
            return -1;
        } else
        {
            return a.d(j).d;
        }
    }

    public final int a(long l1)
    {
        if (a == null)
        {
            return -1;
        } else
        {
            return a.c(l1);
        }
    }

    public final int a(az az1)
    {
        if (a == null || az1 == null)
        {
            return -1;
        } else
        {
            return a.a(az1.a()).c;
        }
    }

    public final Uri a(String s)
    {
        if (s == null || s.equals(""))
        {
            return null;
        } else
        {
            ContentResolver contentresolver = d.getContentResolver();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("name", s);
            contentvalues.put("position", Integer.valueOf(0));
            contentvalues.put("checked", Integer.valueOf(0));
            contentvalues.put("datetime_updated", Long.valueOf(System.currentTimeMillis()));
            contentvalues.put("shopping_list_id", Integer.valueOf(c));
            return contentresolver.insert(i.k, contentvalues);
        }
    }

    public final void a(long l1, SimpleSearchResult simplesearchresult)
    {
        h.put(Long.valueOf(l1), simplesearchresult);
        simplesearchresult = b(l1);
        if (simplesearchresult == null)
        {
            return;
        } else
        {
            a(((az) (simplesearchresult)), true);
            return;
        }
    }

    public final int b()
    {
        if (a == null || b == null || b.isClosed())
        {
            return 0;
        } else
        {
            return a.c() - a.a.size();
        }
    }

    public final az b(long l1)
    {
        if (a == null || a.a(l1) == null)
        {
            return null;
        } else
        {
            return (az)a.b(l1);
        }
    }

    public final String b(int j)
    {
        o o1;
        if (a != null)
        {
            if ((o1 = a.c(j)) != null)
            {
                return o1.e;
            }
        }
        return null;
    }

    public final void b(az az1)
    {
        d.getContentResolver().delete(i.k, "id = ?", new String[] {
            Long.toString(az1.a())
        });
    }

    public final SimpleSearchResult c(long l1)
    {
        return (SimpleSearchResult)h.get(Long.valueOf(l1));
    }

    public final void c()
    {
        h.clear();
        d();
    }

    public final void d(long l1)
    {
        h.remove(Long.valueOf(l1));
        a(b(l1), false);
    }

    public int describeContents()
    {
        return 0;
    }

    public Loader onCreateLoader(int j, Bundle bundle)
    {
        switch (j)
        {
        default:
            throw new InvalidParameterException("Invalid loader requested");

        case 0: // '\0'
            bundle = d;
            Uri uri = i.k;
            String s = Integer.toString(c);
            return new CursorLoader(bundle, uri, new String[] {
                "*", "category", "cat_position"
            }, "shopping_list_id = ?", new String[] {
                s
            }, "cat_position ASC, LOWER(name) ASC, id ASC");

        case 1: // '\001'
            return new CursorLoader(d, i.g, new String[] {
                "_id"
            }, null, null, null);
        }
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        Cursor cursor = (Cursor)obj;
        switch (loader.getId())
        {
        default:
            throw new InvalidParameterException("Invalid loader requested");

        case 0: // '\0'
            if (b == cursor)
            {
                if (e != null)
                {
                    e.a();
                }
            } else
            {
                l l1 = a;
                l l2;
                ArrayList arraylist;
                ArrayList arraylist1;
                ArrayList arraylist2;
                if (b != null && !b.isClosed())
                {
                    obj = b;
                } else
                {
                    obj = new MatrixCursor(new String[] {
                        "cat_position", "name", "id"
                    });
                }
                g = 0;
                l2 = new l();
                arraylist2 = new ArrayList();
                arraylist = new ArrayList();
                arraylist1 = new ArrayList();
                if (((Cursor) (obj)).getCount() > 0 || cursor.getCount() > 0)
                {
                    int j2 = cursor.getColumnIndexOrThrow("id");
                    b b1 = new b(((Cursor) (obj)), new String[] {
                        "cat_position", "name", "id"
                    }, cursor, new String[] {
                        "cat_position", "name", "id"
                    });
                    int j = -1;
                    loader = null;
                    Iterator iterator = b1.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        d d1 = (d)iterator.next();
                        switch (aq.a[d1.ordinal()])
                        {
                        default:
                            break;

                        case 1: // '\001'
                        case 2: // '\002'
                            long l3 = cursor.getLong(j2);
                            az az1;
                            Object obj1;
                            int j1;
                            if (l1 != null)
                            {
                                obj1 = (az)l1.b(l3);
                            } else
                            {
                                obj1 = null;
                            }
                            if (obj1 != null)
                            {
                                az1 = new az(((az) (obj1)), cursor, cursor.getPosition());
                            } else
                            {
                                az1 = new az(cursor, cursor.getPosition());
                            }
                            if (d1 == d.a)
                            {
                                arraylist2.add(az1);
                                a(az1, false);
                            } else
                            if (obj1 != null && ((az) (obj1)).e() != az1.e())
                            {
                                arraylist.add(az1);
                            }
                            if (az1.c())
                            {
                                g = g + 1;
                            }
                            j1 = az1.d();
                            if (loader == null || j1 != j)
                            {
                                if (loader != null)
                                {
                                    l2.a(loader);
                                }
                                if (j1 == 1000)
                                {
                                    loader = d.getString(0x7f0e0024);
                                } else
                                {
                                    if (az.a == -1)
                                    {
                                        throw new IllegalAccessError("Trying to grab category for ShoppingListItem without joining on the query");
                                    }
                                    az1.f();
                                    loader = az1.d.getString(az.a);
                                    az1.g();
                                }
                                j = -2 - j1;
                                obj1 = new o(j, loader);
                                ((o) (obj1)).a(new m(j, 1, loader));
                                j = j1;
                                loader = ((Loader) (obj1));
                            }
                            loader.b(new m(l3, 0, az1));
                            continue;

                        case 3: // '\003'
                            long l4 = ((Cursor) (obj)).getLong(j2);
                            if (l1 == null)
                            {
                                throw new IllegalStateException("Item removed but old items no longer in memory");
                            }
                            az az2 = (az)l1.b(l4);
                            if (az2 != null)
                            {
                                arraylist1.add(az2);
                            }
                            break;
                        }
                    } while (true);
                    if (loader != null)
                    {
                        l2.a(loader);
                    }
                }
                a = l2;
                b = cursor;
                if (e != null)
                {
                    if (l1 == null)
                    {
                        d();
                        e.a(this);
                        return;
                    }
                    if (arraylist2.size() + arraylist1.size() + arraylist.size() > 1)
                    {
                        e.a(this);
                        return;
                    }
                    loader = arraylist2.iterator();
                    while (loader.hasNext()) 
                    {
                        obj = (az)loader.next();
                        int k = ((az) (obj)).d();
                        ar ar1 = e;
                        int k1 = a(((az) (obj)));
                        boolean flag;
                        if (l1.a(-2 - k) == null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        ar1.a(((az) (obj)), k1, flag);
                        (new StringBuilder("Added ")).append(((az) (obj)).b());
                    }
                    loader = arraylist1.iterator();
                    while (loader.hasNext()) 
                    {
                        obj = (az)loader.next();
                        int i1 = ((az) (obj)).d();
                        ar ar2 = e;
                        int i2 = l1.c(((az) (obj)).a());
                        boolean flag1;
                        if (l2.a(-2 - i1) == null)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        ar2.b(((az) (obj)), i2, flag1);
                        (new StringBuilder("Removed ")).append(((az) (obj)).b());
                    }
                    loader = arraylist.iterator();
                    while (loader.hasNext()) 
                    {
                        obj = (az)loader.next();
                        e.a(a(((az) (obj))));
                        (new StringBuilder("Edited ")).append(((az) (obj)).b());
                    }
                }
            }
            return;

        case 1: // '\001'
            a(cursor);
            return;
        }
    }

    public void onLoaderReset(Loader loader)
    {
        a = null;
        b = null;
        i = null;
        if (e != null)
        {
            e.a(this);
        }
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeInt(c);
        parcel.writeLong(f);
        parcel.writeInt(h.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = h.entrySet().iterator(); iterator.hasNext(); parcel.writeParcelable((Parcelable)entry.getValue(), j))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeLong(((Long)entry.getKey()).longValue());
        }

    }

}
