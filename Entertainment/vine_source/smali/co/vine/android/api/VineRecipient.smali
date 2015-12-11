.class public Lco/vine/android/api/VineRecipient;
.super Ljava/lang/Object;
.source "VineRecipient.java"

# interfaces
.implements Ljava/io/Externalizable;
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/api/VineRecipient$2;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineRecipient;",
            ">;"
        }
    .end annotation
.end field

.field public static final KEY_DISPLAY:Ljava/lang/String; = "display"

.field public static final KEY_EMAIL:Ljava/lang/String; = "email"

.field public static final KEY_PHONE:Ljava/lang/String; = "phoneNumber"

.field public static final KEY_RECIPIENT_ID:Ljava/lang/String; = "recipientId"

.field public static final KEY_USER_ID:Ljava/lang/String; = "userId"


# instance fields
.field public avatarUrl:Ljava/lang/String;

.field public color:I

.field public contactId:J

.field public display:Ljava/lang/String;

.field public friendIndex:J

.field public key:Ljava/lang/String;

.field public lastFriendRefresh:J

.field public recipientId:J

.field public sectionIndex:I

.field public sectionTitle:Ljava/lang/String;

.field public userId:J

.field public value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 190
    new-instance v0, Lco/vine/android/api/VineRecipient$1;

    invoke-direct {v0}, Lco/vine/android/api/VineRecipient$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineRecipient;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/api/VineRecipient;->lastFriendRefresh:J

    .line 131
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    .line 132
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    .line 133
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineRecipient;->userId:J

    .line 134
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    .line 135
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    .line 136
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IJ)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "userId"    # J
    .param p5, "display"    # Ljava/lang/String;
    .param p6, "color"    # I
    .param p7, "recipientId"    # J

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lco/vine/android/api/VineRecipient;->lastFriendRefresh:J

    .line 49
    iput-object p1, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    .line 50
    iput-object p2, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    .line 51
    iput-wide p3, p0, Lco/vine/android/api/VineRecipient;->userId:J

    .line 52
    iput-object p5, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    .line 53
    iput p6, p0, Lco/vine/android/api/VineRecipient;->color:I

    .line 54
    iput-wide p7, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    .line 55
    return-void
.end method

.method public static fromEmail(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;
    .locals 9
    .param p0, "display"    # Ljava/lang/String;
    .param p1, "userId"    # J
    .param p3, "email"    # Ljava/lang/String;
    .param p4, "recipientId"    # J

    .prologue
    .line 107
    new-instance v0, Lco/vine/android/api/VineRecipient;

    const-string v1, "email"

    const/4 v6, -0x1

    move-object v2, p3

    move-wide v3, p1

    move-object v5, p0

    move-wide v7, p4

    invoke-direct/range {v0 .. v8}, Lco/vine/android/api/VineRecipient;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IJ)V

    return-object v0
.end method

.method public static fromJson(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineRecipient;
    .locals 12
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    const/4 v1, 0x0

    .line 59
    .local v1, "key":Ljava/lang/String;
    const/4 v2, 0x0

    .line 60
    .local v2, "value":Ljava/lang/String;
    const/4 v5, 0x0

    .line 61
    .local v5, "display":Ljava/lang/String;
    const/4 v10, 0x0

    .line 62
    .local v10, "recipientIdString":Ljava/lang/String;
    const-wide/16 v3, 0x0

    .line 64
    .local v3, "userId":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v11

    .line 65
    .local v11, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v11, :cond_4

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v11, v0, :cond_4

    .line 66
    sget-object v0, Lco/vine/android/api/VineRecipient$2;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v11}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v0, v0, v6

    packed-switch v0, :pswitch_data_0

    .line 89
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v11

    goto :goto_0

    .line 68
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v9

    .line 69
    .local v9, "cn":Ljava/lang/String;
    const-string v0, "phoneNumber"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "email"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 71
    :cond_1
    move-object v1, v9

    .line 72
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 73
    :cond_2
    const-string v0, "recipientId"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 74
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v10

    goto :goto_1

    .line 75
    :cond_3
    const-string v0, "display"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 76
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 81
    .end local v9    # "cn":Ljava/lang/String;
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v9

    .line 82
    .restart local v9    # "cn":Ljava/lang/String;
    const-string v0, "userId"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    move-object v1, v9

    .line 84
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto :goto_1

    .line 91
    .end local v9    # "cn":Ljava/lang/String;
    :cond_4
    const-wide/16 v7, -0x1

    .line 92
    .local v7, "recipientId":J
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 93
    invoke-static {v10}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    .line 95
    :cond_5
    new-instance v0, Lco/vine/android/api/VineRecipient;

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v8}, Lco/vine/android/api/VineRecipient;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IJ)V

    return-object v0

    .line 66
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static fromPhone(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;
    .locals 9
    .param p0, "display"    # Ljava/lang/String;
    .param p1, "userId"    # J
    .param p3, "phone"    # Ljava/lang/String;
    .param p4, "recipientId"    # J

    .prologue
    .line 111
    new-instance v0, Lco/vine/android/api/VineRecipient;

    const-string v1, "phoneNumber"

    const/4 v6, -0x1

    move-object v2, p3

    move-wide v3, p1

    move-object v5, p0

    move-wide v7, p4

    invoke-direct/range {v0 .. v8}, Lco/vine/android/api/VineRecipient;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IJ)V

    return-object v0
.end method

.method public static fromRecipientId(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;
    .locals 9
    .param p0, "display"    # Ljava/lang/String;
    .param p1, "userId"    # J
    .param p3, "phone"    # Ljava/lang/String;
    .param p4, "recipientId"    # J

    .prologue
    .line 115
    new-instance v0, Lco/vine/android/api/VineRecipient;

    const-string v1, "phoneNumber"

    const/4 v6, -0x1

    move-object v2, p3

    move-wide v3, p1

    move-object v5, p0

    move-wide v7, p4

    invoke-direct/range {v0 .. v8}, Lco/vine/android/api/VineRecipient;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IJ)V

    return-object v0
.end method

.method public static fromUser(J)Lco/vine/android/api/VineRecipient;
    .locals 6
    .param p0, "userId"    # J

    .prologue
    .line 99
    const/4 v0, 0x0

    const/4 v3, 0x0

    const-wide/16 v4, -0x1

    move-wide v1, p0

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromUser(Ljava/lang/String;JIJ)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    return-object v0
.end method

.method public static fromUser(Ljava/lang/String;JIJ)Lco/vine/android/api/VineRecipient;
    .locals 9
    .param p0, "display"    # Ljava/lang/String;
    .param p1, "userId"    # J
    .param p3, "color"    # I
    .param p4, "recipientId"    # J

    .prologue
    .line 103
    new-instance v0, Lco/vine/android/api/VineRecipient;

    const-string v1, "userId"

    const/4 v2, 0x0

    move-wide v3, p1

    move-object v5, p0

    move v6, p3

    move-wide v7, p4

    invoke-direct/range {v0 .. v8}, Lco/vine/android/api/VineRecipient;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IJ)V

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 165
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 204
    if-ne p0, p1, :cond_1

    .line 216
    :cond_0
    :goto_0
    return v1

    .line 205
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

    .line 207
    check-cast v0, Lco/vine/android/api/VineRecipient;

    .line 209
    .local v0, "that":Lco/vine/android/api/VineRecipient;
    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    goto :goto_0

    :cond_5
    iget-object v3, v0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    if-nez v3, :cond_4

    .line 210
    :cond_6
    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    goto :goto_0

    :cond_8
    iget-object v3, v0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    if-nez v3, :cond_7

    .line 211
    :cond_9
    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    goto :goto_0

    :cond_b
    iget-object v3, v0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    if-nez v3, :cond_a

    .line 212
    :cond_c
    iget-wide v3, p0, Lco/vine/android/api/VineRecipient;->userId:J

    iget-wide v5, v0, Lco/vine/android/api/VineRecipient;->userId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_d

    move v1, v2

    goto :goto_0

    .line 213
    :cond_d
    iget-wide v3, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    iget-wide v5, v0, Lco/vine/android/api/VineRecipient;->recipientId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_0

    move v1, v2

    goto :goto_0
.end method

.method public getTextSortKey()Ljava/lang/String;
    .locals 3

    .prologue
    .line 187
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .locals 7

    .prologue
    const/16 v6, 0x20

    const/4 v1, 0x0

    .line 221
    iget-object v2, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 222
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 223
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lco/vine/android/api/VineRecipient;->userId:J

    iget-wide v4, p0, Lco/vine/android/api/VineRecipient;->userId:J

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 224
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    iget-wide v4, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 226
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 221
    goto :goto_0
.end method

.method public isFromEmail()Z
    .locals 2

    .prologue
    .line 127
    const-string v0, "email"

    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isFromPhone()Z
    .locals 2

    .prologue
    .line 123
    const-string v0, "phoneNumber"

    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isFromUser()Z
    .locals 2

    .prologue
    .line 119
    const-string v0, "userId"

    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
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
    .line 170
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    .line 171
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    .line 172
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineRecipient;->userId:J

    .line 173
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    .line 174
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLine()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    .line 175
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
    .line 139
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 140
    .local v0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v1, "userId"

    iget-object v2, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 141
    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    iget-wide v2, p0, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    :goto_0
    iget-wide v1, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 146
    const-string v1, "recipientId"

    iget-wide v2, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    :cond_0
    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 149
    const-string v1, "display"

    iget-object v2, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    :cond_1
    return-object v0

    .line 143
    :cond_2
    iget-object v1, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    iget-object v2, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
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
    .line 179
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 180
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 181
    iget-wide v0, p0, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 182
    iget-wide v0, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 183
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeChars(Ljava/lang/String;)V

    .line 184
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 156
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->key:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 157
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->value:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 158
    iget-wide v0, p0, Lco/vine/android/api/VineRecipient;->userId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 159
    iget-wide v0, p0, Lco/vine/android/api/VineRecipient;->recipientId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 160
    iget-object v0, p0, Lco/vine/android/api/VineRecipient;->display:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 161
    return-void
.end method
