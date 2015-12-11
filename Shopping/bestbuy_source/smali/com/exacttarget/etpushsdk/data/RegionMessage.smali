.class public Lcom/exacttarget/etpushsdk/data/RegionMessage;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/Integer;

.field private b:Lcom/exacttarget/etpushsdk/data/Region;

.field private c:Lcom/exacttarget/etpushsdk/data/Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public constructor <init>(Lcom/exacttarget/etpushsdk/data/Region;Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->b:Lcom/exacttarget/etpushsdk/data/Region;

    .line 30
    iput-object p2, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->c:Lcom/exacttarget/etpushsdk/data/Message;

    .line 31
    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->a:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMessage()Lcom/exacttarget/etpushsdk/data/Message;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->c:Lcom/exacttarget/etpushsdk/data/Message;

    return-object v0
.end method

.method public getRegion()Lcom/exacttarget/etpushsdk/data/Region;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->b:Lcom/exacttarget/etpushsdk/data/Region;

    return-object v0
.end method

.method public setId(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->a:Ljava/lang/Integer;

    .line 39
    return-void
.end method

.method public setMessage(Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->c:Lcom/exacttarget/etpushsdk/data/Message;

    .line 55
    return-void
.end method

.method public setRegion(Lcom/exacttarget/etpushsdk/data/Region;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/data/RegionMessage;->b:Lcom/exacttarget/etpushsdk/data/Region;

    .line 47
    return-void
.end method
