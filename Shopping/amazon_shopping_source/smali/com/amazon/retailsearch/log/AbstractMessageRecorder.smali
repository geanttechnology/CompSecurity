.class public abstract Lcom/amazon/retailsearch/log/AbstractMessageRecorder;
.super Ljava/lang/Object;
.source "AbstractMessageRecorder.java"

# interfaces
.implements Lcom/amazon/retailsearch/log/MessageRecorder;


# instance fields
.field private final appLog:Lcom/amazon/retailsearch/log/AppLog;


# direct methods
.method protected constructor <init>(Lcom/amazon/retailsearch/log/AppLog;)V
    .locals 0
    .param p1, "appLog"    # Lcom/amazon/retailsearch/log/AppLog;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/retailsearch/log/AbstractMessageRecorder;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    .line 13
    return-void
.end method


# virtual methods
.method public getAppLog()Lcom/amazon/retailsearch/log/AppLog;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/retailsearch/log/AbstractMessageRecorder;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    return-object v0
.end method
