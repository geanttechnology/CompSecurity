// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzam, GetMetadataRequest, QueryRequest, UpdateMetadataRequest, 
//            CreateContentsRequest, CreateFileRequest, CreateFolderRequest, OpenContentsRequest, 
//            DriveServiceResponse, CloseContentsRequest, OpenFileIntentSenderRequest, CreateFileIntentSenderRequest, 
//            AuthorizeAccessRequest, ListParentsRequest, AddEventListenerRequest, RemoveEventListenerRequest, 
//            DisconnectRequest, TrashResourceRequest, CloseContentsAndUpdateMetadataRequest, DeleteResourceRequest, 
//            LoadRealtimeRequest, SetResourceParentsRequest, GetDriveIdFromUniqueIdentifierRequest, CheckResourceIdsExistRequest, 
//            SetDrivePreferencesRequest, SetFileUploadPreferencesRequest, CancelPendingActionsRequest, UntrashResourceRequest, 
//            FetchThumbnailRequest, GetChangesRequest, UnsubscribeResourceRequest, GetPermissionsRequest, 
//            AddPermissionRequest, UpdatePermissionRequest, RemovePermissionRequest, ControlProgressRequest, 
//            ChangeResourceParentsRequest, StreamContentsRequest, zzan, zzao

public static abstract class zza.zznJ extends Binder
    implements zzam
{
    private static class zza
        implements zzam
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public IntentSender zza(CreateFileIntentSenderRequest createfileintentsenderrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (createfileintentsenderrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            createfileintentsenderrequest.writeToParcel(parcel, 0);
_L3:
            zznJ.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            createfileintentsenderrequest = (IntentSender)IntentSender.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return createfileintentsenderrequest;
_L2:
            parcel.writeInt(0);
              goto _L3
            createfileintentsenderrequest;
            parcel1.recycle();
            parcel.recycle();
            throw createfileintentsenderrequest;
            createfileintentsenderrequest = null;
              goto _L4
        }

        public IntentSender zza(OpenFileIntentSenderRequest openfileintentsenderrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (openfileintentsenderrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            openfileintentsenderrequest.writeToParcel(parcel, 0);
_L3:
            zznJ.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            openfileintentsenderrequest = (IntentSender)IntentSender.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return openfileintentsenderrequest;
_L2:
            parcel.writeInt(0);
              goto _L3
            openfileintentsenderrequest;
            parcel1.recycle();
            parcel.recycle();
            throw openfileintentsenderrequest;
            openfileintentsenderrequest = null;
              goto _L4
        }

        public DriveServiceResponse zza(OpenContentsRequest opencontentsrequest, zzan zzan1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (opencontentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            opencontentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_133;
            }
            opencontentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(opencontentsrequest);
            zznJ.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            opencontentsrequest = obj;
            if (parcel1.readInt() != 0)
            {
                opencontentsrequest = (DriveServiceResponse)DriveServiceResponse.CREATOR.createFromParcel(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return opencontentsrequest;
_L2:
            parcel.writeInt(0);
              goto _L3
            opencontentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw opencontentsrequest;
            opencontentsrequest = null;
              goto _L4
        }

        public DriveServiceResponse zza(StreamContentsRequest streamcontentsrequest, zzan zzan1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (streamcontentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            streamcontentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_133;
            }
            streamcontentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(streamcontentsrequest);
            zznJ.transact(56, parcel, parcel1, 0);
            parcel1.readException();
            streamcontentsrequest = obj;
            if (parcel1.readInt() != 0)
            {
                streamcontentsrequest = (DriveServiceResponse)DriveServiceResponse.CREATOR.createFromParcel(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return streamcontentsrequest;
_L2:
            parcel.writeInt(0);
              goto _L3
            streamcontentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw streamcontentsrequest;
            streamcontentsrequest = null;
              goto _L4
        }

        public void zza(RealtimeDocumentSyncRequest realtimedocumentsyncrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (realtimedocumentsyncrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            realtimedocumentsyncrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            realtimedocumentsyncrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(realtimedocumentsyncrequest);
            zznJ.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            realtimedocumentsyncrequest;
            parcel1.recycle();
            parcel.recycle();
            throw realtimedocumentsyncrequest;
            realtimedocumentsyncrequest = null;
              goto _L4
        }

        public void zza(AddEventListenerRequest addeventlistenerrequest, zzao zzao1, String s, zzan zzan1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (addeventlistenerrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            addeventlistenerrequest.writeToParcel(parcel, 0);
_L3:
            if (zzao1 == null)
            {
                break MISSING_BLOCK_LABEL_137;
            }
            addeventlistenerrequest = zzao1.asBinder();
_L4:
            parcel.writeStrongBinder(addeventlistenerrequest);
            parcel.writeString(s);
            addeventlistenerrequest = obj;
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            addeventlistenerrequest = zzan1.asBinder();
            parcel.writeStrongBinder(addeventlistenerrequest);
            zznJ.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            addeventlistenerrequest;
            parcel1.recycle();
            parcel.recycle();
            throw addeventlistenerrequest;
            addeventlistenerrequest = null;
              goto _L4
        }

        public void zza(AddPermissionRequest addpermissionrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (addpermissionrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            addpermissionrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            addpermissionrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(addpermissionrequest);
            zznJ.transact(48, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            addpermissionrequest;
            parcel1.recycle();
            parcel.recycle();
            throw addpermissionrequest;
            addpermissionrequest = null;
              goto _L4
        }

        public void zza(AuthorizeAccessRequest authorizeaccessrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (authorizeaccessrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            authorizeaccessrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            authorizeaccessrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(authorizeaccessrequest);
            zznJ.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            authorizeaccessrequest;
            parcel1.recycle();
            parcel.recycle();
            throw authorizeaccessrequest;
            authorizeaccessrequest = null;
              goto _L4
        }

        public void zza(CancelPendingActionsRequest cancelpendingactionsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (cancelpendingactionsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            cancelpendingactionsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            cancelpendingactionsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(cancelpendingactionsrequest);
            zznJ.transact(37, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            cancelpendingactionsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw cancelpendingactionsrequest;
            cancelpendingactionsrequest = null;
              goto _L4
        }

        public void zza(ChangeResourceParentsRequest changeresourceparentsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (changeresourceparentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            changeresourceparentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            changeresourceparentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(changeresourceparentsrequest);
            zznJ.transact(55, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            changeresourceparentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw changeresourceparentsrequest;
            changeresourceparentsrequest = null;
              goto _L4
        }

        public void zza(CheckResourceIdsExistRequest checkresourceidsexistrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (checkresourceidsexistrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            checkresourceidsexistrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            checkresourceidsexistrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(checkresourceidsexistrequest);
            zznJ.transact(30, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            checkresourceidsexistrequest;
            parcel1.recycle();
            parcel.recycle();
            throw checkresourceidsexistrequest;
            checkresourceidsexistrequest = null;
              goto _L4
        }

        public void zza(CloseContentsAndUpdateMetadataRequest closecontentsandupdatemetadatarequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (closecontentsandupdatemetadatarequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            closecontentsandupdatemetadatarequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            closecontentsandupdatemetadatarequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(closecontentsandupdatemetadatarequest);
            zznJ.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            closecontentsandupdatemetadatarequest;
            parcel1.recycle();
            parcel.recycle();
            throw closecontentsandupdatemetadatarequest;
            closecontentsandupdatemetadatarequest = null;
              goto _L4
        }

        public void zza(CloseContentsRequest closecontentsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (closecontentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            closecontentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            closecontentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(closecontentsrequest);
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            closecontentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw closecontentsrequest;
            closecontentsrequest = null;
              goto _L4
        }

        public void zza(ControlProgressRequest controlprogressrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (controlprogressrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            controlprogressrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            controlprogressrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(controlprogressrequest);
            zznJ.transact(53, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            controlprogressrequest;
            parcel1.recycle();
            parcel.recycle();
            throw controlprogressrequest;
            controlprogressrequest = null;
              goto _L4
        }

        public void zza(CreateContentsRequest createcontentsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (createcontentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            createcontentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            createcontentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(createcontentsrequest);
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            createcontentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw createcontentsrequest;
            createcontentsrequest = null;
              goto _L4
        }

        public void zza(CreateFileRequest createfilerequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (createfilerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            createfilerequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            createfilerequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(createfilerequest);
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            createfilerequest;
            parcel1.recycle();
            parcel.recycle();
            throw createfilerequest;
            createfilerequest = null;
              goto _L4
        }

        public void zza(CreateFolderRequest createfolderrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (createfolderrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            createfolderrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            createfolderrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(createfolderrequest);
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            createfolderrequest;
            parcel1.recycle();
            parcel.recycle();
            throw createfolderrequest;
            createfolderrequest = null;
              goto _L4
        }

        public void zza(DeleteResourceRequest deleteresourcerequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (deleteresourcerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            deleteresourcerequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            deleteresourcerequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(deleteresourcerequest);
            zznJ.transact(24, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            deleteresourcerequest;
            parcel1.recycle();
            parcel.recycle();
            throw deleteresourcerequest;
            deleteresourcerequest = null;
              goto _L4
        }

        public void zza(DisconnectRequest disconnectrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (disconnectrequest == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            disconnectrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            disconnectrequest;
            parcel1.recycle();
            parcel.recycle();
            throw disconnectrequest;
        }

        public void zza(FetchThumbnailRequest fetchthumbnailrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (fetchthumbnailrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            fetchthumbnailrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            fetchthumbnailrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(fetchthumbnailrequest);
            zznJ.transact(42, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            fetchthumbnailrequest;
            parcel1.recycle();
            parcel.recycle();
            throw fetchthumbnailrequest;
            fetchthumbnailrequest = null;
              goto _L4
        }

        public void zza(GetChangesRequest getchangesrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (getchangesrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            getchangesrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            getchangesrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(getchangesrequest);
            zznJ.transact(44, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            getchangesrequest;
            parcel1.recycle();
            parcel.recycle();
            throw getchangesrequest;
            getchangesrequest = null;
              goto _L4
        }

        public void zza(GetDriveIdFromUniqueIdentifierRequest getdriveidfromuniqueidentifierrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (getdriveidfromuniqueidentifierrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            getdriveidfromuniqueidentifierrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            getdriveidfromuniqueidentifierrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(getdriveidfromuniqueidentifierrequest);
            zznJ.transact(29, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            getdriveidfromuniqueidentifierrequest;
            parcel1.recycle();
            parcel.recycle();
            throw getdriveidfromuniqueidentifierrequest;
            getdriveidfromuniqueidentifierrequest = null;
              goto _L4
        }

        public void zza(GetMetadataRequest getmetadatarequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (getmetadatarequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            getmetadatarequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            getmetadatarequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(getmetadatarequest);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            getmetadatarequest;
            parcel1.recycle();
            parcel.recycle();
            throw getmetadatarequest;
            getmetadatarequest = null;
              goto _L4
        }

        public void zza(GetPermissionsRequest getpermissionsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (getpermissionsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            getpermissionsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            getpermissionsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(getpermissionsrequest);
            zznJ.transact(47, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            getpermissionsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw getpermissionsrequest;
            getpermissionsrequest = null;
              goto _L4
        }

        public void zza(ListParentsRequest listparentsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (listparentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            listparentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            listparentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(listparentsrequest);
            zznJ.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            listparentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw listparentsrequest;
            listparentsrequest = null;
              goto _L4
        }

        public void zza(LoadRealtimeRequest loadrealtimerequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (loadrealtimerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            loadrealtimerequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            loadrealtimerequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(loadrealtimerequest);
            zznJ.transact(27, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            loadrealtimerequest;
            parcel1.recycle();
            parcel.recycle();
            throw loadrealtimerequest;
            loadrealtimerequest = null;
              goto _L4
        }

        public void zza(QueryRequest queryrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (queryrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            queryrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            queryrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(queryrequest);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            queryrequest;
            parcel1.recycle();
            parcel.recycle();
            throw queryrequest;
            queryrequest = null;
              goto _L4
        }

        public void zza(QueryRequest queryrequest, zzao zzao1, zzan zzan1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (queryrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            queryrequest.writeToParcel(parcel, 0);
_L3:
            if (zzao1 == null)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            queryrequest = zzao1.asBinder();
_L4:
            parcel.writeStrongBinder(queryrequest);
            queryrequest = obj;
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            queryrequest = zzan1.asBinder();
            parcel.writeStrongBinder(queryrequest);
            zznJ.transact(51, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            queryrequest;
            parcel1.recycle();
            parcel.recycle();
            throw queryrequest;
            queryrequest = null;
              goto _L4
        }

        public void zza(RemoveEventListenerRequest removeeventlistenerrequest, zzao zzao1, String s, zzan zzan1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (removeeventlistenerrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            removeeventlistenerrequest.writeToParcel(parcel, 0);
_L3:
            if (zzao1 == null)
            {
                break MISSING_BLOCK_LABEL_137;
            }
            removeeventlistenerrequest = zzao1.asBinder();
_L4:
            parcel.writeStrongBinder(removeeventlistenerrequest);
            parcel.writeString(s);
            removeeventlistenerrequest = obj;
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            removeeventlistenerrequest = zzan1.asBinder();
            parcel.writeStrongBinder(removeeventlistenerrequest);
            zznJ.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            removeeventlistenerrequest;
            parcel1.recycle();
            parcel.recycle();
            throw removeeventlistenerrequest;
            removeeventlistenerrequest = null;
              goto _L4
        }

        public void zza(RemovePermissionRequest removepermissionrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (removepermissionrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            removepermissionrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            removepermissionrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(removepermissionrequest);
            zznJ.transact(50, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            removepermissionrequest;
            parcel1.recycle();
            parcel.recycle();
            throw removepermissionrequest;
            removepermissionrequest = null;
              goto _L4
        }

        public void zza(SetDrivePreferencesRequest setdrivepreferencesrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (setdrivepreferencesrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            setdrivepreferencesrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            setdrivepreferencesrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(setdrivepreferencesrequest);
            zznJ.transact(33, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            setdrivepreferencesrequest;
            parcel1.recycle();
            parcel.recycle();
            throw setdrivepreferencesrequest;
            setdrivepreferencesrequest = null;
              goto _L4
        }

        public void zza(SetFileUploadPreferencesRequest setfileuploadpreferencesrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (setfileuploadpreferencesrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            setfileuploadpreferencesrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            setfileuploadpreferencesrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(setfileuploadpreferencesrequest);
            zznJ.transact(36, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            setfileuploadpreferencesrequest;
            parcel1.recycle();
            parcel.recycle();
            throw setfileuploadpreferencesrequest;
            setfileuploadpreferencesrequest = null;
              goto _L4
        }

        public void zza(SetResourceParentsRequest setresourceparentsrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (setresourceparentsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            setresourceparentsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            setresourceparentsrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(setresourceparentsrequest);
            zznJ.transact(28, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            setresourceparentsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw setresourceparentsrequest;
            setresourceparentsrequest = null;
              goto _L4
        }

        public void zza(TrashResourceRequest trashresourcerequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (trashresourcerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            trashresourcerequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            trashresourcerequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(trashresourcerequest);
            zznJ.transact(17, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            trashresourcerequest;
            parcel1.recycle();
            parcel.recycle();
            throw trashresourcerequest;
            trashresourcerequest = null;
              goto _L4
        }

        public void zza(UnsubscribeResourceRequest unsubscriberesourcerequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (unsubscriberesourcerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            unsubscriberesourcerequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            unsubscriberesourcerequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(unsubscriberesourcerequest);
            zznJ.transact(46, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            unsubscriberesourcerequest;
            parcel1.recycle();
            parcel.recycle();
            throw unsubscriberesourcerequest;
            unsubscriberesourcerequest = null;
              goto _L4
        }

        public void zza(UntrashResourceRequest untrashresourcerequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (untrashresourcerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            untrashresourcerequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            untrashresourcerequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(untrashresourcerequest);
            zznJ.transact(38, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            untrashresourcerequest;
            parcel1.recycle();
            parcel.recycle();
            throw untrashresourcerequest;
            untrashresourcerequest = null;
              goto _L4
        }

        public void zza(UpdateMetadataRequest updatemetadatarequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (updatemetadatarequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            updatemetadatarequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            updatemetadatarequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(updatemetadatarequest);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            updatemetadatarequest;
            parcel1.recycle();
            parcel.recycle();
            throw updatemetadatarequest;
            updatemetadatarequest = null;
              goto _L4
        }

        public void zza(UpdatePermissionRequest updatepermissionrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (updatepermissionrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            updatepermissionrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            updatepermissionrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(updatepermissionrequest);
            zznJ.transact(49, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            updatepermissionrequest;
            parcel1.recycle();
            parcel.recycle();
            throw updatepermissionrequest;
            updatepermissionrequest = null;
              goto _L4
        }

        public void zza(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        public void zza(zzao zzao1, zzan zzan1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzao1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            zzao1 = zzao1.asBinder();
_L1:
            parcel.writeStrongBinder(zzao1);
            zzao1 = obj;
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            zzao1 = zzan1.asBinder();
            parcel.writeStrongBinder(zzao1);
            zznJ.transact(52, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzao1 = null;
              goto _L1
            zzao1;
            parcel1.recycle();
            parcel.recycle();
            throw zzao1;
        }

        public void zzb(QueryRequest queryrequest, zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (queryrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            queryrequest.writeToParcel(parcel, 0);
_L3:
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            queryrequest = zzan1.asBinder();
_L4:
            parcel.writeStrongBinder(queryrequest);
            zznJ.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            queryrequest;
            parcel1.recycle();
            parcel.recycle();
            throw queryrequest;
            queryrequest = null;
              goto _L4
        }

        public void zzb(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(31, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        public void zzc(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(32, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        public void zzd(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(35, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        public void zze(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(41, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        public void zzf(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(43, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        public void zzg(zzan zzan1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
            if (zzan1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzan1 = zzan1.asBinder();
_L1:
            parcel.writeStrongBinder(zzan1);
            zznJ.transact(54, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzan1 = null;
              goto _L1
            zzan1;
            parcel1.recycle();
            parcel.recycle();
            throw zzan1;
        }

        zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static zzam zzaS(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
        if (iinterface != null && (iinterface instanceof zzam))
        {
            return (zzam)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Object obj10 = null;
        Object obj11 = null;
        Object obj12 = null;
        Object obj13 = null;
        Object obj14 = null;
        Object obj15 = null;
        Object obj16 = null;
        Object obj17 = null;
        Object obj18 = null;
        Object obj19 = null;
        Object obj20 = null;
        Object obj21 = null;
        Object obj22 = null;
        Object obj23 = null;
        Object obj24 = null;
        Object obj25 = null;
        Object obj26 = null;
        Object obj27 = null;
        Object obj28 = null;
        Object obj29 = null;
        Object obj30 = null;
        Object obj31 = null;
        Object obj32 = null;
        Object obj33 = null;
        Object obj34 = null;
        Object obj35 = null;
        Object obj36 = null;
        Object obj37 = null;
        Object obj38 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.drive.internal.IDriveService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            if (parcel.readInt() != 0)
            {
                obj = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((GetMetadataRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = (QueryRequest)QueryRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((QueryRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj2;
            if (parcel.readInt() != 0)
            {
                obj = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((UpdateMetadataRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj3;
            if (parcel.readInt() != 0)
            {
                obj = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CreateContentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj4;
            if (parcel.readInt() != 0)
            {
                obj = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CreateFileRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj5;
            if (parcel.readInt() != 0)
            {
                obj = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CreateFolderRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj6;
            if (parcel.readInt() != 0)
            {
                obj = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(parcel);
            }
            parcel = zza(((OpenContentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj7;
            if (parcel.readInt() != 0)
            {
                obj = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CloseContentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zza(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj8;
            if (parcel.readInt() != 0)
            {
                obj = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(parcel);
            }
            parcel = zza(((OpenFileIntentSenderRequest) (obj)));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj9;
            if (parcel.readInt() != 0)
            {
                obj = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(parcel);
            }
            parcel = zza(((CreateFileIntentSenderRequest) (obj)));
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj10;
            if (parcel.readInt() != 0)
            {
                obj = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((AuthorizeAccessRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj11;
            if (parcel.readInt() != 0)
            {
                obj = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((ListParentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj12;
            if (parcel.readInt() != 0)
            {
                obj = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((AddEventListenerRequest) (obj)), zzaU(parcel.readStrongBinder()), parcel.readString(), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj13;
            if (parcel.readInt() != 0)
            {
                obj = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((RemoveEventListenerRequest) (obj)), zzaU(parcel.readStrongBinder()), parcel.readString(), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj14;
            if (parcel.readInt() != 0)
            {
                obj = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((DisconnectRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj15;
            if (parcel.readInt() != 0)
            {
                obj = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((TrashResourceRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj16;
            if (parcel.readInt() != 0)
            {
                obj = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CloseContentsAndUpdateMetadataRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj17;
            if (parcel.readInt() != 0)
            {
                obj = (QueryRequest)QueryRequest.CREATOR.createFromParcel(parcel);
            }
            zzb(((QueryRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 24: // '\030'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj18;
            if (parcel.readInt() != 0)
            {
                obj = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((DeleteResourceRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 27: // '\033'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj19;
            if (parcel.readInt() != 0)
            {
                obj = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((LoadRealtimeRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 28: // '\034'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj20;
            if (parcel.readInt() != 0)
            {
                obj = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SetResourceParentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 29: // '\035'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj21;
            if (parcel.readInt() != 0)
            {
                obj = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((GetDriveIdFromUniqueIdentifierRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 30: // '\036'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj22;
            if (parcel.readInt() != 0)
            {
                obj = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CheckResourceIdsExistRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 31: // '\037'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zzb(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 32: // ' '
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zzc(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 33: // '!'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj23;
            if (parcel.readInt() != 0)
            {
                obj = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SetDrivePreferencesRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 34: // '"'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj24;
            if (parcel.readInt() != 0)
            {
                obj = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((RealtimeDocumentSyncRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 35: // '#'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zzd(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 36: // '$'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj25;
            if (parcel.readInt() != 0)
            {
                obj = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SetFileUploadPreferencesRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 37: // '%'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj26;
            if (parcel.readInt() != 0)
            {
                obj = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((CancelPendingActionsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 38: // '&'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj27;
            if (parcel.readInt() != 0)
            {
                obj = (UntrashResourceRequest)UntrashResourceRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((UntrashResourceRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 41: // ')'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zze(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 42: // '*'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj28;
            if (parcel.readInt() != 0)
            {
                obj = (FetchThumbnailRequest)FetchThumbnailRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((FetchThumbnailRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 43: // '+'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zzf(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 44: // ','
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj29;
            if (parcel.readInt() != 0)
            {
                obj = (GetChangesRequest)GetChangesRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((GetChangesRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 46: // '.'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj30;
            if (parcel.readInt() != 0)
            {
                obj = (UnsubscribeResourceRequest)UnsubscribeResourceRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((UnsubscribeResourceRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 47: // '/'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj31;
            if (parcel.readInt() != 0)
            {
                obj = (GetPermissionsRequest)GetPermissionsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((GetPermissionsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 48: // '0'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj32;
            if (parcel.readInt() != 0)
            {
                obj = (AddPermissionRequest)AddPermissionRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((AddPermissionRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 49: // '1'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj33;
            if (parcel.readInt() != 0)
            {
                obj = (UpdatePermissionRequest)UpdatePermissionRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((UpdatePermissionRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 50: // '2'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj34;
            if (parcel.readInt() != 0)
            {
                obj = (RemovePermissionRequest)RemovePermissionRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((RemovePermissionRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 51: // '3'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj35;
            if (parcel.readInt() != 0)
            {
                obj = (QueryRequest)QueryRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((QueryRequest) (obj)), zzaU(parcel.readStrongBinder()), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 52: // '4'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zza(zzaU(parcel.readStrongBinder()), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 53: // '5'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj36;
            if (parcel.readInt() != 0)
            {
                obj = (ControlProgressRequest)ControlProgressRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((ControlProgressRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 54: // '6'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            zzg(zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 55: // '7'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj37;
            if (parcel.readInt() != 0)
            {
                obj = (ChangeResourceParentsRequest)ChangeResourceParentsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((ChangeResourceParentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 56: // '8'
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            obj = obj38;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (StreamContentsRequest)StreamContentsRequest.CREATOR.createFromParcel(parcel);
        }
        parcel = zza(((StreamContentsRequest) (obj)), zzaT(parcel.readStrongBinder()));
        parcel1.writeNoException();
        if (parcel != null)
        {
            parcel1.writeInt(1);
            parcel.writeToParcel(parcel1, 1);
        } else
        {
            parcel1.writeInt(0);
        }
        return true;
    }
}
