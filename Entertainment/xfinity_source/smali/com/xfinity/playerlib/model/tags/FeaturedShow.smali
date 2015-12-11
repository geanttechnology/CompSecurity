.class public Lcom/xfinity/playerlib/model/tags/FeaturedShow;
.super Ljava/lang/Object;
.source "FeaturedShow.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/xfinity/playerlib/model/Program;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/xfinity/playerlib/model/tags/FeaturedShow;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final entityId:Ljava/lang/String;

.field private final entityName:Ljava/lang/String;

.field private final entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

.field private final imageUrl:Ljava/lang/String;

.field private final imageUrl2x:Ljava/lang/String;

.field private final merlinId:Lcom/xfinity/playerlib/model/MerlinId;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 105
    new-instance v0, Lcom/xfinity/playerlib/model/tags/FeaturedShow$1;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow$1;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 117
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    .line 119
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    .line 120
    invoke-static {}, Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;->values()[Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    .line 121
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    .line 122
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    .line 124
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->createMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 125
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/xfinity/playerlib/model/tags/FeaturedShow$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow$1;

    .prologue
    .line 10
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "entityId"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "entityId"
        .end annotation
    .end param
    .param p2, "entityName"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "entityName"
        .end annotation
    .end param
    .param p3, "entityType"    # Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "entityType"
        .end annotation
    .end param
    .param p4, "imageUrl"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "imageUrl"
        .end annotation
    .end param
    .param p5, "imageUrl2x"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "imageUrl2x"
        .end annotation
    .end param

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    .line 31
    iput-object p2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    .line 32
    iput-object p3, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    .line 33
    iput-object p4, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    .line 34
    iput-object p5, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    .line 36
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->createMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 37
    return-void
.end method

.method private createMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 3

    .prologue
    .line 88
    new-instance v0, Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 93
    const/4 v0, 0x0

    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "other"    # Ljava/lang/Object;

    .prologue
    .line 147
    if-ne p0, p1, :cond_0

    .line 148
    const/4 v0, 0x1

    .line 161
    .local v0, "result":Z
    :goto_0
    return v0

    .line 149
    .end local v0    # "result":Z
    :cond_0
    instance-of v2, p1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    if-eqz v2, :cond_7

    move-object v1, p1

    .line 150
    check-cast v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .line 151
    .local v1, "that":Lcom/xfinity/playerlib/model/tags/FeaturedShow;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    if-eq v2, v3, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    .line 152
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    if-eq v2, v3, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    .line 153
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    if-eq v2, v3, :cond_3

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    .line 154
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    :cond_3
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    if-eq v2, v3, :cond_4

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    .line 155
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    :cond_4
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    if-eq v2, v3, :cond_5

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    iget-object v3, v1, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    .line 156
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    :cond_5
    const/4 v0, 0x1

    .line 158
    .restart local v0    # "result":Z
    :goto_1
    goto :goto_0

    .line 156
    .end local v0    # "result":Z
    :cond_6
    const/4 v0, 0x0

    goto :goto_1

    .line 159
    .end local v1    # "that":Lcom/xfinity/playerlib/model/tags/FeaturedShow;
    :cond_7
    const/4 v0, 0x0

    .restart local v0    # "result":Z
    goto :goto_0
.end method

.method public getEntityId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    return-object v0
.end method

.method public getEntityName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    return-object v0
.end method

.method public getEntityType()Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl2x()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    return-object v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    return-object v0
.end method

.method public final hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 133
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit16 v0, v1, 0xd9

    .line 134
    .local v0, "hash":I
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    if-nez v1, :cond_1

    move v1, v2

    :goto_1
    add-int v0, v3, v1

    .line 135
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    if-nez v1, :cond_2

    move v1, v2

    :goto_2
    add-int v0, v3, v1

    .line 136
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    if-nez v1, :cond_3

    move v1, v2

    :goto_3
    add-int v0, v3, v1

    .line 137
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    if-nez v3, :cond_4

    :goto_4
    add-int v0, v1, v2

    .line 138
    return v0

    .line 133
    .end local v0    # "hash":I
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 134
    .restart local v0    # "hash":I
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1

    .line 135
    :cond_2
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;->hashCode()I

    move-result v1

    goto :goto_2

    .line 136
    :cond_3
    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_3

    .line 137
    :cond_4
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_4
.end method

.method public isMovie()Z
    .locals 2

    .prologue
    .line 81
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 98
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 99
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->entityType:Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/FeaturedShow$EntityType;->ordinal()I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 101
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 102
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->imageUrl2x:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 103
    return-void
.end method
