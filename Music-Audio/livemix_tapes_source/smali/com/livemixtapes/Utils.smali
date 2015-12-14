.class public Lcom/livemixtapes/Utils;
.super Ljava/lang/Object;
.source "Utils.java"


# static fields
.field public static final API_KEY:Ljava/lang/String; = "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh"

.field public static final API_URL:Ljava/lang/String; = "https://api.livemixtapes.com/api/"

.field public static final BETA_VERSION:Ljava/lang/String; = "LiveMixtapes 1.0.84 BETA"

.field public static final USER_AGENT:Ljava/lang/String; = "LiveMixtapes Android/1.0.84 BETA"

.field private static decimalFormatter:Ljava/text/DecimalFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 272
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "#,###,###"

    invoke-direct {v0, v1}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/livemixtapes/Utils;->decimalFormatter:Ljava/text/DecimalFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static CopyStream(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .locals 5
    .param p0, "is"    # Ljava/io/InputStream;
    .param p1, "os"    # Ljava/io/OutputStream;

    .prologue
    .line 35
    const/16 v0, 0x400

    .line 37
    .local v0, "buffer_size":I
    const/16 v3, 0x400

    :try_start_0
    new-array v1, v3, [B

    .line 39
    .local v1, "bytes":[B
    :goto_0
    const/4 v3, 0x0

    const/16 v4, 0x400

    invoke-virtual {p0, v1, v3, v4}, Ljava/io/InputStream;->read([BII)I

    move-result v2

    .line 40
    .local v2, "count":I
    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 46
    .end local v1    # "bytes":[B
    .end local v2    # "count":I
    :goto_1
    return-void

    .line 42
    .restart local v1    # "bytes":[B
    .restart local v2    # "count":I
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {p1, v1, v3, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 44
    .end local v1    # "bytes":[B
    .end local v2    # "count":I
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public static createShareIntent(Landroid/content/pm/PackageManager;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Landroid/content/Intent;
    .locals 12
    .param p0, "pm"    # Landroid/content/pm/PackageManager;
    .param p1, "subject"    # Ljava/lang/String;
    .param p2, "text"    # Ljava/lang/String;
    .param p3, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v11, 0x0

    .line 52
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 53
    .local v7, "whiteList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v8, "com.instagram.android"

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 54
    const-string v8, "com.facebook.katana"

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 55
    const-string v8, "com.twitter.android"

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 56
    const-string v8, "com.tumblr"

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 57
    const-string v8, "com.android.mms"

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 59
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 61
    .local v4, "targetedIntents":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    new-instance v1, Landroid/content/Intent;

    const-string v8, "android.intent.action.SEND"

    invoke-direct {v1, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 64
    .local v1, "dummy":Landroid/content/Intent;
    const-string v8, "text/plain"

    invoke-virtual {v1, v8}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 65
    invoke-virtual {p0, v1, v11}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v2

    .line 67
    .local v2, "resInfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_2

    .line 82
    const-string v8, "image/*"

    invoke-virtual {v1, v8}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 83
    invoke-virtual {p0, v1, v11}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v2

    .line 84
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_3

    .line 98
    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/content/Intent;

    const-string v9, "Share via"

    invoke-static {v8, v9}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    .line 99
    .local v0, "chooserIntent":Landroid/content/Intent;
    invoke-interface {v4, v11}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 101
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v8

    new-array v8, v8, [Landroid/os/Parcelable;

    invoke-interface {v4, v8}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Landroid/os/Parcelable;

    .line 102
    .local v5, "targetedIntentsParcelable":[Landroid/os/Parcelable;
    const-string v8, "android.intent.extra.INITIAL_INTENTS"

    invoke-virtual {v0, v8, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 103
    return-object v0

    .line 67
    .end local v0    # "chooserIntent":Landroid/content/Intent;
    .end local v5    # "targetedIntentsParcelable":[Landroid/os/Parcelable;
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .line 69
    .local v3, "ri":Landroid/content/pm/ResolveInfo;
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v9, :cond_0

    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-interface {v7, v9}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 72
    new-instance v6, Landroid/content/Intent;

    const-string v9, "android.intent.action.SEND"

    invoke-direct {v6, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 73
    .local v6, "targetedShareIntent":Landroid/content/Intent;
    const-string v9, "text/plain"

    invoke-virtual {v6, v9}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 74
    const-string v9, "android.intent.extra.SUBJECT"

    invoke-virtual {v6, v9, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 75
    const-string v9, "android.intent.extra.TEXT"

    invoke-virtual {v6, v9, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 76
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v9}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 77
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    iget-object v10, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v10, v10, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v6, v9, v10}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 78
    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 84
    .end local v3    # "ri":Landroid/content/pm/ResolveInfo;
    .end local v6    # "targetedShareIntent":Landroid/content/Intent;
    :cond_3
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .line 85
    .restart local v3    # "ri":Landroid/content/pm/ResolveInfo;
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v9, :cond_1

    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    const-string v10, "com.instagram.android"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 88
    new-instance v6, Landroid/content/Intent;

    const-string v9, "android.intent.action.SEND"

    invoke-direct {v6, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 89
    .restart local v6    # "targetedShareIntent":Landroid/content/Intent;
    const-string v9, "image/*"

    invoke-virtual {v6, v9}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 90
    const-string v9, "android.intent.extra.SUBJECT"

    invoke-virtual {v6, v9, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 91
    const-string v9, "android.intent.extra.TEXT"

    invoke-virtual {v6, v9, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 92
    const-string v9, "android.intent.extra.STREAM"

    invoke-virtual {v6, v9, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 93
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v9}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 94
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    iget-object v10, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v10, v10, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v6, v9, v10}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 95
    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1
.end method

.method public static formatDuration(D)Ljava/lang/String;
    .locals 13
    .param p0, "seconds"    # D

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    const-wide v9, 0x40ac200000000000L    # 3600.0

    const-wide/high16 v7, 0x404e000000000000L    # 60.0

    .line 163
    const-string v0, ""

    .line 166
    .local v0, "format":Ljava/lang/String;
    div-double v5, p0, v9

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v1

    .line 167
    .local v1, "hours":D
    rem-double/2addr p0, v9

    .line 169
    div-double v5, p0, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    .line 170
    .local v3, "minutes":D
    rem-double/2addr p0, v7

    .line 172
    const-wide/16 v5, 0x0

    cmpl-double v5, v1, v5

    if-lez v5, :cond_0

    .line 173
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    double-to-int v6, v1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 174
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "%02d"

    new-array v7, v12, [Ljava/lang/Object;

    double-to-int v8, v3

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 179
    :goto_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "%02d"

    new-array v7, v12, [Ljava/lang/Object;

    double-to-int v8, p0

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 181
    return-object v0

    .line 176
    :cond_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    double-to-int v6, v3

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static formatWithCommas(I)Ljava/lang/String;
    .locals 3
    .param p0, "value"    # I

    .prologue
    .line 274
    sget-object v0, Lcom/livemixtapes/Utils;->decimalFormatter:Ljava/text/DecimalFormat;

    int-to-long v1, p0

    invoke-virtual {v0, v1, v2}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatWithCommas(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 265
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-static {v1}, Lcom/livemixtapes/Utils;->formatWithCommas(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    .line 268
    .local v0, "ex":Ljava/lang/NumberFormatException;
    :goto_0
    return-object p0

    .line 266
    .end local v0    # "ex":Ljava/lang/NumberFormatException;
    :catch_0
    move-exception v0

    .line 267
    .restart local v0    # "ex":Ljava/lang/NumberFormatException;
    invoke-virtual {v0}, Ljava/lang/NumberFormatException;->printStackTrace()V

    goto :goto_0
.end method

.method public static getArtistAndTitle(Ljava/util/Map;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 253
    .local p0, "mixtape":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v2, "title"

    invoke-interface {p0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 254
    .local v1, "title":Ljava/lang/String;
    const-string v2, "artist"

    invoke-interface {p0, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v2, "artist"

    invoke-interface {p0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    move-object v0, v2

    .line 256
    .local v0, "artist":Ljava/lang/String;
    :goto_0
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 257
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " - "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 260
    .end local v1    # "title":Ljava/lang/String;
    :cond_0
    return-object v1

    .line 254
    .end local v0    # "artist":Ljava/lang/String;
    .restart local v1    # "title":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getLivemixtapesFolder(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 153
    new-instance v0, Ljava/io/File;

    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 154
    .local v0, "mixtapesFolder":Ljava/io/File;
    return-object v0
.end method

.method public static isDownloaded(Landroid/content/Context;J)Z
    .locals 12
    .param p0, "mContext"    # Landroid/content/Context;
    .param p1, "downloadId"    # J

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 226
    new-instance v5, Landroid/app/DownloadManager$Query;

    invoke-direct {v5}, Landroid/app/DownloadManager$Query;-><init>()V

    .line 227
    .local v5, "q":Landroid/app/DownloadManager$Query;
    new-array v8, v6, [J

    aput-wide p1, v8, v7

    invoke-virtual {v5, v8}, Landroid/app/DownloadManager$Query;->setFilterById([J)Landroid/app/DownloadManager$Query;

    .line 228
    const-string v8, "download"

    invoke-virtual {p0, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/app/DownloadManager;

    .line 230
    .local v4, "downloadManager":Landroid/app/DownloadManager;
    invoke-virtual {v4, v5}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;

    move-result-object v2

    .line 231
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v8

    if-nez v8, :cond_2

    :cond_0
    move v6, v7

    .line 249
    :cond_1
    :goto_0
    return v6

    .line 236
    :cond_2
    const-string v8, "bytes_so_far"

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 235
    invoke-interface {v2, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 238
    .local v0, "bytes_downloaded":I
    const-string v8, "total_size"

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    .line 237
    invoke-interface {v2, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 240
    .local v1, "bytes_total":I
    const-string v8, "status"

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v8

    invoke-interface {v2, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    const/16 v9, 0x8

    if-ne v8, v9, :cond_3

    .line 241
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 245
    :cond_3
    int-to-long v8, v0

    const-wide/16 v10, 0x64

    mul-long/2addr v8, v10

    int-to-long v10, v1

    div-long/2addr v8, v10

    long-to-int v3, v8

    .line 246
    .local v3, "dl_progress":I
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 247
    const/16 v8, 0x64

    if-eq v3, v8, :cond_1

    move v6, v7

    .line 249
    goto :goto_0
.end method

.method public static isFileExists(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 129
    new-instance v0, Ljava/io/File;

    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 136
    .local v0, "mixtapesFolder":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 137
    const/4 v1, 0x1

    .line 138
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static loadPreferences(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "mContext"    # Landroid/content/Context;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 116
    check-cast p0, Landroid/app/Activity;

    .line 117
    .end local p0    # "mContext":Landroid/content/Context;
    const-string v3, "LiveMixTapes"

    const/4 v4, 0x0

    invoke-virtual {p0, v3, v4}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 118
    .local v1, "sharedPreferences":Landroid/content/SharedPreferences;
    const-string v2, ""

    .line 120
    .local v2, "val":Ljava/lang/String;
    :try_start_0
    const-string v3, ""

    invoke-interface {v1, p1, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 124
    :goto_0
    return-object v2

    .line 121
    :catch_0
    move-exception v0

    .line 122
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, ""

    goto :goto_0
.end method

.method public static savePreferences(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "mContext"    # Landroid/content/Context;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 108
    .line 109
    const-string v2, "LiveMixTapes"

    const/4 v3, 0x0

    .line 108
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 110
    .local v1, "sharedPreferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 111
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 112
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 113
    return-void
.end method

.method public static shouldAllowDownload(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 13
    .param p0, "mContext"    # Landroid/content/Context;
    .param p1, "mixtapeId"    # Ljava/lang/String;
    .param p2, "trackId"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    .line 186
    invoke-static {p0}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v0

    .line 187
    .local v0, "dbHelper":Lcom/livemixtapes/database/DBHelper;
    invoke-virtual {v0}, Lcom/livemixtapes/database/DBHelper;->getIncompleteDownloads()Ljava/util/ArrayList;

    move-result-object v2

    .line 190
    .local v2, "incompleteDownloads":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v8

    const/4 v11, 0x4

    if-ge v8, v11, :cond_0

    move v8, v9

    .line 222
    :goto_0
    return v8

    .line 194
    :cond_0
    const/4 v3, 0x1

    .line 195
    .local v3, "isOfSameMixtape":Z
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_2

    .line 203
    :goto_1
    if-eqz v3, :cond_3

    move v8, v9

    .line 204
    goto :goto_0

    .line 195
    :cond_2
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    .line 197
    .local v1, "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v8, "mixtape_id"

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v8, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 199
    const/4 v3, 0x0

    .line 200
    goto :goto_1

    .line 207
    .end local v1    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v8

    const/16 v11, 0x14

    if-lt v8, v11, :cond_4

    move v8, v10

    .line 208
    goto :goto_0

    .line 210
    :cond_4
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 211
    .local v7, "trackIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_2
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_6

    .line 214
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v8

    iget-object v8, v8, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_5
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_7

    move v8, v10

    .line 222
    goto :goto_0

    .line 211
    :cond_6
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    .line 212
    .restart local v1    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v8, "track_id"

    invoke-virtual {v1, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 214
    .end local v1    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_7
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    .line 215
    .local v4, "playlistMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 216
    .local v5, "playlistTrackIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v8, "tracks"

    invoke-interface {v4, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v12

    if-nez v12, :cond_8

    .line 218
    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->containsAll(Ljava/util/Collection;)Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-virtual {p2}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    move v8, v9

    .line 219
    goto/16 :goto_0

    .line 216
    :cond_8
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map;

    .line 217
    .local v6, "subMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v12, "track_id"

    invoke-interface {v6, v12}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v5, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3
.end method
