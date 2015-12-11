.class public Lco/vine/android/api/VineParsers;
.super Ljava/lang/Object;
.source "VineParsers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/api/VineParsers$13;,
        Lco/vine/android/api/VineParsers$VinePagedInbox;,
        Lco/vine/android/api/VineParsers$VinePagedConversation;,
        Lco/vine/android/api/VineParsers$RecordListParser;,
        Lco/vine/android/api/VineParsers$RecordParser;,
        Lco/vine/android/api/VineParsers$PagedDataParser;,
        Lco/vine/android/api/VineParsers$API_RESPONSE;
    }
.end annotation


# static fields
.field private static final ACTIVITY_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;"
        }
    .end annotation
.end field

.field private static final CHANNELS_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineChannel;",
            ">;"
        }
    .end annotation
.end field

.field private static final COMMENT_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;"
        }
    .end annotation
.end field

.field private static final CONVERSATIONS_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineConversation;",
            ">;"
        }
    .end annotation
.end field

.field private static final GROUPED_ACTIVITY_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineEverydayNotification;",
            ">;"
        }
    .end annotation
.end field

.field public static final JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

.field private static final LIKES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineLike;",
            ">;"
        }
    .end annotation
.end field

.field private static final MESSAGES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;"
        }
    .end annotation
.end field

.field private static final NOTIFICATION_SETTING_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineNotificationSetting;",
            ">;"
        }
    .end annotation
.end field

.field private static final PARAM_DATA:Ljava/lang/String; = "data"

.field private static final PARAM_EDITION_ID:Ljava/lang/String; = "editionId"

.field private static final PARAM_NAME:Ljava/lang/String; = "name"

.field private static final PARAM_RECORDS:Ljava/lang/String; = "records"

.field private static final PARAM_USERS:Ljava/lang/String; = "users"

.field private static final POST_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;"
        }
    .end annotation
.end field

.field private static final TIMESTAMP_FORMAT:Ljava/lang/String; = "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

.field private static final USERS_PARSER:Lco/vine/android/api/VineParsers$RecordListParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordListParser",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field

.field private static final USER_PARSER:Lco/vine/android/api/VineParsers$RecordParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    new-instance v0, Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-direct {v0}, Lcom/fasterxml/jackson/core/JsonFactory;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

    .line 60
    new-instance v0, Lco/vine/android/api/VineParsers$1;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->USERS_PARSER:Lco/vine/android/api/VineParsers$RecordListParser;

    .line 69
    new-instance v0, Lco/vine/android/api/VineParsers$2;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$2;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->USER_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 77
    new-instance v0, Lco/vine/android/api/VineParsers$3;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$3;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->LIKES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 85
    new-instance v0, Lco/vine/android/api/VineParsers$4;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$4;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->POST_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 93
    new-instance v0, Lco/vine/android/api/VineParsers$5;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$5;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->COMMENT_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 101
    new-instance v0, Lco/vine/android/api/VineParsers$6;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$6;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->ACTIVITY_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 109
    new-instance v0, Lco/vine/android/api/VineParsers$7;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$7;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->GROUPED_ACTIVITY_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 117
    new-instance v0, Lco/vine/android/api/VineParsers$8;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$8;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->TAG_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 125
    new-instance v0, Lco/vine/android/api/VineParsers$9;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$9;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->CHANNELS_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 133
    new-instance v0, Lco/vine/android/api/VineParsers$10;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$10;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->MESSAGES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 140
    new-instance v0, Lco/vine/android/api/VineParsers$11;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$11;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->CONVERSATIONS_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    .line 147
    new-instance v0, Lco/vine/android/api/VineParsers$12;

    invoke-direct {v0}, Lco/vine/android/api/VineParsers$12;-><init>()V

    sput-object v0, Lco/vine/android/api/VineParsers;->NOTIFICATION_SETTING_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p1, "x1"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0, p1}, Lco/vine/android/api/VineParsers;->parseUsersArray(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1000(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineNotificationSetting;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseNotificationSetting(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineNotificationSetting;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLike;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseLike(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLike;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePost;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parsePost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePost;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineComment;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseComment(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineComment;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineSingleNotification;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineSingleNotification;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEverydayNotification;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseEverydayNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEverydayNotification;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineTag;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseTag(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineTag;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineChannel;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseChannel(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineChannel;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$900(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineConversation;
    .locals 1
    .param p0, "x0"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseConversation(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineConversation;

    move-result-object v0

    return-object v0
.end method

.method public static createParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;
    .locals 2
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2621
    sget-object v1, Lco/vine/android/api/VineParsers;->JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v1, p0}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonParser(Ljava/io/InputStream;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v0

    .line 2622
    .local v0, "jp":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 2623
    return-object v0
.end method

.method public static createParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;
    .locals 2
    .param p0, "inputString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2627
    sget-object v1, Lco/vine/android/api/VineParsers;->JSON_FACTORY:Lcom/fasterxml/jackson/core/JsonFactory;

    invoke-virtual {v1, p0}, Lcom/fasterxml/jackson/core/JsonFactory;->createJsonParser(Ljava/lang/String;)Lcom/fasterxml/jackson/core/JsonParser;

    move-result-object v0

    .line 2628
    .local v0, "jp":Lcom/fasterxml/jackson/core/JsonParser;
    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    .line 2629
    return-object v0
.end method

.method private static parseActivityCounts(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineActivityCounts;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 363
    const/4 v1, 0x0

    .line 364
    .local v1, "messages":I
    const/4 v2, 0x0

    .line 366
    .local v2, "notifications":I
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 367
    .local v4, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v4, :cond_2

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v5, :cond_2

    .line 368
    sget-object v5, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v4}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 379
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    goto :goto_0

    .line 370
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 371
    .local v0, "cn":Ljava/lang/String;
    const-string v5, "messages"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 372
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v1

    goto :goto_1

    .line 373
    :cond_1
    const-string v5, "notifications"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 374
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v2

    goto :goto_1

    .line 382
    .end local v0    # "cn":Ljava/lang/String;
    :cond_2
    new-instance v3, Lco/vine/android/api/VineActivityCounts;

    invoke-direct {v3, v1, v2}, Lco/vine/android/api/VineActivityCounts;-><init>(II)V

    .line 383
    .local v3, "result":Lco/vine/android/api/VineActivityCounts;
    return-object v3

    .line 368
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method private static parseBlockedUsers(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;
    .locals 5
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1178
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1180
    .local v0, "blockedUsers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 1181
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v1, :cond_0

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v3, :cond_0

    .line 1182
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1195
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    goto :goto_0

    .line 1184
    :pswitch_0
    new-instance v2, Lco/vine/android/api/VineUser;

    invoke-direct {v2}, Lco/vine/android/api/VineUser;-><init>()V

    .line 1185
    .local v2, "user":Lco/vine/android/api/VineUser;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    iput-wide v3, v2, Lco/vine/android/api/VineUser;->userId:J

    .line 1186
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1191
    .end local v2    # "user":Lco/vine/android/api/VineUser;
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1197
    :cond_0
    return-object v0

    .line 1182
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static declared-synchronized parseChannel(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineChannel;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1003
    const-class v4, Lco/vine/android/api/VineParsers;

    monitor-enter v4

    :try_start_0
    new-instance v2, Lco/vine/android/api/VineChannel;

    invoke-direct {v2}, Lco/vine/android/api/VineChannel;-><init>()V

    .line 1004
    .local v2, "vineChannel":Lco/vine/android/api/VineChannel;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 1005
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v1, :cond_6

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v3, :cond_6

    .line 1006
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v5

    aget v3, v3, v5

    packed-switch v3, :pswitch_data_0

    .line 1037
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    goto :goto_0

    .line 1009
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1003
    .end local v1    # "t":Lcom/fasterxml/jackson/core/JsonToken;
    .end local v2    # "vineChannel":Lco/vine/android/api/VineChannel;
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3

    .line 1013
    .restart local v1    # "t":Lcom/fasterxml/jackson/core/JsonToken;
    .restart local v2    # "vineChannel":Lco/vine/android/api/VineChannel;
    :pswitch_1
    :try_start_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 1014
    .local v0, "cn":Ljava/lang/String;
    const-string v3, "channel"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1015
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lco/vine/android/api/VineChannel;->channel:Ljava/lang/String;

    goto :goto_1

    .line 1016
    :cond_1
    const-string v3, "iconFullUrl"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1017
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lco/vine/android/api/VineChannel;->iconFullUrl:Ljava/lang/String;

    goto :goto_1

    .line 1018
    :cond_2
    const-string v3, "retinaIconFullUrl"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1019
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lco/vine/android/api/VineChannel;->retinaIconFullUrl:Ljava/lang/String;

    goto :goto_1

    .line 1020
    :cond_3
    const-string v3, "created"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 1021
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    const-string v5, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static {v3, v5}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v5

    iput-wide v5, v2, Lco/vine/android/api/VineChannel;->created:J

    goto :goto_1

    .line 1022
    :cond_4
    const-string v3, "backgroundColor"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 1023
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lco/vine/android/api/VineChannel;->backgroundColor:Ljava/lang/String;

    goto :goto_1

    .line 1024
    :cond_5
    const-string v3, "fontColor"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1025
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Lco/vine/android/api/VineChannel;->fontColor:Ljava/lang/String;

    goto :goto_1

    .line 1030
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 1031
    .restart local v0    # "cn":Ljava/lang/String;
    const-string v3, "channelId"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1032
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v2, Lco/vine/android/api/VineChannel;->channelId:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_1

    .line 1039
    .end local v0    # "cn":Ljava/lang/String;
    :cond_6
    monitor-exit v4

    return-object v2

    .line 1006
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static parseClientFlags(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineClientFlags;
    .locals 12
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2412
    const/4 v1, 0x0

    .line 2413
    .local v1, "messageTitle":Ljava/lang/String;
    const/4 v2, 0x0

    .line 2414
    .local v2, "messageText":Ljava/lang/String;
    const/4 v3, 0x0

    .line 2415
    .local v3, "apiHost":Ljava/lang/String;
    const/4 v4, 0x0

    .line 2416
    .local v4, "rtcHost":Ljava/lang/String;
    const/4 v5, 0x0

    .line 2417
    .local v5, "mediaHost":Ljava/lang/String;
    const/4 v6, 0x0

    .line 2418
    .local v6, "exploreHost":Ljava/lang/String;
    const-wide/16 v7, 0x0

    .line 2420
    .local v7, "ttlSeconds":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v10

    .line 2421
    .local v10, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v10, :cond_7

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v10, v0, :cond_7

    .line 2422
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v10}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v11

    aget v0, v0, v11

    packed-switch v0, :pswitch_data_0

    .line 2451
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v10

    goto :goto_0

    .line 2424
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v9

    .line 2425
    .local v9, "cn":Ljava/lang/String;
    const-string v0, "messageTitle"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2426
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 2427
    :cond_1
    const-string v0, "messageText"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2428
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 2429
    :cond_2
    const-string v0, "apiHost"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2430
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2431
    :cond_3
    const-string v0, "rtcHost"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2432
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 2433
    :cond_4
    const-string v0, "mediaHost"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 2434
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 2435
    :cond_5
    const-string v0, "exploreHost"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2436
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 2441
    .end local v9    # "cn":Ljava/lang/String;
    :pswitch_1
    const-string v0, "ttl_s"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 2442
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v7

    .line 2447
    :cond_6
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 2454
    :cond_7
    new-instance v0, Lco/vine/android/api/VineClientFlags;

    invoke-direct/range {v0 .. v8}, Lco/vine/android/api/VineClientFlags;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    return-object v0

    .line 2422
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static parseClientProfile(Lcom/fasterxml/jackson/core/JsonParser;)Lorg/json/JSONObject;
    .locals 5
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1528
    const-string v3, "Parse client profile."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 1529
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 1530
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 1531
    .local v1, "object":Lorg/json/JSONObject;
    :goto_0
    if-eqz v2, :cond_0

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v3, :cond_0

    .line 1532
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1562
    :goto_1
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    goto :goto_0

    .line 1536
    :pswitch_1
    :try_start_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 1537
    :catch_0
    move-exception v0

    .line 1538
    .local v0, "e":Lorg/json/JSONException;
    const-string v3, "Failed to parse: {}."

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    .line 1544
    .end local v0    # "e":Lorg/json/JSONException;
    :pswitch_2
    :try_start_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    invoke-virtual {v1, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 1545
    :catch_1
    move-exception v0

    .line 1546
    .restart local v0    # "e":Lorg/json/JSONException;
    const-string v3, "Failed to parse: {}."

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_1

    .line 1551
    .end local v0    # "e":Lorg/json/JSONException;
    :pswitch_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1555
    :pswitch_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1564
    :cond_0
    const-string v3, "Parsed client profile: "

    invoke-static {v3, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1565
    return-object v1

    .line 1532
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_4
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method private static parseComment(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineComment;
    .locals 22
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1066
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v21

    .line 1067
    .local v21, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v6, 0x0

    .line 1068
    .local v6, "avatarUrl":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1069
    .local v5, "comment":Ljava/lang/String;
    const-wide/16 v8, 0x0

    .line 1070
    .local v8, "timestamp":J
    const-wide/16 v3, 0x0

    .line 1071
    .local v3, "commentId":J
    const/4 v10, 0x0

    .line 1072
    .local v10, "location":Ljava/lang/String;
    const/4 v7, 0x0

    .line 1073
    .local v7, "user":Lco/vine/android/api/VineUser;
    const-wide/16 v11, 0x0

    .line 1074
    .local v11, "userId":J
    const/4 v13, 0x0

    .line 1075
    .local v13, "username":Ljava/lang/String;
    const/4 v14, 0x0

    .line 1076
    .local v14, "verified":Z
    const/16 v17, 0x0

    .line 1078
    .local v17, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :goto_0
    if-eqz v21, :cond_a

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v21

    if-eq v0, v2, :cond_a

    .line 1079
    sget-object v2, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v21 .. v21}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v15

    aget v2, v2, v15

    packed-switch v2, :pswitch_data_0

    .line 1139
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v21

    goto :goto_0

    .line 1081
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v19

    .line 1082
    .local v19, "cn":Ljava/lang/String;
    const-string v2, "user"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1083
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;

    move-result-object v7

    goto :goto_1

    .line 1085
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1090
    .end local v19    # "cn":Ljava/lang/String;
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v19

    .line 1091
    .restart local v19    # "cn":Ljava/lang/String;
    const-string v2, "avatarUrl"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1092
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 1093
    :cond_2
    const-string v2, "comment"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1094
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 1095
    :cond_3
    const-string v2, "created"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1096
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    const-string v15, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static {v2, v15}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v8

    goto :goto_1

    .line 1097
    :cond_4
    const-string v2, "location"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 1098
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v10

    goto :goto_1

    .line 1099
    :cond_5
    const-string v2, "username"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1100
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v13

    goto :goto_1

    .line 1105
    .end local v19    # "cn":Ljava/lang/String;
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v19

    .line 1106
    .restart local v19    # "cn":Ljava/lang/String;
    const-string v2, "commentId"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1107
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto/16 :goto_1

    .line 1108
    :cond_6
    const-string v2, "userId"

    move-object/from16 v0, v19

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1109
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v11

    goto/16 :goto_1

    .line 1115
    .end local v19    # "cn":Ljava/lang/String;
    :pswitch_3
    const-string v2, "verified"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v2, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1116
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v14

    goto/16 :goto_1

    .line 1121
    :pswitch_4
    const-string v2, "entities"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v2, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 1122
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v21

    .line 1123
    :goto_2
    if-eqz v21, :cond_0

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v21

    if-eq v0, v2, :cond_0

    .line 1124
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseEntity(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEntity;

    move-result-object v20

    .line 1125
    .local v20, "entity":Lco/vine/android/api/VineEntity;
    if-nez v17, :cond_7

    .line 1126
    new-instance v17, Ljava/util/ArrayList;

    .end local v17    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    .line 1128
    .restart local v17    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_7
    if-eqz v20, :cond_8

    .line 1129
    move-object/from16 v0, v17

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1131
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v21

    .line 1132
    goto :goto_2

    .line 1134
    .end local v20    # "entity":Lco/vine/android/api/VineEntity;
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 1141
    :cond_a
    if-eqz v17, :cond_b

    .line 1142
    invoke-static/range {v17 .. v17}, Lco/vine/android/util/Util;->validateAndFixEntities(Ljava/util/ArrayList;)V

    .line 1144
    :cond_b
    new-instance v2, Lco/vine/android/api/VineComment;

    const-wide/16 v15, 0x0

    const/16 v18, 0x0

    invoke-direct/range {v2 .. v18}, Lco/vine/android/api/VineComment;-><init>(JLjava/lang/String;Ljava/lang/String;Lco/vine/android/api/VineUser;JLjava/lang/String;JLjava/lang/String;ZJLjava/util/ArrayList;Z)V

    return-object v2

    .line 1079
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_4
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method private static parseConversation(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineConversation;
    .locals 25
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1818
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 1819
    .local v20, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v15, 0x0

    .line 1820
    .local v15, "deleted":Z
    const-wide/16 v3, 0x0

    .line 1821
    .local v3, "conversationId":J
    const-wide/16 v7, 0x0

    .line 1822
    .local v7, "createdBy":J
    const-wide/16 v5, 0x0

    .line 1823
    .local v5, "lastMessage":J
    const-wide/16 v16, 0x0

    .line 1824
    .local v16, "lastMessageRead":J
    const-wide/16 v12, 0x0

    .line 1826
    .local v12, "unreadMessageCount":J
    const/4 v9, 0x0

    .line 1827
    .local v9, "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessage;>;"
    const/4 v10, 0x0

    .line 1828
    .local v10, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    const/4 v11, 0x1

    .line 1830
    .local v11, "networkType":I
    :goto_0
    if-eqz v20, :cond_b

    sget-object v23, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    if-eq v0, v1, :cond_b

    .line 1831
    sget-object v23, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v20 .. v20}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v24

    aget v23, v23, v24

    packed-switch v23, :pswitch_data_0

    .line 1904
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    goto :goto_0

    .line 1833
    :pswitch_0
    const-string v23, "inbox"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 1834
    const-string v23, "other"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsString()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 1835
    const/4 v11, 0x2

    goto :goto_1

    .line 1841
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v14

    .line 1842
    .local v14, "cn":Ljava/lang/String;
    const-string v23, "conversationId"

    move-object/from16 v0, v23

    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_1

    .line 1843
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto :goto_1

    .line 1844
    :cond_1
    const-string v23, "lastMessage"

    move-object/from16 v0, v23

    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_2

    .line 1845
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    goto :goto_1

    .line 1846
    :cond_2
    const-string v23, "lastMessageRead"

    move-object/from16 v0, v23

    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_3

    .line 1847
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v16

    goto :goto_1

    .line 1848
    :cond_3
    const-string v23, "unreadMessageCount"

    move-object/from16 v0, v23

    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_4

    .line 1849
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v12

    goto :goto_1

    .line 1850
    :cond_4
    const-string v23, "createdBy"

    move-object/from16 v0, v23

    invoke-virtual {v0, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 1851
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v7

    goto :goto_1

    .line 1856
    .end local v14    # "cn":Ljava/lang/String;
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1861
    :pswitch_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v19

    .line 1862
    .local v19, "name":Ljava/lang/String;
    const-string v23, "deleted"

    move-object/from16 v0, v23

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_0

    .line 1863
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v15

    goto/16 :goto_1

    .line 1868
    .end local v19    # "name":Ljava/lang/String;
    :pswitch_4
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v19

    .line 1869
    .restart local v19    # "name":Ljava/lang/String;
    const-string v23, "messages"

    move-object/from16 v0, v23

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_7

    .line 1870
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 1871
    :goto_2
    if-eqz v20, :cond_0

    sget-object v23, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    if-eq v0, v1, :cond_0

    .line 1872
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parsePrivateMessage(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePrivateMessage;

    move-result-object v18

    .line 1873
    .local v18, "message":Lco/vine/android/api/VinePrivateMessage;
    if-nez v9, :cond_5

    .line 1874
    new-instance v9, Ljava/util/ArrayList;

    .end local v9    # "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessage;>;"
    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 1876
    .restart local v9    # "messages":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessage;>;"
    :cond_5
    if-eqz v9, :cond_6

    .line 1877
    move-object/from16 v0, v18

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1879
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 1880
    goto :goto_2

    .line 1881
    .end local v18    # "message":Lco/vine/android/api/VinePrivateMessage;
    :cond_7
    const-string v23, "users"

    move-object/from16 v0, v23

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v23

    if-eqz v23, :cond_a

    .line 1882
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    .line 1883
    :goto_3
    if-eqz v20, :cond_0

    sget-object v23, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v20

    move-object/from16 v1, v23

    if-eq v0, v1, :cond_0

    .line 1884
    sget-object v23, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v20 .. v20}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v24

    aget v23, v23, v24

    packed-switch v23, :pswitch_data_1

    .line 1896
    :cond_8
    :goto_4
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v20

    goto :goto_3

    .line 1886
    :pswitch_5
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v21

    .line 1887
    .local v21, "userId":J
    if-nez v10, :cond_9

    .line 1888
    new-instance v10, Ljava/util/ArrayList;

    .end local v10    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 1890
    .restart local v10    # "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    :cond_9
    if-eqz v10, :cond_8

    .line 1891
    invoke-static/range {v21 .. v22}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v23

    move-object/from16 v0, v23

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 1899
    .end local v21    # "userId":J
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 1907
    .end local v19    # "name":Ljava/lang/String;
    :cond_b
    new-instance v2, Lco/vine/android/api/VineConversation;

    invoke-direct/range {v2 .. v13}, Lco/vine/android/api/VineConversation;-><init>(JJJLjava/util/ArrayList;Ljava/util/ArrayList;IJ)V

    .line 1909
    .local v2, "result":Lco/vine/android/api/VineConversation;
    return-object v2

    .line 1831
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_4
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_3
    .end packed-switch

    .line 1884
    :pswitch_data_1
    .packed-switch 0x3
        :pswitch_5
    .end packed-switch
.end method

.method private static parseEditions(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;
    .locals 5
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 308
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 310
    .local v1, "editions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 311
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v0, 0x0

    .line 312
    .local v0, "editionId":Ljava/lang/String;
    :goto_0
    if-eqz v2, :cond_3

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v3, :cond_3

    .line 313
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v3, :cond_2

    .line 314
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 315
    :goto_1
    if-eqz v2, :cond_2

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v3, :cond_2

    .line 316
    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v2, v3, :cond_0

    .line 317
    const-string v3, "editionId"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 318
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    .line 323
    :cond_0
    :goto_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    goto :goto_1

    .line 319
    :cond_1
    const-string v3, "name"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 320
    new-instance v3, Landroid/util/Pair;

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v0, v4}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 326
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    goto :goto_0

    .line 328
    :cond_3
    return-object v1
.end method

.method public static parseEntity(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEntity;
    .locals 11
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2323
    const/4 v1, 0x0

    .line 2324
    .local v1, "type":Ljava/lang/String;
    const/4 v3, 0x0

    .line 2325
    .local v3, "link":Ljava/lang/String;
    const/4 v2, 0x0

    .line 2326
    .local v2, "title":Ljava/lang/String;
    const-wide/16 v6, 0x0

    .line 2327
    .local v6, "id":J
    const/4 v4, -0x1

    .line 2328
    .local v4, "start":I
    const/4 v5, -0x1

    .line 2329
    .local v5, "end":I
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 2330
    .local v9, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v9, :cond_6

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v0, :cond_6

    .line 2331
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v9}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v0, v0, v10

    packed-switch v0, :pswitch_data_0

    .line 2373
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    goto :goto_0

    .line 2333
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v8

    .line 2334
    .local v8, "cn":Ljava/lang/String;
    const-string v0, "type"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2335
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 2336
    :cond_1
    const-string v0, "link"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2337
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2338
    :cond_2
    const-string v0, "title"

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2339
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 2344
    .end local v8    # "cn":Ljava/lang/String;
    :pswitch_1
    const-string v0, "range"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2345
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 2346
    :goto_2
    if-eqz v9, :cond_5

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v0, :cond_5

    .line 2347
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v9}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v0, v0, v10

    packed-switch v0, :pswitch_data_1

    .line 2357
    :goto_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    goto :goto_2

    .line 2349
    :pswitch_2
    const/4 v0, -0x1

    if-ne v4, v0, :cond_3

    .line 2350
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    goto :goto_3

    .line 2352
    :cond_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v5

    goto :goto_3

    .line 2360
    :cond_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    .line 2364
    :cond_5
    :pswitch_3
    const-string v0, "id"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2365
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v6

    goto :goto_1

    .line 2375
    :cond_6
    new-instance v0, Lco/vine/android/api/VineEntity;

    invoke-direct/range {v0 .. v7}, Lco/vine/android/api/VineEntity;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJ)V

    return-object v0

    .line 2331
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_3
        :pswitch_0
    .end packed-switch

    .line 2347
    :pswitch_data_1
    .packed-switch 0x3
        :pswitch_2
    .end packed-switch
.end method

.method public static parseError(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineError;
    .locals 6
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1633
    const/4 v1, 0x0

    .line 1634
    .local v1, "error":I
    const/4 v2, 0x0

    .line 1635
    .local v2, "reason":Ljava/lang/String;
    const/4 v0, 0x0

    .line 1636
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 1638
    .local v3, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v3, :cond_2

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v3, v4, :cond_2

    .line 1639
    sget-object v4, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v3}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 1662
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    goto :goto_0

    .line 1641
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1645
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1649
    :pswitch_2
    const-string v4, "code"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1650
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v1

    goto :goto_1

    .line 1655
    :pswitch_3
    const-string v4, "error"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1656
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 1657
    :cond_1
    const-string v4, "data"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1658
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 1664
    :cond_2
    new-instance v4, Lco/vine/android/api/VineError;

    invoke-direct {v4, v1, v2, v0}, Lco/vine/android/api/VineError;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    return-object v4

    .line 1639
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private static parseEverydayNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEverydayNotification;
    .locals 21
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2192
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v18

    .line 2193
    .local v18, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v3, 0x0

    .line 2194
    .local v3, "body":Ljava/lang/String;
    const-wide/16 v4, 0x0

    .line 2195
    .local v4, "notificationId":J
    const-wide v11, 0x7fffffffffffffffL

    .line 2196
    .local v11, "createdAt":J
    const/4 v6, 0x0

    .line 2197
    .local v6, "notificationType":Ljava/lang/String;
    const/4 v9, 0x0

    .line 2198
    .local v9, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    const/4 v8, 0x0

    .line 2199
    .local v8, "user":Lco/vine/android/api/VineUser;
    const/4 v7, 0x0

    .line 2200
    .local v7, "post":Lco/vine/android/api/VinePost;
    const/4 v10, 0x0

    .line 2201
    .local v10, "milestone":Lco/vine/android/api/VineMilestone;
    const/4 v13, 0x0

    .line 2202
    .local v13, "isNew":Z
    const-wide/16 v14, 0x0

    .line 2204
    .local v14, "anchor":J
    :goto_0
    if-eqz v18, :cond_d

    sget-object v19, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-eq v0, v1, :cond_d

    .line 2205
    sget-object v19, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v18 .. v18}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v20

    aget v19, v19, v20

    packed-switch v19, :pswitch_data_0

    .line 2261
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v18

    goto :goto_0

    .line 2207
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v17

    .line 2208
    .local v17, "name":Ljava/lang/String;
    const-string v19, "body"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_1

    .line 2209
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2210
    :cond_1
    const-string v19, "type"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_2

    .line 2211
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 2212
    :cond_2
    const-string v19, "lastActivityTime"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_3

    .line 2213
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v19

    const-string v20, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static/range {v19 .. v20}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v11

    goto :goto_1

    .line 2214
    :cond_3
    const-string v19, "anchor"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_0

    .line 2215
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v19 .. v19}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v14

    goto :goto_1

    .line 2220
    .end local v17    # "name":Ljava/lang/String;
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v17

    .line 2221
    .restart local v17    # "name":Ljava/lang/String;
    const-string v19, "activityId"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_4

    .line 2222
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v4

    goto :goto_1

    .line 2223
    :cond_4
    const-string v19, "isNew"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_6

    .line 2224
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v19

    const/16 v20, 0x1

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_5

    const/4 v13, 0x1

    :goto_2
    goto/16 :goto_1

    :cond_5
    const/4 v13, 0x0

    goto :goto_2

    .line 2225
    :cond_6
    const-string v19, "anchor"

    move-object/from16 v0, v19

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_0

    .line 2226
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v14

    goto/16 :goto_1

    .line 2231
    .end local v17    # "name":Ljava/lang/String;
    :pswitch_2
    const-string v19, "entities"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_9

    .line 2232
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v18

    .line 2233
    :goto_3
    if-eqz v18, :cond_0

    sget-object v19, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-eq v0, v1, :cond_0

    .line 2234
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseEntity(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEntity;

    move-result-object v16

    .line 2235
    .local v16, "entity":Lco/vine/android/api/VineEntity;
    if-nez v9, :cond_7

    .line 2236
    new-instance v9, Ljava/util/ArrayList;

    .end local v9    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 2238
    .restart local v9    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_7
    if-eqz v16, :cond_8

    .line 2239
    move-object/from16 v0, v16

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2241
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v18

    .line 2242
    goto :goto_3

    .line 2244
    .end local v16    # "entity":Lco/vine/android/api/VineEntity;
    :cond_9
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2249
    :pswitch_3
    const-string v19, "user"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_a

    .line 2250
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;

    move-result-object v8

    goto/16 :goto_1

    .line 2251
    :cond_a
    const-string v19, "post"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_b

    .line 2252
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parsePost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePost;

    move-result-object v7

    goto/16 :goto_1

    .line 2253
    :cond_b
    const-string v19, "milestone"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-eqz v19, :cond_c

    .line 2254
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseMilestone(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineMilestone;

    move-result-object v10

    goto/16 :goto_1

    .line 2256
    :cond_c
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2264
    :cond_d
    new-instance v2, Lco/vine/android/api/VineEverydayNotification;

    invoke-direct/range {v2 .. v15}, Lco/vine/android/api/VineEverydayNotification;-><init>(Ljava/lang/String;JLjava/lang/String;Lco/vine/android/api/VinePost;Lco/vine/android/api/VineUser;Ljava/util/ArrayList;Lco/vine/android/api/VineMilestone;JZJ)V

    .line 2267
    .local v2, "result":Lco/vine/android/api/VineEverydayNotification;
    if-eqz v9, :cond_e

    .line 2268
    invoke-static {v9}, Lco/vine/android/util/Util;->validateAndFixEntities(Ljava/util/ArrayList;)V

    .line 2270
    :cond_e
    return-object v2

    .line 2205
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseGeneral(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;
    .locals 3
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1149
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1150
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v0, :cond_2

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v1, :cond_2

    .line 1151
    sget-object v1, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 1172
    :cond_0
    :goto_1
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1153
    :pswitch_1
    const-string v1, "success"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1154
    sget-object v1, Lco/vine/android/api/VineParsers$API_RESPONSE;->SUCCESS:Lco/vine/android/api/VineParsers$API_RESPONSE;

    .line 1174
    :goto_2
    return-object v1

    .line 1159
    :pswitch_2
    const-string v1, "success"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1160
    sget-object v1, Lco/vine/android/api/VineParsers$API_RESPONSE;->FAILURE:Lco/vine/android/api/VineParsers$API_RESPONSE;

    goto :goto_2

    .line 1164
    :cond_1
    :pswitch_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1168
    :pswitch_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1174
    :cond_2
    const/4 v1, 0x0

    goto :goto_2

    .line 1151
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private static parseLike(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLike;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 598
    new-instance v4, Lco/vine/android/api/VineLike;

    invoke-direct {v4}, Lco/vine/android/api/VineLike;-><init>()V

    .line 599
    .local v4, "vineLike":Lco/vine/android/api/VineLike;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 600
    .local v3, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v2, -0x1

    .line 601
    .local v2, "following":I
    const/4 v0, 0x0

    .line 603
    .local v0, "blocked":I
    :goto_0
    if-eqz v3, :cond_8

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v3, v5, :cond_8

    .line 604
    sget-object v5, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v3}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 648
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    goto :goto_0

    .line 606
    :pswitch_0
    const-string v5, "user"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 607
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;

    move-result-object v5

    iput-object v5, v4, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    goto :goto_1

    .line 612
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 616
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v1

    .line 617
    .local v1, "cn":Ljava/lang/String;
    const-string v5, "created"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 618
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    const-string v6, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static {v5, v6}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v5

    iput-wide v5, v4, Lco/vine/android/api/VineLike;->created:J

    goto :goto_1

    .line 619
    :cond_1
    const-string v5, "location"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 620
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lco/vine/android/api/VineLike;->location:Ljava/lang/String;

    goto :goto_1

    .line 621
    :cond_2
    const-string v5, "avatarUrl"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 622
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lco/vine/android/api/VineLike;->avatarUrl:Ljava/lang/String;

    goto :goto_1

    .line 623
    :cond_3
    const-string v5, "username"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 624
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lco/vine/android/api/VineLike;->username:Ljava/lang/String;

    goto :goto_1

    .line 629
    .end local v1    # "cn":Ljava/lang/String;
    :pswitch_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v1

    .line 630
    .restart local v1    # "cn":Ljava/lang/String;
    const-string v5, "likeId"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 631
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v4, Lco/vine/android/api/VineLike;->likeId:J

    goto :goto_1

    .line 632
    :cond_4
    const-string v5, "userId"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 633
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v4, Lco/vine/android/api/VineLike;->userId:J

    goto/16 :goto_1

    .line 634
    :cond_5
    const-string v5, "verified"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 635
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v5

    iput v5, v4, Lco/vine/android/api/VineLike;->verified:I

    goto/16 :goto_1

    .line 636
    :cond_6
    const-string v5, "following"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 637
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v2

    goto/16 :goto_1

    .line 638
    :cond_7
    const-string v5, "blocked"

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 639
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v0

    goto/16 :goto_1

    .line 651
    .end local v1    # "cn":Ljava/lang/String;
    :cond_8
    iget-object v5, v4, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    if-eqz v5, :cond_9

    .line 652
    iget-object v5, v4, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    iput v2, v5, Lco/vine/android/api/VineUser;->following:I

    .line 653
    iget-object v5, v4, Lco/vine/android/api/VineLike;->user:Lco/vine/android/api/VineUser;

    iput v0, v5, Lco/vine/android/api/VineUser;->blocked:I

    .line 656
    :cond_9
    return-object v4

    .line 604
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private static parseLikeId(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Long;
    .locals 5
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1201
    const-wide/16 v0, 0x0

    .line 1202
    .local v0, "id":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 1203
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v2, :cond_1

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v3, :cond_1

    .line 1204
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1217
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    goto :goto_0

    .line 1206
    :pswitch_0
    const-string v3, "likeId"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1207
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v0

    .line 1208
    goto :goto_1

    .line 1213
    :cond_0
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1219
    :cond_1
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    return-object v3

    .line 1204
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static parseLogin(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLogin;
    .locals 10
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1569
    const/4 v1, 0x0

    .line 1570
    .local v1, "key":Ljava/lang/String;
    const/4 v2, 0x0

    .line 1571
    .local v2, "username":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1572
    .local v5, "edition":Ljava/lang/String;
    const-wide/16 v3, 0x0

    .line 1573
    .local v3, "userId":J
    const/4 v7, 0x0

    .line 1575
    .local v7, "success":Z
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    .line 1576
    .local v8, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v8, :cond_5

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v8, v0, :cond_5

    .line 1577
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v8}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v9

    aget v0, v0, v9

    packed-switch v0, :pswitch_data_0

    .line 1622
    :cond_0
    :goto_1
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    goto :goto_0

    .line 1579
    :pswitch_1
    const-string v0, "data"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1580
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    .line 1581
    :goto_2
    if-eqz v8, :cond_0

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v8, v0, :cond_0

    .line 1582
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v8}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v9

    aget v0, v0, v9

    packed-switch v0, :pswitch_data_1

    .line 1604
    :cond_1
    :goto_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v8

    goto :goto_2

    .line 1584
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v6

    .line 1585
    .local v6, "name":Ljava/lang/String;
    const-string v0, "key"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1586
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_3

    .line 1587
    :cond_2
    const-string v0, "username"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1588
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    .line 1589
    :cond_3
    const-string v0, "edition"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1590
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 1595
    .end local v6    # "name":Ljava/lang/String;
    :pswitch_3
    const-string v0, "userId"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1596
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto :goto_3

    .line 1607
    :cond_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1613
    :pswitch_4
    const-string v0, "success"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1614
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v7

    goto :goto_1

    .line 1625
    :cond_5
    if-eqz v7, :cond_6

    .line 1626
    new-instance v0, Lco/vine/android/api/VineLogin;

    invoke-direct/range {v0 .. v5}, Lco/vine/android/api/VineLogin;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V

    .line 1628
    :goto_4
    return-object v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_4

    .line 1577
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_4
    .end packed-switch

    .line 1582
    :pswitch_data_1
    .packed-switch 0x3
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private static parseLoopsSubmission(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLoopSubmissionResponse;
    .locals 5
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 283
    const/4 v1, 0x0

    .line 285
    .local v1, "submissionInterval":I
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 286
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v2, :cond_1

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v3, :cond_1

    .line 288
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 287
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    goto :goto_0

    .line 290
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 291
    .local v0, "cn":Ljava/lang/String;
    const-string v3, "nextAfter"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 292
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v1

    goto :goto_1

    .line 298
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 304
    :cond_1
    new-instance v3, Lco/vine/android/api/VineLoopSubmissionResponse;

    invoke-direct {v3, v1}, Lco/vine/android/api/VineLoopSubmissionResponse;-><init>(I)V

    return-object v3

    .line 288
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static parseMessageError(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineError;
    .locals 5
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1668
    const/4 v0, 0x0

    .line 1669
    .local v0, "error":I
    const/4 v1, 0x0

    .line 1670
    .local v1, "reason":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    .line 1672
    .local v2, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v2, :cond_1

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v2, v3, :cond_1

    .line 1673
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v2}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1694
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v2

    goto :goto_0

    .line 1675
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1679
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1683
    :pswitch_2
    const-string v3, "code"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1684
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v0

    goto :goto_1

    .line 1689
    :pswitch_3
    const-string v3, "message"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1690
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 1696
    :cond_1
    new-instance v3, Lco/vine/android/api/VineError;

    invoke-direct {v3, v0, v1}, Lco/vine/android/api/VineError;-><init>(ILjava/lang/String;)V

    return-object v3

    .line 1673
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static parseMilestone(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineMilestone;
    .locals 12
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2274
    const/4 v1, 0x0

    .line 2275
    .local v1, "backgroundImageUrl":Ljava/lang/String;
    const/4 v2, 0x0

    .line 2276
    .local v2, "backgroundVideoUrl":Ljava/lang/String;
    const/4 v3, 0x0

    .line 2277
    .local v3, "iconUrl":Ljava/lang/String;
    const/4 v4, 0x0

    .line 2278
    .local v4, "title":Ljava/lang/String;
    const/4 v5, 0x0

    .line 2279
    .local v5, "description":Ljava/lang/String;
    const/4 v6, 0x0

    .line 2280
    .local v6, "milestoneUrl":Ljava/lang/String;
    const/4 v7, 0x0

    .line 2281
    .local v7, "overlayColor":I
    const/4 v9, 0x0

    .line 2282
    .local v9, "blurRadius":I
    const/4 v8, 0x0

    .line 2283
    .local v8, "overlayAlpha":F
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v10

    .line 2284
    .local v10, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v10, :cond_9

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v10, v0, :cond_9

    .line 2285
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v10}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v11

    aget v0, v0, v11

    packed-switch v0, :pswitch_data_0

    .line 2315
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v10

    goto :goto_0

    .line 2287
    :pswitch_0
    const-string v0, "backgroundImageUrl"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2288
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 2289
    :cond_1
    const-string v0, "backgroundVideoUrl"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2290
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 2291
    :cond_2
    const-string v0, "iconUrl"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2292
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2293
    :cond_3
    const-string v0, "title"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2294
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 2295
    :cond_4
    const-string v0, "description"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 2296
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 2297
    :cond_5
    const-string v0, "milestoneUrl"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 2298
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 2299
    :cond_6
    const-string v0, "overlayAlpha"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 2300
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v8

    goto :goto_1

    .line 2301
    :cond_7
    const-string v0, "overlayColor"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 2302
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->decode(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v7

    goto/16 :goto_1

    .line 2303
    :cond_8
    const-string v0, "gaussianBlurRadius"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2304
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    goto/16 :goto_1

    .line 2309
    :pswitch_1
    const-string v0, "gaussianBlurRadius"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2310
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v9

    goto/16 :goto_1

    .line 2317
    :cond_9
    new-instance v0, Lco/vine/android/api/VineMilestone;

    invoke-direct/range {v0 .. v9}, Lco/vine/android/api/VineMilestone;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFI)V

    return-object v0

    .line 2285
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineSingleNotification;
    .locals 32
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2072
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v29

    .line 2073
    .local v29, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v3, 0x0

    .line 2074
    .local v3, "avatarUrl":Ljava/lang/String;
    const/4 v4, 0x0

    .line 2075
    .local v4, "username":Ljava/lang/String;
    const/4 v5, 0x0

    .line 2076
    .local v5, "thumbnailUrl":Ljava/lang/String;
    const/4 v6, 0x0

    .line 2077
    .local v6, "comment":Ljava/lang/String;
    const-wide/16 v7, 0x0

    .line 2078
    .local v7, "notificationId":J
    const-wide/16 v9, 0x0

    .line 2079
    .local v9, "userId":J
    const-wide/16 v11, 0x0

    .line 2080
    .local v11, "postId":J
    const-wide/16 v13, 0x0

    .line 2081
    .local v13, "createdAt":J
    const-wide/16 v17, 0x0

    .line 2082
    .local v17, "conversationId":J
    const-wide/16 v20, 0x0

    .line 2083
    .local v20, "unreadMessageCount":J
    const-wide/16 v22, 0x0

    .line 2084
    .local v22, "recipientUserId":J
    const/4 v15, 0x0

    .line 2085
    .local v15, "verified":Z
    const/16 v16, 0x0

    .line 2086
    .local v16, "notificationType":I
    const/16 v28, 0x0

    .line 2087
    .local v28, "privateAccount":Z
    const/16 v25, 0x0

    .line 2088
    .local v25, "followRequested":Z
    const/16 v26, 0x0

    .line 2089
    .local v26, "following":Z
    const/16 v19, 0x0

    .line 2091
    .local v19, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :goto_0
    if-eqz v29, :cond_16

    sget-object v30, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-eq v0, v1, :cond_16

    .line 2092
    sget-object v30, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v29 .. v29}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v31

    aget v30, v30, v31

    packed-switch v30, :pswitch_data_0

    .line 2167
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v29

    goto :goto_0

    .line 2094
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2095
    .local v27, "name":Ljava/lang/String;
    const-string v30, "avatarUrl"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_1

    .line 2096
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2097
    :cond_1
    const-string v30, "body"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_2

    .line 2098
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v30 .. v30}, Lco/vine/android/util/Util;->getUsernameFromActivity(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 2099
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 2100
    :cond_2
    const-string v30, "thumbnailUrl"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_3

    .line 2101
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 2102
    :cond_3
    const-string v30, "created"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_0

    .line 2103
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v30

    const-string v31, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static/range {v30 .. v31}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v13

    goto :goto_1

    .line 2108
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2109
    .restart local v27    # "name":Ljava/lang/String;
    const-string v30, "notificationTypeId"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_4

    .line 2110
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v16

    goto :goto_1

    .line 2111
    :cond_4
    const-string v30, "notificationId"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_5

    .line 2112
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v7

    goto :goto_1

    .line 2113
    :cond_5
    const-string v30, "userId"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_6

    .line 2114
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v9

    goto/16 :goto_1

    .line 2115
    :cond_6
    const-string v30, "postId"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_7

    .line 2116
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v11

    goto/16 :goto_1

    .line 2117
    :cond_7
    const-string v30, "verified"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_9

    .line 2118
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v30

    const/16 v31, 0x1

    move/from16 v0, v30

    move/from16 v1, v31

    if-ne v0, v1, :cond_8

    const/4 v15, 0x1

    :goto_2
    goto/16 :goto_1

    :cond_8
    const/4 v15, 0x0

    goto :goto_2

    .line 2119
    :cond_9
    const-string v30, "private"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_b

    .line 2120
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v30

    const/16 v31, 0x1

    move/from16 v0, v30

    move/from16 v1, v31

    if-ne v0, v1, :cond_a

    const/16 v28, 0x1

    :goto_3
    goto/16 :goto_1

    :cond_a
    const/16 v28, 0x0

    goto :goto_3

    .line 2121
    :cond_b
    const-string v30, "followRequested"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_d

    .line 2122
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v30

    const/16 v31, 0x1

    move/from16 v0, v30

    move/from16 v1, v31

    if-ne v0, v1, :cond_c

    const/16 v25, 0x1

    :goto_4
    goto/16 :goto_1

    :cond_c
    const/16 v25, 0x0

    goto :goto_4

    .line 2123
    :cond_d
    const-string v30, "following"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_f

    .line 2124
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v30

    const/16 v31, 0x1

    move/from16 v0, v30

    move/from16 v1, v31

    if-ne v0, v1, :cond_e

    const/16 v26, 0x1

    :goto_5
    goto/16 :goto_1

    :cond_e
    const/16 v26, 0x0

    goto :goto_5

    .line 2125
    :cond_f
    const-string v30, "conversationId"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_10

    .line 2126
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v17

    goto/16 :goto_1

    .line 2127
    :cond_10
    const-string v30, "unreadMessageCount"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_11

    .line 2128
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v20

    goto/16 :goto_1

    .line 2129
    :cond_11
    const-string v30, "recipientUserId"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_0

    .line 2130
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v22

    goto/16 :goto_1

    .line 2135
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_2
    const-string v30, "entities"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_14

    .line 2136
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v29

    .line 2137
    :goto_6
    if-eqz v29, :cond_0

    sget-object v30, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-eq v0, v1, :cond_0

    .line 2138
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseEntity(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEntity;

    move-result-object v24

    .line 2139
    .local v24, "entity":Lco/vine/android/api/VineEntity;
    if-nez v19, :cond_12

    .line 2140
    new-instance v19, Ljava/util/ArrayList;

    .end local v19    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct/range {v19 .. v19}, Ljava/util/ArrayList;-><init>()V

    .line 2142
    .restart local v19    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_12
    if-eqz v24, :cond_13

    .line 2143
    move-object/from16 v0, v19

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2145
    :cond_13
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v29

    .line 2146
    goto :goto_6

    .line 2148
    .end local v24    # "entity":Lco/vine/android/api/VineEntity;
    :cond_14
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2154
    :pswitch_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2155
    .restart local v27    # "name":Ljava/lang/String;
    const-string v30, "followRequested"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_15

    .line 2156
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v25

    goto/16 :goto_1

    .line 2157
    :cond_15
    const-string v30, "following"

    move-object/from16 v0, v30

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v30

    if-eqz v30, :cond_0

    .line 2158
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v26

    goto/16 :goto_1

    .line 2163
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_4
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2170
    :cond_16
    new-instance v2, Lco/vine/android/api/VineSingleNotification;

    invoke-direct/range {v2 .. v23}, Lco/vine/android/api/VineSingleNotification;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJZIJLjava/util/ArrayList;JJ)V

    .line 2174
    .local v2, "result":Lco/vine/android/api/VineSingleNotification;
    if-eqz v19, :cond_17

    .line 2175
    invoke-static/range {v19 .. v19}, Lco/vine/android/util/Util;->validateAndFixEntities(Ljava/util/ArrayList;)V

    .line 2177
    :cond_17
    if-eqz v26, :cond_18

    .line 2178
    invoke-virtual {v2}, Lco/vine/android/api/VineSingleNotification;->setFollowing()V

    .line 2180
    :cond_18
    if-eqz v25, :cond_19

    .line 2181
    invoke-virtual {v2}, Lco/vine/android/api/VineSingleNotification;->setFollowRequested()V

    .line 2183
    :cond_19
    if-eqz v28, :cond_1a

    .line 2184
    invoke-virtual {v2}, Lco/vine/android/api/VineSingleNotification;->setPrivate()V

    .line 2187
    :cond_1a
    return-object v2

    .line 2092
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_4
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method private static parseNotificationSetting(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineNotificationSetting;
    .locals 13
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    .line 1913
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 1914
    .local v9, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v1, 0x0

    .line 1915
    .local v1, "isBooleanSetting":Z
    const/4 v2, 0x0

    .line 1916
    .local v2, "name":Ljava/lang/String;
    const/4 v3, 0x0

    .line 1917
    .local v3, "title":Ljava/lang/String;
    const/4 v4, 0x0

    .line 1918
    .local v4, "section":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1921
    .local v5, "value":Ljava/lang/String;
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 1923
    .local v6, "choices":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    :goto_0
    if-eqz v9, :cond_b

    sget-object v11, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v11, :cond_b

    .line 1924
    sget-object v11, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v9}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v12

    aget v11, v11, v12

    packed-switch v11, :pswitch_data_0

    .line 1977
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    goto :goto_0

    .line 1926
    :pswitch_0
    const-string v11, "title"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_1

    .line 1927
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 1928
    :cond_1
    const-string v11, "section"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_2

    .line 1929
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 1930
    :cond_2
    const-string v11, "value"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 1931
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 1932
    :cond_3
    const-string v11, "name"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 1933
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 1938
    :pswitch_1
    const-string v11, "boolean"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 1939
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v11

    if-ne v11, v10, :cond_4

    move v1, v10

    :goto_2
    goto :goto_1

    :cond_4
    const/4 v1, 0x0

    goto :goto_2

    .line 1944
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1948
    :pswitch_3
    const-string v11, "choices"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_a

    .line 1949
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 1950
    :goto_3
    if-eqz v9, :cond_0

    sget-object v11, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v11, :cond_0

    .line 1951
    const/4 v7, 0x0

    .line 1952
    .local v7, "choiceTitle":Ljava/lang/String;
    const/4 v8, 0x0

    .line 1953
    .local v8, "choiceValue":Ljava/lang/String;
    sget-object v11, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v9, v11, :cond_9

    .line 1954
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 1955
    :goto_4
    if-eqz v9, :cond_7

    sget-object v11, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v11, :cond_7

    .line 1956
    const-string v11, "title"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_6

    .line 1957
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v7

    .line 1961
    :cond_5
    :goto_5
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    goto :goto_4

    .line 1958
    :cond_6
    const-string v11, "value"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 1959
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v8

    goto :goto_5

    .line 1964
    :cond_7
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_8

    .line 1965
    move-object v7, v8

    .line 1967
    :cond_8
    new-instance v11, Landroid/util/Pair;

    invoke-direct {v11, v7, v8}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v6, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1969
    :cond_9
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 1970
    goto :goto_3

    .line 1972
    .end local v7    # "choiceTitle":Ljava/lang/String;
    .end local v8    # "choiceValue":Ljava/lang/String;
    :cond_a
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 1980
    :cond_b
    new-instance v0, Lco/vine/android/api/VineNotificationSetting;

    invoke-direct/range {v0 .. v6}, Lco/vine/android/api/VineNotificationSetting;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 1983
    .local v0, "result":Lco/vine/android/api/VineNotificationSetting;
    return-object v0

    .line 1924
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parsePagedConversation(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$RecordParser;)Lco/vine/android/api/VinePagedData;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;)",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 468
    .local p1, "parser":Lco/vine/android/api/VineParsers$RecordParser;, "Lco/vine/android/api/VineParsers$RecordParser<Lco/vine/android/api/VinePrivateMessage;>;"
    new-instance v3, Lco/vine/android/api/VineParsers$VinePagedConversation;

    invoke-direct {v3}, Lco/vine/android/api/VineParsers$VinePagedConversation;-><init>()V

    .line 469
    .local v3, "pagedData":Lco/vine/android/api/VineParsers$VinePagedConversation;
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    .line 470
    const/4 v2, 0x1

    .line 472
    .local v2, "networkType":I
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 473
    .local v4, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v4, :cond_a

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v5, :cond_a

    .line 474
    sget-object v5, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v4}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 521
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    goto :goto_0

    .line 476
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 480
    :pswitch_1
    const-string v5, "inbox"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 481
    const-string v5, "other"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 482
    const/4 v2, 0x2

    .line 487
    :cond_1
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 488
    .local v0, "cn":Ljava/lang/String;
    const-string v5, "count"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 489
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v5

    iput v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->count:I

    goto :goto_1

    .line 490
    :cond_2
    const-string v5, "nextPage"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 491
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v5

    iput v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->nextPage:I

    goto :goto_1

    .line 492
    :cond_3
    const-string v5, "previousPage"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 493
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v5

    iput v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->previousPage:I

    goto :goto_1

    .line 494
    :cond_4
    const-string v5, "size"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 495
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v5

    iput v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->size:I

    goto :goto_1

    .line 496
    :cond_5
    const-string v5, "anchor"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 497
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->anchor:J

    goto :goto_1

    .line 498
    :cond_6
    const-string v5, "unreadMessageCount"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 499
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->unreadMessageCount:J

    goto :goto_1

    .line 500
    :cond_7
    const-string v5, "lastMessageRead"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 501
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->lastMessageRead:J

    goto/16 :goto_1

    .line 502
    :cond_8
    const-string v5, "lastMessage"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 503
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    iput-wide v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->lastMessage:J

    goto/16 :goto_1

    .line 508
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_3
    const-string v5, "records"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 509
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 510
    :goto_2
    if-eqz v4, :cond_0

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v5, :cond_0

    .line 511
    const/4 v5, 0x0

    invoke-virtual {p1, p0, v5}, Lco/vine/android/api/VineParsers$RecordParser;->parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePrivateMessage;

    .line 512
    .local v1, "item":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v1, :cond_9

    .line 513
    iget-object v5, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->items:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 515
    :cond_9
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 516
    goto :goto_2

    .line 523
    .end local v1    # "item":Lco/vine/android/api/VinePrivateMessage;
    :cond_a
    iput v2, v3, Lco/vine/android/api/VineParsers$VinePagedConversation;->networkType:I

    .line 524
    return-object v3

    .line 474
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;
    .locals 1
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lco/vine/android/api/VineParsers$PagedDataParser",
            "<TT;>;)",
            "Lco/vine/android/api/VinePagedData",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 389
    .local p1, "parser":Lco/vine/android/api/VineParsers$PagedDataParser;, "Lco/vine/android/api/VineParsers$PagedDataParser<TT;>;"
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;Landroid/os/Bundle;)Lco/vine/android/api/VinePagedData;

    move-result-object v0

    return-object v0
.end method

.method private static parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;Landroid/os/Bundle;)Lco/vine/android/api/VinePagedData;
    .locals 8
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p2, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lco/vine/android/api/VineParsers$PagedDataParser",
            "<TT;>;",
            "Landroid/os/Bundle;",
            ")",
            "Lco/vine/android/api/VinePagedData",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 396
    .local p1, "parser":Lco/vine/android/api/VineParsers$PagedDataParser;, "Lco/vine/android/api/VineParsers$PagedDataParser<TT;>;"
    new-instance v3, Lco/vine/android/api/VinePagedData;

    invoke-direct {v3}, Lco/vine/android/api/VinePagedData;-><init>()V

    .line 397
    .local v3, "pagedData":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<TT;>;"
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, v3, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 399
    const/4 v4, 0x0

    .line 400
    .local v4, "singleParser":Lco/vine/android/api/VineParsers$RecordParser;, "Lco/vine/android/api/VineParsers$RecordParser<TT;>;"
    const/4 v2, 0x0

    .line 402
    .local v2, "listParser":Lco/vine/android/api/VineParsers$RecordListParser;, "Lco/vine/android/api/VineParsers$RecordListParser<TT;>;"
    instance-of v6, p1, Lco/vine/android/api/VineParsers$RecordListParser;

    if-eqz v6, :cond_1

    move-object v2, p1

    .line 403
    check-cast v2, Lco/vine/android/api/VineParsers$RecordListParser;

    .line 408
    :goto_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    .line 409
    .local v5, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_1
    if-eqz v5, :cond_a

    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v5, v6, :cond_a

    .line 410
    sget-object v6, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v5}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 460
    :cond_0
    :goto_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    goto :goto_1

    .end local v5    # "t":Lcom/fasterxml/jackson/core/JsonToken;
    :cond_1
    move-object v4, p1

    .line 405
    check-cast v4, Lco/vine/android/api/VineParsers$RecordParser;

    goto :goto_0

    .line 412
    .restart local v5    # "t":Lcom/fasterxml/jackson/core/JsonToken;
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_2

    .line 416
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 417
    .local v0, "cn":Ljava/lang/String;
    const-string v6, "anchor"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 418
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lco/vine/android/api/VinePagedData;->stringAnchor:Ljava/lang/String;

    goto :goto_2

    .line 423
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 424
    .restart local v0    # "cn":Ljava/lang/String;
    const-string v6, "count"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 425
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v6

    iput v6, v3, Lco/vine/android/api/VinePagedData;->count:I

    goto :goto_2

    .line 426
    :cond_2
    const-string v6, "nextPage"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 427
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v6

    iput v6, v3, Lco/vine/android/api/VinePagedData;->nextPage:I

    goto :goto_2

    .line 428
    :cond_3
    const-string v6, "previousPage"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 429
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v6

    iput v6, v3, Lco/vine/android/api/VinePagedData;->previousPage:I

    goto :goto_2

    .line 430
    :cond_4
    const-string v6, "size"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 431
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v6

    iput v6, v3, Lco/vine/android/api/VinePagedData;->size:I

    goto :goto_2

    .line 432
    :cond_5
    const-string v6, "anchor"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 433
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v6

    iput-wide v6, v3, Lco/vine/android/api/VinePagedData;->anchor:J

    goto :goto_2

    .line 434
    :cond_6
    const-string v6, "title"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 435
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lco/vine/android/api/VinePagedData;->title:Ljava/lang/String;

    goto :goto_2

    .line 440
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_3
    const-string v6, "records"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 441
    if-eqz v2, :cond_7

    .line 442
    iget-object v6, v3, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v2, p0, p2}, Lco/vine/android/api/VineParsers$RecordListParser;->parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto/16 :goto_2

    .line 444
    :cond_7
    if-nez v4, :cond_8

    .line 445
    new-instance v6, Ljava/lang/RuntimeException;

    const-string v7, "Invalid parser."

    invoke-direct {v6, v7}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 447
    :cond_8
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    .line 448
    :goto_3
    if-eqz v5, :cond_0

    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v5, v6, :cond_0

    .line 449
    invoke-virtual {v4, p0, p2}, Lco/vine/android/api/VineParsers$RecordParser;->parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Parcelable;

    .line 450
    .local v1, "item":Landroid/os/Parcelable;, "TT;"
    if-eqz v1, :cond_9

    .line 451
    iget-object v6, v3, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 453
    :cond_9
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    .line 454
    goto :goto_3

    .line 462
    .end local v1    # "item":Landroid/os/Parcelable;, "TT;"
    :cond_a
    return-object v3

    .line 410
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static parsePagedInbox(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$RecordParser;Lco/vine/android/api/VineParsers$RecordParser;)Lco/vine/android/api/VinePagedData;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineConversation;",
            ">;",
            "Lco/vine/android/api/VineParsers$RecordParser",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;)",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineConversation;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .local p1, "parser":Lco/vine/android/api/VineParsers$RecordParser;, "Lco/vine/android/api/VineParsers$RecordParser<Lco/vine/android/api/VineConversation;>;"
    .local p2, "userParser":Lco/vine/android/api/VineParsers$RecordParser;, "Lco/vine/android/api/VineParsers$RecordParser<Lco/vine/android/api/VineUser;>;"
    const/4 v6, 0x0

    .line 538
    new-instance v2, Lco/vine/android/api/VineParsers$VinePagedInbox;

    invoke-direct {v2}, Lco/vine/android/api/VineParsers$VinePagedInbox;-><init>()V

    .line 539
    .local v2, "pagedData":Lco/vine/android/api/VineParsers$VinePagedInbox;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->items:Ljava/util/ArrayList;

    .line 541
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 542
    .local v3, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v3, :cond_8

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v3, v4, :cond_8

    .line 543
    sget-object v4, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v3}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 587
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    goto :goto_0

    .line 545
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 549
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 550
    .local v0, "cn":Ljava/lang/String;
    const-string v4, "count"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 551
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    iput v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->count:I

    goto :goto_1

    .line 552
    :cond_1
    const-string v4, "nextPage"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 553
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    iput v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->nextPage:I

    goto :goto_1

    .line 554
    :cond_2
    const-string v4, "previousPage"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 555
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    iput v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->previousPage:I

    goto :goto_1

    .line 556
    :cond_3
    const-string v4, "size"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 557
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v4

    iput v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->size:I

    goto :goto_1

    .line 558
    :cond_4
    const-string v4, "anchor"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 559
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v4

    iput-wide v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->anchor:J

    goto :goto_1

    .line 564
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_2
    const-string v4, "records"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 565
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 566
    :goto_2
    if-eqz v3, :cond_6

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v3, v4, :cond_6

    .line 567
    invoke-virtual {p1, p0, v6}, Lco/vine/android/api/VineParsers$RecordParser;->parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineConversation;

    .line 568
    .local v1, "item":Lco/vine/android/api/VineConversation;
    if-eqz v1, :cond_5

    .line 569
    iget-object v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->items:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 571
    :cond_5
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 572
    goto :goto_2

    .line 574
    .end local v1    # "item":Lco/vine/android/api/VineConversation;
    :cond_6
    const-string v4, "users"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 575
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 576
    :goto_3
    if-eqz v3, :cond_0

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v3, v4, :cond_0

    .line 577
    invoke-virtual {p2, p0, v6}, Lco/vine/android/api/VineParsers$RecordParser;->parse(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    .line 578
    .local v1, "item":Lco/vine/android/api/VineUser;
    if-eqz v1, :cond_7

    .line 579
    iget-object v4, v2, Lco/vine/android/api/VineParsers$VinePagedInbox;->participants:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 581
    :cond_7
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v3

    .line 582
    goto :goto_3

    .line 589
    .end local v1    # "item":Lco/vine/android/api/VineUser;
    :cond_8
    return-object v2

    .line 543
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static parsePost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePost;
    .locals 34
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 741
    new-instance v29, Lco/vine/android/api/VinePost;

    invoke-direct/range {v29 .. v29}, Lco/vine/android/api/VinePost;-><init>()V

    .line 742
    .local v29, "vinePost":Lco/vine/android/api/VinePost;
    const/4 v11, 0x0

    .line 743
    .local v11, "address":Ljava/lang/String;
    const/4 v4, 0x0

    .line 744
    .local v4, "categoryIconUrl":Ljava/lang/String;
    const/4 v6, 0x0

    .line 745
    .local v6, "categoryId":Ljava/lang/String;
    const/4 v5, 0x0

    .line 746
    .local v5, "categoryShortName":Ljava/lang/String;
    const/4 v7, 0x0

    .line 747
    .local v7, "city":Ljava/lang/String;
    const/4 v8, 0x0

    .line 748
    .local v8, "countryCode":Ljava/lang/String;
    const/4 v9, 0x0

    .line 749
    .local v9, "venueName":Ljava/lang/String;
    const/4 v10, 0x0

    .line 750
    .local v10, "state":Ljava/lang/String;
    const/16 v28, 0x0

    .line 751
    .local v28, "videoWebmUrl":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    .line 752
    .local v24, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v15, 0x0

    .line 753
    .local v15, "explicitContent":Z
    const/16 v27, 0x0

    .line 754
    .local v27, "verified":Z
    const/16 v16, 0x0

    .line 755
    .local v16, "liked":Z
    const/16 v23, 0x0

    .line 756
    .local v23, "revined":Z
    const/16 v22, 0x0

    .line 757
    .local v22, "promoted":Z
    const/16 v20, 0x0

    .line 758
    .local v20, "postVerified":Z
    const/16 v21, 0x0

    .line 759
    .local v21, "priv":Z
    const-wide/16 v17, 0x0

    .line 760
    .local v17, "loops":J
    const-wide/16 v25, 0x0

    .line 761
    .local v25, "velocity":D
    const/16 v19, 0x0

    .line 763
    .local v19, "onFire":Z
    :goto_0
    if-eqz v24, :cond_33

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v24

    if-eq v0, v3, :cond_33

    .line 764
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v24 .. v24}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v30

    aget v3, v3, v30

    packed-switch v3, :pswitch_data_0

    .line 945
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    goto :goto_0

    .line 766
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    .line 767
    .local v12, "cn":Ljava/lang/String;
    const-string v3, "comments"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 768
    sget-object v3, Lco/vine/android/api/VineParsers;->COMMENT_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    goto :goto_1

    .line 769
    :cond_1
    const-string v3, "likes"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 770
    sget-object v3, Lco/vine/android/api/VineParsers;->LIKES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    goto :goto_1

    .line 771
    :cond_2
    const-string v3, "loops"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 772
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    .line 773
    :goto_2
    if-eqz v24, :cond_0

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v24

    if-eq v0, v3, :cond_0

    .line 774
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v24 .. v24}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v30

    aget v3, v3, v30

    packed-switch v3, :pswitch_data_1

    .line 802
    :cond_3
    :goto_3
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    goto :goto_2

    .line 777
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_3

    .line 781
    :pswitch_3
    const-string v3, "count"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 782
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getDoubleValue()D

    move-result-wide v30

    move-wide/from16 v0, v30

    double-to-long v0, v0

    move-wide/from16 v17, v0

    goto :goto_3

    .line 783
    :cond_4
    const-string v3, "velocity"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 784
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getDoubleValue()D

    move-result-wide v25

    goto :goto_3

    .line 789
    :pswitch_4
    const-string v3, "onFire"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 790
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    const/16 v30, 0x1

    move/from16 v0, v30

    if-ne v3, v0, :cond_5

    const/16 v19, 0x1

    :goto_4
    goto :goto_3

    :cond_5
    const/16 v19, 0x0

    goto :goto_4

    .line 796
    :pswitch_5
    const-string v3, "onFire"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 797
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v19

    goto :goto_3

    .line 804
    :cond_6
    const-string v3, "user"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 805
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    .line 806
    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    iget v3, v3, Lco/vine/android/api/VineUser;->profileBackground:I

    move-object/from16 v0, v29

    iput v3, v0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    goto/16 :goto_1

    .line 807
    :cond_7
    const-string v3, "repost"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 808
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseRepost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineRepost;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    goto/16 :goto_1

    .line 809
    :cond_8
    const-string v3, "reposts"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 810
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    .line 811
    :goto_5
    if-eqz v24, :cond_0

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v24

    if-eq v0, v3, :cond_0

    .line 812
    sget-object v3, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v24 .. v24}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v30

    aget v3, v3, v30

    packed-switch v3, :pswitch_data_2

    .line 828
    :cond_9
    :goto_6
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    goto :goto_5

    .line 818
    :pswitch_6
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_6

    .line 822
    :pswitch_7
    const-string v3, "count"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 823
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    move-object/from16 v0, v29

    iput v3, v0, Lco/vine/android/api/VinePost;->revinersCount:I

    goto :goto_6

    .line 831
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 836
    .end local v12    # "cn":Ljava/lang/String;
    :pswitch_8
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    .line 837
    .restart local v12    # "cn":Ljava/lang/String;
    const-string v3, "tags"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 838
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseTags(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    goto/16 :goto_1

    .line 839
    :cond_b
    const-string v3, "entities"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 840
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    .line 841
    const/4 v13, 0x0

    .line 842
    .local v13, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :goto_7
    if-eqz v24, :cond_e

    sget-object v3, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v24

    if-eq v0, v3, :cond_e

    .line 843
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseEntity(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineEntity;

    move-result-object v14

    .line 844
    .local v14, "entity":Lco/vine/android/api/VineEntity;
    if-nez v13, :cond_c

    .line 845
    new-instance v13, Ljava/util/ArrayList;

    .end local v13    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 847
    .restart local v13    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_c
    if-eqz v14, :cond_d

    .line 848
    invoke-virtual {v13, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 850
    :cond_d
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v24

    .line 851
    goto :goto_7

    .line 852
    .end local v14    # "entity":Lco/vine/android/api/VineEntity;
    :cond_e
    if-eqz v13, :cond_0

    .line 853
    invoke-static {v13}, Lco/vine/android/util/Util;->validateAndFixEntities(Ljava/util/ArrayList;)V

    .line 854
    move-object/from16 v0, v29

    iput-object v13, v0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    goto/16 :goto_1

    .line 857
    .end local v13    # "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    :cond_f
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 862
    .end local v12    # "cn":Ljava/lang/String;
    :pswitch_9
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    .line 863
    .restart local v12    # "cn":Ljava/lang/String;
    const-string v3, "foursquareVenueId"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_10

    .line 864
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    goto/16 :goto_1

    .line 865
    :cond_10
    const-string v3, "description"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_11

    .line 866
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    goto/16 :goto_1

    .line 867
    :cond_11
    const-string v3, "created"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_12

    .line 868
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    const-string v30, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    move-object/from16 v0, v30

    invoke-static {v3, v0}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v30

    move-wide/from16 v0, v30

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->created:J

    goto/16 :goto_1

    .line 869
    :cond_12
    const-string v3, "location"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_13

    .line 870
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    goto/16 :goto_1

    .line 871
    :cond_13
    const-string v3, "avatarUrl"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_14

    .line 872
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    goto/16 :goto_1

    .line 873
    :cond_14
    const-string v3, "videoLowURL"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_15

    .line 874
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    goto/16 :goto_1

    .line 875
    :cond_15
    const-string v3, "videoUrl"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_16

    .line 876
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    goto/16 :goto_1

    .line 877
    :cond_16
    const-string v3, "videoWebmUrl"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_17

    .line 878
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v28

    goto/16 :goto_1

    .line 879
    :cond_17
    const-string v3, "username"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_18

    .line 880
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    goto/16 :goto_1

    .line 881
    :cond_18
    const-string v3, "shareUrl"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_19

    .line 882
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    goto/16 :goto_1

    .line 883
    :cond_19
    const-string v3, "thumbnailUrl"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1a

    .line 884
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    goto/16 :goto_1

    .line 885
    :cond_1a
    const-string v3, "venueAddress"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b

    .line 886
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v11

    goto/16 :goto_1

    .line 887
    :cond_1b
    const-string v3, "venueCategoryIconUrl"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1c

    .line 888
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_1

    .line 889
    :cond_1c
    const-string v3, "venueCategoryId"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1d

    .line 890
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_1

    .line 891
    :cond_1d
    const-string v3, "venueCategoryShortName"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1e

    .line 892
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_1

    .line 893
    :cond_1e
    const-string v3, "venueCity"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1f

    .line 894
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v7

    goto/16 :goto_1

    .line 895
    :cond_1f
    const-string v3, "venueCountryCode"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_20

    .line 896
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v8

    goto/16 :goto_1

    .line 897
    :cond_20
    const-string v3, "venueName"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_21

    .line 898
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_1

    .line 899
    :cond_21
    const-string v3, "state"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_22

    .line 900
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_1

    .line 901
    :cond_22
    const-string v3, "profileBackground"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 902
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    const/16 v30, 0x2

    move/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    const/16 v30, 0x10

    move/from16 v0, v30

    invoke-static {v3, v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;I)J

    move-result-wide v30

    move-wide/from16 v0, v30

    long-to-int v3, v0

    move-object/from16 v0, v29

    iput v3, v0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    goto/16 :goto_1

    .line 907
    .end local v12    # "cn":Ljava/lang/String;
    :pswitch_a
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    .line 908
    .restart local v12    # "cn":Ljava/lang/String;
    const-string v3, "explicitContent"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_24

    .line 909
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    const/16 v30, 0x1

    move/from16 v0, v30

    if-ne v3, v0, :cond_23

    const/4 v15, 0x1

    :goto_8
    goto/16 :goto_1

    :cond_23
    const/4 v15, 0x0

    goto :goto_8

    .line 910
    :cond_24
    const-string v3, "postFlags"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_25

    .line 911
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    move-object/from16 v0, v29

    iput v3, v0, Lco/vine/android/api/VinePost;->postFlags:I

    goto/16 :goto_1

    .line 912
    :cond_25
    const-string v3, "postVerified"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_27

    .line 913
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    const/16 v30, 0x1

    move/from16 v0, v30

    if-ne v3, v0, :cond_26

    const/16 v20, 0x1

    :goto_9
    goto/16 :goto_1

    :cond_26
    const/16 v20, 0x0

    goto :goto_9

    .line 914
    :cond_27
    const-string v3, "promoted"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_29

    .line 915
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    const/16 v30, 0x1

    move/from16 v0, v30

    if-ne v3, v0, :cond_28

    const/16 v22, 0x1

    :goto_a
    goto/16 :goto_1

    :cond_28
    const/16 v22, 0x0

    goto :goto_a

    .line 916
    :cond_29
    const-string v3, "verified"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2b

    .line 917
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v3

    const/16 v30, 0x1

    move/from16 v0, v30

    if-ne v3, v0, :cond_2a

    const/16 v27, 0x1

    :goto_b
    goto/16 :goto_1

    :cond_2a
    const/16 v27, 0x0

    goto :goto_b

    .line 918
    :cond_2b
    const-string v3, "postId"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2c

    .line 919
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v30

    move-wide/from16 v0, v30

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->postId:J

    goto/16 :goto_1

    .line 920
    :cond_2c
    const-string v3, "userId"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2d

    .line 921
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v30

    move-wide/from16 v0, v30

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->userId:J

    goto/16 :goto_1

    .line 922
    :cond_2d
    const-string v3, "myRepostId"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2e

    .line 923
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v30

    move-wide/from16 v0, v30

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->myRepostId:J

    .line 924
    move-object/from16 v0, v29

    iget-wide v0, v0, Lco/vine/android/api/VinePost;->myRepostId:J

    move-wide/from16 v30, v0

    const-wide/16 v32, 0x0

    cmp-long v3, v30, v32

    if-lez v3, :cond_0

    .line 925
    const/16 v23, 0x1

    goto/16 :goto_1

    .line 927
    :cond_2e
    const-string v3, "private"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_30

    .line 928
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v30

    const-wide/16 v32, 0x1

    cmp-long v3, v30, v32

    if-nez v3, :cond_2f

    const/16 v21, 0x1

    :goto_c
    goto/16 :goto_1

    :cond_2f
    const/16 v21, 0x0

    goto :goto_c

    .line 929
    :cond_30
    const-string v3, "liked"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 930
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v30

    const-wide/16 v32, 0x1

    cmp-long v3, v30, v32

    if-nez v3, :cond_31

    const/16 v16, 0x1

    :goto_d
    goto/16 :goto_1

    :cond_31
    const/16 v16, 0x0

    goto :goto_d

    .line 936
    .end local v12    # "cn":Ljava/lang/String;
    :pswitch_b
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    .line 937
    .restart local v12    # "cn":Ljava/lang/String;
    const-string v3, "liked"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_32

    .line 938
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v16

    goto/16 :goto_1

    .line 939
    :cond_32
    const-string v3, "revined"

    invoke-virtual {v3, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 940
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v23

    goto/16 :goto_1

    .line 948
    .end local v12    # "cn":Ljava/lang/String;
    :cond_33
    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    if-nez v3, :cond_34

    if-eqz v28, :cond_34

    .line 949
    move-object/from16 v0, v28

    move-object/from16 v1, v29

    iput-object v0, v1, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    .line 952
    :cond_34
    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    if-eqz v3, :cond_35

    .line 953
    new-instance v3, Lco/vine/android/api/VineVenue;

    invoke-direct/range {v3 .. v11}, Lco/vine/android/api/VineVenue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, v29

    iput-object v3, v0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    .line 957
    :cond_35
    move-object/from16 v0, v29

    invoke-virtual {v0, v15}, Lco/vine/android/api/VinePost;->setFlagExplicit(Z)V

    .line 958
    move-object/from16 v0, v29

    move/from16 v1, v27

    invoke-virtual {v0, v1}, Lco/vine/android/api/VinePost;->setFlagVerified(Z)V

    .line 959
    move-object/from16 v0, v29

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lco/vine/android/api/VinePost;->setFlagRevined(Z)V

    .line 960
    move-object/from16 v0, v29

    move/from16 v1, v16

    invoke-virtual {v0, v1}, Lco/vine/android/api/VinePost;->setFlagLiked(Z)V

    .line 961
    move-object/from16 v0, v29

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Lco/vine/android/api/VinePost;->setFlagPromoted(Z)V

    .line 962
    move-object/from16 v0, v29

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Lco/vine/android/api/VinePost;->setFlagPostVerified(Z)V

    .line 963
    move-object/from16 v0, v29

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lco/vine/android/api/VinePost;->setFlagPrivate(Z)V

    .line 965
    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v3, :cond_36

    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget v3, v3, Lco/vine/android/api/VinePagedData;->count:I

    :goto_e
    move-object/from16 v0, v29

    iput v3, v0, Lco/vine/android/api/VinePost;->likesCount:I

    .line 966
    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-eqz v3, :cond_37

    move-object/from16 v0, v29

    iget-object v3, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    iget v3, v3, Lco/vine/android/api/VinePagedData;->count:I

    :goto_f
    move-object/from16 v0, v29

    iput v3, v0, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 967
    move-wide/from16 v0, v17

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->loops:J

    .line 968
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v30

    move-wide/from16 v0, v30

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->lastRefresh:J

    .line 969
    move-wide/from16 v0, v25

    move-object/from16 v2, v29

    iput-wide v0, v2, Lco/vine/android/api/VinePost;->velocity:D

    .line 970
    move/from16 v0, v19

    move-object/from16 v1, v29

    iput-boolean v0, v1, Lco/vine/android/api/VinePost;->onFire:Z

    .line 972
    return-object v29

    .line 965
    :cond_36
    const/4 v3, 0x0

    goto :goto_e

    .line 966
    :cond_37
    const/4 v3, 0x0

    goto :goto_f

    .line 764
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_8
        :pswitch_a
        :pswitch_9
        :pswitch_b
        :pswitch_b
    .end packed-switch

    .line 774
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_2
        :pswitch_2
        :pswitch_4
        :pswitch_1
        :pswitch_5
        :pswitch_5
        :pswitch_3
    .end packed-switch

    .line 812
    :pswitch_data_2
    .packed-switch 0x1
        :pswitch_6
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public static parsePrivateMessage(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePrivateMessage;
    .locals 29
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1987
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v28

    .line 1988
    .local v28, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const-wide/16 v4, 0x0

    .line 1989
    .local v4, "conversationId":J
    const-wide/16 v6, 0x0

    .line 1990
    .local v6, "messageId":J
    const-wide/16 v8, 0x0

    .line 1991
    .local v8, "userId":J
    const-wide/16 v10, 0x0

    .line 1992
    .local v10, "created":J
    const/4 v12, 0x0

    .line 1993
    .local v12, "message":Ljava/lang/String;
    const/4 v13, 0x0

    .line 1994
    .local v13, "videoUrl":Ljava/lang/String;
    const/4 v14, 0x0

    .line 1995
    .local v14, "thumbnailUrl":Ljava/lang/String;
    const/16 v17, 0x0

    .line 1996
    .local v17, "vanished":Z
    const/16 v21, 0x0

    .line 1997
    .local v21, "ephemeral":Z
    const/16 v24, 0x0

    .line 1998
    .local v24, "post":Lco/vine/android/api/VinePost;
    const v18, 0x7fffffff

    .line 1999
    .local v18, "maxLoops":I
    const-wide/16 v19, -0x1

    .line 2000
    .local v19, "vanishDate":J
    const/4 v15, 0x1

    .line 2002
    .local v15, "networkType":I
    :goto_0
    if-eqz v28, :cond_b

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v28

    if-eq v0, v1, :cond_b

    .line 2003
    sget-object v1, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v28 .. v28}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 2062
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v28

    goto :goto_0

    .line 2005
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2006
    .local v27, "name":Ljava/lang/String;
    const-string v1, "message"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2007
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v12

    goto :goto_1

    .line 2008
    :cond_1
    const-string v1, "videoUrl"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 2009
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v13

    goto :goto_1

    .line 2010
    :cond_2
    const-string v1, "thumbnailUrl"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2011
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v14

    goto :goto_1

    .line 2012
    :cond_3
    const-string v1, "created"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 2013
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static {v1, v2}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v10

    goto :goto_1

    .line 2014
    :cond_4
    const-string v1, "vanishedDate"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 2015
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss.SSSSSS"

    invoke-static {v1, v2}, Lco/vine/android/util/DateTimeUtil;->getTimeInMsFromString(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v19

    goto :goto_1

    .line 2016
    :cond_5
    const-string v1, "inbox"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2017
    const-string v1, "other"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2018
    const/4 v15, 0x2

    goto :goto_1

    .line 2024
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2025
    .restart local v27    # "name":Ljava/lang/String;
    const-string v1, "conversationId"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 2026
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v4

    goto/16 :goto_1

    .line 2027
    :cond_6
    const-string v1, "messageId"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 2028
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v6

    goto/16 :goto_1

    .line 2029
    :cond_7
    const-string v1, "userId"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 2030
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v8

    goto/16 :goto_1

    .line 2031
    :cond_8
    const-string v1, "maxLoops"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2032
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v18

    goto/16 :goto_1

    .line 2038
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2039
    .restart local v27    # "name":Ljava/lang/String;
    const-string v1, "vanished"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 2040
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v17

    goto/16 :goto_1

    .line 2041
    :cond_9
    const-string v1, "ephemeral"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2042
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v21

    goto/16 :goto_1

    .line 2047
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v27

    .line 2048
    .restart local v27    # "name":Ljava/lang/String;
    const-string v1, "post"

    move-object/from16 v0, v27

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 2049
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parsePost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePost;

    move-result-object v24

    .line 2050
    move-object/from16 v0, v24

    iget-object v13, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    .line 2051
    move-object/from16 v0, v24

    iget-object v14, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    goto/16 :goto_1

    .line 2053
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2058
    .end local v27    # "name":Ljava/lang/String;
    :pswitch_4
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2065
    :cond_b
    new-instance v1, Lco/vine/android/api/VinePrivateMessage;

    const-wide/16 v2, -0x1

    const/16 v16, 0x0

    const-wide/16 v22, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    invoke-direct/range {v1 .. v26}, Lco/vine/android/api/VinePrivateMessage;-><init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJLco/vine/android/api/VinePost;ILjava/lang/String;)V

    return-object v1

    .line 2003
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_4
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method private static parsePrivateMessageResponse(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;
    .locals 39
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2485
    new-instance v34, Ljava/util/ArrayList;

    invoke-direct/range {v34 .. v34}, Ljava/util/ArrayList;-><init>()V

    .line 2486
    .local v34, "responses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePrivateMessageResponse;>;"
    new-instance v33, Ljava/util/ArrayList;

    invoke-direct/range {v33 .. v33}, Ljava/util/ArrayList;-><init>()V

    .line 2487
    .local v33, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    const/16 v37, 0x0

    .line 2488
    .local v37, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/16 v31, 0x0

    .line 2489
    .local v31, "post":Lco/vine/android/api/VinePost;
    const/16 v24, 0x1

    .line 2491
    .local v24, "networkType":I
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v35

    .line 2492
    .local v35, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v35, :cond_13

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v35

    if-eq v0, v4, :cond_13

    .line 2493
    sget-object v4, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v35 .. v35}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v4, v4, v10

    packed-switch v4, :pswitch_data_0

    .line 2614
    :cond_0
    :goto_1
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v35

    goto :goto_0

    .line 2495
    :pswitch_1
    const-string v4, "inbox"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 2496
    const-string v4, "other"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getValueAsString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 2497
    const/16 v24, 0x2

    goto :goto_1

    .line 2503
    :pswitch_2
    const-string v4, "messages"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_11

    .line 2504
    :goto_2
    if-eqz v35, :cond_0

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v35

    if-eq v0, v4, :cond_0

    .line 2505
    sget-object v4, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v35 .. v35}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v4, v4, v10

    packed-switch v4, :pswitch_data_1

    .line 2600
    :goto_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v35

    goto :goto_2

    .line 2507
    :pswitch_3
    const/16 v23, 0x0

    .line 2508
    .local v23, "error":Lco/vine/android/api/VineError;
    const/16 v20, 0x0

    .line 2509
    .local v20, "videoUrl":Ljava/lang/String;
    const/16 v21, 0x0

    .line 2510
    .local v21, "thumbnailUrl":Ljava/lang/String;
    const/16 v22, 0x0

    .line 2511
    .local v22, "shareUrl":Ljava/lang/String;
    const/4 v7, 0x0

    .line 2512
    .local v7, "email":Ljava/lang/String;
    const/4 v13, 0x0

    .line 2513
    .local v13, "phone":Ljava/lang/String;
    const/16 v32, 0x0

    .line 2514
    .local v32, "recipientIdString":Ljava/lang/String;
    const/16 v38, 0x0

    .line 2515
    .local v38, "videoWebmUrl":Ljava/lang/String;
    const-wide/16 v25, 0x0

    .line 2516
    .local v25, "conversationId":J
    const-wide/16 v27, 0x0

    .line 2517
    .local v27, "messageId":J
    const-wide/16 v5, -0x1

    .line 2518
    .local v5, "userId":J
    :goto_4
    if-eqz v35, :cond_b

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v35

    if-eq v0, v4, :cond_b

    .line 2519
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v29

    .line 2520
    .local v29, "name":Ljava/lang/String;
    sget-object v4, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v35 .. v35}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v4, v4, v10

    packed-switch v4, :pswitch_data_2

    .line 2574
    :cond_1
    :goto_5
    :pswitch_4
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v35

    .line 2575
    goto :goto_4

    .line 2522
    :pswitch_5
    const-string v4, "videoUrl"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 2523
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v20

    goto :goto_5

    .line 2524
    :cond_2
    const-string v4, "thumbnailUrl"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 2525
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v21

    goto :goto_5

    .line 2526
    :cond_3
    const-string v4, "shareUrl"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 2527
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v22

    goto :goto_5

    .line 2528
    :cond_4
    const-string v4, "videoWebmUrl"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2529
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v38

    goto :goto_5

    .line 2534
    :pswitch_6
    const-string v4, "conversationId"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 2535
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v25

    goto :goto_5

    .line 2536
    :cond_5
    const-string v4, "messageId"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2537
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v27

    goto :goto_5

    .line 2542
    :pswitch_7
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v30

    .line 2543
    .local v30, "objName":Ljava/lang/String;
    const-string v4, "to"

    move-object/from16 v0, v30

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 2544
    :goto_6
    if-eqz v35, :cond_1

    sget-object v4, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v35

    if-eq v0, v4, :cond_1

    .line 2545
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v36

    .line 2546
    .local v36, "toName":Ljava/lang/String;
    sget-object v4, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v35 .. v35}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v4, v4, v10

    packed-switch v4, :pswitch_data_3

    .line 2564
    :cond_6
    :goto_7
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v35

    .line 2565
    goto :goto_6

    .line 2548
    :pswitch_8
    const-string v4, "email"

    move-object/from16 v0, v36

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 2549
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v7

    goto :goto_7

    .line 2550
    :cond_7
    const-string v4, "phoneNumber"

    move-object/from16 v0, v36

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 2551
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v13

    goto :goto_7

    .line 2552
    :cond_8
    const-string v4, "recipientId"

    move-object/from16 v0, v36

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 2553
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v32

    goto :goto_7

    .line 2558
    :pswitch_9
    const-string v4, "userId"

    move-object/from16 v0, v36

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 2559
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    goto :goto_7

    .line 2566
    .end local v36    # "toName":Ljava/lang/String;
    :cond_9
    const-string v4, "error"

    move-object/from16 v0, v30

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 2567
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parseMessageError(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineError;

    move-result-object v23

    goto/16 :goto_5

    .line 2568
    :cond_a
    const-string v4, "post"

    move-object/from16 v0, v30

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2569
    invoke-static/range {p0 .. p0}, Lco/vine/android/api/VineParsers;->parsePost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePost;

    move-result-object v31

    goto/16 :goto_5

    .line 2576
    .end local v29    # "name":Ljava/lang/String;
    .end local v30    # "objName":Ljava/lang/String;
    :cond_b
    const-wide/16 v8, -0x1

    .line 2577
    .local v8, "recipientId":J
    invoke-static/range {v32 .. v32}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_c

    .line 2578
    invoke-static/range {v32 .. v32}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    .line 2581
    :cond_c
    const/4 v15, 0x0

    .line 2582
    .local v15, "recipient":Lco/vine/android/api/VineRecipient;
    if-eqz v7, :cond_e

    .line 2583
    const/4 v4, 0x0

    invoke-static/range {v4 .. v9}, Lco/vine/android/api/VineRecipient;->fromEmail(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v15

    .line 2591
    :goto_8
    if-nez v20, :cond_d

    .line 2592
    move-object/from16 v20, v38

    .line 2594
    :cond_d
    move-object/from16 v0, v33

    invoke-virtual {v0, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2595
    new-instance v14, Lco/vine/android/api/VinePrivateMessageResponse;

    move-wide/from16 v16, v25

    move-wide/from16 v18, v27

    invoke-direct/range {v14 .. v24}, Lco/vine/android/api/VinePrivateMessageResponse;-><init>(Lco/vine/android/api/VineRecipient;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lco/vine/android/api/VineError;I)V

    move-object/from16 v0, v34

    invoke-virtual {v0, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_3

    .line 2584
    :cond_e
    if-eqz v13, :cond_f

    .line 2585
    const/4 v10, 0x0

    move-wide v11, v5

    move-wide v14, v8

    invoke-static/range {v10 .. v15}, Lco/vine/android/api/VineRecipient;->fromPhone(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v15

    goto :goto_8

    .line 2586
    :cond_f
    const-wide/16 v10, 0x0

    cmp-long v4, v5, v10

    if-lez v4, :cond_10

    .line 2587
    const/4 v14, 0x0

    const/16 v17, 0x0

    move-wide v15, v5

    move-wide/from16 v18, v8

    invoke-static/range {v14 .. v19}, Lco/vine/android/api/VineRecipient;->fromUser(Ljava/lang/String;JIJ)Lco/vine/android/api/VineRecipient;

    .end local v15    # "recipient":Lco/vine/android/api/VineRecipient;
    move-result-object v15

    .restart local v15    # "recipient":Lco/vine/android/api/VineRecipient;
    goto :goto_8

    .line 2589
    :cond_10
    const-string v4, "No email, phone, or userId for recipient for message {}"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static/range {v27 .. v28}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v4, v10}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_8

    .line 2602
    .end local v5    # "userId":J
    .end local v7    # "email":Ljava/lang/String;
    .end local v8    # "recipientId":J
    .end local v13    # "phone":Ljava/lang/String;
    .end local v15    # "recipient":Lco/vine/android/api/VineRecipient;
    .end local v20    # "videoUrl":Ljava/lang/String;
    .end local v21    # "thumbnailUrl":Ljava/lang/String;
    .end local v22    # "shareUrl":Ljava/lang/String;
    .end local v23    # "error":Lco/vine/android/api/VineError;
    .end local v25    # "conversationId":J
    .end local v27    # "messageId":J
    .end local v32    # "recipientIdString":Ljava/lang/String;
    .end local v38    # "videoWebmUrl":Ljava/lang/String;
    :cond_11
    const-string v4, "users"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_12

    .line 2603
    const/4 v4, 0x0

    move-object/from16 v0, p0

    invoke-static {v0, v4}, Lco/vine/android/api/VineParsers;->parseUsersArray(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;

    move-result-object v37

    goto/16 :goto_1

    .line 2605
    :cond_12
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2610
    :pswitch_a
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 2617
    :cond_13
    new-instance v4, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;

    move-object/from16 v0, v34

    move-object/from16 v1, v33

    move-object/from16 v2, v37

    move-object/from16 v3, v31

    invoke-direct {v4, v0, v1, v2, v3}, Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lco/vine/android/api/VinePost;)V

    return-object v4

    .line 2493
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_a
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 2505
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_3
    .end packed-switch

    .line 2520
    :pswitch_data_2
    .packed-switch 0x1
        :pswitch_7
        :pswitch_4
        :pswitch_6
        :pswitch_5
    .end packed-switch

    .line 2546
    :pswitch_data_3
    .packed-switch 0x3
        :pswitch_9
        :pswitch_8
    .end packed-switch
.end method

.method public static parsePushNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineSingleNotification;
    .locals 2
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1700
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v0, v1, :cond_0

    .line 1701
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseNotification(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineSingleNotification;

    move-result-object v0

    .line 1703
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseRTCConversations(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCConversation;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1743
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 1747
    .local v2, "conversations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 1748
    .local v4, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v4, :cond_0

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v5, :cond_0

    .line 1749
    sget-object v5, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v4}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 1761
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    goto :goto_0

    .line 1751
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 1752
    .local v0, "conversationId":J
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseRTCParticipants(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;

    move-result-object v3

    .line 1753
    .local v3, "participants":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCParticipant;>;"
    new-instance v5, Lco/vine/android/api/VineRTCConversation;

    invoke-direct {v5, v0, v1, v3}, Lco/vine/android/api/VineRTCConversation;-><init>(JLjava/util/ArrayList;)V

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1757
    .end local v0    # "conversationId":J
    .end local v3    # "participants":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCParticipant;>;"
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1764
    :cond_0
    return-object v2

    .line 1749
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseRTCEvent(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;
    .locals 4
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCConversation;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1708
    const/4 v0, 0x0

    .line 1710
    .local v0, "event":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCConversation;>;"
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 1711
    .local v1, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v1, :cond_2

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v2, :cond_2

    .line 1712
    sget-object v2, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1735
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    goto :goto_0

    .line 1714
    :pswitch_0
    const-string v2, "data"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1715
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    .line 1716
    :goto_2
    if-eqz v1, :cond_0

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v1, v2, :cond_0

    .line 1717
    sget-object v2, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_1

    .line 1725
    :cond_1
    :goto_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v1

    goto :goto_2

    .line 1719
    :pswitch_1
    const-string v2, "conversations"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1720
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseRTCConversations(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;

    move-result-object v0

    goto :goto_3

    .line 1731
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1738
    :cond_2
    return-object v0

    .line 1712
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
    .end packed-switch

    .line 1717
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_1
    .end packed-switch
.end method

.method public static parseRTCParticipants(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;
    .locals 11
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineRTCParticipant;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1769
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 1771
    .local v8, "participants":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRTCParticipant;>;"
    const/4 v3, 0x0

    .line 1772
    .local v3, "connected":Z
    const/4 v4, 0x0

    .line 1773
    .local v4, "typing":Z
    const-wide/16 v5, -0x1

    .line 1775
    .local v5, "lastMessageId":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 1776
    .local v9, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v9, :cond_3

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v0, :cond_3

    .line 1777
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v9}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v0, v0, v10

    packed-switch v0, :pswitch_data_0

    .line 1811
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    goto :goto_0

    .line 1779
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v1

    .line 1780
    .local v1, "userId":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    .line 1781
    :goto_2
    if-eqz v9, :cond_2

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v9, v0, :cond_2

    .line 1782
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v9}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v10

    aget v0, v0, v10

    packed-switch v0, :pswitch_data_1

    .line 1800
    :cond_0
    :goto_3
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v9

    goto :goto_2

    .line 1784
    :pswitch_2
    const-string v0, "last_message_id"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1785
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v5

    goto :goto_3

    .line 1791
    :pswitch_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v7

    .line 1792
    .local v7, "cn":Ljava/lang/String;
    const-string v0, "connected"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1793
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v3

    goto :goto_3

    .line 1794
    :cond_1
    const-string v0, "typing"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1795
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v4

    goto :goto_3

    .line 1802
    .end local v7    # "cn":Ljava/lang/String;
    :cond_2
    new-instance v0, Lco/vine/android/api/VineRTCParticipant;

    invoke-direct/range {v0 .. v6}, Lco/vine/android/api/VineRTCParticipant;-><init>(JZZJ)V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1807
    .end local v1    # "userId":J
    :pswitch_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1814
    :cond_3
    return-object v8

    .line 1777
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_4
    .end packed-switch

    .line 1782
    :pswitch_data_1
    .packed-switch 0x3
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method private static parseRepost(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineRepost;
    .locals 18
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 660
    const/4 v2, 0x0

    .line 661
    .local v2, "username":Ljava/lang/String;
    const/4 v3, 0x0

    .line 662
    .local v3, "avatarUrl":Ljava/lang/String;
    const/4 v4, 0x0

    .line 663
    .local v4, "location":Ljava/lang/String;
    const/4 v5, 0x0

    .line 664
    .local v5, "description":Ljava/lang/String;
    const-wide/16 v6, 0x0

    .line 665
    .local v6, "userId":J
    const-wide/16 v8, 0x0

    .line 666
    .local v8, "postId":J
    const-wide/16 v10, 0x0

    .line 667
    .local v10, "repostId":J
    const/4 v12, 0x0

    .line 668
    .local v12, "verified":I
    const/4 v13, 0x0

    .line 669
    .local v13, "priv":I
    const/4 v14, 0x0

    .line 671
    .local v14, "unflaggable":I
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v16

    .line 673
    .local v16, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v16, :cond_a

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v16

    if-eq v0, v1, :cond_a

    .line 674
    sget-object v1, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v16 .. v16}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v17

    aget v1, v1, v17

    packed-switch v1, :pswitch_data_0

    .line 732
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v16

    goto :goto_0

    .line 676
    :pswitch_0
    const-string v1, "user"

    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 677
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v16

    .line 678
    :goto_2
    if-eqz v16, :cond_0

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v16

    if-eq v0, v1, :cond_0

    .line 679
    sget-object v1, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v16 .. v16}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v17

    aget v1, v1, v17

    packed-switch v1, :pswitch_data_1

    .line 712
    :cond_1
    :goto_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v16

    goto :goto_2

    .line 681
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v15

    .line 682
    .local v15, "cn":Ljava/lang/String;
    const-string v1, "description"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 683
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    .line 684
    :cond_2
    const-string v1, "avatarUrl"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 685
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_3

    .line 686
    :cond_3
    const-string v1, "location"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 687
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_3

    .line 688
    :cond_4
    const-string v1, "username"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 689
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_3

    .line 694
    .end local v15    # "cn":Ljava/lang/String;
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v15

    .line 695
    .restart local v15    # "cn":Ljava/lang/String;
    const-string v1, "verified"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 696
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v12

    goto :goto_3

    .line 697
    :cond_5
    const-string v1, "private"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 698
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v13

    goto :goto_3

    .line 699
    :cond_6
    const-string v1, "unflaggable"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 700
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v14

    goto :goto_3

    .line 701
    :cond_7
    const-string v1, "userId"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 702
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v6

    goto :goto_3

    .line 708
    .end local v15    # "cn":Ljava/lang/String;
    :pswitch_3
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_3

    .line 715
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 720
    :pswitch_4
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v15

    .line 721
    .restart local v15    # "cn":Ljava/lang/String;
    const-string v1, "repostId"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 722
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v10

    goto/16 :goto_1

    .line 723
    :cond_9
    const-string v1, "postId"

    invoke-virtual {v1, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 724
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v8

    goto/16 :goto_1

    .line 729
    .end local v15    # "cn":Ljava/lang/String;
    :pswitch_5
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 735
    :cond_a
    new-instance v1, Lco/vine/android/api/VineRepost;

    invoke-direct/range {v1 .. v14}, Lco/vine/android/api/VineRepost;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJIII)V

    return-object v1

    .line 674
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_5
        :pswitch_4
    .end packed-switch

    .line 679
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_3
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static parseRepostResponse(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;
    .locals 9
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 332
    const-wide/16 v3, 0x0

    .line 333
    .local v3, "repostId":J
    const-wide/16 v1, 0x0

    .line 335
    .local v1, "postId":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    .line 336
    .local v5, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v5, :cond_2

    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v5, v7, :cond_2

    .line 337
    sget-object v7, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v5}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 353
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    goto :goto_0

    .line 339
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 340
    .local v0, "cn":Ljava/lang/String;
    const-string v7, "repostId"

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 341
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto :goto_1

    .line 342
    :cond_1
    const-string v7, "postId"

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 343
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v1

    goto :goto_1

    .line 349
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 356
    :cond_2
    new-instance v6, Lco/vine/android/api/VineRepost;

    invoke-direct {v6}, Lco/vine/android/api/VineRepost;-><init>()V

    .line 357
    .local v6, "vr":Lco/vine/android/api/VineRepost;
    iput-wide v3, v6, Lco/vine/android/api/VineRepost;->repostId:J

    .line 358
    iput-wide v1, v6, Lco/vine/android/api/VineRepost;->postId:J

    .line 359
    return-object v6

    .line 337
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseServerStatus(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/ServerStatus;
    .locals 9
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2379
    const/4 v1, 0x0

    .line 2380
    .local v1, "uploadType":Ljava/lang/String;
    const/4 v2, 0x0

    .line 2381
    .local v2, "status":Ljava/lang/String;
    const/4 v3, 0x0

    .line 2382
    .local v3, "message":Ljava/lang/String;
    const/4 v4, 0x0

    .line 2383
    .local v4, "title":Ljava/lang/String;
    const/4 v5, 0x0

    .line 2384
    .local v5, "staticTimelineUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v7

    .line 2385
    .local v7, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v7, :cond_4

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v7, v0, :cond_4

    .line 2386
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v7}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v8

    aget v0, v0, v8

    packed-switch v0, :pswitch_data_0

    .line 2406
    :cond_0
    :goto_1
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v7

    goto :goto_0

    .line 2389
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 2393
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v6

    .line 2394
    .local v6, "cn":Ljava/lang/String;
    const-string v0, "uploadType"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2395
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 2396
    :cond_1
    const-string v0, "status"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2397
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 2398
    :cond_2
    const-string v0, "message"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2399
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2400
    :cond_3
    const-string v0, "staticTimelineUrl"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2401
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 2408
    .end local v6    # "cn":Ljava/lang/String;
    :cond_4
    new-instance v0, Lco/vine/android/api/ServerStatus;

    invoke-direct/range {v0 .. v5}, Lco/vine/android/api/ServerStatus;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    .line 2386
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private static parseSignUp(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLogin;
    .locals 8
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1421
    const-wide/16 v3, 0x0

    .line 1422
    .local v3, "userId":J
    const/4 v5, 0x0

    .line 1423
    .local v5, "edition":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v6

    .line 1425
    .local v6, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v1, 0x0

    .line 1426
    .local v1, "sessionKey":Ljava/lang/String;
    :goto_0
    if-eqz v6, :cond_2

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v6, v2, :cond_2

    .line 1427
    sget-object v2, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v6}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v7

    aget v2, v2, v7

    packed-switch v2, :pswitch_data_0

    .line 1449
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v6

    goto :goto_0

    .line 1429
    :pswitch_0
    const-string v2, "userId"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1430
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto :goto_1

    .line 1435
    :pswitch_1
    const-string v2, "key"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1436
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 1437
    :cond_1
    const-string v2, "edition"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1438
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 1443
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    .line 1446
    :pswitch_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1452
    :cond_2
    new-instance v0, Lco/vine/android/api/VineLogin;

    const/4 v2, 0x0

    invoke-direct/range {v0 .. v5}, Lco/vine/android/api/VineLogin;-><init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V

    .line 1453
    .local v0, "vl":Lco/vine/android/api/VineLogin;
    return-object v0

    .line 1427
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private static parseTag(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineTag;
    .locals 4
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1044
    new-instance v1, Lco/vine/android/api/VineTag;

    invoke-direct {v1}, Lco/vine/android/api/VineTag;-><init>()V

    .line 1045
    .local v1, "tag":Lco/vine/android/api/VineTag;
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 1046
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v0, :cond_0

    sget-object v2, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v2, :cond_0

    .line 1047
    sget-object v2, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1060
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 1049
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lco/vine/android/api/VineTag;->tagName:Ljava/lang/String;

    goto :goto_1

    .line 1052
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v2

    iput-wide v2, v1, Lco/vine/android/api/VineTag;->tagId:J

    goto :goto_1

    .line 1056
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 1062
    :cond_0
    return-object v1

    .line 1047
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseTags(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;
    .locals 7
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 976
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 977
    .local v4, "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineTag;>;"
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 978
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    const/4 v3, 0x0

    .line 979
    .local v3, "tagName":Ljava/lang/String;
    const-wide/16 v1, 0x0

    .line 980
    .local v1, "tagId":J
    :goto_0
    if-eqz v0, :cond_1

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v5, :cond_1

    .line 981
    sget-object v5, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 997
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_0

    .line 983
    :goto_2
    :pswitch_0
    if-eqz v0, :cond_0

    sget-object v5, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v5, :cond_0

    .line 984
    sget-object v5, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_1

    .line 992
    :goto_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_2

    .line 986
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    .line 987
    goto :goto_3

    .line 989
    :pswitch_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v1

    goto :goto_3

    .line 994
    :cond_0
    new-instance v5, Lco/vine/android/api/VineTag;

    invoke-direct {v5, v3, v1, v2}, Lco/vine/android/api/VineTag;-><init>(Ljava/lang/String;J)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 999
    :cond_1
    return-object v4

    .line 981
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    .line 984
    :pswitch_data_1
    .packed-switch 0x3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public static parseTwitterUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/TwitterUser;
    .locals 13
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1465
    const/4 v1, 0x0

    .line 1466
    .local v1, "name":Ljava/lang/String;
    const/4 v2, 0x0

    .line 1467
    .local v2, "screenName":Ljava/lang/String;
    const/4 v3, 0x0

    .line 1468
    .local v3, "location":Ljava/lang/String;
    const/4 v4, 0x0

    .line 1469
    .local v4, "description":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1470
    .local v5, "url":Ljava/lang/String;
    const/4 v6, 0x0

    .line 1471
    .local v6, "profileUrl":Ljava/lang/String;
    const/4 v7, 0x0

    .line 1472
    .local v7, "defaultProfileImage":Z
    const-wide/16 v8, 0x0

    .line 1474
    .local v8, "userId":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v11

    .line 1475
    .local v11, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v11, :cond_6

    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v11, v0, :cond_6

    .line 1476
    sget-object v0, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v11}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v12

    aget v0, v0, v12

    packed-switch v0, :pswitch_data_0

    .line 1520
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v11

    goto :goto_0

    .line 1478
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v10

    .line 1479
    .local v10, "cn":Ljava/lang/String;
    const-string v0, "name"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1480
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 1481
    :cond_1
    const-string v0, "screen_name"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1482
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    .line 1483
    :cond_2
    const-string v0, "profile_image_url"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1484
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    .line 1485
    const-string v0, "_normal"

    const-string v12, "_bigger"

    invoke-virtual {v6, v0, v12}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 1486
    :cond_3
    const-string v0, "url"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1487
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 1488
    :cond_4
    const-string v0, "description"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1489
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 1490
    :cond_5
    const-string v0, "location"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1491
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 1496
    .end local v10    # "cn":Ljava/lang/String;
    :pswitch_1
    const-string v0, "id"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1497
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v8

    goto :goto_1

    .line 1503
    :pswitch_2
    const-string v0, "default_profile_image"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1504
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getBooleanValue()Z

    move-result v7

    goto :goto_1

    .line 1509
    :pswitch_3
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 1513
    :pswitch_4
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 1522
    :cond_6
    new-instance v0, Lco/vine/android/api/TwitterUser;

    invoke-direct/range {v0 .. v9}, Lco/vine/android/api/TwitterUser;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V

    return-object v0

    .line 1476
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_4
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method private static parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;
    .locals 1
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1259
    const/4 v0, -0x1

    invoke-static {p0, v0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;I)Lco/vine/android/api/VineUser;

    move-result-object v0

    return-object v0
.end method

.method private static parseUser(Lcom/fasterxml/jackson/core/JsonParser;I)Lco/vine/android/api/VineUser;
    .locals 44
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p1, "sectionId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1263
    const/4 v3, 0x0

    .line 1264
    .local v3, "username":Ljava/lang/String;
    const/4 v4, 0x0

    .line 1265
    .local v4, "avatarUrl":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1266
    .local v5, "description":Ljava/lang/String;
    const/4 v6, 0x0

    .line 1267
    .local v6, "location":Ljava/lang/String;
    const/16 v21, 0x0

    .line 1268
    .local v21, "phoneNumber":Ljava/lang/String;
    const/16 v20, 0x0

    .line 1269
    .local v20, "email":Ljava/lang/String;
    const/16 v26, 0x0

    .line 1270
    .local v26, "edition":Ljava/lang/String;
    const/16 v30, 0x0

    .line 1271
    .local v30, "sectionTitle":Ljava/lang/String;
    const-wide/16 v7, 0x0

    .line 1272
    .local v7, "userId":J
    const-wide/16 v9, 0x0

    .line 1273
    .local v9, "orderId":J
    const/4 v11, 0x0

    .line 1274
    .local v11, "blocked":I
    const/4 v12, 0x0

    .line 1275
    .local v12, "blocking":I
    const/4 v13, 0x0

    .line 1276
    .local v13, "explicit":I
    const/4 v14, 0x0

    .line 1277
    .local v14, "followerCount":I
    const/4 v15, 0x0

    .line 1278
    .local v15, "followingCount":I
    const/16 v16, -0x1

    .line 1279
    .local v16, "following":I
    const/16 v17, 0x0

    .line 1280
    .local v17, "likeCount":I
    const/16 v29, 0x0

    .line 1281
    .local v29, "authoredPostCount":I
    const/16 v18, 0x0

    .line 1282
    .local v18, "postCount":I
    const/16 v19, 0x0

    .line 1283
    .local v19, "verified":I
    const/16 v22, 0x0

    .line 1284
    .local v22, "twitterConnected":I
    const/16 v23, 0x0

    .line 1285
    .local v23, "includePromoted":I
    const/16 v24, 0x0

    .line 1286
    .local v24, "privateAccount":I
    const/16 v37, 0x0

    .line 1287
    .local v37, "followApprovalPending":Z
    const/16 v38, 0x0

    .line 1288
    .local v38, "followRequested":Z
    const/16 v25, 0x1

    .line 1289
    .local v25, "repostsEnabled":I
    const/16 v27, 0x0

    .line 1290
    .local v27, "acceptsOutOfNetworkConversations":Z
    const/16 v28, -0x1

    .line 1291
    .local v28, "profileBackground":I
    const/16 v36, 0x0

    .line 1292
    .local v36, "emailVerified":Z
    const/16 v40, 0x0

    .line 1293
    .local v40, "phoneVerified":Z
    const/16 v31, 0x0

    .line 1294
    .local v31, "disableAddressBook":Z
    const/16 v32, 0x0

    .line 1295
    .local v32, "hiddenEmail":Z
    const/16 v33, 0x0

    .line 1296
    .local v33, "hiddenPhoneNumber":Z
    const-wide/16 v34, 0x0

    .line 1298
    .local v34, "loopCount":J
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v41

    .line 1300
    .local v41, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v41, :cond_2a

    sget-object v42, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    move-object/from16 v0, v41

    move-object/from16 v1, v42

    if-eq v0, v1, :cond_2a

    .line 1301
    sget-object v42, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual/range {v41 .. v41}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v43

    aget v42, v42, v43

    packed-switch v42, :pswitch_data_0

    .line 1390
    :cond_0
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v41

    goto :goto_0

    .line 1303
    :pswitch_0
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v39

    .line 1304
    .local v39, "name":Ljava/lang/String;
    const-string v42, "avatarUrl"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_1

    .line 1305
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 1306
    :cond_1
    const-string v42, "username"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_2

    .line 1307
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 1308
    :cond_2
    const-string v42, "description"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_3

    .line 1309
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_1

    .line 1310
    :cond_3
    const-string v42, "location"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_4

    .line 1311
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 1312
    :cond_4
    const-string v42, "phoneNumber"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_5

    .line 1313
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v21

    goto :goto_1

    .line 1314
    :cond_5
    const-string v42, "email"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_6

    .line 1315
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v20

    goto :goto_1

    .line 1316
    :cond_6
    const-string v42, "edition"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_7

    .line 1317
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v26

    goto :goto_1

    .line 1318
    :cond_7
    const-string v42, "profileBackground"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_8

    .line 1319
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v42

    const/16 v43, 0x2

    invoke-virtual/range {v42 .. v43}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v42

    const/16 v43, 0x10

    invoke-static/range {v42 .. v43}, Ljava/lang/Long;->parseLong(Ljava/lang/String;I)J

    move-result-wide v42

    move-wide/from16 v0, v42

    long-to-int v0, v0

    move/from16 v28, v0

    goto/16 :goto_1

    .line 1320
    :cond_8
    const-string v42, "section"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_0

    .line 1321
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getText()Ljava/lang/String;

    move-result-object v30

    goto/16 :goto_1

    .line 1326
    .end local v39    # "name":Ljava/lang/String;
    :pswitch_1
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v39

    .line 1327
    .restart local v39    # "name":Ljava/lang/String;
    const-string v42, "userId"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_9

    .line 1328
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v7

    goto/16 :goto_1

    .line 1329
    :cond_9
    const-string v42, "blocked"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_a

    .line 1330
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v11

    goto/16 :goto_1

    .line 1331
    :cond_a
    const-string v42, "blocking"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_b

    .line 1332
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v12

    goto/16 :goto_1

    .line 1333
    :cond_b
    const-string v42, "explicit"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_c

    .line 1334
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v13

    goto/16 :goto_1

    .line 1335
    :cond_c
    const-string v42, "followerCount"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_d

    .line 1336
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v14

    goto/16 :goto_1

    .line 1337
    :cond_d
    const-string v42, "followingCount"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_e

    .line 1338
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v15

    goto/16 :goto_1

    .line 1339
    :cond_e
    const-string v42, "following"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_f

    .line 1340
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v16

    goto/16 :goto_1

    .line 1341
    :cond_f
    const-string v42, "likeCount"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_10

    .line 1342
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v17

    goto/16 :goto_1

    .line 1343
    :cond_10
    const-string v42, "authoredPostCount"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_11

    .line 1344
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v29

    goto/16 :goto_1

    .line 1345
    :cond_11
    const-string v42, "postCount"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_12

    .line 1346
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v18

    goto/16 :goto_1

    .line 1347
    :cond_12
    const-string v42, "verified"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_13

    .line 1348
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v19

    goto/16 :goto_1

    .line 1349
    :cond_13
    const-string v42, "followId"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_14

    .line 1350
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v9

    goto/16 :goto_1

    .line 1351
    :cond_14
    const-string v42, "twitterConnected"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_15

    .line 1352
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v22

    goto/16 :goto_1

    .line 1353
    :cond_15
    const-string v42, "includePromoted"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_16

    .line 1354
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v23

    goto/16 :goto_1

    .line 1355
    :cond_16
    const-string v42, "private"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_17

    .line 1356
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v24

    goto/16 :goto_1

    .line 1357
    :cond_17
    const-string v42, "followApprovalPending"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_19

    .line 1358
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_18

    const/16 v37, 0x1

    :goto_2
    goto/16 :goto_1

    :cond_18
    const/16 v37, 0x0

    goto :goto_2

    .line 1359
    :cond_19
    const-string v42, "followRequested"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_1b

    .line 1360
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_1a

    const/16 v38, 0x1

    :goto_3
    goto/16 :goto_1

    :cond_1a
    const/16 v38, 0x0

    goto :goto_3

    .line 1361
    :cond_1b
    const-string v42, "repostsEnabled"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_1c

    .line 1362
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v25

    goto/16 :goto_1

    .line 1363
    :cond_1c
    const-string v42, "verifiedEmail"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_1e

    .line 1364
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_1d

    const/16 v36, 0x1

    :goto_4
    goto/16 :goto_1

    :cond_1d
    const/16 v36, 0x0

    goto :goto_4

    .line 1365
    :cond_1e
    const-string v42, "verifiedPhoneNumber"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_20

    .line 1366
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_1f

    const/16 v40, 0x1

    :goto_5
    goto/16 :goto_1

    :cond_1f
    const/16 v40, 0x0

    goto :goto_5

    .line 1367
    :cond_20
    const-string v42, "sectionId"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_21

    .line 1368
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result p1

    goto/16 :goto_1

    .line 1369
    :cond_21
    const-string v42, "disableAddressBook"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_23

    .line 1370
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_22

    const/16 v31, 0x1

    :goto_6
    goto/16 :goto_1

    :cond_22
    const/16 v31, 0x0

    goto :goto_6

    .line 1371
    :cond_23
    const-string v42, "acceptsOutOfNetworkConversations"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_25

    .line 1372
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_24

    const/16 v27, 0x1

    :goto_7
    goto/16 :goto_1

    :cond_24
    const/16 v27, 0x0

    goto :goto_7

    .line 1373
    :cond_25
    const-string v42, "hiddenEmail"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_27

    .line 1374
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_26

    const/16 v32, 0x1

    :goto_8
    goto/16 :goto_1

    :cond_26
    const/16 v32, 0x0

    goto :goto_8

    .line 1375
    :cond_27
    const-string v42, "hiddenPhoneNumber"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_29

    .line 1376
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v42

    const/16 v43, 0x1

    move/from16 v0, v42

    move/from16 v1, v43

    if-ne v0, v1, :cond_28

    const/16 v33, 0x1

    :goto_9
    goto/16 :goto_1

    :cond_28
    const/16 v33, 0x0

    goto :goto_9

    .line 1377
    :cond_29
    const-string v42, "loopCount"

    move-object/from16 v0, v42

    move-object/from16 v1, v39

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v42

    if-eqz v42, :cond_0

    .line 1378
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v34

    goto/16 :goto_1

    .line 1384
    .end local v39    # "name":Ljava/lang/String;
    :pswitch_2
    invoke-virtual/range {p0 .. p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_1

    .line 1393
    :cond_2a
    const-wide/16 v42, 0x0

    cmp-long v42, v7, v42

    if-gtz v42, :cond_2c

    .line 1394
    const/4 v2, 0x0

    .line 1416
    :cond_2b
    :goto_a
    return-object v2

    .line 1397
    :cond_2c
    new-instance v2, Lco/vine/android/api/VineUser;

    invoke-direct/range {v2 .. v35}, Lco/vine/android/api/VineUser;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIIIIIIIIILjava/lang/String;Ljava/lang/String;IIIILjava/lang/String;ZIILjava/lang/String;ZZZJ)V

    .line 1403
    .local v2, "u":Lco/vine/android/api/VineUser;
    move/from16 v0, p1

    iput v0, v2, Lco/vine/android/api/VineUser;->sectionId:I

    .line 1404
    if-eqz v37, :cond_2d

    .line 1405
    invoke-virtual {v2}, Lco/vine/android/api/VineUser;->setApprovalPending()V

    .line 1407
    :cond_2d
    if-eqz v38, :cond_2e

    .line 1408
    invoke-virtual {v2}, Lco/vine/android/api/VineUser;->setFollowRequested()V

    .line 1410
    :cond_2e
    if-eqz v36, :cond_2f

    .line 1411
    invoke-virtual {v2}, Lco/vine/android/api/VineUser;->setEmailVerified()V

    .line 1413
    :cond_2f
    if-eqz v40, :cond_2b

    .line 1414
    invoke-virtual {v2}, Lco/vine/android/api/VineUser;->setPhoneVerified()V

    goto :goto_a

    .line 1301
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseUsersArray(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;
    .locals 12
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p1, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/fasterxml/jackson/core/JsonParser;",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v11, 0x20

    .line 1223
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    .line 1224
    .local v4, "t":Lcom/fasterxml/jackson/core/JsonToken;
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 1225
    .local v6, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    const/4 v2, -0x1

    .line 1226
    .local v2, "sectionId":I
    const/4 v3, 0x0

    .line 1228
    .local v3, "sectionIndex":I
    if-eqz p1, :cond_0

    .line 1229
    const-string v7, "friend_index"

    const-wide/16 v8, -0x1

    invoke-virtual {p1, v7, v8, v9}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    .line 1230
    .local v0, "lastIndex":J
    const-wide/16 v7, 0x0

    cmp-long v7, v0, v7

    if-ltz v7, :cond_0

    .line 1231
    shr-long v7, v0, v11

    long-to-int v2, v7

    .line 1232
    int-to-long v7, v2

    shl-long/2addr v7, v11

    sub-long v7, v0, v7

    const-wide/16 v9, 0x1

    add-long/2addr v7, v9

    long-to-int v3, v7

    .line 1236
    .end local v0    # "lastIndex":J
    :cond_0
    :goto_0
    if-eqz v4, :cond_4

    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->END_ARRAY:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v4, v7, :cond_4

    .line 1237
    sget-object v7, Lcom/fasterxml/jackson/core/JsonToken;->START_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-ne v4, v7, :cond_2

    .line 1238
    invoke-static {p0, v2}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;I)Lco/vine/android/api/VineUser;

    move-result-object v5

    .line 1239
    .local v5, "user":Lco/vine/android/api/VineUser;
    iget v7, v5, Lco/vine/android/api/VineUser;->sectionId:I

    if-ltz v7, :cond_1

    .line 1240
    iget v7, v5, Lco/vine/android/api/VineUser;->sectionId:I

    if-eq v2, v7, :cond_3

    .line 1241
    iget v7, v5, Lco/vine/android/api/VineUser;->sectionId:I

    int-to-long v7, v7

    shl-long/2addr v7, v11

    iput-wide v7, v5, Lco/vine/android/api/VineUser;->friendIndex:J

    .line 1242
    const/4 v3, 0x1

    .line 1243
    iget v2, v5, Lco/vine/android/api/VineUser;->sectionId:I

    .line 1249
    :cond_1
    :goto_1
    if-eqz v5, :cond_2

    .line 1250
    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1253
    .end local v5    # "user":Lco/vine/android/api/VineUser;
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v4

    goto :goto_0

    .line 1245
    .restart local v5    # "user":Lco/vine/android/api/VineUser;
    :cond_3
    iget v7, v5, Lco/vine/android/api/VineUser;->sectionId:I

    int-to-long v7, v7

    shl-long/2addr v7, v11

    int-to-long v9, v3

    add-long/2addr v7, v9

    iput-wide v7, v5, Lco/vine/android/api/VineUser;->friendIndex:J

    .line 1246
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 1255
    .end local v5    # "user":Lco/vine/android/api/VineUser;
    :cond_4
    return-object v6
.end method

.method private static parseVinePostResponse(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePostResponse;
    .locals 8
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2459
    const-wide/16 v3, 0x0

    .line 2460
    .local v3, "postId":J
    const-wide/16 v1, 0x0

    .line 2461
    .local v1, "createdAt":J
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    .line 2462
    .local v5, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_0
    if-eqz v5, :cond_2

    sget-object v6, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v5, v6, :cond_2

    .line 2463
    sget-object v6, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v5}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v7

    aget v6, v6, v7

    packed-switch v6, :pswitch_data_0

    .line 2479
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v5

    goto :goto_0

    .line 2465
    :pswitch_0
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v0

    .line 2466
    .local v0, "cn":Ljava/lang/String;
    const-string v6, "postId"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2467
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v3

    goto :goto_1

    .line 2468
    :cond_1
    const-string v6, "createdAt"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 2469
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getLongValue()J

    move-result-wide v1

    goto :goto_1

    .line 2475
    .end local v0    # "cn":Ljava/lang/String;
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_1

    .line 2481
    :cond_2
    new-instance v6, Lco/vine/android/api/VinePostResponse;

    invoke-direct {v6, v3, v4, v1, v2}, Lco/vine/android/api/VinePostResponse;-><init>(JJ)V

    return-object v6

    .line 2463
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static parseVineResponse(Lcom/fasterxml/jackson/core/JsonParser;ILandroid/os/Bundle;)Ljava/lang/Object;
    .locals 4
    .param p0, "p"    # Lcom/fasterxml/jackson/core/JsonParser;
    .param p1, "type"    # I
    .param p2, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 155
    const/16 v1, 0x10

    if-ne p1, v1, :cond_0

    .line 156
    const/4 v1, 0x0

    .line 270
    :goto_0
    return-object v1

    .line 158
    :cond_0
    const/16 v1, 0xf

    if-ne p1, v1, :cond_1

    .line 159
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseServerStatus(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/ServerStatus;

    move-result-object v1

    goto :goto_0

    .line 161
    :cond_1
    const/4 v1, 0x1

    if-ne p1, v1, :cond_2

    .line 162
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseGeneral(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 165
    :cond_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    .line 166
    .local v0, "t":Lcom/fasterxml/jackson/core/JsonToken;
    :goto_1
    if-eqz v0, :cond_4

    sget-object v1, Lcom/fasterxml/jackson/core/JsonToken;->END_OBJECT:Lcom/fasterxml/jackson/core/JsonToken;

    if-eq v0, v1, :cond_4

    .line 167
    sget-object v1, Lco/vine/android/api/VineParsers$13;->$SwitchMap$com$fasterxml$jackson$core$JsonToken:[I

    invoke-virtual {v0}, Lcom/fasterxml/jackson/core/JsonToken;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 277
    :cond_3
    :goto_2
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->nextToken()Lcom/fasterxml/jackson/core/JsonToken;

    move-result-object v0

    goto :goto_1

    .line 169
    :pswitch_0
    const-string v1, "data"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 170
    packed-switch p1, :pswitch_data_1

    .line 241
    :pswitch_1
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto :goto_2

    .line 172
    :pswitch_2
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseUser(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineUser;

    move-result-object v1

    goto :goto_0

    .line 175
    :pswitch_3
    sget-object v1, Lco/vine/android/api/VineParsers;->USERS_PARSER:Lco/vine/android/api/VineParsers$RecordListParser;

    invoke-static {p0, v1, p2}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;Landroid/os/Bundle;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto :goto_0

    .line 178
    :pswitch_4
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseClientProfile(Lcom/fasterxml/jackson/core/JsonParser;)Lorg/json/JSONObject;

    move-result-object v1

    goto :goto_0

    .line 181
    :pswitch_5
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseSignUp(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLogin;

    move-result-object v1

    goto :goto_0

    .line 184
    :pswitch_6
    sget-object v1, Lco/vine/android/api/VineParsers;->COMMENT_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto :goto_0

    .line 187
    :pswitch_7
    sget-object v1, Lco/vine/android/api/VineParsers;->POST_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto :goto_0

    .line 190
    :pswitch_8
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseComment(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineComment;

    move-result-object v1

    goto :goto_0

    .line 193
    :pswitch_9
    sget-object v1, Lco/vine/android/api/VineParsers;->ACTIVITY_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto :goto_0

    .line 196
    :pswitch_a
    sget-object v1, Lco/vine/android/api/VineParsers;->GROUPED_ACTIVITY_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto :goto_0

    .line 199
    :pswitch_b
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseLikeId(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Long;

    move-result-object v1

    goto :goto_0

    .line 202
    :pswitch_c
    sget-object v1, Lco/vine/android/api/VineParsers;->LIKES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto/16 :goto_0

    .line 205
    :pswitch_d
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseVinePostResponse(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePostResponse;

    move-result-object v1

    goto/16 :goto_0

    .line 208
    :pswitch_e
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parsePrivateMessageResponse(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePrivateMessagePostResponseWithUsers;

    move-result-object v1

    goto/16 :goto_0

    .line 211
    :pswitch_f
    sget-object v1, Lco/vine/android/api/VineParsers;->TAG_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto/16 :goto_0

    .line 214
    :pswitch_10
    sget-object v1, Lco/vine/android/api/VineParsers;->CHANNELS_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto/16 :goto_0

    .line 217
    :pswitch_11
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseRepostResponse(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;

    move-result-object v1

    goto/16 :goto_0

    .line 220
    :pswitch_12
    sget-object v1, Lco/vine/android/api/VineParsers;->CONVERSATIONS_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    sget-object v2, Lco/vine/android/api/VineParsers;->USER_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1, v2}, Lco/vine/android/api/VineParsers;->parsePagedInbox(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$RecordParser;Lco/vine/android/api/VineParsers$RecordParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto/16 :goto_0

    .line 223
    :pswitch_13
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parsePrivateMessage(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VinePrivateMessage;

    move-result-object v1

    goto/16 :goto_0

    .line 226
    :pswitch_14
    sget-object v1, Lco/vine/android/api/VineParsers;->MESSAGES_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedConversation(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$RecordParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto/16 :goto_0

    .line 229
    :pswitch_15
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseActivityCounts(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineActivityCounts;

    move-result-object v1

    goto/16 :goto_0

    .line 232
    :pswitch_16
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseLoopsSubmission(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineLoopSubmissionResponse;

    move-result-object v1

    goto/16 :goto_0

    .line 235
    :pswitch_17
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseClientFlags(Lcom/fasterxml/jackson/core/JsonParser;)Lco/vine/android/api/VineClientFlags;

    move-result-object v1

    goto/16 :goto_0

    .line 238
    :pswitch_18
    sget-object v1, Lco/vine/android/api/VineParsers;->NOTIFICATION_SETTING_PARSER:Lco/vine/android/api/VineParsers$RecordParser;

    invoke-static {p0, v1}, Lco/vine/android/api/VineParsers;->parsePagedData(Lcom/fasterxml/jackson/core/JsonParser;Lco/vine/android/api/VineParsers$PagedDataParser;)Lco/vine/android/api/VinePagedData;

    move-result-object v1

    goto/16 :goto_0

    .line 248
    :pswitch_19
    const-string v1, "data"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 249
    sparse-switch p1, :sswitch_data_0

    .line 260
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->skipChildren()Lcom/fasterxml/jackson/core/JsonParser;

    goto/16 :goto_2

    .line 251
    :sswitch_0
    invoke-static {p0, p2}, Lco/vine/android/api/VineParsers;->parseUsersArray(Lcom/fasterxml/jackson/core/JsonParser;Landroid/os/Bundle;)Ljava/util/ArrayList;

    move-result-object v1

    goto/16 :goto_0

    .line 254
    :sswitch_1
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseBlockedUsers(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/util/ArrayList;

    move-result-object v1

    goto/16 :goto_0

    .line 257
    :sswitch_2
    invoke-static {p0}, Lco/vine/android/api/VineParsers;->parseEditions(Lcom/fasterxml/jackson/core/JsonParser;)Ljava/lang/Object;

    move-result-object v1

    goto/16 :goto_0

    .line 267
    :pswitch_1a
    const-string v1, "data"

    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getCurrentName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 268
    packed-switch p1, :pswitch_data_2

    goto/16 :goto_2

    .line 270
    :pswitch_1b
    invoke-virtual {p0}, Lcom/fasterxml/jackson/core/JsonParser;->getIntValue()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto/16 :goto_0

    .line 279
    :cond_4
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unhandled parse type "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 167
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_19
        :pswitch_1a
    .end packed-switch

    .line 170
    :pswitch_data_1
    .packed-switch 0x2
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_5
        :pswitch_6
        :pswitch_8
        :pswitch_7
        :pswitch_9
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_4
        :pswitch_f
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_10
        :pswitch_11
        :pswitch_1
        :pswitch_1
        :pswitch_14
        :pswitch_13
        :pswitch_e
        :pswitch_12
        :pswitch_15
        :pswitch_16
        :pswitch_a
        :pswitch_17
        :pswitch_18
    .end packed-switch

    .line 249
    :sswitch_data_0
    .sparse-switch
        0x3 -> :sswitch_0
        0x11 -> :sswitch_1
        0x14 -> :sswitch_2
    .end sparse-switch

    .line 268
    :pswitch_data_2
    .packed-switch 0x15
        :pswitch_1b
    .end packed-switch
.end method
