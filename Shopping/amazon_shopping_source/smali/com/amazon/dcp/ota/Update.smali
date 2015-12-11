.class public final Lcom/amazon/dcp/ota/Update;
.super Ljava/lang/Object;
.source "Update.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/Update;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field private mForceInstall:Z

.field private mInstallOrder:Ljava/lang/Integer;

.field private mInstallSchedulerStartTimeMillis:J

.field private mLocalUri:Landroid/net/Uri;

.field private mNetworkType:Lcom/amazon/dcp/ota/NetworkType;

.field private mPackageName:Ljava/lang/String;

.field private mPackageVersionCode:Ljava/lang/Integer;

.field private mPackageVersionName:Ljava/lang/String;

.field private mRemoteFileSize:J

.field private mRemoteUri:Landroid/net/Uri;

.field private mState:Lcom/amazon/dcp/ota/UpdateState;

.field private final mType:Lcom/amazon/dcp/ota/UpdateType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    new-instance v0, Lcom/amazon/dcp/ota/Update$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/Update$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/Update;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/dcp/ota/UpdateType;)V
    .locals 4
    .param p1, "type"    # Lcom/amazon/dcp/ota/UpdateType;

    .prologue
    const/4 v3, 0x0

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-boolean v3, p0, Lcom/amazon/dcp/ota/Update;->mForceInstall:Z

    .line 40
    sget-object v0, Lcom/amazon/dcp/ota/NetworkType;->LAN:Lcom/amazon/dcp/ota/NetworkType;

    iput-object v0, p0, Lcom/amazon/dcp/ota/Update;->mNetworkType:Lcom/amazon/dcp/ota/NetworkType;

    .line 42
    sget-object v0, Lcom/amazon/dcp/ota/UpdateState;->Pending:Lcom/amazon/dcp/ota/UpdateState;

    iput-object v0, p0, Lcom/amazon/dcp/ota/Update;->mState:Lcom/amazon/dcp/ota/UpdateState;

    .line 43
    sget-object v0, Lcom/amazon/dcp/ota/OTAFailure;->None:Lcom/amazon/dcp/ota/OTAFailure;

    iput-object v0, p0, Lcom/amazon/dcp/ota/Update;->mFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 44
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dcp/ota/Update;->mLocalUri:Landroid/net/Uri;

    .line 45
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/dcp/ota/Update;->mRemoteFileSize:J

    .line 46
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/amazon/dcp/ota/Update;->mInstallSchedulerStartTimeMillis:J

    .line 50
    sget-object v0, Lcom/amazon/dcp/ota/UpdateType;->Unknown:Lcom/amazon/dcp/ota/UpdateType;

    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Unknown is not an acceptable update type"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, p1, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotEquals(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 55
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mType:Lcom/amazon/dcp/ota/UpdateType;

    .line 56
    return-void
.end method

.method static synthetic access$000(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;
    .locals 1
    .param p0, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 11
    invoke-static {p0}, Lcom/amazon/dcp/ota/Update;->fromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;

    move-result-object v0

    return-object v0
.end method

.method private static fromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/Update;
    .locals 10
    .param p0, "source"    # Landroid/os/Parcel;

    .prologue
    const/4 v9, 0x4

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 340
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 341
    .local v1, "version":I
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const-class v6, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v7, "Expected parcel v%d, but received v%d."

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v3

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    new-array v8, v4, [Ljava/lang/Object;

    invoke-static {v2, v5, v6, v7, v8}, Lcom/amazon/dcp/framework/Checks;->checkEquals(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 346
    new-instance v0, Lcom/amazon/dcp/ota/Update;

    const-class v2, Lcom/amazon/dcp/ota/UpdateType;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Lcom/amazon/dcp/ota/UpdateType;

    invoke-direct {v0, v2}, Lcom/amazon/dcp/ota/Update;-><init>(Lcom/amazon/dcp/ota/UpdateType;)V

    .line 347
    .local v0, "update":Lcom/amazon/dcp/ota/Update;
    const-class v2, Lcom/amazon/dcp/ota/UpdateState;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Lcom/amazon/dcp/ota/UpdateState;

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setState(Lcom/amazon/dcp/ota/UpdateState;)V

    .line 348
    const-class v2, Lcom/amazon/dcp/ota/OTAFailure;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Lcom/amazon/dcp/ota/OTAFailure;

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setFailureReason(Lcom/amazon/dcp/ota/OTAFailure;)V

    .line 349
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setInstallOrder(I)V

    .line 350
    invoke-virtual {p0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setPackageName(Ljava/lang/String;)V

    .line 351
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setPackageVersionCode(I)V

    .line 352
    invoke-virtual {p0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setPackageVersionName(Ljava/lang/String;)V

    .line 353
    const-class v2, Landroid/net/Uri;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setRemoteUri(Landroid/net/Uri;)V

    .line 354
    invoke-virtual {p0}, Landroid/os/Parcel;->readLong()J

    move-result-wide v5

    invoke-virtual {v0, v5, v6}, Lcom/amazon/dcp/ota/Update;->setRemoteFileSize(J)V

    .line 355
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-ne v2, v3, :cond_0

    move v2, v3

    :goto_0
    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setForceInstall(Z)V

    .line 356
    const-class v2, Lcom/amazon/dcp/ota/NetworkType;

    invoke-virtual {v2}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Lcom/amazon/dcp/ota/NetworkType;

    invoke-virtual {v0, v2}, Lcom/amazon/dcp/ota/Update;->setNetworkType(Lcom/amazon/dcp/ota/NetworkType;)V

    .line 357
    invoke-virtual {p0}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/amazon/dcp/ota/Update;->setInstallSchedulerStartTime(J)V

    .line 359
    return-object v0

    :cond_0
    move v2, v4

    .line 355
    goto :goto_0
.end method

.method private varargs isAnyObjectNull([Ljava/lang/Object;)Z
    .locals 5
    .param p1, "objects"    # [Ljava/lang/Object;

    .prologue
    .line 70
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/Object;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_1

    aget-object v3, v0, v1

    .line 72
    .local v3, "object":Ljava/lang/Object;
    if-nez v3, :cond_0

    .line 74
    const/4 v4, 0x1

    .line 78
    .end local v3    # "object":Ljava/lang/Object;
    :goto_1
    return v4

    .line 70
    .restart local v3    # "object":Ljava/lang/Object;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 78
    .end local v3    # "object":Ljava/lang/Object;
    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 315
    const/4 v0, 0x4

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 262
    if-ne p0, p1, :cond_1

    .line 278
    :cond_0
    :goto_0
    return v1

    .line 267
    :cond_1
    instance-of v3, p1, Lcom/amazon/dcp/ota/Update;

    if-nez v3, :cond_2

    move v1, v2

    .line 269
    goto :goto_0

    .line 272
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->hashCode()I

    move-result v3

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 274
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 277
    check-cast v0, Lcom/amazon/dcp/ota/Update;

    .line 278
    .local v0, "other":Lcom/amazon/dcp/ota/Update;
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getUpdateType()Lcom/amazon/dcp/ota/UpdateType;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getUpdateType()Lcom/amazon/dcp/ota/UpdateType;

    move-result-object v4

    if-ne v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getInstallOrder()I

    move-result v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getInstallOrder()I

    move-result v4

    if-ne v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionCode()I

    move-result v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionCode()I

    move-result v4

    if-ne v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getRemoteUri()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getRemoteUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getForceInstall()Z

    move-result v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getForceInstall()Z

    move-result v4

    if-ne v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getNetworkType()Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/Update;->getNetworkType()Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v4

    if-eq v3, v4, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getFailureReason()Lcom/amazon/dcp/ota/OTAFailure;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mFailure:Lcom/amazon/dcp/ota/OTAFailure;

    return-object v0
.end method

.method public getForceInstall()Z
    .locals 1

    .prologue
    .line 216
    iget-boolean v0, p0, Lcom/amazon/dcp/ota/Update;->mForceInstall:Z

    return v0
.end method

.method public getInstallOrder()I
    .locals 4

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mInstallOrder:Ljava/lang/Integer;

    const-class v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "The install order has not been set"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 121
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mInstallOrder:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getInstallSchedulerStartTime()J
    .locals 2

    .prologue
    .line 256
    iget-wide v0, p0, Lcom/amazon/dcp/ota/Update;->mInstallSchedulerStartTimeMillis:J

    return-wide v0
.end method

.method public getNetworkType()Lcom/amazon/dcp/ota/NetworkType;
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mNetworkType:Lcom/amazon/dcp/ota/NetworkType;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageName:Ljava/lang/String;

    const-class v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "The package name has not been set"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 136
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageName:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageVersionCode()I
    .locals 4

    .prologue
    .line 150
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionCode:Ljava/lang/Integer;

    const-class v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "The version code has not been set"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 152
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionCode:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getPackageVersionName()Ljava/lang/String;
    .locals 4

    .prologue
    .line 165
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionName:Ljava/lang/String;

    const-class v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "The version code has not been set"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 167
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionName:Ljava/lang/String;

    return-object v0
.end method

.method public getRemoteFileSize()J
    .locals 2

    .prologue
    .line 206
    iget-wide v0, p0, Lcom/amazon/dcp/ota/Update;->mRemoteFileSize:J

    return-wide v0
.end method

.method public getRemoteUri()Landroid/net/Uri;
    .locals 4

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mRemoteUri:Landroid/net/Uri;

    const-class v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "The remote uri has not been set"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 192
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mRemoteUri:Landroid/net/Uri;

    return-object v0
.end method

.method public getState()Lcom/amazon/dcp/ota/UpdateState;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mState:Lcom/amazon/dcp/ota/UpdateState;

    return-object v0
.end method

.method public getUpdateType()Lcom/amazon/dcp/ota/UpdateType;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mType:Lcom/amazon/dcp/ota/UpdateType;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 291
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    .line 293
    invoke-super {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 309
    :goto_0
    return v0

    .line 297
    :cond_0
    const/16 v0, 0x17

    .line 299
    .local v0, "result":I
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getUpdateType()Lcom/amazon/dcp/ota/UpdateType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/dcp/ota/UpdateType;->hashCode()I

    move-result v1

    add-int/lit16 v0, v1, 0x3af

    .line 300
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getInstallOrder()I

    move-result v2

    add-int v0, v1, v2

    .line 301
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 302
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionCode()I

    move-result v2

    add-int v0, v1, v2

    .line 303
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 304
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getRemoteUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 305
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getForceInstall()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 306
    mul-int/lit8 v1, v0, 0x29

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getNetworkType()Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/dcp/ota/NetworkType;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 309
    goto :goto_0
.end method

.method public isValid()Z
    .locals 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 60
    const/4 v2, 0x6

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/amazon/dcp/ota/Update;->mType:Lcom/amazon/dcp/ota/UpdateType;

    aput-object v3, v2, v1

    iget-object v3, p0, Lcom/amazon/dcp/ota/Update;->mInstallOrder:Ljava/lang/Integer;

    aput-object v3, v2, v0

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/amazon/dcp/ota/Update;->mPackageName:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x3

    iget-object v4, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionCode:Ljava/lang/Integer;

    aput-object v4, v2, v3

    const/4 v3, 0x4

    iget-object v4, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionName:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/amazon/dcp/ota/Update;->mRemoteUri:Landroid/net/Uri;

    aput-object v4, v2, v3

    invoke-direct {p0, v2}, Lcom/amazon/dcp/ota/Update;->isAnyObjectNull([Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public setFailureReason(Lcom/amazon/dcp/ota/OTAFailure;)V
    .locals 0
    .param p1, "failure"    # Lcom/amazon/dcp/ota/OTAFailure;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 102
    return-void
.end method

.method public setForceInstall(Z)V
    .locals 0
    .param p1, "forceInstall"    # Z

    .prologue
    .line 211
    iput-boolean p1, p0, Lcom/amazon/dcp/ota/Update;->mForceInstall:Z

    .line 212
    return-void
.end method

.method public setInstallOrder(I)V
    .locals 4
    .param p1, "order"    # I

    .prologue
    const/4 v1, 0x0

    .line 112
    if-gez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-class v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "The install order must be a positive integer"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v2, v3, v1}, Lcom/amazon/dcp/framework/Checks;->checkFalse(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 114
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/ota/Update;->mInstallOrder:Ljava/lang/Integer;

    .line 115
    return-void

    :cond_0
    move v0, v1

    .line 112
    goto :goto_0
.end method

.method public setInstallSchedulerStartTime(J)V
    .locals 0
    .param p1, "startTimeMillis"    # J

    .prologue
    .line 250
    iput-wide p1, p0, Lcom/amazon/dcp/ota/Update;->mInstallSchedulerStartTimeMillis:J

    .line 251
    return-void
.end method

.method public setLocalUri(Landroid/net/Uri;)V
    .locals 0
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 238
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mLocalUri:Landroid/net/Uri;

    .line 239
    return-void
.end method

.method public setNetworkType(Lcom/amazon/dcp/ota/NetworkType;)V
    .locals 4
    .param p1, "networkType"    # Lcom/amazon/dcp/ota/NetworkType;

    .prologue
    const/4 v3, 0x0

    .line 221
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The networkType may not be null"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 222
    sget-object v0, Lcom/amazon/dcp/ota/NetworkType;->Unknown:Lcom/amazon/dcp/ota/NetworkType;

    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "The networkType may not be Unknown"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, p1, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkNotEquals(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 227
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mNetworkType:Lcom/amazon/dcp/ota/NetworkType;

    .line 228
    return-void
.end method

.method public setPackageName(Ljava/lang/String;)V
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 126
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The package name may not be null"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 127
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The package name may not empty"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotEmpty(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 129
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mPackageName:Ljava/lang/String;

    .line 130
    return-void
.end method

.method public setPackageVersionCode(I)V
    .locals 4
    .param p1, "versionCode"    # I

    .prologue
    const/4 v1, 0x0

    .line 141
    if-gez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-class v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "The version code must be a positive integer"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v2, v3, v1}, Lcom/amazon/dcp/framework/Checks;->checkFalse(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 145
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionCode:Ljava/lang/Integer;

    .line 146
    return-void

    :cond_0
    move v0, v1

    .line 141
    goto :goto_0
.end method

.method public setPackageVersionName(Ljava/lang/String;)V
    .locals 4
    .param p1, "versionName"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 157
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The version name may not be null"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 158
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The version name may not empty"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotEmpty(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 160
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mPackageVersionName:Ljava/lang/String;

    .line 161
    return-void
.end method

.method public setRemoteFileSize(J)V
    .locals 4
    .param p1, "size"    # J

    .prologue
    const/4 v1, 0x0

    .line 198
    const-wide/16 v2, 0x0

    cmp-long v0, p1, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-class v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "The size must be greater than or equal to zero"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v2, v3, v1}, Lcom/amazon/dcp/framework/Checks;->checkTrue(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 200
    iput-wide p1, p0, Lcom/amazon/dcp/ota/Update;->mRemoteFileSize:J

    .line 201
    return-void

    :cond_0
    move v0, v1

    .line 198
    goto :goto_0
.end method

.method public setRemoteUri(Landroid/net/Uri;)V
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 172
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The remote uri may not be null"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 173
    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const-string/jumbo v2, "file"

    aput-object v2, v1, v5

    const-string/jumbo v2, "http"

    aput-object v2, v1, v4

    const/4 v2, 0x2

    const-string/jumbo v3, "https"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lcom/amazon/dcp/framework/StringUtils;->equalsAny(Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v0

    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "The remote uri must use a file, http or https scheme, not %s"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkTrue(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 177
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mRemoteUri:Landroid/net/Uri;

    .line 181
    const-string/jumbo v0, "file"

    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 183
    iget-object v0, p0, Lcom/amazon/dcp/ota/Update;->mRemoteUri:Landroid/net/Uri;

    invoke-virtual {p0, v0}, Lcom/amazon/dcp/ota/Update;->setLocalUri(Landroid/net/Uri;)V

    .line 184
    sget-object v0, Lcom/amazon/dcp/ota/UpdateState;->Downloaded:Lcom/amazon/dcp/ota/UpdateState;

    invoke-virtual {p0, v0}, Lcom/amazon/dcp/ota/Update;->setState(Lcom/amazon/dcp/ota/UpdateState;)V

    .line 186
    :cond_0
    return-void
.end method

.method public setState(Lcom/amazon/dcp/ota/UpdateState;)V
    .locals 0
    .param p1, "state"    # Lcom/amazon/dcp/ota/UpdateState;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/dcp/ota/Update;->mState:Lcom/amazon/dcp/ota/UpdateState;

    .line 90
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 5
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x0

    .line 321
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->isValid()Z

    move-result v0

    const-class v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "Can not parcel an invalid update"

    new-array v4, v1, [Ljava/lang/Object;

    invoke-static {v0, v2, v3, v4}, Lcom/amazon/dcp/framework/Checks;->checkTrue(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 323
    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 324
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getUpdateType()Lcom/amazon/dcp/ota/UpdateType;

    move-result-object v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 325
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getState()Lcom/amazon/dcp/ota/UpdateState;

    move-result-object v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 326
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getFailureReason()Lcom/amazon/dcp/ota/OTAFailure;

    move-result-object v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 327
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getInstallOrder()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 328
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 329
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionCode()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 330
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getPackageVersionName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 331
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getRemoteUri()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 332
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getRemoteFileSize()J

    move-result-wide v2

    invoke-virtual {p1, v2, v3}, Landroid/os/Parcel;->writeLong(J)V

    .line 333
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getForceInstall()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 334
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getNetworkType()Lcom/amazon/dcp/ota/NetworkType;

    move-result-object v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 335
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/Update;->getInstallSchedulerStartTime()J

    move-result-wide v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 336
    return-void

    :cond_0
    move v0, v1

    .line 333
    goto :goto_0
.end method
