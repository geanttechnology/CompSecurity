.class public Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;
.super Ljava/lang/Object;
.source "FlowTextCanvasInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ContactInfo"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;,
        Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;,
        Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

.field public company:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

.field public department:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

.field public emails:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;"
        }
    .end annotation
.end field

.field public jobTitle:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

.field public name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

.field public otherText:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;"
        }
    .end annotation
.end field

.field public phones:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;"
        }
    .end annotation
.end field

.field public urls:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 283
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$1;

    invoke-direct {v0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$1;-><init>()V

    sput-object v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 142
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 143
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    invoke-direct {v0, p0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    .line 144
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    invoke-direct {v0, p0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    .line 145
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-direct {v0, p0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->company:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    .line 146
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-direct {v0, p0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->department:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    .line 147
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-direct {v0, p0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;)V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->jobTitle:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    .line 148
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    .line 149
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->emails:Ljava/util/List;

    .line 150
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->urls:Ljava/util/List;

    .line 151
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->otherText:Ljava/util/List;

    .line 152
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 215
    invoke-direct {p0}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;-><init>()V

    .line 218
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->firstname:Ljava/lang/String;

    .line 219
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->middlename:Ljava/lang/String;

    .line 220
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->lastname:Ljava/lang/String;

    .line 223
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrStreet:Ljava/lang/String;

    .line 224
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrCity:Ljava/lang/String;

    .line 225
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrState:Ljava/lang/String;

    .line 226
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrZipCode:Ljava/lang/String;

    .line 228
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->company:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 229
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->department:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 230
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->jobTitle:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    .line 235
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 236
    .local v0, "listSize":I
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    .line 237
    if-lez v0, :cond_0

    .line 238
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    mul-int/lit8 v2, v0, 0x2

    invoke-direct {p0, p1, v1, v2}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->readStringArrayToEntityListWithType(Landroid/os/Parcel;Ljava/util/List;I)V

    .line 241
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->emails:Ljava/util/List;

    .line 242
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->emails:Ljava/util/List;

    invoke-direct {p0, p1, v1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->readStringArrayToEntityList(Landroid/os/Parcel;Ljava/util/List;)V

    .line 244
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->urls:Ljava/util/List;

    .line 245
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->urls:Ljava/util/List;

    invoke-direct {p0, p1, v1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->readStringArrayToEntityList(Landroid/os/Parcel;Ljava/util/List;)V

    .line 247
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->otherText:Ljava/util/List;

    .line 248
    iget-object v1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->otherText:Ljava/util/List;

    invoke-direct {p0, p1, v1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->readStringArrayToEntityList(Landroid/os/Parcel;Ljava/util/List;)V

    .line 249
    return-void
.end method

.method private entityListToStringList(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 187
    .local p1, "entities":Ljava/util/List;, "Ljava/util/List<Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 188
    .local v2, "strList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    .line 189
    .local v0, "entity":Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;
    iget-object v3, v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 191
    .end local v0    # "entity":Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;
    :cond_0
    return-object v2
.end method

.method private readStringArrayToEntityList(Landroid/os/Parcel;Ljava/util/List;)V
    .locals 4
    .param p1, "in"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 205
    .local p2, "dest":Ljava/util/List;, "Ljava/util/List<Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 206
    .local v2, "strList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readStringList(Ljava/util/List;)V

    .line 207
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 208
    .local v1, "s":Ljava/lang/String;
    new-instance v3, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    invoke-direct {v3, p0, v1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;Ljava/lang/String;)V

    invoke-interface {p2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 210
    .end local v1    # "s":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private readStringArrayToEntityListWithType(Landroid/os/Parcel;Ljava/util/List;I)V
    .locals 5
    .param p1, "in"    # Landroid/os/Parcel;
    .param p3, "listSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            "Ljava/util/List",
            "<",
            "Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 195
    .local p2, "dest":Ljava/util/List;, "Ljava/util/List<Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;>;"
    if-lez p3, :cond_0

    .line 196
    new-array v1, p3, [Ljava/lang/String;

    .line 197
    .local v1, "inArray":[Ljava/lang/String;
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->readStringArray([Ljava/lang/String;)V

    .line 198
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_0

    .line 199
    new-instance v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    aget-object v3, v1, v0

    add-int/lit8 v4, v0, 0x1

    aget-object v4, v1, v4

    invoke-direct {v2, p0, v3, v4}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;-><init>(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p2, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 198
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 202
    .end local v0    # "i":I
    .end local v1    # "inArray":[Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 295
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 4
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 256
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->firstname:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 257
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->middlename:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 258
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->name:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoName;->lastname:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 259
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrStreet:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 260
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrCity:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 261
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrState:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 262
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->address:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoAddress;->addrZipCode:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 263
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->company:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 264
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->department:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 265
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->jobTitle:Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 267
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 268
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 270
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    mul-int/lit8 v2, v2, 0x2

    new-array v1, v2, [Ljava/lang/String;

    .line 271
    .local v1, "phonesArray":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 272
    mul-int/lit8 v3, v0, 0x2

    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->type:Ljava/lang/String;

    aput-object v2, v1, v3

    .line 273
    mul-int/lit8 v2, v0, 0x2

    add-int/lit8 v3, v2, 0x1

    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->phones:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;

    iget-object v2, v2, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo$ContactInfoEntity;->content:Ljava/lang/String;

    aput-object v2, v1, v3

    .line 271
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 275
    :cond_0
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    .line 278
    .end local v0    # "i":I
    .end local v1    # "phonesArray":[Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->emails:Ljava/util/List;

    invoke-direct {p0, v2}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->entityListToStringList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 279
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->urls:Ljava/util/List;

    invoke-direct {p0, v2}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->entityListToStringList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 280
    iget-object v2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->otherText:Ljava/util/List;

    invoke-direct {p0, v2}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;->entityListToStringList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 281
    return-void
.end method
