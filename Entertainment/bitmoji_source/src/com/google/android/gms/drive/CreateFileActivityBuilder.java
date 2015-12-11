// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.n;
import com.google.android.gms.drive.internal.u;
import com.google.android.gms.internal.er;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.drive:
//            Contents, Drive, MetadataChangeSet, DriveId

public class CreateFileActivityBuilder
{

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private MetadataChangeSet CV;
    private Contents CW;
    private String CX;
    private DriveId CY;

    public CreateFileActivityBuilder()
    {
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        er.b(CW, "Must provide initial contents to CreateFileActivityBuilder.");
        try
        {
            CW.getParcelFileDescriptor().close();
        }
        catch (IOException ioexception) { }
        CW.close();
        er.a(googleapiclient.isConnected(), "Client must be connected");
        googleapiclient = ((n)googleapiclient.a(Drive.va)).eT();
        try
        {
            googleapiclient = googleapiclient.a(new CreateFileIntentSenderRequest(CV.eS(), CW.eP(), CX, CY));
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
        CY = (DriveId)er.f(driveid);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String s)
    {
        CX = (String)er.f(s);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents)
    {
        CW = (Contents)er.f(contents);
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadatachangeset)
    {
        CV = (MetadataChangeSet)er.f(metadatachangeset);
        return this;
    }
}
