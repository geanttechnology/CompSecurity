.class public final enum Lco/vine/android/recorder/RecordSessionVersion;
.super Ljava/lang/Enum;
.source "RecordSessionVersion.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lco/vine/android/recorder/RecordSessionVersion;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lco/vine/android/recorder/RecordSessionVersion;

.field public static final enum HW:Lco/vine/android/recorder/RecordSessionVersion;

.field public static final enum SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

.field public static final enum SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;


# instance fields
.field public final folder:Ljava/lang/String;

.field private manager:Lco/vine/android/recorder/RecordSessionManager;

.field public final mimeType:Ljava/lang/String;

.field public final videoOutputExtension:Ljava/lang/String;

.field public final willEventuallyTranscoded:Z


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v11, 0x2

    const/4 v2, 0x0

    const/4 v10, 0x1

    .line 12
    new-instance v0, Lco/vine/android/recorder/RecordSessionVersion;

    const-string v1, "HW"

    const-string v3, "drafts_hw"

    const-string v4, ".mp4"

    const-string v5, "video/mp4"

    move v6, v2

    invoke-direct/range {v0 .. v6}, Lco/vine/android/recorder/RecordSessionVersion;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    sput-object v0, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    .line 13
    new-instance v3, Lco/vine/android/recorder/RecordSessionVersion;

    const-string v4, "SW_MP4"

    const-string v6, "drafts"

    const-string v7, ".mp4"

    const-string v8, "video/mp4"

    move v5, v10

    move v9, v10

    invoke-direct/range {v3 .. v9}, Lco/vine/android/recorder/RecordSessionVersion;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    sput-object v3, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    .line 14
    new-instance v3, Lco/vine/android/recorder/RecordSessionVersion;

    const-string v4, "SW_WEBM"

    const-string v6, "drafts_webm"

    const-string v7, ".webm"

    const-string v8, "video/webm"

    move v5, v11

    move v9, v10

    invoke-direct/range {v3 .. v9}, Lco/vine/android/recorder/RecordSessionVersion;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    sput-object v3, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    .line 11
    const/4 v0, 0x3

    new-array v0, v0, [Lco/vine/android/recorder/RecordSessionVersion;

    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    aput-object v1, v0, v2

    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->SW_MP4:Lco/vine/android/recorder/RecordSessionVersion;

    aput-object v1, v0, v10

    sget-object v1, Lco/vine/android/recorder/RecordSessionVersion;->SW_WEBM:Lco/vine/android/recorder/RecordSessionVersion;

    aput-object v1, v0, v11

    sput-object v0, Lco/vine/android/recorder/RecordSessionVersion;->$VALUES:[Lco/vine/android/recorder/RecordSessionVersion;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p3, "folder"    # Ljava/lang/String;
    .param p4, "videoOutputExtension"    # Ljava/lang/String;
    .param p5, "mimeType"    # Ljava/lang/String;
    .param p6, "willEventuallyTranscoded"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 23
    iput-object p3, p0, Lco/vine/android/recorder/RecordSessionVersion;->folder:Ljava/lang/String;

    .line 24
    iput-object p4, p0, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    .line 25
    iput-object p5, p0, Lco/vine/android/recorder/RecordSessionVersion;->mimeType:Ljava/lang/String;

    .line 26
    iput-boolean p6, p0, Lco/vine/android/recorder/RecordSessionVersion;->willEventuallyTranscoded:Z

    .line 27
    return-void
.end method

.method public static deleteSessionWithName(Landroid/content/Context;Ljava/lang/String;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "parentName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 37
    invoke-static {}, Lco/vine/android/recorder/RecordSessionVersion;->values()[Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v0

    .local v0, "arr$":[Lco/vine/android/recorder/RecordSessionVersion;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v4, v0, v1

    .line 38
    .local v4, "version":Lco/vine/android/recorder/RecordSessionVersion;
    invoke-virtual {v4, p0}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    move-result-object v5

    invoke-virtual {v5, p1}, Lco/vine/android/recorder/RecordSessionManager;->getFolderFromName(Ljava/lang/String;)Ljava/io/File;

    move-result-object v3

    .line 39
    .local v3, "parentFolder":Ljava/io/File;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 40
    const-string v5, "Done with session."

    invoke-static {v3, v5}, Lco/vine/android/recorder/RecordSessionManager;->deleteSession(Ljava/io/File;Ljava/lang/String;)V

    .line 37
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 43
    .end local v3    # "parentFolder":Ljava/io/File;
    .end local v4    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_1
    return-void
.end method

.method public static getValuesWithManagers(Landroid/content/Context;)[Lco/vine/android/recorder/RecordSessionVersion;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-static {}, Lco/vine/android/recorder/RecordSessionVersion;->values()[Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v0

    .local v0, "arr$":[Lco/vine/android/recorder/RecordSessionVersion;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 47
    .local v3, "version":Lco/vine/android/recorder/RecordSessionVersion;
    invoke-virtual {v3, p0}, Lco/vine/android/recorder/RecordSessionVersion;->getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;

    .line 46
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 49
    .end local v3    # "version":Lco/vine/android/recorder/RecordSessionVersion;
    :cond_0
    invoke-static {}, Lco/vine/android/recorder/RecordSessionVersion;->values()[Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v4

    return-object v4
.end method

.method public static valueOf(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lco/vine/android/recorder/RecordSessionVersion;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lco/vine/android/recorder/RecordSessionVersion;

    return-object v0
.end method

.method public static values()[Lco/vine/android/recorder/RecordSessionVersion;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lco/vine/android/recorder/RecordSessionVersion;->$VALUES:[Lco/vine/android/recorder/RecordSessionVersion;

    invoke-virtual {v0}, [Lco/vine/android/recorder/RecordSessionVersion;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lco/vine/android/recorder/RecordSessionVersion;

    return-object v0
.end method


# virtual methods
.method public getAudioArrayType()Lco/vine/android/recorder/AudioArray$AudioArrayType;
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lco/vine/android/recorder/RecordSessionVersion;->HW:Lco/vine/android/recorder/RecordSessionVersion;

    if-ne p0, v0, :cond_0

    sget-object v0, Lco/vine/android/recorder/AudioArray$AudioArrayType;->BYTE:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lco/vine/android/recorder/AudioArray$AudioArrayType;->SHORT:Lco/vine/android/recorder/AudioArray$AudioArrayType;

    goto :goto_0
.end method

.method public declared-synchronized getManager(Landroid/content/Context;)Lco/vine/android/recorder/RecordSessionManager;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordSessionVersion;->manager:Lco/vine/android/recorder/RecordSessionManager;

    if-nez v0, :cond_0

    .line 31
    new-instance v0, Lco/vine/android/recorder/RecordSessionManager;

    invoke-direct {v0, p1, p0}, Lco/vine/android/recorder/RecordSessionManager;-><init>(Landroid/content/Context;Lco/vine/android/recorder/RecordSessionVersion;)V

    iput-object v0, p0, Lco/vine/android/recorder/RecordSessionVersion;->manager:Lco/vine/android/recorder/RecordSessionManager;

    .line 33
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/RecordSessionVersion;->manager:Lco/vine/android/recorder/RecordSessionManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 30
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
