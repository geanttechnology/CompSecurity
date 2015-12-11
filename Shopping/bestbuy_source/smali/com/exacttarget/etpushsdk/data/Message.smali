.class public Lcom/exacttarget/etpushsdk/data/Message;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final a:Ljava/lang/Integer;

.field public static final b:Ljava/lang/Integer;

.field public static final c:Ljava/lang/Integer;

.field public static final d:Ljava/lang/Integer;

.field public static final e:Ljava/lang/Integer;

.field public static final f:Ljava/lang/Integer;

.field public static final g:Ljava/lang/Integer;

.field public static final h:Ljava/lang/Integer;

.field public static final i:Ljava/lang/Integer;

.field public static final j:Ljava/lang/Integer;


# instance fields
.field private A:Ljava/util/Date;

.field private B:Ljava/util/Date;

.field private C:Ljava/lang/Integer;

.field private D:Ljava/lang/Integer;

.field private E:Ljava/lang/Integer;

.field private F:Ljava/util/ArrayList;

.field private G:Ljava/lang/String;

.field private H:Ljava/lang/String;

.field private I:Ljava/lang/Boolean;

.field private J:Ljava/lang/String;

.field private K:Ljava/lang/String;

.field private L:Ljava/lang/String;

.field private M:Ljava/lang/String;

.field private N:Ljava/lang/Boolean;

.field private O:Ljava/lang/Boolean;

.field private P:Ljava/lang/Boolean;

.field private Q:Ljava/lang/Integer;

.field private R:Ljava/lang/Integer;

.field private S:Ljava/lang/Long;

.field private k:Ljava/lang/Integer;

.field private l:I

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Ljava/util/Date;

.field private t:Ljava/util/Date;

.field private u:Ljava/lang/Integer;

.field private v:Ljava/lang/Integer;

.field private w:Ljava/lang/Integer;

.field private x:Ljava/lang/Integer;

.field private y:Ljava/lang/Boolean;

.field private z:Ljava/lang/Integer;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 29
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->a:Ljava/lang/Integer;

    .line 30
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->b:Ljava/lang/Integer;

    .line 31
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->c:Ljava/lang/Integer;

    .line 32
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->d:Ljava/lang/Integer;

    .line 33
    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->e:Ljava/lang/Integer;

    .line 34
    const/4 v0, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->f:Ljava/lang/Integer;

    .line 35
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->g:Ljava/lang/Integer;

    .line 36
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->h:Ljava/lang/Integer;

    .line 37
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->i:Ljava/lang/Integer;

    .line 38
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/data/Message;->j:Ljava/lang/Integer;

    return-void
.end method

.method public constructor <init>()V
    .locals 8

    .prologue
    const-wide/16 v6, 0x3e8

    const/4 v5, -0x1

    const/4 v4, 0x0

    const/4 v1, 0x0

    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->k:Ljava/lang/Integer;

    .line 54
    const/4 v0, 0x2

    iput v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->l:I

    .line 60
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->m:Ljava/lang/String;

    .line 61
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->n:Ljava/lang/String;

    .line 62
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->o:Ljava/lang/String;

    .line 63
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->p:Ljava/lang/String;

    .line 64
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->q:Ljava/lang/String;

    .line 65
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->r:Ljava/lang/String;

    .line 66
    new-instance v0, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long/2addr v2, v6

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->s:Ljava/util/Date;

    .line 67
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->t:Ljava/util/Date;

    .line 68
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->u:Ljava/lang/Integer;

    .line 69
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->v:Ljava/lang/Integer;

    .line 70
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->w:Ljava/lang/Integer;

    .line 71
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->x:Ljava/lang/Integer;

    .line 72
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->y:Ljava/lang/Boolean;

    .line 73
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->z:Ljava/lang/Integer;

    .line 74
    new-instance v0, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long/2addr v2, v6

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->A:Ljava/util/Date;

    .line 75
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->B:Ljava/util/Date;

    .line 76
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->C:Ljava/lang/Integer;

    .line 77
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->D:Ljava/lang/Integer;

    .line 78
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->E:Ljava/lang/Integer;

    .line 79
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->F:Ljava/util/ArrayList;

    .line 81
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->H:Ljava/lang/String;

    .line 82
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->I:Ljava/lang/Boolean;

    .line 87
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->N:Ljava/lang/Boolean;

    .line 88
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->O:Ljava/lang/Boolean;

    .line 89
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->P:Ljava/lang/Boolean;

    .line 91
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->R:Ljava/lang/Integer;

    .line 92
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->S:Ljava/lang/Long;

    .line 95
    return-void
.end method

.method public constructor <init>(Lorg/json/JSONObject;)V
    .locals 8

    .prologue
    const-wide/16 v6, 0x3e8

    const/4 v5, -0x1

    const/4 v0, 0x0

    const/4 v4, 0x0

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->k:Ljava/lang/Integer;

    .line 54
    const/4 v1, 0x2

    iput v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->l:I

    .line 60
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->m:Ljava/lang/String;

    .line 61
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->n:Ljava/lang/String;

    .line 62
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->o:Ljava/lang/String;

    .line 63
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->p:Ljava/lang/String;

    .line 64
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->q:Ljava/lang/String;

    .line 65
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->r:Ljava/lang/String;

    .line 66
    new-instance v1, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long/2addr v2, v6

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->s:Ljava/util/Date;

    .line 67
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->t:Ljava/util/Date;

    .line 68
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->u:Ljava/lang/Integer;

    .line 69
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->v:Ljava/lang/Integer;

    .line 70
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->w:Ljava/lang/Integer;

    .line 71
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->x:Ljava/lang/Integer;

    .line 72
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->y:Ljava/lang/Boolean;

    .line 73
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->z:Ljava/lang/Integer;

    .line 74
    new-instance v1, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long/2addr v2, v6

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->A:Ljava/util/Date;

    .line 75
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->B:Ljava/util/Date;

    .line 76
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->C:Ljava/lang/Integer;

    .line 77
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->D:Ljava/lang/Integer;

    .line 78
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->E:Ljava/lang/Integer;

    .line 79
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->F:Ljava/util/ArrayList;

    .line 81
    iput-object v4, p0, Lcom/exacttarget/etpushsdk/data/Message;->H:Ljava/lang/String;

    .line 82
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->I:Ljava/lang/Boolean;

    .line 87
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->N:Ljava/lang/Boolean;

    .line 88
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->O:Ljava/lang/Boolean;

    .line 89
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->P:Ljava/lang/Boolean;

    .line 91
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->R:Ljava/lang/Integer;

    .line 92
    const-wide/16 v2, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/Message;->S:Ljava/lang/Long;

    .line 98
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"

    sget-object v3, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v1, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 100
    const-string v2, "id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 101
    const-string v2, "id"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setId(Ljava/lang/String;)V

    .line 103
    :cond_0
    const-string v2, "alert"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 104
    const-string v2, "alert"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setAlert(Ljava/lang/String;)V

    .line 106
    :cond_1
    const-string v2, "sound"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 107
    const-string v2, "sound"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setSound(Ljava/lang/String;)V

    .line 109
    :cond_2
    const-string v2, "badge"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 110
    const-string v2, "badge"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setBadge(Ljava/lang/String;)V

    .line 112
    :cond_3
    const-string v2, "startDateUtc"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 113
    const-string v2, "startDateUtc"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setStartDate(Ljava/util/Date;)V

    .line 115
    :cond_4
    const-string v2, "endDateUtc"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 116
    const-string v2, "endDateUtc"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setEndDate(Ljava/util/Date;)V

    .line 118
    :cond_5
    const-string v1, "messageType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 119
    const-string v1, "messageType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageType(Ljava/lang/Integer;)V

    .line 121
    :cond_6
    const-string v1, "contentType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 122
    const-string v1, "contentType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setContentType(Ljava/lang/Integer;)V

    .line 124
    :cond_7
    const-string v1, "subject"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 125
    const-string v1, "subject"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setSubject(Ljava/lang/String;)V

    .line 127
    :cond_8
    const-string v1, "url"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 128
    const-string v1, "url"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setUrl(Ljava/lang/String;)V

    .line 130
    :cond_9
    const-string v1, "pageId"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 131
    const-string v1, "pageId"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setPageId(Ljava/lang/String;)V

    .line 133
    :cond_a
    const-string v1, "messageType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 134
    const-string v1, "messageType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageType(Ljava/lang/Integer;)V

    .line 136
    :cond_b
    const-string v1, "contentType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 137
    const-string v1, "contentType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setContentType(Ljava/lang/Integer;)V

    .line 139
    :cond_c
    const-string v1, "messageObjectPerPeriod"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 140
    const-string v1, "messageObjectPerPeriod"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setMessagesPerPeriod(Ljava/lang/Integer;)V

    .line 142
    :cond_d
    const-string v1, "numberOfPeriods"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 143
    const-string v1, "numberOfPeriods"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setNumberOfPeriods(Ljava/lang/Integer;)V

    .line 145
    :cond_e
    const-string v1, "periodType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 146
    const-string v1, "periodType"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodType(Ljava/lang/Integer;)V

    .line 148
    :cond_f
    const-string v1, "isRollingPeriod"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 149
    const-string v1, "isRollingPeriod"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setIsRollingPeriod(Ljava/lang/Boolean;)V

    .line 151
    :cond_10
    const-string v1, "messageLimit"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 152
    const-string v1, "messageLimit"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageLimit(Ljava/lang/Integer;)V

    .line 154
    :cond_11
    const-string v1, "keys"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_13

    .line 155
    const-string v1, "keys"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 156
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 158
    :goto_0
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v0, v3, :cond_12

    .line 159
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 160
    new-instance v4, Lcom/exacttarget/etpushsdk/data/Attribute;

    invoke-direct {v4}, Lcom/exacttarget/etpushsdk/data/Attribute;-><init>()V

    .line 161
    const-string v5, "key"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/exacttarget/etpushsdk/data/Attribute;->setKey(Ljava/lang/String;)V

    .line 162
    const-string v5, "value"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Lcom/exacttarget/etpushsdk/data/Attribute;->setValue(Ljava/lang/String;)V

    .line 163
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 158
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 165
    :cond_12
    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/data/Message;->setKeys(Ljava/util/ArrayList;)V

    .line 167
    :cond_13
    return-void
.end method


# virtual methods
.method public getAlert()Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->n:Ljava/lang/String;

    return-object v0
.end method

.method public getBadge()Ljava/lang/String;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->p:Ljava/lang/String;

    return-object v0
.end method

.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->r:Ljava/lang/String;

    return-object v0
.end method

.method public getContentType()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->v:Ljava/lang/Integer;

    return-object v0
.end method

.method public getCustom()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->H:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->G:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->H:Ljava/lang/String;

    goto :goto_0
.end method

.method public getCustomObj()Ljava/lang/String;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->H:Ljava/lang/String;

    return-object v0
.end method

.method public getEndDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->t:Ljava/util/Date;

    return-object v0
.end method

.method public getEntryTime()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 447
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->S:Ljava/lang/Long;

    return-object v0
.end method

.method public getEphemeralMessage()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 415
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->O:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getHasEntered()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 423
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->P:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->m:Ljava/lang/String;

    return-object v0
.end method

.method public getIsRollingPeriod()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->y:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getKeys()Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->F:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getLastShownDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->B:Ljava/util/Date;

    return-object v0
.end method

.method public getLoiterSeconds()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 439
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->R:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMessageDeleted()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->N:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMessageLimit()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->z:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMessageType()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->u:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMessagesPerPeriod()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->w:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMinTripped()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->E:Ljava/lang/Integer;

    return-object v0
.end method

.method public getNextAllowedShow()Ljava/util/Date;
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->A:Ljava/util/Date;

    return-object v0
.end method

.method public getNotifyId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 431
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->Q:Ljava/lang/Integer;

    return-object v0
.end method

.method public getNumberOfPeriods()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->x:Ljava/lang/Integer;

    return-object v0
.end method

.method public getOpenDirect()Ljava/lang/String;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->q:Ljava/lang/String;

    return-object v0
.end method

.method public getPageId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 383
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->M:Ljava/lang/String;

    return-object v0
.end method

.method public getPeriodShowCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 314
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->D:Ljava/lang/Integer;

    return-object v0
.end method

.method public getPeriodType()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->k:Ljava/lang/Integer;

    return-object v0
.end method

.method public getProximity()I
    .locals 1

    .prologue
    .line 407
    iget v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->l:I

    return v0
.end method

.method public getRead()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 346
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->I:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getShowCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 306
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->C:Ljava/lang/Integer;

    return-object v0
.end method

.method public getSiteId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 354
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->J:Ljava/lang/String;

    return-object v0
.end method

.method public getSound()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->o:Ljava/lang/String;

    return-object v0
.end method

.method public getStartDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->s:Ljava/util/Date;

    return-object v0
.end method

.method public getSubject()Ljava/lang/String;
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->K:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->n:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 363
    const-string v0, "A new message"

    .line 367
    :goto_0
    return-object v0

    .line 364
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->K:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 365
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->n:Ljava/lang/String;

    goto :goto_0

    .line 367
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->K:Ljava/lang/String;

    goto :goto_0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/Message;->L:Ljava/lang/String;

    return-object v0
.end method

.method public setAlert(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->n:Ljava/lang/String;

    .line 183
    return-void
.end method

.method public setBadge(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 198
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->p:Ljava/lang/String;

    .line 199
    return-void
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 214
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->r:Ljava/lang/String;

    .line 215
    return-void
.end method

.method public setContentType(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 342
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->v:Ljava/lang/Integer;

    .line 343
    return-void
.end method

.method public setCustom(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 326
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->G:Ljava/lang/String;

    .line 327
    return-void
.end method

.method public setCustomObj(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->H:Ljava/lang/String;

    .line 335
    return-void
.end method

.method public setEndDate(Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 230
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->t:Ljava/util/Date;

    .line 231
    return-void
.end method

.method public setEntryTime(Ljava/lang/Long;)V
    .locals 0

    .prologue
    .line 451
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->S:Ljava/lang/Long;

    .line 452
    return-void
.end method

.method public setEphemeralMessage(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 419
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->O:Ljava/lang/Boolean;

    .line 420
    return-void
.end method

.method public setHasEntered(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 427
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->P:Ljava/lang/Boolean;

    .line 428
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->m:Ljava/lang/String;

    .line 175
    return-void
.end method

.method public setIsRollingPeriod(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 270
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->y:Ljava/lang/Boolean;

    .line 271
    return-void
.end method

.method public setKeys(Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 286
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->F:Ljava/util/ArrayList;

    .line 287
    return-void
.end method

.method public setLastShownDate(Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 302
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->B:Ljava/util/Date;

    .line 303
    return-void
.end method

.method public setLoiterSeconds(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 443
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->R:Ljava/lang/Integer;

    .line 444
    return-void
.end method

.method public setMessageDeleted(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 395
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->N:Ljava/lang/Boolean;

    .line 396
    return-void
.end method

.method public setMessageLimit(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 278
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->z:Ljava/lang/Integer;

    .line 279
    return-void
.end method

.method public setMessageType(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->u:Ljava/lang/Integer;

    .line 239
    return-void
.end method

.method public setMessagesPerPeriod(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->w:Ljava/lang/Integer;

    .line 247
    return-void
.end method

.method public setMinTripped(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 403
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->E:Ljava/lang/Integer;

    .line 404
    return-void
.end method

.method public setNextAllowedShow(Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 294
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->A:Ljava/util/Date;

    .line 295
    return-void
.end method

.method public setNotifyId(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 435
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->Q:Ljava/lang/Integer;

    .line 436
    return-void
.end method

.method public setNumberOfPeriods(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 254
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->x:Ljava/lang/Integer;

    .line 255
    return-void
.end method

.method public setOpenDirect(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 206
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->q:Ljava/lang/String;

    .line 207
    return-void
.end method

.method public setPageId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 387
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->M:Ljava/lang/String;

    .line 388
    return-void
.end method

.method public setPeriodShowCount(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 318
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->D:Ljava/lang/Integer;

    .line 319
    return-void
.end method

.method public setPeriodType(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 262
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->k:Ljava/lang/Integer;

    .line 263
    return-void
.end method

.method public setProximity(I)V
    .locals 0

    .prologue
    .line 411
    iput p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->l:I

    .line 412
    return-void
.end method

.method public setRead(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 350
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->I:Ljava/lang/Boolean;

    .line 351
    return-void
.end method

.method public setShowCount(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 310
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->C:Ljava/lang/Integer;

    .line 311
    return-void
.end method

.method public setSiteId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 358
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->J:Ljava/lang/String;

    .line 359
    return-void
.end method

.method public setSound(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->o:Ljava/lang/String;

    .line 191
    return-void
.end method

.method public setStartDate(Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->s:Ljava/util/Date;

    .line 223
    return-void
.end method

.method public setSubject(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 371
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->K:Ljava/lang/String;

    .line 372
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 379
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/Message;->L:Ljava/lang/String;

    .line 380
    return-void
.end method
