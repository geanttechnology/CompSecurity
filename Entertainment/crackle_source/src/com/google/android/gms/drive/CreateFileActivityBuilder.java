// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.j;
import com.google.android.gms.drive.internal.o;
import com.google.android.gms.internal.eg;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.drive:
//            Contents, Drive, MetadataChangeSet, DriveId

public class CreateFileActivityBuilder
{

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private MetadataChangeSet qJ;
    private Contents qK;
    private String qL;
    private DriveId qM;

    public CreateFileActivityBuilder()
    {
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        eg.b(qK, "Must provide initial contents to CreateFileActivityBuilder.");
        try
        {
            qK.getParcelFileDescriptor().close();
        }
        catch (IOException ioexception) { }
        qK.close();
        eg.a(googleapiclient.isConnected(), "Client must be connected");
        googleapiclient = ((j)googleapiclient.a(Drive.jO)).cN();
        try
        {
            googleapiclient = googleapiclient.a(new CreateFileIntentSenderRequest(qJ.cM(), qK.cJ(), qL, qM));
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new RuntimeException("Unable to connect Drive Play Service", googleapiclient);
        }
        return googleapiclient;
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId driveid)
    {
        qM = (DriveId)eg.f(driveid);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String s)
    {
        qL = (String)eg.f(s);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents)
    {
        qK = (Contents)eg.f(contents);
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadatachangeset)
    {
        qJ = (MetadataChangeSet)eg.f(metadatachangeset);
        return this;
    }
}
