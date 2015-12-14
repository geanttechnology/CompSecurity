// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.apiv3.model.card.CardData;
import com.socialin.android.c;
import com.socialin.android.d;
import com.socialin.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.socialin.android.apiv3.model:
//            Response, Adress, ViewerUser

public class ImageItem extends Response
    implements Parcelable, CardData, Cloneable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ImageItem createFromParcel(Parcel parcel)
        {
            return new ImageItem(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ImageItem[] newArray(int i)
        {
            return new ImageItem[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static String prefixLarge = "?r1024x1024";
    public static String prefixMidle = "?r640x640";
    public static String prefixSmall = "?r240x240";
    public static String prefixThumb = "?c120x120";
    public String _id;
    public Adress address;
    public ArrayList comments;
    public int commentsCount;
    public Date createdAt;
    public String desc;
    public boolean detalisLoaded;
    public int height;
    public long id;
    private boolean isImage;
    public boolean isLiked;
    private boolean isLiking;
    public boolean isMature;
    public boolean isPublic;
    public boolean isReposted;
    private boolean isReposting;
    public ArrayList likes;
    public int likesCount;
    public boolean loaded;
    private boolean loadingFailed;
    public ImageItem origin;
    public String packUrl;
    public Date publishedAt;
    public ArrayList reposts;
    public int repostsCount;
    public ArrayList streams;
    public int streamsCount;
    public String tags[];
    public String title;
    public String type;
    public String url;
    public ViewerUser user;
    public int viewsCount;
    public int width;

    public ImageItem()
    {
        loaded = false;
        detalisLoaded = false;
        isImage = true;
    }

    public ImageItem(Parcel parcel)
    {
        loaded = false;
        detalisLoaded = false;
        readFromParcel(parcel);
    }

    public static ImageItem createNonImageItem()
    {
        ImageItem imageitem = new ImageItem();
        imageitem.isImage = false;
        return imageitem;
    }

    private void readFromParcel(Parcel parcel)
    {
        id = parcel.readLong();
        title = parcel.readString();
        viewsCount = parcel.readInt();
        commentsCount = parcel.readInt();
        likesCount = parcel.readInt();
        repostsCount = parcel.readInt();
        streamsCount = parcel.readInt();
        width = parcel.readInt();
        height = parcel.readInt();
        url = parcel.readString();
        type = parcel.readString();
        packUrl = parcel.readString();
        isLiked = Boolean.parseBoolean(parcel.readString());
        isPublic = Boolean.parseBoolean(parcel.readString());
        isMature = Boolean.parseBoolean(parcel.readString());
        isReposted = Boolean.parseBoolean(parcel.readString());
        loaded = Boolean.parseBoolean(parcel.readString());
        tags = parcel.createStringArray();
        try
        {
            String s = parcel.readString();
            if (!s.equals(""))
            {
                address = (Adress)c.a().fromJson(s, com/socialin/android/apiv3/model/Adress);
            }
            s = parcel.readString();
            if (!s.equals(""))
            {
                createdAt = (Date)c.a().fromJson(s, java/util/Date);
            }
            s = parcel.readString();
            if (!s.equals(""))
            {
                origin = (ImageItem)c.a().fromJson(s, com/socialin/android/apiv3/model/ImageItem);
            }
            if (Boolean.parseBoolean(parcel.readString()))
            {
                user = new ViewerUser();
                user.id = parcel.readLong();
                user.name = parcel.readString();
                user.setPhoto(parcel.readString());
                user.username = parcel.readString();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
    }

    public ImageItem clone()
    {
        ImageItem imageitem;
        try
        {
            imageitem = (ImageItem)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            if (d.b)
            {
                clonenotsupportedexception.getMessage();
            }
            return null;
        }
        return imageitem;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ImageItem)
        {
            obj = (ImageItem)obj;
            return isImage && ((ImageItem) (obj)).id == id;
        } else
        {
            return super.equals(obj);
        }
    }

    public boolean freeToEdit()
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (tags == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        int j;
        as = tags;
        j = as.length;
        i = 0;
_L7:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L3
_L3:
        if (!"freetoedit".equals(as[i])) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public int getImageHeight()
    {
        return height;
    }

    public String getImageUrl()
    {
        if (getThumbUrl() != null && !getThumbUrl().equals(""))
        {
            return getThumbUrl();
        }
        if (getSmallUrl() != null && !getSmallUrl().equals(""))
        {
            return getSmallUrl();
        }
        if (getMidleUrl() != null && !getMidleUrl().equals(""))
        {
            return getMidleUrl();
        }
        if (getLargeUrl() != null && !getLargeUrl().equals(""))
        {
            return getLargeUrl();
        } else
        {
            return url;
        }
    }

    public int getImageWidth()
    {
        return width;
    }

    public String getLargeUrl()
    {
        if (url != null)
        {
            return (new StringBuilder()).append(url).append(prefixLarge).toString();
        } else
        {
            return null;
        }
    }

    public String getMidleUrl()
    {
        if (url != null)
        {
            return (new StringBuilder()).append(url).append(prefixMidle).toString();
        } else
        {
            return null;
        }
    }

    public String getSecondUrl()
    {
        return (new StringBuilder("http://picsart.com/i/")).append(id).toString();
    }

    public String getSmallUrl()
    {
        if (url != null)
        {
            return (new StringBuilder()).append(url).append(prefixSmall).toString();
        } else
        {
            return null;
        }
    }

    public List getTagsList()
    {
        if (tags == null)
        {
            return new ArrayList();
        } else
        {
            return Arrays.asList(tags);
        }
    }

    public String getTagsString()
    {
        String s1 = "";
        String s = s1;
        if (tags != null)
        {
            s = s1;
            if (tags.length > 0)
            {
                s1 = tags[0];
                int i = 1;
                do
                {
                    s = s1;
                    if (i >= tags.length)
                    {
                        break;
                    }
                    s1 = (new StringBuilder()).append(s1).append(",").append(tags[i]).toString();
                    i++;
                } while (true);
            }
        }
        s1 = s;
        if ("null".equals(s))
        {
            s1 = "";
        }
        return s1;
    }

    public String getThumbUrl()
    {
        if (url != null)
        {
            return (new StringBuilder()).append(url).append(prefixThumb).toString();
        } else
        {
            return null;
        }
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isLiking()
    {
        return isLiking;
    }

    public boolean isLoadingFailed()
    {
        return loadingFailed;
    }

    public boolean isPhoto()
    {
        return type.equals("photo");
    }

    public boolean isReposting()
    {
        return isReposting;
    }

    public void setLiking(boolean flag)
    {
        isLiking = flag;
    }

    public void setLoadingFailed(boolean flag)
    {
        loadingFailed = flag;
    }

    public void setReposting(boolean flag)
    {
        isReposting = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        Object obj;
        if (title == null)
        {
            obj = "";
        } else
        {
            obj = title;
        }
        parcel.writeString(((String) (obj)));
        parcel.writeInt(viewsCount);
        parcel.writeInt(commentsCount);
        parcel.writeInt(likesCount);
        parcel.writeInt(repostsCount);
        parcel.writeInt(streamsCount);
        parcel.writeInt(width);
        parcel.writeInt(height);
        if (url == null)
        {
            obj = "";
        } else
        {
            obj = url;
        }
        parcel.writeString(((String) (obj)));
        if (type == null)
        {
            obj = "";
        } else
        {
            obj = type;
        }
        parcel.writeString(((String) (obj)));
        if (packUrl == null)
        {
            obj = "";
        } else
        {
            obj = packUrl;
        }
        parcel.writeString(((String) (obj)));
        parcel.writeString(String.valueOf(isLiked));
        parcel.writeString(String.valueOf(isPublic));
        parcel.writeString(String.valueOf(isMature));
        parcel.writeString(String.valueOf(isReposted));
        parcel.writeString(String.valueOf(loaded));
        if (tags == null)
        {
            obj = new String[0];
        } else
        {
            obj = tags;
        }
        parcel.writeStringArray(((String []) (obj)));
        if (address == null)
        {
            obj = "";
        } else
        {
            obj = c.a().toJson(address);
        }
        parcel.writeString(((String) (obj)));
        if (createdAt == null)
        {
            obj = "";
        } else
        {
            obj = c.a().toJson(createdAt);
        }
        parcel.writeString(((String) (obj)));
        if (origin == null)
        {
            obj = "";
        } else
        {
            obj = c.a().toJson(origin);
        }
        parcel.writeString(((String) (obj)));
        if (user != null)
        {
            parcel.writeString("true");
            parcel.writeLong(user.id);
            parcel.writeString(user.name);
            parcel.writeString(user.getPhoto());
            parcel.writeString(user.username);
            return;
        } else
        {
            parcel.writeString("false");
            return;
        }
    }

}
