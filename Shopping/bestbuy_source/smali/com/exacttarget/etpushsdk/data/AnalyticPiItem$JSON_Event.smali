.class Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/util/Date;

.field public c:Ljava/lang/String;

.field public d:Ljava/lang/Boolean;

.field final synthetic e:Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;


# direct methods
.method private constructor <init>(Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 288
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->e:Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 289
    const-string v0, ""

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->a:Ljava/lang/String;

    .line 290
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->b:Ljava/util/Date;

    .line 291
    const-string v0, ""

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->c:Ljava/lang/String;

    .line 292
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;->d:Ljava/lang/Boolean;

    return-void
.end method

.method synthetic constructor <init>(Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$1;)V
    .locals 0

    .prologue
    .line 288
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem$JSON_Event;-><init>(Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;)V

    return-void
.end method
