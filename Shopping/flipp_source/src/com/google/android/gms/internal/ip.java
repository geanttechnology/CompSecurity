// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.d;
import com.google.android.gms.location.h;
import com.google.android.gms.location.i;
import com.google.android.gms.location.k;
import com.google.android.gms.location.n;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.e;
import com.google.android.gms.maps.model.f;

// Referenced classes of package com.google.android.gms.internal:
//            io, iq, go, im, 
//            gt, ja, hi, jn, 
//            je, gv, jb, ij, 
//            gh, ih

public abstract class ip extends Binder
    implements io
{

    public static io a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (iinterface != null && (iinterface instanceof io))
        {
            return (io)iinterface;
        } else
        {
            return new iq(ibinder);
        }
    }

    public boolean onTransact(int j, Parcel parcel, Parcel parcel1, int l)
    {
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag = false;
        Object obj20 = null;
        Object obj21 = null;
        Object obj22 = null;
        Object obj23 = null;
        Object obj5 = null;
        Object obj24 = null;
        Object obj25 = null;
        Object obj15 = null;
        Object obj10 = null;
        Object obj12 = null;
        Object obj11 = null;
        Object obj13 = null;
        Object obj26 = null;
        Object obj = null;
        Object obj27 = null;
        Object obj16 = null;
        Object obj17 = null;
        Object obj18 = null;
        Object obj19 = null;
        Object obj14 = null;
        switch (j)
        {
        default:
            return super.onTransact(j, parcel, parcel1, l);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj5 = parcel.createTypedArrayList(go.CREATOR);
            obj = obj14;
            if (parcel.readInt() != 0)
            {
                obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(((java.util.List) (obj5)), ((PendingIntent) (obj)), com.google.android.gms.internal.im.a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj = obj20;
            if (parcel.readInt() != 0)
            {
                obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(((PendingIntent) (obj)), com.google.android.gms.internal.im.a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            a(parcel.createStringArray(), com.google.android.gms.internal.im.a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            a(com.google.android.gms.internal.im.a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            long l1 = parcel.readLong();
            if (parcel.readInt() != 0)
            {
                flag = true;
            }
            obj = obj21;
            if (parcel.readInt() != 0)
            {
                obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(l1, flag, ((PendingIntent) (obj)));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj = obj22;
            if (parcel.readInt() != 0)
            {
                obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(((PendingIntent) (obj)));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel = a();
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj = obj23;
            if (parcel.readInt() != 0)
            {
                obj = LocationRequest.CREATOR;
                obj = h.a(parcel);
            }
            a(((LocationRequest) (obj)), k.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parcel.readInt() != 0)
            {
                obj = LocationRequest.CREATOR;
                obj = h.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                obj5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(((LocationRequest) (obj)), ((PendingIntent) (obj5)));
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            a(k.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj = obj24;
            if (parcel.readInt() != 0)
            {
                obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            b(((PendingIntent) (obj)));
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            boolean flag1 = flag3;
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            }
            a(flag1);
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj = obj25;
            if (parcel.readInt() != 0)
            {
                obj = (Location)Location.CREATOR.createFromParcel(parcel);
            }
            a(((Location) (obj)));
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Object obj6;
            if (parcel.readInt() != 0)
            {
                obj = LatLngBounds.CREATOR;
                obj = e.a(parcel);
            } else
            {
                obj = null;
            }
            j = parcel.readInt();
            if (parcel.readInt() != 0)
            {
                obj6 = gt.CREATOR;
                obj6 = com.google.android.gms.internal.ja.a(parcel);
            } else
            {
                obj6 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj10 = hi.CREATOR;
                obj10 = com.google.android.gms.internal.jn.a(parcel);
            } else
            {
                obj10 = null;
            }
            a(((LatLngBounds) (obj)), j, ((gt) (obj6)), ((hi) (obj10)), com.google.android.gms.internal.je.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s1 = parcel.readString();
            obj = obj15;
            if (parcel.readInt() != 0)
            {
                obj = hi.CREATOR;
                obj = com.google.android.gms.internal.jn.a(parcel);
            }
            a(s1, ((hi) (obj)), com.google.android.gms.internal.je.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Object obj7;
            if (parcel.readInt() != 0)
            {
                obj = LatLng.CREATOR;
                obj = f.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                obj7 = gt.CREATOR;
                obj7 = com.google.android.gms.internal.ja.a(parcel);
            } else
            {
                obj7 = null;
            }
            if (parcel.readInt() != 0)
            {
                obj10 = hi.CREATOR;
                obj10 = com.google.android.gms.internal.jn.a(parcel);
            }
            a(((LatLng) (obj)), ((gt) (obj7)), ((hi) (obj10)), com.google.android.gms.internal.je.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Object obj8;
            if (parcel.readInt() != 0)
            {
                obj = gt.CREATOR;
                obj = com.google.android.gms.internal.ja.a(parcel);
            } else
            {
                obj = null;
            }
            obj8 = obj12;
            if (parcel.readInt() != 0)
            {
                obj8 = hi.CREATOR;
                obj8 = com.google.android.gms.internal.jn.a(parcel);
            }
            a(((gt) (obj)), ((hi) (obj8)), com.google.android.gms.internal.je.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Object obj9;
            PendingIntent pendingintent1;
            if (parcel.readInt() != 0)
            {
                obj = gv.CREATOR;
                obj = com.google.android.gms.internal.jb.a(parcel);
            } else
            {
                obj = null;
            }
            if (parcel.readInt() != 0)
            {
                obj9 = hi.CREATOR;
                obj9 = com.google.android.gms.internal.jn.a(parcel);
            } else
            {
                obj9 = null;
            }
            pendingintent1 = obj11;
            if (parcel.readInt() != 0)
            {
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(((gv) (obj)), ((hi) (obj9)), pendingintent1);
            parcel1.writeNoException();
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            PendingIntent pendingintent;
            if (parcel.readInt() != 0)
            {
                obj = hi.CREATOR;
                obj = com.google.android.gms.internal.jn.a(parcel);
            } else
            {
                obj = null;
            }
            pendingintent = obj13;
            if (parcel.readInt() != 0)
            {
                pendingintent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
            }
            a(((hi) (obj)), pendingintent);
            parcel1.writeNoException();
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            obj = obj26;
            if (parcel.readInt() != 0)
            {
                obj = LocationRequest.CREATOR;
                obj = h.a(parcel);
            }
            a(((LocationRequest) (obj)), k.a(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 21: // '\025'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel = a(parcel.readString());
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }

        case 24: // '\030'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            a(parcel.createTypedArrayList(hd.a.CREATOR));
            return true;

        case 25: // '\031'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s2 = parcel.readString();
            String s7 = parcel.readString();
            parcel1 = ((Parcel) (obj));
            if (parcel.readInt() != 0)
            {
                parcel1 = hi.CREATOR;
                parcel1 = com.google.android.gms.internal.jn.a(parcel);
            }
            a(s2, s7, parcel1);
            return true;

        case 26: // '\032'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            Location location = obj27;
            if (parcel.readInt() != 0)
            {
                location = (Location)Location.CREATOR.createFromParcel(parcel);
            }
            a(location, parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 27: // '\033'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s3 = parcel.readString();
            Object obj1 = obj16;
            if (parcel.readInt() != 0)
            {
                obj1 = a.CREATOR;
                obj1 = i.a(parcel);
            }
            a(s3, ((a) (obj1)), com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 28: // '\034'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s4 = parcel.readString();
            Object obj2 = obj17;
            if (parcel.readInt() != 0)
            {
                obj2 = gh.CREATOR;
                obj2 = com.google.android.gms.internal.ih.a(parcel);
            }
            a(s4, ((gh) (obj2)), com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 29: // '\035'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            a(parcel.readString(), com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 30: // '\036'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s5 = parcel.readString();
            Object obj3 = obj18;
            if (parcel.readInt() != 0)
            {
                obj3 = com.google.android.gms.location.f.CREATOR;
                obj3 = n.a(parcel);
            }
            a(s5, ((com.google.android.gms.location.f) (obj3)), com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 31: // '\037'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s6 = parcel.readString();
            Object obj4 = obj19;
            if (parcel.readInt() != 0)
            {
                obj4 = com.google.android.gms.location.f.CREATOR;
                obj4 = n.a(parcel);
            }
            b(s6, ((com.google.android.gms.location.f) (obj4)), com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 32: // ' '
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            String s = parcel.readString();
            boolean flag2 = flag4;
            if (parcel.readInt() != 0)
            {
                flag2 = true;
            }
            a(s, flag2, com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 33: // '!'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            b(parcel.readString(), com.google.android.gms.internal.ij.a(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 34: // '"'
            parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel = b(parcel.readString());
            parcel1.writeNoException();
            break;
        }
        if (parcel != null)
        {
            parcel1.writeInt(1);
            parcel.writeToParcel(parcel1, 1);
            return true;
        } else
        {
            parcel1.writeInt(0);
            return true;
        }
    }
}
