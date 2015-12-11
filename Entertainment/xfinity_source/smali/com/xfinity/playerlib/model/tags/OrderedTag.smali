.class public final Lcom/xfinity/playerlib/model/tags/OrderedTag;
.super Ljava/lang/Object;
.source "OrderedTag.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/xfinity/playerlib/model/tags/Tag;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Lcom/xfinity/playerlib/model/tags/Tag;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
        ">;"
    }
.end annotation


# static fields
.field public static final ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

.field public static final ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final merlinId:Ljava/lang/String;

.field private final name:Ljava/lang/String;

.field private final order:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 11
    new-instance v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    const-string v1, "-2"

    const-string v2, "Movies"

    const/4 v3, 0x1

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/tags/OrderedTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 12
    new-instance v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    const-string v1, "-1"

    const-string v2, "Series"

    const/4 v3, 0x2

    invoke-direct {v0, v1, v2, v3}, Lcom/xfinity/playerlib/model/tags/OrderedTag;-><init>(Ljava/lang/String;Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 38
    new-instance v0, Lcom/xfinity/playerlib/model/tags/OrderedTag$1;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/tags/OrderedTag$1;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    .line 64
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    .line 65
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    .line 66
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/xfinity/playerlib/model/tags/OrderedTag$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/xfinity/playerlib/model/tags/OrderedTag$1;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/tags/OrderedTag;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "merlinId"
        .end annotation
    .end param
    .param p2, "name"    # Ljava/lang/String;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "name"
        .end annotation
    .end param
    .param p3, "order"    # I
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "order"
        .end annotation
    .end param

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    .line 22
    iput-object p2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    .line 23
    iput p3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    .line 24
    return-void
.end method


# virtual methods
.method public compareTo(Lcom/xfinity/playerlib/model/tags/OrderedTag;)I
    .locals 2
    .param p1, "orderedTag"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 111
    iget v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    iget v1, p1, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    if-ge v0, v1, :cond_0

    .line 112
    const/4 v0, -0x1

    .line 116
    :goto_0
    return v0

    .line 113
    :cond_0
    iget v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    iget v1, p1, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    if-le v0, v1, :cond_1

    .line 114
    const/4 v0, 0x1

    goto :goto_0

    .line 116
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 9
    check-cast p1, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->compareTo(Lcom/xfinity/playerlib/model/tags/OrderedTag;)I

    move-result v0

    return v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 81
    if-ne p0, p1, :cond_1

    .line 98
    :cond_0
    :goto_0
    return v1

    .line 84
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 85
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 87
    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 88
    .local v0, "orderedTag":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    iget v3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    iget v4, v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 89
    goto :goto_0

    .line 91
    :cond_4
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_7

    :cond_5
    move v1, v2

    .line 92
    goto :goto_0

    .line 91
    :cond_6
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    if-nez v3, :cond_5

    .line 95
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 96
    goto :goto_0

    .line 95
    :cond_8
    iget-object v3, v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 103
    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 104
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 105
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    add-int v0, v1, v2

    .line 106
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 103
    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 72
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "id"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    .line 73
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "name"

    iget-object v2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    .line 74
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "order"

    iget v2, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    .line 75
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;I)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 76
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 57
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->merlinId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 59
    iget v0, p0, Lcom/xfinity/playerlib/model/tags/OrderedTag;->order:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 60
    return-void
.end method
