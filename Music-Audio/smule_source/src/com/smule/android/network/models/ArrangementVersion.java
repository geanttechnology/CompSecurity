// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            Arrangement

public class ArrangementVersion
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ArrangementVersion a(Parcel parcel)
        {
            return new ArrangementVersion(parcel);
        }

        public ArrangementVersion[] a(int i)
        {
            return new ArrangementVersion[i];
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
    public Arrangement arrangement;
    public boolean lyrics;
    public boolean multipart;
    public boolean published;
    public HashMap resourceFilePaths;
    public List resources;
    public int version;

    public ArrangementVersion()
    {
        resources = new ArrayList();
        resourceFilePaths = new HashMap();
    }

    public ArrangementVersion(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        resources = new ArrayList();
        resourceFilePaths = new HashMap();
        arrangement = (Arrangement)parcel.readParcelable(com/smule/android/network/models/Arrangement.getClassLoader());
        version = parcel.readInt();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        published = flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lyrics = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        multipart = flag;
        parcel.readTypedList(resources, Resource.CREATOR);
        resourceFilePaths = (HashMap)parcel.readSerializable();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ArrangementVersion))
            {
                return false;
            }
            obj = (ArrangementVersion)obj;
            if (lyrics != ((ArrangementVersion) (obj)).lyrics)
            {
                return false;
            }
            if (multipart != ((ArrangementVersion) (obj)).multipart)
            {
                return false;
            }
            if (published != ((ArrangementVersion) (obj)).published)
            {
                return false;
            }
            if (version != ((ArrangementVersion) (obj)).version)
            {
                return false;
            }
            if (arrangement == null ? ((ArrangementVersion) (obj)).arrangement != null : !arrangement.equals(((ArrangementVersion) (obj)).arrangement))
            {
                return false;
            }
            if (resources == null ? ((ArrangementVersion) (obj)).resources != null : !resources.equals(((ArrangementVersion) (obj)).resources))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l = 1;
        int i1 = 0;
        int i;
        int j;
        int k;
        int j1;
        if (arrangement != null)
        {
            i = arrangement.hashCode();
        } else
        {
            i = 0;
        }
        j1 = version;
        if (published)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (lyrics)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (!multipart)
        {
            l = 0;
        }
        if (resources != null)
        {
            i1 = resources.hashCode();
        }
        return ((k + (j + (i * 31 + j1) * 31) * 31) * 31 + l) * 31 + i1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ArrangementVersion{arrangement=").append(arrangement).append(", version=").append(version).append(", published=").append(published).append(", lyrics=").append(lyrics).append(", multipart=").append(multipart).append(", resources=").append(resources).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeParcelable(arrangement, 0);
        parcel.writeInt(version);
        if (published)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (lyrics)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (multipart)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeTypedList(resources);
        parcel.writeSerializable(resourceFilePaths);
    }


    private class Resource
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Resource a(Parcel parcel)
            {
                return new Resource(parcel);
            }

            public Resource[] a(int i)
            {
                return new Resource[i];
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
        public String contentType;
        public String role;
        public long size;
        public String uid;
        public String url;

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof Resource))
                {
                    return false;
                }
                obj = (Resource)obj;
                if (size != ((Resource) (obj)).size)
                {
                    return false;
                }
                if (contentType == null ? ((Resource) (obj)).contentType != null : !contentType.equals(((Resource) (obj)).contentType))
                {
                    return false;
                }
                if (role == null ? ((Resource) (obj)).role != null : !role.equals(((Resource) (obj)).role))
                {
                    return false;
                }
                if (uid == null ? ((Resource) (obj)).uid != null : !uid.equals(((Resource) (obj)).uid))
                {
                    return false;
                }
                if (url == null ? ((Resource) (obj)).url != null : !url.equals(((Resource) (obj)).url))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int l = 0;
            int i;
            int j;
            int k;
            if (role != null)
            {
                i = role.hashCode();
            } else
            {
                i = 0;
            }
            if (url != null)
            {
                j = url.hashCode();
            } else
            {
                j = 0;
            }
            if (uid != null)
            {
                k = uid.hashCode();
            } else
            {
                k = 0;
            }
            if (contentType != null)
            {
                l = contentType.hashCode();
            }
            return ((k + (j + i * 31) * 31) * 31 + l) * 31 + (int)(size ^ size >>> 32);
        }

        public String toString()
        {
            return (new StringBuilder()).append("Resource{role='").append(role).append('\'').append(", url='").append(url).append('\'').append(", uid='").append(uid).append('\'').append(", contentType='").append(contentType).append('\'').append(", size=").append(size).append('}').toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(role);
            parcel.writeString(url);
            parcel.writeString(uid);
            parcel.writeString(contentType);
            parcel.writeLong(size);
        }


        public Resource()
        {
        }

        public Resource(Parcel parcel)
        {
            role = parcel.readString();
            url = parcel.readString();
            uid = parcel.readString();
            contentType = parcel.readString();
            size = parcel.readLong();
        }
    }

}
