// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

// Referenced classes of package android.support.v4.media.session:
//            a, PlaybackStateCompat, ParcelableVolumeInfo

public static abstract class a.a extends Binder
    implements android.support.v4.media.session.a
{
    private static final class a
        implements android.support.v4.media.session.a
    {

        private IBinder a;

        public final void a()
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            a.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        public final void a(Bundle bundle)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            a.transact(7, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            bundle;
            parcel.recycle();
            throw bundle;
        }

        public final void a(MediaMetadataCompat mediametadatacompat)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (mediametadatacompat == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            mediametadatacompat.writeToParcel(parcel, 0);
_L1:
            a.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            mediametadatacompat;
            parcel.recycle();
            throw mediametadatacompat;
        }

        public final void a(ParcelableVolumeInfo parcelablevolumeinfo)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (parcelablevolumeinfo == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            parcelablevolumeinfo.writeToParcel(parcel, 0);
_L1:
            a.transact(8, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            parcelablevolumeinfo;
            parcel.recycle();
            throw parcelablevolumeinfo;
        }

        public final void a(PlaybackStateCompat playbackstatecompat)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (playbackstatecompat == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            playbackstatecompat.writeToParcel(parcel, 0);
_L1:
            a.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            playbackstatecompat;
            parcel.recycle();
            throw playbackstatecompat;
        }

        public final void a(CharSequence charsequence)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            if (charsequence == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            TextUtils.writeToParcel(charsequence, parcel, 0);
_L1:
            a.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            charsequence;
            parcel.recycle();
            throw charsequence;
        }

        public final void a(String s, Bundle bundle)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel.writeString(s);
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            a.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            s;
            parcel.recycle();
            throw s;
        }

        public final void a(List list)
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcel.writeTypedList(list);
            a.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            list;
            parcel.recycle();
            throw list;
        }

        public final IBinder asBinder()
        {
            return a;
        }

        a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public static android.support.v4.media.session.a a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
        if (iinterface != null && (iinterface instanceof android.support.v4.media.session.a))
        {
            return (android.support.v4.media.session.a)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        String s = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            s = parcel.readString();
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(s, parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            parcel1 = s;
            if (parcel.readInt() != 0)
            {
                parcel1 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a(parcel.createTypedArrayList(aSessionCompat.QueueItem.CREATOR));
            return true;

        case 6: // '\006'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            parcel1 = obj2;
            if (parcel.readInt() != 0)
            {
                parcel1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            parcel1 = obj3;
            if (parcel.readInt() != 0)
            {
                parcel1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(parcel1);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            parcel1 = obj4;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
        }
        a(parcel1);
        return true;
    }
}
