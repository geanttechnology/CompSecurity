.class public Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private documentation:Ljava/lang/String;

.field private errorcode:Ljava/lang/Integer;

.field private message:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->message:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->message:Ljava/lang/String;

    .line 42
    iput-object p2, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->errorcode:Ljava/lang/Integer;

    .line 43
    return-void
.end method


# virtual methods
.method public getDocumentation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->documentation:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorcode()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->errorcode:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->message:Ljava/lang/String;

    return-object v0
.end method

.method public setDocumentation(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->documentation:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setErrorcode(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->errorcode:Ljava/lang/Integer;

    .line 67
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->message:Ljava/lang/String;

    .line 51
    return-void
.end method
