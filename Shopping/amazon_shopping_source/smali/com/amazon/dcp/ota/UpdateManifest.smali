.class public final Lcom/amazon/dcp/ota/UpdateManifest;
.super Ljava/lang/Object;
.source "UpdateManifest.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/UpdateManifest;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mIdentifier:Ljava/lang/String;

.field private mPriority:I

.field private final mUpdates:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dcp/ota/Update;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    new-instance v0, Lcom/amazon/dcp/ota/UpdateManifest$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/UpdateManifest$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/UpdateManifest;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mUpdates:Ljava/util/List;

    .line 37
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mPriority:I

    .line 41
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mIdentifier:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 4
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mUpdates:Ljava/util/List;

    .line 37
    const v0, 0x7fffffff

    iput v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mPriority:I

    .line 46
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "identifier may not be null"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotNull(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 47
    const-class v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "identifier may not be empty"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1, v0, v1, v2}, Lcom/amazon/dcp/framework/Checks;->checkNotEmpty(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 49
    iput-object p1, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mIdentifier:Ljava/lang/String;

    .line 50
    return-void
.end method

.method static synthetic access$000(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/UpdateManifest;
    .locals 1
    .param p0, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 16
    invoke-static {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->fromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/UpdateManifest;

    move-result-object v0

    return-object v0
.end method

.method private static fromParcel(Landroid/os/Parcel;)Lcom/amazon/dcp/ota/UpdateManifest;
    .locals 13
    .param p0, "source"    # Landroid/os/Parcel;

    .prologue
    const/4 v12, 0x0

    const/4 v10, 0x2

    .line 215
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 216
    .local v4, "version":I
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    const-class v7, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v8, "Expected parcel v%d, but received v%d."

    new-array v9, v10, [Ljava/lang/Object;

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v9, v12

    const/4 v10, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    new-array v9, v12, [Ljava/lang/Object;

    invoke-static {v5, v6, v7, v8, v9}, Lcom/amazon/dcp/framework/Checks;->checkEquals(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 221
    invoke-virtual {p0}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 222
    .local v1, "identifier":Ljava/lang/String;
    new-instance v2, Lcom/amazon/dcp/ota/UpdateManifest;

    invoke-direct {v2, v1}, Lcom/amazon/dcp/ota/UpdateManifest;-><init>(Ljava/lang/String;)V

    .line 224
    .local v2, "manifest":Lcom/amazon/dcp/ota/UpdateManifest;
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 225
    .local v3, "numUpdates":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_0

    .line 227
    const-class v5, Lcom/amazon/dcp/ota/Update;

    invoke-virtual {v5}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v5

    invoke-virtual {p0, v5}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Lcom/amazon/dcp/ota/Update;

    invoke-virtual {v2, v5}, Lcom/amazon/dcp/ota/UpdateManifest;->addUpdate(Lcom/amazon/dcp/ota/Update;)V

    .line 225
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 230
    :cond_0
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v5

    invoke-virtual {v2, v5}, Lcom/amazon/dcp/ota/UpdateManifest;->setPriority(I)V

    .line 232
    return-object v2
.end method


# virtual methods
.method public addUpdate(Lcom/amazon/dcp/ota/Update;)V
    .locals 4
    .param p1, "update"    # Lcom/amazon/dcp/ota/Update;

    .prologue
    .line 144
    invoke-virtual {p1}, Lcom/amazon/dcp/ota/Update;->isValid()Z

    move-result v0

    const-class v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Unable to insert invalid update"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/dcp/framework/Checks;->checkTrue(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 146
    iget-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mUpdates:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 147
    return-void
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 192
    const/4 v0, 0x2

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 157
    if-ne p0, p1, :cond_1

    .line 173
    :cond_0
    :goto_0
    return v1

    .line 162
    :cond_1
    instance-of v3, p1, Lcom/amazon/dcp/ota/UpdateManifest;

    if-nez v3, :cond_2

    move v1, v2

    .line 164
    goto :goto_0

    .line 167
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->hashCode()I

    move-result v3

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 169
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 172
    check-cast v0, Lcom/amazon/dcp/ota/UpdateManifest;

    .line 173
    .local v0, "other":Lcom/amazon/dcp/ota/UpdateManifest;
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->getPriority()I

    move-result v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/UpdateManifest;->getPriority()I

    move-result v4

    if-ne v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->getUpdates()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0}, Lcom/amazon/dcp/ota/UpdateManifest;->getUpdates()Ljava/util/List;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mIdentifier:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->hashCode()I

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    .line 131
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mIdentifier:Ljava/lang/String;

    goto :goto_0
.end method

.method public getPriority()I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mPriority:I

    return v0
.end method

.method public getUpdates()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dcp/ota/Update;",
            ">;"
        }
    .end annotation

    .prologue
    .line 151
    iget-object v0, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mUpdates:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 180
    const/16 v0, 0x11

    .line 182
    .local v0, "result":I
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->getPriority()I

    move-result v1

    add-int/lit16 v0, v1, 0x275

    .line 183
    mul-int/lit8 v1, v0, 0x25

    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->getUpdates()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 186
    return v0
.end method

.method public isValid()Z
    .locals 3

    .prologue
    .line 113
    iget-object v2, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mUpdates:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/dcp/ota/Update;

    .line 115
    .local v1, "update":Lcom/amazon/dcp/ota/Update;
    invoke-virtual {v1}, Lcom/amazon/dcp/ota/Update;->isValid()Z

    move-result v2

    if-nez v2, :cond_0

    .line 117
    const/4 v2, 0x0

    .line 121
    .end local v1    # "update":Lcom/amazon/dcp/ota/Update;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public setPriority(I)V
    .locals 0
    .param p1, "priority"    # I

    .prologue
    .line 54
    iput p1, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mPriority:I

    .line 55
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 8
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v7, 0x0

    .line 198
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->isValid()Z

    move-result v3

    const-class v4, Ljava/lang/IllegalStateException;

    const-string/jumbo v5, "Can not parcel an invalid manifest"

    new-array v6, v7, [Ljava/lang/Object;

    invoke-static {v3, v4, v5, v6}, Lcom/amazon/dcp/framework/Checks;->checkTrue(ZLjava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 199
    const/4 v3, 0x2

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 200
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->getIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 202
    invoke-virtual {p0}, Lcom/amazon/dcp/ota/UpdateManifest;->getUpdates()Ljava/util/List;

    move-result-object v2

    .line 203
    .local v2, "updates":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dcp/ota/Update;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 205
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/dcp/ota/Update;

    .line 207
    .local v1, "update":Lcom/amazon/dcp/ota/Update;
    invoke-virtual {p1, v1, v7}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    goto :goto_0

    .line 210
    .end local v1    # "update":Lcom/amazon/dcp/ota/Update;
    :cond_0
    iget v3, p0, Lcom/amazon/dcp/ota/UpdateManifest;->mPriority:I

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 211
    return-void
.end method
