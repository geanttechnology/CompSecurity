// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.Date;

public final class aei
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new aej();
    private static final String THUMBNAIL_EXTENSION = ".png";
    public static final android.graphics.Bitmap.CompressFormat THUMBNAIL_FORMAT;
    private static final String THUMBNAIL_SUBDIRECTORY = "thumbnails";
    private static final String VIDEO_EXTENSION = ".mp4";
    private static final String VIDEO_SUBDIRECTORY = "videos";
    private File applicationDataDirectory;
    private Date datetime;
    private String recordingPath;
    private String thumbnailPath;
    private String videoId;

    public aei(Parcel parcel)
    {
        videoId = parcel.readString();
        datetime = (Date)parcel.readSerializable();
        recordingPath = parcel.readString();
        thumbnailPath = parcel.readString();
    }

    public aei(String s, Date date)
    {
        videoId = s;
        datetime = date;
    }

    public aei(String s, Date date, File file)
    {
        videoId = s;
        datetime = date;
        applicationDataDirectory = file;
        recordingPath = getRecordingFilePath();
        thumbnailPath = getThumbnailFilePath();
    }

    private String getRecordingFilePath()
    {
        File file = new File(applicationDataDirectory, "videos");
        file.mkdir();
        String s = videoId;
        long l = datetime.getTime();
        String s1 = String.valueOf(".mp4");
        return (new File(file, (new StringBuilder(String.valueOf(s).length() + 21 + String.valueOf(s1).length())).append(s).append("-").append(l).append(s1).toString())).getAbsolutePath();
    }

    public static aei getRecordingFromExtras(Bundle bundle, String s)
    {
        if (bundle == null || bundle.getParcelable(s) == null)
        {
            return null;
        } else
        {
            return (aei)bundle.getParcelable(s);
        }
    }

    private String getThumbnailFilePath()
    {
        File file = new File(applicationDataDirectory, "thumbnails");
        file.mkdir();
        String s = videoId;
        long l = datetime.getTime();
        String s1 = String.valueOf(".png");
        return (new File(file, (new StringBuilder(String.valueOf(s).length() + 21 + String.valueOf(s1).length())).append(s).append("-").append(l).append(s1).toString())).getAbsolutePath();
    }

    public final void deleteOutputFiles()
    {
        if (recordingPath != null)
        {
            (new File(recordingPath)).delete();
            recordingPath = null;
        }
        if (thumbnailPath != null)
        {
            (new File(thumbnailPath)).delete();
            thumbnailPath = null;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Date getDatetime()
    {
        return datetime;
    }

    public final String getRecordingPath()
    {
        return recordingPath;
    }

    public final String getThumbnailPath()
    {
        return thumbnailPath;
    }

    public final String getVideoId()
    {
        return videoId;
    }

    public final boolean isValidRecording()
    {
        return recordingPath != null && (new File(recordingPath)).exists();
    }

    public final void setRecordingPath(String s)
    {
        recordingPath = s;
    }

    public final void setThumbnailPath(String s)
    {
        thumbnailPath = s;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(videoId);
        parcel.writeSerializable(datetime);
        parcel.writeString(recordingPath);
        parcel.writeString(thumbnailPath);
    }

    static 
    {
        THUMBNAIL_FORMAT = android.graphics.Bitmap.CompressFormat.PNG;
    }
}
