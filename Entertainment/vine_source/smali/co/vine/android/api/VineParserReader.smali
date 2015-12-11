.class public Lco/vine/android/api/VineParserReader;
.super Ljava/lang/Object;
.source "VineParserReader.java"

# interfaces
.implements Lco/vine/android/network/HttpOperationReader;


# static fields
.field public static final EXTRA_LAST_FRIEND_INDEX:Ljava/lang/String; = "friend_index"

.field public static final LOGGABLE:Z

.field public static final TAG:Ljava/lang/String; = "VineParserReader"

.field public static final TYPE_ACTIVITY:I = 0x9

.field public static final TYPE_ACTIVITY_COUNTS:I = 0x1a

.field public static final TYPE_BLOCKED_USERS:I = 0x11

.field public static final TYPE_CHANNELS:I = 0x12

.field public static final TYPE_CLIENT_FLAGS:I = 0x1d

.field public static final TYPE_CLIENT_PROFILE:I = 0xd

.field public static final TYPE_COMMENT:I = 0x7

.field public static final TYPE_COMMENTS:I = 0x6

.field public static final TYPE_CONVERSATION:I = 0x16

.field public static final TYPE_EDITIONS:I = 0x14

.field public static final TYPE_GENERAL:I = 0x1

.field public static final TYPE_GROUPED_ACTIVITY:I = 0x1c

.field public static final TYPE_INBOX:I = 0x19

.field public static final TYPE_LIKE:I = 0xa

.field public static final TYPE_LIKES:I = 0xb

.field public static final TYPE_LOGIN:I = 0x4

.field public static final TYPE_LOOPS_SUBMISSION:I = 0x1b

.field public static final TYPE_MESSAGE:I = 0x17

.field public static final TYPE_NOTIFICATION_SETTINGS:I = 0x1e

.field public static final TYPE_PENDING_NOTIF_COUNT:I = 0x15

.field public static final TYPE_POSTS:I = 0x8

.field public static final TYPE_POST_RESPONSE:I = 0xc

.field public static final TYPE_PRIVATE_MESSAGE_RESPONSE:I = 0x18

.field public static final TYPE_REVINE:I = 0x13

.field public static final TYPE_SERVER_STATUS:I = 0xf

.field public static final TYPE_SIGN_UP:I = 0x5

.field public static final TYPE_TAGS:I = 0xe

.field public static final TYPE_UPLOAD:I = 0x10

.field public static final TYPE_USER:I = 0x2

.field public static final TYPE_USERS:I = 0x3


# instance fields
.field private final mBundle:Landroid/os/Bundle;

.field private mParsedObject:Ljava/lang/Object;

.field private final mType:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 23
    const-string v0, "VineParserReader"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Lco/vine/android/api/VineParserReader;->LOGGABLE:Z

    return-void
.end method

.method private constructor <init>(I)V
    .locals 1
    .param p1, "type"    # I

    .prologue
    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lco/vine/android/api/VineParserReader;->mBundle:Landroid/os/Bundle;

    .line 129
    iput p1, p0, Lco/vine/android/api/VineParserReader;->mType:I

    .line 130
    return-void
.end method

.method public static createLoginReader()Lco/vine/android/api/VineParserReader;
    .locals 2

    .prologue
    .line 123
    new-instance v0, Lco/vine/android/api/VineParserReader;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Lco/vine/android/api/VineParserReader;-><init>(I)V

    return-object v0
.end method

.method public static createParserReader(I)Lco/vine/android/api/VineParserReader;
    .locals 1
    .param p0, "type"    # I

    .prologue
    .line 119
    new-instance v0, Lco/vine/android/api/VineParserReader;

    invoke-direct {v0, p0}, Lco/vine/android/api/VineParserReader;-><init>(I)V

    return-object v0
.end method


# virtual methods
.method public getExtraBundle()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lco/vine/android/api/VineParserReader;->mBundle:Landroid/os/Bundle;

    return-object v0
.end method

.method public getParsedObject()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()TT;"
        }
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lco/vine/android/api/VineParserReader;->mParsedObject:Ljava/lang/Object;

    return-object v0
.end method

.method public onHandleError(Lco/vine/android/network/HttpResult;)V
    .locals 0
    .param p1, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 135
    return-void
.end method

.method public readInput(IILjava/io/InputStream;)V
    .locals 8
    .param p1, "statusCode"    # I
    .param p2, "contentLength"    # I
    .param p3, "is"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 76
    sget-boolean v4, Lco/vine/android/api/VineParserReader;->LOGGABLE:Z

    if-eqz v4, :cond_1

    sget-boolean v4, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v4, :cond_1

    .line 77
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 79
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v4, 0x400

    new-array v1, v4, [B

    .line 81
    .local v1, "buffer":[B
    :goto_0
    invoke-virtual {p3, v1}, Ljava/io/InputStream;->read([B)I

    move-result v3

    .local v3, "len":I
    const/4 v4, -0x1

    if-le v3, v4, :cond_0

    .line 82
    invoke-virtual {v0, v1, v7, v3}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 83
    const-string v4, "VineParserReader"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Response: \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, v1, v7, v3}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 85
    :cond_0
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->flush()V

    .line 86
    invoke-virtual {p3}, Ljava/io/InputStream;->close()V

    .line 88
    new-instance p3, Ljava/io/ByteArrayInputStream;

    .end local p3    # "is":Ljava/io/InputStream;
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    invoke-direct {p3, v4}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 91
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v1    # "buffer":[B
    .end local v3    # "len":I
    .restart local p3    # "is":Ljava/io/InputStream;
    :cond_1
    const/16 v4, 0xc8

    if-ne p1, v4, :cond_3

    .line 92
    iget v4, p0, Lco/vine/android/api/VineParserReader;->mType:I

    packed-switch v4, :pswitch_data_0

    .line 99
    invoke-static {p3}, Lco/vine/android/api/VineParsers;->createParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v2

    .line 100
    .local v2, "jsonParser":Lcom/fasterxml/jackson/core/JsonParser;
    iget v4, p0, Lco/vine/android/api/VineParserReader;->mType:I

    iget-object v5, p0, Lco/vine/android/api/VineParserReader;->mBundle:Landroid/os/Bundle;

    invoke-static {v2, v4, v5}, Lco/vine/android/api/VineParsers;->parseVineResponse(Lcom/fasterxml/jackson/core/JsonParser;ILandroid/os/Bundle;)Ljava/lang/Object;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/api/VineParserReader;->mParsedObject:Ljava/lang/Object;

    .line 111
    :cond_2
    :goto_1
    return-void

    .line 94
    .end local v2    # "jsonParser":Lcom/fasterxml/jackson/core/JsonParser;
    :pswitch_0
    invoke-static {p3}, Lco/vine/android/api/VineParsers;->createParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v2

    .line 95
    .restart local v2    # "jsonParser":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-static {v2}, Lco/vine/android/api/VineParsers;->parseLogin(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLogin;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/api/VineParserReader;->mParsedObject:Ljava/lang/Object;

    goto :goto_1

    .line 105
    .end local v2    # "jsonParser":Lcom/fasterxml/jackson/core/JsonParser;
    :cond_3
    invoke-static {p3}, Lco/vine/android/api/VineParsers;->createParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v2

    .line 106
    .restart local v2    # "jsonParser":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-static {v2}, Lco/vine/android/api/VineParsers;->parseError(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineError;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/api/VineParserReader;->mParsedObject:Ljava/lang/Object;

    .line 107
    sget-boolean v4, Lco/vine/android/api/VineParserReader;->LOGGABLE:Z

    if-eqz v4, :cond_2

    .line 108
    const-string v4, "VineParserReader"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "ERROR: Response with "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 92
    nop

    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
    .end packed-switch
.end method
