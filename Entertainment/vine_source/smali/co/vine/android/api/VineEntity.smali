.class public Lco/vine/android/api/VineEntity;
.super Ljava/lang/Object;
.source "VineEntity.java"

# interfaces
.implements Ljava/io/Externalizable;
.implements Ljava/lang/Comparable;
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/api/VineEntity$Range;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/io/Externalizable;",
        "Ljava/lang/Comparable",
        "<",
        "Lco/vine/android/api/VineEntity;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;"
        }
    .end annotation
.end field

.field public static final TYPE_COMMENT_LIST:Ljava/lang/String; = "commentList"

.field public static final TYPE_MENTION:Ljava/lang/String; = "mention"

.field public static final TYPE_POST:Ljava/lang/String; = "post"

.field public static final TYPE_TAG:Ljava/lang/String; = "tag"

.field public static final TYPE_USER:Ljava/lang/String; = "user"

.field public static final TYPE_USER_LIST:Ljava/lang/String; = "userList"

.field private static final serialVersionUID:J = -0x37c0049c1cf0f8cbL


# instance fields
.field public adjusted:Z

.field public end:I

.field public id:J

.field public link:Ljava/lang/String;

.field public start:I

.field public title:Ljava/lang/String;

.field public type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 177
    new-instance v0, Lco/vine/android/api/VineEntity$1;

    invoke-direct {v0}, Lco/vine/android/api/VineEntity$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineEntity;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 4
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 151
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-boolean v1, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    .line 152
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    .line 153
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    .line 154
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    .line 155
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lco/vine/android/api/VineEntity;->start:I

    .line 156
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lco/vine/android/api/VineEntity;->end:I

    .line 157
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/api/VineEntity;->id:J

    .line 158
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-ne v2, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    .line 159
    return-void

    :cond_0
    move v0, v1

    .line 158
    goto :goto_0
.end method

.method public constructor <init>(Lco/vine/android/api/VineEntity;)V
    .locals 8
    .param p1, "entity"    # Lco/vine/android/api/VineEntity;

    .prologue
    .line 55
    iget-object v1, p1, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    iget-object v2, p1, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    iget-object v3, p1, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    iget v4, p1, Lco/vine/android/api/VineEntity;->start:I

    iget v5, p1, Lco/vine/android/api/VineEntity;->end:I

    iget-wide v6, p1, Lco/vine/android/api/VineEntity;->id:J

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lco/vine/android/api/VineEntity;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJ)V

    .line 56
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJ)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "link"    # Ljava/lang/String;
    .param p4, "start"    # I
    .param p5, "end"    # I
    .param p6, "id"    # J

    .prologue
    const/4 v0, 0x0

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    .line 45
    iput-object p1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    .line 46
    iput-object p2, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    .line 47
    iput-object p3, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    .line 48
    iput p4, p0, Lco/vine/android/api/VineEntity;->start:I

    .line 49
    iput p5, p0, Lco/vine/android/api/VineEntity;->end:I

    .line 50
    iput-wide p6, p0, Lco/vine/android/api/VineEntity;->id:J

    .line 51
    iput-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    .line 52
    return-void
.end method


# virtual methods
.method public compareTo(Lco/vine/android/api/VineEntity;)I
    .locals 2
    .param p1, "vineEntity"    # Lco/vine/android/api/VineEntity;

    .prologue
    .line 116
    iget v0, p0, Lco/vine/android/api/VineEntity;->end:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iget v1, p1, Lco/vine/android/api/VineEntity;->end:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Integer;->compareTo(Ljava/lang/Integer;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 18
    check-cast p1, Lco/vine/android/api/VineEntity;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/api/VineEntity;->compareTo(Lco/vine/android/api/VineEntity;)I

    move-result v0

    return v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 174
    const/4 v0, 0x0

    return v0
.end method

.method public duplicate()Lco/vine/android/api/VineEntity;
    .locals 8

    .prologue
    .line 70
    new-instance v0, Lco/vine/android/api/VineEntity;

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    iget-object v2, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    iget-object v3, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    iget v4, p0, Lco/vine/android/api/VineEntity;->start:I

    iget v5, p0, Lco/vine/android/api/VineEntity;->end:I

    iget-wide v6, p0, Lco/vine/android/api/VineEntity;->id:J

    invoke-direct/range {v0 .. v7}, Lco/vine/android/api/VineEntity;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJ)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 86
    if-ne p0, p1, :cond_1

    .line 99
    :cond_0
    :goto_0
    return v1

    .line 87
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 89
    check-cast v0, Lco/vine/android/api/VineEntity;

    .line 91
    .local v0, "entity":Lco/vine/android/api/VineEntity;
    iget-boolean v3, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    iget-boolean v4, v0, Lco/vine/android/api/VineEntity;->adjusted:Z

    if-eq v3, v4, :cond_4

    move v1, v2

    goto :goto_0

    .line 92
    :cond_4
    iget v3, p0, Lco/vine/android/api/VineEntity;->end:I

    iget v4, v0, Lco/vine/android/api/VineEntity;->end:I

    if-eq v3, v4, :cond_5

    move v1, v2

    goto :goto_0

    .line 93
    :cond_5
    iget-wide v3, p0, Lco/vine/android/api/VineEntity;->id:J

    iget-wide v5, v0, Lco/vine/android/api/VineEntity;->id:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_6

    move v1, v2

    goto :goto_0

    .line 94
    :cond_6
    iget v3, p0, Lco/vine/android/api/VineEntity;->start:I

    iget v4, v0, Lco/vine/android/api/VineEntity;->start:I

    if-eq v3, v4, :cond_7

    move v1, v2

    goto :goto_0

    .line 95
    :cond_7
    iget-object v3, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    :cond_8
    move v1, v2

    goto :goto_0

    :cond_9
    iget-object v3, v0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    if-nez v3, :cond_8

    .line 96
    :cond_a
    iget-object v3, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    if-eqz v3, :cond_c

    iget-object v3, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_d

    :cond_b
    move v1, v2

    goto :goto_0

    :cond_c
    iget-object v3, v0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    if-nez v3, :cond_b

    .line 97
    :cond_d
    iget-object v3, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    if-eqz v3, :cond_e

    iget-object v3, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    goto :goto_0

    :cond_e
    iget-object v3, v0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getPostId()J
    .locals 4

    .prologue
    .line 190
    iget-object v2, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 191
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 192
    .local v0, "postIdString":Ljava/lang/String;
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    return-wide v2
.end method

.method public hashCode()I
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 104
    iget-object v2, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 105
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 106
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 107
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineEntity;->start:I

    add-int v0, v2, v3

    .line 108
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineEntity;->end:I

    add-int v0, v2, v3

    .line 109
    mul-int/lit8 v2, v0, 0x1f

    iget-wide v3, p0, Lco/vine/android/api/VineEntity;->id:J

    iget-wide v5, p0, Lco/vine/android/api/VineEntity;->id:J

    const/16 v7, 0x20

    ushr-long/2addr v5, v7

    xor-long/2addr v3, v5

    long-to-int v3, v3

    add-int v0, v2, v3

    .line 110
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v3, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    add-int v0, v2, v1

    .line 111
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 104
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 105
    goto :goto_1

    :cond_3
    move v2, v1

    .line 106
    goto :goto_2
.end method

.method public isCommentListType()Z
    .locals 2

    .prologue
    .line 133
    const-string v0, "commentList"

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isTagType()Z
    .locals 2

    .prologue
    .line 125
    const-string v0, "tag"

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isUserListType()Z
    .locals 2

    .prologue
    .line 129
    const-string v0, "userList"

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isUserType()Z
    .locals 2

    .prologue
    .line 120
    const-string v0, "user"

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "mention"

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "post"

    iget-object v1, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 2
    .param p1, "objectInput"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 60
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    .line 61
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    .line 62
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    .line 63
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineEntity;->start:I

    .line 64
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineEntity;->end:I

    .line 65
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineEntity;->id:J

    .line 66
    invoke-interface {p1}, Ljava/io/ObjectInput;->readBoolean()Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    .line 67
    return-void
.end method

.method public toMap()Ljava/util/HashMap;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 137
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 138
    .local v0, "objectHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v2, "id"

    iget-wide v3, p0, Lco/vine/android/api/VineEntity;->id:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 139
    const-string v2, "type"

    iget-object v3, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    const-string v2, "text"

    iget-object v3, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 143
    .local v1, "range":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget v2, p0, Lco/vine/android/api/VineEntity;->start:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 144
    iget v2, p0, Lco/vine/android/api/VineEntity;->end:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 145
    const-string v2, "range"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    return-object v0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 2
    .param p1, "objectOutput"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 76
    iget-object v0, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 77
    iget-object v0, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 78
    iget v0, p0, Lco/vine/android/api/VineEntity;->start:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 79
    iget v0, p0, Lco/vine/android/api/VineEntity;->end:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 80
    iget-wide v0, p0, Lco/vine/android/api/VineEntity;->id:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 81
    iget-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeBoolean(Z)V

    .line 82
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 163
    iget-object v0, p0, Lco/vine/android/api/VineEntity;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 165
    iget-object v0, p0, Lco/vine/android/api/VineEntity;->link:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 166
    iget v0, p0, Lco/vine/android/api/VineEntity;->start:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 167
    iget v0, p0, Lco/vine/android/api/VineEntity;->end:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 168
    iget-wide v0, p0, Lco/vine/android/api/VineEntity;->id:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 169
    iget-boolean v0, p0, Lco/vine/android/api/VineEntity;->adjusted:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 170
    return-void

    .line 169
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
