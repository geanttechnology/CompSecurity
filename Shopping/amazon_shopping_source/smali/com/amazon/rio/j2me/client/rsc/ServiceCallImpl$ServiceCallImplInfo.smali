.class Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;
.super Ljava/lang/Object;
.source "ServiceCallImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ServiceCallImplInfo"
.end annotation


# instance fields
.field private endTime:J

.field private errorString:Ljava/lang/String;

.field private method:Ljava/lang/String;

.field private startTime:J

.field private state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;


# direct methods
.method public constructor <init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)V
    .locals 2
    .param p1, "serviceCall"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    .prologue
    const-wide/16 v0, -0x1

    .line 325
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 319
    iput-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->startTime:J

    .line 320
    iput-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->endTime:J

    .line 321
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->method:Ljava/lang/String;

    .line 322
    sget-object v0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;->NOT_STARTED:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 323
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->errorString:Ljava/lang/String;

    .line 326
    if-eqz p1, :cond_0

    .line 327
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getStartTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->startTime:J

    .line 328
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getEndTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->endTime:J

    .line 329
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getMethod()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->method:Ljava/lang/String;

    .line 330
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    .line 332
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getError()Ljava/lang/Exception;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 333
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->getError()Ljava/lang/Exception;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->errorString:Ljava/lang/String;

    .line 336
    :cond_0
    return-void
.end method


# virtual methods
.method protected getEndTime()J
    .locals 2

    .prologue
    .line 343
    iget-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->endTime:J

    return-wide v0
.end method

.method protected getErrorString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->errorString:Ljava/lang/String;

    return-object v0
.end method

.method protected getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 347
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->method:Ljava/lang/String;

    return-object v0
.end method

.method protected getStartTime()J
    .locals 2

    .prologue
    .line 339
    iget-wide v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->startTime:J

    return-wide v0
.end method

.method protected getState()Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$ServiceCallImplInfo;->state:Lcom/amazon/rio/j2me/client/rsc/ServiceCallState;

    return-object v0
.end method
