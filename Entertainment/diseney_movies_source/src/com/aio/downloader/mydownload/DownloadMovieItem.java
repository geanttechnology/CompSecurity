// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import android.graphics.Bitmap;
import java.io.Serializable;

// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadFile

public class DownloadMovieItem
    implements Serializable
{

    private static final long serialVersionUID = 12L;
    private String album_title;
    private String artist_title;
    private String author_title;
    private int banner_type;
    private String bannerauthor_title;
    private String bannerhas_apk;
    private String bannericon;
    private String bannerid;
    private String bannerisoffical;
    private String bannerlink_url;
    private String bannerprice;
    private String bannerrating;
    private String bannerserial;
    private String bannersize;
    private String bannerstatus;
    private String bannertitle;
    private String cat;
    private Long create_time;
    private Long currentProgress;
    private String detail;
    private DownloadFile downloadFile;
    private Integer downloadState;
    private String downloadUrl;
    private String downloads;
    private boolean editState;
    private String filePath;
    private String fileSize;
    private String file_id;
    private String has_apk;
    private int has_next_page;
    private String icon;
    private String id;
    private String infotitle;
    private boolean isSelected;
    private String is_official;
    private String link;
    private String link_url;
    private String minigameicon;
    private String minigamestatus;
    private String minigametitle;
    private Bitmap movieHeadImage;
    private String movieHeadImagePath;
    private String movieId;
    private String movieName;
    private String percentage;
    private int position;
    private String ppshort_desc;
    private String price;
    private Long progressCount;
    private Float rating;
    private String release_date;
    private String screenshots;
    private String search_keyword;
    private int serial;
    private String setCount;
    private String size;
    private String title;
    private String type;
    private Long uuid;
    private String version;

    public DownloadMovieItem()
    {
        progressCount = Long.valueOf(0L);
        currentProgress = Long.valueOf(0L);
        downloadState = Integer.valueOf(0);
        percentage = "%0";
    }

    public static long getSerialversionuid()
    {
        return 12L;
    }

    public String getAlbum_title()
    {
        return album_title;
    }

    public String getArtist_title()
    {
        return artist_title;
    }

    public String getAuthor_title()
    {
        return author_title;
    }

    public int getBanner_type()
    {
        return banner_type;
    }

    public String getBannerauthor_title()
    {
        return bannerauthor_title;
    }

    public String getBannerhas_apk()
    {
        return bannerhas_apk;
    }

    public String getBannericon()
    {
        return bannericon;
    }

    public String getBannerid()
    {
        return bannerid;
    }

    public String getBannerisoffical()
    {
        return bannerisoffical;
    }

    public String getBannerlink_url()
    {
        return bannerlink_url;
    }

    public String getBannerprice()
    {
        return bannerprice;
    }

    public String getBannerrating()
    {
        return bannerrating;
    }

    public String getBannerserial()
    {
        return bannerserial;
    }

    public String getBannersize()
    {
        return bannersize;
    }

    public String getBannerstatus()
    {
        return bannerstatus;
    }

    public String getBannertitle()
    {
        return bannertitle;
    }

    public String getCat()
    {
        return cat;
    }

    public Long getCreate_time()
    {
        return create_time;
    }

    public Long getCurrentProgress()
    {
        return currentProgress;
    }

    public String getDetail()
    {
        return detail;
    }

    public DownloadFile getDownloadFile()
    {
        return downloadFile;
    }

    public Integer getDownloadState()
    {
        return downloadState;
    }

    public String getDownloadUrl()
    {
        return downloadUrl;
    }

    public String getDownloads()
    {
        return downloads;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public String getFile_id()
    {
        return file_id;
    }

    public String getHas_apk()
    {
        return has_apk;
    }

    public int getHas_next_page()
    {
        return has_next_page;
    }

    public String getIcon()
    {
        return icon;
    }

    public String getId()
    {
        return id;
    }

    public String getInfotitle()
    {
        return infotitle;
    }

    public String getIs_official()
    {
        return is_official;
    }

    public String getLink()
    {
        return link;
    }

    public String getLink_url()
    {
        return link_url;
    }

    public String getMinigameicon()
    {
        return minigameicon;
    }

    public String getMinigamestatus()
    {
        return minigamestatus;
    }

    public String getMinigametitle()
    {
        return minigametitle;
    }

    public Bitmap getMovieHeadImage()
    {
        return movieHeadImage;
    }

    public String getMovieHeadImagePath()
    {
        return movieHeadImagePath;
    }

    public String getMovieId()
    {
        return movieId;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public String getPercentage()
    {
        return percentage;
    }

    public int getPosition()
    {
        return position;
    }

    public String getPpshort_desc()
    {
        return ppshort_desc;
    }

    public String getPrice()
    {
        return price;
    }

    public Long getProgressCount()
    {
        return progressCount;
    }

    public Float getRating()
    {
        return rating;
    }

    public String getRelease_date()
    {
        return release_date;
    }

    public String getScreenshots()
    {
        return screenshots;
    }

    public String getSearch_keyword()
    {
        return search_keyword;
    }

    public int getSerial()
    {
        return serial;
    }

    public String getSetCount()
    {
        return setCount;
    }

    public String getShort_desc()
    {
        return ppshort_desc;
    }

    public String getSize()
    {
        return size;
    }

    public String getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }

    public Long getUuid()
    {
        return uuid;
    }

    public String getVersion()
    {
        return version;
    }

    public boolean isEditState()
    {
        return editState;
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public void setAlbum_title(String s)
    {
        album_title = s;
    }

    public void setArtist_title(String s)
    {
        artist_title = s;
    }

    public void setAuthor_title(String s)
    {
        author_title = s;
    }

    public void setBanner_type(int i)
    {
        banner_type = i;
    }

    public void setBannerauthor_title(String s)
    {
        bannerauthor_title = s;
    }

    public void setBannerhas_apk(String s)
    {
        bannerhas_apk = s;
    }

    public void setBannericon(String s)
    {
        bannericon = s;
    }

    public void setBannerid(String s)
    {
        bannerid = s;
    }

    public void setBannerisoffical(String s)
    {
        bannerisoffical = s;
    }

    public void setBannerlink_url(String s)
    {
        bannerlink_url = s;
    }

    public void setBannerprice(String s)
    {
        bannerprice = s;
    }

    public void setBannerrating(String s)
    {
        bannerrating = s;
    }

    public void setBannerserial(String s)
    {
        bannerserial = s;
    }

    public void setBannersize(String s)
    {
        bannersize = s;
    }

    public void setBannerstatus(String s)
    {
        bannerstatus = s;
    }

    public void setBannertitle(String s)
    {
        bannertitle = s;
    }

    public void setCat(String s)
    {
        cat = s;
    }

    public void setCreate_time(Long long1)
    {
        create_time = long1;
    }

    public void setCurrentProgress(Long long1)
    {
        currentProgress = long1;
    }

    public void setDetail(String s)
    {
        detail = s;
    }

    public void setDownloadFile(DownloadFile downloadfile)
    {
        downloadFile = downloadfile;
    }

    public void setDownloadState(Integer integer)
    {
        downloadState = integer;
    }

    public void setDownloadUrl(String s)
    {
        downloadUrl = s;
    }

    public void setDownloads(String s)
    {
        downloads = s;
    }

    public void setEditState(boolean flag)
    {
        editState = flag;
    }

    public void setFilePath(String s)
    {
        filePath = s;
    }

    public void setFileSize(String s)
    {
        fileSize = s;
    }

    public void setFile_id(String s)
    {
        file_id = s;
    }

    public void setHas_apk(String s)
    {
        has_apk = s;
    }

    public void setHas_next_page(int i)
    {
        has_next_page = i;
    }

    public void setIcon(String s)
    {
        icon = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setInfotitle(String s)
    {
        infotitle = s;
    }

    public void setIs_official(String s)
    {
        is_official = s;
    }

    public void setLink(String s)
    {
        link = s;
    }

    public void setLink_url(String s)
    {
        link_url = s;
    }

    public void setMinigameicon(String s)
    {
        minigameicon = s;
    }

    public void setMinigamestatus(String s)
    {
        minigamestatus = s;
    }

    public void setMinigametitle(String s)
    {
        minigametitle = s;
    }

    public void setMovieHeadImage(Bitmap bitmap)
    {
        movieHeadImage = bitmap;
    }

    public void setMovieHeadImagePath(String s)
    {
        movieHeadImagePath = s;
    }

    public void setMovieId(String s)
    {
        movieId = s;
    }

    public void setMovieName(String s)
    {
        movieName = s;
    }

    public void setPercentage(String s)
    {
        percentage = s;
    }

    public void setPosition(int i)
    {
        position = i;
    }

    public void setPpshort_desc(String s)
    {
        ppshort_desc = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setProgressCount(Long long1)
    {
        progressCount = long1;
    }

    public void setRating(Float float1)
    {
        rating = float1;
    }

    public void setRelease_date(String s)
    {
        release_date = s;
    }

    public void setScreenshots(String s)
    {
        screenshots = s;
    }

    public void setSearch_keyword(String s)
    {
        search_keyword = s;
    }

    public void setSelected(boolean flag)
    {
        isSelected = flag;
    }

    public void setSerial(int i)
    {
        serial = i;
    }

    public void setSetCount(String s)
    {
        setCount = s;
    }

    public void setShort_desc(String s)
    {
        ppshort_desc = s;
    }

    public void setSize(String s)
    {
        size = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUuid(Long long1)
    {
        uuid = long1;
    }

    public void setVersion(String s)
    {
        version = s;
    }

    public String toString()
    {
        return (new StringBuilder("DownloadMovieItem [progressCount=")).append(progressCount).append(", currentProgress=").append(currentProgress).append(", downloadState=").append(downloadState).append(", editState=").append(editState).append(", movieHeadImage=").append(movieHeadImage).append(", fileSize=").append(fileSize).append(", movieName=").append(movieName).append("]").toString();
    }
}
