.class public Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String; = "~!RAFInitCompletedEvent"

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private exception:Ljava/lang/Exception;

.field private readyAimFireReady:Z


# direct methods
.method public constructor <init>(Z)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-boolean p1, p0, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;->readyAimFireReady:Z

    .line 32
    return-void
.end method

.method public constructor <init>(ZLjava/lang/Exception;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-boolean p1, p0, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;->readyAimFireReady:Z

    .line 27
    iput-object p2, p0, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;->exception:Ljava/lang/Exception;

    .line 28
    return-void
.end method


# virtual methods
.method public getException()Ljava/lang/Exception;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;->exception:Ljava/lang/Exception;

    return-object v0
.end method

.method public isReadyAimFireReady()Z
    .locals 1

    .prologue
    .line 41
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;->readyAimFireReady:Z

    return v0
.end method
